package oj7;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements ni7.b.a, c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f523591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f523592b;

    @Override // oj7.c.b
    public final void a() {
    }

    public final void b() {
        this.f523591a.getClass();
        c.b(true);
        c r100 = this.f523591a;
        r100.getClass();
        r100.f523586a = new WeakReference(this);
        a r101 = this.f523592b;
        r101.f523582a++;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", " ILuckyCatPage screenIncrement, currentCnt = " + r101.f523582a);
        r101.a();
    }

    public final void c() {
        this.f523591a.getClass();
        c.b(false);
        a r100 = this.f523592b;
        r100.f523582a--;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyMonitor", " ILuckyCatPage screenDecrement, currentCnt = " + r100.f523582a);
        r100.a();
    }

    public g(c r100, a r101) {
        this.f523591a = r100;
        this.f523592b = r101;
    }
}
