package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowParameters implements CipherParameters {
    private final int[] DEFAULT_VI;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525585vi;

    public RainbowParameters() {
        int[] r100 = {6, 12, 17, 22, 33};
        this.DEFAULT_VI = r100;
        this.f525585vi = r100;
    }

    public RainbowParameters(int[] r100) {
        this.DEFAULT_VI = new int[]{6, 12, 17, 22, 33};
        this.f525585vi = r100;
        checkParams();
    }

    private void checkParams() {
        int[] r100 = this.f525585vi;
        if (r100 == null) goto L18;
        if (r100.length <= 1) goto L16;
        int r101 = 0;
    L7:
        int[] r102 = this.f525585vi;
        if (r101 >= (r102.length - 1)) goto L14;
        int r103 = r102[r101];
        r101 = r101 + 1;
        if (r103 < r102[r101]) goto L7;
        throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
    L14:
        return;
    L16:
        throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
    L18:
        throw new IllegalArgumentException("no layers defined.");
    }

    public int getDocLength() {
        int[] r100 = this.f525585vi;
        return r100[r100.length - 1] - r100[0];
    }

    public int getNumOfLayers() {
        return this.f525585vi.length - 1;
    }

    public int[] getVi() {
        return this.f525585vi;
    }
}
