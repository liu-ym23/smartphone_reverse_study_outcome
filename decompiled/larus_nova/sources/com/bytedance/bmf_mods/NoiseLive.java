package com.bytedance.bmf_mods;

import android.content.Context;
import com.bytedance.bmf.JsonParam;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods.downloader.IDownloader;
import com.bytedance.bmf_mods.downloader.custom.CustomDownloader;
import com.bytedance.bmf_mods_api.NoiseLiveAPI;
import com.bytedance.bmf_mods_api.NoiseLiveCallbackAPI;
import com.google.gson.JsonObject;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {NoiseLiveAPI.class}, singleton = true)
public class NoiseLive implements NoiseLiveAPI {
    private IDownloader mDownloader;
    private final StringBuilder modelPathBuilder;
    private ModuleFunctor noiseFunc;
    private NoiseLiveCallbackAPI noiseLiveCallback;
    private ModuleInfo noiseModuleInfo;
    private JsonObject noiseOption;

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
    public void Free() {
        ModuleFunctor r100 = this.noiseFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public NoiseLive() {
        this.noiseOption = new JsonObject();
        this.noiseModuleInfo = null;
        this.noiseFunc = null;
        this.modelPathBuilder = new StringBuilder();
        Logging.d("New NoiseLive");
    }

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
    public boolean Init(int r100) {
        return Init(r100, 0);
    }

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
    public void SetCallback(NoiseLiveCallbackAPI r100) {
        this.noiseLiveCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
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
        this.mDownloader.download("noiselive", "NoiseModelDir", "NoiseLive", "10.6.0", this.modelPathBuilder, r111, this.noiseLiveCallback);
    }

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
    public boolean Init(int r100, int r101) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L7;
        Logging.d("NoiseLive: so has not been initialized");
        return false;
    L7:
        if (r101 == 0) goto L11;
        if (r101 == 1) goto L11;
        Logging.d("NoiseLive: byteNNForwardType is not 0 or 1");
        return false;
    L11:
        this.noiseOption.addProperty("numThread", Integer.valueOf(r100));
        this.noiseOption.addProperty("byteNNForwardType", Integer.valueOf(r101));
        if (this.modelPathBuilder.length() <= 0) goto L14;
        this.noiseOption.addProperty("model_path", this.modelPathBuilder.toString());
    L14:
        this.noiseModuleInfo = new ModuleInfo("NOISE_LIVE_Module", "c++", "libbmf_hydra.so", "");
        Class[] r102 = {JsonParam.class};
        Class[] r103 = {JsonParam.class};
        Logging.d("NoiseLive: load NoiseLive Module");     // Catch: Exception -> L17
        this.noiseFunc = new ModuleFunctor(this.noiseModuleInfo, this.noiseOption, r102, r103);     // Catch: Exception -> L17
        Logging.d("NoiseLive: load NoiseLive Module success");     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        Logging.d(String.format("NoiseLive: load Noise Live Module failed, %s", new Object[]{e.toString()}));
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.NoiseLiveAPI
    public float Process(int r100, int r101, int r102) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1.0f;
    L6:
        if (this.noiseFunc != null) goto L8;
        return -1.0f;
    L8:
        JsonParam r103 = new JsonParam();
        JsonParam r104 = null;
        r103.set("input_texture", Integer.valueOf(r100));     // Catch: Throwable -> L17 Exception -> L19
        r103.set("width", Integer.valueOf(r101));     // Catch: Throwable -> L17 Exception -> L19
        r103.set("height", Integer.valueOf(r102));     // Catch: Throwable -> L17 Exception -> L19
        JsonParam r105 = (JsonParam) this.noiseFunc.call(new Object[]{r103})[0];     // Catch: Throwable -> L17 Exception -> L19
        float r106 = r105.getFloat("noiselive_res");     // Catch: Throwable -> L13 Exception -> L15
        r103.free();
        r105.free();
        return r106;
    L15:
        e = e;
        r104 = r105;
    L20:
        Logging.d(String.format("NoiseLive: call NoiseLive module failed, %s", new Object[]{e.toString()}));     // Catch: Throwable -> L17
        e.printStackTrace();     // Catch: Throwable -> L17
        r103.free();
        if (r104 == null) goto L24;
        r104.free();
    L24:
        return -1.0f;
    L13:
        th = th;
        r104 = r105;
    L25:
        r103.free();
        if (r104 == null) goto L28;
        r104.free();
    L28:
        throw th;
    L17:
        th = th;
    L19:
        e = e;
        goto L20
    }
}
