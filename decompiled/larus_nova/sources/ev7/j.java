package ev7;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f474486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f474487b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (read(this.f474487b, 0, 1) == 1) goto L5;
        return -1;
    L5:
        return this.f474487b[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(@Nonnull byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    public j(InputStream r100, long r101) {
        super(r100);
        this.f474487b = new byte[1];
        if (r101 < 0) goto L7;
        this.f474486a = r101;
        return;
    L7:
        throw new IllegalArgumentException("numToRead must be >= 0: " + r101);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(@Nonnull byte[] r100, int r101, int r102) throws IOException {
        long r103 = this.f474486a;
        if (r103 != 0) goto L6;
        return -1;
    L6:
        int r104 = ((FilterInputStream) this).in.read(r100, r101, (int) Math.min(r102, r103));
        if (r104 <= 0) goto L9;
        this.f474486a -= (long) r104;
    L9:
        return r104;
    }
}
