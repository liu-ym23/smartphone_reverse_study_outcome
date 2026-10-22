package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
class SimpleBigDecimal {
    private static final long serialVersionUID = 1;
    private final BigInteger bigInt;
    private final int scale;

    public SimpleBigDecimal(BigInteger r100, int r101) {
        if (r101 < 0) goto L7;
        this.bigInt = r100;
        this.scale = r101;
        return;
    L7:
        throw new IllegalArgumentException("scale may not be negative");
    }

    private void checkScale(SimpleBigDecimal r100) {
        if (this.scale != r100.scale) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public static SimpleBigDecimal getInstance(BigInteger r100, int r101) {
        return new SimpleBigDecimal(r100.shiftLeft(r101), r101);
    }

    public SimpleBigDecimal add(BigInteger r100) {
        return new SimpleBigDecimal(this.bigInt.add(r100.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal add(SimpleBigDecimal r100) {
        checkScale(r100);
        return new SimpleBigDecimal(this.bigInt.add(r100.bigInt), this.scale);
    }

    public SimpleBigDecimal adjustScale(int r100) {
        if (r100 < 0) goto L9;
        int r101 = this.scale;
        if (r100 != r101) goto L7;
        return this;
    L7:
        return new SimpleBigDecimal(this.bigInt.shiftLeft(r100 - r101), r100);
    L9:
        throw new IllegalArgumentException("scale may not be negative");
    }

    public int compareTo(BigInteger r100) {
        return this.bigInt.compareTo(r100.shiftLeft(this.scale));
    }

    public int compareTo(SimpleBigDecimal r100) {
        checkScale(r100);
        return this.bigInt.compareTo(r100.bigInt);
    }

    public SimpleBigDecimal divide(BigInteger r100) {
        return new SimpleBigDecimal(this.bigInt.divide(r100), this.scale);
    }

    public SimpleBigDecimal divide(SimpleBigDecimal r100) {
        checkScale(r100);
        return new SimpleBigDecimal(this.bigInt.shiftLeft(this.scale).divide(r100.bigInt), this.scale);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SimpleBigDecimal) == true) goto L8;
        return false;
    L8:
        SimpleBigDecimal r101 = (SimpleBigDecimal) r100;
        if (this.bigInt.equals(r101.bigInt) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.scale != r101.scale) goto L13;
        return true;
    }

    public BigInteger floor() {
        return this.bigInt.shiftRight(this.scale);
    }

    public int getScale() {
        return this.scale;
    }

    public int hashCode() {
        return this.bigInt.hashCode() ^ this.scale;
    }

    public int intValue() {
        return floor().intValue();
    }

    public long longValue() {
        return floor().longValue();
    }

    public SimpleBigDecimal multiply(BigInteger r100) {
        return new SimpleBigDecimal(this.bigInt.multiply(r100), this.scale);
    }

    public SimpleBigDecimal multiply(SimpleBigDecimal r100) {
        checkScale(r100);
        BigInteger r101 = this.bigInt.multiply(r100.bigInt);
        int r102 = this.scale;
        return new SimpleBigDecimal(r101, r102 + r102);
    }

    public SimpleBigDecimal negate() {
        return new SimpleBigDecimal(this.bigInt.negate(), this.scale);
    }

    public BigInteger round() {
        return add(new SimpleBigDecimal(ECConstants.ONE, 1).adjustScale(this.scale)).floor();
    }

    public SimpleBigDecimal shiftLeft(int r100) {
        return new SimpleBigDecimal(this.bigInt.shiftLeft(r100), this.scale);
    }

    public SimpleBigDecimal subtract(BigInteger r100) {
        return new SimpleBigDecimal(this.bigInt.subtract(r100.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal r100) {
        return add(r100.negate());
    }

    public String toString() {
        if (this.scale == 0) goto L5;
        BigInteger r100 = floor();
        BigInteger r101 = this.bigInt.subtract(r100.shiftLeft(this.scale));
        if (this.bigInt.signum() != (-1)) goto L10;
        r101 = ECConstants.ONE.shiftLeft(this.scale).subtract(r101);
    L10:
        if (r100.signum() == (-1)) goto L12;
    L14:
        String r102 = r100.toString();
        char[] r103 = new char[this.scale];
        String r104 = r101.toString(2);
        int r105 = r104.length();
        int r106 = this.scale - r105;
        int r107 = 0;
        int r108 = 0;
    L15:
        if (r108 >= r106) goto L17;
        r103[r108] = '0';
        r108 = r108 + 1;
    L17:
        if (r107 >= r105) goto L19;
        r103[r106 + r107] = r104.charAt(r107);
        r107 = r107 + 1;
        goto L17
    L19:
        String r109 = new String(r103);
        StringBuffer r110 = new StringBuffer(r102);
        r110.append(".");
        r110.append(r109);
        return r110.toString();
    L12:
        if (r101.equals(ECConstants.ZERO) == true) goto L14;
        r100 = r100.add(ECConstants.ONE);
        goto L14
    L5:
        return this.bigInt.toString();
    }
}
