package com.larus.paging;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d1<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d1<Object> f363801e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f363802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f363803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f363804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f363805d;

    public static final class a {
    }

    public final String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.f363802a) + ", data=" + this.f363803b + ", hintOriginalPageOffset=" + this.f363804c + ", hintOriginalIndices=" + this.f363805d + ')';
    }

    static {
        f363801e = new d1(0, CollectionsKt.emptyList());
    }

    public final int hashCode() {
        int r100 = ((((Arrays.hashCode(this.f363802a) * 31) + this.f363803b.hashCode()) * 31) + this.f363804c) * 31;
        List<Integer> r101 = this.f363805d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(d1.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.paging.TransformablePage<*>");
        d1 r102 = (d1) r100;
        if (Arrays.equals(this.f363802a, r102.f363802a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f363803b, r102.f363803b) == true) goto L19;
        return false;
    L19:
        if (this.f363804c == r102.f363804c) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f363805d, r102.f363805d) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public d1(int r100, List<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this(new int[]{r100}, r101, r100, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d1(int[] r100, List<? extends T> r101, int r102, List<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f363802a = r100;
        this.f363803b = r101;
        this.f363804c = r102;
        this.f363805d = r103;
        boolean r104 = false;
        if (r100.length != 0) goto L5;
        boolean r105 = true;
    L7:
        if ((!r105) == false) goto L17;
        if (r103 != null) goto L10;
    L11:
        r104 = true;
    L12:
        if (r104 == false) goto L14;
        return;
    L14:
        StringBuilder r106 = new StringBuilder("If originalIndices (size = ");
        Intrinsics.checkNotNull(r103);
        r106.append(r103.size());
        r106.append(") is provided, it must be same length as data (size = ");
        r106.append(r101.size());
        r106.append(')');
        throw new IllegalArgumentException(r106.toString().toString());
    L10:
        if (r103.size() != r101.size()) goto L12;
    L17:
        throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
    L5:
        r105 = false;
        goto L7
    }
}
