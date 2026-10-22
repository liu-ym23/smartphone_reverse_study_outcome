package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSAValidationParameters {
    private int counter;
    private byte[] seed;
    private int usageIndex;

    public DSAValidationParameters(byte[] r100, int r101) {
        this(r100, r101, -1);
    }

    public DSAValidationParameters(byte[] r100, int r101, int r102) {
        this.seed = Arrays.clone(r100);
        this.counter = r101;
        this.usageIndex = r102;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSAValidationParameters) == true) goto L5;
        return false;
    L5:
        DSAValidationParameters r101 = (DSAValidationParameters) r100;
        if (r101.counter == this.counter) goto L9;
        return false;
    L9:
        return Arrays.areEqual(this.seed, r101.seed);
    }

    public int getCounter() {
        return this.counter;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public int hashCode() {
        return this.counter ^ Arrays.hashCode(this.seed);
    }
}
