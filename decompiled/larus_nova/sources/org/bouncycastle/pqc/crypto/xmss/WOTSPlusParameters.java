package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
final class WOTSPlusParameters {
    private final int digestSize;
    private final int len;
    private final int len1;
    private final int len2;
    private final XMSSOid oid;
    private final ASN1ObjectIdentifier treeDigest;
    private final int winternitzParameter;

    public WOTSPlusParameters(ASN1ObjectIdentifier r100) {
        if (r100 == null) goto L10;
        this.treeDigest = r100;
        Digest r101 = DigestUtil.getDigest(r100);
        int r102 = XMSSUtil.getDigestSize(r101);
        this.digestSize = r102;
        this.winternitzParameter = 16;
        int r103 = (int) Math.ceil(((double) (r102 * 8)) / ((double) XMSSUtil.log2(16)));
        this.len1 = r103;
        int r104 = ((int) Math.floor(XMSSUtil.log2((16 - 1) * r103) / XMSSUtil.log2(16))) + 1;
        this.len2 = r104;
        int r105 = r103 + r104;
        this.len = r105;
        WOTSPlusOid r106 = WOTSPlusOid.lookup(r101.getAlgorithmName(), r102, 16, r105);
        this.oid = r106;
        if (r106 == null) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + r101.getAlgorithmName());
    L10:
        throw new NullPointerException("treeDigest == null");
    }

    public int getLen() {
        return this.len;
    }

    public int getLen1() {
        return this.len1;
    }

    public int getLen2() {
        return this.len2;
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int getTreeDigestSize() {
        return this.digestSize;
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
