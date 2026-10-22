package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes38.dex */
public class StringBlock {
    private static final Logger LOGGER = null;
    private static final int STRING_BLOCK_HEADER_SIZE = 28;
    private static final int UTF8_FLAG = 256;
    private final CharsetDecoder CESU8_DECODER;
    private final CharsetDecoder UTF16LE_DECODER;
    private final CharsetDecoder UTF8_DECODER;
    private boolean mIsUtf8;
    private int[] mStringOffsets;
    private byte[] mStrings;
    private int[] mStyleOffsets;
    private int[] mStyles;

    static {
        LOGGER = Logger.getLogger(StringBlock.class.getName());
    }

    private StringBlock() {
        this.UTF16LE_DECODER = StandardCharsets.UTF_16LE.newDecoder();
        this.UTF8_DECODER = StandardCharsets.UTF_8.newDecoder();
        this.CESU8_DECODER = Charset.forName("CESU8").newDecoder();
    }

    private int[] getStyle(int r100) {
        int[] r101 = this.mStyleOffsets;
        int[] r102 = null;
        if (r101 != null) goto L5;
    L27:
        return r102;
    L5:
        if (this.mStyles == null) goto L27;
        if (r100 >= r101.length) goto L27;
        int r103 = r101[r100] / 4;
        int r104 = 0;
        int r105 = r103;
        int r106 = 0;
    L10:
        int[] r107 = this.mStyles;
        if (r105 >= r107.length) goto L16;
        if (r107[r105] == (-1)) goto L16;
        r106 = r106 + 1;
        r105 = r105 + 1;
    L16:
        if (r106 == 0) goto L27;
        if ((r106 % 3) != 0) goto L27;
        r102 = new int[r106];
    L21:
        int[] r108 = this.mStyles;
        if (r103 >= r108.length) goto L27;
        int r109 = r108[r103];
        if (r109 == (-1)) goto L27;
        r103 = r103 + 1;
        r102[r104] = r109;
        r104 = r104 + 1;
        goto L21
    }

    public static StringBlock readWithChunk(ExtCountingDataInput r100) throws IOException {
        int r101 = r100.position();
        r100.skipCheckShort(1);
        return readWithoutChunk(r100, r101, r100.readShort(), r100.readInt());
    }

    public int find(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = 0;
    L6:
        int[] r102 = this.mStringOffsets;
        if (r101 == r102.length) goto L20;
        int r103 = r102[r101];
        int r104 = getShort(this.mStrings, r103);
        if (r104 != r100.length()) goto L19;
        int r105 = 0;
    L12:
        if (r105 == r104) goto L17;
        r103 = r103 + 2;
        if (r100.charAt(r105) != getShort(this.mStrings, r103)) goto L17;
        r105 = r105 + 1;
    L17:
        if (r105 != r104) goto L19;
        return r101;
    L19:
        r101 = r101 + 1;
        goto L6
    L20:
        return -1;
    }

    public String getString(int r100) {
        if (r100 < 0) goto L14;
        int[] r101 = this.mStringOffsets;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 >= r101.length) goto L17;
        int r102 = r101[r100];
        if (this.mIsUtf8 == false) goto L11;
        int[] r103 = getUtf8(this.mStrings, r102);
        int r104 = r103[0];
    L13:
        return decodeString(r104, r103[1]);
    L11:
        int[] r105 = getUtf16(this.mStrings, r102);
        r104 = r102 + r105[0];
        r103 = r105;
        goto L13
    L17:
        return null;
    L14:
        return null;
    }

    private static int getShort(byte[] r100, int r101) {
        int r102 = (r100[r101 + 1] & UByte.MAX_VALUE) << 8;
        return (r100[r101] & UByte.MAX_VALUE) | r102;
    }

    private static int[] getUtf16(byte[] r100, int r101) {
        int r102 = ((r100[r101 + 1] & UByte.MAX_VALUE) << 8) | (r100[r101] & UByte.MAX_VALUE);
        if ((32768 & r102) == 0) goto L7;
        return new int[]{4, (((r102 & 32767) << 16) + (((r100[r101 + 3] & UByte.MAX_VALUE) << 8) + (r100[r101 + 2] & UByte.MAX_VALUE))) * 2};
    L7:
        return new int[]{2, r102 * 2};
    }

    private static int[] getUtf8(byte[] r100, int r101) {
        if ((r100[r101] & 128) == 0) goto L5;
        int r102 = r101 + 2;
    L6:
        int r103 = r100[r102];
        int r104 = r102 + 1;
        if ((r103 & 128) == 0) goto L10;
        r103 = ((r103 & 127) << 8) + (r100[r104] & 255);
        r104 = r104 + 1;
    L10:
        return new int[]{r104, r103};
    L5:
        r102 = r101 + 1;
        goto L6
    }

    public String decodeString(int r100, int r101) {
        ByteBuffer r102 = ByteBuffer.wrap(this.mStrings, r100, r101);     // Catch: IndexOutOfBoundsException -> L9 CharacterCodingException -> L13
        if (this.mIsUtf8 == false) goto L6;
        CharsetDecoder r103 = this.UTF8_DECODER;     // Catch: IndexOutOfBoundsException -> L9 CharacterCodingException -> L13
    L7:
        return r103.decode(r102).toString();
    L6:
        r103 = this.UTF16LE_DECODER;     // Catch: IndexOutOfBoundsException -> L9 CharacterCodingException -> L13
    L10:
        if (this.mIsUtf8 == true) goto L21;
        LOGGER.warning("String extends outside of pool at  " + r100 + " of length " + r101);
        return null;
    L21:
        return this.CESU8_DECODER.decode(ByteBuffer.wrap(this.mStrings, r100, r101)).toString();
    L19:
        LOGGER.warning("Failed to decode a string with CESU-8 decoder.");
        return null;
    L14:
        if (this.mIsUtf8 == true) goto L21;
        LOGGER.warning("Failed to decode a string at offset " + r100 + " of length " + r101);
        return null;
    }

    public static StringBlock readWithoutChunk(ExtCountingDataInput r100, int r110, int r111, int r112) throws IOException {
        int r101 = r100.readInt();
        int r102 = r100.readInt();
        int r103 = r100.readInt();
        int r104 = r100.readInt();
        int r105 = r100.readInt();
        if (r111 <= 28) goto L5;
        r100.skipBytes(r111 - 28);
    L5:
        StringBlock r113 = new StringBlock();
        boolean r106 = false;
        if ((r103 & 256) == 0) goto L8;
        boolean r107 = true;
    L9:
        r113.mIsUtf8 = r107;
        r113.mStringOffsets = r100.readSafeIntArray(r101, r110 + r104);
        if (r102 == 0) goto L12;
        r113.mStyleOffsets = r100.readSafeIntArray(r102, r110 + r105);
    L12:
        if (r105 == 0) goto L15;
        if (r102 == 0) goto L15;
        r106 = true;
    L15:
        int r114 = r112 - r104;
        if (r102 <= 0) goto L18;
        r114 = r105 - r104;
    L18:
        byte[] r108 = new byte[r114];
        r113.mStrings = r108;
        r100.readFully(r108);
        if (r106 == false) goto L21;
        r114 = r112 - r105;
        r113.mStyles = r100.readIntArray(r114 / 4);
    L21:
        int r115 = r114 % 4;
        if (r115 < 1) goto L26;
    L23:
        int r116 = r115 - 1;
        if (r115 <= 0) goto L26;
        r100.readByte();
        r115 = r116;
    L26:
        return r113;
    L8:
        r107 = false;
        goto L9
    }
}
