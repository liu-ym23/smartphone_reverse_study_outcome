package com.ss.texturerender;

import android.os.SystemClock;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class TextureRenderEventLogger {
    private static final String EVENT_CROP_PARAMS = "tr_crop";
    private static final String EVENT_EFFECT_INIT_ERROR = "tr_eff_init_fail";
    private static final String EVENT_EFFECT_PROCESS_ERROR = "tr_eff_pro_fail";
    private static final String EVENT_EFFECT_SETTING = "tr_eff";
    private static final String EVENT_EFFECT_USING = "tr_use_eff";
    private static final String EVENT_EGL_CONTEXT_BIT_DEPTH = "tr_bit_depth";
    private static final String EVENT_EGL_SURFACE_ERROR = "tr_eglsf";
    private static final String EVENT_ERROR_CODE = "tr_erroc";
    private static final String EVENT_FIRST_FRAME_RENDERED = "tr_sdfirfra";
    private static final String EVENT_HARDWARE_BUFFER_PROCESS_ERROR = "tr_hw_buf_fail";
    private static final String EVENT_HARDWARE_BUFFER_RECT = "tr_hw_buf_rect";
    private static final String EVENT_LAYOUT_MODE = "tr_lymd";
    private static final String EVENT_MIRROR = "tr_mirror";
    private static final String EVENT_ON_FRAME_RECEIVED = "tr_on_frre";
    private static final String EVENT_POST_RENDER_CNT = "tr_post_render_cnt";
    private static final String EVENT_POST_RENDER_COST_AVG = "tr_post_render_cost_avg";
    private static final String EVENT_RENDER_IN_CALLBACK = "tr_rendercb";
    private static final String EVENT_ROTATION = "tr_rotation";
    private static final String EVENT_SAVE_FRAME_COUNT = "tr_safra";
    private static final String EVENT_SOURCE_TYPE = "tr_sorty";
    private static final String EVENT_SR_ASYNC_INIT = "sr_async_init";
    private static final String EVENT_SR_ASYNC_INIT_WITH_SHARE_CONTEXT = "sr_scon_asyinit";
    private static final String EVENT_SR_OUTPUT_SIZE = "sr_tex_size";
    private static final String EVENT_SURFACE_HWC = "tr_hwc";
    private static final String EVENT_SURFACE_SIZE = "tr_sf_bf_size";
    private static final String EVENT_SURFACE_TEXTURE_DATA_SPACE = "tr_data_sp";
    private static final String EVENT_SURFACE_TEXTURE_REUSE = "tr_reuse_sft";
    private static final String EVENT_SURFACE_TEXTURE_SIZE = "tr_off_size";
    private static final String EVENT_SURFACE_VALID = "tr_sfva";
    private static final String EVENT_TEX_COORDS = "tr_tex_coords";
    private static final String EVENT_TEX_SIZE = "tr_tex_size";
    private static final String EVENT_TOTAL_EFFECT_COST_AVG = "tr_total_effect_cost_avg";
    private static final String EVENT_USE_GL3 = "tr_gl3";
    private static final String EVENT_USE_GL_BLIT = "tr_blit";
    private static final String EVENT_USE_TEXEL_FETCH = "tr_texel_fet";
    private static final String EVENT_VIEW_PORT = "tr_vport";
    private final String TAG;
    private float mCropHeight;
    private float mCropWidth;
    private float mCropX;
    private float mCropY;
    private int mEGLContextBitDepth;
    private int mEGLSurfaceError;
    private Map<Integer, Integer> mEffectConfigSetting;
    private Map<Integer, Integer> mEffectConfigUsing;
    private Map<Integer, List<Integer>> mEffectInitError;
    private Map<Integer, List<Integer>> mEffectProcessError;
    private volatile boolean mEnable;
    private int mErrorCode;
    private int mFirstFrameRendered;
    private int mHardwareBufferProcessError;
    private int[] mHardwareBufferRect;
    private int mLayoutMode;
    private final ReentrantLock mLock;
    private int mMirror;
    private int mOnFrameReceived;
    private long mPostRenderCost;
    private long mPostRenderTime;
    private int mPostRendered;
    private int mRenderInCallback;
    private int mRotation;
    private int mSRAsyncInit;
    private int mSRAsyncInitWithSharedContext;
    private int mSROutputTexHeight;
    private int mSROutputTexWidth;
    private int mSaveFrameCount;
    private int mSourceType;
    private int mSurfaceHWC;
    private int mSurfaceHeight;
    private int mSurfaceTextureDataSpace;
    private int mSurfaceTextureHeight;
    private int mSurfaceTextureReuse;
    private int mSurfaceTextureWidth;
    private int mSurfaceValid;
    private int mSurfaceWidth;
    private float[] mTexCoords;
    private int mTexHeight;
    private int mTexWidth;
    private long mTotalEffectRenderCost;
    private long mTotalEffectRenderTime;
    private int mTotalEffectRendered;
    private int mUseGL3;
    private int mUseGLBlit;
    private int mUseTexelFetch;
    private int mViewPortHeight;
    private int mViewPortWidth;
    private int mViewPortX;
    private int mViewPortY;

    public void setTexCoords(FloatBuffer r100) {
    }

    private boolean readBegin() {
        if (this.mEnable == true) goto L6;
        return false;
    L6:
        this.mLock.lock();
        return true;
    }

    private void readEnd() {
        if (this.mLock.isLocked() == false) goto L6;
        this.mLock.unlock();
        return;
    }

    private boolean writeBegin() {
        if (this.mEnable == true) goto L7;
        return false;
    L7:
        return this.mLock.tryLock();
    }

    private void writeEnd() {
        if (this.mLock.isLocked() == false) goto L6;
        this.mLock.unlock();
        return;
    }

    public void resetAllEvents() {
        this.mLock.lock();
        this.mErrorCode = 0;
        this.mSourceType = 0;
        this.mOnFrameReceived = 0;
        this.mRenderInCallback = 0;
        this.mFirstFrameRendered = 0;
        this.mSaveFrameCount = 0;
        this.mSurfaceValid = 0;
        this.mSurfaceHWC = 0;
        this.mSurfaceHeight = 0;
        this.mSurfaceWidth = 0;
        this.mSurfaceTextureReuse = 0;
        this.mSurfaceTextureHeight = 0;
        this.mSurfaceTextureWidth = 0;
        this.mSurfaceTextureDataSpace = 0;
        this.mEGLSurfaceError = 0;
        this.mEGLContextBitDepth = 0;
        this.mUseGL3 = 0;
        this.mViewPortHeight = 0;
        this.mViewPortWidth = 0;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        this.mTexCoords = null;
        this.mUseTexelFetch = 0;
        this.mUseGLBlit = 0;
        this.mTexHeight = 0;
        this.mTexWidth = 0;
        this.mLayoutMode = 0;
        this.mRotation = 0;
        this.mMirror = 0;
        this.mCropY = 0.0f;
        this.mCropX = 0.0f;
        this.mCropHeight = 1.0f;
        this.mCropWidth = 1.0f;
        this.mEffectConfigSetting.clear();
        this.mEffectConfigUsing.clear();
        this.mEffectInitError.clear();
        this.mEffectProcessError.clear();
        this.mHardwareBufferProcessError = 0;
        this.mHardwareBufferRect = null;
        this.mSRAsyncInit = 0;
        this.mSRAsyncInitWithSharedContext = 0;
        this.mSROutputTexHeight = 0;
        this.mSROutputTexWidth = 0;
        this.mPostRenderTime = 0;
        this.mPostRendered = 0;
        this.mPostRenderCost = 0;
        this.mTotalEffectRenderTime = 0;
        this.mTotalEffectRendered = 0;
        this.mTotalEffectRenderCost = 0;
        this.mLock.unlock();
    }

    public void setPostRenderBegin() {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mPostRenderTime = SystemClock.elapsedRealtime();
        writeEnd();
    }

    public void setTotalEffectRenderBegin() {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mTotalEffectRenderTime = SystemClock.elapsedRealtime();
        writeEnd();
    }

    public TextureRenderEventLogger(String r100) {
        this.mLock = new ReentrantLock();
        this.mEffectConfigSetting = new HashMap();
        this.mEffectConfigUsing = new HashMap();
        this.mEffectInitError = new HashMap();
        this.mEffectProcessError = new HashMap();
        this.TAG = r100;
        resetAllEvents();
    }

    public Map<String, Object> getAllEvents(int r110) {
        HashMap r100 = new HashMap();     // Catch: Throwable -> L70 Exception -> L72
        if (readBegin() == true) goto L6;
        readEnd();
        return r100;
    L6:
        r100.put(EVENT_ERROR_CODE, new int[]{this.mErrorCode});     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SOURCE_TYPE, Integer.valueOf(this.mSourceType));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_ON_FRAME_RECEIVED, Integer.valueOf(this.mOnFrameReceived));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_RENDER_IN_CALLBACK, Integer.valueOf(this.mRenderInCallback));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_FIRST_FRAME_RENDERED, Integer.valueOf(this.mFirstFrameRendered));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SAVE_FRAME_COUNT, Integer.valueOf(this.mSaveFrameCount));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_VALID, Integer.valueOf(this.mSurfaceValid));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_HWC, Integer.valueOf(this.mSurfaceHWC));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_SIZE, new int[]{this.mSurfaceWidth, this.mSurfaceHeight});     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_TEXTURE_REUSE, Integer.valueOf(this.mSurfaceTextureReuse));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_TEXTURE_SIZE, new int[]{this.mSurfaceTextureWidth, this.mSurfaceTextureHeight});     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SURFACE_TEXTURE_DATA_SPACE, Integer.valueOf(this.mSurfaceTextureDataSpace));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_EGL_SURFACE_ERROR, Integer.valueOf(this.mEGLSurfaceError));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_EGL_CONTEXT_BIT_DEPTH, Integer.valueOf(this.mEGLContextBitDepth));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_USE_GL3, Integer.valueOf(this.mUseGL3));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_VIEW_PORT, new int[]{this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight});     // Catch: Throwable -> L70 Exception -> L72
        float[] r101 = this.mTexCoords;     // Catch: Throwable -> L70 Exception -> L72
        if (r101 != null) goto L10;
    L12:
        r100.put(EVENT_TEX_COORDS, new float[0]);     // Catch: Throwable -> L70 Exception -> L72
    L13:
        r100.put(EVENT_USE_TEXEL_FETCH, Integer.valueOf(this.mUseTexelFetch));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_USE_GL_BLIT, Integer.valueOf(this.mUseGLBlit));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_TEX_SIZE, new int[]{this.mTexWidth, this.mTexHeight});     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_LAYOUT_MODE, Integer.valueOf(this.mLayoutMode));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_ROTATION, Integer.valueOf(this.mRotation));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_MIRROR, Integer.valueOf(this.mMirror));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_CROP_PARAMS, new float[]{this.mCropX, this.mCropY, this.mCropWidth, this.mCropHeight});     // Catch: Throwable -> L70 Exception -> L72
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L70 Exception -> L72
        if (this.mEffectConfigSetting.isEmpty() == true) goto L24;
        Iterator<Map.Entry<Integer, Integer>> r103 = this.mEffectConfigSetting.entrySet().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L17:
        if (r103.hasNext() == false) goto L24;
        Map.Entry<Integer, Integer> r104 = r103.next();     // Catch: Throwable -> L70 Exception -> L72
        if (r104.getKey().intValue() == 11) goto L17;
        if (r104.getValue().intValue() != 1) goto L17;
        r102.put(r104.getKey());     // Catch: Throwable -> L70 Exception -> L72
    L24:
        r100.put(EVENT_EFFECT_SETTING, r102);     // Catch: Throwable -> L70 Exception -> L72
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L70 Exception -> L72
        if (this.mEffectConfigUsing.isEmpty() == true) goto L35;
        Iterator<Map.Entry<Integer, Integer>> r106 = this.mEffectConfigUsing.entrySet().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L28:
        if (r106.hasNext() == false) goto L35;
        Map.Entry<Integer, Integer> r107 = r106.next();     // Catch: Throwable -> L70 Exception -> L72
        if (r107.getKey().intValue() == 11) goto L28;
        if (r107.getValue().intValue() != 1) goto L28;
        r105.put(r107.getKey());     // Catch: Throwable -> L70 Exception -> L72
    L35:
        r100.put(EVENT_EFFECT_USING, r105);     // Catch: Throwable -> L70 Exception -> L72
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L70 Exception -> L72
        Iterator<Map.Entry<Integer, List<Integer>>> r109 = this.mEffectInitError.entrySet().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L37:
        if (r109.hasNext() == false) goto L43;
        Map.Entry<Integer, List<Integer>> r111 = r109.next();     // Catch: Throwable -> L70 Exception -> L72
        JSONArray r112 = new JSONArray();     // Catch: Throwable -> L70 Exception -> L72
        Iterator<Integer> r113 = r111.getValue().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L40:
        if (r113.hasNext() == false) goto L42;
        r112.put(r113.next());     // Catch: Throwable -> L70 Exception -> L72
        goto L40
    L42:
        r108.put(String.valueOf(r111.getKey()), r112);     // Catch: Throwable -> L70 Exception -> L72
        goto L37
    L43:
        r100.put(EVENT_EFFECT_INIT_ERROR, r108);     // Catch: Throwable -> L70 Exception -> L72
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L70 Exception -> L72
        Iterator<Map.Entry<Integer, List<Integer>>> r115 = this.mEffectProcessError.entrySet().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L45:
        if (r115.hasNext() == false) goto L51;
        Map.Entry<Integer, List<Integer>> r116 = r115.next();     // Catch: Throwable -> L70 Exception -> L72
        JSONArray r117 = new JSONArray();     // Catch: Throwable -> L70 Exception -> L72
        Iterator<Integer> r118 = r116.getValue().iterator();     // Catch: Throwable -> L70 Exception -> L72
    L48:
        if (r118.hasNext() == false) goto L50;
        r117.put(r118.next());     // Catch: Throwable -> L70 Exception -> L72
        goto L48
    L50:
        r108.put(String.valueOf(r116.getKey()), r117);     // Catch: Throwable -> L70 Exception -> L72
        goto L45
    L51:
        r100.put(EVENT_EFFECT_PROCESS_ERROR, r114);     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_HARDWARE_BUFFER_PROCESS_ERROR, Integer.valueOf(this.mHardwareBufferProcessError));     // Catch: Throwable -> L70 Exception -> L72
        int[] r119 = this.mHardwareBufferRect;     // Catch: Throwable -> L70 Exception -> L72
        if (r119 != null) goto L55;
    L57:
        r100.put(EVENT_HARDWARE_BUFFER_RECT, new int[0]);     // Catch: Throwable -> L70 Exception -> L72
    L58:
        r100.put(EVENT_SR_ASYNC_INIT, Integer.valueOf(this.mSRAsyncInit));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SR_ASYNC_INIT_WITH_SHARE_CONTEXT, Integer.valueOf(this.mSRAsyncInitWithSharedContext));     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_SR_OUTPUT_SIZE, new int[]{this.mSROutputTexWidth, this.mSROutputTexHeight});     // Catch: Throwable -> L70 Exception -> L72
        r100.put(EVENT_POST_RENDER_CNT, Integer.valueOf(this.mPostRendered));     // Catch: Throwable -> L70 Exception -> L72
        int r120 = this.mPostRendered;     // Catch: Throwable -> L70 Exception -> L72
        if (r120 == 0) goto L62;
        r100.put(EVENT_POST_RENDER_COST_AVG, Integer.valueOf((int) Math.ceil((this.mPostRenderCost * 1.0d) / ((double) r120))));     // Catch: Throwable -> L70 Exception -> L72
    L63:
        int r121 = this.mTotalEffectRendered;     // Catch: Throwable -> L70 Exception -> L72
        if (r121 == 0) goto L67;
        r100.put(EVENT_TOTAL_EFFECT_COST_AVG, Integer.valueOf((int) Math.ceil((this.mTotalEffectRenderCost * 1.0d) / ((double) r121))));     // Catch: Throwable -> L70 Exception -> L72
    L68:
        readEnd();
        return r100;
    L67:
        r100.put(EVENT_TOTAL_EFFECT_COST_AVG, 0);     // Catch: Throwable -> L70 Exception -> L72
        goto L68
    L62:
        r100.put(EVENT_POST_RENDER_COST_AVG, 0);     // Catch: Throwable -> L70 Exception -> L72
        goto L63
    L55:
        if (r119.length <= 0) goto L57;
        r100.put(EVENT_HARDWARE_BUFFER_RECT, r119);     // Catch: Throwable -> L70 Exception -> L72
        goto L58
    L10:
        if (r101.length <= 0) goto L12;
        r100.put(EVENT_TEX_COORDS, r101);     // Catch: Throwable -> L70 Exception -> L72
    L72:
        e = move-exception;
        TextureRenderLog.e(r110, this.TAG, "getAllEvents exp = " + e);     // Catch: Throwable -> L70
        readEnd();
        return null;
    L70:
        th = move-exception;
        readEnd();
        throw th;
    }

    public void setEGLContextBitDepth(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mEGLContextBitDepth = r100;
        writeEnd();
    }

    public void setEGLSurfaceError(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mEGLSurfaceError = r100;
        writeEnd();
    }

    public void setEffectConfigSetting(Map<Integer, Integer> r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mEffectConfigSetting.clear();
        if (r100.isEmpty() == true) goto L8;
        this.mEffectConfigSetting.putAll(r100);
    L8:
        writeEnd();
    }

    public void setEffectConfigUsing(Map<Integer, Integer> r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mEffectConfigUsing.clear();
        if (r100.isEmpty() == true) goto L8;
        this.mEffectConfigUsing.putAll(r100);
    L8:
        writeEnd();
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public void setErrorCode(int r100) {
        if (writeBegin() == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
    L14:
        writeEnd();
        return;
    L8:
        if (r100 == 3) goto L14;
        if (r100 == 6) goto L14;
        this.mErrorCode = r100;
        writeEnd();
    }

    public void setFirstFrameRendered(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mFirstFrameRendered = r100;
        writeEnd();
    }

    public void setHardwareBufferProcessError(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mHardwareBufferProcessError = r100;
        writeEnd();
    }

    public void setHardwareBufferRect(int[] r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L14:
        writeEnd();
        return;
    L7:
        if (r100.length <= 0) goto L14;
        int[] r101 = this.mHardwareBufferRect;
        if (r101 != null) goto L11;
    L12:
        this.mHardwareBufferRect = new int[r100.length];
    L13:
        int[] r102 = this.mHardwareBufferRect;
        System.arraycopy(r100, 0, r102, 0, r102.length);
        goto L14
    L11:
        if (r101.length == r100.length) goto L13;
        goto L12
    }

    public void setLayoutMode(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mLayoutMode = r100;
        writeEnd();
    }

    public void setMirror(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mMirror = r100;
        writeEnd();
    }

    public void setOnFrameReceived(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mOnFrameReceived = r100;
        writeEnd();
    }

    public void setPostRenderEnd(boolean r100) {
        if (writeBegin() == true) goto L6;
        return;
    L6:
        if (r100 == true) goto L8;
    L10:
        this.mPostRenderTime = 0;
        writeEnd();
        return;
    L8:
        if (this.mPostRenderTime == 0) goto L10;
        this.mPostRendered++;
        this.mPostRenderCost += SystemClock.elapsedRealtime() - this.mPostRenderTime;
        goto L10
    }

    public void setRenderInCallback(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mRenderInCallback = r100;
        writeEnd();
    }

    public void setRotation(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mRotation = r100;
        writeEnd();
    }

    public void setSRAsyncInit(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSRAsyncInit = r100;
        writeEnd();
    }

    public void setSRAsyncInitWithSharedContext(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSRAsyncInitWithSharedContext = r100;
        writeEnd();
    }

    public void setSaveFrameCount(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSaveFrameCount = r100;
        writeEnd();
    }

    public void setSourceType(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSourceType = r100;
        writeEnd();
    }

    public void setSurfaceHWC(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceHWC = r100;
        writeEnd();
    }

    public void setSurfaceTextureDataSpace(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceTextureDataSpace = r100;
        writeEnd();
    }

    public void setSurfaceTextureReuse(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceTextureReuse = r100;
        writeEnd();
    }

    public void setSurfaceValid(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceValid = r100;
        writeEnd();
    }

    public void setTotalEffectRenderEnd(boolean r100) {
        if (writeBegin() == true) goto L6;
        return;
    L6:
        if (r100 == true) goto L8;
    L10:
        this.mTotalEffectRenderTime = 0;
        writeEnd();
        return;
    L8:
        if (this.mTotalEffectRenderTime == 0) goto L10;
        this.mTotalEffectRendered++;
        this.mTotalEffectRenderCost += SystemClock.elapsedRealtime() - this.mTotalEffectRenderTime;
        goto L10
    }

    public void setUseGL3(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mUseGL3 = r100;
        writeEnd();
    }

    public void setUseGLBlit(int r100) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mUseGLBlit = r100;
        writeEnd();
    }

    public void setUseTexelFetch(int r100) {
        if (writeBegin() == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        this.mUseTexelFetch++;
    L8:
        writeEnd();
    }

    public void setEffectInitError(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        if (r100 > 0) goto L7;
    L17:
        writeEnd();
        return;
    L7:
        if (r100 >= 32) goto L17;
        List<Integer> r102 = this.mEffectInitError.get(Integer.valueOf(r100));
        if (r102 != null) goto L13;
        r102 = new ArrayList();
    L13:
        if (r102.contains(Integer.valueOf(r101)) == true) goto L15;
        r102.add(Integer.valueOf(r101));
    L15:
        this.mEffectInitError.put(Integer.valueOf(r100), r102);
        writeEnd();
    }

    public void setEffectProcessError(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        if (r100 > 0) goto L7;
    L17:
        writeEnd();
        return;
    L7:
        if (r100 >= 32) goto L17;
        List<Integer> r102 = this.mEffectProcessError.get(Integer.valueOf(r100));
        if (r102 != null) goto L13;
        r102 = new ArrayList();
    L13:
        if (r102.contains(Integer.valueOf(r101)) == true) goto L15;
        r102.add(Integer.valueOf(r101));
    L15:
        this.mEffectProcessError.put(Integer.valueOf(r100), r102);
        writeEnd();
    }

    public void setSROutputTexSize(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSROutputTexWidth = r100;
        this.mSROutputTexHeight = r101;
        writeEnd();
    }

    public void setSurfaceSize(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceWidth = r100;
        this.mSurfaceHeight = r101;
        writeEnd();
    }

    public void setSurfaceTextureSize(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mSurfaceTextureWidth = r100;
        this.mSurfaceTextureHeight = r101;
        writeEnd();
    }

    public void setTexSize(int r100, int r101) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mTexWidth = r100;
        this.mTexHeight = r101;
        writeEnd();
    }

    public void setCropParams(float r100, float r101, float r102, float r103) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mCropX = r100;
        this.mCropY = r101;
        this.mCropWidth = r102;
        this.mCropHeight = r103;
        writeEnd();
    }

    public void setViewPort(int r100, int r101, int r102, int r103) {
        if (writeBegin() == true) goto L5;
        return;
    L5:
        this.mViewPortX = r100;
        this.mViewPortY = r101;
        this.mViewPortWidth = r102;
        this.mViewPortHeight = r103;
        writeEnd();
    }
}
