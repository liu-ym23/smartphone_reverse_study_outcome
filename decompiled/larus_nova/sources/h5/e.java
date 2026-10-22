package h5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final int a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "otherVersion");
        List r112 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        List r113 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
        int r100 = Math.max(r112.size(), r113.size());
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L20;
        String r102 = (String) CollectionsKt.getOrNull(r112, r101);
        if (r102 == null) goto L9;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        String r105 = (String) CollectionsKt.getOrNull(r113, r101);
        if (r105 == null) goto L15;
        Integer r106 = StringsKt.toIntOrNull(r105);
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L16:
        if (r104 != r107) goto L18;
        r101 = r101 + 1;
        goto L3
    L18:
        return Intrinsics.compare(r104, r107);
    L15:
        r107 = 0;
    L9:
        r104 = 0;
        goto L10
    L20:
        return 0;
    }
}
