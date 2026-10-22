package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1Integer extends ASN1Primitive {
    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 255;
    private final byte[] bytes;
    private final int start;

    public ASN1Integer(long r100) {
        this.bytes = BigInteger.valueOf(r100).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger r100) {
        this.bytes = r100.toByteArray();
        this.start = 0;
    }

    public ASN1Integer(byte[] r100) {
        this(r100, true);
    }

    public ASN1Integer(byte[] r100, boolean r101) {
        if (isMalformed(r100) == true) goto L10;
        if (r101 == false) goto L6;
        byte[] r102 = Arrays.clone(r100);
    L7:
        this.bytes = r102;
        this.start = signBytesToSkip(r100);
        return;
    L6:
        r102 = r100;
        goto L7
    L10:
        throw new IllegalArgumentException("malformed integer");
    }

    public static ASN1Integer getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1Integer) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (ASN1Integer) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1Integer) r100;
    }

    public static ASN1Integer getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1Integer) == true) goto L10;
        return new ASN1Integer(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    public static int intValue(byte[] r100, int r101, int r102) {
        int r103 = r100.length;
        int r104 = Math.max(r101, r103 - 4);
        int r105 = r102 & r100[r104];
    L3:
        r104 = r104 + 1;
        if (r104 >= r103) goto L6;
        r105 = (r105 << 8) | (r100[r104] & 255);
        goto L3
    L6:
        return r105;
    }

    public static boolean isMalformed(byte[] r100) {
        int r101 = r100.length;
        if (r101 != 0) goto L5;
        return true;
    L5:
        if (r101 != 1) goto L7;
        return false;
    L7:
        if (r100[0] == (r100[1] >> 7)) goto L9;
    L11:
        return false;
    L9:
        if (Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer") == true) goto L11;
        return true;
    }

    public static long longValue(byte[] r100, int r101, int r102) {
        int r103 = r100.length;
        int r104 = Math.max(r101, r103 - 8);
        long r105 = r102 & r100[r104];
    L3:
        r104 = r104 + 1;
        if (r104 >= r103) goto L6;
        r105 = (r105 << 8) | ((long) (r100[r104] & UByte.MAX_VALUE));
        goto L3
    L6:
        return r105;
    }

    public static int signBytesToSkip(byte[] r100) {
        int r101 = r100.length - 1;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L7;
        int r103 = r102 + 1;
        if (r100[r102] != (r100[r103] >> 7)) goto L7;
        r102 = r103;
    L7:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Integer) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.bytes, ((ASN1Integer) r100).bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 2, this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (StreamUtil.calculateBodyLength(this.bytes.length) + 1) + this.bytes.length;
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(BigInteger r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (intValue(this.bytes, this.start, -1) != r100.intValue()) goto L8;
        if (getValue().equals(r100) == false) goto L8;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intPositiveValueExact() {
        byte[] r100 = this.bytes;
        int r101 = r100.length;
        int r102 = this.start;
        int r103 = r101 - r102;
        if (r103 > 4) goto L10;
        if (r103 != 4) goto L8;
        if ((r100[r102] & ByteCompanionObject.MIN_VALUE) != 0) goto L10;
    L8:
        return intValue(r100, r102, 255);
    L10:
        throw new ArithmeticException("ASN.1 Integer out of positive int range");
    }

    public int intValueExact() {
        byte[] r100 = this.bytes;
        int r101 = r100.length;
        int r102 = this.start;
        if ((r101 - r102) > 4) goto L7;
        return intValue(r100, r102, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public long longValueExact() {
        byte[] r100 = this.bytes;
        int r101 = r100.length;
        int r102 = this.start;
        if ((r101 - r102) > 8) goto L7;
        return longValue(r100, r102, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }
}
