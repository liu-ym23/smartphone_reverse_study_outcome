package org.bouncycastle.crypto.digests;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ThreefishEngine;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class SkeinEngine implements Memoable {
    private static final Hashtable INITIAL_STATES = null;
    private static final int PARAM_TYPE_CONFIG = 4;
    private static final int PARAM_TYPE_KEY = 0;
    private static final int PARAM_TYPE_MESSAGE = 48;
    private static final int PARAM_TYPE_OUTPUT = 63;
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    long[] chain;
    private long[] initialState;
    private byte[] key;
    private final int outputSizeBytes;
    private Parameter[] postMessageParameters;
    private Parameter[] preMessageParameters;
    private final byte[] singleByte;
    final ThreefishEngine threefish;
    private final UBI ubi;

    public static class Configuration {
        private byte[] bytes;

        public Configuration(long r100) {
            byte[] r101 = new byte[32];
            this.bytes = r101;
            r101[0] = 83;
            r101[1] = 72;
            r101[2] = 65;
            r101[3] = 51;
            r101[4] = 1;
            r101[5] = 0;
            ThreefishEngine.wordToBytes(r100, r101, 8);
        }

        public byte[] getBytes() {
            return this.bytes;
        }
    }

    public static class Parameter {
        private int type;
        private byte[] value;

        public Parameter(int r100, byte[] r101) {
            this.type = r100;
            this.value = r101;
        }

        public int getType() {
            return this.type;
        }

        public byte[] getValue() {
            return this.value;
        }
    }

    public class UBI {
        private byte[] currentBlock;
        private int currentOffset;
        private long[] message;
        final /* synthetic */ SkeinEngine this$0;
        private final UbiTweak tweak;

        public UBI(SkeinEngine r100, int r101) {
            this.this$0 = r100;
            this.tweak = new UbiTweak();
            byte[] r102 = new byte[r101];
            this.currentBlock = r102;
            this.message = new long[r102.length / 8];
        }

        private void processBlock(long[] r100) {
            SkeinEngine r101 = this.this$0;
            r101.threefish.init(true, r101.chain, this.tweak.getWords());
            int r102 = 0;
            int r103 = 0;
        L3:
            long[] r104 = this.message;
            if (r103 >= r104.length) goto L6;
            r104[r103] = ThreefishEngine.bytesToWord(this.currentBlock, r103 * 8);
            r103 = r103 + 1;
            goto L3
        L6:
            this.this$0.threefish.processBlock(r104, r100);
        L8:
            if (r102 >= r100.length) goto L10;
            r100[r102] = r100[r102] ^ this.message[r102];
            r102 = r102 + 1;
            goto L8
        }

        public void doFinal(long[] r100) {
            int r101 = this.currentOffset;
        L3:
            byte[] r102 = this.currentBlock;
            if (r101 >= r102.length) goto L6;
            r102[r101] = 0;
            r101 = r101 + 1;
            goto L3
        L6:
            this.tweak.setFinal(true);
            processBlock(r100);
        }

        public void reset(int r100) {
            this.tweak.reset();
            this.tweak.setType(r100);
            this.currentOffset = 0;
        }

        public void reset(UBI r100) {
            this.currentBlock = Arrays.clone(r100.currentBlock, this.currentBlock);
            this.currentOffset = r100.currentOffset;
            this.message = Arrays.clone(r100.message, this.message);
            this.tweak.reset(r100.tweak);
        }

        public void update(byte[] r100, int r101, int r102, long[] r110) {
            int r103 = 0;
        L3:
            if (r102 <= r103) goto L8;
            if (this.currentOffset != this.currentBlock.length) goto L7;
            processBlock(r110);
            this.tweak.setFirst(false);
            this.currentOffset = 0;
        L7:
            int r104 = Math.min(r102 - r103, this.currentBlock.length - this.currentOffset);
            System.arraycopy(r100, r101 + r103, this.currentBlock, this.currentOffset, r104);
            r103 = r103 + r104;
            this.currentOffset += r104;
            this.tweak.advancePosition(r104);
            goto L3
        }
    }

    public static class UbiTweak {
        private static final long LOW_RANGE = 9223372034707292160L;
        private static final long T1_FINAL = Long.MIN_VALUE;
        private static final long T1_FIRST = 4611686018427387904L;
        private boolean extendedPosition;
        private long[] tweak;

        public UbiTweak() {
            this.tweak = new long[2];
            reset();
        }

        public void advancePosition(int r110) {
            if (this.extendedPosition == false) goto L8;
            long[] r100 = new long[3];
            long[] r101 = this.tweak;
            r100[0] = r101[0] & BodyPartID.bodyIdMax;
            r100[1] = (r101[0] >>> 32) & BodyPartID.bodyIdMax;
            r100[2] = r101[1] & BodyPartID.bodyIdMax;
            long r102 = r110;
            int r111 = 0;
        L5:
            if (r111 >= 3) goto L7;
            long r103 = r102 + r100[r111];
            r100[r111] = r103;
            r102 = r103 >>> 32;
            r111 = r111 + 1;
            goto L5
        L7:
            long[] r112 = this.tweak;
            r112[0] = ((r100[1] & BodyPartID.bodyIdMax) << 32) | (r100[0] & BodyPartID.bodyIdMax);
            r112[1] = (r100[2] & BodyPartID.bodyIdMax) | (r112[1] & (-4294967296L));
            return;
        L8:
            long[] r104 = this.tweak;
            long r105 = r104[0] + ((long) r110);
            r104[0] = r105;
            if (r105 <= LOW_RANGE) goto L14;
            this.extendedPosition = true;
            return;
        }

        public int getType() {
            return (int) ((this.tweak[1] >>> 56) & 63);
        }

        public long[] getWords() {
            return this.tweak;
        }

        public boolean isFinal() {
            if ((this.tweak[1] & Long.MIN_VALUE) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isFirst() {
            if ((this.tweak[1] & 4611686018427387904L) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public void reset() {
            long[] r100 = this.tweak;
            r100[0] = 0;
            r100[1] = 0;
            this.extendedPosition = false;
            setFirst(true);
        }

        public void reset(UbiTweak r100) {
            this.tweak = Arrays.clone(r100.tweak, this.tweak);
            this.extendedPosition = r100.extendedPosition;
        }

        public void setFinal(boolean r100) {
            if (r100 == false) goto L5;
            long[] r101 = this.tweak;
            r101[1] = r101[1] | Long.MIN_VALUE;
            return;
        L5:
            long[] r102 = this.tweak;
            r102[1] = r102[1] & Long.MAX_VALUE;
        }

        public void setFirst(boolean r100) {
            if (r100 == false) goto L5;
            long[] r101 = this.tweak;
            r101[1] = r101[1] | 4611686018427387904L;
            return;
        L5:
            long[] r102 = this.tweak;
            r102[1] = r102[1] & (-4611686018427387905L);
        }

        public void setType(int r100) {
            long[] r101 = this.tweak;
            r101[1] = (r101[1] & (-274877906944L)) | ((((long) r100) & 63) << 56);
        }

        public String toString() {
            return getType() + " first: " + isFirst() + ", final: " + isFinal();
        }
    }

    static {
        INITIAL_STATES = new Hashtable();
        initialState(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        initialState(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        initialState(256, 224, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        initialState(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        initialState(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        initialState(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        initialState(512, 224, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        initialState(512, 384, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        initialState(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    public SkeinEngine(int r100, int r101) {
        this.singleByte = new byte[1];
        if ((r101 % 8) != 0) goto L7;
        this.outputSizeBytes = r101 / 8;
        ThreefishEngine r102 = new ThreefishEngine(r100);
        this.threefish = r102;
        this.ubi = new UBI(this, r102.getBlockSize());
        return;
    L7:
        throw new IllegalArgumentException("Output size must be a multiple of 8 bits. :" + r101);
    }

    public SkeinEngine(SkeinEngine r100) {
        this(r100.getBlockSize() * 8, r100.getOutputSize() * 8);
        copyIn(r100);
    }

    private void checkInitialised() {
        if (this.ubi == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Skein engine is not initialised.");
    }

    private static Parameter[] clone(Parameter[] r100, Parameter[] r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
    L8:
        r101 = new Parameter[r100.length];
    L9:
        System.arraycopy(r100, 0, r101, 0, r101.length);
        return r101;
    L7:
        if (r101.length == r100.length) goto L9;
        goto L8
    }

    private void copyIn(SkeinEngine r100) {
        this.ubi.reset(r100.ubi);
        this.chain = Arrays.clone(r100.chain, this.chain);
        this.initialState = Arrays.clone(r100.initialState, this.initialState);
        this.key = Arrays.clone(r100.key, this.key);
        this.preMessageParameters = clone(r100.preMessageParameters, this.preMessageParameters);
        this.postMessageParameters = clone(r100.postMessageParameters, this.postMessageParameters);
    }

    private void createInitialState() {
        long[] r100 = (long[]) INITIAL_STATES.get(variantIdentifier(getBlockSize(), getOutputSize()));
        int r101 = 0;
        if (this.key != null) goto L6;
        if (r100 == null) goto L6;
        this.chain = Arrays.clone(r100);
    L11:
        if (this.preMessageParameters == null) goto L15;
    L12:
        Parameter[] r102 = this.preMessageParameters;
        if (r101 >= r102.length) goto L15;
        Parameter r103 = r102[r101];
        ubiComplete(r103.getType(), r103.getValue());
        r101 = r101 + 1;
    L15:
        this.initialState = Arrays.clone(this.chain);
        return;
    L6:
        this.chain = new long[getBlockSize() / 8];
        byte[] r104 = this.key;
        if (r104 == null) goto L9;
        ubiComplete(0, r104);
    L9:
        ubiComplete(4, new Configuration(this.outputSizeBytes * 8).getBytes());
        goto L11
    }

    private void initParams(Hashtable r100) {
        Enumeration r101 = r100.keys();
        Vector r102 = new Vector();
        Vector r103 = new Vector();
    L4:
        if (r101.hasMoreElements() == false) goto L12;
        Integer r104 = (Integer) r101.nextElement();
        byte[] r105 = (byte[]) r100.get(r104);
        if (r104.intValue() == 0) goto L7;
        if (r104.intValue() < 48) goto L10;
        r103.addElement(new Parameter(r104.intValue(), r105));
        goto L4
    L10:
        r102.addElement(new Parameter(r104.intValue(), r105));
        goto L4
    L7:
        this.key = r105;
        goto L4
    L12:
        Parameter[] r106 = new Parameter[r102.size()];
        this.preMessageParameters = r106;
        r102.copyInto(r106);
        sort(this.preMessageParameters);
        Parameter[] r107 = new Parameter[r103.size()];
        this.postMessageParameters = r107;
        r103.copyInto(r107);
        sort(this.postMessageParameters);
    }

    private static void initialState(int r100, int r101, long[] r102) {
        INITIAL_STATES.put(variantIdentifier(r100 / 8, r101 / 8), r102);
    }

    private void output(long r100, byte[] r110, int r111, int r112) {
        byte[] r101 = new byte[8];
        ThreefishEngine.wordToBytes(r100, r101, 0);
        long[] r102 = new long[this.chain.length];
        ubiInit(63);
        this.ubi.update(r101, 0, 8, r102);
        this.ubi.doFinal(r102);
        int r113 = ((r112 + 8) - 1) / 8;
        int r103 = 0;
    L3:
        if (r103 >= r113) goto L9;
        int r104 = r103 * 8;
        int r105 = Math.min(8, r112 - r104);
        if (r105 != 8) goto L7;
        ThreefishEngine.wordToBytes(r102[r103], r110, r104 + r111);
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        ThreefishEngine.wordToBytes(r102[r103], r101, 0);
        System.arraycopy(r101, 0, r110, r104 + r111, r105);
        goto L8
    }

    private static void sort(Parameter[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 1;
    L6:
        if (r101 >= r100.length) goto L13;
        Parameter r102 = r100[r101];
        int r103 = r101;
    L8:
        if (r103 <= 0) goto L12;
        int r104 = r103 - 1;
        if (r102.getType() >= r100[r104].getType()) goto L12;
        r100[r103] = r100[r104];
        r103 = r104;
    L12:
        r100[r103] = r102;
        r101 = r101 + 1;
        goto L6
    }

    private void ubiComplete(int r100, byte[] r101) {
        ubiInit(r100);
        this.ubi.update(r101, 0, r101.length, this.chain);
        ubiFinal();
    }

    private void ubiFinal() {
        this.ubi.doFinal(this.chain);
    }

    private void ubiInit(int r100) {
        this.ubi.reset(r100);
    }

    private static Integer variantIdentifier(int r100, int r101) {
        return Integers.valueOf(r100 | (r101 << 16));
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SkeinEngine(this);
    }

    public int doFinal(byte[] r110, int r111) {
        checkInitialised();
        if (r110.length < (this.outputSizeBytes + r111)) goto L16;
        ubiFinal();
        int r100 = 0;
        if (this.postMessageParameters == null) goto L10;
        int r101 = 0;
    L7:
        Parameter[] r102 = this.postMessageParameters;
        if (r101 >= r102.length) goto L10;
        Parameter r103 = r102[r101];
        ubiComplete(r103.getType(), r103.getValue());
        r101 = r101 + 1;
    L10:
        int r104 = getBlockSize();
        int r105 = ((this.outputSizeBytes + r104) - 1) / r104;
    L11:
        if (r100 >= r105) goto L13;
        int r106 = r100 * r104;
        output(r100, r110, r111 + r106, Math.min(r104, this.outputSizeBytes - r106));
        r100 = r100 + 1;
        goto L11
    L13:
        reset();
        return this.outputSizeBytes;
    L16:
        throw new OutputLengthException("Output buffer is too short to hold output");
    }

    public int getBlockSize() {
        return this.threefish.getBlockSize();
    }

    public int getOutputSize() {
        return this.outputSizeBytes;
    }

    public void init(SkeinParameters r100) {
        this.chain = null;
        this.key = null;
        this.preMessageParameters = null;
        this.postMessageParameters = null;
        if (r100 != null) goto L5;
    L9:
        createInitialState();
        ubiInit(48);
        return;
    L5:
        if (r100.getKey().length < 16) goto L8;
        initParams(r100.getParameters());
        goto L9
    L8:
        throw new IllegalArgumentException("Skein key must be at least 128 bits.");
    }

    public void reset() {
        long[] r100 = this.initialState;
        long[] r101 = this.chain;
        System.arraycopy(r100, 0, r101, 0, r101.length);
        ubiInit(48);
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        SkeinEngine r101 = (SkeinEngine) r100;
        if (getBlockSize() != r101.getBlockSize()) goto L9;
        if (this.outputSizeBytes != r101.outputSizeBytes) goto L9;
        copyIn(r101);
        return;
    L9:
        throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
    }

    public void update(byte r100) {
        byte[] r101 = this.singleByte;
        r101[0] = r100;
        update(r101, 0, 1);
    }

    public void update(byte[] r100, int r101, int r102) {
        checkInitialised();
        this.ubi.update(r100, r101, r102, this.chain);
    }
}
