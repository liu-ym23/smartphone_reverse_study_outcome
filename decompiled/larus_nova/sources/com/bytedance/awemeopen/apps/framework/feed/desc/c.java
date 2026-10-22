package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends BaseMovementMethod {
    public c() {
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        int r103 = r102.getAction();
        if (r103 == 1) goto L5;
        if (r103 == 0) goto L5;
    L9:
        return true;
    L5:
        int r104 = (int) r102.getX();
        int r105 = (int) r102.getY();
        int r106 = r104 - r100.getTotalPaddingLeft();
        int r107 = r105 - r100.getTotalPaddingTop();
        int r108 = r106 + r100.getScrollX();
        int r109 = r107 + r100.getScrollY();
        Layout r110 = r100.getLayout();
        int r111 = r110.getOffsetForHorizontal(r110.getLineForVertical(r109), r108);
        ClickableSpan[] r112 = (ClickableSpan[]) r101.getSpans(r111, r111, ClickableSpan.class);
        if (r112.length == 0) goto L9;
        if (r103 != 1) goto L9;
        r112[0].onClick(r100);
        goto L9
    }
}
