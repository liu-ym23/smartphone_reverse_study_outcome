package com.lynx.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.lynx.smartrefresh.layout.footer.BallPulseFooter;
import com.lynx.smartrefresh.layout.header.BezierRadarHeader;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public class SmartRefreshLayout extends ViewGroup implements m6a.i, NestedScrollingParent {
    public static final ViewGroup.MarginLayoutParams J2 = null;
    public boolean A;
    public boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public boolean E2;
    public final boolean F;
    public boolean F2;
    public final boolean G;
    public final float G1;
    public MotionEvent G2;
    public final boolean H;
    public boolean H0;
    public final float H1;
    public Runnable H2;
    public final boolean I;
    public ValueAnimator I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f381483J;
    public boolean K;
    public final boolean L;
    public final int[] L0;
    public m6a.f L1;
    public final boolean M;
    public m6a.e M1;
    public final boolean N;
    public final boolean O;
    public boolean P;
    public final NestedScrollingChildHelper P0;
    public o6a.a P1;
    public final boolean Q;
    public Paint Q1;
    public final boolean R;
    public boolean S;
    public final Handler S1;
    public boolean T;
    public final i T1;
    public boolean U;
    public q6a.d V;
    public final NestedScrollingParentHelper V0;
    public RefreshState V1;
    public q6a.b W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f381484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f381485b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f381486b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public RefreshState f381487b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f381488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f381489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f381490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f381491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f381492g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public n6a.a f381493g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public long f381494g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f381495h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f381496h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f381497h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f381498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f381499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f381500k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public q6a.c f381501k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public n6a.a f381502k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f381503l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public char f381504m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f381505n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f381506o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f381507p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f381508p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final int f381509p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public int f381510p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f381511q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f381512r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f381513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f381514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f381515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f381516v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final int f381517v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f381518v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Scroller f381519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final VelocityTracker f381520x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public float f381521x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public boolean f381522x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r6a.b f381523y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final float f381524y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public boolean f381525y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f381526z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f381527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n6a.b f381528b;

        public LayoutParams(int r100) {
            super(-1, r100);
            this.f381527a = 0;
            this.f381528b = null;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f381527a = 0;
            this.f381528b = null;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_srlBackgroundColor, R.attr.layout_srlSpinnerStyle});
            this.f381527a = r102.getColor(0, 0);
            if (r102.hasValue(1) == false) goto L5;
            n6a.b[] r103 = n6a.b.f518187h;
            n6a.b r104 = n6a.b.f518183d;
            this.f381528b = r103[r102.getInt(1, 0)];
        L5:
            r102.recycle();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381529a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f381529a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            f381529a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            f381529a[RefreshState.PullUpToLoad.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            f381529a[RefreshState.PullDownCanceled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            f381529a[RefreshState.PullUpCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            f381529a[RefreshState.ReleaseToRefresh.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            f381529a[RefreshState.ReleaseToLoad.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            f381529a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            f381529a[RefreshState.RefreshReleased.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            f381529a[RefreshState.LoadReleased.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            f381529a[RefreshState.Refreshing.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            f381529a[RefreshState.Loading.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            f381529a[RefreshState.RefreshFinish.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            f381529a[RefreshState.LoadFinish.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            f381529a[RefreshState.TwoLevelReleased.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            f381529a[RefreshState.TwoLevelFinish.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            f381529a[RefreshState.TwoLevel.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f381530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381531b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f381531b.setStateDirectLoading(this.f381530a);
        }

        public b(SmartRefreshLayout r100, boolean r101) {
            this.f381531b = r100;
            this.f381530a = r101;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f381532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381533b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f381533b.f381494g2 = System.currentTimeMillis();
            this.f381533b.n(RefreshState.Refreshing);
            SmartRefreshLayout r101 = this.f381533b;
            q6a.d r102 = r101.V;
            if (r102 == null) goto L8;
            if (this.f381532a == false) goto L10;
            r102.l(r101);
        L10:
            SmartRefreshLayout r103 = this.f381533b;
            m6a.f r104 = r103.L1;
            if (r104 == null) goto L13;
            int r105 = r103.f381486b1;
            r104.n(r103, r105, (int) (r103.f381521x1 * r105));
        L13:
            SmartRefreshLayout r106 = this.f381533b;
            q6a.c r107 = r106.f381501k0;
            if (r107 != null) goto L16;
            return;
        L16:
            if ((r106.L1 instanceof m6a.f) == true) goto L18;
            return;
        L18:
            if (this.f381532a == false) goto L20;
            r107.l(r106);
        L20:
            this.f381533b.f381501k0.o();
            return;
        L8:
            if (r101.f381501k0 != null) goto L10;
            r101.i(3000, true, Boolean.FALSE);
            goto L10
        }

        public c(SmartRefreshLayout r100, boolean r101) {
            this.f381533b = r100;
            this.f381532a = r101;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381534a;

        public d(SmartRefreshLayout r100) {
            this.f381534a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SmartRefreshLayout r101 = this.f381534a;
            r101.I2 = null;
            if (r101.f381485b != 0) goto L11;
            RefreshState r102 = r101.V1;
            RefreshState r103 = RefreshState.None;
            if (r102 == r103) goto L11;
            if (r102.isOpening == true) goto L11;
            if (r102.isDragging == true) goto L11;
            r101.n(r103);
            return;
        L11:
            RefreshState r104 = r101.V1;
            if (r104 == r101.f381487b2) goto L16;
            r101.setViceState(r104);
            return;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381535a;

        public e(SmartRefreshLayout r100) {
            this.f381535a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f381535a.T1.b(((Integer) r100.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381536a;

        @Override // java.lang.Runnable
        public final void run() {
            SmartRefreshLayout r100 = this.f381536a;     // Catch: Throwable -> L12
            q6a.b r101 = r100.W;     // Catch: Throwable -> L12
            if (r101 == null) goto L6;
            r101.g(r100);     // Catch: Throwable -> L12
        L8:
            SmartRefreshLayout r102 = this.f381536a;     // Catch: Throwable -> L12
            q6a.c r103 = r102.f381501k0;     // Catch: Throwable -> L12
            if (r103 == null) goto L15;
            r103.g(r102);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L6:
            if (r100.f381501k0 != null) goto L8;
            r100.h(2000, false);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public f(SmartRefreshLayout r100) {
            this.f381536a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f381537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f381538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f381539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f381540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f381541e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381542f;

        public final void a() {
            SmartRefreshLayout r100 = this.f381542f;
            if (r100.H2 == this) goto L5;
            return;
        L5:
            if (r100.V1.isFinishing == false) goto L7;
            return;
        L7:
            if (Math.abs(r100.f381485b) >= Math.abs(this.f381538b)) goto L9;
            double r101 = this.f381541e;
            int r102 = this.f381537a + 1;
            this.f381537a = r102;
            this.f381541e = (float) (r101 * Math.pow(0.949999988079071d, r102 * 2));
        L13:
            long r103 = AnimationUtils.currentAnimationTimeMillis();
            float r104 = this.f381541e * (((r103 - this.f381539c) * 1.0f) / 1000.0f);
            if (Math.abs(r104) < 1.0f) goto L16;
            this.f381539c = r103;
            float r105 = this.f381540d + r104;
            this.f381540d = r105;
            this.f381542f.m(r105);
            this.f381542f.S1.postDelayed(this, 10);
            return;
        L16:
            SmartRefreshLayout r106 = this.f381542f;
            RefreshState r107 = r106.f381487b2;
            boolean r108 = r107.isDragging;
            if (r108 == true) goto L19;
        L21:
            if (r108 == true) goto L23;
        L25:
            SmartRefreshLayout r109 = this.f381542f;
            r109.H2 = null;
            if (Math.abs(r109.f381485b) < Math.abs(this.f381538b)) goto L32;
            int r110 = Math.min(Math.max((int) (Math.abs(this.f381542f.f381485b - this.f381538b) / r6a.b.f536385b), 30), 100) * 10;
            SmartRefreshLayout r111 = this.f381542f;
            r111.g(this.f381538b, 0, r111.f381523y, r110);
            return;
        L32:
            return;
        L23:
            if (r107.isFooter == false) goto L25;
            r106.T1.d(RefreshState.PullUpCanceled);
            goto L25
        L19:
            if (r107.isHeader == false) goto L21;
            r106.T1.d(RefreshState.PullDownCanceled);
            goto L25
        L9:
            if (this.f381538b == 0) goto L11;
            double r112 = this.f381541e;
            int r113 = this.f381537a + 1;
            this.f381537a = r113;
            this.f381541e = (float) (r112 * Math.pow(0.44999998807907104d, r113 * 2));
            goto L13
        L11:
            double r114 = this.f381541e;
            int r115 = this.f381537a + 1;
            this.f381537a = r115;
            this.f381541e = (float) (r114 * Math.pow(0.8500000238418579d, r115 * 2));
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
            this.f381542f = r100;
            this.f381537a = 0;
            this.f381540d = 0.0f;
            this.f381541e = r101;
            this.f381538b = r102;
            this.f381539c = AnimationUtils.currentAnimationTimeMillis();
            r100.S1.postDelayed(this, 10);
            if (r101 <= 0.0f) goto L5;
            r100.T1.d(RefreshState.PullDownToRefresh);
            return;
        L5:
            r100.T1.d(RefreshState.PullUpToLoad);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f381543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f381544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f381545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f381546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381547e;

        public final void a() {
            SmartRefreshLayout r100 = this.f381547e;
            if (r100.H2 == this) goto L5;
            return;
        L5:
            if (r100.V1.isFinishing == true) goto L34;
            long r101 = AnimationUtils.currentAnimationTimeMillis();
            long r102 = r101 - this.f381546d;
            float r103 = (float) (((double) this.f381544b) * Math.pow(0.98f, (r101 - this.f381545c) / (1000.0f / 10)));
            this.f381544b = r103;
            float r104 = r103 * ((r102 * 1.0f) / 1000.0f);
            if (Math.abs(r104) <= 1.0f) goto L31;
            this.f381546d = r101;
            int r105 = (int) (this.f381543a + r104);
            this.f381543a = r105;
            SmartRefreshLayout r106 = this.f381547e;
            if ((r106.f381485b * r105) <= 0) goto L11;
            r106.T1.b(r105, true);
            this.f381547e.S1.postDelayed(this, 10);
            return;
        L11:
            r106.H2 = null;
            r106.T1.b(0, true);
            View r107 = this.f381547e.P1.f522215c;
            int r108 = (int) (-this.f381544b);
            float r109 = r6a.b.f536385b;
            if ((r107 instanceof ScrollView) == false) goto L15;
            ((ScrollView) r107).fling(r108);
        L26:
            SmartRefreshLayout r110 = this.f381547e;
            if (r110.E2 == true) goto L29;
            return;
        L29:
            if (r104 <= 0.0f) goto L37;
            r110.E2 = false;
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
            this.f381547e.H2 = null;
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
            this.f381547e = r100;
            this.f381545c = 0;
            this.f381546d = AnimationUtils.currentAnimationTimeMillis();
            this.f381544b = r101;
            this.f381543a = r100.f381485b;
        }
    }

    public class i implements m6a.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f381548a;

        public i(SmartRefreshLayout r100) {
            this.f381548a = r100;
        }

        public final ValueAnimator a(int r100) {
            SmartRefreshLayout r101 = this.f381548a;
            return r101.g(r100, 0, r101.f381523y, r101.f381491f);
        }

        public final void d(RefreshState r100) {
            switch(a.f381529a[r100.ordinal()]) {
                case 1: goto L92;
                case 2: goto L86;
                case 3: goto L72;
                case 4: goto L66;
                case 5: goto L54;
                case 6: goto L48;
                case 7: goto L34;
                case 8: goto L28;
                case 9: goto L22;
                case 10: goto L16;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L11;
                case 14: goto L8;
                case 15: goto L7;
                case 16: goto L6;
                case 17: goto L5;
                default: goto L130;
            };
        L5:
            this.f381548a.n(RefreshState.TwoLevel);
            return;
        L6:
            this.f381548a.n(RefreshState.TwoLevelFinish);
            return;
        L7:
            this.f381548a.n(RefreshState.TwoLevelReleased);
            return;
        L8:
            SmartRefreshLayout r101 = this.f381548a;
            if (r101.V1 != RefreshState.Loading) goto L104;
            r101.n(RefreshState.LoadFinish);
            return;
        L104:
            return;
        L11:
            SmartRefreshLayout r102 = this.f381548a;
            if (r102.V1 != RefreshState.Refreshing) goto L106;
            r102.n(RefreshState.RefreshFinish);
            return;
        L106:
            return;
        L14:
            this.f381548a.setStateLoading(true);
            return;
        L15:
            this.f381548a.setStateRefreshing(true);
            return;
        L16:
            SmartRefreshLayout r103 = this.f381548a;
            if (r103.V1.isOpening == false) goto L19;
        L21:
            this.f381548a.setViceState(RefreshState.LoadReleased);
            return;
        L19:
            if (r103.k(r103.B) == false) goto L21;
            this.f381548a.n(RefreshState.LoadReleased);
            return;
        L22:
            SmartRefreshLayout r104 = this.f381548a;
            if (r104.V1.isOpening == false) goto L25;
        L27:
            this.f381548a.setViceState(RefreshState.RefreshReleased);
            return;
        L25:
            if (r104.k(r104.A) == false) goto L27;
            this.f381548a.n(RefreshState.RefreshReleased);
            return;
        L28:
            SmartRefreshLayout r105 = this.f381548a;
            if (r105.V1.isOpening == false) goto L31;
        L33:
            this.f381548a.setViceState(RefreshState.ReleaseToTwoLevel);
            return;
        L31:
            if (r105.k(r105.A) == false) goto L33;
            this.f381548a.n(RefreshState.ReleaseToTwoLevel);
            return;
        L34:
            SmartRefreshLayout r106 = this.f381548a;
            if (r106.k(r106.B) == false) goto L47;
            SmartRefreshLayout r107 = this.f381548a;
            RefreshState r108 = r107.V1;
            if (r108.isOpening == true) goto L47;
            if (r108.isFinishing == true) goto L47;
            if (r107.S == true) goto L43;
        L46:
            r107.n(RefreshState.ReleaseToLoad);
            return;
        L43:
            if (r107.G == false) goto L46;
            if (r107.T == false) goto L46;
        L47:
            this.f381548a.setViceState(RefreshState.ReleaseToLoad);
            return;
        L48:
            SmartRefreshLayout r109 = this.f381548a;
            if (r109.V1.isOpening == false) goto L51;
        L53:
            this.f381548a.setViceState(RefreshState.ReleaseToRefresh);
            return;
        L51:
            if (r109.k(r109.A) == false) goto L53;
            this.f381548a.n(RefreshState.ReleaseToRefresh);
            return;
        L54:
            SmartRefreshLayout r110 = this.f381548a;
            if (r110.k(r110.B) == false) goto L65;
            SmartRefreshLayout r111 = this.f381548a;
            if (r111.V1.isOpening == true) goto L65;
            if (r111.S == true) goto L61;
        L64:
            r111.n(RefreshState.PullUpCanceled);
            d(RefreshState.None);
            return;
        L61:
            if (r111.G == false) goto L64;
            if (r111.T == false) goto L64;
        L65:
            this.f381548a.setViceState(RefreshState.PullUpCanceled);
            return;
        L66:
            SmartRefreshLayout r112 = this.f381548a;
            if (r112.V1.isOpening == false) goto L69;
        L71:
            this.f381548a.setViceState(RefreshState.PullDownCanceled);
            return;
        L69:
            if (r112.k(r112.A) == false) goto L71;
            this.f381548a.n(RefreshState.PullDownCanceled);
            d(RefreshState.None);
            return;
        L72:
            SmartRefreshLayout r113 = this.f381548a;
            if (r113.k(r113.B) == false) goto L85;
            SmartRefreshLayout r114 = this.f381548a;
            RefreshState r115 = r114.V1;
            if (r115.isOpening == true) goto L85;
            if (r115.isFinishing == true) goto L85;
            if (r114.S == true) goto L81;
        L84:
            r114.n(RefreshState.PullUpToLoad);
            return;
        L81:
            if (r114.G == false) goto L84;
            if (r114.T == false) goto L84;
        L85:
            this.f381548a.setViceState(RefreshState.PullUpToLoad);
            return;
        L86:
            SmartRefreshLayout r116 = this.f381548a;
            if (r116.V1.isOpening == false) goto L89;
        L91:
            this.f381548a.setViceState(RefreshState.PullDownToRefresh);
            return;
        L89:
            if (r116.k(r116.A) == false) goto L91;
            this.f381548a.n(RefreshState.PullDownToRefresh);
            return;
        L92:
            SmartRefreshLayout r117 = this.f381548a;
            RefreshState r118 = r117.V1;
            RefreshState r119 = RefreshState.None;
            if (r118 == r119) goto L98;
            if (r117.f381485b != 0) goto L98;
            r117.n(r119);
            return;
        L98:
            if (r117.f381485b == 0) goto L129;
            a(0);
            return;
        L129:
            return;
        }

        public final i b(int r110, boolean r111) {
            SmartRefreshLayout r100 = this.f381548a;
            if (r100.f381485b != r110) goto L13;
            m6a.f r101 = r100.L1;
            if (r101 != null) goto L7;
        L8:
            m6a.e r102 = this.f381548a.M1;
            if (r102 != null) goto L11;
        L12:
            return this;
        L11:
            if (r102.a() == true) goto L13;
        L7:
            if (r101.a() == false) goto L8;
        L13:
            SmartRefreshLayout r103 = this.f381548a;
            int r112 = r103.f381485b;
            r103.f381485b = r110;
            if (r111 == false) goto L35;
            RefreshState r104 = r103.f381487b2;
            if (r104.isDragging == true) goto L20;
            if (r104.isOpening == false) goto L35;
        L20:
            if (r110 <= (r103.f381486b1 * r103.G1)) goto L25;
            if (r103.V1 == RefreshState.ReleaseToTwoLevel) goto L35;
            r103.T1.d(RefreshState.ReleaseToRefresh);
            goto L35
        L25:
            if ((-r110) > (r103.f381496h1 * r103.H1)) goto L27;
        L29:
            if (r110 < 0) goto L31;
        L33:
            if (r110 <= 0) goto L35;
            r103.T1.d(RefreshState.PullDownToRefresh);
            goto L35
        L31:
            if (r103.S == true) goto L33;
            r103.T1.d(RefreshState.PullUpToLoad);
            goto L35
        L27:
            if (r103.S == true) goto L29;
            r103.T1.d(RefreshState.ReleaseToLoad);
        L35:
            SmartRefreshLayout r105 = this.f381548a;
            if (r105.P1 == null) goto L106;
            if (r110 < 0) goto L46;
            m6a.f r106 = r105.L1;
            if (r106 == null) goto L46;
            if (r105.l(r105.E, r106) == false) goto L43;
            int r107 = r110;
        L45:
            boolean r108 = true;
        L47:
            if (r110 > 0) goto L56;
            SmartRefreshLayout r109 = this.f381548a;
            m6a.e r113 = r109.M1;
            if (r113 == null) goto L56;
            if (r109.l(r109.F, r113) == false) goto L53;
            r107 = r110;
        L55:
            r108 = true;
            goto L56
        L53:
            if (r112 <= 0) goto L56;
            r107 = 0;
        L56:
            if (r108 == false) goto L106;
            SmartRefreshLayout r114 = this.f381548a;
            r114.P1.d(r107, r114.f381512r, r114.f381513s);
            SmartRefreshLayout r115 = this.f381548a;
            if (r115.S == true) goto L60;
        L70:
            SmartRefreshLayout r116 = this.f381548a;
            if (r116.C == false) goto L77;
            m6a.f r117 = r116.L1;
            if (r117 == null) goto L77;
            if (r117.getSpinnerStyle() != n6a.b.f518184e) goto L77;
            boolean r118 = true;
        L78:
            if (r118 == false) goto L80;
        L83:
            boolean r119 = true;
        L84:
            SmartRefreshLayout r120 = this.f381548a;
            if (r120.D == false) goto L91;
            m6a.e r121 = r120.M1;
            if (r121 == null) goto L91;
            if (r121.getSpinnerStyle() != n6a.b.f518184e) goto L91;
            boolean r122 = true;
        L92:
            if (r122 == false) goto L94;
        L97:
            boolean r123 = true;
        L98:
            if (r119 == false) goto L101;
            if (r107 >= 0) goto L104;
            if (r112 <= 0) goto L101;
        L104:
            r103.invalidate();
        L101:
            if (r123 == false) goto L106;
            if (r107 <= 0) goto L104;
            if (r112 >= 0) goto L106;
        L94:
            if (this.f381548a.f381510p2 != 0) goto L97;
            r123 = false;
        L91:
            r122 = false;
            goto L92
        L80:
            if (this.f381548a.f381497h2 != 0) goto L83;
            r119 = false;
        L77:
            r118 = false;
            goto L78
        L60:
            if (r115.T == false) goto L70;
            if (r115.G == false) goto L70;
            m6a.e r124 = r115.M1;
            if ((r124 instanceof m6a.e) == false) goto L70;
            if (r124.getSpinnerStyle() != n6a.b.f518183d) goto L70;
            SmartRefreshLayout r125 = this.f381548a;
            if (r125.k(r125.B) == false) goto L70;
            this.f381548a.M1.getView().setTranslationY(Math.max(0, r107));
            goto L70
        L43:
            if (r112 >= 0) goto L46;
            r107 = 0;
        L46:
            r107 = 0;
            r108 = false;
        L106:
            if (r110 >= 0) goto L109;
            if (r112 > 0) goto L109;
        L153:
            if (r110 <= 0) goto L156;
            if (r112 < 0) goto L156;
        L200:
            return this;
        L156:
            if (this.f381548a.M1 == null) goto L200;
            int r126 = -Math.min(r110, 0);
            SmartRefreshLayout r127 = this.f381548a;
            int r128 = r127.f381496h1;
            int r129 = (int) (r128 * r127.f381524y1);
            float r130 = r126 * 1.0f;
            if (r128 != 0) goto L160;
            int r131 = 1;
        L161:
            float r132 = r130 / r131;
            if (r127.k(r127.B) == false) goto L164;
        L166:
            SmartRefreshLayout r133 = this.f381548a;
            if (r112 != r133.f381485b) goto L169;
        L185:
            if (r111 == true) goto L187;
        L193:
            SmartRefreshLayout r134 = this.f381548a;
            if (r112 == r134.f381485b) goto L200;
            q6a.c r135 = r134.f381501k0;
            if (r135 == null) goto L200;
            if ((r134.M1 instanceof m6a.e) == false) goto L200;
            r135.m(r111, r132);
            goto L200
        L187:
            if (this.f381548a.M1.a() == false) goto L193;
            int r136 = (int) this.f381548a.f381499j;
            int r137 = r103.getWidth();
            SmartRefreshLayout r138 = this.f381548a;
            float r139 = r138.f381499j;
            if (r137 != 0) goto L191;
            int r140 = 1;
        L192:
            r138.M1.d(r139 / r140, r136, r137);
            goto L193
        L191:
            r140 = r137;
            goto L192
        L169:
            if (r133.M1.getSpinnerStyle() != n6a.b.f518183d) goto L178;
            this.f381548a.M1.getView().setTranslationY(this.f381548a.f381485b);
            SmartRefreshLayout r141 = this.f381548a;
            if (r141.f381510p2 != 0) goto L173;
        L184:
            this.f381548a.M1.b(r111, r132, r126, r128, r129);
            goto L185
        L173:
            if (r141.Q1 == null) goto L184;
            if (r141.l(r141.F, r141.M1) == true) goto L184;
            r103.invalidate();
            goto L184
        L178:
            if (this.f381548a.M1.getSpinnerStyle().f518190c == false) goto L184;
            View r142 = this.f381548a.M1.getView();
            ViewGroup.LayoutParams r143 = r142.getLayoutParams();
            if ((r143 instanceof ViewGroup.MarginLayoutParams) == false) goto L182;
            ViewGroup.MarginLayoutParams r144 = (ViewGroup.MarginLayoutParams) r143;
        L183:
            r142.measure(View.MeasureSpec.makeMeasureSpec(r142.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-this.f381548a.f381485b) - r144.bottomMargin) - r144.topMargin, 0), 1073741824));
            int r145 = r144.leftMargin;
            int r146 = (r144.topMargin + r103.getMeasuredHeight()) - this.f381548a.f381517v1;
            r142.layout(r145, r146 - r142.getMeasuredHeight(), r142.getMeasuredWidth() + r145, r146);
            goto L184
        L182:
            r144 = SmartRefreshLayout.J2;
            goto L183
        L164:
            if (this.f381548a.V1 != RefreshState.LoadFinish) goto L193;
            if (r111 == true) goto L193;
        L160:
            r131 = r128;
        L109:
            if (this.f381548a.L1 == null) goto L153;
            int r147 = Math.max(r110, 0);
            SmartRefreshLayout r148 = this.f381548a;
            int r149 = r148.f381486b1;
            int r150 = (int) (r149 * r148.f381521x1);
            float r151 = r147 * 1.0f;
            if (r149 != 0) goto L113;
            int r152 = 1;
        L114:
            float r153 = r151 / r152;
            if (r148.k(r148.A) == false) goto L117;
        L119:
            SmartRefreshLayout r154 = this.f381548a;
            if (r112 != r154.f381485b) goto L122;
        L138:
            if (r111 == true) goto L140;
        L146:
            SmartRefreshLayout r155 = this.f381548a;
            if (r112 == r155.f381485b) goto L153;
            q6a.c r156 = r155.f381501k0;
            if (r156 == null) goto L153;
            if ((r155.L1 instanceof m6a.f) == false) goto L153;
            r156.f(r111, r153);
            goto L153
        L140:
            if (this.f381548a.L1.a() == false) goto L146;
            int r157 = (int) this.f381548a.f381499j;
            int r158 = r103.getWidth();
            SmartRefreshLayout r159 = this.f381548a;
            float r160 = r159.f381499j;
            if (r158 != 0) goto L144;
            int r161 = 1;
        L145:
            r159.L1.d(r160 / r161, r157, r158);
            goto L146
        L144:
            r161 = r158;
            goto L145
        L122:
            if (r154.L1.getSpinnerStyle() != n6a.b.f518183d) goto L131;
            this.f381548a.L1.getView().setTranslationY(this.f381548a.f381485b);
            SmartRefreshLayout r162 = this.f381548a;
            if (r162.f381497h2 != 0) goto L126;
        L137:
            this.f381548a.L1.b(r111, r153, r147, r149, r150);
            goto L138
        L126:
            if (r162.Q1 == null) goto L137;
            if (r162.l(r162.E, r162.L1) == true) goto L137;
            r103.invalidate();
            goto L137
        L131:
            if (this.f381548a.L1.getSpinnerStyle().f518190c == false) goto L137;
            View r163 = this.f381548a.L1.getView();
            ViewGroup.LayoutParams r164 = r163.getLayoutParams();
            if ((r164 instanceof ViewGroup.MarginLayoutParams) == false) goto L135;
            ViewGroup.MarginLayoutParams r165 = (ViewGroup.MarginLayoutParams) r164;
        L136:
            r163.measure(View.MeasureSpec.makeMeasureSpec(r163.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f381548a.f381485b - r165.bottomMargin) - r165.topMargin, 0), 1073741824));
            int r166 = r165.leftMargin;
            int r167 = r165.topMargin + this.f381548a.f381509p1;
            r163.layout(r166, r167, r163.getMeasuredWidth() + r166, r163.getMeasuredHeight() + r167);
            goto L137
        L135:
            r165 = SmartRefreshLayout.J2;
            goto L136
        L117:
            if (this.f381548a.V1 != RefreshState.RefreshFinish) goto L146;
            if (r111 == true) goto L146;
        L113:
            r152 = r149;
            goto L114
        }

        public final i c(m6a.g r100, int r101) {
            SmartRefreshLayout r102 = this.f381548a;
            if (r102.Q1 != null) goto L7;
            if (r101 == 0) goto L7;
            r102.Q1 = new Paint();
        L7:
            if (r100.equals(this.f381548a.L1) == false) goto L10;
            this.f381548a.f381497h2 = r101;
        L12:
            return this;
        L10:
            if (r100.equals(this.f381548a.M1) == false) goto L12;
            this.f381548a.f381510p2 = r101;
            goto L12
        }
    }

    public static void setDefaultRefreshFooterCreator(m6a.a r100) {
    }

    public static void setDefaultRefreshHeaderCreator(m6a.b r100) {
    }

    public static void setDefaultRefreshInitializer(m6a.c r100) {
    }

    @Override // m6a.i
    public ViewGroup getLayout() {
        return this;
    }

    static {
        J2 = new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f381519w.getCurrY();
        if (this.f381519w.computeScrollOffset() == false) goto L62;
        int r100 = this.f381519w.getFinalY();
        if (r100 < 0) goto L7;
    L12:
        if (r100 > 0) goto L14;
    L60:
        this.F2 = true;
        invalidate();
        return;
    L14:
        if (this.B == true) goto L18;
        if (this.f381483J == false) goto L60;
    L18:
        if (this.P1.canLoadMore() == false) goto L60;
    L20:
        if (this.F2 == false) goto L59;
        if (r100 <= 0) goto L23;
        float r101 = -this.f381519w.getCurrVelocity();
    L25:
        if (this.I2 != null) goto L59;
        if (r101 <= 0.0f) goto L34;
        RefreshState r102 = this.V1;
        if (r102 != RefreshState.Refreshing) goto L31;
    L32:
        this.H2 = new g(this, r101, this.f381486b1);
        goto L59
    L31:
        if (r102 == RefreshState.TwoLevel) goto L32;
    L34:
        if (r101 >= 0.0f) goto L55;
        if (this.V1 != RefreshState.Loading) goto L38;
    L53:
        this.H2 = new g(this, r101, -this.f381496h1);
        goto L59
    L38:
        if (this.G == false) goto L46;
        if (this.S == false) goto L46;
        if (this.T == false) goto L46;
        if (k(this.B) == true) goto L53;
    L46:
        if (this.K == false) goto L55;
        if (this.S == true) goto L55;
        if (k(this.B) == false) goto L55;
        if (this.V1 != RefreshState.Refreshing) goto L53;
    L55:
        if (this.f381485b != 0) goto L59;
        if (this.I == false) goto L59;
        this.H2 = new g(this, r101, 0);
        goto L59
    L23:
        r101 = this.f381519w.getCurrVelocity();
    L59:
        this.f381519w.forceFinished(true);
        return;
    L7:
        if (this.A == true) goto L11;
        if (this.f381483J == false) goto L12;
    L11:
        if (this.P1.b() == true) goto L20;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.V0.getNestedScrollAxes();
    }

    public m6a.e getRefreshFooter() {
        m6a.e r100 = this.M1;
        if ((r100 instanceof m6a.e) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    public m6a.f getRefreshHeader() {
        m6a.f r100 = this.L1;
        if ((r100 instanceof m6a.f) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        if (this.P == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f381483J == false) goto L7;
    L10:
        return true;
    L7:
        if (this.A == true) goto L10;
        if (this.B == false) goto L11;
        goto L10
    }

    public final void o() {
        RefreshState r100 = this.V1;
        RefreshState r101 = RefreshState.TwoLevel;
        if (r100 == r101) goto L5;
        RefreshState r102 = RefreshState.Loading;
        if (r100 != r102) goto L22;
    L67:
        int r103 = this.f381485b;
        int r104 = -this.f381496h1;
        if (r103 >= r104) goto L70;
        this.T1.a(r104);
        return;
    L70:
        if (r103 <= 0) goto L94;
        this.T1.a(0);
        return;
    L94:
        return;
    L22:
        if (this.G == true) goto L24;
    L32:
        RefreshState r105 = this.V1;
        RefreshState r106 = RefreshState.Refreshing;
        if (r105 != r106) goto L40;
        int r107 = this.f381485b;
        int r108 = this.f381486b1;
        if (r107 <= r108) goto L37;
        this.T1.a(r108);
        return;
    L37:
        if (r107 >= 0) goto L80;
        this.T1.a(0);
        return;
    L80:
        return;
    L40:
        if (r105 != RefreshState.PullDownToRefresh) goto L43;
        this.T1.d(RefreshState.PullDownCanceled);
        return;
    L43:
        if (r105 != RefreshState.PullUpToLoad) goto L46;
        this.T1.d(RefreshState.PullUpCanceled);
        return;
    L46:
        if (r105 != RefreshState.ReleaseToRefresh) goto L49;
        this.T1.d(r106);
        return;
    L49:
        if (r105 != RefreshState.ReleaseToLoad) goto L52;
        this.T1.d(r102);
        return;
    L52:
        if (r105 != RefreshState.ReleaseToTwoLevel) goto L55;
        this.T1.d(RefreshState.TwoLevelReleased);
        return;
    L55:
        if (r105 != RefreshState.RefreshReleased) goto L60;
        if (this.I2 != null) goto L87;
        this.T1.a(this.f381486b1);
        return;
    L87:
        return;
    L60:
        if (r105 != RefreshState.LoadReleased) goto L65;
        if (this.I2 != null) goto L89;
        this.T1.a(-this.f381496h1);
        return;
    L89:
        return;
    L65:
        if (this.f381485b == 0) goto L91;
        this.T1.a(0);
        return;
    L91:
        return;
    L24:
        if (this.S == false) goto L32;
        if (this.T == false) goto L32;
        if (this.f381485b >= 0) goto L32;
        if (k(this.B) == false) goto L32;
    L5:
        if (this.f381516v <= (-1000)) goto L12;
        if (this.f381485b <= (getMeasuredHeight() / 2)) goto L12;
        ValueAnimator r109 = this.T1.a(getMeasuredHeight());
        if (r109 == null) goto L73;
        r109.setDuration(this.f381490e);
        return;
    L73:
        return;
    L12:
        if (this.f381505n == false) goto L75;
        i r110 = this.T1;
        SmartRefreshLayout r111 = r110.f381548a;
        if (r111.V1 != r101) goto L76;
        r111.T1.d(RefreshState.TwoLevelFinish);
        if (r110.f381548a.f381485b != 0) goto L18;
        r110.b(0, false);
        r110.f381548a.n(RefreshState.None);
        return;
    L18:
        r110.a(0).setDuration(r110.f381548a.f381490e);
        return;
    L76:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = true;
        this.f381525y2 = true;
        if (isInEditMode() == false) goto L5;
    L37:
        int[] r101 = this.f381526z;
        if (r101 == null) goto L45;
        m6a.f r102 = this.L1;
        if (r102 == null) goto L42;
        r102.setPrimaryColors(r101);
    L42:
        m6a.e r103 = this.M1;
        if (r103 == null) goto L45;
        r103.setPrimaryColors(this.f381526z);
    L45:
        o6a.a r104 = this.P1;
        if (r104 == null) goto L48;
        super.bringChildToFront(r104.f522213a);
    L48:
        m6a.f r105 = this.L1;
        if (r105 != null) goto L51;
    L53:
        m6a.e r106 = this.M1;
        if (r106 != null) goto L56;
        return;
    L56:
        if (r106.getSpinnerStyle().f518189b == false) goto L64;
        super.bringChildToFront(this.M1.getView());
        return;
    L64:
        return;
    L51:
        if (r105.getSpinnerStyle().f518189b == false) goto L53;
        super.bringChildToFront(this.L1.getView());
        goto L53
    L5:
        if (this.L1 != null) goto L8;
        s(new BezierRadarHeader(getContext()));
    L8:
        if (this.M1 != null) goto L11;
        boolean r107 = this.B;
        r(new BallPulseFooter(getContext()));
        this.B = r107;
    L18:
        if (this.P1 != null) goto L32;
        int r108 = getChildCount();
        int r109 = 0;
    L20:
        if (r109 >= r108) goto L32;
        View r110 = getChildAt(r109);
        m6a.f r111 = this.L1;
        if (r111 != null) goto L24;
    L25:
        m6a.e r112 = this.M1;
        if (r112 != null) goto L28;
    L29:
        this.P1 = new o6a.a(r110);
    L30:
        r109 = r109 + 1;
        goto L20
    L28:
        if (r110 == r112.getView()) goto L30;
    L24:
        if (r110 == r111.getView()) goto L30;
    L32:
        if (this.P1 != null) goto L34;
        int r113 = r6a.b.c(20.0f);
        View r114 = new View(getContext());
        super.addView(r114, 0, new LayoutParams(-1));
        o6a.a r115 = new o6a.a(r114);
        this.P1 = r115;
        r115.f522213a.setPadding(r113, r113, r113, r113);
    L34:
        View r116 = findViewById(this.f381507p);
        View r117 = findViewById(this.f381511q);
        this.P1.f();
        o6a.a r118 = this.P1;
        r118.f522221i.f522224c = this.O;
        r118.g(this.T1, r116, r117);
        if (this.f381485b == 0) goto L37;
        n(RefreshState.None);
        o6a.a r119 = this.P1;
        this.f381485b = 0;
        r119.d(0, this.f381512r, this.f381513s);
        goto L37
    L11:
        if (this.B == false) goto L13;
    L16:
        this.B = r100;
        goto L18
    L13:
        if (this.U == false) goto L16;
        r100 = false;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f381525y2 = false;
        this.T1.b(0, true);
        n(RefreshState.None);
        Handler r100 = this.S1;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.U = true;
        this.H2 = null;
        ValueAnimator r101 = this.I2;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
        this.I2.removeAllUpdateListeners();
        this.I2.cancel();
        this.I2 = null;
    L8:
        this.E2 = false;
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
        if (r6a.b.d(r105) == false) goto L13;
        if (r103 < 2) goto L11;
        if (r101 != 1) goto L13;
    L11:
        r102 = r101;
        r103 = 2;
    L19:
        r101 = r101 + 1;
    L13:
        if ((r105 instanceof m6a.g) == true) goto L19;
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
        this.P1 = new o6a.a(super.getChildAt(r102));
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
        if (this.L1 != null) goto L41;
        if ((r108 instanceof m6a.f) == true) goto L58;
    L41:
        if (r107 == r104) goto L46;
        if (r104 != (-1)) goto L62;
        if ((r108 instanceof m6a.e) == true) goto L46;
    L62:
        r107 = r107 + 1;
    L46:
        if (this.B == false) goto L48;
    L51:
        boolean r109 = true;
    L52:
        this.B = r109;
        if ((r108 instanceof m6a.e) == false) goto L55;
        m6a.e r110 = (m6a.e) r108;
    L56:
        this.M1 = r110;
        goto L62
    L55:
        r110 = new o6a.b(r108);
        goto L56
    L48:
        if (this.U == false) goto L51;
        r109 = false;
    L58:
        if ((r108 instanceof m6a.f) == false) goto L60;
        m6a.f r111 = (m6a.f) r108;
    L61:
        this.L1 = r111;
        goto L62
    L60:
        r111 = new o6a.c(r108);
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
        throw new RuntimeException("Most only support three sub view");
    }

    public RefreshState getState() {
        return this.V1;
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
        if (r100 == 6) goto L21;
        if (r100 == 5) goto L21;
    L23:
        this.f381499j = r107;
        this.f381500k = r108;
        if (this.H0 == false) goto L53;
        int r109 = this.f381508p0;
        boolean r113 = super.dispatchTouchEvent(r210);
        if (r100 == 2) goto L28;
    L51:
        return r113;
    L28:
        if (r109 != this.f381508p0) goto L51;
        int r114 = (int) this.f381499j;
        int r115 = getWidth();
        float r116 = this.f381499j;
        if (r115 == 0) goto L33;
        r111 = r115;
    L33:
        float r117 = r116 / r111;
        if (k(this.A) == false) goto L43;
        if (this.f381485b <= 0) goto L43;
        m6a.f r118 = this.L1;
        if (r118 == null) goto L43;
        if (r118.a() == false) goto L43;
        this.L1.d(r117, r114, r115);
    L43:
        if (k(this.B) == false) goto L51;
        if (this.f381485b >= 0) goto L51;
        m6a.e r119 = this.M1;
        if (r119 == null) goto L51;
        if (r119.a() == false) goto L51;
        this.M1.d(r117, r114, r115);
        goto L51
    L53:
        if (isEnabled() == false) goto L244;
        if (this.A == true) goto L61;
        if (this.B == true) goto L61;
        if (this.f381483J == false) goto L244;
    L61:
        if (this.f381518v2 == false) goto L69;
        RefreshState r120 = this.V1;
        if (r120.isOpening == true) goto L67;
        if (r120.isFinishing == false) goto L69;
    L67:
        if (r120.isHeader == true) goto L244;
    L69:
        if (this.f381522x2 == false) goto L78;
        RefreshState r121 = this.V1;
        if (r121.isOpening == true) goto L75;
        if (r121.isFinishing == false) goto L78;
    L75:
        if (r121.isFooter == true) goto L244;
    L78:
        if (j(r100) == true) goto L242;
        RefreshState r122 = this.V1;
        if (r122.isFinishing == true) goto L242;
        RefreshState r123 = RefreshState.Loading;
        if (r122 != r123) goto L86;
        if (this.R == true) goto L242;
    L86:
        if (r122 != RefreshState.Refreshing) goto L91;
        if (this.Q == true) goto L242;
    L91:
        if (r100 != 0) goto L93;
        this.f381516v = 0;
        this.f381520x.addMovement(r210);
        this.f381519w.forceFinished(true);
        this.f381495h = r107;
        this.f381498i = r108;
        this.f381488c = 0;
        this.f381489d = this.f381485b;
        this.f381505n = false;
        this.f381506o = super.dispatchTouchEvent(r210);
        if (this.V1 == RefreshState.TwoLevel) goto L235;
    L238:
        o6a.a r124 = this.P1;
        if (r124 == null) goto L241;
        r124.a(r210);
    L241:
        return true;
    L235:
        if (this.f381498i >= ((getMeasuredHeight() * 5) / 6)) goto L238;
        this.f381504m = 'h';
        return this.f381506o;
    L93:
        if (r100 != 1) goto L95;
        this.f381520x.addMovement(r210);
        this.f381520x.computeCurrentVelocity(1000, this.f381515u);
        this.f381516v = (int) this.f381520x.getYVelocity();
        t(0.0f);
    L223:
        this.f381520x.clear();
        this.f381504m = 'n';
        MotionEvent r125 = this.G2;
        if (r125 == null) goto L226;
        r125.recycle();
        this.G2 = null;
        long r126 = r210.getEventTime();
        MotionEvent r127 = MotionEvent.obtain(r126, r126, r100, this.f381495h, r108, 0);
        super.dispatchTouchEvent(r127);
        r127.recycle();
    L226:
        o();
        if (this.f381505n == false) goto L231;
        this.f381505n = false;
        return true;
    L231:
        return super.dispatchTouchEvent(r210);
    L95:
        if (r100 == 2) goto L98;
        if (r100 == 3) goto L223;
    L98:
        float r128 = r107 - this.f381495h;
        float r129 = r108 - this.f381498i;
        this.f381520x.addMovement(r210);
        if (this.f381505n == true) goto L161;
        char r130 = this.f381504m;
        if (r130 == 'h') goto L161;
        if (this.P1 == null) goto L161;
        if (r130 != 'v') goto L107;
    L118:
        this.f381504m = 'v';
        if (r129 <= 0.0f) goto L130;
        if (this.f381485b >= 0) goto L123;
    L128:
        this.f381505n = true;
        this.f381498i = r108 - this.f381484a;
    L145:
        if (this.f381505n == false) goto L161;
        r129 = r108 - this.f381498i;
        if (this.f381506o == false) goto L149;
        r210.setAction(3);
        super.dispatchTouchEvent(r210);
    L149:
        i r131 = this.T1;
        int r132 = this.f381485b;
        if (r132 > 0) goto L156;
        if (r132 == 0) goto L153;
    L155:
        RefreshState r133 = RefreshState.PullUpToLoad;
    L157:
        r131.d(r133);
        ViewParent r134 = getParent();
        if ((r134 instanceof ViewGroup) == false) goto L161;
        ((ViewGroup) r134).requestDisallowInterceptTouchEvent(true);
        goto L161
    L153:
        if (r129 <= 0.0f) goto L155;
    L156:
        r133 = RefreshState.PullDownToRefresh;
        goto L157
    L123:
        if (this.f381483J == true) goto L127;
        if (this.A == false) goto L130;
    L127:
        if (this.P1.b() == true) goto L128;
    L130:
        if (r129 >= 0.0f) goto L145;
        if (this.f381485b <= 0) goto L134;
    L143:
        this.f381505n = true;
        this.f381498i = this.f381484a + r108;
        goto L145
    L134:
        if (this.f381483J == true) goto L138;
        if (this.B == false) goto L145;
    L138:
        if (this.V1 != r123) goto L142;
        if (this.E2 == true) goto L143;
    L142:
        if (this.P1.canLoadMore() == false) goto L145;
    L107:
        if (Math.abs(r129) < this.f381484a) goto L112;
        if (Math.abs(r128) < Math.abs(r129)) goto L118;
    L112:
        if (Math.abs(r128) < this.f381484a) goto L161;
        if (Math.abs(r128) <= Math.abs(r129)) goto L161;
        if (this.f381504m == 'v') goto L161;
        this.f381504m = 'h';
    L161:
        if (this.f381505n == false) goto L216;
        int r135 = ((int) r129) + this.f381489d;
        RefreshState r136 = this.f381487b2;
        if (r136.isHeader == false) goto L168;
        if (r135 >= 0) goto L166;
    L172:
        this.f381488c = r135;
        long r211 = r210.getEventTime();
        if (this.G2 != null) goto L175;
        MotionEvent r137 = MotionEvent.obtain(r211, r211, 0, this.f381495h + r128, this.f381498i, 0);
        this.G2 = r137;
        super.dispatchTouchEvent(r137);
    L175:
        MotionEvent r138 = MotionEvent.obtain(r211, r211, 2, this.f381495h + r128, this.f381498i + r135, 0);
        super.dispatchTouchEvent(r138);
        if (this.E2 == true) goto L178;
    L182:
        if (r135 > 0) goto L184;
    L190:
        if (r135 < 0) goto L192;
    L198:
        r110 = r135;
    L199:
        RefreshState r139 = this.f381487b2;
        if (r139.isHeader == false) goto L203;
        if (r110 >= 0) goto L203;
    L206:
        if (this.f381485b == 0) goto L208;
        m(0.0f);
    L208:
        return true;
    L203:
        if (r139.isFooter == false) goto L210;
        if (r110 > 0) goto L206;
    L210:
        if (this.G2 == null) goto L212;
        this.G2 = null;
        r138.setAction(3);
        super.dispatchTouchEvent(r138);
    L212:
        r138.recycle();
        r135 = r110;
    L213:
        m(r135);
        return true;
    L192:
        if (this.f381483J == true) goto L196;
        if (this.B == false) goto L198;
    L196:
        if (this.P1.canLoadMore() == false) goto L198;
        this.f381500k = r108;
        this.f381498i = r108;
        this.f381489d = 0;
        this.T1.d(RefreshState.PullUpToLoad);
        goto L199
    L184:
        if (this.f381483J == true) goto L188;
        if (this.A == false) goto L190;
    L188:
        if (this.P1.b() == false) goto L190;
        this.f381500k = r108;
        this.f381498i = r108;
        this.f381489d = 0;
        this.T1.d(RefreshState.PullDownToRefresh);
        goto L199
    L178:
        if (r129 <= this.f381484a) goto L182;
        if (this.f381485b >= 0) goto L182;
        this.E2 = false;
        goto L182
    L166:
        if (this.f381488c < 0) goto L172;
    L168:
        if (r136.isFooter == false) goto L213;
        if (r135 > 0) goto L172;
        if (this.f381488c <= 0) goto L213;
    L216:
        if (this.E2 == false) goto L231;
        if (r129 <= this.f381484a) goto L231;
        if (this.f381485b >= 0) goto L231;
        this.E2 = false;
    L242:
        return false;
    L244:
        return super.dispatchTouchEvent(r210);
    L21:
        if (this.f381505n == false) goto L23;
        this.f381498i += r108 - this.f381500k;
        goto L23
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

    public final boolean j(int r100) {
        if (r100 != 0) goto L21;
        if (this.I2 == null) goto L19;
        RefreshState r101 = this.V1;
        if (r101.isFinishing == false) goto L9;
    L18:
        return true;
    L9:
        if (r101 == RefreshState.TwoLevelReleased) goto L18;
        if (r101 != RefreshState.PullDownCanceled) goto L15;
        this.T1.d(RefreshState.PullDownToRefresh);
    L17:
        this.I2.cancel();
        this.I2 = null;
        goto L19
    L15:
        if (r101 != RefreshState.PullUpCanceled) goto L17;
        this.T1.d(RefreshState.PullUpToLoad);
    L19:
        this.H2 = null;
    L21:
        if (this.I2 != null) goto L25;
        return false;
    L25:
        return true;
    }

    public final boolean k(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.L == true) goto L6;
        return true;
    }

    public final void m(float r110) {
        if (this.H0 == true) goto L5;
    L11:
        float r100 = r110;
    L12:
        RefreshState r101 = this.V1;
        if (r101 != RefreshState.TwoLevel) goto L18;
        if (r100 <= 0.0f) goto L18;
        this.T1.b(Math.min((int) r100, getMeasuredHeight()), true);
    L64:
        if (this.K == true) goto L66;
        return;
    L66:
        if (this.S == false) goto L68;
        return;
    L68:
        if (k(this.B) == true) goto L70;
        return;
    L70:
        if (r100 >= 0.0f) goto L85;
        RefreshState r102 = this.V1;
        if (r102 != RefreshState.Refreshing) goto L74;
        return;
    L74:
        if (r102 != RefreshState.Loading) goto L76;
        return;
    L76:
        if (r102 != RefreshState.LoadFinish) goto L78;
        return;
    L78:
        if (this.R == false) goto L80;
        this.H2 = null;
        this.T1.a(-this.f381496h1);
    L80:
        setStateDirectLoading(false);
        this.S1.postDelayed(new f(this), this.f381491f);
        return;
    L85:
        return;
    L18:
        if (r101 != RefreshState.Refreshing) goto L29;
        if (r100 < 0.0f) goto L29;
        float r103 = this.f381486b1;
        if (r100 >= r103) goto L24;
        this.T1.b((int) r100, true);
        goto L64
    L24:
        double r104 = (this.f381521x1 - 1.0f) * r103;
        int r105 = Math.max((this.f381492g * 4) / 3, getHeight());
        int r111 = this.f381486b1;
        double r112 = r105 - r111;
        double r106 = Math.max(0.0f, (r100 - r111) * this.f381503l);
        double r107 = -r106;
        if (r112 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
        r112 = 1.0d;
    L27:
        this.T1.b(((int) Math.min(r104 * (1.0d - Math.pow(100.0d, r107 / r112)), r106)) + this.f381486b1, true);
    L29:
        if (r100 >= 0.0f) goto L54;
        if (r101 != RefreshState.Loading) goto L33;
    L46:
        int r108 = this.f381496h1;
        if (r100 <= (-r108)) goto L49;
        this.T1.b((int) r100, true);
        goto L64
    L49:
        double r109 = (this.f381524y1 - 1.0f) * r108;
        int r113 = Math.max((this.f381492g * 4) / 3, getHeight());
        int r114 = this.f381496h1;
        double r115 = r113 - r114;
        double r116 = -Math.min(0.0f, (r114 + r100) * this.f381503l);
        double r117 = -r116;
        if (r115 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L52;
        r115 = 1.0d;
    L52:
        this.T1.b(((int) (-Math.min(r109 * (1.0d - Math.pow(100.0d, r117 / r115)), r116))) - this.f381496h1, true);
        goto L64
    L33:
        if (this.G == false) goto L41;
        if (this.S == false) goto L41;
        if (this.T == false) goto L41;
        if (k(this.B) == true) goto L46;
    L41:
        if (this.K == false) goto L54;
        if (this.S == true) goto L54;
        if (k(this.B) == true) goto L46;
    L54:
        if (r100 < 0.0f) goto L59;
        double r118 = this.f381521x1 * this.f381486b1;
        double r119 = Math.max(this.f381492g / 2, getHeight());
        double r120 = Math.max(0.0f, this.f381503l * r100);
        double r121 = -r120;
        if (r119 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L58;
        r119 = 1.0d;
    L58:
        this.T1.b((int) Math.min(r118 * (1.0d - Math.pow(100.0d, r121 / r119)), r120), true);
        goto L64
    L59:
        double r122 = this.f381524y1 * this.f381496h1;
        double r123 = Math.max(this.f381492g / 2, getHeight());
        double r124 = -Math.min(0.0f, this.f381503l * r100);
        double r125 = -r124;
        if (r123 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L62;
        r123 = 1.0d;
    L62:
        this.T1.b((int) (-Math.min(r122 * (1.0d - Math.pow(100.0d, r125 / r123)), r124)), true);
        goto L64
    L5:
        if (this.O == true) goto L11;
        if (r110 >= 0.0f) goto L11;
        if (this.P1.canLoadMore() == true) goto L11;
        r100 = 0.0f;
        goto L12
    }

    public final void n(RefreshState r100) {
        RefreshState r101 = this.V1;
        if (r101 == r100) goto L15;
        this.V1 = r100;
        this.f381487b2 = r100;
        m6a.f r102 = this.L1;
        m6a.e r103 = this.M1;
        q6a.c r104 = this.f381501k0;
        if (r102 == null) goto L7;
        r102.i(this, r101, r100);
    L7:
        if (r103 == null) goto L9;
        r103.i(this, r101, r100);
    L9:
        if (r104 == null) goto L12;
        r104.i(this, r101, r100);
    L12:
        if (r100 != RefreshState.LoadFinish) goto L18;
        this.E2 = false;
        return;
    L18:
        return;
    L15:
        if (this.f381487b2 == r101) goto L20;
        this.f381487b2 = r101;
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.V0.onStopNestedScroll(r100);
        this.H0 = false;
        this.f381508p0 = 0;
        o();
        this.P0.stopNestedScroll();
    }

    public final void p(boolean r100) {
        RefreshState r101 = this.V1;
        if (r101 != RefreshState.Refreshing) goto L7;
        if (r100 == false) goto L7;
        i(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f381494g2))), 300) << 16, true, Boolean.TRUE);
        return;
    L7:
        if (r101 != RefreshState.Loading) goto L11;
        if (r100 == false) goto L11;
        h(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f381494g2))), 300) << 16, true);
        return;
    L11:
        if (this.S == r100) goto L33;
        this.S = r100;
        m6a.e r102 = this.M1;
        if ((r102 instanceof m6a.e) == true) goto L15;
        return;
    L15:
        if (r102.c(r100) == false) goto L29;
        this.T = true;
        if (this.S == true) goto L19;
        return;
    L19:
        if (this.G == true) goto L21;
        return;
    L21:
        if (this.f381485b > 0) goto L23;
        return;
    L23:
        if (this.M1.getSpinnerStyle() == n6a.b.f518183d) goto L25;
        return;
    L25:
        if (k(this.B) == true) goto L27;
        return;
    L27:
        if (l(this.A, this.L1) == false) goto L40;
        this.M1.getView().setTranslationY(this.f381485b);
        return;
    L40:
        return;
    L29:
        this.T = false;
        new RuntimeException("Footer:" + this.M1 + " NoMoreData is not supported").printStackTrace();
        return;
    }

    public m6a.i q(View r100) {
        o6a.a r101 = this.P1;
        if (r101 == null) goto L5;
        super.removeView(r101.f522213a);
    L5:
        this.P1 = new o6a.a(r100);
        super.addView(r100, getChildCount(), new LayoutParams(-1));
        if (this.f381525y2 == false) goto L8;
        View r102 = findViewById(this.f381507p);
        View r103 = findViewById(this.f381511q);
        this.P1.f();
        o6a.a r104 = this.P1;
        r104.f522221i.f522224c = this.O;
        r104.g(this.T1, r102, r103);
    L8:
        m6a.f r105 = this.L1;
        if (r105 != null) goto L11;
    L13:
        m6a.e r106 = this.M1;
        if (r106 != null) goto L16;
    L18:
        return this;
    L16:
        if (r106.getSpinnerStyle().f518189b == false) goto L18;
        super.bringChildToFront(this.M1.getView());
        goto L18
    L11:
        if (r105.getSpinnerStyle().f518189b == false) goto L13;
        super.bringChildToFront(this.L1.getView());
        goto L13
    }

    public final void r(m6a.e r100) {
        m6a.e r101 = this.M1;
        if (r101 == null) goto L5;
        super.removeView(r101.getView());
    L5:
        this.M1 = r100;
        this.E2 = false;
        this.f381510p2 = 0;
        this.T = false;
        this.f381522x2 = false;
        this.f381502k1 = this.f381502k1.b();
        if (this.U == true) goto L8;
    L11:
        boolean r102 = true;
    L12:
        this.B = r102;
        if (this.M1.getSpinnerStyle().f518189b == false) goto L15;
        super.addView(this.M1.getView(), getChildCount(), new LayoutParams(-2));
    L16:
        int[] r103 = this.f381526z;
        if (r103 == null) goto L22;
        m6a.e r104 = this.M1;
        if (r104 == null) goto L23;
        r104.setPrimaryColors(r103);
        return;
    L23:
        return;
    L22:
        return;
    L15:
        super.addView(this.M1.getView(), 0, new LayoutParams(-2));
        goto L16
    L8:
        if (this.B == true) goto L11;
        r102 = false;
        goto L12
    }

    public final void s(m6a.f r100) {
        m6a.f r101 = this.L1;
        if (r101 == null) goto L5;
        super.removeView(r101.getView());
    L5:
        this.L1 = r100;
        this.f381497h2 = 0;
        this.f381518v2 = false;
        this.f381493g1 = this.f381493g1.b();
        if (this.L1.getSpinnerStyle().f518189b == false) goto L8;
        super.addView(this.L1.getView(), getChildCount(), new LayoutParams(-2));
    L9:
        int[] r102 = this.f381526z;
        if (r102 == null) goto L15;
        m6a.f r103 = this.L1;
        if (r103 == null) goto L16;
        r103.setPrimaryColors(r102);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        super.addView(this.L1.getView(), 0, new LayoutParams(-2));
        goto L9
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r100) {
        this.P = r100;
        this.P0.setNestedScrollingEnabled(r100);
    }

    public void setStateDirectLoading(boolean r100) {
        RefreshState r101 = this.V1;
        RefreshState r102 = RefreshState.Loading;
        if (r101 == r102) goto L22;
        this.f381494g2 = System.currentTimeMillis();
        this.E2 = true;
        n(r102);
        q6a.b r103 = this.W;
        if (r103 == null) goto L9;
        if (r100 == false) goto L11;
        r103.g(this);
    L11:
        m6a.e r104 = this.M1;
        if (r104 == null) goto L14;
        int r105 = this.f381496h1;
        r104.n(this, r105, (int) (this.f381524y1 * r105));
    L14:
        q6a.c r106 = this.f381501k0;
        if (r106 != null) goto L17;
        return;
    L17:
        if ((this.M1 instanceof m6a.e) == false) goto L24;
        if (r100 == false) goto L20;
        r106.g(this);
    L20:
        this.f381501k0.s();
        return;
    L24:
        return;
    L9:
        if (this.f381501k0 != null) goto L11;
        h(2000, false);
        goto L11
    }

    public void setStateLoading(boolean r100) {
        b r101 = new b(this, r100);
        n(RefreshState.LoadReleased);
        ValueAnimator r102 = this.T1.a(-this.f381496h1);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        m6a.e r103 = this.M1;
        if (r103 == null) goto L8;
        int r104 = this.f381496h1;
        r103.k(this, r104, (int) (this.f381524y1 * r104));
    L8:
        q6a.c r105 = this.f381501k0;
        if (r105 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
        r101.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.M1 instanceof m6a.e) == false) goto L13;
        r105.w();
        goto L13
    }

    public void setStateRefreshing(boolean r100) {
        c r101 = new c(this, r100);
        n(RefreshState.RefreshReleased);
        ValueAnimator r102 = this.T1.a(this.f381486b1);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        m6a.f r103 = this.L1;
        if (r103 == null) goto L8;
        int r104 = this.f381486b1;
        r103.k(this, r104, (int) (this.f381521x1 * r104));
    L8:
        q6a.c r105 = this.f381501k0;
        if (r105 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
        r101.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.L1 instanceof m6a.f) == false) goto L13;
        r105.p();
        goto L13
    }

    public void setViceState(RefreshState r100) {
        RefreshState r101 = this.V1;
        if (r101.isDragging == false) goto L8;
        if (r101.isHeader == r100.isHeader) goto L8;
        n(RefreshState.None);
    L8:
        if (this.f381487b2 == r100) goto L11;
        this.f381487b2 = r100;
        return;
    }

    public boolean t(float r110) {
        if (r110 != 0.0f) goto L6;
        r110 = this.f381516v;
    L6:
        if (Build.VERSION.SDK_INT > 27) goto L8;
    L14:
        int r100 = 0;
        if (Math.abs(r110) <= this.f381514t) goto L107;
        int r101 = this.f381485b;
        if ((r101 * r110) >= 0.0f) goto L80;
        RefreshState r102 = this.V1;
        RefreshState r103 = RefreshState.Refreshing;
        if (r102 != r103) goto L21;
    L29:
        h r104 = new h(this, r110);
        RefreshState r111 = this.V1;
        if (r111.isFinishing == false) goto L33;
    L74:
        r104 = null;
    L77:
        this.H2 = r104;
        return true;
    L33:
        if (this.f381485b != 0) goto L35;
    L76:
        r104.f381545c = AnimationUtils.currentAnimationTimeMillis();
        r104.f381547e.S1.postDelayed(r104, 10);
        goto L77
    L35:
        if (r111.isOpening == true) goto L45;
        if (this.S == true) goto L39;
    L60:
        int r112 = this.f381485b;
        float r105 = r104.f381544b;
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
        SmartRefreshLayout r113 = r104.f381547e;
        RefreshState r108 = r113.V1;
        if (r108.isOpening == false) goto L74;
        RefreshState r109 = RefreshState.Refreshing;
        if (r108 == r109) goto L70;
    L71:
        if (r108 == r109) goto L76;
        if (r106 >= (-r113.f381496h1)) goto L76;
    L70:
        if (r106 > r113.f381486b1) goto L74;
    L39:
        if (this.G == false) goto L60;
        if (this.T == false) goto L60;
        if (k(this.B) == false) goto L60;
    L45:
        if (this.V1 == RefreshState.Loading) goto L55;
        if (this.S == false) goto L57;
        if (this.G == false) goto L57;
        if (this.T == false) goto L57;
        if (k(this.B) == true) goto L55;
    L57:
        if (this.V1 != r103) goto L76;
        if (this.f381485b <= this.f381486b1) goto L76;
    L55:
        if (this.f381485b < (-this.f381496h1)) goto L60;
    L21:
        if (r102 == RefreshState.Loading) goto L29;
        if (r101 >= 0) goto L27;
        if (this.S == true) goto L29;
    L27:
        if (r102.isReleaseToOpening == false) goto L80;
        return true;
    L80:
        if (r110 >= 0.0f) goto L95;
        if (this.I == false) goto L88;
        if (this.B == false) goto L86;
    L106:
        this.F2 = false;
        this.f381519w.fling(0, 0, 0, (int) (-r110), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.f381519w.computeScrollOffset();
        invalidate();
        goto L107
    L86:
        if (this.f381483J == true) goto L106;
    L88:
        if (this.V1 != RefreshState.Loading) goto L91;
        if (r101 >= 0) goto L106;
    L91:
        if (this.K == false) goto L95;
        if (k(this.B) == true) goto L106;
    L95:
        if (r110 <= 0.0f) goto L107;
        if (this.I == false) goto L101;
        if (this.A == true) goto L106;
    L101:
        if (this.f381483J == true) goto L106;
        if (this.V1 != RefreshState.Refreshing) goto L107;
        if (this.f381485b <= 0) goto L106;
    L107:
        return false;
    L8:
        if (this.P1 == null) goto L14;
        getScaleY();
        View r114 = this.P1.f522213a;
        if (getScaleY() != (-1.0f)) goto L14;
        if (r114.getScaleY() != (-1.0f)) goto L14;
        r110 = -r110;
        goto L14
    }

    public SmartRefreshLayout(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f381490e = 300;
        this.f381491f = 300;
        this.f381503l = 0.5f;
        this.f381504m = 'n';
        this.f381507p = -1;
        this.f381511q = -1;
        this.f381512r = -1;
        this.f381513s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.f381483J = false;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.L0 = new int[2];
        NestedScrollingChildHelper r100 = new NestedScrollingChildHelper(this);
        this.P0 = r100;
        this.V0 = new NestedScrollingParentHelper(this);
        n6a.a r101 = n6a.a.f518175c;
        this.f381493g1 = r101;
        this.f381502k1 = r101;
        this.f381521x1 = 2.5f;
        this.f381524y1 = 2.5f;
        this.G1 = 1.0f;
        this.H1 = 1.0f;
        this.T1 = new i(this);
        RefreshState r102 = RefreshState.None;
        this.V1 = r102;
        this.f381487b2 = r102;
        this.f381494g2 = 0;
        this.f381497h2 = 0;
        this.f381510p2 = 0;
        this.E2 = false;
        this.F2 = false;
        this.G2 = null;
        ViewConfiguration r103 = ViewConfiguration.get(r110);
        this.S1 = new Handler(Looper.getMainLooper());
        this.f381519w = new Scroller(r110);
        this.f381520x = VelocityTracker.obtain();
        Resources r112 = r110.getResources();
        this.f381492g = WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).heightPixels;
        this.f381523y = new r6a.b(0);
        this.f381484a = r103.getScaledTouchSlop();
        this.f381514t = r103.getScaledMinimumFlingVelocity();
        this.f381515u = r103.getScaledMaximumFlingVelocity();
        this.f381496h1 = r6a.b.c(60.0f);
        this.f381486b1 = r6a.b.c(100.0f);
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.clipChildren, android.R.attr.clipToPadding, R.attr.srlAccentColor, R.attr.srlDisableContentWhenLoading, R.attr.srlDisableContentWhenRefresh, R.attr.srlDragRate, R.attr.srlEnableAutoLoadMore, R.attr.srlEnableClipFooterWhenFixedBehind, R.attr.srlEnableClipHeaderWhenFixedBehind, R.attr.srlEnableFooterFollowWhenLoadFinished, R.attr.srlEnableFooterFollowWhenNoMoreData, R.attr.srlEnableFooterTranslationContent, R.attr.srlEnableHeaderTranslationContent, R.attr.srlEnableLoadMore, R.attr.srlEnableLoadMoreWhenContentNotFull, R.attr.srlEnableNestedScrolling, R.attr.srlEnableOverScrollBounce, R.attr.srlEnableOverScrollDrag, R.attr.srlEnablePreviewInEditMode, R.attr.srlEnablePureScrollMode, R.attr.srlEnableRefresh, R.attr.srlEnableScrollContentWhenLoaded, R.attr.srlEnableScrollContentWhenRefreshed, R.attr.srlFixedFooterViewId, R.attr.srlFixedHeaderViewId, R.attr.srlFooterHeight, R.attr.srlFooterInsetStart, R.attr.srlFooterMaxDragRate, R.attr.srlFooterTranslationViewId, R.attr.srlFooterTriggerRate, R.attr.srlHeaderHeight, R.attr.srlHeaderInsetStart, R.attr.srlHeaderMaxDragRate, R.attr.srlHeaderTranslationViewId, R.attr.srlHeaderTriggerRate, R.attr.srlPrimaryColor, R.attr.srlReboundDuration});
        if (r113.hasValue(1) == true) goto L6;
        super.setClipToPadding(false);
    L6:
        if (r113.hasValue(0) == true) goto L8;
        super.setClipChildren(false);
    L8:
        this.f381503l = r113.getFloat(5, 0.5f);
        this.f381521x1 = r113.getFloat(32, this.f381521x1);
        this.f381524y1 = r113.getFloat(27, 2.5f);
        this.G1 = r113.getFloat(34, 1.0f);
        this.H1 = r113.getFloat(29, 1.0f);
        this.A = r113.getBoolean(20, this.A);
        this.f381491f = r113.getInt(36, 300);
        this.B = r113.getBoolean(13, this.B);
        this.f381486b1 = r113.getDimensionPixelOffset(30, this.f381486b1);
        this.f381496h1 = r113.getDimensionPixelOffset(25, this.f381496h1);
        this.f381509p1 = r113.getDimensionPixelOffset(31, this.f381509p1);
        this.f381517v1 = r113.getDimensionPixelOffset(26, this.f381517v1);
        this.Q = r113.getBoolean(4, false);
        this.R = r113.getBoolean(3, false);
        this.E = r113.getBoolean(12, true);
        this.F = r113.getBoolean(11, true);
        this.H = r113.getBoolean(18, true);
        this.K = r113.getBoolean(6, this.K);
        this.I = r113.getBoolean(16, true);
        boolean r104 = r113.getBoolean(19, false);
        this.L = r104;
        this.M = r113.getBoolean(21, true);
        this.N = r113.getBoolean(22, true);
        this.O = r113.getBoolean(14, true);
        boolean r114 = r113.getBoolean(9, false);
        this.G = r114;
        this.G = r113.getBoolean(10, r114);
        this.C = r113.getBoolean(8, true);
        this.D = r113.getBoolean(7, true);
        this.f381483J = r113.getBoolean(17, false);
        this.f381507p = r113.getResourceId(24, -1);
        this.f381511q = r113.getResourceId(23, -1);
        this.f381512r = r113.getResourceId(33, -1);
        this.f381513s = r113.getResourceId(28, -1);
        boolean r105 = r113.getBoolean(15, this.P);
        this.P = r105;
        r100.setNestedScrollingEnabled(r105);
        if (this.U == false) goto L11;
    L14:
        boolean r106 = true;
    L15:
        this.U = r106;
        r113.hasValue(12);
        r113.hasValue(11);
        if (r113.hasValue(30) == false) goto L18;
        n6a.a r115 = n6a.a.f518178f;
    L19:
        this.f381493g1 = r115;
        if (r113.hasValue(25) == false) goto L22;
        n6a.a r116 = n6a.a.f518178f;
    L23:
        this.f381502k1 = r116;
        int r117 = r113.getColor(2, 0);
        int r107 = r113.getColor(35, 0);
        if (r107 == 0) goto L28;
        if (r117 == 0) goto L27;
        this.f381526z = new int[]{r107, r117};
    L30:
        if (r104 == true) goto L32;
    L36:
        r113.recycle();
        return;
    L32:
        if (this.U == true) goto L36;
        if (this.B == true) goto L36;
        this.B = true;
        goto L36
    L27:
        this.f381526z = new int[]{r107};
        goto L30
    L28:
        if (r117 == 0) goto L30;
        this.f381526z = new int[]{0, r117};
        goto L30
    L22:
        r116 = this.f381502k1;
        goto L23
    L18:
        r115 = this.f381493g1;
        goto L19
    L11:
        if (r113.hasValue(13) == true) goto L14;
        r106 = false;
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

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101) {
        q(r100);
    }

    public final void h(int r100, boolean r101) {
        int r102 = r100 >> 16;
        int r103 = (r100 << 16) >> 16;
        l6a.b r104 = new l6a.b(this, r102, r101);
        if (r103 <= 0) goto L5;
        this.S1.postDelayed(r104, r103);
        return;
    L5:
        r104.run();
    }

    public final boolean l(boolean r100, m6a.g r101) {
        if (r100 == false) goto L4;
    L10:
        return true;
    L4:
        if (this.L == true) goto L10;
        if (r101 == null) goto L10;
        if (r101.getSpinnerStyle() == n6a.b.f518184e) goto L10;
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r210) {
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
        if (r104.getTag(R.string.srl_component_falsify) == r104) goto L161;
        m6a.f r111 = this.L1;
        if (r111 != null) goto L18;
    L69:
        m6a.e r105 = this.M1;
        if (r105 == null) goto L125;
        if (r105.getView() != r104) goto L125;
        View r106 = this.M1.getView();
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L76;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r107;
    L77:
        int r113 = ViewGroup.getChildMeasureSpec(r110, r112.leftMargin + r112.rightMargin, r107.width);
        int r114 = this.f381496h1;
        n6a.a r115 = this.f381502k1;
        int r116 = r115.f518181a;
        n6a.a r117 = n6a.a.f518175c;
        if (r116 >= 6) goto L98;
        int r118 = r107.height;
        if (r118 <= 0) goto L85;
        r114 = r112.bottomMargin + (r118 + r112.topMargin);
        n6a.a r119 = n6a.a.f518177e;
        if (r115.a(r119) == false) goto L98;
        this.f381496h1 = (r107.height + r112.topMargin) + r112.bottomMargin;
        this.f381502k1 = r119;
        goto L98
    L85:
        if (r118 != (-2)) goto L98;
        if (this.M1.getSpinnerStyle() == n6a.b.f518186g) goto L89;
    L90:
        int r108 = Math.max((View.MeasureSpec.getSize(r210) - r112.bottomMargin) - r112.topMargin, 0);
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(r108, Integer.MIN_VALUE));
        int r120 = r106.getMeasuredHeight();
        if (r120 <= 0) goto L98;
        if (r120 == r108) goto L96;
        n6a.a r109 = this.f381502k1;
        n6a.a r121 = n6a.a.f518176d;
        if (r109.a(r121) == false) goto L96;
        this.f381496h1 = (r120 + r112.topMargin) + r112.bottomMargin;
        this.f381502k1 = r121;
    L96:
        r114 = -1;
        goto L98
    L89:
        if (this.f381502k1.f518182b == false) goto L90;
    L98:
        if (this.M1.getSpinnerStyle() != n6a.b.f518186g) goto L102;
        int r122 = View.MeasureSpec.getSize(r210);
        int r123 = 0;
    L111:
        if (r122 == (-1)) goto L113;
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(Math.max((r122 - r112.bottomMargin) - r112.topMargin, r123), 1073741824));
    L113:
        n6a.a r124 = this.f381502k1;
        boolean r125 = r124.f518182b;
        if (r125 == true) goto L120;
        if (r125 == true) goto L118;
        r124 = n6a.a.f518180h[r124.f518181a + 1];
    L118:
        this.f381502k1 = r124;
        m6a.e r126 = this.M1;
        i r127 = this.T1;
        int r128 = this.f381496h1;
        r126.j(r127, r128, (int) (this.f381524y1 * r128));
    L120:
        if (r100 == false) goto L125;
        if (k(this.B) == false) goto L125;
        r103 = r103 + r106.getMeasuredHeight();
        goto L125
    L102:
        if (this.M1.getSpinnerStyle().f518190c == false) goto L109;
        if (r100 == true) goto L109;
        if (k(this.B) == false) goto L107;
        int r129 = -this.f381485b;
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
        r112 = J2;
    L125:
        o6a.a r130 = this.P1;
        if (r130 == null) goto L161;
        View r131 = r130.f522213a;
        if (r131 != r104) goto L161;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == false) goto L132;
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
    L134:
        if (this.L1 != null) goto L136;
    L140:
        boolean r134 = false;
    L142:
        if (this.M1 != null) goto L144;
    L148:
        boolean r135 = false;
    L149:
        int r136 = ViewGroup.getChildMeasureSpec(r110, ((getPaddingLeft() + getPaddingRight()) + r133.leftMargin) + r133.rightMargin, r132.width);
        int r137 = ((getPaddingTop() + getPaddingBottom()) + r133.topMargin) + r133.bottomMargin;
        if (r100 == false) goto L153;
        if (r134 == false) goto L153;
        int r138 = this.f381486b1;
    L154:
        int r139 = r137 + r138;
        if (r100 == false) goto L158;
        if (r135 == false) goto L158;
        int r140 = this.f381496h1;
    L159:
        r131.measure(r136, ViewGroup.getChildMeasureSpec(r210, r139 + r140, r132.height));
        r103 = r103 + r131.getMeasuredHeight();
    L158:
        r140 = 0;
    L153:
        r138 = 0;
        goto L154
    L144:
        if (k(this.B) == false) goto L148;
        if (l(this.F, this.M1) == false) goto L148;
        r135 = true;
        goto L149
    L136:
        if (k(this.A) == false) goto L140;
        if (l(this.E, this.L1) == false) goto L140;
        r134 = true;
        goto L142
    L132:
        r133 = J2;
        goto L134
    L18:
        if (r111.getView() != r104) goto L69;
        View r141 = this.L1.getView();
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r142;
    L23:
        int r144 = ViewGroup.getChildMeasureSpec(r110, r143.leftMargin + r143.rightMargin, r142.width);
        int r145 = this.f381486b1;
        n6a.a r146 = this.f381493g1;
        int r147 = r146.f518181a;
        n6a.a r148 = n6a.a.f518175c;
        if (r147 >= 6) goto L43;
        int r149 = r142.height;
        if (r149 <= 0) goto L31;
        int r150 = (r149 + r143.bottomMargin) + r143.topMargin;
        n6a.a r151 = n6a.a.f518177e;
        if (r146.a(r151) == false) goto L45;
        this.f381486b1 = (r142.height + r143.bottomMargin) + r143.topMargin;
        this.f381493g1 = r151;
    L45:
        if (this.L1.getSpinnerStyle() != n6a.b.f518186g) goto L49;
        int r152 = View.MeasureSpec.getSize(r210);
        int r153 = 0;
    L58:
        if (r152 == (-1)) goto L60;
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(Math.max((r152 - r143.bottomMargin) - r143.topMargin, r153), 1073741824));
    L60:
        n6a.a r154 = this.f381493g1;
        boolean r155 = r154.f518182b;
        if (r155 == true) goto L65;
        if (r155 == true) goto L64;
        r154 = n6a.a.f518180h[r154.f518181a + 1];
    L64:
        this.f381493g1 = r154;
        m6a.f r156 = this.L1;
        i r157 = this.T1;
        int r158 = this.f381486b1;
        r156.j(r157, r158, (int) (this.f381521x1 * r158));
    L65:
        if (r100 == false) goto L69;
        if (k(this.A) == false) goto L69;
        r103 = r103 + r141.getMeasuredHeight();
        goto L69
    L49:
        if (this.L1.getSpinnerStyle().f518190c == false) goto L56;
        if (r100 == true) goto L56;
        if (k(this.A) == false) goto L54;
        int r159 = this.f381485b;
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
        if (this.L1.getSpinnerStyle() == n6a.b.f518186g) goto L35;
    L36:
        int r160 = Math.max((View.MeasureSpec.getSize(r210) - r143.bottomMargin) - r143.topMargin, 0);
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(r160, Integer.MIN_VALUE));
        int r161 = r141.getMeasuredHeight();
        if (r161 <= 0) goto L43;
        if (r161 == r160) goto L42;
        n6a.a r162 = this.f381493g1;
        n6a.a r163 = n6a.a.f518176d;
        if (r162.a(r163) == false) goto L42;
        this.f381486b1 = (r161 + r143.bottomMargin) + r143.topMargin;
        this.f381493g1 = r163;
    L42:
        r150 = -1;
        goto L45
    L35:
        if (this.f381493g1.f518182b == false) goto L36;
    L43:
        r150 = r145;
        goto L45
    L22:
        r143 = J2;
    L161:
        r102 = r102 + 1;
        goto L9
    L162:
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r110), View.resolveSize(r103, r210));
        this.f381499j = getMeasuredWidth() / 2.0f;
        return;
    L5:
        if (this.H == false) goto L7;
        r100 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r110, View r111, long r112) {
        o6a.a r100 = this.P1;
        if (r100 == null) goto L5;
        View r101 = r100.f522213a;
    L6:
        m6a.f r102 = this.L1;
        if (r102 != null) goto L9;
    L36:
        m6a.e r103 = this.M1;
        if (r103 == null) goto L67;
        if (r103.getView() != r111) goto L67;
        if (k(this.B) == true) goto L43;
    L65:
        return true;
    L43:
        if (this.H == false) goto L45;
    L47:
        if (r101 == null) goto L67;
        int r104 = Math.min((r101.getBottom() - r101.getPaddingBottom()) + this.f381485b, r111.getBottom());
        int r105 = this.f381510p2;
        if (r105 == 0) goto L60;
        Paint r106 = this.Q1;
        if (r106 == null) goto L60;
        r106.setColor(r105);
        if (this.M1.getSpinnerStyle().f518190c == false) goto L56;
        r104 = r111.getTop();
    L58:
        r110.drawRect(0.0f, r104, getWidth(), r111.getBottom(), this.Q1);
        goto L60
    L56:
        if (this.M1.getSpinnerStyle() != n6a.b.f518183d) goto L58;
        r104 = r111.getTop() + this.f381485b;
    L60:
        if (this.D == false) goto L67;
        if (this.M1.getSpinnerStyle() != n6a.b.f518184e) goto L67;
        r110.save();
        r110.clipRect(r111.getLeft(), r104, r111.getRight(), r111.getBottom());
        boolean r113 = super.drawChild(r110, r111, r112);
        r110.restore();
        return r113;
    L45:
        if (isInEditMode() == false) goto L47;
    L67:
        return super.drawChild(r110, r111, r112);
    L9:
        if (r102.getView() != r111) goto L36;
        if (k(this.A) == true) goto L13;
    L35:
        return true;
    L13:
        if (this.H == false) goto L15;
    L17:
        if (r101 == null) goto L36;
        int r107 = Math.max((r101.getTop() + r101.getPaddingTop()) + this.f381485b, r111.getTop());
        int r108 = this.f381497h2;
        if (r108 == 0) goto L30;
        Paint r109 = this.Q1;
        if (r109 == null) goto L30;
        r109.setColor(r108);
        if (this.L1.getSpinnerStyle().f518190c == false) goto L26;
        r107 = r111.getBottom();
    L28:
        r110.drawRect(0.0f, r111.getTop(), getWidth(), r107, this.Q1);
        goto L30
    L26:
        if (this.L1.getSpinnerStyle() != n6a.b.f518183d) goto L28;
        r107 = r111.getBottom() + this.f381485b;
    L30:
        if (this.C == false) goto L36;
        if (this.L1.getSpinnerStyle() != n6a.b.f518184e) goto L36;
        r110.save();
        r110.clipRect(r111.getLeft(), r111.getTop(), r111.getRight(), r107);
        boolean r114 = super.drawChild(r110, r111, r112);
        r110.restore();
        return r114;
    L15:
        if (isInEditMode() == false) goto L17;
    L5:
        r101 = null;
        goto L6
    }

    public final void i(int r100, boolean r101, Boolean r102) {
        int r103 = r100 >> 16;
        int r104 = (r100 << 16) >> 16;
        l6a.a r105 = new l6a.a(this, r103, r102, r101);
        if (r104 <= 0) goto L5;
        this.S1.postDelayed(r105, r104);
        return;
    L5:
        r105.run();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.E2 == false) goto L7;
        if (r102 <= 0.0f) goto L7;
    L12:
        return true;
    L7:
        if (t(-r102) == true) goto L12;
        if (this.P0.dispatchNestedPreFling(r101, r102) == true) goto L12;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.V0.onNestedScrollAccepted(r100, r101, r102);
        this.P0.startNestedScroll(r102 & 2);
        this.f381508p0 = this.f381485b;
        this.H0 = true;
        j(0);
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
        if (this.f381483J == false) goto L14;
        return true;
    L14:
        if (this.A == false) goto L16;
        return true;
    L16:
        if (this.B == false) goto L18;
        return true;
    L5:
        if (isNestedScrollingEnabled() == false) goto L9;
        if ((r102 & 2) == 0) goto L9;
        r103 = true;
        goto L10
    }

    public final ValueAnimator g(int r100, int r101, Interpolator r102, int r103) {
        if (this.f381485b == r100) goto L9;
        ValueAnimator r104 = this.I2;
        if (r104 == null) goto L7;
        r104.cancel();
    L7:
        this.H2 = null;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{this.f381485b, r100});
        this.I2 = r105;
        r105.setDuration(r103);
        this.I2.setInterpolator(r102);
        this.I2.addListener(new d(this));
        this.I2.addUpdateListener(new e(this));
        this.I2.setStartDelay(r101);
        this.I2.start();
        return this.I2;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return this.P0.dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        int r104 = this.f381508p0;
        int r105 = 0;
        if ((r102 * r104) > 0) goto L5;
        if (r102 > 0) goto L11;
    L13:
        this.P0.dispatchNestedPreScroll(r101, r102 - r105, r103, null);
        r103[1] = r103[1] + r105;
        return;
    L11:
        if (this.E2 == false) goto L13;
        int r106 = r104 - r102;
        this.f381508p0 = r106;
        m(r106);
        r105 = r102;
        goto L13
    L5:
        if (Math.abs(r102) <= Math.abs(this.f381508p0)) goto L7;
        int r107 = this.f381508p0;
        this.f381508p0 = 0;
        r105 = r107;
    L8:
        m(this.f381508p0);
        goto L13
    L7:
        this.f381508p0 -= r102;
        r105 = r102;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        int r115 = getPaddingLeft();
        int r116 = getPaddingTop();
        getPaddingBottom();
        int r117 = super.getChildCount();
        int r118 = 0;
    L3:
        if (r118 >= r117) goto L110;
        View r100 = super.getChildAt(r118);
        if (r100.getVisibility() == 8) goto L109;
        if (r100.getTag(R.string.srl_component_falsify) == r100) goto L109;
        o6a.a r101 = this.P1;
        boolean r102 = true;
        if (r101 != null) goto L12;
    L33:
        m6a.f r103 = this.L1;
        if (r103 != null) goto L36;
    L55:
        m6a.e r104 = this.M1;
        if (r104 == null) goto L109;
        if (r104.getView() != r100) goto L109;
        if (isInEditMode() == true) goto L62;
    L66:
        r102 = false;
    L67:
        View r105 = this.M1.getView();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L70;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L71:
        n6a.b r108 = this.M1.getSpinnerStyle();
        int r109 = r107.leftMargin;
        int r119 = (r107.topMargin + getMeasuredHeight()) - this.f381517v1;
        if (this.S == false) goto L89;
        if (this.T == false) goto L89;
        if (this.G == false) goto L89;
        if (this.P1 == null) goto L89;
        if (this.M1.getSpinnerStyle() != n6a.b.f518183d) goto L89;
        if (k(this.B) == false) goto L89;
        View r120 = this.P1.f522213a;
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
        if (r108 != n6a.b.f518186g) goto L91;
        r119 = r107.topMargin - this.f381517v1;
    L108:
        r105.layout(r109, r119, r105.getMeasuredWidth() + r109, r105.getMeasuredHeight() + r119);
        goto L109
    L91:
        if (r102 == false) goto L93;
    L106:
        int r124 = this.f381496h1;
    L107:
        r119 = r119 - r124;
        goto L108
    L93:
        if (r108 == n6a.b.f518185f) goto L106;
        if (r108 == n6a.b.f518184e) goto L106;
        if (r108.f518190c == false) goto L108;
        if (this.f381485b >= 0) goto L108;
        if (k(this.B) == false) goto L104;
        int r125 = -this.f381485b;
    L105:
        r124 = Math.max(r125, 0);
        goto L107
    L104:
        r125 = 0;
        goto L105
    L70:
        r107 = J2;
        goto L71
    L62:
        if (this.H == false) goto L66;
        if (k(this.B) == false) goto L66;
    L36:
        if (r103.getView() != r100) goto L55;
        if (isInEditMode() == true) goto L40;
    L44:
        boolean r126 = false;
    L45:
        View r127 = this.L1.getView();
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L49:
        int r130 = r129.leftMargin;
        int r131 = r129.topMargin + this.f381509p1;
        int r132 = r127.getMeasuredWidth() + r130;
        int r133 = r127.getMeasuredHeight() + r131;
        if (r126 == false) goto L52;
    L54:
        r127.layout(r130, r131, r132, r133);
        goto L55
    L52:
        if (this.L1.getSpinnerStyle() != n6a.b.f518183d) goto L54;
        int r134 = this.f381486b1;
        r131 = r131 - r134;
        r133 = r133 - r134;
        goto L54
    L48:
        r129 = J2;
        goto L49
    L40:
        if (this.H == false) goto L44;
        if (k(this.A) == false) goto L44;
        r126 = true;
        goto L45
    L12:
        if (r101.f522213a != r100) goto L33;
        if (isInEditMode() == true) goto L16;
    L22:
        boolean r135 = false;
    L23:
        View r136 = this.P1.f522213a;
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
        if (l(this.E, this.L1) == false) goto L32;
        int r143 = this.f381486b1;
        r140 = r140 + r143;
        r142 = r142 + r143;
        goto L32
    L26:
        r138 = J2;
        goto L27
    L16:
        if (this.H == false) goto L22;
        if (k(this.A) == false) goto L22;
        if (this.L1 == null) goto L22;
        r135 = true;
    L109:
        r118 = r118 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        boolean r103 = this.P0.dispatchNestedScroll(r101, r102, r110, r111, this.L0);
        int r112 = r111 + this.L0[1];
        if (r112 < 0) goto L5;
    L9:
        if (r112 > 0) goto L11;
    L29:
        if (this.E2 == false) goto L33;
        if (r102 >= 0) goto L34;
        this.E2 = false;
        return;
    L34:
        return;
    L33:
        return;
    L11:
        if (this.B == false) goto L13;
    L14:
        RefreshState r104 = this.f381487b2;
        if (r104 != RefreshState.None) goto L17;
    L18:
        i r105 = this.T1;
        if (r112 <= 0) goto L21;
        RefreshState r106 = RefreshState.PullUpToLoad;
    L22:
        r105.d(r106);
        if (r103 == true) goto L27;
        ViewParent r107 = getParent();
        if ((r107 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r107).requestDisallowInterceptTouchEvent(true);
    L27:
        int r108 = this.f381508p0 - r112;
        this.f381508p0 = r108;
        m(r108);
        goto L29
    L21:
        r106 = RefreshState.PullDownToRefresh;
        goto L22
    L17:
        if (r104.isOpening == false) goto L27;
    L13:
        if (this.f381483J == false) goto L29;
    L5:
        if (this.A == true) goto L14;
        if (this.f381483J == false) goto L9;
        goto L9
    }
}
