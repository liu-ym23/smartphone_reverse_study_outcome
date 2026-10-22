package net.sqlcipher;

/* JADX INFO: loaded from: classes42.dex */
public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long WindowAllocationUnbounded;
    private long initialAllocationSize;

    public DefaultCursorWindowAllocation() {
        this.initialAllocationSize = 1048576;
        this.WindowAllocationUnbounded = 0;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
