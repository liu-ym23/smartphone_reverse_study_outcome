package com.larus.canvas.service.internal.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f323859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f323860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f323861c;

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
        if (this.f323859a == r101.f323859a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323860b, r101.f323860b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323861c, r101.f323861c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f323859a * 31) + this.f323860b.hashCode()) * 31) + this.f323861c.hashCode();
    }

    public final String toString() {
        return "CanvasChunkPackage(id=" + this.f323859a + ", event=" + this.f323860b + ", data=" + this.f323861c + ')';
    }

    public b() {
        Intrinsics.checkNotNullParameter("json", "event");
        Intrinsics.checkNotNullParameter("", "data");
        this.f323859a = -1;
        this.f323860b = "json";
        this.f323861c = "";
    }
}
