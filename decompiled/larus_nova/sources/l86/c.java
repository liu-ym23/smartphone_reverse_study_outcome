package l86;

import com.bytedance.ies.xelement.pickview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f508051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f508052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f508053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f508054d;

    public final void a() {
        if (this.f508051a != Integer.MAX_VALUE) goto L5;
        this.f508051a = this.f508053c;
    L5:
        int r100 = this.f508051a;
        int r101 = (int) (r100 * 0.1f);
        this.f508052b = r101;
        if (r101 != 0) goto L11;
        if (r100 >= 0) goto L9;
        this.f508052b = -1;
        goto L11
    L9:
        this.f508052b = 1;
    L11:
        if (Math.abs(r100) > 1) goto L13;
        this.f508054d.a();
        this.f508054d.getHandler().sendEmptyMessage(3000);
        return;
    L13:
        WheelView r102 = this.f508054d;
        r102.setTotalScrollY(r102.getTotalScrollY() + this.f508052b);
        WheelView r103 = this.f508054d;
        if (r103.B == true) goto L21;
        float r104 = r103.getItemHeight();
        float r105 = (-this.f508054d.getInitPosition()) * r104;
        float r106 = ((this.f508054d.getItemsCount() - 1) - this.f508054d.getInitPosition()) * r104;
        if (this.f508054d.getTotalScrollY() > r105) goto L18;
    L19:
        WheelView r107 = this.f508054d;
        r107.setTotalScrollY(r107.getTotalScrollY() - this.f508052b);
        this.f508054d.a();
        this.f508054d.getHandler().sendEmptyMessage(3000);
        return;
    L18:
        if (this.f508054d.getTotalScrollY() >= r106) goto L19;
    L21:
        this.f508054d.getHandler().sendEmptyMessage(1000);
        this.f508051a -= this.f508052b;
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
        this.f508054d = r100;
        this.f508053c = r101;
        this.f508051a = Integer.MAX_VALUE;
        this.f508052b = 0;
    }
}
