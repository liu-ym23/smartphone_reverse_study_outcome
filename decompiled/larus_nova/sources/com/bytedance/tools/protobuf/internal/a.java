package com.bytedance.tools.protobuf.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f271025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a> f271026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, b<?>> f271027d;

    /* JADX INFO: renamed from: com.bytedance.tools.protobuf.internal.a$a, reason: collision with other inner class name */
    public static final class C3799a {
    }

    static {
    }

    public a(String r100, Set<String> r101, Map<String, a> r102, List<? extends b<?>> r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "keeps");
        Intrinsics.checkNotNullParameter(r102, "children");
        Intrinsics.checkNotNullParameter(r103, "options");
        this.f271024a = r100;
        this.f271025b = r101;
        this.f271026c = r102;
        List<? extends b<?>> r104 = r103;
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        b r108 = (b) r107;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if ((r108 instanceof b.d) == false) goto L9;
        String r109 = "config";
    L14:
        r105.put(r109, r107);
        goto L4
    L9:
        if ((r108 instanceof b.C3800b) == false) goto L12;
        r109 = "map_keys";
        goto L14
    L12:
        if ((r108 instanceof b.c) == false) goto L16;
        r109 = "map_values";
        goto L14
    L16:
        throw new IllegalStateException(("unknown option " + r108.a()).toString());
    L17:
        this.f271027d = r105;
    }
}
