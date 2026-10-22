package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n4 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f352397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceRowActionKind f352398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceListKind f352399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f352400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f352401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f352402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f352403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.screen.single.t0 f352405i;

    public n4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n4) == true) goto L8;
        return false;
    L8:
        n4 r101 = (n4) r100;
        if (this.f352397a == r101.f352397a) goto L12;
        return false;
    L12:
        if (this.f352398b == r101.f352398b) goto L15;
        return false;
    L15:
        if (this.f352399c == r101.f352399c) goto L18;
        return false;
    L18:
        if (this.f352400d == r101.f352400d) goto L21;
        return false;
    L21:
        if (this.f352401e == r101.f352401e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352402f, r101.f352402f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f352403g, r101.f352403g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352404h, r101.f352404h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352405i, r101.f352405i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f352397a;
        int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f352398b.hashCode()) * 31) + this.f352399c.hashCode()) * 31) + this.f352400d) * 31) + this.f352401e) * 31;
        String r102 = this.f352402f;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f352403g;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f352404h;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        com.larus.kmp.voice_setting.voice.screen.single.t0 r112 = this.f352405i;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        return r111 + r103;
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDropdownMenuRequestData(token=" + this.f352397a + ", actionKind=" + this.f352398b + ", listKind=" + this.f352399c + ", screenIndex=" + this.f352400d + ", rowIndex=" + this.f352401e + ", voiceId=" + this.f352402f + ", selectedVoiceId=" + this.f352403g + ", activeTabKey=" + this.f352404h + ", anchorBounds=" + this.f352405i + ')';
    }

    public /* synthetic */ n4(int r110) {
        this(0, VoiceRowActionKind.NONE, VoiceListKind.UNSPECIFIED, -1, -1, null, null, null, null);
    }

    public n4(long r100, VoiceRowActionKind r101, VoiceListKind r102, int r103, int r104, String r105, String r106, String r110, com.larus.kmp.voice_setting.voice.screen.single.t0 r111) {
        Intrinsics.checkNotNullParameter(r101, "actionKind");
        Intrinsics.checkNotNullParameter(r102, "listKind");
        this.f352397a = r100;
        this.f352398b = r101;
        this.f352399c = r102;
        this.f352400d = r103;
        this.f352401e = r104;
        this.f352402f = r105;
        this.f352403g = r106;
        this.f352404h = r110;
        this.f352405i = r111;
    }
}
