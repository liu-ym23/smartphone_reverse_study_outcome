package com.larksuite.component.card.component;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends LinkMovementMethod {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f283366b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f283367a;

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean bottom(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean down(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean left(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineEnd(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean lineStart(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageDown(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean pageUp(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean right(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean top(TextView r100, Spannable r101) {
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public final boolean up(TextView r100, Spannable r101) {
        return false;
    }

    public e() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r110) {
        int r102 = r110.getAction();
        if (r102 == 1) goto L7;
        if (r102 == 0) goto L7;
        return false;
    L7:
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
        if (r109.length == 0) goto L22;
        if (r102 == 1) goto L11;
        this.f283367a = System.currentTimeMillis();
    L21:
        return true;
    L11:
        if (r114 == (r100.getLineCount() - 1)) goto L13;
    L15:
        boolean r115 = false;
    L16:
        Log.d("CardSpanMovementClickMethod", "touch area: " + r115);
        if ((System.currentTimeMillis() - this.f283367a) >= 500) goto L21;
        if (r115 == true) goto L21;
        r109[0].onClick(r100);
        goto L21
    L13:
        if (r107 <= r106.getLineRight(r100.getLineCount() - 1)) goto L15;
        r115 = true;
        goto L16
    L22:
        return false;
    }
}
