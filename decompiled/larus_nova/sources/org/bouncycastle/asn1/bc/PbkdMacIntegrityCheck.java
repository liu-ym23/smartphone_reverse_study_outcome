package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PbkdMacIntegrityCheck extends ASN1Object {

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private final ASN1OctetString f525024mac;
    private final AlgorithmIdentifier macAlgorithm;
    private final KeyDerivationFunc pbkdAlgorithm;

    private PbkdMacIntegrityCheck(ASN1Sequence r100) {
        this.macAlgorithm = AlgorithmIdentifier.getInstance(r100.getObjectAt(0));
        this.pbkdAlgorithm = KeyDerivationFunc.getInstance(r100.getObjectAt(1));
        this.f525024mac = ASN1OctetString.getInstance(r100.getObjectAt(2));
    }

    public PbkdMacIntegrityCheck(AlgorithmIdentifier r100, KeyDerivationFunc r101, byte[] r102) {
        this.macAlgorithm = r100;
        this.pbkdAlgorithm = r101;
        this.f525024mac = new DEROctetString(Arrays.clone(r102));
    }

    public static PbkdMacIntegrityCheck getInstance(Object r100) {
        if ((r100 instanceof PbkdMacIntegrityCheck) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PbkdMacIntegrityCheck(ASN1Sequence.getInstance(r100));
    L5:
        return (PbkdMacIntegrityCheck) r100;
    }

    public byte[] getMac() {
        return Arrays.clone(this.f525024mac.getOctets());
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public KeyDerivationFunc getPbkdAlgorithm() {
        return this.pbkdAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.macAlgorithm);
        r100.add(this.pbkdAlgorithm);
        r100.add(this.f525024mac);
        return new DERSequence(r100);
    }
}
