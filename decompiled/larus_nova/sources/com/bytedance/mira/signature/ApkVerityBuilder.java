package com.bytedance.mira.signature;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
abstract class ApkVerityBuilder {
    private static final int CHUNK_SIZE_BYTES = 4096;
    private static final byte[] DEFAULT_SALT = null;
    private static final int DIGEST_SIZE_BYTES = 32;
    private static final int FSVERITY_HEADER_SIZE_BYTES = 64;
    private static final String JCA_DIGEST_ALGORITHM = "SHA-256";
    private static final int MMAP_REGION_SIZE_BYTES = 1048576;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_SIZE = 4;

    /* JADX INFO: renamed from: com.bytedance.mira.signature.ApkVerityBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ApkVerityResult {
        public final ByteBuffer fsverityData;
        public final byte[] rootHash;

        public ApkVerityResult(ByteBuffer r100, byte[] r101) {
            this.fsverityData = r100;
            this.rootHash = r101;
        }
    }

    public static class BufferedDigester implements DataDigester {
        private static final int BUFFER_SIZE = 4096;
        private int mBytesDigestedSinceReset;
        private final byte[] mDigestBuffer;
        private final MessageDigest mMd;
        private final ByteBuffer mOutput;
        private final byte[] mSalt;

        private void fillUpLastOutputChunk() {
            int r100 = this.mOutput.position() % 4096;
            if (r100 != 0) goto L5;
            return;
        L5:
            this.mOutput.put(ByteBuffer.allocate(4096 - r100));
        }

        public void assertEmptyBuffer() throws DigestException {
            if (this.mBytesDigestedSinceReset != 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Buffer is not empty: " + this.mBytesDigestedSinceReset);
        }

        public static /* synthetic */ void access$100(BufferedDigester r100) {
            r100.fillUpLastOutputChunk();
        }

        @Override // com.bytedance.mira.signature.DataDigester
        public void consume(ByteBuffer r100) throws DigestException {
            r100.position();
            int r101 = r100.remaining();
        L3:
            if (r101 <= 0) goto L7;
            int r102 = Math.min(r101, 4096 - this.mBytesDigestedSinceReset);
            r100.limit(r100.position() + r102);
            this.mMd.update(r100);
            r101 = r101 - r102;
            int r103 = this.mBytesDigestedSinceReset + r102;
            this.mBytesDigestedSinceReset = r103;
            if (r103 != 4096) goto L3;
            MessageDigest r104 = this.mMd;
            byte[] r105 = this.mDigestBuffer;
            r104.digest(r105, 0, r105.length);
            this.mOutput.put(this.mDigestBuffer);
            this.mMd.update(this.mSalt);
            this.mBytesDigestedSinceReset = 0;
            goto L3
        }

        private BufferedDigester(byte[] r100, ByteBuffer r101) throws NoSuchAlgorithmException {
            this.mDigestBuffer = new byte[32];
            this.mSalt = r100;
            this.mOutput = r101.slice();
            MessageDigest r102 = MessageDigest.getInstance("SHA-256");
            this.mMd = r102;
            r102.update(r100);
            this.mBytesDigestedSinceReset = 0;
        }

