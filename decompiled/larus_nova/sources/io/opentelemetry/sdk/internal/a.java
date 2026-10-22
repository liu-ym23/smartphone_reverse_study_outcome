package io.opentelemetry.sdk.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static Object a(Object r100, int r101) {
        if (r101 != Integer.MAX_VALUE) goto L6;
        return r100;
    L6:
        if ((r100 instanceof List) == false) goto L13;
        List r102 = (List) r100;
        ArrayList r103 = new ArrayList(r102.size());
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        r103.add(a(r104.next(), r101));
        goto L9
    L11:
        return r103;
    L13:
        if ((r100 instanceof String) == false) goto L20;
        String r105 = (String) r100;
        if (r105.length() >= r101) goto L18;
        return r100;
    L18:
        return r105.substring(0, r101);
    L20:
        return r100;
    }
}
