package org.bouncycastle.crypto.params;

import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECDomainParameters implements ECConstants {
    private final ECPoint G;
    private final ECCurve curve;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BigInteger f525305h;
    private BigInteger hInv;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final BigInteger f525306n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters r100) {
        this(r100.getCurve(), r100.getG(), r100.getN(), r100.getH(), r100.getSeed());
    }

    public ECDomainParameters(ECCurve r100, ECPoint r101, BigInteger r102) {
        this(r100, r101, r102, ECConstants.ONE, null);
    }

    public ECDomainParameters(ECCurve r100, ECPoint r101, BigInteger r102, BigInteger r110) {
        this(r100, r101, r102, r110, null);
    }

    public ECDomainParameters(ECCurve r100, ECPoint r101, BigInteger r102, BigInteger r103, byte[] r104) {
        this.hInv = null;
        if (r100 == null) goto L10;
        if (r102 == null) goto L8;
        this.curve = r100;
        this.G = validatePublicPoint(r100, r101);
        this.f525306n = r102;
        this.f525305h = r103;
        this.seed = Arrays.clone(r104);
        return;
    L8:
        throw new NullPointerException(OfficeSDKRequestTag.KEY_NEW_USER);
    L10:
        throw new NullPointerException("curve");
    }

    public static ECPoint validatePublicPoint(ECCurve r100, ECPoint r101) {
        if (r101 == null) goto L13;
        ECPoint r102 = ECAlgorithms.importPoint(r100, r101).normalize();
        if (r102.isInfinity() == true) goto L11;
        if (r102.isValid() == false) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException("Point not on curve");
    L11:
        throw new IllegalArgumentException("Point at infinity");
    L13:
        throw new NullPointerException("Point cannot be null");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ECDomainParameters) == true) goto L8;
        return false;
    L8:
        ECDomainParameters r101 = (ECDomainParameters) r100;
        if (this.curve.equals(r101.curve) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.G.equals(r101.G) == false) goto L15;
        if (this.f525306n.equals(r101.f525306n) == false) goto L15;
        return true;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.f525305h;
    }

    public synchronized BigInteger getHInv() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.hInv != null) goto L6;
        this.hInv = BigIntegers.modOddInverseVar(this.f525306n, this.f525305h);     // Catch: Throwable -> L9
    L6:
        BigInteger r100 = this.hInv;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public BigInteger getN() {
        return this.f525306n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        return ((((this.curve.hashCode() ^ 1028) * 257) ^ this.G.hashCode()) * 257) ^ this.f525306n.hashCode();
    }

    public BigInteger validatePrivateScalar(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.compareTo(ECConstants.ONE) < 0) goto L9;
        if (r100.compareTo(getN()) >= 0) goto L9;
        return r100;
    L9:
        throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
    L11:
        throw new NullPointerException("Scalar cannot be null");
    }

    public ECPoint validatePublicPoint(ECPoint r100) {
        return validatePublicPoint(getCurve(), r100);
    }
}
