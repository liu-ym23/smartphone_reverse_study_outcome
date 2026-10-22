package com.ss.texturerender.effect;

import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSDR2HDRWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSDR2HDREffect extends AbsEffect {
    private String mAlgorithmName601;
    private String mAlgorithmName709;
    private volatile BrightnessObserver mBrightnessObserver;
    private Context mContext;
    private float mCurrentHDRStrength;
    private float mGradientStep;
    private double[] mHDRStrengthsArray;
    private int mLastColorSpace;
    private int mLastModeId;
    private float mLastScreenBrightness;
    private double[] mLightStepsArray;
    private ArrayList<Integer> mModelIdsList;
    private ArrayList<String> mModelNamesList;
    private int mOutTextureFormat;
    private final VideoSDR2HDRWrapper mSDR2HDRWrapper;
    private double mSaturability;
    private float mTargetStrength;

    public static class BrightnessObserver extends ContentObserver {
        private final String LOG_TAG;
        private final Context mContext;
        private volatile float mCurrentBrightness;
        private final int mMaxBrightness;
        private final int mTexType;

        private int getSystemMaxBrightnessRaw() {
            Resources r100 = Resources.getSystem();     // Catch: Exception -> L7
            int r101 = r100.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");     // Catch: Exception -> L7
            if (r101 == 0) goto L9;
            int r102 = r100.getInteger(r101);     // Catch: Exception -> L7
        L10:
            if (r102 > 0) goto L12;
            return 255;
        L12:
            return r102;
        L9:
            r102 = 255;
        L7:
            e = move-exception;
            TextureRenderLog.w(this.mTexType, this.LOG_TAG, "SDR2HDR getSystemMaxBrightnessRaw exception:" + e.getMessage());
            goto L9
        }

        private void updateScreenBrightness() {
            this.mCurrentBrightness = (getScreenBrightness(this.mContext) * 1.0f) / this.mMaxBrightness;
            TextureRenderLog.i(this.mTexType, this.LOG_TAG, "SDR2HDR screen brightness: " + this.mCurrentBrightness);
        }

        public float getScreenBrightness() {
            if (this.mCurrentBrightness != (-1.0f)) goto L6;
            updateScreenBrightness();
        L6:
            return this.mCurrentBrightness;
        }

        private int getScreenBrightness(Context r100) {
            return Settings.System.getInt(r100.getContentResolver(), "screen_brightness");
        L4:
            e = move-exception;
            TextureRenderLog.w(this.mTexType, this.LOG_TAG, "SDR2HDR getBrightness exception:" + e.getMessage());
            return -1;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r100) {
            super.onChange(r100);
            updateScreenBrightness();
        }

        public BrightnessObserver(int r100, String r101, Context r102, Handler r103) {
            super(r103);
            this.mCurrentBrightness = -1.0f;
            this.mTexType = r100;
            this.LOG_TAG = r101;
            this.mContext = r102.getApplicationContext();
            this.mMaxBrightness = getSystemMaxBrightnessRaw();
        }
    }

    public boolean isReady() {
        if (this.mSurfaceTexture != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mSDR2HDRWrapper.isInitialized() == false) goto L7;
        return true;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        if (this.mSDR2HDRWrapper.isInitialized() == false) goto L6;
        this.mSDR2HDRWrapper.release();
    L6:
        if (this.mBrightnessObserver != null) goto L16;
        monitor-enter(VideoSDR2HDREffect.class);
        this.mContext.getContentResolver().unregisterContentObserver(this.mBrightnessObserver);     // Catch: Throwable -> L12
        this.mBrightnessObserver = null;     // Catch: Throwable -> L12
        monitor-exit(VideoSDR2HDREffect.class);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        return super.release();
    }

    public VideoSDR2HDREffect(int r100) {
        super(r100, 31);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new VideoSDR2HDREffect");
        this.mSDR2HDRWrapper = new VideoSDR2HDRWrapper(r100);
        this.mOrder = 13;
        this.mModelNamesList = null;
        this.mModelIdsList = null;
        this.mAlgorithmName709 = null;
        this.mHDRStrengthsArray = null;
        this.mLightStepsArray = null;
        this.mAlgorithmName601 = null;
        this.mSaturability = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mGradientStep = -1.0f;
        this.mOutTextureFormat = 6;
        this.mLastColorSpace = 1;
        this.mLastModeId = -1;
        this.mLastScreenBrightness = -1.0f;
        this.mTargetStrength = 1.0f;
        this.mCurrentHDRStrength = 1.0f;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public Object getOption(Bundle r100) {
        if (r100.getInt("action") != 204) goto L7;
        return Integer.valueOf(isReady() ? 1 : 0);
    L7:
        return super.getOption(r100);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        super.init(r110);
        Context r100 = TextureRenderManager.getManager().getContext();
        this.mContext = r100;
        if (r100 != null) goto L6;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, context");
        return -1;
    L6:
        this.mAlgorithmName709 = r110.getString(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_ALGORITHM_709);
        String r101 = r110.getString(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_ALGORITHM_601);
        this.mAlgorithmName601 = r101;
        if (this.mAlgorithmName709 == null) goto L48;
        if (r101 == null) goto L48;
        this.mHDRStrengthsArray = r110.getDoubleArray(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_STRENGTHS);
        double[] r102 = r110.getDoubleArray(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_LIGHT_STEPS);
        this.mLightStepsArray = r102;
        if (this.mHDRStrengthsArray == null) goto L25;
        if (r102 == null) goto L25;
        if (this.mBrightnessObserver != null) goto L25;
        monitor-enter(VideoSDR2HDREffect.class);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (this.mBrightnessObserver != null) goto L20;
        this.mBrightnessObserver = new BrightnessObserver(this.mTexType, this.LOG_TAG, this.mContext, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L22
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.mBrightnessObserver);     // Catch: Throwable -> L22
    L20:
        monitor-exit(VideoSDR2HDREffect.class);     // Catch: Throwable -> L22
    L25:
        this.mSaturability = r110.getDouble(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_SATURABILITY);
        this.mGradientStep = (float) r110.getDouble(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_GRADIENT_STEP);
        this.mOutTextureFormat = r110.getInt(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_OUT_TEXTURE_FORMAT, this.mOutTextureFormat);
        if (this.mSDR2HDRWrapper.isInitializing() == false) goto L30;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR isInitializing");
        return -1;
    L30:
        if (this.mSDR2HDRWrapper.isInitialized() == false) goto L33;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "init SDR2HDR isInitialized");
        return 0;
    L33:
        int r103 = r110.getInt(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_PACKAGE_INDEX);
        int r104 = r110.getInt(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_PACKAGE_POOL_SIZE);
        int r111 = r110.getInt(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_PACKAGE_INSTANCE_SIZE);
        String r105 = r110.getString("access_key");
        String r106 = r110.getString(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_DOWNLOAD_HOST);
        String r112 = r110.getString("cache_dir", "");
        this.mModelNamesList = r110.getStringArrayList(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_MODEL_NAMES);
        ArrayList<Integer> r113 = r110.getIntegerArrayList(TextureRenderKeys.KEY_IS_BMF_SDR2HDR_MODEL_IDS);
        this.mModelIdsList = r113;
        ArrayList<String> r107 = this.mModelNamesList;
        if (r107 == null) goto L46;
        if (r113 == null) goto L46;
        String r108 = TextUtils.join(",", r107);
        int[] r114 = new int[this.mModelIdsList.size()];
        int r115 = 0;
    L39:
        if (r115 >= this.mModelIdsList.size()) goto L41;
        r114[r115] = ((Integer) ListProtector.get(this.mModelIdsList, r115)).intValue();
        r115 = r115 + 1;
        goto L39
    L41:
        int r116 = this.mSDR2HDRWrapper.init(this.mContext, r105, r106, r108, r103, r104, r111, r112, r114);
        if (r116 == 0) goto L45;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, bmf init " + r116);
        return -1;
    L45:
        return 0;
    L46:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, param");
        return -1;
    L48:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "init SDR2HDR fail, alg");
        return -1;
    }

    private void notifyFail(int r100, String r101) {
        if (this.mSurfaceTexture != null) goto L5;
        return;
    L5:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "code:" + r100 + ", message:" + r101);
        this.mSurfaceTexture.notifyInitError(r100, this.mEffectType, r101);
        this.mSurfaceTexture.setOption(42, 0);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        r210.setDrType(0);
        if (this.mSDR2HDRWrapper.isInitialized() == true) goto L5;
    L83:
        notifyFail(20, "process SDR2HDR fail, not ready");
        return r210;
    L5:
        if (this.mSurfaceTexture == null) goto L83;
        if (this.mSDR2HDRWrapper.enableAlg((float) this.mSaturability, this.mOutTextureFormat) == 0) goto L11;
        notifyFail(21, "process SDR2HDR fail, enable alg");
        return r210;
    L11:
        int r100 = this.mLastColorSpace;
        int r101 = this.mSurfaceTexture.getIntOption(169);
        int r102 = -1;
        if (r101 == (-1)) goto L15;
        r100 = (r101 >> 2) & 63;
    L15:
        if (r100 == this.mLastColorSpace) goto L17;
    L18:
        this.mLastColorSpace = r100;
        if (r100 != 5) goto L21;
    L24:
        int r103 = this.mModelNamesList.indexOf(this.mAlgorithmName601);
    L25:
        if (r103 != (-1)) goto L27;
    L29:
        float[] r110 = new float[16];
        this.mSurfaceTexture.getTransformMatrix(r110);
        if (this.mHDRStrengthsArray != null) goto L32;
    L69:
        this.mCurrentHDRStrength = 1.0f;
    L71:
        if (this.mCurrentHDRStrength >= 0.0f) goto L73;
    L81:
        notifyFail(22, "SDR2HDR process error, param");
        return r210;
    L73:
        if (this.mLastModeId <= 0) goto L81;
        int r111 = this.mSDR2HDRWrapper.process(r210.getTexTarget(), r210.getTexID(), r210.getWidth(), r210.getHeight(), this.mCurrentHDRStrength, this.mLastModeId, r110);
        if (r111 >= 0) goto L79;
        notifyFail(23, "SDR2HDR process error, bmf process");
        return r210;
    L79:
        EffectTexture r104 = new EffectTexture(null, r111, r210.getWidth(), r210.getHeight(), 3553, r210.getRect());
        r104.setDrType(1);
        return r104;
    L32:
        if (this.mLightStepsArray == null) goto L69;
        if (this.mBrightnessObserver == null) goto L69;
        float r105 = this.mBrightnessObserver.getScreenBrightness();
        if (this.mLastScreenBrightness == r105) goto L54;
        int r106 = 1;
    L38:
        double[] r107 = this.mLightStepsArray;
        if (r106 >= r107.length) goto L46;
        double r108 = r105;
        int r112 = r106 - 1;
        if (r108 < r107[r112]) goto L45;
        if (r108 > r107[r106]) goto L45;
        r102 = r112;
    L45:
        r106 = r106 + 1;
    L46:
        if (r102 < 0) goto L53;
        double[] r109 = this.mHDRStrengthsArray;
        if (r109.length <= r102) goto L53;
        if (this.mGradientStep <= 0.0f) goto L52;
        this.mTargetStrength = (float) r109[r102];
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "SDR2HDR process, update target strength " + this.mTargetStrength);
        goto L53
    L52:
        this.mCurrentHDRStrength = (float) r109[r102];
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "SDR2HDR process, update current strength " + this.mTargetStrength);
    L53:
        this.mLastScreenBrightness = r105;
    L54:
        float r113 = this.mGradientStep;
        if (r113 <= 0.0f) goto L71;
        float r114 = this.mTargetStrength;
        if (r114 == (-1.0f)) goto L71;
        float r115 = this.mCurrentHDRStrength;
        if (r115 == r114) goto L71;
        if (r115 <= r114) goto L64;
        this.mCurrentHDRStrength = r115 - r113;
    L67:
        if (Math.abs(this.mCurrentHDRStrength - r114) > this.mGradientStep) goto L71;
        this.mCurrentHDRStrength = this.mTargetStrength;
        this.mTargetStrength = -1.0f;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "SDR2HDR process, update current strength " + this.mCurrentHDRStrength);
        goto L71
    L64:
        if (r115 >= r114) goto L67;
        this.mCurrentHDRStrength = r115 + r113;
        goto L67
    L27:
        if (r103 >= this.mModelIdsList.size()) goto L29;
        this.mLastModeId = ((Integer) ListProtector.get(this.mModelIdsList, r103)).intValue();
        goto L29
    L21:
        if (r100 == 6) goto L24;
        r103 = this.mModelNamesList.indexOf(this.mAlgorithmName709);
        goto L25
    L17:
        if (this.mLastModeId >= 0) goto L29;
        goto L18
    }
}
