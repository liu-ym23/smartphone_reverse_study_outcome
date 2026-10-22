package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f352209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352211f;

    public d5() {
        String r100 = null;
        this(r100, r100, r100, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r101 = (d5) r100;
        if (Intrinsics.areEqual(this.f352206a, r101.f352206a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352207b, r101.f352207b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352208c, r101.f352208c) == true) goto L18;
        return false;
    L18:
        if (this.f352209d == r101.f352209d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352210e, r101.f352210e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352211f, r101.f352211f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f352206a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f352207b.hashCode()) * 31;
        String r104 = this.f352208c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f352209d) * 31;
        String r107 = this.f352210e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f352211f;
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
        return "VoiceMixItemMeta(voiceId=" + this.f352206a + ", voiceName=" + this.f352207b + ", styleId=" + this.f352208c + ", percentage=" + this.f352209d + ", previewUrl=" + this.f352210e + ", previewMd5=" + this.f352211f + ')';
    }

    public /* synthetic */ d5(String r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r111 = "";
    L9:
        String r101 = r111;
        if ((r113 & 4) == 0) goto L12;
        String r102 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        int r103 = 100;
    L17:
        this(r100, r101, r102, r103, null, null);
        return;
    L16:
        r103 = 0;
        goto L17
    L12:
        r102 = r112;
        goto L14
    L5:
        r100 = r110;
        goto L7
    }

    public d5(String r100, String r101, String r102, int r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "voiceName");
        this.f352206a = r100;
        this.f352207b = r101;
        this.f352208c = r102;
        this.f352209d = r103;
        this.f352210e = r104;
        this.f352211f = r105;
    }
}
