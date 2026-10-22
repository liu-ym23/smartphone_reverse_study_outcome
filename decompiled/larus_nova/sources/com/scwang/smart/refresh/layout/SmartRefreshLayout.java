package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.camera.video.AudioStats;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes34.dex */
public class SmartRefreshLayout extends ViewGroup implements vpa.d, NestedScrollingParent {
    public static final ViewGroup.MarginLayoutParams F2 = null;
    public final int[] A;
    public final boolean B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public ValueAnimator E2;
    public final boolean F;
    public final boolean G;
    public final float G1;
    public final boolean H;
    public final NestedScrollingChildHelper H0;
    public vpa.c H1;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f405792J;
    public final boolean K;
    public boolean L;
    public final NestedScrollingParentHelper L0;
    public vpa.b L1;
    public final boolean M;
    public aqa.a M1;
    public final boolean N;
    public final boolean O;
    public final boolean P;
    public int P0;
    public Paint P1;
    public boolean Q;
    public final Handler Q1;
    public final boolean R;
    public final boolean S;
    public final i S1;
    public boolean T;
    public RefreshState T1;
    public boolean U;
    public boolean V;
    public wpa.a V0;
    public RefreshState V1;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f405794b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f405795b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public long f405796b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f405799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f405800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f405801g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public wpa.a f405802g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public int f405803g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f405804h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final int f405805h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f405806h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f405807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f405808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f405809k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f405810k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final int f405811k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f405812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public char f405813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f405814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f405815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f405816p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f405817p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final float f405818p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f405819p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f405820q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f405821r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f405822s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f405823t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f405824u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f405825v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final float f405826v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f405827v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f405828w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Scroller f405829x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final float f405830x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public MotionEvent f405831x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final VelocityTracker f405832y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final float f405833y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public Runnable f405834y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final zpa.b f405835z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f405836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wpa.b f405837b;

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f405836a = 0;
            this.f405837b = null;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_srlBackgroundColor, R.attr.layout_srlSpinnerStyle});
            this.f405836a = r102.getColor(0, 0);
            if (r102.hasValue(1) == false) goto L5;
            wpa.b[] r103 = wpa.b.f560646g;
            wpa.b r104 = wpa.b.f560642c;
            this.f405837b = r103[r102.getInt(1, 0)];
        L5:
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f405836a = 0;
            this.f405837b = null;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405838a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f405838a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f405838a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f405838a[RefreshState.PullUpToLoad.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f405838a[RefreshState.PullDownCanceled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f405838a[RefreshState.PullUpCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f405838a[RefreshState.ReleaseToRefresh.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f405838a[RefreshState.ReleaseToLoad.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f405838a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f405838a[RefreshState.RefreshReleased.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f405838a[RefreshState.LoadReleased.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f405838a[RefreshState.Refreshing.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f405838a[RefreshState.Loading.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f405839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405840b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (r100 != null) goto L4;
        L6:
            this.f405840b.setStateDirectLoading(this.f405839a);
            return;
        L4:
            if (r100.getDuration() != 0) goto L6;
        }

        public b(SmartRefreshLayout r100, boolean r101) {
            this.f405840b = r100;
            this.f405839a = r101;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f405841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405842b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (r100 != null) goto L4;
        L6:
            this.f405842b.f405796b2 = System.currentTimeMillis();
            this.f405842b.p(RefreshState.Refreshing);
            SmartRefreshLayout r101 = this.f405842b;
            r101.getClass();
            r101.k(3000, true, Boolean.FALSE);
            SmartRefreshLayout r102 = this.f405842b;
            vpa.c r103 = r102.H1;
            if (r103 == null) goto L9;
            int r104 = r102.P0;
            r103.g(r102, r104, (int) (r102.f405818p1 * r104));
        L9:
            this.f405842b.getClass();
            return;
        L4:
            if (r100.getDuration() != 0) goto L6;
        }

        public c(SmartRefreshLayout r100, boolean r101) {
            this.f405842b = r100;
            this.f405841a = r101;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405843a;

        public d(SmartRefreshLayout r100) {
            this.f405843a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (r100 != null) goto L4;
        L6:
            SmartRefreshLayout r101 = this.f405843a;
            r101.E2 = null;
            if (r101.f405794b != 0) goto L15;
            RefreshState r102 = r101.T1;
            RefreshState r103 = RefreshState.None;
            if (r102 == r103) goto L15;
            if (r102.isOpening == true) goto L15;
            if (r102.isDragging == true) goto L15;
            r101.p(r103);
            return;
        L15:
            RefreshState r104 = r101.T1;
            if (r104 == r101.V1) goto L20;
            r101.setViceState(r104);
            return;
        L20:
            return;
        L4:
            if (r100.getDuration() != 0) goto L6;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405844a;

        public e(SmartRefreshLayout r100) {
            this.f405844a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f405844a.S1.b(((Integer) r100.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405845a;

        @Override // java.lang.Runnable
        public final void run() {
            SmartRefreshLayout r100 = this.f405845a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            r100.i(2000, true, false);     // Catch: Throwable -> L4
            this.f405845a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(SmartRefreshLayout r100) {
            this.f405845a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f405846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f405847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f405848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f405849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f405850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405851f;

        public final void a() {
            SmartRefreshLayout r100 = this.f405851f;
            if (r100.f405834y2 == this) goto L5;
            return;
        L5:
            if (r100.T1.isFinishing == false) goto L7;
            return;
        L7:
            if (Math.abs(r100.f405794b) >= Math.abs(this.f405847b)) goto L9;
            double r101 = this.f405850e;
            int r102 = this.f405846a + 1;
            this.f405846a = r102;
            this.f405850e = (float) (r101 * Math.pow(0.949999988079071d, r102 * 2));
        L13:
            long r103 = AnimationUtils.currentAnimationTimeMillis();
            float r104 = this.f405850e * (((r103 - this.f405848c) * 1.0f) / 1000.0f);
            if (Math.abs(r104) < 1.0f) goto L16;
            this.f405848c = r103;
            float r105 = this.f405849d + r104;
            this.f405849d = r105;
            this.f405851f.o(r105);
            this.f405851f.Q1.postDelayed(this, 10);
            return;
        L16:
            SmartRefreshLayout r106 = this.f405851f;
            RefreshState r107 = r106.V1;
            boolean r108 = r107.isDragging;
            if (r108 == true) goto L19;
        L21:
            if (r108 == true) goto L23;
        L25:
            SmartRefreshLayout r109 = this.f405851f;
            r109.f405834y2 = null;
            if (Math.abs(r109.f405794b) < Math.abs(this.f405847b)) goto L32;
            int r110 = Math.min(Math.max((int) (Math.abs(this.f405851f.f405794b - this.f405847b) / zpa.b.f573281a), 30), 100) * 10;
            SmartRefreshLayout r111 = this.f405851f;
            r111.g(this.f405847b, 0, r111.f405835z, r110);
            return;
        L32:
            return;
        L23:
            if (r107.isFooter == false) goto L25;
            r106.S1.c(RefreshState.PullUpCanceled);
            goto L25
        L19:
            if (r107.isHeader == false) goto L21;
            r106.S1.c(RefreshState.PullDownCanceled);
            goto L25
        L9:
            if (this.f405847b == 0) goto L11;
            double r112 = this.f405850e;
            int r113 = this.f405846a + 1;
            this.f405846a = r113;
            this.f405850e = (float) (r112 * Math.pow(0.44999998807907104d, r113 * 2));
            goto L13
        L11:
            double r114 = this.f405850e;
            int r115 = this.f405846a + 1;
            this.f405846a = r115;
            this.f405850e = (float) (r114 * Math.pow(0.8500000238418579d, r115 * 2));
            goto L13
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

        public g(SmartRefreshLayout r100, float r101, int r102) {
            this.f405851f = r100;
            this.f405846a = 0;
            this.f405849d = 0.0f;
            this.f405850e = r101;
            this.f405847b = r102;
            this.f405848c = AnimationUtils.currentAnimationTimeMillis();
            r100.Q1.postDelayed(this, 10);
            if (r101 <= 0.0f) goto L5;
            r100.S1.c(RefreshState.PullDownToRefresh);
            return;
        L5:
            r100.S1.c(RefreshState.PullUpToLoad);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f405852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f405853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f405854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f405855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405856e;

        public final void a() {
            SmartRefreshLayout r100 = this.f405856e;
            if (r100.f405834y2 == this) goto L5;
            return;
        L5:
            if (r100.T1.isFinishing == true) goto L34;
            long r101 = AnimationUtils.currentAnimationTimeMillis();
            long r102 = r101 - this.f405855d;
            float r103 = (float) (((double) this.f405853b) * Math.pow(0.98f, (r101 - this.f405854c) / (1000.0f / 10)));
            this.f405853b = r103;
            float r104 = r103 * ((r102 * 1.0f) / 1000.0f);
            if (Math.abs(r104) <= 1.0f) goto L31;
            this.f405855d = r101;
            int r105 = (int) (this.f405852a + r104);
            this.f405852a = r105;
            SmartRefreshLayout r106 = this.f405856e;
            if ((r106.f405794b * r105) <= 0) goto L11;
            r106.S1.b(r105, true);
            this.f405856e.Q1.postDelayed(this, 10);
            return;
        L11:
            r106.f405834y2 = null;
            r106.S1.b(0, true);
            View r107 = this.f405856e.M1.f15983c;
            int r108 = (int) (-this.f405853b);
            float r109 = zpa.b.f573281a;
            if ((r107 instanceof ScrollView) == false) goto L15;
            ((ScrollView) r107).fling(r108);
        L26:
            SmartRefreshLayout r110 = this.f405856e;
            if (r110.f405819p2 == true) goto L29;
            return;
        L29:
            if (r104 <= 0.0f) goto L37;
            r110.f405819p2 = false;
            return;
        L37:
            return;
        L15:
            if ((r107 instanceof AbsListView) == false) goto L18;
            ((AbsListView) r107).fling(r108);
            goto L26
        L18:
            if ((r107 instanceof WebView) == false) goto L21;
            ((WebView) r107).flingScroll(0, r108);
            goto L26
        L21:
            if ((r107 instanceof NestedScrollView) == false) goto L24;
            ((NestedScrollView) r107).fling(r108);
            goto L26
        L24:
            if ((r107 instanceof RecyclerView) == false) goto L26;
            ((RecyclerView) r107).fling(0, r108);
            goto L26
        L31:
            this.f405856e.f405834y2 = null;
            return;
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

        public h(SmartRefreshLayout r100, float r101) {
            this.f405856e = r100;
            this.f405854c = 0;
            this.f405855d = AnimationUtils.currentAnimationTimeMillis();
            this.f405853b = r101;
            this.f405852a = r100.f405794b;
        }
    }

    public class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405857a;

        public i(SmartRefreshLayout r100) {
            this.f405857a = r100;
        }

        public final ValueAnimator a(int r100) {
            SmartRefreshLayout r101 = this.f405857a;
            return r101.g(r100, 0, r101.f405835z, r101.f405800f);
        }

        public final void c(RefreshState r100) {
            switch(a.f405838a[r100.ordinal()]) {
                case 1: goto L83;
                case 2: goto L77;
                case 3: goto L63;
                case 4: goto L57;
                case 5: goto L45;
                case 6: goto L39;
                case 7: goto L25;
                case 8: goto L19;
                case 9: goto L13;
                case 10: goto L7;
                case 11: goto L6;
                case 12: goto L5;
                default: goto L4;
            };
        L4:
            this.f405857a.p(r100);
            return;
        L5:
            this.f405857a.setStateLoading(true);
            return;
        L6:
            this.f405857a.setStateRefreshing(true);
            return;
        L7:
            SmartRefreshLayout r101 = this.f405857a;
            if (r101.T1.isOpening == false) goto L10;
        L12:
            this.f405857a.setViceState(RefreshState.LoadReleased);
            return;
        L10:
            if (r101.m(r101.C) == false) goto L12;
            this.f405857a.p(RefreshState.LoadReleased);
            return;
        L13:
            SmartRefreshLayout r102 = this.f405857a;
            if (r102.T1.isOpening == false) goto L16;
        L18:
            this.f405857a.setViceState(RefreshState.RefreshReleased);
            return;
        L16:
            if (r102.m(r102.B) == false) goto L18;
            this.f405857a.p(RefreshState.RefreshReleased);
            return;
        L19:
            SmartRefreshLayout r103 = this.f405857a;
            if (r103.T1.isOpening == false) goto L22;
        L24:
            this.f405857a.setViceState(RefreshState.ReleaseToTwoLevel);
            return;
        L22:
            if (r103.m(r103.B) == false) goto L24;
            this.f405857a.p(RefreshState.ReleaseToTwoLevel);
            return;
        L25:
            SmartRefreshLayout r104 = this.f405857a;
            if (r104.m(r104.C) == false) goto L38;
            SmartRefreshLayout r105 = this.f405857a;
            RefreshState r106 = r105.T1;
            if (r106.isOpening == true) goto L38;
            if (r106.isFinishing == true) goto L38;
            if (r105.T == true) goto L34;
        L37:
            r105.p(RefreshState.ReleaseToLoad);
            return;
        L34:
            if (r105.H == false) goto L37;
            if (r105.U == false) goto L37;
        L38:
            this.f405857a.setViceState(RefreshState.ReleaseToLoad);
            return;
        L39:
            SmartRefreshLayout r107 = this.f405857a;
            if (r107.T1.isOpening == false) goto L42;
        L44:
            this.f405857a.setViceState(RefreshState.ReleaseToRefresh);
            return;
        L42:
            if (r107.m(r107.B) == false) goto L44;
            this.f405857a.p(RefreshState.ReleaseToRefresh);
            return;
        L45:
            SmartRefreshLayout r108 = this.f405857a;
            if (r108.m(r108.C) == false) goto L56;
            SmartRefreshLayout r109 = this.f405857a;
            if (r109.T1.isOpening == true) goto L56;
            if (r109.T == true) goto L52;
        L55:
            r109.p(RefreshState.PullUpCanceled);
            c(RefreshState.None);
            return;
        L52:
            if (r109.H == false) goto L55;
            if (r109.U == false) goto L55;
        L56:
            this.f405857a.setViceState(RefreshState.PullUpCanceled);
            return;
        L57:
            SmartRefreshLayout r110 = this.f405857a;
            if (r110.T1.isOpening == false) goto L60;
        L62:
            this.f405857a.setViceState(RefreshState.PullDownCanceled);
            return;
        L60:
            if (r110.m(r110.B) == false) goto L62;
            this.f405857a.p(RefreshState.PullDownCanceled);
            c(RefreshState.None);
            return;
        L63:
            SmartRefreshLayout r111 = this.f405857a;
            if (r111.m(r111.C) == false) goto L76;
            SmartRefreshLayout r112 = this.f405857a;
            RefreshState r113 = r112.T1;
            if (r113.isOpening == true) goto L76;
            if (r113.isFinishing == true) goto L76;
            if (r112.T == true) goto L72;
        L75:
            r112.p(RefreshState.PullUpToLoad);
            return;
        L72:
            if (r112.H == false) goto L75;
            if (r112.U == false) goto L75;
        L76:
            this.f405857a.setViceState(RefreshState.PullUpToLoad);
            return;
        L77:
            SmartRefreshLayout r114 = this.f405857a;
            if (r114.T1.isOpening == false) goto L80;
        L82:
            this.f405857a.setViceState(RefreshState.PullDownToRefresh);
            return;
        L80:
            if (r114.m(r114.B) == false) goto L82;
            this.f405857a.p(RefreshState.PullDownToRefresh);
            return;
        L83:
            SmartRefreshLayout r115 = this.f405857a;
            RefreshState r116 = r115.T1;
            RefreshState r117 = RefreshState.None;
            if (r116 == r117) goto L89;
            if (r115.f405794b != 0) goto L89;
            r115.p(r117);
            return;
        L89:
            if (r115.f405794b == 0) goto L114;
            a(0);
            return;
        }

        public final i b(int r110, boolean r111) {
            SmartRefreshLayout r100 = this.f405857a;
            if (r100.f405794b != r110) goto L13;
            vpa.c r101 = r100.H1;
            if (r101 != null) goto L7;
        L8:
            vpa.b r102 = this.f405857a.L1;
            if (r102 != null) goto L11;
        L12:
            return this;
        L11:
            if (r102.a() == true) goto L13;
        L7:
            if (r101.a() == false) goto L8;
        L13:
            SmartRefreshLayout r103 = this.f405857a;
            int r104 = r103.f405794b;
            r103.f405794b = r110;
            if (r111 == false) goto L35;
            RefreshState r105 = r103.V1;
            if (r105.isDragging == true) goto L20;
            if (r105.isOpening == false) goto L35;
        L20:
            if (r110 <= (r103.P0 * r103.f405830x1)) goto L25;
            if (r103.T1 == RefreshState.ReleaseToTwoLevel) goto L35;
            r103.S1.c(RefreshState.ReleaseToRefresh);
            goto L35
        L25:
            if ((-r110) > (r103.f405795b1 * r103.f405833y1)) goto L27;
        L29:
            if (r110 < 0) goto L31;
        L33:
            if (r110 <= 0) goto L35;
            r103.S1.c(RefreshState.PullDownToRefresh);
            goto L35
        L31:
            if (r103.T == true) goto L33;
            r103.S1.c(RefreshState.PullUpToLoad);
            goto L35
        L27:
            if (r103.T == true) goto L29;
            r103.S1.c(RefreshState.ReleaseToLoad);
        L35:
            SmartRefreshLayout r106 = this.f405857a;
            if (r106.M1 == null) goto L102;
            if (r110 >= 0) goto L39;
        L44:
            int r107 = 0;
            boolean r108 = false;
        L45:
            if (r110 > 0) goto L52;
            SmartRefreshLayout r109 = this.f405857a;
            if (r109.n(r109.G, r109.L1) == false) goto L49;
            r107 = r110;
        L51:
            r108 = true;
            goto L52
        L49:
            if (r104 <= 0) goto L52;
            r107 = 0;
        L52:
            if (r108 == false) goto L102;
            SmartRefreshLayout r112 = this.f405857a;
            r112.M1.d(r107, r112.f405822s, r112.f405823t);
            SmartRefreshLayout r113 = this.f405857a;
            if (r113.T == true) goto L56;
        L66:
            SmartRefreshLayout r114 = this.f405857a;
            if (r114.D == false) goto L73;
            vpa.c r115 = r114.H1;
            if (r115 == null) goto L73;
            if (r115.getSpinnerStyle() != wpa.b.f560643d) goto L73;
            boolean r116 = true;
        L74:
            if (r116 == false) goto L76;
        L79:
            boolean r117 = true;
        L80:
            SmartRefreshLayout r118 = this.f405857a;
            if (r118.E == false) goto L87;
            vpa.b r119 = r118.L1;
            if (r119 == null) goto L87;
            if (r119.getSpinnerStyle() != wpa.b.f560643d) goto L87;
            boolean r120 = true;
        L88:
            if (r120 == false) goto L90;
        L93:
            boolean r121 = true;
        L94:
            if (r117 == false) goto L97;
            if (r107 >= 0) goto L100;
            if (r104 <= 0) goto L97;
        L100:
            r103.invalidate();
        L97:
            if (r121 == false) goto L102;
            if (r107 <= 0) goto L100;
            if (r104 >= 0) goto L102;
        L90:
            if (this.f405857a.f405806h2 != 0) goto L93;
            r121 = false;
        L87:
            r120 = false;
            goto L88
        L76:
            if (this.f405857a.f405803g2 != 0) goto L79;
            r117 = false;
        L73:
            r116 = false;
            goto L74
        L56:
            if (r113.U == false) goto L66;
            if (r113.H == false) goto L66;
            vpa.b r122 = r113.L1;
            if ((r122 instanceof vpa.b) == false) goto L66;
            if (r122.getSpinnerStyle() != wpa.b.f560642c) goto L66;
            SmartRefreshLayout r123 = this.f405857a;
            if (r123.m(r123.C) == false) goto L66;
            this.f405857a.L1.getView().setTranslationY(Math.max(0, r107));
            goto L66
        L39:
            if (r106.n(r106.F, r106.H1) == false) goto L41;
            r107 = r110;
        L43:
            r108 = true;
            goto L45
        L41:
            if (r104 >= 0) goto L44;
            r107 = 0;
        L102:
            if (r110 >= 0) goto L105;
            if (r104 > 0) goto L105;
        L143:
            if (r110 <= 0) goto L146;
            if (r104 < 0) goto L146;
        L184:
            return this;
        L146:
            if (this.f405857a.L1 == null) goto L184;
            int r124 = -Math.min(r110, 0);
            SmartRefreshLayout r125 = this.f405857a;
            int r126 = r125.f405795b1;
            int r127 = (int) (r126 * r125.f405826v1);
            float r128 = r124 * 1.0f;
            if (r126 != 0) goto L150;
            int r129 = 1;
        L151:
            float r130 = r128 / r129;
            if (r125.m(r125.C) == false) goto L154;
        L156:
            SmartRefreshLayout r131 = this.f405857a;
            if (r104 != r131.f405794b) goto L159;
        L175:
            if (r111 == true) goto L177;
        L183:
            int r132 = this.f405857a.f405794b;
            goto L184
        L177:
            if (this.f405857a.L1.a() == false) goto L183;
            int r133 = (int) this.f405857a.f405808j;
            int r134 = r103.getWidth();
            SmartRefreshLayout r135 = this.f405857a;
            float r136 = r135.f405808j;
            if (r134 != 0) goto L181;
            int r137 = 1;
        L182:
            r135.L1.d(r136 / r137, r133, r134);
            goto L183
        L181:
            r137 = r134;
            goto L182
        L159:
            if (r131.L1.getSpinnerStyle() != wpa.b.f560642c) goto L168;
            this.f405857a.L1.getView().setTranslationY(this.f405857a.f405794b);
            SmartRefreshLayout r138 = this.f405857a;
            if (r138.f405806h2 != 0) goto L163;
        L174:
            this.f405857a.L1.b(r111, r130, r124, r126, r127);
            goto L175
        L163:
            if (r138.P1 == null) goto L174;
            if (r138.n(r138.G, r138.L1) == true) goto L174;
            r103.invalidate();
            goto L174
        L168:
            if (this.f405857a.L1.getSpinnerStyle().f560648b == false) goto L174;
            View r139 = this.f405857a.L1.getView();
            ViewGroup.LayoutParams r140 = r139.getLayoutParams();
            if ((r140 instanceof ViewGroup.MarginLayoutParams) == false) goto L172;
            ViewGroup.MarginLayoutParams r141 = (ViewGroup.MarginLayoutParams) r140;
        L173:
            r139.measure(View.MeasureSpec.makeMeasureSpec(r139.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-this.f405857a.f405794b) - r141.bottomMargin) - r141.topMargin, 0), 1073741824));
            int r142 = r141.leftMargin;
            int r143 = (r141.topMargin + r103.getMeasuredHeight()) - this.f405857a.f405811k1;
            r139.layout(r142, r143 - r139.getMeasuredHeight(), r139.getMeasuredWidth() + r142, r143);
            goto L174
        L172:
            r141 = SmartRefreshLayout.F2;
            goto L173
        L154:
            if (this.f405857a.T1 != RefreshState.LoadFinish) goto L183;
            if (r111 == true) goto L183;
        L150:
            r129 = r126;
        L105:
            if (this.f405857a.H1 == null) goto L143;
            int r144 = Math.max(r110, 0);
            SmartRefreshLayout r145 = this.f405857a;
            int r146 = r145.P0;
            int r147 = (int) (r146 * r145.f405818p1);
            float r148 = r144 * 1.0f;
            if (r146 != 0) goto L109;
            int r149 = 1;
        L110:
            float r150 = r148 / r149;
            if (r145.m(r145.B) == false) goto L113;
        L115:
            SmartRefreshLayout r151 = this.f405857a;
            if (r104 != r151.f405794b) goto L118;
        L134:
            if (r111 == true) goto L136;
        L142:
            int r152 = this.f405857a.f405794b;
            goto L143
        L136:
            if (this.f405857a.H1.a() == false) goto L142;
            int r153 = (int) this.f405857a.f405808j;
            int r154 = r103.getWidth();
            SmartRefreshLayout r155 = this.f405857a;
            float r156 = r155.f405808j;
            if (r154 != 0) goto L140;
            int r157 = 1;
        L141:
            r155.H1.d(r156 / r157, r153, r154);
            goto L142
        L140:
            r157 = r154;
            goto L141
        L118:
            if (r151.H1.getSpinnerStyle() != wpa.b.f560642c) goto L127;
            this.f405857a.H1.getView().setTranslationY(this.f405857a.f405794b);
            SmartRefreshLayout r158 = this.f405857a;
            if (r158.f405803g2 != 0) goto L122;
        L133:
            this.f405857a.H1.b(r111, r150, r144, r146, r147);
            goto L134
        L122:
            if (r158.P1 == null) goto L133;
            if (r158.n(r158.F, r158.H1) == true) goto L133;
            r103.invalidate();
            goto L133
        L127:
            if (this.f405857a.H1.getSpinnerStyle().f560648b == false) goto L133;
            View r159 = this.f405857a.H1.getView();
            ViewGroup.LayoutParams r160 = r159.getLayoutParams();
            if ((r160 instanceof ViewGroup.MarginLayoutParams) == false) goto L131;
            ViewGroup.MarginLayoutParams r161 = (ViewGroup.MarginLayoutParams) r160;
        L132:
            r159.measure(View.MeasureSpec.makeMeasureSpec(r159.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f405857a.f405794b - r161.bottomMargin) - r161.topMargin, 0), 1073741824));
            int r162 = r161.leftMargin;
            int r163 = r161.topMargin + this.f405857a.f405805h1;
            r159.layout(r162, r163, r159.getMeasuredWidth() + r162, r159.getMeasuredHeight() + r163);
            goto L133
        L131:
            r161 = SmartRefreshLayout.F2;
            goto L132
        L113:
            if (this.f405857a.T1 != RefreshState.RefreshFinish) goto L142;
            if (r111 == true) goto L142;
        L109:
            r149 = r146;
            goto L110
        }
    }

    public static void setDefaultRefreshFooterCreator(xpa.b r100) {
    }

    public static void setDefaultRefreshHeaderCreator(xpa.c r100) {
    }

    public static void setDefaultRefreshInitializer(xpa.d r100) {
    }

    @Override // vpa.d
    public ViewGroup getLayout() {
        return this;
    }

    static {
        F2 = new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f405829x.getCurrY();
        if (this.f405829x.computeScrollOffset() == false) goto L62;
        int r100 = this.f405829x.getFinalY();
        if (r100 < 0) goto L7;
    L12:
        if (r100 > 0) goto L14;
    L60:
        this.f405827v2 = true;
        invalidate();
        return;
    L14:
        if (this.C == true) goto L18;
        if (this.K == false) goto L60;
    L18:
        if (this.M1.a() == false) goto L60;
    L20:
        if (this.f405827v2 == false) goto L59;
        if (r100 <= 0) goto L23;
        float r101 = -this.f405829x.getCurrVelocity();
    L25:
        if (this.E2 != null) goto L59;
        if (r101 <= 0.0f) goto L34;
        RefreshState r102 = this.T1;
        if (r102 != RefreshState.Refreshing) goto L31;
    L32:
        this.f405834y2 = new g(this, r101, this.P0);
        goto L59
    L31:
        if (r102 == RefreshState.TwoLevel) goto L32;
    L34:
        if (r101 >= 0.0f) goto L55;
        if (this.T1 != RefreshState.Loading) goto L38;
    L53:
        this.f405834y2 = new g(this, r101, -this.f405795b1);
        goto L59
    L38:
        if (this.H == false) goto L46;
        if (this.T == false) goto L46;
        if (this.U == false) goto L46;
        if (m(this.C) == true) goto L53;
    L46:
        if (this.L == false) goto L55;
        if (this.T == true) goto L55;
        if (m(this.C) == false) goto L55;
        if (this.T1 != RefreshState.Refreshing) goto L53;
    L55:
        if (this.f405794b != 0) goto L59;
        if (this.f405792J == false) goto L59;
        this.f405834y2 = new g(this, r101, 0);
        goto L59
    L23:
        r101 = this.f405829x.getCurrVelocity();
    L59:
        this.f405829x.forceFinished(true);
        return;
    L7:
        if (this.B == true) goto L11;
        if (this.K == false) goto L12;
    L11:
        if (this.M1.b() == true) goto L20;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.L0.getNestedScrollAxes();
    }

    public vpa.b getRefreshFooter() {
        vpa.b r100 = this.L1;
        if ((r100 instanceof vpa.b) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    public vpa.c getRefreshHeader() {
        vpa.c r100 = this.H1;
        if ((r100 instanceof vpa.c) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        if (this.Q == true) goto L5;
    L11:
        return false;
    L5:
        if (this.K == false) goto L7;
    L10:
        return true;
    L7:
        if (this.B == true) goto L10;
        if (this.C == false) goto L11;
        goto L10
    }

    public final void q() {
        RefreshState r100 = this.T1;
        RefreshState r101 = RefreshState.TwoLevel;
        if (r100 == r101) goto L5;
        RefreshState r102 = RefreshState.Loading;
        if (r100 != r102) goto L22;
    L70:
        int r103 = this.f405794b;
        int r104 = -this.f405795b1;
        if (r103 >= r104) goto L73;
        this.S1.a(r104);
        return;
    L73:
        if (r103 <= 0) goto L97;
        this.S1.a(0);
        return;
    L97:
        return;
    L22:
        if (this.H == true) goto L24;
    L32:
        RefreshState r105 = this.T1;
        RefreshState r106 = RefreshState.Refreshing;
        if (r105 != r106) goto L40;
        int r107 = this.f405794b;
        int r108 = this.P0;
        if (r107 <= r108) goto L37;
        this.S1.a(r108);
        return;
    L37:
        if (r107 >= 0) goto L83;
        this.S1.a(0);
        return;
    L83:
        return;
    L40:
        if (r105 != RefreshState.PullDownToRefresh) goto L43;
        this.S1.c(RefreshState.PullDownCanceled);
        return;
    L43:
        if (r105 != RefreshState.PullUpToLoad) goto L46;
        this.S1.c(RefreshState.PullUpCanceled);
        return;
    L46:
        if (r105 != RefreshState.ReleaseToRefresh) goto L49;
        this.S1.c(r106);
        return;
    L49:
        if (r105 != RefreshState.ReleaseToLoad) goto L52;
        this.S1.c(r102);
        return;
    L52:
        if (r105 != RefreshState.ReleaseToTwoLevel) goto L55;
        this.S1.c(RefreshState.TwoLevelReleased);
        return;
    L55:
        if (r105 != RefreshState.RefreshReleased) goto L60;
        if (this.E2 != null) goto L90;
        this.S1.a(this.P0);
        return;
    L90:
        return;
    L60:
        if (r105 != RefreshState.LoadReleased) goto L65;
        if (this.E2 != null) goto L92;
        this.S1.a(-this.f405795b1);
        return;
    L92:
        return;
    L65:
        if (r105 != RefreshState.LoadFinish) goto L68;
        return;
    L68:
        if (this.f405794b == 0) goto L94;
        this.S1.a(0);
        return;
    L94:
        return;
    L24:
        if (this.T == false) goto L32;
        if (this.U == false) goto L32;
        if (this.f405794b >= 0) goto L32;
        if (m(this.C) == false) goto L32;
    L5:
        if (this.f405828w <= (-1000)) goto L12;
        if (this.f405794b <= (getHeight() / 2)) goto L12;
        ValueAnimator r109 = this.S1.a(getHeight());
        if (r109 == null) goto L76;
        r109.setDuration(this.f405799e);
        return;
    L76:
        return;
    L12:
        if (this.f405814n == false) goto L78;
        i r110 = this.S1;
        SmartRefreshLayout r111 = r110.f405857a;
        if (r111.T1 != r101) goto L79;
        r111.S1.c(RefreshState.TwoLevelFinish);
        if (r110.f405857a.f405794b != 0) goto L18;
        r110.b(0, false);
        r110.f405857a.p(RefreshState.None);
        return;
    L18:
        r110.a(0).setDuration(r110.f405857a.f405799e);
        return;
    L79:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() == false) goto L5;
    L91:
        int[] r100 = this.A;
        if (r100 == null) goto L99;
        vpa.c r101 = this.H1;
        if (r101 == null) goto L96;
        r101.setPrimaryColors(r100);
    L96:
        vpa.b r102 = this.L1;
        if (r102 == null) goto L99;
        r102.setPrimaryColors(this.A);
    L99:
        aqa.a r103 = this.M1;
        if (r103 == null) goto L102;
        super.bringChildToFront(r103.f15981a);
    L102:
        vpa.c r104 = this.H1;
        if (r104 != null) goto L105;
    L107:
        vpa.b r105 = this.L1;
        if (r105 != null) goto L110;
        return;
    L110:
        if (r105.getSpinnerStyle().f560647a == false) goto L143;
        super.bringChildToFront(this.L1.getView());
        return;
    L143:
        return;
    L105:
        if (r104.getSpinnerStyle().f560647a == false) goto L107;
        super.bringChildToFront(this.H1.getView());
        goto L107
    L5:
        if (this.L1 == null) goto L16;
        if (this.C == false) goto L10;
    L13:
        boolean r106 = true;
    L14:
        this.C = r106;
        goto L16
    L10:
        if (this.V == false) goto L13;
        r106 = false;
    L16:
        if (this.M1 != null) goto L30;
        int r107 = getChildCount();
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L30;
        View r109 = getChildAt(r108);
        vpa.c r110 = this.H1;
        if (r110 != null) goto L22;
    L23:
        vpa.b r111 = this.L1;
        if (r111 != null) goto L26;
    L27:
        this.M1 = new aqa.a(r109);
    L28:
        r108 = r108 + 1;
        goto L18
    L26:
        if (r109 == r111.getView()) goto L28;
    L22:
        if (r109 == r110.getView()) goto L28;
    L30:
        if (this.M1 != null) goto L32;
        int r112 = (int) ((zpa.b.f573281a * 20.0f) + 0.5f);
        TextView r113 = new TextView(getContext());
        r113.setTextColor(-39424);
        r113.setGravity(17);
        r113.setTextSize(20.0f);
        r113.setText(R.string.srl_content_empty);
        super.addView(r113, 0, new LayoutParams(-1, -1));
        aqa.a r114 = new aqa.a(r113);
        this.M1 = r114;
        r114.f15981a.setPadding(r112, r112, r112, r112);
    L32:
        View r115 = findViewById(this.f405820q);
        View r116 = findViewById(this.f405821r);
        aqa.a r117 = this.M1;
        Object r118 = null;
        r117.getClass();
        if ((r118 instanceof ypa.a) == false) goto L35;
        ypa.a r119 = (ypa.a) null;
        r117.f15989i = null;
    L36:
        aqa.a r120 = this.M1;
        r120.f15989i.f568728c = this.P;
        i r121 = this.S1;
        View r122 = r120.f15981a;
        boolean r123 = r122.isInEditMode();
        View r124 = null;
    L37:
        if (r124 != null) goto L39;
    L42:
        if (r124 != null) goto L44;
        boolean r125 = true;
    L45:
        LinkedList r126 = new LinkedList();
        r126.add(r122);
        View r127 = null;
    L47:
        if (r126.size() <= 0) goto L62;
        if (r127 != null) goto L62;
        View r128 = (View) r126.poll();
        if (r128 == null) goto L47;
        if (r125 == true) goto L54;
        if (r128 != r122) goto L54;
    L57:
        if ((r128 instanceof ViewGroup) == false) goto L47;
        ViewGroup r129 = (ViewGroup) r128;
        int r130 = 0;
    L60:
        if (r130 >= r129.getChildCount()) goto L47;
        r126.add(r129.getChildAt(r130));
        r130 = r130 + 1;
    L54:
        if (zpa.b.c(r128) == false) goto L57;
        r127 = r128;
    L62:
        if (r127 == null) goto L65;
        r122 = r127;
    L65:
        if (r122 == r124) goto L66;
        if (r123 == true) goto L90;
    L88:
        th = move-exception;
        th.printStackTrace();
        goto L90
    L80:
        if ((r122 instanceof CoordinatorLayout) == false) goto L90;
        r121.f405857a.setNestedScrollingEnabled(false);     // Catch: Throwable -> L88
        ViewGroup r131 = (ViewGroup) r122;     // Catch: Throwable -> L88
        int r132 = r131.getChildCount();     // Catch: Throwable -> L88
    L82:
        r132 = r132 - 1;     // Catch: Throwable -> L88
        if (r132 < 0) goto L90;
        View r133 = r131.getChildAt(r132);     // Catch: Throwable -> L88
        if ((r133 instanceof AppBarLayout) == false) goto L82;
        ((AppBarLayout) r133).addOnOffsetChangedListener(new zpa.a(r120));     // Catch: Throwable -> L88
    L90:
        r124 = r122;
    L66:
        if (r124 == null) goto L68;
        r120.f15983c = r124;
    L68:
        if (r115 != null) goto L70;
        if (r116 != null) goto L70;
    L76:
        if (this.f405794b == 0) goto L91;
        p(RefreshState.None);
        aqa.a r134 = this.M1;
        this.f405794b = 0;
        r134.d(0, this.f405822s, this.f405823t);
    L70:
        r120.f15984d = r115;
        r120.f15985e = r116;
        FrameLayout r135 = new FrameLayout(r120.f15981a.getContext());
        int r136 = r121.f405857a.getLayout().indexOfChild(r120.f15981a);
        r121.f405857a.getLayout().removeView(r120.f15981a);
        r135.addView(r120.f15981a, 0, new ViewGroup.LayoutParams(-1, -1));
        r121.f405857a.getLayout().addView(r135, r136, r120.f15981a.getLayoutParams());
        r120.f15981a = r135;
        if (r115 == null) goto L73;
        r115.setTag(R.id.srl_tag, "fixed-top");
        ViewGroup.LayoutParams r137 = r115.getLayoutParams();
        ViewGroup r138 = (ViewGroup) r115.getParent();
        int r139 = r138.indexOfChild(r115);
        r138.removeView(r115);
        r137.height = zpa.b.e(r115);
        r138.addView(new Space(r120.f15981a.getContext()), r139, r137);
        r135.addView(r115, 1, r137);
    L73:
        if (r116 == null) goto L76;
        r116.setTag(R.id.srl_tag, "fixed-bottom");
        ViewGroup.LayoutParams r140 = r116.getLayoutParams();
        ViewGroup r141 = (ViewGroup) r116.getParent();
        int r142 = r141.indexOfChild(r116);
        r141.removeView(r116);
        FrameLayout.LayoutParams r143 = new FrameLayout.LayoutParams(r140);
        r140.height = zpa.b.e(r116);
        r141.addView(new Space(r120.f15981a.getContext()), r142, r140);
        r143.gravity = 80;
        r135.addView(r116, 1, r143);
        goto L76
    L44:
        r125 = false;
        goto L45
    L39:
        if ((r124 instanceof NestedScrollingParent) == false) goto L66;
        if ((r124 instanceof NestedScrollingChild) == true) goto L66;
    L35:
        r117.f15989i.f568727b = null;
        goto L36
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.V = true;
        this.f405834y2 = null;
        ValueAnimator r100 = this.E2;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
        this.E2.removeAllUpdateListeners();
        this.E2.setDuration(0);
        this.E2.cancel();
        this.E2 = null;
    L5:
        vpa.c r101 = this.H1;
        if (r101 != null) goto L8;
    L10:
        vpa.b r102 = this.L1;
        if (r102 == null) goto L16;
        if (this.T1 != RefreshState.Loading) goto L16;
        r102.i(this, false);
    L16:
        if (this.f405794b == 0) goto L18;
        this.S1.b(0, true);
    L18:
        RefreshState r103 = this.T1;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L21;
        p(r104);
    L21:
        Handler r105 = this.Q1;
        if (r105 == null) goto L24;
        r105.removeCallbacksAndMessages(null);
    L24:
        this.f405819p2 = false;
        return;
    L8:
        if (this.T1 != RefreshState.Refreshing) goto L10;
        r101.i(this, false);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r100 = super.getChildCount();
        if (r100 > 3) goto L65;
        int r101 = 0;
        int r102 = -1;
        char r103 = 0;
    L5:
        int r104 = 2;
        if (r101 >= r100) goto L20;
        View r105 = super.getChildAt(r101);
        if (zpa.b.c(r105) == false) goto L13;
        if (r103 < 2) goto L11;
        if (r101 != 1) goto L13;
    L11:
        r102 = r101;
        r103 = 2;
    L19:
        r101 = r101 + 1;
    L13:
        if ((r105 instanceof vpa.a) == true) goto L19;
        if (r103 >= 1) goto L19;
        if (r101 <= 0) goto L17;
        r103 = 1;
    L18:
        r102 = r101;
        goto L19
    L17:
        r103 = 0;
        goto L18
    L20:
        if (r102 < 0) goto L28;
        this.M1 = new aqa.a(super.getChildAt(r102));
        if (r102 != 1) goto L26;
        if (r100 != 3) goto L25;
        int r106 = 0;
    L30:
        int r107 = 0;
    L31:
        if (r107 >= r100) goto L63;
        View r108 = super.getChildAt(r107);
        if (r107 == r106) goto L58;
        if (r107 == r104) goto L41;
        if (r106 != (-1)) goto L41;
        if (this.H1 != null) goto L41;
        if ((r108 instanceof vpa.c) == true) goto L58;
    L41:
        if (r107 == r104) goto L46;
        if (r104 != (-1)) goto L62;
        if ((r108 instanceof vpa.b) == true) goto L46;
    L62:
        r107 = r107 + 1;
    L46:
        if (this.C == false) goto L48;
    L51:
        boolean r109 = true;
    L52:
        this.C = r109;
        if ((r108 instanceof vpa.b) == false) goto L55;
        vpa.b r110 = (vpa.b) r108;
    L56:
        this.L1 = r110;
        goto L62
    L55:
        r110 = new aqa.b(r108);
        goto L56
    L48:
        if (this.V == false) goto L51;
        r109 = false;
    L58:
        if ((r108 instanceof vpa.c) == false) goto L60;
        vpa.c r111 = (vpa.c) r108;
    L61:
        this.H1 = r111;
        goto L62
    L60:
        r111 = new aqa.c(r108);
        goto L61
    L63:
        return;
    L25:
        r106 = 0;
    L29:
        r104 = -1;
        goto L30
    L26:
        if (r100 != 2) goto L28;
        r106 = -1;
        r104 = 1;
    L28:
        r106 = -1;
        goto L29
    L65:
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    public RefreshState getState() {
        return this.T1;
    }

    public SmartRefreshLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r210) {
        int r100 = r210.getActionMasked();
        int r110 = 0;
        int r111 = 1;
        if (r100 != 6) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = r210.getActionIndex();
    L9:
        int r103 = r210.getPointerCount();
        int r104 = 0;
        float r105 = 0.0f;
        float r112 = 0.0f;
    L10:
        if (r104 >= r103) goto L15;
        if (r102 == r104) goto L14;
        r105 = r105 + r210.getX(r104);
        r112 = r112 + r210.getY(r104);
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        if (r101 == false) goto L17;
        r103 = r103 - 1;
    L17:
        float r106 = r103;
        float r107 = r105 / r106;
        float r108 = r112 / r106;
        if (r100 == 6) goto L22;
        if (r100 == 5) goto L22;
    L24:
        this.f405808j = r107;
        this.f405809k = r108;
        if (this.f405810k0 == false) goto L54;
        int r109 = this.W;
        boolean r113 = super.dispatchTouchEvent(r210);
        if (r100 == 2) goto L29;
    L52:
        return r113;
    L29:
        if (r109 != this.W) goto L52;
        int r114 = (int) this.f405808j;
        int r115 = getWidth();
        float r116 = this.f405808j;
        if (r115 == 0) goto L34;
        r111 = r115;
    L34:
        float r117 = r116 / r111;
        if (m(this.B) == false) goto L44;
        if (this.f405794b <= 0) goto L44;
        vpa.c r118 = this.H1;
        if (r118 == null) goto L44;
        if (r118.a() == false) goto L44;
        this.H1.d(r117, r114, r115);
    L44:
        if (m(this.C) == false) goto L52;
        if (this.f405794b >= 0) goto L52;
        vpa.b r119 = this.L1;
        if (r119 == null) goto L52;
        if (r119.a() == false) goto L52;
        this.L1.d(r117, r114, r115);
        goto L52
    L54:
        if (isEnabled() == false) goto L235;
        if (this.B == true) goto L62;
        if (this.C == true) goto L62;
        if (this.K == false) goto L235;
    L62:
        if (l(r100) == true) goto L233;
        RefreshState r120 = this.T1;
        if (r120.isFinishing == true) goto L233;
        RefreshState r121 = RefreshState.Loading;
        if (r120 != r121) goto L70;
        if (this.S == true) goto L233;
    L70:
        if (r120 != RefreshState.Refreshing) goto L75;
        if (this.R == true) goto L233;
    L75:
        if (r100 == 0) goto L217;
        if (r100 != 1) goto L78;
        this.f405832y.addMovement(r210);
        this.f405832y.computeCurrentVelocity(1000, this.f405825v);
        this.f405828w = (int) this.f405832y.getYVelocity();
        s(0.0f);
    L208:
        this.f405832y.clear();
        this.f405813m = 'n';
        MotionEvent r122 = this.f405831x2;
        if (r122 == null) goto L211;
        r122.recycle();
        this.f405831x2 = null;
        long r123 = r210.getEventTime();
        MotionEvent r124 = MotionEvent.obtain(r123, r123, r100, this.f405804h, r108, 0);
        super.dispatchTouchEvent(r124);
        r124.recycle();
    L211:
        q();
        if (this.f405814n == false) goto L216;
        this.f405814n = false;
        return true;
    L216:
        return super.dispatchTouchEvent(r210);
    L78:
        if (r100 == 2) goto L81;
        if (r100 == 3) goto L208;
    L81:
        float r125 = r107 - this.f405804h;
        float r126 = r108 - this.f405807i;
        this.f405832y.addMovement(r210);
        if (this.f405814n == true) goto L146;
        if (this.f405816p == true) goto L146;
        char r127 = this.f405813m;
        if (r127 == 'h') goto L146;
        if (this.M1 == null) goto L146;
        if (r127 != 'v') goto L92;
    L103:
        this.f405813m = 'v';
        if (r126 <= 0.0f) goto L115;
        if (this.f405794b >= 0) goto L108;
    L113:
        this.f405814n = true;
        this.f405807i = r108 - this.f405793a;
    L130:
        if (this.f405814n == false) goto L146;
        r126 = r108 - this.f405807i;
        if (this.f405815o == false) goto L134;
        r210.setAction(3);
        super.dispatchTouchEvent(r210);
    L134:
        i r128 = this.S1;
        int r129 = this.f405794b;
        if (r129 > 0) goto L141;
        if (r129 == 0) goto L138;
    L140:
        RefreshState r130 = RefreshState.PullUpToLoad;
    L142:
        r128.c(r130);
        ViewParent r131 = getParent();
        if ((r131 instanceof ViewGroup) == false) goto L146;
        ((ViewGroup) r131).requestDisallowInterceptTouchEvent(true);
        goto L146
    L138:
        if (r126 <= 0.0f) goto L140;
    L141:
        r130 = RefreshState.PullDownToRefresh;
        goto L142
    L108:
        if (this.K == true) goto L112;
        if (this.B == false) goto L115;
    L112:
        if (this.M1.b() == true) goto L113;
    L115:
        if (r126 >= 0.0f) goto L130;
        if (this.f405794b <= 0) goto L119;
    L128:
        this.f405814n = true;
        this.f405807i = this.f405793a + r108;
        goto L130
    L119:
        if (this.K == true) goto L123;
        if (this.C == false) goto L130;
    L123:
        if (this.T1 != r121) goto L127;
        if (this.f405819p2 == true) goto L128;
    L127:
        if (this.M1.a() == false) goto L130;
    L92:
        if (Math.abs(r126) < this.f405793a) goto L97;
        if (Math.abs(r125) < Math.abs(r126)) goto L103;
    L97:
        if (Math.abs(r125) < this.f405793a) goto L146;
        if (Math.abs(r125) <= Math.abs(r126)) goto L146;
        if (this.f405813m == 'v') goto L146;
        this.f405813m = 'h';
    L146:
        if (this.f405814n == false) goto L201;
        int r132 = ((int) r126) + this.f405798d;
        RefreshState r133 = this.V1;
        if (r133.isHeader == false) goto L153;
        if (r132 >= 0) goto L151;
    L157:
        this.f405797c = r132;
        long r211 = r210.getEventTime();
        if (this.f405831x2 != null) goto L160;
        MotionEvent r134 = MotionEvent.obtain(r211, r211, 0, this.f405804h + r125, this.f405807i, 0);
        this.f405831x2 = r134;
        super.dispatchTouchEvent(r134);
    L160:
        MotionEvent r135 = MotionEvent.obtain(r211, r211, 2, this.f405804h + r125, this.f405807i + r132, 0);
        super.dispatchTouchEvent(r135);
        if (this.f405819p2 == true) goto L163;
    L167:
        if (r132 > 0) goto L169;
    L175:
        if (r132 < 0) goto L177;
    L183:
        r110 = r132;
    L184:
        RefreshState r136 = this.V1;
        if (r136.isHeader == false) goto L188;
        if (r110 >= 0) goto L188;
    L191:
        if (this.f405794b == 0) goto L193;
        o(0.0f);
    L193:
        return true;
    L188:
        if (r136.isFooter == false) goto L195;
        if (r110 > 0) goto L191;
    L195:
        if (this.f405831x2 == null) goto L197;
        this.f405831x2 = null;
        r135.setAction(3);
        super.dispatchTouchEvent(r135);
    L197:
        r135.recycle();
        r132 = r110;
    L198:
        o(r132);
        return true;
    L177:
        if (this.K == true) goto L181;
        if (this.C == false) goto L183;
    L181:
        if (this.M1.a() == false) goto L183;
        this.f405809k = r108;
        this.f405807i = r108;
        this.f405798d = 0;
        this.S1.c(RefreshState.PullUpToLoad);
        goto L184
    L169:
        if (this.K == true) goto L173;
        if (this.B == false) goto L175;
    L173:
        if (this.M1.b() == false) goto L175;
        this.f405809k = r108;
        this.f405807i = r108;
        this.f405798d = 0;
        this.S1.c(RefreshState.PullDownToRefresh);
        goto L184
    L163:
        if (r126 <= this.f405793a) goto L167;
        if (this.f405794b >= 0) goto L167;
        this.f405819p2 = false;
        goto L167
    L151:
        if (this.f405797c < 0) goto L157;
    L153:
        if (r133.isFooter == false) goto L198;
        if (r132 > 0) goto L157;
        if (this.f405797c <= 0) goto L198;
    L201:
        if (this.f405819p2 == false) goto L216;
        if (r126 <= this.f405793a) goto L216;
        if (this.f405794b >= 0) goto L216;
        this.f405819p2 = false;
        goto L216
    L217:
        this.f405828w = 0;
        this.f405832y.addMovement(r210);
        this.f405829x.forceFinished(true);
        this.f405804h = r107;
        this.f405807i = r108;
        this.f405797c = 0;
        this.f405798d = this.f405794b;
        this.f405814n = false;
        this.f405816p = false;
        this.f405815o = super.dispatchTouchEvent(r210);
        if (this.T1 == RefreshState.TwoLevel) goto L220;
    L223:
        aqa.a r137 = this.M1;
        if (r137 == null) goto L232;
        PointF r138 = new PointF(r210.getX(), r210.getY());
        r138.offset(-r137.f15981a.getLeft(), -r137.f15981a.getTop());
        View r139 = r137.f15983c;
        View r140 = r137.f15981a;
        if (r139 == r140) goto L229;
        r137.f15983c = aqa.a.c(r140, r138, r139);
    L229:
        if (r137.f15983c != r137.f15981a) goto L231;
        r137.f15989i.f568726a = null;
        goto L232
    L231:
        r137.f15989i.f568726a = r138;
    L232:
        return true;
    L220:
        if (this.f405807i >= (getMeasuredHeight() * (1.0f - this.G1))) goto L223;
        this.f405813m = 'h';
        return this.f405815o;
    L233:
        return false;
    L235:
        return super.dispatchTouchEvent(r210);
    L22:
        if (this.f405814n == false) goto L24;
        this.f405807i += r108 - this.f405809k;
        goto L24
    L8:
        r102 = -1;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final SmartRefreshLayout h(boolean r100) {
        long r101 = System.currentTimeMillis() - this.f405796b2;
        if (r100 == false) goto L5;
        int r102 = Math.min(Math.max(0, 300 - ((int) r101)), 300) << 16;
    L6:
        i(r102, r100, false);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public final SmartRefreshLayout j(boolean r100) {
        if (r100 == false) goto L6;
        k(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405796b2))), 300) << 16, true, Boolean.FALSE);
        return this;
    L6:
        k(0, false, null);
        return this;
    }

    public final boolean l(int r100) {
        if (r100 != 0) goto L25;
        if (this.E2 == null) goto L23;
        RefreshState r101 = this.T1;
        if (r101.isFinishing == false) goto L9;
    L22:
        return true;
    L9:
        if (r101 == RefreshState.TwoLevelReleased) goto L22;
        if (r101 == RefreshState.RefreshReleased) goto L22;
        if (r101 == RefreshState.LoadReleased) goto L22;
        if (r101 != RefreshState.PullDownCanceled) goto L19;
        this.S1.c(RefreshState.PullDownToRefresh);
    L21:
        this.E2.setDuration(0);
        this.E2.cancel();
        this.E2 = null;
        goto L23
    L19:
        if (r101 != RefreshState.PullUpCanceled) goto L21;
        this.S1.c(RefreshState.PullUpToLoad);
    L23:
        this.f405834y2 = null;
    L25:
        if (this.E2 != null) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean m(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.M == true) goto L6;
        return true;
    }

    public final void o(float r110) {
        if (this.f405810k0 == true) goto L5;
    L11:
        float r100 = r110;
    L13:
        if (r100 > (this.f405801g * 5)) goto L15;
    L23:
        RefreshState r101 = this.T1;
        if (r101 != RefreshState.TwoLevel) goto L29;
        if (r100 <= 0.0f) goto L29;
        this.S1.b(Math.min((int) r100, getMeasuredHeight()), true);
    L75:
        if (this.L == true) goto L77;
        return;
    L77:
        if (this.T == false) goto L79;
        return;
    L79:
        if (m(this.C) == true) goto L81;
        return;
    L81:
        if (r100 >= 0.0f) goto L96;
        RefreshState r102 = this.T1;
        if (r102 != RefreshState.Refreshing) goto L85;
        return;
    L85:
        if (r102 != RefreshState.Loading) goto L87;
        return;
    L87:
        if (r102 != RefreshState.LoadFinish) goto L89;
        return;
    L89:
        if (this.S == false) goto L91;
        this.f405834y2 = null;
        this.S1.a(-this.f405795b1);
    L91:
        setStateDirectLoading(false);
        this.Q1.postDelayed(new f(this), this.f405800f);
        return;
    L96:
        return;
    L29:
        if (r101 != RefreshState.Refreshing) goto L40;
        if (r100 < 0.0f) goto L40;
        float r103 = this.P0;
        if (r100 >= r103) goto L35;
        this.S1.b((int) r100, true);
        goto L75
    L35:
        double r111 = (this.f405818p1 - 1.0f) * r103;
        int r104 = Math.max((this.f405801g * 4) / 3, getHeight());
        int r105 = this.P0;
        double r106 = r104 - r105;
        double r107 = Math.max(0.0f, (r100 - r105) * this.f405812l);
        double r108 = -r107;
        if (r106 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
        r106 = 1.0d;
    L38:
        this.S1.b(((int) Math.min(r111 * (1.0d - Math.pow(100.0d, r108 / r106)), r107)) + this.P0, true);
    L40:
        if (r100 >= 0.0f) goto L65;
        if (r101 != RefreshState.Loading) goto L44;
    L57:
        int r109 = this.f405795b1;
        if (r100 <= (-r109)) goto L60;
        this.S1.b((int) r100, true);
        goto L75
    L60:
        double r112 = (this.f405826v1 - 1.0f) * r109;
        int r113 = Math.max((this.f405801g * 4) / 3, getHeight());
        int r114 = this.f405795b1;
        double r115 = r113 - r114;
        double r116 = -Math.min(0.0f, (r114 + r100) * this.f405812l);
        double r117 = -r116;
        if (r115 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L63;
        r115 = 1.0d;
    L63:
        this.S1.b(((int) (-Math.min(r112 * (1.0d - Math.pow(100.0d, r117 / r115)), r116))) - this.f405795b1, true);
        goto L75
    L44:
        if (this.H == false) goto L52;
        if (this.T == false) goto L52;
        if (this.U == false) goto L52;
        if (m(this.C) == true) goto L57;
    L52:
        if (this.L == false) goto L65;
        if (this.T == true) goto L65;
        if (m(this.C) == true) goto L57;
    L65:
        if (r100 < 0.0f) goto L70;
        double r118 = this.f405818p1 * this.P0;
        double r119 = Math.max(this.f405801g / 2, getHeight());
        double r120 = Math.max(0.0f, this.f405812l * r100);
        double r121 = -r120;
        if (r119 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L69;
        r119 = 1.0d;
    L69:
        this.S1.b((int) Math.min(r118 * (1.0d - Math.pow(100.0d, r121 / r119)), r120), true);
        goto L75
    L70:
        double r122 = this.f405826v1 * this.f405795b1;
        double r123 = Math.max(this.f405801g / 2, getHeight());
        double r124 = -Math.min(0.0f, this.f405812l * r100);
        double r125 = -r124;
        if (r123 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L73;
        r123 = 1.0d;
    L73:
        this.S1.b((int) (-Math.min(r122 * (1.0d - Math.pow(100.0d, r125 / r123)), r124)), true);
        goto L75
    L15:
        if (getTag() != null) goto L23;
        if (getTag(R.id.srl_tag) != null) goto L23;
        float r126 = this.f405809k;
        float r127 = this.f405801g;
        if (r126 >= (r127 / 6.0f)) goto L23;
        if (this.f405808j >= (r127 / 16.0f)) goto L23;
        Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
        setTag(R.id.srl_tag, "你这么死拉，臣妾做不到啊！");
        goto L23
    L5:
        if (this.P == true) goto L11;
        if (r110 >= 0.0f) goto L11;
        if (this.M1.a() == true) goto L11;
        r100 = 0.0f;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.L0.onStopNestedScroll(r100);
        this.f405810k0 = false;
        this.W = 0;
        q();
        this.H0.stopNestedScroll();
    }

    public final void p(RefreshState r100) {
        RefreshState r101 = this.T1;
        if (r101 == r100) goto L13;
        this.T1 = r100;
        this.V1 = r100;
        vpa.c r102 = this.H1;
        vpa.b r103 = this.L1;
        if (r102 == null) goto L7;
        r102.h(this, r101, r100);
    L7:
        if (r103 == null) goto L10;
        r103.h(this, r101, r100);
    L10:
        if (r100 != RefreshState.LoadFinish) goto L16;
        this.f405819p2 = false;
        return;
    L16:
        return;
    L13:
        if (this.V1 == r101) goto L18;
        this.V1 = r101;
        return;
    }

    public final void r(boolean r100) {
        RefreshState r101 = this.T1;
        if (r101 != RefreshState.Refreshing) goto L7;
        if (r100 == false) goto L7;
        k(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405796b2))), 300) << 16, true, Boolean.TRUE);
        return;
    L7:
        if (r101 != RefreshState.Loading) goto L11;
        if (r100 == false) goto L11;
        i(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405796b2))), 300) << 16, true, true);
        return;
    L11:
        if (this.T == r100) goto L33;
        this.T = r100;
        vpa.b r102 = this.L1;
        if ((r102 instanceof vpa.b) == true) goto L15;
        return;
    L15:
        if (r102.c(r100) == false) goto L29;
        this.U = true;
        if (this.T == true) goto L19;
        return;
    L19:
        if (this.H == true) goto L21;
        return;
    L21:
        if (this.f405794b > 0) goto L23;
        return;
    L23:
        if (this.L1.getSpinnerStyle() == wpa.b.f560642c) goto L25;
        return;
    L25:
        if (m(this.C) == true) goto L27;
        return;
    L27:
        if (n(this.B, this.H1) == false) goto L40;
        this.L1.getView().setTranslationY(this.f405794b);
        return;
    L40:
        return;
    L29:
        this.U = false;
        new RuntimeException("Footer:" + this.L1 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (ViewCompat.isNestedScrollingEnabled(this.M1.f15983c) == false) goto L6;
        this.f405816p = r100;
        super.requestDisallowInterceptTouchEvent(r100);
        return;
    }

    public final boolean s(float r110) {
        if (r110 != 0.0f) goto L6;
        r110 = this.f405828w;
    L6:
        if (Build.VERSION.SDK_INT > 27) goto L8;
    L14:
        int r100 = 0;
        if (Math.abs(r110) <= this.f405824u) goto L107;
        int r101 = this.f405794b;
        if ((r101 * r110) >= 0.0f) goto L80;
        RefreshState r102 = this.T1;
        RefreshState r103 = RefreshState.Refreshing;
        if (r102 != r103) goto L21;
    L29:
        h r104 = new h(this, r110);
        RefreshState r111 = this.T1;
        if (r111.isFinishing == false) goto L33;
    L74:
        r104 = null;
    L77:
        this.f405834y2 = r104;
        return true;
    L33:
        if (this.f405794b != 0) goto L35;
    L76:
        r104.f405854c = AnimationUtils.currentAnimationTimeMillis();
        r104.f405856e.Q1.postDelayed(r104, 10);
        goto L77
    L35:
        if (r111.isOpening == true) goto L45;
        if (this.T == true) goto L39;
    L60:
        int r112 = this.f405794b;
        float r105 = r104.f405853b;
        int r106 = r112;
    L62:
        if ((r112 * r106) <= 0) goto L76;
        r100 = r100 + 1;
        r105 = (float) (((double) r105) * Math.pow(0.98f, (r100 * 10) / 10.0f));
        float r107 = ((10 * 1.0f) / 1000.0f) * r105;
        if (Math.abs(r107) < 1.0f) goto L65;
        r106 = (int) (r106 + r107);
        goto L62
    L65:
        SmartRefreshLayout r113 = r104.f405856e;
        RefreshState r108 = r113.T1;
        if (r108.isOpening == false) goto L74;
        RefreshState r109 = RefreshState.Refreshing;
        if (r108 == r109) goto L70;
    L71:
        if (r108 == r109) goto L76;
        if (r106 >= (-r113.f405795b1)) goto L76;
    L70:
        if (r106 > r113.P0) goto L74;
    L39:
        if (this.H == false) goto L60;
        if (this.U == false) goto L60;
        if (m(this.C) == false) goto L60;
    L45:
        if (this.T1 == RefreshState.Loading) goto L55;
        if (this.T == false) goto L57;
        if (this.H == false) goto L57;
        if (this.U == false) goto L57;
        if (m(this.C) == true) goto L55;
    L57:
        if (this.T1 != r103) goto L76;
        if (this.f405794b <= this.P0) goto L76;
    L55:
        if (this.f405794b < (-this.f405795b1)) goto L60;
    L21:
        if (r102 == RefreshState.Loading) goto L29;
        if (r101 >= 0) goto L27;
        if (this.T == true) goto L29;
    L27:
        if (r102.isReleaseToOpening == false) goto L80;
        return true;
    L80:
        if (r110 >= 0.0f) goto L95;
        if (this.f405792J == false) goto L88;
        if (this.C == false) goto L86;
    L106:
        this.f405827v2 = false;
        this.f405829x.fling(0, 0, 0, (int) (-r110), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.f405829x.computeScrollOffset();
        invalidate();
        goto L107
    L86:
        if (this.K == true) goto L106;
    L88:
        if (this.T1 != RefreshState.Loading) goto L91;
        if (r101 >= 0) goto L106;
    L91:
        if (this.L == false) goto L95;
        if (m(this.C) == true) goto L106;
    L95:
        if (r110 <= 0.0f) goto L107;
        if (this.f405792J == false) goto L101;
        if (this.B == true) goto L106;
    L101:
        if (this.K == true) goto L106;
        if (this.T1 != RefreshState.Refreshing) goto L107;
        if (this.f405794b <= 0) goto L106;
    L107:
        return false;
    L8:
        if (this.M1 == null) goto L14;
        getScaleY();
        View r114 = this.M1.f15981a;
        if (getScaleY() != (-1.0f)) goto L14;
        if (r114.getScaleY() != (-1.0f)) goto L14;
        r110 = -r110;
        goto L14
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r100) {
        this.Q = r100;
        this.H0.setNestedScrollingEnabled(r100);
    }

    public void setStateDirectLoading(boolean r100) {
        RefreshState r101 = this.T1;
        RefreshState r102 = RefreshState.Loading;
        if (r101 == r102) goto L8;
        this.f405796b2 = System.currentTimeMillis();
        this.f405819p2 = true;
        p(r102);
        i(2000, true, false);
        vpa.b r103 = this.L1;
        if (r103 == null) goto L9;
        int r104 = this.f405795b1;
        r103.g(this, r104, (int) (this.f405826v1 * r104));
        return;
    L9:
        return;
    }

    public void setStateLoading(boolean r100) {
        b r101 = new b(this, r100);
        p(RefreshState.LoadReleased);
        ValueAnimator r102 = this.S1.a(-this.f405795b1);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        vpa.b r103 = this.L1;
        if (r103 == null) goto L8;
        int r104 = this.f405795b1;
        r103.f(this, r104, (int) (this.f405826v1 * r104));
    L8:
        if (r102 != null) goto L11;
        r101.onAnimationEnd(null);
        return;
    }

    public void setStateRefreshing(boolean r100) {
        c r101 = new c(this, r100);
        p(RefreshState.RefreshReleased);
        ValueAnimator r102 = this.S1.a(this.P0);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        vpa.c r103 = this.H1;
        if (r103 == null) goto L8;
        int r104 = this.P0;
        r103.f(this, r104, (int) (this.f405818p1 * r104));
    L8:
        if (r102 != null) goto L11;
        r101.onAnimationEnd(null);
        return;
    }

    public void setViceState(RefreshState r100) {
        RefreshState r101 = this.T1;
        if (r101.isDragging == false) goto L8;
        if (r101.isHeader == r100.isHeader) goto L8;
        p(RefreshState.None);
    L8:
        if (this.V1 == r100) goto L11;
        this.V1 = r100;
        return;
    }

    public SmartRefreshLayout(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f405799e = 300;
        this.f405800f = 300;
        this.f405812l = 0.5f;
        this.f405813m = 'n';
        this.f405820q = -1;
        this.f405821r = -1;
        this.f405822s = -1;
        this.f405823t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.f405792J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f405817p0 = new int[2];
        NestedScrollingChildHelper r100 = new NestedScrollingChildHelper(this);
        this.H0 = r100;
        this.L0 = new NestedScrollingParentHelper(this);
        wpa.a r101 = wpa.a.f560634c;
        this.V0 = r101;
        this.f405802g1 = r101;
        this.f405818p1 = 2.5f;
        this.f405826v1 = 2.5f;
        this.f405830x1 = 1.0f;
        this.f405833y1 = 1.0f;
        this.G1 = 0.16666667f;
        this.S1 = new i(this);
        RefreshState r102 = RefreshState.None;
        this.T1 = r102;
        this.V1 = r102;
        this.f405796b2 = 0;
        this.f405803g2 = 0;
        this.f405806h2 = 0;
        this.f405819p2 = false;
        this.f405827v2 = false;
        this.f405831x2 = null;
        ViewConfiguration r103 = ViewConfiguration.get(r110);
        this.Q1 = new Handler(Looper.getMainLooper());
        this.f405829x = new Scroller(r110);
        this.f405832y = VelocityTracker.obtain();
        Resources r112 = r110.getResources();
        this.f405801g = WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).heightPixels;
        this.f405835z = new zpa.b();
        this.f405793a = r103.getScaledTouchSlop();
        this.f405824u = r103.getScaledMinimumFlingVelocity();
        this.f405825v = r103.getScaledMaximumFlingVelocity();
        float r104 = zpa.b.f573281a;
        this.f405795b1 = (int) ((60.0f * r104) + 0.5f);
        this.P0 = (int) ((100.0f * r104) + 0.5f);
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.clipChildren, android.R.attr.clipToPadding, R.attr.srlAccentColor, R.attr.srlDisableContentWhenLoading, R.attr.srlDisableContentWhenRefresh, R.attr.srlDragRate, R.attr.srlEnableAutoLoadMore, R.attr.srlEnableClipFooterWhenFixedBehind, R.attr.srlEnableClipHeaderWhenFixedBehind, R.attr.srlEnableFooterFollowWhenLoadFinished, R.attr.srlEnableFooterFollowWhenNoMoreData, R.attr.srlEnableFooterTranslationContent, R.attr.srlEnableHeaderTranslationContent, R.attr.srlEnableLoadMore, R.attr.srlEnableLoadMoreWhenContentNotFull, R.attr.srlEnableNestedScrolling, R.attr.srlEnableOverScrollBounce, R.attr.srlEnableOverScrollDrag, R.attr.srlEnablePreviewInEditMode, R.attr.srlEnablePureScrollMode, R.attr.srlEnableRefresh, R.attr.srlEnableScrollContentWhenLoaded, R.attr.srlEnableScrollContentWhenRefreshed, R.attr.srlFixedFooterViewId, R.attr.srlFixedHeaderViewId, R.attr.srlFooterHeight, R.attr.srlFooterInsetStart, R.attr.srlFooterMaxDragRate, R.attr.srlFooterTranslationViewId, R.attr.srlFooterTriggerRate, R.attr.srlHeaderHeight, R.attr.srlHeaderInsetStart, R.attr.srlHeaderMaxDragRate, R.attr.srlHeaderTranslationViewId, R.attr.srlHeaderTriggerRate, R.attr.srlPrimaryColor, R.attr.srlReboundDuration});
        if (r113.hasValue(1) == true) goto L6;
        super.setClipToPadding(false);
    L6:
        if (r113.hasValue(0) == true) goto L8;
        super.setClipChildren(false);
    L8:
        this.f405812l = r113.getFloat(5, 0.5f);
        this.f405818p1 = r113.getFloat(32, 2.5f);
        this.f405826v1 = r113.getFloat(27, 2.5f);
        this.f405830x1 = r113.getFloat(34, 1.0f);
        this.f405833y1 = r113.getFloat(29, 1.0f);
        this.B = r113.getBoolean(20, true);
        this.f405800f = r113.getInt(36, 300);
        this.C = r113.getBoolean(13, this.C);
        this.P0 = r113.getDimensionPixelOffset(30, this.P0);
        this.f405795b1 = r113.getDimensionPixelOffset(25, this.f405795b1);
        this.f405805h1 = r113.getDimensionPixelOffset(31, this.f405805h1);
        this.f405811k1 = r113.getDimensionPixelOffset(26, this.f405811k1);
        this.R = r113.getBoolean(4, false);
        this.S = r113.getBoolean(3, false);
        this.F = r113.getBoolean(12, true);
        this.G = r113.getBoolean(11, true);
        this.I = r113.getBoolean(18, true);
        this.L = r113.getBoolean(6, this.L);
        this.f405792J = r113.getBoolean(16, true);
        boolean r105 = r113.getBoolean(19, false);
        this.M = r105;
        this.N = r113.getBoolean(21, true);
        this.O = r113.getBoolean(22, true);
        this.P = r113.getBoolean(14, true);
        boolean r114 = r113.getBoolean(9, false);
        this.H = r114;
        this.H = r113.getBoolean(10, r114);
        this.D = r113.getBoolean(8, true);
        this.E = r113.getBoolean(7, true);
        this.K = r113.getBoolean(17, false);
        this.f405820q = r113.getResourceId(24, -1);
        this.f405821r = r113.getResourceId(23, -1);
        this.f405822s = r113.getResourceId(33, -1);
        this.f405823t = r113.getResourceId(28, -1);
        boolean r106 = r113.getBoolean(15, this.Q);
        this.Q = r106;
        r100.setNestedScrollingEnabled(r106);
        if (this.V == false) goto L11;
    L14:
        boolean r107 = true;
    L15:
        this.V = r107;
        r113.hasValue(12);
        r113.hasValue(11);
        if (r113.hasValue(30) == false) goto L18;
        wpa.a r115 = wpa.a.f560637f;
    L19:
        this.V0 = r115;
        if (r113.hasValue(25) == false) goto L22;
        wpa.a r116 = wpa.a.f560637f;
    L23:
        this.f405802g1 = r116;
        int r117 = r113.getColor(2, 0);
        int r108 = r113.getColor(35, 0);
        if (r108 == 0) goto L28;
        if (r117 == 0) goto L27;
        this.A = new int[]{r108, r117};
    L30:
        if (r105 == true) goto L32;
    L36:
        r113.recycle();
        return;
    L32:
        if (this.V == true) goto L36;
        if (this.C == true) goto L36;
        this.C = true;
        goto L36
    L27:
        this.A = new int[]{r108};
        goto L30
    L28:
        if (r117 == 0) goto L30;
        this.A = new int[]{0, r117};
        goto L30
    L22:
        r116 = this.f405802g1;
        goto L23
    L18:
        r115 = this.V0;
        goto L19
    L11:
        if (r113.hasValue(13) == true) goto L14;
        r107 = false;
        goto L15
    }

    public static /* synthetic */ void a(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void b(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void c(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void d(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void e(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void f(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public final boolean n(boolean r100, vpa.a r101) {
        if (r100 == false) goto L4;
    L10:
        return true;
    L4:
        if (this.M == true) goto L10;
        if (r101 == null) goto L10;
        if (r101.getSpinnerStyle() == wpa.b.f560643d) goto L10;
        return false;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        if (isInEditMode() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        int r101 = super.getChildCount();
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r102 >= r101) goto L162;
        View r104 = super.getChildAt(r102);
        if (r104.getVisibility() == 8) goto L161;
        if ("GONE".equals(r104.getTag(R.id.srl_tag)) == true) goto L161;
        vpa.c r111 = this.H1;
        if (r111 != null) goto L18;
    L69:
        vpa.b r105 = this.L1;
        if (r105 == null) goto L125;
        if (r105.getView() != r104) goto L125;
        View r106 = this.L1.getView();
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L76;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r107;
    L77:
        int r113 = ViewGroup.getChildMeasureSpec(r110, r112.leftMargin + r112.rightMargin, r107.width);
        int r114 = this.f405795b1;
        wpa.a r115 = this.f405802g1;
        int r116 = r115.f560640a;
        wpa.a r117 = wpa.a.f560634c;
        if (r116 >= 6) goto L98;
        int r118 = r107.height;
        if (r118 <= 0) goto L85;
        r114 = r112.bottomMargin + (r118 + r112.topMargin);
        wpa.a r119 = wpa.a.f560636e;
        if (r115.a(r119) == false) goto L98;
        this.f405795b1 = (r107.height + r112.topMargin) + r112.bottomMargin;
        this.f405802g1 = r119;
        goto L98
    L85:
        if (r118 != (-2)) goto L98;
        if (this.L1.getSpinnerStyle() == wpa.b.f560645f) goto L89;
    L90:
        int r108 = Math.max((View.MeasureSpec.getSize(r210) - r112.bottomMargin) - r112.topMargin, 0);
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(r108, Integer.MIN_VALUE));
        int r120 = r106.getMeasuredHeight();
        if (r120 <= 0) goto L98;
        if (r120 == r108) goto L96;
        wpa.a r109 = this.f405802g1;
        wpa.a r121 = wpa.a.f560635d;
        if (r109.a(r121) == false) goto L96;
        this.f405795b1 = (r120 + r112.topMargin) + r112.bottomMargin;
        this.f405802g1 = r121;
    L96:
        r114 = -1;
        goto L98
    L89:
        if (this.f405802g1.f560641b == false) goto L90;
    L98:
        if (this.L1.getSpinnerStyle() != wpa.b.f560645f) goto L102;
        int r122 = View.MeasureSpec.getSize(r210);
        int r123 = 0;
    L111:
        if (r122 == (-1)) goto L113;
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(Math.max((r122 - r112.bottomMargin) - r112.topMargin, r123), 1073741824));
    L113:
        wpa.a r124 = this.f405802g1;
        boolean r125 = r124.f560641b;
        if (r125 == true) goto L120;
        if (r125 == true) goto L118;
        r124 = wpa.a.f560639h[r124.f560640a + 1];
    L118:
        this.f405802g1 = r124;
        vpa.b r126 = this.L1;
        i r127 = this.S1;
        int r128 = this.f405795b1;
        r126.e(r127, r128, (int) (this.f405826v1 * r128));
    L120:
        if (r100 == false) goto L125;
        if (m(this.C) == false) goto L125;
        r103 = r103 + r106.getMeasuredHeight();
        goto L125
    L102:
        if (this.L1.getSpinnerStyle().f560648b == false) goto L109;
        if (r100 == true) goto L109;
        if (m(this.C) == false) goto L107;
        int r129 = -this.f405794b;
    L108:
        r123 = 0;
        r114 = Math.max(0, r129);
    L110:
        r122 = r114;
        goto L111
    L107:
        r129 = 0;
    L109:
        r123 = 0;
        goto L110
    L76:
        r112 = F2;
    L125:
        aqa.a r130 = this.M1;
        if (r130 == null) goto L161;
        View r131 = r130.f15981a;
        if (r131 != r104) goto L161;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == false) goto L132;
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
    L134:
        if (this.H1 != null) goto L136;
    L140:
        boolean r134 = false;
    L142:
        if (this.L1 != null) goto L144;
    L148:
        boolean r135 = false;
    L149:
        int r136 = ViewGroup.getChildMeasureSpec(r110, ((getPaddingLeft() + getPaddingRight()) + r133.leftMargin) + r133.rightMargin, r132.width);
        int r137 = ((getPaddingTop() + getPaddingBottom()) + r133.topMargin) + r133.bottomMargin;
        if (r100 == false) goto L153;
        if (r134 == false) goto L153;
        int r138 = this.P0;
    L154:
        int r139 = r137 + r138;
        if (r100 == false) goto L158;
        if (r135 == false) goto L158;
        int r140 = this.f405795b1;
    L159:
        r131.measure(r136, ViewGroup.getChildMeasureSpec(r210, r139 + r140, r132.height));
        r103 = r103 + r131.getMeasuredHeight();
    L158:
        r140 = 0;
    L153:
        r138 = 0;
        goto L154
    L144:
        if (m(this.C) == false) goto L148;
        if (n(this.G, this.L1) == false) goto L148;
        r135 = true;
        goto L149
    L136:
        if (m(this.B) == false) goto L140;
        if (n(this.F, this.H1) == false) goto L140;
        r134 = true;
        goto L142
    L132:
        r133 = F2;
        goto L134
    L18:
        if (r111.getView() != r104) goto L69;
        View r141 = this.H1.getView();
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r142;
    L23:
        int r144 = ViewGroup.getChildMeasureSpec(r110, r143.leftMargin + r143.rightMargin, r142.width);
        int r145 = this.P0;
        wpa.a r146 = this.V0;
        int r147 = r146.f560640a;
        wpa.a r148 = wpa.a.f560634c;
        if (r147 >= 6) goto L43;
        int r149 = r142.height;
        if (r149 <= 0) goto L31;
        int r150 = (r149 + r143.bottomMargin) + r143.topMargin;
        wpa.a r151 = wpa.a.f560636e;
        if (r146.a(r151) == false) goto L45;
        this.P0 = (r142.height + r143.bottomMargin) + r143.topMargin;
        this.V0 = r151;
    L45:
        if (this.H1.getSpinnerStyle() != wpa.b.f560645f) goto L49;
        int r152 = View.MeasureSpec.getSize(r210);
        int r153 = 0;
    L58:
        if (r152 == (-1)) goto L60;
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(Math.max((r152 - r143.bottomMargin) - r143.topMargin, r153), 1073741824));
    L60:
        wpa.a r154 = this.V0;
        boolean r155 = r154.f560641b;
        if (r155 == true) goto L65;
        if (r155 == true) goto L64;
        r154 = wpa.a.f560639h[r154.f560640a + 1];
    L64:
        this.V0 = r154;
        vpa.c r156 = this.H1;
        i r157 = this.S1;
        int r158 = this.P0;
        r156.e(r157, r158, (int) (this.f405818p1 * r158));
    L65:
        if (r100 == false) goto L69;
        if (m(this.B) == false) goto L69;
        r103 = r103 + r141.getMeasuredHeight();
        goto L69
    L49:
        if (this.H1.getSpinnerStyle().f560648b == false) goto L56;
        if (r100 == true) goto L56;
        if (m(this.B) == false) goto L54;
        int r159 = this.f405794b;
    L55:
        r153 = 0;
        r150 = Math.max(0, r159);
    L57:
        r152 = r150;
        goto L58
    L54:
        r159 = 0;
    L56:
        r153 = 0;
        goto L57
    L31:
        if (r149 != (-2)) goto L43;
        if (this.H1.getSpinnerStyle() == wpa.b.f560645f) goto L35;
    L36:
        int r160 = Math.max((View.MeasureSpec.getSize(r210) - r143.bottomMargin) - r143.topMargin, 0);
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(r160, Integer.MIN_VALUE));
        int r161 = r141.getMeasuredHeight();
        if (r161 <= 0) goto L43;
        if (r161 == r160) goto L42;
        wpa.a r162 = this.V0;
        wpa.a r163 = wpa.a.f560635d;
        if (r162.a(r163) == false) goto L42;
        this.P0 = (r161 + r143.bottomMargin) + r143.topMargin;
        this.V0 = r163;
    L42:
        r150 = -1;
        goto L45
    L35:
        if (this.V0.f560641b == false) goto L36;
    L43:
        r150 = r145;
        goto L45
    L22:
        r143 = F2;
    L161:
        r102 = r102 + 1;
        goto L9
    L162:
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r110), View.resolveSize(r103, r210));
        this.f405808j = getMeasuredWidth() / 2.0f;
        return;
    L5:
        if (this.I == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        aqa.a r100 = this.M1;
        if (r100 == null) goto L5;
        View r101 = r100.f15981a;
    L6:
        vpa.c r102 = this.H1;
        if (r102 != null) goto L9;
    L38:
        vpa.b r103 = this.L1;
        if (r103 == null) goto L71;
        if (r103.getView() != r111) goto L71;
        if (m(this.C) == true) goto L45;
    L69:
        return true;
    L45:
        if (this.I == false) goto L47;
    L49:
        if (r101 == null) goto L71;
        int r104 = Math.min((r101.getBottom() - r101.getPaddingBottom()) + this.f405794b, r111.getBottom());
        int r105 = this.f405806h2;
        if (r105 == 0) goto L62;
        Paint r106 = this.P1;
        if (r106 == null) goto L62;
        r106.setColor(r105);
        if (this.L1.getSpinnerStyle().f560648b == false) goto L58;
        r104 = r111.getTop();
    L60:
        r110.drawRect(0.0f, r104, getWidth(), r111.getBottom(), this.P1);
        goto L62
    L58:
        if (this.L1.getSpinnerStyle() != wpa.b.f560642c) goto L60;
        r104 = r111.getTop() + this.f405794b;
    L62:
        if (this.E == false) goto L66;
        if (this.L1.getSpinnerStyle() != wpa.b.f560643d) goto L66;
    L67:
        r110.save();
        r110.clipRect(r111.getLeft(), r104, r111.getRight(), r111.getBottom());
        boolean r113 = super.drawChild(r110, r111, r112);
        r110.restore();
        return r113;
    L66:
        if (this.L1.getSpinnerStyle().f560648b == false) goto L71;
    L47:
        if (isInEditMode() == false) goto L49;
    L71:
        return super.drawChild(r110, r111, r112);
    L9:
        if (r102.getView() != r111) goto L38;
        if (m(this.B) == true) goto L13;
    L37:
        return true;
    L13:
        if (this.I == false) goto L15;
    L17:
        if (r101 == null) goto L38;
        int r107 = Math.max((r101.getTop() + r101.getPaddingTop()) + this.f405794b, r111.getTop());
        int r108 = this.f405803g2;
        if (r108 == 0) goto L30;
        Paint r109 = this.P1;
        if (r109 == null) goto L30;
        r109.setColor(r108);
        if (this.H1.getSpinnerStyle().f560648b == false) goto L26;
        r107 = r111.getBottom();
    L28:
        r110.drawRect(0.0f, r111.getTop(), getWidth(), r107, this.P1);
        goto L30
    L26:
        if (this.H1.getSpinnerStyle() != wpa.b.f560642c) goto L28;
        r107 = r111.getBottom() + this.f405794b;
    L30:
        if (this.D == false) goto L34;
        if (this.H1.getSpinnerStyle() != wpa.b.f560643d) goto L34;
    L35:
        r110.save();
        r110.clipRect(r111.getLeft(), r111.getTop(), r111.getRight(), r107);
        boolean r114 = super.drawChild(r110, r111, r112);
        r110.restore();
        return r114;
    L34:
        if (this.H1.getSpinnerStyle().f560648b == false) goto L38;
    L15:
        if (isInEditMode() == false) goto L17;
    L5:
        r101 = null;
        goto L6
    }

    public final void i(int r100, boolean r101, boolean r102) {
        int r103 = r100 >> 16;
        int r104 = (r100 << 16) >> 16;
        upa.b r105 = new upa.b(this, r103, r102, r101);
        if (r104 <= 0) goto L5;
        this.Q1.postDelayed(r105, r104);
        return;
    L5:
        r105.run();
    }

    public final void k(int r100, boolean r101, Boolean r102) {
        int r103 = r100 >> 16;
        int r104 = (r100 << 16) >> 16;
        upa.a r105 = new upa.a(this, r103, r102, r101);
        if (r104 <= 0) goto L5;
        this.Q1.postDelayed(r105, r104);
        return;
    L5:
        r105.run();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.f405819p2 == false) goto L7;
        if (r102 <= 0.0f) goto L7;
    L12:
        return true;
    L7:
        if (s(-r102) == true) goto L12;
        if (this.H0.dispatchNestedPreFling(r101, r102) == true) goto L12;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.L0.onNestedScrollAccepted(r100, r101, r102);
        this.H0.startNestedScroll(r102 & 2);
        this.W = this.f405794b;
        this.f405810k0 = true;
        l(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L12;
    L18:
        return false;
    L12:
        if (this.K == false) goto L14;
        return true;
    L14:
        if (this.B == false) goto L16;
        return true;
    L16:
        if (this.C == false) goto L18;
        return true;
    L5:
        if (isNestedScrollingEnabled() == false) goto L9;
        if ((r102 & 2) == 0) goto L9;
        r103 = true;
        goto L10
    }

    public final ValueAnimator g(int r100, int r101, Interpolator r102, int r103) {
        if (this.f405794b == r100) goto L9;
        ValueAnimator r104 = this.E2;
        if (r104 == null) goto L7;
        r104.setDuration(0);
        this.E2.cancel();
        this.E2 = null;
    L7:
        this.f405834y2 = null;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{this.f405794b, r100});
        this.E2 = r105;
        r105.setDuration(r103);
        this.E2.setInterpolator(r102);
        this.E2.addListener(new d(this));
        this.E2.addUpdateListener(new e(this));
        this.E2.setStartDelay(r101);
        this.E2.start();
        return this.E2;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return this.H0.dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        int r104 = this.W;
        int r105 = 0;
        if ((r102 * r104) > 0) goto L5;
        if (r102 > 0) goto L11;
    L13:
        this.H0.dispatchNestedPreScroll(r101, r102 - r105, r103, null);
        r103[1] = r103[1] + r105;
        return;
    L11:
        if (this.f405819p2 == false) goto L13;
        int r106 = r104 - r102;
        this.W = r106;
        o(r106);
        r105 = r102;
        goto L13
    L5:
        if (Math.abs(r102) <= Math.abs(this.W)) goto L7;
        int r107 = this.W;
        this.W = 0;
        r105 = r107;
    L8:
        o(this.W);
        goto L13
    L7:
        this.W -= r102;
        r105 = r102;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        int r115 = getPaddingLeft();
        int r116 = getPaddingTop();
        getPaddingBottom();
        int r117 = super.getChildCount();
        int r118 = 0;
    L3:
        if (r118 >= r117) goto L110;
        View r100 = super.getChildAt(r118);
        if (r100.getVisibility() == 8) goto L109;
        if ("GONE".equals(r100.getTag(R.id.srl_tag)) == true) goto L109;
        aqa.a r101 = this.M1;
        boolean r102 = true;
        if (r101 != null) goto L12;
    L33:
        vpa.c r103 = this.H1;
        if (r103 != null) goto L36;
    L55:
        vpa.b r104 = this.L1;
        if (r104 == null) goto L109;
        if (r104.getView() != r100) goto L109;
        if (isInEditMode() == true) goto L62;
    L66:
        r102 = false;
    L67:
        View r105 = this.L1.getView();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L70;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L71:
        wpa.b r108 = this.L1.getSpinnerStyle();
        int r109 = r107.leftMargin;
        int r119 = (r107.topMargin + getMeasuredHeight()) - this.f405811k1;
        if (this.T == false) goto L89;
        if (this.U == false) goto L89;
        if (this.H == false) goto L89;
        if (this.M1 == null) goto L89;
        if (this.L1.getSpinnerStyle() != wpa.b.f560642c) goto L89;
        if (m(this.C) == false) goto L89;
        View r120 = this.M1.f15981a;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if ((r121 instanceof ViewGroup.MarginLayoutParams) == false) goto L86;
        int r122 = ((ViewGroup.MarginLayoutParams) r121).topMargin;
    L87:
        int r123 = r120.getMeasuredHeight();
        r119 = r123 + ((r116 + r116) + r122);
        goto L89
    L86:
        r122 = 0;
    L89:
        if (r108 != wpa.b.f560645f) goto L91;
        r119 = r107.topMargin - this.f405811k1;
    L108:
        r105.layout(r109, r119, r105.getMeasuredWidth() + r109, r105.getMeasuredHeight() + r119);
        goto L109
    L91:
        if (r102 == false) goto L93;
    L106:
        int r124 = this.f405795b1;
    L107:
        r119 = r119 - r124;
        goto L108
    L93:
        if (r108 == wpa.b.f560644e) goto L106;
        if (r108 == wpa.b.f560643d) goto L106;
        if (r108.f560648b == false) goto L108;
        if (this.f405794b >= 0) goto L108;
        if (m(this.C) == false) goto L104;
        int r125 = -this.f405794b;
    L105:
        r124 = Math.max(r125, 0);
        goto L107
    L104:
        r125 = 0;
        goto L105
    L70:
        r107 = F2;
        goto L71
    L62:
        if (this.I == false) goto L66;
        if (m(this.C) == false) goto L66;
    L36:
        if (r103.getView() != r100) goto L55;
        if (isInEditMode() == true) goto L40;
    L44:
        boolean r126 = false;
    L45:
        View r127 = this.H1.getView();
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L49:
        int r130 = r129.leftMargin;
        int r131 = r129.topMargin + this.f405805h1;
        int r132 = r127.getMeasuredWidth() + r130;
        int r133 = r127.getMeasuredHeight() + r131;
        if (r126 == false) goto L52;
    L54:
        r127.layout(r130, r131, r132, r133);
        goto L55
    L52:
        if (this.H1.getSpinnerStyle() != wpa.b.f560642c) goto L54;
        int r134 = this.P0;
        r131 = r131 - r134;
        r133 = r133 - r134;
        goto L54
    L48:
        r129 = F2;
        goto L49
    L40:
        if (this.I == false) goto L44;
        if (m(this.B) == false) goto L44;
        r126 = true;
        goto L45
    L12:
        if (r101.f15981a != r100) goto L33;
        if (isInEditMode() == true) goto L16;
    L22:
        boolean r135 = false;
    L23:
        View r136 = this.M1.f15981a;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if ((r137 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
    L27:
        int r139 = r138.leftMargin + r115;
        int r140 = r138.topMargin + r116;
        int r141 = r136.getMeasuredWidth() + r139;
        int r142 = r136.getMeasuredHeight() + r140;
        if (r135 == true) goto L30;
    L32:
        r136.layout(r139, r140, r141, r142);
        goto L33
    L30:
        if (n(this.F, this.H1) == false) goto L32;
        int r143 = this.P0;
        r140 = r140 + r143;
        r142 = r142 + r143;
        goto L32
    L26:
        r138 = F2;
        goto L27
    L16:
        if (this.I == false) goto L22;
        if (m(this.B) == false) goto L22;
        if (this.H1 == null) goto L22;
        r135 = true;
    L109:
        r118 = r118 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        boolean r103 = this.H0.dispatchNestedScroll(r101, r102, r110, r111, this.f405817p0);
        int r112 = r111 + this.f405817p0[1];
        if (r112 < 0) goto L5;
    L9:
        if (r112 > 0) goto L11;
    L30:
        if (this.f405819p2 == false) goto L34;
        if (r102 >= 0) goto L35;
        this.f405819p2 = false;
        return;
    L35:
        return;
    L34:
        return;
    L11:
        if (this.C == false) goto L13;
    L8:
        int r104 = this.W;
        RefreshState r105 = this.V1;
        if (r105 != RefreshState.None) goto L18;
    L19:
        i r106 = this.S1;
        if (r112 <= 0) goto L22;
        RefreshState r107 = RefreshState.PullUpToLoad;
    L23:
        r106.c(r107);
        if (r103 == true) goto L28;
        ViewParent r108 = getParent();
        if (r108 == null) goto L28;
        r108.requestDisallowInterceptTouchEvent(true);
    L28:
        int r109 = this.W - r112;
        this.W = r109;
        o(r109);
        goto L30
    L22:
        r107 = RefreshState.PullDownToRefresh;
        goto L23
    L18:
        if (r105.isOpening == false) goto L28;
    L13:
        if (this.K == false) goto L30;
    L5:
        if (this.B == true) goto L8;
        if (this.K == false) goto L9;
        goto L8
    }
}
