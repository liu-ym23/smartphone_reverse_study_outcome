package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECElGamalDecryptor implements ECDecryptor {
    private ECPrivateKeyParameters key;

    public ECElGamalDecryptor() {
    }

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public ECPoint decrypt(ECPair r100) {
        ECPrivateKeyParameters r101 = this.key;
        if (r101 == null) goto L7;
        ECCurve r102 = r101.getParameters().getCurve();
        ECPoint r103 = ECAlgorithms.cleanPoint(r102, r100.getX()).multiply(this.key.getD());
        return ECAlgorithms.cleanPoint(r102, r100.getY()).subtract(r103).normalize();
    L7:
        throw new IllegalStateException("ECElGamalDecryptor not initialised");
    }

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public void init(CipherParameters r100) {
        if ((r100 instanceof ECPrivateKeyParameters) == false) goto L7;
        this.key = (ECPrivateKeyParameters) r100;
        return;
    L7:
        throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
    }
}
