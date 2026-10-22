package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSParameters {
    private static final Map<Integer, XMSSParameters> paramsLookupTable = null;
    private final int height;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f525593k;
    private final XMSSOid oid;
    private final String treeDigest;
    private final ASN1ObjectIdentifier treeDigestOID;
    private final int treeDigestSize;
    private final int winternitzParameter;
    private final WOTSPlusParameters wotsPlusParams;

    static {
        HashMap r100 = new HashMap();
        Integer r101 = Integers.valueOf(1);
        ASN1ObjectIdentifier r102 = NISTObjectIdentifiers.id_sha256;
        r100.put(r101, new XMSSParameters(10, r102));
        r100.put(Integers.valueOf(2), new XMSSParameters(16, r102));
        r100.put(Integers.valueOf(3), new XMSSParameters(20, r102));
        Integer r103 = Integers.valueOf(4);
        ASN1ObjectIdentifier r104 = NISTObjectIdentifiers.id_sha512;
        r100.put(r103, new XMSSParameters(10, r104));
        r100.put(Integers.valueOf(5), new XMSSParameters(16, r104));
        r100.put(Integers.valueOf(6), new XMSSParameters(20, r104));
        Integer r105 = Integers.valueOf(7);
        ASN1ObjectIdentifier r106 = NISTObjectIdentifiers.id_shake128;
        r100.put(r105, new XMSSParameters(10, r106));
        r100.put(Integers.valueOf(8), new XMSSParameters(16, r106));
        r100.put(Integers.valueOf(9), new XMSSParameters(20, r106));
        Integer r107 = Integers.valueOf(10);
        ASN1ObjectIdentifier r108 = NISTObjectIdentifiers.id_shake256;
        r100.put(r107, new XMSSParameters(10, r108));
        r100.put(Integers.valueOf(11), new XMSSParameters(16, r108));
        r100.put(Integers.valueOf(12), new XMSSParameters(20, r108));
        paramsLookupTable = Collections.unmodifiableMap(r100);
    }

    public XMSSParameters(int r100, ASN1ObjectIdentifier r101) {
        if (r100 < 2) goto L10;
        if (r101 == null) goto L8;
        this.height = r100;
        this.f525593k = determineMinK();
        String r102 = DigestUtil.getDigestName(r101);
        this.treeDigest = r102;
        this.treeDigestOID = r101;
        WOTSPlusParameters r103 = new WOTSPlusParameters(r101);
        this.wotsPlusParams = r103;
        int r104 = r103.getTreeDigestSize();
        this.treeDigestSize = r104;
        int r105 = r103.getWinternitzParameter();
        this.winternitzParameter = r105;
        this.oid = DefaultXMSSOid.lookup(r102, r104, r105, r103.getLen(), r100);
        return;
    L8:
        throw new NullPointerException("digest == null");
    L10:
        throw new IllegalArgumentException("height must be >= 2");
    }

    public XMSSParameters(int r100, Digest r101) {
        this(r100, DigestUtil.getDigestOID(r101.getAlgorithmName()));
    }

    private int determineMinK() {
        int r100 = 2;
    L3:
        int r101 = this.height;
        if (r100 > r101) goto L10;
        if (((r101 - r100) % 2) == 0) goto L7;
        r100 = r100 + 1;
        goto L3
    L7:
        return r100;
    L10:
        throw new IllegalStateException("should never happen...");
    }

    public static XMSSParameters lookupByOID(int r100) {
        return paramsLookupTable.get(Integers.valueOf(r100));
    }

    public int getHeight() {
        return this.height;
    }

    public int getK() {
        return this.f525593k;
    }

    public int getLen() {
        return this.wotsPlusParams.getLen();
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.treeDigestOID;
    }

    public int getTreeDigestSize() {
        return this.treeDigestSize;
    }

    public WOTSPlus getWOTSPlus() {
        return new WOTSPlus(this.wotsPlusParams);
    }

    public int getWinternitzParameter() {
        return this.winternitzParameter;
    }
}
