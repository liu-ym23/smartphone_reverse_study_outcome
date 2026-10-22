package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowParameterSpec implements AlgorithmParameterSpec {
    private static final int[] DEFAULT_VI = null;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525603vi;

    static {
        DEFAULT_VI = new int[]{6, 12, 17, 22, 33};
    }

    public RainbowParameterSpec() {
        this.f525603vi = DEFAULT_VI;
    }

    public RainbowParameterSpec(int[] r100) {
        this.f525603vi = r100;
        checkParams();
    }

    private void checkParams() {
        int[] r100 = this.f525603vi;
        if (r100 == null) goto L18;
        if (r100.length <= 1) goto L16;
        int r101 = 0;
    L7:
        int[] r102 = this.f525603vi;
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

    public int getDocumentLength() {
        int[] r100 = this.f525603vi;
        return r100[r100.length - 1] - r100[0];
    }

    public int getNumOfLayers() {
        return this.f525603vi.length - 1;
    }

    public int[] getVi() {
        return Arrays.clone(this.f525603vi);
    }
}
