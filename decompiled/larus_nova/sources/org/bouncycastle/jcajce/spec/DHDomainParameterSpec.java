package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DHDomainParameterSpec extends DHParameterSpec {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BigInteger f525385j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f525386m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final BigInteger f525387q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(BigInteger r100, BigInteger r101, BigInteger r102) {
        this(r100, r101, r102, null, 0);
    }

    public DHDomainParameterSpec(BigInteger r100, BigInteger r101, BigInteger r102, int r110) {
        this(r100, r101, r102, null, r110);
    }

    public DHDomainParameterSpec(BigInteger r100, BigInteger r101, BigInteger r110, BigInteger r111, int r112) {
        this(r100, r101, r110, r111, 0, r112);
    }

    public DHDomainParameterSpec(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103, int r104, int r105) {
        super(r100, r102, r105);
        this.f525387q = r101;
        this.f525385j = r103;
        this.f525386m = r104;
    }

    public DHDomainParameterSpec(DHParameters r100) {
        this(r100.getP(), r100.getQ(), r100.getG(), r100.getJ(), r100.getM(), r100.getL());
        this.validationParameters = r100.getValidationParameters();
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.f525387q, this.f525386m, getL(), this.f525385j, this.validationParameters);
    }

    public BigInteger getJ() {
        return this.f525385j;
    }

    public int getM() {
        return this.f525386m;
    }

    public BigInteger getQ() {
        return this.f525387q;
    }
}
