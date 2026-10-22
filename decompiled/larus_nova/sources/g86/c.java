package g86;

import com.bytedance.ies.xelement.picker.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f480406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f480407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f480408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f480409d;

    public final void a() {
        if (this.f480406a != Integer.MAX_VALUE) goto L5;
        this.f480406a = this.f480408c;
    L5:
        int r100 = this.f480406a;
        int r101 = (int) (r100 * 0.1f);
        this.f480407b = r101;
        if (r101 != 0) goto L11;
        if (r100 >= 0) goto L9;
        this.f480407b = -1;
        goto L11
    L9:
        this.f480407b = 1;
    L11:
        if (Math.abs(r100) > 1) goto L13;
        this.f480409d.a();
        this.f480409d.getHandler().sendEmptyMessage(3000);
        return;
    L13:
        WheelView r102 = this.f480409d;
        r102.setTotalScrollY(r102.getTotalScrollY() + this.f480407b);
        WheelView r103 = this.f480409d;
        if (r103.f250258z == true) goto L21;
        float r104 = r103.getItemHeight();
        float r105 = (-this.f480409d.getInitPosition()) * r104;
        float r106 = ((this.f480409d.getItemsCount() - 1) - this.f480409d.getInitPosition()) * r104;
        if (this.f480409d.getTotalScrollY() > r105) goto L18;
    L19:
        WheelView r107 = this.f480409d;
        r107.setTotalScrollY(r107.getTotalScrollY() - this.f480407b);
        this.f480409d.a();
        this.f480409d.getHandler().sendEmptyMessage(3000);
        return;
    L18:
        if (this.f480409d.getTotalScrollY() >= r106) goto L19;
    L21:
        this.f480409d.getHandler().sendEmptyMessage(1000);
        this.f480406a -= this.f480407b;
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
        this.f480409d = r100;
        this.f480408c = r101;
        this.f480406a = Integer.MAX_VALUE;
        this.f480407b = 0;
    }
}
