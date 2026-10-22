package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525290g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BigInteger f525291j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f525292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525293m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525294p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525295q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger r100, BigInteger r101) {
        this(r100, r101, null, 0);
    }

    public DHParameters(BigInteger r100, BigInteger r101, BigInteger r102) {
        this(r100, r101, r102, 0);
    }

    public DHParameters(BigInteger r100, BigInteger r110, BigInteger r111, int r112) {
        this(r100, r110, r111, getDefaultMParam(r112), r112, null, null);
    }

    public DHParameters(BigInteger r100, BigInteger r110, BigInteger r111, int r112, int r113) {
        this(r100, r110, r111, r112, r113, null, null);
    }

    public DHParameters(BigInteger r100, BigInteger r101, BigInteger r102, int r103, int r104, BigInteger r105, DHValidationParameters r106) {
        if (r104 == 0) goto L13;
        if (r104 > r100.bitLength()) goto L11;
        if (r104 >= r103) goto L13;
        throw new IllegalArgumentException("when l value specified, it may not be less than m value");
    L11:
        throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
    L13:
        if (r103 > r100.bitLength()) goto L15;
    L19:
        this.f525290g = r101;
        this.f525294p = r100;
        this.f525295q = r102;
        this.f525293m = r103;
        this.f525292l = r104;
        this.f525291j = r105;
        this.validation = r106;
        return;
    L15:
        if (Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value") == true) goto L19;
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public DHParameters(BigInteger r100, BigInteger r110, BigInteger r111, BigInteger r112, DHValidationParameters r113) {
        this(r100, r110, r111, 160, 0, r112, r113);
    }

    private static int getDefaultMParam(int r100) {
        if (r100 != 0) goto L5;
        return 160;
    L5:
        if (r100 < 160) goto L9;
        return 160;
    L9:
        return r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DHParameters) == true) goto L5;
        return false;
    L5:
        DHParameters r101 = (DHParameters) r100;
        if (getQ() == null) goto L11;
        if (getQ().equals(r101.getQ()) == true) goto L14;
        return false;
    L14:
        if (r101.getP().equals(this.f525294p) == true) goto L16;
        return false;
    L16:
        if (r101.getG().equals(this.f525290g) == false) goto L20;
        return true;
    L20:
        return false;
    L11:
        if (r101.getQ() == null) goto L14;
        return false;
    }

    public BigInteger getG() {
        return this.f525290g;
    }

    public BigInteger getJ() {
        return this.f525291j;
    }

    public int getL() {
        return this.f525292l;
    }

    public int getM() {
        return this.f525293m;
    }

    public BigInteger getP() {
        return this.f525294p;
    }

    public BigInteger getQ() {
        return this.f525295q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        int r100 = getP().hashCode() ^ getG().hashCode();
        if (getQ() == null) goto L5;
        int r101 = getQ().hashCode();
    L7:
        return r100 ^ r101;
    L5:
        r101 = 0;
        goto L7
    }
}
