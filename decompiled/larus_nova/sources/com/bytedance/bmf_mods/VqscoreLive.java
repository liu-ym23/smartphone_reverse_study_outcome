package com.bytedance.bmf_mods;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods.downloader.custom.CustomDownloader;
import com.bytedance.bmf_mods.downloader.custom.ModelPathCache;
import com.bytedance.bmf_mods_api.VqscoreLiveAPI;
import com.bytedance.bmf_mods_api.VqscoreLiveCallbackAPI;
import com.bytedance.bmf_mods_api.VqscoreProcessCallbackAPI;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VqscoreLiveAPI.class}, singleton = true)
public class VqscoreLive implements VqscoreLiveAPI {
    private static final String MODEL_NAME = "vqscore";
    private IDownloader mDownloader;
    private long mNativePtr;
    private VqscoreProcessCallbackAPI mVqscoreProcessCallback;
    private final StringBuilder modelPathBuilder;
    private VqscoreLiveCallbackAPI vqscoreLiveCallback;

    private native long nativeCreateVqscoreLive();

    private native int nativeInitVqscoreLive(long r100, int r101, int r102, int r103, String r104, boolean r105, String r106, int r107);

    private native void nativeReleaseVqscoreLive(long r100);

    private native float nativeVqscoreLiveProcess(long r100, int r101, int r102, int r103);

    private native int nativeVqscoreProcessAsync(long r100, int r101, int r102, int r103, long r104);

    private native int nativeVqscoreProcessOesAsync(long r100, int r101, int r102, int r103, float[] r104, long r105);

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseVqscoreLive(r100);
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public String GetDownloadedModelPath() {
        String r100 = ModelPathCache.INSTANCE.getModelPath(MODEL_NAME);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L10;
        this.modelPathBuilder.setLength(0);
        this.modelPathBuilder.append(r100);
        return this.modelPathBuilder.toString();
    L10:
        return "";
    }

    public VqscoreLive() {
        this.mNativePtr = 0;
        this.modelPathBuilder = new StringBuilder();
        Logging.d("New VqscoreLive");
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetCallback(VqscoreLiveCallbackAPI r100) {
        this.vqscoreLiveCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetDownloadCallback(VqscoreLiveCallbackAPI r100) {
        this.vqscoreLiveCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void SetProcessCallback(VqscoreProcessCallbackAPI r100) {
        this.mVqscoreProcessCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public void DownloadModel(Context r110, Map<String, String> r111) {
        if (r111.containsKey("accessKey") == true) goto L5;
        return;
    L5:
        if (r111.containsKey("host") == false) goto L19;
        String r100 = ModelPathCache.INSTANCE.getModelPath(MODEL_NAME);
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (new PolarisFileWrapper(r100).exists() == false) goto L14;
        this.modelPathBuilder.setLength(0);
        this.modelPathBuilder.append(r100);
        this.vqscoreLiveCallback.callback(1);
        return;
    L14:
        if (this.mDownloader != null) goto L16;
        this.mDownloader = new CustomDownloader(r110);
    L16:
        this.mDownloader.download(MODEL_NAME, "VqscoreModelDir", "VqscoreLive", "11.0.0", this.modelPathBuilder, r111, this.vqscoreLiveCallback);
        return;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, boolean r101) {
        return Init(r100, 0, r101, "");
    }

    private void onNativeProcessCallback(long r100, int r101, float r102) {
        VqscoreProcessCallbackAPI r103 = this.mVqscoreProcessCallback;
        if (r103 == null) goto L6;
        r103.onProcessResult(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public float Process(int r100, int r110, int r111) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1.0f;
    L5:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L8;
        return -1.0f;
    L8:
        if (r110 <= 0) goto L13;
        if (r111 <= 0) goto L13;
        return nativeVqscoreLiveProcess(r101, r100, r110, r111);
    L13:
        return -1.0f;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, int r101, boolean r102, String r110) {
        return Init(r100, r101, r102, r110, -1);
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int ProcessAsync(int r110, int r111, int r112, long r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        if (r111 <= 0) goto L13;
        if (r112 <= 0) goto L13;
        return nativeVqscoreProcessAsync(r100, r110, r111, r112, r113);
    L13:
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r100, int r110, boolean r111, String r112, int r113) {
        return Init(0, 2, r100, r110, r111, r112, r113);
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int ProcessOesAsync(int r110, int r111, int r112, float[] r113, long r114) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1;
    L8:
        if (r111 <= 0) goto L13;
        if (r112 > 0) goto L12;
        return -1;
    L12:
        return nativeVqscoreProcessOesAsync(r100, r110, r111, r112, r113, r114);
    L13:
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VqscoreLiveAPI
    public int Init(int r110, int r111, int r112, int r113, boolean r114, String r115, int r116) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        Logging.d("VqscoreLive: so has not been initialized");
        return -1;
    L6:
        if (r113 != 0) goto L8;
    L11:
        long r100 = nativeCreateVqscoreLive();
        this.mNativePtr = r100;
        if (r100 != 0) goto L15;
        return -1;
    L15:
        if (this.modelPathBuilder.length() != 0) goto L17;
    L21:
        Logging.d("modelPath is empty or file not exist");
        return -1;
    L17:
        if (new PolarisFileWrapper(this.modelPathBuilder.toString()).exists() == false) goto L21;
        return nativeInitVqscoreLive(this.mNativePtr, r111, r112, r113, this.modelPathBuilder.toString(), r114, r115, r116);
    L8:
        if (r113 == 1) goto L11;
        Logging.d("VqscoreLive: byteNNForwardType is not 0 or 1");
        return -1;
    }
}
