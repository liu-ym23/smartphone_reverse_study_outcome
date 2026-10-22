package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    private CramerShoupParameters params;

    public CramerShoupKeyParameters(boolean r100, CramerShoupParameters r101) {
        super(r100);
        this.params = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CramerShoupKeyParameters) == true) goto L5;
        return false;
    L5:
        CramerShoupParameters r101 = this.params;
        CramerShoupParameters r102 = ((CramerShoupKeyParameters) r100).getParameters();
        if (r101 != null) goto L11;
        if (r102 != null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return r101.equals(r102);
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        int r100 = !isPrivate() ? 1 : 0;
        CramerShoupParameters r101 = this.params;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 ^ r101.hashCode();
    }
}
