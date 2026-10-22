package com.larus.audio.asr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f288360c;

    public b0() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f288358a, r101.f288358a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288359b, r101.f288359b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f288360c, r101.f288360c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f288358a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f288359b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f288360c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrStreamSentenceData(streamingSentence=" + this.f288358a + ", definiteSentence=" + this.f288359b + ", isInterim=" + this.f288360c + ')';
    }

    public b0(String r100, String r101, Boolean r102) {
        this.f288358a = r100;
        this.f288359b = r101;
        this.f288360c = r102;
    }
}
