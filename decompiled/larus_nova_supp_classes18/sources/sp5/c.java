package sp5;

import android.os.Process;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends TimerTask {
    public int a;
    public int b;
    public final int c;
    public final WheelView d;

    public final void a() {
        Process.setThreadPriority(5);
        if (this.a != Integer.MAX_VALUE) goto L5;
        this.a = this.c;
    L5:
        int r0 = this.a;
        int r1 = (int) (r0 * 0.1f);
        this.b = r1;
        if (r1 != 0) goto L11;
        if (r0 >= 0) goto L9;
        this.b = -1;
        goto L11
    L9:
        this.b = 1;
    L11:
        if (Math.abs(r0) > 1) goto L13;
        this.d.a();
        this.d.getHandler().sendEmptyMessage(3000);
        return;
    L13:
        WheelView r2 = this.d;
        r2.setTotalScrollY(r2.getTotalScrollY() + this.b);
        WheelView r3 = this.d;
        if (r3.D == true) goto L21;
        float r4 = r3.getItemHeight();
        float r5 = (-this.d.getInitPosition()) * r4;
        float r6 = ((this.d.getItemsCount() - 1) - this.d.getInitPosition()) * r4;
        if (this.d.getTotalScrollY() > r5) goto L18;
    L19:
        WheelView r7 = this.d;
        r7.setTotalScrollY(r7.getTotalScrollY() - this.b);
        this.d.a();
        this.d.getHandler().sendEmptyMessage(3000);
        return;
    L18:
        if (this.d.getTotalScrollY() >= r6) goto L19;
    L21:
        this.d.getHandler().sendEmptyMessage(CCMLynxCardView.ViewType.BANNER);
        this.a -= this.b;
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

    public c(WheelView r1, int r2) {
        this.d = r1;
        this.c = r2;
        this.a = Integer.MAX_VALUE;
        this.b = 0;
    }
}
