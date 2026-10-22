package com.bytedance.ee.bear.middleground.comment.card;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 implements TextWatcher {
    public final /* synthetic */ HalfScreenCardComment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public f1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        ImageView r0 = this.a.P;
        CommentEditText r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sendView");
        r0 = null;
    L5:
        boolean r2 = false;
        if (r5 == null) goto L8;
        int r6 = r5.length();
    L10:
        if (r6 <= 0) goto L12;
        boolean r7 = true;
    L13:
        r0.setEnabled(r7);
        CommentEditText r8 = this.a.M;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
    L17:
        r1.getClass();
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L20;
    L22:
        if (r2 == true) goto L25;
        HalfScreenCardComment.b(this.a, true);
        return;
    L25:
        return;
    L20:
        if (r1.p2 == false) goto L22;
        r2 = true;
        goto L22
    L16:
        r1 = r8;
        goto L17
    L12:
        r7 = false;
        goto L13
    L8:
        r6 = 0;
        goto L10
    }
}
