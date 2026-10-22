package com.larus.bmhome.chat.list.cell.text.cells.base;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CellComponentType f306021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f306022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f306023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f306024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f306025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Object, Object> f306026f;

    public c() {
        this(null, 0, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f306021a == r101.f306021a) goto L12;
        return false;
    L12:
        if (this.f306022b == r101.f306022b) goto L15;
        return false;
    L15:
        if (this.f306023c == r101.f306023c) goto L18;
        return false;
    L18:
        if (this.f306024d == r101.f306024d) goto L21;
        return false;
    L21:
        if (this.f306025e == r101.f306025e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f306026f, r101.f306026f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f306021a.hashCode() * 31) + this.f306022b) * 31) + this.f306023c) * 31) + this.f306024d) * 31) + this.f306025e) * 31) + this.f306026f.hashCode();
    }

    public final String toString() {
        return "CellComponentInfo(cellComponentType=" + this.f306021a + ", indexInKind=" + this.f306022b + ", countInKind=" + this.f306023c + ", indexInAll=" + this.f306024d + ", countInAll=" + this.f306025e + ", ext=" + this.f306026f + ')';
    }

    public c(CellComponentType r100, int r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r100 = CellComponentType.UNKNOWN;
    L5:
        int r104 = -1;
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r103 & 8) == 0) goto L14;
        int r105 = -1;
    L16:
        if ((r103 & 16) != 0) goto L20;
        r104 = 0;
    L20:
        if ((r103 & 32) == 0) goto L22;
        HashMap<Object, Object> r106 = new HashMap();
    L23:
        Intrinsics.checkNotNullParameter(r100, "cellComponentType");
        Intrinsics.checkNotNullParameter(r106, "ext");
        this.f306021a = r100;
        this.f306022b = r101;
        this.f306023c = r102;
        this.f306024d = r105;
        this.f306025e = r104;
        this.f306026f = r106;
        return;
    L22:
        r106 = null;
        goto L23
    L14:
        r105 = 0;
        goto L16
    }
}
