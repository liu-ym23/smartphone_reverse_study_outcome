package com.scwang.smartrefresh.layout;

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
import android.widget.TextView;
import android.widget.Toast;
import androidx.camera.video.AudioStats;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;

/* JADX INFO: loaded from: classes34.dex */
public class SmartRefreshLayout extends ViewGroup implements cqa.h, NestedScrollingParent {
    public static final ViewGroup.MarginLayoutParams K2 = null;
    public boolean A;
    public boolean B;
    public final boolean C;
    public final boolean D;
    public boolean E;
    public boolean E2;
    public final boolean F;
    public boolean F2;
    public final boolean G;
    public final float G1;
    public boolean G2;
    public final boolean H;
    public int H0;
    public float H1;
    public MotionEvent H2;
    public boolean I;
    public Runnable I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f405859J;
    public ValueAnimator J2;
    public boolean K;
    public final boolean L;
    public boolean L0;
    public final float L1;
    public final boolean M;
    public cqa.e M1;
    public final boolean N;
    public final boolean O;
    public boolean P;
    public final int[] P0;
    public cqa.d P1;
    public boolean Q;
    public eqa.a Q1;
    public final boolean R;
    public boolean S;
    public Paint S1;
    public boolean T;
    public Handler T1;
    public boolean U;
    public boolean V;
    public final NestedScrollingChildHelper V0;
    public final j V1;
    public gqa.d W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f405861b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final NestedScrollingParentHelper f405862b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public RefreshState f405863b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f405866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f405867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f405868g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f405869g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public RefreshState f405870g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f405871h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public dqa.a f405872h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public long f405873h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f405874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f405875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f405876k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public gqa.b f405877k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f405878k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f405879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public char f405880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f405881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f405882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f405883p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public gqa.c f405884p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public dqa.a f405885p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public int f405886p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f405887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f405888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f405889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f405890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f405891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f405892v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final int f405893v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f405894v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Scroller f405895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final VelocityTracker f405896x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final int f405897x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public boolean f405898x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final hqa.b f405899y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public float f405900y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public boolean f405901y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f405902z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f405903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dqa.b f405904b;

