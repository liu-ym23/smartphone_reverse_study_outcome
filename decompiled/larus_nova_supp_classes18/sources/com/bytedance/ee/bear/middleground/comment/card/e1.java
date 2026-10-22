package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public e1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        CommentEditText r6 = this.a.M;
        CommentEditText r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        r6 = null;
    L5:
        kn4.g r7 = r6.getAtWindow();
        boolean r2 = false;
        if (r7 != null) goto L8;
    L10:
        if (r2 == false) goto L18;
        CommentEditText r8 = this.a.M;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L15:
        kn4.g r9 = r0.getAtWindow();
        if (r9 == null) goto L24;
        r9.close();
        return;
    L24:
        return;
    L14:
        r0 = r8;
        goto L15
    L18:
        CommentEditText r10 = this.a.M;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L22:
        r0.J();
        return;
    L21:
        r0 = r10;
        goto L22
    L8:
        if (r7.isShowing() != true) goto L10;
        r2 = true;
        goto L10
    }
}
