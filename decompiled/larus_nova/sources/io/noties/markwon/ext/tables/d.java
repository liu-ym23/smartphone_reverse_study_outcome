package io.noties.markwon.ext.tables;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MovementMethod f492508a;

    @Override // android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return this.f492508a.canSelectArbitrarily();
    }

    public d(btc.c r100) {
        this.f492508a = r100;
    }

    @Override // android.text.method.MovementMethod
    public final void initialize(TextView r100, Spannable r101) {
        this.f492508a.initialize(r100, r101);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onGenericMotionEvent(TextView r100, Spannable r101, MotionEvent r102) {
        return this.f492508a.onGenericMotionEvent(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyOther(TextView r100, Spannable r101, KeyEvent r102) {
        return this.f492508a.onKeyOther(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final void onTakeFocus(TextView r100, Spannable r101, int r102) {
        this.f492508a.onTakeFocus(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r110) {
        if (this.f492508a.onTouchEvent(r100, r101, r110) == false) goto L5;
        return true;
    L5:
        if (r110.getAction() == 1) goto L7;
    L6:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L20;
        return false;
    L20:
        return true;
    L7:
        int r103 = (int) r110.getX();
        int r111 = (int) r110.getY();
        int r104 = r103 - r100.getTotalPaddingLeft();
        int r112 = r111 - r100.getTotalPaddingTop();
        int r105 = r104 + r100.getScrollX();
        int r113 = r112 + r100.getScrollY();
        Layout r106 = r100.getLayout();
        int r107 = r106.getLineForVertical(r113);
        int r108 = r106.getOffsetForHorizontal(r107, r105);
        a[] r109 = (a[]) r101.getSpans(r108, r108, a.class);
        if (r109.length == 0) goto L6;
        ClickableSpan[] r114 = (ClickableSpan[]) r109[0].a(r105, r113 - r106.getLineTop(r107), ClickableSpan.class);
        if (r114 == null) goto L6;
        if (r114.length <= 0) goto L6;
        r114[0].onClick(r100);
        r102 = true;
        goto L15
    }

    @Override // android.text.method.MovementMethod
    public final boolean onTrackballEvent(TextView r100, Spannable r101, MotionEvent r102) {
        return this.f492508a.onTrackballEvent(r100, r101, r102);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyDown(TextView r100, Spannable r101, int r102, KeyEvent r103) {
        return this.f492508a.onKeyDown(r100, r101, r102, r103);
    }

    @Override // android.text.method.MovementMethod
    public final boolean onKeyUp(TextView r100, Spannable r101, int r102, KeyEvent r103) {
        return this.f492508a.onKeyUp(r100, r101, r102, r103);
    }
}
