package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTParameters {
    private static final Map<Integer, XMSSMTParameters> paramsLookupTable = null;
    private final int height;
    private final int layers;
    private final XMSSOid oid;
    private final XMSSParameters xmssParams;

    static {
        HashMap r100 = new HashMap();
        Integer r101 = Integers.valueOf(1);
        ASN1ObjectIdentifier r102 = NISTObjectIdentifiers.id_sha256;
        r100.put(r101, new XMSSMTParameters(20, 2, r102));
        r100.put(Integers.valueOf(2), new XMSSMTParameters(20, 4, r102));
        r100.put(Integers.valueOf(3), new XMSSMTParameters(40, 2, r102));
        r100.put(Integers.valueOf(4), new XMSSMTParameters(40, 4, r102));
        r100.put(Integers.valueOf(5), new XMSSMTParameters(40, 8, r102));
        r100.put(Integers.valueOf(6), new XMSSMTParameters(60, 3, r102));
        r100.put(Integers.valueOf(7), new XMSSMTParameters(60, 6, r102));
        r100.put(Integers.valueOf(8), new XMSSMTParameters(60, 12, r102));
        Integer r103 = Integers.valueOf(9);
        ASN1ObjectIdentifier r110 = NISTObjectIdentifiers.id_sha512;
        r100.put(r103, new XMSSMTParameters(20, 2, r110));
        r100.put(Integers.valueOf(10), new XMSSMTParameters(20, 4, r110));
        r100.put(Integers.valueOf(11), new XMSSMTParameters(40, 2, r110));
        r100.put(Integers.valueOf(12), new XMSSMTParameters(40, 4, r110));
        r100.put(Integers.valueOf(13), new XMSSMTParameters(40, 8, r110));
        r100.put(Integers.valueOf(14), new XMSSMTParameters(60, 3, r110));
        r100.put(Integers.valueOf(15), new XMSSMTParameters(60, 6, r110));
        r100.put(Integers.valueOf(16), new XMSSMTParameters(60, 12, r110));
        Integer r104 = Integers.valueOf(17);
        ASN1ObjectIdentifier r111 = NISTObjectIdentifiers.id_shake128;
        r100.put(r104, new XMSSMTParameters(20, 2, r111));
        r100.put(Integers.valueOf(18), new XMSSMTParameters(20, 4, r111));
        r100.put(Integers.valueOf(19), new XMSSMTParameters(40, 2, r111));
        r100.put(Integers.valueOf(20), new XMSSMTParameters(40, 4, r111));
        r100.put(Integers.valueOf(21), new XMSSMTParameters(40, 8, r111));
        r100.put(Integers.valueOf(22), new XMSSMTParameters(60, 3, r111));
        r100.put(Integers.valueOf(23), new XMSSMTParameters(60, 6, r111));
        r100.put(Integers.valueOf(24), new XMSSMTParameters(60, 12, r111));
        Integer r105 = Integers.valueOf(25);
        ASN1ObjectIdentifier r112 = NISTObjectIdentifiers.id_shake256;
        r100.put(r105, new XMSSMTParameters(20, 2, r112));
        r100.put(Integers.valueOf(26), new XMSSMTParameters(20, 4, r112));
        r100.put(Integers.valueOf(27), new XMSSMTParameters(40, 2, r112));
        r100.put(Integers.valueOf(28), new XMSSMTParameters(40, 4, r112));
        r100.put(Integers.valueOf(29), new XMSSMTParameters(40, 8, r112));
        r100.put(Integers.valueOf(30), new XMSSMTParameters(60, 3, r112));
        r100.put(Integers.valueOf(31), new XMSSMTParameters(60, 6, r112));
        r100.put(Integers.valueOf(32), new XMSSMTParameters(60, 12, r112));
        paramsLookupTable = Collections.unmodifiableMap(r100);
    }

    public XMSSMTParameters(int r100, int r101, ASN1ObjectIdentifier r110) {
        this.height = r100;
        this.layers = r101;
        this.xmssParams = new XMSSParameters(xmssTreeHeight(r100, r101), r110);
        this.oid = DefaultXMSSMTOid.lookup(getTreeDigest(), getTreeDigestSize(), getWinternitzParameter(), getLen(), getHeight(), r101);
    }

    public XMSSMTParameters(int r100, int r101, Digest r102) {
        this(r100, r101, DigestUtil.getDigestOID(r102.getAlgorithmName()));
    }

    public static XMSSMTParameters lookupByOID(int r100) {
        return paramsLookupTable.get(Integers.valueOf(r100));
    }

    private static int xmssTreeHeight(int r100, int r101) throws IllegalArgumentException {
        if (r100 < 2) goto L14;
        if ((r100 % r101) != 0) goto L12;
        int r102 = r100 / r101;
        if (r102 == 1) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("height / layers must be greater than 1");
    L12:
        throw new IllegalArgumentException("layers must divide totalHeight without remainder");
    L14:
        throw new IllegalArgumentException("totalHeight must be > 1");
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public int getLen() {
        return this.xmssParams.getLen();
    }

    public XMSSOid getOid() {
        return this.oid;
    }

    public String getTreeDigest() {
        return this.xmssParams.getTreeDigest();
    }

    public ASN1ObjectIdentifier getTreeDigestOID() {
        return this.xmssParams.getTreeDigestOID();
    }

    public int getTreeDigestSize() {
        return this.xmssParams.getTreeDigestSize();
    }

    public WOTSPlus getWOTSPlus() {
        return this.xmssParams.getWOTSPlus();
    }

    public int getWinternitzParameter() {
        return this.xmssParams.getWinternitzParameter();
    }

    public XMSSParameters getXMSSParameters() {
        return this.xmssParams;
    }
}
