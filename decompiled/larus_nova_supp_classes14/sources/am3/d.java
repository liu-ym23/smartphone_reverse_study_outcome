package am3;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class d<T extends InputStream> extends e {
    public final byte[] b;
    public final T c;
    public final int d;
    public int e;

    @Override // am3.f
    public void a() {
        throw new UnsupportedOperationException("reread not supported");
    }

    @Override // am3.f
    public f b() {
        throw new UnsupportedOperationException("buffered not supported");
    }

    @Override // am3.f
    public final boolean d() {
        if ((this.d - this.e) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // am3.f
    public final byte readByte() throws IOException {
        this.e++;
        return (byte) this.c.read();
    }

    @Override // am3.f
    public final void c(long r3) throws IOException {
        this.e = (int) (((long) this.e) + r3);
        this.c.skip(r3);
    }

    @Override // am3.f
    public final byte[] readByteArray(long r3) throws IOException {
        this.e = (int) (((long) this.e) + r3);
        byte[] r4 = new byte[(int) r3];
        this.c.read(r4);
        return r4;
    }

    @Override // am3.f
    public final String readUtf8(long r7) throws IOException {
        this.e = (int) (((long) this.e) + r7);
        int r1 = (int) r7;
        if (r7 <= 256) goto L5;
        byte[] r8 = new byte[r1];
        this.c.read(r8, 0, r1);
    L7:
        return new String(r8, 0, r1, e.a);
    L5:
        this.c.read(this.b, 0, r1);
        r8 = this.b;
        goto L7
    }

    @Override // am3.f
    public final void skip(long r3) throws IOException {
        this.e = (int) (((long) this.e) + r3);
        this.c.skip(r3);
    }

    public d(T r2, int r3, int r4) {
        this.b = new byte[256];
        this.c = r2;
        this.e = r3;
        this.d = r4;
    }
}
