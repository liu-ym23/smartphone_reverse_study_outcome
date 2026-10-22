package yk2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class d {
    public d() {
    }

    public abstract <T> T a();

    public abstract List<String> b();

    public final int hashCode() {
        List<String> r0 = b();
        if (r0 == null) goto L7;
        String r1 = (String) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        return r1.hashCode();
    L7:
        return 0;
    }

    public final boolean equals(Object r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if ((r3 instanceof d) == false) goto L17;
        List<String> r0 = b();
        String r1 = null;
        if (r0 == null) goto L9;
        String r2 = (String) CollectionsKt.firstOrNull(r0);
    L10:
        List<String> r4 = ((d) r3).b();
        if (r4 == null) goto L14;
        r1 = (String) CollectionsKt.firstOrNull(r4);
    L14:
        return Intrinsics.areEqual(r2, r1);
    L9:
        r2 = null;
        goto L10
    L17:
        return false;
    }
}
