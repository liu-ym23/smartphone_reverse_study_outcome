package com.larus.kmp.voice_setting.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceQualityStatus f351724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f351727d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (this.f351724a == r101.f351724a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351725b, r101.f351725b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351726c, r101.f351726c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f351727d, r101.f351727d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f351724a.hashCode() * 31) + this.f351725b.hashCode()) * 31) + this.f351726c.hashCode()) * 31) + this.f351727d.hashCode();
    }

    public final String toString() {
        return "VoiceQualityResult(status=" + this.f351724a + ", resultName=" + this.f351725b + ", returnValue=" + this.f351726c + ", reasonDetail=" + this.f351727d + ')';
    }

    public r0(VoiceQualityStatus r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "resultName");
        Intrinsics.checkNotNullParameter(r102, "returnValue");
        Intrinsics.checkNotNullParameter(r103, "reasonDetail");
        this.f351724a = r100;
        this.f351725b = r101;
        this.f351726c = r102;
        this.f351727d = r103;
    }
}
