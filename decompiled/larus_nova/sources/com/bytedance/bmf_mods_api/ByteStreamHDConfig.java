package com.bytedance.bmf_mods_api;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class ByteStreamHDConfig {
    public static final int AESBOOST_ALG_TYPE = 1;
    public static final int DENOISE_ALG_TYPE = 2;
    public static final int SHARP_ALG_TYPE = 4;
    int abStrategy;
    int aesBoostAlgType;
    int denoiseAlgType;
    private String downLoadPath;
    private int[] groupIds;
    int mediumISO;
    private String modelNamePrefix;
    private final Map<String, String> paramMap;
    int sharpAlgType;
    float strength;
    int strongISO;
    int subalgListIndex;
    int texProcessType;
    float thresholdHigh;
    float thresholdLow;
    int weakISO;
    int windowType;

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_api.ByteStreamHDConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        int abStrategy;
        int aesBoostAlgType;
        int denoiseAlgType;
        private String downLoadPath;
        private int[] groupIds;
        int mediumISO;
        private String modelNamePrefix;
        private final Map<String, String> paramMap;
        int sharpAlgType;
        float strength;
        int strongISO;
        int subalgListIndex;
        int texProcessType;
        float thresholdHigh;
        float thresholdLow;
        int weakISO;
        int windowType;

        public ByteStreamHDConfig build() throws BmfException {
            if (this.aesBoostAlgType > 0) goto L5;
        L25:
            ByteStreamHDConfig r100 = new ByteStreamHDConfig(this.paramMap, null);
            ByteStreamHDConfig.access$102(r100, this.modelNamePrefix);
            ByteStreamHDConfig.access$202(r100, this.downLoadPath);
            ByteStreamHDConfig.access$302(r100, this.groupIds);
            r100.aesBoostAlgType = this.aesBoostAlgType;
            r100.denoiseAlgType = this.denoiseAlgType;
            r100.windowType = this.windowType;
            r100.abStrategy = this.abStrategy;
            r100.weakISO = this.weakISO;
            r100.mediumISO = this.mediumISO;
            r100.strongISO = this.strongISO;
            r100.sharpAlgType = this.sharpAlgType;
            r100.strength = this.strength;
            r100.thresholdLow = this.thresholdLow;
            r100.thresholdHigh = this.thresholdHigh;
            r100.subalgListIndex = this.subalgListIndex;
            r100.texProcessType = this.texProcessType;
            return r100;
        L5:
            if (this.paramMap.containsKey("host") == false) goto L24;
            if (this.paramMap.containsKey("accessKey") == false) goto L24;
            if (TextUtils.isEmpty(this.paramMap.get("host")) == true) goto L24;
            if (TextUtils.isEmpty(this.paramMap.get("accessKey")) == true) goto L24;
            if (this.groupIds == null) goto L22;
            String r101 = this.modelNamePrefix;
            if (r101 == null) goto L20;
            if (r101.isEmpty() == false) goto L25;
        L20:
            throw new BmfException(-100020, "modelNamePrefix is null,aesboost need set");
        L22:
            throw new BmfException(-100020, "groupIds is null");
        L24:
            throw new BmfException(-100020, "host or accessKey is null,aesboost need set");
        }

        public Builder() {
            this.paramMap = new HashMap();
            this.modelNamePrefix = "";
            this.downLoadPath = "";
            this.groupIds = new int[]{3, 4, 5};
        }

        public Builder setSubAlgListIndexParam(int r100) {
            this.subalgListIndex = r100;
            return this;
        }

        public Builder setTexProcessTypeParam(int r100) {
            this.texProcessType = r100;
            return this;
        }

        public Builder setAesBoostAlgParam(int r100, int[] r101, String r102, String r103) {
            this.aesBoostAlgType = r100;
            this.groupIds = r101;
            this.modelNamePrefix = r102;
            this.downLoadPath = r103;
            return this;
        }

        public Builder setSharpAlgParam(int r100, float r101, float r102, float r103) {
            this.sharpAlgType = r100;
            this.strength = r101;
            this.thresholdLow = r102;
            this.thresholdHigh = r103;
            return this;
        }

        public Builder setDenoiseAlgParam(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.denoiseAlgType = r100;
            this.windowType = r101;
            this.abStrategy = r102;
            this.weakISO = r103;
            this.mediumISO = r104;
            this.strongISO = r105;
            return this;
        }

        public Builder setHostInfoParam(String r100, String r101, String r102, String r103, String r104, String r105) {
            this.paramMap.put("host", r100);
            this.paramMap.put("accessKey", r101);
            this.paramMap.put("platformSdkVersion", r105);
            this.paramMap.put("deviceId", r104);
            this.paramMap.put(b.f276371u, r102);
            this.paramMap.put("appVersion", r103);
            return this;
        }
    }

    public String toString() {
        return "{ modelNamePrefix: " + this.modelNamePrefix + "downLoadPath: " + this.downLoadPath + ", groupIds: " + Arrays.toString(this.groupIds) + ", host: " + this.paramMap.get("host") + ", accessKey: " + this.paramMap.get("accessKey") + ", deviceId: " + this.paramMap.get("deviceId") + ", appVersion: " + this.paramMap.get("appVersion") + ", appID: " + this.paramMap.get(b.f276371u) + ", platformSdkVersion: " + this.paramMap.get("platformSdkVersion") + " }";
    }

    public int getAbStrategy() {
        return this.abStrategy;
    }

    public int getAesBoostAlgType() {
        return this.aesBoostAlgType;
    }

    public int getDenoiseAlgType() {
        return this.denoiseAlgType;
    }

    public String getDownLoadPath() {
        return this.downLoadPath;
    }

    public int[] getGroupIds() {
        return this.groupIds;
    }

    public int getMediumISO() {
        return this.mediumISO;
    }

    public String getModelNamePrefix() {
        return this.modelNamePrefix;
    }

    public Map<String, String> getParamMap() {
        return this.paramMap;
    }

    public int getSharpAlgType() {
        return this.sharpAlgType;
    }

    public float getSharpStrength() {
        return this.strength;
    }

    public float getSharpThresholdHigh() {
        return this.thresholdHigh;
    }

    public float getSharpThresholdLow() {
        return this.thresholdLow;
    }

    public int getStrongISO() {
        return this.strongISO;
    }

    public int getSubAlgListIndex() {
        return this.subalgListIndex;
    }

    public int getTexProcessType() {
        return this.texProcessType;
    }

    public int getWeakISO() {
        return this.weakISO;
    }

    public int getWindowType() {
        return this.windowType;
    }

    private ByteStreamHDConfig(Map<String, String> r100) {
        this.modelNamePrefix = "";
        this.downLoadPath = "";
        this.paramMap = r100;
    }

    public /* synthetic */ ByteStreamHDConfig(Map r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ String access$102(ByteStreamHDConfig r100, String r101) {
        r100.modelNamePrefix = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(ByteStreamHDConfig r100, String r101) {
        r100.downLoadPath = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$302(ByteStreamHDConfig r100, int[] r101) {
        r100.groupIds = r101;
        return r101;
    }
}
