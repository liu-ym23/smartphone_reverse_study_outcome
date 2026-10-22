package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public a0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        FloatCardComment r5 = this.a;
        d r0 = r5.p;
        Boolean r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        VerticalViewPager r2 = this.a.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r2 = null;
    L8:
        CommentBean r3 = r0.e(Integer.valueOf(r2.getCurrentItem()));
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L11;
        r1 = Boolean.FALSE;
    L11:
        FloatCardComment.m(r5, r3, r1, 2);
    }
}
