package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends BaseMovementMethod {
    public static a a;

    public a() {
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r7, Spannable r8, MotionEvent r9) {
        int r0 = r9.getAction();
        if (r0 == 1) goto L5;
        if (r0 == 0) goto L5;
    L11:
        return true;
    L5:
        int r2 = (int) r9.getX();
        int r10 = (int) r9.getY();
        int r3 = r2 - r7.getTotalPaddingLeft();
        int r11 = r10 - r7.getTotalPaddingTop();
        int r4 = r3 + r7.getScrollX();
        int r12 = r11 + r7.getScrollY();
        Layout r5 = r7.getLayout();
        int r13 = r5.getLineForVertical(r12);
        float r6 = r4;
        int r14 = r5.getOffsetForHorizontal(r13, r6);
        ClickableSpan[] r15 = (ClickableSpan[]) r8.getSpans(r14, r14, ClickableSpan.class);
        if (r15.length == 0) goto L11;
        if (r0 != 1) goto L11;
        if (r6 > r7.getPaint().measureText(r7.getText().subSequence(r5.getLineStart(r13), r5.getLineEnd(r13)).toString())) goto L11;
        r15[0].onClick(r7);
        goto L11
    }
}
