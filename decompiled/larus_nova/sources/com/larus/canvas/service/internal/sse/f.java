package com.larus.canvas.service.internal.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f323872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f323873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f323874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f323875d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f323872a == r101.f323872a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323873b, r101.f323873b) == true) goto L15;
        return false;
    L15:
        if (this.f323874c == r101.f323874c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f323875d, r101.f323875d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323872a * 31;
        String r101 = this.f323873b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f323874c) * 31) + this.f323875d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChunkEndData(status=" + this.f323872a + ", logId=" + this.f323873b + ", errorCode=" + this.f323874c + ", errorMsg=" + this.f323875d + ')';
    }

    public /* synthetic */ f(int r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r102 & 8) != 0) goto L9;
        r103 = null;
    L9:
        this(r100, r101, 0, r103);
    }

    public f(int r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        this.f323872a = r100;
        this.f323873b = r101;
        this.f323874c = r102;
        this.f323875d = r103;
    }
}
