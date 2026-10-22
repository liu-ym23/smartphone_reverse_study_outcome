package com.bytedance.mira.signature;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
final class ApkSigningBlockUtils {
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    private static final int CHUNK_SIZE_BYTES = 1048576;
    static final int CONTENT_DIGEST_CHUNKED_SHA256 = 1;
    static final int CONTENT_DIGEST_CHUNKED_SHA512 = 2;
    static final int CONTENT_DIGEST_VERITY_CHUNKED_SHA256 = 3;
    static final int SIGNATURE_DSA_WITH_SHA256 = 769;
    static final int SIGNATURE_ECDSA_WITH_SHA256 = 513;
    static final int SIGNATURE_ECDSA_WITH_SHA512 = 514;
    static final int SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 = 259;
    static final int SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA512 = 260;
    static final int SIGNATURE_RSA_PSS_WITH_SHA256 = 257;
    static final int SIGNATURE_RSA_PSS_WITH_SHA512 = 258;
    static final int SIGNATURE_VERITY_DSA_WITH_SHA256 = 1061;
    static final int SIGNATURE_VERITY_ECDSA_WITH_SHA256 = 1059;
    static final int SIGNATURE_VERITY_RSA_PKCS1_V1_5_WITH_SHA256 = 1057;

    public static class MultipleDigestDataDigester implements DataDigester {
        private final MessageDigest[] mMds;

        public MultipleDigestDataDigester(MessageDigest[] r100) {
            this.mMds = r100;
        }

        @Override // com.bytedance.mira.signature.DataDigester
        public void consume(ByteBuffer r100) {
            ByteBuffer r101 = r100.slice();
            MessageDigest[] r102 = this.mMds;
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            MessageDigest r105 = r102[r104];
            r101.position(0);
            r105.update(r101);
            r104 = r104 + 1;
            goto L3
        }
    }

    private ApkSigningBlockUtils() {
    }

    private static void checkByteOrderLittleEndian(ByteBuffer r100) {
        if (r100.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static long getChunkCount(long r100) {
        return ((r100 + 1048576) - 1) / 1048576;
    }

    public static String getContentDigestAlgorithmJcaDigestAlgorithm(int r100) {
        if (r100 != 1) goto L5;
        return "SHA-256";
    L5:
        if (r100 != 2) goto L7;
        return "SHA-512";
    L7:
        if (r100 != 3) goto L10;
        return "SHA-256";
    L10:
        throw new IllegalArgumentException("Unknown content digest algorthm: " + r100);
    }

    private static int getContentDigestAlgorithmOutputSizeBytes(int r100) {
        if (r100 != 1) goto L5;
        return 32;
    L5:
        if (r100 != 2) goto L7;
        return 64;
    L7:
        if (r100 != 3) goto L10;
        return 32;
    L10:
        throw new IllegalArgumentException("Unknown content digest algorthm: " + r100);
    }

    public static Pair<ByteBuffer, Long> getEocd(RandomAccessFile r100) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> r101 = ZipUtils.findZipEndOfCentralDirectoryRecord(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer r100) throws IOException {
        if (r100.remaining() < 4) goto L15;
        int r101 = r100.getInt();
        if (r101 < 0) goto L13;
        if (r101 > r100.remaining()) goto L11;
        return getByteBuffer(r100, r101);
    L11:
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + r101 + ", remaining: " + r100.remaining());
    L13:
        throw new IllegalArgumentException("Negative length");
    L15:
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + r100.remaining());
    }

    public static int getSignatureAlgorithmContentDigestAlgorithm(int r100) {
        if (r100 != 513) goto L5;
        return 1;
    L5:
        if (r100 != 514) goto L7;
        return 2;
    L7:
        if (r100 != SIGNATURE_DSA_WITH_SHA256) goto L9;
        return 1;
    L9:
        if (r100 != 1057) goto L11;
        return 3;
    L11:
        if (r100 != 1059) goto L13;
        return 3;
    L13:
        if (r100 == 1061) goto L24;
        switch(r100) {
            case 257: goto L27;
            case 258: goto L25;
            case 259: goto L27;
            case 260: goto L25;
            default: goto L16;
        };
    L25:
        return 2;
    L27:
        return 1;
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L24:
        return 3;
    }

