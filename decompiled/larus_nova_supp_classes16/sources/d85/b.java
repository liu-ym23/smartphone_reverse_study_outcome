package d85;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements d {
    public b() {
    }

    @Override // d85.d
    public final boolean a(w75.c<?> r1, w75.c<?> r2) {
        Boolean r3 = Boolean.valueOf(r1.C());
        Boolean r4 = Boolean.valueOf(r2.C());
        if (r3 == null) goto L8;
        if (r4 != null) goto L7;
        return false;
    L7:
        return !Intrinsics.areEqual(r3, r4);
    L8:
        return false;
    }
}
