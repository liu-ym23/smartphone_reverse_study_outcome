package l6a;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f507737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f507738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f507739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f507740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f507741e;

    public final void a() {
        int r100 = this.f507737a;
        o6a.a r101 = null;
        if (r100 != 0) goto L30;
        SmartRefreshLayout r102 = this.f507741e;
        RefreshState r103 = r102.V1;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L7;
    L9:
        ValueAnimator r105 = r102.I2;
        if (r105 == null) goto L19;
        if (r103.isHeader == false) goto L19;
        if (r103.isDragging == false) goto L16;
    L17:
        r102.I2 = null;
        r105.cancel();
        this.f507741e.T1.d(r104);
    L28:
        if (this.f507739c != Boolean.TRUE) goto L59;
        this.f507741e.p(true);
        return;
    L59:
        return;
    L16:
        if (r103 == RefreshState.RefreshReleased) goto L17;
    L19:
        if (r103 != RefreshState.Refreshing) goto L28;
        if (r102.L1 == null) goto L28;
        if (r102.P1 == null) goto L28;
        this.f507737a = r100 + 1;
        r102.S1.postDelayed(this, this.f507738b);
        this.f507741e.n(RefreshState.RefreshFinish);
        if (this.f507739c != Boolean.FALSE) goto L28;
        this.f507741e.p(false);
        goto L28
    L7:
        if (r102.f381487b2 != RefreshState.Refreshing) goto L9;
        r102.f381487b2 = r104;
        goto L28
    L30:
        SmartRefreshLayout r106 = this.f507741e;
        int r107 = r106.L1.e(r106, this.f507740d);
        SmartRefreshLayout r108 = this.f507741e;
        q6a.c r109 = r108.f381501k0;
        if (r109 == null) goto L36;
        if ((r108.L1 instanceof f) == false) goto L36;
        r109.h();
    L36:
        if (r107 >= Integer.MAX_VALUE) goto L61;
        SmartRefreshLayout r110 = this.f507741e;
        if (r110.f381505n == false) goto L40;
    L41:
        long r111 = System.currentTimeMillis();
        SmartRefreshLayout r112 = this.f507741e;
        if (r112.f381505n == false) goto L44;
        float r113 = r112.f381500k;
        r112.f381498i = r113;
        r112.f381489d = 0;
        r112.f381505n = false;
        SmartRefreshLayout.a(r112, MotionEvent.obtain(r111, r111, 0, r112.f381499j, (r113 + r112.f381485b) - (r112.f381484a * 2), 0));
        SmartRefreshLayout r114 = this.f507741e;
        SmartRefreshLayout.b(r114, MotionEvent.obtain(r111, r111, 2, r114.f381499j, r114.f381500k + r114.f381485b, 0));
    L44:
        SmartRefreshLayout r115 = this.f507741e;
        if (r115.H0 == false) goto L47;
        r115.f381508p0 = 0;
        SmartRefreshLayout.c(r115, MotionEvent.obtain(r111, r111, 1, r115.f381499j, r115.f381500k, 0));
        SmartRefreshLayout r116 = this.f507741e;
        r116.H0 = false;
        r116.f381489d = 0;
    L47:
        SmartRefreshLayout r117 = this.f507741e;
        int r118 = r117.f381485b;
        if (r118 <= 0) goto L55;
        ValueAnimator r119 = r117.g(0, r107, r117.f381523y, r117.f381491f);
        SmartRefreshLayout r120 = this.f507741e;
        if (r120.N == false) goto L52;
        r101 = r120.P1.e(r120.f381485b);
    L52:
        if (r119 == null) goto L62;
        if (r101 == null) goto L63;
        r119.addUpdateListener(r101);
        return;
    L63:
        return;
    L62:
        return;
    L55:
        if (r118 >= 0) goto L57;
        r117.g(0, r107, r117.f381523y, r117.f381491f);
        return;
    L57:
        r117.T1.b(0, false);
        this.f507741e.T1.d(RefreshState.None);
        return;
    L40:
        if (r110.H0 == false) goto L47;
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
        this.f507741e = r100;
        this.f507738b = r101;
        this.f507739c = r102;
        this.f507740d = r103;
        this.f507737a = 0;
    }
}
