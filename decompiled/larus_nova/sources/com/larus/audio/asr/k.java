package com.larus.audio.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288425b;

    public k() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f288424a, r101.f288424a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288425b, r101.f288425b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f288424a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f288425b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrContextConfig(text=" + this.f288424a + ", audioContext=" + this.f288425b + ')';
    }

    public k(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f288424a = r100;
        this.f288425b = null;
    }
}
