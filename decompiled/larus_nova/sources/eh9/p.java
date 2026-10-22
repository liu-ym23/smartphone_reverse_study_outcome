package eh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f472748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f472749f;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f472744a, r101.f472744a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472745b, r101.f472745b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472746c, r101.f472746c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472747d, r101.f472747d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472748e, r101.f472748e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f472749f, r101.f472749f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f472744a.hashCode() * 31) + this.f472745b.hashCode()) * 31) + this.f472746c.hashCode()) * 31) + this.f472747d.hashCode()) * 31) + this.f472748e.hashCode()) * 31) + this.f472749f.hashCode();
    }

    public final String toString() {
        return "VoiceRowTextResources(mutedVoiceName=" + this.f472744a + ", unavailableText=" + this.f472745b + ", moderationText=" + this.f472746c + ", creatingText=" + this.f472747d + ", voiceNameUnavailableText=" + this.f472748e + ", creationFailedText=" + this.f472749f + ')';
    }

    public /* synthetic */ p(int r100) {
        this("", "", "", "", "", "");
    }

    public p(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "mutedVoiceName");
        Intrinsics.checkNotNullParameter(r101, "unavailableText");
        Intrinsics.checkNotNullParameter(r102, "moderationText");
        Intrinsics.checkNotNullParameter(r103, "creatingText");
        Intrinsics.checkNotNullParameter(r104, "voiceNameUnavailableText");
        Intrinsics.checkNotNullParameter(r105, "creationFailedText");
        this.f472744a = r100;
        this.f472745b = r101;
        this.f472746c = r102;
        this.f472747d = r103;
        this.f472748e = r104;
        this.f472749f = r105;
    }
}
