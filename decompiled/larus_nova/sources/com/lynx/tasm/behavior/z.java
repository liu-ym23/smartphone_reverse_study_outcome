package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f383224b;

    public final void a() {
        Iterator<u> r100 = this.f383224b.f382001v.iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        u r101 = r100.next();
        if (r101.f382317a != this.f383223a) goto L4;
        this.f383224b.f382001v.remove(r101);
        d0 r102 = this.f383224b;
        if (r102.f382004y == true) goto L10;
        return;
    L10:
        if (r102.f382001v.isEmpty() == false) goto L17;
        this.f383224b.c();
        return;
    L17:
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

    public z(d0 r100, int r101) {
        this.f383224b = r100;
        this.f383223a = r101;
    }
}
