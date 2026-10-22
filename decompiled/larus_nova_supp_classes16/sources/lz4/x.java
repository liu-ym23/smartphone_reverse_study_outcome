package lz4;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ w c;

    @Override // java.lang.Runnable
    public final void run() {
        w r0 = this.c;     // Catch: Throwable -> L7
        WebView r1 = r0.c;     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        r1.scrollTo(0, this.a * r0.i);     // Catch: Throwable -> L7
    L5:
        this.b.countDown();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public x(w r1, int r2, CountDownLatch r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
