package org.bouncycastle.pqc.crypto.qtesla;

/* JADX INFO: loaded from: classes42.dex */
final class IntSlicer {
    private int base;
    private final int[] values;

    public IntSlicer(int[] r100, int r101) {
        this.values = r100;
        this.base = r101;
    }

    public final int at(int r100) {
        return this.values[this.base + r100];
    }

    public final int at(int r100, int r101) {
        this.values[this.base + r100] = r101;
        return r101;
    }

    public final int at(int r100, long r101) {
        int[] r102 = this.values;
        int r103 = this.base + r100;
        int r104 = (int) r101;
        r102[r103] = r104;
        return r104;
    }

    public final IntSlicer copy() {
        return new IntSlicer(this.values, this.base);
    }

    public final IntSlicer from(int r100) {
        return new IntSlicer(this.values, this.base + r100);
    }

    public final void incBase(int r100) {
        this.base += r100;
    }
}
