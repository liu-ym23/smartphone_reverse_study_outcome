package iz4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f496678a;

    public final void a() {
        this.f496678a.c();
        if (this.f496678a.f496686r == false) goto L6;
        tt5.a.d("ScreenshotV2", "onSuccess has Release");
        return;
    L6:
        this.f496678a.e();
        if (this.f496678a.f496634e.toFile().exists() == false) goto L9;
        w r100 = this.f496678a;
        ((fz4.x) r100.f496633d).c(r100.f496634e, r100.f496682n, r100.f496681m);
    L10:
        this.f496678a.f496681m = 0;
        return;
    L9:
        w r101 = this.f496678a;
        ((fz4.x) r101.f496633d).a("File not exists!", r101.f496681m);
        tt5.a.d("ScreenshotV2", "onSuccess, but file not exists: path = " + this.f496678a.f496634e.getRealPath());
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
        this.f496678a = r100;
    }
}
