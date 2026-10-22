package org.bouncycastle.asn1;

import androidx.collection.SieveCacheKt;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes42.dex */
class StreamUtil {
    private static final long MAX_MEMORY = 0;

    static {
        MAX_MEMORY = Runtime.getRuntime().maxMemory();
    }

    public StreamUtil() {
    }

    public static int calculateBodyLength(int r100) {
        int r101 = 1;
        if (r100 <= 127) goto L11;
        int r102 = 1;
    L5:
        r100 = r100 >>> 8;
        if (r100 == 0) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        int r103 = (r102 - 1) * 8;
    L9:
        if (r103 < 0) goto L11;
        r101 = r101 + 1;
        r103 = r103 - 8;
    L11:
        return r101;
    }

    public static int calculateTagLength(int r100) throws IOException {
        if (r100 >= 31) goto L5;
        return 1;
    L5:
        if (r100 >= 128) goto L7;
        return 2;
    L7:
        byte[] r101 = new byte[5];
        int r102 = 4;
        r101[4] = (byte) (r100 & 127);
    L8:
        r100 = r100 >> 7;
        r102 = r102 - 1;
        r101[r102] = (byte) ((r100 & 127) | 128);
        if (r100 > 127) goto L8;
        return 1 + (5 - r102);
    }

    public static int findLimit(InputStream r100) {
        if ((r100 instanceof LimitedInputStream) == false) goto L7;
        return ((LimitedInputStream) r100).getLimit();
    L7:
        if ((r100 instanceof ASN1InputStream) == false) goto L11;
        return ((ASN1InputStream) r100).getLimit();
    L11:
        if ((r100 instanceof ByteArrayInputStream) == false) goto L15;
        return ((ByteArrayInputStream) r100).available();
    L15:
        if ((r100 instanceof FileInputStream) == true) goto L32;
    L26:
        long r101 = MAX_MEMORY;
        if (r101 <= SieveCacheKt.NodeLinkMask) goto L31;
        return Integer.MAX_VALUE;
    L31:
        return (int) r101;
    L32:
        FileChannel r102 = ((FileInputStream) r100).getChannel();     // Catch: IOException -> L25
        if (r102 == null) goto L20;
        long r103 = r102.size();     // Catch: IOException -> L25
    L22:
        if (r103 >= SieveCacheKt.NodeLinkMask) goto L26;
        return (int) r103;
    L20:
        r103 = 2147483647L;
        goto L22
    }
}
