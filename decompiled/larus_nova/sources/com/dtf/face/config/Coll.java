package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes22.dex */
public class Coll {

    @JSONField(name = "actionMode")
    public String[] actionMode;

    @JSONField(name = "asyncUp")
    public boolean asyncUp;

    @JSONField(name = "authorization")
    public boolean authorization;

    @JSONField(name = "bottomText")
    public String bottomText;

    @JSONField(name = "captureFrameLimit")
    private int captureFrameLimit;

    @JSONField(name = "chameleon")
    public Chameleon chameleon;

    @JSONField(name = "doVideoCapture")
    private boolean doVideoCapture;

    @JSONField(name = "docInputMode")
    public String docInputMode;

    @JSONField(name = "docType")
    public String docType;

    @JSONField(name = "docUIRatio")
    public float docUIRatio;

    @JSONField(name = "encUp")
    public boolean encUp;

    @JSONField(name = "far")
    public float far;

    @JSONField(name = "imageIndex")
    public int imageIndex;

    @JSONField(name = "light")
    public int light;

    @JSONField(name = "logUpload")
    public Integer logUpload;

    @JSONField(name = "maxangle")
    public float maxangle;

    @JSONField(name = "minangle")
    public float minangle;

    @JSONField(name = "mineDscore")
    public int mineDscore;

    @JSONField(name = "mineVideo")
    public int mineVideo;

    @JSONField(name = "minlight")
    public int minlight;

    @JSONField(name = "multiLangVer")
    public String multiLangVer;

    @JSONField(name = "near")
    public float near;

    @JSONField(name = "opType")
    public String opType;

    @JSONField(name = "pageNo")
    public int pageNo;

    @JSONField(name = "progressbar")
    public boolean progressbar;

    @JSONField(name = "readImg")
    public String readImg;

    @JSONField(name = EventConstant.Value.RETRY)
    public int retry;

    @JSONField(name = "retryLimit")
    public int retryLimit;

    @JSONField(name = "scanTimeout")
    public int scanTimeout;

    @JSONField(name = "time")
    public int time;

    @JSONField(name = "topText")
    public String topText;

    @JSONField(name = "topText_angle")
    public String topText_angle;

    @JSONField(name = "topText_blink")
    public String topText_blink;

    @JSONField(name = "topText_blur")
    public String topText_blur;

    @JSONField(name = "topText_integrity")
    public String topText_integrity;

    @JSONField(name = "topText_light")
    public String topText_light;

    @JSONField(name = "topText_max_rectwidth")
    public String topText_max_rectwidth;

    @JSONField(name = "topText_noface")
    public String topText_noface;

    @JSONField(name = "topText_quality")
    public String topText_quality;

    @JSONField(name = "topText_rectwidth")
    public String topText_rectwidth;

    @JSONField(name = "topText_stay")
    public String topText_stay;

    @JSONField(name = "uiType")
    public String uiType;

    @JSONField(name = "uploadBestPic")
    public boolean uploadBestPic;

    @JSONField(name = "uploadBigPic")
    public boolean uploadBigPic;

    @JSONField(name = "uploadDepthData")
    public boolean uploadDepthData;

    @JSONField(name = "uploadLivePic")
    public boolean uploadLivePic;

    @JSONField(name = "uploadMonitorPic")
    public int uploadMonitorPic;

    @JSONField(name = "uploadPoseOkPic")
    public boolean uploadPoseOkPic;

    public Coll() {
        this.retry = 3;
        this.minangle = -0.6f;
        this.maxangle = 0.6f;
        this.near = 0.5f;
        this.far = 0.28f;
        this.minlight = 50;
        this.time = 20;
        this.light = 178;
        this.imageIndex = 1;
        this.mineDscore = 1;
        this.mineVideo = 5;
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
        this.uploadMonitorPic = 0;
        this.uploadLivePic = false;
        this.progressbar = false;
        this.uploadBestPic = true;
        this.uploadPoseOkPic = false;
        this.uploadBigPic = true;
        this.uploadDepthData = false;
        this.authorization = false;
        this.actionMode = new String[]{"7"};
        this.asyncUp = true;
        this.encUp = true;
        this.opType = "";
        this.docInputMode = "";
        this.readImg = "";
        this.docUIRatio = 0.639f;
        this.doVideoCapture = false;
    }

    public int getCaptureFrameLimit() {
        return this.captureFrameLimit;
    }

    public boolean isAsyncUp() {
        return this.asyncUp;
    }

    public boolean isAuthorization() {
        return this.authorization;
    }

    public boolean isDoVideoCapture() {
        return this.doVideoCapture;
    }

    public boolean isEncUp() {
        return this.encUp;
    }

    public void setAsyncUp(boolean r100) {
        this.asyncUp = r100;
    }

    public void setAuthorization(boolean r100) {
        this.authorization = r100;
    }

    public void setCaptureFrameLimit(int r100) {
        this.captureFrameLimit = r100;
    }

    public void setDoVideoCapture(boolean r100) {
        this.doVideoCapture = r100;
    }

    public void setEncUp(boolean r100) {
        this.encUp = r100;
    }
}
