package com.ss.texturerender.effect.ICEffect;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectFactory;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import java.io.Serializable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class ICEffectWrapper extends AbsEffect {
    public static final int BEF_AB_DATA_TYPE_BOOL = 0;
    public static final int BEF_AB_DATA_TYPE_FLOAT = 2;
    public static final int BEF_AB_DATA_TYPE_INT = 1;
    public static final int BEF_AB_DATA_TYPE_STRING = 3;
    public static final String DEFAULT_SEI_KEY = "LiveSEI";
    private static boolean isLibLoaded;
    private double mCostSum;
    private GLDefaultFilter mCropFilter;
    EffectTexture mCropedTexture;
    private GLDefaultFilter mDefaultFilter;
    private boolean mDisableCropTexture;
    private boolean mDisableReverseExtraTexture;
    private boolean mDisableReverseMainTexture;
    private boolean mDisableReverseTexture;
    private boolean mEnableVideoEffectPKGift;
    private boolean mEnableVideoEffectSixDofLite;
    EffectTexture mExtraTexture;
    private long mFrameCount;
    private long mHandle;
    private boolean mIsInit;
    public IEffectMsgListener mMsgListener;
    private boolean mProcessOccurError;
    private IEffectResourceFinder mResourceFinder;
    private boolean mReverseStatusChanged;
    private String mSeiInfo;
    private String mSeiKey;
    private int mSixDofLiteLogLevel;
    private int mSixDofLiteMode;
    private int mSixDofLiteStreamLayout;

    public interface IEffectInitCallback extends Serializable {
        void onInitCallback(int r100);
    }

    public interface IEffectLogListener extends Serializable {
        void onLogReport(int r100, String r101);
    }

    public interface IEffectMsgListener extends Serializable {
        void onMessageReceived(int r100, long r101, long r102, String r103);
    }

    public interface IEffectResourceFinder extends Serializable {
        long createNativeResourceFinder(long r100);

        void release(long r100);
    }

    private native int _composerAppendNodesWithTags(long r100, Object[] r101, int r102, Object[] r103);

    private native String _composerGetNodePaths(long r100);

    private native int _composerRemoveNodes(long r100, String[] r101, int r102);

    private native int _composerSetNodesWithTags(long r100, Object[] r101, int r102, Object[] r103);

    private static native int _configABBooleanValue(long r100, String r101, boolean r102);

    private static native int _configABFloatValue(long r100, String r101, float r102);

    private static native int _configABIntValue(long r100, String r101, int r102);

    private static native int _configABStringValue(long r100, String r101, String r102);

    private native int _configEffect(long r100, int r101, int r102, String r103, String r104, String r105, String r106);

    private native long _createEffectWrapper();

    private native String _getEventData(long r100, int r101);

    private native int _initEffect(long r100, int r101, int r102, String r103);

    private native int _processFrame(long r100, int r101, int r102, int r103, int r104, double r105, String r106, String r110);

    private native int _refreshResourceMemory(long r100);

    private native int _release(long r100);

    private native int _sendEffectMsg(long r100, int r101, int r102, int r103, String r104);

    private native int _setAuxiliaryTexture(long r100, int r101, String r102, int r103, int r104);

    private native int _setRenderCacheString(long r100, String r101, String r102);

    private native int _setTextureSize(long r100, int r101, int r102);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private int initSixDofLite(Bundle r100) {
        return 0;
    }

    private void processSixDofLiteAfter(EffectTexture r100, FrameBuffer r101) {
    }

    private void checkReverseStatusChanged() {
        boolean r100 = this.mDisableReverseTexture;
        if (r100 == true) goto L5;
    L9:
        boolean r101 = false;
    L11:
        if (r101 == this.mDisableReverseMainTexture) goto L13;
        this.mDisableReverseMainTexture = r101;
        this.mReverseStatusChanged = true;
    L13:
        if (r100 == true) goto L15;
    L17:
        boolean r102 = false;
    L19:
        if (r102 == this.mDisableReverseExtraTexture) goto L22;
        this.mDisableReverseExtraTexture = r102;
        this.mReverseStatusChanged = true;
    L22:
        if (this.mReverseStatusChanged == false) goto L32;
        Bundle r103 = new Bundle();
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L26
        r104.put("InputTex_FlipY_Opt", this.mDisableReverseMainTexture);     // Catch: Exception -> L26
        r104.put("SixDofTex_FlipY_Opt", this.mDisableReverseExtraTexture);     // Catch: Exception -> L26
        String r105 = r104.toString();     // Catch: Exception -> L26
    L28:
        r103.putString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_KEY, "6dof_config");
        r103.putString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_VALUE, r105);
        setRenderCacheString(r103);
        this.mReverseStatusChanged = false;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "mDisableReverseMainTexture:" + this.mDisableReverseMainTexture + ",mDisableReverseExtraTexture:" + this.mDisableReverseExtraTexture);
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
        r105 = "";
        goto L28
    L32:
        return;
    L15:
        if (this.mEnableVideoEffectSixDofLite == false) goto L17;
        r102 = true;
        goto L19
    L5:
        if (this.mEnableVideoEffectSixDofLite == false) goto L9;
        if (this.mEnableVideoEffectPKGift == true) goto L9;
        r101 = true;
        goto L11
    }

    private int releaseSixDofLite() {
        EffectTexture r100 = this.mExtraTexture;
        if (r100 == null) goto L5;
        r100.giveBack();
        this.mExtraTexture = null;
    L5:
        this.mCropFilter = null;
        return 0;
    }

    public int refreshResourceMemory() {
        int r100 = _refreshResourceMemory(this.mHandle);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_refreshResourceMemory ret: " + r100);
        return r100;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        long r100 = this.mHandle;
        if (r100 == 0) goto L17;
        if (isLibLoaded == false) goto L17;
        String r101 = _composerGetNodePaths(r100);
        if (TextUtils.isEmpty(r101) == true) goto L14;
        String[] r102 = r101.split(",");
        if (r102 == null) goto L14;
        if (r102.length <= 0) goto L14;
        _composerRemoveNodes(this.mHandle, r102, r102.length);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "remove composer nodes");
    L14:
        _release(this.mHandle);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release effect");
        this.mHandle = 0;
        this.mIsInit = false;
        this.mProcessOccurError = false;
        this.mSeiInfo = "";
        this.mDefaultFilter = null;
        releaseSixDofLite();
        return super.release();
    L17:
        return super.release();
    }

    static {
        isLibLoaded = loadLibrary();
    }

    public static boolean loadLibrary() {
        INVOKESTATIC_com_ss_texturerender_effect_ICEffect_ICEffectWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("texturerender_native");     // Catch: UnsatisfiedLinkError -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public ICEffectWrapper(int r100) {
        super(r100, 21);
        this.mSeiInfo = "";
        this.mSeiKey = DEFAULT_SEI_KEY;
        this.mIsInit = false;
        this.mProcessOccurError = false;
        this.mDefaultFilter = null;
        this.mEnableVideoEffectPKGift = false;
        this.mEnableVideoEffectSixDofLite = false;
        this.mSixDofLiteMode = 2;
        this.mSixDofLiteStreamLayout = 1;
        this.mCropFilter = null;
        this.mExtraTexture = null;
        this.mDisableReverseTexture = false;
        this.mReverseStatusChanged = false;
        this.mDisableReverseMainTexture = true;
        this.mDisableReverseExtraTexture = true;
        this.mDisableCropTexture = false;
        this.mCropedTexture = null;
        this.mFrameCount = 0;
        this.mCostSum = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mSixDofLiteLogLevel = 2;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new ICEffectWrapper, load so result: " + isLibLoaded);
        this.mOrder = 99;
        this.mIsSupportOes = 0;
        this.mInTextureTarget = 3553;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_texturerender_effect_ICEffect_ICEffectWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public int composerAppendNodesWithTags(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return -1;
    L5:
        if (this.mIsInit == false) goto L15;
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (this.mHandle == 0) goto L18;
        String[] r101 = r100.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH);
        String[] r102 = r100.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_STICKER_TAGS);
        if (r101 == null) goto L17;
        int r103 = _composerAppendNodesWithTags(this.mHandle, r101, r101.length, r102);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_composerAppendNodesWithTags ret: " + r103);
        return r103;
    L17:
        return -1;
    L18:
        return -1;
    L15:
        return -1;
    }

    public int composerRemoveNodes(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return -1;
    L5:
        if (this.mIsInit == false) goto L15;
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (this.mHandle == 0) goto L18;
        String[] r101 = r100.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH);
        if (r101 == null) goto L17;
        int r102 = _composerRemoveNodes(this.mHandle, r101, r101.length);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_composerRemoveNodes ret: " + r102);
        return r102;
    L17:
        return -1;
    L18:
        return -1;
    L15:
        return -1;
    }

    public int composerSetNodesWithTags(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return -1;
    L5:
        if (this.mIsInit == false) goto L15;
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (this.mHandle == 0) goto L18;
        String[] r101 = r100.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH);
        String[] r102 = r100.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_STICKER_TAGS);
        if (r101 == null) goto L17;
        int r103 = _composerSetNodesWithTags(this.mHandle, r101, r101.length, r102);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_composerSetNodesWithTags ret: " + r103);
        return r103;
    L17:
        return -1;
    L18:
        return -1;
    L15:
        return -1;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public Object getOption(Bundle r100) {
        if (isLibLoaded == true) goto L5;
    L19:
        return null;
    L5:
        if (this.mIsInit == false) goto L19;
        if (r100 == null) goto L19;
        if (this.mHandle == 0) goto L19;
        int r101 = r100.getInt("action");
        if (r101 == 3) goto L18;
        if (r101 == 9) goto L15;
        return null;
    L15:
        int r102 = r100.getInt("event_type");
        return _getEventData(this.mHandle, r102);
    L18:
        return _composerGetNodePaths(this.mHandle);
    }

    public long getResourceFunc(long r100) {
        IEffectResourceFinder r101 = this.mResourceFinder;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.createNativeResourceFinder(r100);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        if (r110 != null) goto L5;
        return -1;
    L5:
        if (isLibLoaded == true) goto L7;
        return -1;
    L7:
        if (this.mIsInit == true) goto L71;
        this.mHandle = _createEffectWrapper();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create effect wrapper, handle: " + this.mHandle);
        if (this.mHandle != 0) goto L12;
        return -1;
    L12:
        int r111 = r110.getInt("log_level");
        String r100 = r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_LOG_KEY);
        String r101 = r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_PLATFORM_CONFIG);
        int r102 = r110.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_USE_GL30);
        String r103 = r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_CACHE_PATH);
        String r104 = r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_LICENSE);
        this.mMsgListener = (IEffectMsgListener) r110.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_CALLBACK);
        IEffectInitCallback r105 = (IEffectInitCallback) r110.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_INIT_RESULT_CALLBACK);
        this.mResourceFinder = (IEffectResourceFinder) r110.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_RESOURCE_FINDER);
        int r106 = _configEffect(this.mHandle, r102, r111, r101, r103, r104, r100);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "config effect, loglevel: " + r111 + ", ret: " + r106);
        if (r106 >= 0) goto L18;
        if (r105 == null) goto L16;
        r105.onInitCallback(r106);
    L16:
        this.mSurfaceTexture.notifyInitError(17, this.mEffectType, "iceffect config effect error code: " + r106);
        return r106;
    L18:
        String r107 = r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG);
        int r108 = 1;
        if (TextUtils.isEmpty(r107) == false) goto L59;
    L44:
        if (r106 >= 0) goto L49;
        if (r105 == null) goto L47;
        r105.onInitCallback(r106);
    L47:
        this.mSurfaceTexture.notifyInitError(17, this.mEffectType, "iceffect config ab params error code: " + r106);
        return r106;
    L49:
        int r109 = this.mSurfaceTexture.getTexWidth();
        int r112 = this.mSurfaceTexture.getTexHeight();
        int r113 = _initEffect(this.mHandle, r109, r112, r110.getString(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME));
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init effect width: " + r109 + ", height: " + r112 + ", result: " + r113);
        initSixDofLite(r110);
        if (r113 != 0) goto L52;
        this.mIsInit = true;
    L53:
        if (r105 == null) goto L55;
        r105.onInitCallback(r113);
    L55:
        this.mReverseStatusChanged = true;
        return r113;
    L52:
        this.mSurfaceTexture.notifyInitError(17, this.mEffectType, "iceffect init error code: " + r113);
        goto L53
    L59:
        JSONArray r114 = new JSONArray(r107);     // Catch: JSONException -> L42
        int r115 = 0;
    L21:
        if (r115 >= r114.length()) goto L44;
        JSONObject r116 = r114.optJSONObject(r115);     // Catch: JSONException -> L42
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set effect ab config: " + r116);     // Catch: JSONException -> L42
        if (r116.has("key") == false) goto L41;
        if (r116.has("data_type") == false) goto L41;
        if (r116.has("value") == false) goto L41;
        String r117 = r116.optString("key");     // Catch: JSONException -> L42
        int r118 = r116.optInt("data_type");     // Catch: JSONException -> L42
        if (r118 == 0) goto L40;
        if (r118 != r108) goto L33;
        r106 = _configABIntValue(this.mHandle, r117, r116.optInt("value"));     // Catch: JSONException -> L42
        goto L41
    L33:
        if (r118 != 2) goto L35;
        r106 = _configABFloatValue(this.mHandle, r117, (float) r116.optDouble(r117));     // Catch: JSONException -> L42
        goto L41
    L35:
        if (r118 != 3) goto L41;
        r106 = _configABStringValue(this.mHandle, r117, r116.optString(r117));     // Catch: JSONException -> L42
        goto L41
    L40:
        r106 = _configABBooleanValue(this.mHandle, r117, r116.optBoolean("value"));     // Catch: JSONException -> L42
    L41:
        r115 = r115 + 1;
        r108 = 1;
    L42:
        e = move-exception;
        e.printStackTrace();
        r106 = -1;
        goto L44
    L71:
        return -1;
    }

    public void sendEffectMsg(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return;
    L5:
        if (this.mIsInit == false) goto L15;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.mHandle == 0) goto L18;
        int r101 = r100.getInt("msg_id");
        int r102 = r100.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_PARAM1);
        int r103 = r100.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_PARAM2);
        String r104 = r100.getString(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_STRING_PARAM3);
        if (r101 == (-1)) goto L17;
        _sendEffectMsg(this.mHandle, r101, r102, r103, r104);
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (this.mHandle == 0) goto L24;
        if (r100 != null) goto L6;
        return;
    L6:
        if (isLibLoaded == true) goto L9;
        return;
    L9:
        switch(r100.getInt("action")) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L38;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L38;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            default: goto L38;
        };
    L11:
        setVideoEffectSixDofLiteDisableReverse(r100);
        return;
    L12:
        setVideoEffectSixDofLiteMode(r100);
        return;
    L13:
        setVideoEffectEnable(r100);
        return;
    L14:
        refreshResourceMemory();
        return;
    L15:
        release();
        return;
    L16:
        setTextureSize(r100);
        return;
    L17:
        setRenderCacheString(r100);
        return;
    L18:
        setSeiInfo(r100);
        return;
    L19:
        composerRemoveNodes(r100);
        return;
    L20:
        composerAppendNodesWithTags(r100);
        return;
    L21:
        composerSetNodesWithTags(r100);
        return;
    L22:
        sendEffectMsg(r100);
        return;
    L38:
        return;
    }

    public int setRenderCacheString(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return -1;
    L5:
        if (this.mIsInit == false) goto L17;
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (this.mHandle == 0) goto L21;
        String r101 = r100.getString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_KEY);
        String r102 = r100.getString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_VALUE);
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return -1;
    L13:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        return -1;
    L15:
        return _setRenderCacheString(this.mHandle, r101, r102);
    L21:
        return -1;
    L17:
        return -1;
    }

    public void setSeiInfo(Bundle r100) {
        if (this.mIsInit == false) goto L12;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mHandle == 0) goto L15;
        String r101 = r100.getString(ICEffectKeys.KEY_IS_IC_EFFECT_SEI_KEY);
        String r102 = r100.getString(ICEffectKeys.KEY_IS_IC_EFFECT_SEI_INFO);
        if (TextUtils.equals(r101, DEFAULT_SEI_KEY) == false) goto L14;
        this.mSeiInfo = r102;
        return;
    L14:
        return;
    L15:
        return;
    }

    public int setTextureSize(Bundle r100) {
        if (isLibLoaded == true) goto L5;
        return -1;
    L5:
        if (this.mIsInit == false) goto L14;
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (this.mHandle == 0) goto L16;
        int r101 = r100.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_TEX_WIDTH);
        int r102 = r100.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_TEX_HEIGHT);
        return _setTextureSize(this.mHandle, r101, r102);
    L16:
        return -1;
    L14:
        return -1;
    }

    public void setVideoEffectEnable(Bundle r100) {
        if (this.mIsInit == false) goto L19;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mHandle == 0) goto L23;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setVideoEffectEnable, bundle: " + r100);
        int r101 = r100.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_VIDEO_EFFECT_TYPE, -1);
        boolean r102 = false;
        int r103 = r100.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);
        if (r101 != 1) goto L14;
        if (r103 != 1) goto L12;
        r102 = true;
    L12:
        this.mEnableVideoEffectPKGift = r102;
        return;
    L14:
        if (r101 != 2) goto L22;
        if (r103 != 1) goto L17;
        r102 = true;
    L17:
        this.mEnableVideoEffectSixDofLite = r102;
        return;
    L22:
        return;
    L23:
        return;
    }

    public void setVideoEffectSixDofLiteDisableReverse(Bundle r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setVideoEffectSixDofLiteDisableReverse, bundle: " + r100);
        if (r100.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0) <= 0) goto L5;
        boolean r101 = true;
    L6:
        this.mDisableReverseTexture = r101;
        int r102 = r100.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0) - 1;
        if (r102 <= 2) goto L10;
        this.mSixDofLiteLogLevel = r102;
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setVideoEffectSixDofLiteMode(Bundle r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setVideoEffectSixDofLiteMode, bundle: " + r100);
        this.mSixDofLiteMode = r100.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 2);
        this.mSixDofLiteStreamLayout = r100.getInt(TextureRenderKeys.KEY_IS_SIX_DOF_LITE_STREAM_LAYOUT, 1);
    }

    private void processSixDofLite(EffectTexture r100, FrameBuffer r101) {
        if (this.mSixDofLiteStreamLayout != 2) goto L5;
        String r102 = "6dof_1_2_0_tex";
    L6:
        long r103 = this.mHandle;
        int r104 = r100.getTexID();
        _setAuxiliaryTexture(r103, r104, r102, r100.getWidth(), r100.getHeight());
        return;
    L5:
        r102 = "6dof_2_2_tex";
        goto L6
    }

    private EffectTexture processSixDofLiteBefore(EffectTexture r100, FrameBuffer r101) {
        if (this.mEnableVideoEffectSixDofLite == true) goto L5;
        return r100;
    L5:
        if (this.mSixDofLiteMode == 2) goto L7;
        return r100;
    L7:
        if (this.mCropFilter != null) goto L18;
        GLDefaultFilter r102 = (GLDefaultFilter) EffectFactory.createEffect(this.mTexType, 7);
        this.mCropFilter = r102;
        if (r102 != null) goto L12;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create GLDefaultFilter failed");
        return null;
    L12:
        r102.setSurfaceTexture(this.mSurfaceTexture);
        this.mCropFilter.init(null);
        this.mCropFilter.setParentRender(this.mParentRender);
        if (this.mSixDofLiteStreamLayout != 2) goto L15;
        float r103 = 1.0f;
    L16:
        Bundle r104 = new Bundle();
        r104.putInt("action", 28);
        r104.putInt("effect_type", 11);
        r104.putFloat("width", r103);
        r104.putFloat("height", 0.5f);
        r104.putFloat("x", 0.0f);
        r104.putFloat("y", 0.5f);
        this.mCropFilter.setOption(r104);
        goto L18
    L15:
        r103 = 0.5f;
    L18:
        if (this.mDisableCropTexture == true) goto L20;
        EffectTexture r105 = this.mCropFilter.process(r100, r101, Boolean.FALSE);
    L24:
        EffectTexture r106 = this.mExtraTexture;
        if (r106 == null) goto L28;
        r106.giveBack();
        this.mExtraTexture = null;
    L28:
        if (this.mDisableReverseExtraTexture == false) goto L30;
        this.mExtraTexture = r100;
    L32:
        return r105;
    L30:
        this.mExtraTexture = processTexture(r100, r101, this.mSurfaceTexture, 1);
        goto L32
    L20:
        if (this.mCropedTexture != null) goto L22;
        this.mCropedTexture = this.mCropFilter.process(r100, r101, Boolean.FALSE);
    L22:
        r105 = this.mCropedTexture;
        goto L24
    }

    public void onLogReport(int r100, String r101) {
        if (r100 >= this.mSixDofLiteLogLevel) goto L6;
        return;
    L6:
        if (r100 != 2) goto L8;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, r101);
        return;
    L8:
        if (r100 != 3) goto L10;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, r101);
        return;
    L10:
        if (r100 != 4) goto L12;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, r101);
        return;
    L12:
        if (r100 != 5) goto L14;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, r101);
        return;
    L14:
        if (r100 != 6) goto L26;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, r101);
        return;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        long r110 = System.currentTimeMillis();
        checkReverseStatusChanged();
        if (this.mEnableVideoEffectSixDofLite == false) goto L5;
        EffectTexture r111 = processSixDofLiteBefore(r210, r211);
    L7:
        if (this.mHandle == 0) goto L70;
        if (r111 == null) goto L70;
        if (this.mIsInit == false) goto L70;
        if (isLibLoaded == false) goto L70;
        if (this.mSurfaceTexture.getIntOption(163) != 1) goto L70;
        if (this.mDisableReverseMainTexture == false) goto L19;
        EffectTexture r100 = r111;
    L20:
        if (r100 != null) goto L23;
        return r111;
    L23:
        if (r100.getWidth() != 0) goto L25;
    L67:
        EffectTexture r212 = r111;
        r100.giveBack();
        return r212;
    L25:
        if (r100.getHeight() == 0) goto L67;
        if (r211 == null) goto L35;
        TextureRenderer r101 = this.mParentRender;
        if (r101 == null) goto L35;
        if (r101.getEffectTextureManager() == null) goto L35;
        if (this.mSurfaceTexture == null) goto L35;
        EffectTexture r102 = this.mParentRender.getEffectTextureManager().genTexture(r111.getWidth(), r111.getHeight(), this.mSurfaceTexture.getIntOption(130), r111.getRect());
    L36:
        EffectTexture r103 = r102;
        if (r103 == null) goto L65;
        double r112 = ((long) ((System.currentTimeMillis() / 1000.0d) * 1000.0d)) / 1000.0d;
        if (this.mEnableVideoEffectSixDofLite == true) goto L41;
    L43:
        EffectTexture r113 = r100;
        EffectTexture r213 = r111;
        int r104 = _processFrame(this.mHandle, r100.getTexID(), r103.getTexID(), r100.getWidth(), r100.getHeight(), r112, this.mSeiKey, this.mSeiInfo);
        if (this.mDisableCropTexture == false) goto L46;
        this.mCropedTexture = r113;
    L47:
        if (r104 != 0) goto L61;
        this.mProcessOccurError = false;
        if (this.mDisableReverseMainTexture == false) goto L51;
        EffectTexture r105 = processTexture(r103, r211, this.mSurfaceTexture, 0);
    L52:
        if (r105 == null) goto L58;
        r213.giveBack();
        r105.giveBack();
        this.mFrameCount++;
        this.mCostSum += System.currentTimeMillis() - r110;
        if ((this.mFrameCount % 300) != 299) goto L57;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process cost_avg:" + (this.mCostSum / this.mFrameCount));
        this.mFrameCount = 0;
        this.mCostSum = AudioStats.AUDIO_AMPLITUDE_NONE;
    L57:
        return new EffectTexture(null, r105.getTexID(), r105.getWidth(), r105.getHeight(), 3553, r105.getRect());
    L58:
        r103.giveBack();
        return r213;
    L51:
        r105 = processTexture(r103, r211, this.mSurfaceTexture, 1);
        goto L52
    L61:
        if (this.mProcessOccurError == true) goto L63;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "iceffect process error code: " + r104);
        this.mSurfaceTexture.notifyError(18, this.mEffectType, "iceffect process error code: " + r104);
        this.mProcessOccurError = true;
    L63:
        r103.giveBack();
        return r213;
    L46:
        r113.giveBack();
        goto L47
    L41:
        if (this.mSixDofLiteMode != 2) goto L43;
        processSixDofLite(this.mExtraTexture, r211);
        goto L43
    L65:
        EffectTexture r214 = r111;
        r100.giveBack();
        return r214;
    L35:
        r102 = null;
        goto L36
    L19:
        r100 = processTexture(r111, r211, this.mSurfaceTexture, 1);
    L70:
        return r111;
    L5:
        r111 = r210;
        goto L7
    }

    public void onReceiveEffectMessage(int r110, long r111, long r112, String r113) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "onReceiveEffectMessage, msgType: " + r110 + ", arg: " + r113);
        IEffectMsgListener r100 = this.mMsgListener;
        if (r100 == null) goto L6;
        r100.onMessageReceived(r110, r111, r112, r113);
        return;
    }

    public EffectTexture processTexture(EffectTexture r100, FrameBuffer r101, VideoSurfaceTexture r102, int r103) {
        if (this.mDefaultFilter != null) goto L9;
        GLDefaultFilter r104 = (GLDefaultFilter) EffectFactory.createEffect(this.mTexType, 7);
        this.mDefaultFilter = r104;
        if (r104 != null) goto L8;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create GLDefaultFilter failed");
        return null;
    L8:
        r104.setSurfaceTexture(r102);
        this.mDefaultFilter.init(null);
        this.mDefaultFilter.setParentRender(this.mParentRender);
    L9:
        this.mDefaultFilter.setOption(31, r103);
        return this.mDefaultFilter.process(r100, r101);
    }
}
