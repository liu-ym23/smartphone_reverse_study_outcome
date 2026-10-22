package com.bytedance.bmf_mods;

import android.opengl.GLES20;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.GLUtils;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoSRLutAPI;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VideoSRLutAPI.class}, singleton = true)
public class VideoSRLut implements VideoSRLutAPI {
    private int SR_R15_TYPE;
    private int SR_R_TYPE;
    private int algType;
    private int currHeight;
    private int currOutputTexture;
    private int currWidth;
    private int oes_flag;
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int AsyncWait() {
        if (this.srFunc != null) goto L5;
        return -1;
    L5:
        JsonObject r100 = new JsonObject();
        r100.addProperty("async_wait", 1);
        Logging.d("VideoSRLut: async process, wait.");     // Catch: Exception -> L8
        Object[] r101 = this.srFunc.call(new Object[]{r100});     // Catch: Exception -> L8
        Logging.d("VideoSRLut: async wait finish.");     // Catch: Exception -> L8
        JsonObject r102 = (JsonObject) r101[0];     // Catch: Exception -> L8
        return 0;
    L8:
        e = move-exception;
        Logging.d("VideoSRLut: call VRSR module failed, %s" + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int ClearClBuffer() {
        if (this.srFunc != null) goto L5;
        return -1;
    L5:
        JsonObject r100 = new JsonObject();
        r100.addProperty("clear_cl_buffer", 1);
        Logging.d("VideoSRLut: clear opencl buffer start.");     // Catch: Exception -> L8
        Object[] r101 = this.srFunc.call(new Object[]{r100});     // Catch: Exception -> L8
        Logging.d("VideoSRLut: clear opencl buffer finish.");     // Catch: Exception -> L8
        JsonObject r102 = (JsonObject) r101[0];     // Catch: Exception -> L8
        return 0;
    L8:
        e = move-exception;
        Logging.d("VideoSRLut: clear opencl buffer failed," + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public VideoSRLut() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.oes_flag = 0;
        this.SR_R_TYPE = 0;
        this.SR_R15_TYPE = 4;
        Logging.d("New VideoSRLut");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(int r100) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r100 != this.SR_R_TYPE) goto L13;
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srOption.addProperty("data_type", 1);
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] r101 = {JsonObject.class};
        Class[] r102 = {JsonObject.class};
        Logging.d("VideoSRLut: load SRLut Module");     // Catch: Exception -> L10
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r101, r102);     // Catch: Exception -> L10
        Logging.d("VideoSRLut: load SRLut Module success");     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        Logging.d("VideoSRLut: load video sr lut Module failed," + e.toString());
        return false;
    L13:
        Logging.d("VideoSRLut: unsupported algoType=" + r100);
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int AsyncProcess(int r100, int r101, int r102, int r103, boolean r104) {
        if (this.srFunc != null) goto L5;
        return -1;
    L5:
        JsonObject r105 = new JsonObject();
        r105.addProperty("input_texture", Integer.valueOf(r100));
        r105.addProperty("output_texture", Integer.valueOf(r101));
        r105.addProperty("width", Integer.valueOf(r102));
        r105.addProperty("height", Integer.valueOf(r103));
        r105.addProperty("async", 1);
        Logging.d("VideoSRLut: async call");     // Catch: Exception -> L8
        Object[] r106 = this.srFunc.call(new Object[]{r105});     // Catch: Exception -> L8
        Logging.d("VideoSRLut: async call end");     // Catch: Exception -> L8
        JsonObject r107 = (JsonObject) r106[0];     // Catch: Exception -> L8
        return r101;
    L8:
        e = move-exception;
        Logging.d("VideoSRLut: async call VRSR module failed, " + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean GlSrInit(String r100, int r101, boolean r102, int r103, int r104) {
        long r105 = System.currentTimeMillis();
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r102 == false) goto L8;
        this.oes_flag = 1;
    L8:
        if (r101 != 0) goto L16;
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srOption.addProperty("gl_sr", 1);
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] r106 = {JsonObject.class};
        Class[] r107 = {JsonObject.class};
        Logging.d("VideoSRLut: load VRSR Module");     // Catch: Exception -> L13
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r106, r107);     // Catch: Exception -> L13
        Logging.d("VideoSRLut: load VRSR Module success");     // Catch: Exception -> L13
        Logging.d(String.format("BMF_gl_sr proces time:%d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r105)}));
        return true;
    L13:
        e = move-exception;
        Logging.d(String.format("VideoSRLut: load video sr lut Module failed, %s", new Object[]{e.toString()}));
        return false;
    L16:
        Logging.d(String.format("VideoSRLut: unsupported algoType=%d", new Object[]{Integer.valueOf(r101)}));
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(String r100, int r101, boolean r102, int r103, int r104) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r102 == false) goto L9;
        this.oes_flag = 1;
    L9:
        if (r101 != this.SR_R_TYPE) goto L16;
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] r105 = {JsonObject.class};
        Class[] r106 = {JsonObject.class};
        Logging.d("VideoSRLut: load SRLut Module");     // Catch: Exception -> L13
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r105, r106);     // Catch: Exception -> L13
        Logging.d("VideoSRLut: load SRLut Module success");     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        Logging.d("VideoSRLut: load video sr lut Module failed," + e.toString());
        return false;
    L16:
        Logging.d("VideoSRLut: unsupported algoType=" + r101);
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int Process(int r100, int r101, int r102, int r103, boolean r104) {
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
        JsonObject r106 = (JsonObject) this.srFunc.call(new Object[]{r105})[0];     // Catch: Exception -> L11
        return r101;
    L11:
        e = move-exception;
        Logging.d("VideoSRLut: call SRLut module failed, " + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public boolean Init(String r100, int r101, boolean r102, int r103, int r104, String r105) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r102 == false) goto L9;
        this.oes_flag = 1;
    L9:
        if (r101 != this.SR_R_TYPE) goto L16;
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
        this.srOption.addProperty("license_module_name", r105);
        this.srModuleInfo = new ModuleInfo("SR_LUT_Module", "c++", "libbmf_hydra.so", "");
        Class[] r106 = {JsonObject.class};
        Class[] r107 = {JsonObject.class};
        Logging.d("VideoSRLut: load SRLut Module");     // Catch: Exception -> L13
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r106, r107);     // Catch: Exception -> L13
        Logging.d("VideoSRLut: load SRLut Module success");     // Catch: Exception -> L13
        return true;
    L13:
        e = move-exception;
        Logging.d(String.format("VideoSRLut: load video sr lut Module failed, %s", new Object[]{e.toString()}));
        return false;
    L16:
        Logging.d(String.format("VideoSRLut: unsupported algoType=%d", new Object[]{Integer.valueOf(r101)}));
        return false;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRLutAPI
    public int Process(long r210, long r211, long r212, int r213, int r214, int r215, int r216) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.srFunc != null) goto L9;
        return -1;
    L9:
        if (r215 == this.currWidth) goto L11;
    L12:
        GLUtils.deleteTexture(this.currOutputTexture);
        this.currWidth = r215;
        this.currHeight = r216;
        if (this.algType != 0) goto L15;
        double r100 = 2.0d;
    L16:
        int r110 = (int) (((double) r215) * r100);
        int r111 = (int) (r100 * ((double) r216));
        int r101 = GLUtils.genTexture(3553);
        this.currOutputTexture = r101;
        GLES20.glBindTexture(3553, r101);
        GLES20.glTexImage2D(3553, 0, 6408, r110, r111, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
    L17:
        JsonObject r102 = new JsonObject();
        r102.addProperty("y_ptr", Long.valueOf(r210));
        r102.addProperty("u_ptr", Long.valueOf(r211));
        r102.addProperty("v_ptr", Long.valueOf(r212));
        r102.addProperty("color_space", Integer.valueOf(r213));
        r102.addProperty("color_range", Integer.valueOf(r214));
        r102.addProperty("output_texture", Integer.valueOf(this.currOutputTexture));
        r102.addProperty("width", Integer.valueOf(r215));
        r102.addProperty("height", Integer.valueOf(r216));
        JsonObject r103 = (JsonObject) this.srFunc.call(new Object[]{r102})[0];     // Catch: Exception -> L21
        return this.currOutputTexture;
    L21:
        e = move-exception;
        Logging.d("VideoSRLut: call SRLut module failed, " + e.toString());
        e.printStackTrace();
        return -1;
    L15:
        r100 = 1.5d;
        goto L16
    L11:
        if (r216 == this.currHeight) goto L17;
        goto L12
    }
}
