package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends BaseMovementMethod {
    public c() {
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r5, Spannable r6, MotionEvent r7) {
        int r0 = r7.getAction();
        if (r0 == 1) goto L5;
        if (r0 == 0) goto L5;
    L9:
        return true;
    L5:
        int r2 = (int) r7.getX();
        int r8 = (int) r7.getY();
        int r3 = r2 - r5.getTotalPaddingLeft();
        int r9 = r8 - r5.getTotalPaddingTop();
        int r4 = r3 + r5.getScrollX();
        int r10 = r9 + r5.getScrollY();
        Layout r11 = r5.getLayout();
        int r12 = r11.getOffsetForHorizontal(r11.getLineForVertical(r10), r4);
        ClickableSpan[] r13 = (ClickableSpan[]) r6.getSpans(r12, r12, ClickableSpan.class);
        if (r13.length == 0) goto L9;
        if (r0 != 1) goto L9;
        r13[0].onClick(r5);
        goto L9
    }
}
