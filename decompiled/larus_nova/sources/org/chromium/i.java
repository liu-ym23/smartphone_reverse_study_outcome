package org.chromium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static List a(Class r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
    L6:
        if (r100 == null) goto L21;
        Class<?>[] r102 = r100.getInterfaces();
        int r103 = 0;
    L9:
        if (r103 >= r102.length) goto L20;
        if (r101.contains(r102[r103]) == true) goto L13;
        r101.add(r102[r103]);
    L13:
        Iterator r104 = a(r102[r103]).iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Class r105 = (Class) r104.next();
        if (r101.contains(r105) == true) goto L15;
        r101.add(r105);
        goto L15
    L19:
        r103 = r103 + 1;
        goto L9
    L20:
        r100 = r100.getSuperclass();
        goto L6
    L21:
        return r101;
    }
}
