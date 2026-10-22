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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements hb5.a {

    public class a implements FlowableOnSubscribe<Object> {
        public volatile com.bytedance.ee.bear.integrator.di.a a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.integrator.di.c$a$a, reason: collision with other inner class name */
        public class C0193a implements r {
            public final /* synthetic */ FlowableEmitter a;
            public final /* synthetic */ a b;

            public final void onInit() {
                tt5.a.h("AppInitializeImpl", "init start!!!");
                if (this.b.a == null) goto L5;
                tt5.a.h("AppInitializeImpl", "init remove timeout task!!!");
                j.e(this.b.a);
            L5:
                tt5.a.h("AppInitializeImpl", "init remove doc listener!!!");
                j.c(new b(this));
                this.a.onNext("anything non null");
                this.a.onComplete();
            }

            public C0193a(a r1, FlowableEmitter r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.integrator.di.a] */
        public final void subscribe(final FlowableEmitter<Object> r4) throws Exception {
            if (w.c() == false) goto L6;
            r4.onNext("anything non null");
            r4.onComplete();
            tt5.a.h("AppInitializeImpl", "init Complete!!!");
            return;
        L6:
            final C0193a r0 = new C0193a(this, r4);
            this.a = new com.bytedance.ee.bear.integrator.di.a(r0, r4);
            tt5.a.h("AppInitializeImpl", "init timeout add DocInitListener!!!");
            w.b(r0);
            tt5.a.h("AppInitializeImpl", "init postDelayed timeout Task!!!");
            j.d(this.a, 10000);
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
