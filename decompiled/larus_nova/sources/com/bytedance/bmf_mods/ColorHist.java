package com.bytedance.bmf_mods;

import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.ColorHistAPI;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {ColorHistAPI.class}, singleton = false)
public class ColorHist implements ColorHistAPI {
    private long mNativePtr;
    private float[] output_data;
    private JsonObject resultJson;

    private native int nativeColorHistOesProcess(long r100, int r101, float[] r102, int r103, int r104, long r105, float[] r106);

    private native int nativeColorHistProcess(long r100, int r101, int r102, int r103, long r104, float[] r105);

    private native int nativeColorHistRestStatus(long r100);

    private native long nativeCreateColorHist();

    private native int nativeInitColorHist(long r100, int r101, int r102, int r103, int r104, int r105);

    private native void nativeReleaseColorHist(long r100);

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseColorHist(r100);
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ResetStatus() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeColorHistRestStatus(r100);
    }

    public ColorHist() {
        this.mNativePtr = 0;
        this.resultJson = new JsonObject();
        this.output_data = new float[]{-1.0f, -1.0f, -1.0f};
        Logging.d("New color hist");
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public JsonObject GetResult() {
        return this.resultJson;
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ProcessTexture(int r110, int r111, int r112, long r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        int r101 = nativeColorHistProcess(r100, r110, r111, r112, r113, this.output_data);
        if (r101 <= 0) goto L11;
        this.resultJson.addProperty("valid", Integer.valueOf(r101));
        this.resultJson.addProperty("constract", Float.valueOf(this.output_data[0]));
        this.resultJson.addProperty("brightness", Float.valueOf(this.output_data[1]));
        this.resultJson.addProperty("saturation", Float.valueOf(this.output_data[2]));
    L11:
        return r101;
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int Init(int r110, int r111, int r112, int r113, int r114) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = nativeCreateColorHist();
        this.mNativePtr = r100;
        if (r100 != 0) goto L9;
        return -1;
    L9:
        return nativeInitColorHist(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.bytedance.bmf_mods_api.ColorHistAPI
    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113, long r114) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        int r101 = nativeColorHistOesProcess(r100, r110, r113, r111, r112, r114, this.output_data);
        if (r101 <= 0) goto L11;
        this.resultJson.addProperty("valid", Integer.valueOf(r101));
        this.resultJson.addProperty("constract", Float.valueOf(this.output_data[0]));
        this.resultJson.addProperty("brightness", Float.valueOf(this.output_data[1]));
        this.resultJson.addProperty("saturation", Float.valueOf(this.output_data[2]));
    L11:
        return r101;
    }
}
