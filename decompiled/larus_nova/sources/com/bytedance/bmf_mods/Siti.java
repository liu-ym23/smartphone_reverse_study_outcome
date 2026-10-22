package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.SitiAPI;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {SitiAPI.class}, singleton = false)
public class Siti implements SitiAPI {
    private int mAlgType;
    private long mNativePtr;

    private native long nativeCreateHydraSiti();

    private native int nativeHydraSitiGetResult(long r100, double[] r101, double[] r102);

    private native int nativeHydraSitiProcessTexture(long r100, int r101, int r102, int r103, boolean r104);

    private native int nativeInitHydraSiti(long r100, String r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, int r112);

    private native void nativeReleaseHydraSiti(long r100);

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseHydraSiti(r100);
    }

    public Siti() {
        this.mNativePtr = 0;
        this.mAlgType = -1;
        Logging.d("New Siti");
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int GetResult(double[] r100, double[] r101) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r102 = this.mNativePtr;
        if (r102 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraSitiGetResult(r102, r100, r101);
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int ProcessTexture(int r110, int r111, int r112, boolean r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeHydraSitiProcessTexture(r100, r110, r111, r112, r113);
    }

    @Override // com.bytedance.bmf_mods_api.SitiAPI
    public int Init(String r110, int r111, int r112, int r113, int r114, int r210, int r211, int r212, int r213, int r214) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        this.mAlgType = r111;
        if (r111 == 11) goto L8;
    L15:
        Logging.d("Siti: alg_type range is [11,11],backend is [3,3] ");
        return -1;
    L8:
        if (r211 != 3) goto L15;
        long r100 = nativeCreateHydraSiti();
        this.mNativePtr = r100;
        if (r100 != 0) goto L14;
        return -1;
    L14:
        return nativeInitHydraSiti(r100, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }
}
