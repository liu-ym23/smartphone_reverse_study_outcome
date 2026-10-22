package com.bytedance.bdturing.live;

import androidx.camera.video.AudioStats;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class Config {
    public float detect_model_confidence_th;
    public int detect_model_keep_top_k;
    public float detect_model_nms_th;
    public String detect_model_path;
    public int detect_model_top_k;
    public float eye_ratio_th;
    public float fit_roi_th;
    public int illumination_high_th;
    public int illumination_low_th;
    public float in_rob_th;
    public String kpt_model_path;
    public float mouth_ratio_hi_th;
    public float mouth_ratio_lo_th;
    public float too_large_th;
    public float too_small_th;
    public float vertical_angle_th;
    public float visible_point_rate_th;
    public float visible_point_th;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("detect_model_confidence_th", this.detect_model_confidence_th + "");     // Catch: Exception -> L5
        r100.put("detect_model_top_k", this.detect_model_top_k + "");     // Catch: Exception -> L5
        r100.put("detect_model_nms_th", this.detect_model_nms_th + "");     // Catch: Exception -> L5
        r100.put("detect_model_keep_top_k", this.detect_model_keep_top_k + "");     // Catch: Exception -> L5
        r100.put("illumination_low_th", this.illumination_low_th + "");     // Catch: Exception -> L5
        r100.put("illumination_high_th", this.illumination_high_th + "");     // Catch: Exception -> L5
        r100.put("in_rob_th", this.in_rob_th + "");     // Catch: Exception -> L5
        r100.put("too_small_th", this.too_small_th + "");     // Catch: Exception -> L5
        r100.put("too_large_th", this.too_large_th + "");     // Catch: Exception -> L5
        r100.put("fit_roi_th", this.fit_roi_th + "");     // Catch: Exception -> L5
        r100.put("visible_point_th", this.visible_point_th + "");     // Catch: Exception -> L5
        r100.put("visible_point_rate_th", this.visible_point_rate_th + "");     // Catch: Exception -> L5
        r100.put("eye_ratio_th", this.eye_ratio_th + "");     // Catch: Exception -> L5
        r100.put("mouth_ratio_lo_th", this.mouth_ratio_lo_th + "");     // Catch: Exception -> L5
        r100.put("mouth_ratio_hi_th", this.mouth_ratio_hi_th + "");     // Catch: Exception -> L5
        r100.put("vertical_angle_th", this.vertical_angle_th + "");     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public Config() {
    }

    public Config(JSONObject r100) {
        this.detect_model_confidence_th = (float) r100.optDouble("detect_model_confidence_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.detect_model_top_k = r100.optInt("detect_model_top_k", 0);
        this.detect_model_nms_th = (float) r100.optDouble("detect_model_nms_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.detect_model_keep_top_k = r100.optInt("detect_model_keep_top_k", 0);
        this.illumination_low_th = r100.optInt("illumination_low_th", 0);
        this.illumination_high_th = r100.optInt("illumination_high_th", 0);
        this.in_rob_th = (float) r100.optDouble("in_rob_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.too_small_th = (float) r100.optDouble("too_small_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.too_large_th = (float) r100.optDouble("too_large_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.fit_roi_th = (float) r100.optDouble("fit_roi_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.visible_point_th = (float) r100.optDouble("visible_point_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.visible_point_rate_th = (float) r100.optDouble("visible_point_rate_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.eye_ratio_th = (float) r100.optDouble("eye_ratio_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mouth_ratio_lo_th = (float) r100.optDouble("mouth_ratio_lo_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mouth_ratio_hi_th = (float) r100.optDouble("mouth_ratio_hi_th", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.vertical_angle_th = (float) r100.optDouble("vertical_angle_th", AudioStats.AUDIO_AMPLITUDE_NONE);
    }
}
