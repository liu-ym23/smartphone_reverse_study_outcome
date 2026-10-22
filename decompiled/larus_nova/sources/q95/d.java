package q95;

import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f532105a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        int r100 = this.f532105a;
        if (r100 != Integer.MIN_VALUE) goto L6;
        return super.available();
    L6:
        return Math.min(r100, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1) != (-1)) goto L6;
        return -1;
    L6:
        int r100 = super.read();
        b(1);
        return r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        super.reset();
        this.f532105a = Integer.MIN_VALUE;
    }

    public d(c r100) {
        super(r100);
        this.f532105a = Integer.MIN_VALUE;
    }

    public final long a(long r100) {
        int r101 = this.f532105a;
        if (r101 != 0) goto L7;
        return -1;
    L7:
        if (r101 != Integer.MIN_VALUE) goto L9;
        return r100;
    L9:
        if (r100 > r101) goto L11;
        return r100;
    L11:
        return r101;
    }

    public final void b(long r100) {
        int r101 = this.f532105a;
        if (r101 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r100 == (-1)) goto L9;
        this.f532105a = (int) (((long) r101) - r100);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int r100) {
        super.mark(r100);
        this.f532105a = r100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r100) throws IOException {
        long r101 = a(r100);
        if (r101 != (-1)) goto L5;
        return -1;
    L5:
        long r102 = super.skip(r101);
        b(r102);
        return r102;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = (int) a(r102);
        if (r103 != (-1)) goto L5;
        return -1;
    L5:
        int r104 = super.read(r100, r101, r103);
        b(r104);
        return r104;
    }
}
