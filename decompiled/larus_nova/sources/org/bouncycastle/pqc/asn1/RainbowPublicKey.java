package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowPublicKey extends ASN1Object {
    private byte[][] coeffQuadratic;
    private byte[] coeffScalar;
    private byte[][] coeffSingular;
    private ASN1Integer docLength;
    private ASN1ObjectIdentifier oid;
    private ASN1Integer version;

    public RainbowPublicKey(int r100, short[][] r101, short[][] r102, short[] r103) {
        this.version = new ASN1Integer(0);
        this.docLength = new ASN1Integer(r100);
        this.coeffQuadratic = RainbowUtil.convertArray(r101);
        this.coeffSingular = RainbowUtil.convertArray(r102);
        this.coeffScalar = RainbowUtil.convertArray(r103);
    }

    private RainbowPublicKey(ASN1Sequence r100) {
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L5;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
    L6:
        this.docLength = ASN1Integer.getInstance(r100.getObjectAt(1));
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100.getObjectAt(2));
        this.coeffQuadratic = new byte[r101.size()][];
        int r102 = 0;
    L8:
        if (r102 >= r101.size()) goto L10;
        this.coeffQuadratic[r102] = ASN1OctetString.getInstance(r101.getObjectAt(r102)).getOctets();
        r102 = r102 + 1;
        goto L8
    L10:
        ASN1Sequence r103 = (ASN1Sequence) r100.getObjectAt(3);
        this.coeffSingular = new byte[r103.size()][];
        int r104 = 0;
    L12:
        if (r104 >= r103.size()) goto L14;
        this.coeffSingular[r104] = ASN1OctetString.getInstance(r103.getObjectAt(r104)).getOctets();
        r104 = r104 + 1;
        goto L12
    L14:
        this.coeffScalar = ASN1OctetString.getInstance(((ASN1Sequence) r100.getObjectAt(4)).getObjectAt(0)).getOctets();
        return;
    L5:
        this.oid = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        goto L6
    }

    public static RainbowPublicKey getInstance(Object r100) {
        if ((r100 instanceof RainbowPublicKey) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RainbowPublicKey(ASN1Sequence.getInstance(r100));
    L5:
        return (RainbowPublicKey) r100;
    }

    public short[][] getCoeffQuadratic() {
        return RainbowUtil.convertArray(this.coeffQuadratic);
    }

    public short[] getCoeffScalar() {
        return RainbowUtil.convertArray(this.coeffScalar);
    }

    public short[][] getCoeffSingular() {
        return RainbowUtil.convertArray(this.coeffSingular);
    }

    public int getDocLength() {
        return this.docLength.intValueExact();
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        ASN1Encodable r101 = this.version;
        if (r101 != null) goto L6;
        r101 = this.oid;
    L6:
        r100.add(r101);
        r100.add(this.docLength);
        ASN1EncodableVector r102 = new ASN1EncodableVector();
        int r103 = 0;
        int r104 = 0;
    L7:
        byte[][] r105 = this.coeffQuadratic;
        if (r104 >= r105.length) goto L10;
        r102.add(new DEROctetString(r105[r104]));
        r104 = r104 + 1;
        goto L7
    L10:
        r100.add(new DERSequence(r102));
        ASN1EncodableVector r106 = new ASN1EncodableVector();
    L11:
        byte[][] r107 = this.coeffSingular;
        if (r103 >= r107.length) goto L14;
        r106.add(new DEROctetString(r107[r103]));
        r103 = r103 + 1;
        goto L11
    L14:
        r100.add(new DERSequence(r106));
        ASN1EncodableVector r108 = new ASN1EncodableVector();
        r108.add(new DEROctetString(this.coeffScalar));
        r100.add(new DERSequence(r108));
        return new DERSequence(r100);
    }
}
