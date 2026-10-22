package org.bouncycastle.crypto.engines;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RFC3211WrapEngine implements Wrapper {
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private ParametersWithIV param;
    private SecureRandom rand;

    public RFC3211WrapEngine(BlockCipher r100) {
        this.engine = new CBCBlockCipher(r100);
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        this.forWrapping = r100;
        if ((r101 instanceof ParametersWithRandom) == false) goto L9;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.rand = r102.getRandom();
        if ((r102.getParameters() instanceof ParametersWithIV) == false) goto L8;
        this.param = (ParametersWithIV) r102.getParameters();
        return;
    L8:
        throw new IllegalArgumentException("RFC3211Wrap requires an IV");
    L9:
        if (r100 == false) goto L12;
        this.rand = CryptoServicesRegistrar.getSecureRandom();
    L12:
        if ((r101 instanceof ParametersWithIV) == false) goto L16;
        this.param = (ParametersWithIV) r101;
        return;
    L16:
        throw new IllegalArgumentException("RFC3211Wrap requires an IV");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L34;
        int r103 = this.engine.getBlockSize();
        if (r102 < (r103 * 2)) goto L32;
        byte[] r104 = new byte[r102];
        byte[] r105 = new byte[r103];
        boolean r106 = false;
        System.arraycopy(r100, r101, r104, 0, r102);
        System.arraycopy(r100, r101, r105, 0, r103);
        this.engine.init(false, new ParametersWithIV(this.param.getParameters(), r105));
        int r107 = r103;
    L7:
        if (r107 >= r102) goto L9;
        this.engine.processBlock(r104, r107, r104, r107);
        r107 = r107 + r103;
        goto L7
    L9:
        System.arraycopy(r104, r102 - r103, r105, 0, r103);
        this.engine.init(false, new ParametersWithIV(this.param.getParameters(), r105));
        this.engine.processBlock(r104, 0, r104, 0);
        this.engine.init(false, this.param);
        int r108 = 0;
    L10:
        if (r108 >= r102) goto L12;
        this.engine.processBlock(r104, r108, r104, r108);
        r108 = r108 + r103;
        goto L10
    L12:
        int r109 = r104[0];
        int r110 = r102 - 4;
        if ((r109 & 255) <= r110) goto L15;
        boolean r111 = true;
    L16:
        if (r111 == false) goto L18;
        byte[] r112 = new byte[r110];
    L19:
        System.arraycopy(r104, 4, r112, 0, r112.length);
        int r113 = 0;
        int r114 = 0;
    L21:
        if (r113 == 3) goto L23;
        int r115 = r113 + 1;
        byte r116 = (byte) (~r104[r115]);
        r114 = r114 | (r104[r113 + 4] ^ r116);
        r113 = r115;
        goto L21
    L23:
        Arrays.clear(r104);
        if (r114 == 0) goto L27;
        r106 = true;
    L27:
        if ((r111 | r106) == true) goto L30;
        return r112;
    L30:
        throw new InvalidCipherTextException("wrapped key corrupted");
    L18:
        r112 = new byte[r109 & 255];
        goto L19
    L15:
        r111 = false;
        goto L16
    L32:
        throw new InvalidCipherTextException("input too short");
    L34:
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r101, int r102) {
        if (this.forWrapping == false) goto L25;
        if (r102 > 255) goto L23;
        if (r102 < 0) goto L23;
        this.engine.init(true, this.param);
        int r103 = this.engine.getBlockSize();
        int r104 = r102 + 4;
        int r105 = r103 * 2;
        if (r104 >= r105) goto L11;
    L9:
        byte[] r106 = new byte[r105];
        int r107 = 0;
        r106[0] = (byte) r102;
        System.arraycopy(r100, r101, r106, 4, r102);
        int r108 = r106.length - r104;
        byte[] r109 = new byte[r108];
        this.rand.nextBytes(r109);
        System.arraycopy(r109, 0, r106, r104, r108);
        r106[1] = (byte) (~r106[4]);
        r106[2] = (byte) (~r106[5]);
        r106[3] = (byte) (~r106[6]);
        int r110 = 0;
    L16:
        if (r110 >= r106.length) goto L19;
        this.engine.processBlock(r106, r110, r106, r110);
        r110 = r110 + r103;
    L19:
        if (r107 >= r106.length) goto L21;
        this.engine.processBlock(r106, r107, r106, r107);
        r107 = r107 + r103;
        goto L19
    L21:
        return r106;
    L11:
        if ((r104 % r103) != 0) goto L13;
        r105 = r104;
        goto L9
    L13:
        r105 = ((r104 / r103) + 1) * r103;
    L23:
        throw new IllegalArgumentException("input must be from 0 to 255 bytes");
    L25:
        throw new IllegalStateException("not set for wrapping");
    }
}
