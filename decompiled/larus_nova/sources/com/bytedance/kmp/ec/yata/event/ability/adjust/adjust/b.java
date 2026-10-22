package com.bytedance.kmp.ec.yata.event.ability.adjust.adjust;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f251567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Map<String, String>> f251568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<List<String>, List<String>>> f251569c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f251567a, r101.f251567a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251568b, r101.f251568b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f251567a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f251568b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "IncrementalSource(dataSource=" + this.f251567a + ", dataMergeParams=" + this.f251568b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<String, ? extends Object> r110, List<? extends Map<String, String>> r111) {
        Intrinsics.checkNotNullParameter(r111, "dataMergeParams");
        this.f251567a = r110;
        this.f251568b = r111;
        List<? extends Map<String, String>> r112 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L4:
        if (r114.hasNext() == false) goto L16;
        Map r100 = (Map) r114.next();
        String r101 = (String) r100.get("source_path");
        if (r101 == null) goto L9;
        List r102 = StringsKt.split$default(r101, new String[]{"."}, false, 0, 6, null);
        if (r102 == null) goto L9;
    L10:
        String r103 = (String) r100.get("target_path");
        if (r103 == null) goto L14;
        List r104 = StringsKt.split$default(r103, new String[]{"."}, false, 0, 6, null);
        if (r104 == null) goto L14;
    L15:
        r113.add(TuplesKt.to(r102, r104));
    L14:
        r104 = CollectionsKt.emptyList();
    L9:
        r102 = CollectionsKt.emptyList();
        goto L10
    L16:
        this.f251569c = r113;
    }
}
