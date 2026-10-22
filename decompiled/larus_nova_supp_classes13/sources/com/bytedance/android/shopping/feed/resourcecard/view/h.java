package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.animation.RotateAnimation;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Observer<rd3.k> {
    public final /* synthetic */ PanelsNodeView a;

    public final void onComplete() {
        PanelsNodeView r0 = this.a;
        int r1 = PanelsNodeView.s;
        r0.d();
    }

    public h(PanelsNodeView r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        PanelsNodeView r3 = this.a;
        int r0 = PanelsNodeView.s;
        r3.d();
    }

    public final void onNext(Object r4) {
        rd3.k r5 = (rd3.k) r4;
        Intrinsics.checkNotNullParameter(r5, "resp");
        yd3.p r0 = r5.a();
        if (r0 == null) goto L9;
        yd3.m r1 = r0.l();
        if (r1 == null) goto L9;
        List<Promotion> r2 = r1.h();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L11:
        if (r3 >= 3) goto L13;
        UIUtils.displayToast(this.a.getContext(), 2131896661);
    L51:
        this.a.o = true;
        return;
    L13:
        rd3.a r6 = this.a.f;
        if (r6 == null) goto L26;
        yd3.p r7 = r6.i();
        if (r7 == null) goto L26;
        yd3.m r8 = r7.l();
        if (r8 == null) goto L26;
        yd3.p r9 = r5.a();
        if (r9 == null) goto L24;
        yd3.m r10 = r9.l();
        if (r10 == null) goto L24;
        List<Promotion> r11 = r10.h();
    L25:
        r8.i(r11);
    L24:
        r11 = null;
    L26:
        rd3.a r12 = this.a.f;
        if (r12 == null) goto L39;
        yd3.p r13 = r12.i();
        if (r13 == null) goto L39;
        yd3.a r14 = r13.b();
        if (r14 == null) goto L39;
        yd3.p r15 = r5.a();
        if (r15 == null) goto L37;
        yd3.a r16 = r15.b();
        if (r16 == null) goto L37;
        String r17 = r16.c();
    L38:
        r14.e(r17);
    L37:
        r17 = null;
    L39:
        rd3.a r18 = this.a.f;
        if (r18 == null) goto L48;
        yd3.p r19 = r18.i();
        if (r19 == null) goto L48;
        yd3.p r20 = r5.a();
        if (r20 == null) goto L46;
        yd3.p.b r21 = r20.g();
    L47:
        r19.s(r21);
        goto L48
    L46:
        r21 = null;
    L48:
        rd3.a r22 = this.a.f;
        if (r22 == null) goto L51;
        this.a.c(r22, null);
    L9:
        r3 = 0;
        goto L11
    }

    public final void onSubscribe(Disposable r9) {
        Intrinsics.checkNotNullParameter(r9, "disposable");
        PanelsNodeView r0 = this.a;
        r0.k = r9;
        r0.n.setImageResource(2131233533);
        RotateAnimation r10 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r10.setDuration(1000);
        this.a.n.startAnimation(r10);
    }
}
