package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ConcatenationKDFGenerator implements DerivationFunction {
    private Digest digest;
    private int hLen;
    private byte[] otherInfo;
    private byte[] shared;

    public ConcatenationKDFGenerator(Digest r100) {
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
    public int generateBytes(byte[] r110, int r111, int r112) throws DataLengthException, IllegalArgumentException {
        if ((r110.length - r112) < r111) goto L16;
        byte[] r100 = new byte[this.hLen];
        byte[] r101 = new byte[4];
        this.digest.reset();
        int r102 = 1;
        if (r112 <= this.hLen) goto L11;
        int r103 = 0;
    L7:
        ItoOSP(r102, r101);
        this.digest.update(r101, 0, 4);
        Digest r104 = this.digest;
        byte[] r105 = this.shared;
        r104.update(r105, 0, r105.length);
        Digest r106 = this.digest;
        byte[] r107 = this.otherInfo;
        r106.update(r107, 0, r107.length);
        this.digest.doFinal(r100, 0);
        System.arraycopy(r100, 0, r110, r111 + r103, this.hLen);
        int r108 = this.hLen;
        r103 = r103 + r108;
        int r109 = r102 + 1;
        if (r102 >= (r112 / r108)) goto L9;
        r102 = r109;
        goto L7
    L9:
        r102 = r109;
    L12:
        if (r103 >= r112) goto L14;
        ItoOSP(r102, r101);
        this.digest.update(r101, 0, 4);
        Digest r113 = this.digest;
        byte[] r114 = this.shared;
        r113.update(r114, 0, r114.length);
        Digest r115 = this.digest;
        byte[] r116 = this.otherInfo;
        r115.update(r116, 0, r116.length);
        this.digest.doFinal(r100, 0);
        System.arraycopy(r100, 0, r110, r111 + r103, r112 - r103);
    L14:
        return r112;
    L11:
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
        if ((r100 instanceof KDFParameters) == false) goto L7;
        KDFParameters r101 = (KDFParameters) r100;
        this.shared = r101.getSharedSecret();
        this.otherInfo = r101.getIV();
        return;
    L7:
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
