package com.larus.audioplayer.impl.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f290459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f290460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f290461c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f290459a == r101.f290459a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f290460b, r101.f290460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f290461c, r101.f290461c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f290459a * 31) + this.f290460b.hashCode()) * 31) + this.f290461c.hashCode();
    }

    public final String toString() {
        return "StreamChunkPackage(id=" + this.f290459a + ", event=" + this.f290460b + ", data=" + this.f290461c + ')';
    }

    public w() {
        Intrinsics.checkNotNullParameter("json", "event");
        Intrinsics.checkNotNullParameter("", "data");
        this.f290459a = -1;
        this.f290460b = "json";
        this.f290461c = "";
    }
}
