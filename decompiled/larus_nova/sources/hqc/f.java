package hqc;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f486848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f486849b;

    public f() {
    }

    public final String a(int r100) {
        if (r100 < 0) goto L20;
        int[] r101 = this.f486848a;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 >= r101.length) goto L26;
        int r102 = r101[r100];
        int r103 = this.f486849b[r102 / 4];
        if (((r102 % 4) / 2) != 0) goto L10;
        int r104 = r103 & 65535;
    L11:
        StringBuilder r105 = new StringBuilder(r104);
    L12:
        if (r104 == 0) goto L19;
        r102 = r102 + 2;
        int r106 = this.f486849b[r102 / 4];
        if (((r102 % 4) / 2) != 0) goto L16;
        int r107 = r106 & 65535;
    L17:
        r105.append((char) r107);
        r104 = r104 - 1;
        goto L12
    L16:
        r107 = r106 >>> 16;
        goto L17
    L19:
        return r105.toString();
    L10:
        r104 = r103 >>> 16;
        goto L11
    L26:
        return null;
    L20:
        return null;
    }
}
