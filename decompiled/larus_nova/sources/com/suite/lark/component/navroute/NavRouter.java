package com.suite.lark.component.navroute;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.activity.AppNavRouteHost;
import com.suite.lark.component.navroute.group.NavRouterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class NavRouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f460191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NavRouterProvider f460192b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<ync.a<qnc.c>> f460193c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<ync.a<com.suite.lark.component.navroute.lifecycle.b>> f460194d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.suite.lark.component.navroute.group.c f460195e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f460196f;

    public static final class NavRouteConfigBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.suite.lark.component.navroute.graph.a f460197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.suite.lark.component.navroute.args.b f460198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<qnc.c> f460199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super KClass<? extends com.suite.lark.component.navroute.api.a<?, ?>>, Boolean> f460200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function0<Boolean> f460201e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function0<Boolean> f460202f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function0<Boolean> f460203g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Executor f460204h;

        public NavRouteConfigBuilder() {
            this.f460199c = new ArrayList();
            this.f460200d = NavRouter$NavRouteConfigBuilder$isNavRouteEnable$1.INSTANCE;
            this.f460201e = NavRouter$NavRouteConfigBuilder$isAutoTabEnable$1.INSTANCE;
            this.f460202f = NavRouter$NavRouteConfigBuilder$isGoBackResultEnable$1.INSTANCE;
            this.f460203g = NavRouter$NavRouteConfigBuilder$tempOptimizeEnable$1.INSTANCE;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f460205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.suite.lark.component.navroute.graph.a f460206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.suite.lark.component.navroute.args.b f460207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<qnc.c> f460208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<KClass<? extends com.suite.lark.component.navroute.api.a<?, ?>>, Boolean> f460209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function0<Boolean> f460210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function0<Boolean> f460211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function0<Boolean> f460212h;

        public a(Executor r100, com.suite.lark.component.navroute.graph.a r101, com.suite.lark.component.navroute.args.b r102, List r103, Function1 r104, Function0 r105, Function0 r106, Function0 r107) {
            Intrinsics.checkNotNullParameter(r101, "graphRepository");
            Intrinsics.checkNotNullParameter(r102, "navArgsTypeRepository");
            Intrinsics.checkNotNullParameter(r103, "globalInterceptors");
            Intrinsics.checkNotNullParameter(r104, "isNavRouteEnable");
            Intrinsics.checkNotNullParameter(r105, "isAutoTabEnable");
            Intrinsics.checkNotNullParameter(r106, "isGoBackResultEnable");
            Intrinsics.checkNotNullParameter(r107, "tempOptimizeEnable");
            this.f460205a = r100;
            this.f460206b = r101;
            this.f460207c = r102;
            this.f460208d = r103;
            this.f460209e = r104;
            this.f460210f = r105;
            this.f460211g = r106;
            this.f460212h = r107;
        }
    }

    public NavRouter() {
    }

    static {
        f460192b = NavRouterProvider.f460376a;
        f460193c = new LinkedHashSet();
        f460194d = new LinkedHashSet();
        f460195e = new com.suite.lark.component.navroute.group.c();
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return "NavRouter-".concat(r100);
    }

    public static boolean c(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "routerType");
        a r101 = f460191a;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.f460209e.invoke(r100).booleanValue();
    }

    @JvmStatic
    public static final void b(Context r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "block");
        if (f460196f == false) goto L5;
        return;
    L5:
        f460196f = true;
        NavRouteConfigBuilder r100 = new NavRouteConfigBuilder();
        r111.invoke(r100);
        Executor r101 = r100.f460204h;
        com.suite.lark.component.navroute.graph.a r102 = r100.f460197a;
        a r112 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("graphProvider");
        com.suite.lark.component.navroute.graph.a r103 = null;
    L9:
        com.suite.lark.component.navroute.args.b r104 = r100.f460198b;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("navArgsTypeRepository");
        com.suite.lark.component.navroute.args.b r105 = null;
    L13:
        a r113 = new a(r101, r103, r105, r100.f460199c, r100.f460200d, r100.f460201e, r100.f460202f, r100.f460203g);
        f460191a = r113;
        Iterator<T> r114 = r113.f460208d.iterator();
    L15:
        if (r114.hasNext() == false) goto L17;
        qnc.c r106 = (qnc.c) r114.next();
        Intrinsics.checkNotNullParameter(r106, "interceptor");
        f460193c.add(new ync.a(r106));
        goto L15
    L17:
        com.suite.lark.component.navroute.args.b r115 = com.suite.lark.component.navroute.args.a.f460276a;
        a r116 = f460191a;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("routeConfig");
        r116 = null;
    L20:
        com.suite.lark.component.navroute.args.b r117 = r116.f460207c;
        Intrinsics.checkNotNullParameter(r117, "repo");
        com.suite.lark.component.navroute.args.a.f460276a = r117;
        a r118 = f460191a;
        if (r118 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("routeConfig");
        r118 = null;
    L23:
        com.suite.lark.component.navroute.graph.a r119 = r118.f460206b;
        rnc.c r107 = rnc.c.f538747a;
        Intrinsics.checkNotNullParameter(r119, "repository");
        rnc.c.f538748b = r119;
        a r108 = f460191a;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("routeConfig");
    L27:
        Executor r109 = r112.f460205a;
        NavRouter$init$1$2 r120 = NavRouter$init$1$2.INSTANCE;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "isSyncGraph");
        if (r119.f460366e == true) goto L33;
        if (r109 != null) goto L32;
        r109 = com.suite.lark.component.navroute.graph.b.f460374a;
    L32:
        r119.f460364c = r109;
        r119.f460365d = r120;
        r119.f460366e = true;
        r119.b();
        Log.i("NavRouter", "global graphs init");
    L33:
        int r121 = rnc.b.f538746a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r122 = r110.getApplicationContext();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type android.app.Application");
        Application r123 = (Application) r122;
        AppNavRouteHost r124 = AppNavRouteHost.f460236h;
        Intrinsics.checkNotNullParameter(r123, "application");
        AppNavRouteHost r125 = new AppNavRouteHost(r123);
        Intrinsics.checkNotNullParameter(r123, PerfLog.PARAM_KEY_CONTEXT_ID);
        r125.i(r123);
        r125.j(r123);
        AppNavRouteHost.f460236h = r125;
        r123.registerActivityLifecycleCallbacks(new rnc.a());
        return;
    L26:
        r112 = r108;
        goto L27
    L12:
        r105 = r104;
        goto L13
    L8:
        r103 = r102;
        goto L9
    }
}
