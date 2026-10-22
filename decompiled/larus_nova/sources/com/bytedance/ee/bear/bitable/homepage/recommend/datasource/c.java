package com.bytedance.ee.bear.bitable.homepage.recommend.datasource;

import com.bytedance.ee.bear.bitable.homepage.recommend.RecommendLoadType;
import com.bytedance.ee.bear.contract.NetService;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f213017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f213018b;

    public c() {
        this.f213017a = new CompositeDisposable();
    }

    public static final void a(c r110, long r111, int r112, String r113, String r114, String r115) {
        r110.getClass();
        int r100 = vs4.a.f556983a;
        long r101 = r110.f213018b + 1;
        r110.f213018b = r101;
        vs4.a.C8038a r102 = new vs4.a.C8038a(r111, r112, r113, r114, r115, r101);
        Intrinsics.checkNotNullParameter(r102, "recommendParams");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new vs4.d(r102));
    }

    public static Object b(final c r110, int r111, String r112, boolean r113, final RecommendLoadType r114, Continuation r115) {
        r110.getClass();
        final long r100 = System.currentTimeMillis();
        j r101 = new j(IntrinsicsKt.intercepted(r115), 1);
        r101.C();
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r103 = new NetService.f("/space/api/platform/template/content_recommend");
        r103.f216906c = 2;
        r103.b("chunk_size", String.valueOf(r111));
        r103.b("change_extra", r112);
        r103.b("is_refresh", String.valueOf(r113));
        r103.b("scene", String.valueOf(1));
        String r116 = u05.b.a();
        r103.c(MapsKt.mapOf(TuplesKt.to(NetResponse.HEADER_KEY_LOG_ID, r116)));
        tt5.a.h("BitableRecommendDataFetcher", "innerFetch, params: " + r103.f216908e + ", logId: " + r116);
        final Disposable r104 = r102.Vc(new d(r116)).a(r103).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new a(r114, r110, r100, r101), new b(r114, r110, r100, r101));
        r110.f213017a.add(r104);
        r101.i(new BitableRecommendDataFetcher$fetch$2$1(r110, r100, r114, r104));
        tt5.a.h("BitableRecommendDataFetcher", "fetch send, and wait");
        Object r117 = r101.B();
        if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r115);
    L5:
        return r117;
    }
}
