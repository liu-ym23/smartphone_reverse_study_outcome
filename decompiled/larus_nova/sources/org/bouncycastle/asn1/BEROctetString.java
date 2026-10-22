package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes42.dex */
public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_CHUNK_SIZE = 1000;
    private final int chunkSize;
    private final ASN1OctetString[] octs;

    public BEROctetString(byte[] r100) {
        this(r100, 1000);
    }

    public BEROctetString(byte[] r100, int r101) {
        this(r100, null, r101);
    }

    private BEROctetString(byte[] r100, ASN1OctetString[] r101, int r102) {
        super(r100);
        this.octs = r101;
        this.chunkSize = r102;
    }

    public BEROctetString(ASN1OctetString[] r100) {
        this(r100, 1000);
    }

    public BEROctetString(ASN1OctetString[] r100, int r101) {
        this(toBytes(r100), r100, r101);
    }

    public static /* synthetic */ int access$000(BEROctetString r100) {
        return r100.chunkSize;
    }

    public static /* synthetic */ ASN1OctetString[] access$100(BEROctetString r100) {
        return r100.octs;
    }

    public static BEROctetString fromSequence(ASN1Sequence r100) {
        int r101 = r100.size();
        ASN1OctetString[] r102 = new ASN1OctetString[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        r102[r103] = ASN1OctetString.getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L6:
        return new BEROctetString(r102);
    }

    private static byte[] toBytes(ASN1OctetString[] r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L11;
        r101.write(r100[r102].getOctets());     // Catch: IOException -> L7
        r102 = r102 + 1;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("exception converting octets " + e.toString());
    L11:
        return r101.toByteArray();
    }

    @Override // org.bouncycastle.asn1.ASN1OctetString, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncodedIndef(r101, 36, getObjects());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        Enumeration r100 = getObjects();
        int r101 = 0;
    L4:
        if (r100.hasMoreElements() == false) goto L7;
        r101 = r101 + ((ASN1Encodable) r100.nextElement()).toASN1Primitive().encodedLength();
        goto L4
    L7:
        return (r101 + 2) + 2;
    }

    public Enumeration getObjects() {
        if (this.octs != null) goto L7;
        return new AnonymousClass1(this);
    L7:
        return new AnonymousClass2(this);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }
}
