package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class IetfAttrSyntax extends ASN1Object {
    public static final int VALUE_OCTETS = 1;
    public static final int VALUE_OID = 2;
    public static final int VALUE_UTF8 = 3;
    GeneralNames policyAuthority;
    int valueChoice;
    Vector values;

    private IetfAttrSyntax(ASN1Sequence r100) {
        this.policyAuthority = null;
        this.values = new Vector();
        this.valueChoice = -1;
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == false) goto L7;
        GeneralNames r102 = GeneralNames.getInstance((ASN1TaggedObject) r100.getObjectAt(0), false);
    L5:
        this.policyAuthority = r102;
        r101 = 1;
    L10:
        if ((r100.getObjectAt(r101) instanceof ASN1Sequence) == false) goto L35;
        Enumeration r103 = ((ASN1Sequence) r100.getObjectAt(r101)).getObjects();
    L13:
        if (r103.hasMoreElements() == false) goto L33;
        ASN1Primitive r104 = (ASN1Primitive) r103.nextElement();
        if ((r104 instanceof ASN1ObjectIdentifier) == false) goto L18;
        int r105 = 2;
    L24:
        if (this.valueChoice >= 0) goto L27;
        this.valueChoice = r105;
    L27:
        if (r105 != this.valueChoice) goto L30;
        this.values.addElement(r104);
        goto L13
    L30:
        throw new IllegalArgumentException("Mix of value types in IetfAttrSyntax");
    L18:
        if ((r104 instanceof DERUTF8String) == false) goto L21;
        r105 = 3;
        goto L24
    L21:
        if ((r104 instanceof DEROctetString) == false) goto L32;
        r105 = 1;
        goto L24
    L32:
        throw new IllegalArgumentException("Bad value type encoding IetfAttrSyntax");
    L33:
        return;
    L35:
        throw new IllegalArgumentException("Non-IetfAttrSyntax encoding");
    L7:
        if (r100.size() != 2) goto L10;
        r102 = GeneralNames.getInstance(r100.getObjectAt(0));
        goto L5
    }

    public static IetfAttrSyntax getInstance(Object r100) {
        if ((r100 instanceof IetfAttrSyntax) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IetfAttrSyntax(ASN1Sequence.getInstance(r100));
    L5:
        return (IetfAttrSyntax) r100;
    }

    public GeneralNames getPolicyAuthority() {
        return this.policyAuthority;
    }

    public int getValueType() {
        return this.valueChoice;
    }

    public Object[] getValues() {
        int r100 = 0;
        if (getValueType() != 1) goto L9;
        int r101 = this.values.size();
        ASN1OctetString[] r102 = new ASN1OctetString[r101];
    L5:
        if (r100 == r101) goto L7;
        r102[r100] = (ASN1OctetString) this.values.elementAt(r100);
        r100 = r100 + 1;
        goto L5
    L7:
        return r102;
    L9:
        if (getValueType() != 2) goto L14;
        int r103 = this.values.size();
        ASN1ObjectIdentifier[] r104 = new ASN1ObjectIdentifier[r103];
    L11:
        if (r100 == r103) goto L13;
        r104[r100] = (ASN1ObjectIdentifier) this.values.elementAt(r100);
        r100 = r100 + 1;
        goto L11
    L13:
        return r104;
    L14:
        int r105 = this.values.size();
        DERUTF8String[] r106 = new DERUTF8String[r105];
    L15:
        if (r100 == r105) goto L17;
        r106[r100] = (DERUTF8String) this.values.elementAt(r100);
        r100 = r100 + 1;
        goto L15
    L17:
        return r106;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        GeneralNames r101 = this.policyAuthority;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(0, r101));
    L5:
        ASN1EncodableVector r102 = new ASN1EncodableVector(this.values.size());
        Enumeration r103 = this.values.elements();
    L7:
        if (r103.hasMoreElements() == false) goto L9;
        r102.add((ASN1Encodable) r103.nextElement());
        goto L7
    L9:
        r100.add(new DERSequence(r102));
        return new DERSequence(r100);
    }
}
