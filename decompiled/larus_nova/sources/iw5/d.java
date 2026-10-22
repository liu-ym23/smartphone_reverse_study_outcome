package iw5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final boolean a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        b r101 = r100.f496228e;
        if (r101 == null) goto L17;
        List<a> r102 = r101.f496222b;
        if (r102 == null) goto L18;
        a r103 = (a) CollectionsKt.firstOrNull(r102);
        if (r103 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r103.getType(), "music") == true) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 != true) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (Intrinsics.areEqual(r103.f496218b, "music") == false) goto L13;
        r104 = true;
        goto L14
    L18:
        return false;
    L17:
        return false;
    }
}
