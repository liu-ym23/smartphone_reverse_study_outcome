package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements View.OnLayoutChangeListener {
    public final /* synthetic */ FloatCardComment a;

    public m(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) != (r9 - r7)) goto L5;
        return;
    L5:
        if ((r4 - r2) != (r8 - r6)) goto L12;
        tt5.a.h("Comment#CardComment2", "onLayoutChangeListener : bottom = " + r5);
        CommentPagerAdapter2 r10 = this.a.o;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r10 = null;
    L9:
        RecyclerView r11 = r10.P0(Integer.valueOf(this.a.p0));
        FloatCardComment r12 = this.a;
        FloatCardComment.c(r12, r11, r12.I);
        return;
    }
}
