package ww7;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class q0<TResult> implements y<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f561693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f561694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f561695c;

    @Override // ww7.y
    public final void a(e r100) {
        if (r100.f() == true) goto L6;
        r100.e();
        this.f561693a.execute(new o0(this, r100));
        return;
    }

    public q0(Executor r100, w0 r101) {
        this.f561695c = new Object();
        this.f561694b = r101;
        this.f561693a = r100;
    }
}
