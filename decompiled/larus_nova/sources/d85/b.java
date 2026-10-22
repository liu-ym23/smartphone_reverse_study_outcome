package d85;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements d {
    public b() {
    }

    @Override // d85.d
    public final boolean a(w75.c<?> r100, w75.c<?> r101) {
        Boolean r102 = Boolean.valueOf(r100.C());
        Boolean r103 = Boolean.valueOf(r101.C());
        if (r102 == null) goto L8;
        if (r103 != null) goto L7;
        return false;
    L7:
        return !Intrinsics.areEqual(r102, r103);
    L8:
        return false;
    }
}
