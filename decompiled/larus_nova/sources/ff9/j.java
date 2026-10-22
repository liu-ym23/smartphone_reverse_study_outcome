package ff9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f476763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f476764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f476765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f476766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f476767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f476768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f476769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f476770h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f476763a, r101.f476763a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476764b, r101.f476764b) == true) goto L15;
        return false;
    L15:
        if (this.f476765c == r101.f476765c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476766d, r101.f476766d) == true) goto L21;
        return false;
    L21:
        if (this.f476767e == r101.f476767e) goto L24;
        return false;
    L24:
        if (this.f476768f == r101.f476768f) goto L27;
        return false;
    L27:
        if (this.f476769g == r101.f476769g) goto L30;
        return false;
    L30:
        if (this.f476770h == r101.f476770h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f476763a.hashCode() * 31) + this.f476764b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f476765c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f476766d.hashCode()) * 31;
        if (this.f476767e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f476768f == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f476769g == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f476770h == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowRTCJoinRoomCommonConfig(userId=" + this.f476763a + ", token=" + this.f476764b + ", fromPreCreate=" + this.f476765c + ", ppeEnv=" + this.f476766d + ", isNewArch=" + this.f476767e + ", isDora=" + this.f476768f + ", enablePseudo=" + this.f476769g + ", enableAudioEncodeStereo=" + this.f476770h + ')';
    }

    public j(String r100, String r101, boolean r102, String r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "ppeEnv");
        this.f476763a = r100;
        this.f476764b = r101;
        this.f476765c = r102;
        this.f476766d = r103;
        this.f476767e = r104;
        this.f476768f = r105;
        this.f476769g = r106;
        this.f476770h = r107;
    }
}
