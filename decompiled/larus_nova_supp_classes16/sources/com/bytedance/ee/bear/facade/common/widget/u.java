package com.bytedance.ee.bear.facade.common.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u extends LinkMovementMethod {
    public static u b;
    public long a;

    public static u a() {
        if (b != null) goto L6;
        b = new u();
    L6:
        return b;
    }

    public u() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r9, Spannable r10, MotionEvent r11) {
        int r0 = r11.getAction();
        if (r0 == 1) goto L5;
        if (r0 == 0) goto L5;
    L21:
        return super.onTouchEvent(r9, r10, r11);
    L5:
        int r2 = (int) r11.getX();
        int r3 = (int) r11.getY();
        int r4 = r2 - r9.getTotalPaddingLeft();
        int r5 = r3 - r9.getTotalPaddingTop();
        int r6 = r4 + r9.getScrollX();
        int r7 = r5 + r9.getScrollY();
        Layout r8 = r9.getLayout();
        int r12 = r8.getLineForVertical(r7);
        float r13 = r6;
        int r14 = r8.getOffsetForHorizontal(r12, r13);
        ClickableSpan[] r16 = (ClickableSpan[]) r10.getSpans(r14, r14, ClickableSpan.class);
        if (r16.length != 0) goto L8;
        Selection.removeSelection(r10);
        goto L21
    L8:
        if (r0 == 1) goto L10;
        Selection.setSelection(r10, r10.getSpanStart(r16[0]), r10.getSpanEnd(r16[0]));
        this.a = System.currentTimeMillis();
    L18:
        return true;
    L10:
        if (r13 <= r8.getLineRight(r12)) goto L12;
        boolean r17 = true;
    L13:
        tt5.a.b("LinkMovementClickMethod", "touch area: " + r17);
        if ((System.currentTimeMillis() - this.a) >= 500) goto L18;
        if (r17 == true) goto L18;
        r16[0].onClick(r9);
        goto L18
    L12:
        r17 = false;
        goto L13
    }
}
