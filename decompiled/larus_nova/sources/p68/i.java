package p68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f527937e;

    public i() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f527933a, r101.f527933a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527934b, r101.f527934b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527935c, r101.f527935c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527936d, r101.f527936d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f527937e, r101.f527937e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f527933a.hashCode() * 31) + this.f527934b.hashCode()) * 31) + this.f527935c.hashCode()) * 31) + this.f527936d.hashCode()) * 31) + this.f527937e.hashCode();
    }

    public final String toString() {
        return "VoiceStyleInfo(ttsSpeakerId=" + this.f527933a + ", ttsSpeakerName=" + this.f527934b + ", voiceId=" + this.f527935c + ", extra=" + this.f527936d + ", audioMetrics=" + this.f527937e + ')';
    }

    public final String a() {
        return this.f527937e;
    }

    public final String b() {
        return this.f527936d;
    }

    public final String c() {
        return this.f527933a;
    }

    public final String d() {
        return this.f527934b;
    }

    public i(String r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = "";
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = "";
    L17:
        Intrinsics.checkNotNullParameter(r100, "ttsSpeakerId");
        Intrinsics.checkNotNullParameter(r101, "ttsSpeakerName");
        Intrinsics.checkNotNullParameter(r102, "voiceId");
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r104, "audioMetrics");
        this.f527933a = r100;
        this.f527934b = r101;
        this.f527935c = r102;
        this.f527936d = r103;
        this.f527937e = r104;
    }
}
