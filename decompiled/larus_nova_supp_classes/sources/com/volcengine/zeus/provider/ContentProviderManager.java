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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        public final PluginContentProvider a;

        public a(PluginContentProvider r1) {
            this.a = r1;
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b, this.c});
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof b) == false) goto L12;
            b r5 = (b) r4;
            if (TextUtils.equals(this.c, r5.c) == true) goto L7;
            return false;
        L7:
            if (TextUtils.equals(this.b, r5.b) == true) goto L9;
            return false;
        L9:
            if (TextUtils.equals(this.a, r5.a) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public b(String r1, String r2, String r3) {
            this.a = r2;
            this.b = r3;
            this.c = r1;
        }
    }

    public static final class c extends b {
        public c(String r1, String r2, ProviderInfo r3) {
            super(r1, r2, r3.authority);
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
        ProviderInfo[] r5 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;     // Catch: Throwable -> L23
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length == 0) goto L38;
        int r6 = r5.length;     // Catch: Throwable -> L23
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L39;
        ProviderInfo r8 = r5[r7];     // Catch: Throwable -> L23
        if (r8 == null) goto L22;
        String r9 = r8.authority;     // Catch: Throwable -> L23
        if (r9 == null) goto L22;
        if (r9.contains(".zeus.provider.proxy.") == false) goto L22;
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + r8.packageName + "],[processName=" + r8.processName + "],[authority:" + r8.authority + "]");     // Catch: Exception -> L20 Throwable -> L23
        if (r8.authority.contains(Zeus.getAppApplication().getPackageName() + ".zeus.provider.proxy.") == false) goto L22;
        String r10 = d.b(r8.processName);     // Catch: Exception -> L20 Throwable -> L23
        this.mSystemProviderInfoMap.put(r10, new c(Zeus.getAppApplication().getPackageName(), r10, r8));     // Catch: Exception -> L20 Throwable -> L23
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + r8.packageName + "],[processName=" + r8.processName + "],[authority:" + r8.authority + "]");     // Catch: Exception -> L20 Throwable -> L23
    L20:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + r8.authority + "],exception：", e);     // Catch: Throwable -> L23
    L22:
        r7 = r7 + 1;
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

    private boolean hasFileProviderPath(ProviderInfo r4) {
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, "providerInfo metaData:" + r4.metaData);
        Bundle r0 = r4.metaData;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getInt("android.support.FILE_PROVIDER_PATHS") == 0) goto L7;
    L8:
        return true;
    L7:
        if (r4.metaData.getInt(LIVE_META_PROVIDER_PATHS.replace("-", ".")) == 0) goto L9;
        goto L8
    }

    public String getPluginProcessNameByAuthority(String r2) {
        return this.mAuthorityProcessNameMap.get(r2);
    }

    public PluginContentProvider getPluginProvider(b r2) {
        a r3 = this.mContentProviderMap.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    public boolean isPluginProvider(Uri r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        String r4 = r3.getAuthority();
        Set<String> r1 = this.mAuthorityProcessNameMap.keySet();
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.contains(r4) == false) goto L10;
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_provider_ContentProviderManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    private PluginContentProvider instantiateProvider(Plugin r5, ProviderInfo r6) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Object r0 = INVOKEVIRTUAL_com_volcengine_zeus_provider_ContentProviderManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r5.mClassLoader, r6.name).newInstance();
        StringBuilder r1 = new StringBuilder("isProvider:");
        boolean r2 = r0 instanceof FileProvider;
        r1.append(r2);
        r1.append(", hasPath:");
        r1.append(hasFileProviderPath(r6));
        ZeusLogger.i(ZeusLogger.TAG_PROVIDER, r1.toString());
        if (r2 == false) goto L5;
    L9:
        Bundle r3 = r6.metaData;
        if (r3 == null) goto L24;
        int r4 = r3.getInt("android.support.FILE_PROVIDER_PATHS");
        if (r4 != 0) goto L14;
        r4 = r6.metaData.getInt(LIVE_META_PROVIDER_PATHS.replace("-", "."));
    L14:
        XmlResourceParser r7 = r5.mResources.getXml(r4);
        String[] r8 = com.volcengine.zeus.FileProvider.a;
        com.volcengine.zeus.FileProvider.a(r5.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), r5.mPkgName), com.volcengine.zeus.FileProvider.c, r7);     // Catch: Throwable -> L17 IOException -> L19
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L24:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:" + r0);
    L5:
        if (hasFileProviderPath(r6) == true) goto L9;
        return (PluginContentProvider) r0;
    }

    public void installContentProviders(Collection<ProviderInfo> r5, Plugin r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.size() == 0) goto L18;
        if (r6 == null) goto L19;
        Zeus.getAppApplication();
        String r0 = d.b(d.c());
        Iterator<ProviderInfo> r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L20;
        ProviderInfo r1 = r7.next();
        if (ZeusLogger.isDebug() == false) goto L13;
        StringBuilder r2 = new StringBuilder(128);
        r2.append("Install plugin provider [authority:");
        r2.append(r1.authority);
        r2.append("] - [className:");
        r2.append(r1.name);
        r2.append("]");
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, r2.toString());
    L13:
        installProvider(r0, r1, r6);
        goto L9
    L20:
        return;
    L19:
        return;
    }

    private void installProvider(String r5, ProviderInfo r6, Plugin r7) {
        if (r6 != null) goto L7;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + r7.mPkgName + "】");
        return;
    L7:
        if (TextUtils.equals(r5, r6.processName) == false) goto L17;
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + r6.authority + "] [className:" + r6.name + "]");
        PluginContentProvider r8 = instantiateProvider(r7, r6);     // Catch: Exception -> L14
        if (r8 != null) goto L12;
        return;
    L12:
        r8.attachInfo(ZeusTransformUtils.wrapperContext(r7.mHostApplication, r7.mPkgName), r6);     // Catch: Exception -> L14
        ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + r6.name + "]");     // Catch: Exception -> L14
        this.mContentProviderMap.put(new b(r6.packageName, r6.processName, r6.authority), new a(r8));
    L14:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e);
        return;
    L17:
        this.mAuthorityProcessNameMap.put(r6.authority, r6.processName);
    }

    public String getType(ContentResolver r1, Uri r2, String r3) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3);
    }

    public int delete(ContentResolver r1, Uri r2, Bundle r3, String r4) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4);
    }

    public Uri insert(ContentResolver r1, Uri r2, ContentValues r3, String r4) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4);
    }

    public int delete(ContentResolver r1, Uri r2, String r3, String[] r4, String r5) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5);
    }

    public Uri insert(ContentResolver r1, Uri r2, ContentValues r3, Bundle r4, String r5) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5);
    }

    public int update(ContentResolver r1, Uri r2, ContentValues r3, Bundle r4, String r5) {
        return com.volcengine.zeus.provider.a.b(r1, r2, r3, r4, r5);
    }

    public Bundle call(ContentResolver r1, Uri r2, String r3, String r4, Bundle r5, String r6) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6);
    }

    public Cursor query(ContentResolver r1, Uri r2, String[] r3, Bundle r4, CancellationSignal r5, String r6) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6);
    }

    public int update(ContentResolver r1, Uri r2, ContentValues r3, String r4, String[] r5, String r6) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6);
    }

    public final Bundle call(ContentResolver r1, String r2, String r3, String r4, Bundle r5, String r6) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6);
    }

    public Cursor query(ContentResolver r1, Uri r2, String[] r3, String r4, String[] r5, String r6, String r7) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6, r7);
    }

    public Cursor query(ContentResolver r1, Uri r2, String[] r3, String r4, String[] r5, String r6, CancellationSignal r7, String r8) {
        return com.volcengine.zeus.provider.a.a(r1, r2, r3, r4, r5, r6, r7, r8);
    }
}
