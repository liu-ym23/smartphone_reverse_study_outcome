package e76;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f471186a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.f471186a.f471193g != null) goto L5;
        return;
    L5:
        if (this.f471186a.f471192f.isCancelled() == true) goto L23;
        c<T> r100 = this.f471186a.f471193g;
        V r101 = r100.f471184a;
        if (r101 == 0) goto L13;
        e r102 = this.f471186a;
        r102.getClass();
        Iterator r103 = new ArrayList(r102.f471189c).iterator();
    L11:
        if (r103.hasNext() == false) goto L25;
        ((b) r103.next()).onResult(r101);
        goto L11
    L25:
        return;
    L13:
        e r104 = this.f471186a;
        Throwable r105 = r100.f471185b;
        r104.getClass();
        ArrayList r106 = new ArrayList(r104.f471190d);
        if (r106.isEmpty() == true) goto L24;
        Iterator r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L26;
        ((b) r107.next()).onResult(r105);
        goto L18
    L26:
        return;
    L24:
        return;
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

    public d(e r100) {
        this.f471186a = r100;
    }
}
