package sk4;

import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f542396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f542397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f542398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f542399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f542400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f542401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f542402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f542403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f542404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f542405j;

    public final String toString() {
        return "ProtocolInfo{version=" + n.g(this.f542396a) + ", ability=" + n.g(this.f542397b) + ", config=" + this.f542398c + ", mtu=" + this.f542399d + ", interval=" + this.f542400e + ", channelNum=" + this.f542401f + ", frameSize=" + this.f542402g + ", samplingRate=" + this.f542403h + ", compression=" + this.f542404i + ", depth=" + this.f542405j + '}';
    }

    public final boolean b(String r100) {
        byte[] r101 = this.f542397b;
        if (r101 == null) goto L7;
        if (r100 != null) goto L6;
        return false;
    L6:
        return n.i(n.g(r101), r100);
    L7:
        return false;
    }

    public static boolean a(String r100, String r101) {
        if (r100 == null) goto L11;
        String[] r102 = r100.split(",");
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        if (r101.equals(r102[r104].trim().replace("[", "").replace("]", "").trim()) == true) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public e(byte[] r100, byte[] r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110) {
        this.f542396a = r100;
        this.f542397b = r101;
        this.f542398c = r102;
        this.f542399d = r103;
        this.f542400e = r104;
        this.f542401f = r105;
        this.f542402g = r106;
        this.f542403h = r107;
        this.f542404i = r108;
        this.f542405j = r110;
    }
}
