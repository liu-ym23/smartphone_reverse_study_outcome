package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class SimpleLookupTable extends AbstractECLookupTable {
    private final ECPoint[] points;

    public SimpleLookupTable(ECPoint[] r100, int r101, int r102) {
        this.points = copy(r100, r101, r102);
    }

    private static ECPoint[] copy(ECPoint[] r100, int r101, int r102) {
        ECPoint[] r103 = new ECPoint[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = r100[r101 + r104];
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    @Override // org.bouncycastle.math.ec.ECLookupTable
    public int getSize() {
        return this.points.length;
    }

    @Override // org.bouncycastle.math.ec.ECLookupTable
    public ECPoint lookup(int r100) {
        throw new UnsupportedOperationException("Constant-time lookup not supported");
    }

    @Override // org.bouncycastle.math.ec.AbstractECLookupTable, org.bouncycastle.math.ec.ECLookupTable
    public ECPoint lookupVar(int r100) {
        return this.points[r100];
    }
}
