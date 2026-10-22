package com.ss.texturerender;

import android.content.Context;
import com.bytedance.bmf_mods_lite_api.packageHandler.ParamApi;
import com.bytedance.bmf_mods_lite_api.packageHandler.VideoFrameApi;
import java.util.HashMap;
import nc4.a;
import oc4.b;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSDR2HDRWrapper implements b {
    private final String LOG_TAG;
    private String downloadModelPathDir;
    private String mCacheDir;
    private ParamApi mInParam;
    private int mIndex;
    private volatile boolean mInitialized;
    private volatile boolean mInitializing;
    private int mMaxInstanceSize;
    private int[] mModelIds;
    private ParamApi mOutParam;
    private a mPackageHandler;
    private int mPoolSize;
    private int mProcessCount;
    private VideoFrameApi mProcessInFrame;
    private VideoFrameApi mProcessOutFrame;
    private float mProcessSaturation;
    private int mProcessTextureFormat;
    private final int mTexType;

    public void release() {
        this.mInitializing = false;
        this.mInitialized = false;
        VideoFrameApi r100 = this.mProcessInFrame;
        if (r100 == null) goto L5;
        r100.release();
        this.mProcessInFrame = null;
    L5:
        ParamApi r101 = this.mInParam;
        if (r101 == null) goto L8;
        r101.release();
        this.mInParam = null;
    L8:
        VideoFrameApi r102 = this.mProcessOutFrame;
        if (r102 == null) goto L11;
        r102.release();
        this.mProcessOutFrame = null;
    L11:
        ParamApi r103 = this.mOutParam;
        if (r103 == null) goto L14;
        r103.release();
        this.mOutParam = null;
    L14:
        a r104 = this.mPackageHandler;
        if (r104 == null) goto L18;
        r104.release();
        this.mPackageHandler = null;
        return;
    }

    private void createHandler() {
        ParamApi r100 = (ParamApi) nc4.b.b("Param");
        if (r100 != null) goto L6;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, create handler param");
        return;
    L6:
        r100.setInt(101, this.mIndex);
        r100.setInt(103, this.mPoolSize);
        r100.setString(102, "sdr2hdr");
        r100.setInt(104, this.mMaxInstanceSize);
        a r101 = (a) nc4.b.b("PackageHandler");
        if (r101 != null) goto L11;
        r100.release();
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, create handler");
        return;
    L11:
        if (r101.init() == 0) goto L14;
        r100.release();
        r101.release();
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, init");
        return;
    L14:
        this.mPackageHandler = r101;
        this.mInitialized = true;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR handler success");
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public boolean isInitializing() {
        return this.mInitializing;
    }

    public VideoSDR2HDRWrapper(int r100) {
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
        this.downloadModelPathDir = null;
        this.mPackageHandler = null;
        this.mInitializing = false;
        this.mInitialized = false;
    }

    public void callback(int r100, String r101) {
        if (r100 != 0) goto L4;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "init SDR2HDR download, status:" + r100 + ", modelDir:" + r101);
        this.downloadModelPathDir = r101;
        createHandler();
        this.mInitializing = false;
        return;
    L4:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, download status:" + r100);
    }

    public int enableAlg(float r100, int r101) {
        if (this.mProcessSaturation != r100) goto L8;
        if (this.mProcessTextureFormat != r101) goto L8;
        return 0;
    L8:
        if (this.mPackageHandler != null) goto L10;
        return -1;
    L10:
        this.mProcessSaturation = r100;
        this.mProcessTextureFormat = r101;
        this.mProcessCount = 0;
        ParamApi r102 = (ParamApi) nc4.b.b("Param");
        if (r102 != null) goto L14;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, create alg param");
        return -1;
    L14:
        r102.setInt(1101, 9);
        r102.setInt(1105, 2160);
        r102.setInt(1106, 3840);
        r102.setString(1107, this.mCacheDir);
        r102.setString(1109, this.downloadModelPathDir);
        r102.setIntList(18101, this.mModelIds);
        r102.setFloat(18102, r100);
        r102.setInt(18103, r101);
        if (this.mPackageHandler.b() == 0) goto L18;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, enable alg");
        return -1;
    L18:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR success saturation: " + this.mProcessSaturation + ", textureFormat: " + this.mProcessTextureFormat);
        return 0;
    }

    private int downloadModel(Context r100, String r101, String r102, String r103) {
        oc4.a r104 = (oc4.a) nc4.b.b("packageUtil.PackageDownload");
        if (r104 != null) goto L6;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, create downloader");
        return -1;
    L6:
        this.mInitializing = true;
        r104.b();
        HashMap r105 = new HashMap();
        r105.put("accessKey", r101);
        r105.put("host", r102);
        r105.put("deviceId", "");
        r105.put("tag", "sdr2hdr");
        r105.put("modelNames", r103);
        r104.a();
        return 0;
    }

    public int process(int r100, int r110, int r111, int r112, float r113, int r114, float[] r115) {
        VideoFrameApi r101 = this.mProcessInFrame;
        if (r101 != null) goto L5;
        this.mProcessInFrame = (VideoFrameApi) nc4.b.b("VideoFrame");
    L6:
        VideoFrameApi r102 = this.mProcessInFrame;
        if (r102 != null) goto L11;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, create in frame");
        return -1;
    L11:
        if (r100 != 36197) goto L14;
        r102.setVideoFrame(r110, 4, r111, r112, 0);
    L16:
        ParamApi r103 = this.mInParam;
        if (r103 != null) goto L19;
        this.mInParam = (ParamApi) nc4.b.b("Param");
    L20:
        ParamApi r104 = this.mInParam;
        if (r104 != null) goto L24;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, create in param");
        return -1;
    L24:
        r104.setFloat(18202, r113);
        this.mInParam.setInt(18201, r114);
        if (r115 == null) goto L27;
        this.mInParam.setFloatList(1201, r115);
    L27:
        VideoFrameApi r105 = this.mProcessOutFrame;
        if (r105 != null) goto L30;
        this.mProcessOutFrame = (VideoFrameApi) nc4.b.b("VideoFrame");
    L32:
        if (this.mProcessOutFrame != null) goto L35;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, create output frame");
        return -1;
    L35:
        ParamApi r106 = this.mOutParam;
        if (r106 != null) goto L38;
        this.mOutParam = (ParamApi) nc4.b.b("Param");
    L40:
        if (this.mOutParam != null) goto L44;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, create out param");
        return -1;
    L44:
        if (this.mPackageHandler.process() == 0) goto L47;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, process");
        return -1;
    L47:
        int r107 = this.mProcessOutFrame.getVideoFrameTexture();
        if ((this.mProcessCount % 3000) != 0) goto L50;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process SDR2HDR successful. outFormat: " + this.mProcessOutFrame.getVideoFrameFormat() + ", width: " + this.mProcessOutFrame.getVideoFrameWidth() + ", height: " + this.mProcessOutFrame.getVideoFrameHeight());
        this.mProcessCount = 0;
    L50:
        this.mPackageHandler.a();
        this.mProcessCount++;
        return r107;
    L38:
        r106.clearData();
        goto L40
    L30:
        r105.clearData();
        goto L32
    L19:
        r103.clearData();
        goto L20
    L14:
        if (r100 != 3553) goto L52;
        r102.setVideoFrame(r110, 3, r111, r112, 0);
        goto L16
    L52:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "process SDR2HDR fail, unknow texTarget");
        return -1;
    L5:
        r101.clearData();
        goto L6
    }

    public int init(Context r100, String r101, String r102, String r103, int r104, int r105, int r106, String r107, int[] r108) {
        this.mIndex = r104;
        this.mPoolSize = r105;
        this.mMaxInstanceSize = r106;
        this.mCacheDir = r107;
        this.mModelIds = r108;
        this.mProcessInFrame = null;
        this.mInParam = null;
        this.mProcessOutFrame = null;
        this.mOutParam = null;
        this.mProcessSaturation = -1.0f;
        this.mProcessTextureFormat = -1;
        this.mProcessCount = 0;
        return downloadModel(r100, r101, r102, r103);
    }
}
