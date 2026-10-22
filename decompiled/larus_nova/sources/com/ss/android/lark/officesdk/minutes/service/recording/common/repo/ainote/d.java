package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f434838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f434839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f434840f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f434835a, r101.f434835a) == true) goto L12;
        return false;
    L12:
        if (this.f434836b == r101.f434836b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f434837c, r101.f434837c) == true) goto L18;
        return false;
    L18:
        if (this.f434838d == r101.f434838d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f434839e, r101.f434839e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f434840f, r101.f434840f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f434835a.hashCode() * 31) + this.f434836b) * 31) + this.f434837c.hashCode()) * 31;
        long r101 = this.f434838d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f434839e;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f434840f;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAINoteFishBoneMarkPayload(action=" + this.f434835a + ", type=" + this.f434836b + ", id=" + this.f434837c + ", timestamp=" + this.f434838d + ", image=" + this.f434839e + ", text=" + this.f434840f + ')';
    }

    public final int getType() {
        return this.f434836b;
    }

    public d(String r100, int r101, String r102, long r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r102, "id");
        this.f434835a = r100;
        this.f434836b = r101;
        this.f434837c = r102;
        this.f434838d = r103;
        this.f434839e = r104;
        this.f434840f = r105;
    }
}
