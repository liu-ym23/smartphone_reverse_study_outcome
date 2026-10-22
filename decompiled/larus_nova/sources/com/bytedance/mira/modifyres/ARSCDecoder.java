package com.bytedance.mira.modifyres;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes21.dex */
public class ARSCDecoder {
    private static final short ENTRY_FLAG_COMPLEX = 1;
    private static final int KNOWN_CONFIG_BYTES = 56;
    private static final Logger LOGGER = null;
    private final byte[] mBytes;
    private final CountingInputStream mCountIn;
    private Header mHeader;
    private final ExtDataInput mIn;
    private final IResIdMapper mMapper;

    public static class Header {
        public static final short TYPE_LIBRARY = 515;
        public static final short TYPE_NONE = -1;
        public static final short TYPE_PACKAGE = 512;
        public static final short TYPE_SPEC_TYPE = 514;
        public static final short TYPE_TABLE = 2;
        public static final short TYPE_TYPE = 513;
        public final int chunkSize;
        public final int endPosition;
        public final int headerSize;
        public final int startPosition;
        public final short type;

        public static Header read(ExtDataInput r100, CountingInputStream r101) throws IOException {
            int r102 = r101.getCount();
            short r103 = r100.readShort();     // Catch: EOFException -> L6
            return new Header(r103, r100.readShort(), r100.readInt(), r102);
        L7:
            return new Header(-1, 0, 0, r101.getCount());
        }

        public Header(short r100, int r101, int r102, int r103) {
            this.type = r100;
            this.headerSize = r101;
            this.chunkSize = r102;
            this.startPosition = r103;
            this.endPosition = r103 + r102;
        }
    }

    private char[] unpackLanguageOrRegion(byte r100, byte r101, char r102) {
        if (((r100 >> 7) & 1) != 1) goto L7;
        return new char[]{(char) ((r101 & 31) + r102), (char) ((((r101 & 224) >> 5) + ((r100 & 3) << 3)) + r102), (char) (((r100 & 124) >> 2) + r102)};
    L7:
        return new char[]{(char) r100, (char) r101};
    }

    public void readTableHeader() throws IOException {
        nextChunkCheckType(2);
        int r100 = this.mIn.readInt();
        StringBlock.read(this.mIn);
        nextChunk();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        readTablePackage();
        r101 = r101 + 1;
        goto L3
    }

    static {
        LOGGER = Logger.getLogger(ARSCDecoder.class.getName());
    }

    private Header nextChunk() throws IOException {
        Header r100 = Header.read(this.mIn, this.mCountIn);
        this.mHeader = r100;
        return r100;
    }

    private void readComplexEntry() throws IOException {
        int r100 = ResReplaceUtils.getCount(this.mIn);
        int r101 = this.mIn.readInt();
        ResReplaceUtils.replaceResId(this.mBytes, r101, r100, this.mMapper);
        int r102 = this.mIn.readInt();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = ResReplaceUtils.getCount(this.mIn);
        int r105 = this.mIn.readInt();
        ResReplaceUtils.replaceResId(this.mBytes, r105, r104, this.mMapper);
        readValue();
        r103 = r103 + 1;
        goto L3
    }

    private void readConfigFlags() throws IOException {
        int r100 = this.mIn.readInt();
        int r101 = 28;
        if (r100 < 28) goto L31;
        this.mIn.readShort();
        this.mIn.readShort();
        unpackLanguageOrRegion(this.mIn.readByte(), this.mIn.readByte(), 'a');
        int r102 = 48;
        unpackLanguageOrRegion(this.mIn.readByte(), this.mIn.readByte(), '0');
        this.mIn.readByte();
        this.mIn.readByte();
        this.mIn.readUnsignedShort();
        this.mIn.readByte();
        this.mIn.readByte();
        this.mIn.readByte();
        this.mIn.skipBytes(1);
        this.mIn.readShort();
        this.mIn.readShort();
        this.mIn.readShort();
        this.mIn.skipBytes(2);
        if (r100 < 32) goto L8;
        this.mIn.readByte();
        this.mIn.readByte();
        this.mIn.readShort();
        r101 = 32;
    L8:
        if (r100 < 36) goto L11;
        this.mIn.readShort();
        this.mIn.readShort();
        r101 = 36;
    L11:
        if (r100 < 48) goto L13;
        readScriptOrVariantChar(4).toCharArray();
        readScriptOrVariantChar(8).toCharArray();
    L15:
        if (r100 < 52) goto L18;
        this.mIn.readByte();
        this.mIn.readByte();
        this.mIn.skipBytes(2);
        r102 = 52;
    L18:
        if (r100 < 56) goto L20;
        this.mIn.skipBytes(4);
        r102 = 56;
    L20:
        int r103 = r100 - 56;
        if (r103 <= 0) goto L26;
        byte[] r104 = new byte[r103];
        r102 = r102 + r103;
        this.mIn.readFully(r104);
        BigInteger r105 = new BigInteger(1, r104);
        if (r105.equals(BigInteger.ZERO) == false) goto L25;
        LOGGER.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", new Object[]{56}));
        goto L26
    L25:
        LOGGER.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", new Object[]{56, Integer.valueOf(r100), r105}));
    L26:
        int r106 = r100 - r102;
        if (r106 <= 0) goto L32;
        this.mIn.skipBytes(r106);
        return;
    L32:
        return;
    L13:
        r102 = r101;
        goto L15
    L31:
        throw new RuntimeException("Config size < 28");
    }

