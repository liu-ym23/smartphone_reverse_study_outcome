package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public f0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.k r5 = this.a.j();
        if (r5 == null) goto L5;
        r5.b();
    L5:
        FloatCardComment r6 = this.a;
        VerticalViewPager r0 = null;
        r6.L = null;
        r6.o(false, null);
        FloatCardComment r7 = this.a;
        d r1 = r7.p;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L8:
        VerticalViewPager r2 = this.a.m;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L12:
        FloatCardComment.m(r7, r1.e(Integer.valueOf(r0.getCurrentItem())), Boolean.TRUE, 2);
        return;
    L11:
        r0 = r2;
        goto L12
    }
}
