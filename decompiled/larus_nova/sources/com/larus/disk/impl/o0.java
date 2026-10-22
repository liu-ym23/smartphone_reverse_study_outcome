package com.larus.disk.impl;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f330781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f330782c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f330780a, r101.f330780a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330781b, r101.f330781b) == true) goto L15;
        return false;
    L15:
        if (this.f330782c == r101.f330782c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f330780a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f330781b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f330782c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LargeFileModel(path=" + this.f330780a + ", fileSize=" + this.f330781b + ", isInternal=" + this.f330782c + ')';
    }

    public o0() {
        this("", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), true);
    }

    public o0(String r100, Double r101, boolean r102) {
        this.f330780a = r100;
        this.f330781b = r101;
        this.f330782c = r102;
    }
}
