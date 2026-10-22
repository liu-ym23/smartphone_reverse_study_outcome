package com.larus.dora.impl.file;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f335734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraFileType f335735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f335736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f335737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f335738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f335739g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f335733a, r101.f335733a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f335734b, r101.f335734b) == true) goto L15;
        return false;
    L15:
        if (this.f335735c == r101.f335735c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f335736d, r101.f335736d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f335737e, r101.f335737e) == true) goto L24;
        return false;
    L24:
        if (this.f335738f == r101.f335738f) goto L27;
        return false;
    L27:
        if (this.f335739g == r101.f335739g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f335733a.hashCode() * 31) + this.f335734b.hashCode()) * 31) + this.f335735c.hashCode()) * 31) + this.f335736d.hashCode()) * 31) + this.f335737e.hashCode()) * 31;
        long r101 = this.f335738f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f335739g;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "DoraFetchContext(transportType=" + this.f335733a + ", fetchFrom=" + this.f335734b + ", fileType=" + this.f335735c + ", fileName=" + this.f335736d + ", fileMd5=" + this.f335737e + ", fileCreateTimeMs=" + this.f335738f + ", fileTotalSize=" + this.f335739g + ')';
    }

    public b(String r100, DoraFileType r101, String r102, String r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter("bt", "transportType");
        Intrinsics.checkNotNullParameter(r100, "fetchFrom");
        Intrinsics.checkNotNullParameter(r101, "fileType");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileMd5");
        this.f335733a = "bt";
        this.f335734b = r100;
        this.f335735c = r101;
        this.f335736d = r102;
        this.f335737e = r103;
        this.f335738f = r104;
        this.f335739g = r105;
    }
}
