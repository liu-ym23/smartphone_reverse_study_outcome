package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X509NameEntryConverter {
    public X509NameEntryConverter() {
    }

    public boolean canBePrintable(String r100) {
        return DERPrintableString.isPrintableString(r100);
    }

    public ASN1Primitive convertHexEncoded(String r100, int r101) throws IOException {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(r100, r101, r100.length() - r101));
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier r100, String r101);
}
