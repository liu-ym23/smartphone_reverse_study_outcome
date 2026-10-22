package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f351690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f351691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f351692f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f351687a, r101.f351687a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351688b, r101.f351688b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351689c, r101.f351689c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f351690d, r101.f351690d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f351691e, r101.f351691e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f351692f, r101.f351692f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f351687a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f351688b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f351689c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + Float.floatToIntBits(this.f351690d)) * 31) + Float.floatToIntBits(this.f351691e)) * 31;
        String r110 = this.f351692f;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "VoiceMixPreviewPlaybackRequest(styleId=" + this.f351687a + ", url=" + this.f351688b + ", md5=" + this.f351689c + ", pitch=" + this.f351690d + ", rate=" + this.f351691e + ", botId=" + this.f351692f + ')';
    }

    public l0(String r100, String r101, String r102, float r103, float r104, String r105) {
        this.f351687a = r100;
        this.f351688b = r101;
        this.f351689c = r102;
        this.f351690d = r103;
        this.f351691e = r104;
        this.f351692f = r105;
    }
}
