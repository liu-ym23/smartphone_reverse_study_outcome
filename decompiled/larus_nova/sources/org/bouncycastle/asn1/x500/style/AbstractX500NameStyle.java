package org.bouncycastle.asn1.x500.style;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractX500NameStyle implements X500NameStyle {
    public AbstractX500NameStyle() {
    }

    private int calcHashCode(ASN1Encodable r100) {
        return IETFUtils.canonicalString(r100).hashCode();
    }

    public static Hashtable copyHashTable(Hashtable r100) {
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

    private boolean foundMatch(boolean r100, RDN r101, RDN[] r102) {
        if (r100 == false) goto L13;
        int r103 = r102.length - 1;
    L5:
        if (r103 < 0) goto L23;
        RDN r104 = r102[r103];
        if (r104 == null) goto L12;
        if (rdnAreEqual(r101, r104) == false) goto L12;
        r102[r103] = null;
        return true;
    L12:
        r103 = r103 - 1;
    L23:
        return false;
    L13:
        int r105 = 0;
    L15:
        if (r105 == r102.length) goto L23;
        RDN r106 = r102[r105];
        if (r106 == null) goto L22;
        if (rdnAreEqual(r101, r106) == false) goto L22;
        r102[r105] = null;
        return true;
    L22:
        r105 = r105 + 1;
        goto L15
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public boolean areEqual(X500Name r100, X500Name r101) {
        RDN[] r102 = r100.getRDNs();
        RDN[] r103 = r101.getRDNs();
        if (r102.length == r103.length) goto L6;
        return false;
    L6:
        if (r102[0].getFirst() != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        int r105 = 0;
    L13:
        if (r105 == r102.length) goto L18;
        if (foundMatch(r104, r102[r105], r103) == false) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    L8:
        if (r103[0].getFirst() == null) goto L10;
        r104 = !r102[0].getFirst().getType().equals(r103[0].getFirst().getType());
        goto L11
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public int calculateHashCode(X500Name r100) {
        RDN[] r101 = r100.getRDNs();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 == r101.length) goto L13;
        if (r101[r102].isMultiValued() == false) goto L11;
        AttributeTypeAndValue[] r104 = r101[r102].getTypesAndValues();
        int r105 = 0;
    L9:
        if (r105 == r104.length) goto L12;
        r103 = (r103 ^ r104[r105].getType().hashCode()) ^ calcHashCode(r104[r105].getValue());
        r105 = r105 + 1;
    L12:
        r102 = r102 + 1;
        goto L4
    L11:
        r103 = (r103 ^ r101[r102].getFirst().getType().hashCode()) ^ calcHashCode(r101[r102].getFirst().getValue());
        goto L12
    L13:
        return r103;
    }

    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier r100, String r101) {
        return new DERUTF8String(r101);
    }

    public boolean rdnAreEqual(RDN r100, RDN r101) {
        return IETFUtils.rDNAreEqual(r100, r101);
    }

    @Override // org.bouncycastle.asn1.x500.X500NameStyle
    public ASN1Encodable stringToValue(ASN1ObjectIdentifier r100, String r101) {
        if (r101.length() == 0) goto L11;
        if (r101.charAt(0) != '#') goto L11;
        return IETFUtils.valueFromHexString(r101, 1);
    L9:
        throw new ASN1ParsingException("can't recode value for oid " + r100.getId());
    L11:
        if (r101.length() == 0) goto L16;
        if (r101.charAt(0) != '\\') goto L16;
        r101 = r101.substring(1);
    L16:
        return encodeStringValue(r100, r101);
    }
}
