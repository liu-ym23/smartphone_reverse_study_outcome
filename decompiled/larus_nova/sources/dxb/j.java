package dxb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f470479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f470480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f470481e;

    public j(cxb.a r100, boolean r101, int r102, String r103, String r104) {
        this.f470477a = r100;
        this.f470478b = r101;
        this.f470479c = r102;
        this.f470480d = r103;
        this.f470481e = r104;
    }

    public final void a() {
        g r100 = new g("wb_load_duration", c.f470467l, this.f470477a);
        r100.a("is_first_page", Boolean.valueOf(this.f470478b));
        r100.a("result_code", Integer.valueOf(this.f470479c));
        r100.a("duration", this.f470480d);
        t.c(r100, this.f470481e);
        r100.b();
    }

    @Override // java.lang.Runnable
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
}
