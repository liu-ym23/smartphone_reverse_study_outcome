package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class DHPrivateKeyParameters extends DHKeyParameters {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525296x;

    public DHPrivateKeyParameters(BigInteger r100, DHParameters r101) {
        super(true, r101);
        this.f525296x = r100;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof DHPrivateKeyParameters) == true) goto L6;
        return false;
    L6:
        if (((DHPrivateKeyParameters) r100).getX().equals(this.f525296x) == true) goto L8;
        return false;
    L8:
        if (super.equals(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public BigInteger getX() {
        return this.f525296x;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.f525296x.hashCode() ^ super.hashCode();
    }
}
