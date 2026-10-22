package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class FixedPointPreCompInfo implements PreCompInfo {
    protected ECLookupTable lookupTable;
    protected ECPoint offset;
    protected int width;

    public FixedPointPreCompInfo() {
        this.offset = null;
        this.lookupTable = null;
        this.width = -1;
    }

    public ECLookupTable getLookupTable() {
        return this.lookupTable;
    }

    public ECPoint getOffset() {
        return this.offset;
    }

    public int getWidth() {
        return this.width;
    }

    public void setLookupTable(ECLookupTable r100) {
        this.lookupTable = r100;
    }

    public void setOffset(ECPoint r100) {
        this.offset = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