        public LayoutParams(int r100) {
            super(-1, r100);
            this.f405903a = 0;
            this.f405904b = null;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f405903a = 0;
            this.f405904b = null;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_srlBackgroundColor, R.attr.layout_srlSpinnerStyle});
            this.f405903a = r102.getColor(0, 0);
            if (r102.hasValue(1) == false) goto L5;
            dqa.b[] r103 = dqa.b.f469721h;
            dqa.b r104 = dqa.b.f469717d;
            this.f405904b = r103[r102.getInt(1, 0)];
        L5:
            r102.recycle();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f405905a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f405905a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            f405905a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            f405905a[RefreshState.PullUpToLoad.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            f405905a[RefreshState.PullDownCanceled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            f405905a[RefreshState.PullUpCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            f405905a[RefreshState.ReleaseToRefresh.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            f405905a[RefreshState.ReleaseToLoad.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            f405905a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            f405905a[RefreshState.RefreshReleased.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            f405905a[RefreshState.LoadReleased.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            f405905a[RefreshState.Refreshing.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            f405905a[RefreshState.Loading.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            f405905a[RefreshState.RefreshFinish.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            f405905a[RefreshState.LoadFinish.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            f405905a[RefreshState.TwoLevelReleased.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            f405905a[RefreshState.TwoLevelFinish.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            f405905a[RefreshState.TwoLevel.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f405906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405907b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f405907b.setStateDirectLoading(this.f405906a);
        }

        public b(SmartRefreshLayout r100, boolean r101) {
            this.f405907b = r100;
            this.f405906a = r101;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f405908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405909b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f405909b.f405873h2 = System.currentTimeMillis();
            this.f405909b.z(RefreshState.Refreshing);
            SmartRefreshLayout r101 = this.f405909b;
            gqa.d r102 = r101.W;
            if (r102 == null) goto L8;
            if (this.f405908a == false) goto L10;
            r102.d2(r101);
        L10:
            SmartRefreshLayout r103 = this.f405909b;
            cqa.e r104 = r103.M1;
            if (r104 == null) goto L13;
            int r105 = r103.f405869g1;
            r104.f(r103, r105, (int) (r103.f405900y1 * r105));
        L13:
            SmartRefreshLayout r106 = this.f405909b;
            gqa.c r107 = r106.f405884p0;
            if (r107 != null) goto L16;
            return;
        L16:
            if ((r106.M1 instanceof cqa.e) == true) goto L18;
            return;
        L18:
            if (this.f405908a == false) goto L20;
            r107.d2(r106);
        L20:
            this.f405909b.f405884p0.o();
            return;
        L8:
            if (r101.f405884p0 != null) goto L10;
            r101.u(3000, true, Boolean.FALSE);
            goto L10
        }

        public c(SmartRefreshLayout r100, boolean r101) {
            this.f405909b = r100;
            this.f405908a = r101;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405910a;

        public d(SmartRefreshLayout r100) {
            this.f405910a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SmartRefreshLayout r101 = this.f405910a;
            r101.J2 = null;
            if (r101.f405861b != 0) goto L11;
            RefreshState r102 = r101.f405863b2;
            RefreshState r103 = RefreshState.None;
            if (r102 == r103) goto L11;
            if (r102.isOpening == true) goto L11;
            if (r102.isDragging == true) goto L11;
            r101.z(r103);
            return;
        L11:
            RefreshState r104 = r101.f405863b2;
            if (r104 == r101.f405870g2) goto L16;
            r101.setViceState(r104);
            return;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405911a;

        public e(SmartRefreshLayout r100) {
            this.f405911a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f405911a.V1.b(((Integer) r100.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405912a;

        @Override // java.lang.Runnable
        public final void run() {
            SmartRefreshLayout r100 = this.f405912a;     // Catch: Throwable -> L12
            gqa.b r101 = r100.f405877k0;     // Catch: Throwable -> L12
            if (r101 == null) goto L6;
            r101.O0(r100);     // Catch: Throwable -> L12
        L8:
            SmartRefreshLayout r102 = this.f405912a;     // Catch: Throwable -> L12
            gqa.c r103 = r102.f405884p0;     // Catch: Throwable -> L12
            if (r103 == null) goto L15;
            r103.O0(r102);     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L6:
            if (r100.f405884p0 != null) goto L8;
            r100.b(2000, false);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public f(SmartRefreshLayout r100) {
            this.f405912a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f405913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f405914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f405915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405916d;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f405917a;

            public a(g r100) {
                this.f405917a = r100;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                SmartRefreshLayout r101 = this.f405917a.f405916d;
                if (r101.J2 == null) goto L6;
                r101.V1.b(((Integer) r100.getAnimatedValue()).intValue(), true);
                return;
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f405918a;

            public b(g r100) {
                this.f405918a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                SmartRefreshLayout r101 = this.f405918a.f405916d;
                if (r101.J2 == null) goto L9;
                r101.J2 = null;
                RefreshState r102 = r101.f405863b2;
                RefreshState r103 = RefreshState.ReleaseToRefresh;
                if (r102 == r103) goto L7;
                r101.V1.d(r103);
            L7:
                g r104 = this.f405918a;
                r104.f405916d.setStateRefreshing(!r104.f405915c);
                return;
            }
        }

        public final void a() {
            SmartRefreshLayout r100 = this.f405916d;
            if (r100.f405870g2 == RefreshState.Refreshing) goto L5;
            return;
        L5:
            ValueAnimator r101 = r100.J2;
            if (r101 == null) goto L8;
            r101.cancel();
        L8:
            SmartRefreshLayout r102 = this.f405916d;
            r102.f405875j = r102.getMeasuredWidth() / 2.0f;
            this.f405916d.V1.d(RefreshState.PullDownToRefresh);
            SmartRefreshLayout r103 = this.f405916d;
            r103.J2 = ValueAnimator.ofInt(new int[]{r103.f405861b, (int) (r103.f405869g1 * this.f405913a)});
            this.f405916d.J2.setDuration(this.f405914b);
            this.f405916d.J2.setInterpolator(new hqa.b(0));
            this.f405916d.J2.addUpdateListener(new a(this));
            this.f405916d.J2.addListener(new b(this));
            this.f405916d.J2.start();
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

        public g(SmartRefreshLayout r100, float r101, int r102, boolean r103) {
            this.f405916d = r100;
            this.f405913a = r101;
            this.f405914b = r102;
            this.f405915c = r103;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f405919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f405920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f405921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f405922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f405923e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405924f;

        public final void a() {
            SmartRefreshLayout r100 = this.f405924f;
            if (r100.I2 == this) goto L5;
            return;
        L5:
            if (r100.f405863b2.isFinishing == false) goto L7;
            return;
        L7:
            if (Math.abs(r100.f405861b) >= Math.abs(this.f405920b)) goto L9;
            double r101 = this.f405923e;
            int r102 = this.f405919a + 1;
            this.f405919a = r102;
            this.f405923e = (float) (r101 * Math.pow(0.949999988079071d, r102 * 2));
        L13:
            long r103 = AnimationUtils.currentAnimationTimeMillis();
            float r104 = this.f405923e * (((r103 - this.f405921c) * 1.0f) / 1000.0f);
            if (Math.abs(r104) < 1.0f) goto L16;
            this.f405921c = r103;
            float r105 = this.f405922d + r104;
            this.f405922d = r105;
            this.f405924f.y(r105);
            this.f405924f.T1.postDelayed(this, 10);
            return;
        L16:
            SmartRefreshLayout r106 = this.f405924f;
            RefreshState r107 = r106.f405870g2;
            boolean r108 = r107.isDragging;
            if (r108 == true) goto L19;
        L21:
            if (r108 == true) goto L23;
        L25:
            SmartRefreshLayout r109 = this.f405924f;
            r109.I2 = null;
            if (Math.abs(r109.f405861b) < Math.abs(this.f405920b)) goto L32;
            int r110 = Math.min(Math.max((int) (Math.abs(this.f405924f.f405861b - this.f405920b) / hqa.b.f486829b), 30), 100) * 10;
            SmartRefreshLayout r111 = this.f405924f;
            r111.q(this.f405920b, 0, r111.f405899y, r110);
            return;
        L32:
            return;
        L23:
            if (r107.isFooter == false) goto L25;
            r106.V1.d(RefreshState.PullUpCanceled);
            goto L25
        L19:
            if (r107.isHeader == false) goto L21;
            r106.V1.d(RefreshState.PullDownCanceled);
            goto L25
        L9:
            if (this.f405920b == 0) goto L11;
            double r112 = this.f405923e;
            int r113 = this.f405919a + 1;
            this.f405919a = r113;
            this.f405923e = (float) (r112 * Math.pow(0.44999998807907104d, r113 * 2));
            goto L13
        L11:
            double r114 = this.f405923e;
            int r115 = this.f405919a + 1;
            this.f405919a = r115;
            this.f405923e = (float) (r114 * Math.pow(0.8500000238418579d, r115 * 2));
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

        public h(SmartRefreshLayout r100, float r101, int r102) {
            this.f405924f = r100;
            this.f405919a = 0;
            this.f405922d = 0.0f;
            this.f405923e = r101;
            this.f405920b = r102;
            this.f405921c = AnimationUtils.currentAnimationTimeMillis();
            r100.T1.postDelayed(this, 10);
            if (r101 <= 0.0f) goto L5;
            r100.V1.d(RefreshState.PullDownToRefresh);
            return;
        L5:
            r100.V1.d(RefreshState.PullUpToLoad);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f405925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f405926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f405927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f405928d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405929e;

        public final void a() {
            SmartRefreshLayout r100 = this.f405929e;
            if (r100.I2 == this) goto L5;
            return;
        L5:
            if (r100.f405863b2.isFinishing == true) goto L34;
            long r101 = AnimationUtils.currentAnimationTimeMillis();
            long r102 = r101 - this.f405928d;
            float r103 = (float) (((double) this.f405926b) * Math.pow(0.98f, (r101 - this.f405927c) / (1000.0f / 10)));
            this.f405926b = r103;
            float r104 = r103 * ((r102 * 1.0f) / 1000.0f);
            if (Math.abs(r104) <= 1.0f) goto L31;
            this.f405928d = r101;
            int r105 = (int) (this.f405925a + r104);
            this.f405925a = r105;
            SmartRefreshLayout r106 = this.f405929e;
            if ((r106.f405861b * r105) <= 0) goto L11;
            r106.V1.b(r105, true);
            this.f405929e.T1.postDelayed(this, 10);
            return;
        L11:
            r106.I2 = null;
            r106.V1.b(0, true);
            View r107 = this.f405929e.Q1.f473552c;
            int r108 = (int) (-this.f405926b);
            float r109 = hqa.b.f486829b;
            if ((r107 instanceof ScrollView) == false) goto L15;
            ((ScrollView) r107).fling(r108);
        L26:
            SmartRefreshLayout r110 = this.f405929e;
            if (r110.F2 == true) goto L29;
            return;
        L29:
            if (r104 <= 0.0f) goto L37;
            r110.F2 = false;
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
            this.f405929e.I2 = null;
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

        public i(SmartRefreshLayout r100, float r101) {
            this.f405929e = r100;
            this.f405927c = 0;
            this.f405928d = AnimationUtils.currentAnimationTimeMillis();
            this.f405926b = r101;
            this.f405925a = r100.f405861b;
        }
    }

    public class j implements cqa.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f405930a;

        public j(SmartRefreshLayout r100) {
            this.f405930a = r100;
        }

        public final ValueAnimator a(int r100) {
            SmartRefreshLayout r101 = this.f405930a;
            return r101.q(r100, 0, r101.f405899y, r101.f405867f);
        }

        public final void d(RefreshState r100) {
            switch(a.f405905a[r100.ordinal()]) {
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
            this.f405930a.z(RefreshState.TwoLevel);
            return;
        L6:
            this.f405930a.z(RefreshState.TwoLevelFinish);
            return;
        L7:
            this.f405930a.z(RefreshState.TwoLevelReleased);
            return;
        L8:
            SmartRefreshLayout r101 = this.f405930a;
            if (r101.f405863b2 != RefreshState.Loading) goto L104;
            r101.z(RefreshState.LoadFinish);
            return;
        L104:
            return;
        L11:
            SmartRefreshLayout r102 = this.f405930a;
            if (r102.f405863b2 != RefreshState.Refreshing) goto L106;
            r102.z(RefreshState.RefreshFinish);
            return;
        L106:
            return;
        L14:
            this.f405930a.setStateLoading(true);
            return;
        L15:
            this.f405930a.setStateRefreshing(true);
            return;
        L16:
            SmartRefreshLayout r103 = this.f405930a;
            if (r103.f405863b2.isOpening == false) goto L19;
        L21:
            this.f405930a.setViceState(RefreshState.LoadReleased);
            return;
        L19:
            if (r103.w(r103.B) == false) goto L21;
            this.f405930a.z(RefreshState.LoadReleased);
            return;
        L22:
            SmartRefreshLayout r104 = this.f405930a;
            if (r104.f405863b2.isOpening == false) goto L25;
        L27:
            this.f405930a.setViceState(RefreshState.RefreshReleased);
            return;
        L25:
            if (r104.w(r104.A) == false) goto L27;
            this.f405930a.z(RefreshState.RefreshReleased);
            return;
        L28:
            SmartRefreshLayout r105 = this.f405930a;
            if (r105.f405863b2.isOpening == false) goto L31;
        L33:
            this.f405930a.setViceState(RefreshState.ReleaseToTwoLevel);
            return;
        L31:
            if (r105.w(r105.A) == false) goto L33;
            this.f405930a.z(RefreshState.ReleaseToTwoLevel);
            return;
        L34:
            SmartRefreshLayout r106 = this.f405930a;
            if (r106.w(r106.B) == false) goto L47;
            SmartRefreshLayout r107 = this.f405930a;
            RefreshState r108 = r107.f405863b2;
            if (r108.isOpening == true) goto L47;
            if (r108.isFinishing == true) goto L47;
            if (r107.S == true) goto L43;
        L46:
            r107.z(RefreshState.ReleaseToLoad);
            return;
        L43:
            if (r107.G == false) goto L46;
            if (r107.T == false) goto L46;
        L47:
            this.f405930a.setViceState(RefreshState.ReleaseToLoad);
            return;
        L48:
            SmartRefreshLayout r109 = this.f405930a;
            if (r109.f405863b2.isOpening == false) goto L51;
        L53:
            this.f405930a.setViceState(RefreshState.ReleaseToRefresh);
            return;
        L51:
            if (r109.w(r109.A) == false) goto L53;
            this.f405930a.z(RefreshState.ReleaseToRefresh);
            return;
        L54:
            SmartRefreshLayout r110 = this.f405930a;
            if (r110.w(r110.B) == false) goto L65;
            SmartRefreshLayout r111 = this.f405930a;
            if (r111.f405863b2.isOpening == true) goto L65;
            if (r111.S == true) goto L61;
        L64:
            r111.z(RefreshState.PullUpCanceled);
            d(RefreshState.None);
            return;
        L61:
            if (r111.G == false) goto L64;
            if (r111.T == false) goto L64;
        L65:
            this.f405930a.setViceState(RefreshState.PullUpCanceled);
            return;
        L66:
            SmartRefreshLayout r112 = this.f405930a;
            if (r112.f405863b2.isOpening == false) goto L69;
        L71:
            this.f405930a.setViceState(RefreshState.PullDownCanceled);
            return;
        L69:
            if (r112.w(r112.A) == false) goto L71;
            this.f405930a.z(RefreshState.PullDownCanceled);
            d(RefreshState.None);
            return;
        L72:
            SmartRefreshLayout r113 = this.f405930a;
            if (r113.w(r113.B) == false) goto L85;
            SmartRefreshLayout r114 = this.f405930a;
            RefreshState r115 = r114.f405863b2;
            if (r115.isOpening == true) goto L85;
            if (r115.isFinishing == true) goto L85;
            if (r114.S == true) goto L81;
        L84:
            r114.z(RefreshState.PullUpToLoad);
            return;
        L81:
            if (r114.G == false) goto L84;
            if (r114.T == false) goto L84;
        L85:
            this.f405930a.setViceState(RefreshState.PullUpToLoad);
            return;
        L86:
            SmartRefreshLayout r116 = this.f405930a;
            if (r116.f405863b2.isOpening == false) goto L89;
        L91:
            this.f405930a.setViceState(RefreshState.PullDownToRefresh);
            return;
        L89:
            if (r116.w(r116.A) == false) goto L91;
            this.f405930a.z(RefreshState.PullDownToRefresh);
            return;
        L92:
            SmartRefreshLayout r117 = this.f405930a;
            RefreshState r118 = r117.f405863b2;
            RefreshState r119 = RefreshState.None;
            if (r118 == r119) goto L98;
            if (r117.f405861b != 0) goto L98;
            r117.z(r119);
            return;
        L98:
            if (r117.f405861b == 0) goto L129;
            a(0);
            return;
        L129:
            return;
        }

        public final j b(int r110, boolean r111) {
            SmartRefreshLayout r100 = this.f405930a;
            if (r100.f405861b != r110) goto L13;
            cqa.e r101 = r100.M1;
            if (r101 != null) goto L7;
        L8:
            cqa.d r102 = this.f405930a.P1;
            if (r102 != null) goto L11;
        L12:
            return this;
        L11:
            if (r102.a() == true) goto L13;
        L7:
            if (r101.a() == false) goto L8;
        L13:
            SmartRefreshLayout r103 = this.f405930a;
            int r104 = r103.f405861b;
            r103.f405861b = r110;
            if (r111 == false) goto L35;
            RefreshState r105 = r103.f405870g2;
            if (r105.isDragging == true) goto L20;
            if (r105.isOpening == false) goto L35;
        L20:
            if (r110 <= (r103.f405869g1 * r103.H1)) goto L25;
            if (r103.f405863b2 == RefreshState.ReleaseToTwoLevel) goto L35;
            r103.V1.d(RefreshState.ReleaseToRefresh);
            goto L35
        L25:
            if ((-r110) > (r103.f405878k1 * r103.L1)) goto L27;
        L29:
            if (r110 < 0) goto L31;
        L33:
            if (r110 <= 0) goto L35;
            r103.V1.d(RefreshState.PullDownToRefresh);
            goto L35
        L31:
            if (r103.S == true) goto L33;
            r103.V1.d(RefreshState.PullUpToLoad);
            goto L35
        L27:
            if (r103.S == true) goto L29;
            r103.V1.d(RefreshState.ReleaseToLoad);
        L35:
            SmartRefreshLayout r106 = this.f405930a;
            if (r106.Q1 == null) goto L106;
            if (r110 < 0) goto L46;
            cqa.e r107 = r106.M1;
            if (r107 == null) goto L46;
            if (r106.x(r106.E, r107) == false) goto L43;
            int r108 = r110;
        L45:
            boolean r109 = true;
        L47:
            if (r110 > 0) goto L56;
            SmartRefreshLayout r112 = this.f405930a;
            cqa.d r113 = r112.P1;
            if (r113 == null) goto L56;
            if (r112.x(r112.F, r113) == false) goto L53;
            r108 = r110;
        L55:
            r109 = true;
            goto L56
        L53:
            if (r104 <= 0) goto L56;
            r108 = 0;
        L56:
            if (r109 == false) goto L106;
            SmartRefreshLayout r114 = this.f405930a;
            r114.Q1.d(r108, r114.f405888r, r114.f405889s);
            SmartRefreshLayout r115 = this.f405930a;
            if (r115.S == true) goto L60;
        L70:
            SmartRefreshLayout r116 = this.f405930a;
            if (r116.C == false) goto L77;
            cqa.e r117 = r116.M1;
            if (r117 == null) goto L77;
            if (r117.getSpinnerStyle() != dqa.b.f469718e) goto L77;
            boolean r118 = true;
        L78:
            if (r118 == false) goto L80;
        L83:
            boolean r119 = true;
        L84:
            SmartRefreshLayout r120 = this.f405930a;
            if (r120.D == false) goto L91;
            cqa.d r121 = r120.P1;
            if (r121 == null) goto L91;
            if (r121.getSpinnerStyle() != dqa.b.f469718e) goto L91;
            boolean r122 = true;
        L92:
            if (r122 == false) goto L94;
        L97:
            boolean r123 = true;
        L98:
            if (r119 == false) goto L101;
            if (r108 >= 0) goto L104;
            if (r104 <= 0) goto L101;
        L104:
            r103.invalidate();
        L101:
            if (r123 == false) goto L106;
            if (r108 <= 0) goto L104;
            if (r104 >= 0) goto L106;
        L94:
            if (this.f405930a.f405894v2 != 0) goto L97;
            r123 = false;
        L91:
            r122 = false;
            goto L92
        L80:
            if (this.f405930a.f405886p2 != 0) goto L83;
            r119 = false;
        L77:
            r118 = false;
            goto L78
        L60:
            if (r115.T == false) goto L70;
            if (r115.G == false) goto L70;
            cqa.d r124 = r115.P1;
            if ((r124 instanceof cqa.d) == false) goto L70;
            if (r124.getSpinnerStyle() != dqa.b.f469717d) goto L70;
            SmartRefreshLayout r125 = this.f405930a;
            if (r125.w(r125.B) == false) goto L70;
            this.f405930a.P1.getView().setTranslationY(Math.max(0, r108));
            goto L70
        L43:
            if (r104 >= 0) goto L46;
            r108 = 0;
        L46:
            r108 = 0;
            r109 = false;
        L106:
            if (r110 >= 0) goto L109;
            if (r104 > 0) goto L109;
        L153:
            if (r110 <= 0) goto L156;
            if (r104 < 0) goto L156;
        L200:
            return this;
        L156:
            if (this.f405930a.P1 == null) goto L200;
            int r126 = -Math.min(r110, 0);
            SmartRefreshLayout r127 = this.f405930a;
            int r128 = r127.f405878k1;
            int r129 = (int) (r128 * r127.G1);
            float r130 = r126 * 1.0f;
            if (r128 != 0) goto L160;
            int r131 = 1;
        L161:
            float r132 = r130 / r131;
            if (r127.w(r127.B) == false) goto L164;
        L166:
            SmartRefreshLayout r133 = this.f405930a;
            if (r104 != r133.f405861b) goto L169;
        L185:
            if (r111 == true) goto L187;
        L193:
            SmartRefreshLayout r134 = this.f405930a;
            if (r104 == r134.f405861b) goto L200;
            gqa.c r135 = r134.f405884p0;
            if (r135 == null) goto L200;
            if ((r134.P1 instanceof cqa.d) == false) goto L200;
            r135.D0();
            goto L200
        L187:
            if (this.f405930a.P1.a() == false) goto L193;
            int r136 = (int) this.f405930a.f405875j;
            int r137 = r103.getWidth();
            SmartRefreshLayout r138 = this.f405930a;
            float r139 = r138.f405875j;
            if (r137 != 0) goto L191;
            int r140 = 1;
        L192:
            r138.P1.d(r139 / r140, r136, r137);
            goto L193
        L191:
            r140 = r137;
            goto L192
        L169:
            if (r133.P1.getSpinnerStyle() != dqa.b.f469717d) goto L178;
            this.f405930a.P1.getView().setTranslationY(this.f405930a.f405861b);
            SmartRefreshLayout r141 = this.f405930a;
            if (r141.f405894v2 != 0) goto L173;
        L184:
            this.f405930a.P1.b(r111, r132, r126, r128, r129);
            goto L185
        L173:
            if (r141.S1 == null) goto L184;
            if (r141.x(r141.F, r141.P1) == true) goto L184;
            r103.invalidate();
            goto L184
        L178:
            if (this.f405930a.P1.getSpinnerStyle().f469724c == false) goto L184;
            View r142 = this.f405930a.P1.getView();
            ViewGroup.LayoutParams r143 = r142.getLayoutParams();
            if ((r143 instanceof ViewGroup.MarginLayoutParams) == false) goto L182;
            ViewGroup.MarginLayoutParams r144 = (ViewGroup.MarginLayoutParams) r143;
        L183:
            r142.measure(View.MeasureSpec.makeMeasureSpec(r142.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-this.f405930a.f405861b) - r144.bottomMargin) - r144.topMargin, 0), 1073741824));
            int r145 = r144.leftMargin;
            int r146 = (r144.topMargin + r103.getMeasuredHeight()) - this.f405930a.f405897x1;
            r142.layout(r145, r146 - r142.getMeasuredHeight(), r142.getMeasuredWidth() + r145, r146);
            goto L184
        L182:
            r144 = SmartRefreshLayout.K2;
            goto L183
        L164:
            if (this.f405930a.f405863b2 != RefreshState.LoadFinish) goto L193;
            if (r111 == true) goto L193;
        L160:
            r131 = r128;
        L109:
            if (this.f405930a.M1 == null) goto L153;
            int r147 = Math.max(r110, 0);
            SmartRefreshLayout r148 = this.f405930a;
            int r149 = r148.f405869g1;
            int r150 = (int) (r149 * r148.f405900y1);
            float r151 = r147 * 1.0f;
            if (r149 != 0) goto L113;
            int r152 = 1;
        L114:
            float r153 = r151 / r152;
            if (r148.w(r148.A) == false) goto L117;
        L119:
            SmartRefreshLayout r154 = this.f405930a;
            if (r104 != r154.f405861b) goto L122;
        L138:
            if (r111 == true) goto L140;
        L146:
            SmartRefreshLayout r155 = this.f405930a;
            if (r104 == r155.f405861b) goto L153;
            gqa.c r156 = r155.f405884p0;
            if (r156 == null) goto L153;
            if ((r155.M1 instanceof cqa.e) == false) goto L153;
            r156.L();
            goto L153
        L140:
            if (this.f405930a.M1.a() == false) goto L146;
            int r157 = (int) this.f405930a.f405875j;
            int r158 = r103.getWidth();
            SmartRefreshLayout r159 = this.f405930a;
            float r160 = r159.f405875j;
            if (r158 != 0) goto L144;
            int r161 = 1;
        L145:
            r159.M1.d(r160 / r161, r157, r158);
            goto L146
        L144:
            r161 = r158;
            goto L145
        L122:
            if (r154.M1.getSpinnerStyle() != dqa.b.f469717d) goto L131;
            this.f405930a.M1.getView().setTranslationY(this.f405930a.f405861b);
            SmartRefreshLayout r162 = this.f405930a;
            if (r162.f405886p2 != 0) goto L126;
        L137:
            this.f405930a.M1.b(r111, r153, r147, r149, r150);
            goto L138
        L126:
            if (r162.S1 == null) goto L137;
            if (r162.x(r162.E, r162.M1) == true) goto L137;
            r103.invalidate();
            goto L137
        L131:
            if (this.f405930a.M1.getSpinnerStyle().f469724c == false) goto L137;
            View r163 = this.f405930a.M1.getView();
            ViewGroup.LayoutParams r164 = r163.getLayoutParams();
            if ((r164 instanceof ViewGroup.MarginLayoutParams) == false) goto L135;
            ViewGroup.MarginLayoutParams r165 = (ViewGroup.MarginLayoutParams) r164;
        L136:
            r163.measure(View.MeasureSpec.makeMeasureSpec(r163.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f405930a.f405861b - r165.bottomMargin) - r165.topMargin, 0), 1073741824));
            int r166 = r165.leftMargin;
            int r167 = r165.topMargin + this.f405930a.f405893v1;
            r163.layout(r166, r167, r163.getMeasuredWidth() + r166, r163.getMeasuredHeight() + r167);
            goto L137
        L135:
            r165 = SmartRefreshLayout.K2;
            goto L136
        L117:
            if (this.f405930a.f405863b2 != RefreshState.RefreshFinish) goto L146;
            if (r111 == true) goto L146;
        L113:
            r152 = r149;
            goto L114
        }

        public final j c(cqa.f r100, int r101) {
            SmartRefreshLayout r102 = this.f405930a;
            if (r102.S1 != null) goto L7;
            if (r101 == 0) goto L7;
            r102.S1 = new Paint();
        L7:
            if (r100.equals(this.f405930a.M1) == false) goto L10;
            this.f405930a.f405886p2 = r101;
        L12:
            return this;
        L10:
            if (r100.equals(this.f405930a.P1) == false) goto L12;
            this.f405930a.f405894v2 = r101;
            goto L12
        }
    }

    public static void setDefaultRefreshFooterCreator(cqa.a r100) {
    }

    public static void setDefaultRefreshHeaderCreator(cqa.b r100) {
    }

    public static void setDefaultRefreshInitializer(cqa.c r100) {
    }

    @Override // cqa.h
    public final SmartRefreshLayout a() {
        h(true);
        return this;
    }

    @Override // cqa.h
    public final SmartRefreshLayout c() {
        D(false);
        return this;
    }

    @Override // cqa.h
    public ViewGroup getLayout() {
        return this;
    }

    static {
        K2 = new ViewGroup.MarginLayoutParams(-1, -1);
    }

    public final void A() {
        RefreshState r100 = this.f405863b2;
        RefreshState r101 = RefreshState.TwoLevel;
        if (r100 == r101) goto L5;
        RefreshState r102 = RefreshState.Loading;
        if (r100 != r102) goto L22;
    L67:
        int r103 = this.f405861b;
        int r104 = -this.f405878k1;
        if (r103 >= r104) goto L70;
        this.V1.a(r104);
        return;
    L70:
        if (r103 <= 0) goto L94;
        this.V1.a(0);
        return;
    L94:
        return;
    L22:
        if (this.G == true) goto L24;
    L32:
        RefreshState r105 = this.f405863b2;
        RefreshState r106 = RefreshState.Refreshing;
        if (r105 != r106) goto L40;
        int r107 = this.f405861b;
        int r108 = this.f405869g1;
        if (r107 <= r108) goto L37;
        this.V1.a(r108);
        return;
    L37:
        if (r107 >= 0) goto L80;
        this.V1.a(0);
        return;
    L80:
        return;
    L40:
        if (r105 != RefreshState.PullDownToRefresh) goto L43;
        this.V1.d(RefreshState.PullDownCanceled);
        return;
    L43:
        if (r105 != RefreshState.PullUpToLoad) goto L46;
        this.V1.d(RefreshState.PullUpCanceled);
        return;
    L46:
        if (r105 != RefreshState.ReleaseToRefresh) goto L49;
        this.V1.d(r106);
        return;
    L49:
        if (r105 != RefreshState.ReleaseToLoad) goto L52;
        this.V1.d(r102);
        return;
    L52:
        if (r105 != RefreshState.ReleaseToTwoLevel) goto L55;
        this.V1.d(RefreshState.TwoLevelReleased);
        return;
    L55:
        if (r105 != RefreshState.RefreshReleased) goto L60;
        if (this.J2 != null) goto L87;
        this.V1.a(this.f405869g1);
        return;
    L87:
        return;
    L60:
        if (r105 != RefreshState.LoadReleased) goto L65;
        if (this.J2 != null) goto L89;
        this.V1.a(-this.f405878k1);
        return;
    L89:
        return;
    L65:
        if (this.f405861b == 0) goto L91;
        this.V1.a(0);
        return;
    L91:
        return;
    L24:
        if (this.S == false) goto L32;
        if (this.T == false) goto L32;
        if (this.f405861b >= 0) goto L32;
        if (w(this.B) == false) goto L32;
    L5:
        if (this.f405892v <= (-1000)) goto L12;
        if (this.f405861b <= (getMeasuredHeight() / 2)) goto L12;
        ValueAnimator r109 = this.V1.a(getMeasuredHeight());
        if (r109 == null) goto L73;
        r109.setDuration(this.f405866e);
        return;
    L73:
        return;
    L12:
        if (this.f405881n == false) goto L75;
        j r110 = this.V1;
        SmartRefreshLayout r111 = r110.f405930a;
        if (r111.f405863b2 != r101) goto L76;
        r111.V1.d(RefreshState.TwoLevelFinish);
        if (r110.f405930a.f405861b != 0) goto L18;
        r110.b(0, false);
        r110.f405930a.z(RefreshState.None);
        return;
    L18:
        r110.a(0).setDuration(r110.f405930a.f405866e);
        return;
    L76:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f405895w.getCurrY();
        if (this.f405895w.computeScrollOffset() == false) goto L62;
        int r100 = this.f405895w.getFinalY();
        if (r100 < 0) goto L7;
    L12:
        if (r100 > 0) goto L14;
    L60:
        this.G2 = true;
        invalidate();
        return;
    L14:
        if (this.B == true) goto L18;
        if (this.f405859J == false) goto L60;
    L18:
        if (this.Q1.a() == false) goto L60;
    L20:
        if (this.G2 == false) goto L59;
        if (r100 <= 0) goto L23;
        float r101 = -this.f405895w.getCurrVelocity();
    L25:
        if (this.J2 != null) goto L59;
        if (r101 <= 0.0f) goto L34;
        RefreshState r102 = this.f405863b2;
        if (r102 != RefreshState.Refreshing) goto L31;
    L32:
        this.I2 = new h(this, r101, this.f405869g1);
        goto L59
    L31:
        if (r102 == RefreshState.TwoLevel) goto L32;
    L34:
        if (r101 >= 0.0f) goto L55;
        if (this.f405863b2 != RefreshState.Loading) goto L38;
    L53:
        this.I2 = new h(this, r101, -this.f405878k1);
        goto L59
    L38:
        if (this.G == false) goto L46;
        if (this.S == false) goto L46;
        if (this.T == false) goto L46;
        if (w(this.B) == true) goto L53;
    L46:
        if (this.K == false) goto L55;
        if (this.S == true) goto L55;
        if (w(this.B) == false) goto L55;
        if (this.f405863b2 != RefreshState.Refreshing) goto L53;
    L55:
        if (this.f405861b != 0) goto L59;
        if (this.I == false) goto L59;
        this.I2 = new h(this, r101, 0);
        goto L59
    L23:
        r101 = this.f405895w.getCurrVelocity();
    L59:
        this.f405895w.forceFinished(true);
        return;
    L7:
        if (this.A == true) goto L11;
        if (this.f405859J == false) goto L12;
    L11:
        if (this.Q1.b() == true) goto L20;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f405862b1.getNestedScrollAxes();
    }

    public cqa.d getRefreshFooter() {
        cqa.d r100 = this.P1;
        if ((r100 instanceof cqa.d) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // cqa.h
    public cqa.e getRefreshHeader() {
        cqa.e r100 = this.M1;
        if ((r100 instanceof cqa.e) == true) goto L7;
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
        if (this.f405859J == false) goto L7;
    L10:
        return true;
    L7:
        if (this.A == true) goto L10;
        if (this.B == false) goto L11;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = true;
        this.E2 = true;
        if (isInEditMode() == false) goto L5;
    L37:
        int[] r101 = this.f405902z;
        if (r101 == null) goto L45;
        cqa.e r102 = this.M1;
        if (r102 == null) goto L42;
        r102.setPrimaryColors(r101);
    L42:
        cqa.d r103 = this.P1;
        if (r103 == null) goto L45;
        r103.setPrimaryColors(this.f405902z);
    L45:
        eqa.a r104 = this.Q1;
        if (r104 == null) goto L48;
        super.bringChildToFront(r104.f473550a);
    L48:
        cqa.e r105 = this.M1;
        if (r105 != null) goto L51;
    L53:
        cqa.d r106 = this.P1;
        if (r106 != null) goto L56;
        return;
    L56:
        if (r106.getSpinnerStyle().f469723b == false) goto L64;
        super.bringChildToFront(this.P1.getView());
        return;
    L64:
        return;
    L51:
        if (r105.getSpinnerStyle().f469723b == false) goto L53;
        super.bringChildToFront(this.M1.getView());
        goto L53
    L5:
        if (this.M1 != null) goto L8;
        G(new BezierRadarHeader(getContext()), -2);
    L8:
        if (this.P1 != null) goto L11;
        boolean r107 = this.B;
        F(new BallPulseFooter(getContext()), -2);
        this.B = r107;
    L18:
        if (this.Q1 != null) goto L32;
        int r108 = getChildCount();
        int r109 = 0;
    L20:
        if (r109 >= r108) goto L32;
        View r110 = getChildAt(r109);
        cqa.e r111 = this.M1;
        if (r111 != null) goto L24;
    L25:
        cqa.d r112 = this.P1;
        if (r112 != null) goto L28;
    L29:
        this.Q1 = new eqa.a(r110);
    L30:
        r109 = r109 + 1;
        goto L20
    L28:
        if (r110 == r112.getView()) goto L30;
    L24:
        if (r110 == r111.getView()) goto L30;
    L32:
        if (this.Q1 != null) goto L34;
        int r113 = hqa.b.c(20.0f);
        TextView r114 = new TextView(getContext());
        r114.setTextColor(-39424);
        r114.setGravity(17);
        r114.setTextSize(20.0f);
        r114.setText(R.string.srl_content_empty);
        super.addView(r114, 0, new LayoutParams(-1));
        eqa.a r115 = new eqa.a(r114);
        this.Q1 = r115;
        r115.f473550a.setPadding(r113, r113, r113, r113);
    L34:
        View r116 = findViewById(this.f405883p);
        View r117 = findViewById(this.f405887q);
        eqa.a r118 = this.Q1;
        eqa.d r119 = r118.f473558i;
        r119.f473560b = null;
        r119.f473561c = this.O;
        r118.f(this.V1, r116, r117);
        if (this.f405861b == 0) goto L37;
        z(RefreshState.None);
        eqa.a r120 = this.Q1;
        this.f405861b = 0;
        r120.d(0, this.f405888r, this.f405889s);
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
        this.E2 = false;
        this.V1.b(0, true);
        z(RefreshState.None);
        Handler r100 = this.T1;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.U = true;
        this.I2 = null;
        ValueAnimator r101 = this.J2;
        if (r101 == null) goto L8;
        r101.removeAllListeners();
        this.J2.removeAllUpdateListeners();
        this.J2.cancel();
        this.J2 = null;
    L8:
        this.F2 = false;
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
        if (hqa.b.d(r105) == false) goto L13;
        if (r103 < 2) goto L11;
        if (r101 != 1) goto L13;
    L11:
        r102 = r101;
        r103 = 2;
    L19:
        r101 = r101 + 1;
    L13:
        if ((r105 instanceof cqa.f) == true) goto L19;
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
        this.Q1 = new eqa.a(super.getChildAt(r102));
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
        if (this.M1 != null) goto L41;
        if ((r108 instanceof cqa.e) == true) goto L58;
    L41:
        if (r107 == r104) goto L46;
        if (r104 != (-1)) goto L62;
        if ((r108 instanceof cqa.d) == true) goto L46;
    L62:
        r107 = r107 + 1;
    L46:
        if (this.B == false) goto L48;
    L51:
        boolean r109 = true;
    L52:
        this.B = r109;
        if ((r108 instanceof cqa.d) == false) goto L55;
        cqa.d r110 = (cqa.d) r108;
    L56:
        this.P1 = r110;
        goto L62
    L55:
        r110 = new eqa.b(r108);
        goto L56
    L48:
        if (this.U == false) goto L51;
        r109 = false;
    L58:
        if ((r108 instanceof cqa.e) == false) goto L60;
        cqa.e r111 = (cqa.e) r108;
    L61:
        this.M1 = r111;
        goto L62
    L60:
        r111 = new eqa.c(r108);
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

    public final void s() {
        b(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405873h2))), 300) << 16, false);
    }

    public final void t() {
        b(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405873h2))), 300) << 16, true);
    }

    public RefreshState getState() {
        return this.f405863b2;
    }

    public SmartRefreshLayout(Context r100) {
        this(r100, null);
    }

    public final void B(float r100) {
        int r101 = hqa.b.c(r100);
        if (r101 != this.f405869g1) goto L5;
        return;
    L5:
        dqa.a r102 = this.f405872h1;
        dqa.a r103 = dqa.a.f469713h;
        if (r102.a(r103) == false) goto L28;
        this.f405869g1 = r101;
        cqa.e r104 = this.M1;
        if (r104 != null) goto L10;
    L26:
        this.f405872h1 = dqa.a.f469712g;
        return;
    L10:
        if (this.E2 == false) goto L26;
        if (this.f405872h1.f469716b == false) goto L26;
        dqa.b r105 = r104.getSpinnerStyle();
        if (r105 != dqa.b.f469720g) goto L16;
    L25:
        this.f405872h1 = r103;
        cqa.e r106 = this.M1;
        j r107 = this.V1;
        int r108 = this.f405869g1;
        r106.g(r107, r108, (int) (this.f405900y1 * r108));
        return;
    L16:
        if (r105.f469724c == true) goto L25;
        View r109 = this.M1.getView();
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
    L21:
        int r112 = 0;
        r109.measure(View.MeasureSpec.makeMeasureSpec(r109.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f405869g1 - r111.bottomMargin) - r111.topMargin, 0), 1073741824));
        int r113 = r111.leftMargin;
        int r114 = r111.topMargin + this.f405893v1;
        if (r105 != dqa.b.f469717d) goto L24;
        r112 = this.f405869g1;
    L24:
        int r115 = r114 - r112;
        r109.layout(r113, r115, r109.getMeasuredWidth() + r113, r109.getMeasuredHeight() + r115);
        goto L25
    L20:
        r111 = K2;
        goto L21
    }

    public final SmartRefreshLayout C(float r100) {
        this.f405900y1 = r100;
        cqa.e r101 = this.M1;
        if (r101 != null) goto L5;
    L7:
        this.f405872h1 = this.f405872h1.b();
    L8:
        return this;
    L5:
        if (this.E2 == false) goto L7;
        j r102 = this.V1;
        int r103 = this.f405869g1;
        r101.g(r102, r103, (int) (r100 * r103));
        goto L8
    }

    public final void D(boolean r100) {
        RefreshState r101 = this.f405863b2;
        if (r101 != RefreshState.Refreshing) goto L7;
        if (r100 == false) goto L7;
        u(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405873h2))), 300) << 16, true, Boolean.TRUE);
        return;
    L7:
        if (r101 != RefreshState.Loading) goto L11;
        if (r100 == false) goto L11;
        t();
        return;
    L11:
        if (this.S == r100) goto L33;
        this.S = r100;
        cqa.d r102 = this.P1;
        if ((r102 instanceof cqa.d) == true) goto L15;
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
        if (this.f405861b > 0) goto L23;
        return;
    L23:
        if (this.P1.getSpinnerStyle() == dqa.b.f469717d) goto L25;
        return;
    L25:
        if (w(this.B) == true) goto L27;
        return;
    L27:
        if (x(this.A, this.M1) == false) goto L40;
        this.P1.getView().setTranslationY(this.f405861b);
        return;
    L40:
        return;
    L29:
        this.T = false;
        new RuntimeException("Footer:" + this.P1 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
        return;
    }

    public final void E(View r100) {
        eqa.a r101 = this.Q1;
        if (r101 == null) goto L5;
        super.removeView(r101.f473550a);
    L5:
        super.addView(r100, getChildCount(), new LayoutParams(-1));
        this.Q1 = new eqa.a(r100);
        if (this.E2 == false) goto L8;
        View r102 = findViewById(this.f405883p);
        View r103 = findViewById(this.f405887q);
        eqa.a r104 = this.Q1;
        eqa.d r105 = r104.f473558i;
        r105.f473560b = null;
        r105.f473561c = this.O;
        r104.f(this.V1, r102, r103);
    L8:
        cqa.e r106 = this.M1;
        if (r106 != null) goto L11;
    L13:
        cqa.d r107 = this.P1;
        if (r107 != null) goto L16;
        return;
    L16:
        if (r107.getSpinnerStyle().f469723b == false) goto L20;
        super.bringChildToFront(this.P1.getView());
        return;
    L20:
        return;
    L11:
        if (r106.getSpinnerStyle().f469723b == false) goto L13;
        super.bringChildToFront(this.M1.getView());
        goto L13
    }

    public final boolean H(float r110) {
        if (r110 != 0.0f) goto L6;
        r110 = this.f405892v;
    L6:
        if (Build.VERSION.SDK_INT > 27) goto L8;
    L14:
        int r100 = 0;
        if (Math.abs(r110) <= this.f405890t) goto L107;
        int r101 = this.f405861b;
        if ((r101 * r110) >= 0.0f) goto L80;
        RefreshState r102 = this.f405863b2;
        RefreshState r103 = RefreshState.Refreshing;
        if (r102 != r103) goto L21;
    L29:
        i r104 = new i(this, r110);
        RefreshState r111 = this.f405863b2;
        if (r111.isFinishing == false) goto L33;
    L74:
        r104 = null;
    L77:
        this.I2 = r104;
        return true;
    L33:
        if (this.f405861b != 0) goto L35;
    L76:
        r104.f405927c = AnimationUtils.currentAnimationTimeMillis();
        r104.f405929e.T1.postDelayed(r104, 10);
        goto L77
    L35:
        if (r111.isOpening == true) goto L45;
        if (this.S == true) goto L39;
    L60:
        int r112 = this.f405861b;
        float r105 = r104.f405926b;
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
        SmartRefreshLayout r113 = r104.f405929e;
        RefreshState r108 = r113.f405863b2;
        if (r108.isOpening == false) goto L74;
        RefreshState r109 = RefreshState.Refreshing;
        if (r108 == r109) goto L70;
    L71:
        if (r108 == r109) goto L76;
        if (r106 >= (-r113.f405878k1)) goto L76;
    L70:
        if (r106 > r113.f405869g1) goto L74;
    L39:
        if (this.G == false) goto L60;
        if (this.T == false) goto L60;
        if (w(this.B) == false) goto L60;
    L45:
        if (this.f405863b2 == RefreshState.Loading) goto L55;
        if (this.S == false) goto L57;
        if (this.G == false) goto L57;
        if (this.T == false) goto L57;
        if (w(this.B) == true) goto L55;
    L57:
        if (this.f405863b2 != r103) goto L76;
        if (this.f405861b <= this.f405869g1) goto L76;
    L55:
        if (this.f405861b < (-this.f405878k1)) goto L60;
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
        this.G2 = false;
        this.f405895w.fling(0, 0, 0, (int) (-r110), 0, 0, -2147483647, Integer.MAX_VALUE);
        this.f405895w.computeScrollOffset();
        invalidate();
        goto L107
    L86:
        if (this.f405859J == true) goto L106;
    L88:
        if (this.f405863b2 != RefreshState.Loading) goto L91;
        if (r101 >= 0) goto L106;
    L91:
        if (this.K == false) goto L95;
        if (w(this.B) == true) goto L106;
    L95:
        if (r110 <= 0.0f) goto L107;
        if (this.I == false) goto L101;
        if (this.A == true) goto L106;
    L101:
        if (this.f405859J == true) goto L106;
        if (this.f405863b2 != RefreshState.Refreshing) goto L107;
        if (this.f405861b <= 0) goto L106;
    L107:
        return false;
    L8:
        if (this.Q1 == null) goto L14;
        getScaleY();
        View r114 = this.Q1.f473550a;
        if (getScaleY() != (-1.0f)) goto L14;
        if (r114.getScaleY() != (-1.0f)) goto L14;
        r110 = -r110;
        goto L14
    }

    @Override // cqa.h
    public final SmartRefreshLayout d(gqa.d r100) {
        this.W = r100;
        return this;
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
        this.f405875j = r107;
        this.f405876k = r108;
        if (this.L0 == false) goto L53;
        int r109 = this.H0;
        boolean r113 = super.dispatchTouchEvent(r210);
        if (r100 == 2) goto L28;
    L51:
        return r113;
    L28:
        if (r109 != this.H0) goto L51;
        int r114 = (int) this.f405875j;
        int r115 = getWidth();
        float r116 = this.f405875j;
        if (r115 == 0) goto L33;
        r111 = r115;
    L33:
        float r117 = r116 / r111;
        if (w(this.A) == false) goto L43;
        if (this.f405861b <= 0) goto L43;
        cqa.e r118 = this.M1;
        if (r118 == null) goto L43;
        if (r118.a() == false) goto L43;
        this.M1.d(r117, r114, r115);
    L43:
        if (w(this.B) == false) goto L51;
        if (this.f405861b >= 0) goto L51;
        cqa.d r119 = this.P1;
        if (r119 == null) goto L51;
        if (r119.a() == false) goto L51;
        this.P1.d(r117, r114, r115);
        goto L51
    L53:
        if (isEnabled() == false) goto L249;
        if (this.A == true) goto L61;
        if (this.B == true) goto L61;
        if (this.f405859J == false) goto L249;
    L61:
        if (this.f405898x2 == false) goto L69;
        RefreshState r120 = this.f405863b2;
        if (r120.isOpening == true) goto L67;
        if (r120.isFinishing == false) goto L69;
    L67:
        if (r120.isHeader == true) goto L249;
    L69:
        if (this.f405901y2 == false) goto L78;
        RefreshState r121 = this.f405863b2;
        if (r121.isOpening == true) goto L75;
        if (r121.isFinishing == false) goto L78;
    L75:
        if (r121.isFooter == true) goto L249;
    L78:
        if (v(r100) == true) goto L247;
        RefreshState r122 = this.f405863b2;
        if (r122.isFinishing == true) goto L247;
        RefreshState r123 = RefreshState.Loading;
        if (r122 != r123) goto L86;
        if (this.R == true) goto L247;
    L86:
        if (r122 != RefreshState.Refreshing) goto L91;
        if (this.Q == true) goto L247;
    L91:
        if (r100 == 0) goto L231;
        if (r100 != 1) goto L94;
        this.f405896x.addMovement(r210);
        this.f405896x.computeCurrentVelocity(1000, this.f405891u);
        this.f405892v = (int) this.f405896x.getYVelocity();
        H(0.0f);
    L222:
        this.f405896x.clear();
        this.f405880m = 'n';
        MotionEvent r124 = this.H2;
        if (r124 == null) goto L225;
        r124.recycle();
        this.H2 = null;
        long r125 = r210.getEventTime();
        MotionEvent r126 = MotionEvent.obtain(r125, r125, r100, this.f405871h, r108, 0);
        super.dispatchTouchEvent(r126);
        r126.recycle();
    L225:
        A();
        if (this.f405881n == false) goto L230;
        this.f405881n = false;
        return true;
    L230:
        return super.dispatchTouchEvent(r210);
    L94:
        if (r100 == 2) goto L97;
        if (r100 == 3) goto L222;
    L97:
        float r127 = r107 - this.f405871h;
        float r128 = r108 - this.f405874i;
        this.f405896x.addMovement(r210);
        if (this.f405881n == true) goto L160;
        char r129 = this.f405880m;
        if (r129 == 'h') goto L160;
        if (this.Q1 == null) goto L160;
        if (r129 != 'v') goto L106;
    L117:
        this.f405880m = 'v';
        if (r128 <= 0.0f) goto L129;
        if (this.f405861b >= 0) goto L122;
    L127:
        this.f405881n = true;
        this.f405874i = r108 - this.f405860a;
    L144:
        if (this.f405881n == false) goto L160;
        r128 = r108 - this.f405874i;
        if (this.f405882o == false) goto L148;
        r210.setAction(3);
        super.dispatchTouchEvent(r210);
    L148:
        j r130 = this.V1;
        int r131 = this.f405861b;
        if (r131 > 0) goto L155;
        if (r131 == 0) goto L152;
    L154:
        RefreshState r132 = RefreshState.PullUpToLoad;
    L156:
        r130.d(r132);
        ViewParent r133 = getParent();
        if ((r133 instanceof ViewGroup) == false) goto L160;
        ((ViewGroup) r133).requestDisallowInterceptTouchEvent(true);
        goto L160
    L152:
        if (r128 <= 0.0f) goto L154;
    L155:
        r132 = RefreshState.PullDownToRefresh;
        goto L156
    L122:
        if (this.f405859J == true) goto L126;
        if (this.A == false) goto L129;
    L126:
        if (this.Q1.b() == true) goto L127;
    L129:
        if (r128 >= 0.0f) goto L144;
        if (this.f405861b <= 0) goto L133;
    L142:
        this.f405881n = true;
        this.f405874i = this.f405860a + r108;
        goto L144
    L133:
        if (this.f405859J == true) goto L137;
        if (this.B == false) goto L144;
    L137:
        if (this.f405863b2 != r123) goto L141;
        if (this.F2 == true) goto L142;
    L141:
        if (this.Q1.a() == false) goto L144;
    L106:
        if (Math.abs(r128) < this.f405860a) goto L111;
        if (Math.abs(r127) < Math.abs(r128)) goto L117;
    L111:
        if (Math.abs(r127) < this.f405860a) goto L160;
        if (Math.abs(r127) <= Math.abs(r128)) goto L160;
        if (this.f405880m == 'v') goto L160;
        this.f405880m = 'h';
    L160:
        if (this.f405881n == false) goto L215;
        int r134 = ((int) r128) + this.f405865d;
        RefreshState r135 = this.f405870g2;
        if (r135.isHeader == false) goto L167;
        if (r134 >= 0) goto L165;
    L171:
        this.f405864c = r134;
        long r136 = r210.getEventTime();
        if (this.H2 != null) goto L174;
        MotionEvent r137 = MotionEvent.obtain(r136, r136, 0, this.f405871h + r127, this.f405874i, 0);
        this.H2 = r137;
        super.dispatchTouchEvent(r137);
    L174:
        MotionEvent r138 = MotionEvent.obtain(r136, r136, 2, this.f405871h + r127, this.f405874i + r134, 0);
        super.dispatchTouchEvent(r138);
        if (this.F2 == true) goto L177;
    L181:
        if (r134 > 0) goto L183;
    L189:
        if (r134 < 0) goto L191;
    L197:
        r110 = r134;
    L198:
        RefreshState r139 = this.f405870g2;
        if (r139.isHeader == false) goto L202;
        if (r110 >= 0) goto L202;
    L205:
        if (this.f405861b == 0) goto L207;
        y(0.0f);
    L207:
        return true;
    L202:
        if (r139.isFooter == false) goto L209;
        if (r110 > 0) goto L205;
    L209:
        if (this.H2 == null) goto L211;
        this.H2 = null;
        r138.setAction(3);
        super.dispatchTouchEvent(r138);
    L211:
        r138.recycle();
        r134 = r110;
    L212:
        y(r134);
        return true;
    L191:
        if (this.f405859J == true) goto L195;
        if (this.B == false) goto L197;
    L195:
        if (this.Q1.a() == false) goto L197;
        this.f405876k = r108;
        this.f405874i = r108;
        this.f405865d = 0;
        this.V1.d(RefreshState.PullUpToLoad);
        goto L198
    L183:
        if (this.f405859J == true) goto L187;
        if (this.A == false) goto L189;
    L187:
        if (this.Q1.b() == false) goto L189;
        this.f405876k = r108;
        this.f405874i = r108;
        this.f405865d = 0;
        this.V1.d(RefreshState.PullDownToRefresh);
        goto L198
    L177:
        if (r128 <= this.f405860a) goto L181;
        if (this.f405861b >= 0) goto L181;
        this.F2 = false;
        goto L181
    L165:
        if (this.f405864c < 0) goto L171;
    L167:
        if (r135.isFooter == false) goto L212;
        if (r134 > 0) goto L171;
        if (this.f405864c <= 0) goto L212;
    L215:
        if (this.F2 == false) goto L230;
        if (r128 <= this.f405860a) goto L230;
        if (this.f405861b >= 0) goto L230;
        this.F2 = false;
        goto L230
    L231:
        this.f405892v = 0;
        this.f405896x.addMovement(r210);
        this.f405895w.forceFinished(true);
        this.f405871h = r107;
        this.f405874i = r108;
        this.f405864c = 0;
        this.f405865d = this.f405861b;
        this.f405881n = false;
        this.f405882o = super.dispatchTouchEvent(r210);
        if (this.f405863b2 == RefreshState.TwoLevel) goto L234;
    L237:
        eqa.a r140 = this.Q1;
        if (r140 == null) goto L246;
        PointF r141 = new PointF(r210.getX(), r210.getY());
        r141.offset(-r140.f473550a.getLeft(), -r140.f473550a.getTop());
        View r142 = r140.f473552c;
        View r143 = r140.f473550a;
        if (r142 == r143) goto L243;
        r140.f473552c = eqa.a.c(r143, r141, r142);
    L243:
        if (r140.f473552c != r140.f473550a) goto L245;
        r140.f473558i.f473559a = null;
        goto L246
    L245:
        r140.f473558i.f473559a = r141;
    L246:
        return true;
    L234:
        if (this.f405874i >= ((getMeasuredHeight() * 5) / 6)) goto L237;
        this.f405880m = 'h';
        return this.f405882o;
    L247:
        return false;
    L249:
        return super.dispatchTouchEvent(r210);
    L21:
        if (this.f405881n == false) goto L23;
        this.f405874i += r108 - this.f405876k;
        goto L23
    L8:
        r102 = -1;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    @Override // cqa.h
    public final SmartRefreshLayout e(cqa.d r100) {
        F(r100, -2);
        return this;
    }

    @Override // cqa.h
    public final SmartRefreshLayout f(int r100) {
        b(r100, false);
        return this;
    }

    @Override // cqa.h
    public final SmartRefreshLayout g(boolean r100) {
        this.U = true;
        this.B = r100;
        return this;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // cqa.h
    public final SmartRefreshLayout h(boolean r100) {
        if (r100 == false) goto L6;
        u(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f405873h2))), 300) << 16, true, Boolean.FALSE);
        return this;
    L6:
        u(0, false, null);
        return this;
    }

    @Override // cqa.h
    public final SmartRefreshLayout i(gqa.b r100) {
        this.f405877k0 = r100;
        if (this.B == false) goto L5;
    L9:
        boolean r101 = true;
    L10:
        this.B = r101;
        return this;
    L5:
        if (this.U == true) goto L8;
        if (r100 != null) goto L9;
    L8:
        r101 = false;
        goto L10
    }

    @Override // cqa.h
    public final SmartRefreshLayout j(boolean r100) {
        this.A = r100;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f405862b1.onStopNestedScroll(r100);
        this.L0 = false;
        this.H0 = 0;
        A();
        this.V0.stopNestedScroll();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r100) {
        this.P = r100;
        this.V0.setNestedScrollingEnabled(r100);
    }

    public void setStateDirectLoading(boolean r100) {
        RefreshState r101 = this.f405863b2;
        RefreshState r102 = RefreshState.Loading;
        if (r101 == r102) goto L22;
        this.f405873h2 = System.currentTimeMillis();
        this.F2 = true;
        z(r102);
        gqa.b r103 = this.f405877k0;
        if (r103 == null) goto L9;
        if (r100 == false) goto L11;
        r103.O0(this);
    L11:
        cqa.d r104 = this.P1;
        if (r104 == null) goto L14;
        int r105 = this.f405878k1;
        r104.f(this, r105, (int) (this.G1 * r105));
    L14:
        gqa.c r106 = this.f405884p0;
        if (r106 != null) goto L17;
        return;
    L17:
        if ((this.P1 instanceof cqa.d) == false) goto L24;
        if (r100 == false) goto L20;
        r106.O0(this);
    L20:
        this.f405884p0.s();
        return;
    L24:
        return;
    L9:
        if (this.f405884p0 != null) goto L11;
        b(2000, false);
        goto L11
    }

    public void setStateLoading(boolean r100) {
        b r101 = new b(this, r100);
        z(RefreshState.LoadReleased);
        ValueAnimator r102 = this.V1.a(-this.f405878k1);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        cqa.d r103 = this.P1;
        if (r103 == null) goto L8;
        int r104 = this.f405878k1;
        r103.i(this, r104, (int) (this.G1 * r104));
    L8:
        gqa.c r105 = this.f405884p0;
        if (r105 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
        r101.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.P1 instanceof cqa.d) == false) goto L13;
        r105.w();
        goto L13
    }

    public void setStateRefreshing(boolean r100) {
        c r101 = new c(this, r100);
        z(RefreshState.RefreshReleased);
        ValueAnimator r102 = this.V1.a(this.f405869g1);
        if (r102 == null) goto L5;
        r102.addListener(r101);
    L5:
        cqa.e r103 = this.M1;
        if (r103 == null) goto L8;
        int r104 = this.f405869g1;
        r103.i(this, r104, (int) (this.f405900y1 * r104));
    L8:
        gqa.c r105 = this.f405884p0;
        if (r105 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
        r101.onAnimationEnd(null);
        return;
    L16:
        return;
    L11:
        if ((this.M1 instanceof cqa.e) == false) goto L13;
        r105.p();
        goto L13
    }

    public void setViceState(RefreshState r100) {
        RefreshState r101 = this.f405863b2;
        if (r101.isDragging == false) goto L8;
        if (r101.isHeader == r100.isHeader) goto L8;
        z(RefreshState.None);
    L8:
        if (this.f405870g2 == r100) goto L11;
        this.f405870g2 = r100;
        return;
    }

    public final boolean v(int r100) {
        if (r100 != 0) goto L21;
        if (this.J2 == null) goto L19;
        RefreshState r101 = this.f405863b2;
        if (r101.isFinishing == false) goto L9;
    L18:
        return true;
    L9:
        if (r101 == RefreshState.TwoLevelReleased) goto L18;
        if (r101 != RefreshState.PullDownCanceled) goto L15;
        this.V1.d(RefreshState.PullDownToRefresh);
    L17:
        this.J2.cancel();
        this.J2 = null;
        goto L19
    L15:
        if (r101 != RefreshState.PullUpCanceled) goto L17;
        this.V1.d(RefreshState.PullUpToLoad);
    L19:
        this.I2 = null;
    L21:
        if (this.J2 != null) goto L25;
        return false;
    L25:
        return true;
    }

    public final boolean w(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.L == true) goto L6;
        return true;
    }

    public final void y(float r110) {
        if (this.L0 == true) goto L5;
    L11:
        float r100 = r110;
    L13:
        if (r100 > (this.f405868g * 5)) goto L15;
    L17:
        RefreshState r101 = this.f405863b2;
        if (r101 != RefreshState.TwoLevel) goto L23;
        if (r100 <= 0.0f) goto L23;
        this.V1.b(Math.min((int) r100, getMeasuredHeight()), true);
    L69:
        if (this.K == true) goto L71;
        return;
    L71:
        if (this.S == false) goto L73;
        return;
    L73:
        if (w(this.B) == true) goto L75;
        return;
    L75:
        if (r100 >= 0.0f) goto L90;
        RefreshState r102 = this.f405863b2;
        if (r102 != RefreshState.Refreshing) goto L79;
        return;
    L79:
        if (r102 != RefreshState.Loading) goto L81;
        return;
    L81:
        if (r102 != RefreshState.LoadFinish) goto L83;
        return;
    L83:
        if (this.R == false) goto L85;
        this.I2 = null;
        this.V1.a(-this.f405878k1);
    L85:
        setStateDirectLoading(false);
        this.T1.postDelayed(new f(this), this.f405867f);
        return;
    L90:
        return;
    L23:
        if (r101 != RefreshState.Refreshing) goto L34;
        if (r100 < 0.0f) goto L34;
        float r103 = this.f405869g1;
        if (r100 >= r103) goto L29;
        this.V1.b((int) r100, true);
        goto L69
    L29:
        double r111 = (this.f405900y1 - 1.0f) * r103;
        int r104 = Math.max((this.f405868g * 4) / 3, getHeight());
        int r105 = this.f405869g1;
        double r106 = r104 - r105;
        double r107 = Math.max(0.0f, (r100 - r105) * this.f405879l);
        double r108 = -r107;
        if (r106 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        r106 = 1.0d;
    L32:
        this.V1.b(((int) Math.min(r111 * (1.0d - Math.pow(100.0d, r108 / r106)), r107)) + this.f405869g1, true);
    L34:
        if (r100 >= 0.0f) goto L59;
        if (r101 != RefreshState.Loading) goto L38;
    L51:
        int r109 = this.f405878k1;
        if (r100 <= (-r109)) goto L54;
        this.V1.b((int) r100, true);
        goto L69
    L54:
        double r112 = (this.G1 - 1.0f) * r109;
        int r113 = Math.max((this.f405868g * 4) / 3, getHeight());
        int r114 = this.f405878k1;
        double r115 = r113 - r114;
        double r116 = -Math.min(0.0f, (r114 + r100) * this.f405879l);
        double r117 = -r116;
        if (r115 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L57;
        r115 = 1.0d;
    L57:
        this.V1.b(((int) (-Math.min(r112 * (1.0d - Math.pow(100.0d, r117 / r115)), r116))) - this.f405878k1, true);
        goto L69
    L38:
        if (this.G == false) goto L46;
        if (this.S == false) goto L46;
        if (this.T == false) goto L46;
        if (w(this.B) == true) goto L51;
    L46:
        if (this.K == false) goto L59;
        if (this.S == true) goto L59;
        if (w(this.B) == true) goto L51;
    L59:
        if (r100 < 0.0f) goto L64;
        double r118 = this.f405900y1 * this.f405869g1;
        double r119 = Math.max(this.f405868g / 2, getHeight());
        double r120 = Math.max(0.0f, this.f405879l * r100);
        double r121 = -r120;
        if (r119 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L63;
        r119 = 1.0d;
    L63:
        this.V1.b((int) Math.min(r118 * (1.0d - Math.pow(100.0d, r121 / r119)), r120), true);
        goto L69
    L64:
        double r122 = this.G1 * this.f405878k1;
        double r123 = Math.max(this.f405868g / 2, getHeight());
        double r124 = -Math.min(0.0f, this.f405879l * r100);
        double r125 = -r124;
        if (r123 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L67;
        r123 = 1.0d;
    L67:
        this.V1.b((int) (-Math.min(r122 * (1.0d - Math.pow(100.0d, r125 / r123)), r124)), true);
        goto L69
    L15:
        if (getTag() != null) goto L17;
        Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
        setTag("你这么死拉，臣妾做不到啊！");
        goto L17
    L5:
        if (this.O == true) goto L11;
        if (r110 >= 0.0f) goto L11;
        if (this.Q1.a() == true) goto L11;
        r100 = 0.0f;
        goto L13
    }

    public final void z(RefreshState r100) {
        RefreshState r101 = this.f405863b2;
        if (r101 == r100) goto L15;
        this.f405863b2 = r100;
        this.f405870g2 = r100;
        cqa.e r102 = this.M1;
        cqa.d r103 = this.P1;
        gqa.c r104 = this.f405884p0;
        if (r102 == null) goto L7;
        r102.e(this, r101, r100);
    L7:
        if (r103 == null) goto L9;
        r103.e(this, r101, r100);
    L9:
        if (r104 == null) goto L12;
        r104.e(this, r101, r100);
    L12:
        if (r100 != RefreshState.LoadFinish) goto L18;
        this.F2 = false;
        return;
    L18:
        return;
    L15:
        if (this.f405870g2 == r101) goto L20;
        this.f405870g2 = r101;
        return;
    }

    public SmartRefreshLayout(Context r110, AttributeSet r111) {
        super(r110, r111);
        this.f405866e = 300;
        this.f405867f = 300;
        this.f405879l = 0.5f;
        this.f405880m = 'n';
        this.f405883p = -1;
        this.f405887q = -1;
        this.f405888r = -1;
        this.f405889s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.f405859J = false;
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
        this.V = false;
        this.P0 = new int[2];
        NestedScrollingChildHelper r100 = new NestedScrollingChildHelper(this);
        this.V0 = r100;
        this.f405862b1 = new NestedScrollingParentHelper(this);
        dqa.a r101 = dqa.a.f469708c;
        this.f405872h1 = r101;
        this.f405885p1 = r101;
        this.f405900y1 = 2.5f;
        this.G1 = 2.5f;
        this.H1 = 1.0f;
        this.L1 = 1.0f;
        this.V1 = new j(this);
        RefreshState r102 = RefreshState.None;
        this.f405863b2 = r102;
        this.f405870g2 = r102;
        this.f405873h2 = 0;
        this.f405886p2 = 0;
        this.f405894v2 = 0;
        this.F2 = false;
        this.G2 = false;
        this.H2 = null;
        ViewConfiguration r103 = ViewConfiguration.get(r110);
        this.T1 = new Handler();
        this.f405895w = new Scroller(r110);
        this.f405896x = VelocityTracker.obtain();
        Resources r104 = r110.getResources();
        this.f405868g = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels;
        this.f405899y = new hqa.b(0);
        this.f405860a = r103.getScaledTouchSlop();
        this.f405890t = r103.getScaledMinimumFlingVelocity();
        this.f405891u = r103.getScaledMaximumFlingVelocity();
        this.f405878k1 = hqa.b.c(60.0f);
        this.f405869g1 = hqa.b.c(100.0f);
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.clipChildren, android.R.attr.clipToPadding, R.attr.srlAccentColor, R.attr.srlDisableContentWhenLoading, R.attr.srlDisableContentWhenRefresh, R.attr.srlDragRate, R.attr.srlEnableAutoLoadMore, R.attr.srlEnableClipFooterWhenFixedBehind, R.attr.srlEnableClipHeaderWhenFixedBehind, R.attr.srlEnableFooterFollowWhenLoadFinished, R.attr.srlEnableFooterFollowWhenNoMoreData, R.attr.srlEnableFooterTranslationContent, R.attr.srlEnableHeaderTranslationContent, R.attr.srlEnableLoadMore, R.attr.srlEnableLoadMoreWhenContentNotFull, R.attr.srlEnableNestedScrolling, R.attr.srlEnableOverScrollBounce, R.attr.srlEnableOverScrollDrag, R.attr.srlEnablePreviewInEditMode, R.attr.srlEnablePureScrollMode, R.attr.srlEnableRefresh, R.attr.srlEnableScrollContentWhenLoaded, R.attr.srlEnableScrollContentWhenRefreshed, R.attr.srlFixedFooterViewId, R.attr.srlFixedHeaderViewId, R.attr.srlFooterHeight, R.attr.srlFooterInsetStart, R.attr.srlFooterMaxDragRate, R.attr.srlFooterTranslationViewId, R.attr.srlFooterTriggerRate, R.attr.srlHeaderHeight, R.attr.srlHeaderInsetStart, R.attr.srlHeaderMaxDragRate, R.attr.srlHeaderTranslationViewId, R.attr.srlHeaderTriggerRate, R.attr.srlPrimaryColor, R.attr.srlReboundDuration});
        if (r112.hasValue(1) == true) goto L6;
        super.setClipToPadding(false);
    L6:
        if (r112.hasValue(0) == true) goto L8;
        super.setClipChildren(false);
    L8:
        this.f405879l = r112.getFloat(5, this.f405879l);
        this.f405900y1 = r112.getFloat(32, this.f405900y1);
        this.G1 = r112.getFloat(27, 2.5f);
        this.H1 = r112.getFloat(34, this.H1);
        this.L1 = r112.getFloat(29, 1.0f);
        this.A = r112.getBoolean(20, this.A);
        this.f405867f = r112.getInt(36, this.f405867f);
        this.B = r112.getBoolean(13, this.B);
        this.f405869g1 = r112.getDimensionPixelOffset(30, this.f405869g1);
        this.f405878k1 = r112.getDimensionPixelOffset(25, this.f405878k1);
        this.f405893v1 = r112.getDimensionPixelOffset(31, this.f405893v1);
        this.f405897x1 = r112.getDimensionPixelOffset(26, this.f405897x1);
        this.Q = r112.getBoolean(4, this.Q);
        this.R = r112.getBoolean(3, false);
        this.E = r112.getBoolean(12, this.E);
        this.F = r112.getBoolean(11, true);
        this.H = r112.getBoolean(18, true);
        this.K = r112.getBoolean(6, this.K);
        this.I = r112.getBoolean(16, this.I);
        boolean r105 = r112.getBoolean(19, false);
        this.L = r105;
        this.M = r112.getBoolean(21, true);
        this.N = r112.getBoolean(22, true);
        this.O = r112.getBoolean(14, true);
        boolean r113 = r112.getBoolean(9, false);
        this.G = r113;
        this.G = r112.getBoolean(10, r113);
        this.C = r112.getBoolean(8, true);
        this.D = r112.getBoolean(7, true);
        this.f405859J = r112.getBoolean(17, this.f405859J);
        this.f405883p = r112.getResourceId(24, -1);
        this.f405887q = r112.getResourceId(23, -1);
        this.f405888r = r112.getResourceId(33, -1);
        this.f405889s = r112.getResourceId(28, -1);
        boolean r106 = r112.getBoolean(15, this.P);
        this.P = r106;
        r100.setNestedScrollingEnabled(r106);
        if (this.U == false) goto L11;
    L14:
        boolean r107 = true;
    L15:
        this.U = r107;
        if (this.V == false) goto L18;
    L21:
        boolean r108 = true;
    L22:
        this.V = r108;
        r112.hasValue(11);
        if (r112.hasValue(30) == false) goto L25;
        dqa.a r114 = dqa.a.f469711f;
    L26:
        this.f405872h1 = r114;
        if (r112.hasValue(25) == false) goto L29;
        dqa.a r115 = dqa.a.f469711f;
    L30:
        this.f405885p1 = r115;
        int r116 = r112.getColor(2, 0);
        int r109 = r112.getColor(35, 0);
        if (r109 == 0) goto L35;
        if (r116 == 0) goto L34;
        this.f405902z = new int[]{r109, r116};
    L37:
        if (r105 == true) goto L39;
    L43:
        r112.recycle();
        return;
    L39:
        if (this.U == true) goto L43;
        if (this.B == true) goto L43;
        this.B = true;
        goto L43
    L34:
        this.f405902z = new int[]{r109};
        goto L37
    L35:
        if (r116 == 0) goto L37;
        this.f405902z = new int[]{0, r116};
        goto L37
    L29:
        r115 = this.f405885p1;
        goto L30
    L25:
        r114 = this.f405872h1;
        goto L26
    L18:
        if (r112.hasValue(12) == true) goto L21;
        r108 = false;
        goto L22
    L11:
        if (r112.hasValue(13) == true) goto L14;
        r107 = false;
        goto L15
    }

    public static /* synthetic */ void k(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void l(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void m(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void n(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void o(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public static /* synthetic */ void p(SmartRefreshLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public final void F(cqa.d r100, int r101) {
        cqa.d r102 = this.P1;
        if (r102 == null) goto L5;
        super.removeView(r102.getView());
    L5:
        this.P1 = r100;
        this.F2 = false;
        this.f405894v2 = 0;
        this.T = false;
        this.f405901y2 = false;
        this.f405885p1 = this.f405885p1.b();
        if (this.U == true) goto L8;
    L11:
        boolean r103 = true;
    L12:
        this.B = r103;
        if (this.P1.getSpinnerStyle().f469723b == false) goto L15;
        super.addView(this.P1.getView(), getChildCount(), new LayoutParams(r101));
    L16:
        int[] r104 = this.f405902z;
        if (r104 == null) goto L22;
        cqa.d r105 = this.P1;
        if (r105 == null) goto L23;
        r105.setPrimaryColors(r104);
        return;
    L23:
        return;
    L22:
        return;
    L15:
        super.addView(this.P1.getView(), 0, new LayoutParams(r101));
        goto L16
    L8:
        if (this.B == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void G(cqa.e r100, int r101) {
        cqa.e r102 = this.M1;
        if (r102 == null) goto L5;
        super.removeView(r102.getView());
    L5:
        this.M1 = r100;
        this.f405886p2 = 0;
        this.f405898x2 = false;
        this.f405872h1 = this.f405872h1.b();
        if (this.M1.getSpinnerStyle().f469723b == false) goto L8;
        super.addView(this.M1.getView(), getChildCount(), new LayoutParams(r101));
    L9:
        int[] r103 = this.f405902z;
        if (r103 == null) goto L15;
        cqa.e r104 = this.M1;
        if (r104 == null) goto L16;
        r104.setPrimaryColors(r103);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        super.addView(this.M1.getView(), 0, new LayoutParams(r101));
        goto L9
    }

    @Override // cqa.h
    public final SmartRefreshLayout b(int r100, boolean r101) {
        int r102 = r100 >> 16;
        int r103 = (r100 << 16) >> 16;
        bqa.b r104 = new bqa.b(this, r102, r101);
        if (r103 <= 0) goto L5;
        this.T1.postDelayed(r104, r103);
    L6:
        return this;
    L5:
        r104.run();
        goto L6
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
        if (r104.getTag(R.string.srl_component_falsify) == r104) goto L161;
        cqa.e r111 = this.M1;
        if (r111 != null) goto L18;
    L69:
        cqa.d r105 = this.P1;
        if (r105 == null) goto L125;
        if (r105.getView() != r104) goto L125;
        View r106 = this.P1.getView();
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L76;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r107;
    L77:
        int r113 = ViewGroup.getChildMeasureSpec(r110, r112.leftMargin + r112.rightMargin, r107.width);
        int r114 = this.f405878k1;
        dqa.a r115 = this.f405885p1;
        int r116 = r115.f469715a;
        dqa.a r117 = dqa.a.f469708c;
        if (r116 >= 6) goto L98;
        int r118 = r107.height;
        if (r118 <= 0) goto L85;
        r114 = r112.bottomMargin + (r118 + r112.topMargin);
        dqa.a r119 = dqa.a.f469710e;
        if (r115.a(r119) == false) goto L98;
        this.f405878k1 = (r107.height + r112.topMargin) + r112.bottomMargin;
        this.f405885p1 = r119;
        goto L98
    L85:
        if (r118 != (-2)) goto L98;
        if (this.P1.getSpinnerStyle() == dqa.b.f469720g) goto L89;
    L90:
        int r108 = Math.max((View.MeasureSpec.getSize(r210) - r112.bottomMargin) - r112.topMargin, 0);
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(r108, Integer.MIN_VALUE));
        int r120 = r106.getMeasuredHeight();
        if (r120 <= 0) goto L98;
        if (r120 == r108) goto L96;
        dqa.a r109 = this.f405885p1;
        dqa.a r121 = dqa.a.f469709d;
        if (r109.a(r121) == false) goto L96;
        this.f405878k1 = (r120 + r112.topMargin) + r112.bottomMargin;
        this.f405885p1 = r121;
    L96:
        r114 = -1;
        goto L98
    L89:
        if (this.f405885p1.f469716b == false) goto L90;
    L98:
        if (this.P1.getSpinnerStyle() != dqa.b.f469720g) goto L102;
        int r122 = View.MeasureSpec.getSize(r210);
        int r123 = 0;
    L111:
        if (r122 == (-1)) goto L113;
        r106.measure(r113, View.MeasureSpec.makeMeasureSpec(Math.max((r122 - r112.bottomMargin) - r112.topMargin, r123), 1073741824));
    L113:
        dqa.a r124 = this.f405885p1;
        boolean r125 = r124.f469716b;
        if (r125 == true) goto L120;
        if (r125 == true) goto L118;
        r124 = dqa.a.f469714i[r124.f469715a + 1];
    L118:
        this.f405885p1 = r124;
        cqa.d r126 = this.P1;
        j r127 = this.V1;
        int r128 = this.f405878k1;
        r126.g(r127, r128, (int) (this.G1 * r128));
    L120:
        if (r100 == false) goto L125;
        if (w(this.B) == false) goto L125;
        r103 = r103 + r106.getMeasuredHeight();
        goto L125
    L102:
        if (this.P1.getSpinnerStyle().f469724c == false) goto L109;
        if (r100 == true) goto L109;
        if (w(this.B) == false) goto L107;
        int r129 = -this.f405861b;
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
        r112 = K2;
    L125:
        eqa.a r130 = this.Q1;
        if (r130 == null) goto L161;
        View r131 = r130.f473550a;
        if (r131 != r104) goto L161;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == false) goto L132;
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
    L134:
        if (this.M1 != null) goto L136;
    L140:
        boolean r134 = false;
    L142:
        if (this.P1 != null) goto L144;
    L148:
        boolean r135 = false;
    L149:
        int r136 = ViewGroup.getChildMeasureSpec(r110, ((getPaddingLeft() + getPaddingRight()) + r133.leftMargin) + r133.rightMargin, r132.width);
        int r137 = ((getPaddingTop() + getPaddingBottom()) + r133.topMargin) + r133.bottomMargin;
        if (r100 == false) goto L153;
        if (r134 == false) goto L153;
        int r138 = this.f405869g1;
    L154:
        int r139 = r137 + r138;
        if (r100 == false) goto L158;
        if (r135 == false) goto L158;
        int r140 = this.f405878k1;
    L159:
        r131.measure(r136, ViewGroup.getChildMeasureSpec(r210, r139 + r140, r132.height));
        r103 = r103 + r131.getMeasuredHeight();
    L158:
        r140 = 0;
    L153:
        r138 = 0;
        goto L154
    L144:
        if (w(this.B) == false) goto L148;
        if (x(this.F, this.P1) == false) goto L148;
        r135 = true;
        goto L149
    L136:
        if (w(this.A) == false) goto L140;
        if (x(this.E, this.M1) == false) goto L140;
        r134 = true;
        goto L142
    L132:
        r133 = K2;
        goto L134
    L18:
        if (r111.getView() != r104) goto L69;
        View r141 = this.M1.getView();
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r142;
    L23:
        int r144 = ViewGroup.getChildMeasureSpec(r110, r143.leftMargin + r143.rightMargin, r142.width);
        int r145 = this.f405869g1;
        dqa.a r146 = this.f405872h1;
        int r147 = r146.f469715a;
        dqa.a r148 = dqa.a.f469708c;
        if (r147 >= 6) goto L43;
        int r149 = r142.height;
        if (r149 <= 0) goto L31;
        int r150 = (r149 + r143.bottomMargin) + r143.topMargin;
        dqa.a r151 = dqa.a.f469710e;
        if (r146.a(r151) == false) goto L45;
        this.f405869g1 = (r142.height + r143.bottomMargin) + r143.topMargin;
        this.f405872h1 = r151;
    L45:
        if (this.M1.getSpinnerStyle() != dqa.b.f469720g) goto L49;
        int r152 = View.MeasureSpec.getSize(r210);
        int r153 = 0;
    L58:
        if (r152 == (-1)) goto L60;
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(Math.max((r152 - r143.bottomMargin) - r143.topMargin, r153), 1073741824));
    L60:
        dqa.a r154 = this.f405872h1;
        boolean r155 = r154.f469716b;
        if (r155 == true) goto L65;
        if (r155 == true) goto L64;
        r154 = dqa.a.f469714i[r154.f469715a + 1];
    L64:
        this.f405872h1 = r154;
        cqa.e r156 = this.M1;
        j r157 = this.V1;
        int r158 = this.f405869g1;
        r156.g(r157, r158, (int) (this.f405900y1 * r158));
    L65:
        if (r100 == false) goto L69;
        if (w(this.A) == false) goto L69;
        r103 = r103 + r141.getMeasuredHeight();
        goto L69
    L49:
        if (this.M1.getSpinnerStyle().f469724c == false) goto L56;
        if (r100 == true) goto L56;
        if (w(this.A) == false) goto L54;
        int r159 = this.f405861b;
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
        if (this.M1.getSpinnerStyle() == dqa.b.f469720g) goto L35;
    L36:
        int r160 = Math.max((View.MeasureSpec.getSize(r210) - r143.bottomMargin) - r143.topMargin, 0);
        r141.measure(r144, View.MeasureSpec.makeMeasureSpec(r160, Integer.MIN_VALUE));
        int r161 = r141.getMeasuredHeight();
        if (r161 <= 0) goto L43;
        if (r161 == r160) goto L42;
        dqa.a r162 = this.f405872h1;
        dqa.a r163 = dqa.a.f469709d;
        if (r162.a(r163) == false) goto L42;
        this.f405869g1 = (r161 + r143.bottomMargin) + r143.topMargin;
        this.f405872h1 = r163;
    L42:
        r150 = -1;
        goto L45
    L35:
        if (this.f405872h1.f469716b == false) goto L36;
    L43:
        r150 = r145;
        goto L45
    L22:
        r143 = K2;
    L161:
        r102 = r102 + 1;
        goto L9
    L162:
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r110), View.resolveSize(r103, r210));
        this.f405875j = getMeasuredWidth() / 2.0f;
        return;
    L5:
        if (this.H == false) goto L7;
        r100 = true;
        goto L8
    }

    public final boolean x(boolean r100, cqa.f r101) {
        if (r100 == false) goto L4;
    L10:
        return true;
    L4:
        if (this.L == true) goto L10;
        if (r101 == null) goto L10;
        if (r101.getSpinnerStyle() == dqa.b.f469718e) goto L10;
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r110, View r111, long r112) {
        eqa.a r100 = this.Q1;
        if (r100 == null) goto L5;
        View r101 = r100.f473550a;
    L6:
        cqa.e r102 = this.M1;
        if (r102 != null) goto L9;
    L36:
        cqa.d r103 = this.P1;
        if (r103 == null) goto L67;
        if (r103.getView() != r111) goto L67;
        if (w(this.B) == true) goto L43;
    L65:
        return true;
    L43:
        if (this.H == false) goto L45;
    L47:
        if (r101 == null) goto L67;
        int r104 = Math.min((r101.getBottom() - r101.getPaddingBottom()) + this.f405861b, r111.getBottom());
        int r105 = this.f405894v2;
        if (r105 == 0) goto L60;
        Paint r106 = this.S1;
        if (r106 == null) goto L60;
        r106.setColor(r105);
        if (this.P1.getSpinnerStyle().f469724c == false) goto L56;
        r104 = r111.getTop();
    L58:
        r110.drawRect(0.0f, r104, getWidth(), r111.getBottom(), this.S1);
        goto L60
    L56:
        if (this.P1.getSpinnerStyle() != dqa.b.f469717d) goto L58;
        r104 = r111.getTop() + this.f405861b;
    L60:
        if (this.D == false) goto L67;
        if (this.P1.getSpinnerStyle() != dqa.b.f469718e) goto L67;
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
        if (w(this.A) == true) goto L13;
    L35:
        return true;
    L13:
        if (this.H == false) goto L15;
    L17:
        if (r101 == null) goto L36;
        int r107 = Math.max((r101.getTop() + r101.getPaddingTop()) + this.f405861b, r111.getTop());
        int r108 = this.f405886p2;
        if (r108 == 0) goto L30;
        Paint r109 = this.S1;
        if (r109 == null) goto L30;
        r109.setColor(r108);
        if (this.M1.getSpinnerStyle().f469724c == false) goto L26;
        r107 = r111.getBottom();
    L28:
        r110.drawRect(0.0f, r111.getTop(), getWidth(), r107, this.S1);
        goto L30
    L26:
        if (this.M1.getSpinnerStyle() != dqa.b.f469717d) goto L28;
        r107 = r111.getBottom() + this.f405861b;
    L30:
        if (this.C == false) goto L36;
        if (this.M1.getSpinnerStyle() != dqa.b.f469718e) goto L36;
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

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.F2 == false) goto L7;
        if (r102 <= 0.0f) goto L7;
    L12:
        return true;
    L7:
        if (H(-r102) == true) goto L12;
        if (this.V0.dispatchNestedPreFling(r101, r102) == true) goto L12;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f405862b1.onNestedScrollAccepted(r100, r101, r102);
        this.V0.startNestedScroll(r102 & 2);
        this.H0 = this.f405861b;
        this.L0 = true;
        v(0);
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
        if (this.f405859J == false) goto L14;
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

    public final void u(int r100, boolean r101, Boolean r102) {
        int r103 = r100 >> 16;
        int r104 = (r100 << 16) >> 16;
        bqa.a r105 = new bqa.a(this, r103, r102, r101);
        if (r104 <= 0) goto L5;
        this.T1.postDelayed(r105, r104);
        return;
    L5:
        r105.run();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return this.V0.dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        int r104 = this.H0;
        int r105 = 0;
        if ((r102 * r104) > 0) goto L5;
        if (r102 > 0) goto L11;
    L13:
        this.V0.dispatchNestedPreScroll(r101, r102 - r105, r103, null);
        r103[1] = r103[1] + r105;
        return;
    L11:
        if (this.F2 == false) goto L13;
        int r106 = r104 - r102;
        this.H0 = r106;
        y(r106);
        r105 = r102;
        goto L13
    L5:
        if (Math.abs(r102) <= Math.abs(this.H0)) goto L7;
        int r107 = this.H0;
        this.H0 = 0;
        r105 = r107;
    L8:
        y(this.H0);
        goto L13
    L7:
        this.H0 -= r102;
        r105 = r102;
        goto L8
    }

    public final ValueAnimator q(int r100, int r101, Interpolator r102, int r103) {
        if (this.f405861b == r100) goto L9;
        ValueAnimator r104 = this.J2;
        if (r104 == null) goto L7;
        r104.cancel();
    L7:
        this.I2 = null;
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{this.f405861b, r100});
        this.J2 = r105;
        r105.setDuration(r103);
        this.J2.setInterpolator(r102);
        this.J2.addListener(new d(this));
        this.J2.addUpdateListener(new e(this));
        this.J2.setStartDelay(r101);
        this.J2.start();
        return this.J2;
    L9:
        return null;
    }

    public final boolean r(int r100, int r101, float r102, boolean r103) {
        if (this.f405863b2 == RefreshState.None) goto L5;
        return false;
    L5:
        if (w(this.A) == false) goto L15;
        g r104 = new g(this, r102, r101, r103);
        setViceState(RefreshState.Refreshing);
        if (r100 <= 0) goto L9;
        this.T1.postDelayed(r104, r100);
        return true;
    L9:
        r104.run();
        return true;
    L15:
        return false;
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
        if (r100.getTag(R.string.srl_component_falsify) == r100) goto L109;
        eqa.a r101 = this.Q1;
        boolean r102 = true;
        if (r101 != null) goto L12;
    L33:
        cqa.e r103 = this.M1;
        if (r103 != null) goto L36;
    L55:
        cqa.d r104 = this.P1;
        if (r104 == null) goto L109;
        if (r104.getView() != r100) goto L109;
        if (isInEditMode() == true) goto L62;
    L66:
        r102 = false;
    L67:
        View r105 = this.P1.getView();
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L70;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L71:
        dqa.b r108 = this.P1.getSpinnerStyle();
        int r109 = r107.leftMargin;
        int r119 = (r107.topMargin + getMeasuredHeight()) - this.f405897x1;
        if (this.S == false) goto L89;
        if (this.T == false) goto L89;
        if (this.G == false) goto L89;
        if (this.Q1 == null) goto L89;
        if (this.P1.getSpinnerStyle() != dqa.b.f469717d) goto L89;
        if (w(this.B) == false) goto L89;
        View r120 = this.Q1.f473550a;
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
        if (r108 != dqa.b.f469720g) goto L91;
        r119 = r107.topMargin - this.f405897x1;
    L108:
        r105.layout(r109, r119, r105.getMeasuredWidth() + r109, r105.getMeasuredHeight() + r119);
        goto L109
    L91:
        if (r102 == false) goto L93;
    L106:
        int r124 = this.f405878k1;
    L107:
        r119 = r119 - r124;
        goto L108
    L93:
        if (r108 == dqa.b.f469719f) goto L106;
        if (r108 == dqa.b.f469718e) goto L106;
        if (r108.f469724c == false) goto L108;
        if (this.f405861b >= 0) goto L108;
        if (w(this.B) == false) goto L104;
        int r125 = -this.f405861b;
    L105:
        r124 = Math.max(r125, 0);
        goto L107
    L104:
        r125 = 0;
        goto L105
    L70:
        r107 = K2;
        goto L71
    L62:
        if (this.H == false) goto L66;
        if (w(this.B) == false) goto L66;
    L36:
        if (r103.getView() != r100) goto L55;
        if (isInEditMode() == true) goto L40;
    L44:
        boolean r126 = false;
    L45:
        View r127 = this.M1.getView();
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
    L49:
        int r130 = r129.leftMargin;
        int r131 = r129.topMargin + this.f405893v1;
        int r132 = r127.getMeasuredWidth() + r130;
        int r133 = r127.getMeasuredHeight() + r131;
        if (r126 == false) goto L52;
    L54:
        r127.layout(r130, r131, r132, r133);
        goto L55
    L52:
        if (this.M1.getSpinnerStyle() != dqa.b.f469717d) goto L54;
        int r134 = this.f405869g1;
        r131 = r131 - r134;
        r133 = r133 - r134;
        goto L54
    L48:
        r129 = K2;
        goto L49
    L40:
        if (this.H == false) goto L44;
        if (w(this.A) == false) goto L44;
        r126 = true;
        goto L45
    L12:
        if (r101.f473550a != r100) goto L33;
        if (isInEditMode() == true) goto L16;
    L22:
        boolean r135 = false;
    L23:
        View r136 = this.Q1.f473550a;
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
        if (x(this.E, this.M1) == false) goto L32;
        int r143 = this.f405869g1;
        r140 = r140 + r143;
        r142 = r142 + r143;
        goto L32
    L26:
        r138 = K2;
        goto L27
    L16:
        if (this.H == false) goto L22;
        if (w(this.A) == false) goto L22;
        if (this.M1 == null) goto L22;
        r135 = true;
    L109:
        r118 = r118 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        boolean r103 = this.V0.dispatchNestedScroll(r101, r102, r110, r111, this.P0);
        int r112 = r111 + this.P0[1];
        if (r112 < 0) goto L5;
    L9:
        if (r112 > 0) goto L11;
    L29:
        if (this.F2 == false) goto L33;
        if (r102 >= 0) goto L34;
        this.F2 = false;
        return;
    L34:
        return;
    L33:
        return;
    L11:
        if (this.B == false) goto L13;
    L14:
        RefreshState r104 = this.f405870g2;
        if (r104 != RefreshState.None) goto L17;
    L18:
        j r105 = this.V1;
        if (r112 <= 0) goto L21;
        RefreshState r106 = RefreshState.PullUpToLoad;
    L22:
        r105.d(r106);
        if (r103 == true) goto L27;
        ViewParent r107 = getParent();
        if ((r107 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r107).requestDisallowInterceptTouchEvent(true);
    L27:
        int r108 = this.H0 - r112;
        this.H0 = r108;
        y(r108);
        goto L29
    L21:
        r106 = RefreshState.PullDownToRefresh;
        goto L22
    L17:
        if (r104.isOpening == false) goto L27;
    L13:
        if (this.f405859J == false) goto L29;
    L5:
        if (this.A == true) goto L14;
        if (this.f405859J == false) goto L9;
        goto L9
    }
}
