package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ESSCertIDv2 extends ASN1Object {
    private static final AlgorithmIdentifier DEFAULT_ALG_ID = null;
    private byte[] certHash;
    private AlgorithmIdentifier hashAlgorithm;
    private IssuerSerial issuerSerial;

    static {
        DEFAULT_ALG_ID = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    }

    private ESSCertIDv2(ASN1Sequence r100) {
        if (r100.size() > 3) goto L13;
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1OctetString) == false) goto L7;
        this.hashAlgorithm = DEFAULT_ALG_ID;
    L8:
        int r102 = r101 + 1;
        this.certHash = ASN1OctetString.getInstance(r100.getObjectAt(r101).toASN1Primitive()).getOctets();
        if (r100.size() <= r102) goto L14;
        this.issuerSerial = IssuerSerial.getInstance(r100.getObjectAt(r102));
        return;
    L14:
        return;
    L7:
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0).toASN1Primitive());
        r101 = 1;
        goto L8
    L13:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public ESSCertIDv2(AlgorithmIdentifier r100, byte[] r101) {
        this(r100, r101, null);
    }

    public ESSCertIDv2(AlgorithmIdentifier r100, byte[] r101, IssuerSerial r102) {
        if (r100 != null) goto L5;
        r100 = DEFAULT_ALG_ID;
    L5:
        this.hashAlgorithm = r100;
        this.certHash = Arrays.clone(r101);
        this.issuerSerial = r102;
    }

    public ESSCertIDv2(byte[] r100) {
        this(null, r100, null);
    }

    public ESSCertIDv2(byte[] r100, IssuerSerial r101) {
        this(null, r100, r101);
    }

    public static ESSCertIDv2 getInstance(Object r100) {
        if ((r100 instanceof ESSCertIDv2) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ESSCertIDv2(ASN1Sequence.getInstance(r100));
    L5:
        return (ESSCertIDv2) r100;
    }

    public byte[] getCertHash() {
        return Arrays.clone(this.certHash);
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        if (this.hashAlgorithm.equals(DEFAULT_ALG_ID) == true) goto L5;
        r100.add(this.hashAlgorithm);
    L5:
        r100.add(new DEROctetString(this.certHash).toASN1Primitive());
        IssuerSerial r101 = this.issuerSerial;
        if (r101 == null) goto L9;
        r100.add(r101);
    L9:
        return new DERSequence(r100);
    }
}
