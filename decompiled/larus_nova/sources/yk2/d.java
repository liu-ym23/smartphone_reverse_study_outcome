package yk2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class d {
    public d() {
    }

    public abstract <T> T a();

    public abstract List<String> b();

    public final int hashCode() {
        List<String> r100 = b();
        if (r100 == null) goto L7;
        String r101 = (String) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L7;
        return r101.hashCode();
    L7:
        return 0;
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof d) == false) goto L17;
        List<String> r101 = b();
        String r102 = null;
        if (r101 == null) goto L9;
        String r103 = (String) CollectionsKt.firstOrNull(r101);
    L10:
        List<String> r104 = ((d) r100).b();
        if (r104 == null) goto L14;
        r102 = (String) CollectionsKt.firstOrNull(r104);
    L14:
        return Intrinsics.areEqual(r103, r102);
    L9:
        r103 = null;
        goto L10
    L17:
        return false;
    }
}
