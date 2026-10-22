package e18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f470712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f470713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f470714c;

    public final void a() {
        float r100 = this.f470713b;
        float r101 = 0.1f * r100;
        this.f470714c = r101;
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L14;
        if (r100 >= 0.0f) goto L11;
        float r103 = -1.0f;
    L12:
        this.f470714c = r103;
        goto L14
    L11:
        r103 = 1.0f;
    L14:
        if (Math.abs(r100) > 1.0f) goto L17;
        this.f470712a.cancelFuture();
        this.f470712a.getWheelHandler().sendEmptyMessage(3000);
        return;
    L17:
        WheelView r104 = this.f470712a;
        r104.setTotalScrollY(r104.getTotalScrollY() + this.f470714c);
        if (this.f470712a.isLoop() == true) goto L25;
        float r105 = this.f470712a.getItemHeight();
        float r106 = (-this.f470712a.getInitPosition()) * r105;
        float r107 = ((this.f470712a.getItemsCount() - 1) - this.f470712a.getInitPosition()) * r105;
        if (this.f470712a.getTotalScrollY() > r106) goto L22;
    L23:
        WheelView r108 = this.f470712a;
        r108.setTotalScrollY(r108.getTotalScrollY() - this.f470714c);
        this.f470712a.cancelFuture();
        this.f470712a.getWheelHandler().sendEmptyMessage(3000);
        return;
    L22:
        if (this.f470712a.getTotalScrollY() >= r107) goto L23;
    L25:
        this.f470712a.checkLoopChange(this.f470714c);
        this.f470712a.getWheelHandler().sendEmptyMessage(1000);
        this.f470713b -= this.f470714c;
        return;
    L5:
        r102 = false;
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

    public f(WheelView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "wheelView");
        this.f470712a = r100;
        this.f470713b = r101;
    }
}
