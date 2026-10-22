package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import hq9.f1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class m0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f327525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f327526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f327527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f327528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f327529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SingleFloatBall f327531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f327532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SingleFloatWindowState f327533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ObjectAnimator f327534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ObjectAnimator f327535k;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f327536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f327537b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SingleFloatBall r101 = this.f327536a.f327531g;
            r101.f327468b.removeView(r101);
            Function0 r102 = this.f327537b;
            if (r102 == null) goto L6;
            r102.invoke();
            return;
        }

        public b(m0 r100, Function0 r101) {
            this.f327536a = r100;
            this.f327537b = r101;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowManager.LayoutParams f327538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f327539b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f327538a.x >= 0) goto L6;
            final m0 r101 = this.f327539b;
            r101.getClass();
            ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r102.setDuration(150);
            r102.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            r102.addUpdateListener(new c0(r101));
            r102.start();
            return;
        }

        public c(WindowManager.LayoutParams r100, m0 r101) {
            this.f327538a = r100;
            this.f327539b = r101;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f327540a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(m0 r100) {
            this.f327540a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            m0 r101 = this.f327540a;
            r101.f327533i = SingleFloatWindowState.MINIMIZE;
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f327541a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public e(m0 r100) {
            this.f327541a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            m0 r101 = this.f327541a;
            r101.f327533i = SingleFloatWindowState.MAXIMIZE;
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f327542a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public f(m0 r100) {
            this.f327542a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            m0 r101 = this.f327542a;
            r101.f327533i = SingleFloatWindowState.MAXIMIZE;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void c() {
        View r100 = this.f327532h;
        if (r100 == null) goto L6;
        removeView(r100);
        return;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void e() {
        this.f327535k.end();
        this.f327531g.setAlpha(0.0f);
        SingleFloatBall r100 = this.f327531g;
        r100.f327468b.addView(r100, r100.f327471e);
        this.f327531g.post(new k0(this));
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void g() {
        WindowManager.LayoutParams r100 = this.f327531g.getParams();
        int r101 = com.larus.utils.m0.f375450a;
        r100.y = (com.larus.utils.m0.a(this.f327531g.getContext()) - r100.height) / 2;
        this.f327531g.c(r100);
    }

    public final f1 j() {
        return (f1) this.f327525a.getValue();
    }

    public final int k() {
        return ((Number) this.f327527c.getValue()).intValue();
    }

    public final int l() {
        return ((Number) this.f327528d.getValue()).intValue();
    }

    public final int m() {
        return ((Number) this.f327529e.getValue()).intValue();
    }

    public final void o() {
        if (j().e() == false) goto L5;
        final WindowManager.LayoutParams r100 = this.f327531g.getParams();
        AnimatorSet r110 = new AnimatorSet();
        u r101 = this.f327531g.getHotInfo();
        int r111 = RangesKt.coerceAtLeast(r100.y - ((this.f327530f - k()) / 2), r101.f327559b);
        int r112 = com.larus.utils.m0.f375450a;
        final ValueAnimator r113 = ValueAnimator.ofInt(new int[]{r100.y, RangesKt.coerceAtMost(r111, (com.larus.utils.m0.a(this.f327531g.getContext()) - r101.f327560c) - r100.height)});
        r113.setDuration(200);
        r113.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        final ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r100.x, r101.f327558a});
        r114.setDuration(150);
        r114.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r114);
        r114.addListener(new f(this));
        final ValueAnimator r115 = ValueAnimator.ofInt(new int[]{r100.height, this.f327530f});
        r115.setDuration(r113.getDuration());
        r115.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        final ValueAnimator r116 = ValueAnimator.ofInt(new int[]{m(), l()});
        r116.setDuration(r113.getDuration());
        r116.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{0, 100});
        r102.setDuration(Math.max(r114.getDuration(), r113.getDuration()));
        r102.addUpdateListener(new l0(r100, r114, r113, r115, r116, this));
        r110.playTogether(new Animator[]{r114, r113, r102, r115, r116});
        r110.start();
        return;
    L5:
        final WindowManager.LayoutParams r103 = this.f327531g.getParams();
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r103.x, this.f327531g.getHotInfo().f327558a});
        r104.setDuration(150);
        r104.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r104.addUpdateListener(new b0(r103, this));
        Intrinsics.checkNotNull(r104);
        r104.addListener(new n0(this));
        r104.start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final SingleFloatWindowState d() {
        return this.f327533i;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void a(Function0<Unit> r100) {
        this.f327534j.end();
        this.f327531g.setAlpha(1.0f);
        this.f327535k.addListener(new b(this, r100));
        this.f327535k.start();
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final Rect f(boolean r100) {
        SingleFloatBall r101 = this.f327531g;
        r101.getClass();
        Rect r102 = new Rect();
        if (r101.f327468b.b(r101) == true) goto L6;
        if (r100 == true) goto L6;
    L10:
        return r102;
    L6:
        if (r101.b() == false) goto L8;
        int r103 = r101.f327471e.x;
    L9:
        WindowManager.LayoutParams r104 = r101.f327471e;
        int r105 = r104.width + r103;
        int r106 = r104.y;
        r102.set(r103, r106, r105, r104.height + r106);
        goto L10
    L8:
        int r107 = com.larus.utils.m0.f375450a;
        int r108 = com.larus.utils.m0.b(r101.getContext());
        WindowManager.LayoutParams r109 = r101.f327471e;
        r103 = (r108 - r109.x) - r109.width;
        goto L9
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void i(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        SingleFloatBall r101 = this.f327531g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        h r102 = r101.f327468b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger r103 = FLogger.f375446a;
        r103.d("FloatWindowManager", "forwardSwitch activity: " + r100);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Activity r105 = com.larus.common_ui.floatwindow.view.e.b(r100);     // Catch: Throwable -> L5
        r103.d("FloatWindowManager", "forwardSwitch forwardActivity: " + r105);     // Catch: Throwable -> L5
        r102.e(r105);     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        FLogger.f375446a.d("FloatWindowManager", "forwardSwitch crash. throwable:" + r107.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void removeView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f327532h != r100) goto L5;
        this.f327532h = null;
    L5:
        SingleFloatBall r101 = this.f327531g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        FLogger.f375446a.d("SingleFloatBall", "removeContentView.");
        r101.f327472f.removeView(r100);
        WindowManager.LayoutParams r102 = r101.f327471e;
        r102.width = 0;
        r102.height = 0;
        r101.f327468b.updateViewLayout(r101, r102);
    }

    public m0(Application r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "winManager");
        this.f327525a = LazyKt.lazy(new f0());
        this.f327526b = LazyKt.lazy(new g0(this));
        this.f327527c = LazyKt.lazy(new h0());
        this.f327528d = LazyKt.lazy(new i0());
        this.f327529e = LazyKt.lazy(new j0());
        SingleFloatBall r102 = new SingleFloatBall(r100, this, r101);
        this.f327531g = r102;
        this.f327533i = SingleFloatWindowState.MAXIMIZE;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r102, View.ALPHA, new float[]{0.0f, 1.0f});
        r103.setDuration(150);
        r103.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        this.f327534j = r103;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, View.ALPHA, new float[]{1.0f, 0.0f});
        r104.setDuration(150);
        r104.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        this.f327535k = r104;
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void b(SingleFloatWindowState r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100 != this.f327533i) goto L7;
        return;
    L7:
        if (r101 == true) goto L9;
        WindowManager.LayoutParams r102 = this.f327531g.getParams();
        u r103 = this.f327531g.getHotInfo();
        SingleFloatWindowState r104 = SingleFloatWindowState.MAXIMIZE;
        if (r100 != r104) goto L22;
        FLogger.f375446a.i("SingleFloatWindowHandler", "changeWindowStateWithoutAnimation. MAXIMIZE");
        r102.x = this.f327531g.getHotInfo().f327558a;
        if (j().e() == false) goto L17;
        int r105 = RangesKt.coerceAtLeast(r102.y - ((this.f327530f - k()) / 2), r103.f327559b);
        int r106 = com.larus.utils.m0.f375450a;
        r102.y = RangesKt.coerceAtMost(r105, (com.larus.utils.m0.a(this.f327531g.getContext()) - r103.f327560c) - r102.height);
        r102.height = this.f327530f;
        this.f327531g.setClipViewCornerRadius(l());
    L17:
        SingleFloatBall r107 = this.f327531g;
        r107.c(r107.getParams());
        SingleFloatBall r108 = this.f327531g;
        if (r108.b() == false) goto L20;
        ImageView r109 = r108.f327475i;
    L21:
        e1.o(r109);
        this.f327533i = r104;
        return;
    L20:
        r109 = r108.f327476j;
        goto L21
    L22:
        FLogger.f375446a.i("SingleFloatWindowHandler", "changeWindowStateWithoutAnimation. MINIMIZE");
        r102.x = 0 - (r102.width - ((Number) this.f327526b.getValue()).intValue());
        if (j().e() == false) goto L25;
        int r110 = RangesKt.coerceAtLeast(r102.y + ((this.f327530f - k()) / 2), r103.f327559b);
        int r111 = com.larus.utils.m0.f375450a;
        r102.y = RangesKt.coerceAtMost(r110, (com.larus.utils.m0.a(this.f327531g.getContext()) - r103.f327560c) - r102.height);
        r102.height = k();
        this.f327531g.setClipViewCornerRadius(m());
    L25:
        this.f327531g.c(r102);
        SingleFloatBall r112 = this.f327531g;
        if (r112.b() == false) goto L28;
        ImageView r113 = r112.f327475i;
    L29:
        r113.setAlpha(1.0f);
        e1.x(r113);
        this.f327531g.setMaskClickListener(new a0(this));
        this.f327533i = SingleFloatWindowState.MINIMIZE;
        return;
    L28:
        r113 = r112.f327476j;
        goto L29
    L9:
        if (r100 != SingleFloatWindowState.MAXIMIZE) goto L11;
        FLogger.f375446a.i("SingleFloatWindowHandler", "changeWindowStateWithAnimation. MAXIMIZE");
        o();
        this.f327531g.setMaskClickListener(null);
        return;
    L11:
        FLogger.f375446a.i("SingleFloatWindowHandler", "changeWindowStateWithAnimation. MINIMIZE");
        n(true, true);
    }

    public final void n(boolean r110, boolean r111) {
        final WindowManager.LayoutParams r100 = this.f327531g.getParams();
        AnimatorSet r101 = new AnimatorSet();
        u r102 = this.f327531g.getHotInfo();
        if (r111 == false) goto L5;
        long r103 = 2;
    L6:
        int r104 = r100.x;
        if (r104 < ((-r100.width) / 2)) goto L14;
        if (r104 < 0) goto L10;
    L11:
        if (r110 == true) goto L14;
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
    L21:
        boolean r106 = false;
    L22:
        if (r105 == true) goto L24;
    L26:
        if (r106 == false) goto L28;
        int r107 = r100.y - ((this.f327530f - k()) / 2);
    L29:
        int r108 = RangesKt.coerceAtLeast(r107, r102.f327559b);
        int r109 = com.larus.utils.m0.f375450a;
        final ValueAnimator r112 = ValueAnimator.ofInt(new int[]{r100.y, RangesKt.coerceAtMost(r108, (com.larus.utils.m0.a(this.f327531g.getContext()) - r102.f327560c) - r100.height)});
        long r113 = ((long) 200) * r103;
        r112.setDuration(r113);
        r112.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        if (r105 == false) goto L32;
        this.f327531g.setMaskClickListener(new d0(this));
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r100.x, -(r100.width - ((Number) this.f327526b.getValue()).intValue())});
        r114.setDuration(((long) 150) * r103);
        r114.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r114);
        r114.addListener(new d(this));
    L33:
        final ValueAnimator r115 = r114;
        int[] r116 = new int[2];
        r116[0] = r100.height;
        if (r105 == true) goto L36;
    L38:
        if (r106 == false) goto L40;
        int r117 = this.f327530f;
    L41:
        r116[1] = r117;
        final ValueAnimator r118 = ValueAnimator.ofInt(r116);
        r118.setDuration(r112.getDuration());
        r118.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        int[] r119 = new int[2];
        if (this.f327533i == SingleFloatWindowState.MINIMIZE) goto L44;
    L46:
        int r120 = l();
    L47:
        r119[0] = r120;
        if (r105 == true) goto L50;
    L52:
        int r121 = l();
    L53:
        r119[1] = r121;
        final ValueAnimator r122 = ValueAnimator.ofInt(r119);
        r122.setDuration(r112.getDuration());
        r122.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ValueAnimator r123 = ValueAnimator.ofInt(new int[]{0, 100});
        r123.setDuration(Math.max(r115.getDuration(), r112.getDuration()));
        r123.addUpdateListener(new e0(r100, r115, r112, r118, r122, this));
        Intrinsics.checkNotNull(r123);
        r123.addListener(new c(r100, this));
        r101.playTogether(new Animator[]{r115, r112, r123, r118, r122});
        r101.start();
        return;
    L50:
        if (j().e() == false) goto L52;
        r121 = m();
        goto L53
    L44:
        if (j().e() == false) goto L46;
        r120 = m();
        goto L47
    L40:
        r117 = r100.height;
        goto L41
    L36:
        if (j().e() == false) goto L38;
        r117 = k();
        goto L41
    L32:
        r114 = ValueAnimator.ofInt(new int[]{r100.x, r102.f327558a});
        r114.setDuration(r113);
        r114.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        Intrinsics.checkNotNull(r114);
        r114.addListener(new e(this));
        goto L33
    L28:
        r107 = r100.y;
        goto L29
    L24:
        if (j().e() == false) goto L26;
        r107 = r100.y + ((r100.height - k()) / 2);
        goto L29
    L17:
        if (j().e() == false) goto L21;
        if (this.f327533i != SingleFloatWindowState.MINIMIZE) goto L21;
        r106 = true;
        goto L22
    L10:
        if (this.f327533i != SingleFloatWindowState.MAXIMIZE) goto L11;
    L14:
        r105 = true;
        goto L15
    L5:
        r103 = 1;
        goto L6
    }

    @Override // com.larus.common_ui.floatwindow.view.v
    public final void h(e19.h r100, SingleFloatWindowState r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f327530f = r100.getHeight();
        if (this.f327533i == SingleFloatWindowState.MINIMIZE) goto L5;
    L7:
        int r103 = r100.getHeight();
    L8:
        View r104 = r100.getContentView();
        this.f327532h = r104;
        final SingleFloatBall r105 = this.f327531g;
        int r106 = r100.getWidth();
        int r107 = r100.getHeight();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "view");
        WindowManager.LayoutParams r108 = r105.f327471e;
        r108.width = r106;
        r108.height = r103;
        if (r105.f327472f.indexOfChild(r104) == (-1)) goto L11;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L15;
        FLogger.f375446a.d("SingleFloatBall", "updateContentView. has contained");
        r104.getLayoutParams().width = r106;
        r104.getLayoutParams().height = r107;
        r105.f327468b.updateViewLayout(r105, r105.f327471e);
    L17:
        if (r105.f327473g.getBackground() != null) goto L19;
    L20:
        boolean r110 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L23;
        int r111 = R.color.larus_float_window_default_mask_dark;
    L24:
        ColorDrawable r112 = new ColorDrawable(ContextCompat.getColor(r104.getContext(), r111));
        r105.f327473g.setBackground(r112);
        r105.f327474h.setBackground(r112);
    L25:
        r105.postDelayed(new w(r105), 1100);
        b(r101, r102);
        return;
    L23:
        r111 = R.color.larus_float_window_default_mask;
        goto L24
    L19:
        if (r105.f327474h.getBackground() != null) goto L25;
    L15:
        r105.f327472f.removeAllViews();
        FLogger.f375446a.d("SingleFloatBall", "updateContentView. remove all and add");
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(r106, r107);
        r105.f327472f.addView(r104, r113);
        r105.f327468b.updateViewLayout(r105, r105.f327471e);
        goto L17
    L11:
        r109 = false;
        goto L13
    L5:
        if (j().e() == false) goto L7;
        r103 = k();
        goto L8
    }
}
