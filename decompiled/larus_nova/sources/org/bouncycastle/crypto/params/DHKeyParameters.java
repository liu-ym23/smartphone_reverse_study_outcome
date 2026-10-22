package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    public DHKeyParameters(boolean r100, DHParameters r101) {
        super(r100);
        this.params = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DHKeyParameters) == true) goto L5;
        return false;
    L5:
        DHParameters r101 = this.params;
        DHParameters r102 = ((DHKeyParameters) r100).getParameters();
        if (r101 != null) goto L11;
        if (r102 != null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return r101.equals(r102);
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        int r100 = !isPrivate() ? 1 : 0;
        DHParameters r101 = this.params;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 ^ r101.hashCode();
    }
}
