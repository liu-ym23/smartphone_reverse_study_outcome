package com.bytedance.bmf_mods;

import android.content.Context;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods.downloader.custom.CustomDownloader;
import com.bytedance.bmf_mods_api.NoiseDetectAPI;
import com.bytedance.bmf_mods_api.NoiseDetectCallbackAPI;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {NoiseDetectAPI.class}, singleton = true)
public class NoiseDetect implements NoiseDetectAPI {
    private IDownloader mDownloader;
    private long mNativePtr;
    private final StringBuilder modelPathBuilder;
    private NoiseDetectCallbackAPI noiseDetectCallback;

    private native long nativeCreateNoiseDetect();

    private native int nativeInitNoiseDetect(long r100, int r101, int r102, String r103, boolean r104, String r105);

    private native float nativeNoiseDetectProcess(long r100, int r101, int r102, int r103);

    private native void nativeReleaseNoiseDetect(long r100);

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseNoiseDetect(r100);
    }

    public NoiseDetect() {
        this.mNativePtr = 0;
        this.modelPathBuilder = new StringBuilder();
        Logging.d("New  NoiseDetect");
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void SetCallback(NoiseDetectCallbackAPI r100) {
        this.noiseDetectCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public void DownloadModel(Context r110, Map<String, String> r111) {
        if (r111.containsKey("accessKey") == true) goto L5;
        return;
    L5:
        if (r111.containsKey(b.f276371u) == true) goto L7;
        return;
    L7:
        if (r111.containsKey("appVersion") == true) goto L9;
        return;
    L9:
        if (r111.containsKey("platformSdkVersion") == true) goto L11;
        return;
    L11:
        if (r111.containsKey("deviceId") == true) goto L13;
        return;
    L13:
        if (r111.containsKey("host") == true) goto L16;
        return;
    L16:
        if (this.mDownloader != null) goto L18;
        this.mDownloader = new CustomDownloader(r110);
    L18:
        this.mDownloader.download("noiselive", "NoiseModelDir", "NoiseLive", "10.6.0", this.modelPathBuilder, r111, this.noiseDetectCallback);
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
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
        return nativeNoiseDetectProcess(r101, r100, r110, r111);
    L13:
        return -1.0f;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseDetectAPI
    public int Init(int r110, int r111, boolean r112, String r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        Logging.d("NoiseDetect: so has not been initialized");
        return -1;
    L6:
        if (r111 != 0) goto L8;
    L11:
        long r100 = nativeCreateNoiseDetect();
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
        return nativeInitNoiseDetect(this.mNativePtr, r110, r111, this.modelPathBuilder.toString(), r112, r113);
    L8:
        if (r111 == 1) goto L11;
        Logging.d("NoiseDetect: byteNNForwardType is not 0 or 1");
        return -1;
    }
}
