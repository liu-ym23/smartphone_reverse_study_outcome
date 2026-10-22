package am3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends InputStream {
    public final InputStream a;
    public final C0002a b;
    public int c;

    /* JADX INFO: renamed from: am3.a$a, reason: collision with other inner class name */
    public static final class C0002a extends ByteArrayOutputStream {
        public C0002a() {
        }

        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public final int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        int r0 = this.b.getCount();
        int r1 = this.c;
        if (r1 >= r0) goto L5;
        int r2 = r0 - r1;
    L7:
        return r2 + this.a.available();
    L5:
        r2 = 0;
        goto L7
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.c >= this.b.getCount()) goto L6;
        byte[] r0 = this.b.a();
        int r1 = this.c;
        this.c = r1 + 1;
        return r0[r1];
    L6:
        int r2 = this.a.read();
        if (r2 < 0) goto L9;
        this.b.write(r2);
        this.c++;
    L9:
        return r2;
    }

    public a(InputStream r1) {
        this.a = r1;
        this.b = new C0002a();
        this.c = 0;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) throws IOException {
        int r0 = (int) r5;
        int r1 = this.b.getCount();
        int r2 = this.c;
        if (r2 >= r1) goto L5;
        int r3 = r1 - r2;
    L6:
        if (r0 > r3) goto L9;
        this.c = r2 + r0;
        return r5;
    L9:
        this.c = r2 + r3;
        byte[] r6 = new byte[r0 - r3];
        int r7 = this.a.read(r6);
        if (r7 <= 0) goto L13;
        this.b.write(r6, 0, r7);
        this.c += r7;
    L13:
        return r7;
    L5:
        r3 = 0;
        goto L6
    }

    public a(a r2, int r3) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r3;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r4, int r5, int r6) throws IOException {
        int r0 = this.b.getCount();
        int r1 = this.c;
        if (r1 >= r0) goto L5;
        int r2 = r0 - r1;
    L6:
        if (r2 > 0) goto L11;
        r6 = this.a.read(r4, r5, r6);
        if (r6 <= 0) goto L10;
        this.b.write(r4, r5, r6);
    L17:
        this.c += r6;
        return r6;
    L10:
        r6 = 0;
        goto L17
    L11:
        if (r2 < r6) goto L13;
        System.arraycopy(this.b.a(), this.c, r4, r5, r6);
        goto L17
    L13:
        System.arraycopy(this.b.a(), this.c, r4, r5, r2);
        int r7 = this.a.read(r4, r5, r6 - r2);
        if (r7 <= 0) goto L16;
        this.b.write(r4, r5, r7);
        r6 = r7 + r2;
        goto L17
    L16:
        r6 = r2;
        goto L17
    L5:
        r2 = 0;
        goto L6
    }
}
