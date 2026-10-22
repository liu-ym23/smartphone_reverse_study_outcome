package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public class DHPublicKeyParameters extends DHKeyParameters {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525297y;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DHPublicKeyParameters(BigInteger r100, DHParameters r101) {
        super(false, r101);
        this.f525297y = validate(r100, r101);
    }

    private static int legendre(BigInteger r100, BigInteger r101) {
        int r102 = r101.bitLength();
        int[] r103 = Nat.fromBigInteger(r102, r100);
        int[] r104 = Nat.fromBigInteger(r102, r101);
        int r105 = r104.length;
        int r106 = 0;
    L3:
        int r107 = r103[0];
        if (r107 == 0) goto L5;
        int r108 = Integers.numberOfTrailingZeros(r107);
        if (r108 <= 0) goto L9;
        Nat.shiftDownBits(r105, r103, r108, 0);
        int r109 = r104[0];
        r106 = r106 ^ ((r108 << 1) & (r109 ^ (r109 >>> 1)));
    L9:
        int r110 = Nat.compare(r105, r103, r104);
        if (r110 == 0) goto L12;
        if (r110 >= 0) goto L17;
        r106 = r106 ^ (r103[0] & r104[0]);
        int[] r111 = r104;
        r104 = r103;
        r103 = r111;
    L17:
        int r112 = r105 - 1;
        if (r103[r112] != 0) goto L20;
        r105 = r112;
        goto L17
    L20:
        Nat.sub(r105, r103, r104, r103);
        goto L3
    L12:
        if (Nat.isOne(r105, r104) == true) goto L14;
        return 0;
    L14:
        return 1 - (r106 & 2);
    L5:
        Nat.shiftDownWord(r105, r103, 0);
        goto L3
    }

    private BigInteger validate(BigInteger r100, DHParameters r101) {
        if (r100 == null) goto L27;
        BigInteger r102 = r101.getP();
        BigInteger r103 = TWO;
        if (r100.compareTo(r103) < 0) goto L25;
        if (r100.compareTo(r102.subtract(r103)) > 0) goto L25;
        BigInteger r104 = r101.getQ();
        if (r104 != null) goto L11;
        return r100;
    L11:
        if (r102.testBit(0) == false) goto L20;
        if ((r102.bitLength() - 1) != r104.bitLength()) goto L20;
        if (r102.shiftRight(1).equals(r104) == false) goto L20;
        if (1 != legendre(r100, r102)) goto L23;
        return r100;
    L23:
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
    L20:
        if (ONE.equals(r100.modPow(r104, r102)) == false) goto L23;
        return r100;
    L25:
        throw new IllegalArgumentException("invalid DH public key");
    L27:
        throw new NullPointerException("y value cannot be null");
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof DHPublicKeyParameters) == true) goto L6;
        return false;
    L6:
        if (((DHPublicKeyParameters) r100).getY().equals(this.f525297y) == true) goto L8;
        return false;
    L8:
        if (super.equals(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getY() {
        return this.f525297y;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.f525297y.hashCode() ^ super.hashCode();
    }
}
