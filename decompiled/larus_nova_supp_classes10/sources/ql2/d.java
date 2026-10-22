package ql2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import ql2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class d<T extends d> implements PopupWindow.OnDismissListener {
    public PopupWindow a;
    public Context b;
    public View c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public View i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;

    public final void a() {
        if (this.a != null) goto L5;
        this.a = new PopupWindow();
    L5:
        View r0 = this.c;
        if (r0 == null) goto L41;
        this.a.setContentView(r0);
        int r1 = this.e;
        if (r1 > 0) goto L13;
        if (r1 == (-2)) goto L13;
        if (r1 == (-1)) goto L13;
        this.a.setWidth(-2);
    L14:
        int r2 = this.f;
        if (r2 > 0) goto L20;
        if (r2 == (-2)) goto L20;
        if (r2 == (-1)) goto L20;
        this.a.setHeight(-2);
    L21:
        View r3 = d();
        if (this.e > 0) goto L24;
    L25:
        r3.measure(0, 0);
        if (this.e > 0) goto L29;
        this.e = r3.getMeasuredWidth();
    L29:
        if (this.f > 0) goto L31;
        this.f = r3.getMeasuredHeight();
    L31:
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        this.a.setInputMethodMode(0);
        this.a.setSoftInputMode(1);
        e r4 = (e) this;
        int r5 = this.g;
        if (r5 == 0) goto L35;
        this.a.setAnimationStyle(r5);
    L35:
        if (this.h == true) goto L37;
        this.a.setTouchable(true);
        this.a.setFocusable(true);
        this.a.setOutsideTouchable(false);
        this.a.setBackgroundDrawable(null);
        this.a.getContentView().setFocusable(true);
        this.a.getContentView().setFocusableInTouchMode(true);
        this.a.getContentView().setOnKeyListener(new a(this));
        this.a.setTouchInterceptor(new b(this));
    L38:
        this.a.setOnDismissListener(this);
        return;
    L37:
        this.a.setTouchable(true);
        this.a.setFocusable(this.d);
        this.a.setOutsideTouchable(true);
        this.a.setBackgroundDrawable(new ColorDrawable(0));
        goto L38
    L24:
        if (this.f > 0) goto L31;
    L20:
        this.a.setHeight(r2);
    L13:
        this.a.setWidth(r1);
        goto L14
    L41:
        throw new IllegalArgumentException("The content view is null,the layoutId=0,appContext=" + this.b);
    }

    public final View d() {
        PopupWindow r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContentView();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        PopupWindow r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        PopupWindow r1 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        return;
    }

    public d() {
        this.d = true;
        this.e = -2;
        this.f = -2;
        this.h = true;
        this.j = 2;
        this.k = 1;
        this.n = false;
        this.o = false;
    }

    public static int b(View r2, int r3, int r4, int r5) {
        if (r3 != 0) goto L5;
        int r6 = (r2.getWidth() / 2) - (r4 / 2);
    L15:
        return r5 + r6;
    L5:
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L8;
        r6 = r2.getWidth();
        goto L15
    L8:
        if (r3 != 4) goto L17;
        r4 = r4 - r2.getWidth();
        goto L16
    L17:
        return r5;
    L16:
        return r5 - r4;
    }

    public static int c(View r1, int r2, int r3, int r4) {
        if (r2 != 0) goto L4;
        int r5 = (r1.getHeight() / 2) + (r3 / 2);
    L15:
        return r4 - r5;
    L4:
        if (r2 != 1) goto L6;
        r3 = r3 + r1.getHeight();
    L16:
        return r4 - r3;
    L6:
        if (r2 != 3) goto L8;
        r5 = r1.getHeight();
        goto L15
    L8:
        if (r2 == 4) goto L16;
        return r4;
    }

    public final void e(View r3, int r4, int r5, int r6, int r7) {
        if (this.o == true) goto L6;
        this.o = true;
    L6:
        if (this.a != null) goto L8;
        a();
    L8:
        this.i = r3;
        this.l = r6;
        this.m = r7;
        this.j = r4;
        this.k = r5;
        int r8 = b(r3, r5, this.e, r6);
        int r9 = c(r3, r4, this.f, this.m);
        if (this.n == false) goto L11;
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
    L11:
        PopupWindowCompat.showAsDropDown(this.a, r3, r8, r9, 0);
    }
}
