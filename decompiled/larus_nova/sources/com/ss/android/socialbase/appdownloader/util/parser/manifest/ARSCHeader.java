package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes38.dex */
public class ARSCHeader {
    private static final Logger LOGGER = null;
    public static final short RES_NONE_TYPE = -1;
    public static final short RES_NULL_TYPE = 0;
    public static final short RES_STRING_POOL_TYPE = 1;
    public static final short RES_TABLE_TYPE = 2;
    public static final short RES_XML_CDATA_TYPE = 260;
    public static final short RES_XML_END_ELEMENT_TYPE = 259;
    public static final short RES_XML_END_NAMESPACE_TYPE = 257;
    public static final short RES_XML_FIRST_CHUNK_TYPE = 256;
    public static final short RES_XML_LAST_CHUNK_TYPE = 383;
    public static final short RES_XML_RESOURCE_MAP_TYPE = 384;
    public static final short RES_XML_START_ELEMENT_TYPE = 258;
    public static final short RES_XML_START_NAMESPACE_TYPE = 256;
    public static final short RES_XML_TYPE = 3;
    public static final short XML_TYPE_LIBRARY = 515;
    public static final short XML_TYPE_OVERLAY = 516;
    public static final short XML_TYPE_OVERLAY_POLICY = 517;
    public static final short XML_TYPE_PACKAGE = 512;
    public static final short XML_TYPE_SPEC_TYPE = 514;
    public static final short XML_TYPE_STAGED_ALIAS = 518;
    public static final short XML_TYPE_TYPE = 513;
    public final int chunkSize;
    public final int endPosition;
    public final int headerSize;
    public final int startPosition;
    public final short type;

    static {
        LOGGER = Logger.getLogger(ARSCHeader.class.getName());
    }

    public static ARSCHeader read(ExtCountingDataInput r100) throws IOException {
        int r101 = r100.position();
        short r102 = r100.readShort();     // Catch: EOFException -> L6
        return new ARSCHeader(r102, r100.readShort(), r100.readInt(), r101);
    L7:
        return new ARSCHeader(-1, 0, 0, r100.position());
    }

    public void checkForUnreadHeader(ExtCountingDataInput r100) throws IOException {
        int r101 = r100.position() - this.startPosition;
        int r102 = this.headerSize - r101;
        if (r102 <= 0) goto L9;
        byte[] r103 = new byte[r102];
        r100.readFully(r103);
        BigInteger r104 = new BigInteger(1, r103);
        if (r104.equals(BigInteger.ZERO) == false) goto L7;
        LOGGER.fine(String.format("Chunk header size (%d), read (%d), but exceeding bytes are all zero.", new Object[]{Integer.valueOf(this.headerSize), Integer.valueOf(r101)}));
        return;
    L7:
        LOGGER.warning(String.format("Chunk header size (%d), read (%d). Exceeding bytes: 0x%X.", new Object[]{Integer.valueOf(this.headerSize), Integer.valueOf(r101), r104}));
        return;
    }

    public void skipChunk(ExtDataInput r100) throws IOException {
        r100.skipBytes(this.chunkSize - this.headerSize);
    }

    public ARSCHeader(short r100, int r101, int r102, int r103) {
        this.type = r100;
        this.headerSize = r101;
        this.chunkSize = r102;
        this.startPosition = r103;
        this.endPosition = r103 + r102;
    }
}
