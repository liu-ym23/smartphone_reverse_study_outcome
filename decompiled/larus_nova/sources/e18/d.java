package e18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f470709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f470710b;

    public final void a() {
        float r100 = Math.abs(this.f470710b);
        boolean r101 = false;
        if (0.0f <= r100) goto L5;
    L7:
        if (r101 == false) goto L10;
        this.f470709a.cancelFuture();
        this.f470709a.getWheelHandler().sendEmptyMessage(2000);
        return;
    L10:
        float r102 = (this.f470710b * 10.0f) / 1000.0f;
        WheelView r103 = this.f470709a;
        r103.setTotalScrollY(r103.getTotalScrollY() - r102);
        if (this.f470709a.isLoop() == true) goto L25;
        float r104 = this.f470709a.getItemHeight();
        float r105 = (-this.f470709a.getInitPosition()) * r104;
        float r106 = ((this.f470709a.getItemsCount() - 1) - this.f470709a.getInitPosition()) * r104;
        double r107 = ((double) r104) * 0.25d;
        if ((((double) this.f470709a.getTotalScrollY()) - r107) >= r105) goto L17;
        r105 = this.f470709a.getTotalScrollY() + r102;
    L20:
        if (this.f470709a.getTotalScrollY() > r105) goto L23;
        this.f470710b = 40.0f;
        this.f470709a.setTotalScrollY(r105);
        goto L25
    L23:
        if (this.f470709a.getTotalScrollY() < r106) goto L25;
        this.f470709a.setTotalScrollY(r106);
        this.f470710b = -40.0f;
        goto L25
    L17:
        if ((((double) this.f470709a.getTotalScrollY()) + r107) <= r106) goto L20;
        r106 = this.f470709a.getTotalScrollY() + r102;
    L25:
        float r108 = this.f470710b;
        if (r108 >= 0.0f) goto L28;
        float r109 = r108 + 20.0f;
    L29:
        this.f470710b = r109;
        this.f470709a.checkLoopChange(-r102);
        this.f470709a.getWheelHandler().sendEmptyMessage(1000);
        return;
    L28:
        r109 = r108 - 20.0f;
        goto L29
    L5:
        if (r100 > 20.0f) goto L7;
        r101 = true;
        goto L7
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

    public d(WheelView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "wheelView");
        this.f470709a = r100;
        if (Math.abs(r101) > 2000.0f) goto L5;
    L8:
        this.f470710b = r101;
        return;
    L5:
        if (r101 <= 0.0f) goto L7;
        r101 = 2000.0f;
        goto L8
    L7:
        r101 = -2000.0f;
        goto L8
    }
}
