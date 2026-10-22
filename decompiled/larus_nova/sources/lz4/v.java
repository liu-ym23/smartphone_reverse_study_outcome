package lz4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f511415a;

    public final void a() {
        this.f511415a.c();
        if (this.f511415a.f511423s == false) goto L6;
        tt5.a.d("ScreenshotV2", "onSuccess has Release");
        return;
    L6:
        this.f511415a.e();
        if (this.f511415a.f511369e.toFile().exists() == false) goto L9;
        w r100 = this.f511415a;
        ((jz4.i) r100.f511368d).c(r100.f511369e, r100.f511419o, r100.f511418n);
    L10:
        this.f511415a.f511418n = 0;
        return;
    L9:
        w r101 = this.f511415a;
        ((jz4.i) r101.f511368d).a("File not exists!", r101.f511418n);
        tt5.a.d("ScreenshotV2", "onSuccess, but file not exists: path = " + this.f511415a.f511369e.getRealPath());
        goto L10
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

    public v(w r100) {
        this.f511415a = r100;
    }
}
