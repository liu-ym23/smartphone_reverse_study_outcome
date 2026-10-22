package sab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f541198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WheelView f541199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f541200c;

    public final void a() {
        if (this.f541200c != 2.1474836E9f) goto L12;
        if (Math.abs(this.f541198a) > 2000.0f) goto L7;
        this.f541200c = this.f541198a;
        goto L12
    L7:
        if (this.f541198a <= 0.0f) goto L9;
        this.f541200c = 2000.0f;
        goto L12
    L9:
        this.f541200c = -2000.0f;
    L12:
        if (Math.abs(this.f541200c) >= 0.0f) goto L14;
    L17:
        int r100 = (int) ((this.f541200c * 10.0f) / 1000.0f);
        WheelView r101 = this.f541199b;
        float r102 = r100;
        r101.f420381v -= r102;
        if (r101.f420377r == true) goto L31;
        float r103 = r101.f420371l;
        float r104 = (-r101.f420382w) * r103;
        int r105 = r101.getItemsCount() - 1;
        WheelView r106 = this.f541199b;
        float r107 = (r105 - r106.f420382w) * r103;
        float r108 = r106.f420381v;
        float r109 = r103 * 0.25f;
        if ((r108 - r109) >= r104) goto L23;
        r104 = r108 + r102;
    L26:
        if (r108 > r104) goto L29;
        this.f541200c = 40.0f;
        r106.f420381v = (int) r104;
        goto L31
    L29:
        if (r108 < r107) goto L31;
        r106.f420381v = (int) r107;
        this.f541200c = -40.0f;
        goto L31
    L23:
        if ((r109 + r108) <= r107) goto L26;
        r107 = r108 + r102;
    L31:
        float r110 = this.f541200c;
        if (r110 >= 0.0f) goto L34;
        this.f541200c = r110 + 20.0f;
    L35:
        this.f541199b.getClass();
        this.f541199b.f420361b.sendEmptyMessage(1000);
        return;
    L34:
        this.f541200c = r110 - 20.0f;
        goto L35
    L14:
        if (Math.abs(this.f541200c) > 20.0f) goto L17;
        this.f541199b.a();
        this.f541199b.f420361b.sendEmptyMessage(2000);
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
        this.f541199b = r100;
        this.f541198a = r101;
        this.f541200c = 2.1474836E9f;
    }
}
