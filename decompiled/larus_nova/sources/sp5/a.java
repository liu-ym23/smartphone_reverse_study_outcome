package sp5;

import android.os.Process;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f542875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f542876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelView f542877c;

    public final void a() {
        Process.setThreadPriority(5);
        if (this.f542875a != 2.1474836E9f) goto L13;
        float r100 = 2000.0f;
        if (Math.abs(this.f542876b) > 2000.0f) goto L7;
        this.f542875a = this.f542876b;
        goto L13
    L7:
        if (this.f542876b > 0.0f) goto L10;
        r100 = -2000.0f;
    L10:
        this.f542875a = r100;
    L13:
        if (Math.abs(this.f542875a) >= 0.0f) goto L15;
    L18:
        int r101 = (int) (this.f542875a / 100.0f);
        WheelView r102 = this.f542877c;
        float r103 = r101;
        r102.setTotalScrollY(r102.getTotalScrollY() - r103);
        WheelView r104 = this.f542877c;
        if (r104.D == true) goto L32;
        float r105 = r104.getItemHeight();
        float r106 = (-this.f542877c.getInitPosition()) * r105;
        float r107 = ((this.f542877c.getItemsCount() - 1) - this.f542877c.getInitPosition()) * r105;
        float r108 = r105 * 0.25f;
        if ((this.f542877c.getTotalScrollY() - r108) >= r106) goto L24;
        r106 = this.f542877c.getTotalScrollY() + r103;
    L27:
        if (this.f542877c.getTotalScrollY() > r106) goto L30;
        this.f542875a = 40.0f;
        this.f542877c.setTotalScrollY((int) r106);
        goto L32
    L30:
        if (this.f542877c.getTotalScrollY() < r107) goto L32;
        this.f542877c.setTotalScrollY((int) r107);
        this.f542875a = -40.0f;
        goto L32
    L24:
        if ((this.f542877c.getTotalScrollY() + r108) <= r107) goto L27;
        r107 = this.f542877c.getTotalScrollY() + r103;
    L32:
        float r109 = this.f542875a;
        if (r109 >= 0.0f) goto L35;
        this.f542875a = r109 + this.f542877c.getResistance();
    L36:
        this.f542877c.getHandler().sendEmptyMessage(1000);
        return;
    L35:
        this.f542875a = r109 - this.f542877c.getResistance();
        goto L36
    L15:
        if (Math.abs(this.f542875a) > 20.0f) goto L18;
        this.f542877c.a();
        this.f542877c.getHandler().sendEmptyMessage(2000);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
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

    public a(WheelView r100, float r101) {
        this.f542877c = r100;
        this.f542876b = r101;
        this.f542875a = 2.1474836E9f;
    }
}
