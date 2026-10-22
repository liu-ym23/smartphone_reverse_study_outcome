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

/* JADX INFO: loaded from: classes18.dex */
public final class l0 extends ArrowKeyMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f232345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f232346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f232347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f232348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f232349e;

    public l0() {
        this.f232345a = true;
        this.f232349e = 0.0f;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(final TextView r110, Spannable r111, MotionEvent r112) {
        int r100 = r112.getAction();
        if (r100 == 1) goto L22;
        if (r100 == 0) goto L22;
        if (this.f232345a == false) goto L21;
        if (r100 != 0) goto L11;
        this.f232347c = r112.getX();
        this.f232348d = r112.getY();
        this.f232346b = false;
        goto L21
    L11:
        if (r112.getAction() != 2) goto L21;
        float r101 = r112.getX();
        float r102 = r112.getY();
        Context r103 = r110.getContext();
        if (this.f232349e != 0.0f) goto L16;
        this.f232349e = ViewConfiguration.get(r103).getScaledTouchSlop();
    L16:
        if (Math.abs(this.f232347c - r101) <= this.f232349e) goto L18;
    L19:
        this.f232346b = true;
        goto L21
    L18:
        if (Math.abs(this.f232348d - r102) > this.f232349e) goto L19;
    L21:
        return super.onTouchEvent(r110, r111, r112);
    L22:
        int r104 = (int) r112.getX();
        int r105 = (int) r112.getY();
        int r106 = r104 - r110.getTotalPaddingLeft();
        int r107 = r105 - r110.getTotalPaddingTop();
        int r108 = r106 + r110.getScrollX();
        int r109 = r107 + r110.getScrollY();
        Layout r113 = r110.getLayout();
        int r114 = r113.getLineForVertical(r109);
        float r115 = r108;
        int r116 = r113.getOffsetForHorizontal(r114, r115);
        ClickableSpan[] r117 = (ClickableSpan[]) r111.getSpans(r116, r116, ClickableSpan.class);
        if (r117.length == 0) goto L40;
        ClickableSpan r118 = r117[0];
        if (r100 != 1) goto L47;
        if (r111.getSpanEnd(r118) != r116) goto L29;
        boolean r119 = true;
    L31:
        if (r114 == (r110.getLineCount() - 1)) goto L33;
    L35:
        boolean r120 = false;
    L36:
        if (r119 == true) goto L39;
        if (r120 == true) goto L39;
        r118.onClick(r110);
        r110.setEnabled(false);
        r110.setSelected(false);
        rcb.e.f537198a.post(new k0(r110));
    L39:
        rcb.c.g(r110.getContext());
        goto L47
    L33:
        if (r115 <= r113.getLineRight(r114)) goto L35;
        r120 = true;
        goto L36
    L29:
        r119 = false;
    L47:
        if (this.f232345a == false) goto L54;
        if (Selection.getSelectionStart(r111) != (-1)) goto L57;
        if (r111.length() != 0) goto L57;
        Selection.setSelection(r111, 0);
    L57:
        if (this.f232345a == false) goto L59;
        Touch.onTouchEvent(r110, r111, r112);
    L59:
        return true;
    L54:
        if (Selection.getSelectionStart(r111) != (-1)) goto L57;
        Selection.setSelection(r111, r111.length());
        goto L57
    L40:
        if (r100 != 1) goto L47;
        if (this.f232345a == true) goto L44;
    L45:
        rcb.c.g(r110.getContext());
        goto L47
    L44:
        if (this.f232346b == true) goto L47;
        goto L45
    }
}
