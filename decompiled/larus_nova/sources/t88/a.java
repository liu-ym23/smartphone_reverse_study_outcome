package t88;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static final boolean b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.h() != 3) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        return false;
    L8:
        if (a(r100, 8) == false) goto L10;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public static final boolean a(n r100, int r101) {
        List<b> r102 = r100.c();
        if (r102 == null) goto L31;
        List<b> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L8;
        b r105 = (b) r104.next();
        if (r105 == null) goto L20;
        Integer r106 = r105.b();
        if (r106 == null) goto L20;
        if (r106.intValue() != r101) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L11;
        boolean r108 = true;
    L23:
        if (r108 != true) goto L32;
        return true;
    L32:
        return false;
    L20:
        r107 = false;
    L8:
        r108 = false;
        goto L23
    L7:
        if (r103.isEmpty() == false) goto L9;
    L31:
        return false;
    }
}
