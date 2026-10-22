package com.bytedance.mira.modifyres.apkidentity;

import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.bytedance.mira.util.EncryptUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class V2V3SignatureIdentity {
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    private static final String V2_SIGNATURE_VERSION = "V2";
    private static final String V3_SIGNATURE_VERSION = "V3";
    private static String signatureVersion = "";

    public V2V3SignatureIdentity() {
    }

    private static void checkByteOrderLittleEndian(ByteBuffer r100) {
        if (r100.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static ByteBuffer getApkSigningBlock(File r100) throws Exception {
        RandomAccessFile r101 = null;
        RandomAccessFile r102 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L13
        Pair<ByteBuffer, Long> r103 = getEocd(r102);     // Catch: Throwable -> L11
        ByteBuffer r104 = (ByteBuffer) r103.first;     // Catch: Throwable -> L11
        long r105 = ((Long) r103.second).longValue();     // Catch: Throwable -> L11
        if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(r102, r105) == true) goto L10;
        ByteBuffer r106 = (ByteBuffer) findApkSigningBlock(r102, getCentralDirOffset(r104, r105)).first;     // Catch: Throwable -> L11
        r102.close();
        return r106;
    L10:
        throw new Exception("ZIP64 APK not supported");     // Catch: Throwable -> L11
    L11:
        th = th;
        r101 = r102;
    L14:
        if (r101 == null) goto L16;
        r101.close();
    L16:
        throw th;
    L13:
        th = th;
        goto L14
    }

    private static Pair<ByteBuffer, Long> getEocd(RandomAccessFile r100) throws Exception {
        Pair<ByteBuffer, Long> r101 = ZipUtils.findZipEndOfCentralDirectoryRecord(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static String[] getIdentity(File r100) {
        String r101 = "";
        ByteBuffer r102 = getApkSigningBlock(r100);     // Catch: Exception -> L8
        if (hasV2V3SignatureSchemeBlock(r102) == false) goto L6;
        r101 = EncryptUtils.encryptMD5ToString(r102.array());     // Catch: Exception -> L8
        String r103 = "";
    L10:
        return new String[]{r101, signatureVersion, r103};
    L6:
        r103 = "without v2 & v3 signature.";
    L8:
        r103 = r101;
        goto L10
    }

    private static boolean hasV2V3SignatureSchemeBlock(ByteBuffer r110) throws Exception {
        checkByteOrderLittleEndian(r110);
        ByteBuffer r111 = sliceFromTo(r110, 8, r110.capacity() - 24);
        int r100 = 0;
    L4:
        if (r111.hasRemaining() == false) goto L28;
        r100 = r100 + 1;
        if (r111.remaining() < 8) goto L27;
        long r101 = r111.getLong();
        if (r101 < 4) goto L25;
        if (r101 > SieveCacheKt.NodeLinkMask) goto L25;
        int r102 = (int) r101;
        int r103 = r111.position() + r102;
        if (r102 > r111.remaining()) goto L23;
        int r104 = r111.getInt();
        if (r104 == APK_SIGNATURE_SCHEME_V3_BLOCK_ID) goto L15;
        if (r104 == APK_SIGNATURE_SCHEME_V2_BLOCK_ID) goto L19;
        r111.position(r103);
        goto L4
    L19:
        signatureVersion = V2_SIGNATURE_VERSION;
        return true;
    L15:
        signatureVersion = V3_SIGNATURE_VERSION;
        return true;
    L23:
        throw new Exception("APK Signing Block entry #" + r100 + " size out of range: " + r102 + ", available: " + r111.remaining());
    L25:
        throw new Exception("APK Signing Block entry #" + r100 + " size out of range: " + r101);
    L27:
        throw new Exception("Insufficient data to read size of APK Signing Block entry #" + r100);
    L28:
        return false;
    }

    public static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile r100, long r101) throws Exception {
        if (r101 < 32) goto L27;
        ByteBuffer r102 = ByteBuffer.allocate(24);
        ByteOrder r103 = ByteOrder.LITTLE_ENDIAN;
        r102.order(r103);
        r100.seek(r101 - ((long) r102.capacity()));
        r100.readFully(r102.array(), r102.arrayOffset(), r102.capacity());
        if (r102.getLong(8) != APK_SIG_BLOCK_MAGIC_LO) goto L25;
        if (r102.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) goto L25;
        long r104 = r102.getLong(0);
        if (r104 < r102.capacity()) goto L23;
        if (r104 > 2147483639) goto L23;
        int r105 = (int) (8 + r104);
        long r106 = r101 - ((long) r105);
        if (r106 < 0) goto L21;
        ByteBuffer r107 = ByteBuffer.allocate(r105);
        r107.order(r103);
        r100.seek(r106);
        r100.readFully(r107.array(), r107.arrayOffset(), r107.capacity());
        long r108 = r107.getLong(0);
        if (r108 != r104) goto L19;
        return Pair.create(r107, Long.valueOf(r106));
    L19:
        throw new Exception("APK Signing Block sizes in header and footer do not match: " + r108 + " vs " + r104);
    L21:
        throw new Exception("APK Signing Block offset out of range: " + r106);
    L23:
        throw new Exception("APK Signing Block size out of range: " + r104);
    L25:
        throw new Exception("No APK Signing Block before ZIP Central Directory");
    L27:
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: " + r101);
    }

    private static long getCentralDirOffset(ByteBuffer r100, long r101) throws Exception {
        long r102 = ZipUtils.getZipEocdCentralDirectoryOffset(r100);
        if (r102 > r101) goto L10;
        if ((ZipUtils.getZipEocdCentralDirectorySizeBytes(r100) + r102) != r101) goto L8;
        return r102;
    L8:
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    L10:
        throw new Exception("ZIP Central Directory offset out of range: " + r102 + ". ZIP End of Central Directory offset: " + r101);
    }

    private static ByteBuffer sliceFromTo(ByteBuffer r100, int r101, int r102) {
        if (r101 < 0) goto L18;
        if (r102 < r101) goto L16;
        int r103 = r100.capacity();
        if (r102 > r100.capacity()) goto L14;
        int r104 = r100.limit();
        int r105 = r100.position();
        r100.position(0);     // Catch: Throwable -> L10
        r100.limit(r102);     // Catch: Throwable -> L10
        r100.position(r101);     // Catch: Throwable -> L10
        ByteBuffer r106 = r100.slice();     // Catch: Throwable -> L10
        r106.order(r100.order());     // Catch: Throwable -> L10
        r100.position(0);
        r100.limit(r104);
        r100.position(r105);
        return r106;
    L10:
        th = move-exception;
        r100.position(0);
        r100.limit(r104);
        r100.position(r105);
        throw th;
    L14:
        throw new IllegalArgumentException("end > capacity: " + r102 + " > " + r103);
    L16:
        throw new IllegalArgumentException("end < start: " + r102 + " < " + r101);
    L18:
        throw new IllegalArgumentException("start: " + r101);
    }
}
