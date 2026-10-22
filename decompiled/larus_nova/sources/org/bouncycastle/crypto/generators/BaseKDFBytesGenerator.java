package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525210iv;
    private byte[] shared;

    public BaseKDFBytesGenerator(int r100, Digest r101) {
        this.counterStart = r100;
        this.digest = r101;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r110, int r111, int r112) throws DataLengthException, IllegalArgumentException {
        int r100 = r112;
        int r101 = r111;
        if ((r110.length - r100) < r101) goto L24;
        long r102 = r100;
        int r103 = this.digest.getDigestSize();
        if (r102 > 8589934591L) goto L22;
        long r104 = r103;
        int r105 = (int) (((r102 + r104) - 1) / r104);
        byte[] r106 = new byte[this.digest.getDigestSize()];
        byte[] r113 = new byte[4];
        Pack.intToBigEndian(this.counterStart, r113, 0);
        int r114 = this.counterStart & (-256);
        int r115 = 0;
    L7:
        if (r115 >= r105) goto L19;
        Digest r116 = this.digest;
        byte[] r117 = this.shared;
        r116.update(r117, 0, r117.length);
        this.digest.update(r113, 0, 4);
        byte[] r107 = this.f525210iv;
        if (r107 == null) goto L11;
        this.digest.update(r107, 0, r107.length);
    L11:
        this.digest.doFinal(r106, 0);
        if (r100 <= r103) goto L14;
        System.arraycopy(r106, 0, r110, r101, r103);
        r101 = r101 + r103;
        r100 = r100 - r103;
    L15:
        byte r118 = (byte) (r113[3] + 1);
        r113[3] = r118;
        if (r118 != 0) goto L18;
        r114 = r114 + 256;
        Pack.intToBigEndian(r114, r113, 0);
    L18:
        r115 = r115 + 1;
        goto L7
    L14:
        System.arraycopy(r106, 0, r110, r101, r100);
        goto L15
    L19:
        this.digest.reset();
        return (int) r102;
    L22:
        throw new IllegalArgumentException("Output length too large");
    L24:
        throw new OutputLengthException("output buffer too small");
    }

    @Override // org.bouncycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        if ((r100 instanceof KDFParameters) == false) goto L6;
        KDFParameters r101 = (KDFParameters) r100;
        this.shared = r101.getSharedSecret();
        this.f525210iv = r101.getIV();
        return;
    L6:
        if ((r100 instanceof ISO18033KDFParameters) == false) goto L10;
        this.shared = ((ISO18033KDFParameters) r100).getSeed();
        this.f525210iv = null;
        return;
    L10:
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
