package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    private ElGamalParameters params;

    public ElGamalKeyParameters(boolean r100, ElGamalParameters r101) {
        super(r100);
        this.params = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ElGamalKeyParameters) == true) goto L5;
        return false;
    L5:
        ElGamalParameters r101 = this.params;
        ElGamalParameters r102 = ((ElGamalKeyParameters) r100).getParameters();
        if (r101 != null) goto L11;
        if (r102 != null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return r101.equals(r102);
    }

    public ElGamalParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        ElGamalParameters r100 = this.params;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }
}
