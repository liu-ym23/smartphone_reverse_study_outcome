package v9c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends a {
    public d(o9c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        super(r100);
    }

    @Override // v9c.a, v9c.e
    public final String a(q9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        Long r101 = (Long) this.f553910a.get(r100);
        if (r101 == null) goto L5;
        r101.longValue();
        long r102 = System.currentTimeMillis() - r101.longValue();
    L7:
        return String.valueOf(r102);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // v9c.a, v9c.e
    public String update(q9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        Long r101 = (Long) this.f553910a.get(r100);
        if (r101 == null) goto L5;
        r101.longValue();
        long r102 = System.currentTimeMillis() - r101.longValue();
    L7:
        return String.valueOf(r102);
    L5:
        long r103 = Long.valueOf(System.currentTimeMillis()).longValue();
        this.f553910a.set(r100, Long.valueOf(r103));
        r102 = 0;
        goto L7
    }
}
