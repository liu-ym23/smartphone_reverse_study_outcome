package w6a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f558460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.b f558461b;

    public final void a() {
        if (this.f558460a.decrementAndGet() != 0) goto L8;
        h.b r100 = this.f558461b;
        if (r100 == null) goto L9;
        ((f) r100).a();
        return;
    L9:
        return;
    }

    public f(AtomicInteger r100) {
        this.f558460a = r100;
        this.f558461b = null;
    }
}
