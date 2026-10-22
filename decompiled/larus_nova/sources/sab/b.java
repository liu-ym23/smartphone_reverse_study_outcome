package sab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f541201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f541203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f541204d;

    public final void a() {
        if (this.f541202b != Integer.MAX_VALUE) goto L5;
        this.f541202b = this.f541204d;
    L5:
        int r100 = this.f541202b;
        int r101 = (int) (r100 * 0.1f);
        this.f541203c = r101;
        if (r101 != 0) goto L11;
        if (r100 >= 0) goto L9;
        this.f541203c = -1;
        goto L11
    L9:
        this.f541203c = 1;
    L11:
        if (Math.abs(r100) > 1) goto L13;
        this.f541201a.a();
        this.f541201a.f420361b.sendEmptyMessage(3000);
        return;
    L13:
        WheelView r102 = this.f541201a;
        r102.f420381v += this.f541203c;
        if (r102.f420377r == true) goto L21;
        float r103 = r102.f420371l;
        float r104 = (-r102.f420382w) * r103;
        int r105 = r102.getItemsCount() - 1;
        WheelView r106 = this.f541201a;
        float r107 = (r105 - r106.f420382w) * r103;
        float r108 = r106.f420381v;
        if (r108 > r104) goto L18;
    L19:
        r106.f420381v = r108 - this.f541203c;
        r106.a();
        this.f541201a.f420361b.sendEmptyMessage(3000);
        return;
    L18:
        if (r108 >= r107) goto L19;
    L21:
        this.f541201a.getClass();
        this.f541201a.f420361b.sendEmptyMessage(1000);
        this.f541202b -= this.f541203c;
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

    public b(WheelView r100, int r101) {
        this.f541201a = r100;
        this.f541204d = r101;
        this.f541202b = Integer.MAX_VALUE;
        this.f541203c = 0;
    }
}
