package e17;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f470706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f470707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f470708c;

    public b() {
    }

    public static void b(short[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = 1024;
        r101 = r101 + 1;
        goto L4
    }

    public final int a(short[] r100, int r101) throws IOException {
        short r102 = r100[r101];
        int r103 = this.f470706a;
        int r104 = (r103 >>> 11) * r102;
        int r105 = this.f470707b;
        if ((r105 ^ Integer.MIN_VALUE) >= (Integer.MIN_VALUE ^ r104)) goto L9;
        this.f470706a = r104;
        r100[r101] = (short) (r102 + ((2048 - r102) >>> 5));
        if ((r104 & (-16777216)) != 0) goto L14;
        this.f470707b = (r105 << 8) | this.f470708c.read();
        this.f470706a <<= 8;
        return 0;
    L14:
        return 0;
    L9:
        int r106 = r103 - r104;
        this.f470706a = r106;
        int r107 = r105 - r104;
        this.f470707b = r107;
        r100[r101] = (short) (r102 - (r102 >>> 5));
        if ((r106 & (-16777216)) != 0) goto L15;
        this.f470707b = (r107 << 8) | this.f470708c.read();
        this.f470706a <<= 8;
        return 1;
    L15:
        return 1;
    }
}
