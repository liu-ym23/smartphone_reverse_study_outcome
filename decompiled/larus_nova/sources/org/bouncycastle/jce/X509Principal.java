package org.bouncycastle.jce;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

/* JADX INFO: loaded from: classes42.dex */
public class X509Principal extends X509Name implements Principal {
    public X509Principal(String r100) {
        super(r100);
    }

    public X509Principal(Hashtable r100) {
        super(r100);
    }

    public X509Principal(Vector r100, Hashtable r101) {
        super(r100, r101);
    }

    public X509Principal(Vector r100, Vector r101) {
        super(r100, r101);
    }

    public X509Principal(X500Name r100) {
        super((ASN1Sequence) r100.toASN1Primitive());
    }

    public X509Principal(X509Name r100) {
        super((ASN1Sequence) r100.toASN1Primitive());
    }

    public X509Principal(boolean r100, String r101) {
        super(r100, r101);
    }

    public X509Principal(boolean r100, Hashtable r101, String r102) {
        super(r100, r101, r102);
    }

    public X509Principal(byte[] r100) throws IOException {
        super(readSequence(new ASN1InputStream(r100)));
    }

    private static ASN1Sequence readSequence(ASN1InputStream r100) throws IOException {
        return ASN1Sequence.getInstance(r100.readObject());
    L4:
        e = move-exception;
        throw new IOException("not an ASN.1 Sequence: " + e);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return getEncoded(ASN1Encoding.DER);
    L4:
        e = move-exception;
        throw new RuntimeException(e.toString());
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }
}
