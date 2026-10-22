package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public final class KDFFeedbackParameters implements DerivationParameters {
    private static final int UNUSED_R = -1;
    private final byte[] fixedInputData;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private final byte[] f525325iv;

    /* JADX INFO: renamed from: ki, reason: collision with root package name */
    private final byte[] f525326ki;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f525327r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] r100, byte[] r101, byte[] r102, int r103, boolean r104) {
        if (r100 == null) goto L15;
        this.f525326ki = Arrays.clone(r100);
        if (r102 != null) goto L7;
        this.fixedInputData = new byte[0];
    L8:
        this.f525327r = r103;
        if (r101 != null) goto L11;
        this.f525325iv = new byte[0];
    L12:
        this.useCounter = r104;
        return;
    L11:
        this.f525325iv = Arrays.clone(r101);
        goto L12
    L7:
        this.fixedInputData = Arrays.clone(r102);
        goto L8
    L15:
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFFeedbackParameters createWithCounter(byte[] r100, byte[] r101, byte[] r102, int r110) {
        if (r110 == 8) goto L14;
        if (r110 == 16) goto L14;
        if (r110 == 24) goto L14;
        if (r110 == 32) goto L14;
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    L14:
        return new KDFFeedbackParameters(r100, r101, r102, r110, true);
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] r100, byte[] r101, byte[] r102) {
        return new KDFFeedbackParameters(r100, r101, r102, -1, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getIV() {
        return this.f525325iv;
    }

    public byte[] getKI() {
        return this.f525326ki;
    }

    public int getR() {
        return this.f525327r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
