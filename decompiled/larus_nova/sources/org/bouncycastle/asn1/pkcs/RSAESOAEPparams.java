package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class RSAESOAEPparams extends ASN1Object {
    public static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = null;
    public static final AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = null;
    public static final AlgorithmIdentifier DEFAULT_P_SOURCE_ALGORITHM = null;
    private AlgorithmIdentifier hashAlgorithm;
    private AlgorithmIdentifier maskGenAlgorithm;
    private AlgorithmIdentifier pSourceAlgorithm;

    static {
        AlgorithmIdentifier r100 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        DEFAULT_HASH_ALGORITHM = r100;
        DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, r100);
        DEFAULT_P_SOURCE_ALGORITHM = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(new byte[0]));
    }

    public RSAESOAEPparams() {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.pSourceAlgorithm = DEFAULT_P_SOURCE_ALGORITHM;
    }

    public RSAESOAEPparams(ASN1Sequence r100) {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.pSourceAlgorithm = DEFAULT_P_SOURCE_ALGORITHM;
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L16;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r100.getObjectAt(r101);
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L9;
        this.maskGenAlgorithm = AlgorithmIdentifier.getInstance(r102, true);
    L15:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r103 != 2) goto L12;
        this.pSourceAlgorithm = AlgorithmIdentifier.getInstance(r102, true);
        goto L15
    L12:
        throw new IllegalArgumentException("unknown tag");
    L14:
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r102, true);
        goto L15
    }

    public RSAESOAEPparams(AlgorithmIdentifier r100, AlgorithmIdentifier r101, AlgorithmIdentifier r102) {
        this.hashAlgorithm = r100;
        this.maskGenAlgorithm = r101;
        this.pSourceAlgorithm = r102;
    }

    public static RSAESOAEPparams getInstance(Object r100) {
        if ((r100 instanceof RSAESOAEPparams) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RSAESOAEPparams(ASN1Sequence.getInstance(r100));
    L5:
        return (RSAESOAEPparams) r100;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public AlgorithmIdentifier getMaskGenAlgorithm() {
        return this.maskGenAlgorithm;
    }

    public AlgorithmIdentifier getPSourceAlgorithm() {
        return this.pSourceAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        if (this.hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM) == true) goto L6;
        r100.add(new DERTaggedObject(true, 0, this.hashAlgorithm));
    L6:
        if (this.maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION) == true) goto L9;
        r100.add(new DERTaggedObject(true, 1, this.maskGenAlgorithm));
    L9:
        if (this.pSourceAlgorithm.equals(DEFAULT_P_SOURCE_ALGORITHM) == true) goto L12;
        r100.add(new DERTaggedObject(true, 2, this.pSourceAlgorithm));
    L12:
        return new DERSequence(r100);
    }
}
