package sp5;

import android.os.Process;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f542879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f542880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f542882d;

    public final void a() {
        Process.setThreadPriority(5);
        if (this.f542879a != Integer.MAX_VALUE) goto L5;
        this.f542879a = this.f542881c;
    L5:
        int r100 = this.f542879a;
        int r101 = (int) (r100 * 0.1f);
        this.f542880b = r101;
        if (r101 != 0) goto L11;
        if (r100 >= 0) goto L9;
        this.f542880b = -1;
        goto L11
    L9:
        this.f542880b = 1;
    L11:
        if (Math.abs(r100) > 1) goto L13;
        this.f542882d.a();
        this.f542882d.getHandler().sendEmptyMessage(3000);
        return;
    L13:
        WheelView r102 = this.f542882d;
        r102.setTotalScrollY(r102.getTotalScrollY() + this.f542880b);
        WheelView r103 = this.f542882d;
        if (r103.D == true) goto L21;
        float r104 = r103.getItemHeight();
        float r105 = (-this.f542882d.getInitPosition()) * r104;
        float r106 = ((this.f542882d.getItemsCount() - 1) - this.f542882d.getInitPosition()) * r104;
        if (this.f542882d.getTotalScrollY() > r105) goto L18;
    L19:
        WheelView r107 = this.f542882d;
        r107.setTotalScrollY(r107.getTotalScrollY() - this.f542880b);
        this.f542882d.a();
        this.f542882d.getHandler().sendEmptyMessage(3000);
        return;
    L18:
        if (this.f542882d.getTotalScrollY() >= r106) goto L19;
    L21:
        this.f542882d.getHandler().sendEmptyMessage(1000);
        this.f542879a -= this.f542880b;
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

    public c(WheelView r100, int r101) {
        this.f542882d = r100;
        this.f542881c = r101;
        this.f542879a = Integer.MAX_VALUE;
        this.f542880b = 0;
    }
}
