package xu6;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.ILocalLifeLiveService;
import com.bytedance.locallife.adapter.impl.init.LocalLifeInitializer;
import com.bytedance.locallife.host.ILifeHostPerfService;
import com.bytedance.locallife.host.ILifeHostService;
import com.bytedance.locallife.host.ILifeLiveHostService;
import com.bytedance.locallife.sdk.LocalLifeSdk;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.feed.model.NearbyCities;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import df6.q;
import df6.r;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lz6.e0;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f565100a = null;

    public static final class a implements com.bytedance.android.locallife.core.service.a {
        public a() {
        }

        @Override // com.bytedance.android.locallife.core.service.a
        public final void a(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            com.larus.platform.service.g r101 = com.larus.platform.service.g.f365738a;
            r101.ensureNotReachHere(r100, "LifeServiceManager exception");
            r101.ensureNotReachHere(new RuntimeException(), "LifeServiceManager exception | invoke stack");
        }
    }

    static {
        f565100a = LazyKt.lazy(new xu6.a());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [xu6.e] */
    public static void a() {
        ConcurrentHashMap<Class<?>, Object> r100 = LifeServiceManager.f162660a;
        a r101 = new a();
        Intrinsics.checkNotNullParameter(r101, "callback");
        LifeServiceManager.f162662c = r101;
        q.b(new r(new r.a(AppHost.f326268a.getApplication())));
        CopyOnWriteArrayList<fo6.d> r102 = fo6.e.f478167a;
        fo6.e.a(new com.bytedance.locallife.host.route.e(new com.bytedance.locallife.adapter.impl.router.c(new e())));
        int r103 = LocalLifeInitializer.f256488a;
        cn6.a r104 = cn6.a.f24548a;
        cn6.b r105 = cn6.b.f24549a;
        cn6.c r106 = cn6.c.f24550a;
        Intrinsics.checkNotNullParameter(r104, "pdpService");
        Intrinsics.checkNotNullParameter(r105, "poiPageService");
        Intrinsics.checkNotNullParameter(r106, "rateService");
        LifeServiceManager.e(com.bytedance.locallife.pdp.d.class, r104);
        LifeServiceManager.e(by6.a.class, r105);
        LifeServiceManager.e(com.bytedance.locallife.rate.a.class, r106);
        ms6.d r107 = ms6.d.f515485a;
        e0 r108 = new e0();
        ms6.a r109 = ms6.a.f515484a;
        Intrinsics.checkNotNullParameter(r107, "hostService");
        Intrinsics.checkNotNullParameter(r108, "liveService");
        Intrinsics.checkNotNullParameter(r109, "perfService");
        LifeServiceManager.e(ILifeHostService.class, r107);
        LifeServiceManager.e(ILifeLiveHostService.class, r108);
        LifeServiceManager.e(ILifeHostPerfService.class, r109);
        NearbyCities.CityBean r110 = com.bytedance.locallife.adapter.impl.host.location.c.f256462a;
        com.bytedance.locallife.adapter.impl.host.location.c.d(NearbyPageType.TAB_GROUP_BUY);
        com.bytedance.locallife.adapter.impl.host.location.c.d(NearbyPageType.PAGE_GROUP_BUY);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, xu6.b] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, xu6.c] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, xu6.d] */
    public static void b() {
        LocalLifeSdk r100 = LocalLifeSdk.f264319a;
        ?? r101 = new b();
        ?? r102 = new c();
        ?? r103 = new d();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "baseBlock");
        Intrinsics.checkNotNullParameter(r102, "totalBlock");
        Intrinsics.checkNotNullParameter(r103, "onLifeRouterOpen");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LocalLifeSdk.a(r101, r102, r103);
        ILocalLifeLiveService r104 = (ILocalLifeLiveService) f565100a.getValue();
        if (r104 == null) goto L6;
        r104.a();
        return;
    }

    public static void c() {
        LocalLifeSdk.f264319a.getClass();
        if (LocalLifeSdk.f264320b == false) goto L16;
        return;
    L16:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        b();     // Catch: Throwable -> L10
        if (LocalLifeSdk.f264320b == false) goto L8;
        FLogger.f375446a.i("BackgroundLazyInit", "LocalLife init completed");     // Catch: Throwable -> L10
    L8:
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L18;
        FLogger.f375446a.e("LocallifeSdkInitializer", "init exception", r102);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, xu6.f] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, xu6.g] */
    public static void d() {
        LocalLifeSdk r100 = LocalLifeSdk.f264319a;
        ?? r101 = new f();
        ?? r102 = new g();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "baseBlock");
        Intrinsics.checkNotNullParameter(r102, "totalBlock");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LocalLifeSdk.c(r101, r102);
    }
}
