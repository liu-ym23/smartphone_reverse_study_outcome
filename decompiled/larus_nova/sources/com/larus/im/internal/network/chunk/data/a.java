package com.larus.im.internal.network.chunk.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f349098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f349100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f349101d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f349098a == r101.f349098a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349099b, r101.f349099b) == true) goto L15;
        return false;
    L15:
        if (this.f349100c == r101.f349100c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f349101d, r101.f349101d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f349098a * 31;
        String r101 = this.f349099b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f349100c) * 31) + this.f349101d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChunkEndData(status=" + this.f349098a + ", logId=" + this.f349099b + ", errorCode=" + this.f349100c + ", errorMsg=" + this.f349101d + ')';
    }

    public /* synthetic */ a(int r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r102 & 8) != 0) goto L9;
        r103 = null;
    L9:
        this(r100, r101, 0, r103);
    }

    public a(int r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        this.f349098a = r100;
        this.f349099b = r101;
        this.f349100c = r102;
        this.f349101d = r103;
    }
}
