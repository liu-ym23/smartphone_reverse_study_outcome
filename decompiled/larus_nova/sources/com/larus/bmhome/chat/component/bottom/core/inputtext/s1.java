package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t1> f299156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q1> f299157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, t1> f299158c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s1) == true) goto L8;
        return false;
    L8:
        s1 r101 = (s1) r100;
        if (Intrinsics.areEqual(this.f299156a, r101.f299156a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299157b, r101.f299157b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f299156a.hashCode() * 31) + this.f299157b.hashCode();
    }

    public final String toString() {
        return "SkillPanelSearchResult(matches=" + this.f299156a + ", groups=" + this.f299157b + ')';
    }

    public s1(List<t1> r100, List<q1> r101) {
        Intrinsics.checkNotNullParameter(r100, "matches");
        Intrinsics.checkNotNullParameter(r101, "groups");
        this.f299156a = r100;
        this.f299157b = r101;
        List<t1> r102 = r100;
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Object r105 = r104.next();
        r103.put(((t1) r105).f299232a.f18744a, r105);
        goto L4
    L6:
        this.f299158c = r103;
    }
}
