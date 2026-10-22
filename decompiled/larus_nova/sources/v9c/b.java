package v9c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends a {
    public b(o9c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        super(r100);
    }

    @Override // v9c.a, v9c.e
    public String update(q9c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        String r101 = r100.f532196c;
        if (r101 == null) goto L5;
        this.f553910a.set(r100, r101);
    L6:
        return r101;
    L5:
        this.f553910a.remove(r100);
        goto L6
    }
}
