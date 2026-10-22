package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes29.dex */
public final class f0<T> implements a0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f0<Object> f363835e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d1<T>> f363836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f363837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f363838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f363839d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363840a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363840a = r100;
        }
    }

    static {
        f363835e = new f0(PageEvent.Insert.f363671g);
    }

    @Override // com.larus.paging.a0
    public final int getSize() {
        return (this.f363838c + this.f363837b) + this.f363839d;
    }

    public final String toString() {
        int r100 = this.f363837b;
        ArrayList r101 = new ArrayList(r100);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        r101.add(c(r102));
        r102 = r102 + 1;
        goto L3
    L6:
        return "[(" + this.f363838c + " placeholders), " + CollectionsKt.joinToString$default(r101, null, null, null, 0, null, null, 63, null) + ", (" + this.f363839d + " placeholders)]";
    }

    @Override // com.larus.paging.a0
    public final int a() {
        return this.f363838c;
    }

    @Override // com.larus.paging.a0
    public final int d() {
        return this.f363837b;
    }

    @Override // com.larus.paging.a0
    public final int e() {
        return this.f363839d;
    }

    public f0(PageEvent.Insert<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "insertEvent");
        this.f363836a = CollectionsKt.toMutableList(r100.f363673b);
        Iterator<T> r101 = r100.f363673b.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r102 + ((d1) r101.next()).f363803b.size();
        goto L4
    L6:
        this.f363837b = r102;
        this.f363838c = r100.f363674c;
        this.f363839d = r100.f363675d;
    }

    public final f1.a b(int r110) {
        int r100 = r110 - this.f363838c;
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r100 < ((d1) ListProtector.get(this.f363836a, r102)).f363803b.size()) goto L8;
        if (r102 >= CollectionsKt.getLastIndex(this.f363836a)) goto L8;
        r100 = r100 - ((d1) ListProtector.get(this.f363836a, r102)).f363803b.size();
        r102 = r102 + 1;
    L8:
        d1 r103 = (d1) ListProtector.get(this.f363836a, r102);
        int r104 = r110 - this.f363838c;
        int r105 = ((getSize() - r110) - this.f363839d) - 1;
        Integer r111 = ArraysKt.minOrNull(((d1) CollectionsKt.first(this.f363836a)).f363802a);
        Intrinsics.checkNotNull(r111);
        int r106 = r111.intValue();
        Integer r112 = ArraysKt.maxOrNull(((d1) CollectionsKt.last(this.f363836a)).f363802a);
        Intrinsics.checkNotNull(r112);
        int r113 = r112.intValue();
        r103.getClass();
        int r107 = r103.f363804c;
        List<Integer> r108 = r103.f363805d;
        if (r108 == null) goto L15;
        IntRange r109 = CollectionsKt.getIndices(r108);
        if (r109 == null) goto L15;
        if (r109.contains(r100) != true) goto L15;
        r101 = true;
    L15:
        if (r101 == false) goto L18;
        r100 = ((Number) ListProtector.get(r103.f363805d, r100)).intValue();
    L18:
        return new f1.a(r107, r100, r104, r105, r106, r113);
    }

    @Override // com.larus.paging.a0
    public final T c(int r100) {
        int r101 = this.f363836a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        int r103 = ((d1) ListProtector.get(this.f363836a, r102)).f363803b.size();
        if (r103 > r100) goto L9;
        r100 = r100 - r103;
        r102 = r102 + 1;
    L9:
        return (T) ListProtector.get(((d1) ListProtector.get(this.f363836a, r102)).f363803b, r100);
    }

    public final int f(IntRange r100) {
        Iterator<d1<T>> r101 = this.f363836a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L14;
        d1<T> r103 = r101.next();
        int[] r104 = r103.f363802a;
        int r105 = r104.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        if (r100.contains(r104[r106]) == true) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L4;
        r102 = r102 + r103.f363803b.size();
        r101.remove();
        goto L4
    L11:
        r107 = false;
        goto L12
    L14:
        return r102;
    }
}
