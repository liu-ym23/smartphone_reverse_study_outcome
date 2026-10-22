package yo2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import yo2.d;

/* JADX INFO: loaded from: classes11.dex */
public abstract class d<T extends d> implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePopupWindow f568639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.popup.manager.c f568640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f568641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f568642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f568643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f568644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f568645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f568646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f568647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f568648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f568649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f568650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f568651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f568652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f568653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f568654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f568655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f568656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f568657s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f568658t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f568659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f568660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f568661w;

    public abstract void f();

    public abstract void g(View r100, T r101);

    public final void a() {
        if (this.f568639a != null) goto L5;
        this.f568639a = new LivePopupWindow();
    L5:
        f();
        if (this.f568642d == null) goto L8;
    L14:
        this.f568639a.setContentView(this.f568642d);
        int r100 = this.f568646h;
        if (r100 > 0) goto L20;
        if (r100 == (-2)) goto L20;
        if (r100 == (-1)) goto L20;
        this.f568639a.setWidth(-2);
    L21:
        int r101 = this.f568647i;
        if (r101 > 0) goto L27;
        if (r101 == (-2)) goto L27;
        if (r101 == (-1)) goto L27;
        this.f568639a.setHeight(-2);
    L28:
        View r102 = e();
        if (this.f568646h > 0) goto L31;
    L32:
        r102.measure(0, 0);
        if (this.f568646h > 0) goto L36;
        this.f568646h = r102.getMeasuredWidth();
    L36:
        if (this.f568647i > 0) goto L38;
        this.f568647i = r102.getMeasuredHeight();
    L38:
        e().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        this.f568639a.setInputMethodMode(0);
        this.f568639a.setSoftInputMode(this.f568659u);
        g(this.f568642d, this);
        int r103 = this.f568648j;
        if (r103 == 0) goto L41;
        this.f568639a.setAnimationStyle(r103);
    L41:
        LivePopupWindow r104 = this.f568639a;
        r104.f156289d = this.f568651m;
        r104.f156288c = this.f568652n;
        r104.f156287b = this.f568653o;
        com.bytedance.android.livesdk.popup.manager.c r105 = this.f568640b;
        if (r105 == null) goto L45;
        r104.f156290e = r105;
    L45:
        if (this.f568650l == true) goto L47;
        r104.setFocusable(true);
        this.f568639a.setOutsideTouchable(false);
        this.f568639a.setBackgroundDrawable(null);
        this.f568639a.getContentView().setFocusable(true);
        this.f568639a.getContentView().setFocusableInTouchMode(true);
        this.f568639a.getContentView().setOnKeyListener(new a(this));
        this.f568639a.setTouchInterceptor(new b(this));
    L48:
        this.f568639a.setOnDismissListener(this);
        return;
    L47:
        r104.setFocusable(this.f568644f);
        this.f568639a.setOutsideTouchable(this.f568645g);
        this.f568639a.setBackgroundDrawable(new ColorDrawable(0));
        goto L48
    L31:
        if (this.f568647i > 0) goto L38;
    L27:
        this.f568639a.setHeight(r101);
    L20:
        this.f568639a.setWidth(r100);
        goto L21
    L8:
        if (this.f568643e == 0) goto L13;
        Context r106 = this.f568641c;
        if (r106 == null) goto L13;
        this.f568642d = LayoutInflater.from(r106).inflate(this.f568643e, null);
    L13:
        throw new IllegalArgumentException("The content view is null,the layoutId=" + this.f568643e + ",appContext=" + this.f568641c);
    }

    public void d() {
        LivePopupWindow r100 = this.f568639a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        LivePopupWindow r101 = this.f568639a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    }

    public final View e() {
        LivePopupWindow r100 = this.f568639a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContentView();
    }

    public final boolean h() {
        LivePopupWindow r100 = this.f568639a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() == false) goto L7;
        return true;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        PopupWindow.OnDismissListener r100 = this.f568649k;
        if (r100 == null) goto L5;
        r100.onDismiss();
    L5:
        LivePopupWindow r101 = this.f568639a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isShowing() == false) goto L12;
        LivePopupWindow r102 = this.f568639a;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
        return;
    }

    public d() {
        this.f568644f = true;
        this.f568645g = true;
        this.f568646h = -2;
        this.f568647i = -2;
        this.f568650l = true;
        this.f568651m = 0;
        this.f568652n = false;
        this.f568653o = 1;
        this.f568655q = 2;
        this.f568656r = 1;
        this.f568659u = 1;
        this.f568660v = false;
        this.f568661w = false;
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

    public final void i(View r100, int r101, int r102, int r103, int r104) {
        if (this.f568661w == true) goto L6;
        this.f568661w = true;
    L6:
        if (this.f568639a != null) goto L8;
        a();
    L8:
        this.f568654p = r100;
        this.f568657s = r103;
        this.f568658t = r104;
        this.f568655q = r101;
        this.f568656r = r102;
        int r105 = b(r100, r102, this.f568646h, r103);
        int r106 = c(r100, r101, this.f568647i, this.f568658t);
        if (this.f568660v == false) goto L11;
        e().getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
    L11:
        LivePopupWindow r107 = this.f568639a;
        OverlaySource r108 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r107, r100, r108) == true) goto L16;
        r107.showAsDropDown(r100, r105, r106, 0);
        PopupWindowLancet.trackAfterShow(r107, r108, r100);
        return;
    }
}
