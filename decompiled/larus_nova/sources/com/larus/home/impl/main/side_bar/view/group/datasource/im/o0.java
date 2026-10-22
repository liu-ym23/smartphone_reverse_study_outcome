package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f345366c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n0> f345367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f345368b;

    public static final class a {
        public static o0 a(List r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "before");
            Intrinsics.checkNotNullParameter(r101, "after");
            List r102 = r100;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.add(((n0) r104.next()).f345364a);
            goto L4
        L6:
            Set r105 = CollectionsKt.toSet(r103);
            List r106 = r101;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator r108 = r106.iterator();
        L8:
            if (r108.hasNext() == false) goto L10;
            r107.add(((n0) r108.next()).f345364a);
            goto L8
        L10:
            Set r109 = CollectionsKt.toSet(r107);
            ArrayList r110 = new ArrayList();
            Iterator r111 = r106.iterator();
        L12:
            if (r111.hasNext() == false) goto L16;
            Object r112 = r111.next();
            if ((!r105.contains(((n0) r112).f345364a)) == false) goto L12;
            r110.add(r112);
            goto L12
        L16:
            ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r114 = r102.iterator();
        L18:
            if (r114.hasNext() == false) goto L20;
            r113.add(((n0) r114.next()).f345364a);
            goto L18
        L20:
            ArrayList r115 = new ArrayList();
            Iterator r116 = r113.iterator();
        L22:
            if (r116.hasNext() == false) goto L27;
            Object r117 = r116.next();
            if ((!r109.contains((String) r117)) == false) goto L22;
            r115.add(r117);
            goto L22
        L27:
            return new o0(r110, r115);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f345367a, r101.f345367a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f345368b, r101.f345368b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f345367a.hashCode() * 31) + this.f345368b.hashCode();
    }

    public final String toString() {
        return "SideBarDeviceListDiff(added=" + this.f345367a + ", removed=" + this.f345368b + ')';
    }

    public o0(List<n0> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "added");
        Intrinsics.checkNotNullParameter(r101, "removed");
        this.f345367a = r100;
        this.f345368b = r101;
    }
}
