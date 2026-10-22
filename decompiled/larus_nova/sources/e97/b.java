package e97;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static <E> String a(Collection<E> r100) {
        if (r100 != null) goto L4;
        return "[]";
    L4:
        if (r100.size() == 0) goto L23;
        StringBuilder r101 = new StringBuilder("[\n");
        Iterator<E> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        E r103 = r102.next();
        if (r102.hasNext() == true) goto L11;
        r101.append(r103.toString());
        r101.append("\n");
        goto L8
    L11:
        r101.append(r103.toString());
        r101.append(", \n");
        goto L8
    L13:
        r101.append("]");
        return r101.toString();
    L23:
        return "[]";
    }
}
