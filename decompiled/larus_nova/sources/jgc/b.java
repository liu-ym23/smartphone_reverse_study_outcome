package jgc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f499059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f499060b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (read(this.f499059a, 0, 1) == 1) goto L7;
        return -1;
    L7:
        return this.f499059a[0];
    }

    public b(PolarisFileInputStreamWrapper r100) {
        super(r100);
        this.f499059a = new byte[1];
        this.f499060b = new CRC32();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = super.read(r100, r101, r102);
        if (r103 == (-1)) goto L5;
        this.f499060b.update(r100, r101, r103);
    L5:
        return r103;
    }
}
