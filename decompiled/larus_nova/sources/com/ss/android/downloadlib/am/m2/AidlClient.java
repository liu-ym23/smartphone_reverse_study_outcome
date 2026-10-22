package com.ss.android.downloadlib.am.m2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AidlClient {
    private static String ACTION = "";
    private static String MARKET = "";
    private static String PACKAGE = "";
    private static volatile AidlClient mInstance;
    private boolean bSupportAidl;
    private boolean bindWaivePriority;
    private volatile boolean bindingService;
    private Context mContext;
    private final List<Pair<AidlMsg, ICallback>> mRequestCache;
    public IAidlService mServerClient;
    public final List<OnServiceConnectedChangeListener> mServiceConnectedChangeListeners;
    private final ServiceConnection mServiceConnection;
    private String mSourceInfo;
    public final Object syncObject;

    public interface OnServiceConnectedChangeListener {
        void onConnected();

        void onDisConnected();
    }

    public static AidlClient getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(AidlClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new AidlClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AidlClient.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void doCachedRequest() {
        Iterator<Pair<AidlMsg, ICallback>> r100 = this.mRequestCache.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Pair<AidlMsg, ICallback> r101 = r100.next();
        this.mServerClient.doAction((AidlMsg) r101.first, (ICallback) r101.second);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        this.mRequestCache.clear();
    }

    public void onDestroy() {
        if (this.mServerClient == null) goto L5;
        this.mContext.unbindService(this.mServiceConnection);
        this.mServerClient = null;
    L5:
        this.mServiceConnectedChangeListeners.clear();
        this.mRequestCache.clear();
    }

    private AidlClient() {
        this.bSupportAidl = true;
        this.bindWaivePriority = false;
        this.bindingService = false;
        this.mRequestCache = new ArrayList();
        this.mServiceConnectedChangeListeners = new ArrayList();
        this.mServiceConnection = new AnonymousClass1(this);
        this.mSourceInfo = "";
        this.syncObject = new Object();
    }

    public boolean isBindingService() {
        return this.bindingService;
    }

    public Intent getExplicitIntent(Context r100) {
        Intent r101 = new Intent();
        r101.setAction(ACTION);
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentServices(r101, 0);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.size() != 1) goto L18;
        Iterator<ResolveInfo> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        ServiceInfo r104 = r103.next().serviceInfo;
        String r105 = r104.packageName;
        String r106 = r104.name;
        if (MARKET.equals(r105) == false) goto L9;
        ComponentName r107 = new ComponentName(r105, r106);
        Intent r108 = new Intent(r101);
        r108.setComponent(r107);
        return r108;
    L19:
        return null;
    L18:
        return null;
    }

    public void setBindingService(boolean r100) {
        this.bindingService = r100;
    }

    public void doAction(AidlMsg r100, ICallback r101) {
        Object r102 = this.syncObject;
        monitor-enter(r102);
        r100.sourceApk = PACKAGE;     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r100.sourceApkInfo) == false) goto L7;
        r100.sourceApkInfo = this.mSourceInfo;     // Catch: Throwable -> L20
    L7:
        IAidlService r103 = this.mServerClient;     // Catch: Throwable -> L20
        if (r103 == null) goto L14;
        r103.doAction(r100, r101);     // Catch: RemoteException -> L11 Throwable -> L20
    L18:
        monitor-exit(r102);     // Catch: Throwable -> L20
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L18
    L14:
        if (isBindingService() == false) goto L16;
    L17:
        this.mRequestCache.add(Pair.create(r100, r101));     // Catch: Throwable -> L20
        goto L18
    L16:
        if (init(this.mContext, this.bindWaivePriority) == false) goto L18;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean init(Context r100, boolean r101) {
        if (TextUtils.isEmpty(ACTION) == false) goto L12;
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r102 == null) goto L7;
        JSONObject r103 = r102.getTTDownloaderAdSettings();
    L8:
        if (r103 == null) goto L10;
        String r104 = r103.optString("s");
    L11:
        ACTION = DecryptUtils.decrypt(r103.optString("q"), r104);
        MARKET = DecryptUtils.decrypt(r103.optString("u"), r104);
        PACKAGE = DecryptUtils.decrypt(r103.optString("w"), r104);
        goto L12
    L10:
        r104 = "";
        goto L11
    L7:
        r103 = null;
    L12:
        this.bindWaivePriority = r101;
        if (r100 == null) goto L27;
        Context r105 = r100.getApplicationContext();
        this.mContext = r105;
        if (r105 != null) goto L18;
        return true;
    L18:
        if (TextUtils.isEmpty(PACKAGE) == false) goto L21;
        PACKAGE = this.mContext.getPackageName();
    L21:
        if (this.mServerClient != null) goto L27;
        if (isBindingService() == true) goto L27;
        Intent r106 = getExplicitIntent(r100);
        return this.mContext.bindService(r106, this.mServiceConnection, 33);
    L27:
        return true;
    }
}
