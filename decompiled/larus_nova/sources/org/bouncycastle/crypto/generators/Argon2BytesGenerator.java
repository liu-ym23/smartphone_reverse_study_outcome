package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;
    private static final long M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777216;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = null;
    private int laneLength;
    private Block[] memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.generators.Argon2BytesGenerator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Block {
        private static final int SIZE = 128;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final long[] f525209v;

        private Block() {
            this.f525209v = new long[128];
        }

        public /* synthetic */ Block(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ void access$1000(Block r100, Block r101, Block r102) {
            r100.xorWith(r101, r102);
        }

        public static /* synthetic */ long[] access$400(Block r100) {
            return r100.f525209v;
        }

        public static /* synthetic */ void access$600(Block r100, Block r101) {
            r100.xorWith(r101);
        }

        public static /* synthetic */ void access$800(Block r100, Block r101) {
            r100.copyBlock(r101);
        }

        public static /* synthetic */ void access$900(Block r100, Block r101, Block r102) {
            r100.xor(r101, r102);
        }

        private void copyBlock(Block r100) {
            System.arraycopy(r100.f525209v, 0, this.f525209v, 0, 128);
        }

        private void xor(Block r100, Block r101) {
            long[] r102 = this.f525209v;
            long[] r103 = r100.f525209v;
            long[] r104 = r101.f525209v;
            int r105 = 0;
        L4:
            if (r105 >= 128) goto L6;
            r102[r105] = r103[r105] ^ r104[r105];
            r105 = r105 + 1;
            goto L4
        }

        private void xorWith(Block r100) {
            long[] r101 = this.f525209v;
            long[] r102 = r100.f525209v;
            int r103 = 0;
        L4:
            if (r103 >= 128) goto L6;
            r101[r103] = r101[r103] ^ r102[r103];
            r103 = r103 + 1;
            goto L4
        }

        private void xorWith(Block r100, Block r110) {
            long[] r101 = this.f525209v;
            long[] r102 = r100.f525209v;
            long[] r111 = r110.f525209v;
            int r103 = 0;
        L4:
            if (r103 >= 128) goto L6;
            r101[r103] = r101[r103] ^ (r102[r103] ^ r111[r103]);
            r103 = r103 + 1;
            goto L4
        }

        public Block clear() {
            Arrays.fill(this.f525209v, 0);
            return this;
        }

        public void fromBytes(byte[] r100) {
            if (r100.length < 1024) goto L7;
            Pack.littleEndianToLong(r100, 0, this.f525209v);
            return;
        L7:
            throw new IllegalArgumentException("input shorter than blocksize");
        }

        public void toBytes(byte[] r100) {
            if (r100.length < 1024) goto L7;
            Pack.longToLittleEndian(this.f525209v, r100, 0);
            return;
        L7:
            throw new IllegalArgumentException("output shorter than blocksize");
        }
    }

    public static class FillBlock {
        Block R;
        Block Z;
        Block addressBlock;
        Block inputBlock;

        private FillBlock() {
            AnonymousClass1 r100 = null;
            this.R = new Block(r100);
            this.Z = new Block(r100);
            this.addressBlock = new Block(r100);
            this.inputBlock = new Block(r100);
        }

        public /* synthetic */ FillBlock(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ void access$200(FillBlock r100, Block r101, Block r102, Block r103) {
            r100.fillBlockWithXor(r101, r102, r103);
        }

        public static /* synthetic */ void access$300(FillBlock r100, Block r101, Block r102, Block r103) {
            r100.fillBlock(r101, r102, r103);
        }

        public static /* synthetic */ void access$500(FillBlock r100, Block r101, Block r102) {
            r100.fillBlock(r101, r102);
        }

        private void applyBlake() {
            int r100 = 0;
            int r101 = 0;
        L4:
            if (r101 >= 8) goto L6;
            int r102 = r101 * 16;
            Argon2BytesGenerator.access$700(this.Z, r102, r102 + 1, r102 + 2, r102 + 3, r102 + 4, r102 + 5, r102 + 6, r102 + 7, r102 + 8, r102 + 9, r102 + 10, r102 + 11, r102 + 12, r102 + 13, r102 + 14, r102 + 15);
            r101 = r101 + 1;
        L6:
            if (r100 >= 8) goto L8;
            int r103 = r100 * 2;
            Argon2BytesGenerator.access$700(this.Z, r103, r103 + 1, r103 + 16, r103 + 17, r103 + 32, r103 + 33, r103 + 48, r103 + 49, r103 + 64, r103 + 65, r103 + 80, r103 + 81, r103 + 96, r103 + 97, r103 + 112, r103 + 113);
            r100 = r100 + 1;
            goto L6
        }

        private void fillBlock(Block r100, Block r101) {
            Block.access$800(this.Z, r100);
            applyBlake();
            Block.access$900(r101, r100, this.Z);
        }

        private void fillBlock(Block r100, Block r101, Block r102) {
            Block.access$900(this.R, r100, r101);
            Block.access$800(this.Z, this.R);
            applyBlake();
            Block.access$900(r102, this.R, this.Z);
        }

        private void fillBlockWithXor(Block r100, Block r101, Block r102) {
            Block.access$900(this.R, r100, r101);
            Block.access$800(this.Z, this.R);
            applyBlake();
            Block.access$1000(r102, this.R, this.Z);
        }
    }

    public static class Position {
        int lane;
        int pass;
        int slice;

        public Position() {
        }
    }

    static {
        ZERO_BYTES = new byte[4];
    }

    public Argon2BytesGenerator() {
    }

    private static void F(long[] r100, int r101, int r102, int r103, int r104) {
        quarterRound(r100, r101, r102, r104, 32);
        quarterRound(r100, r103, r104, r102, 24);
        quarterRound(r100, r101, r102, r104, 16);
        quarterRound(r100, r103, r104, r102, 63);
    }

    public static /* synthetic */ void access$700(Block r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109, int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        roundFunction(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116);
    }

    private static void addByteString(byte[] r100, Digest r101, byte[] r102) {
        if (r102 != null) goto L6;
        r101.update(ZERO_BYTES, 0, 4);
        return;
    L6:
        Pack.intToLittleEndian(r102.length, r100, 0);
        r101.update(r100, 0, 4);
        r101.update(r102, 0, r102.length);
    }

    private void digest(byte[] r100, byte[] r101, int r102, int r103) {
        Block r104 = this.memory[this.laneLength - 1];
        int r105 = 1;
    L4:
        if (r105 >= this.parameters.getLanes()) goto L6;
        int r106 = this.laneLength;
        int r107 = (r105 * r106) + (r106 - 1);
        Block.access$600(r104, this.memory[r107]);
        r105 = r105 + 1;
        goto L4
    L6:
        r104.toBytes(r100);
        hash(r100, r101, r102, r103);
    }

    private void doInit(Argon2Parameters r100) {
        int r101 = r100.getMemory();
        if (r101 >= (r100.getLanes() * 8)) goto L5;
        r101 = r100.getLanes() * 8;
    L5:
        int r102 = r101 / (r100.getLanes() * 4);
        this.segmentLength = r102;
        this.laneLength = r102 * 4;
        initMemory(r102 * (r100.getLanes() * 4));
    }

    private void fillFirstBlocks(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[72];
        System.arraycopy(r101, 0, r102, 0, 64);
        r102[64] = 1;
        int r103 = 0;
    L4:
        if (r103 >= this.parameters.getLanes()) goto L6;
        Pack.intToLittleEndian(r103, r101, 68);
        Pack.intToLittleEndian(r103, r102, 68);
        hash(r101, r100, 0, 1024);
        this.memory[(this.laneLength * r103) + 0].fromBytes(r100);
        hash(r102, r100, 0, 1024);
        this.memory[(this.laneLength * r103) + 1].fromBytes(r100);
        r103 = r103 + 1;
        goto L4
    }

    private void fillMemoryBlocks() {
        FillBlock r100 = new FillBlock(null);
        Position r101 = new Position();
        int r102 = 0;
    L4:
        if (r102 >= this.parameters.getIterations()) goto L14;
        r101.pass = r102;
        int r103 = 0;
    L7:
        if (r103 >= 4) goto L13;
        r101.slice = r103;
        int r104 = 0;
    L10:
        if (r104 >= this.parameters.getLanes()) goto L12;
        r101.lane = r104;
        fillSegment(r100, r101);
        r104 = r104 + 1;
        goto L10
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        r102 = r102 + 1;
        goto L4
    }

    private void fillSegment(FillBlock r110, Position r111) {
        boolean r112 = isDataIndependentAddressing(r111);
        int r100 = getStartingIndex(r111);
        int r101 = ((r111.lane * this.laneLength) + (r111.slice * this.segmentLength)) + r100;
        int r102 = getPrevOffset(r101);
        if (r112 == false) goto L5;
        Block r103 = r110.addressBlock.clear();
        Block r104 = r110.inputBlock.clear();
        initAddressBlocks(r110, r111, r104, r103);
        Block r113 = r103;
        Block r114 = r104;
    L6:
        boolean r115 = isWithXor(r111);
        int r116 = r100;
        int r117 = r101;
        int r118 = r102;
    L8:
        if (r116 >= this.segmentLength) goto L18;
        long r105 = getPseudoRandom(r110, r116, r113, r114, r118, r112);
        int r106 = getRefLane(r111, r105);
        if (r106 != r111.lane) goto L12;
        boolean r107 = true;
    L13:
        int r108 = getRefColumn(r111, r116, r105, r107);
        Block[] r109 = this.memory;
        Block r119 = r109[r118];
        Block r120 = r109[(this.laneLength * r106) + r108];
        Block r121 = r109[r117];
        if (r115 == false) goto L16;
        FillBlock.access$200(r110, r119, r120, r121);
    L17:
        r116 = r116 + 1;
        r118 = r117;
        r117 = r117 + 1;
        goto L8
    L16:
        FillBlock.access$300(r110, r119, r120, r121);
        goto L17
    L12:
        r107 = false;
        goto L13
    L18:
        return;
    L5:
        r113 = null;
        r114 = null;
        goto L6
    }

    private int getPrevOffset(int r100) {
        int r101 = this.laneLength;
        if ((r100 % r101) != 0) goto L7;
        return (r100 + r101) - 1;
    L7:
        return r100 - 1;
    }

    private long getPseudoRandom(FillBlock r100, int r101, Block r102, Block r103, int r104, boolean r105) {
        if (r105 == false) goto L9;
        int r106 = r101 % 128;
        if (r106 != 0) goto L7;
        nextAddresses(r100, r103, r102);
    L7:
        return Block.access$400(r102)[r106];
    L9:
        return Block.access$400(this.memory[r104])[0];
    }

    private int getRefColumn(Position r100, int r101, long r102, boolean r110) {
        int r103 = r100.pass;
        int r104 = -1;
        int r105 = 0;
        int r106 = r100.slice;
        if (r103 != 0) goto L11;
        if (r110 == false) goto L6;
        int r107 = ((r106 * this.segmentLength) + r101) - 1;
    L19:
        long r108 = r102 & 4294967295L;
        return ((int) (((long) r105) + (((long) (r107 - 1)) - ((r107 * ((r108 * r108) >>> 32)) >>> 32)))) % this.laneLength;
    L6:
        int r109 = r106 * this.segmentLength;
        if (r101 == 0) goto L10;
        r104 = 0;
    L10:
        r107 = r109 + r104;
        goto L19
    L11:
        int r111 = this.segmentLength;
        int r112 = this.laneLength;
        int r113 = ((r106 + 1) * r111) % r112;
        int r114 = r112 - r111;
        if (r110 == false) goto L15;
        int r115 = (r114 + r101) - 1;
    L14:
        r105 = r113;
        r107 = r115;
        goto L19
    L15:
        if (r101 == 0) goto L18;
        r104 = 0;
    L18:
        r115 = r114 + r104;
        goto L14
    }

    private int getRefLane(Position r100, long r101) {
        int r102 = (int) ((r101 >>> 32) % ((long) this.parameters.getLanes()));
        if (r100.pass == 0) goto L5;
        return r102;
    L5:
        if (r100.slice == 0) goto L7;
        return r102;
    L7:
        return r100.lane;
    }

    private static int getStartingIndex(Position r100) {
        if (r100.pass == 0) goto L5;
        return 0;
    L5:
        if (r100.slice != 0) goto L10;
        return 2;
    L10:
        return 0;
    }

    private void hash(byte[] r100, byte[] r101, int r102, int r110) {
        byte[] r103 = new byte[4];
        Pack.intToLittleEndian(r110, r103, 0);
        if (r110 > 64) goto L5;
        Blake2bDigest r104 = new Blake2bDigest(r110 * 8);
        r104.update(r103, 0, 4);
        r104.update(r100, 0, r100.length);
        r104.doFinal(r101, r102);
        return;
    L5:
        Blake2bDigest r105 = new Blake2bDigest(512);
        byte[] r106 = new byte[64];
        r105.update(r103, 0, 4);
        r105.update(r100, 0, r100.length);
        r105.doFinal(r106, 0);
        System.arraycopy(r106, 0, r101, r102, 32);
        int r107 = r102 + 32;
        int r108 = 2;
        int r109 = ((r110 + 31) / 32) - 2;
    L6:
        if (r108 > r109) goto L8;
        r105.update(r106, 0, 64);
        r105.doFinal(r106, 0);
        System.arraycopy(r106, 0, r101, r107, 32);
        r108 = r108 + 1;
        r107 = r107 + 32;
        goto L6
    L8:
        Blake2bDigest r111 = new Blake2bDigest((r110 - (r109 * 32)) * 8);
        r111.update(r106, 0, 64);
        r111.doFinal(r101, r107);
    }

    private void initAddressBlocks(FillBlock r100, Position r101, Block r102, Block r103) {
        Block.access$400(r102)[0] = intToLong(r101.pass);
        Block.access$400(r102)[1] = intToLong(r101.lane);
        Block.access$400(r102)[2] = intToLong(r101.slice);
        Block.access$400(r102)[3] = intToLong(this.memory.length);
        Block.access$400(r102)[4] = intToLong(this.parameters.getIterations());
        Block.access$400(r102)[5] = intToLong(this.parameters.getType());
        if (r101.pass == 0) goto L5;
        return;
    L5:
        if (r101.slice != 0) goto L9;
        nextAddresses(r100, r102, r103);
        return;
    }

    private void initMemory(int r100) {
        this.memory = new Block[r100];
        int r101 = 0;
    L3:
        Block[] r102 = this.memory;
        if (r101 >= r102.length) goto L6;
        r102[r101] = new Block(null);
        r101 = r101 + 1;
        goto L3
    }

    private void initialize(byte[] r100, byte[] r101, int r102) {
        Blake2bDigest r103 = new Blake2bDigest(512);
        Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), r102, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.getType()}, r100, 0);
        r103.update(r100, 0, 24);
        addByteString(r100, r103, r101);
        addByteString(r100, r103, this.parameters.getSalt());
        addByteString(r100, r103, this.parameters.getSecret());
        addByteString(r100, r103, this.parameters.getAdditional());
        byte[] r104 = new byte[72];
        r103.doFinal(r104, 0);
        fillFirstBlocks(r100, r104);
    }

    private long intToLong(int r100) {
        return ((long) r100) & 4294967295L;
    }

    private boolean isDataIndependentAddressing(Position r100) {
        if (this.parameters.getType() != 1) goto L5;
        return true;
    L5:
        if (this.parameters.getType() == 2) goto L7;
    L11:
        return false;
    L7:
        if (r100.pass != 0) goto L11;
        if (r100.slice >= 2) goto L11;
        return true;
    }

    private boolean isWithXor(Position r100) {
        if (r100.pass != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.parameters.getVersion() == 16) goto L7;
        return true;
    }

    private void nextAddresses(FillBlock r100, Block r101, Block r102) {
        long[] r103 = Block.access$400(r101);
        r103[6] = r103[6] + 1;
        FillBlock.access$500(r100, r101, r102);
        FillBlock.access$500(r100, r102, r102);
    }

    private static void quarterRound(long[] r110, int r111, int r112, int r113, int r114) {
        long r100 = r110[r111];
        long r101 = r110[r112];
        long r102 = r100 + (r101 + (((r100 & 4294967295L) * 2) * (4294967295L & r101)));
        long r103 = Longs.rotateRight(r110[r113] ^ r102, r114);
        r110[r111] = r102;
        r110[r113] = r103;
    }

    private void reset() {
        if (this.memory == null) goto L11;
        int r100 = 0;
    L5:
        Block[] r101 = this.memory;
        if (r100 >= r101.length) goto L15;
        Block r102 = r101[r100];
        if (r102 == null) goto L10;
        r102.clear();
    L10:
        r100 = r100 + 1;
        goto L5
    L15:
        return;
    }

    private static void roundFunction(Block r110, int r111, int r112, int r113, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r310, int r311, int r312) {
        long[] r100 = Block.access$400(r110);
        F(r100, r111, r211, r215, r219);
        F(r100, r112, r212, r216, r310);
        F(r100, r113, r213, r217, r311);
        F(r100, r210, r214, r218, r312);
        F(r100, r111, r212, r217, r312);
        F(r100, r112, r213, r218, r219);
        F(r100, r113, r214, r215, r310);
        F(r100, r210, r211, r216, r311);
    }

    public int generateBytes(byte[] r100, byte[] r101) {
        return generateBytes(r100, r101, 0, r101.length);
    }

    public int generateBytes(byte[] r100, byte[] r101, int r102, int r103) {
        if (r103 < 4) goto L7;
        byte[] r104 = new byte[1024];
        initialize(r104, r100, r103);
        fillMemoryBlocks();
        digest(r104, r101, r102, r103);
        reset();
        return r103;
    L7:
        throw new IllegalStateException("output length less than 4");
    }

    public int generateBytes(char[] r100, byte[] r101) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(r100), r101);
    }

    public int generateBytes(char[] r100, byte[] r101, int r102, int r103) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(r100), r101, r102, r103);
    }

    public void init(Argon2Parameters r100) {
        this.parameters = r100;
        if (r100.getLanes() < 1) goto L19;
        if (r100.getLanes() > 16777216) goto L17;
        if (r100.getMemory() < (r100.getLanes() * 2)) goto L15;
        if (r100.getIterations() < 1) goto L13;
        doInit(r100);
        return;
    L13:
        throw new IllegalStateException("iterations is less than: 1");
    L15:
        throw new IllegalStateException("memory is less than: " + (r100.getLanes() * 2) + " expected " + (r100.getLanes() * 2));
    L17:
        throw new IllegalStateException("lanes must be less than 16777216");
    L19:
        throw new IllegalStateException("lanes must be greater than 1");
    }
}
