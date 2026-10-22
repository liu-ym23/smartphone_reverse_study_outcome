package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public interface X500NameStyle {
    boolean areEqual(X500Name r100, X500Name r101);

    ASN1ObjectIdentifier attrNameToOID(String r100);

    int calculateHashCode(X500Name r100);

    RDN[] fromString(String r100);

    String[] oidToAttrNames(ASN1ObjectIdentifier r100);

    String oidToDisplayName(ASN1ObjectIdentifier r100);

    ASN1Encodable stringToValue(ASN1ObjectIdentifier r100, String r101);

    String toString(X500Name r100);
}
