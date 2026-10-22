package y28;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static boolean a(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static <T extends b> boolean b(List<T> r100, List<T> r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        if (r100.size() == r101.size()) goto L12;
        return false;
    L12:
        Iterator<T> r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L23;
        T r103 = r102.next();
        Iterator<T> r104 = r101.iterator();
        boolean r105 = false;
    L17:
        if (r104.hasNext() == false) goto L21;
        if (c(r103, r104.next()) == false) goto L17;
        r105 = true;
        goto L17
    L21:
        if (r105 == true) goto L14;
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static <T extends b> boolean c(b<T> r100, T r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 == null) goto L13;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r100.getClass() == r101.getClass()) goto L12;
        return false;
    L12:
        return r100.isContentSame(r101);
    L13:
        return false;
    }
}
