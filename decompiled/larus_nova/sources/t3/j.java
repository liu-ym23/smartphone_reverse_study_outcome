package t3;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f544309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f544311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f544312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f544313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f544314f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f544309a == r101.f544309a) goto L12;
        return false;
    L12:
        if (this.f544310b == r101.f544310b) goto L15;
        return false;
    L15:
        if (this.f544311c == r101.f544311c) goto L18;
        return false;
    L18:
        if (this.f544312d == r101.f544312d) goto L21;
        return false;
    L21:
        if (this.f544313e == r101.f544313e) goto L24;
        return false;
    L24:
        if (this.f544314f == r101.f544314f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f544309a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f544310b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f544311c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f544312d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f544313e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f544314f == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
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
        return "BluetoothCharacteristicPropertiesSnapshot(read=" + this.f544309a + ", write=" + this.f544310b + ", notify=" + this.f544311c + ", indicate=" + this.f544312d + ", writeNoResponse=" + this.f544313e + ", writeDefault=" + this.f544314f + ')';
    }

    public j(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f544309a = r100;
        this.f544310b = r101;
        this.f544311c = r102;
        this.f544312d = r103;
        this.f544313e = r104;
        this.f544314f = true;
    }
}
