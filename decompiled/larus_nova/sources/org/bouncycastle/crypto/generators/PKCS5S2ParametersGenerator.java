package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    private Mac hMac;
    private byte[] state;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public PKCS5S2ParametersGenerator(Digest r100) {
        HMac r101 = new HMac(r100);
        this.hMac = r101;
        this.state = new byte[r101.getMacSize()];
    }

    private void F(byte[] r100, int r101, byte[] r102, byte[] r103, int r104) {
        if (r101 == 0) goto L15;
        if (r100 == null) goto L6;
        this.hMac.update(r100, 0, r100.length);
    L6:
        this.hMac.update(r102, 0, r102.length);
        this.hMac.doFinal(this.state, 0);
        byte[] r105 = this.state;
        System.arraycopy(r105, 0, r103, r104, r105.length);
        int r106 = 1;
    L7:
        if (r106 >= r101) goto L13;
        Mac r107 = this.hMac;
        byte[] r108 = this.state;
        r107.update(r108, 0, r108.length);
        this.hMac.doFinal(this.state, 0);
        int r109 = 0;
    L9:
        byte[] r110 = this.state;
        if (r109 == r110.length) goto L12;
        int r111 = r104 + r109;
        byte r112 = r103[r111];
        r103[r111] = (byte) (r110[r109] ^ r112);
        r109 = r109 + 1;
        goto L9
    L12:
        r106 = r106 + 1;
        goto L7
    L13:
        return;
    L15:
        throw new IllegalArgumentException("iteration count must be at least 1.");
    }

    private byte[] generateDerivedKey(int r110) {
        int r100 = this.hMac.getMacSize();
        int r111 = ((r110 + r100) - 1) / r100;
        byte[] r101 = new byte[4];
        byte[] r102 = new byte[r111 * r100];
        this.hMac.init(new KeyParameter(this.password));
        int r112 = 0;
        int r113 = 1;
    L3:
        if (r113 > r111) goto L9;
        int r103 = 3;
    L5:
        byte r104 = (byte) (r101[r103] + 1);
        r101[r103] = r104;
        if (r104 != 0) goto L8;
        r103 = r103 - 1;
        goto L5
    L8:
        F(this.salt, this.iterationCount, r101, r102, r112);
        r112 = r112 + r100;
        r113 = r113 + 1;
        goto L3
    L9:
        return r102;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int r100) {
        return generateDerivedParameters(r100);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100) {
        int r101 = r100 / 8;
        return new KeyParameter(generateDerivedKey(r101), 0, r101);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int r100, int r101) {
        int r102 = r100 / 8;
        int r103 = r101 / 8;
        byte[] r104 = generateDerivedKey(r102 + r103);
        return new ParametersWithIV(new KeyParameter(r104, 0, r102), r104, r102, r103);
    }
}
