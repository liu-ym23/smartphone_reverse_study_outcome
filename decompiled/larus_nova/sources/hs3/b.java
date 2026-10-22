package hs3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f486964a;

    public final void a() {
        AbstractCollection r100 = this.f486964a.f486958a;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList(this.f486964a.f486958a);     // Catch: Throwable -> L11
        this.f486964a.f486958a.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        c r103 = (c) r102.next();
        this.f486964a.c(r103);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
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

    public b(a r100) {
        this.f486964a = r100;
    }
}
