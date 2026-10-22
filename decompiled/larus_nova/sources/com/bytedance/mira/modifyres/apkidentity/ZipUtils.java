package com.bytedance.mira.modifyres.apkidentity;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes3.dex */
public class ZipUtils {
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER = 1347094023;
    private static final int ZIP64_EOCD_LOCATOR_SIZE = 20;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_SIZE_FIELD_OFFSET = 12;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    private ZipUtils() {
    }

    private static void assertByteOrderLittleEndian(ByteBuffer r100) {
        if (r100.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static int findZipEndOfCentralDirectoryRecord(ByteBuffer r100) {
        assertByteOrderLittleEndian(r100);
        int r101 = r100.capacity();
        if (r101 >= 22) goto L5;
        return -1;
    L5:
        int r102 = r101 - 22;
        int r103 = Math.min(r102, 65535);
        int r104 = 0;
    L6:
        if (r104 > r103) goto L13;
        int r105 = r102 - r104;
        if (r100.getInt(r105) != ZIP_EOCD_REC_SIG) goto L12;
        if (getUnsignedInt16(r100, r105 + 20) != r104) goto L12;
        return r105;
    L12:
        r104 = r104 + 1;
        goto L6
    L13:
        return -1;
    }

    public static long getZipEocdCentralDirectoryOffset(ByteBuffer r100) {
        assertByteOrderLittleEndian(r100);
        return getUnsignedInt32(r100, r100.position() + 16);
    }

    public static long getZipEocdCentralDirectorySizeBytes(ByteBuffer r100) {
        assertByteOrderLittleEndian(r100);
        return getUnsignedInt32(r100, r100.position() + 12);
    }

    public static void safeCloseZipFile(ZipFile r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: Throwable -> L6
        return;
    }

    public static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(RandomAccessFile r100) throws IOException {
        if (r100.length() >= 22) goto L6;
        return null;
    L6:
        Pair<ByteBuffer, Long> r101 = findZipEndOfCentralDirectoryRecord(r100, 0);
        if (r101 == null) goto L10;
        return r101;
    L10:
        return findZipEndOfCentralDirectoryRecord(r100, 65535);
    }

    private static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(RandomAccessFile r100, int r101) throws IOException {
        if (r101 < 0) goto L14;
        if (r101 > 65535) goto L14;
        long r102 = r100.length();
        if (r102 >= 22) goto L8;
        return null;
    L8:
        ByteBuffer r103 = ByteBuffer.allocate(((int) Math.min(r101, r102 - 22)) + 22);
        ByteOrder r104 = ByteOrder.LITTLE_ENDIAN;
        r103.order(r104);
        long r105 = r102 - ((long) r103.capacity());
        r100.seek(r105);
        r100.readFully(r103.array(), r103.arrayOffset(), r103.capacity());
        int r106 = findZipEndOfCentralDirectoryRecord(r103);
        if (r106 != (-1)) goto L11;
        return null;
    L11:
        r103.position(r106);
        ByteBuffer r107 = r103.slice();
        r107.order(r104);
        return Pair.create(r107, Long.valueOf(r105 + ((long) r106)));
    L14:
        throw new IllegalArgumentException("maxCommentSize: " + r101);
    }

    private static int getUnsignedInt16(ByteBuffer r100, int r101) {
        return r100.getShort(r101) & 65535;
    }

    private static long getUnsignedInt32(ByteBuffer r100, int r101) {
        return ((long) r100.getInt(r101)) & BodyPartID.bodyIdMax;
    }

    public static final boolean isZip64EndOfCentralDirectoryLocatorPresent(RandomAccessFile r100, long r101) throws IOException {
        long r102 = r101 - 20;
        if (r102 >= 0) goto L5;
        return false;
    L5:
        r100.seek(r102);
        if (r100.readInt() != ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER) goto L9;
        return true;
    L9:
        return false;
    }

    private static void setUnsignedInt32(ByteBuffer r100, int r101, long r102) {
        if (r102 < 0) goto L9;
        if (r102 > BodyPartID.bodyIdMax) goto L9;
        r100.putInt(r100.position() + r101, (int) r102);
        return;
    L9:
        throw new IllegalArgumentException("uint32 value of out range: " + r102);
    }
}
