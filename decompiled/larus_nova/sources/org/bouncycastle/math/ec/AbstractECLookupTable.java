package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractECLookupTable implements ECLookupTable {
    public AbstractECLookupTable() {
    }

    @Override // org.bouncycastle.math.ec.ECLookupTable
    public ECPoint lookupVar(int r100) {
        return lookup(r100);
    }
}
