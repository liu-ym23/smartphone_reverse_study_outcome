package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RFC3394WrapEngine implements Wrapper {
    private BlockCipher engine;
    private boolean forWrapping;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525199iv;
    private KeyParameter param;
    private boolean wrapCipherMode;

    public RFC3394WrapEngine(BlockCipher r100) {
        this(r100, false);
    }

    public RFC3394WrapEngine(BlockCipher r100, boolean r101) {
        this.f525199iv = new byte[]{-90, -90, -90, -90, -90, -90, -90, -90};
        this.engine = r100;
        this.wrapCipherMode = !r101;
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
        return;
    L9:
        if ((r101 instanceof ParametersWithIV) == false) goto L16;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        this.f525199iv = r102.getIV();
        this.param = (KeyParameter) r102.getParameters();
        if (this.f525199iv.length != 8) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("IV not equal to 8");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L23;
        int r100 = r112 / 8;
        if ((r100 * 8) != r112) goto L21;
        byte[] r101 = this.f525199iv;
        byte[] r102 = new byte[r112 - r101.length];
        byte[] r103 = new byte[r101.length];
        byte[] r104 = new byte[r101.length + 8];
        System.arraycopy(r110, r111, r103, 0, r101.length);
        byte[] r105 = this.f525199iv;
        System.arraycopy(r110, r111 + r105.length, r102, 0, r112 - r105.length);
        this.engine.init(!this.wrapCipherMode, this.param);
        int r106 = r100 - 1;
        int r113 = 5;
    L7:
        if (r113 < 0) goto L16;
        int r114 = r106;
    L9:
        if (r114 < 1) goto L14;
        System.arraycopy(r103, 0, r104, 0, this.f525199iv.length);
        int r107 = (r114 - 1) * 8;
        System.arraycopy(r102, r107, r104, this.f525199iv.length, 8);
        int r108 = (r106 * r113) + r114;
        int r109 = 1;
    L11:
        if (r108 == 0) goto L13;
        int r115 = this.f525199iv.length - r109;
        r104[r115] = (byte) (((byte) r108) ^ r104[r115]);
        r108 = r108 >>> 8;
        r109 = r109 + 1;
        goto L11
    L13:
        this.engine.processBlock(r104, 0, r104, 0);
        System.arraycopy(r104, 0, r103, 0, 8);
        System.arraycopy(r104, 8, r102, r107, 8);
        r114 = r114 - 1;
        goto L9
    L14:
        r113 = r113 - 1;
        goto L7
    L16:
        if (Arrays.constantTimeAreEqual(r103, this.f525199iv) == false) goto L19;
        return r102;
    L19:
        throw new InvalidCipherTextException("checksum failed");
    L21:
        throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
    L23:
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r110, int r111, int r112) {
        if (this.forWrapping == false) goto L20;
        int r100 = r112 / 8;
        if ((r100 * 8) != r112) goto L18;
        byte[] r101 = this.f525199iv;
        byte[] r102 = new byte[r101.length + r112];
        byte[] r103 = new byte[r101.length + 8];
        System.arraycopy(r101, 0, r102, 0, r101.length);
        System.arraycopy(r110, r111, r102, this.f525199iv.length, r112);
        this.engine.init(this.wrapCipherMode, this.param);
        int r113 = 0;
    L8:
        if (r113 == 6) goto L16;
        int r114 = 1;
    L10:
        if (r114 > r100) goto L15;
        System.arraycopy(r102, 0, r103, 0, this.f525199iv.length);
        int r104 = r114 * 8;
        System.arraycopy(r102, r104, r103, this.f525199iv.length, 8);
        this.engine.processBlock(r103, 0, r103, 0);
        int r105 = (r100 * r113) + r114;
        int r106 = 1;
    L12:
        if (r105 == 0) goto L14;
        int r107 = this.f525199iv.length - r106;
        r103[r107] = (byte) (((byte) r105) ^ r103[r107]);
        r105 = r105 >>> 8;
        r106 = r106 + 1;
        goto L12
    L14:
        System.arraycopy(r103, 0, r102, 0, 8);
        System.arraycopy(r103, 8, r102, r104, 8);
        r114 = r114 + 1;
        goto L10
    L15:
        r113 = r113 + 1;
        goto L8
    L16:
        return r102;
    L18:
        throw new DataLengthException("wrap data must be a multiple of 8 bytes");
    L20:
        throw new IllegalStateException("not set for wrapping");
    }
}
