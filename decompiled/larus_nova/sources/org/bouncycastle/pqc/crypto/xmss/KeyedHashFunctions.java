package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes42.dex */
final class KeyedHashFunctions {
    private final Digest digest;
    private final int digestSize;

    public KeyedHashFunctions(ASN1ObjectIdentifier r100, int r101) {
        if (r100 == null) goto L7;
        this.digest = DigestUtil.getDigest(r100);
        this.digestSize = r101;
        return;
    L7:
        throw new NullPointerException("digest == null");
    }

    private byte[] coreDigest(int r100, byte[] r101, byte[] r102) {
        byte[] r103 = XMSSUtil.toBytesBigEndian(r100, this.digestSize);
        this.digest.update(r103, 0, r103.length);
        this.digest.update(r101, 0, r101.length);
        this.digest.update(r102, 0, r102.length);
        int r104 = this.digestSize;
        byte[] r105 = new byte[r104];
        Digest r106 = this.digest;
        if ((r106 instanceof Xof) == false) goto L5;
        ((Xof) r106).doFinal(r105, 0, r104);
    L6:
        return r105;
    L5:
        r106.doFinal(r105, 0);
        goto L6
    }

    public byte[] F(byte[] r100, byte[] r101) {
        int r102 = r100.length;
        int r103 = this.digestSize;
        if (r102 != r103) goto L11;
        if (r101.length != r103) goto L9;
        return coreDigest(0, r100, r101);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] H(byte[] r100, byte[] r101) {
        int r102 = r100.length;
        int r103 = this.digestSize;
        if (r102 != r103) goto L11;
        if (r101.length != (r103 * 2)) goto L9;
        return coreDigest(1, r100, r101);
    L9:
        throw new IllegalArgumentException("wrong in length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] HMsg(byte[] r100, byte[] r101) {
        if (r100.length != (this.digestSize * 3)) goto L7;
        return coreDigest(2, r100, r101);
    L7:
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] PRF(byte[] r100, byte[] r101) {
        if (r100.length != this.digestSize) goto L11;
        if (r101.length != 32) goto L9;
        return coreDigest(3, r100, r101);
    L9:
        throw new IllegalArgumentException("wrong address length");
    L11:
        throw new IllegalArgumentException("wrong key length");
    }
}
