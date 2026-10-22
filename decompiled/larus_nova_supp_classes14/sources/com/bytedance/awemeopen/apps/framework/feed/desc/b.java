package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends ScrollingMovementMethod {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r8, Spannable r9, MotionEvent r10) {
        if (r8 == null) goto L21;
        if (r9 == null) goto L21;
        if (r10 == null) goto L21;
        boolean r1 = super.onTouchEvent(r8, r9, r10);
        if (r10.getAction() != 1) goto L20;
        if (r1 == true) goto L20;
        int r2 = (int) r10.getX();
        int r11 = (int) r10.getY();
        int r3 = r2 - r8.getTotalPaddingLeft();
        int r12 = r11 - r8.getTotalPaddingTop();
        int r4 = r3 + r8.getScrollX();
        int r13 = r12 + r8.getScrollY();
        Layout r5 = r8.getLayout();
        int r14 = r5.getLineForVertical(r13);
        float r6 = r4;
        int r7 = r5.getOffsetForHorizontal(r14, r6);
        ClickableSpan[] r15 = (ClickableSpan[]) r9.getSpans(r7, r7, ClickableSpan.class);
        if (r15.length != 0) goto L13;
        boolean r16 = true;
    L15:
        if ((!r16) == false) goto L20;
        if (r6 > r8.getPaint().measureText(r8.getText().subSequence(r5.getLineStart(r14), r5.getLineEnd(r14)).toString())) goto L20;
        r15[0].onClick(r8);
        return true;
    L13:
        r16 = false;
    L20:
        return r1;
    L21:
        return false;
    }
}
