package com.bytedance.ee.bear.widget;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.widgets.MaxHeightLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends kn4.a implements ocb.a {
    public static final /* synthetic */ int u = 0;
    public final int d;
    public final MaxHeightLayout e;
    public final View f;
    public View g;
    public final PopupWindow h;
    public final pcb.a i;
    public int j;
    public int k;
    public final kn4.h l;
    public final AtEditText m;
    public final Fragment n;
    public final FragmentActivity o;
    public final long p;
    public boolean q;
    public final g r;
    public sa5.b s;
    public final f t;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ x a;

        public a(x r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            x r11 = this.a;
            Intrinsics.checkNotNull(r10);
            r11.getClass();
            int r0 = r10.getActionMasked();
            boolean r1 = true;
            if (r0 == 0) goto L8;
            if (r0 != 4) goto L16;
        L17:
            boolean r2 = true;
        L18:
            if (r2 == false) goto L50;
            Iterable r12 = r11.l.q;
            if (r12 != null) goto L23;
            r12 = CollectionsKt.emptyList();
        L23:
            Iterable r13 = r12;
            if ((r13 instanceof Collection) == true) goto L26;
        L28:
            Iterator r14 = r13.iterator();
        L30:
            if (r14.hasNext() == false) goto L42;
            View r3 = (View) r14.next();
            Intrinsics.checkNotNull(r3);
            if (r3.isShown() == true) goto L34;
        L39:
            boolean r4 = false;
        L40:
            if (r4 == false) goto L30;
        L44:
            return r1;
        L34:
            if (r3.getWidth() <= 0) goto L39;
            if (r3.getHeight() <= 0) goto L39;
            int[] r5 = new int[2];
            r3.getLocationOnScreen(r5);
            int r6 = r5[0];
            r4 = new Rect(r6, r5[1], r3.getWidth() + r6, r5[1] + r3.getHeight()).contains((int) r10.getRawX(), (int) r10.getRawY());
        L42:
            r1 = false;
            goto L44
        L26:
            if (((Collection) r13).isEmpty() == false) goto L28;
        L50:
            return false;
        L16:
            r2 = false;
            goto L18
        L8:
            if (r10.getX() < 0.0f) goto L17;
            if (r10.getX() >= r11.f.getWidth()) goto L17;
            if (r10.getY() < 0.0f) goto L17;
            if (r10.getY() < r11.f.getHeight()) goto L16;
            goto L16
        }
    }

    public static final class b implements PopupWindow.OnDismissListener {
        public final /* synthetic */ x a;

        public static final class a implements Runnable {
            public final /* synthetic */ x a;

            public a(x r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.close();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(x r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            tt5.a.h("AtWindowCustomPopWindowImp", "AtWindowPopupImp dismiss");
            com.bytedance.ee.util.ui.j.d(new a(this.a), 100);
            kn4.g.b r0 = ((kn4.a) this.a).a;
            if (r0 == null) goto L6;
            r0.b(false);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public c(PopupWindow r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            PopupWindow r2 = this.a;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        }
    }

    public static final class d implements AtFinderView.b {
        public final /* synthetic */ x a;
        public final /* synthetic */ AtFinderView b;

        public static final class a implements Runnable {
            public final /* synthetic */ x a;
            public final /* synthetic */ ViewGroup.LayoutParams b;
            public final /* synthetic */ AtFinderView c;

            public a(x r1, ViewGroup.LayoutParams r2, AtFinderView r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                x r0 = this.a;     // Catch: Throwable -> L6
                int r1 = x.u;     // Catch: Throwable -> L6
                kn4.g.b r2 = ((kn4.a) r0).a;     // Catch: Throwable -> L6
                if (r2 == null) goto L9;
                r2.a(this.b.height, this.c.getHeight());     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(x r1, AtFinderView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.widget.AtFinderView.b
        public final void a() {
            ViewGroup.LayoutParams r0 = this.a.f.getLayoutParams();
            if (r0 != null) goto L5;
            return;
        L5:
            AtFinderView r1 = this.b;
            r1.post(new a(this.a, r0, r1));
        }
    }

    public static final class e {
    }

    public static final class f implements sa5.d {
        public final /* synthetic */ x a;

        public f(x r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            PopupWindow r0 = this.a.h;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L11;
            this.a.close();
            return true;
        L11:
            return false;
        L5:
            if (r0.isShowing() != true) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class g implements ocb.a {
        public final /* synthetic */ x a;

        public static final class a implements Runnable {
            public final /* synthetic */ x a;

            public a(x r1) {
                this.a = r1;
            }

            public final void a() {
                x r0 = this.a;
                PopupWindow r1 = r0.h;
                boolean r2 = false;
                if (r1 != null) goto L5;
            L7:
                if (r2 == false) goto L9;
                return;
            L9:
                if (r0.o.isFinishing() == true) goto L30;
                AtEditText r3 = r0.m;
                if (r3 == null) goto L27;
                Pair r4 = r0.m(r0.o, r3, r0.i, r0.l);
                if (r4 != null) goto L16;
                r4 = TuplesKt.to(0, 0);
            L16:
                int r5 = ((Number) r4.component1()).intValue();
                int r6 = ((Number) r4.component2()).intValue();
                PopupWindow r7 = r0.h;
                if (r7 == null) goto L28;
                kn4.h r8 = r0.l;
                int r9 = r8.n;
                int r10 = r8.o;
                if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r7) == false) goto L22;
                r7.update(r5, r6, r9, r10);
                return;
            L22:
                if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r7, r5, r6, r9, r10) == true) goto L31;
                r7.update(r5, r6, r9, r10);
                return;
            L31:
                return;
            L28:
                return;
            L27:
                return;
            L30:
                return;
            L5:
                if (r1.isShowing() == true) goto L7;
                r2 = true;
                goto L7
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public g(x r1) {
            this.a = r1;
        }

        public final void onKeyboardHeightChanged(pcb.a r3, int r4, int r5) {
            if (r4 <= 0) goto L4;
            boolean r6 = true;
        L5:
            if (r6 == false) goto L8;
            Handler r7 = new Handler(Looper.getMainLooper());
            x r8 = this.a;
            r7.postDelayed(new a(r8), r8.p);
            return;
        L8:
            return;
        L4:
            r6 = false;
            goto L5
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ x a;

        public h(x r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.b("AtWindowCustomPopWindowImp", "onClosedView: ");     // Catch: Throwable -> L4
            this.a.close();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ x a;

        public i(x r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void close() {
        boolean r0 = true;
        this.q = true;
        this.i.a(this);
        PopupWindow r1 = this.h;
        if (r1 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L12;
        PopupWindow r2 = this.h;
        if (r2 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L12:
        ((kn4.a) this).b.a();
        View r3 = this.f;
        if (r3 == null) goto L16;
        r3.setOnKeyListener(null);
    L16:
        if (ForsetiHelper.s(this.n) == false) goto L20;
        com.ss.android.lark.forsetiutils.a r4 = this.o;
        if ((r4 instanceof com.ss.android.lark.forsetiutils.a) == false) goto L20;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.forsetiutils.ForsetiFragmentEventHandler");
        r4.b();
    L20:
        this.i.a(this.r);
        sa5.b r5 = this.s;
        if (r5 == null) goto L24;
        r5.d(this.t);
        return;
    L24:
        return;
    L5:
        if (r1.isShowing() != true) goto L7;
        goto L7
    }

    public final void show() {
        this.q = false;
        this.i.c(this.r);
        boolean r0 = rcb.b.a(this.o);
        tt5.a.h("AtWindowCustomPopWindowImp", "show() called, hasHardKeyboard:" + r0);
        if (r0 == true) goto L5;
        com.bytedance.ee.util.ui.j.d(new i(this), this.p);
        return;
    L5:
        p();
    }

    public final boolean isShowing() {
        return !this.q;
    }

    public final void j() {
        AtFinderView r0 = ((kn4.a) this).c;
        if (r0 == null) goto L5;
        r0.a();
        return;
    L5:
        tt5.a.d("AtWindowCustomPopWindowImp", "closeFindView(): findView is null");
    }

    public final void p() {
        if (this.m != null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r0 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r1 = this.o;
        Fragment r2 = this.n;
        r0.getClass();
        sa5.b r3 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r1, r2);
        this.s = r3;
        if (r3 == null) goto L8;
        r3.d(this.t);
    L8:
        sa5.b r4 = this.s;
        if (r4 == null) goto L11;
        r4.e(this.t);
    L11:
        PopupWindow r5 = this.h;
        if (r5 != null) goto L14;
    L51:
        this.i.c(this);
        return;
    L14:
        if (r5.isShowing() == true) goto L51;
        if (this.o.isFinishing() == false) goto L19;
        tt5.a.k("AtWindowCustomPopWindowImp", "show: at fail casue activity.isFinishing");
        return;
    L19:
        kn4.g.b r6 = ((kn4.a) this).a;
        if (r6 == null) goto L22;
        r6.b(true);
    L22:
        ((kn4.a) this).b.c(true);
        Pair r7 = m(this.o, this.m, this.i, this.l);
        if (r7 != null) goto L25;
        r7 = TuplesKt.to(0, 0);
    L25:
        int r10 = ((Number) r7.component1()).intValue();
        int r8 = ((Number) r7.component2()).intValue();
        View r11 = l(this.o.getWindow());
        if (PopupWindowLancet.hasSubWindowToken(r11) == false) goto L29;
    L53:
        View r9 = r5.getContentView();     // Catch: Exception -> L44
        if (r9 == null) goto L46;
        View r12 = r5.getContentView().findViewById(2131372554);     // Catch: Exception -> L44
        if (r12 == null) goto L40;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");     // Catch: Exception -> L44
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r13;     // Catch: Exception -> L44
        r14.gravity = 48;     // Catch: Exception -> L44
        r12.setLayoutParams(r14);     // Catch: Exception -> L44
    L40:
        TextView r15 = (TextView) r9.findViewById(2131385547);     // Catch: Exception -> L44
        r15.setGravity(17);     // Catch: Exception -> L44
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();     // Catch: Exception -> L44
        if ((r16 instanceof FrameLayout.LayoutParams) == false) goto L46;
        ((FrameLayout.LayoutParams) r16).gravity = 48;     // Catch: Exception -> L44
        ((FrameLayout.LayoutParams) r16).leftMargin = 0;     // Catch: Exception -> L44
        ((FrameLayout.LayoutParams) r16).topMargin = 0;     // Catch: Exception -> L44
        r15.setLayoutParams(r16);     // Catch: Exception -> L44
        r15.setElevation(0.0f);     // Catch: Exception -> L44
        r15.setBackground(AppCompatResources.getDrawable(this.o, 2131247393));     // Catch: Exception -> L44
        r15.setTextColor(UDColorUtils.getColor(this.o, 2131106622));     // Catch: Exception -> L44
        r15.setPadding(0, 0, 0, 0);     // Catch: Exception -> L44
    L46:
        o(this.i.getVisibleKeyboardHeight());
        kn4.l.b r17 = kn4.f.b();
        View r18 = this.f.findViewById(2131373295);
        if ((r18 instanceof FrameLayout) == false) goto L49;
        FrameLayout r19 = (FrameLayout) r18;
    L50:
        r17.a(r19);
        goto L51
    L49:
        r19 = null;
    L44:
        e = move-exception;
        tt5.a.e("AtWindowCustomPopWindowImp", "show: Exception:", e, false);
        goto L46
    L29:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r5) == false) goto L31;
        r5.showAtLocation(r11, 8388659, r10, r8);
        goto L53
    L31:
        OverlaySource r110 = PopupWindowLancet.resolveSource(r11);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r5, r11, r110, 8388659, r10, r8) == true) goto L53;
        r5.showAtLocation(r11, 8388659, r10, r8);
        PopupWindowLancet.trackAfterShow(r5, r110, r11);
        goto L53
    }

    public void update() {
        o(this.i.getVisibleKeyboardHeight());
        PopupWindow r0 = this.h;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isShowing() != true) goto L7;
    L8:
        if (r2 == false) goto L19;
        int r1 = n();
        PopupWindow r3 = this.h;
        if (r3 != null) goto L12;
        return;
    L12:
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r3) == false) goto L15;
        r3.update(0, r1, -1, -2);
        return;
    L15:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r3, 0, r1, -1, -2) == true) goto L22;
        r3.update(0, r1, -1, -2);
        return;
    L22:
        return;
    L19:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final int n() {
        if (com.ss.android.lark.base.embedded.b.i() == false) goto L6;
        return this.j - this.d;
    L6:
        return this.j;
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

    public final void e(int r1) {
        this.j = r1;
    }

    public final void f(kn4.g.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        tt5.a.b("AtWindowCustomPopWindowImp", "setSelectedCallback: ");
        com.bytedance.ee.bear.atfinder.c r0 = ((kn4.a) this).b;
        r0.d = new q(r0, r4, new h(this));
    }

    public final void h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "bottomAnchor");
        this.g = r2;
    }

    public final void i(int r1) {
        this.k = r1;
    }

    public final void o(int r8) {
        Rect r0 = new Rect();
        View r1 = l(this.o.getWindow());
        r1.getWindowVisibleDisplayFrame(r0);
        int r2 = r1.getHeight();
        int r3 = this.o.getWindow().getAttributes().softInputMode & 240;
        boolean r5 = true;
        if (r3 != 16) goto L5;
    L8:
        boolean r4 = true;
    L9:
        int r6 = r0.height();
        if (r2 <= 0) goto L17;
        if (r6 <= 0) goto L17;
        if (r8 <= 0) goto L17;
        if (((r2 - r6) + Math.max(this.d, com.bytedance.ee.util.ui.n.c(24.0f))) < r8) goto L17;
    L18:
        com.bytedance.ee.bear.appsetting.c r7 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r9 = r7.g("ccm.bitable.big_screen_at_window_height");
        boolean r10 = r7.g("ccm.mobile.at_window_height_fix_enable");
        if (r4 == false) goto L21;
        if (r9 == false) goto L21;
    L23:
        r8 = 0;
    L24:
        View r11 = this.g;
        int r12 = this.k;
        if (r12 != 0) goto L28;
        if (r11 == null) goto L28;
        int r13 = r0.height() - n();
        int r14 = r11.getHeight();
    L31:
        int r15 = (r13 - r14) - r8;
        if (com.bytedance.ee.util.ui.n.D(this.o) == true) goto L34;
    L35:
        r15 = r15 + this.d;
    L36:
        ViewGroup.LayoutParams r16 = this.f.getLayoutParams();
        if (r16 == null) goto L40;
        this.e.setMaxHeight(r15);
        r16.height = r15;
        this.f.setLayoutParams(r16);
        return;
    L40:
        return;
    L34:
        if (com.bytedance.ee.util.ui.k.g(this.o) == false) goto L36;
    L28:
        if (r12 == 0) goto L30;
        r13 = r0.height() - n();
        r14 = this.k;
        goto L31
    L30:
        r13 = r0.height();
        r14 = n();
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
        Intrinsics.checkNotNullParameter(r3, "keyword");
        tt5.a.b("AtWindowCustomPopWindowImp", "search: ");
        ((kn4.a) this).b.b(r3);
    }

    public final void onKeyboardHeightChanged(pcb.a r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "khp");
        PopupWindow r5 = this.h;
        boolean r6 = false;
        if (r5 != null) goto L5;
    L7:
        if (r6 == false) goto L9;
        return;
    L9:
        o(r3);
        return;
    L5:
        if (r5.isShowing() != true) goto L7;
        r6 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair m(FragmentActivity r11, AtEditText r12, pcb.a r13, kn4.h r14) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r12, "<this>");
        int r0 = r12.getSelectionStart();
        boolean r2 = false;
        if (r0 >= 0) goto L5;
        Point r1 = new Point(0, 0);
    L16:
        if (r1.x == 0) goto L18;
    L20:
        Layout r3 = r12.getLayout();
        if (r3 != null) goto L23;
        Rect r15 = new Rect();
    L24:
        Window r16 = r11.getWindow();
        if (r16 == null) goto L46;
        View r17 = l(r16);
        if (r17 == null) goto L46;
        Integer r4 = Integer.valueOf(r17.getWidth());
        if (r4.intValue() <= 0) goto L32;
        boolean r5 = true;
    L33:
        if (r5 == true) goto L36;
        r4 = null;
    L36:
        if (r4 == null) goto L46;
        int r8 = r4.intValue();
        Integer r18 = Integer.valueOf(r17.getHeight() - r13.getVisibleKeyboardHeight());
        if (r18.intValue() <= 0) goto L40;
        r2 = true;
    L40:
        if (r2 == true) goto L43;
        r18 = null;
    L43:
        if (r18 == null) goto L46;
        int r9 = r18.intValue();
        FragmentActivity r6 = this.o;
        int r7 = r14.n;
        int r10 = r14.o;
        int r19 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m.a;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r15, "rect");
        dib.a r110 = eib.a.a(r6, new vua.a(r15, r7, r10, true), r7, r10, r8, r9);
        return TuplesKt.to(Integer.valueOf(r110.a), Integer.valueOf(r110.b));
    L32:
        r5 = false;
    L46:
        return null;
    L23:
        int r111 = r3.getLineForOffset(r12.getSelectionStart());
        int r20 = r3.getLineBottom(r111) - r3.getLineTop(r111);
        int r21 = r1.x;
        int r22 = r1.y;
        r15 = new Rect(r21, r22, r21, r20 + r22);
        goto L24
    L18:
        if (r1.y != 0) goto L20;
        r15 = new Rect();
        goto L24
    L5:
        Layout r23 = r12.getLayout();
        if (r23 != null) goto L8;
        r1 = new Point(0, 0);
        goto L16
    L8:
        int r24 = r23.getLineForOffset(r0);
        if (r24 >= 0) goto L11;
    L14:
        r1 = new Point(0, 0);
        goto L16
    L11:
        if (r24 >= r23.getLineCount()) goto L14;
        int r25 = (int) r23.getPrimaryHorizontal(r0);
        int r26 = r23.getLineTop(r24);
        int[] r27 = new int[2];
        r12.getLocationOnScreen(r27);
        int r28 = r27[0];
        int r29 = r27[1];
        r1 = new Point((r28 + r25) - r12.getScrollX(), (r29 + r26) - r12.getScrollY());
        goto L16
    }

    public x(FragmentActivity r8, View r9, MaxHeightLayout r10, AtFinderView r11, AtEditText r12, Fragment r13, kn4.h r14) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "contentView");
        Intrinsics.checkNotNullParameter(r10, "atFinderContainerView");
        Intrinsics.checkNotNullParameter(r11, "atFinderView");
        Intrinsics.checkNotNullParameter(r12, "atEditText");
        Intrinsics.checkNotNullParameter(r14, "atWindowConfig");
        this.d = com.bytedance.ee.util.ui.k.e(r8.getApplicationContext());
        this.p = 350;
        boolean r0 = true;
        this.q = true;
        this.r = new g(this);
        this.t = new f(this);
        this.o = r8;
        this.f = r9;
        this.e = r10;
        ((kn4.a) this).c = r11;
        this.n = r13;
        if (r11 == null) goto L7;
        UDShadowLayout r15 = r11.findViewById(2131386033);
        if (r15 == null) goto L7;
        r15.setShadowSize(UDShadowLayout.Size.NONE);
    L7:
        FrameLayout r16 = (FrameLayout) r9.findViewById(2131373295);
        if (r16 != null) goto L10;
    L12:
        this.m = r12;
        this.l = r14;
        this.i = pcb.a.a.b(r8);
        bo4.d r17 = new bo4.d(r14.b, r14.a, r14.c, r14.d, "");
        r17.e = r14.i;
        k(r14);
        ((kn4.a) this).b = ((kn4.a) this).c.d(this.o, r14.a(), r17);
        PopupWindow r18 = new PopupWindow(r8);
        this.h = r18;
        r18.setInputMethodMode(1);
        r18.setAnimationStyle(2131953368);
        int r19 = r14.n;
        if (r19 == 0) goto L15;
        r18.setWidth(r19);
    L16:
        int r110 = r14.o;
        if (r110 == 0) goto L19;
        r18.setHeight(r110);
    L20:
        r18.setFocusable(false);
        r18.setOutsideTouchable(true);
        r18.setClippingEnabled(false);
        r18.setContentView(r9);
        r18.setElevation(12.0f);
        r18.setBackgroundDrawable(AppCompatResources.getDrawable(r8, 2131247393));
        ArrayList r20 = r14.q;
        if (r20 != null) goto L23;
    L26:
        if (r0 == true) goto L28;
        r18.setTouchInterceptor(new a(this));
    L28:
        r18.setOnDismissListener(new b(this));
        r9.setOnClickListener(new c(r18));
        ((kn4.a) this).c.setContentHeightChangeCallback(new d(this, r11));
        return;
    L23:
        if (r20.isEmpty() == true) goto L26;
        r0 = false;
        goto L26
    L19:
        r18.setHeight(-1);
        goto L20
    L15:
        r18.setWidth(-1);
        goto L16
    L10:
        if (r14.o == 0) goto L12;
        ViewGroup.LayoutParams r111 = r16.getLayoutParams();
        r111.height = r14.o;
        r16.setLayoutParams(r111);
        goto L12
    }
}
