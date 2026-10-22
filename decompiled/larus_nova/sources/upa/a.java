package upa;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f551154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f551155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f551156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f551157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f551158e;

    public final void a() {
        int r100 = this.f551154a;
        aqa.a r101 = null;
        if (r100 != 0) goto L33;
        SmartRefreshLayout r102 = this.f551158e;
        RefreshState r103 = r102.T1;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L7;
    L9:
        ValueAnimator r105 = r102.E2;
        if (r105 == null) goto L22;
        if (r103.isHeader == false) goto L22;
        if (r103.isDragging == false) goto L16;
    L17:
        r105.setDuration(0);
        this.f551158e.E2.cancel();
        SmartRefreshLayout r106 = this.f551158e;
        r106.E2 = null;
        if (r106.S1.a(0) != null) goto L20;
        this.f551158e.p(r104);
    L31:
        if (this.f551156c != Boolean.TRUE) goto L57;
        this.f551158e.r(true);
        return;
    L57:
        return;
    L20:
        this.f551158e.p(RefreshState.PullDownCanceled);
        goto L31
    L16:
        if (r103 == RefreshState.RefreshReleased) goto L17;
    L22:
        if (r103 != RefreshState.Refreshing) goto L31;
        if (r102.H1 == null) goto L31;
        if (r102.M1 == null) goto L31;
        this.f551154a = r100 + 1;
        r102.Q1.postDelayed(this, this.f551155b);
        this.f551158e.p(RefreshState.RefreshFinish);
        if (this.f551156c != Boolean.FALSE) goto L31;
        this.f551158e.r(false);
        goto L31
    L7:
        if (r102.V1 != RefreshState.Refreshing) goto L9;
        r102.V1 = r104;
        goto L31
    L33:
        SmartRefreshLayout r107 = this.f551158e;
        int r108 = r107.H1.i(r107, this.f551157d);
        this.f551158e.getClass();
        if (r108 >= Integer.MAX_VALUE) goto L59;
        SmartRefreshLayout r109 = this.f551158e;
        if (r109.f405814n == false) goto L38;
    L39:
        long r110 = System.currentTimeMillis();
        SmartRefreshLayout r111 = this.f551158e;
        if (r111.f405814n == false) goto L42;
        float r112 = r111.f405809k;
        r111.f405807i = r112;
        r111.f405798d = 0;
        r111.f405814n = false;
        SmartRefreshLayout.a(r111, MotionEvent.obtain(r110, r110, 0, r111.f405808j, (r112 + r111.f405794b) - (r111.f405793a * 2), 0));
        SmartRefreshLayout r113 = this.f551158e;
        SmartRefreshLayout.b(r113, MotionEvent.obtain(r110, r110, 2, r113.f405808j, r113.f405809k + r113.f405794b, 0));
    L42:
        SmartRefreshLayout r114 = this.f551158e;
        if (r114.f405810k0 == false) goto L45;
        r114.W = 0;
        SmartRefreshLayout.c(r114, MotionEvent.obtain(r110, r110, 1, r114.f405808j, r114.f405809k, 0));
        SmartRefreshLayout r115 = this.f551158e;
        r115.f405810k0 = false;
        r115.f405798d = 0;
    L45:
        SmartRefreshLayout r116 = this.f551158e;
        int r117 = r116.f405794b;
        if (r117 <= 0) goto L53;
        ValueAnimator r118 = r116.g(0, r108, r116.f405835z, r116.f405800f);
        SmartRefreshLayout r119 = this.f551158e;
        if (r119.O == false) goto L50;
        r101 = r119.M1.e(r119.f405794b);
    L50:
        if (r118 == null) goto L60;
        if (r101 == null) goto L61;
        r118.addUpdateListener(r101);
        return;
    L61:
        return;
    L60:
        return;
    L53:
        if (r117 >= 0) goto L55;
        r116.g(0, r108, r116.f405835z, r116.f405800f);
        return;
    L55:
        r116.S1.b(0, false);
        this.f551158e.S1.c(RefreshState.None);
        return;
    L38:
        if (r109.f405810k0 == false) goto L45;
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

    public a(SmartRefreshLayout r100, int r101, Boolean r102, boolean r103) {
        this.f551158e = r100;
        this.f551155b = r101;
        this.f551156c = r102;
        this.f551157d = r103;
        this.f551154a = 0;
    }
}
