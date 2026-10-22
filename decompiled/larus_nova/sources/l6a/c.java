package l6a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f507750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f507751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f507752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f507753d;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f507754a;

        public a(c r100) {
            this.f507754a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            SmartRefreshLayout r101 = this.f507754a.f507753d;
            if (r101.I2 == null) goto L6;
            r101.T1.b(((Integer) r100.getAnimatedValue()).intValue(), true);
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f507755a;

        public b(c r100) {
            this.f507755a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SmartRefreshLayout r101 = this.f507755a.f507753d;
            if (r101.I2 == null) goto L9;
            r101.I2 = null;
            RefreshState r102 = r101.V1;
            RefreshState r103 = RefreshState.ReleaseToRefresh;
            if (r102 == r103) goto L7;
            r101.T1.d(r103);
        L7:
            c r104 = this.f507755a;
            r104.f507753d.setStateRefreshing(!r104.f507752c);
            return;
        }
    }

    public final void a() {
        SmartRefreshLayout r100 = this.f507753d;
        if (r100.f381487b2 == RefreshState.Refreshing) goto L5;
        return;
    L5:
        ValueAnimator r101 = r100.I2;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        SmartRefreshLayout r102 = this.f507753d;
        r102.f381499j = r102.getMeasuredWidth() / 2.0f;
        this.f507753d.T1.d(RefreshState.PullDownToRefresh);
        SmartRefreshLayout r103 = this.f507753d;
        r103.I2 = ValueAnimator.ofInt(new int[]{r103.f381485b, (int) (r103.f381486b1 * this.f507750a)});
        this.f507753d.I2.setDuration(this.f507751b);
        this.f507753d.I2.setInterpolator(new r6a.b(0));
        this.f507753d.I2.addUpdateListener(new a(this));
        this.f507753d.I2.addListener(new b(this));
        this.f507753d.I2.start();
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

    public c(SmartRefreshLayout r100) {
        this.f507753d = r100;
        this.f507750a = 1.0f;
        this.f507751b = 300;
        this.f507752c = false;
    }
}
