package com.bytedance.bmf_mods;

import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.ColorShiftAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {ColorShiftAPI.class}, singleton = true)
public class ColorShift implements ColorShiftAPI {
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public ColorShift() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        Logging.d("New ColorShift");
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public int Process(int r100, int r101, int r102, int r103) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.srFunc != null) goto L8;
        return -1;
    L8:
        JsonObject r104 = new JsonObject();
        r104.addProperty("input_texture", Integer.valueOf(r100));
        r104.addProperty("output_texture", Integer.valueOf(r101));
        r104.addProperty("width", Integer.valueOf(r102));
        r104.addProperty("height", Integer.valueOf(r103));
        JsonObject r105 = (JsonObject) this.srFunc.call(new Object[]{r104})[0];     // Catch: Exception -> L11
        return r101;
    L11:
        e = move-exception;
        Logging.d("ColorShift: call ColorShift module failed," + e.toString());
        e.printStackTrace();
        return -1;
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
    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public int oesProcess(int r100, int r101, int r102, int r103, float[] r104) {
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
        JsonArray r106 = new JsonArray();
        int r107 = r104.length;
        int r108 = 0;
    L9:
        if (r108 >= r107) goto L11;
        r106.add(Float.valueOf(r104[r108]));
        r108 = r108 + 1;
        goto L9
    L11:
        r105.add("matrix", r106);
        JsonObject r109 = (JsonObject) this.srFunc.call(new Object[]{r105})[0];     // Catch: Exception -> L14
        return r101;
    L14:
        e = move-exception;
        Logging.d("ColorShift: call ColorShift module failed," + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.ColorShiftAPI
    public boolean Init(boolean r100, float r101, float r102, float[] r103, float[] r104, int r105) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return false;
    L5:
        this.srOption.addProperty("enable_profile", Boolean.valueOf(r100));
        this.srOption.addProperty("bright", Float.valueOf(r101));
        this.srOption.addProperty("saturation", Float.valueOf(r102));
        this.srOption.addProperty("input_texture_type", Integer.valueOf(r105));
        JsonArray r106 = new JsonArray();
        int r107 = r103.length;
        int r108 = 0;
    L6:
        if (r108 >= r107) goto L8;
        r106.add(Float.valueOf(r103[r108]));
        r108 = r108 + 1;
        goto L6
    L8:
        this.srOption.add("shift_positive", r106);
        JsonArray r109 = new JsonArray();
        int r110 = r104.length;
        int r111 = 0;
    L9:
        if (r111 >= r110) goto L11;
        r109.add(Float.valueOf(r104[r111]));
        r111 = r111 + 1;
        goto L9
    L11:
        this.srOption.add("shift_negative", r109);
        this.srModuleInfo = new ModuleInfo("ColorShiftModule", "c++", "libbmf_hydra.so", "");
        Class[] r112 = {JsonObject.class};
        Class[] r113 = {JsonObject.class};
        Logging.d("ColorShift: load ColorShift Module");     // Catch: Exception -> L14
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r112, r113);     // Catch: Exception -> L14
        Logging.d("ColorShift: load ColorShift Module success");     // Catch: Exception -> L14
        return true;
    L14:
        e = move-exception;
        Logging.d("ColorShift: load ColorShift Module failed," + e.toString());
        return false;
    }
}
