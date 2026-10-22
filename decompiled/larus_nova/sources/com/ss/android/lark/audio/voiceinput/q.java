package com.ss.android.lark.audio.voiceinput;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f409377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.audio.voiceinput.utils.a f409378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f409379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f409380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f409381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f409382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f409383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f409384h;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f409377a, r101.f409377a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409378b, r101.f409378b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409379c, r101.f409379c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409380d, r101.f409380d) == true) goto L21;
        return false;
    L21:
        if (this.f409381e == r101.f409381e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409382f, r101.f409382f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f409383g, r101.f409383g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f409384h, r101.f409384h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        s r100 = this.f409377a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        com.ss.android.lark.audio.voiceinput.utils.a r104 = this.f409378b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f409379c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f409380d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f409381e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        String r115 = this.f409382f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f409383g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f409384h;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return r120 + r101;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
        goto L22
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
        return "VoiceInputRecord(voceRecordEntity=" + this.f409377a + ", pcmBuffer=" + this.f409378b + ", sourceId=" + this.f409379c + ", asrResult=" + this.f409380d + ", isUseOriginText=" + this.f409381e + ", textSnapshotBefore=" + this.f409382f + ", textSnapshotAfter=" + this.f409383g + ", recordingDevice=" + this.f409384h + ')';
    }

    public q(int r100) {
        this.f409377a = null;
        this.f409378b = null;
        this.f409379c = null;
        this.f409380d = null;
        this.f409381e = false;
        this.f409382f = null;
        this.f409383g = null;
        this.f409384h = null;
    }
}
