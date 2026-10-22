package com.volcengine.zeus.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import dqc.d;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ContentProviderManager {
    public static final String LIVE_META_PROVIDER_PATHS = "android-support-FILE_PROVIDER_PATHS";
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<String, String> mAuthorityProcessNameMap;
    private final Map<b, a> mContentProviderMap;
    private final Map<String, c> mSystemProviderInfoMap;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PluginContentProvider f462824a;

        public a(PluginContentProvider r100) {
            this.f462824a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f462825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f462826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f462827c;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f462825a, this.f462826b, this.f462827c});
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (TextUtils.equals(this.f462827c, r101.f462827c) == true) goto L7;
            return false;
        L7:
            if (TextUtils.equals(this.f462826b, r101.f462826b) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(this.f462825a, r101.f462825a) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public b(String r100, String r101, String r102) {
            this.f462825a = r101;
            this.f462826b = r102;
            this.f462827c = r100;
        }
    }

    public static final class c extends b {
        public c(String r100, String r101, ProviderInfo r102) {
            super(r100, r101, r102.authority);
        }
    }

    public static ContentProviderManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ContentProviderManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ContentProviderManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ContentProviderManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void initSystemContentProviderInfo() {
        ProviderInfo[] r100 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;     // Catch: Throwable -> L23
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length == 0) goto L38;
        int r101 = r100.length;     // Catch: Throwable -> L23
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L39;
        ProviderInfo r103 = r100[r102];     // Catch: Throwable -> L23
        if (r103 == null) goto L22;
        String r104 = r103.authority;     // Catch: Throwable -> L23
        if (r104 == null) goto L22;
        if (r104.contains(".zeus.provider.proxy.") == false) goto L22;
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + r103.packageName + "],[processName=" + r103.processName + "],[authority:" + r103.authority + "]");     // Catch: Exception -> L20 Throwable -> L23
        if (r103.authority.contains(Zeus.getAppApplication().getPackageName() + ".zeus.provider.proxy.") == false) goto L22;
        String r105 = d.b(r103.processName);     // Catch: Exception -> L20 Throwable -> L23
        this.mSystemProviderInfoMap.put(r105, new c(Zeus.getAppApplication().getPackageName(), r105, r103));     // Catch: Exception -> L20 Throwable -> L23
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + r103.packageName + "],[processName=" + r103.processName + "],[authority:" + r103.authority + "]");     // Catch: Exception -> L20 Throwable -> L23
    L20:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + r103.authority + "],exception：", e);     // Catch: Throwable -> L23
    L22:
        r102 = r102 + 1;
        goto L8
    L39:
        return;
    L38:
        return;
    L23:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
    }

    private ContentProviderManager() {
        this.mContentProviderMap = new HashMap();
        this.mAuthorityProcessNameMap = new HashMap();
        this.mSystemProviderInfoMap = new HashMap();
    }

    public Map<String, c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    private boolean hasFileProviderPath(ProviderInfo r100) {
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "providerInfo metaData:" + r100.metaData);
        Bundle r101 = r100.metaData;
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (r101.getInt("android.support.FILE_PROVIDER_PATHS") == 0) goto L7;
    L8:
        return true;
    L7:
        if (r100.metaData.getInt(LIVE_META_PROVIDER_PATHS.replace("-", ".")) == 0) goto L9;
        goto L8
    }

    public String getPluginProcessNameByAuthority(String r100) {
        return this.mAuthorityProcessNameMap.get(r100);
    }

    public PluginContentProvider getPluginProvider(b r100) {
        a r101 = this.mContentProviderMap.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f462824a;
    }

    public boolean isPluginProvider(Uri r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        String r101 = r100.getAuthority();
        Set<String> r102 = this.mAuthorityProcessNameMap.keySet();
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.contains(r101) == false) goto L10;
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_provider_ContentProviderManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private PluginContentProvider instantiateProvider(Plugin r100, ProviderInfo r101) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object r102 = INVOKEVIRTUAL_com_volcengine_zeus_provider_ContentProviderManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.mClassLoader, r101.name).newInstance();
        StringBuilder r103 = new StringBuilder("isProvider:");
        boolean r104 = r102 instanceof FileProvider;
        r103.append(r104);
        r103.append(", hasPath:");
        r103.append(hasFileProviderPath(r101));
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, r103.toString());
        if (r104 == false) goto L5;
    L9:
        Bundle r105 = r101.metaData;
        if (r105 == null) goto L24;
        int r106 = r105.getInt("android.support.FILE_PROVIDER_PATHS");
        if (r106 != 0) goto L14;
        r106 = r101.metaData.getInt(LIVE_META_PROVIDER_PATHS.replace("-", "."));
    L14:
        XmlResourceParser r107 = r100.mResources.getXml(r106);
        String[] r108 = com.volcengine.zeus.FileProvider.f462625a;
        com.volcengine.zeus.FileProvider.a(r100.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), r100.mPkgName), com.volcengine.zeus.FileProvider.f462627c, r107);     // Catch: Throwable -> L17 IOException -> L19
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L24:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:" + r102);
    L5:
        if (hasFileProviderPath(r101) == true) goto L9;
        return (PluginContentProvider) r102;
    }

    public void installContentProviders(Collection<ProviderInfo> r100, Plugin r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L18;
        if (r101 == null) goto L19;
        Zeus.getAppApplication();
        String r102 = d.b(d.c());
        Iterator<ProviderInfo> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L20;
        ProviderInfo r104 = r103.next();
        if (ZeusLogger.isDebug() == false) goto L13;
        StringBuilder r105 = new StringBuilder(128);
        r105.append("Install plugin provider [authority:");
        r105.append(r104.authority);
        r105.append("] - [className:");
        r105.append(r104.name);
        r105.append("]");
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, r105.toString());
    L13:
        installProvider(r102, r104, r101);
        goto L9
    L20:
        return;
    L19:
        return;
    }

    private void installProvider(String r100, ProviderInfo r101, Plugin r102) {
        if (r101 != null) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + r102.mPkgName + "】");
        return;
    L7:
        if (TextUtils.equals(r100, r101.processName) == false) goto L17;
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + r101.authority + "] [className:" + r101.name + "]");
        PluginContentProvider r103 = instantiateProvider(r102, r101);     // Catch: Exception -> L14
        if (r103 != null) goto L12;
        return;
    L12:
        r103.attachInfo(ZeusTransformUtils.wrapperContext(r102.mHostApplication, r102.mPkgName), r101);     // Catch: Exception -> L14
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + r101.name + "]");     // Catch: Exception -> L14
        this.mContentProviderMap.put(new b(r101.packageName, r101.processName, r101.authority), new a(r103));
    L14:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
        return;
    L17:
        this.mAuthorityProcessNameMap.put(r101.authority, r101.processName);
    }

    public String getType(ContentResolver r100, Uri r101, String r102) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102);
    }

    public int delete(ContentResolver r100, Uri r101, Bundle r102, String r103) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103);
    }

    public Uri insert(ContentResolver r100, Uri r101, ContentValues r102, String r103) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103);
    }

    public int delete(ContentResolver r100, Uri r101, String r102, String[] r103, String r104) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104);
    }

    public Uri insert(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, String r104) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104);
    }

    public int update(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, String r104) {
        return com.volcengine.zeus.provider.a.b(r100, r101, r102, r103, r104);
    }

    public Bundle call(ContentResolver r100, Uri r101, String r102, String r103, Bundle r104, String r105) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105);
    }

    public Cursor query(ContentResolver r100, Uri r101, String[] r102, Bundle r103, CancellationSignal r104, String r105) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105);
    }

    public int update(ContentResolver r100, Uri r101, ContentValues r102, String r103, String[] r104, String r105) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105);
    }

    public final Bundle call(ContentResolver r100, String r101, String r102, String r103, Bundle r104, String r105) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105);
    }

    public Cursor query(ContentResolver r100, Uri r101, String[] r102, String r103, String[] r104, String r105, String r106) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105, r106);
    }

    public Cursor query(ContentResolver r100, Uri r101, String[] r102, String r103, String[] r104, String r105, CancellationSignal r106, String r107) {
        return com.volcengine.zeus.provider.a.a(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
