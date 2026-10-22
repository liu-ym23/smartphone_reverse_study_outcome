package com.ss.bduploader.smartserver;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class SmartRouting extends SmartAbstract {
    private static final String ENGINE_TYPE = "mlsdk";
    private static final String OUTPUT_TYPE = "regression";
    private static final String SERVER_NAME = "smart_upload_tcp_quic";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;

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

    public SmartRouting() {
        this.mIntelligentURL = "";
    }

    public Map getIntelligentInput(JSONObject r110) {
        Objects.toString(r110);
        HashMap r100 = new HashMap();
        if (JSONObjectProtectorUtils.getInt(r110, "est_file_size") <= 0) goto L12;
        if (JSONObjectProtectorUtils.getJSONObject(r110, "optimized_info") == null) goto L12;
        if (JSONObjectProtectorUtils.getInt(r110, "origin_speed_test") <= 0) goto L12;
        r100.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r110, "origin_speed_test", 0)));
        r100.put("speed_test_protocol", Float.valueOf(parseIntelligentInputFloat(r110, "speed_test_protocol", 0)));
        r100.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r110, "init_rtt", 1)) / 1000.0d));
        r100.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r110, "close_rtt", 1)) / 1000.0d));
        r100.put("mss", Float.valueOf(parseIntelligentInputFloat(r110, "mss", 1)));
        r100.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r110, RNParamRegisterEventHandler.SRC_INNER, 1)) / 1000.0d));
        r100.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r110, PlayerResolution.SDKKEY.ORIGIN, 1)) / 1000.0d));
        r100.put("est_file_size", Float.valueOf(parseIntelligentInputFloat(r110, "est_file_size", 0)));
        return r100;
    L12:
        return null;
    }

    public Map getIntelligentInputTTNet(JSONObject r110) {
        Objects.toString(r110);
        HashMap r100 = new HashMap();
    L38:
        e = move-exception;
        String.valueOf(e);
        return null;
    L4:
        if (JSONObjectProtectorUtils.getInt(r110, "est_file_size") > 0) goto L6;
        return null;
    L6:
        if (JSONObjectProtectorUtils.getJSONObject(r110, "tcp_domain") != null) goto L8;
        return null;
    L8:
        if (JSONObjectProtectorUtils.getJSONObject(r110, "quic_domain") == null) goto L48;
        List r101 = Arrays.asList(new String[]{"tcp", "quic"});     // Catch: Exception -> L38
        List r102 = Arrays.asList(new String[]{"SeverSpeed", "speed", "duration", "routing_request_log.timing.detailed_duration.inner", "routing_request_log.timing.detailed_duration.send", "routing_request_log.timing.detailed_duration.ttfb", "routing_request_log.timing.request.duration"});     // Catch: Exception -> L38
        List r103 = Arrays.asList(new String[]{"routing_request_log.nqe.http_rtt", "routing_request_log.nqe.tcp_rtt", "routing_request_log.nqe.downlink_throughput", "routing_request_log.nqe.real_net_type", "routing_request_log.nqe.effective_net_type"});     // Catch: Exception -> L38
        int r111 = 0;
    L13:
        if (r111 >= r101.size()) goto L26;
        String r112 = (String) ListProtector.get(r101, r111);     // Catch: Exception -> L38
        JSONObject r113 = JSONObjectProtectorUtils.getJSONObject(r110, r112 + "_domain");     // Catch: Exception -> L38
        Iterator r114 = r102.iterator();     // Catch: Exception -> L38
    L16:
        if (r114.hasNext() == false) goto L25;
        String r115 = (String) r114.next();     // Catch: Exception -> L38
        String[] r104 = r115.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L38
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L38
        r105.append(r112);     // Catch: Exception -> L38
        List r116 = r101;
        r105.append("_");     // Catch: Exception -> L38
        r105.append(r104[r104.length - 1].toLowerCase(Locale.US));     // Catch: Exception -> L38
        String r106 = r105.toString();     // Catch: Exception -> L38
        if (r115.equals("duration") == false) goto L20;
        r106 = r106 + "_bd";     // Catch: Exception -> L38
    L20:
        float r107 = getValueForKey(r113, r115);     // Catch: Exception -> L38
        if (r107 == (-1.0f)) goto L22;
        r100.put(r106, Float.valueOf(r107));     // Catch: Exception -> L38
        r101 = r116;
        goto L16
    L22:
        return null;
    L25:
        r111 = r111 + 1;     // Catch: Exception -> L38
        goto L13
    L26:
        Iterator r108 = r103.iterator();     // Catch: Exception -> L38
    L28:
        if (r108.hasNext() == false) goto L30;
        String r109 = (String) r108.next();     // Catch: Exception -> L38
        String[] r117 = r109.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L38
        r100.put(r117[r117.length - 1].toLowerCase(Locale.US), Float.valueOf(getValueForKey(JSONObjectProtectorUtils.getJSONObject(r110, "tcp_domain"), r109)));     // Catch: Exception -> L38
        goto L28
    L30:
        float r118 = parseIntelligentInputFloat(r110, "est_file_size", 0);     // Catch: Exception -> L38
        if (r118 > 0.0f) goto L34;
        return null;
    L34:
        r100.put("est_file_size", Float.valueOf(r118));     // Catch: Exception -> L38
        return r100;
    L48:
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
        if (this.mIntelligentService.serviceEnabled() == false) goto L17;
        Map r101 = new HashMap();
        if (JSONObjectProtectorUtils.getInt(r100, "routing_using_vcn") != 1) goto L9;
        r101 = getIntelligentInput(r100);     // Catch: Exception -> L15
    L11:
        if (r101 != null) goto L14;
        return -1.0f;
    L14:
        return this.mIntelligentService.runSync(r101);
    L9:
        if (JSONObjectProtectorUtils.getInt(r100, "routing_using_vcn") != 0) goto L11;
        r101 = getIntelligentInputTTNet(r100);     // Catch: Exception -> L15
        goto L11
    L18:
        return -1.0f;
    L17:
        return -1.0f;
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
}
