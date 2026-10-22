package umc;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.VideoSurface;
import com.ss.videoarch.liveplayer.AdaptiveGradingConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f550743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f550744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f550745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdaptiveGradingConfig f550746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f550747e;

    public a() {
        this.f550743a = TECameraUtils.CAPTURE_NORMAL;
        this.f550744b = TECameraUtils.CAPTURE_NORMAL;
        this.f550747e = 2000;
    }

    private void updateConfig(b.a r100) {
        if (r100 == null) goto L9;
        VideoSurface r101 = r100.f550749b;
        if (r101 == null) goto L10;
        AdaptiveGradingConfig r102 = r100.f550748a;
        if (r102 == null) goto L11;
        setDstAdaptiveGrading(r102, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void init(VideoSurface r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = new Bundle();
        r101.putInt("action", 21);
        r101.putInt("effect_type", 14);
        r101.putInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT, this.f550744b);
        r101.putInt(TextureRenderKeys.KEY_IS_MAX_WIDTH, this.f550743a);
        r101.putString(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CACHE_FILE, this.f550745c);
        r101.putLong(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_GOP_TIME_MS, this.f550747e);
        AdaptiveGradingConfig r102 = this.f550746d;
        if (r102 == null) goto L15;
        float[] r103 = r102.mBrightnessThreshold;
        if (r103 == null) goto L9;
        r101.putFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_BRIGHTNESS_THRESHOLD, r103);
    L9:
        float[] r104 = this.f550746d.mContrastThreshold;
        if (r104 == null) goto L12;
        r101.putFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CONTRAST_THRESHOLD, r104);
    L12:
        float[] r105 = this.f550746d.mSaturationThreshold;
        if (r105 == null) goto L15;
        r101.putFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SATURATION_THRESHOLD, r105);
    L15:
        r101.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, 1);
        r100.setEffect(r101);
    }

    public void setUseEffect(VideoSurface r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = new Bundle();
        r101.putInt("action", 19);
        r101.putInt("effect_type", 14);
        r101.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, 1);
        r100.setEffect(r101);
        Bundle r102 = new Bundle();
        r102.putInt("action", 140);
        r102.putInt("effect_type", 14);
        r102.putBoolean(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_IS_NEW_FRAME, true);
        r102.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, 1);
        AdaptiveGradingConfig r103 = this.f550746d;
        if (r103 == null) goto L7;
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_BRIGHTNESS, r103.mBrightness);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_CONTRAST, this.f550746d.mContrast);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_SATURATION, this.f550746d.mSaturation);
    L7:
        r100.setEffect(r102);
    }

    private void updateSEIInfo(String r100, VideoSurface r101) {
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L11
        if (r102.has("video_color_hist") == true) goto L6;
        return;
    L6:
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r102, "video_color_hist");     // Catch: Exception -> L11
        if (r103.optInt("valid") == 1) goto L9;
        return;
    L9:
        AdaptiveGradingConfig r104 = new AdaptiveGradingConfig();     // Catch: Exception -> L11
        r104.mBrightness = (float) r103.optDouble("constract");     // Catch: Exception -> L11
        r104.mContrast = (float) r103.optDouble("brightness");     // Catch: Exception -> L11
        r104.mSaturation = (float) r103.optDouble("saturation");     // Catch: Exception -> L11
        setSrcAdaptiveGrading(r104, r101);     // Catch: Exception -> L11
        return;
    }

    public void setDstAdaptiveGrading(AdaptiveGradingConfig r100, VideoSurface r101) {
        Bundle r102 = new Bundle();
        r102.putInt("action", 140);
        r102.putInt("effect_type", 14);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_BRIGHTNESS, r100.mBrightness);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_CONTRAST, r100.mContrast);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_SATURATION, r100.mSaturation);
        r101.setEffect(r102);
    }

    public void setSrcAdaptiveGrading(AdaptiveGradingConfig r100, VideoSurface r101) {
        Bundle r102 = new Bundle();
        r102.putInt("action", 140);
        r102.putInt("effect_type", 14);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_SATURATION, r100.mSaturation);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_CONTRAST, r100.mContrast);
        r102.putFloat(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_BRIGHTNESS, r100.mBrightness);
        r101.setEffect(r102);
    }

    @Override // umc.b
    public void onEvent(int r100, int r101, String r102, Object r103) {
        switch(r100) {
            case 100: goto L16;
            case 101: goto L13;
            case 102: goto L10;
            case 103: goto L8;
            case 104: goto L7;
            case 105: goto L5;
            default: goto L32;
        };
    L7:
        this.f550745c = r102;
        return;
    L8:
        this.f550747e = r101;
        return;
    L32:
        return;
    L5:
        if ((r103 instanceof VideoSurface) == false) goto L22;
        updateSEIInfo(r102, (VideoSurface) r103);
        return;
    L22:
        return;
    L10:
        if ((r103 instanceof VideoSurface) == false) goto L26;
        setUseEffect((VideoSurface) r103);
        return;
    L26:
        return;
    L13:
        if ((r103 instanceof VideoSurface) == false) goto L28;
        init((VideoSurface) r103);
        return;
    L28:
        return;
    L16:
        if ((r103 instanceof b.a) == false) goto L19;
        updateConfig((b.a) r103);
        return;
    L19:
        if ((r103 instanceof AdaptiveGradingConfig) == false) goto L31;
        this.f550746d = (AdaptiveGradingConfig) r103;
        return;
    }
}
