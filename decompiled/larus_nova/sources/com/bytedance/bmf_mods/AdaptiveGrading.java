package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.AdaptiveGradingAPI;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {AdaptiveGradingAPI.class}, singleton = false)
public class AdaptiveGrading implements AdaptiveGradingAPI {
    private long mNativePtr;

    private native int nativeAdaptiveGradingGetResultTexture(long r100);

    private native int nativeAdaptiveGradingOesProcess(long r100, int r101, int r102, int r103, float[] r104, float r105, float r106, float r107, float r110, float r111, float r112, boolean r113);

    private native int nativeAdaptiveGradingProcess(long r100, int r101, int r102, int r103, float r104, float r105, float r106, float r107, float r110, float r111, boolean r112);

    private native long nativeCreateAdaptiveGrading();

    private native int nativeInitAdaptiveGrading(long r100, int r101, int r102, String r103, float[] r104, float[] r105, float[] r106);

    private native void nativeReleaseAdaptiveGrading(long r100);

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseAdaptiveGrading(r100);
    }

    public AdaptiveGrading() {
        this.mNativePtr = 0;
        Logging.d("New AdaptiveGrading");
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int Init(int r110, int r111, String r112, float[] r113, float[] r114, float[] r115) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = nativeCreateAdaptiveGrading();
        this.mNativePtr = r100;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeInitAdaptiveGrading(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int ProcessTexture(int r110, int r111, int r112, float r113, float r114, float r210, float r211, float r212, float r213, boolean r214) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        int r101 = nativeAdaptiveGradingProcess(r100, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
        if (r101 == 0) goto L11;
        return r101;
    L11:
        return nativeAdaptiveGradingGetResultTexture(this.mNativePtr);
    }

    @Override // com.bytedance.bmf_mods_api.AdaptiveGradingAPI
    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113, float r210, float r211, float r212, float r213, float r214, float r215, boolean r216) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        int r101 = nativeAdaptiveGradingOesProcess(r100, r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216);
        if (r101 == 0) goto L11;
        return r101;
    L11:
        return nativeAdaptiveGradingGetResultTexture(this.mNativePtr);
    }
}
