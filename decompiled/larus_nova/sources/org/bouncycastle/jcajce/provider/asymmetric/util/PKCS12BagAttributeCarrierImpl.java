package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes42.dex */
public class PKCS12BagAttributeCarrierImpl implements PKCS12BagAttributeCarrier {
    private Hashtable pkcs12Attributes;
    private Vector pkcs12Ordering;

    public PKCS12BagAttributeCarrierImpl() {
        this(new Hashtable(), new Vector());
    }

    public PKCS12BagAttributeCarrierImpl(Hashtable r100, Vector r101) {
        this.pkcs12Attributes = r100;
        this.pkcs12Ordering = r101;
    }

    public Hashtable getAttributes() {
        return this.pkcs12Attributes;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r100) {
        return (ASN1Encodable) this.pkcs12Attributes.get(r100);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.pkcs12Ordering.elements();
    }

    public Vector getOrdering() {
        return this.pkcs12Ordering;
    }

    public void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        Object r101 = r100.readObject();
        if ((r101 instanceof Hashtable) == false) goto L5;
        this.pkcs12Attributes = (Hashtable) r101;
        this.pkcs12Ordering = (Vector) r100.readObject();
        return;
    L5:
        ASN1InputStream r102 = new ASN1InputStream((byte[]) r101);
    L6:
        ASN1ObjectIdentifier r103 = (ASN1ObjectIdentifier) r102.readObject();
        if (r103 == null) goto L11;
        setBagAttribute(r103, r102.readObject());
        goto L6
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        if (this.pkcs12Attributes.containsKey(r100) == false) goto L5;
        this.pkcs12Attributes.put(r100, r101);
        return;
    L5:
        this.pkcs12Attributes.put(r100, r101);
        this.pkcs12Ordering.addElement(r100);
    }

    public int size() {
        return this.pkcs12Ordering.size();
    }

    public void writeObject(ObjectOutputStream r100) throws IOException {
        if (this.pkcs12Ordering.size() != 0) goto L5;
        r100.writeObject(new Hashtable());
        r100.writeObject(new Vector());
        return;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        ASN1OutputStream r102 = ASN1OutputStream.create(r101);
        Enumeration r103 = getBagAttributeKeys();
    L7:
        if (r103.hasMoreElements() == false) goto L9;
        ASN1ObjectIdentifier r104 = ASN1ObjectIdentifier.getInstance(r103.nextElement());
        r102.writeObject(r104);
        r102.writeObject((ASN1Encodable) this.pkcs12Attributes.get(r104));
        goto L7
    L9:
        r100.writeObject(r101.toByteArray());
    }
}
