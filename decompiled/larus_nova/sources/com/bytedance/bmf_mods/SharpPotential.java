package com.bytedance.bmf_mods;

import android.content.Context;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods.downloader.custom.CustomDownloader;
import com.bytedance.bmf_mods_api.SharpPotentialAPI;
import com.bytedance.bmf_mods_api.SharpPotentialDownloadCallback;
import com.bytedance.bmf_mods_api.SharpPotentialProcessCallback;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class SharpPotential implements SharpPotentialAPI {
    private IDownloader mDownloader;
    private final StringBuilder mModelPathBuilder;
    private long mNativePtr;
    private SharpPotentialDownloadCallback mSharpPotentialDownloadCallback;
    private SharpPotentialProcessCallback mSharpPotentialProcessCallback;

    private native long nativeCreateSharpPotential();

    private native int nativeInitSharpPotential(long r100, int r101, int r102, String r103, String r104, int r105);

    private native void nativeReleaseSharpPotential(long r100);

    private native float nativeSharpPotentialOesProcess(long r100, int r101, int r102, int r103, float[] r104);

    private native float nativeSharpPotentialProcess(long r100, int r101, int r102, int r103);

    private native int nativeSharpPotentialProcessAsync(long r100, int r101, int r102, int r103, long r104);

    private native int nativeSharpPotentialProcessOesAsync(long r100, int r101, int r102, int r103, float[] r104, long r105);

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public void Free() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseSharpPotential(r100);
    }

    public SharpPotential() {
        this.mNativePtr = 0;
        this.mModelPathBuilder = new StringBuilder();
        Logging.d("New SharpPotential");
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public void SetDownloadCallback(SharpPotentialDownloadCallback r100) {
        this.mSharpPotentialDownloadCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public void SetProcessCallback(SharpPotentialProcessCallback r100) {
        this.mSharpPotentialProcessCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public void DownloadModel(Context r110, Map<String, String> r111) {
        if (r111.containsKey("accessKey") == true) goto L5;
        return;
    L5:
        if (r111.containsKey("host") == true) goto L8;
        return;
    L8:
        if (this.mDownloader != null) goto L10;
        this.mDownloader = new CustomDownloader(r110);
    L10:
        this.mDownloader.download("sharp_potential", "SharpPotentialModelDir", "SharpPotential", "11.0.0", this.mModelPathBuilder, r111, this.mSharpPotentialDownloadCallback);
    }

    private void onNativeProcessCallback(long r100, int r101, float r102) {
        SharpPotentialProcessCallback r103 = this.mSharpPotentialProcessCallback;
        if (r103 == null) goto L6;
        r103.onProcessResult(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public int Init(int r100, int r101, String r102) {
        return Init(r100, r101, r102, -1);
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public float ProcessTexture(int r100, int r110, int r111) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1.0f;
    L5:
        long r101 = this.mNativePtr;
        if (r101 != 0) goto L8;
        return -1.0f;
    L8:
        if (r110 <= 0) goto L13;
        if (r111 <= 0) goto L13;
        return nativeSharpPotentialProcess(r101, r100, r110, r111);
    L13:
        return -1.0f;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public int Init(int r110, int r111, String r112, int r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        Logging.d("SharpPotential: so has not been initialized");
        return -1;
    L6:
        if (r111 != 0) goto L8;
    L11:
        long r100 = nativeCreateSharpPotential();
        this.mNativePtr = r100;
        if (r100 != 0) goto L15;
        return -1;
    L15:
        if (this.mModelPathBuilder.length() != 0) goto L17;
    L21:
        Logging.d("modelPath is empty or file not exist");
        return -1;
    L17:
        if (new PolarisFileWrapper(this.mModelPathBuilder.toString()).exists() == false) goto L21;
        return nativeInitSharpPotential(this.mNativePtr, r110, r111, this.mModelPathBuilder.toString(), r112, r113);
    L8:
        if (r111 == 1) goto L11;
        Logging.d("SharpPotential: byteNNForwardType is neither 0 nor 1");
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
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
        return nativeSharpPotentialProcessAsync(r100, r110, r111, r112, r113);
    L13:
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
    public float ProcessOesTexture(int r110, int r111, int r112, float[] r113) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1.0f;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
        return -1.0f;
    L8:
        if (r111 <= 0) goto L13;
        if (r112 <= 0) goto L13;
        return nativeSharpPotentialOesProcess(r100, r110, r111, r112, r113);
    L13:
        return -1.0f;
    }

    @Override // com.bytedance.bmf_mods_api.SharpPotentialAPI
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
        return nativeSharpPotentialProcessOesAsync(r100, r110, r111, r112, r113, r114);
    L13:
        return -1;
    }
}
