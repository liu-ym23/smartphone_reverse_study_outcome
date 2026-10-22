package dg5;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.facade.common.widget.d f468490a;

    public /* synthetic */ t(com.bytedance.ee.bear.facade.common.widget.d r100) {
        this.f468490a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.facade.common.widget.d r100 = this.f468490a;
        com.bytedance.ee.bear.facade.common.widget.d.b r101 = r100.f226593h;
        if (r101 == null) goto L6;
        r101.a(r100.c());
        return;
    }
}