        public /* synthetic */ BufferedDigester(byte[] r100, ByteBuffer r101, AnonymousClass1 r102) throws NoSuchAlgorithmException {
            this(r100, r101);
        }
    }

    private ApkVerityBuilder() {
    }

    static {
        DEFAULT_SALT = new byte[8];
    }

    private static void assertSigningBlockAlignedAndHasFullPages(SignatureInfo r100) {
        long r101 = r100.apkSigningBlockOffset;
        if ((r101 % 4096) != 0) goto L10;
        if (((r100.centralDirOffset - r101) % 4096) != 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (r100.centralDirOffset - r100.apkSigningBlockOffset));
    L10:
        throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + r100.apkSigningBlockOffset);
    }

    private static int[] calculateVerityLevelOffset(long r100) {
        ArrayList r101 = new ArrayList();
    L3:
        r100 = divideRoundup(r100, 4096) * 32;
        r101.add(Long.valueOf(divideRoundup(r100, 4096) * 4096));
        if (r100 > 4096) goto L3;
        int[] r102 = new int[r101.size() + 1];
        int r103 = 0;
        r102[0] = 0;
    L7:
        if (r103 >= r101.size()) goto L9;
        int r104 = r103 + 1;
        r102[r104] = r102[r103] + toIntExact(((Long) ListProtector.get(r101, (r101.size() - r103) - 1)).longValue());
        r103 = r104;
        goto L7
    L9:
        return r102;
    }

    public static int toIntExact(long r100) {
        int r101 = (int) r100;
        if (r101 != r100) goto L6;
        return r101;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    private static long divideRoundup(long r100, long r101) {
        return ((r100 + r101) - 1) / r101;
    }

    private static void skip(ByteBuffer r100, int r101) {
        r100.position(r100.position() + r101);
    }

    private static void consumeByChunk(DataDigester r100, DataSource r101, int r110) throws IOException, DigestException {
        long r102 = r101.size();
        long r103 = 0;
    L4:
        if (r102 <= 0) goto L6;
        int r104 = (int) Math.min(r102, r110);
        r101.feedIntoDataDigester(r100, r103, r104);
        long r105 = r104;
        r103 = r103 + r105;
        r102 = r102 - r105;
        goto L4
    }

    public static ApkVerityResult generateApkVerity(RandomAccessFile r110, SignatureInfo r111, ByteBufferFactory r112) throws IOException, SecurityException, NoSuchAlgorithmException, DigestException {
        int[] r100 = calculateVerityLevelOffset(r110.length() - (r111.centralDirOffset - r111.apkSigningBlockOffset));
        int r101 = r100[r100.length - 1];
        int r102 = r101 + 4096;
        ByteBuffer r113 = r112.create(r102);
        ByteOrder r103 = ByteOrder.LITTLE_ENDIAN;
        r113.order(r103);
        ByteBuffer r104 = slice(r113, 0, r101);
        int r105 = r101 + 64;
        ByteBuffer r106 = slice(r113, r101, r105);
        ByteBuffer r107 = slice(r113, r105, r102);
        byte[] r108 = new byte[32];
        ByteBuffer r109 = ByteBuffer.wrap(r108);
        r109.order(r103);
        calculateFsveritySignatureInternal(r110, r111, r104, r109, r106, r107);
        r113.position(r105 + r107.limit());
        r113.putInt((r107.limit() + 64) + 4);
        r113.flip();
        return new ApkVerityResult(r113, r108);
    }

    public static byte[] generateFsverityRootHash(RandomAccessFile r100, ByteBuffer r110, SignatureInfo r111) throws NoSuchAlgorithmException, DigestException, IOException {
        ByteBuffer r101 = ByteBuffer.allocate(4096).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer r102 = slice(r101, 0, 64);
        ByteBuffer r103 = slice(r101, 64, MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC);
        calculateFsveritySignatureInternal(r100, r111, null, null, r102, r103);
        MessageDigest r104 = MessageDigest.getInstance("SHA-256");
        r104.update(r102);
        r104.update(r103);
        r104.update(r110);
        return r104.digest();
    }

    private static ByteBuffer slice(ByteBuffer r100, int r101, int r102) {
        ByteBuffer r103 = r100.duplicate();
        r103.position(0);
        r103.limit(r102);
        r103.position(r101);
        return r103.slice();
    }

    private static void generateApkVerityDigestAtLeafLevel(RandomAccessFile r100, SignatureInfo r110, byte[] r111, ByteBuffer r112) throws IOException, NoSuchAlgorithmException, DigestException {
        BufferedDigester r101 = new BufferedDigester(r111, r112, null);
        consumeByChunk(r101, new MemoryMappedFileDataSource(r100.getFD(), 0, r110.apkSigningBlockOffset), 1048576);
        long r102 = r110.eocdOffset + 16;
        FileDescriptor r103 = r100.getFD();
        long r104 = r110.centralDirOffset;
        consumeByChunk(r101, new MemoryMappedFileDataSource(r103, r104, r102 - r104), 1048576);
        ByteBuffer r113 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        r113.putInt(toIntExact(r110.apkSigningBlockOffset));
        r113.flip();
        r101.consume(r113);
        long r105 = r102 + 4;
        consumeByChunk(r101, new MemoryMappedFileDataSource(r100.getFD(), r105, r100.length() - r105), 1048576);
        int r114 = (int) (r100.length() % 4096);
        if (r114 == 0) goto L5;
        r101.consume(ByteBuffer.allocate(4096 - r114));
    L5:
        r101.assertEmptyBuffer();
        BufferedDigester.access$100(r101);
    }

    private static ByteBuffer generateFsverityExtensions(ByteBuffer r100, long r101, long r102, long r103) {
        r100.putInt(24);
        r100.putShort(1);
        skip(r100, 2);
        r100.putLong(r101);
        r100.putLong(r102);
        r100.putInt(20);
        r100.putShort(2);
        skip(r100, 2);
        r100.putLong(r103 + 16);
        r100.putInt(toIntExact(r101));
        skip(r100, 4);
        r100.flip();
        return r100;
    }

    private static ByteBuffer generateFsverityHeader(ByteBuffer r100, long r101, int r102, byte[] r103) {
        if (r103.length != 8) goto L7;
        r100.put("TrueBrew".getBytes());
        r100.put((byte) 1);
        r100.put((byte) 0);
        r100.put((byte) 12);
        r100.put((byte) 7);
        r100.putShort(1);
        r100.putShort(1);
        r100.putInt(0);
        r100.putInt(0);
        r100.putLong(r101);
        r100.put((byte) 2);
        r100.put((byte) 0);
        r100.put(r103);
        skip(r100, 22);
        r100.flip();
        return r100;
    L7:
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static byte[] generateApkVerityTree(RandomAccessFile r100, SignatureInfo r101, byte[] r102, int[] r103, ByteBuffer r104) throws IOException, NoSuchAlgorithmException, DigestException {
        generateApkVerityDigestAtLeafLevel(r100, r101, r102, slice(r104, r103[r103.length - 2], r103[r103.length - 1]));
        int r105 = r103.length - 3;
    L3:
        AnonymousClass1 r106 = null;
        if (r105 < 0) goto L6;
        int r107 = r105 + 1;
        ByteBuffer r108 = slice(r104, r103[r107], r103[r105 + 2]);
        ByteBuffer r109 = slice(r104, r103[r105], r103[r107]);
        ByteBufferDataSource r110 = new ByteBufferDataSource(r108);
        BufferedDigester r111 = new BufferedDigester(r102, r109, r106);
        consumeByChunk(r111, r110, 4096);
        r111.assertEmptyBuffer();
        BufferedDigester.access$100(r111);
        r105 = r105 - 1;
        goto L3
    L6:
        byte[] r112 = new byte[32];
        BufferedDigester r113 = new BufferedDigester(r102, ByteBuffer.wrap(r112), r106);
        r113.consume(slice(r104, 0, 4096));
        r113.assertEmptyBuffer();
        return r112;
    }

    private static void calculateFsveritySignatureInternal(RandomAccessFile r100, SignatureInfo r110, ByteBuffer r111, ByteBuffer r112, ByteBuffer r113, ByteBuffer r114) throws IOException, NoSuchAlgorithmException, DigestException {
        assertSigningBlockAlignedAndHasFullPages(r110);
        long r101 = r110.centralDirOffset - r110.apkSigningBlockOffset;
        int[] r102 = calculateVerityLevelOffset(r100.length() - r101);
        if (r111 == null) goto L7;
        byte[] r103 = generateApkVerityTree(r100, r110, DEFAULT_SALT, r102, r111);
        if (r112 == null) goto L7;
        r112.put(r103);
        r112.flip();
    L7:
        if (r113 == null) goto L9;
        r113.order(ByteOrder.LITTLE_ENDIAN);
        generateFsverityHeader(r113, r100.length(), r102.length - 1, DEFAULT_SALT);
    L9:
        if (r114 == null) goto L12;
        r114.order(ByteOrder.LITTLE_ENDIAN);
        generateFsverityExtensions(r114, r110.apkSigningBlockOffset, r101, r110.eocdOffset);
        return;
    }
}
