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
public class Extensions extends ASN1Object {
    private Hashtable extensions;
    private Vector ordering;

    private Extensions(ASN1Sequence r100) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L10;
        Extension r102 = Extension.getInstance(r101.nextElement());
        if (this.extensions.containsKey(r102.getExtnId()) == true) goto L9;
        this.extensions.put(r102.getExtnId(), r102);
        this.ordering.addElement(r102.getExtnId());
        goto L4
    L9:
        throw new IllegalArgumentException("repeated extension found: " + r102.getExtnId());
    }

    public Extensions(Extension r100) {
        this.extensions = new Hashtable();
        Vector r101 = new Vector();
        this.ordering = r101;
        r101.addElement(r100.getExtnId());
        this.extensions.put(r100.getExtnId(), r100);
    }

    public Extensions(Extension[] r100) {
        this.extensions = new Hashtable();
        this.ordering = new Vector();
        int r101 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        Extension r102 = r100[r101];
        this.ordering.addElement(r102.getExtnId());
        this.extensions.put(r102.getExtnId(), r102);
        r101 = r101 + 1;
        goto L4
    }

    public static Extension getExtension(Extensions r100, ASN1ObjectIdentifier r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getExtension(r101);
    }

    private ASN1ObjectIdentifier[] getExtensionOIDs(boolean r100) {
        Vector r101 = new Vector();
        int r102 = 0;
    L4:
        if (r102 == this.ordering.size()) goto L10;
        Object r103 = this.ordering.elementAt(r102);
        if (((Extension) this.extensions.get(r103)).isCritical() != r100) goto L8;
        r101.addElement(r103);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return toOidArray(r101);
    }

    public static ASN1Encodable getExtensionParsedValue(Extensions r100, ASN1ObjectIdentifier r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getExtensionParsedValue(r101);
    }

    public static Extensions getInstance(Object r100) {
        if ((r100 instanceof Extensions) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Extensions(ASN1Sequence.getInstance(r100));
    L5:
        return (Extensions) r100;
    }

    public static Extensions getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    private ASN1ObjectIdentifier[] toOidArray(Vector r100) {
        int r101 = r100.size();
        ASN1ObjectIdentifier[] r102 = new ASN1ObjectIdentifier[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = (ASN1ObjectIdentifier) r100.elementAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public boolean equivalent(Extensions r100) {
        if (this.extensions.size() == r100.extensions.size()) goto L5;
        return false;
    L5:
        Enumeration r101 = this.extensions.keys();
    L7:
        if (r101.hasMoreElements() == false) goto L11;
        Object r102 = r101.nextElement();
        if (this.extensions.get(r102).equals(r100.extensions.get(r102)) == true) goto L7;
        return false;
    L11:
        return true;
    }

    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public Extension getExtension(ASN1ObjectIdentifier r100) {
        return (Extension) this.extensions.get(r100);
    }

    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        return toOidArray(this.ordering);
    }

    public ASN1Encodable getExtensionParsedValue(ASN1ObjectIdentifier r100) {
        Extension r101 = getExtension(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getParsedValue();
    }

    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public Enumeration oids() {
        return this.ordering.elements();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.ordering.size());
        Enumeration r101 = this.ordering.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L7;
        ASN1ObjectIdentifier r102 = (ASN1ObjectIdentifier) r101.nextElement();
        r100.add((Extension) this.extensions.get(r102));
        goto L4
    L7:
        return new DERSequence(r100);
    }
}
