package com.ss.bduploader.smartserver;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ugc.clientai.core.api.SmartInputData;
import com.ss.ugc.clientai.core.api.SmartOutputData;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class SmartServiceWrapper implements SmartServiceInterface {
    public static final int KEY_IS_MLSDK_ENGINE_TYPE = 1000;
    public static final int KEY_IS_MLSDK_OUTPUT_TYPE = 1002;
    public static final int KEY_IS_MLSDK_SERVICE_NAME = 1001;
    public static final int KEY_IS_MLSDK_URL = 1003;
    public static final int KeyIsIntelligentClassification = 1;
    public static final int KeyIsIntelligentRegression = 0;
    private String mIntelligentURL;
    private String mMLSDKEngineType;
    private String mMLSDKOutputType;
    private SmartService mMLSDKService;
    private String mMLSDKServiceName;

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void runAsync(Map r100, SmartServiceListener r101) {
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runAsyncJsonObject(JSONObject r100, SmartServiceListener r101) {
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSyncJsonObject(JSONObject r100) {
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setIntValue(int r100, int r101) {
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void configServer() {
        if (TextUtils.isEmpty(this.mMLSDKEngineType) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mMLSDKOutputType) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mMLSDKServiceName) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mIntelligentURL) == true) goto L19;
        SmartService r100 = SmartServiceManager.instance().getCommonService(this.mMLSDKServiceName);
        this.mMLSDKService = r100;
        if (r100 == null) goto L18;
        SmartServiceConfig r101 = new SmartServiceConfig(this.mMLSDKServiceName);
        Map<String, Object> r102 = r101.configMap();
        r102.put("engineType", this.mMLSDKEngineType);
        r102.put("outputType", this.mMLSDKOutputType);
        r102.put("packageUrl", this.mIntelligentURL);
        this.mMLSDKService.configService(r101);
        return;
    L18:
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void preloadEnv() {
        SmartService r100 = this.mMLSDKService;
        if (r100 == null) goto L6;
        r100.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public boolean serviceEnabled() {
        SmartService r100 = this.mMLSDKService;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.enable() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public SmartServiceWrapper() {
        this.mMLSDKEngineType = "";
        this.mMLSDKServiceName = "";
        this.mMLSDKOutputType = "";
        this.mIntelligentURL = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSync(Map r100) {
        Objects.toString(r100);
        SmartInputData r101 = new SmartInputData();
        Map<String, Object> r102 = r101.inputMap();
        Iterator r103 = r100.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        r102.put(r104, r100.get(r104));
        goto L4
    L6:
        SmartService r105 = this.mMLSDKService;
        if (r105 != null) goto L9;
    L17:
        return -1.0f;
    L9:
        if (r105.enable() == false) goto L17;
        SmartOutputData r106 = this.mMLSDKService.runSync(r101);
        if (r106 == null) goto L17;
        if (r106.success() == false) goto L17;
        if (r106.getValue() == null) goto L17;
        return r106.getValue().floatValue();
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public int getIntelligentInput(JSONObject r100, SmartInputData r110) {
        Objects.toString(r100);
        Map<String, Object> r111 = r110.inputMap();
        if (JSONObjectProtectorUtils.getJSONObject(r100, "optimized_info") == null) goto L24;
        if (JSONObjectProtectorUtils.getInt(r100, "origin_speed_test") <= 0) goto L24;
        r111.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r100, "origin_speed_test", 0)));
        r111.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r100, "init_rtt", 1)) / 1000.0d));
        r111.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r100, "close_rtt", 1)) / 1000.0d));
        r111.put("mss", Float.valueOf(parseIntelligentInputFloat(r100, "mss", 1)));
        r111.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r100, RNParamRegisterEventHandler.SRC_INNER, 1)) / 1000.0d));
        r111.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r100, PlayerResolution.SDKKEY.ORIGIN, 1)) / 1000.0d));
        String r101 = parseIntelligentInputString(r100, "apply_start", 0);
        String r102 = parseIntelligentInputString(r100, "apply_end", 0);
        if (r102.isEmpty() == true) goto L24;
        if (r101.isEmpty() == true) goto L24;
        float r103 = CastLongProtector.valueOf(r102).longValue() - CastLongProtector.valueOf(r101).longValue();
        if (r103 >= 0.0f) goto L16;
        return -1;
    L16:
        r111.put("apply_duration", Float.valueOf(r103));
        String r104 = parseIntelligentInputString(r100, "node_type", 0);
        r104.getClass();
        if (r104.equals("Origin") == false) goto L19;
        r111.put("node_type", Float.valueOf(2.0f));
    L23:
        return 0;
    L19:
        if (r104.equals("Edge") == true) goto L21;
        r111.put("node_type", Float.valueOf(0.0f));
        goto L23
    L21:
        r111.put("node_type", Float.valueOf(1.0f));
    L24:
        return -1;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setStringValue(int r100, String r101) {
        switch(r100) {
            case 1000: goto L7;
            case 1001: goto L6;
            case 1002: goto L5;
            case 1003: goto L4;
            default: goto L12;
        };
    L4:
        this.mIntelligentURL = r101;
        return;
    L5:
        this.mMLSDKOutputType = r101;
        return;
    L6:
        this.mMLSDKServiceName = r101;
        return;
    L7:
        this.mMLSDKEngineType = r101;
        return;
    }

    private float parseIntelligentInputFloat(JSONObject r100, String r101, int r102) {
        if (r102 != 1) goto L5;
        double r103 = JSONObjectProtectorUtils.getDouble(JSONObjectProtectorUtils.getJSONObject(r100, "optimized_info"), r101);     // Catch: Exception -> L7
    L6:
        return (float) r103;
    L5:
        r103 = JSONObjectProtectorUtils.getDouble(r100, r101);     // Catch: Exception -> L7
    L7:
        return 0.0f;
    }

    private String parseIntelligentInputString(JSONObject r100, String r101, int r102) {
        if (r102 != 1) goto L5;
        String r103 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r100, "optimized_info"), r101);     // Catch: Exception -> L7
    L9:
        return r103;
    L5:
        r103 = JSONObjectProtectorUtils.getString(r100, r101);     // Catch: Exception -> L7
    L7:
        return "";
    }
}
