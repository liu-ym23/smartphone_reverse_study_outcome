package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public s0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        tt5.a.h("Comment#CardComment", "nextButton click");
        int r0 = this.a.n.getCurrentItem();
        d r1 = this.a.E;
        CommentPagerAdapter r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L6:
        if (r1.o(r0) == true) goto L17;
        CommentPagerAdapter r3 = this.a.D;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L11:
        int r5 = r0 + 1;
        if (r2.b() <= r5) goto L18;
        this.a.n.w(r5, true);
        tt5.a.h("Comment#CardComment", "nextButton click, so dismiss inputComment");
        kf5.b r6 = this.a.f;
        if (r6 == null) goto L19;
        kf5.a.a(r6, false, false, 3);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r2 = r3;
        goto L11
    }
}
