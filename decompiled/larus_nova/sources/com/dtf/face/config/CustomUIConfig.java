package com.dtf.face.config;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class CustomUIConfig {
    private JSONObject docConfig;
    private String errMsg;
    private FaceConfig faceConfig;
    private GuideConfig guideConfig;
    private boolean isValid;
    private JSONObject nfcConfig;

    public FaceConfig getFaceConfig() {
        if (this.faceConfig != null) goto L6;
        this.faceConfig = new FaceConfig();
    L6:
        return this.faceConfig;
    }

    public GuideConfig getGuideConfig() {
        if (this.guideConfig != null) goto L6;
        this.guideConfig = new GuideConfig();
    L6:
        return this.guideConfig;
    }

    public CustomUIConfig() {
        this.isValid = true;
    }

    public JSONObject getDocConfig() {
        return this.docConfig;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public GuideConfig getLoadingConfig() {
        return this.guideConfig;
    }

    public JSONObject getNfcConfig() {
        return this.nfcConfig;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setDocConfig(JSONObject r100) {
        this.docConfig = r100;
    }

    public void setErrMsg(String r100) {
        this.errMsg = r100;
    }

    public void setFaceConfig(FaceConfig r100) {
        this.faceConfig = r100;
    }

    public void setGuideConfig(GuideConfig r100) {
        this.guideConfig = r100;
    }

    public void setLoadingConfig(GuideConfig r100) {
        this.guideConfig = r100;
    }

    public void setNfcConfig(JSONObject r100) {
        this.nfcConfig = r100;
    }

    public void setValid(boolean r100) {
        this.isValid = r100;
    }
}
