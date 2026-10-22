package lz4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements Runnable {
    public final /* synthetic */ w a;

    public final void a() {
        this.a.c();
        if (this.a.s == false) goto L6;
        tt5.a.d("ScreenshotV2", "onSuccess has Release");
        return;
    L6:
        this.a.e();
        if (this.a.e.toFile().exists() == false) goto L9;
        w r0 = this.a;
        ((jz4.i) r0.d).c(r0.e, r0.o, r0.n);
    L10:
        this.a.n = 0;
        return;
    L9:
        w r1 = this.a;
        ((jz4.i) r1.d).a("File not exists!", r1.n);
        tt5.a.d("ScreenshotV2", "onSuccess, but file not exists: path = " + this.a.e.getRealPath());
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

    public v(w r1) {
        this.a = r1;
    }
}
