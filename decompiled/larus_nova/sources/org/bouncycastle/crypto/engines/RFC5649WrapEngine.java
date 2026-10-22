package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class RFC5649WrapEngine implements Wrapper {
    private BlockCipher engine;
    private byte[] extractedAIV;
    private boolean forWrapping;
    private byte[] highOrderIV;
    private KeyParameter param;
    private byte[] preIV;

    public RFC5649WrapEngine(BlockCipher r100) {
        byte[] r101 = {-90, 89, 89, -90};
        this.highOrderIV = r101;
        this.preIV = r101;
        this.extractedAIV = null;
        this.engine = r100;
    }

    private byte[] padPlaintext(byte[] r100) {
        int r101 = r100.length;
        int r102 = (8 - (r101 % 8)) % 8;
        byte[] r103 = new byte[r101 + r102];
        System.arraycopy(r100, 0, r103, 0, r101);
        if (r102 == 0) goto L5;
        System.arraycopy(new byte[r102], 0, r103, r101, r102);
    L5:
        return r103;
    }

    private byte[] rfc3394UnwrapNoIvCheck(byte[] r110, int r111, int r112) {
        int r100 = r112 - 8;
        byte[] r101 = new byte[r100];
        byte[] r102 = new byte[8];
        byte[] r103 = new byte[16];
        System.arraycopy(r110, r111, r102, 0, 8);
        System.arraycopy(r110, r111 + 8, r101, 0, r100);
        this.engine.init(false, this.param);
        int r113 = (r112 / 8) - 1;
        int r114 = 5;
    L3:
        if (r114 < 0) goto L11;
        int r104 = r113;
    L5:
        if (r104 < 1) goto L10;
        System.arraycopy(r102, 0, r103, 0, 8);
        int r105 = (r104 - 1) * 8;
        System.arraycopy(r101, r105, r103, 8, 8);
        int r106 = (r113 * r114) + r104;
        int r107 = 1;
    L7:
        if (r106 == 0) goto L9;
        int r115 = 8 - r107;
        r103[r115] = (byte) (((byte) r106) ^ r103[r115]);
        r106 = r106 >>> 8;
        r107 = r107 + 1;
        goto L7
    L9:
        this.engine.processBlock(r103, 0, r103, 0);
        System.arraycopy(r103, 0, r102, 0, 8);
        System.arraycopy(r103, 8, r101, r105, 8);
        r104 = r104 - 1;
        goto L5
    L10:
        r114 = r114 - 1;
        goto L3
    L11:
        this.extractedAIV = r102;
        return r101;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        this.forWrapping = r100;
        if ((r101 instanceof ParametersWithRandom) == false) goto L6;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L6:
        if ((r101 instanceof KeyParameter) == false) goto L9;
        this.param = (KeyParameter) r101;
        this.preIV = this.highOrderIV;
        return;
    L9:
        if ((r101 instanceof ParametersWithIV) == false) goto L16;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        this.preIV = r102.getIV();
        this.param = (KeyParameter) r102.getParameters();
        if (this.preIV.length != 4) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("IV length not equal to 4");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L39;
        int r103 = r102 / 8;
        if ((r103 * 8) != r102) goto L37;
        if (r103 <= 1) goto L35;
        byte[] r104 = new byte[r102];
        System.arraycopy(r100, r101, r104, 0, r102);
        byte[] r105 = new byte[r102];
        if (r103 != 2) goto L14;
        this.engine.init(false, this.param);
        int r106 = 0;
    L11:
        if (r106 >= r102) goto L13;
        this.engine.processBlock(r104, r106, r105, r106);
        r106 = r106 + this.engine.getBlockSize();
        goto L11
    L13:
        byte[] r107 = new byte[8];
        this.extractedAIV = r107;
        System.arraycopy(r105, 0, r107, 0, r107.length);
        byte[] r108 = this.extractedAIV;
        int r109 = r102 - r108.length;
        byte[] r110 = new byte[r109];
        System.arraycopy(r105, r108.length, r110, 0, r109);
    L15:
        int r111 = 4;
        byte[] r112 = new byte[4];
        byte[] r113 = new byte[4];
        System.arraycopy(this.extractedAIV, 0, r112, 0, 4);
        System.arraycopy(this.extractedAIV, 4, r113, 0, 4);
        int r114 = Pack.bigEndianToInt(r113, 0);
        boolean r115 = Arrays.constantTimeAreEqual(r112, this.preIV);
        int r116 = r110.length;
        if (r114 > (r116 - 8)) goto L18;
        r115 = false;
    L18:
        if (r114 <= r116) goto L20;
        r115 = false;
    L20:
        int r117 = r116 - r114;
        if (r117 >= 8) goto L25;
        if (r117 < 0) goto L25;
        r111 = r117;
    L26:
        byte[] r118 = new byte[r111];
        System.arraycopy(r110, r110.length - r111, r118, 0, r111);
        if (Arrays.constantTimeAreEqual(r118, new byte[r111]) == true) goto L29;
        r115 = false;
    L29:
        if (r115 == false) goto L33;
        byte[] r119 = new byte[r114];
        System.arraycopy(r110, 0, r119, 0, r114);
        return r119;
    L33:
        throw new InvalidCipherTextException("checksum failed");
    L25:
        r115 = false;
        goto L26
    L14:
        r110 = rfc3394UnwrapNoIvCheck(r100, r101, r102);
        goto L15
    L35:
        throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
    L37:
        throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
    L39:
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r101, int r102) {
        if (this.forWrapping == false) goto L13;
        byte[] r103 = new byte[8];
        byte[] r104 = Pack.intToBigEndian(r102);
        byte[] r105 = this.preIV;
        int r106 = 0;
        System.arraycopy(r105, 0, r103, 0, r105.length);
        System.arraycopy(r104, 0, r103, this.preIV.length, r104.length);
        byte[] r107 = new byte[r102];
        System.arraycopy(r100, r101, r107, 0, r102);
        byte[] r108 = padPlaintext(r107);
        if (r108.length != 8) goto L10;
        int r109 = r108.length + 8;
        byte[] r110 = new byte[r109];
        System.arraycopy(r103, 0, r110, 0, 8);
        System.arraycopy(r108, 0, r110, 8, r108.length);
        this.engine.init(true, this.param);
    L7:
        if (r106 >= r109) goto L9;
        this.engine.processBlock(r110, r106, r110, r106);
        r106 = r106 + this.engine.getBlockSize();
        goto L7
    L9:
        return r110;
    L10:
        RFC3394WrapEngine r111 = new RFC3394WrapEngine(this.engine);
        r111.init(true, new ParametersWithIV(this.param, r103));
        return r111.wrap(r108, 0, r108.length);
    L13:
        throw new IllegalStateException("not set for wrapping");
    }
}
