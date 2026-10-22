package dv;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.gamecp.common.ui.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import dv.d;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d<T extends d> implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePopupWindow f470087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f470088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f470089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f470090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f470091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f470092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f470093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f470094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f470095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f470096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f470097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f470098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f470099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f470100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f470101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f470102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f470103q;

    public final void a() {
        if (this.f470087a != null) goto L5;
        this.f470087a = new LivePopupWindow();
    L5:
        View r100 = this.f470089c;
        if (r100 == null) goto L38;
        this.f470087a.setContentView(r100);
        int r101 = this.f470092f;
        if (r101 > 0) goto L13;
        if (r101 == (-2)) goto L13;
        if (r101 == (-1)) goto L13;
        this.f470087a.setWidth(-2);
    L14:
        int r102 = this.f470093g;
        if (r102 > 0) goto L20;
        if (r102 == (-2)) goto L20;
        if (r102 == (-1)) goto L20;
        this.f470087a.setHeight(-2);
    L21:
        View r103 = d();
        if (this.f470092f > 0) goto L24;
    L25:
        r103.measure(0, 0);
        if (this.f470092f > 0) goto L29;
        this.f470092f = r103.getMeasuredWidth();
    L29:
        if (this.f470093g > 0) goto L31;
        this.f470093g = r103.getMeasuredHeight();
    L31:
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        this.f470087a.setInputMethodMode(0);
        this.f470087a.setSoftInputMode(1);
        e r104 = (e) this;
        LivePopupWindow r105 = this.f470087a;
        r105.f57035c = this.f470095i;
        r105.f57034b = this.f470096j;
        if (this.f470094h == true) goto L34;
        r105.setFocusable(true);
        this.f470087a.setOutsideTouchable(false);
        this.f470087a.setBackgroundDrawable(null);
        this.f470087a.getContentView().setFocusable(true);
        this.f470087a.getContentView().setFocusableInTouchMode(true);
        this.f470087a.getContentView().setOnKeyListener(new a(this));
        this.f470087a.setTouchInterceptor(new b(this));
    L35:
        this.f470087a.setOnDismissListener(this);
        return;
    L34:
        r105.setFocusable(this.f470090d);
        this.f470087a.setOutsideTouchable(this.f470091e);
        this.f470087a.setBackgroundDrawable(new ColorDrawable(0));
        goto L35
    L24:
        if (this.f470093g > 0) goto L31;
    L20:
        this.f470087a.setHeight(r102);
    L13:
        this.f470087a.setWidth(r101);
        goto L14
    L38:
        throw new IllegalArgumentException("The content view is null,the layoutId=0,appContext=" + this.f470088b);
    }

    public final View d() {
        LivePopupWindow r100 = this.f470087a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContentView();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        LivePopupWindow r100 = this.f470087a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        LivePopupWindow r101 = this.f470087a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    }

    public d() {
        this.f470090d = true;
        this.f470091e = true;
        this.f470092f = -2;
        this.f470093g = -2;
        this.f470094h = true;
        this.f470095i = 0;
        this.f470096j = 1;
        this.f470098l = 2;
        this.f470099m = 1;
        this.f470102p = false;
        this.f470103q = false;
    }

    public final void e(View r100) {
        if (this.f470103q == true) goto L6;
        this.f470103q = true;
    L6:
        if (this.f470087a != null) goto L8;
        a();
    L8:
        this.f470097k = r100;
        this.f470100n = 0;
        this.f470101o = 0;
        this.f470098l = 2;
        this.f470099m = 0;
        int r101 = b(r100, 0, this.f470092f, 0);
        int r102 = c(r100, 2, this.f470093g, this.f470101o);
        if (this.f470102p == false) goto L11;
        d().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
    L11:
        LivePopupWindow r103 = this.f470087a;
        OverlaySource r104 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r103, r100, r104) == true) goto L16;
        r103.showAsDropDown(r100, r101, r102, 0);
        PopupWindowLancet.trackAfterShow(r103, r104, r100);
        return;
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
}
