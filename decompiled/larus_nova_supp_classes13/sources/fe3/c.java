package fe3;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.shopping.deepfeed.data.repo.h;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(h r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    L3:
        if (b.d == true) goto L6;
        MessageQueue r0 = Looper.myQueue();     // Catch: Throwable -> L8
        b.a r1 = b.b;     // Catch: Throwable -> L8
        r0.removeIdleHandler(r1);     // Catch: Throwable -> L8
        Looper.myQueue().addIdleHandler(r1);     // Catch: Throwable -> L8
        b.d = true;     // Catch: Throwable -> L8
    L6:
        a r2 = this.a;     // Catch: Throwable -> L8
        String r3 = r2.a;     // Catch: Throwable -> L8
        b.c.offer(r2);     // Catch: Throwable -> L8
    }
}
