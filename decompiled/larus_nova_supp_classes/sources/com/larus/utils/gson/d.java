package com.larus.utils.gson;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final d a = null;
    public static volatile e b;

    static {
        a = new d();
    }

    public d() {
    }

    public static void a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "any");
        Intrinsics.checkNotNullParameter(r3, "typeName");
        if ((r2 instanceof Map) == false) goto L18;
        Map r4 = (Map) r2;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r3, "typeName");
        if (r4.isEmpty() == true) goto L51;
        Iterator r5 = r4.entrySet().iterator();
        if (TypeIntrinsics.isMutableIterator(r5) == true) goto L10;
        return;
    L10:
        if (r5.hasNext() == false) goto L53;
        Object r0 = ((Map.Entry) r5.next()).getValue();
        if (r0 == null) goto L13;
        a(r0, r3);
        goto L10
    L13:
        r5.remove();
        e r1 = b;
        if (r1 == null) goto L10;
        r1.a(r3);
        goto L10
    L53:
        return;
    L51:
        return;
    L18:
        if ((r2 instanceof Collection) == false) goto L49;
        Collection r6 = (Collection) r2;
        Intrinsics.checkNotNullParameter(r6, "collection");
        Intrinsics.checkNotNullParameter(r3, "typeName");
        if (r6.isEmpty() == true) goto L52;
        Iterator r7 = r6.iterator();
        if (TypeIntrinsics.isMutableIterator(r7) == true) goto L25;
        return;
    L25:
        if (r7.hasNext() == false) goto L54;
        Object r8 = r7.next();
        if (r8 == null) goto L28;
        a(r8, r3);
        goto L25
    L28:
        r7.remove();
        e r9 = b;
        if (r9 == null) goto L25;
        r9.a(r3);
        goto L25
    L54:
        return;
    L52:
        return;
    }
}
