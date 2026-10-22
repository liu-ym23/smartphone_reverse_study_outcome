package com.volcengine.zeus.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProxyProvider extends ContentProviderProxy {
    private static final long WAIT_TIMEOUT_MS = 3000;
    private volatile String authority;

    public abstract String getPluginName();

    private void logAwaitLoadFailed() {
        if (GlobalParam.getInstance().isDebug() == true) goto L5;
        return;
    L5:
        int r100 = Binder.getCallingUid();
        String r101 = getCallingPackage();
        if (r101 == null) goto L8;
    L14:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "logAwaitLoadFailed, callingUid=" + r100 + ", callingPackage=" + r101);
        return;
    L8:
        if (getContext() == null) goto L14;
        String[] r102 = getContext().getPackageManager().getPackagesForUid(r100);
        if (r102 == null) goto L14;
        if (r102.length <= 0) goto L14;
        r101 = r102[0];
        goto L14
    }

    public BaseProxyProvider() {
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public String getType(Uri r100) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.getType(buildProxyUri(r100, getPluginName()));
    }

    private Uri buildProxyUri(Uri r100, String r101) {
        return a.a(r100, r101);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r100, ProviderInfo r101) {
        super.attachInfo(r100, r101);
        if (r101 == null) goto L11;
        String r102 = r101.authority;
        if (r102 == null) goto L10;
        int r103 = r102.indexOf(59);
        if (r103 < 0) goto L9;
        r102 = r102.substring(0, r103);
    L9:
        this.authority = r102;
        return;
    L10:
        this.authority = null;
        return;
    L11:
        this.authority = null;
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int delete(Uri r100, Bundle r101) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.delete(buildProxyUri(r100, getPluginName()), r101);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.insert(buildProxyUri(r100, getPluginName()), r101);
    }

    private Uri buildProxyUri(String r100, Uri r101, String r102) {
        return a.a(r100, r101, r102);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L5;
        logAwaitLoadFailed();
    L5:
        if (r102 != null) goto L7;
        r102 = new Bundle();
    L7:
        r102.putString("provider_params", this.authority);
        r102.putString(ContentProviderManager.PROVIDER_PROXY_URI, buildProxyUri(getPluginName(), null, this.authority).toString());
        return super.call(r100, r101, r102);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.delete(buildProxyUri(r100, getPluginName()), r101, r102);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101, Bundle r102) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.insert(buildProxyUri(r100, getPluginName()), r101, r102);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, Bundle r102) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.update(buildProxyUri(r100, getPluginName()), r101, r102);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L5;
        logAwaitLoadFailed();
    L5:
        if (r103 != null) goto L7;
        r103 = new Bundle();
    L7:
        r103.putString("provider_params", this.authority);
        r103.putString(ContentProviderManager.PROVIDER_PROXY_URI, buildProxyUri(getPluginName(), null, this.authority).toString());
        return super.call(r100, r101, r102, r103);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, Bundle r102, CancellationSignal r103) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r100, getPluginName()), r101, r102, r103);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.update(buildProxyUri(r100, getPluginName()), r101, r102, r103);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r110, String[] r111, String r112) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r100, getPluginName()), r101, r110, r111, r112);
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Cursor query(Uri r100, String[] r110, String r111, String[] r112, String r113, CancellationSignal r114) {
        if (Zeus.loadOrAwaitLoad(getPluginName(), 3000) == true) goto L6;
        logAwaitLoadFailed();
    L6:
        return super.query(buildProxyUri(r100, getPluginName()), r110, r111, r112, r113, r114);
    }
}
