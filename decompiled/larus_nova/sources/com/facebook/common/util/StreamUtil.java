package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes22.dex */
public class StreamUtil {
    public StreamUtil() {
    }

    public static byte[] getBytesFromStream(InputStream r100) throws IOException {
        return getBytesFromStream(r100, r100.available());
    }

    public static byte[] getBytesFromStream(InputStream r100, final int r101) throws IOException {
        ByteArrayOutputStream r102 = new AnonymousClass1(r101);
        ByteStreams.copy(r100, r102);
        return r102.toByteArray();
    }

    public static long skip(InputStream r100, long r101) throws IOException {
        Preconditions.checkNotNull(r100);
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102);
        long r103 = r101;
    L8:
        if (r103 <= 0) goto L21;
        long r104 = r100.skip(r103);
        if (r104 > 0) goto L11;
        if (r100.read() == (-1)) goto L16;
        r104 = 1;
        goto L11
    L16:
        return r101 - r103;
    L11:
        r103 = r103 - r104;
        goto L8
    L21:
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
