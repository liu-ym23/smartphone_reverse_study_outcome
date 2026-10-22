package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PBKDF2Params extends ASN1Object {
    private static final AlgorithmIdentifier algid_hmacWithSHA1 = null;
    private final ASN1Integer iterationCount;
    private final ASN1Integer keyLength;
    private final ASN1OctetString octStr;
    private final AlgorithmIdentifier prf;

    static {
        algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    }

    private PBKDF2Params(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.octStr = (ASN1OctetString) r101.nextElement();
        this.iterationCount = (ASN1Integer) r101.nextElement();
        if (r101.hasMoreElements() == false) goto L13;
        Object r102 = r101.nextElement();
        if ((r102 instanceof ASN1Integer) == false) goto L10;
        this.keyLength = ASN1Integer.getInstance(r102);
        if (r101.hasMoreElements() == false) goto L9;
        r102 = r101.nextElement();
    L11:
        if (r102 == null) goto L14;
        this.prf = AlgorithmIdentifier.getInstance(r102);
        return;
    L14:
        this.prf = null;
        return;
    L9:
        r102 = null;
        goto L11
    L10:
        this.keyLength = null;
        goto L11
    L13:
        this.keyLength = null;
        goto L14
    }

    public PBKDF2Params(byte[] r100, int r101) {
        this(r100, r101, 0);
    }

    public PBKDF2Params(byte[] r100, int r101, int r102) {
        this(r100, r101, r102, null);
    }

    public PBKDF2Params(byte[] r100, int r101, int r102, AlgorithmIdentifier r103) {
        this.octStr = new DEROctetString(Arrays.clone(r100));
        this.iterationCount = new ASN1Integer(r101);
        if (r102 <= 0) goto L5;
        ASN1Integer r104 = new ASN1Integer(r102);
    L6:
        this.keyLength = r104;
        this.prf = r103;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public PBKDF2Params(byte[] r100, int r101, AlgorithmIdentifier r102) {
        this(r100, r101, 0, r102);
    }

    public static PBKDF2Params getInstance(Object r100) {
        if ((r100 instanceof PBKDF2Params) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PBKDF2Params(ASN1Sequence.getInstance(r100));
    L5:
        return (PBKDF2Params) r100;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer r100 = this.keyLength;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getValue();
    }

    public AlgorithmIdentifier getPrf() {
        AlgorithmIdentifier r100 = this.prf;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return algid_hmacWithSHA1;
    }

    public byte[] getSalt() {
        return this.octStr.getOctets();
    }

    public boolean isDefaultPrf() {
        AlgorithmIdentifier r100 = this.prf;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.equals(algid_hmacWithSHA1) == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.octStr);
        r100.add(this.iterationCount);
        ASN1Integer r101 = this.keyLength;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        AlgorithmIdentifier r102 = this.prf;
        if (r102 == null) goto L11;
        if (r102.equals(algid_hmacWithSHA1) == true) goto L11;
        r100.add(this.prf);
    L11:
        return new DERSequence(r100);
    }
}
