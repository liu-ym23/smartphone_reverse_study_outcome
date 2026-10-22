package q38;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {
    public static final c a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        p r101 = r100.c();
        if (r101 == null) goto L9;
        List<c> r102 = r101.a();
        if (r102 == null) goto L9;
        List r103 = CollectionsKt.filterNotNull(r102);
        if (r103 == null) goto L9;
        return (c) CollectionsKt.firstOrNull(r103);
    L9:
        return null;
    }
}
