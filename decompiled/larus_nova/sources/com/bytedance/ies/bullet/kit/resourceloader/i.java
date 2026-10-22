package com.bytedance.ies.bullet.kit.resourceloader;

import android.app.Application;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ResourceLoaderService> f246824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f246825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f246826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a26.b f246827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f246828e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static IXResourceLoader f246829f;

    public static final class a extends ResourceLoaderService {
        public a() {
        }

        @Override // com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService
        public final d1 h(String r100, v26.l r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "config");
            y16.b r102 = y16.c.f565659a;
            y16.c.b("placeHolder loadSync " + r100);
            return null;
        }

        @Override // com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService
        public final g g(String r100, v26.l r101, Function1<? super d1, Unit> r102, Function1<? super Throwable, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "config");
            Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
            Intrinsics.checkNotNullParameter(r103, "reject");
            y16.b r104 = y16.c.f565659a;
            y16.c.b("placeHolder loadAsync " + r100);
            r103.invoke(new Throwable("rl not init"));
            return new g(0);
        }
    }

    public i() {
    }

    static {
        f246824a = new ConcurrentHashMap();
        f246828e = new a();
    }

    public static void a(String r110, v26.j r210) {
        Intrinsics.checkNotNullParameter(r110, "bid");
        Intrinsics.checkNotNullParameter(r210, "config");
        y16.b r100 = y16.c.f565659a;
        y16.c.a("register ResourceLoader with ".concat(r110));
        com.bytedance.ies.bullet.forest.d r101 = com.bytedance.ies.bullet.forest.d.f246740a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r110, "bid");     // Catch: Throwable -> L65
        Intrinsics.checkNotNullParameter(r210, "rlConfig");     // Catch: Throwable -> L65
        boolean r102 = false;
        if (Intrinsics.areEqual(r110, "default_bid") == false) goto L18;
        com.bytedance.forest.model.i r103 = com.bytedance.ies.bullet.forest.d.f246741b;     // Catch: Throwable -> L65
        if (r103.f244346h == null) goto L9;
        com.bytedance.forest.utils.i r104 = com.bytedance.forest.utils.i.f244548a;     // Catch: Throwable -> L65
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Default gecko config already exists! Config is " + r103.f244346h, false, 60);     // Catch: Throwable -> L65
    L10:
        int r105 = com.bytedance.ies.bullet.forest.a.f246735a;     // Catch: Throwable -> L65
        Iterator r106 = com.bytedance.ies.bullet.forest.a.C3527a.a().iterator();     // Catch: Throwable -> L65
    L12:
        if (r106.hasNext() == false) goto L26;
        String r107 = (String) r106.next();     // Catch: Throwable -> L65
        Long r108 = StringsKt.toLongOrNull(r210.f552683d);     // Catch: Throwable -> L65
        if (r108 == null) goto L16;
        long r111 = r108.longValue();     // Catch: Throwable -> L65
    L17:
        GeckoConfig r112 = new GeckoConfig(r107, "offlineX", r111, r210.f552684e, r210.f552685f, r210.f552681b, true);     // Catch: Throwable -> L65
        com.bytedance.forest.model.i r109 = com.bytedance.ies.bullet.forest.d.f246741b;     // Catch: Throwable -> L65
        r109.f244347i.put(r107, r112);     // Catch: Throwable -> L65
        com.bytedance.forest.utils.i r113 = com.bytedance.forest.utils.i.f244548a;     // Catch: Throwable -> L65
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Register annie gecko config=" + r109.f244347i.get(r107) + " when register default bid", false, 60);     // Catch: Throwable -> L65
        goto L12
    L16:
        r111 = 0;
    L26:
        Iterator<T> r114 = r210.f552687h.entrySet().iterator();     // Catch: Throwable -> L65
    L27:
        if (r114.hasNext() == false) goto L38;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Throwable -> L65
        com.bytedance.ies.bullet.forest.d r116 = com.bytedance.ies.bullet.forest.d.f246740a;     // Catch: Throwable -> L65
        com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig r117 = (com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig) r115.getValue();     // Catch: Throwable -> L65
        if (Intrinsics.areEqual(r110, "webcast") == false) goto L32;
    L35:
        boolean r118 = true;
    L36:
        com.bytedance.ies.bullet.forest.d.b(r110, r117, r210, r118);     // Catch: Throwable -> L65
        goto L27
    L32:
        if (Intrinsics.areEqual(r110, "live") == true) goto L35;
        r118 = false;
        goto L36
    L38:
        monitor-exit(r101);
        ConcurrentHashMap<String, ResourceLoaderService> r119 = f246824a;
        ResourceLoaderService r120 = new ResourceLoaderService();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r120.f246786e = r110;
        Intrinsics.checkNotNullParameter(r210, "<set-?>");
        r120.f246787f = r210;
        String r121 = r210.f552686g.getAccessKey();
        com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig r122 = r210.f552686g;
        Intrinsics.checkNotNullParameter(r121, "ak");
        Intrinsics.checkNotNullParameter(r122, "config");
        if (r120.j() == true) goto L42;
        y16.c.b("ResourceLoaderConfig 实例未初始化，registerGeckoConfig未执行");
    L50:
        r119.put(r110, r120);
        int r123 = z16.a.f569669e;
        z16.a r124 = z16.a.b.f569674a;
        int r125 = r210.f552692m;
        if (r125 >= 1) goto L53;
        r124.getClass();
        return;
    L53:
        z16.b r126 = r124.f569671b;
        if (r126 != null) goto L56;
    L57:
        r124.f569672c.clear();
        z16.b r127 = r124.f569671b;
        if (r127 == null) goto L60;
        r127.evictAll();
    L60:
        z16.c r128 = r124.f569670a;
        if (r128 == null) goto L63;
        r128.evictAll();
    L63:
        r124.f569673d.clear();
        r124.f569671b = new z16.b(r125);
        r124.f569670a = new z16.c(r125);
        return;
    L56:
        if (r126.maxSize() > r125) goto L57;
        return;
    L42:
        r122.getLoaderDepender().d(r120);
        r120.f().f552687h.put(r121, r122);
        if (r122.getNetworkImpl() != null) goto L50;
        if (r122.getLocalInfo().length() <= 0) goto L47;
        r102 = true;
    L47:
        if (r102 == false) goto L49;
        r122.setNetworkImpl(r120.f().f552689j);
        goto L50
    L49:
        r122.setNetworkImpl(r120.f().f552690k);
        goto L50
    L9:
        com.bytedance.ies.bullet.forest.d.a();     // Catch: Throwable -> L65
        GeckoConfig r129 = com.bytedance.ies.bullet.forest.e.a(r210.f552686g, r210.f552683d, r210.f552684e, r210.f552685f, r210.f552681b);     // Catch: Throwable -> L65
        r103.f244346h = r129;     // Catch: Throwable -> L65
        com.bytedance.ies.bullet.forest.d.f246742c.put(r110, r129);     // Catch: Throwable -> L65
        com.bytedance.forest.utils.i r130 = com.bytedance.forest.utils.i.f244548a;     // Catch: Throwable -> L65
        com.bytedance.forest.utils.i.b("ForestConfigHelper", "Register default gecko config=" + r103.f244346h, false, 60);     // Catch: Throwable -> L65
        goto L10
    L18:
        com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig r131 = r210.f552686g;     // Catch: Throwable -> L65
        if (Intrinsics.areEqual(r110, "webcast") == false) goto L21;
    L24:
        boolean r132 = true;
    L25:
        com.bytedance.ies.bullet.forest.d.b(r110, r131, r210, r132);     // Catch: Throwable -> L65
        goto L26
    L21:
        if (Intrinsics.areEqual(r110, "live") == true) goto L24;
        r132 = false;
    L65:
        th = move-exception;
        throw th;
    }

    public static ResourceLoaderService b(String r100, int r101) {
        String r102 = "default_bid";
        if ((r101 & 1) == 0) goto L6;
        r100 = "default_bid";
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = null;
    L9:
        Intrinsics.checkNotNullParameter(r102, "fallback");
        ConcurrentHashMap<String, ResourceLoaderService> r103 = f246824a;
        ResourceLoaderService r104 = r103.get(r100);
        if (r104 != null) goto L15;
        ResourceLoaderService r105 = r103.get(r102);
        if (r105 == null) goto L14;
        return r105;
    L14:
        return f246828e;
    L15:
        return r104;
    }
}
