package com.dtf.toyger.base.algorithm;

import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerQualityConfig {
    public float blinkOpenness;
    public float blur_thresh;
    public List<Float> calibrationMaxRegion;
    public List<Float> calibrationMinRegion;
    public float calibrationStackTime;
    public int depthCollectCount;
    public float depthMinQuality;
    public int detectImageFormat;
    public boolean detectImageLight;
    public int detectMode;
    public int detect_face_num;
    public float eyeOcclusion;
    public float eyeOpenness;
    public float eye_openness_thresh;
    public float hat_thresh;
    public int img_light;
    public float light_thresh;
    public float maxGaussian;
    public float maxMotion;
    public float maxPitch;
    public float maxYaw;
    public int max_face_num;
    public float max_iod;
    public float minBrightness;
    public float minFaceWidth;
    public float minIntegrity;
    public float minPitch;
    public float minQuality;
    public float minYaw;
    public float min_iod;
    public float nearFarMaxStackTime;
    public float nearFarStackTime;
    public float occlusion_thresh;
    public float pitch_thresh;
    public float quality_mask_thresh;
    public float quality_thresh;
    public float roll_thresh;
    public int speed;
    public float stackTime;
    public List<Float> targetRegion;
    public List<Float> targetRegionTolerance;
    public float targetStackTime;
    public boolean uploadMultiFace;
    public float yaw_thresh;

    public ToygerQualityConfig() {
        this.img_light = 82;
        this.detectImageLight = false;
        this.uploadMultiFace = false;
        this.max_face_num = 0;
        this.detect_face_num = 1;
        this.speed = 100;
        this.quality_mask_thresh = 0.1f;
        this.hat_thresh = 0.9f;
        this.quality_thresh = 5.0f;
        this.pitch_thresh = 5.0f;
        this.yaw_thresh = 5.0f;
        this.roll_thresh = 5.0f;
        this.light_thresh = 15.0f;
        this.blur_thresh = 5.0f;
        this.occlusion_thresh = 5.0f;
        this.eye_openness_thresh = 0.25f;
        this.nearFarStackTime = 0.2f;
        this.nearFarMaxStackTime = 0.2f;
        this.calibrationStackTime = 0.2f;
        this.targetStackTime = 0.2f;
    }

    public ToygerQualityConfig(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111, float r112, float r113, float r114, float r115, float r116, float r117, float r118, float r119, float r210, int r211, int r212, int r213, int r214, boolean r215, boolean r216, int r217, int r218, int r219) {
        this.quality_mask_thresh = 0.1f;
        this.hat_thresh = 0.9f;
        this.quality_thresh = 5.0f;
        this.pitch_thresh = 5.0f;
        this.yaw_thresh = 5.0f;
        this.roll_thresh = 5.0f;
        this.light_thresh = 15.0f;
        this.blur_thresh = 5.0f;
        this.occlusion_thresh = 5.0f;
        this.eye_openness_thresh = 0.25f;
        this.nearFarStackTime = 0.2f;
        this.nearFarMaxStackTime = 0.2f;
        this.calibrationStackTime = 0.2f;
        this.targetStackTime = 0.2f;
        this.minBrightness = r100;
        this.minFaceWidth = r101;
        this.minIntegrity = r102;
        this.maxPitch = r103;
        this.maxYaw = r104;
        this.maxGaussian = r105;
        this.maxMotion = r110;
        this.minQuality = r111;
        this.stackTime = r112;
        this.min_iod = r113;
        this.max_iod = r114;
        this.blinkOpenness = r115;
        this.eyeOpenness = r116;
        this.eyeOcclusion = r117;
        this.minPitch = r118;
        this.minYaw = r119;
        this.depthCollectCount = r211;
        this.depthMinQuality = r210;
        this.detectImageFormat = r212;
        this.detectMode = r213;
        this.img_light = r214;
        this.detectImageLight = r215;
        this.uploadMultiFace = r216;
        this.max_face_num = r217;
        this.speed = r219;
        this.detect_face_num = r218;
    }
}
