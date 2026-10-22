package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ExtendedKeyUsage extends ASN1Object {
    ASN1Sequence seq;
    Hashtable usageTable;

    public ExtendedKeyUsage(Vector r100) {
        this.usageTable = new Hashtable();
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.size());
        Enumeration r102 = r100.elements();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        KeyPurposeId r103 = KeyPurposeId.getInstance(r102.nextElement());
        r101.add(r103);
        this.usageTable.put(r103, r103);
        goto L4
    L6:
        this.seq = new DERSequence(r101);
    }

    private ExtendedKeyUsage(ASN1Sequence r100) {
        this.usageTable = new Hashtable();
        this.seq = r100;
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L10;
        ASN1Encodable r102 = (ASN1Encodable) r101.nextElement();
        if ((r102.toASN1Primitive() instanceof ASN1ObjectIdentifier) == false) goto L9;
        this.usageTable.put(r102, r102);
        goto L4
    L9:
        throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
    }

    public ExtendedKeyUsage(KeyPurposeId r100) {
        this.usageTable = new Hashtable();
        this.seq = new DERSequence(r100);
        this.usageTable.put(r100, r100);
    }

    public ExtendedKeyUsage(KeyPurposeId[] r100) {
        this.usageTable = new Hashtable();
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.length);
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L6;
        r101.add(r100[r102]);
        Hashtable r103 = this.usageTable;
        KeyPurposeId r104 = r100[r102];
        r103.put(r104, r104);
        r102 = r102 + 1;
        goto L4
    L6:
        this.seq = new DERSequence(r101);
    }

    public static ExtendedKeyUsage fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.extendedKeyUsage));
    }

    public static ExtendedKeyUsage getInstance(Object r100) {
        if ((r100 instanceof ExtendedKeyUsage) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ExtendedKeyUsage(ASN1Sequence.getInstance(r100));
    L5:
        return (ExtendedKeyUsage) r100;
    }

    public static ExtendedKeyUsage getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public KeyPurposeId[] getUsages() {
        KeyPurposeId[] r100 = new KeyPurposeId[this.seq.size()];
        Enumeration r101 = this.seq.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100[r102] = KeyPurposeId.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public boolean hasKeyPurposeId(KeyPurposeId r100) {
        if (this.usageTable.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int size() {
        return this.usageTable.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
