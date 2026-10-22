package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525313y;

    public ElGamalPublicKeyParameters(BigInteger r100, ElGamalParameters r101) {
        super(false, r101);
        this.f525313y = r100;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof ElGamalPublicKeyParameters) == true) goto L6;
        return false;
    L6:
        if (((ElGamalPublicKeyParameters) r100).getY().equals(this.f525313y) == true) goto L8;
        return false;
    L8:
        if (super.equals(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getY() {
        return this.f525313y;
    }

    @Override // org.bouncycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        return this.f525313y.hashCode() ^ super.hashCode();
    }
}
