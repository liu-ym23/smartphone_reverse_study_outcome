package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x0 implements View.OnLongClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public x0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r8) {
        HalfScreenCardComment.s(this.a, false, false, 6);
        HalfScreenCardComment r9 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r9.a.d0;
        d r10 = r9.E;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r10 = null;
    L5:
        String r11 = r10.f(Integer.valueOf(this.a.n.getCurrentItem()));
        Pair[] r4 = new Pair[2];
        r4[0] = TuplesKt.to(ResourceData.KEY_TYPE, "comment");
        d r1 = this.a.E;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r1 = null;
    L8:
        CommentBean r2 = r1.e(Integer.valueOf(this.a.n.getCurrentItem()));
        if (r2 == null) goto L13;
        CommentBean.Extra r3 = r2.getExtra();
        if (r3 == null) goto L13;
        String r5 = r3.getReportVisibility();
    L14:
        r4[1] = TuplesKt.to("comment_visible_range", r5);
        r0.g("input_box", r11, null, MapsKt.mapOf(r4));
        return true;
    L13:
        r5 = null;
        goto L14
    }
}