    private void readEntryData() throws IOException {
        if (this.mIn.readShort() < 0) goto L10;
        short r100 = this.mIn.readShort();
        this.mIn.readInt();
        if ((r100 & 1) != 0) goto L7;
        readValue();
        return;
    L7:
        readComplexEntry();
        return;
    L10:
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    private void readLibraryType() throws IOException {
        checkChunkType(515);
        int r100 = this.mIn.readInt();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L6;
        this.mIn.readInt();
        this.mIn.skipBytes(256);
        r101 = r101 + 1;
    L6:
        if (nextChunk().type != 513) goto L8;
        readTableTypeSpec();
        goto L6
    }

    private void readSingleTableTypeSpec() throws IOException {
        checkChunkType(514);
        this.mIn.readUnsignedByte();
        this.mIn.skipBytes(3);
        int r100 = this.mIn.readInt();
        this.mIn.skipBytes(r100 * 4);
    }

    private void readTablePackage() throws IOException {
        checkChunkType(512);
        this.mIn.readInt();
        this.mIn.skipBytes(256);
        this.mIn.skipInt();
        this.mIn.skipInt();
        this.mIn.skipInt();
        this.mIn.skipInt();
        if (this.mHeader.headerSize == 288) goto L5;
    L9:
        StringBlock.read(this.mIn);
        StringBlock.read(this.mIn);
        nextChunk();
        boolean r100 = true;
    L10:
        if (r100 == false) goto L18;
        short r101 = this.mHeader.type;
        if (r101 != 514) goto L14;
        readTableTypeSpec();
        goto L10
    L14:
        if (r101 != 515) goto L15;
        readLibraryType();
        goto L10
    L15:
        r100 = false;
        goto L10
    L18:
        return;
    L5:
        if (this.mIn.readInt() <= 0) goto L9;
        throw new RuntimeException("don't support");
    }

    private void readTableType() throws IOException {
        checkChunkType(513);
        this.mIn.readUnsignedByte();
        this.mIn.readByte();
        this.mIn.skipBytes(2);
        int r100 = this.mIn.readInt();
        int r101 = this.mIn.readInt();
        readConfigFlags();
        int r102 = (this.mHeader.startPosition + r101) - (r100 * 4);
        if (r102 == this.mCountIn.getCount()) goto L5;
        LOGGER.warning("Invalid data detected. Skipping: " + (r102 - this.mCountIn.getCount()) + " byte(s)");
        this.mIn.skipBytes(r102 - this.mCountIn.getCount());
    L5:
        int[] r103 = this.mIn.readIntArray(r100);
        HashSet r104 = new HashSet();
        int r105 = r103.length;
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L14;
        int r107 = r103[r106];
        if (r107 == (-1)) goto L13;
        if (r104.contains(Integer.valueOf(r107)) == true) goto L13;
        readEntryData();
        r104.add(Integer.valueOf(r107));
    L13:
        r106 = r106 + 1;
        goto L6
    }

    private void readValue() throws IOException {
        this.mIn.skipCheckShort(8);
        this.mIn.skipCheckByte((byte) 0);
        byte r100 = this.mIn.readByte();
        int r101 = ResReplaceUtils.getCount(this.mIn);
        int r102 = this.mIn.readInt();
        if (r100 != 1) goto L6;
        ResReplaceUtils.replaceResId(this.mBytes, r102, r101, this.mMapper);
    L6:
        if (r100 != 2) goto L9;
        ResReplaceUtils.replaceResId(this.mBytes, r102, r101, this.mMapper);
        return;
    }

    private void readTableTypeSpec() throws IOException {
        readSingleTableTypeSpec();
        short r100 = nextChunk().type;
    L4:
        if (r100 != 514) goto L7;
        readSingleTableTypeSpec();
        r100 = nextChunk().type;
    L7:
        if (r100 != 513) goto L12;
        readTableType();
        if (this.mCountIn.getCount() >= this.mHeader.endPosition) goto L11;
        LOGGER.warning("Unknown data detected. Skipping: " + (this.mHeader.endPosition - this.mCountIn.getCount()) + " byte(s)");
        CountingInputStream r101 = this.mCountIn;
        r101.skip((long) (this.mHeader.endPosition - r101.getCount()));
    L11:
        r100 = nextChunk().type;
        goto L7
    }

    private void checkChunkType(int r100) {
        if (this.mHeader.type != r100) goto L6;
        return;
    L6:
        throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", new Object[]{Integer.valueOf(r100), Short.valueOf(this.mHeader.type)}));
    }

    private void nextChunkCheckType(int r100) throws IOException {
        nextChunk();
        checkChunkType(r100);
    }

    private String readScriptOrVariantChar(int r100) throws IOException {
        StringBuilder r101 = new StringBuilder(16);
    L3:
        int r102 = r100 - 1;
        if (r100 == 0) goto L9;
        short r103 = this.mIn.readByte();
        if (r103 == 0) goto L9;
        r101.append((char) r103);
        r100 = r102;
    L9:
        this.mIn.skipBytes(r102);
        return r101.toString();
    }

    public ARSCDecoder(byte[] r100, IResIdMapper r101) {
        CountingInputStream r102 = new CountingInputStream(new ByteArrayInputStream(r100));
        this.mCountIn = r102;
        this.mIn = new ExtDataInput(new LittleEndianDataInputStream(r102));
        this.mBytes = r100;
        this.mMapper = r101;
    }
}
