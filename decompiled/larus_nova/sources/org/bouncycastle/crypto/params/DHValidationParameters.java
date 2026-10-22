package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DHValidationParameters {
    private int counter;
    private byte[] seed;

    public DHValidationParameters(byte[] r100, int r101) {
        this.seed = Arrays.clone(r100);
        this.counter = r101;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DHValidationParameters) == true) goto L5;
        return false;
    L5:
        DHValidationParameters r101 = (DHValidationParameters) r100;
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

    public int hashCode() {
        return this.counter ^ Arrays.hashCode(this.seed);
    }
}
