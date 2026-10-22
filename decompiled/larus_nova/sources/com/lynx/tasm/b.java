package com.lynx.tasm;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f381827a;

    @Override // java.lang.Runnable
    public final void run() {
        SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        Iterator r100 = this.f381827a.iterator();     // Catch: Throwable -> L11
    L5:
        if (r100.hasNext() == false) goto L9;
        a r101 = ((com.lynx.tasm.behavior.a) r100.next()).createClassWarmer();     // Catch: Throwable -> L11
        if (r101 == null) goto L5;
        r101.a();     // Catch: Throwable -> L11
        goto L5
    L9:
        SystemClock.uptimeMillis();     // Catch: Throwable -> L11
    L28:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L18;
        return;
    L18:
        throw th;
    }

    public b(List r100) {
        this.f381827a = r100;
    }
}
