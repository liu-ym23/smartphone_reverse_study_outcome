package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class BiometricData extends ASN1Object {
    private ASN1OctetString biometricDataHash;
    private AlgorithmIdentifier hashAlgorithm;
    private DERIA5String sourceDataUri;
    private TypeOfBiometricData typeOfBiometricData;

    private BiometricData(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.typeOfBiometricData = TypeOfBiometricData.getInstance(r101.nextElement());
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(r101.nextElement());
        this.biometricDataHash = ASN1OctetString.getInstance(r101.nextElement());
        if (r101.hasMoreElements() == false) goto L6;
        this.sourceDataUri = DERIA5String.getInstance(r101.nextElement());
        return;
    }

    public BiometricData(TypeOfBiometricData r100, AlgorithmIdentifier r101, ASN1OctetString r102) {
        this.typeOfBiometricData = r100;
        this.hashAlgorithm = r101;
        this.biometricDataHash = r102;
        this.sourceDataUri = null;
    }

    public BiometricData(TypeOfBiometricData r100, AlgorithmIdentifier r101, ASN1OctetString r102, DERIA5String r103) {
        this.typeOfBiometricData = r100;
        this.hashAlgorithm = r101;
        this.biometricDataHash = r102;
        this.sourceDataUri = r103;
    }

    public static BiometricData getInstance(Object r100) {
        if ((r100 instanceof BiometricData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new BiometricData(ASN1Sequence.getInstance(r100));
    L5:
        return (BiometricData) r100;
    }

    public ASN1OctetString getBiometricDataHash() {
        return this.biometricDataHash;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public DERIA5String getSourceDataUri() {
        return this.sourceDataUri;
    }

    public TypeOfBiometricData getTypeOfBiometricData() {
        return this.typeOfBiometricData;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.typeOfBiometricData);
        r100.add(this.hashAlgorithm);
        r100.add(this.biometricDataHash);
        DERIA5String r101 = this.sourceDataUri;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
