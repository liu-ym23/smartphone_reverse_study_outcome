package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.shopping.utils.s;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Observer<la3.b> {
    public final /* synthetic */ BuyNowStarterOpt a;
    public final /* synthetic */ boolean b;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r14) {
        Intrinsics.checkNotNullParameter(r14, "e");
        BuyNowStarterOpt r0 = this.a;
        d r12 = new d(r0.j, null, new ma3.b(null, 6), this.b, r14, s.a(r14), 0, false, false, 384);
        r0.f = r12;
        Function1<? super d, Unit> r15 = r0.g;
        if (r15 == null) goto L6;
        Unit r16 = (Unit) r15.invoke(r12);
        return;
    }

    public final void onNext(Object r15) {
        final la3.b r16 = (la3.b) r15;
        Intrinsics.checkNotNullParameter(r16, "t");
        BuyNowStarterOpt r0 = this.a;
        boolean r1 = true;
        r0.h = true;
        Function0<Unit> r2 = r0.i;
        if (r2 == null) goto L5;
        Unit r3 = (Unit) r2.invoke();
    L5:
        BuyNowStarterOpt r4 = this.a;
        String r5 = r4.j;
        String r6 = r16.b;
        ma3.b r7 = r16.a;
        boolean r8 = this.b;
        int r9 = r16.c;
        int r10 = r16.d;
        if (r10 == 0) goto L8;
        boolean r11 = true;
    L9:
        if (r10 == 1) goto L12;
        r1 = false;
    L12:
        d r13 = new d(r5, r6, r7, r8, null, null, r9, r11, r1, 16);
        r4.f = r13;
        Function1<? super d, Unit> r12 = r4.g;
        if (r12 == null) goto L15;
        Unit r14 = (Unit) r12.invoke(r13);
    L15:
        Map r17 = ECParamTrackerCenter.a;
        com.bytedance.android.ec.core.monitor.param.a r18 = ECParamTrackerCenter.c(this.a.j);
        if (r18 == null) goto L19;
        na3.g r19 = na3.g.a;
        r18.l(na3.g.b(this.a.k), new BuyNowStarterOpt$loadBuyNowRenderDataOpt$1$onNext$1(r16));
        return;
    L19:
        return;
    L8:
        r11 = false;
        goto L9
    }

    public l(BuyNowStarterOpt r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
