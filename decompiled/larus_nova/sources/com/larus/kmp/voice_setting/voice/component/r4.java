package com.larus.kmp.voice_setting.voice.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f352505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f352508e;

    public r4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r4) == true) goto L8;
        return false;
    L8:
        r4 r101 = (r4) r100;
        if (Intrinsics.areEqual(this.f352504a, r101.f352504a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352505b, r101.f352505b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352506c, r101.f352506c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352507d, r101.f352507d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352508e, r101.f352508e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f352504a.hashCode() * 31) + this.f352505b.hashCode()) * 31) + this.f352506c.hashCode()) * 31) + this.f352507d.hashCode()) * 31) + this.f352508e.hashCode();
    }

    public final String toString() {
        return "VoiceEditAreaLabels(emptyText=" + this.f352504a + ", pitchLabel=" + this.f352505b + ", rateLabel=" + this.f352506c + ", defaultValuePrefix=" + this.f352507d + ", mixedPlayText=" + this.f352508e + ')';
    }

    public /* synthetic */ r4(int r100) {
        this("", "", "", "", "");
    }

    public r4(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "emptyText");
        Intrinsics.checkNotNullParameter(r101, "pitchLabel");
        Intrinsics.checkNotNullParameter(r102, "rateLabel");
        Intrinsics.checkNotNullParameter(r103, "defaultValuePrefix");
        Intrinsics.checkNotNullParameter(r104, "mixedPlayText");
        this.f352504a = r100;
        this.f352505b = r101;
        this.f352506c = r102;
        this.f352507d = r103;
        this.f352508e = r104;
    }
}
