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
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
    private int fieldPoly;
    private boolean initialized;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525557m;
    private McElieceKeyGenerationParameters mcElieceParams;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525558n;
    private SecureRandom random;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525559t;

    public McElieceKeyPairGenerator() {
        this.initialized = false;
    }

    private AsymmetricCipherKeyPair genKeyPair() {
        if (this.initialized == true) goto L5;
        initializeDefault();
    L5:
        GF2mField r100 = new GF2mField(this.f525557m, this.fieldPoly);
        PolynomialGF2mSmallM r101 = new PolynomialGF2mSmallM(r100, this.f525559t, 'I', this.random);
        new PolynomialRingGF2m(r100, r101).getSquareRootMatrix();
        GoppaCode.MaMaPe r102 = GoppaCode.computeSystematicForm(GoppaCode.createCanonicalCheckMatrix(r100, r101), this.random);
        GF2Matrix r103 = r102.getSecondMatrix();
        Permutation r104 = r102.getPermutation();
        GF2Matrix r105 = (GF2Matrix) r103.computeTranspose();
        GF2Matrix r106 = r105.extendLeftCompactForm();
        int r107 = r105.getNumRows();
        GF2Matrix[] r108 = GF2Matrix.createRandomRegularMatrixAndItsInverse(r107, this.random);
        Permutation r109 = new Permutation(this.f525558n, this.random);
        GF2Matrix r110 = (GF2Matrix) ((GF2Matrix) r108[0].rightMultiply(r106)).rightMultiply(r109);
        return new AsymmetricCipherKeyPair(new McEliecePublicKeyParameters(this.f525558n, this.f525559t, r110), new McEliecePrivateKeyParameters(this.f525558n, r107, r100, r101, r104, r109, r108[1]));
    }

    private void initialize(KeyGenerationParameters r100) {
        this.mcElieceParams = (McElieceKeyGenerationParameters) r100;
        this.random = r100.getRandom();
        this.f525557m = this.mcElieceParams.getParameters().getM();
        this.f525558n = this.mcElieceParams.getParameters().getN();
        this.f525559t = this.mcElieceParams.getParameters().getT();
        this.fieldPoly = this.mcElieceParams.getParameters().getFieldPoly();
        this.initialized = true;
    }

    private void initializeDefault() {
        initialize(new McElieceKeyGenerationParameters(null, new McElieceParameters()));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        initialize(r100);
    }
}
