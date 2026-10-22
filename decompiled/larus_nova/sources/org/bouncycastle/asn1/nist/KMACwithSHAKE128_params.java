package org.bouncycastle.asn1.nist;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class KMACwithSHAKE128_params extends ASN1Object {
    private static final int DEF_LENGTH = 256;
    private static final byte[] EMPTY_STRING = null;
    private final byte[] customizationString;
    private final int outputLength;

    static {
        EMPTY_STRING = new byte[0];
    }

    public KMACwithSHAKE128_params(int r100) {
        this.outputLength = r100;
        this.customizationString = EMPTY_STRING;
    }

    public KMACwithSHAKE128_params(int r100, byte[] r101) {
        this.outputLength = r100;
        this.customizationString = Arrays.clone(r101);
    }

    private KMACwithSHAKE128_params(ASN1Sequence r100) {
        if (r100.size() > 2) goto L16;
        if (r100.size() != 2) goto L8;
        this.outputLength = ASN1Integer.getInstance(r100.getObjectAt(0)).intValueExact();
        this.customizationString = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets());
        return;
    L8:
        if (r100.size() == 1) goto L10;
        this.outputLength = 256;
        this.customizationString = EMPTY_STRING;
        return;
    L10:
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L12;
        this.outputLength = ASN1Integer.getInstance(r100.getObjectAt(0)).intValueExact();
        this.customizationString = EMPTY_STRING;
        return;
    L12:
        this.outputLength = 256;
        this.customizationString = Arrays.clone(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        return;
    L16:
        throw new IllegalArgumentException("sequence size greater than 2");
    }

    public static KMACwithSHAKE128_params getInstance(Object r100) {
        if ((r100 instanceof KMACwithSHAKE128_params) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KMACwithSHAKE128_params(ASN1Sequence.getInstance(r100));
    L5:
        return (KMACwithSHAKE128_params) r100;
    }

    public byte[] getCustomizationString() {
        return Arrays.clone(this.customizationString);
    }

    public int getOutputLength() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        int r101 = this.outputLength;
        if (r101 == 256) goto L6;
        r100.add(new ASN1Integer(r101));
    L6:
        if (this.customizationString.length == 0) goto L9;
        r100.add(new DEROctetString(getCustomizationString()));
    L9:
        return new DERSequence(r100);
    }
}
