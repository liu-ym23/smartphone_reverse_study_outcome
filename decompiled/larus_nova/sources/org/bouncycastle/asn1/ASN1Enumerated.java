package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1Enumerated extends ASN1Primitive {
    private static ASN1Enumerated[] cache;
    private final byte[] bytes;
    private final int start;

    static {
        cache = new ASN1Enumerated[12];
    }

    public ASN1Enumerated(int r100) {
        if (r100 < 0) goto L7;
        this.bytes = BigInteger.valueOf(r100).toByteArray();
        this.start = 0;
        return;
    L7:
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(BigInteger r100) {
        if (r100.signum() < 0) goto L7;
        this.bytes = r100.toByteArray();
        this.start = 0;
        return;
    L7:
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(byte[] r100) {
        if (ASN1Integer.isMalformed(r100) == true) goto L11;
        if ((r100[0] & ByteCompanionObject.MIN_VALUE) != 0) goto L9;
        this.bytes = Arrays.clone(r100);
        this.start = ASN1Integer.signBytesToSkip(r100);
        return;
    L9:
        throw new IllegalArgumentException("enumerated must be non-negative");
    L11:
        throw new IllegalArgumentException("malformed enumerated");
    }

    public static ASN1Enumerated fromOctetString(byte[] r100) {
        if (r100.length <= 1) goto L7;
        return new ASN1Enumerated(r100);
    L7:
        if (r100.length == 0) goto L17;
        int r101 = r100[0] & UByte.MAX_VALUE;
        ASN1Enumerated[] r102 = cache;
        if (r101 >= r102.length) goto L11;
        ASN1Enumerated r103 = r102[r101];
        if (r103 != null) goto L18;
        ASN1Enumerated r104 = new ASN1Enumerated(r100);
        r102[r101] = r104;
        return r104;
    L18:
        return r103;
    L11:
        return new ASN1Enumerated(r100);
    L17:
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    public static ASN1Enumerated getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1Enumerated) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (ASN1Enumerated) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1Enumerated) r100;
    }

    public static ASN1Enumerated getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1Enumerated) == true) goto L10;
        return fromOctetString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Enumerated) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.bytes, ((ASN1Enumerated) r100).bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 10, this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (StreamUtil.calculateBodyLength(this.bytes.length) + 1) + this.bytes.length;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(BigInteger r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (ASN1Integer.intValue(this.bytes, this.start, -1) != r100.intValue()) goto L8;
        if (getValue().equals(r100) == false) goto L8;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intValueExact() {
        byte[] r100 = this.bytes;
        int r101 = r100.length;
        int r102 = this.start;
        if ((r101 - r102) > 4) goto L7;
        return ASN1Integer.intValue(r100, r102, -1);
    L7:
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
