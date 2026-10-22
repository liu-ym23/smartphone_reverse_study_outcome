package org.bouncycastle.asn1.ua;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145Params extends ASN1Object {
    private static final byte[] DEFAULT_DKE = null;
    private byte[] dke;
    private DSTU4145ECBinary ecbinary;
    private ASN1ObjectIdentifier namedCurve;

    static {
        DEFAULT_DKE = new byte[]{-87, -42, -21, 69, -15, 60, 112, -126, ByteCompanionObject.MIN_VALUE, -60, -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, -64, 55, 41, 29, 56, -39, 107, -16, 37, -54, 78, 23, -8, -23, 114, HTTP.CR, -58, 21, -76, 58, 40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 100, -22, 44, 23, -97, -48, 18, 62, 109, -72, -6, -59, 121, 4};
    }

    public DSTU4145Params(ASN1ObjectIdentifier r100) {
        this.dke = DEFAULT_DKE;
        this.namedCurve = r100;
    }

    public DSTU4145Params(ASN1ObjectIdentifier r100, byte[] r101) {
        this.dke = DEFAULT_DKE;
        this.namedCurve = r100;
        this.dke = Arrays.clone(r101);
    }

    public DSTU4145Params(DSTU4145ECBinary r100) {
        this.dke = DEFAULT_DKE;
        this.ecbinary = r100;
    }

    public static byte[] getDefaultDKE() {
        return Arrays.clone(DEFAULT_DKE);
    }

    public static DSTU4145Params getInstance(Object r100) {
        if ((r100 instanceof DSTU4145Params) == false) goto L7;
        return (DSTU4145Params) r100;
    L7:
        if (r100 == null) goto L21;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100);
        if ((r101.getObjectAt(0) instanceof ASN1ObjectIdentifier) == false) goto L11;
        DSTU4145Params r102 = new DSTU4145Params(ASN1ObjectIdentifier.getInstance(r101.getObjectAt(0)));
    L13:
        if (r101.size() != 2) goto L19;
        byte[] r103 = ASN1OctetString.getInstance(r101.getObjectAt(1)).getOctets();
        r102.dke = r103;
        if (r103.length == DEFAULT_DKE.length) goto L19;
        throw new IllegalArgumentException("object parse error");
    L19:
        return r102;
    L11:
        r102 = new DSTU4145Params(DSTU4145ECBinary.getInstance(r101.getObjectAt(0)));
        goto L13
    L21:
        throw new IllegalArgumentException("object parse error");
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }

    public DSTU4145ECBinary getECBinary() {
        return this.ecbinary;
    }

    public ASN1ObjectIdentifier getNamedCurve() {
        return this.namedCurve;
    }

    public boolean isNamedCurve() {
        if (this.namedCurve == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1Encodable r101 = this.namedCurve;
        if (r101 != null) goto L6;
        r101 = this.ecbinary;
    L6:
        r100.add(r101);
        if (Arrays.areEqual(this.dke, DEFAULT_DKE) == true) goto L10;
        r100.add(new DEROctetString(this.dke));
    L10:
        return new DERSequence(r100);
    }
}
