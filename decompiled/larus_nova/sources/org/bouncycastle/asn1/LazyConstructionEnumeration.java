package org.bouncycastle.asn1;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes42.dex */
class LazyConstructionEnumeration implements Enumeration {
    private ASN1InputStream aIn;
    private Object nextObj;

    public LazyConstructionEnumeration(byte[] r100) {
        this.aIn = new ASN1InputStream(r100, true);
        this.nextObj = readObject();
    }

    private Object readObject() {
        return this.aIn.readObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException("malformed DER construction: " + e, e);
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        if (this.nextObj == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object r100 = this.nextObj;
        if (r100 == null) goto L7;
        this.nextObj = readObject();
        return r100;
    L7:
        throw new NoSuchElementException();
    }
}
