package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class BERApplicationSpecific extends ASN1ApplicationSpecific {
    public BERApplicationSpecific(int r100, ASN1Encodable r101) throws IOException {
        this(true, r100, r101);
    }

    public BERApplicationSpecific(int r100, ASN1EncodableVector r101) {
        super(true, r100, getEncodedVector(r101));
    }

    public BERApplicationSpecific(boolean r100, int r101, ASN1Encodable r102) throws IOException {
        if (r100 == false) goto L4;
    L7:
        boolean r103 = true;
    L8:
        super(r103, r101, getEncoding(r100, r102));
        return;
    L4:
        if (r102.toASN1Primitive().isConstructed() == true) goto L7;
        r103 = false;
        goto L8
    }

    public BERApplicationSpecific(boolean r100, int r101, byte[] r102) {
        super(r100, r101, r102);
    }

    private static byte[] getEncodedVector(ASN1EncodableVector r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        int r102 = 0;
    L4:
        if (r102 == r100.size()) goto L11;
        r101.write(((ASN1Object) r100.get(r102)).getEncoded(ASN1Encoding.BER));     // Catch: IOException -> L7
        r102 = r102 + 1;
    L7:
        e = move-exception;
        throw new ASN1ParsingException("malformed object: " + e, e);
    L11:
        return r101.toByteArray();
    }

    private static byte[] getEncoding(boolean r100, ASN1Encodable r101) throws IOException {
        byte[] r102 = r101.toASN1Primitive().getEncoded(ASN1Encoding.BER);
        if (r100 == false) goto L5;
        return r102;
    L5:
        int r103 = ASN1ApplicationSpecific.getLengthOfHeader(r102);
        int r104 = r102.length - r103;
        byte[] r105 = new byte[r104];
        System.arraycopy(r102, r103, r105, 0, r104);
        return r105;
    }

    @Override // org.bouncycastle.asn1.ASN1ApplicationSpecific, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        if (this.isConstructed == false) goto L5;
        int r102 = 96;
    L6:
        r100.writeEncodedIndef(r101, r102, this.tag, this.octets);
        return;
    L5:
        r102 = 64;
        goto L6
    }
}
