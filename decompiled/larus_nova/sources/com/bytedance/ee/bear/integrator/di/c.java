package com.bytedance.ee.bear.integrator.di;

import com.bytedance.ee.bear.basesdk.apisupport.ISdkClaymoreService;
import com.bytedance.ee.bear.basesdk.apisupport.w;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import javax.inject.Inject;
import on4.r;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements hb5.a {

    public class a implements FlowableOnSubscribe<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile com.bytedance.ee.bear.integrator.di.a f227087a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.c$a$a, reason: collision with other inner class name */
        public class C3249a implements r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter f227088a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f227089b;

            @Override // on4.r
            public final void onInit() {
                tt5.a.h("AppInitializeImpl", "init start!!!");
                if (this.f227089b.f227087a == null) goto L5;
                tt5.a.h("AppInitializeImpl", "init remove timeout task!!!");
                j.e(this.f227089b.f227087a);
            L5:
                tt5.a.h("AppInitializeImpl", "init remove doc listener!!!");
                j.c(new b(this));
                this.f227088a.onNext("anything non null");
                this.f227088a.onComplete();
            }

            public C3249a(a r100, FlowableEmitter r101) {
                this.f227089b = r100;
                this.f227088a = r101;
            }
        }

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.integrator.di.a] */
        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(final FlowableEmitter<Object> r100) throws Exception {
            if (w.c() == false) goto L6;
            r100.onNext("anything non null");
            r100.onComplete();
            tt5.a.h("AppInitializeImpl", "init Complete!!!");
            return;
        L6:
            final C3249a r101 = new C3249a(this, r100);
            this.f227087a = new com.bytedance.ee.bear.integrator.di.a(r101, r100);
            tt5.a.h("AppInitializeImpl", "init timeout add DocInitListener!!!");
            w.b(r101);
            tt5.a.h("AppInitializeImpl", "init postDelayed timeout Task!!!");
            j.d(this.f227087a, 10000);
        }
    }

    @Override // hb5.a
    public final Flowable<Object> Sc() {
        return Flowable.create(new a(), BackpressureStrategy.BUFFER);
    }

    @Override // hb5.a
    public final void checkAndInit() {
        if (w.c() == false) goto L11;
        tt5.a.h("AppInitializeImpl", "checkAndInit Complete!!!");
        return;
    L11:
        ((ISdkClaymoreService) ApiUtils.getApi(ISdkClaymoreService.class)).checkAndInit();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e("AppInitializeImpl", "call checkAndInit error!", th, false);
    }

    @Inject
    public c() {
    }
}
