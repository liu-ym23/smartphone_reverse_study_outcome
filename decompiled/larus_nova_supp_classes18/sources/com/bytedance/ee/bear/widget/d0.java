package com.bytedance.ee.bear.widget;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.widgets.MaxHeightLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends kn4.a implements ocb.a {
    public final int d;
    public final MaxHeightLayout e;
    public final View f;
    public final FragmentActivity g;
    public View h;
    public View i;
    public final PopupWindow j;
    public final pcb.a k;
    public int l;
    public int m;

    public class a implements AtFinderView.b {
        public final /* synthetic */ AtFinderView a;
        public final /* synthetic */ d0 b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.widget.d0$a$a, reason: collision with other inner class name */
        public class RunnableC0199a implements Runnable {
            public final /* synthetic */ ViewGroup.LayoutParams a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams r0 = this.a;     // Catch: Throwable -> L8
                if (r0 == null) goto L11;
                a r1 = this.b;     // Catch: Throwable -> L8
                kn4.g.b r2 = ((kn4.a) r1.b).a;     // Catch: Throwable -> L8
                if (r2 == null) goto L15;
                r2.a(r0.height, r1.a.getHeight());     // Catch: Throwable -> L8
                return;
            L15:
                return;
            L11:
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }

            public RunnableC0199a(a r1, ViewGroup.LayoutParams r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        @Override // com.bytedance.ee.bear.widget.AtFinderView.b
        public final void a() {
            ViewGroup.LayoutParams r0 = this.b.f.getLayoutParams();
            this.a.post(new RunnableC0199a(this, r0));
        }

        public a(d0 r1, AtFinderView r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void close() {
        this.k.a(this);
        PopupWindow r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        ((kn4.a) this).b.a();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        PopupWindow r1 = this.j;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        goto L7
    }

    public final boolean isShowing() {
        return this.j.isShowing();
    }

    public final void j() {
        AtFinderView r0 = ((kn4.a) this).c;
        if (r0 == null) goto L5;
        r0.a();
        return;
    L5:
        tt5.a.d("AtWindowPopWindowImp", "closeFindView(): findView is null");
    }

    public final void show() {
        if (this.g != null) goto L6;
        return;
    L6:
        if (this.j.isShowing() == false) goto L8;
        return;
    L8:
        if (this.g.isFinishing() == false) goto L11;
        tt5.a.k("AtWindowPopWindowImp", "show: at fail casue activity.isFinishing");
        return;
    L11:
        kn4.g.b r0 = ((kn4.a) this).a;
        if (r0 == null) goto L14;
        r0.b(true);
    L14:
        ((kn4.a) this).b.c(true);
        int r1 = n();
        View r2 = this.i;
        if (r2 == null) goto L17;
        m(this.j, r2, r1);
    L18:
        o(this.k.getVisibleKeyboardHeight());
        kn4.f.b().a((FrameLayout) this.f);
        this.k.c(this);
        return;
    L17:
        m(this.j, l(this.g.getWindow()), r1);
        goto L18
    }

    public void update() {
        o(this.k.getVisibleKeyboardHeight());
        PopupWindow r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L17;
        int r1 = n();
        PopupWindow r2 = this.j;
        if ((r2 instanceof PopupWindow) == false) goto L12;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r2) == false) goto L12;
        r2.update(0, r1, -1, -2);
        return;
    L12:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r2, 0, r1, -1, -2) == true) goto L19;
        r2.update(0, r1, -1, -2);
        return;
    L19:
        return;
    }

    public final int n() {
        if (com.ss.android.lark.base.embedded.b.i() == false) goto L7;
        return this.l - this.d;
    L7:
        return this.l;
    }

    public static View l(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void d(View r1) {
        this.i = r1;
    }

    public final void e(int r1) {
        this.l = r1;
    }

    public final void f(kn4.g.a r4) {
        tt5.a.b("AtWindowPopWindowImp", "setSelectedCallback: ");
        com.bytedance.ee.bear.atfinder.c r0 = ((kn4.a) this).b;
        r0.d = new q(r0, r4, new a0(this));
    }

    public final void h(View r1) {
        this.h = r1;
    }

    public final void i(int r1) {
        this.m = r1;
    }

    public final void o(int r9) {
        Rect r0 = new Rect();
        View r1 = l(this.g.getWindow());
        r1.getWindowVisibleDisplayFrame(r0);
        int r2 = r1.getHeight();
        int r3 = this.g.getWindow().getAttributes().softInputMode & 240;
        boolean r5 = true;
        if (r3 != 16) goto L5;
    L8:
        boolean r4 = true;
    L9:
        int r6 = r0.height();
        if (r2 <= 0) goto L17;
        if (r6 <= 0) goto L17;
        if (r9 <= 0) goto L17;
        if (((r2 - r6) + Math.max(this.d, com.bytedance.ee.util.ui.n.d(24))) < r9) goto L17;
    L18:
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r8 = r7.g("ccm.bitable.big_screen_at_window_height");
        boolean r10 = r7.g("ccm.mobile.at_window_height_fix_enable");
        tt5.a.h("AtWindowPopWindowImp", "setContentViewParams, isHadSubtractKeyboardHeight:" + r4 + ", bigScreenAtWindowHeightFg:" + r8 + ", isVisibleFrameHadSubtractKeyboardHeight:" + r5);
        if (r4 == false) goto L21;
        if (r8 == false) goto L21;
    L23:
        r9 = 0;
    L24:
        int r11 = this.m;
        if (r11 == 0) goto L27;
    L29:
        if (r11 == 0) goto L31;
        int r12 = r0.height() - n();
        int r13 = this.m;
    L32:
        int r14 = (r12 - r13) - r9;
        if (com.bytedance.ee.util.ui.n.D(this.g) == true) goto L35;
    L36:
        r14 = r14 + this.d;
    L37:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) this.f.getLayoutParams();
        if (r15 != null) goto L40;
        r15 = new FrameLayout.LayoutParams(-1, -2);
    L40:
        this.e.setMaxHeight(r14);
        r15.height = r14;
        this.f.setLayoutParams(r15);
        return;
    L35:
        if (com.bytedance.ee.util.ui.k.g(this.g) == false) goto L37;
    L31:
        r12 = r0.height();
        r13 = n();
        goto L32
    L27:
        if (this.h == null) goto L29;
        r12 = r0.height() - n();
        r13 = this.h.getHeight();
    L21:
        if (r5 == false) goto L24;
        if (r10 == false) goto L24;
    L17:
        r5 = false;
        goto L18
    L5:
        if (r3 == 32) goto L8;
        r4 = false;
        goto L9
    }

    public final void x0(String r3) {
        tt5.a.b("AtWindowPopWindowImp", "search: ");
        ((kn4.a) this).b.b(r3);
    }

    public static void m(PopupWindow r9, View r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r10) == false) goto L6;
        return;
    L6:
        if ((r9 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r10);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r9, r10, r0, 48, 0, r11) == false) goto L14;
        return;
    L14:
        r9.showAtLocation(r10, 48, 0, r11);
        PopupWindowLancet.trackAfterShow(r9, r0, r10);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r9) == false) goto L11;
        r9.showAtLocation(r10, 48, 0, r11);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (this.j.isShowing() == true) goto L5;
        return;
    L5:
        o(r2);
    }

    public d0(FragmentActivity r8, View r9, MaxHeightLayout r10, AtFinderView r11, kn4.h r12) {
        this.l = 0;
        this.m = 0;
        this.g = r8;
        this.f = r9;
        this.e = r10;
        ((kn4.a) this).c = r11;
        this.k = pcb.a.a.b(r8);
        bo4.d r13 = new bo4.d(r12.b, r12.a, r12.c, r12.d, "");
        r13.e = r12.i;
        k(r12);
        ((kn4.a) this).b = ((kn4.a) this).c.d(r8, r12.a(), r13);
        PopupWindow r14 = new PopupWindow(r8);
        this.j = r14;
        r14.setWidth(-1);
        r14.setHeight(-2);
        r14.setBackgroundDrawable(new ColorDrawable(r8.getResources().getColor(2131103546)));
        r14.setFocusable(false);
        r14.setOutsideTouchable(false);
        r14.setClippingEnabled(false);
        r14.setContentView(r9);
        r14.setOnDismissListener(new b0(this));
        this.d = com.bytedance.ee.util.ui.k.e(r8.getApplicationContext());
        r9.setOnClickListener(new c0(this));
        ((kn4.a) this).c.setContentHeightChangeCallback(new a(this, r11));
    }
}
