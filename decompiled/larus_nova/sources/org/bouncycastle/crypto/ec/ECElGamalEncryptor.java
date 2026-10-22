package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes42.dex */
public class ECElGamalEncryptor implements ECEncryptor {
    private ECPublicKeyParameters key;
    private SecureRandom random;

    public ECElGamalEncryptor() {
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.ec.ECEncryptor
    public ECPair encrypt(ECPoint r100) {
        ECPublicKeyParameters r101 = this.key;
        if (r101 == null) goto L7;
        ECDomainParameters r102 = r101.getParameters();
        BigInteger r103 = ECUtil.generateK(r102.getN(), this.random);
        ECPoint[] r104 = {createBasePointMultiplier().multiply(r102.getG(), r103), this.key.getQ().multiply(r103).add(ECAlgorithms.cleanPoint(r102.getCurve(), r100))};
        r102.getCurve().normalizeAll(r104);
        return new ECPair(r104[0], r104[1]);
    L7:
        throw new IllegalStateException("ECElGamalEncryptor not initialised");
    }

    @Override // org.bouncycastle.crypto.ec.ECEncryptor
    public void init(CipherParameters r100) {
        if ((r100 instanceof ParametersWithRandom) == false) goto L10;
        ParametersWithRandom r101 = (ParametersWithRandom) r100;
        if ((r101.getParameters() instanceof ECPublicKeyParameters) == false) goto L8;
        this.key = (ECPublicKeyParameters) r101.getParameters();
        SecureRandom r102 = r101.getRandom();
    L12:
        this.random = r102;
        return;
    L8:
        throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
    L10:
        if ((r100 instanceof ECPublicKeyParameters) == false) goto L15;
        this.key = (ECPublicKeyParameters) r100;
        r102 = CryptoServicesRegistrar.getSecureRandom();
        goto L12
    L15:
        throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
    }
}
