package ji3;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ i a;

    public j(i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        Iterator<i.a> r2 = this.a.d.iterator();     // Catch: Throwable -> L12
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().onTick();     // Catch: Throwable -> L12
        goto L4
    L6:
        long r3 = SystemClock.elapsedRealtime() - r0;     // Catch: Throwable -> L12
        i r1 = this.a;     // Catch: Throwable -> L12
        long r4 = r1.e;     // Catch: Throwable -> L12
        if (r3 > r4) goto L10;
        r4 = r4 - r3;     // Catch: Throwable -> L12
    L10:
        r1.a(r4);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
