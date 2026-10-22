package upa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f551159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f551160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f551161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f551162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f551163e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f551164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f551165b;

        /* JADX INFO: renamed from: upa.b$a$a, reason: collision with other inner class name */
        public class C7916a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f551166a;

            public C7916a(a r100) {
                this.f551166a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                if (r100 != null) goto L4;
            L6:
                b r101 = this.f551166a.f551165b;
                SmartRefreshLayout r102 = r101.f551163e;
                r102.f405819p2 = false;
                if (r101.f551161c == false) goto L9;
                r102.r(true);
            L9:
                SmartRefreshLayout r103 = this.f551166a.f551165b.f551163e;
                if (r103.T1 != RefreshState.LoadFinish) goto L13;
                r103.p(RefreshState.None);
                return;
            L13:
                return;
            L4:
                if (r100.getDuration() != 0) goto L6;
            }
        }

        public final void a() {
            SmartRefreshLayout r100 = this.f551165b.f551163e;
            if (r100.N == true) goto L5;
        L9:
            aqa.a r101 = null;
        L10:
            C7916a r102 = new C7916a(this);
            b r103 = this.f551165b;
            SmartRefreshLayout r104 = r103.f551163e;
            int r105 = r104.f405794b;
            if (r105 <= 0) goto L13;
            ValueAnimator r106 = r104.S1.a(0);
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
            if (r103.f551161c == true) goto L19;
        L24:
            r106 = r104.S1.a(0);
            goto L30
        L19:
            if (r104.H == false) goto L24;
            int r107 = -r104.f405795b1;
            if (r105 < r107) goto L23;
            r104.p(RefreshState.None);
        L29:
            r106 = null;
            goto L30
        L23:
            r106 = r104.S1.a(r107);
        L25:
            ValueAnimator r108 = r104.E2;
            if (r108 == null) goto L28;
            r108.setDuration(0);
            this.f551165b.f551163e.E2.cancel();
            this.f551165b.f551163e.E2 = null;
        L28:
            this.f551165b.f551163e.S1.b(0, false);
            this.f551165b.f551163e.S1.c(RefreshState.None);
            goto L29
        L5:
            if (this.f551164a >= 0) goto L9;
            r101 = r100.M1.e(r100.f405794b);
            if (r101 == null) goto L10;
            r101.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
            goto L10
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
            this.f551165b = r100;
            this.f551164a = r101;
        }
    }

    public final void a() {
        int r100 = this.f551159a;
        long r101 = 0;
        boolean r102 = true;
        if (r100 != 0) goto L32;
        SmartRefreshLayout r103 = this.f551163e;
        RefreshState r104 = r103.T1;
        RefreshState r105 = RefreshState.None;
        if (r104 == r105) goto L7;
    L9:
        ValueAnimator r106 = r103.E2;
        if (r106 == null) goto L22;
        if (r104.isDragging == true) goto L16;
        if (r104 != RefreshState.LoadReleased) goto L22;
    L16:
        if (r104.isFooter == false) goto L22;
        r106.setDuration(0);
        this.f551163e.E2.cancel();
        SmartRefreshLayout r107 = this.f551163e;
        r107.E2 = null;
        if (r107.S1.a(0) != null) goto L20;
        this.f551163e.p(r105);
    L30:
        if (this.f551161c == false) goto L67;
        this.f551163e.r(true);
        return;
    L67:
        return;
    L20:
        this.f551163e.p(RefreshState.PullUpCanceled);
    L22:
        if (r104 != RefreshState.Loading) goto L30;
        if (r103.L1 == null) goto L30;
        if (r103.M1 == null) goto L30;
        this.f551159a = r100 + 1;
        r103.Q1.postDelayed(this, this.f551160b);
        this.f551163e.p(RefreshState.LoadFinish);
        return;
    L7:
        if (r103.V1 != RefreshState.Loading) goto L9;
        r103.V1 = r105;
        goto L30
    L32:
        SmartRefreshLayout r108 = this.f551163e;
        int r109 = r108.L1.i(r108, this.f551162d);
        this.f551163e.getClass();
        if (r109 < Integer.MAX_VALUE) goto L35;
        return;
    L35:
        if (this.f551161c == false) goto L43;
        SmartRefreshLayout r110 = this.f551163e;
        if (r110.H == false) goto L43;
        if (r110.f405794b >= 0) goto L43;
        if (r110.M1.a() == false) goto L43;
    L44:
        SmartRefreshLayout r111 = this.f551163e;
        int r112 = r111.f405794b;
        if (r102 == false) goto L47;
        int r113 = Math.max(r112, -r111.f405795b1);
    L48:
        int r114 = r112 - r113;
        SmartRefreshLayout r115 = this.f551163e;
        if (r115.f405814n == false) goto L51;
    L52:
        long r116 = System.currentTimeMillis();
        SmartRefreshLayout r117 = this.f551163e;
        if (r117.f405814n == false) goto L59;
        float r118 = r117.f405809k;
        r117.f405807i = r118;
        r117.f405798d = r117.f405794b - r114;
        r117.f405814n = false;
        if (r117.G == false) goto L57;
        int r119 = r114;
    L58:
        float r120 = r119;
        SmartRefreshLayout.d(r117, MotionEvent.obtain(r116, r116, 0, r117.f405808j, (r118 + r120) + (r117.f405793a * 2), 0));
        SmartRefreshLayout r121 = this.f551163e;
        SmartRefreshLayout.e(r121, MotionEvent.obtain(r116, r116, 2, r121.f405808j, r121.f405809k + r120, 0));
        goto L59
    L57:
        r119 = 0;
    L59:
        SmartRefreshLayout r122 = this.f551163e;
        if (r122.f405810k0 == false) goto L62;
        r122.W = 0;
        SmartRefreshLayout.f(r122, MotionEvent.obtain(r116, r116, 1, r122.f405808j, r122.f405809k, 0));
        SmartRefreshLayout r123 = this.f551163e;
        r123.f405810k0 = false;
        r123.f405798d = 0;
    L62:
        SmartRefreshLayout r124 = this.f551163e;
        Handler r125 = r124.Q1;
        a r126 = new a(this, r114);
        if (r124.f405794b >= 0) goto L65;
        r101 = r109;
    L65:
        r125.postDelayed(r126, r101);
        return;
    L51:
        if (r115.f405810k0 == false) goto L62;
    L47:
        r113 = 0;
    L43:
        r102 = false;
        goto L44
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

    public b(SmartRefreshLayout r100, int r101, boolean r102, boolean r103) {
        this.f551163e = r100;
        this.f551160b = r101;
        this.f551161c = r102;
        this.f551162d = r103;
        this.f551159a = 0;
    }
}
