package mh5;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public static final a<T> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        Set r6 = (Set) e.a.a("cache_new_document", new LinkedHashSet());
        if (hu5.a.f(r6) == false) goto L8;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        String r0 = (String) r7.next();
        e.c.put(r0, Boolean.TRUE);
        goto L6
    L10:
        return;
    }
}
