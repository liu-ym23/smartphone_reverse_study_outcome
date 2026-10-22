package com.bytedance.ee.bear.facade.common.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes16.dex */
public final class u extends LinkMovementMethod {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static u f226725b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f226726a;

    public static u a() {
        if (f226725b != null) goto L6;
        f226725b = new u();
    L6:
        return f226725b;
    }

    public u() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r110, MotionEvent r111) {
        int r101 = r111.getAction();
        if (r101 == 1) goto L5;
        if (r101 == 0) goto L5;
    L21:
        return super.onTouchEvent(r100, r110, r111);
    L5:
        int r102 = (int) r111.getX();
        int r103 = (int) r111.getY();
        int r104 = r102 - r100.getTotalPaddingLeft();
        int r105 = r103 - r100.getTotalPaddingTop();
        int r106 = r104 + r100.getScrollX();
        int r107 = r105 + r100.getScrollY();
        Layout r108 = r100.getLayout();
        int r109 = r108.getLineForVertical(r107);
        float r112 = r106;
        int r113 = r108.getOffsetForHorizontal(r109, r112);
        ClickableSpan[] r114 = (ClickableSpan[]) r110.getSpans(r113, r113, ClickableSpan.class);
        if (r114.length != 0) goto L8;
        Selection.removeSelection(r110);
        goto L21
    L8:
        if (r101 == 1) goto L10;
        Selection.setSelection(r110, r110.getSpanStart(r114[0]), r110.getSpanEnd(r114[0]));
        this.f226726a = System.currentTimeMillis();
    L18:
        return true;
    L10:
        if (r112 <= r108.getLineRight(r109)) goto L12;
        boolean r115 = true;
    L13:
        tt5.a.b("LinkMovementClickMethod", "touch area: " + r115);
        if ((System.currentTimeMillis() - this.f226726a) >= 500) goto L18;
        if (r115 == true) goto L18;
        r114[0].onClick(r100);
        goto L18
    L12:
        r115 = false;
        goto L13
    }
}
