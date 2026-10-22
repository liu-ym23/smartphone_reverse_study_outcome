package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;

/* JADX INFO: loaded from: classes42.dex */
public class AttributeTable {
    private Hashtable attributes;

    public AttributeTable(Hashtable r100) {
        this.attributes = new Hashtable();
        this.attributes = copyTable(r100);
    }

    public AttributeTable(ASN1EncodableVector r100) {
        this.attributes = new Hashtable();
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        Attribute r102 = Attribute.getInstance(r100.get(r101));
        addAttribute(r102.getAttrType(), r102);
        r101 = r101 + 1;
        goto L4
    }

    public AttributeTable(ASN1Set r100) {
        this.attributes = new Hashtable();
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        Attribute r102 = Attribute.getInstance(r100.getObjectAt(r101));
        addAttribute(r102.getAttrType(), r102);
        r101 = r101 + 1;
        goto L4
    }

    public AttributeTable(Attribute r100) {
        this.attributes = new Hashtable();
        addAttribute(r100.getAttrType(), r100);
    }

    public AttributeTable(Attributes r100) {
        this(ASN1Set.getInstance(r100.toASN1Primitive()));
    }

    private void addAttribute(ASN1ObjectIdentifier r100, Attribute r101) {
        Object r102 = this.attributes.get(r100);
        if (r102 != null) goto L6;
        this.attributes.put(r100, r101);
        return;
    L6:
        if ((r102 instanceof Attribute) == false) goto L8;
        Vector r103 = new Vector();
        r103.addElement(r102);
    L9:
        r103.addElement(r101);
        this.attributes.put(r100, r103);
        return;
    L8:
        r103 = (Vector) r102;
        goto L9
    }

    private Hashtable copyTable(Hashtable r100) {
        Hashtable r101 = new Hashtable();
        Enumeration r102 = r100.keys();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        Object r103 = r102.nextElement();
        r101.put(r103, r100.get(r103));
        goto L4
    L6:
        return r101;
    }

    public AttributeTable add(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        AttributeTable r102 = new AttributeTable(this.attributes);
        r102.addAttribute(r100, new Attribute(r100, new DERSet(r101)));
        return r102;
    }

    public Attribute get(ASN1ObjectIdentifier r100) {
        Object r101 = this.attributes.get(r100);
        if ((r101 instanceof Vector) == false) goto L7;
        return (Attribute) ((Vector) r101).elementAt(0);
    L7:
        return (Attribute) r101;
    }

    public ASN1EncodableVector getAll(ASN1ObjectIdentifier r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector();
        Object r102 = this.attributes.get(r100);
        if ((r102 instanceof Vector) == false) goto L8;
        Enumeration r103 = ((Vector) r102).elements();
    L6:
        if (r103.hasMoreElements() == false) goto L10;
        r101.add((Attribute) r103.nextElement());
    L10:
        return r101;
    L8:
        if (r102 == null) goto L10;
        r101.add((Attribute) r102);
        goto L10
    }

    public AttributeTable remove(ASN1ObjectIdentifier r100) {
        AttributeTable r101 = new AttributeTable(this.attributes);
        r101.attributes.remove(r100);
        return r101;
    }

    public int size() {
        Enumeration r100 = this.attributes.elements();
        int r101 = 0;
    L4:
        if (r100.hasMoreElements() == false) goto L9;
        Object r102 = r100.nextElement();
        if ((r102 instanceof Vector) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        r101 = r101 + ((Vector) r102).size();
        goto L4
    L9:
        return r101;
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        Enumeration r101 = this.attributes.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L12;
        Object r102 = r101.nextElement();
        if ((r102 instanceof Vector) == true) goto L7;
        r100.add(Attribute.getInstance(r102));
        goto L4
    L7:
        Enumeration r103 = ((Vector) r102).elements();
    L9:
        if (r103.hasMoreElements() == false) goto L4;
        r100.add(Attribute.getInstance(r103.nextElement()));
        goto L9
    L12:
        return r100;
    }

    public Attributes toASN1Structure() {
        return new Attributes(toASN1EncodableVector());
    }

    public Hashtable toHashtable() {
        return copyTable(this.attributes);
    }
}
