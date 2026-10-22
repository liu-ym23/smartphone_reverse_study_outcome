package kqc;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public final class i extends h {
    public i(k r100) {
        super(r100);
    }

    public final void a(int r100) throws IOException {
        int r101 = readInt();
        if (r101 != r100) goto L5;
    L11:
        a(-1);
        return;
    L5:
        if (r101 < 1835009) goto L11;
        if (r101 != 1835009) goto L10;
        return;
    L10:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{1835009, Integer.valueOf(r101)}));
    }

    @Override // kqc.h, java.io.DataInput
    public final int skipBytes(int r100) throws IOException {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L7;
        int r102 = super.skipBytes(r100 - r101);
        if (r102 <= 0) goto L7;
        r101 = r101 + r102;
    L7:
        return r101;
    }
}
