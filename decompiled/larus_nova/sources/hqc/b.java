package hqc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f486842a;

    public final int a() throws IOException {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 == 32) goto L10;
        int r102 = this.f486842a.read();
        if (r102 == (-1)) goto L9;
        r101 = r101 | (r102 << r100);
        r100 = r100 + 8;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return r101;
    }

    public final void d() throws IOException {
        if (this.f486842a.skip(4) != 4) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public b(InputStream r100) {
        this.f486842a = r100;
    }

    public final int[] b(int r100) throws IOException {
        int[] r101 = new int[r100];
        int r102 = 0;
    L3:
        if (r100 <= 0) goto L5;
        r101[r102] = a();
        r100 = r100 - 1;
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public final void c(int r100) throws IOException {
        int r101 = a();
        if (r101 != r100) goto L6;
        return;
    L6:
        throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));
    }
}
