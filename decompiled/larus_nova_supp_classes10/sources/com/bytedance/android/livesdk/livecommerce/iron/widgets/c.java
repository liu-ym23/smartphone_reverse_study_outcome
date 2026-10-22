package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.IronListHeaderEntryView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends PopupWindow {
    public static int v;
    public BubbleLayout a;
    public final Activity b;
    public TextView c;
    public final boolean d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public long o;
    public AnimatorSet p;
    public Runnable q;
    public final a r;
    public long s;
    public long t;
    public boolean u;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L4
            PopupWindowLancet.handleDismissBeforeOrigin(r0);     // Catch: Throwable -> L4
            r0.dismiss();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
            c r2 = this.a;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.widgets.c$c, reason: collision with other inner class name */
    public class RunnableC0073c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ BubbleLayout b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ c d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.widgets.c$c$a */
        public class a extends AnimatorListenerAdapter {
            public final /* synthetic */ RunnableC0073c a;

            public a(RunnableC0073c r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                RunnableC0073c r3 = this.a;
                if (r3.c == true) goto L19;
                r3.b.setVisibility(8);
                c r4 = this.a.d;
                AnimatorSet r0 = r4.p;
                if (r0 == null) goto L8;
                r0.removeAllListeners();
                r4.p.cancel();
                r4.p = null;
            L8:
                if (r4.b.isFinishing() == false) goto L10;
                return;
            L10:
                if (r4.isShowing() == false) goto L21;
                c.a(r4);     // Catch: Exception -> L14
                return;
            L14:
                e = move-exception;
                com.bytedance.android.ec.sdk.helper.g.a.e(e);
                return;
            L21:
                return;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                super.onAnimationStart(r2);
                RunnableC0073c r3 = this.a;
                if (r3.c == false) goto L6;
                r3.b.setVisibility(0);
                return;
            }
        }

        public final void a() {
            if (this.d.p != null) goto L5;
            return;
        L5:
            int r0 = this.a;
            if (r0 != 3) goto L8;
            int r1 = this.b.getMeasuredWidth();
            int r2 = (int) this.b.getBubbleOffset();
        L19:
            this.b.setPivotY(r2);
            this.b.setPivotX(r1);
            BubbleLayout r3 = this.b;
            float[] r4 = new float[2];
            boolean r5 = this.c;
            float r6 = 0.0f;
            if (r5 == false) goto L22;
            float r7 = 0.0f;
        L23:
            r4[0] = r7;
            if (r5 == false) goto L26;
            float r8 = 1.0f;
        L27:
            r4[1] = r8;
            ObjectAnimator r9 = ObjectAnimator.ofFloat(r3, "scaleX", r4);
            BubbleLayout r10 = this.b;
            float[] r11 = new float[2];
            boolean r12 = this.c;
            if (r12 == false) goto L30;
            float r13 = 0.0f;
        L31:
            r11[0] = r13;
            if (r12 == false) goto L34;
            float r14 = 1.0f;
        L35:
            r11[1] = r14;
            ObjectAnimator r15 = ObjectAnimator.ofFloat(r10, "scaleY", r11);
            BubbleLayout r16 = this.b;
            float[] r17 = new float[2];
            boolean r18 = this.c;
            if (r18 == false) goto L38;
            float r19 = 0.0f;
        L39:
            r17[0] = r19;
            if (r18 == false) goto L42;
            r6 = 1.0f;
        L42:
            r17[1] = r6;
            this.d.p.play(r9).with(r15).with(ObjectAnimator.ofFloat(r16, "alpha", r17));
            c r20 = this.d;
            AnimatorSet r21 = r20.p;
            if (this.c == false) goto L45;
            long r22 = r20.s;
        L46:
            r21.setDuration(r22);
            this.d.getClass();
            this.d.p.addListener(new a(this));
            this.d.p.start();
            return;
        L45:
            r22 = r20.t;
            goto L46
        L38:
            r19 = 1.0f;
            goto L39
        L34:
            r14 = 0.0f;
            goto L35
        L30:
            r13 = 1.0f;
            goto L31
        L26:
            r8 = 0.0f;
            goto L27
        L22:
            r7 = 1.0f;
            goto L23
        L8:
            if (r0 != 5) goto L10;
            r2 = (int) this.b.getBubbleOffset();
            r1 = 0;
            goto L19
        L10:
            if (r0 != 48) goto L12;
            r1 = (int) this.b.getBubbleOffset();
            r2 = this.b.getMeasuredHeight();
            goto L19
        L12:
            if (r0 == 80) goto L15;
            r1 = 0;
        L14:
            r2 = 0;
            goto L19
        L15:
            r1 = (int) this.b.getBubbleOffset();
            goto L14
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

        public RunnableC0073c(c r1, int r2, BubbleLayout r3, boolean r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        if (this.k == true) goto L5;
        b(false, this.l);
        getContentView().removeCallbacks(this.r);
        this.h = 0;
        this.i = 0;
    L5:
        Runnable r0 = this.q;
        if (r0 == null) goto L9;
        r0.run();
        return;
    }

    public c(Activity r5) {
        super(r5);
        this.j = 0;
        this.n = true;
        this.o = 7000;
        this.r = new a(this);
        this.s = 800;
        this.t = 200;
        this.u = false;
        this.b = r5;
        this.d = true;
        Resources r2 = r5.getResources();
        v = (int) ((WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density * 3.0f) + 0.5f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        TextView r0 = new TextView(r5);
        this.c = r0;
        r0.setTextColor(th.a.a(r5, 2131101703));
        this.c.setTextSize(13.0f);
        this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.c.setMaxLines(2);
        this.c.setGravity(17);
        c(this.c);
        this.g = true;
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void a(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        super.dismiss();
    }

    public final void c(View r3) {
        BubbleLayout r0 = new BubbleLayout(this.b);
        this.a = r0;
        r0.setBackgroundColor(0);
        this.a.addView(r3);
        this.a.setGravity(17);
        ViewGroup.MarginLayoutParams r4 = new ViewGroup.MarginLayoutParams(-2, -2);
        this.a.setLayoutParams(r4);
        this.a.setVisibility(8);
        int r5 = this.m;
        if (r5 == 0) goto L5;
        this.a.setBgColor(r5);
    L5:
        this.a.setNeedPath(this.n);
        this.a.setNeedPressFade(false);
        this.a.setOnClickListener(new b(this));
        if (this.d == false) goto L8;
        setContentView(this.a);
        return;
    L8:
        FrameLayout r6 = new FrameLayout(this.b);
        r6.addView(this.a);
        r6.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.iron.widgets.b(this));
        setContentView(r6);
    }

    public final void b(boolean r3, int r4) {
        BubbleLayout r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == true) goto L7;
        this.k = true;
    L7:
        AnimatorSet r1 = this.p;
        if (r1 != null) goto L10;
        this.p = new AnimatorSet();
    L11:
        r0.post(new RunnableC0073c(this, r4, r0, r3));
        return;
    L10:
        r1.removeAllListeners();
        this.p.cancel();
        goto L11
    }

    public final void d(IronListHeaderEntryView r12, int r13, int r14) {
        this.h = r14;
        this.i = -9;
        this.j = r13;
        if (this.b.isFinishing() == false) goto L5;
        return;
    L5:
        if (r12.getWindowToken() != null) goto L8;
        return;
    L8:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SPLIT_FIX_POPUP_WINDOW_FORCE().booleanValue() == true) goto L10;
    L12:
        getContentView().removeCallbacks(this.r);
        this.l = 80;
        if (isShowing() == true) goto L53;
        int r0 = this.e;
        if (r0 != 0) goto L17;
    L19:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L20:
        int r1 = getContentView().getMeasuredWidth() / 2;
        BubbleLayout r2 = this.a;
        if (r2 == null) goto L23;
        r2.o = r1 + this.j;
        r2.p = 0;
    L23:
        int[] r3 = new int[2];
        r12.getLocationInWindow(r3);
        int r4 = this.h + ((r12.getMeasuredWidth() - getContentView().getMeasuredWidth()) / 2);
        int r5 = v + this.i;
        if (this.d == false) goto L29;
        OverlaySource r6 = PopupWindowLancet.resolveSource(r12);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r12, r6) == true) goto L46;
        showAsDropDown(r12, r4, r5);
        PopupWindowLancet.trackAfterShow(this, r6, r12);
    L46:
        b(true, 80);
        this.k = false;
        if (this.o <= 0) goto L50;
        getContentView().postDelayed(this.r, this.o);
    L50:
        if (this.g == false) goto L58;
        getContentView().setSystemUiVisibility(4102);
        return;
    L58:
        return;
    L29:
        int r7 = r4 + r3[0];
        int r8 = (r5 + r3[1]) + r12.getHeight();
        BubbleLayout r9 = this.a;
        if (r9 != null) goto L32;
        ViewGroup.LayoutParams r10 = null;
    L34:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        r11.leftMargin = r7;
        r11.topMargin = r8;
    L37:
        if (PopupWindowLancet.hasSubWindowToken(r12) == true) goto L46;
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L42;
        showAtLocation(r12, 0, 0, 0);
        goto L46
    L42:
        OverlaySource r15 = PopupWindowLancet.resolveSource(r12);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r12, r15, 0, 0, 0) == true) goto L46;
        showAtLocation(r12, 0, 0, 0);
        PopupWindowLancet.trackAfterShow(this, r15, r12);
        goto L46
    L32:
        r10 = r9.getLayoutParams();
        goto L34
    L17:
        if (this.f == 0) goto L19;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
        goto L20
    L53:
        a(this);
        return;
    L10:
        if (this.u == false) goto L12;
        setFocusable(false);
        update();
        goto L12
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r3, int r4, int r5, int r6) {
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);     // Catch: Exception -> L7
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r3, r0) == true) goto L12;
        super.showAsDropDown(r3, r4, r5, r6);     // Catch: Exception -> L7
        PopupWindowLancet.trackAfterShow(this, r0, r3);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
    L8:
        e = move-exception;
        com.bytedance.android.ec.sdk.helper.g.a.e(e);
        return;
    L3:
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
    L17:
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L10;
        super.showAtLocation(r8, r9, r10, r11);     // Catch: Exception -> L8
        goto L17
    L10:
        OverlaySource r6 = PopupWindowLancet.resolveSource(r8);     // Catch: Exception -> L8
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r6, r9, r10, r11) == true) goto L17;
        super.showAtLocation(r8, r9, r10, r11);     // Catch: Exception -> L8
        PopupWindowLancet.trackAfterShow(this, r6, r8);     // Catch: Exception -> L8
        goto L17
    }
}
