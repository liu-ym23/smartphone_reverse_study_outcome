package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends ScrollingMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f194656a = null;

    static {
        f194656a = new b();
    }

    public b() {
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r110) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r110 == null) goto L21;
        boolean r102 = super.onTouchEvent(r100, r101, r110);
        if (r110.getAction() != 1) goto L20;
        if (r102 == true) goto L20;
        int r103 = (int) r110.getX();
        int r111 = (int) r110.getY();
        int r104 = r103 - r100.getTotalPaddingLeft();
        int r112 = r111 - r100.getTotalPaddingTop();
        int r105 = r104 + r100.getScrollX();
        int r113 = r112 + r100.getScrollY();
        Layout r106 = r100.getLayout();
        int r114 = r106.getLineForVertical(r113);
        float r107 = r105;
        int r108 = r106.getOffsetForHorizontal(r114, r107);
        ClickableSpan[] r109 = (ClickableSpan[]) r101.getSpans(r108, r108, ClickableSpan.class);
        if (r109.length != 0) goto L13;
        boolean r115 = true;
    L15:
        if ((!r115) == false) goto L20;
        if (r107 > r100.getPaint().measureText(r100.getText().subSequence(r106.getLineStart(r114), r106.getLineEnd(r114)).toString())) goto L20;
        r109[0].onClick(r100);
        return true;
    L13:
        r115 = false;
    L20:
        return r102;
    L21:
        return false;
    }
}
