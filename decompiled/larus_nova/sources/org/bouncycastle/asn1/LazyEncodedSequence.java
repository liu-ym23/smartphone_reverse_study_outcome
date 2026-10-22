package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
class LazyEncodedSequence extends ASN1Sequence {
    private byte[] encoded;

    public LazyEncodedSequence(byte[] r100) throws IOException {
        this.encoded = r100;
    }

    private void force() {
        if (this.encoded == null) goto L11;
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        LazyConstructionEnumeration r101 = new LazyConstructionEnumeration(this.encoded);
    L6:
        if (r101.hasMoreElements() == false) goto L8;
        r100.add((ASN1Primitive) r101.nextElement());
        goto L6
    L8:
        this.elements = r100.takeElements();
        this.encoded = null;
        return;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    public synchronized void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        monitor-enter(this);
        byte[] r102 = this.encoded;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r100.writeEncoded(r101, 48, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        super.toDLObject().encode(r100, r101);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public synchronized int encodedLength() throws IOException {
        monitor-enter(this);
        byte[] r100 = this.encoded;     // Catch: Throwable -> L12
        if (r100 != null) goto L6;
        int r101 = super.toDLObject().encodedLength();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L6:
        int r102 = (StreamUtil.calculateBodyLength(r100.length) + 1) + this.encoded.length;
        monitor-exit(this);
        return r102;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public synchronized ASN1Encodable getObjectAt(int r100) {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        ASN1Encodable r101 = super.getObjectAt(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public synchronized Enumeration getObjects() {
        monitor-enter(this);
        byte[] r100 = this.encoded;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        LazyConstructionEnumeration r101 = new LazyConstructionEnumeration(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        Enumeration r102 = super.getObjects();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public synchronized int hashCode() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        int r100 = super.hashCode();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.util.Iterable, java.lang.Iterable
    public synchronized Iterator<ASN1Encodable> iterator() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        Iterator<ASN1Encodable> r100 = super.iterator();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public synchronized int size() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        int r100 = super.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public synchronized ASN1Encodable[] toArray() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        ASN1Encodable[] r100 = super.toArray();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public ASN1Encodable[] toArrayInternal() {
        force();
        return super.toArrayInternal();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    public synchronized ASN1Primitive toDERObject() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        ASN1Primitive r100 = super.toDERObject();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    public synchronized ASN1Primitive toDLObject() {
        monitor-enter(this);
        force();     // Catch: Throwable -> L6
        ASN1Primitive r100 = super.toDLObject();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }
}
