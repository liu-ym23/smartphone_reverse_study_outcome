package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(String r100) {
        super(r100);
    }

    public DERGeneralizedTime(Date r100) {
        super(r100);
    }

    public DERGeneralizedTime(byte[] r100) {
        super(r100);
    }

    private byte[] getDERTime() {
        byte[] r100 = this.time;
        if (r100[r100.length - 1] == 90) goto L5;
        return r100;
    L5:
        if (hasMinutes() == true) goto L9;
        byte[] r101 = this.time;
        byte[] r102 = new byte[r101.length + 4];
        System.arraycopy(r101, 0, r102, 0, r101.length - 1);
        System.arraycopy(Strings.toByteArray("0000Z"), 0, r102, this.time.length - 1, 5);
        return r102;
    L9:
        if (hasSeconds() == true) goto L13;
        byte[] r103 = this.time;
        byte[] r104 = new byte[r103.length + 2];
        System.arraycopy(r103, 0, r104, 0, r103.length - 1);
        System.arraycopy(Strings.toByteArray("00Z"), 0, r104, this.time.length - 1, 3);
        return r104;
    L13:
        if (hasFractionalSeconds() == false) goto L26;
        int r105 = this.time.length - 2;
    L15:
        if (r105 <= 0) goto L19;
        if (this.time[r105] != 48) goto L19;
        r105 = r105 - 1;
    L19:
        byte[] r106 = this.time;
        if (r106[r105] != 46) goto L23;
        byte[] r107 = new byte[r105 + 1];
        System.arraycopy(r106, 0, r107, 0, r105);
        r107[r105] = 90;
        return r107;
    L23:
        byte[] r108 = new byte[r105 + 2];
        int r109 = r105 + 1;
        System.arraycopy(r106, 0, r108, 0, r109);
        r108[r109] = 90;
        return r108;
    L26:
        return this.time;
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 24, getDERTime());
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int r100 = getDERTime().length;
        return (StreamUtil.calculateBodyLength(r100) + 1) + r100;
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1GeneralizedTime, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
