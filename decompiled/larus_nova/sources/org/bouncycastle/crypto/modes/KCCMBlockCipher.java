package org.bouncycastle.crypto.modes;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class KCCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final int BYTES_IN_INT = 4;
    private static final int MAX_MAC_BIT_LENGTH = 512;
    private static final int MIN_MAC_BIT_LENGTH = 64;
    private byte[] G1;
    private int Nb_;
    private ExposedByteArrayOutputStream associatedText;
    private byte[] buffer;
    private byte[] counter;
    private ExposedByteArrayOutputStream data;
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private byte[] f525272mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private byte[] f525273s;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        final /* synthetic */ KCCMBlockCipher this$0;

        public ExposedByteArrayOutputStream(KCCMBlockCipher r100) {
            this.this$0 = r100;
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public KCCMBlockCipher(BlockCipher r100) {
        this(r100, 4);
    }

    public KCCMBlockCipher(BlockCipher r100, int r101) {
        this.associatedText = new ExposedByteArrayOutputStream(this);
        this.data = new ExposedByteArrayOutputStream(this);
        this.Nb_ = 4;
        this.engine = r100;
        this.macSize = r100.getBlockSize();
        this.nonce = new byte[r100.getBlockSize()];
        this.initialAssociatedText = new byte[r100.getBlockSize()];
        this.f525272mac = new byte[r100.getBlockSize()];
        this.macBlock = new byte[r100.getBlockSize()];
        this.G1 = new byte[r100.getBlockSize()];
        this.buffer = new byte[r100.getBlockSize()];
        this.f525273s = new byte[r100.getBlockSize()];
        this.counter = new byte[r100.getBlockSize()];
        setNb(r101);
    }

    private void CalculateMac(byte[] r100, int r101, int r102) {
    L2:
        if (r102 <= 0) goto L8;
        int r103 = 0;
    L5:
        if (r103 >= this.engine.getBlockSize()) goto L7;
        byte[] r104 = this.macBlock;
        r104[r103] = (byte) (r104[r103] ^ r100[r101 + r103]);
        r103 = r103 + 1;
        goto L5
    L7:
        BlockCipher r105 = this.engine;
        byte[] r106 = this.macBlock;
        r105.processBlock(r106, 0, r106, 0);
        r102 = r102 - this.engine.getBlockSize();
        r101 = r101 + this.engine.getBlockSize();
        goto L2
    }

    private void ProcessBlock(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        int r105 = 0;
        int r106 = 0;
    L3:
        byte[] r107 = this.counter;
        if (r106 >= r107.length) goto L6;
        byte[] r108 = this.f525273s;
        r108[r106] = (byte) (r108[r106] + r107[r106]);
        r106 = r106 + 1;
        goto L3
    L6:
        this.engine.processBlock(this.f525273s, 0, this.buffer, 0);
    L8:
        if (r105 >= this.engine.getBlockSize()) goto L10;
        r103[r104 + r105] = (byte) (this.buffer[r105] ^ r100[r101 + r105]);
        r105 = r105 + 1;
        goto L8
    }

    private byte getFlag(boolean r100, int r101) {
        StringBuffer r102 = new StringBuffer();
        if (r100 == false) goto L5;
        r102.append("1");
    L7:
        if (r101 != 8) goto L9;
        String r103 = "010";
    L22:
        r102.append(r103);
    L23:
        String r104 = Integer.toBinaryString(this.Nb_ - 1);
    L25:
        if (r104.length() >= 4) goto L27;
        r104 = new StringBuffer(r104).insert(0, "0").toString();
        goto L25
    L27:
        r102.append(r104);
        return (byte) CastIntegerProtector.parseInt(r102.toString(), 2);
    L9:
        if (r101 != 16) goto L11;
        r103 = "011";
        goto L22
    L11:
        if (r101 != 32) goto L13;
        r103 = "100";
        goto L22
    L13:
        if (r101 != 48) goto L15;
        r103 = "101";
        goto L22
    L15:
        if (r101 != 64) goto L23;
        r103 = BDLocationException.ERROR_TMAP_CLIENT;
        goto L22
    L5:
        r102.append("0");
        goto L7
    }

    private void intToBytes(int r100, byte[] r101, int r102) {
        r101[r102 + 3] = (byte) (r100 >> 24);
        r101[r102 + 2] = (byte) (r100 >> 16);
        r101[r102 + 1] = (byte) (r100 >> 8);
        r101[r102] = (byte) r100;
    }

    private void processAAD(byte[] r100, int r101, int r102, int r103) {
        if ((r102 - r101) < this.engine.getBlockSize()) goto L32;
        if ((r102 % this.engine.getBlockSize()) != 0) goto L30;
        byte[] r104 = this.nonce;
        System.arraycopy(r104, 0, this.G1, 0, (r104.length - this.Nb_) - 1);
        intToBytes(r103, this.buffer, 0);
        System.arraycopy(this.buffer, 0, this.G1, (this.nonce.length - this.Nb_) - 1, 4);
        byte[] r105 = this.G1;
        r105[r105.length - 1] = getFlag(true, this.macSize);
        this.engine.processBlock(this.G1, 0, this.macBlock, 0);
        intToBytes(r102, this.buffer, 0);
        if (r102 > (this.engine.getBlockSize() - this.Nb_)) goto L17;
        int r106 = 0;
    L9:
        if (r106 >= r102) goto L11;
        byte[] r107 = this.buffer;
        int r108 = this.Nb_ + r106;
        r107[r108] = (byte) (r107[r108] ^ r100[r101 + r106]);
        r106 = r106 + 1;
        goto L9
    L11:
        int r109 = 0;
    L13:
        if (r109 >= this.engine.getBlockSize()) goto L15;
        byte[] r110 = this.macBlock;
        r110[r109] = (byte) (r110[r109] ^ this.buffer[r109]);
        r109 = r109 + 1;
        goto L13
    L15:
        BlockCipher r111 = this.engine;
        byte[] r112 = this.macBlock;
        r111.processBlock(r112, 0, r112, 0);
        return;
    L17:
        int r113 = 0;
    L19:
        if (r113 >= this.engine.getBlockSize()) goto L21;
        byte[] r114 = this.macBlock;
        r114[r113] = (byte) (r114[r113] ^ this.buffer[r113]);
        r113 = r113 + 1;
        goto L19
    L21:
        BlockCipher r115 = this.engine;
        byte[] r116 = this.macBlock;
        r115.processBlock(r116, 0, r116, 0);
    L22:
        if (r102 == 0) goto L28;
        int r117 = 0;
    L25:
        if (r117 >= this.engine.getBlockSize()) goto L27;
        byte[] r118 = this.macBlock;
        r118[r117] = (byte) (r118[r117] ^ r100[r117 + r101]);
        r117 = r117 + 1;
        goto L25
    L27:
        BlockCipher r119 = this.engine;
        byte[] r120 = this.macBlock;
        r119.processBlock(r120, 0, r120, 0);
        r101 = r101 + this.engine.getBlockSize();
        r102 = r102 - this.engine.getBlockSize();
        goto L22
    L28:
        return;
    L30:
        throw new IllegalArgumentException("padding not supported");
    L32:
        throw new IllegalArgumentException("authText buffer too short");
    }

    private void setNb(int r100) {
        if (r100 != 4) goto L5;
    L11:
        this.Nb_ = r100;
        return;
    L5:
        if (r100 == 6) goto L11;
        if (r100 == 8) goto L11;
        throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] r100, int r101) throws IllegalStateException, InvalidCipherTextException {
        int r102 = processPacket(this.data.getBuffer(), 0, this.data.size(), r100, r101);
        reset();
        return r102;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        return Arrays.clone(this.f525272mac);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int r100) {
        return r100 + this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int r100) {
        return r100;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof AEADParameters) == false) goto L14;
        AEADParameters r102 = (AEADParameters) r101;
        if (r102.getMacSize() > 512) goto L12;
        if (r102.getMacSize() < 64) goto L12;
        if ((r102.getMacSize() % 8) != 0) goto L12;
        this.nonce = r102.getNonce();
        this.macSize = r102.getMacSize() / 8;
        this.initialAssociatedText = r102.getAssociatedText();
        CipherParameters r103 = r102.getKey();
    L16:
        this.f525272mac = new byte[this.macSize];
        this.forEncryption = r100;
        this.engine.init(true, r103);
        this.counter[0] = 1;
        byte[] r104 = this.initialAssociatedText;
        if (r104 == null) goto L22;
        processAADBytes(r104, 0, r104.length);
        return;
    L22:
        return;
    L12:
        throw new IllegalArgumentException("Invalid mac size specified");
    L14:
        if ((r101 instanceof ParametersWithIV) == false) goto L21;
        ParametersWithIV r105 = (ParametersWithIV) r101;
        this.nonce = r105.getIV();
        this.macSize = this.engine.getBlockSize();
        this.initialAssociatedText = null;
        r103 = r105.getParameters();
        goto L16
    L21:
        throw new IllegalArgumentException("Invalid parameters specified");
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

    public int processPacket(byte[] r110, int r111, int r112, byte[] r113, int r114) throws IllegalStateException, InvalidCipherTextException {
        if ((r110.length - r111) < r112) goto L61;
        if ((r113.length - r114) < r112) goto L59;
        if (this.associatedText.size() <= 0) goto L13;
        if (this.forEncryption == false) goto L11;
        processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size());
        goto L13
    L11:
        processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size(), this.data.size() - this.macSize);
    L13:
        if (this.forEncryption == false) goto L32;
        if ((r112 % this.engine.getBlockSize()) != 0) goto L30;
        CalculateMac(r110, r111, r112);
        this.engine.processBlock(this.nonce, 0, this.f525273s, 0);
        int r100 = r112;
    L17:
        if (r100 <= 0) goto L19;
        ProcessBlock(r110, r111, r112, r113, r114);
        r100 = r100 - this.engine.getBlockSize();
        r111 = r111 + this.engine.getBlockSize();
        r114 = r114 + this.engine.getBlockSize();
        goto L17
    L19:
        int r115 = 0;
    L20:
        byte[] r116 = this.counter;
        if (r115 >= r116.length) goto L23;
        byte[] r101 = this.f525273s;
        r101[r115] = (byte) (r101[r115] + r116[r115]);
        r115 = r115 + 1;
        goto L20
    L23:
        this.engine.processBlock(this.f525273s, 0, this.buffer, 0);
        int r117 = 0;
    L24:
        int r118 = this.macSize;
        if (r117 >= r118) goto L27;
        r113[r114 + r117] = (byte) (this.buffer[r117] ^ this.macBlock[r117]);
        r117 = r117 + 1;
        goto L24
    L27:
        System.arraycopy(this.macBlock, 0, this.f525272mac, 0, r118);
        reset();
        return r112 + this.macSize;
    L30:
        throw new DataLengthException("partial blocks not supported");
    L32:
        if (((r112 - this.macSize) % this.engine.getBlockSize()) != 0) goto L57;
        this.engine.processBlock(this.nonce, 0, this.f525273s, 0);
        int r102 = r112 / this.engine.getBlockSize();
        int r103 = 0;
    L34:
        if (r103 >= r102) goto L36;
        ProcessBlock(r110, r111, r112, r113, r114);
        r111 = r111 + this.engine.getBlockSize();
        r114 = r114 + this.engine.getBlockSize();
        r103 = r103 + 1;
        goto L34
    L36:
        if (r112 <= r111) goto L46;
        int r104 = 0;
    L38:
        byte[] r105 = this.counter;
        if (r104 >= r105.length) goto L41;
        byte[] r106 = this.f525273s;
        r106[r104] = (byte) (r106[r104] + r105[r104]);
        r104 = r104 + 1;
        goto L38
    L41:
        this.engine.processBlock(this.f525273s, 0, this.buffer, 0);
        int r107 = 0;
    L42:
        int r108 = this.macSize;
        if (r107 >= r108) goto L45;
        r113[r114 + r107] = (byte) (this.buffer[r107] ^ r110[r111 + r107]);
        r107 = r107 + 1;
        goto L42
    L45:
        r114 = r114 + r108;
    L46:
        int r119 = 0;
    L47:
        byte[] r120 = this.counter;
        if (r119 >= r120.length) goto L50;
        byte[] r109 = this.f525273s;
        r109[r119] = (byte) (r109[r119] + r120[r119]);
        r119 = r119 + 1;
        goto L47
    L50:
        this.engine.processBlock(this.f525273s, 0, this.buffer, 0);
        int r121 = this.macSize;
        System.arraycopy(r113, r114 - r121, this.buffer, 0, r121);
        CalculateMac(r113, 0, r114 - this.macSize);
        System.arraycopy(this.macBlock, 0, this.f525272mac, 0, this.macSize);
        int r122 = this.macSize;
        byte[] r123 = new byte[r122];
        System.arraycopy(this.buffer, 0, r123, 0, r122);
        if (Arrays.constantTimeAreEqual(this.f525272mac, r123) == false) goto L55;
        reset();
        return r112 - this.macSize;
    L55:
        throw new InvalidCipherTextException("mac check failed");
    L57:
        throw new DataLengthException("partial blocks not supported");
    L59:
        throw new OutputLengthException("output buffer too short");
    L61:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        Arrays.fill(this.G1, (byte) 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.counter, (byte) 0);
        Arrays.fill(this.macBlock, (byte) 0);
        this.counter[0] = 1;
        this.data.reset();
        this.associatedText.reset();
        byte[] r100 = this.initialAssociatedText;
        if (r100 == null) goto L6;
        processAADBytes(r100, 0, r100.length);
        return;
    }
}
