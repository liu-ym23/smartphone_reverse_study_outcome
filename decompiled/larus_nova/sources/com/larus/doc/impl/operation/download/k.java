package com.larus.doc.impl.operation.download;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f331388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f331389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f331390d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f331387a, r101.f331387a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f331388b, r101.f331388b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f331389c, r101.f331389c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f331390d, r101.f331390d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f331387a.hashCode() * 31) + this.f331388b.hashCode()) * 31) + this.f331389c.hashCode()) * 31) + this.f331390d.hashCode();
    }

    public final String toString() {
        return "DownloadTask(url=" + this.f331387a + ", fileName=" + this.f331388b + ", fileDir=" + this.f331389c + ", callback=" + this.f331390d + ')';
    }

    public k(String r100, String r101, String r102, p r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "fileDir");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f331387a = r100;
        this.f331388b = r101;
        this.f331389c = r102;
        this.f331390d = r103;
    }
}
