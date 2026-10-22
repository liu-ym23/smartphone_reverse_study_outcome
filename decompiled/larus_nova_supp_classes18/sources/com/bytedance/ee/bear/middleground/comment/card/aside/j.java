package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.control.y;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements PointRecoderRecyclerView.a {
    public final /* synthetic */ AsidePageAdapter a;

    public j(AsidePageAdapter r1) {
        this.a = r1;
    }

    public final void a(float r2) {
        y r0 = this.a.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r0 = null;
    L5:
        r0.m(r2);
    }
}
