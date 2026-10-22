package org.bouncycastle.jce.provider;

import com.larus.dora.impl.ota.g2.j0;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KDFParameters;

/* JADX INFO: loaded from: classes42.dex */
public class BrokenKDF2BytesGenerator implements DerivationFunction {
    private Digest digest;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525390iv;
    private byte[] shared;

    public BrokenKDF2BytesGenerator(Digest r100) {
        this.digest = r100;
    }

    @Override // org.bouncycastle.crypto.DerivationFunction
    public int generateBytes(byte[] r100, int r110, int r111) throws DataLengthException, IllegalArgumentException {
        if ((r100.length - r111) < r110) goto L18;
        long r101 = ((long) r111) * 8;
        if (r101 > ((((long) this.digest.getDigestSize()) * 8) * j0.G2_OTA_SPACE_RESERVE_BYTES)) goto L16;
        int r102 = (int) (r101 / ((long) this.digest.getDigestSize()));
        int r103 = this.digest.getDigestSize();
        byte[] r104 = new byte[r103];
        int r105 = 1;
    L7:
        if (r105 > r102) goto L13;
        Digest r106 = this.digest;
        byte[] r107 = this.shared;
        r106.update(r107, 0, r107.length);
        this.digest.update((byte) (r105 & 255));
        this.digest.update((byte) ((r105 >> 8) & 255));
        this.digest.update((byte) ((r105 >> 16) & 255));
        this.digest.update((byte) ((r105 >> 24) & 255));
        Digest r108 = this.digest;
        byte[] r109 = this.f525390iv;
        r108.update(r109, 0, r109.length);
        this.digest.doFinal(r104, 0);
        int r112 = r111 - r110;
        if (r112 <= r103) goto L11;
        System.arraycopy(r104, 0, r100, r110, r103);
        r110 = r110 + r103;
    L12:
        r105 = r105 + 1;
        goto L7
    L11:
        System.arraycopy(r104, 0, r100, r110, r112);
        goto L12
    L13:
        this.digest.reset();
        return r111;
    L16:
        throw new IllegalArgumentException("Output length too large");
    L18:
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
        this.f525390iv = r101.getIV();
        return;
    L7:
        throw new IllegalArgumentException("KDF parameters required for generator");
    }
}
