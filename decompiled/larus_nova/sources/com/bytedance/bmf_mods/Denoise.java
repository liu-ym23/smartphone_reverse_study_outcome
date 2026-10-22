package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.DenoiseAPI;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {DenoiseAPI.class}, singleton = false)
public class Denoise implements DenoiseAPI {
    private int mAlgType;
    private long mNativePtr;
    private int[] output_data;

    private native long nativeCreateHydraDenoise();

    private native int nativeGetHydraDenoiseReport(long r100, int[] r101);

    private native int nativeGetHydraDenoiseResult(long r100);

    private native int nativeHydraDenoiseOesProcess(long r100, int r101, int r102, int r103, float[] r104, int r105, boolean r106);

    private native int nativeHydraDenoiseProcess(long r100, int r101, int r102, int r103, int r104, boolean r105);

    private native int nativeHydraDenoiseProcessTexture(long r100, int r101, boolean r102, int r103, int r104, float[] r105, int r106, boolean r107, int r110);

    private native int nativeInitHydraDenoise(long r100, int r101, int r102, int r103, int r104, int r105, int r106, boolean r107, String r110, int r111, int r112, int r113, int r114, int r115);

    private native void nativeReleaseHydraDenoise(long r100);

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseHydraDenoise(r100);
        this.mNativePtr = 0;
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int[] GetReport() {
        nativeGetHydraDenoiseReport(this.mNativePtr, this.output_data);
        return this.output_data;
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int GetResult() {
        return nativeGetHydraDenoiseResult(this.mNativePtr);
    }

    public Denoise() {
        this.mNativePtr = 0;
        this.mAlgType = -1;
        this.output_data = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        Logging.d("New denoise");
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int ProcessTexture(int r110, int r111, int r112, int r113, boolean r114) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraDenoiseProcess(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113, int r114, boolean r115) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraDenoiseOesProcess(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int ProcessTexture(int r110, boolean r111, int r112, int r113, float[] r114, int r115, boolean r210, int r211) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraDenoiseProcessTexture(r100, r110, r111, r112, r113, r114, r115, r210, r211);
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int Init(int r110, int r111, int r210, boolean r211, String r212, int r213, int r214, int r215, int r216) {
        int r100 = r213;
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r101 = nativeCreateHydraDenoise();
        this.mNativePtr = r101;
        if (r101 != 0) goto L8;
        return -1;
    L8:
        this.mAlgType = 0;
        if (r100 < 268435456) goto L11;
        r100 = r100 - 268435456;
        this.mAlgType = 1;
    L11:
        int r102 = this.mAlgType;
        return nativeInitHydraDenoise(r101, r102, 2, 3, r110, r111, r210, r211, r212, r100, r214, r215, r216, 0);
    }

    @Override // com.bytedance.bmf_mods_api.DenoiseAPI
    public int Init(int r110, int r111, int r112, int r210, int r211, int r212, boolean r213, String r214, int r215, int r216, int r217, int r218, int r219) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        this.mAlgType = r110;
        if (r110 >= 0) goto L8;
    L25:
        Logging.d("Denoise: alg_type range is [0,7],backend is [2,3] ");
        return -1;
    L8:
        if (r110 > 7) goto L25;
        if (r111 < 1) goto L25;
        if (r111 > 3) goto L25;
        long r100 = nativeCreateHydraDenoise();
        this.mNativePtr = r100;
        if (r100 != 0) goto L17;
        return -1;
    L17:
        if (r112 > 0) goto L19;
    L22:
        Logging.d("Denoise: pool size should be more than 0, change to 3 for default");
        int r101 = 3;
    L24:
        return nativeInitHydraDenoise(this.mNativePtr, r110, r111, r101, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219);
    L19:
        if (r112 > 10) goto L22;
        r101 = r112;
        goto L24
    }
}
