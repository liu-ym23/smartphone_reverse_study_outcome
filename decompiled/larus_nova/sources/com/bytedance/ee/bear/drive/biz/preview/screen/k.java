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
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f223730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f223731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f223732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f223733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f223734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f223735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f223736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f223737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f223738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g85.f f223739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f223740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f223741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DriveMediaImmersiveVM f223742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f223743n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f223744o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DriveFullScreenVM f223745p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f223746q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f223747r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.preview.screen.c f223748s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.screen.a f223749t;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f223750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f223751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f223752c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f223750a = true;
            this.f223752c.b();
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation canceled, hide=" + this.f223751b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f223750a == false) goto L5;
            return;
        L5:
            this.f223752c.b();
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation end, hide=" + this.f223751b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f223752c.f223731b.setAlpha(1.0f);
            View r101 = this.f223752c.f223732c;
            if (r101 == null) goto L6;
            r101.setAlpha(1.0f);
        L6:
            if (this.f223751b == true) goto L8;
            this.f223752c.f223731b.setVisibility(0);
        L8:
            tt5.a.h("DriveFullScreenManager", "drive progressive fullscreen animation start, hide=" + this.f223751b);
        }

        public a(k r100, boolean r101) {
            this.f223752c = r100;
            this.f223751b = r101;
            this.f223750a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f223753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f223754b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f223754b.d() == false) goto L16;
            k r101 = this.f223754b;
            DriveMediaImmersiveVM r102 = r101.f223742m;
            boolean r103 = false;
            if (r102 != null) goto L7;
        L9:
            boolean r104 = false;
        L10:
            if (r104 == false) goto L12;
            tt5.a.h("DriveFullScreenManager", "skip window color: mediaImmersiveActive");
        L13:
            if (r103 == false) goto L17;
            this.f223754b.g(this.f223753a);
            this.f223754b.f223734e.getWindow().setStatusBarColor(this.f223753a);
            this.f223754b.f223734e.getWindow().setNavigationBarColor(this.f223753a);
            return;
        L17:
            return;
        L12:
            r103 = !r101.f223740k;
            goto L13
        L7:
            if (r102.isMediaImmersiveActive(r101.f223741l, r101.f223740k) == false) goto L9;
            r104 = true;
            goto L10
        }

        public b(k r100, int r101) {
            this.f223754b = r100;
            this.f223753a = r101;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f223755a;

        public c(k r100) {
            this.f223755a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f223755a.e();
        }
    }

    public final void b() {
        this.f223747r = false;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r100 = this.f223749t;
        if (r100 != null) goto L5;
    L9:
        if (r100 == null) goto L14;
        tt5.a.h("DriveFullScreenManager", "fullscreen animation finished in normal state, notify deferred callback");
        this.f223749t = null;
        e();
        return;
    L14:
        return;
    L5:
        if (this.f223730a == false) goto L9;
        this.f223749t = null;
        tt5.a.h("DriveFullScreenManager", "fullscreen animation finished, continue deferred presentation exit, ext=" + r100.f223713b);
        r100.f223712a = false;
        if (i(r100) == true) goto L12;
        tt5.a.k("DriveFullScreenManager", "deferred presentation exit rejected, clear callback, ext=" + r100.f223713b);
        this.f223748s.f223716a = null;
        return;
    }

    public final void c() {
        if (this.f223746q == true) goto L12;
        this.f223737h = new AnimatorSet();
        this.f223738i = new AnimatorSet();
        Animator r100 = ValueAnimator.ofInt(new int[]{0});
        long r101 = 100;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f223731b, "alpha", new float[]{1.0f, 0.0f}).setDuration(r101);
        View r103 = this.f223732c;
        if (r103 == null) goto L7;
        r100 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{1.0f, 0.0f}).setDuration(r101);
    L7:
        this.f223737h.playTogether(new Animator[]{r102, r100});
        this.f223737h.addListener(new g(this));
        Animator r104 = ValueAnimator.ofInt(new int[]{0});
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f223731b, "alpha", new float[]{0.0f, 1.0f}).setDuration(r101);
        View r106 = this.f223732c;
        if (r106 == null) goto L10;
        r104 = ObjectAnimator.ofFloat(r106, "alpha", new float[]{0.0f, 1.0f}).setDuration(r101);
    L10:
        this.f223738i.playTogether(new Animator[]{r105, r104});
        this.f223738i.addListener(new h(this));
        return;
    }

    public final boolean d() {
        FragmentActivity r100 = this.f223734e;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isFinishing() == true) goto L7;
        return true;
    }

    public final void e() {
        if (this.f223748s.f223716a != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        View r101 = this.f223733d;
        if (r101 != null) goto L12;
        tt5.a.k("DriveFullScreenManager", "exit preview presentation callback dropped: preview view is null");
        this.f223748s.f223716a = null;
        return;
    L12:
        r101.post(new d(this));
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final AnimatorSet a(boolean r110) {
        View r100 = this.f223731b;
        if (r100 != null) goto L6;
        final int r101 = 0;
    L15:
        if (r110 == false) goto L17;
        final int r102 = 0;
    L18:
        View r103 = this.f223732c;
        if (r103 != null) goto L22;
        final int r104 = 0;
    L31:
        if (r110 == false) goto L33;
        final int r105 = 0;
    L34:
        final ViewGroup.LayoutParams r106 = this.f223731b.getLayoutParams();
        View r107 = this.f223732c;
        if (r107 != null) goto L37;
        ViewGroup.LayoutParams r108 = null;
    L38:
        final ViewGroup.LayoutParams r109 = r108;
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r111.setDuration(150);
        r111.addUpdateListener(new e(this, r106, r101, r102, r109, r104, r105));
        AnimatorSet r112 = new AnimatorSet();
        r112.play(r111);
        r112.addListener(new a(this, r110));
        return r112;
    L37:
        r108 = r107.getLayoutParams();
        goto L38
    L33:
        r105 = this.f223735f;
        goto L34
    L22:
        if (r103.getHeight() <= 0) goto L25;
        int r113 = r103.getHeight();
    L24:
        r104 = r113;
        goto L31
    L25:
        ViewGroup.LayoutParams r114 = r103.getLayoutParams();
        if (r114 == null) goto L30;
        r113 = r114.height;
        if (r113 >= 0) goto L24;
    L30:
        r113 = 0;
        goto L24
    L17:
        r102 = this.f223736g;
        goto L18
    L6:
        if (r100.getHeight() <= 0) goto L9;
        int r115 = r100.getHeight();
    L8:
        r101 = r115;
        goto L15
    L9:
        ViewGroup.LayoutParams r116 = r100.getLayoutParams();
        if (r116 == null) goto L14;
        r115 = r116.height;
        if (r115 >= 0) goto L8;
    L14:
        r115 = 0;
        goto L8
    }

    public final void g(int r100) {
        if (this.f223740k == false) goto L5;
        this.f223733d.setBackgroundColor(r100);
        return;
    L5:
        FragmentActivity r101 = this.f223734e;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getWindow() == null) goto L18;
        View r102 = this.f223734e.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L14:
        r102.setBackgroundColor(r100);
        return;
    }

    public final boolean i(com.bytedance.ee.bear.drive.biz.preview.screen.a r100) {
        if (d() == true) goto L5;
        return false;
    L5:
        String r101 = r100.f223713b;
        boolean r102 = r100.f223712a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.drive.disable_pdf_immersive") == true) goto L8;
    L11:
        this.f223730a = r102;
        if (this.f223746q == false) goto L15;
        this.f223747r = true;
        this.f223745p.getLiveFullScreen().setValue(r100);
    L15:
        if (((g85.b) this.f223739j).m(r101) == false) goto L18;
        h(this.f223734e.getResources().getColor(R.color.bg_base), r101);
    L29:
        if (this.f223746q == true) goto L31;
        this.f223745p.getLiveFullScreen().postValue(r100);
    L31:
        return true;
    L18:
        if (((g85.b) this.f223739j).j(r101, null) == false) goto L21;
        h(this.f223734e.getResources().getColor(R.color.static_black), r101);
        goto L29
    L21:
        if (((g85.b) this.f223739j).o(r101, null) == false) goto L24;
        h(this.f223734e.getResources().getColor(R.color.static_black), r101);
        goto L29
    L24:
        if (i75.h.i(this.f223744o) == false) goto L26;
        int r103 = R.color.bg_body;
    L27:
        h(this.f223734e.getResources().getColor(r103), r101);
        goto L29
    L26:
        r103 = R.color.bg_body_overlay;
        goto L27
    L8:
        if (((g85.b) this.f223739j).m(r101) == false) goto L11;
        tt5.a.k("DriveFullScreenManager", "setFullScreen, extension=pdf, isFullScreen=" + r102 + ", need block");
        return false;
    }

    public static void j(View r100, int r101) {
        r100.getLayoutParams().height = r101;
        r100.requestLayout();
    }

    public final void f(FragmentActivity r100, com.bytedance.ee.bear.drive.biz.preview.screen.a r101) {
        if (com.bytedance.ee.util.ui.b.a(r100) == true) goto L5;
    L24:
        tt5.a.k("DRIVE_PREVIEW_FLOW", "requestVideoFullScreen, activity=" + r100);
        return;
    L5:
        if (r100.getWindow() == null) goto L24;
        boolean r102 = r101.f223712a;
        View r103 = this.f223731b;
        if (r102 == false) goto L10;
        int r104 = 8;
    L11:
        r103.setVisibility(r104);
        if (r102 == true) goto L15;
        j(this.f223731b, this.f223736g);
    L15:
        if (((g85.b) this.f223739j).m(r101.f223713b) == false) goto L17;
    L22:
        this.f223730a = r102;
        this.f223745p.getLiveFullScreen().postValue(r101);
        return;
    L17:
        if (r101.f223715d == true) goto L22;
        if (r102 == false) goto L21;
        r100.getWindow().addFlags(1024);
        goto L22
    L21:
        r100.getWindow().clearFlags(1024);
        goto L22
    L10:
        r104 = 0;
        goto L11
    }

    public final void h(int r110, String r111) {
        this.f223737h.cancel();
        this.f223738i.cancel();
        boolean r100 = false;
        if (this.f223746q == false) goto L12;
        if (this.f223732c == null) goto L8;
    L10:
        this.f223737h = a(true);
        this.f223738i = a(false);
    L39:
        if (this.f223730a == false) goto L41;
        this.f223737h.addListener(new b(this, r110));
        this.f223737h.start();
        return;
    L41:
        DriveMediaImmersiveVM r112 = this.f223742m;
        if (r112 != null) goto L44;
    L46:
        boolean r113 = false;
    L47:
        if (r113 == false) goto L49;
        tt5.a.h("DriveFullScreenManager", "skip window color: mediaImmersiveActive");
    L50:
        if (r100 == false) goto L56;
        this.f223734e.getWindow().setStatusBarColor(this.f223745p.getOriginStatusBarColor());
        this.f223734e.getWindow().setNavigationBarColor(this.f223745p.getOriginNavigationBarColor());
        Resources r114 = this.f223734e.getResources();
        if (((g85.b) this.f223739j).d(r111) == false) goto L54;
        int r115 = R.color.static_white;
    L55:
        g(r114.getColor(r115));
        goto L56
    L54:
        r115 = R.color.bg_body_overlay;
    L56:
        this.f223738i.addListener(new c(this));
        this.f223738i.start();
        return;
    L49:
        r100 = !this.f223740k;
        goto L50
    L44:
        if (r112.isMediaImmersiveActive(this.f223741l, this.f223740k) == false) goto L46;
        r113 = true;
        goto L47
    L8:
        if ((this.f223733d.getParent() instanceof View) == false) goto L10;
        this.f223732c = ((View) this.f223733d.getParent()).findViewById(R.id.drive_extra_fileinfo);
        goto L10
    L12:
        if (((g85.b) this.f223739j).m(this.f223744o) == false) goto L14;
    L23:
        boolean r101 = true;
    L24:
        if (r101 == false) goto L39;
        this.f223737h = new AnimatorSet();
        this.f223738i = new AnimatorSet();
        Animator r102 = ValueAnimator.ofInt(new int[]{0});
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{0});
        long r104 = 100;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f223731b, "alpha", new float[]{1.0f, 0.0f}).setDuration(r104);
        View r106 = this.f223732c;
        if (r106 == null) goto L29;
        r102 = ObjectAnimator.ofFloat(r106, "alpha", new float[]{1.0f, 0.0f}).setDuration(r104);
    L29:
        if (((g85.b) this.f223739j).m(this.f223744o) == false) goto L31;
        r103 = com.bytedance.ee.util.ui.g.a(this.f223731b, this.f223736g, 0).setDuration(r104);
    L31:
        this.f223737h.playTogether(new Animator[]{r105, r102, r103});
        this.f223737h.addListener(new i(this));
        Animator r107 = ValueAnimator.ofInt(new int[]{0});
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{0});
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f223731b, "alpha", new float[]{0.0f, 1.0f}).setDuration(r104);
        View r116 = this.f223732c;
        if (r116 == null) goto L35;
        r107 = ObjectAnimator.ofFloat(r116, "alpha", new float[]{0.0f, 1.0f}).setDuration(r104);
    L35:
        if (((g85.b) this.f223739j).m(this.f223744o) == false) goto L37;
        r108 = com.bytedance.ee.util.ui.g.a(this.f223731b, 0, this.f223736g).setDuration(r104);
    L37:
        this.f223738i.playTogether(new Animator[]{r109, r107, r108});
        this.f223738i.addListener(new j(this));
        goto L39
    L14:
        if (this.f223743n == 1) goto L23;
        if (this.f223740k == true) goto L18;
    L22:
        r101 = false;
        goto L24
    L18:
        if (i75.h.g(this.f223744o) == true) goto L23;
        if (i75.h.j(this.f223744o) == false) goto L22;
        goto L22
    }

    public k(View r100, View r101, View r102, boolean r103, FragmentActivity r104, boolean r105) {
        boolean r106 = false;
        this.f223730a = false;
        this.f223737h = new AnimatorSet();
        this.f223738i = new AnimatorSet();
        this.f223740k = false;
        this.f223741l = false;
        this.f223743n = 0;
        boolean r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("spacekit.mobile.drive_fullscreen_animation");
        this.f223746q = r107;
        this.f223747r = false;
        this.f223748s = new com.bytedance.ee.bear.drive.biz.preview.screen.c();
        this.f223739j = o75.b.a().getMimeTypeManager();
        this.f223731b = r100;
        this.f223732c = r101;
        this.f223733d = r102;
        this.f223740k = r103;
        this.f223741l = r105;
        this.f223734e = r104;
        tt5.a.h("DriveFullScreenManager", "init drive fullscreen manager, driveFullscreenAnimationEnabled=" + r107);
        this.f223742m = (DriveMediaImmersiveVM) new ViewModelProvider(r104).get(DriveMediaImmersiveVM.class);
        DriveNotificationVM r108 = (DriveNotificationVM) new ViewModelProvider(r104).get(DriveNotificationVM.class);
        if (d() == false) goto L10;
        this.f223735f = r104.getResources().getDimensionPixelSize(R.dimen.drive_main_page_file_extra_view);
        this.f223736g = r104.getResources().getDimensionPixelSize(R.dimen.drive_main_page_title_bar_height);
        if (r108.getShowState().getValue() != null) goto L7;
    L9:
        c();
        goto L10
    L7:
        if (r108.getShowState().getValue().intValue() <= 0) goto L9;
        this.f223736g += r108.getShowState().getValue().intValue();
    L10:
        DriveFullScreenVM r109 = (DriveFullScreenVM) new ViewModelProvider(r104).get(DriveFullScreenVM.class);
        this.f223745p = r109;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r110 = r109.getLiveFullScreen().getValue();
        if (r110 != null) goto L13;
    L15:
        this.f223730a = r106;
        r108.getShowState().observe(r104, new f(this));
        return;
    L13:
        if (r110.f223712a == false) goto L15;
        r106 = true;
        goto L15
    }
}
