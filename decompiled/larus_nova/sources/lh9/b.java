package lh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f509298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f509300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f509301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f509302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f509303h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f509296a, r101.f509296a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509297b, r101.f509297b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509298c, r101.f509298c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509299d, r101.f509299d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f509300e, r101.f509300e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f509301f, r101.f509301f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f509302g, r101.f509302g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f509303h, r101.f509303h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f509296a.hashCode() * 31) + this.f509297b.hashCode()) * 31) + this.f509298c.hashCode()) * 31) + this.f509299d.hashCode()) * 31) + this.f509300e.hashCode()) * 31) + this.f509301f.hashCode()) * 31) + this.f509302g.hashCode()) * 31) + this.f509303h.hashCode();
    }

    public final String toString() {
        return "VoiceSettingEditTexts(pitchLabel=" + this.f509296a + ", rateLabel=" + this.f509297b + ", defaultValuePrefix=" + this.f509298c + ", mixedPlayText=" + this.f509299d + ", emptyText=" + this.f509300e + ", mixEmptyText=" + this.f509301f + ", mixedTitle=" + this.f509302g + ", expandContentDescription=" + this.f509303h + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "pitchLabel");
        Intrinsics.checkNotNullParameter(r101, "rateLabel");
        Intrinsics.checkNotNullParameter(r102, "defaultValuePrefix");
        Intrinsics.checkNotNullParameter(r103, "mixedPlayText");
        Intrinsics.checkNotNullParameter(r104, "emptyText");
        Intrinsics.checkNotNullParameter(r105, "mixEmptyText");
        Intrinsics.checkNotNullParameter(r106, "mixedTitle");
        Intrinsics.checkNotNullParameter("Expand", "expandContentDescription");
        this.f509296a = r100;
        this.f509297b = r101;
        this.f509298c = r102;
        this.f509299d = r103;
        this.f509300e = r104;
        this.f509301f = r105;
        this.f509302g = r106;
        this.f509303h = "Expand";
    }
}
