package com.bytedance.ee.bear.middleground.comment.card;

import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements PointRecoderRecyclerView.a {
    public final /* synthetic */ CommentPagerAdapter2 a;

    public g(CommentPagerAdapter2 r1) {
        this.a = r1;
    }

    public final void a(float r2) {
        com.bytedance.ee.bear.middleground.comment.control.y r0 = this.a.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r0 = null;
    L5:
        r0.m(r2);
    }
}
