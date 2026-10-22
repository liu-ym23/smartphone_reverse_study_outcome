package v9c;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends a {
    public c(o9c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        super(r100);
    }

    @Override // v9c.a, v9c.e
    public String update(q9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        AtomicInteger r101 = (AtomicInteger) this.f553910a.get(r100);
        if (r101 == null) goto L5;
        r101.incrementAndGet();
    L7:
        return String.valueOf(r101);
    L5:
        AtomicInteger r102 = new AtomicInteger(1);
        this.f553910a.set(r100, r102);
        goto L7
    }
}
