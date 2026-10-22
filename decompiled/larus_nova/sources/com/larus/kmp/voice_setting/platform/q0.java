package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f351721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f351722e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f351718a, r101.f351718a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351719b, r101.f351719b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351720c, r101.f351720c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f351721d, r101.f351721d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f351722e, r101.f351722e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f351718a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f351719b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f351720c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f351721d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f351722e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "VoicePreviewPlaybackRequest(styleId=" + this.f351718a + ", url=" + this.f351719b + ", md5=" + this.f351720c + ", voiceId=" + this.f351721d + ", speakerName=" + this.f351722e + ')';
    }

    public q0(String r100, String r101, String r102, String r103, String r104) {
        this.f351718a = r100;
        this.f351719b = r101;
        this.f351720c = r102;
        this.f351721d = r103;
        this.f351722e = r104;
    }
}
