package com.bytedance.iesgurd.core;

import android.content.Context;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.IGeckoGlobalInit;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.iesgurd.model.Common;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f250632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f250633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f250634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f250635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f250636e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Common f250637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static GeckoGlobalConfig f250638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f250639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f250640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static zy5.c f250641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final GlobalManager f250642k = null;

    public GlobalManager() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (f250634c.get() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        IGeckoGlobalInit r100 = (IGeckoGlobalInit) ServiceManager.get().getServiceForReal(IGeckoGlobalInit.class);     // Catch: Throwable -> L14
        if (r100 == null) goto L12;
        GeckoGlobalConfig r101 = r100.getGeckoGlobalConfig();     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        d(r101);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    static {
        f250642k = new GlobalManager();
        f250632a = new AtomicBoolean(false);
        f250633b = new AtomicBoolean(false);
        f250634c = new AtomicBoolean(false);
        f250635d = new ConcurrentHashMap();
        f250636e = new ConcurrentHashMap();
        f250637f = new Common();
        f250639h = true;
    }

    public static String c() {
        Context r100 = com.bytedance.geckox.b.a.f245076a.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFilesDir() + "/offlineX";
    }

    public final Context getContext() {
        GeckoGlobalConfig r100 = f250638g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public static String b(String r100) {
        if (AppSettingsManager.b.f245071a.a() == false) goto L11;
        GeckoGlobalConfig r101 = f250638g;
        if (r101 == null) goto L12;
        String r102 = r101.getRootDir();
        if (r102 == null) goto L12;
        return r102;
    L12:
        return (String) ((ConcurrentHashMap) f250635d).get(r100);
    L11:
        return (String) ((ConcurrentHashMap) f250635d).get(r100);
    }

    public static void d(GeckoGlobalConfig r100) {
        AtomicBoolean r101 = f250634c;
        if (r101.get() == false) goto L5;
        return;
    L5:
        GeckoLogger.d("GeckoGlobalManager init");
        f250638g = r100;
        Context r102 = r100.getContext();
        r101.set(true);
        f250640i = System.currentTimeMillis();
        f250641j = new zy5.c();
        String r103 = com.bytedance.iesgurd.strategy.e.f250861a;
        AppSettingsManager.IGeckoAppSettings r104 = AppSettingsManager.b.f245071a.b();
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
        com.bytedance.iesgurd.strategy.e.b("registerProbeListener_error", "", null);
        GeckoLogger.d("[gecko probe] disabled");
    L16:
        if (GkFSUtils.f() == false) goto L18;
        String[] r106 = GeckoFileSystem.f245101a;
        GeckoFileSystem.b(r102);
    L23:
        boolean r107 = a.f250646a;
        a.f250647b = new PolarisFileWrapper(r102.getFilesDir(), GeckoClient.GECKO_ROOT_DIR);
        PolarisFileWrapper r108 = a.f250647b;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("fileRoot");
    L26:
        a.f250648c = new PolarisFileWrapper(r108, "pending_delete");
        a.f250646a = true;
        f250637f.init(r100);
        GeckoLogger.d("GeckoGlobalManager init finish");
        Iterator r109 = ((ConcurrentHashMap) f250636e).entrySet().iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        Map.Entry r110 = (Map.Entry) r109.next();
        e((String) r110.getKey(), (String) r110.getValue());
        goto L28
    L30:
        return;
    L18:
        GkFSUtils.b(r102, GlobalManager$init$1.INSTANCE);
        if (GkFSUtils.f() == true) goto L23;
        if (GkFSUtils.h() == false) goto L23;
        GkFSExecutor.a(new com.bytedance.geckox.d(r102));
        goto L23
    L14:
        com.bytedance.iesgurd.strategy.e.f250862b = r102;
        com.bytedance.iesgurd.strategy.e.f250863c = r100;
        com.bytedance.iesgurd.strategy.e.f250861a = ez5.g.a.f474886a.a(r102, "tlb_probe", null);
        GeckoLogger.d("[gecko probe] request interceptor registered,old probe:" + com.bytedance.iesgurd.strategy.e.f250861a);
        RetrofitUtils.addInterceptor(new com.bytedance.iesgurd.strategy.c());
        goto L16
    L8:
        if (r104.isProbeEnable() != true) goto L10;
        r105 = true;
        goto L12
    }

    public static void e(String r100, String r101) {
        if (AppSettingsManager.b.f245071a.a() == true) goto L5;
        return;
    L5:
        GeckoLogger.d("migrateRes accessKey: " + r100 + ", dir: " + r101);
        GeckoGlobalConfig r102 = f250638g;
        if (r102 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        String r103 = r102.getRootDir();
        ((ConcurrentHashMap) f250635d).put(r100, r103);
        boolean r104 = a.f250646a;
        if (Intrinsics.areEqual(r101, r103) == false) goto L11;
        GeckoLogger.d("migrateResToSameDir, srcDir equals destDir, accessKey: " + r100 + ", srcDir: " + r101);
    L27:
        if (f250633b.get() == false) goto L30;
        com.bytedance.iesgurd.meta.a.d(r100, r101);
        return;
    L30:
        return;
    L11:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101, r100);
        if (r105.exists() == true) goto L14;
        GeckoLogger.d("migrateResToSameDir, srcDir not exists, accessKey: " + r100 + ", srcDir: " + r101);
        goto L27
    L14:
        File[] r106 = r105.listFiles(d.f250655a);
        boolean r107 = true;
        if (r106 != null) goto L17;
    L23:
        if (r107 == false) goto L25;
        GeckoLogger.d("migrateResToSameDir, srcDir is empty, accessKey: " + r100 + ", srcDir: " + r101);
        ez5.c.delete(r105);
        goto L27
    L25:
        ((Executor) GeckoExecutors.f250873f.getValue()).execute(new c(r103, r100, r106, r101));
        goto L27
    L17:
        if (r106.length != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L23;
        r107 = false;
        goto L23
    L19:
        r108 = false;
        goto L20
    }
}
