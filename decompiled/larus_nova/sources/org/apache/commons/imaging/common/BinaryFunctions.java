package org.apache.commons.imaging.common;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes42.dex */
public final class BinaryFunctions {
    private static final Logger LOGGER = null;

    public static int charsToQuad(char r100, char r101, char r102, char r103) {
        return ((((r100 & 255) << 24) | ((r101 & 255) << 16)) | ((r102 & 255) << 8)) | ((r103 & 255) << 0);
    }

    static {
        LOGGER = Logger.getLogger(BinaryFunctions.class.getName());
    }

    private BinaryFunctions() {
    }

    public static int read4Bytes(String r100, InputStream r101, String r102, ByteOrder r103) throws IOException {
        int r104 = r101.read();
        int r105 = r101.read();
        int r106 = r101.read();
        int r107 = r101.read();
        if ((((r104 | r105) | r106) | r107) < 0) goto L10;
        if (r103 == ByteOrder.BIG_ENDIAN) goto L11;
        int r108 = r104 << 0;
        return r108 | (((r107 << 24) | (r106 << 16)) | (r105 << 8));
    L11:
        return (((r104 << 24) | (r105 << 16)) | (r106 << 8)) | (r107 << 0);
    L10:
        throw new IOException(r102);
    }
}
