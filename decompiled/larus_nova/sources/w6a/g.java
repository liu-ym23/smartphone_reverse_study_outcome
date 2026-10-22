package w6a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class g implements h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f558462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.c f558463b;

    @Override // w6a.h.c
    public final void a() {
        if (this.f558462a.decrementAndGet() != 0) goto L8;
        h.c r100 = this.f558463b;
        if (r100 == null) goto L9;
        r100.a();
        return;
    L9:
        return;
    }

    public g(AtomicInteger r100, x7a.d.a r101) {
        this.f558462a = r100;
        this.f558463b = r101;
    }
}
