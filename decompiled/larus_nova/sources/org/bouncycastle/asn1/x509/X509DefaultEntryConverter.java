package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class X509DefaultEntryConverter extends X509NameEntryConverter {
    public X509DefaultEntryConverter() {
    }

    @Override // org.bouncycastle.asn1.x509.X509NameEntryConverter
    public ASN1Primitive getConvertedValue(ASN1ObjectIdentifier r100, String r101) {
        if (r101.length() == 0) goto L11;
        if (r101.charAt(0) != '#') goto L11;
        return convertHexEncoded(r101, 1);
    L9:
        throw new RuntimeException("can't recode value for oid " + r100.getId());
    L11:
        if (r101.length() == 0) goto L16;
        if (r101.charAt(0) != '\\') goto L16;
        r101 = r101.substring(1);
    L16:
        if (r100.equals(X509Name.EmailAddress) == true) goto L38;
        if (r100.equals(X509Name.DC) == true) goto L38;
        if (r100.equals(X509Name.DATE_OF_BIRTH) == false) goto L25;
        return new DERGeneralizedTime(r101);
    L25:
        if (r100.equals(X509Name.C) == true) goto L36;
        if (r100.equals(X509Name.SN) == true) goto L36;
        if (r100.equals(X509Name.DN_QUALIFIER) == true) goto L36;
        if (r100.equals(X509Name.TELEPHONE_NUMBER) == true) goto L36;
        return new DERUTF8String(r101);
    L36:
        return new DERPrintableString(r101);
    L38:
        return new DERIA5String(r101);
    }
}
