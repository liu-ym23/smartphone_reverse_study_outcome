package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class RSAKeyParameters extends AsymmetricKeyParameter {
    private static final BigInteger ONE = null;
    private static final BigInteger SMALL_PRIMES_PRODUCT = null;
    private BigInteger exponent;
    private BigInteger modulus;

    static {
        SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
        ONE = BigInteger.valueOf(1);
    }

    public RSAKeyParameters(boolean r100, BigInteger r101, BigInteger r102) {
        super(r100);
        if (r100 == false) goto L5;
    L9:
        this.modulus = validate(r101);
        this.exponent = r102;
        return;
    L5:
        if ((r102.intValue() & 1) != 0) goto L9;
        throw new IllegalArgumentException("RSA publicExponent is even");
    }

    private BigInteger validate(BigInteger r100) {
        if ((r100.intValue() & 1) == 0) goto L13;
        if (Properties.isOverrideSet("org.bouncycastle.rsa.allow_unsafe_mod") == false) goto L8;
        return r100;
    L8:
        if (r100.gcd(SMALL_PRIMES_PRODUCT).equals(ONE) == false) goto L11;
        return r100;
    L11:
        throw new IllegalArgumentException("RSA modulus has a small prime factor");
    L13:
        throw new IllegalArgumentException("RSA modulus is even");
    }

    public BigInteger getExponent() {
        return this.exponent;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }
}
