package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.security.SignatureException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureSpiLe extends SignatureSpi {
    public SignatureSpiLe() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi, java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] r100 = ASN1OctetString.getInstance(super.engineSign()).getOctets();
        reverseBytes(r100);
        return new DEROctetString(r100).getEncoded();
    L5:
        e = move-exception;
        throw new SignatureException(e.toString());
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi, java.security.SignatureSpi
    public boolean engineVerify(byte[] r100) throws SignatureException {
        byte[] r101 = ((ASN1OctetString) ASN1Primitive.fromByteArray(r100)).getOctets();     // Catch: IOException -> L11
        reverseBytes(r101);
        return super.engineVerify(new DEROctetString(r101).getEncoded());
    L9:
        e = move-exception;
        throw e;
    L6:
        e = move-exception;
        throw new SignatureException(e.toString());
    L12:
        throw new SignatureException("error decoding signature bytes.");
    }

    public void reverseBytes(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= (r100.length / 2)) goto L6;
        byte r102 = r100[r101];
        r100[r101] = r100[(r100.length - 1) - r101];
        r100[(r100.length - 1) - r101] = r102;
        r101 = r101 + 1;
        goto L4
    }
}
