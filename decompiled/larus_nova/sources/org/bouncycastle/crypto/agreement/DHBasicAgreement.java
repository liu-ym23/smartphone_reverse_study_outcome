package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* JADX INFO: loaded from: classes42.dex */
public class DHBasicAgreement implements BasicAgreement {
    private static final BigInteger ONE = null;
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public DHBasicAgreement() {
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters r100) {
        DHPublicKeyParameters r101 = (DHPublicKeyParameters) r100;
        if (r101.getParameters().equals(this.dhParams) == false) goto L18;
        BigInteger r102 = this.dhParams.getP();
        BigInteger r103 = r101.getY();
        if (r103 == null) goto L16;
        BigInteger r104 = ONE;
        if (r103.compareTo(r104) <= 0) goto L16;
        if (r103.compareTo(r102.subtract(r104)) >= 0) goto L16;
        BigInteger r105 = r103.modPow(this.key.getX(), r102);
        if (r105.equals(r104) == true) goto L14;
        return r105;
    L14:
        throw new IllegalStateException("Shared key can't be 1");
    L16:
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    L18:
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.key.getParameters().getP().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters r100) {
        if ((r100 instanceof ParametersWithRandom) == false) goto L5;
        r100 = ((ParametersWithRandom) r100).getParameters();
    L5:
        AsymmetricKeyParameter r101 = (AsymmetricKeyParameter) r100;
        if ((r101 instanceof DHPrivateKeyParameters) == false) goto L10;
        DHPrivateKeyParameters r102 = (DHPrivateKeyParameters) r101;
        this.key = r102;
        this.dhParams = r102.getParameters();
        return;
    L10:
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }
}
