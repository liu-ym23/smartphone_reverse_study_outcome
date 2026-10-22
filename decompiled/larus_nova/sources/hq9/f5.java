package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486605c;

    public f5() {
        this(false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f5) == true) goto L8;
        return false;
    L8:
        f5 r101 = (f5) r100;
        if (this.f486603a == r101.f486603a) goto L12;
        return false;
    L12:
        if (this.f486604b == r101.f486604b) goto L15;
        return false;
    L15:
        if (this.f486605c == r101.f486605c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486603a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486604b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486605c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "WechatLoginConfig(enableWechatLogin=" + this.f486603a + ", forceBindPhoneAfterWechat=" + this.f486604b + ", skipBindPhoneAfterWechat=" + this.f486605c + ')';
    }

    public f5(boolean r100, boolean r101, boolean r102) {
        this.f486603a = r100;
        this.f486604b = r101;
        this.f486605c = r102;
    }
}
