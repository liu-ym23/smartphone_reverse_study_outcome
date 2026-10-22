package com.larus.utils.gson;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f375407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f375408b;

    static {
        f375407a = new d();
    }

    public d() {
    }

    public static void a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "any");
        Intrinsics.checkNotNullParameter(r101, "typeName");
        if ((r100 instanceof Map) == false) goto L18;
        Map r102 = (Map) r100;
        Intrinsics.checkNotNullParameter(r102, "map");
        Intrinsics.checkNotNullParameter(r101, "typeName");
        if (r102.isEmpty() == true) goto L51;
        Iterator r103 = r102.entrySet().iterator();
        if (TypeIntrinsics.isMutableIterator(r103) == true) goto L10;
        return;
    L10:
        if (r103.hasNext() == false) goto L53;
        Object r104 = ((Map.Entry) r103.next()).getValue();
        if (r104 == null) goto L13;
        a(r104, r101);
        goto L10
    L13:
        r103.remove();
        e r105 = f375408b;
        if (r105 == null) goto L10;
        r105.a(r101);
        goto L10
    L53:
        return;
    L51:
        return;
    L18:
        if ((r100 instanceof Collection) == false) goto L49;
        Collection r106 = (Collection) r100;
        Intrinsics.checkNotNullParameter(r106, "collection");
        Intrinsics.checkNotNullParameter(r101, "typeName");
        if (r106.isEmpty() == true) goto L52;
        Iterator r107 = r106.iterator();
        if (TypeIntrinsics.isMutableIterator(r107) == true) goto L25;
        return;
    L25:
        if (r107.hasNext() == false) goto L54;
        Object r108 = r107.next();
        if (r108 == null) goto L28;
        a(r108, r101);
        goto L25
    L28:
        r107.remove();
        e r109 = f375408b;
        if (r109 == null) goto L25;
        r109.a(r101);
        goto L25
    L54:
        return;
    L52:
        return;
    }
}