    public static String getSignatureAlgorithmJcaKeyAlgorithm(int r100) {
        if (r100 != 513) goto L5;
        return CryptoConst.ALGORITHM_EC;
    L5:
        if (r100 != 514) goto L7;
        return CryptoConst.ALGORITHM_EC;
    L7:
        if (r100 != SIGNATURE_DSA_WITH_SHA256) goto L9;
        return "DSA";
    L9:
        if (r100 != 1057) goto L11;
        return d.f25615a;
    L11:
        if (r100 != 1059) goto L13;
        return CryptoConst.ALGORITHM_EC;
    L13:
        if (r100 == 1061) goto L24;
        switch(r100) {
            case 257: goto L23;
            case 258: goto L23;
            case 259: goto L23;
            case 260: goto L23;
            default: goto L16;
        };
    L23:
        return d.f25615a;
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L24:
        return "DSA";
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> getSignatureAlgorithmJcaSignatureAlgorithm(int r100) {
        if (r100 == 513) goto L30;
        if (r100 == 514) goto L28;
        if (r100 == SIGNATURE_DSA_WITH_SHA256) goto L26;
        if (r100 == 1057) goto L24;
        if (r100 == 1059) goto L30;
        if (r100 == 1061) goto L26;
        switch(r100) {
            case 257: goto L22;
            case 258: goto L20;
            case 259: goto L24;
            case 260: goto L18;
            default: goto L16;
        };
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L18:
        return Pair.create("SHA512withRSA", null);
    L20:
        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
    L22:
        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
    L24:
        return Pair.create(RSAUtil.SIGNATURE_ALGORITHM, null);
    L26:
        return Pair.create("SHA256withDSA", null);
    L28:
        return Pair.create("SHA512withECDSA", null);
    L30:
        return Pair.create("SHA256withECDSA", null);
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer r100) throws IOException {
        int r101 = r100.getInt();
        if (r101 < 0) goto L11;
        if (r101 > r100.remaining()) goto L9;
        byte[] r102 = new byte[r101];
        r100.get(r102);
        return r102;
    L9:
        throw new IOException("Underflow while reading length-prefixed value. Length: " + r101 + ", available: " + r100.remaining());
    L11:
        throw new IOException("Negative length");
    }

    private static int compareContentDigestAlgorithm(int r100, int r101) {
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L16;
        if (r100 != 3) goto L15;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 != 3) goto L11;
        return 0;
    L11:
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r101);
    L12:
        return -1;
    L13:
        return 1;
    L15:
        throw new IllegalArgumentException("Unknown digestAlgorithm1: " + r100);
    L16:
        if (r101 == 1) goto L23;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L23;
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r101);
    L22:
        return 0;
    L23:
        return 1;
    L24:
        if (r101 == 1) goto L31;
        if (r101 == 2) goto L30;
        if (r101 == 3) goto L30;
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r101);
    L30:
        return -1;
    L31:
        return 0;
    }

    public static int compareSignatureAlgorithm(int r100, int r101) {
        return compareContentDigestAlgorithm(getSignatureAlgorithmContentDigestAlgorithm(r100), getSignatureAlgorithmContentDigestAlgorithm(r101));
    }

    private static byte[][] computeContentDigestsPer1MbChunk(int[] r210, DataSource[] r211) throws DigestException {
        DataSource[] r100 = r211;
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
        long r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r101) goto L6;
        r104 = r104 + getChunkCount(r100[r105].size());
        r105 = r105 + 1;
        goto L3
    L6:
        if (r104 >= 2097151) goto L54;
        int r106 = (int) r104;
        byte[][] r107 = new byte[r210.length][];
        int r108 = 0;
    L9:
        if (r108 >= r210.length) goto L11;
        byte[] r109 = new byte[(getContentDigestAlgorithmOutputSizeBytes(r210[r108]) * r106) + 5];
        r109[0] = 90;
        setUnsignedInt32LittleEndian(r106, r109, 1);
        r107[r108] = r109;
        r108 = r108 + 1;
        goto L9
    L11:
        byte[] r110 = new byte[5];
        r110[0] = -91;
        int r111 = r210.length;
        MessageDigest[] r112 = new MessageDigest[r111];
        int r113 = 0;
    L12:
        String r114 = " digest not supported";
        if (r113 >= r210.length) goto L20;
        String r115 = getContentDigestAlgorithmJcaDigestAlgorithm(r210[r113]);
        r112[r113] = MessageDigest.getInstance(r115);     // Catch: NoSuchAlgorithmException -> L17
        r113 = r113 + 1;
    L17:
        e = move-exception;
        throw new RuntimeException(r115 + " digest not supported", e);
    L20:
        MultipleDigestDataDigester r116 = new MultipleDigestDataDigester(r112);
        int r117 = r100.length;
        int r118 = 0;
        int r119 = 0;
    L21:
        if (r118 >= r117) goto L43;
        DataSource r120 = r100[r118];
        int r212 = r117;
        String r121 = r114;
        long r122 = r102;
        MultipleDigestDataDigester r123 = r116;
        long r124 = r120.size();
    L24:
        if (r124 <= r102) goto L42;
        int r125 = (int) Math.min(r124, 1048576);
        setUnsignedInt32LittleEndian(r125, r110, 1);
        int r126 = 0;
    L26:
        if (r126 >= r111) goto L28;
        r112[r126].update(r110);
        r126 = r126 + 1;
        goto L26
    L28:
        MultipleDigestDataDigester r127 = r123;
        r120.feedIntoDataDigester(r127, r122, r125);     // Catch: IOException -> L39
        r123 = r127;
        int r128 = 0;
    L32:
        if (r128 >= r210.length) goto L38;
        int r129 = r210[r128];
        byte[] r213 = r110;
        byte[] r130 = r107[r128];
        int r131 = getContentDigestAlgorithmOutputSizeBytes(r129);
        int r214 = r111;
        MessageDigest r132 = r112[r128];
        MessageDigest[] r215 = r112;
        int r133 = r132.digest(r130, (r119 * r131) + 5, r131);
        if (r133 != r131) goto L37;
        r128 = r128 + 1;
        r110 = r213;
        r111 = r214;
        r112 = r215;
        goto L32
    L37:
        throw new RuntimeException("Unexpected output size of " + r132.getAlgorithm() + " digest: " + r133);
    L38:
        long r134 = r125;
        r122 = r122 + r134;
        r124 = r124 - r134;
        r119 = r119 + 1;
        r110 = r110;
        r102 = 0;
    L39:
        e = move-exception;
        throw new DigestException("Failed to digest chunk #" + r119 + " of section #" + r103, e);
    L42:
        r103 = r103 + 1;
        r118 = r118 + 1;
        r100 = r211;
        r116 = r123;
        r114 = r121;
        r117 = r212;
        r102 = 0;
        goto L21
    L43:
        String r135 = r114;
        byte[][] r136 = new byte[r210.length][];
        int r137 = 0;
    L45:
        if (r137 >= r210.length) goto L52;
        int r138 = r210[r137];
        byte[] r139 = r107[r137];
        String r140 = getContentDigestAlgorithmJcaDigestAlgorithm(r138);
        r136[r137] = MessageDigest.getInstance(r140).digest(r139);
        r137 = r137 + 1;
    L49:
        e = move-exception;
        throw new RuntimeException(r140 + r135, e);
    L52:
        return r136;
    L54:
        throw new DigestException("Too many chunks: " + r104);
    }

    public static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer r100, int r110) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(r100);
        ByteBuffer r101 = sliceFromTo(r100, 8, r100.capacity() - 24);
        int r102 = 0;
    L4:
        if (r101.hasRemaining() == false) goto L25;
        r102 = r102 + 1;
        if (r101.remaining() < 8) goto L23;
        long r103 = r101.getLong();
        if (r103 < 4) goto L21;
        if (r103 > SieveCacheKt.NodeLinkMask) goto L21;
        int r104 = (int) r103;
        int r105 = r101.position() + r104;
        if (r104 > r101.remaining()) goto L19;
        if (r101.getInt() == r110) goto L16;
        r101.position(r105);
        goto L4
    L16:
        return getByteBuffer(r101, r104 - 4);
    L19:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r102 + " size out of range: " + r104 + ", available: " + r101.remaining());
    L21:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r102 + " size out of range: " + r103);
    L23:
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + r102);
    L25:
        throw new SignatureNotFoundException("No block with ID " + r110 + " in APK Signing Block.");
    }

    public static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile r100, long r101) throws IOException, SignatureNotFoundException {
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
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + r108 + " vs " + r104);
    L21:
        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + r106);
    L23:
        throw new SignatureNotFoundException("APK Signing Block size out of range: " + r104);
    L25:
        throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    L27:
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + r101);
    }

    public static SignatureInfo findSignature(RandomAccessFile r110, int r111) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> r100 = getEocd(r110);
        ByteBuffer r112 = (ByteBuffer) r100.first;
        long r101 = ((Long) r100.second).longValue();
        if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(r110, r101) == true) goto L7;
        long r102 = getCentralDirOffset(r112, r101);
        Pair<ByteBuffer, Long> r113 = findApkSigningBlock(r110, r102);
        ByteBuffer r103 = (ByteBuffer) r113.first;
        long r104 = ((Long) r113.second).longValue();
        return new SignatureInfo(findApkSignatureSchemeBlock(r103, r111), r104, r102, r101, r112);
    L7:
        throw new SignatureNotFoundException("ZIP64 APK not supported");
    }

    public static ByteBuffer getByteBuffer(ByteBuffer r100, int r101) throws BufferUnderflowException {
        if (r101 < 0) goto L16;
        int r102 = r100.limit();
        int r103 = r100.position();
        int r104 = r101 + r103;
        if (r104 < r103) goto L14;
        if (r104 > r102) goto L14;
        r100.limit(r104);
        ByteBuffer r105 = r100.slice();     // Catch: Throwable -> L10
        r105.order(r100.order());     // Catch: Throwable -> L10
        r100.position(r104);     // Catch: Throwable -> L10
        r100.limit(r102);
        return r105;
    L10:
        th = move-exception;
        r100.limit(r102);
        throw th;
    L14:
        throw new BufferUnderflowException();
    L16:
        throw new IllegalArgumentException("size: " + r101);
    }

    public static long getCentralDirOffset(ByteBuffer r100, long r101) throws SignatureNotFoundException {
        long r102 = ZipUtils.getZipEocdCentralDirectoryOffset(r100);
        if (r102 > r101) goto L10;
        if ((ZipUtils.getZipEocdCentralDirectorySizeBytes(r100) + r102) != r101) goto L8;
        return r102;
    L8:
        throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    L10:
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + r102 + ". ZIP End of Central Directory offset: " + r101);
    }

    public static byte[] generateApkVerity(String r100, ByteBufferFactory r101, SignatureInfo r102) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        RandomAccessFile r103 = new RandomAccessFile(r100, "r");
        byte[] r104 = ApkVerityBuilder.generateApkVerity(r103, r102, r101).rootHash;     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static byte[] parseVerityDigestAndVerifySourceLength(byte[] r100, long r101, SignatureInfo r110) throws SecurityException {
        if (r100.length != 40) goto L11;
        ByteBuffer r102 = ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN);
        r102.position(32);
        if (r102.getLong() != (r101 - (r110.centralDirOffset - r110.apkSigningBlockOffset))) goto L9;
        return Arrays.copyOfRange(r100, 0, 32);
    L9:
        throw new SecurityException("APK content size did not verify");
    L11:
        throw new SecurityException("Verity digest size is wrong: " + r100.length);
    }

    public static void setUnsignedInt32LittleEndian(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) (r100 & 255);
        r101[r102 + 1] = (byte) ((r100 >>> 8) & 255);
        r101[r102 + 2] = (byte) ((r100 >>> 16) & 255);
        r101[r102 + 3] = (byte) ((r100 >>> 24) & 255);
    }

    public static ByteBuffer sliceFromTo(ByteBuffer r100, int r101, int r102) {
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

    public static void verifyIntegrity(Map<Integer, byte[]> r100, RandomAccessFile r101, SignatureInfo r102) throws SecurityException {
        if (r100.isEmpty() == true) goto L26;
        ArrayMap r103 = new ArrayMap();
        boolean r104 = true;
        if (r100.containsKey(1) == false) goto L8;
        r103.put(1, r100.get(1));
    L8:
        if (r100.containsKey(2) == false) goto L10;
        r103.put(2, r100.get(2));
    L10:
        boolean r105 = false;
        if (r103.isEmpty() == true) goto L18;
        verifyIntegrityFor1MbChunkBasedAlgorithm(r103, r101.getFD(), r102);     // Catch: IOException -> L14
        r104 = false;
    L14:
        e = move-exception;
        throw new SecurityException("Cannot get FD", e);
    L18:
        if (r100.containsKey(3) == false) goto L20;
        verifyIntegrityForVerityBasedAlgorithm(r100.get(3), r101, r102);
    L21:
        if (r105 == true) goto L24;
        return;
    L24:
        throw new SecurityException("No known digest exists for integrity check");
    L20:
        r105 = r104;
        goto L21
    L26:
        throw new SecurityException("No digests provided");
    }

    private static void verifyIntegrityFor1MbChunkBasedAlgorithm(Map<Integer, byte[]> r110, FileDescriptor r111, SignatureInfo r112) throws SecurityException {
        MemoryMappedFileDataSource r100 = new MemoryMappedFileDataSource(r111, 0, r112.apkSigningBlockOffset);
        long r101 = r112.centralDirOffset;
        MemoryMappedFileDataSource r102 = new MemoryMappedFileDataSource(r111, r101, r112.eocdOffset - r101);
        ByteBuffer r113 = r112.eocd.duplicate();
        r113.order(ByteOrder.LITTLE_ENDIAN);
        ZipUtils.setZipEocdCentralDirectoryOffset(r113, r112.apkSigningBlockOffset);
        ByteBufferDataSource r114 = new ByteBufferDataSource(r113);
        int r115 = r110.size();
        int[] r103 = new int[r115];
        Iterator<Integer> r104 = r110.keySet().iterator();
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r104.hasNext() == false) goto L18;
        r103[r106] = r104.next().intValue();
        r106 = r106 + 1;
        goto L4
    L18:
        byte[][] r116 = computeContentDigestsPer1MbChunk(r103, new DataSource[]{r100, r102, r114});     // Catch: DigestException -> L15
    L8:
        if (r105 >= r115) goto L14;
        int r107 = r103[r105];
        if (MessageDigest.isEqual(r110.get(Integer.valueOf(r107)), r116[r105]) == false) goto L13;
        r105 = r105 + 1;
        goto L8
    L13:
        throw new SecurityException(getContentDigestAlgorithmJcaDigestAlgorithm(r107) + " digest of contents did not verify");
    L14:
        return;
    L15:
        e = move-exception;
        throw new SecurityException("Failed to compute digest(s) of contents", e);
    }

    private static void verifyIntegrityForVerityBasedAlgorithm(byte[] r100, RandomAccessFile r101, SignatureInfo r102) throws SecurityException {
    L11:
        e = move-exception;
        throw new SecurityException("Error during verification", e);
    L3:
        if (Arrays.equals(parseVerityDigestAndVerifySourceLength(r100, r101.length(), r102), ApkVerityBuilder.generateApkVerity(r101, r102, new AnonymousClass1()).rootHash) == false) goto L6;
        return;
    L6:
        throw new SecurityException("APK verity digest of contents did not verify");     // Catch: NoSuchAlgorithmException -> L7 IOException -> L9 Throwable -> L11
    }
}
