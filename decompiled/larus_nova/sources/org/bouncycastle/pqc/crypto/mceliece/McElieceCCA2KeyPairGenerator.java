package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2";
    private int fieldPoly;
    private boolean initialized;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525540m;
    private McElieceCCA2KeyGenerationParameters mcElieceCCA2Params;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525541n;
    private SecureRandom random;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525542t;

    public McElieceCCA2KeyPairGenerator() {
        this.initialized = false;
    }

    private void initializeDefault() {
        init(new McElieceCCA2KeyGenerationParameters(null, new McElieceCCA2Parameters()));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        if (this.initialized == true) goto L5;
        initializeDefault();
    L5:
        GF2mField r100 = new GF2mField(this.f525540m, this.fieldPoly);
        PolynomialGF2mSmallM r101 = new PolynomialGF2mSmallM(r100, this.f525542t, 'I', this.random);
        GoppaCode.MaMaPe r102 = GoppaCode.computeSystematicForm(GoppaCode.createCanonicalCheckMatrix(r100, r101), this.random);
        GF2Matrix r103 = r102.getSecondMatrix();
        Permutation r104 = r102.getPermutation();
        GF2Matrix r105 = (GF2Matrix) r103.computeTranspose();
        int r106 = r105.getNumRows();
        return new AsymmetricCipherKeyPair(new McElieceCCA2PublicKeyParameters(this.f525541n, this.f525542t, r105, this.mcElieceCCA2Params.getParameters().getDigest()), new McElieceCCA2PrivateKeyParameters(this.f525541n, r106, r100, r101, r104, this.mcElieceCCA2Params.getParameters().getDigest()));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.mcElieceCCA2Params = (McElieceCCA2KeyGenerationParameters) r100;
        this.random = r100.getRandom();
        this.f525540m = this.mcElieceCCA2Params.getParameters().getM();
        this.f525541n = this.mcElieceCCA2Params.getParameters().getN();
        this.f525542t = this.mcElieceCCA2Params.getParameters().getT();
        this.fieldPoly = this.mcElieceCCA2Params.getParameters().getFieldPoly();
        this.initialized = true;
    }
}
