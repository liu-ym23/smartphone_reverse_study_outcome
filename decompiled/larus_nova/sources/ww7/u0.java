package ww7;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class u0<TResult> implements y<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f561716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0<TResult> f561717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f561718c;

    @Override // ww7.y
    public final void a(e r100) {
        if (r100.f() == false) goto L6;
        r100.e();
        this.f561716a.execute(new s0(this, r100));
        return;
    }

    public u0(Executor r100, w0 r101) {
        this.f561718c = new Object();
        this.f561717b = r101;
        this.f561716a = r100;
    }
}
