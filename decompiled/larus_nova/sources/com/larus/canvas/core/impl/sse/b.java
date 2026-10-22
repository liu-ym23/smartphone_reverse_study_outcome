package com.larus.canvas.core.impl.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f322960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f322961b;

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
        if (Intrinsics.areEqual(this.f322960a, r101.f322960a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f322961b, r101.f322961b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f322960a.hashCode() * 31) + this.f322961b.hashCode();
    }

    public final String toString() {
        return "CanvasChunkPackage(event=" + this.f322960a + ", data=" + this.f322961b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f322960a = r100;
        this.f322961b = r101;
    }
}
