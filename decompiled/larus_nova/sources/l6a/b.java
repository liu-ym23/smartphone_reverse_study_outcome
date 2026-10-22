package l6a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.e;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f507742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f507743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f507744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f507745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f507746e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f507747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f507748b;

        /* JADX INFO: renamed from: l6a.b$a$a, reason: collision with other inner class name */
        public class C6657a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f507749a;

            public C6657a(a r100) {
                this.f507749a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                b r101 = this.f507749a.f507748b;
                SmartRefreshLayout r102 = r101.f507746e;
                r102.E2 = false;
                if (r101.f507744c == false) goto L5;
                r102.p(true);
            L5:
                SmartRefreshLayout r103 = this.f507749a.f507748b.f507746e;
                if (r103.V1 != RefreshState.LoadFinish) goto L9;
                r103.n(RefreshState.None);
                return;
            }
        }

        public final void a() {
            SmartRefreshLayout r100 = this.f507748b.f507746e;
            if (r100.M == true) goto L5;
        L7:
            o6a.a r101 = null;
        L8:
            if (r101 == null) goto L10;
            r101.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
        L10:
            C6657a r102 = new C6657a(this);
            b r103 = this.f507748b;
            SmartRefreshLayout r104 = r103.f507746e;
            int r105 = r104.f381485b;
            if (r105 <= 0) goto L13;
            ValueAnimator r106 = r104.T1.a(0);
        L30:
            if (r106 == null) goto L32;
            r106.addListener(r102);
            return;
        L32:
            r102.onAnimationEnd(null);
            return;
        L13:
            if (r101 != null) goto L25;
            if (r105 == 0) goto L25;
            if (r103.f507744c == true) goto L19;
        L24:
            r106 = r104.T1.a(0);
            goto L30
        L19:
            if (r104.G == false) goto L24;
            int r107 = -r104.f381496h1;
            if (r105 < r107) goto L23;
            r104.n(RefreshState.None);
        L29:
            r106 = null;
            goto L30
        L23:
            r106 = r104.T1.a(r107);
        L25:
            ValueAnimator r108 = r104.I2;
            if (r108 == null) goto L28;
            r108.cancel();
            this.f507748b.f507746e.I2 = null;
        L28:
            this.f507748b.f507746e.T1.b(0, false);
            this.f507748b.f507746e.T1.d(RefreshState.None);
            goto L29
        L5:
            if (this.f507747a >= 0) goto L7;
            r101 = r100.P1.e(r100.f381485b);
            goto L8
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

        public a(b r100, int r101) {
            this.f507748b = r100;
            this.f507747a = r101;
        }
    }

    public final void a() {
        int r100 = this.f507742a;
        boolean r101 = true;
        if (r100 != 0) goto L29;
        SmartRefreshLayout r102 = this.f507746e;
        RefreshState r103 = r102.V1;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L7;
    L9:
        ValueAnimator r105 = r102.I2;
        if (r105 == null) goto L19;
        if (r103.isDragging == true) goto L16;
        if (r103 != RefreshState.LoadReleased) goto L19;
    L16:
        if (r103.isFooter == false) goto L19;
        r102.I2 = null;
        r105.cancel();
        this.f507746e.T1.d(r104);
    L27:
        if (this.f507744c == false) goto L70;
        this.f507746e.p(true);
        return;
    L70:
        return;
    L19:
        if (r103 != RefreshState.Loading) goto L27;
        if (r102.M1 == null) goto L27;
        if (r102.P1 == null) goto L27;
        this.f507742a = r100 + 1;
        r102.S1.postDelayed(this, this.f507743b);
        this.f507746e.n(RefreshState.LoadFinish);
        return;
    L7:
        if (r102.f381487b2 != RefreshState.Loading) goto L9;
        r102.f381487b2 = r104;
        goto L27
    L29:
        SmartRefreshLayout r106 = this.f507746e;
        int r107 = r106.M1.e(r106, this.f507745d);
        SmartRefreshLayout r108 = this.f507746e;
        q6a.c r109 = r108.f381501k0;
        if (r109 == null) goto L35;
        if ((r108.M1 instanceof e) == false) goto L35;
        r109.C();
    L35:
        if (r107 < Integer.MAX_VALUE) goto L37;
        return;
    L37:
        if (this.f507744c == false) goto L45;
        SmartRefreshLayout r110 = this.f507746e;
        if (r110.G == false) goto L45;
        if (r110.f381485b >= 0) goto L45;
        if (r110.P1.canLoadMore() == false) goto L45;
    L46:
        SmartRefreshLayout r111 = this.f507746e;
        int r112 = r111.f381485b;
        if (r101 == false) goto L49;
        int r113 = Math.max(r112, -r111.f381496h1);
    L50:
        int r114 = r112 - r113;
        SmartRefreshLayout r115 = this.f507746e;
        if (r115.f381505n == false) goto L53;
    L54:
        long r116 = System.currentTimeMillis();
        SmartRefreshLayout r117 = this.f507746e;
        if (r117.f381505n == false) goto L61;
        float r118 = r117.f381500k;
        r117.f381498i = r118;
        r117.f381489d = r117.f381485b - r114;
        r117.f381505n = false;
        if (r117.F == false) goto L59;
        int r119 = r114;
    L60:
        float r120 = r119;
        SmartRefreshLayout.d(r117, MotionEvent.obtain(r116, r116, 0, r117.f381499j, (r118 + r120) + (r117.f381484a * 2), 0));
        SmartRefreshLayout r121 = this.f507746e;
        SmartRefreshLayout.e(r121, MotionEvent.obtain(r116, r116, 2, r121.f381499j, r121.f381500k + r120, 0));
        goto L61
    L59:
        r119 = 0;
    L61:
        SmartRefreshLayout r122 = this.f507746e;
        if (r122.H0 == false) goto L64;
        r122.f381508p0 = 0;
        SmartRefreshLayout.f(r122, MotionEvent.obtain(r116, r116, 1, r122.f381499j, r122.f381500k, 0));
        SmartRefreshLayout r123 = this.f507746e;
        r123.H0 = false;
        r123.f381489d = 0;
    L64:
        SmartRefreshLayout r124 = this.f507746e;
        Handler r125 = r124.S1;
        a r126 = new a(this, r114);
        if (r124.f381485b >= 0) goto L67;
        long r127 = r107;
    L68:
        r125.postDelayed(r126, r127);
        return;
    L67:
        r127 = 0;
        goto L68
    L53:
        if (r115.H0 == false) goto L64;
    L49:
        r113 = 0;
    L45:
        r101 = false;
        goto L46
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

    public b(SmartRefreshLayout r100, int r101, boolean r102) {
        this.f507746e = r100;
        this.f507743b = r101;
        this.f507744c = r102;
        this.f507745d = true;
        this.f507742a = 0;
    }
}
