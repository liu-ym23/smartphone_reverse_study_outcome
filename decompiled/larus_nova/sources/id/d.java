package id;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f489282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f489283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f489284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f489285d;

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f489284c < this.f489282a) goto L6;
        return -1;
    L6:
        long r100 = System.nanoTime();
        int r101 = this.f489283b.read();
        this.f489285d += System.nanoTime() - r100;
        if (r101 < 0) goto L9;
        this.f489284c++;
    L9:
        return r101;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    public d(int r100, InputStream r101) {
        this.f489284c = 0;
        this.f489282a = r100;
        this.f489283b = r101;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.f489282a - this.f489284c;
        if (r103 > 0) goto L6;
        return -1;
    L6:
        if (r103 >= r102) goto L8;
        r102 = r103;
    L8:
        long r104 = System.nanoTime();
        int r105 = this.f489283b.read(r100, r101, r102);
        this.f489285d += System.nanoTime() - r104;
        if (r105 < 0) goto L11;
        this.f489284c += r105;
    L11:
        return r105;
    }
}
