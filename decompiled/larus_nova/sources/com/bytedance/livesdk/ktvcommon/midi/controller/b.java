package com.bytedance.livesdk.ktvcommon.midi.controller;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f256033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f256034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f256035d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f256032a, r101.f256032a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f256033b, r101.f256033b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f256034c, r101.f256034c) == true) goto L12;
        return false;
    L12:
        if (this.f256035d == r101.f256035d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f256032a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f256033b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f256034c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f256035d;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MusicFileDownloadResult(musicId=" + this.f256032a + ", midiPath=" + this.f256033b + ", lyricPath=" + this.f256034c + ", isSuccess=" + this.f256035d + ")";
    }

    public b(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        this.f256032a = r100;
        this.f256033b = r101;
        this.f256034c = r102;
        this.f256035d = r103;
    }
}
