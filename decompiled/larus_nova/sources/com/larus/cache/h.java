package com.larus.cache;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f321289a;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("WeakHostRunnable", "error " + th);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public h(T r100) {
        this.f321289a = new WeakReference(r100);
    }
}
