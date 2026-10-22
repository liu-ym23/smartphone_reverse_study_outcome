package com.larus.media;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f359146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f359148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f359149d;

    public final String toString() {
        return "PCMData(audio=" + Arrays.toString(this.f359146a) + ", extra=" + this.f359147b + ", isFinal=" + this.f359148c + ", trace=" + this.f359149d + ')';
    }

    public final int hashCode() {
        int r100 = Arrays.hashCode(this.f359146a) * 31;
        String r101 = this.f359147b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f359148c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(w.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.media.PCMData");
        w r102 = (w) r100;
        if (Arrays.equals(this.f359146a, r102.f359146a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f359147b, r102.f359147b) == true) goto L19;
        return false;
    L19:
        if (this.f359148c == r102.f359148c) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public w(byte[] r100, String r101, boolean r102, x r103) {
        Intrinsics.checkNotNullParameter(r100, "audio");
        Intrinsics.checkNotNullParameter(r103, "trace");
        this.f359146a = r100;
        this.f359147b = r101;
        this.f359148c = r102;
        this.f359149d = r103;
    }
}
