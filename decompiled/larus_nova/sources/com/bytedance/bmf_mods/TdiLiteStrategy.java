package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.TdiLiteStrategyAPI;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {TdiLiteStrategyAPI.class}, singleton = false)
public class TdiLiteStrategy implements TdiLiteStrategyAPI {
    private int mAlgType;
    private long mNativePtr;

    private native long nativeCreateTdiLiteStrategy();

    private native int nativeInitTdiLiteStrategy(long r100, int r101, int r102, int r103, int r104, String r105, String r106, String r107, int r110);

    private native void nativeReleaseTdiLiteStrategy(long r100);

    private native int nativeTdiLiteStrategyGetResult(long r100, float[] r101);

    private native int nativeTdiLiteStrategyProcess(long r100, double[] r101, double[] r102, double[] r103, double[] r104, int r105, int r106);

    @Override // com.bytedance.bmf_mods_api.TdiLiteStrategyAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseTdiLiteStrategy(r100);
    }

    public TdiLiteStrategy() {
        this.mNativePtr = 0;
        this.mAlgType = -1;
        Logging.d("New TdiLiteStrategy");
    }

    @Override // com.bytedance.bmf_mods_api.TdiLiteStrategyAPI
    public int GetResult(float[] r100) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L11;
        return -101;
    L11:
        return nativeTdiLiteStrategyGetResult(r101, r100);
    }

    @Override // com.bytedance.bmf_mods_api.TdiLiteStrategyAPI
    public int Process(double[] r110, double[] r111, double[] r112, double[] r113, int r114, int r115) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L11;
        return -101;
    L11:
        return nativeTdiLiteStrategyProcess(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.bytedance.bmf_mods_api.TdiLiteStrategyAPI
    public int Init(int r110, int r111, int r112, int r113, String r114, String r115, String r116, int r210) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        this.mAlgType = r110;
        if (r110 == 11) goto L9;
        Logging.d("TdiLiteStrategy: alg_type range is [11,11] ");
        return -1;
    L9:
        long r100 = nativeCreateTdiLiteStrategy();
        this.mNativePtr = r100;
        if (r100 != 0) goto L13;
        return -1;
    L13:
        if (r114 != null) goto L15;
        String r101 = "";
    L16:
        if (r115 != null) goto L18;
        String r102 = "";
    L19:
        if (r116 != null) goto L21;
        String r103 = "";
    L23:
        return nativeInitTdiLiteStrategy(r100, r110, r111, r112, r113, r101, r102, r103, r210);
    L21:
        r103 = r116;
        goto L23
    L18:
        r102 = r115;
        goto L19
    L15:
        r101 = r114;
        goto L16
    }
}
