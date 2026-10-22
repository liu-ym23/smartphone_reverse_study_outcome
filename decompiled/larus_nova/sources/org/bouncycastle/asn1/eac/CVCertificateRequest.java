package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CVCertificateRequest extends ASN1Object {
    private static final int bodyValid = 1;
    private static final int signValid = 2;
    private CertificateBody certificateBody;
    private byte[] innerSignature;
    private final ASN1ApplicationSpecific original;
    private byte[] outerSignature;

    private CVCertificateRequest(ASN1ApplicationSpecific r100) throws IOException {
        this.innerSignature = null;
        this.outerSignature = null;
        this.original = r100;
        if (r100.isConstructed() == true) goto L5;
    L7:
        initCertBody(r100);
        return;
    L5:
        if (r100.getApplicationTag() != 7) goto L7;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100.getObject(16));
        initCertBody(ASN1ApplicationSpecific.getInstance(r101.getObjectAt(0)));
        this.outerSignature = ASN1ApplicationSpecific.getInstance(r101.getObjectAt(r101.size() - 1)).getContents();
    }

    public static CVCertificateRequest getInstance(Object r100) {
        if ((r100 instanceof CVCertificateRequest) == true) goto L5;
        if (r100 != null) goto L14;
        return null;
    L14:
        return new CVCertificateRequest(ASN1ApplicationSpecific.getInstance(r100));
    L9:
        e = move-exception;
        throw new ASN1ParsingException("unable to parse data: " + e.getMessage(), e);
    L5:
        return (CVCertificateRequest) r100;
    }

    private void initCertBody(ASN1ApplicationSpecific r100) throws IOException {
        if (r100.getApplicationTag() != 33) goto L21;
        Enumeration r101 = ASN1Sequence.getInstance(r100.getObject(16)).getObjects();
        int r102 = 0;
    L6:
        if (r101.hasMoreElements() == false) goto L16;
        ASN1ApplicationSpecific r103 = ASN1ApplicationSpecific.getInstance(r101.nextElement());
        int r104 = r103.getApplicationTag();
        if (r104 != 55) goto L10;
        this.innerSignature = r103.getContents();
        r102 = r102 | 2;
        goto L6
    L10:
        if (r104 != 78) goto L13;
        this.certificateBody = CertificateBody.getInstance(r103);
        r102 = r102 | 1;
        goto L6
    L13:
        throw new IOException("Invalid tag, not an CV Certificate Request element:" + r103.getApplicationTag());
    L16:
        if ((r102 & 3) == 0) goto L19;
        return;
    L19:
        throw new IOException("Invalid CARDHOLDER_CERTIFICATE in request:" + r100.getApplicationTag());
    L21:
        throw new IOException("not a CARDHOLDER_CERTIFICATE in request:" + r100.getApplicationTag());
    }

    public CertificateBody getCertificateBody() {
        return this.certificateBody;
    }

    public byte[] getInnerSignature() {
        return Arrays.clone(this.innerSignature);
    }

    public byte[] getOuterSignature() {
        return Arrays.clone(this.outerSignature);
    }

    public PublicKeyDataObject getPublicKey() {
        return this.certificateBody.getPublicKey();
    }

    public boolean hasOuterSignature() {
        if (this.outerSignature == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1ApplicationSpecific r100 = this.original;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ASN1EncodableVector r101 = new ASN1EncodableVector(2);
        r101.add(this.certificateBody);
        r101.add(new DERApplicationSpecific(false, 55, new DEROctetString(this.innerSignature)));     // Catch: IOException -> L9
        return new DERApplicationSpecific(33, r101);
    L10:
        throw new IllegalStateException("unable to convert signature!");
    }
}
