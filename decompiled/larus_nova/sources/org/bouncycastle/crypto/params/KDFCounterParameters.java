package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class KDFCounterParameters implements DerivationParameters {
    private byte[] fixedInputDataCounterPrefix;
    private byte[] fixedInputDataCounterSuffix;

    /* JADX INFO: renamed from: ki, reason: collision with root package name */
    private byte[] f525321ki;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f525322r;

    public KDFCounterParameters(byte[] r100, byte[] r101, int r102) {
        this(r100, null, r101, r102);
    }

    public KDFCounterParameters(byte[] r100, byte[] r101, byte[] r102, int r103) {
        if (r100 == null) goto L25;
        this.f525321ki = Arrays.clone(r100);
        if (r101 != null) goto L7;
        this.fixedInputDataCounterPrefix = new byte[0];
    L8:
        if (r102 != null) goto L10;
        this.fixedInputDataCounterSuffix = new byte[0];
    L12:
        if (r103 != 8) goto L14;
    L22:
        this.f525322r = r103;
        return;
    L14:
        if (r103 == 16) goto L22;
        if (r103 == 24) goto L22;
        if (r103 == 32) goto L22;
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    L10:
        this.fixedInputDataCounterSuffix = Arrays.clone(r102);
        goto L12
    L7:
        this.fixedInputDataCounterPrefix = Arrays.clone(r101);
        goto L8
    L25:
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return Arrays.clone(this.fixedInputDataCounterPrefix);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getKI() {
        return this.f525321ki;
    }

    public int getR() {
        return this.f525322r;
    }
}
