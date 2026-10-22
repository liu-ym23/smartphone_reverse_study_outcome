package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class X509ExtensionsGenerator {
    private Vector extOrdering;
    private Hashtable extensions;

    public X509ExtensionsGenerator() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }

    public void addExtension(ASN1ObjectIdentifier r100, boolean r101, ASN1Encodable r102) {
        addExtension(r100, r101, r102.toASN1Primitive().getEncoded(ASN1Encoding.DER));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalArgumentException("error encoding value: " + e);
    }

    public void addExtension(ASN1ObjectIdentifier r100, boolean r101, byte[] r102) {
        if (this.extensions.containsKey(r100) == true) goto L7;
        this.extOrdering.addElement(r100);
        this.extensions.put(r100, new X509Extension(r101, new DEROctetString(r102)));
        return;
    L7:
        throw new IllegalArgumentException("extension " + r100 + " already added");
    }

    public X509Extensions generate() {
        return new X509Extensions(this.extOrdering, this.extensions);
    }

    public boolean isEmpty() {
        return this.extOrdering.isEmpty();
    }

    public void reset() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }
}
