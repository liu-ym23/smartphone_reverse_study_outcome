package t3b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements e<u3b.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f544541a;

    public b() {
        this.f544541a = new AtomicInteger(0);
    }

    @Override // t3b.e
    public final String a(u3b.a r100) {
        return ((u3b.c) r100).a() + "_" + this.f544541a.get();
    }

    @Override // t3b.e
    public final String b(u3b.a r100) {
        return ((u3b.c) r100).a() + "_" + this.f544541a.incrementAndGet();
    }
}
