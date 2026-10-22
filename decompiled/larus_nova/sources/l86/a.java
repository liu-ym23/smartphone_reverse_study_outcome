package l86;

import com.bytedance.ies.xelement.pickview.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f508047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f508048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelView f508049c;

    public final void a() {
        if (this.f508047a != 2.1474836E9f) goto L13;
        float r100 = 2000.0f;
        if (Math.abs(this.f508048b) > 2000.0f) goto L7;
        this.f508047a = this.f508048b;
        goto L13
    L7:
        if (this.f508048b > 0.0f) goto L10;
        r100 = -2000.0f;
    L10:
        this.f508047a = r100;
    L13:
        if (Math.abs(this.f508047a) >= 0.0f) goto L15;
    L18:
        int r101 = (int) (this.f508047a / 100.0f);
        WheelView r102 = this.f508049c;
        float r103 = r101;
        r102.setTotalScrollY(r102.getTotalScrollY() - r103);
        WheelView r104 = this.f508049c;
        if (r104.B == true) goto L32;
        float r105 = r104.getItemHeight();
        float r106 = (-this.f508049c.getInitPosition()) * r105;
        float r107 = ((this.f508049c.getItemsCount() - 1) - this.f508049c.getInitPosition()) * r105;
        double r108 = ((double) r105) * 0.25d;
        if ((((double) this.f508049c.getTotalScrollY()) - r108) >= r106) goto L24;
        r106 = this.f508049c.getTotalScrollY() + r103;
    L27:
        if (this.f508049c.getTotalScrollY() > r106) goto L30;
        this.f508047a = 40.0f;
        this.f508049c.setTotalScrollY((int) r106);
        goto L32
    L30:
        if (this.f508049c.getTotalScrollY() < r107) goto L32;
        this.f508049c.setTotalScrollY((int) r107);
        this.f508047a = -40.0f;
        goto L32
    L24:
        if ((((double) this.f508049c.getTotalScrollY()) + r108) <= r107) goto L27;
        r107 = this.f508049c.getTotalScrollY() + r103;
    L32:
        float r109 = this.f508047a;
        if (r109 >= 0.0f) goto L35;
        this.f508047a = r109 + 20.0f;
    L36:
        this.f508049c.getHandler().sendEmptyMessage(1000);
        return;
    L35:
        this.f508047a = r109 - 20.0f;
        goto L36
    L15:
        if (Math.abs(this.f508047a) > 20.0f) goto L18;
        this.f508049c.a();
        this.f508049c.getHandler().sendEmptyMessage(2000);
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
        this.f508049c = r100;
        this.f508048b = r101;
        this.f508047a = 2.1474836E9f;
    }
}
