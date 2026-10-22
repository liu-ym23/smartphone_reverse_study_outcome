package jq9;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f500096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f500097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f500098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f500099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f500100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500101f;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f500096a == r101.f500096a) goto L12;
        return false;
    L12:
        if (this.f500097b == r101.f500097b) goto L15;
        return false;
    L15:
        if (this.f500098c == r101.f500098c) goto L18;
        return false;
    L18:
        if (this.f500099d == r101.f500099d) goto L21;
        return false;
    L21:
        if (this.f500100e == r101.f500100e) goto L24;
        return false;
    L24:
        if (this.f500101f == r101.f500101f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f500096a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f500097b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f500098c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f500099d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.f500100e) * 31;
        if (this.f500101f == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ActionbarEntryConfig(abcEntryExpandEnable=" + this.f500096a + ", abcEntryReorderEnable=" + this.f500097b + ", abcEntryRedDotEnable=" + this.f500098c + ", abcEntryRedDotToText=" + this.f500099d + ", abcEntryRedDotMaxExposureTimes=" + this.f500100e + ", enableShowInstructionUpdateDialog=" + this.f500101f + ')';
    }

    public /* synthetic */ k(int r100) {
        this(false, false, false, false, 3, false);
    }

    public k(boolean r100, boolean r101, boolean r102, boolean r103, int r104, boolean r105) {
        this.f500096a = r100;
        this.f500097b = r101;
        this.f500098c = r102;
        this.f500099d = r103;
        this.f500100e = r104;
        this.f500101f = r105;
    }
}
