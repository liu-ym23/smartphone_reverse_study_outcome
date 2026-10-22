package nu3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public a() {
    }

    /* JADX INFO: Infinite loop detected, blocks: 67, insns: 0 */
    public static void a() {
    L43:
        c r100 = (c) ((LinkedTransferQueue) b.f520604c).take();     // Catch: Throwable -> L37
        Iterator r101 = ((CopyOnWriteArrayList) b.f520603b).iterator();     // Catch: Throwable -> L37
        boolean r102 = false;
    L5:
        if (r101.hasNext() == false) goto L19;
        e r103 = (e) r101.next();     // Catch: Throwable -> L37
    L15:
        th = move-exception;
        if (xu3.a.a() == false) goto L5;
        av3.b.c("APM-Monitor", "interceptor throws a Throwable", th);     // Catch: Throwable -> L37
        goto L5
    L8:
        if (r103.shouldIntercept() == false) goto L5;
        r102 = true;
        if (xu3.a.a() == false) goto L19;
        r103.getClass().toString();     // Catch: Throwable -> L15
        Objects.toString(r100);     // Catch: Throwable -> L15
        av3.a r104 = av3.b.f16366a;     // Catch: Throwable -> L15
        if (r104 == null) goto L19;
        r104.a();     // Catch: Throwable -> L15
    L19:
        if (r102 == true) goto L43;
        Iterator r105 = ((CopyOnWriteArrayList) b.f520602a).iterator();     // Catch: Throwable -> L37
    L23:
        if (r105.hasNext() == false) goto L43;
        d r106 = (d) r105.next();     // Catch: Throwable -> L37
    L26:
        if (r100.isValid() == true) goto L27;
        if (xu3.a.a() == false) goto L23;
        r100.toString();     // Catch: Throwable -> L34
        av3.a r107 = av3.b.f16366a;     // Catch: Throwable -> L34
        if (r107 == null) goto L23;
        r107.a();     // Catch: Throwable -> L34
        goto L23
    L27:
        r106.a(r100);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        av3.b.c("APM-Monitor", "monitorableHandler " + r106 + " handle monitorable " + r100 + "failed.", th);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        av3.b.c("APM", "record error", th);
        goto L43
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
