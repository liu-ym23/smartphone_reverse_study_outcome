package com.ss.android.vesdk;

import com.ss.android.ttve.lensAlgorithm.VEBaseLensAlgorithmConfig;
import com.ss.android.ttve.lensAlgorithm.VEBaseLensResults;
import com.ss.android.ttve.nativePort.TELensAlgorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VELensAlgorithm {
    private static final String TAG = "VELensAlgorithm";
    private TELensAlgorithm mLensHandle;

    public int destroy() {
        return this.mLensHandle.a();
    }

    public int init() {
        return this.mLensHandle.c();
    }

    public VELensAlgorithm() {
        this.mLensHandle = new TELensAlgorithm();
    }

    public VEBaseLensResults getAlgorithmResults(VEBaseLensAlgorithmConfig r100, VEListener.p r101) {
        VELensCallBacks r102 = new VELensCallBacks();
        r102.setmLensStateListener(r101);
        return this.mLensHandle.b(r100, r102);
    }
}
