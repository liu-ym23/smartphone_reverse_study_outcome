package com.bytedance.bmf_mods;

import android.graphics.Bitmap;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.VideoSRRaisrAPI;
import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelFormat;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VideoSRRaisrAPI.class}, singleton = true)
public class VideoSRRaisr implements VideoSRRaisrAPI {
    private final int SR_R15_TYPE;
    private final int SR_R_TYPE;
    private int data_type;
    private int scale_type;
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L6;
        r100.free();
        return;
    }

    public VideoSRRaisr() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.data_type = 0;
        this.SR_R_TYPE = 0;
        this.SR_R15_TYPE = 4;
        Logging.d("New VideoSRRaisr");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public Bitmap Process(Bitmap r100, int r101, int r110, boolean r111) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return null;
    L6:
        if (this.data_type == 1) goto L10;
        Logging.d("SR_RAISR_Module: only receive bitmap");
        return null;
    L10:
        if (this.srFunc != null) goto L13;
        Logging.d("SR_RAISR_Module: ModuleFunctor is null");
        return null;
    L13:
        Frame r102 = new Frame(r100);
        PixelFormat r103 = r102.format();
        PixelFormat r104 = PixelFormat.PF_RGBA32;
        if (r103 != r104) goto L16;
        Image r105 = r102.toImage(ChannelFormat.kNHWC);
    L17:
        if (r105 != null) goto L20;
        Logging.d("VideoSRRaisr: srcImage is null");
        return null;
    L20:
        int r106 = r105.width();
        int r107 = r105.height();
        long r108 = r105.data().dataPtr();
        int r109 = this.scale_type;
        if (r109 != 0) goto L23;
        int r112 = (r106 / 2) * 3;
        int r113 = (r107 / 2) * 3;
    L25:
        Bitmap r114 = Bitmap.createBitmap(r112, r113, Bitmap.Config.ARGB_8888);
        Frame r115 = new Frame(r114);
        if (r115.format() != r104) goto L28;
        Image r116 = r115.toImage(ChannelFormat.kNHWC);
    L29:
        if (r116 != null) goto L32;
        Logging.d("VideoSRRaisr: dstImage is null");
        return null;
    L32:
        long r117 = r116.data().dataPtr();
        JsonObject r118 = new JsonObject();
        r118.addProperty("input_width", Integer.valueOf(r106));
        r118.addProperty("input_height", Integer.valueOf(r107));
        r118.addProperty("input_dataPtr", Long.valueOf(r108));
        r118.addProperty("output_dataPtr", Long.valueOf(r117));
        this.srFunc.call(new Object[]{r118});     // Catch: Exception -> L35
        return r114;
    L35:
        e = move-exception;
        Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
        e.printStackTrace();
        return null;
    L28:
        r116 = null;
        goto L29
    L23:
        if (r109 != 1) goto L38;
        r112 = r106 * 2;
        r113 = r107 * 2;
        goto L25
    L38:
        Logging.d("VideoSRRaisr: scale_type is neither 0 nor 1");
        return null;
    L16:
        r105 = null;
        goto L17
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public boolean Init(String r100, int r101, boolean r110, int r111, int r112) {
        return Init(r100, r101, r110, r111, r112, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public int Process(int r100, int r101, int r102, int r103, boolean r104) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.data_type == 0) goto L10;
        Logging.d("SR_RAISR_Module: Process function only receive texture2D");
        return -1;
    L10:
        if (this.srFunc != null) goto L13;
        Logging.d("SR_RAISR_Module: ModuleFunctor is null");
        return -1;
    L13:
        JsonObject r105 = new JsonObject();
        r105.addProperty("input_texture", Integer.valueOf(r100));
        r105.addProperty("output_texture", Integer.valueOf(r101));
        r105.addProperty("width", Integer.valueOf(r102));
        r105.addProperty("height", Integer.valueOf(r103));
        JsonObject r106 = (JsonObject) this.srFunc.call(new Object[]{r105})[0];     // Catch: Exception -> L16
        return r101;
    L16:
        e = move-exception;
        Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
        e.printStackTrace();
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public boolean Init(String r100, int r101, boolean r102, int r103, int r104, int r105) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return false;
    L6:
        if (r102 == false) goto L11;
        if (r105 != 1) goto L10;
        Logging.d("SR_RAISR_Module: data type cannot transfer to OES texture");
        return false;
    L10:
        this.data_type = 2;
    L14:
        if (r101 != 0) goto L17;
        this.scale_type = 1;
    L19:
        this.srOption.addProperty("scale_type", Integer.valueOf(this.scale_type));
        this.srOption.addProperty("data_type", Integer.valueOf(this.data_type));
        this.srModuleInfo = new ModuleInfo("SR_RAISR_Module", "c++", "libbmf_hydra.so", "");
        Class[] r106 = {JsonObject.class};
        Class[] r107 = {JsonObject.class};
        Logging.d("SR_RAISR_Module: load raisr Module");     // Catch: Exception -> L22
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r106, r107);     // Catch: Exception -> L22
        Logging.d("SR_RAISR_Module: load raisr Module success");     // Catch: Exception -> L22
        return true;
    L22:
        e = move-exception;
        Logging.d("SR_RAISR_Module: load raisr Module failed," + e.toString());
        return false;
    L17:
        if (r101 != 4) goto L25;
        this.scale_type = 0;
        goto L19
    L25:
        Logging.d("SR_RAISR_Module: algType param is neither 4 nor 0");
        return false;
    L11:
        if (r105 != 1) goto L13;
        this.data_type = 1;
        goto L14
    L13:
        this.data_type = 0;
        goto L14
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
    @Override // com.bytedance.bmf_mods_api.VideoSRRaisrAPI
    public int OesProcess(int r100, int r101, int r102, int r103, float[] r104, boolean r105) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.data_type == 2) goto L10;
        Logging.d("SR_RAISR_Module: OesProcess function only receive oes texture");
        return -1;
    L10:
        if (this.srFunc != null) goto L13;
        Logging.d("SR_RAISR_Module: ModuleFunctor is null");
        return -1;
    L13:
        JsonObject r106 = new JsonObject();
        r106.addProperty("input_texture", Integer.valueOf(r100));
        r106.addProperty("output_texture", Integer.valueOf(r101));
        r106.addProperty("width", Integer.valueOf(r102));
        r106.addProperty("height", Integer.valueOf(r103));
        JsonArray r107 = new JsonArray();
        int r108 = r104.length;
        int r109 = 0;
    L14:
        if (r109 >= r108) goto L16;
        r107.add(Float.valueOf(r104[r109]));
        r109 = r109 + 1;
        goto L14
    L16:
        r106.add("matrix", r107);
        JsonObject r110 = (JsonObject) this.srFunc.call(new Object[]{r106})[0];     // Catch: Exception -> L19
        return r101;
    L19:
        e = move-exception;
        Logging.d("VideoSRRaisr: call raisr module failed," + e.toString());
        e.printStackTrace();
        return -1;
    }
}
