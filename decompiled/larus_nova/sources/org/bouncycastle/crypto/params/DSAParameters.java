package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DSAParameters implements CipherParameters {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525300g;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525302q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger r100, BigInteger r101, BigInteger r102) {
        this.f525300g = r102;
        this.f525301p = r100;
        this.f525302q = r101;
    }

    public DSAParameters(BigInteger r100, BigInteger r101, BigInteger r102, DSAValidationParameters r103) {
        this.f525300g = r102;
        this.f525301p = r100;
        this.f525302q = r101;
        this.validation = r103;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSAParameters) == true) goto L5;
        return false;
    L5:
        DSAParameters r101 = (DSAParameters) r100;
        if (r101.getP().equals(this.f525301p) == true) goto L8;
        return false;
    L8:
        if (r101.getQ().equals(this.f525302q) == true) goto L10;
        return false;
    L10:
        if (r101.getG().equals(this.f525300g) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getG() {
        return this.f525300g;
    }

    public BigInteger getP() {
        return this.f525301p;
    }

    public BigInteger getQ() {
        return this.f525302q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
