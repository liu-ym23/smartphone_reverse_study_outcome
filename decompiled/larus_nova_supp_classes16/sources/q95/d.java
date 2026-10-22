package q95;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends FilterInputStream {
    public int a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        int r0 = this.a;
        if (r0 != Integer.MIN_VALUE) goto L6;
        return super.available();
    L6:
        return Math.min(r0, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1) != (-1)) goto L6;
        return -1;
    L6:
        int r2 = super.read();
        b(1);
        return r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        super.reset();
        this.a = ShareItemModel.SRC_TINT_UNDEFINED;
    }

    public d(c r1) {
        super(r1);
        this.a = ShareItemModel.SRC_TINT_UNDEFINED;
    }

    public final long a(long r5) {
        int r0 = this.a;
        if (r0 != 0) goto L7;
        return -1;
    L7:
        if (r0 != Integer.MIN_VALUE) goto L9;
        return r5;
    L9:
        if (r5 > r0) goto L11;
        return r5;
    L11:
        return r0;
    }

    public final void b(long r5) {
        int r0 = this.a;
        if (r0 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        this.a = (int) (((long) r0) - r5);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int r1) {
        super.mark(r1);
        this.a = r1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long r4) throws IOException {
        long r5 = a(r4);
        if (r5 != (-1)) goto L5;
        return -1;
    L5:
        long r6 = super.skip(r5);
        b(r6);
        return r6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] r3, int r4, int r5) throws IOException {
        int r6 = (int) a(r5);
        if (r6 != (-1)) goto L5;
        return -1;
    L5:
        int r7 = super.read(r3, r4, r6);
        b(r7);
        return r7;
    }
}
