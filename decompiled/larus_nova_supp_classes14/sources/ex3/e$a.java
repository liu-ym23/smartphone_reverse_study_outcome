package ex3;

import com.bytedance.applog.log.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e$a implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ Thread.UncaughtExceptionHandler a;
    public final /* synthetic */ e b;

    public e$a(e r1, Thread.UncaughtExceptionHandler r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r7, Throwable r8) {
        n.w().r(8, e.m, "monitor thread crash!", r8, new Object[0]);
        if (this.b.a.o == false) goto L8;
        Thread.UncaughtExceptionHandler r0 = this.a;
        if (r0 == null) goto L9;
        r0.uncaughtException(r7, r8);
        return;
    L9:
        return;
    }
}
