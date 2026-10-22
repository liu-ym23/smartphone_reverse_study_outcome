package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class CryptoProWrapEngine extends GOST28147WrapEngine {
    public CryptoProWrapEngine() {
    }

    private static boolean bitSet(byte r100, int r101) {
        if ((r100 & (1 << r101)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static byte[] cryptoProDiversify(byte[] r100, byte[] r101, byte[] r110) {
        int r102 = 0;
    L4:
        if (r102 == 8) goto L13;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r103 == 8) goto L12;
        int r106 = Pack.littleEndianToInt(r100, r103 * 4);
        if (bitSet(r101[r102], r103) == false) goto L10;
        r104 = r104 + r106;
    L11:
        r103 = r103 + 1;
        goto L6
    L10:
        r105 = r105 + r106;
        goto L11
    L12:
        byte[] r107 = new byte[8];
        Pack.intToLittleEndian(r104, r107, 0);
        Pack.intToLittleEndian(r105, r107, 4);
        GCFBBlockCipher r108 = new GCFBBlockCipher(new GOST28147Engine());
        r108.init(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(r100), r110), r107));
        r108.processBlock(r100, 0, r100, 0);
        r108.processBlock(r100, 8, r100, 8);
        r108.processBlock(r100, 16, r100, 16);
        r108.processBlock(r100, 24, r100, 24);
        r102 = r102 + 1;
        goto L4
    L13:
        return r100;
    }

    @Override // org.bouncycastle.crypto.engines.GOST28147WrapEngine, org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L5:
        ParametersWithUKM r102 = (ParametersWithUKM) r101;
        if ((r102.getParameters() instanceof ParametersWithSBox) == false) goto L8;
        KeyParameter r103 = (KeyParameter) ((ParametersWithSBox) r102.getParameters()).getParameters();
        byte[] r104 = ((ParametersWithSBox) r102.getParameters()).getSBox();
    L9:
        KeyParameter r105 = new KeyParameter(cryptoProDiversify(r103.getKey(), r102.getUKM(), r104));
        if (r104 == null) goto L12;
        ParametersWithUKM r106 = new ParametersWithUKM(new ParametersWithSBox(r105, r104), r102.getUKM());
    L13:
        super.init(r100, r106);
        return;
    L12:
        r106 = new ParametersWithUKM(r105, r102.getUKM());
        goto L13
    L8:
        r103 = (KeyParameter) r102.getParameters();
        r104 = null;
        goto L9
    }
}
