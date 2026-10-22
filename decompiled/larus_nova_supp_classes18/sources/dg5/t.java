package dg5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.facade.common.widget.d a;

    public /* synthetic */ t(com.bytedance.ee.bear.facade.common.widget.d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.facade.common.widget.d r0 = this.a;
        com.bytedance.ee.bear.facade.common.widget.d.b r1 = r0.h;
        if (r1 == null) goto L6;
        r1.a(r0.c());
        return;
    }
}
