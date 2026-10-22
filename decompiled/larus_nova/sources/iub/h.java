package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f495835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f495837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f495838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f495839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f495840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f495841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f495842h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f495835a == r101.f495835a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495836b, r101.f495836b) == true) goto L15;
        return false;
    L15:
        if (this.f495837c == r101.f495837c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495838d, r101.f495838d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495839e, r101.f495839e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495840f, r101.f495840f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f495841g, r101.f495841g) == true) goto L30;
        return false;
    L30:
        if (this.f495842h == r101.f495842h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f495835a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f495836b.hashCode()) * 31;
        long r102 = this.f495837c;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        y r104 = this.f495838d;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (r103 + r106) * 31;
        f r108 = this.f495839e;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        e r111 = this.f495840f;
        if (r111 == null) goto L14;
        r105 = r111.hashCode();
    L14:
        int r112 = (((r110 + r105) * 31) + this.f495841g.hashCode()) * 31;
        if (this.f495842h == false) goto L17;
        int r113 = 1231;
    L19:
        return r112 + r113;
    L17:
        r113 = 1237;
        goto L19
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingAsrContent(seqID=" + this.f495835a + ", targetContent=" + this.f495836b + ", relativeTimeMs=" + this.f495837c + ", speaker=" + this.f495838d + ", markedSpeaker=" + this.f495839e + ", displaySpeaker=" + this.f495840f + ", clusterId=" + this.f495841g + ", canEditSpeaker=" + this.f495842h + ')';
    }

    public h(long r100, String r101, long r102, y r103, f r104, e r105, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r101, "targetContent");
        Intrinsics.checkNotNullParameter(r110, "clusterId");
        this.f495835a = r100;
        this.f495836b = r101;
        this.f495837c = r102;
        this.f495838d = r103;
        this.f495839e = r104;
        this.f495840f = r105;
        this.f495841g = r110;
        this.f495842h = r111;
    }
}
