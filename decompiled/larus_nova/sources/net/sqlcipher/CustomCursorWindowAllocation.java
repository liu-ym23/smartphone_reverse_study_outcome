package net.sqlcipher;

/* JADX INFO: loaded from: classes42.dex */
public class CustomCursorWindowAllocation implements CursorWindowAllocation {
    private long growthPaddingSize;
    private long initialAllocationSize;
    private long maxAllocationSize;

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.growthPaddingSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.maxAllocationSize;
    }

    public CustomCursorWindowAllocation(long r100, long r101, long r102) {
        this.initialAllocationSize = r100;
        this.growthPaddingSize = r101;
        this.maxAllocationSize = r102;
    }
}
