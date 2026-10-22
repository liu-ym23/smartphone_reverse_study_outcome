package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public z(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
    L7:
        FloatCardComment r6 = this.a;
        d r0 = r6.p;
        Boolean r1 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L10:
        VerticalViewPager r2 = this.a.m;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r2 = null;
    L13:
        CommentBean r3 = r0.e(Integer.valueOf(r2.getCurrentItem()));
        boolean r4 = !this.a.K;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L16;
        r1 = Boolean.valueOf(this.a.K);
    L16:
        r6.l(r3, r4, r1);
        return;
    L5:
        if (this.a.K == false) goto L7;
    }
}
