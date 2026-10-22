package po1;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f530029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f530030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f530031d;

    public b(int r100, String r101, boolean r102) {
        this.f530031d = null;
        this.f530028a = r100;
        this.f530030c = r101;
        byte[] r103 = a.f530026a;
        this.f530029b = r101.getBytes(Charset.forName("ISO-8859-1"));
        int r104 = 0;
    L4:
        if (r104 >= 4) goto L16;
        byte r105 = this.f530029b[r104];
        if (r105 < 65) goto L15;
        if (r105 > 122) goto L15;
        if (r105 <= 90) goto L13;
        if (r105 < 97) goto L15;
    L13:
        r104 = r104 + 1;
    L15:
        throw new RuntimeException();
    L16:
        if (r102 == false) goto L29;
        byte[] r106 = this.f530031d;
        if (r106 != null) goto L20;
    L21:
        this.f530031d = new byte[this.f530028a];
        return;
    L20:
        if (r106.length < this.f530028a) goto L21;
        return;
    }
}
