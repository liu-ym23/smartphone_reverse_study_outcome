package org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class X509ExtensionUtil {
    public X509ExtensionUtil() {
    }

    public static ASN1Primitive fromExtensionValue(byte[] r100) throws IOException {
        return ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(r100)).getOctets());
    }

    private static Collection getAlternativeNames(byte[] r100) throws CertificateParsingException {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L22
        Enumeration r102 = ASN1Sequence.getInstance(fromExtensionValue(r100)).getObjects();     // Catch: Exception -> L22
    L7:
        if (r102.hasMoreElements() == false) goto L21;
        GeneralName r103 = GeneralName.getInstance(r102.nextElement());     // Catch: Exception -> L22
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L22
        r104.add(Integers.valueOf(r103.getTagNo()));     // Catch: Exception -> L22
        switch(r103.getTagNo()) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            default: goto L19;
        };     // Catch: Exception -> L22
    L11:
        Object r105 = ASN1ObjectIdentifier.getInstance(r103.getName()).getId();     // Catch: Exception -> L22
    L12:
        r104.add(r105);     // Catch: Exception -> L22
    L17:
        r101.add(r104);     // Catch: Exception -> L22
        goto L7
    L13:
        r104.add(ASN1OctetString.getInstance(r103.getName()).getOctets());     // Catch: Exception -> L22
        goto L17
    L14:
        r105 = X500Name.getInstance(r103.getName()).toString();     // Catch: Exception -> L22
        goto L12
    L15:
        r105 = ((ASN1String) r103.getName()).getString();     // Catch: Exception -> L22
        goto L12
    L16:
        r105 = r103.getName().toASN1Primitive();     // Catch: Exception -> L22
        goto L12
    L19:
        throw new IOException("Bad tag number: " + r103.getTagNo());     // Catch: Exception -> L22
    L21:
        return Collections.unmodifiableCollection(r101);
    L22:
        e = move-exception;
        throw new CertificateParsingException(e.getMessage());
    L4:
        return Collections.EMPTY_LIST;
    }

    public static Collection getIssuerAlternativeNames(X509Certificate r100) throws CertificateParsingException {
        return getAlternativeNames(r100.getExtensionValue(Extension.issuerAlternativeName.getId()));
    }

    public static Collection getSubjectAlternativeNames(X509Certificate r100) throws CertificateParsingException {
        return getAlternativeNames(r100.getExtensionValue(Extension.subjectAlternativeName.getId()));
    }
}
