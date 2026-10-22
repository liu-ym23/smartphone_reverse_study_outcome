package org.bouncycastle.asn1.pkcs;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class PrivateKeyInfo extends ASN1Object {
    private ASN1Set attributes;
    private ASN1OctetString privateKey;
    private AlgorithmIdentifier privateKeyAlgorithm;
    private ASN1BitString publicKey;
    private ASN1Integer version;

    private PrivateKeyInfo(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        ASN1Integer r102 = ASN1Integer.getInstance(r101.nextElement());
        this.version = r102;
        int r103 = getVersionValue(r102);
        this.privateKeyAlgorithm = AlgorithmIdentifier.getInstance(r101.nextElement());
        this.privateKey = ASN1OctetString.getInstance(r101.nextElement());
        int r104 = -1;
    L4:
        if (r101.hasMoreElements() == false) goto L21;
        ASN1TaggedObject r105 = (ASN1TaggedObject) r101.nextElement();
        int r106 = r105.getTagNo();
        if (r106 <= r104) goto L20;
        if (r106 != 0) goto L10;
        this.attributes = ASN1Set.getInstance(r105, false);
    L18:
        r104 = r106;
        goto L4
    L10:
        if (r106 != 1) goto L16;
        if (r103 < 1) goto L14;
        this.publicKey = DERBitString.getInstance(r105, false);
        goto L18
    L14:
        throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
    L16:
        throw new IllegalArgumentException("unknown optional field in private key info");
    L20:
        throw new IllegalArgumentException("invalid optional field in private key info");
    }

    public PrivateKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101) throws IOException {
        this(r100, r101, null, null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101, ASN1Set r102) throws IOException {
        this(r100, r101, r102, null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier r100, ASN1Encodable r101, ASN1Set r102, byte[] r103) throws IOException {
        if (r103 == null) goto L5;
        BigInteger r104 = BigIntegers.ONE;
    L6:
        this.version = new ASN1Integer(r104);
        this.privateKeyAlgorithm = r100;
        this.privateKey = new DEROctetString(r101);
        this.attributes = r102;
        if (r103 != null) goto L9;
        DERBitString r105 = null;
    L10:
        this.publicKey = r105;
        return;
    L9:
        r105 = new DERBitString(r103);
        goto L10
    L5:
        r104 = BigIntegers.ZERO;
        goto L6
    }

    public static PrivateKeyInfo getInstance(Object r100) {
        if ((r100 instanceof PrivateKeyInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PrivateKeyInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (PrivateKeyInfo) r100;
    }

    public static PrivateKeyInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private static int getVersionValue(ASN1Integer r100) {
        int r101 = r100.intValueExact();
        if (r101 < 0) goto L8;
        if (r101 > 1) goto L8;
        return r101;
    L8:
        throw new IllegalArgumentException("invalid version for private key info");
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public ASN1OctetString getPrivateKey() {
        return new DEROctetString(this.privateKey.getOctets());
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithm() {
        return this.privateKeyAlgorithm;
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public boolean hasPublicKey() {
        if (this.publicKey == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ASN1Encodable parsePrivateKey() throws IOException {
        return ASN1Primitive.fromByteArray(this.privateKey.getOctets());
    }

    public ASN1Encodable parsePublicKey() throws IOException {
        ASN1BitString r100 = this.publicKey;
        if (r100 != null) goto L6;
        return null;
    L6:
        return ASN1Primitive.fromByteArray(r100.getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.version);
        r100.add(this.privateKeyAlgorithm);
        r100.add(this.privateKey);
        ASN1Set r101 = this.attributes;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        ASN1BitString r102 = this.publicKey;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
