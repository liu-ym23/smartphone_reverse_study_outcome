package com.larus.im.internal.network.chunk.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f349102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f349103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f349104c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f349102a == r101.f349102a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349103b, r101.f349103b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349104c, r101.f349104c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f349102a * 31) + this.f349103b.hashCode()) * 31) + this.f349104c.hashCode();
    }

    public final String toString() {
        return "ChunkPackage(id=" + this.f349102a + ", event=" + this.f349103b + ", data=" + this.f349104c + ')';
    }

    public b() {
        Intrinsics.checkNotNullParameter("json", "event");
        Intrinsics.checkNotNullParameter("", "data");
        this.f349102a = -1;
        this.f349103b = "json";
        this.f349104c = "";
    }
}
