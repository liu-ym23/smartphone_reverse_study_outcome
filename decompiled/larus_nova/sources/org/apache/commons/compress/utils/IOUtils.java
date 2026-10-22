package org.apache.commons.compress.utils;

import com.obric.capabilitykit.common.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public final class IOUtils {
    private static final byte[] SKIP_BUF = null;

    static {
        SKIP_BUF = new byte[4096];
    }

    public static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        return copy(r100, r101, ErrorCode.EventTask.LOCATION_SELECTED_ID_CONDITION_EMPTY);
    }

    public static int readFully(InputStream r100, byte[] r101) throws IOException {
        return readFully(r100, r101, 0, r101.length);
    }

    public static long skip(InputStream r100, long r101) throws IOException {
        long r102 = r101;
    L4:
        if (r102 <= 0) goto L10;
        long r103 = r100.skip(r102);
        if (r103 == 0) goto L10;
        r102 = r102 - r103;
    L10:
        if (r102 <= 0) goto L16;
        int r104 = readFully(r100, SKIP_BUF, 0, (int) Math.min(r102, 4096));
        if (r104 < 1) goto L16;
        r102 = r102 - ((long) r104);
    L16:
        return r101 - r102;
    }

    public static long copy(InputStream r100, OutputStream r101, int r102) throws IOException {
        if (r102 < 1) goto L10;
        byte[] r103 = new byte[r102];
        long r104 = 0;
    L5:
        int r105 = r100.read(r103);
        if ((-1) == r105) goto L8;
        r101.write(r103, 0, r105);
        r104 = r104 + ((long) r105);
        goto L5
    L8:
        return r104;
    L10:
        throw new IllegalArgumentException("buffersize must be bigger than 0");
    }

    public static int readFully(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        if (r103 < 0) goto L14;
        if (r102 < 0) goto L14;
        if ((r103 + r102) > r101.length) goto L14;
        int r104 = 0;
    L7:
        if (r104 == r103) goto L12;
        int r105 = r100.read(r101, r102 + r104, r103 - r104);
        if (r105 == (-1)) goto L12;
        r104 = r104 + r105;
    L12:
        return r104;
    L14:
        throw new IndexOutOfBoundsException();
    }
}
