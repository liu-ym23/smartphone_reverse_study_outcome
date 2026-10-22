package com.ss.android.ttve.vealgorithm;

import com.ss.android.ttve.vealgorithm.params.VESmartCutResult;

/* JADX INFO: loaded from: classes38.dex */
public class VESmartCutAlgorithm extends VEAlgorithm {
    public VESmartCutResult getRandomResult() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return (VESmartCutResult) nativeAlgorithmGetRandomResult(r100);
    }

    public VESmartCutAlgorithm() {
    }
}
