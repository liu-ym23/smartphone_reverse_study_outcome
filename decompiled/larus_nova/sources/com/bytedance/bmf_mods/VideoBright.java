package com.bytedance.bmf_mods;

import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoBrightAPI;
import com.bytedance.bmf_mods_api.VideoBrightCallbackAPI;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VideoBrightAPI.class}, singleton = true)
public class VideoBright implements VideoBrightAPI {
    private int bright_status;
    private int oes_flag;
    private VideoBrightCallbackAPI sCallback;
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;
    private int status_change;

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public int GetStatus() {
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public VideoBright() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.oes_flag = 0;
        this.bright_status = 0;
        this.status_change = 0;
        this.sCallback = null;
        Logging.d("New VideoBright");
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public void SetCallback(VideoBrightCallbackAPI r100) {
        this.sCallback = r100;
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public boolean Init(int r100, int r101, int r102, int r103) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return false;
    L5:
        this.srOption.addProperty("init_fps", Integer.valueOf(r100));
        this.srOption.addProperty("normal_fps", Integer.valueOf(r101));
        this.srOption.addProperty("long_sw", Integer.valueOf(r102));
        this.srOption.addProperty("lum_thre", Integer.valueOf(r103));
        this.srModuleInfo = new ModuleInfo("Brighten_Module", "c++", "libbmf_hydra.so", "");
        Class[] r104 = {JsonObject.class};
        Class[] r105 = {JsonObject.class};
        Logging.d("Brighten_Module: load bright Module");     // Catch: Exception -> L8
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r104, r105);     // Catch: Exception -> L8
        Logging.d("Brighten_Module: load bright Module success");     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        Logging.d("Brighten_Module: load bright Module failed," + e.toString());
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoBrightAPI
    public int Process(int r100, int r101, int r102, int r103, long r104) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.srFunc != null) goto L8;
        return -1;
    L8:
        JsonObject r105 = new JsonObject();
        r105.addProperty("input_texture", Integer.valueOf(r100));
        r105.addProperty("output_texture", Integer.valueOf(r101));
        r105.addProperty("width", Integer.valueOf(r102));
        r105.addProperty("height", Integer.valueOf(r103));
        r105.addProperty("timestamp", Long.valueOf(r104));
        JsonObject r106 = (JsonObject) this.srFunc.call(new Object[]{r105})[0];     // Catch: Exception -> L16
        int r107 = r106.get("output_texture").getAsInt();
        int r108 = r106.get("status").getAsInt();
        if (r108 != 2) goto L15;
        float r109 = r106.get("process_time").getAsFloat();
        float r110 = r106.get("input_texture_brightness").getAsFloat();
        float r111 = r106.get("output_texture_brightness").getAsFloat();
        VideoBrightCallbackAPI r112 = this.sCallback;
        if (r112 == null) goto L15;
        r112.callback(r108, r109, r110, r111);
    L15:
        return r107;
    L16:
        e = move-exception;
        Logging.d("Brighten_Module: call bright module failed," + e.toString());
        e.printStackTrace();
        return -1;
    }
}
