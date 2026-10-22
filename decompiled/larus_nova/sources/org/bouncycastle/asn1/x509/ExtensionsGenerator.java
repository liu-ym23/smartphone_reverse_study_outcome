package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class ExtensionsGenerator {
    private Vector extOrdering;
    private Hashtable extensions;

    public ExtensionsGenerator() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }

    public void addExtension(ASN1ObjectIdentifier r100, boolean r101, ASN1Encodable r102) throws IOException {
        addExtension(r100, r101, r102.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public void addExtension(ASN1ObjectIdentifier r100, boolean r101, byte[] r102) {
        if (this.extensions.containsKey(r100) == true) goto L7;
        this.extOrdering.addElement(r100);
        this.extensions.put(r100, new Extension(r100, r101, new DEROctetString(r102)));
        return;
    L7:
        throw new IllegalArgumentException("extension " + r100 + " already added");
    }

    public void addExtension(Extension r100) {
        if (this.extensions.containsKey(r100.getExtnId()) == true) goto L7;
        this.extOrdering.addElement(r100.getExtnId());
        this.extensions.put(r100.getExtnId(), r100);
        return;
    L7:
        throw new IllegalArgumentException("extension " + r100.getExtnId() + " already added");
    }

    public Extensions generate() {
        Extension[] r100 = new Extension[this.extOrdering.size()];
        int r101 = 0;
    L4:
        if (r101 == this.extOrdering.size()) goto L7;
        r100[r101] = (Extension) this.extensions.get(this.extOrdering.elementAt(r101));
        r101 = r101 + 1;
        goto L4
    L7:
        return new Extensions(r100);
    }

    public Extension getExtension(ASN1ObjectIdentifier r100) {
        return (Extension) this.extensions.get(r100);
    }

    public boolean hasExtension(ASN1ObjectIdentifier r100) {
        return this.extensions.containsKey(r100);
    }

    public boolean isEmpty() {
        return this.extOrdering.isEmpty();
    }

    public void removeExtension(ASN1ObjectIdentifier r100) {
        if (this.extensions.containsKey(r100) == false) goto L7;
        this.extOrdering.removeElement(r100);
        this.extensions.remove(r100);
        return;
    L7:
        throw new IllegalArgumentException("extension " + r100 + " not present");
    }

    public void replaceExtension(ASN1ObjectIdentifier r100, boolean r101, ASN1Encodable r102) throws IOException {
        replaceExtension(r100, r101, r102.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public void replaceExtension(ASN1ObjectIdentifier r100, boolean r101, byte[] r102) {
        replaceExtension(new Extension(r100, r101, r102));
    }

    public void replaceExtension(Extension r100) {
        if (this.extensions.containsKey(r100.getExtnId()) == false) goto L7;
        this.extensions.put(r100.getExtnId(), r100);
        return;
    L7:
        throw new IllegalArgumentException("extension " + r100.getExtnId() + " not present");
    }

    public void reset() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }
}
