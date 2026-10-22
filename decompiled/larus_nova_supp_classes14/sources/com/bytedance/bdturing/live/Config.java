package com.bytedance.bdturing.live;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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
        JSONObject r1 = new JSONObject();
        r1.put("detect_model_confidence_th", this.detect_model_confidence_th + "");     // Catch: Exception -> L5
        r1.put("detect_model_top_k", this.detect_model_top_k + "");     // Catch: Exception -> L5
        r1.put("detect_model_nms_th", this.detect_model_nms_th + "");     // Catch: Exception -> L5
        r1.put("detect_model_keep_top_k", this.detect_model_keep_top_k + "");     // Catch: Exception -> L5
        r1.put("illumination_low_th", this.illumination_low_th + "");     // Catch: Exception -> L5
        r1.put("illumination_high_th", this.illumination_high_th + "");     // Catch: Exception -> L5
        r1.put("in_rob_th", this.in_rob_th + "");     // Catch: Exception -> L5
        r1.put("too_small_th", this.too_small_th + "");     // Catch: Exception -> L5
        r1.put("too_large_th", this.too_large_th + "");     // Catch: Exception -> L5
        r1.put("fit_roi_th", this.fit_roi_th + "");     // Catch: Exception -> L5
        r1.put("visible_point_th", this.visible_point_th + "");     // Catch: Exception -> L5
        r1.put("visible_point_rate_th", this.visible_point_rate_th + "");     // Catch: Exception -> L5
        r1.put("eye_ratio_th", this.eye_ratio_th + "");     // Catch: Exception -> L5
        r1.put("mouth_ratio_lo_th", this.mouth_ratio_lo_th + "");     // Catch: Exception -> L5
        r1.put("mouth_ratio_hi_th", this.mouth_ratio_hi_th + "");     // Catch: Exception -> L5
        r1.put("vertical_angle_th", this.vertical_angle_th + "");     // Catch: Exception -> L5
    L7:
        return r1;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public Config() {
    }

    public Config(JSONObject r7) {
        this.detect_model_confidence_th = (float) r7.optDouble("detect_model_confidence_th", 0.0d);
        this.detect_model_top_k = r7.optInt("detect_model_top_k", 0);
        this.detect_model_nms_th = (float) r7.optDouble("detect_model_nms_th", 0.0d);
        this.detect_model_keep_top_k = r7.optInt("detect_model_keep_top_k", 0);
        this.illumination_low_th = r7.optInt("illumination_low_th", 0);
        this.illumination_high_th = r7.optInt("illumination_high_th", 0);
        this.in_rob_th = (float) r7.optDouble("in_rob_th", 0.0d);
        this.too_small_th = (float) r7.optDouble("too_small_th", 0.0d);
        this.too_large_th = (float) r7.optDouble("too_large_th", 0.0d);
        this.fit_roi_th = (float) r7.optDouble("fit_roi_th", 0.0d);
        this.visible_point_th = (float) r7.optDouble("visible_point_th", 0.0d);
        this.visible_point_rate_th = (float) r7.optDouble("visible_point_rate_th", 0.0d);
        this.eye_ratio_th = (float) r7.optDouble("eye_ratio_th", 0.0d);
        this.mouth_ratio_lo_th = (float) r7.optDouble("mouth_ratio_lo_th", 0.0d);
        this.mouth_ratio_hi_th = (float) r7.optDouble("mouth_ratio_hi_th", 0.0d);
        this.vertical_angle_th = (float) r7.optDouble("vertical_angle_th", 0.0d);
    }
}
