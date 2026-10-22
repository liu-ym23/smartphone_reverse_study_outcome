package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier;
import org.bouncycastle.crypto.modes.kgcm.Tables16kKGCMMultiplier_512;
import org.bouncycastle.crypto.modes.kgcm.Tables4kKGCMMultiplier_128;
import org.bouncycastle.crypto.modes.kgcm.Tables8kKGCMMultiplier_256;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int MIN_MAC_BITS = 64;
    private ExposedByteArrayOutputStream associatedText;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f525275b;
    private final int blockSize;
    private BufferedBlockCipher ctrEngine;
    private ExposedByteArrayOutputStream data;
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525276iv;
    private byte[] macBlock;
    private int macSize;
    private KGCMMultiplier multiplier;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        final /* synthetic */ KGCMBlockCipher this$0;

        public ExposedByteArrayOutputStream(KGCMBlockCipher r100) {
            this.this$0 = r100;
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KGCMBlockCipher(BlockCipher r100) {
        this.associatedText = new ExposedByteArrayOutputStream(this);
        this.data = new ExposedByteArrayOutputStream(this);
        this.engine = r100;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(r100));
        this.macSize = -1;
        int r101 = this.engine.getBlockSize();
        this.blockSize = r101;
        this.initialAssociatedText = new byte[r101];
        this.f525276iv = new byte[r101];
        this.multiplier = createDefaultMultiplier(r101);
        this.f525275b = new long[r101 >>> 3];
        this.macBlock = null;
    }

    private void calculateMac(byte[] r100, int r101, int r102, int r103) {
        int r104 = r101 + r102;
    L3:
        if (r101 >= r104) goto L5;
        xorWithInput(this.f525275b, r100, r101);
        this.multiplier.multiplyH(this.f525275b);
        r101 = r101 + this.blockSize;
        goto L3
    L5:
        long r105 = (((long) r103) & BodyPartID.bodyIdMax) << 3;
        long r106 = (BodyPartID.bodyIdMax & ((long) r102)) << 3;
        long[] r107 = this.f525275b;
        r107[0] = r105 ^ r107[0];
        int r108 = this.blockSize >>> 4;
        r107[r108] = r107[r108] ^ r106;
        byte[] r109 = Pack.longToLittleEndian(r107);
        this.macBlock = r109;
        this.engine.processBlock(r109, 0, r109, 0);
    }

    private static KGCMMultiplier createDefaultMultiplier(int r100) {
        if (r100 == 16) goto L15;
        if (r100 == 32) goto L13;
        if (r100 != 64) goto L11;
        return new Tables16kKGCMMultiplier_512();
    L11:
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    L13:
        return new Tables8kKGCMMultiplier_256();
    L15:
        return new Tables4kKGCMMultiplier_128();
    }

    private void processAAD(byte[] r100, int r101, int r102) {
        int r103 = r102 + r101;
    L3:
        if (r101 >= r103) goto L5;
        xorWithInput(this.f525275b, r100, r101);
        this.multiplier.multiplyH(this.f525275b);
        r101 = r101 + this.blockSize;
        goto L3
    }

    private static void xorWithInput(long[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r100[r103] = r100[r103] ^ Pack.littleEndianToLong(r101, r102);
        r102 = r102 + 8;
        r103 = r103 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r110, int r111) throws IllegalStateException, InvalidCipherTextException {
        int r100 = this.data.size();
        if (this.forEncryption == false) goto L5;
    L9:
        byte[] r101 = new byte[this.blockSize];
        this.engine.processBlock(r101, 0, r101, 0);
        long[] r102 = new long[this.blockSize >>> 3];
        Pack.littleEndianToLong(r101, 0, r102);
        this.multiplier.init(r102);
        Arrays.fill(r101, (byte) 0);
        Arrays.fill(r102, 0);
        int r103 = this.associatedText.size();
        if (r103 <= 0) goto L13;
        processAAD(this.associatedText.getBuffer(), 0, r103);
    L13:
        if (this.forEncryption == true) goto L15;
        int r104 = r100 - this.macSize;
        if ((r110.length - r111) < r104) goto L37;
        calculateMac(this.data.getBuffer(), 0, r104, r103);
        int r105 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, r104, r110, r111);
        int r106 = r105 + this.ctrEngine.doFinal(r110, r111 + r105);
    L22:
        byte[] r107 = this.macBlock;
        if (r107 == null) goto L35;
        if (this.forEncryption == false) goto L28;
        System.arraycopy(r107, 0, r110, r111 + r106, this.macSize);
        reset();
        return r106 + this.macSize;
    L28:
        byte[] r108 = new byte[this.macSize];
        byte[] r109 = this.data.getBuffer();
        int r112 = this.macSize;
        System.arraycopy(r109, r100 - r112, r108, 0, r112);
        int r113 = this.macSize;
        byte[] r114 = new byte[r113];
        System.arraycopy(this.macBlock, 0, r114, 0, r113);
        if (Arrays.constantTimeAreEqual(r108, r114) == false) goto L33;
        reset();
        return r106;
    L33:
        throw new InvalidCipherTextException("mac verification failed");
    L35:
        throw new IllegalStateException("mac is not calculated");
    L37:
        throw new OutputLengthException("Output buffer too short");
    L15:
        if (((r110.length - r111) - this.macSize) < r100) goto L18;
        int r115 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, r100, r110, r111);
        r106 = r115 + this.ctrEngine.doFinal(r110, r111 + r115);
        calculateMac(r110, r111, r100, r103);
        goto L22
    L18:
        throw new OutputLengthException("Output buffer too short");
    L5:
        if (r100 >= this.macSize) goto L9;
        throw new InvalidCipherTextException("data too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KGCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        int r100 = this.macSize;
        byte[] r101 = new byte[r100];
        System.arraycopy(this.macBlock, 0, r101, 0, r100);
        return r101;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int r100) {
        int r101 = r100 + this.data.size();
        if (this.forEncryption == true) goto L5;
        int r102 = this.macSize;
        if (r101 >= r102) goto L10;
        return 0;
    L10:
        return r101 - r102;
    L5:
        return r101 + this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof AEADParameters) == false) goto L16;
        AEADParameters r102 = (AEADParameters) r101;
        byte[] r103 = r102.getNonce();
        byte[] r104 = this.f525276iv;
        int r105 = r104.length - r103.length;
        Arrays.fill(r104, (byte) 0);
        System.arraycopy(r103, 0, this.f525276iv, r105, r103.length);
        this.initialAssociatedText = r102.getAssociatedText();
        int r106 = r102.getMacSize();
        if (r106 < 64) goto L14;
        if (r106 > (this.blockSize << 3)) goto L14;
        if ((r106 & 7) != 0) goto L14;
        this.macSize = r106 >>> 3;
        KeyParameter r107 = r102.getKey();
        byte[] r108 = this.initialAssociatedText;
        if (r108 == null) goto L18;
        processAADBytes(r108, 0, r108.length);
    L18:
        this.macBlock = new byte[this.blockSize];
        this.ctrEngine.init(true, new ParametersWithIV(r107, this.f525276iv));
        this.engine.init(true, r107);
        return;
    L14:
        throw new IllegalArgumentException("Invalid value for MAC size: " + r106);
    L16:
        if ((r101 instanceof ParametersWithIV) == false) goto L21;
        ParametersWithIV r109 = (ParametersWithIV) r101;
        byte[] r110 = r109.getIV();
        byte[] r111 = this.f525276iv;
        int r112 = r111.length - r110.length;
        Arrays.fill(r111, (byte) 0);
        System.arraycopy(r110, 0, this.f525276iv, r112, r110.length);
        this.initialAssociatedText = null;
        this.macSize = this.blockSize;
        r107 = (KeyParameter) r109.getParameters();
        goto L18
    L21:
        throw new IllegalArgumentException("Invalid parameter passed");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte r100) {
        this.associatedText.write(r100);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] r100, int r101, int r102) {
        this.associatedText.write(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException, IllegalStateException {
        this.data.write(r100);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException, IllegalStateException {
        if (r100.length < (r101 + r102)) goto L7;
        this.data.write(r100, r101, r102);
        return 0;
    L7:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        Arrays.fill(this.f525275b, 0);
        this.engine.reset();
        this.data.reset();
        this.associatedText.reset();
        byte[] r100 = this.initialAssociatedText;
        if (r100 == null) goto L6;
        processAADBytes(r100, 0, r100.length);
        return;
    }
}
