package ws7;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes22.dex */
public final class t {
    public static boolean a(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if ("".equals(r100.trim()) == true) goto L7;
        return false;
    }

    public static String b(Collection r100) {
        if (r100 != null) goto L4;
    L15:
        return "";
    L4:
        if (r100.isEmpty() == true) goto L15;
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (r103 == null) goto L7;
        r101.append(r103.toString());
        r101.append(",");
        goto L7
    L11:
        int r104 = r101.lastIndexOf(",");
        if ((-1) == r104) goto L22;
        r101.delete(r104, r101.length());
    L22:
        return r101.toString();
    }
}
