package com.bytedance.bmf_mods;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bmf.JsonParam;
import com.bytedance.bmf.ModuleFunctor;
import com.bytedance.bmf.ModuleInfo;
import com.bytedance.bmf_mods.common.Logging;
import com.bytedance.bmf_mods.common.SoLoader;
import com.bytedance.bmf_mods_api.BmfException;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPI;
import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelFormat;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import com.ss.texturerender.TextureRenderKeys;

/* JADX INFO: loaded from: classes44.dex */
@ServiceImpl(service = {VideoSuperResolutionAPI.class}, singleton = true)
public class VideoSuperResolution implements VideoSuperResolutionAPI {
    private int algType_;
    private int mBackend;
    private long mNativePtr;
    private int scaleType;
    private ModuleFunctor srFunc;
    private ModuleInfo srModuleInfo;
    private JsonObject srOption;

    private native long nativeCreateSuperResolution();

    private native int nativeInitSuperResolution(long r100, int r101, int r102, int r103, int r104, int r105, int r106, String r107, String r110, String r111, int r112);

    private native void nativeReleaseSuperResolution(long r100);

    private native int nativeSuperResolutionGetQueuingTaskNum(long r100);

    private native int nativeSuperResolutionGetResultTexture(long r100);

    private native int nativeSuperResolutionOesProcess(long r100, int r101, float[] r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, long r112);

    private native int nativeSuperResolutionOesProcessMultiScale(long r100, int r101, float[] r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, long r112, int r113, int r114);

    private native int nativeSuperResolutionOesYuvProcess(long r100, int r101, int r102, int r103, float[] r104, float[] r105, float[] r106, boolean r107);

    private native int nativeSuperResolutionProcess(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, long r111);

    private native int nativeSuperResolutionProcessBitmap(long r100, Bitmap r101, Bitmap r102);

    private native int nativeSuperResolutionProcessBitmapMultiScale(long r100, Bitmap r101, Bitmap r102, int r103, int r104);

    private native int nativeSuperResolutionProcessMultiScale(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, long r111, int r112, int r113);

    private native int nativeSuperResolutionProcessYuv(long r100, long r101, long r102, long r103, int r104, int r110, int r111, int r112);

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public void Free() {
        ModuleFunctor r100 = this.srFunc;
        if (r100 == null) goto L5;
        r100.free();
    L5:
        long r101 = this.mNativePtr;
        if (r101 == 0) goto L9;
        nativeReleaseSuperResolution(r101);
        return;
    }

    public VideoSuperResolution() {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.scaleType = 0;
        this.algType_ = -1;
        this.mBackend = 0;
        this.mNativePtr = 0;
        Logging.d("New VideoSuperResolution");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int GetQueuingTaskNum() {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.algType_ == 7) goto L8;
    L12:
        return -1;
    L8:
        if (this.mBackend != 3) goto L12;
        return nativeSuperResolutionGetQueuingTaskNum(this.mNativePtr);
    }

