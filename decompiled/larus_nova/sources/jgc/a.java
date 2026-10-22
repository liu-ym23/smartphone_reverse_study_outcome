package jgc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f499057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f499058b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (read(this.f499057a, 0, 1) == 1) goto L7;
        return -1;
    L7:
        return this.f499057a[0];
    }

    public a(PolarisFileInputStreamWrapper r100) {
        super(r100);
        this.f499057a = new byte[1];
        this.f499058b = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = super.read(r100, r101, r102);
        if (r103 == (-1)) goto L5;
        this.f499058b += (long) r102;
    L5:
        return r103;
    }
}
