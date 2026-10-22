package pj5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final ConcurrentHashMap<String, ArrayList<qj5.b>> a = null;

    @JvmStatic
    public static final int a(int r2) {
        if (r2 != 0) goto L5;
        return 2131888838;
    L5:
        if (r2 != 1) goto L7;
        return 2131888836;
    L7:
        if (r2 != 2) goto L9;
        return 2131888841;
    L9:
        if (r2 != 3) goto L18;
        return 2131888852;
    L18:
        return 2131888838;
    }

    static {
        a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final void b(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        ArrayList<qj5.b> r2 = a.get(r1);
        if (r2 == null) goto L10;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        ((qj5.b) r3.next()).onDocFreshNessChange();
        goto L8
    L12:
        return;
    }
}
