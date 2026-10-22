package sp5;

import android.os.Process;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends TimerTask {
    public float a;
    public final float b;
    public final WheelView c;

    public final void a() {
        Process.setThreadPriority(5);
        if (this.a != 2.1474836E9f) goto L13;
        float r1 = 2000.0f;
        if (Math.abs(this.b) > 2000.0f) goto L7;
        this.a = this.b;
        goto L13
    L7:
        if (this.b > 0.0f) goto L10;
        r1 = -2000.0f;
    L10:
        this.a = r1;
    L13:
        if (Math.abs(this.a) >= 0.0f) goto L15;
    L18:
        int r0 = (int) (this.a / 100.0f);
        WheelView r2 = this.c;
        float r3 = r0;
        r2.setTotalScrollY(r2.getTotalScrollY() - r3);
        WheelView r4 = this.c;
        if (r4.D == true) goto L32;
        float r5 = r4.getItemHeight();
        float r6 = (-this.c.getInitPosition()) * r5;
        float r7 = ((this.c.getItemsCount() - 1) - this.c.getInitPosition()) * r5;
        float r8 = r5 * 0.25f;
        if ((this.c.getTotalScrollY() - r8) >= r6) goto L24;
        r6 = this.c.getTotalScrollY() + r3;
    L27:
        if (this.c.getTotalScrollY() > r6) goto L30;
        this.a = 40.0f;
        this.c.setTotalScrollY((int) r6);
        goto L32
    L30:
        if (this.c.getTotalScrollY() < r7) goto L32;
        this.c.setTotalScrollY((int) r7);
        this.a = -40.0f;
        goto L32
    L24:
        if ((this.c.getTotalScrollY() + r8) <= r7) goto L27;
        r7 = this.c.getTotalScrollY() + r3;
    L32:
        float r9 = this.a;
        if (r9 >= 0.0f) goto L35;
        this.a = r9 + this.c.getResistance();
    L36:
        this.c.getHandler().sendEmptyMessage(CCMLynxCardView.ViewType.BANNER);
        return;
    L35:
        this.a = r9 - this.c.getResistance();
        goto L36
    L15:
        if (Math.abs(this.a) > 20.0f) goto L18;
        this.c.a();
        this.c.getHandler().sendEmptyMessage(2000);
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

    public a(WheelView r1, float r2) {
        this.c = r1;
        this.b = r2;
        this.a = 2.1474836E9f;
    }
}
