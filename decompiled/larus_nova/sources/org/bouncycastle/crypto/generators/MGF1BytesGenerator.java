package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.MGFParameters;

/* JADX INFO: loaded from: classes42.dex */
public class MGF1BytesGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] seed;

    public MGF1BytesGenerator(Digest r100) {
        this.digest = r100;
        this.hLen = r100.getDigestSize();
    }

    private void ItoOSP(int r100, byte[] r101) {
        r101[0] = (byte) (r100 >>> 24);
        r101[1] = (byte) (r100 >>> 16);
        r101[2] = (byte) (r100 >>> 8);
        r101[3] = (byte) (r100 >>> 0);
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r110, int r111) throws DataLengthException, IllegalArgumentException {
        if ((r100.length - r111) < r110) goto L16;
        byte[] r101 = new byte[this.hLen];
        byte[] r102 = new byte[4];
        this.digest.reset();
        if (r111 <= this.hLen) goto L10;
        int r103 = 0;
    L7:
        ItoOSP(r103, r102);
        Digest r104 = this.digest;
        byte[] r105 = this.seed;
        r104.update(r105, 0, r105.length);
        this.digest.update(r102, 0, 4);
        this.digest.doFinal(r101, 0);
        int r106 = this.hLen;
        System.arraycopy(r101, 0, r100, (r103 * r106) + r110, r106);
        r103 = r103 + 1;
        if (r103 < (r111 / this.hLen)) goto L7;
    L12:
        if ((this.hLen * r103) >= r111) goto L14;
        ItoOSP(r103, r102);
        Digest r107 = this.digest;
        byte[] r108 = this.seed;
        r107.update(r108, 0, r108.length);
        this.digest.update(r102, 0, 4);
        this.digest.doFinal(r101, 0);
        int r109 = this.hLen;
        System.arraycopy(r101, 0, r100, r110 + (r103 * r109), r111 - (r103 * r109));
    L14:
        return r111;
    L10:
        r103 = 0;
        goto L12
    L16:
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        if ((r100 instanceof MGFParameters) == false) goto L7;
        this.seed = ((MGFParameters) r100).getSeed();
        return;
    L7:
        throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
    }
}
