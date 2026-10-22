package com.larus.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f288730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f288731d;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f288728a, r101.f288728a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288729b, r101.f288729b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f288730c, r101.f288730c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f288731d, r101.f288731d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f288728a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f288729b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f288730c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f288731d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrSuccessResultExtra(localPath=" + this.f288728a + ", audioDataTosUri=" + this.f288729b + ", audioEventResp=" + this.f288730c + ", logId=" + this.f288731d + ')';
    }

    public c(String r100, String r101, String r102, String r103) {
        this.f288728a = r100;
        this.f288729b = r101;
        this.f288730c = r102;
        this.f288731d = r103;
    }
}
