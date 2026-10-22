package com.larus.kmp.voice_setting.voice.editvoice;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f353264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f353266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f353267d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f353264a == r101.f353264a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353265b, r101.f353265b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353266c, r101.f353266c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353267d, r101.f353267d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f353264a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f353265b.hashCode()) * 31;
        h r102 = this.f353266c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        f r106 = this.f353267d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoicePitchAndRatePolicy(shouldRemember=" + this.f353264a + ", cacheKey=" + this.f353265b + ", firstVoice=" + this.f353266c + ", fallbackPitchAndRate=" + this.f353267d + ')';
    }

    public i(boolean r100, String r101, h r102, f r103) {
        Intrinsics.checkNotNullParameter(r101, "cacheKey");
        this.f353264a = r100;
        this.f353265b = r101;
        this.f353266c = r102;
        this.f353267d = r103;
    }
}
