package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f434863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f434864d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f434861a, r101.f434861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f434862b, r101.f434862b) == true) goto L15;
        return false;
    L15:
        if (this.f434863c == r101.f434863c) goto L18;
        return false;
    L18:
        if (this.f434864d == r101.f434864d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f434861a.hashCode() * 31) + this.f434862b.hashCode()) * 31;
        long r101 = this.f434863c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f434864d;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "MmRecordingAINoteSubtitleMarkRequest(markId=" + this.f434861a + ", contentMarkdown=" + this.f434862b + ", relativeAudioTimeMs=" + this.f434863c + ", audioLocationTimeMs=" + this.f434864d + ')';
    }

    public k(String r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        Intrinsics.checkNotNullParameter(r101, "contentMarkdown");
        this.f434861a = r100;
        this.f434862b = r101;
        this.f434863c = r102;
        this.f434864d = r103;
    }
}
