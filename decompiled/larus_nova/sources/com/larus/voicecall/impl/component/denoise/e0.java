package com.larus.voicecall.impl.component.denoise;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DenoiseUploadStatus f377388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f377389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f377390c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.f377388a == r101.f377388a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f377389b, r101.f377389b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f377390c, r101.f377390c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f377388a.hashCode() * 31) + this.f377389b.hashCode()) * 31) + this.f377390c.hashCode();
    }

    public final String toString() {
        return "ReportDenoiseStatusPayload(uploadStatus=" + this.f377388a + ", botId=" + this.f377389b + ", roomId=" + this.f377390c + ')';
    }

    public e0(DenoiseUploadStatus r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uploadStatus");
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        this.f377388a = r100;
        this.f377389b = r101;
        this.f377390c = r102;
    }
}
