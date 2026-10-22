package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends com.bytedance.android.ec.core.utils.rotation.a<p0> {
    public final /* synthetic */ IntroCardInfoComponent k;
    public final /* synthetic */ FrameLayout l;
    public final /* synthetic */ FrameLayout m;
    public final /* synthetic */ int n;
    public final /* synthetic */ List o;

    public final View f(int r1) {
        if (r1 != 0) goto L5;
        return this.l;
    L5:
        return this.m;
    }

    public final void i(int r4, Object r5) {
        p0 r6 = (p0) r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (r4 != 0) goto L5;
        FrameLayout r7 = this.l;
    L6:
        r7.removeAllViews();
        IntroCardInfoComponent r0 = this.k;
        int r1 = this.n;
        int r2 = IntroCardInfoComponent.g;
        r7.addView((LinearLayout) r0.d(r6, r1).component1(), new LinearLayout.LayoutParams(-1, -2));
        return;
    L5:
        r7 = this.m;
        goto L6
    }

    public c(IntroCardInfoComponent r9, FrameLayout r10, FrameLayout r11, int r12, List r13, List r14, long r15, long r17) {
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        super(r14, r15, r17, false);
    }
}
