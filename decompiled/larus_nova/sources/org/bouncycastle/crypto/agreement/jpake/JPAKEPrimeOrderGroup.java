package org.bouncycastle.crypto.agreement.jpake;

import com.amap.api.col.s.ce;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKEPrimeOrderGroup {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BigInteger f525112g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final BigInteger f525113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final BigInteger f525114q;

    public JPAKEPrimeOrderGroup(BigInteger r100, BigInteger r101, BigInteger r102) {
        this(r100, r101, r102, false);
    }

    public JPAKEPrimeOrderGroup(BigInteger r100, BigInteger r101, BigInteger r102, boolean r103) {
        JPAKEUtil.validateNotNull(r100, "p");
        JPAKEUtil.validateNotNull(r101, "q");
        JPAKEUtil.validateNotNull(r102, ce.f26391f);
        if (r103 == true) goto L27;
        BigInteger r104 = JPAKEUtil.ONE;
        if (r100.subtract(r104).mod(r101).equals(JPAKEUtil.ZERO) == false) goto L26;
        if (r102.compareTo(BigInteger.valueOf(2)) == (-1)) goto L24;
        if (r102.compareTo(r100.subtract(r104)) == 1) goto L24;
        if (r102.modPow(r101, r100).equals(r104) == false) goto L22;
        if (r100.isProbablePrime(20) == false) goto L20;
        if (r101.isProbablePrime(20) == true) goto L27;
        throw new IllegalArgumentException("q must be prime");
    L20:
        throw new IllegalArgumentException("p must be prime");
    L22:
        throw new IllegalArgumentException("g^q mod p must equal 1");
    L24:
        throw new IllegalArgumentException("g must be in [2, p-1]");
    L26:
        throw new IllegalArgumentException("p-1 must be evenly divisible by q");
    L27:
        this.f525113p = r100;
        this.f525114q = r101;
        this.f525112g = r102;
    }

    public BigInteger getG() {
        return this.f525112g;
    }

    public BigInteger getP() {
        return this.f525113p;
    }

    public BigInteger getQ() {
        return this.f525114q;
    }
}
