package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveNotificationVM;
import com.bytedance.ee.bear.drive.core.fragment.DriveMediaImmersiveVM;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public boolean a;
    public final View b;
    public View c;
    public final View d;
    public final FragmentActivity e;
    public final int f;
    public int g;
    public AnimatorSet h;
    public AnimatorSet i;
    public final g85.f j;
    public final boolean k;
    public final boolean l;
    public final DriveMediaImmersiveVM m;
    public int n;
    public String o;
    public final DriveFullScreenVM p;
    public final boolean q;
    public boolean r;
    public final com.bytedance.ee.bear.drive.biz.preview.screen.c s;
    public com.bytedance.ee.bear.drive.biz.preview.screen.a t;

    public class a extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ k c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.a = true;
            this.c.b();
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation canceled, hide=" + this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            if (this.a == false) goto L5;
            return;
        L5:
            this.c.b();
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation end, hide=" + this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.c.b.setAlpha(1.0f);
            View r3 = this.c.c;
            if (r3 == null) goto L6;
            r3.setAlpha(1.0f);
        L6:
            if (this.b == true) goto L8;
            this.c.b.setVisibility(0);
        L8:
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation start, hide=" + this.b);
        }

        public a(k r1, boolean r2) {
            this.c = r1;
            this.b = r2;
            this.a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ k b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r6) {
            if (this.b.d() == false) goto L16;
            k r7 = this.b;
            DriveMediaImmersiveVM r0 = r7.m;
            boolean r1 = false;
            if (r0 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 == false) goto L12;
            tt5.a.h("DriveFullScreenManager", "skip window color: mediaImmersiveActive");
        L13:
            if (r1 == false) goto L17;
            this.b.g(this.a);
            this.b.e.getWindow().setStatusBarColor(this.a);
            this.b.e.getWindow().setNavigationBarColor(this.a);
            return;
        L17:
            return;
        L12:
            r1 = !r7.k;
            goto L13
        L7:
            if (r0.isMediaImmersiveActive(r7.l, r7.k) == false) goto L9;
            r2 = true;
            goto L10
        }

        public b(k r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.e();
        }
    }

    public final void b() {
        this.r = false;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r1 = this.t;
        if (r1 != null) goto L5;
    L9:
        if (r1 == null) goto L14;
        tt5.a.h("DriveFullScreenManager", "fullscreen animation finished in normal state, notify deferred callback");
        this.t = null;
        e();
        return;
    L14:
        return;
    L5:
        if (this.a == false) goto L9;
        this.t = null;
        tt5.a.h("DriveFullScreenManager", "fullscreen animation finished, continue deferred presentation exit, ext=" + r1.b);
        r1.a = false;
        if (i(r1) == true) goto L12;
        tt5.a.k("DriveFullScreenManager", "deferred presentation exit rejected, clear callback, ext=" + r1.b);
        this.s.a = null;
        return;
    }

    public final void c() {
        if (this.q == true) goto L12;
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        Animator r1 = ValueAnimator.ofInt(new int[]{0});
        long r7 = 100;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f}).setDuration(r7);
        View r5 = this.c;
        if (r5 == null) goto L7;
        r1 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f}).setDuration(r7);
    L7:
        this.h.playTogether(new Animator[]{r3, r1});
        this.h.addListener(new g(this));
        Animator r2 = ValueAnimator.ofInt(new int[]{0});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f}).setDuration(r7);
        View r6 = this.c;
        if (r6 == null) goto L10;
        r2 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{0.0f, 1.0f}).setDuration(r7);
    L10:
        this.i.playTogether(new Animator[]{r4, r2});
        this.i.addListener(new h(this));
        return;
    }

    public final boolean d() {
        FragmentActivity r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isFinishing() == true) goto L7;
        return true;
    }

    public final void e() {
        if (this.s.a != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        View r1 = this.d;
        if (r1 != null) goto L12;
        tt5.a.k("DriveFullScreenManager", "exit preview presentation callback dropped: preview view is null");
        this.s.a = null;
        return;
    L12:
        r1.post(new d(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final AnimatorSet a(boolean r11) {
        View r0 = this.b;
        if (r0 != null) goto L6;
        final int r5 = 0;
    L15:
        if (r11 == false) goto L17;
        final int r6 = 0;
    L18:
        View r1 = this.c;
        if (r1 != null) goto L22;
        final int r8 = 0;
    L31:
        if (r11 == false) goto L33;
        final int r9 = 0;
    L34:
        final ViewGroup.LayoutParams r4 = this.b.getLayoutParams();
        View r2 = this.c;
        if (r2 != null) goto L37;
        ViewGroup.LayoutParams r3 = null;
    L38:
        final ViewGroup.LayoutParams r7 = r3;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(150);
        r10.addUpdateListener(new e(this, r4, r5, r6, r7, r8, r9));
        AnimatorSet r12 = new AnimatorSet();
        r12.play(r10);
        r12.addListener(new a(this, r11));
        return r12;
    L37:
        r3 = r2.getLayoutParams();
        goto L38
    L33:
        r9 = this.f;
        goto L34
    L22:
        if (r1.getHeight() <= 0) goto L25;
        int r13 = r1.getHeight();
    L24:
        r8 = r13;
        goto L31
    L25:
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
        if (r14 == null) goto L30;
        r13 = r14.height;
        if (r13 >= 0) goto L24;
    L30:
        r13 = 0;
        goto L24
    L17:
        r6 = this.g;
        goto L18
    L6:
        if (r0.getHeight() <= 0) goto L9;
        int r16 = r0.getHeight();
    L8:
        r5 = r16;
        goto L15
    L9:
        ViewGroup.LayoutParams r17 = r0.getLayoutParams();
        if (r17 == null) goto L14;
        r16 = r17.height;
        if (r16 >= 0) goto L8;
    L14:
        r16 = 0;
        goto L8
    }

    public final void g(int r5) {
        if (this.k == false) goto L5;
        this.d.setBackgroundColor(r5);
        return;
    L5:
        FragmentActivity r0 = this.e;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getWindow() == null) goto L18;
        View r1 = this.e.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L14;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L14:
        r1.setBackgroundColor(r5);
        return;
    }

    public final boolean i(com.bytedance.ee.bear.drive.biz.preview.screen.a r6) {
        if (d() == true) goto L5;
        return false;
    L5:
        String r0 = r6.b;
        boolean r2 = r6.a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.drive.disable_pdf_immersive") == true) goto L8;
    L11:
        this.a = r2;
        if (this.q == false) goto L15;
        this.r = true;
        this.p.getLiveFullScreen().setValue(r6);
    L15:
        if (((g85.b) this.j).m(r0) == false) goto L18;
        h(this.e.getResources().getColor(2131100545), r0);
    L29:
        if (this.q == true) goto L31;
        this.p.getLiveFullScreen().postValue(r6);
    L31:
        return true;
    L18:
        if (((g85.b) this.j).j(r0, null) == false) goto L21;
        h(this.e.getResources().getColor(2131106500), r0);
        goto L29
    L21:
        if (((g85.b) this.j).o(r0, null) == false) goto L24;
        h(this.e.getResources().getColor(2131106500), r0);
        goto L29
    L24:
        if (i75.h.i(this.o) == false) goto L26;
        int r1 = 2131100548;
    L27:
        h(this.e.getResources().getColor(r1), r0);
        goto L29
    L26:
        r1 = 2131100549;
        goto L27
    L8:
        if (((g85.b) this.j).m(r0) == false) goto L11;
        tt5.a.k("DriveFullScreenManager", "setFullScreen, extension=pdf, isFullScreen=" + r2 + ", need block");
        return false;
    }

    public static void j(View r1, int r2) {
        r1.getLayoutParams().height = r2;
        r1.requestLayout();
    }

    public final void f(FragmentActivity r4, com.bytedance.ee.bear.drive.biz.preview.screen.a r5) {
        if (com.bytedance.ee.util.ui.b.a(r4) == true) goto L5;
    L24:
        tt5.a.k("DRIVE_PREVIEW_FLOW", "requestVideoFullScreen, activity=" + r4);
        return;
    L5:
        if (r4.getWindow() == null) goto L24;
        boolean r0 = r5.a;
        View r1 = this.b;
        if (r0 == false) goto L10;
        int r2 = 8;
    L11:
        r1.setVisibility(r2);
        if (r0 == true) goto L15;
        j(this.b, this.g);
    L15:
        if (((g85.b) this.j).m(r5.b) == false) goto L17;
    L22:
        this.a = r0;
        this.p.getLiveFullScreen().postValue(r5);
        return;
    L17:
        if (r5.d == true) goto L22;
        if (r0 == false) goto L21;
        r4.getWindow().addFlags(1024);
        goto L22
    L21:
        r4.getWindow().clearFlags(1024);
        goto L22
    L10:
        r2 = 0;
        goto L11
    }

    public final void h(int r13, String r14) {
        this.h.cancel();
        this.i.cancel();
        boolean r1 = false;
        if (this.q == false) goto L12;
        if (this.c == null) goto L8;
    L10:
        this.h = a(true);
        this.i = a(false);
    L39:
        if (this.a == false) goto L41;
        this.h.addListener(new b(this, r13));
        this.h.start();
        return;
    L41:
        DriveMediaImmersiveVM r16 = this.m;
        if (r16 != null) goto L44;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == false) goto L49;
        tt5.a.h("DriveFullScreenManager", "skip window color: mediaImmersiveActive");
    L50:
        if (r1 == false) goto L56;
        this.e.getWindow().setStatusBarColor(this.p.getOriginStatusBarColor());
        this.e.getWindow().setNavigationBarColor(this.p.getOriginNavigationBarColor());
        Resources r18 = this.e.getResources();
        if (((g85.b) this.j).d(r14) == false) goto L54;
        int r19 = 2131106521;
    L55:
        g(r18.getColor(r19));
        goto L56
    L54:
        r19 = 2131100549;
    L56:
        this.i.addListener(new c(this));
        this.i.start();
        return;
    L49:
        r1 = !this.k;
        goto L50
    L44:
        if (r16.isMediaImmersiveActive(this.l, this.k) == false) goto L46;
        r17 = true;
        goto L47
    L8:
        if ((this.d.getParent() instanceof View) == false) goto L10;
        this.c = ((View) this.d.getParent()).findViewById(2131370259);
        goto L10
    L12:
        if (((g85.b) this.j).m(this.o) == false) goto L14;
    L23:
        boolean r0 = true;
    L24:
        if (r0 == false) goto L39;
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        Animator r2 = ValueAnimator.ofInt(new int[]{0});
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{0});
        long r8 = 100;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f}).setDuration(r8);
        View r6 = this.c;
        if (r6 == null) goto L29;
        r2 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{1.0f, 0.0f}).setDuration(r8);
    L29:
        if (((g85.b) this.j).m(this.o) == false) goto L31;
        r3 = com.bytedance.ee.util.ui.g.a(this.b, this.g, 0).setDuration(r8);
    L31:
        this.h.playTogether(new Animator[]{r4, r2, r3});
        this.h.addListener(new i(this));
        Animator r5 = ValueAnimator.ofInt(new int[]{0});
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{0});
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f}).setDuration(r8);
        View r10 = this.c;
        if (r10 == null) goto L35;
        r5 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{0.0f, 1.0f}).setDuration(r8);
    L35:
        if (((g85.b) this.j).m(this.o) == false) goto L37;
        r7 = com.bytedance.ee.util.ui.g.a(this.b, 0, this.g).setDuration(r8);
    L37:
        this.i.playTogether(new Animator[]{r9, r5, r7});
        this.i.addListener(new j(this));
        goto L39
    L14:
        if (this.n == 1) goto L23;
        if (this.k == true) goto L18;
    L22:
        r0 = false;
        goto L24
    L18:
        if (i75.h.g(this.o) == true) goto L23;
        if (i75.h.j(this.o) == false) goto L22;
        goto L22
    }

    public k(View r4, View r5, View r6, boolean r7, FragmentActivity r8, boolean r9) {
        boolean r0 = false;
        this.a = false;
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.k = false;
        this.l = false;
        this.n = 0;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
        this.q = r1;
        this.r = false;
        this.s = new com.bytedance.ee.bear.drive.biz.preview.screen.c();
        this.j = o75.b.a().getMimeTypeManager();
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.k = r7;
        this.l = r9;
        this.e = r8;
        tt5.a.h("DriveFullScreenManager", "init drive fullscreen manager, driveFullscreenAnimationEnabled=" + r1);
        this.m = (DriveMediaImmersiveVM) new ViewModelProvider(r8).get(DriveMediaImmersiveVM.class);
        DriveNotificationVM r10 = (DriveNotificationVM) new ViewModelProvider(r8).get(DriveNotificationVM.class);
        if (d() == false) goto L10;
        this.f = r8.getResources().getDimensionPixelSize(2131166315);
        this.g = r8.getResources().getDimensionPixelSize(2131166316);
        if (r10.getShowState().getValue() != null) goto L7;
    L9:
        c();
        goto L10
    L7:
        if (((Integer) r10.getShowState().getValue()).intValue() <= 0) goto L9;
        this.g += ((Integer) r10.getShowState().getValue()).intValue();
    L10:
        DriveFullScreenVM r11 = (DriveFullScreenVM) new ViewModelProvider(r8).get(DriveFullScreenVM.class);
        this.p = r11;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r12 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r11.getLiveFullScreen().getValue();
        if (r12 != null) goto L13;
    L15:
        this.a = r0;
        r10.getShowState().observe(r8, new f(this));
        return;
    L13:
        if (r12.a == false) goto L15;
        r0 = true;
        goto L15
    }
}
