package com.dtf.face.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import faceverify.q;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class AndroidClientConfig {

    @JSONField(name = q.KEY_ALGORITHM_CONFIG)
    private JSONObject algorithm;
    public String clientExtParamStr;
    public JSONObject clientExtParams;
    public VoiceConfig clientVoiceParamConfig;

    @JSONField(name = "coll")
    private Coll coll;

    @JSONField(name = "deviceSettings")
    private DeviceSetting[] deviceSettings;

    @JSONField(name = "env")
    private int env;

    @JSONField(name = "faceTips")
    private FaceTips faceTips;

    @JSONField(name = "navi")
    private NavigatePage navi;

    @JSONField(name = "sceneEnv")
    private SceneEnv sceneEnv;

    @JSONField(name = "sdkActionList")
    private ArrayList<SDKAction> sdkActionList;

    @JSONField(name = "simpleFlags")
    private JSONObject simpleFlags;

    @JSONField(name = "suitable")
    public HashMap<String, String> suitable;

    @JSONField(name = "token")
    public String token;

    /* JADX INFO: renamed from: ui, reason: collision with root package name */
    @JSONField(name = "ui")
    private int f273637ui;

    @JSONField(name = "upload")
    private Upload upload;

    @JSONField(name = "verifyMode")
    private String verifyMode;

    public boolean enableQualityConfig() {
        JSONObject r100 = this.algorithm;
        if (r100 == null) goto L10;
        String r101 = r100.getString("detect_combination");
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.contains(ToygerFaceAlgorithmConfig.ZFACE_QUALITY_DETECT) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public AndroidClientConfig() {
        this.sceneEnv = new SceneEnv();
        this.navi = new NavigatePage();
        this.coll = new Coll();
        this.faceTips = new FaceTips();
        this.sdkActionList = new ArrayList();
        this.deviceSettings = new DeviceSetting[0];
        this.env = 0;
        this.f273637ui = 991;
        this.verifyMode = "normal";
        this.clientExtParamStr = "";
    }

    public JSONObject getAlgorithm() {
        return this.algorithm;
    }

    public VoiceConfig getAndroidVoiceConfig() {
        return this.clientVoiceParamConfig;
    }

    public Coll getColl() {
        return this.coll;
    }

    public DeviceSetting[] getDeviceSettings() {
        return this.deviceSettings;
    }

    public int getEnv() {
        return this.env;
    }

    public FaceTips getFaceTips() {
        return this.faceTips;
    }

    public NavigatePage getNavi() {
        return this.navi;
    }

    public SceneEnv getSceneEnv() {
        return this.sceneEnv;
    }

    public ArrayList<SDKAction> getSdkActionList() {
        return this.sdkActionList;
    }

    public JSONObject getSimpleFlags() {
        return this.simpleFlags;
    }

    public int getUi() {
        return this.f273637ui;
    }

    public Upload getUpload() {
        return this.upload;
    }

    public String getVerifyMode() {
        return this.verifyMode;
    }

    public JSONObject getCaptureConfig(int r100) {
        Upload r101 = this.upload;
        if (r101 == null) goto L12;
        JSONArray r102 = r101.captureConfig;
        if (r102 == null) goto L12;
        if (r102.size() == 0) goto L12;
        JSONArray r103 = this.upload.captureConfig;
        return r103.getJSONObject(r100 % r103.size());
    L12:
        return new JSONObject();
    }

    public void setAlgorithm(JSONObject r100) {
        this.algorithm = r100;
    }

    public void setColl(Coll r100) {
        this.coll = r100;
    }

    public void setDeviceSettings(DeviceSetting[] r100) {
        this.deviceSettings = r100;
    }

    public void setEnv(int r100) {
        this.env = r100;
    }

    public void setFaceTips(FaceTips r100) {
        this.faceTips = r100;
    }

    public void setNavi(NavigatePage r100) {
        this.navi = r100;
    }

    public void setSceneEnv(SceneEnv r100) {
        this.sceneEnv = r100;
    }

    public void setSdkActionList(ArrayList<SDKAction> r100) {
        this.sdkActionList = r100;
    }

    public void setSimpleFlags(JSONObject r100) {
        this.simpleFlags = r100;
    }

    public void setUi(int r100) {
        this.f273637ui = r100;
    }

    public void setUpload(Upload r100) {
        this.upload = r100;
    }

    public void setVerifyMode(String r100) {
        this.verifyMode = r100;
    }
}
