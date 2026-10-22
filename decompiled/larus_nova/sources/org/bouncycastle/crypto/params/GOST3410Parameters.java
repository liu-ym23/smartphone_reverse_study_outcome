package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410Parameters implements CipherParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f525314a;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525316q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger r100, BigInteger r101, BigInteger r102) {
        this.f525315p = r100;
        this.f525316q = r101;
        this.f525314a = r102;
    }

    public GOST3410Parameters(BigInteger r100, BigInteger r101, BigInteger r102, GOST3410ValidationParameters r103) {
        this.f525314a = r102;
        this.f525315p = r100;
        this.f525316q = r101;
        this.validation = r103;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GOST3410Parameters) == true) goto L5;
        return false;
    L5:
        GOST3410Parameters r101 = (GOST3410Parameters) r100;
        if (r101.getP().equals(this.f525315p) == true) goto L8;
        return false;
    L8:
        if (r101.getQ().equals(this.f525316q) == true) goto L10;
        return false;
    L10:
        if (r101.getA().equals(this.f525314a) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getA() {
        return this.f525314a;
    }

    public BigInteger getP() {
        return this.f525315p;
    }

    public BigInteger getQ() {
        return this.f525316q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f525315p.hashCode() ^ this.f525316q.hashCode()) ^ this.f525314a.hashCode();
    }
}
