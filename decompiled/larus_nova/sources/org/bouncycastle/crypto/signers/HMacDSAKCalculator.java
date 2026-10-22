package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class HMacDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = null;
    private final byte[] K;
    private final byte[] V;
    private final HMac hMac;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BigInteger f525342n;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public HMacDSAKCalculator(Digest r100) {
        HMac r101 = new HMac(r100);
        this.hMac = r101;
        this.V = new byte[r101.getMacSize()];
        this.K = new byte[r101.getMacSize()];
    }

    private BigInteger bitsToInt(byte[] r100) {
        BigInteger r101 = new BigInteger(1, r100);
        if ((r100.length * 8) > this.f525342n.bitLength()) goto L5;
        return r101;
    L5:
        return r101.shiftRight((r100.length * 8) - this.f525342n.bitLength());
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger r100, BigInteger r101, byte[] r102) {
        this.f525342n = r100;
        Arrays.fill(this.V, (byte) 1);
        Arrays.fill(this.K, (byte) 0);
        int r103 = BigIntegers.getUnsignedByteLength(r100);
        byte[] r104 = new byte[r103];
        byte[] r105 = BigIntegers.asUnsignedByteArray(r101);
        System.arraycopy(r105, 0, r104, r103 - r105.length, r105.length);
        byte[] r106 = new byte[r103];
        BigInteger r107 = bitsToInt(r102);
        if (r107.compareTo(r100) < 0) goto L5;
        r107 = r107.subtract(r100);
    L5:
        byte[] r108 = BigIntegers.asUnsignedByteArray(r107);
        System.arraycopy(r108, 0, r106, r103 - r108.length, r108.length);
        this.hMac.init(new KeyParameter(this.K));
        HMac r109 = this.hMac;
        byte[] r110 = this.V;
        r109.update(r110, 0, r110.length);
        this.hMac.update((byte) 0);
        this.hMac.update(r104, 0, r103);
        this.hMac.update(r106, 0, r103);
        this.hMac.doFinal(this.K, 0);
        this.hMac.init(new KeyParameter(this.K));
        HMac r111 = this.hMac;
        byte[] r112 = this.V;
        r111.update(r112, 0, r112.length);
        this.hMac.doFinal(this.V, 0);
        HMac r113 = this.hMac;
        byte[] r114 = this.V;
        r113.update(r114, 0, r114.length);
        this.hMac.update((byte) 1);
        this.hMac.update(r104, 0, r103);
        this.hMac.update(r106, 0, r103);
        this.hMac.doFinal(this.K, 0);
        this.hMac.init(new KeyParameter(this.K));
        HMac r115 = this.hMac;
        byte[] r116 = this.V;
        r115.update(r116, 0, r116.length);
        this.hMac.doFinal(this.V, 0);
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public void init(BigInteger r100, SecureRandom r101) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public boolean isDeterministic() {
        return true;
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    public BigInteger nextK() {
        int r100 = BigIntegers.getUnsignedByteLength(this.f525342n);
        byte[] r101 = new byte[r100];
    L3:
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L6;
        HMac r103 = this.hMac;
        byte[] r104 = this.V;
        r103.update(r104, 0, r104.length);
        this.hMac.doFinal(this.V, 0);
        int r105 = Math.min(r100 - r102, this.V.length);
        System.arraycopy(this.V, 0, r101, r102, r105);
        r102 = r102 + r105;
        goto L4
    L6:
        BigInteger r106 = bitsToInt(r101);
        if (r106.compareTo(ZERO) <= 0) goto L11;
        if (r106.compareTo(this.f525342n) >= 0) goto L11;
        return r106;
    L11:
        HMac r107 = this.hMac;
        byte[] r108 = this.V;
        r107.update(r108, 0, r108.length);
        this.hMac.update((byte) 0);
        this.hMac.doFinal(this.K, 0);
        this.hMac.init(new KeyParameter(this.K));
        HMac r109 = this.hMac;
        byte[] r110 = this.V;
        r109.update(r110, 0, r110.length);
        this.hMac.doFinal(this.V, 0);
        goto L3
    }
}
