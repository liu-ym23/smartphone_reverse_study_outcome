package v;

import bolts.Task;

/* JADX INFO: loaded from: classes28.dex */
public class e<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Task<TResult> f552273a;

    public final void a() {
        if (this.f552273a.trySetCancelled() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot cancel a completed task.");
    }

    public e() {
        this.f552273a = new Task();
    }

    public final void b(Exception r100) {
        if (this.f552273a.trySetError(r100) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public void setResult(TResult r100) {
        if (this.f552273a.trySetResult(r100) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }
}
