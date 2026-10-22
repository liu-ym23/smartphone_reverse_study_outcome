package com.ss.android.ttve.vealgorithm;

import com.ss.android.ttve.vealgorithm.params.VEAlgorithmParam;
import com.ss.android.ttve.vealgorithm.params.VEAlgorithmResult;
import com.ss.android.ttve.vealgorithm.params.VEAlgorithmType;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.algorithm.VECommAlgoInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public class VEAlgorithm {
    private static final String TAG = "VEAlgorithm";
    private VEListener.j commAlgInfoListener;
    private VEListener.b mErrorListener;
    protected long mHandle;
    private VEListener.c mListener;

    public native int nativeAlgorithmCancel(long r100);

    public native long nativeAlgorithmCreate(Object r100);

    public native int nativeAlgorithmDestroy(long r100);

    public native Object nativeAlgorithmGetRandomResult(long r100);

    public native Object nativeAlgorithmGetResult(long r100);

    public native int nativeAlgorithmStart(long r100);

    public void nativeCallback_onCommonInfo(int r100, HashMap<String, VECommAlgoInfo> r101) {
    }

    public void nativeCallback_onError(int r100, String r101) {
    }

    public void nativeCallback_onProcess(float r100, boolean r101) {
    }

    public native VECommAlgoInfo nativeGetCommonData(long r100);

    public native int nativeSetParams(long r100, VECommAlgoInfo r101);

    public native int nativeupdateAlgorithmParam(long r100, Object r101);

    public void setCommAlgInfoListener(VEListener.j r100) {
    }

    public void setErrorListener(VEListener.b r100) {
    }

    public void setProcessListener(VEListener.c r100) {
    }

    public int cancel() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -112;
    L7:
        return nativeAlgorithmCancel(r100);
    }

    public int destroy() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        return -112;
    L6:
        int r101 = nativeAlgorithmDestroy(r100);
        this.mHandle = 0;
        return r101;
    }

    public void finalize() {
        if (this.mHandle == 0) goto L6;
        VELogUtil.e(TAG, "not destroy algorithm object:" + this.mHandle);
        return;
    }

    public VEAlgorithmResult getResult() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return (VEAlgorithmResult) nativeAlgorithmGetResult(r100);
    }

    public int start() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return -112;
    L7:
        return nativeAlgorithmStart(r100);
    }

    public VEAlgorithm() {
        this.mHandle = 0;
    }

    public int init(VEAlgorithmParam r100) {
        int r101 = r100.type;
        if (r101 != VEAlgorithmType.VE_ALGORITHM_TYPE_INVALID) goto L6;
        VELogUtil.e(TAG, "invalid algorithm type:" + r101);
        return -100;
    L6:
        long r102 = nativeAlgorithmCreate(r100);
        this.mHandle = r102;
        if (r102 != 0) goto L10;
        VELogUtil.e(TAG, "nativeAlgorithmCreate failed!");
        return -1;
    L10:
        return 0;
    }

    public int updateParams(VEAlgorithmParam r100) {
        int r101 = r100.type;
        if (r101 != VEAlgorithmType.VE_ALGORITHM_TYPE_INVALID) goto L6;
        VELogUtil.e(TAG, "invalid algorithm type:" + r101);
        return -100;
    L6:
        long r102 = this.mHandle;
        if (r102 != 0) goto L10;
        return -112;
    L10:
        int r103 = nativeupdateAlgorithmParam(r102, r100);
        if (r103 == 0) goto L14;
        VELogUtil.e(TAG, "nativeupdateAlgorithmParam failed! ret: " + r103);
        return r103;
    L14:
        return 0;
    }
}
