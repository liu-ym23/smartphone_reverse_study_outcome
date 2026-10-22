package gt1;

/* JADX INFO: loaded from: classes8.dex */
public final class e {
    public static d a(int r100, Object r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, boolean r107, boolean r108, qr2.b r109, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 128) == 0) goto L9;
        r106 = 0;
    L9:
        if ((r110 & 256) == 0) goto L12;
        r107 = false;
    L12:
        if ((r110 & 512) == 0) goto L15;
        r108 = false;
    L15:
        if ((r110 & 1024) == 0) goto L17;
        r109 = null;
    L17:
        d r111 = new d(r100);
        r111.f482491a = r101;
        r111.f482492b = r109;
        r111.f482493c = r106;
        r111.f482494d = r107;
        r111.f482495e = r108;
        return r111;
    }
}
