package com.larus.dora.impl.ota.g2;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private final boolean bound;
    private final boolean deleteAfterTerminal;
    private final boolean unboundTombstone;

    public d() {
        boolean r100 = false;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.bound == r101.bound) goto L12;
        return false;
    L12:
        if (this.unboundTombstone == r101.unboundTombstone) goto L15;
        return false;
    L15:
        if (this.deleteAfterTerminal == r101.deleteAfterTerminal) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.bound == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.unboundTombstone == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.deleteAfterTerminal == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BindingState(bound=" + this.bound + ", unboundTombstone=" + this.unboundTombstone + ", deleteAfterTerminal=" + this.deleteAfterTerminal + ')';
    }

    public final boolean a() {
        return this.bound;
    }

    public final boolean b() {
        return this.deleteAfterTerminal;
    }

    public final boolean c() {
        return this.unboundTombstone;
    }

    public /* synthetic */ d(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101, false);
    }

    public d(boolean r100, boolean r101, boolean r102) {
        this.bound = r100;
        this.unboundTombstone = r101;
        this.deleteAfterTerminal = r102;
    }
}
