package com.ss.bduploader.smartserver;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class SmartSpeedTest extends SmartAbstract {
    private static final String ENGINE_TYPE = "mlsdk";
    private static final String OUTPUT_TYPE = "regression";
    private static final String SERVER_NAME = "smart_upload_speed";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;
    private int mSpeedTestUseVCN;

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void configServer() {
        this.mIntelligentService.setStringValue(1000, ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, SERVER_NAME);
        this.mIntelligentService.setStringValue(1002, OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void preloadEnv() {
        SmartServiceInterface r100 = this.mIntelligentService;
        if (r100 == null) goto L6;
        r100.preloadEnv();
        return;
    }

    public SmartSpeedTest() {
        this.mSpeedTestUseVCN = -1;
        this.mIntelligentURL = "";
    }

    public Map getIntelligentInput(JSONObject r110) {
        Objects.toString(r110);
        HashMap r100 = new HashMap();
        if (JSONObjectProtectorUtils.getJSONObject(r110, "optimized_info") == null) goto L24;
        if (JSONObjectProtectorUtils.getInt(r110, "origin_speed_test") <= 0) goto L24;
        r100.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r110, "origin_speed_test", 0)));
        r100.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r110, "init_rtt", 1)) / 1000.0d));
        r100.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r110, "close_rtt", 1)) / 1000.0d));
        r100.put("mss", Float.valueOf(parseIntelligentInputFloat(r110, "mss", 1)));
        r100.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r110, RNParamRegisterEventHandler.SRC_INNER, 1)) / 1000.0d));
        r100.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r110, PlayerResolution.SDKKEY.ORIGIN, 1)) / 1000.0d));
        String r101 = parseIntelligentInputString(r110, "apply_start", 0);
        String r102 = parseIntelligentInputString(r110, "apply_end", 0);
        if (r102.isEmpty() == true) goto L24;
        if (r101.isEmpty() == true) goto L24;
        float r103 = CastLongProtector.valueOf(r102).longValue() - CastLongProtector.valueOf(r101).longValue();
        if (r103 >= 0.0f) goto L16;
        return null;
    L16:
        r100.put("apply_duration", Float.valueOf(r103));
        String r111 = parseIntelligentInputString(r110, "node_type", 0);
        r111.getClass();
        if (r111.equals("Origin") == false) goto L19;
        r100.put("node_type", Float.valueOf(2.0f));
    L23:
        return r100;
    L19:
        if (r111.equals("Edge") == true) goto L21;
        r100.put("node_type", Float.valueOf(0.0f));
        goto L23
    L21:
        r100.put("node_type", Float.valueOf(1.0f));
    L24:
        return null;
    }

    public Map getIntelligentInputTTNet(JSONObject r110) {
        Objects.toString(r110);
        HashMap r100 = new HashMap();
        if (JSONObjectProtectorUtils.getJSONObject(r110, "speedtest_request_log") == null) goto L26;
        if (JSONObjectProtectorUtils.getInt(r110, "origin_speed_test") <= 0) goto L26;
        String r101 = parseIntelligentInputString(r110, "apply_start", 0);     // Catch: Exception -> L27
        String r102 = parseIntelligentInputString(r110, "apply_end", 0);     // Catch: Exception -> L27
        if (r102.isEmpty() == true) goto L26;
        if (r101.isEmpty() == true) goto L26;
        float r103 = CastLongProtector.valueOf(r102).longValue() - CastLongProtector.valueOf(r101).longValue();     // Catch: Exception -> L27
        if (r103 >= 0.0f) goto L16;
        return null;
    L16:
        r100.put("apply_duration", Float.valueOf(r103));     // Catch: Exception -> L27
        Iterator r104 = Arrays.asList(new String[]{"origin_speed_test", "speedtest_request_log.timing.detailed_duration.send", "speedtest_request_log.timing.detailed_duration.inner", "speedtest_request_log.timing.detailed_duration.ttfb", "speedtest_request_log.timing.request.duration", "speedtest_request_log.nqe.http_rtt", "speedtest_request_log.nqe.tcp_rtt", "speedtest_request_log.nqe.downlink_throughput", "speedtest_request_log.nqe.real_net_type", "speedtest_request_log.nqe.effective_net_type"}).iterator();     // Catch: Exception -> L27
    L18:
        if (r104.hasNext() == false) goto L24;
        String r105 = (String) r104.next();     // Catch: Exception -> L27
        String[] r106 = r105.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L27
        String r107 = r106[r106.length - 1].toLowerCase(Locale.US);     // Catch: Exception -> L27
        float r108 = getValueForKey(r110, r105);     // Catch: Exception -> L27
        if (r108 == (-1.0f)) goto L21;
        r100.put(r107, Float.valueOf(r108));     // Catch: Exception -> L27
    L21:
        return null;
    L24:
        r100.toString();
        return r100;
    L26:
        return null;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void parseUrl(String r100) {
        this.mIntelligentURL = JSONObjectProtectorUtils.getString(new JSONObject(r100), "intelligent_model_url");     // Catch: Exception -> L4
        return;
    L4:
        this.mIntelligentURL = "";
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public float predictSpeedSync(JSONObject r100) {
        if (this.mIntelligentService.serviceEnabled() == true) goto L5;
        return -1.0f;
    L5:
        if (this.mSpeedTestUseVCN != 1) goto L7;
        Map r101 = getIntelligentInput(r100);
    L8:
        if (r101 != null) goto L11;
        return -1.0f;
    L11:
        return this.mIntelligentService.runSync(r101);
    L7:
        r101 = getIntelligentInputTTNet(r100);
        goto L8
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setSpeedTestUseVCN(int r100) {
        this.mSpeedTestUseVCN = r100;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setUrl(String r100) {
        this.mIntelligentURL = r100;
    }

    private float getValueForKey(JSONObject r100, String r101) {
        String[] r102 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        int r103 = 0;
    L15:
    L13:
        Objects.toString(r100);
        return -1.0f;
    L5:
        if (r103 >= (r102.length - 1)) goto L7;
        r100 = JSONObjectProtectorUtils.getJSONObject(r100, r102[r103]);     // Catch: Exception -> L13
        r103 = r103 + 1;     // Catch: Exception -> L13
        goto L15
    L7:
        String r104 = r102[r102.length - 1];     // Catch: Exception -> L13
        if (r100.has(r104) == true) goto L10;
        return -1.0f;
    L10:
        return (float) JSONObjectProtectorUtils.getDouble(r100, r104);
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
