package dv7;

import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes23.dex */
public final class s<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f470197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Queue<r<TResult>> f470198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f470199c;

    public s() {
        this.f470197a = new Object();
    }

    public final void a(Task<TResult> r100) {
        Object r101 = this.f470197a;
        monitor-enter(r101);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.f470198b != null) goto L7;
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L7:
        if (this.f470199c == true) goto L23;
        this.f470199c = true;     // Catch: Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
    L11:
        Object r102 = this.f470197a;
        monitor-enter(r102);
        r r103 = (r) ((ArrayDeque) this.f470198b).poll();     // Catch: Throwable -> L20
        if (r103 == null) goto L15;
        monitor-exit(r102);     // Catch: Throwable -> L20
        r103.onComplete(r100);
        goto L11
    L15:
        this.f470199c = false;     // Catch: Throwable -> L20
        monitor-exit(r102);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void b(r<TResult> r100) {
        Object r101 = this.f470197a;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f470198b != null) goto L7;
        this.f470198b = new ArrayDeque();     // Catch: Throwable -> L10
    L7:
        ((ArrayDeque) this.f470198b).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }
}
