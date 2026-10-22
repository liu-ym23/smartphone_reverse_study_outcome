package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class FaceTips {

    @JSONField(name = "adjustPoseText")
    private String adjustPoseText;

    @JSONField(name = "bottomText")
    public String bottomText;

    @JSONField(name = "brandTip")
    private String brandTip;

    @JSONField(name = "noBlinkText")
    private String noBlinkText;

    @JSONField(name = "noFaceText")
    private String noFaceText;

    @JSONField(name = "sceneText")
    public String sceneText;

    @JSONField(name = "stopScanTip")
    private String stopScanTip;

    @JSONField(name = "topText")
    public String topText;

    @JSONField(name = "topText_angle")
    public String topText_angle;

    @JSONField(name = "topText_blink")
    public String topText_blink;

    @JSONField(name = "topText_blur")
    public String topText_blur;

    @JSONField(name = "topText_depth_damage")
    public String topText_depth_damage;

    @JSONField(name = "topText_integrity")
    public String topText_integrity;

    @JSONField(name = "topText_light")
    public String topText_light;

    @JSONField(name = "topText_max_rectwidth")
    public String topText_max_rectwidth;

    @JSONField(name = "topText_noface")
    public String topText_noface;

    @JSONField(name = "topText_openness")
    public String topText_openness;

    @JSONField(name = "topText_pitch")
    public String topText_pitch;

    @JSONField(name = "topText_quality")
    public String topText_quality;

    @JSONField(name = "topText_rectwidth")
    public String topText_rectwidth;

    @JSONField(name = "topText_stack_time")
    public String topText_stack_time;

    @JSONField(name = "topText_stay")
    public String topText_stay;

    @JSONField(name = "topText_yaw")
    public String topText_yaw;

    public FaceTips() {
        this.brandTip = "";
        this.stopScanTip = "";
        this.sceneText = "";
        this.topText = "";
        this.bottomText = "";
        this.topText_noface = "";
        this.topText_light = "";
        this.topText_rectwidth = "";
        this.topText_integrity = "";
        this.topText_angle = "";
        this.topText_blur = "";
        this.topText_quality = "";
        this.topText_blink = "";
        this.topText_stay = "";
        this.topText_max_rectwidth = "";
        this.topText_pitch = "";
        this.topText_yaw = "";
        this.topText_openness = "";
        this.topText_stack_time = "";
        this.topText_depth_damage = "";
    }
}
