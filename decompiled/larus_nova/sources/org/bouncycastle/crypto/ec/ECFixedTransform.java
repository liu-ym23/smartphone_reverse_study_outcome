package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes42.dex */
public class ECFixedTransform implements ECPairFactorTransform {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BigInteger f525151k;
    private ECPublicKeyParameters key;

    public ECFixedTransform(BigInteger r100) {
        this.f525151k = r100;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.ec.ECPairFactorTransform
    public BigInteger getTransformValue() {
        return this.f525151k;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters r100) {
        if ((r100 instanceof ECPublicKeyParameters) == false) goto L7;
        this.key = (ECPublicKeyParameters) r100;
        return;
    L7:
        throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public ECPair transform(ECPair r100) {
        ECPublicKeyParameters r101 = this.key;
        if (r101 == null) goto L7;
        ECDomainParameters r102 = r101.getParameters();
        BigInteger r103 = r102.getN();
        ECMultiplier r104 = createBasePointMultiplier();
        BigInteger r105 = this.f525151k.mod(r103);
        ECPoint[] r106 = {r104.multiply(r102.getG(), r105).add(ECAlgorithms.cleanPoint(r102.getCurve(), r100.getX())), this.key.getQ().multiply(r105).add(ECAlgorithms.cleanPoint(r102.getCurve(), r100.getY()))};
        r102.getCurve().normalizeAll(r106);
        return new ECPair(r106[0], r106[1]);
    L7:
        throw new IllegalStateException("ECFixedTransform not initialised");
    }
}
