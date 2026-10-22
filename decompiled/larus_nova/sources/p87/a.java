package p87;

import java.io.DataInput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f528195a = null;

    static {
        f528195a = new byte[]{108, 116, 108, 111, 118, 101, 122, 104};
    }

    public static boolean a(byte[] r100) {
        if (r100.length == 8) goto L5;
        return false;
    L5:
        int r101 = 0;
    L6:
        if (r101 >= 8) goto L11;
        if (r100[r101] != f528195a[r101]) goto L9;
        r101 = r101 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static short b(DataInput r100) throws IOException {
        byte[] r101 = new byte[2];
        ((RandomAccessFile) r100).readFully(r101);
        return ByteBuffer.wrap(r101).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }
}
