package com.bytedance.ee.bear.more.protocol3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final i c = null;
    public final List<k> a;
    public final Map<String, Integer> b;

    public static final class a {
    }

    static {
        c = new i(CollectionsKt.emptyList());
    }

    public i(List<? extends k> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        List<k> r6 = CollectionsKt.toMutableList(r5);
        this.a = r6;
        List<k> r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r0.add(TuplesKt.to(((k) r2).a, Integer.valueOf(r1)));
        r1 = r3;
        goto L4
    L9:
        this.b = MapsKt.toMap(r0);
    }

    public final k a(int r2) {
        return (k) ListProtector.get(this.a, r2);
    }
}
