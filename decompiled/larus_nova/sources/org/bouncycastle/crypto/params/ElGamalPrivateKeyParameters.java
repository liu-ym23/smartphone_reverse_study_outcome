package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525312x;

    public ElGamalPrivateKeyParameters(BigInteger r100, ElGamalParameters r101) {
        super(true, r101);
        this.f525312x = r100;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof ElGamalPrivateKeyParameters) == true) goto L6;
        return false;
    L6:
        if (((ElGamalPrivateKeyParameters) r100).getX().equals(this.f525312x) == true) goto L9;
        return false;
    L9:
        return super.equals(r100);
    }

    public BigInteger getX() {
        return this.f525312x;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        return getX().hashCode();
    }
}
