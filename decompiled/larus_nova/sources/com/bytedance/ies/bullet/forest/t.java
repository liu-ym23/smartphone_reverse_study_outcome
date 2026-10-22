package com.bytedance.ies.bullet.forest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u> f246766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f246768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246769d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f246766a, r101.f246766a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246767b, r101.f246767b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f246766a.hashCode() * 31) + this.f246767b.hashCode();
    }

    public final String toString() {
        return "LynxSSRData(chunks=" + this.f246766a + ", hydrateUrl=" + this.f246767b + ')';
    }

    public t(List<u> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chunks");
        Intrinsics.checkNotNullParameter(r101, "hydrateUrl");
        this.f246766a = r100;
        this.f246767b = r101;
        Iterator<T> r102 = r100.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        if (((u) r104).getType() != 1) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
    L12:
        u r106 = (u) r104;
        if (r106 == null) goto L41;
        byte[] r107 = r106.f246771b;
        if (r107 == null) goto L41;
        this.f246768c = r107;
        Iterator<T> r108 = this.f246766a.iterator();
    L19:
        if (r108.hasNext() == false) goto L26;
        Object r109 = r108.next();
        if (((u) r109).getType() != 2) goto L23;
        boolean r110 = true;
    L24:
        if (r110 == false) goto L19;
        r103 = r109;
        goto L26
    L23:
        r110 = false;
    L26:
        u r111 = (u) r103;
        if (r111 == null) goto L35;
        byte[] r112 = r111.f246771b;
        if (r112 == null) goto L35;
        String r113 = StringsKt.decodeToString(r112);
        if (r113 == null) goto L35;
        this.f246769d = r113;
        return;
    L35:
        StringBuilder r114 = new StringBuilder("can not find chunk type 2, all types:");
        List<u> r115 = this.f246766a;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r117 = r115.iterator();
    L37:
        if (r117.hasNext() == false) goto L39;
        r116.add(Integer.valueOf(((u) r117.next()).getType()));
        goto L37
    L39:
        r114.append(r116);
        throw new IllegalStateException(r114.toString());
    L41:
        StringBuilder r118 = new StringBuilder("can not find chunk type 1, all types:");
        List<u> r119 = this.f246766a;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator<T> r121 = r119.iterator();
    L43:
        if (r121.hasNext() == false) goto L45;
        r120.add(Integer.valueOf(((u) r121.next()).getType()));
        goto L43
    L45:
        r118.append(r120);
        throw new IllegalStateException(r118.toString());
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }
}
