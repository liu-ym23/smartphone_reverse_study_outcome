package com.bytedance.bmf_mods;

import android.graphics.Bitmap;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf.VideoFrame;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoOCLSRAPI;
import com.bytedance.hmp.Frame;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import com.ss.ttvideoengine.model.SubInfo;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VideoOCLSRAPI.class}, singleton = true)
public class VideoOCLSR implements VideoOCLSRAPI {
    private int oes_flag;
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public VideoOCLSR() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.oes_flag = 0;
        Logging.d("New VideoOCLSR");
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public Bitmap Process(Bitmap r100, int r101, int r102, boolean r103) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return null;
    L6:
        if (this.srFunc != null) goto L8;
        return null;
    L8:
        VideoFrame r104 = new VideoFrame(new Frame(r100));
        VideoFrame r105 = (VideoFrame) this.srFunc.call(new Object[]{r104})[0];     // Catch: Exception -> L12
        Bitmap r106 = Bitmap.createBitmap(r105.width(), r105.height(), Bitmap.Config.ARGB_8888);
        VideoFrame r107 = new VideoFrame(new Frame(r106));
        r107.copyFrom(r105);
        r104.free();
        r105.free();
        r107.free();
        return r106;
    L12:
        e = move-exception;
        r104.free();
        Logging.d("VideoOCLSR: call VRSR module failed," + e.toString());
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public boolean Init(String r100, int r101, boolean r110, int r111, int r112) {
        return Init(r100, r101, r110, r111, r112, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
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
        Logging.d("VideoOCLSR: call VRSR module failed, %s" + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public boolean Init(String r100, int r101, boolean r102, int r103, int r104, int r110) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r102 == false) goto L8;
        this.oes_flag = 1;
    L8:
        this.srOption.addProperty("config_path", r100);
        if (r101 != 0) goto L11;
        this.srOption.addProperty("scale", Double.valueOf(2.0d));
    L13:
        this.srOption.addProperty("max_input_width", Integer.valueOf(r103));
        this.srOption.addProperty("max_input_height", Integer.valueOf(r104));
        this.srOption.addProperty("filter_path", "");
        this.srOption.addProperty(SubInfo.KEY_FORMAT, Integer.valueOf(r110));
        this.srOption.addProperty("color", 1);
        this.srOption.addProperty(BatteryTypeInf.BATTERY_POWER_LOCK, 4);
        this.srOption.addProperty("backend", 2);
        this.srOption.addProperty("pipeline", 1);
        this.srOption.addProperty("oes_flag", Integer.valueOf(this.oes_flag));
        this.srModuleInfo = new ModuleInfo("VRSR_Module", "c++", "libvrsr.so", "");
        Class[] r105 = {JsonObject.class};
        Class[] r106 = {JsonObject.class};
        if (r110 != 1) goto L23;
        r105[0] = VideoFrame.class;
        r106[0] = VideoFrame.class;
    L23:
        Logging.d("VideoOCLSR: load VRSR Module");     // Catch: Exception -> L18
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r105, r106);     // Catch: Exception -> L18
        Logging.d("VideoOCLSR: load VRSR Module success");     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        Logging.d("VideoOCLSR: load VRSR Module failed," + e.toString());
        return false;
    L11:
        if (r101 != 4) goto L21;
        this.srOption.addProperty("scale", Double.valueOf(1.5d));
        goto L13
    L21:
        Logging.d("VideoOCLSR: unsupported algoType=%d" + r101);
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.bmf_mods_api.VideoOCLSRAPI
    public int OesProcess(int r100, int r101, int r102, int r103, float[] r104, boolean r110) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.srFunc != null) goto L8;
        return -1;
    L8:
        JsonObject r111 = new JsonObject();
        r111.addProperty("input_texture", Integer.valueOf(r100));
        r111.addProperty("output_texture", Integer.valueOf(r101));
        r111.addProperty("width", Integer.valueOf(r102));
        r111.addProperty("height", Integer.valueOf(r103));
        if (this.oes_flag != 1) goto L19;
        JsonArray r105 = new JsonArray();
        int r106 = r104.length;
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L13;
        r105.add(Float.valueOf(r104[r107]));
        r107 = r107 + 1;
        goto L11
    L13:
        r111.add("matrix", r105);
    L19:
        JsonObject r108 = (JsonObject) this.srFunc.call(new Object[]{r111})[0];     // Catch: Exception -> L16
        return r101;
    L16:
        e = move-exception;
        Logging.d("VideoOCLSR: call VRSR module failed," + e.toString());
        e.printStackTrace();
        return -1;
    }
}
