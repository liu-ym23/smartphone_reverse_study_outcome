package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.MotionSenseAPI;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {MotionSenseAPI.class}, singleton = false)
public class MotionSense implements MotionSenseAPI {
    private int mAlgType;
    private long mNativePtr;
    private float[] output_data;

    private native long nativeCreateMotionSense();

    private native int nativeInitMotionSense(long r100, int r101, int r102, int r103, int r104, String r105, int r106, int r107);

    private native int nativeMotionSenseGetResult(long r100, float[] r101);

    private native int nativeMotionSenseProcess(long r100, float r101, int r102, float[] r103, float[] r104, float[] r105, int[] r106, boolean r107, boolean r110);

    private native void nativeReleaseMotionSense(long r100);

    @Override // com.bytedance.bmf_mods_api.MotionSenseAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseMotionSense(r100);
    }

    public MotionSense() {
        this.mNativePtr = 0;
        this.mAlgType = -1;
        this.output_data = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        Logging.d("New MotionSense");
    }

    @Override // com.bytedance.bmf_mods_api.MotionSenseAPI
    public float[] GetResult() {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return null;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return null;
    L9:
        if (nativeMotionSenseGetResult(r100, this.output_data) == 0) goto L13;
        Logging.e("MotionSense GetResult fail");
        return null;
    L13:
        return this.output_data;
    }

    @Override // com.bytedance.bmf_mods_api.MotionSenseAPI
    public int Init(int r110, int r111, int r112, int r113, String r114, int r115, int r116) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        this.mAlgType = r110;
        if (r110 == 10) goto L9;
        Logging.d("MotionSense: alg_type range is [10,10]");
        return -1;
    L9:
        long r100 = nativeCreateMotionSense();
        this.mNativePtr = r100;
        if (r100 != 0) goto L13;
        return -1;
    L13:
        return nativeInitMotionSense(r100, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.bytedance.bmf_mods_api.MotionSenseAPI
    public int Process(float r110, int r111, float[] r112, float[] r113, float[] r114, int[] r115, boolean r210, boolean r211) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeMotionSenseProcess(r100, r110, r111, r112, r113, r114, r115, r210, r211);
    }
}
