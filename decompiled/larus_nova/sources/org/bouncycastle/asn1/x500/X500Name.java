package org.bouncycastle.asn1.x500;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.style.BCStyle;

/* JADX INFO: loaded from: classes42.dex */
public class X500Name extends ASN1Object implements ASN1Choice {
    private static X500NameStyle defaultStyle;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;
    private DERSequence rdnSeq;
    private RDN[] rdns;
    private X500NameStyle style;

    static {
        defaultStyle = BCStyle.INSTANCE;
    }

    public X500Name(String r100) {
        this(defaultStyle, r100);
    }

    private X500Name(ASN1Sequence r100) {
        this(defaultStyle, r100);
    }

    public X500Name(X500NameStyle r100, String r101) {
        this(r100.fromString(r101));
        this.style = r100;
    }

    private X500Name(X500NameStyle r100, ASN1Sequence r101) {
        this.style = r100;
        this.rdns = new RDN[r101.size()];
        Enumeration r102 = r101.getObjects();
        boolean r103 = true;
        int r104 = 0;
    L4:
        if (r102.hasMoreElements() == false) goto L10;
        Object r105 = r102.nextElement();
        RDN r106 = RDN.getInstance(r105);
        if (r106 != r105) goto L8;
        boolean r107 = true;
    L9:
        r103 = r103 & r107;
        this.rdns[r104] = r106;
        r104 = r104 + 1;
        goto L4
    L8:
        r107 = false;
        goto L9
    L10:
        if (r103 == false) goto L12;
        DERSequence r108 = DERSequence.convert(r101);
    L13:
        this.rdnSeq = r108;
        return;
    L12:
        r108 = new DERSequence(this.rdns);
        goto L13
    }

    public X500Name(X500NameStyle r100, X500Name r101) {
        this.style = r100;
        this.rdns = r101.rdns;
        this.rdnSeq = r101.rdnSeq;
    }

    public X500Name(X500NameStyle r100, RDN[] r101) {
        this.style = r100;
        RDN[] r102 = (RDN[]) r101.clone();
        this.rdns = r102;
        this.rdnSeq = new DERSequence(r102);
    }

    public X500Name(RDN[] r100) {
        this(defaultStyle, r100);
    }

    public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }

    public static X500Name getInstance(Object r100) {
        if ((r100 instanceof X500Name) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new X500Name(ASN1Sequence.getInstance(r100));
    L5:
        return (X500Name) r100;
    }

    public static X500Name getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, true));
    }

    public static X500Name getInstance(X500NameStyle r100, Object r101) {
        if ((r101 instanceof X500Name) == true) goto L5;
        if (r101 != null) goto L8;
        return null;
    L8:
        return new X500Name(r100, ASN1Sequence.getInstance(r101));
    L5:
        return new X500Name(r100, (X500Name) r101);
    }

    public static void setDefaultStyle(X500NameStyle r100) {
        if (r100 == null) goto L6;
        defaultStyle = r100;
        return;
    L6:
        throw new NullPointerException("cannot set style to null");
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof X500Name) == false) goto L8;
    L10:
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if (toASN1Primitive().equals(r101) == false) goto L16;
        return true;
    L16:
        return this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((ASN1Encodable) r100).toASN1Primitive())));
    L15:
        return false;
    L8:
        if ((r100 instanceof ASN1Sequence) == true) goto L10;
        return false;
    }

    public ASN1ObjectIdentifier[] getAttributeTypes() {
        int r100 = this.rdns.length;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r103 = r103 + this.rdns[r102].size();
        r102 = r102 + 1;
        goto L3
    L5:
        ASN1ObjectIdentifier[] r104 = new ASN1ObjectIdentifier[r103];
        int r105 = 0;
    L6:
        if (r101 >= r100) goto L8;
        r105 = r105 + this.rdns[r101].collectAttributeTypes(r104, r105);
        r101 = r101 + 1;
        goto L6
    L8:
        return r104;
    }

    public RDN[] getRDNs() {
        return (RDN[]) this.rdns.clone();
    }

    public RDN[] getRDNs(ASN1ObjectIdentifier r100) {
        int r101 = this.rdns.length;
        RDN[] r102 = new RDN[r101];
        int r103 = 0;
        int r104 = 0;
    L3:
        RDN[] r105 = this.rdns;
        if (r103 == r105.length) goto L9;
        RDN r106 = r105[r103];
        if (r106.containsAttributeType(r100) == false) goto L8;
        r102[r104] = r106;
        r104 = r104 + 1;
    L8:
        r103 = r103 + 1;
        goto L3
    L9:
        if (r104 >= r101) goto L15;
        RDN[] r107 = new RDN[r104];
        System.arraycopy(r102, 0, r107, 0, r104);
        return r107;
    L15:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated == true) goto L5;
        this.isHashCodeCalculated = true;
        int r100 = this.style.calculateHashCode(this);
        this.hashCodeValue = r100;
        return r100;
    L5:
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.rdnSeq;
    }

    public String toString() {
        return this.style.toString(this);
    }
}
