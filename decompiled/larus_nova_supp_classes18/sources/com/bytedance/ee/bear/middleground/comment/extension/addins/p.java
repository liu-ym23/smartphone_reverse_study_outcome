package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ View b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        this.a.getGlobalVisibleRect(r0);
        this.b.getGlobalVisibleRect(r1);
        String r2 = this.a.getText().toString();
        int r3 = this.a.getLineCount();
        if (this.a.getLayout() != null) goto L6;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L6:
        int r4 = r3 - 1;
        ConstraintLayout.LayoutParams r5 = null;
        if ((r1.left - r0.left) > this.a.getPaint().measureText(StringsKt.replace$default(r2.substring(this.a.getLayout().getLineStart(r4), this.a.getLayout().getLineEnd(r4)), "<doc.at.~#_%=`>", "     ", false, 4, null))) goto L15;
        View r6 = this.b;
        ConstraintLayout.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r8 = r7;
    L12:
        if (r8 == null) goto L14;
        r8.topToBottom = 2131390399;
        r8.bottomToBottom = -1;
        r5 = r8;
    L14:
        r6.setLayoutParams(r5);
    L22:
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L11:
        r8 = null;
        goto L12
    L15:
        View r9 = this.b;
        ConstraintLayout.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        ConstraintLayout.LayoutParams r11 = r10;
    L19:
        if (r11 == null) goto L21;
        r11.bottomToBottom = 2131390399;
        r11.topToBottom = -1;
        r5 = r11;
    L21:
        r9.setLayoutParams(r5);
        goto L22
    L18:
        r11 = null;
        goto L19
    }

    public p(TextView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
