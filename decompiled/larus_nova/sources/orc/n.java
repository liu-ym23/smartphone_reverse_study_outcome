package orc;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class n {
    public static final boolean a(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "pattern");
        if (r101.isEmpty() == false) goto L7;
        return r100.isEmpty();
    L7:
        if (r100.isEmpty() == true) goto L9;
        String r102 = (String) CollectionsKt.first(r100);
        String r103 = (String) CollectionsKt.first(r101);
        if (Intrinsics.areEqual(r103, "*") == false) goto L29;
        return a(r100.subList(1, r100.size()), r101.subList(1, r101.size()));
    L29:
        if (Intrinsics.areEqual(r103, "**") == false) goto L36;
        if (a(r100.subList(1, r100.size()), r101) == false) goto L33;
    L34:
        return true;
    L33:
        if (a(r100, r101.subList(1, r101.size())) == true) goto L34;
        return false;
    L36:
        if (Intrinsics.areEqual(r103, r102) == true) goto L38;
        return false;
    L38:
        if (a(r100.subList(1, r100.size()), r101.subList(1, r101.size())) == true) goto L34;
        return false;
    L9:
        if (r101.isEmpty() == false) goto L11;
        return true;
    L11:
        List<String> r104 = r101;
        if ((r104 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L15;
        if (Intrinsics.areEqual((String) r105.next(), "**") == true) goto L18;
        boolean r106 = false;
    L22:
        if (r106 == false) goto L24;
        return true;
    L24:
        return false;
    L15:
        r106 = true;
        goto L22
    L14:
        if (r104.isEmpty() == false) goto L16;
        goto L15
    }
}
