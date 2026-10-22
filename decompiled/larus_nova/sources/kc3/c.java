package kc3;

import androidx.arch.core.executor.ArchTaskExecutor;

/* JADX INFO: loaded from: classes13.dex */
public final class c<T> extends b<T> {
    public c() {
    }

    public final void f(T r100, boolean r101) {
        Object r102 = this.f502393a;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f502398f != b.f502392j) goto L7;
        boolean r103 = true;
    L8:
        this.f502398f = r100;     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        if (r103 == false) goto L19;
        ArchTaskExecutor.getInstance().postToMainThread(new a(this, r101));
        return;
    L19:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
