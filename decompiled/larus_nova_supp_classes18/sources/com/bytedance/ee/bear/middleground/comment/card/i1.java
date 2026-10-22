package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public i1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        View r4 = this.a.r;
        View r0 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
        r4 = null;
    L6:
        if (r4.isEnabled() == true) goto L8;
        return;
    L8:
        View r5 = this.a.r;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("createWholeCommentView");
    L12:
        boolean r6 = false;
        r0.setEnabled(false);
        Function0<Boolean> r1 = this.a.a.Y;
        if (r1 != null) goto L15;
    L17:
        if (r6 == true) goto L20;
        this.a.t();
        return;
    L20:
        return;
    L15:
        if (((Boolean) r1.invoke()).booleanValue() != true) goto L17;
        r6 = true;
        goto L17
    L11:
        r0 = r5;
        goto L12
    }
}
