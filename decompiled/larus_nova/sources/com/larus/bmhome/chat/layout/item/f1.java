package com.larus.bmhome.chat.layout.item;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f304346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f304347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f304348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f304349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f304350e;

    public f1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (this.f304346a == r101.f304346a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f304347b, r101.f304347b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f304348c, r101.f304348c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f304349d, r101.f304349d) == true) goto L21;
        return false;
    L21:
        if (this.f304350e == r101.f304350e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f304346a * 31;
        Integer r101 = this.f304347b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f304348c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.f304349d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f304350e;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageBoxWidthInfo(lastBoxType=" + this.f304346a + ", immerseBgColor=" + this.f304347b + ", isShareMode=" + this.f304348c + ", isSharePicMode=" + this.f304349d + ", expandMaxWidth=" + this.f304350e + ')';
    }

    public f1(int r100) {
        this.f304346a = Integer.MIN_VALUE;
        this.f304347b = Integer.MIN_VALUE;
        this.f304348c = null;
        this.f304349d = null;
        this.f304350e = -1;
    }
}
