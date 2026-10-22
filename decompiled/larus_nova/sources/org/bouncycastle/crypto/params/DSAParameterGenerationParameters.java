package org.bouncycastle.crypto.params;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f525298l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f525299n;
    private final SecureRandom random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int r100, int r101, int r102, SecureRandom r110) {
        this(r100, r101, r102, r110, -1);
    }

    public DSAParameterGenerationParameters(int r100, int r101, int r102, SecureRandom r103, int r104) {
        this.f525298l = r100;
        this.f525299n = r101;
        this.certainty = r102;
        this.usageIndex = r104;
        this.random = r103;
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getL() {
        return this.f525298l;
    }

    public int getN() {
        return this.f525299n;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }
}
