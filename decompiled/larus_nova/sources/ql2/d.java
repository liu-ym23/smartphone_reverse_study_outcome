package ql2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import ql2.d;

/* JADX INFO: loaded from: classes10.dex */
public abstract class d<T extends d> implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f533725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f533726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f533727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f533728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f533729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f533730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f533731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f533732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f533733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f533734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f533735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f533736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f533737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f533738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f533739o;

    public final void a() {
        if (this.f533725a != null) goto L5;
        this.f533725a = new PopupWindow();
    L5:
        View r100 = this.f533727c;
        if (r100 == null) goto L41;
        this.f533725a.setContentView(r100);
        int r101 = this.f533729e;
        if (r101 > 0) goto L13;
        if (r101 == (-2)) goto L13;
        if (r101 == (-1)) goto L13;
        this.f533725a.setWidth(-2);
    L14:
        int r102 = this.f533730f;
        if (r102 > 0) goto L20;
        if (r102 == (-2)) goto L20;
        if (r102 == (-1)) goto L20;
        this.f533725a.setHeight(-2);
    L21:
        View r103 = d();
        if (this.f533729e > 0) goto L24;
    L25:
        r103.measure(0, 0);
        if (this.f533729e > 0) goto L29;
        this.f533729e = r103.getMeasuredWidth();
    L29:
        if (this.f533730f > 0) goto L31;
        this.f533730f = r103.getMeasuredHeight();
    L31:
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        this.f533725a.setInputMethodMode(0);
        this.f533725a.setSoftInputMode(1);
        e r104 = (e) this;
        int r105 = this.f533731g;
        if (r105 == 0) goto L35;
        this.f533725a.setAnimationStyle(r105);
    L35:
        if (this.f533732h == true) goto L37;
        this.f533725a.setTouchable(true);
        this.f533725a.setFocusable(true);
        this.f533725a.setOutsideTouchable(false);
        this.f533725a.setBackgroundDrawable(null);
        this.f533725a.getContentView().setFocusable(true);
        this.f533725a.getContentView().setFocusableInTouchMode(true);
        this.f533725a.getContentView().setOnKeyListener(new a(this));
        this.f533725a.setTouchInterceptor(new b(this));
    L38:
        this.f533725a.setOnDismissListener(this);
        return;
    L37:
        this.f533725a.setTouchable(true);
        this.f533725a.setFocusable(this.f533728d);
        this.f533725a.setOutsideTouchable(true);
        this.f533725a.setBackgroundDrawable(new ColorDrawable(0));
        goto L38
    L24:
        if (this.f533730f > 0) goto L31;
    L20:
        this.f533725a.setHeight(r102);
    L13:
        this.f533725a.setWidth(r101);
        goto L14
    L41:
        throw new IllegalArgumentException("The content view is null,the layoutId=0,appContext=" + this.f533726b);
    }

    public final View d() {
        PopupWindow r100 = this.f533725a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContentView();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        PopupWindow r100 = this.f533725a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        PopupWindow r101 = this.f533725a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    }

    public d() {
        this.f533728d = true;
        this.f533729e = -2;
        this.f533730f = -2;
        this.f533732h = true;
        this.f533734j = 2;
        this.f533735k = 1;
        this.f533738n = false;
        this.f533739o = false;
    }

    public static int b(View r100, int r101, int r102, int r103) {
        if (r101 != 0) goto L5;
        int r104 = (r100.getWidth() / 2) - (r102 / 2);
    L15:
        return r103 + r104;
    L5:
        if (r101 == 1) goto L16;
        if (r101 != 2) goto L8;
        r104 = r100.getWidth();
        goto L15
    L8:
        if (r101 != 4) goto L17;
        r102 = r102 - r100.getWidth();
        goto L16
    L17:
        return r103;
    L16:
        return r103 - r102;
    }

    public static int c(View r100, int r101, int r102, int r103) {
        if (r101 != 0) goto L4;
        int r104 = (r100.getHeight() / 2) + (r102 / 2);
    L15:
        return r103 - r104;
    L4:
        if (r101 != 1) goto L6;
        r102 = r102 + r100.getHeight();
    L16:
        return r103 - r102;
    L6:
        if (r101 != 3) goto L8;
        r104 = r100.getHeight();
        goto L15
    L8:
        if (r101 == 4) goto L16;
        return r103;
    }

    public final void e(View r100, int r101, int r102, int r103, int r104) {
        if (this.f533739o == true) goto L6;
        this.f533739o = true;
    L6:
        if (this.f533725a != null) goto L8;
        a();
    L8:
        this.f533733i = r100;
        this.f533736l = r103;
        this.f533737m = r104;
        this.f533734j = r101;
        this.f533735k = r102;
        int r105 = b(r100, r102, this.f533729e, r103);
        int r106 = c(r100, r101, this.f533730f, this.f533737m);
        if (this.f533738n == false) goto L11;
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
    L11:
        PopupWindowCompat.showAsDropDown(this.f533725a, r100, r105, r106, 0);
    }
}
