package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class GSKKFDGenerator implements DigestDerivationFunction {
    private byte[] buf;
    private int counter;
    private final Digest digest;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private byte[] f525122r;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f525123z;

    public GSKKFDGenerator(Digest r100) {
        this.digest = r100;
        this.buf = new byte[r100.getDigestSize()];
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException {
        if ((r101 + r102) > r100.length) goto L10;
        Digest r103 = this.digest;
        byte[] r104 = this.f525123z;
        r103.update(r104, 0, r104.length);
        int r105 = this.counter;
        this.counter = r105 + 1;
        byte[] r106 = Pack.intToBigEndian(r105);
        this.digest.update(r106, 0, r106.length);
        byte[] r107 = this.f525122r;
        if (r107 == null) goto L7;
        this.digest.update(r107, 0, r107.length);
    L7:
        this.digest.doFinal(this.buf, 0);
        System.arraycopy(this.buf, 0, r100, r101, r102);
        Arrays.clear(this.buf);
        return r102;
    L10:
        throw new DataLengthException("output buffer too small");
    }

    @Override // org.bouncycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public void init(DerivationParameters r100) {
        if ((r100 instanceof GSKKDFParameters) == false) goto L7;
        GSKKDFParameters r101 = (GSKKDFParameters) r100;
        this.f525123z = r101.getZ();
        this.counter = r101.getStartCounter();
        this.f525122r = r101.getNonce();
        return;
    L7:
        throw new IllegalArgumentException("unkown parameters type");
    }
}
