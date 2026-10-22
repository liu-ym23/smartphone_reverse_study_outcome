package com.bytedance.awemeopen.infra.base.event;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class AoEventReportRules {
    private static final String ACTIONS = "actions";
    private static final double DEFAULT_RATE = 1.0d;
    private static final String EVENT_NAME_PATTERN = "event_name_pattern";
    private static final String EVENT_PARAMS_PATTERN = "event_params_pattern";
    private static final String ONLY_PARAMS = "only_params";
    private static final String REMOVE_PARAMS = "remove_params";
    private static final String RULES = "rules";
    private static final String SAMPLE_RATE = "sample_rate";
    public static String TAG = "BdpAppEventReportRules";
    private static JSONObject sEventLogReportConfig;

    public AoEventReportRules() {
    }

    private static boolean isNeedReportAfterSample(JSONObject r100) {
        if (r100 == null) goto L11;
        double r101 = r100.optDouble("sample_rate", 1.0d);
        if (AudioStats.AUDIO_AMPLITUDE_NONE < r101) goto L7;
    L9:
        return false;
    L7:
        if (Math.random() >= r101) goto L9;
        return true;
    L11:
        return true;
    }

    public static void setEventLogReportConfig(JSONObject r100) {
        sEventLogReportConfig = r100;
        AoLogger.g(TAG, new Object[]{"setEventLogReportConfig", r100});
    }

    public static boolean check(String r100, JSONObject r101) {
        JSONObject r102 = sEventLogReportConfig;
        if (r102 != null) goto L5;
    L27:
        return true;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        if (r101 == null) goto L27;
        JSONArray r103 = r102.optJSONArray(RULES);
        if (r103 == null) goto L27;
        int r104 = 0;
    L11:
        if (r104 >= r103.length()) goto L27;
        JSONObject r105 = r103.optJSONObject(r104);
        if (r105 == null) goto L26;
        if (ruleMatch(r105, r100, r101) == false) goto L26;
        JSONObject r106 = r105.optJSONObject("actions");
        if (r106 == null) goto L26;
        if (isNeedReportAfterSample(r106) == false) goto L34;
        String r107 = r106.optString(REMOVE_PARAMS);
        String r108 = r106.optString(ONLY_PARAMS);
        if (TextUtils.isEmpty(r107) == true) goto L24;
        processRemoveParams(r101, r107);
        goto L27
    L24:
        if (TextUtils.isEmpty(r108) == true) goto L27;
        processOnlyParams(r101, r108);
        goto L27
    L34:
        return false;
    L26:
        r104 = r104 + 1;
        goto L11
    }

    private static boolean patternMatches(String r100, CharSequence r101) {
        return Pattern.matches(r100, r101);
    L4:
        return false;
    }

    private static void processOnlyParams(JSONObject r100, String r101) {
        JSONArray r102 = r100.names();
        int r103 = 0;
    L4:
        if (r103 >= r102.length()) goto L9;
        String r104 = r102.optString(r103);
        if (patternMatches(r101, r104) == true) goto L8;
        r100.remove(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    }

    private static void processRemoveParams(JSONObject r100, String r101) {
        JSONArray r102 = r100.names();
        int r103 = 0;
    L4:
        if (r103 >= r102.length()) goto L9;
        String r104 = r102.optString(r103);
        if (patternMatches(r101, r104) == false) goto L8;
        r100.remove(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    }

    private static boolean ruleMatch(JSONObject r100, String r101, JSONObject r102) {
        String r103 = r100.optString(EVENT_NAME_PATTERN);
        if (TextUtils.isEmpty(r103) == true) goto L26;
        boolean r104 = patternMatches(r103, r101);
        if (r104 == false) goto L18;
        JSONObject r105 = r100.optJSONObject(EVENT_PARAMS_PATTERN);
        if (r105 == null) goto L18;
        Iterator<String> r106 = r105.keys();
    L10:
        if (r106.hasNext() == false) goto L18;
        String r107 = r106.next();
        String r108 = r105.optString(r107);
        if (TextUtils.isEmpty(r108) == true) goto L10;
        String r109 = r102.optString(r107);
        if (TextUtils.isEmpty(r109) == true) goto L27;
        r104 = patternMatches(r108, r109);
        if (r104 == true) goto L10;
    L27:
        return false;
    L18:
        return r104;
    L26:
        return false;
    }
}
