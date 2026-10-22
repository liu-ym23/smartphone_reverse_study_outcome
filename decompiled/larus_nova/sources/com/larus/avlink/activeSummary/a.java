package com.larus.avlink.activeSummary;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f291446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f291447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f291448c;

    /* JADX INFO: renamed from: com.larus.avlink.activeSummary.a$a, reason: collision with other inner class name */
    public static final class C3986a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f291446a == r101.f291446a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f291447b, r101.f291447b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291448c, r101.f291448c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f291446a * 31) + this.f291447b.hashCode()) * 31) + this.f291448c.hashCode();
    }

    public final String toString() {
        return "ChunkPackage(id=" + this.f291446a + ", event=" + this.f291447b + ", data=" + this.f291448c + ')';
    }

    public a() {
        Intrinsics.checkNotNullParameter("json", "event");
        Intrinsics.checkNotNullParameter("", "data");
        this.f291446a = -1;
        this.f291447b = "json";
        this.f291448c = "";
    }
}