    public VideoSuperResolution(Context r100) {
        this.srOption = new JsonObject();
        this.srModuleInfo = null;
        this.srFunc = null;
        this.scaleType = 0;
        this.algType_ = -1;
        this.mBackend = 0;
        this.mNativePtr = 0;
        Logging.d("New VideoSuperResolution with context");
        SoLoader.getInstance().setContext(r100);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public Bitmap ProcessBitmap(Bitmap r210, int r211, int r212) throws BmfException {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return null;
    L6:
        if (this.algType_ > 2) goto L67;
        if (this.srFunc != null) goto L10;
        return null;
    L10:
        if (r210 != null) goto L13;
        Logging.d("VideoSuperResolution: srcBmp is null");
        return null;
    L13:
        Frame r100 = new Frame(r210);
        PixelFormat r101 = r100.format();
        PixelFormat r102 = PixelFormat.PF_RGBA32;
        if (r101 != r102) goto L16;
        Image r110 = r100.toImage(ChannelFormat.kNHWC);
    L17:
        if (r110 != null) goto L20;
        Logging.d("VideoSuperResolution: srcImage is null");
        return null;
    L20:
        int r103 = r110.width();
        int r111 = r110.height();
        long r112 = r110.data().dataPtr();
        int r113 = this.scaleType;
        if (r113 != 0) goto L23;
        int r104 = r103 * 2;
        int r105 = r111 * 2;
    L25:
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
        Frame r114 = new Frame(r106);
        if (r114.format() != r102) goto L28;
        Image r107 = r114.toImage(ChannelFormat.kNHWC);
    L29:
        if (r107 != null) goto L32;
        Logging.d("VideoSuperResolution: dstImage is null");
        return null;
    L32:
        long r115 = r107.data().dataPtr();
        int r108 = r210.getRowBytes();
        int r109 = r106.getRowBytes();
        if (r108 < r103) goto L62;
        if (r109 < r104) goto L62;
        JsonParam r116 = new JsonParam();
        Image r117 = r107;
        r116.set("mode", 0);     // Catch: Throwable -> L49 Exception -> L51
        r116.set("input_data_type", 4);     // Catch: Throwable -> L49 Exception -> L51
        r116.set("width", Integer.valueOf(r103));     // Catch: Throwable -> L49 Exception -> L51
        r116.set("height", Integer.valueOf(r111));     // Catch: Throwable -> L49 Exception -> L51
        r116.set("input_stride", Integer.valueOf(r108));     // Catch: Throwable -> L49 Exception -> L51
        r116.set("output_stride", Integer.valueOf(r109));     // Catch: Throwable -> L49 Exception -> L51
        r116.set("input_dataPtr", Long.valueOf(r112));     // Catch: Throwable -> L49 Exception -> L51
        r116.set("output_dataPtr", Long.valueOf(r115));     // Catch: Throwable -> L49 Exception -> L51
        Object[] r118 = this.srFunc.call(new Object[]{r116});     // Catch: Throwable -> L49 Exception -> L51
        if (r118 != null) goto L42;
    L45:
        r106.recycle();     // Catch: Throwable -> L49 Exception -> L51
        Bitmap r119 = null;
    L47:
        r116.free();
        r100.free();
        r100.unlock(r210);
        r110.free();
        r114.free();
        r114.unlock(r119);
        r117.free();
        return r119;
    L42:
        if (((JsonParam) r118[0]).getInt("output_texture") == (-1)) goto L45;
        r119 = r106;
    L51:
        e = move-exception;
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L49
        e.printStackTrace();     // Catch: Throwable -> L49
        r116.free();
        r100.free();
        r100.unlock(r210);
        r110.free();
        r114.free();
        r114.unlock(r106);
        r117.free();
        return null;
    L49:
        th = move-exception;
        r116.free();
        r100.free();
        r100.unlock(r210);
        r110.free();
        r114.free();
        r114.unlock(r106);
        r117.free();
        throw th;
    L62:
        Logging.d("VideoSuperResolution: bitmap stride is smaller than bitmap width");
        return null;
    L28:
        r107 = null;
        goto L29
    L23:
        if (r113 != 1) goto L64;
        r104 = (r103 * 3) / 2;
        r105 = (r111 * 3) / 2;
        goto L25
    L64:
        Logging.d("VideoSuperResolution: scaleType is neither 0 nor 1");
        return null;
    L16:
        r110 = null;
        goto L17
    L67:
        if (r210 == null) goto L86;
        if (this.mNativePtr == 0) goto L84;
        int r120 = r210.getWidth();
        int r121 = r210.getHeight();
        int r122 = this.scaleType;
        if (r122 != 0) goto L74;
        int r123 = r120 * 2;
        int r124 = r121 * 2;
    L76:
        Bitmap r125 = Bitmap.createBitmap(r123, r124, Bitmap.Config.ARGB_8888);
        int r126 = nativeSuperResolutionProcessBitmap(this.mNativePtr, r210, r125);
        if (r126 < 0) goto L79;
        return r125;
    L79:
        r125.recycle();
        throw new BmfException(r126, "Process Bitmap failed, error code: " + r126);
    L74:
        if (r122 != 1) goto L81;
        r123 = (r120 * 3) / 2;
        r124 = (r121 * 3) / 2;
        goto L76
    L81:
        Logging.d("VideoSuperResolution: scaleType is neither 0 nor 1");
        throw new BmfException(-100020, "ScaleType not valid");
    L84:
        throw new BmfException(-100010, "VideoSuperResolution not initialized");
    L86:
        throw new BmfException(-100020, "Input bitmap is null");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public Bitmap ProcessMultiScaleBitmap(Bitmap r210, int r211, int r212) throws BmfException {
        int r100 = this.algType_;
        if (r100 > 2) goto L69;
        if (this.srFunc != null) goto L7;
        return null;
    L7:
        if (r210 != null) goto L10;
        Logging.d("VideoSuperResolution: srcBmp is null");
        return null;
    L10:
        if (r100 != 0) goto L13;
        if (r212 == 0) goto L15;
        if (r212 != 2) goto L13;
    L15:
        Frame r101 = new Frame(r210);
        PixelFormat r102 = r101.format();
        PixelFormat r103 = PixelFormat.PF_RGBA32;
        if (r102 != r103) goto L18;
        Image r110 = r101.toImage(ChannelFormat.kNHWC);
    L19:
        if (r110 != null) goto L22;
        Logging.d("VideoSuperResolution: srcImage is null");
        return null;
    L22:
        int r104 = r110.width();
        int r111 = r110.height();
        long r112 = r110.data().dataPtr();
        int r113 = this.scaleType;
        if (r113 != 0) goto L25;
        int r105 = r104 * 2;
        int r114 = r111 * 2;
    L27:
        Bitmap r115 = Bitmap.createBitmap(r105, r114, Bitmap.Config.ARGB_8888);
        Frame r116 = new Frame(r115);
        if (r116.format() != r103) goto L30;
        Image r106 = r116.toImage(ChannelFormat.kNHWC);
    L31:
        if (r106 != null) goto L34;
        Logging.d("VideoSuperResolution: dstImage is null");
        return null;
    L34:
        long r117 = r106.data().dataPtr();
        int r107 = r210.getRowBytes();
        int r108 = r115.getRowBytes();
        if (r107 < r104) goto L62;
        if (r108 < r105) goto L62;
        JsonParam r109 = new JsonParam();
        r109.set("mode", 0);     // Catch: Exception -> L51 Throwable -> L53
        r109.set("input_data_type", 4);     // Catch: Exception -> L51 Throwable -> L53
        r109.set("width", Integer.valueOf(r104));     // Catch: Exception -> L51 Throwable -> L53
        r109.set("height", Integer.valueOf(r111));     // Catch: Exception -> L51 Throwable -> L53
        r109.set("input_stride", Integer.valueOf(r107));     // Catch: Exception -> L51 Throwable -> L53
        r109.set("output_stride", Integer.valueOf(r108));     // Catch: Exception -> L51 Throwable -> L53
        r109.set("input_dataPtr", Long.valueOf(r112));     // Catch: Exception -> L51 Throwable -> L53
        r109.set("output_dataPtr", Long.valueOf(r117));     // Catch: Exception -> L51 Throwable -> L53
        Object[] r118 = this.srFunc.call(new Object[]{r109});     // Catch: Exception -> L51 Throwable -> L53
        if (r118 != null) goto L44;
    L47:
        r115.recycle();     // Catch: Exception -> L51 Throwable -> L53
        Bitmap r119 = null;
    L49:
        r109.free();
        r101.free();
        r101.unlock(r210);
        r110.free();
        r116.free();
        r116.unlock(r119);
        r106.free();
        return r119;
    L44:
        if (((JsonParam) r118[0]).getInt("output_texture") == (-1)) goto L47;
        r119 = r115;
    L51:
        e = move-exception;
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L53
        e.printStackTrace();     // Catch: Throwable -> L53
        r109.free();
        r101.free();
        r101.unlock(r210);
        r110.free();
        r116.free();
        r116.unlock(r115);
        r106.free();
        return null;
    L53:
        th = move-exception;
        r109.free();
        r101.free();
        r101.unlock(r210);
        r110.free();
        r116.free();
        r116.unlock(r115);
        r106.free();
        throw th;
    L62:
        Logging.d("VideoSuperResolution: bitmap stride is smaller than bitmap width");
        return null;
    L30:
        r106 = null;
        goto L31
    L25:
        if (r113 != 1) goto L64;
        r114 = (r111 * 3) / 2;
        r105 = (r104 * 3) / 2;
        goto L27
    L64:
        Logging.d("VideoSuperResolution: scaleType is neither 0 nor 1");
        return null;
    L18:
        r110 = null;
    L13:
        if (r100 != 1) goto L67;
        if (r212 == 1) goto L15;
    L67:
        return null;
    L69:
        if (r210 == null) goto L118;
        if (this.mNativePtr == 0) goto L116;
        if (r100 >= 7) goto L91;
        int r120 = this.scaleType;
        if (r120 == r212) goto L78;
        if (r120 != 0) goto L91;
        if (r212 != 2) goto L91;
    L78:
        int r121 = r210.getWidth();
        int r122 = r210.getHeight();
        int r123 = this.scaleType;
        if (r123 != 0) goto L82;
        int r124 = r121 * 2;
        int r125 = r122 * 2;
    L84:
        Bitmap r126 = Bitmap.createBitmap(r124, r125, Bitmap.Config.ARGB_8888);
        int r127 = nativeSuperResolutionProcessBitmap(this.mNativePtr, r210, r126);
        if (r127 < 0) goto L87;
        return r126;
    L87:
        r126.recycle();
        throw new BmfException(r127, "Process Bitmap failed, error code: " + r127);
    L82:
        if (r123 != 1) goto L89;
        r124 = (r121 * 3) / 2;
        r125 = (r122 * 3) / 2;
        goto L84
    L89:
        Logging.d("VideoSuperResolution: scaleType is neither 0/2 nor 1");
        throw new BmfException(-100020, "ScaleType not valid");
    L91:
        if (r100 < 7) goto L113;
        if (r212 != 0) goto L94;
    L107:
        float r128 = 2.0f;
    L108:
        Bitmap r129 = Bitmap.createBitmap((int) (r210.getWidth() * r128), (int) (r210.getHeight() * r128), Bitmap.Config.ARGB_8888);
        int r130 = nativeSuperResolutionProcessBitmapMultiScale(this.mNativePtr, r210, r129, r211, r212);
        if (r130 < 0) goto L111;
        return r129;
    L111:
        r129.recycle();
        throw new BmfException(r130, "Process Bitmap failed, error code: " + r130);
    L94:
        if (r212 == 1) goto L106;
        if (r212 == 2) goto L107;
        if (r212 != 4) goto L99;
        r128 = 1.1f;
        goto L108
    L99:
        if (r212 != 8) goto L101;
        r128 = 1.2f;
        goto L108
    L101:
        if (r212 == 16) goto L103;
        r128 = 1.4f;
        goto L108
    L103:
        r128 = 1.3f;
        goto L108
    L106:
        r128 = 1.5f;
        goto L108
    L113:
        return null;
    L116:
        throw new BmfException(-100010, "VideoSuperResolution not initialized");
    L118:
        throw new BmfException(-100020, "Input bitmap is null");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessTexture(int r110, int r111, int r112) {
        return ProcessTexture(r110, r111, r112, 0, 0, 0, 0, 0, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113) {
        return ProcessOesTexture(r110, r111, r112, r113, 0, 0, 0, 0, 0, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int r100, int r110, int r111, int r112, String r113, String r114) {
        return Init(r100, r110, r111, r112, r113, r114, "");
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int r110, int r111, int r112, int r113, String r114, String r115, String r116) {
        return Init(r110, r111, r112, r113, r114, r115, r116, 0, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessOesTexture(int r110, int r111, int r112, float[] r113, float[] r114, float[] r115, boolean r116) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L8;
    L14:
        return -1;
    L8:
        if (this.algType_ <= 2) goto L14;
        if (nativeSuperResolutionOesYuvProcess(r100, r110, r111, r112, r113, r114, r115, r116) != 0) goto L14;
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessYuv420p(long r110, long r111, long r210, int r211, int r212, int r213, int r214) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.algType_ <= 2) goto L8;
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L35;
        return -1;
    L35:
        if (nativeSuperResolutionProcessYuv(r100, r110, r111, r210, r213, r214, r211, r212) == 0) goto L37;
        return -1;
    L37:
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    L8:
        if (this.srFunc != null) goto L10;
        return -1;
    L10:
        JsonParam r101 = new JsonParam();
        JsonParam r102 = null;
        r101.set("mode", 0);     // Catch: Throwable -> L19 Exception -> L21
        r101.set("input_data_type", 3);     // Catch: Throwable -> L19 Exception -> L21
        r101.set("y_ptr", Long.valueOf(r110));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("u_ptr", Long.valueOf(r111));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("v_ptr", Long.valueOf(r210));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("color_space", Integer.valueOf(r211));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("color_range", Integer.valueOf(r212));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("width", Integer.valueOf(r213));     // Catch: Throwable -> L19 Exception -> L21
        r101.set("height", Integer.valueOf(r214));     // Catch: Throwable -> L19 Exception -> L21
        JsonParam r103 = (JsonParam) this.srFunc.call(new Object[]{r101})[0];     // Catch: Throwable -> L19 Exception -> L21
        int r104 = r103.getInt("output_texture");     // Catch: Throwable -> L15 Exception -> L17
        r101.free();
        r103.free();
        return r104;
    L17:
        e = e;
        r102 = r103;
    L22:
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L19
        e.printStackTrace();     // Catch: Throwable -> L19
        r101.free();
        if (r102 == null) goto L26;
        r102.free();
    L26:
        return -1;
    L15:
        th = th;
        r102 = r103;
    L27:
        r101.free();
        if (r102 == null) goto L30;
        r102.free();
    L30:
        throw th;
    L19:
        th = th;
    L21:
        e = e;
        goto L22
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int r110, int r111, int r112, int r113, String r114, String r115, String r116, int r117, int r210) {
        return Init(r110, r111, r112, r113, r114, r115, r116, r117, r210, 0);
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessTexture(int r110, int r111, int r112, int r210, int r211, int r212, int r213, int r214, long r215) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.algType_ <= 2) goto L8;
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L58;
        return -1;
    L58:
        if (nativeSuperResolutionProcess(r100, r110, r111, r112, r210, r211, r212, r213, r214, r215) == 0) goto L60;
        return -1;
    L60:
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    L8:
        if (this.srFunc != null) goto L10;
        return -1;
    L10:
        if (r210 < 0) goto L52;
        if (r211 < 0) goto L52;
        if ((r210 + r212) > r111) goto L52;
        if ((r211 + r213) > r112) goto L52;
        if (r214 == 0) goto L20;
        if (r214 != 1) goto L52;
    L20:
        if (r215 < 0) goto L52;
        if ((r215 >> 32) > 0) goto L52;
        if (r214 != 0) goto L27;
        long r113 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L28:
        JsonParam r114 = new JsonParam();
        r114.set("mode", 0);     // Catch: Throwable -> L37 Exception -> L39
        r114.set("input_data_type", 0);     // Catch: Throwable -> L37 Exception -> L39
        r114.set("input_texture", Integer.valueOf(r110));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("width", Integer.valueOf(r111));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("height", Integer.valueOf(r112));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_w_start", Integer.valueOf(r101));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_h_start", Integer.valueOf(r102));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_w", Integer.valueOf(r103));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_h", Integer.valueOf(r104));     // Catch: Throwable -> L37 Exception -> L39
        r114.set(TextureRenderKeys.KEY_IS_ROI_MODE, Integer.valueOf(r214));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("roiBackground", Long.valueOf(r113));     // Catch: Throwable -> L37 Exception -> L39
        JsonParam r105 = (JsonParam) this.srFunc.call(new Object[]{r114})[0];     // Catch: Throwable -> L37 Exception -> L39
        int r106 = r105.getInt("output_texture");     // Catch: Throwable -> L33 Exception -> L35
        r114.free();
        r105.free();
        return r106;
    L35:
        e = e;
        JsonParam r115 = r105;
    L63:
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L47
        e.printStackTrace();     // Catch: Throwable -> L47
        r114.free();
        if (r115 == null) goto L69;
        r115.free();
        return -1;
    L69:
        return -1;
    L47:
        th = th;
    L48:
        r114.free();
        if (r115 == null) goto L51;
        r115.free();
    L51:
        throw th;
    L33:
        th = th;
        r115 = r105;
        goto L48
    L39:
        e = e;
        r115 = null;
    L37:
        th = th;
        r115 = null;
        goto L48
    L27:
        r101 = r210;
        r102 = r211;
        r103 = r212;
        r104 = r213;
        r113 = r215;
    L52:
        Logging.d("VideoSuperResolution: ROI param incorrect");
        return -1;
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int Init(int r110, int r210, int r211, int r212, String r213, String r214, String r215, int r216, int r217, int r218) {
        int r100 = r212;
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        this.scaleType = r211;
        this.algType_ = r110;
        this.mBackend = r210;
        if (r110 >= 0) goto L8;
    L49:
        Logging.d("VideoSuperResolution: alg_type or backend is not support. check input param  alg_type:" + r110 + " backend:" + r210 + " scale_type:" + r211 + " pool_size:" + r100 + " libpath:" + r213 + " licenseModuleName:" + r214 + " programCacheDir:" + r215 + " max_width:" + r216 + " max_height:" + r217);
        return -1;
    L8:
        if (r110 > 12) goto L49;
        if (r210 < 0) goto L49;
        if (r210 > 4) goto L49;
        if (r110 > 2) goto L30;
        if (r211 != 2) goto L17;
        this.scaleType = 0;
    L17:
        this.srOption.addProperty("backend", Integer.valueOf(r210));
        this.srOption.addProperty(TextureRenderKeys.KEY_IS_BMF_SHARPEN_ALG_TYPE, Integer.valueOf(r110));
        this.srOption.addProperty("scale_type", Integer.valueOf(this.scaleType));
        if (r100 > 0) goto L20;
        Logging.d("VideoSuperResolution: pool size should be more than 0, change to 6 for default");
        r100 = 6;
    L20:
        this.srOption.addProperty("pool_size", Integer.valueOf(r100));
        this.srOption.addProperty("license_module_name", r214);
        this.srOption.addProperty(TextureRenderKeys.KEY_IS_BMF_SHARPEN_PROGRAME_CACHE_DIR, r215);
        if (r216 <= 0) goto L24;
        if (r217 <= 0) goto L24;
        this.srOption.addProperty(TextureRenderKeys.KEY_IS_MAX_WIDTH, Integer.valueOf(r216));
        this.srOption.addProperty(TextureRenderKeys.KEY_IS_MAX_HEIGHT, Integer.valueOf(r217));
    L24:
        this.srModuleInfo = new ModuleInfo("SuperResolutionModule", "c++", "libbmf_hydra.so", "");
        Class[] r101 = {JsonParam.class};
        Class[] r102 = {JsonParam.class};
        Logging.d("VideoSuperResolution: load VideoSuperResolution Module");     // Catch: Exception -> L27
        this.srFunc = new ModuleFunctor(this.srModuleInfo, this.srOption, r101, r102);     // Catch: Exception -> L27
        Logging.d("VideoSuperResolution: load VideoSuperResolution Module success");     // Catch: Exception -> L27
        return 0;
    L27:
        e = move-exception;
        Logging.d(String.format("VideoSuperResolution: load VideoSuperResolution Module failed, %s", new Object[]{e.toString()}));
        return -1;
    L30:
        String r111 = "";
        long r112 = nativeCreateSuperResolution();
        this.mNativePtr = r112;
        if (r112 != 0) goto L33;
        return -1;
    L33:
        int r103 = r110 - 3;
        if (r103 < 4) goto L36;
    L38:
        if (r213 != null) goto L40;
        String r113 = r111;
    L41:
        if (r214 != null) goto L43;
        String r114 = r111;
    L44:
        if (r215 == null) goto L48;
        r111 = r215;
    L48:
        return nativeInitSuperResolution(r112, r103, r210, this.scaleType, r212, r216, r217, r113, r114, r111, r218);
    L43:
        r114 = r214;
        goto L44
    L40:
        r113 = r213;
        goto L41
    L36:
        if (this.scaleType != 2) goto L38;
        this.scaleType = 0;
        goto L38
    }

    @Override // com.bytedance.bmf_mods_api.VideoSuperResolutionAPI
    public int ProcessOesTexture(int r110, int r111, int r210, float[] r211, int r212, int r213, int r214, int r215, int r216, long r217) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L6;
        return -1;
    L6:
        if (this.algType_ <= 2) goto L8;
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L57;
        return -1;
    L57:
        if (nativeSuperResolutionOesProcess(r100, r110, r211, r111, r210, r212, r213, r214, r215, r216, r217) == 0) goto L59;
        return -1;
    L59:
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    L8:
        if (this.srFunc != null) goto L10;
        return -1;
    L10:
        if (r212 < 0) goto L51;
        if (r213 < 0) goto L51;
        if ((r212 + r214) > r111) goto L51;
        if ((r213 + r215) > r210) goto L51;
        if (r216 == 0) goto L20;
        if (r216 != 1) goto L51;
    L20:
        if (r217 < 0) goto L51;
        if ((r217 >> 32) > 0) goto L51;
        if (r216 != 0) goto L27;
        long r112 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r113 = 0;
    L28:
        JsonParam r114 = new JsonParam();
        r114.set("mode", 0);     // Catch: Throwable -> L37 Exception -> L39
        r114.set("input_data_type", 2);     // Catch: Throwable -> L37 Exception -> L39
        r114.set("input_texture", Integer.valueOf(r110));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("width", Integer.valueOf(r111));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("height", Integer.valueOf(r210));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("matrix", r211);     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_w_start", Integer.valueOf(r101));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_h_start", Integer.valueOf(r102));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_w", Integer.valueOf(r103));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("in_roi_h", Integer.valueOf(r113));     // Catch: Throwable -> L37 Exception -> L39
        r114.set(TextureRenderKeys.KEY_IS_ROI_MODE, Integer.valueOf(r216));     // Catch: Throwable -> L37 Exception -> L39
        r114.set("roiBackground", Long.valueOf(r112));     // Catch: Throwable -> L37 Exception -> L39
        JsonParam r104 = (JsonParam) this.srFunc.call(new Object[]{r114})[0];     // Catch: Throwable -> L37 Exception -> L39
        int r105 = r104.getInt("output_texture");     // Catch: Throwable -> L33 Exception -> L35
        r114.free();
        r104.free();
        return r105;
    L35:
        e = e;
        JsonParam r115 = r104;
    L61:
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L46
        e.printStackTrace();     // Catch: Throwable -> L46
        r114.free();
        if (r115 == null) goto L45;
        r115.free();
    L45:
        return -1;
    L46:
        th = th;
    L47:
        r114.free();
        if (r115 == null) goto L50;
        r115.free();
    L50:
        throw th;
    L33:
        th = th;
        r115 = r104;
        goto L47
    L39:
        e = e;
        r115 = null;
    L37:
        th = th;
        r115 = null;
        goto L47
    L27:
        r101 = r212;
        r102 = r213;
        r103 = r214;
        r113 = r215;
        r112 = r217;
    L51:
        Logging.d("VideoSuperResolution: ROI param incorrect");
        return -1;
    }

    public int ProcessMultiScaleTexture(int r110, int r111, int r210, int r211, int r212, int r213, int r214, int r215, long r216, int r217, int r218) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        int r100 = this.algType_;
        if (r100 > 2) goto L60;
        if (r211 < 0) goto L58;
        if (r212 < 0) goto L58;
        if ((r211 + r213) > r111) goto L58;
        if ((r212 + r214) > r210) goto L58;
        if (r215 == 0) goto L17;
        if (r215 != 1) goto L58;
    L17:
        if (r216 < 0) goto L58;
        if ((r216 >> 32) > 0) goto L58;
        if (r215 != 0) goto L24;
        long r112 = 0;
        int r101 = 0;
        int r102 = 0;
        int r113 = 0;
        int r114 = 0;
    L25:
        if (r100 == 0) goto L27;
        if (r100 == 2) goto L27;
    L30:
        if (r100 != 1) goto L34;
        if (r218 == 0) goto L35;
        if (r218 != 2) goto L34;
    L35:
        JsonParam r103 = new JsonParam();
        r103.set("mode", 0);     // Catch: Throwable -> L44 Exception -> L46
        r103.set("input_data_type", 0);     // Catch: Throwable -> L44 Exception -> L46
        r103.set("input_texture", Integer.valueOf(r110));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("width", Integer.valueOf(r111));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("height", Integer.valueOf(r210));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_w_start", Integer.valueOf(r101));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_h_start", Integer.valueOf(r102));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_w", Integer.valueOf(r113));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_h", Integer.valueOf(r114));     // Catch: Throwable -> L44 Exception -> L46
        r103.set(TextureRenderKeys.KEY_IS_ROI_MODE, Integer.valueOf(r215));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("roiBackground", Long.valueOf(r112));     // Catch: Throwable -> L44 Exception -> L46
        JsonParam r104 = (JsonParam) this.srFunc.call(new Object[]{r103})[0];     // Catch: Throwable -> L44 Exception -> L46
        int r105 = r104.getInt("output_texture");     // Catch: Throwable -> L40 Exception -> L42
        r103.free();
        r104.free();
        return r105;
    L42:
        e = e;
        JsonParam r106 = r104;
    L80:
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L53
        e.printStackTrace();     // Catch: Throwable -> L53
        r103.free();
        if (r106 == null) goto L52;
        r106.free();
    L52:
        return -1;
    L53:
        th = th;
    L54:
        r103.free();
        if (r106 == null) goto L57;
        r106.free();
    L57:
        throw th;
    L40:
        th = th;
        r106 = r104;
        goto L54
    L46:
        e = e;
        r106 = null;
    L44:
        th = th;
        r106 = null;
    L34:
        return -1;
    L27:
        if (r218 == 0) goto L35;
        if (r218 == 1) goto L35;
        if (r218 == 2) goto L35;
    L24:
        r101 = r211;
        r102 = r212;
        r113 = r213;
        r114 = r214;
        r112 = r216;
    L58:
        Logging.d("VideoSuperResolution: ROI param incorrect");
        return -1;
    L60:
        long r107 = this.mNativePtr;
        if (r107 != 0) goto L64;
        return -1;
    L64:
        if (r100 >= 7) goto L73;
        int r108 = this.scaleType;
        if (r108 == r218) goto L70;
        if (r108 != 0) goto L73;
        if (r218 != 2) goto L73;
    L70:
        if (nativeSuperResolutionProcess(r107, r110, r111, r210, r211, r212, r213, r214, r215, r216) != 0) goto L79;
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    L79:
        return -1;
    L73:
        if (r100 < 7) goto L79;
        if (nativeSuperResolutionProcessMultiScale(r107, r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218) != 0) goto L79;
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    }

    public int ProcessMultiScaleOesTexture(int r210, int r211, int r212, float[] r213, int r214, int r215, int r216, int r217, int r218, long r310, int r311, int r312) {
        if (SoLoader.getInstance().isSoInitialized() == true) goto L5;
        return -1;
    L5:
        int r100 = this.algType_;
        if (r100 > 2) goto L58;
        if (r214 < 0) goto L56;
        if (r215 < 0) goto L56;
        if ((r214 + r216) > r211) goto L56;
        if ((r215 + r217) > r212) goto L56;
        if (r218 == 0) goto L17;
        if (r218 != 1) goto L56;
    L17:
        if (r310 < 0) goto L56;
        if ((r310 >> 32) > 0) goto L56;
        if (r218 != 0) goto L24;
        long r110 = 0;
        int r101 = 0;
        int r102 = 0;
        int r111 = 0;
        int r112 = 0;
    L25:
        if (r100 == 0) goto L27;
        if (r100 == 2) goto L27;
    L30:
        if (r100 != 1) goto L34;
        if (r312 == 0) goto L35;
        if (r312 != 2) goto L34;
    L35:
        JsonParam r103 = new JsonParam();
        JsonParam r113 = null;
        r103.set("mode", 0);     // Catch: Throwable -> L44 Exception -> L46
        r103.set("input_data_type", 2);     // Catch: Throwable -> L44 Exception -> L46
        r103.set("input_texture", Integer.valueOf(r210));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("width", Integer.valueOf(r211));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("height", Integer.valueOf(r212));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("matrix", r213);     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_w_start", Integer.valueOf(r101));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_h_start", Integer.valueOf(r102));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_w", Integer.valueOf(r111));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("in_roi_h", Integer.valueOf(r112));     // Catch: Throwable -> L44 Exception -> L46
        r103.set(TextureRenderKeys.KEY_IS_ROI_MODE, Integer.valueOf(r218));     // Catch: Throwable -> L44 Exception -> L46
        r103.set("roiBackground", Long.valueOf(r110));     // Catch: Throwable -> L44 Exception -> L46
        JsonParam r104 = (JsonParam) this.srFunc.call(new Object[]{r103})[0];     // Catch: Throwable -> L44 Exception -> L46
        int r105 = r104.getInt("output_texture");     // Catch: Throwable -> L40 Exception -> L42
        r103.free();
        r104.free();
        return r105;
    L42:
        e = e;
        r113 = r104;
    L47:
        Logging.d("VideoSuperResolution: call VideoSuperResolution module failed, " + e.toString());     // Catch: Throwable -> L44
        e.printStackTrace();     // Catch: Throwable -> L44
        r103.free();
        if (r113 == null) goto L51;
        r113.free();
    L51:
        return -1;
    L40:
        th = th;
        r113 = r104;
    L52:
        r103.free();
        if (r113 == null) goto L55;
        r113.free();
    L55:
        throw th;
    L46:
        e = e;
    L44:
        th = th;
    L34:
        return -1;
    L27:
        if (r312 == 0) goto L35;
        if (r312 == 1) goto L35;
        if (r312 == 2) goto L35;
    L24:
        r101 = r214;
        r102 = r215;
        r111 = r216;
        r112 = r217;
        r110 = r310;
    L56:
        Logging.d("VideoSuperResolution: ROI param incorrect");
        return -1;
    L58:
        long r106 = this.mNativePtr;
        if (r106 != 0) goto L62;
        return -1;
    L62:
        if (r100 >= 7) goto L71;
        int r107 = this.scaleType;
        if (r107 == r312) goto L68;
        if (r107 != 0) goto L71;
        if (r312 != 2) goto L71;
    L68:
        if (nativeSuperResolutionOesProcess(r106, r210, r213, r211, r212, r214, r215, r216, r217, r218, r310) != 0) goto L77;
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    L77:
        return -1;
    L71:
        if (r100 < 7) goto L77;
        if (nativeSuperResolutionOesProcessMultiScale(r106, r210, r213, r211, r212, r214, r215, r216, r217, r218, r310, r311, r312) != 0) goto L77;
        return nativeSuperResolutionGetResultTexture(this.mNativePtr);
    }
}
