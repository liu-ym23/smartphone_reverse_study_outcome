package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class KDFDoublePipelineIterationParameters implements DerivationParameters {
    private static final int UNUSED_R = 32;
    private final byte[] fixedInputData;

    /* JADX INFO: renamed from: ki, reason: collision with root package name */
    private final byte[] f525323ki;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f525324r;
    private final boolean useCounter;

    private KDFDoublePipelineIterationParameters(byte[] r100, byte[] r101, int r102, boolean r103) {
        if (r100 == null) goto L22;
        this.f525323ki = Arrays.clone(r100);
        if (r101 != null) goto L7;
        this.fixedInputData = new byte[0];
    L9:
        if (r102 != 8) goto L11;
    L19:
        this.f525324r = r102;
        this.useCounter = r103;
        return;
    L11:
        if (r102 == 16) goto L19;
        if (r102 == 24) goto L19;
        if (r102 == 32) goto L19;
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    L7:
        this.fixedInputData = Arrays.clone(r101);
        goto L9
    L22:
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFDoublePipelineIterationParameters createWithCounter(byte[] r100, byte[] r101, int r102) {
        return new KDFDoublePipelineIterationParameters(r100, r101, r102, true);
    }

    public static KDFDoublePipelineIterationParameters createWithoutCounter(byte[] r100, byte[] r101) {
        return new KDFDoublePipelineIterationParameters(r100, r101, 32, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getKI() {
        return this.f525323ki;
    }

    public int getR() {
        return this.f525324r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
