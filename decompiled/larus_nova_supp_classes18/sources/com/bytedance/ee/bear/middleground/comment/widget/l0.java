package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 extends ArrowKeyMovementMethod {
    public final boolean a;
    public boolean b;
    public float c;
    public float d;
    public float e;

    public l0() {
        this.a = true;
        this.e = 0.0f;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r10, Spannable r11, MotionEvent r12) {
        int r0 = r12.getAction();
        if (r0 == 1) goto L22;
        if (r0 == 0) goto L22;
        if (this.a == false) goto L21;
        if (r0 != 0) goto L11;
        this.c = r12.getX();
        this.d = r12.getY();
        this.b = false;
        goto L21
    L11:
        if (r12.getAction() != 2) goto L21;
        float r1 = r12.getX();
        float r2 = r12.getY();
        Context r3 = r10.getContext();
        if (this.e != 0.0f) goto L16;
        this.e = ViewConfiguration.get(r3).getScaledTouchSlop();
    L16:
        if (Math.abs(this.c - r1) <= this.e) goto L18;
    L19:
        this.b = true;
        goto L21
    L18:
        if (Math.abs(this.d - r2) > this.e) goto L19;
    L21:
        return super.onTouchEvent(r10, r11, r12);
    L22:
        int r4 = (int) r12.getX();
        int r5 = (int) r12.getY();
        int r6 = r4 - r10.getTotalPaddingLeft();
        int r7 = r5 - r10.getTotalPaddingTop();
        int r8 = r6 + r10.getScrollX();
        int r9 = r7 + r10.getScrollY();
        Layout r13 = r10.getLayout();
        int r14 = r13.getLineForVertical(r9);
        float r15 = r8;
        int r16 = r13.getOffsetForHorizontal(r14, r15);
        ClickableSpan[] r17 = (ClickableSpan[]) r11.getSpans(r16, r16, ClickableSpan.class);
        if (r17.length == 0) goto L40;
        ClickableSpan r18 = r17[0];
        if (r0 != 1) goto L47;
        if (r11.getSpanEnd(r18) != r16) goto L29;
        boolean r19 = true;
    L31:
        if (r14 == (r10.getLineCount() - 1)) goto L33;
    L35:
        boolean r20 = false;
    L36:
        if (r19 == true) goto L39;
        if (r20 == true) goto L39;
        r18.onClick(r10);
        r10.setEnabled(false);
        r10.setSelected(false);
        rcb.e.a.post(new k0(r10));
    L39:
        rcb.c.g(r10.getContext());
        goto L47
    L33:
        if (r15 <= r13.getLineRight(r14)) goto L35;
        r20 = true;
        goto L36
    L29:
        r19 = false;
    L47:
        if (this.a == false) goto L54;
        if (Selection.getSelectionStart(r11) != (-1)) goto L57;
        if (r11.length() != 0) goto L57;
        Selection.setSelection(r11, 0);
    L57:
        if (this.a == false) goto L59;
        Touch.onTouchEvent(r10, r11, r12);
    L59:
        return true;
    L54:
        if (Selection.getSelectionStart(r11) != (-1)) goto L57;
        Selection.setSelection(r11, r11.length());
        goto L57
    L40:
        if (r0 != 1) goto L47;
        if (this.a == true) goto L44;
    L45:
        rcb.c.g(r10.getContext());
        goto L47
    L44:
        if (this.b == true) goto L47;
        goto L45
    }
}
