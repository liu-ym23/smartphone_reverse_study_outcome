package com.larus.network.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f360202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f360203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f360204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f360205g;

    public y() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f360202d, r101.f360202d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f360203e, r101.f360203e) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f360204f, r101.f360204f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f360205g, r101.f360205g) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f360202d;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f360203e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f360204f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f360205g;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Success(value=" + this.f360202d + ", payload=" + this.f360203e + ", msg=" + this.f360204f + ", code=" + this.f360205g + ')';
    }

    public /* synthetic */ y(Object r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, null, r101, null);
    }

    public y(T r100, String r101, String r102, Long r103) {
        super(true, r100, r101);
        this.f360202d = r100;
        this.f360203e = r101;
        this.f360204f = r102;
        this.f360205g = r103;
    }
}
