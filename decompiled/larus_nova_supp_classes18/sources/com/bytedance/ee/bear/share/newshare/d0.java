package com.bytedance.ee.bear.share.newshare;

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
public final class d0 {
    public static final d0 d = null;
    public final List<e0> a;
    public final List<e0> b;
    public final Map<String, Integer> c;

    public static final class a {
    }

    static {
        d = new d0(CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(List<? extends e0> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        this.a = r5;
        List<e0> r6 = CollectionsKt.toMutableList(r5);
        this.b = r6;
        List<e0> r7 = r6;
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
        r0.add(TuplesKt.to(((e0) r2).a, Integer.valueOf(r1)));
        r1 = r3;
        goto L4
    L9:
        this.c = MapsKt.toMap(r0);
    }

    public final e0 a(int r2) {
        return (e0) ListProtector.get(this.b, r2);
    }
}
