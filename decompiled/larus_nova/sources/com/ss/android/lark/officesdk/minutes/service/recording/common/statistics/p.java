package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f435492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f435493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f435494e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f435490a, r101.f435490a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435491b, r101.f435491b) == true) goto L15;
        return false;
    L15:
        if (this.f435492c == r101.f435492c) goto L18;
        return false;
    L18:
        if (this.f435493d == r101.f435493d) goto L21;
        return false;
    L21:
        if (this.f435494e == r101.f435494e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f435490a.hashCode() * 31) + this.f435491b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f435492c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f435493d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f435494e == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationTrackState(speakLanguage=" + this.f435490a + ", translationLanguage=" + this.f435491b + ", showTranslationBoth=" + this.f435492c + ", saveNotes=" + this.f435493d + ", aiSiVoice=" + this.f435494e + ')';
    }

    public p(String r100, String r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "speakLanguage");
        Intrinsics.checkNotNullParameter(r101, "translationLanguage");
        this.f435490a = r100;
        this.f435491b = r101;
        this.f435492c = r102;
        this.f435493d = r103;
        this.f435494e = r104;
    }
}
