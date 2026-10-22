package kc3;

import androidx.arch.core.executor.ArchTaskExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> extends b<T> {
    public c() {
    }

    public final void f(T r4, boolean r5) {
        Object r0 = this.a;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f != b.j) goto L7;
        boolean r1 = true;
    L8:
        this.f = r4;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 == false) goto L19;
        ArchTaskExecutor.getInstance().postToMainThread(new a(this, r5));
        return;
    L19:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
