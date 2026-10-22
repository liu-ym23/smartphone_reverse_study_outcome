package com.bytedance.mira.log;

import com.bytedance.apm.ApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.PrintWriter;
import java.io.StringWriter;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MiraMonitor implements Runnable {
    public static final String ERROR = "4_error";
    public static final String FAIL = "3_fail";
    public static final String FAIL_1 = "3_fail_1";
    public static final String FAIL_2 = "3_fail_2";
    public static final String FAIL_3 = "3_fail_3";
    public static final String KEY_AUTO_ERROR = "autoError";
    public static final String KEY_DEFAULT_ABI = "defaultABI";
    public static final String KEY_DEFAULT_ABI0 = "defaultABI0";
    public static final String KEY_MANUAL_ERROR = "manualError";
    public static final String KEY_MATCH_CPU_ABI = "matchCpuAbi";
    public static final String KEY_PRIMARY_CPU_ABI = "primaryCpuAbi";
    public static final String KEY_PROCESS_MODE = "processMode";
    public static final String KEY_SUPPORTED_ABI0 = "supportedABI0";
    public static final String LOAD_FIRST_KEY = "loadFirst";
    public static final String LOAD_FIRST_VALUE_ERROR = "error";
    public static final String LOAD_FIRST_VALUE_FAIL = "fail";
    public static final String LOAD_FIRST_VALUE_SUCCESS = "success";
    public static final String LOAD_SECOND_KEY = "loadSecond";
    public static final String LOAD_SECOND_VALUE_ERROR = "error";
    public static final String LOAD_SECOND_VALUE_SUCCESS = "success";
    public static final String SCHEMA_V1 = "schema_v1";
    public static final String SCHEMA_V1_FAIL_1 = "schema_v1_fail_1";
    public static final String SCHEMA_V1_FAIL_2 = "schema_v1_fail_2";
    public static final String SCHEMA_V1_FAIL_3 = "schema_v1_fail_3";
    public static final String SCHEMA_V1_FAIL_4 = "schema_v1_fail_4";
    public static final String SCHEMA_V1_FAIL_5 = "schema_v1_fail_5";
    public static final String SCHEMA_V1_FAIL_6 = "schema_v1_fail_6";
    public static final String SCHEMA_V2 = "schema_v2";
    public static final String SCHEMA_V2_ERROR = "schema_v2_error";
    public static final String SCHEMA_V2_NOT_FOUND = "schema_v2_not_found";
    public static final String SCHEMA_V3 = "schema_v3";
    public static final String SCHEMA_V3_ERROR = "schema_v3_error";
    public static final String SCHEMA_V3_NOT_FOUND = "schema_v3_not_found";
    public static final String SUCCESS = "2_success";
    private static final String TAG_INFER_HOST_ABI = "mira_infer_host_abi_tt786";
    private static final String TAG_INIT = "mira_init";
    private static final String TAG_SAFE_LOAD_LIB = "mira_safe_load_lib";
    private static final String TAG_SIGN_ANALYZE = "mira_sign_analyze";
    public static final String TOTAL = "1_total";
    public static final String UNPACK_LIBRARY_KEY = "unpackLibrary";
    public static final String UNPACK_LIBRARY_VALUE_ERROR = "error";
    public static final String UNPACK_LIBRARY_VALUE_FAIL = "fail";
    public static final String UNPACK_LIBRARY_VALUE_SUCCESS = "success";
    public static final String VALUE_DEFAULT = "0";
    public static long sTimeInit;
    public static long sTimeLoadPlugins;
    public static long sTimeStart;

    public MiraMonitor() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_mira_log_MiraMonitor_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public static JSONObject createAbiCategory() {
        JSONObject r100 = new JSONObject();
        r100.put(KEY_PRIMARY_CPU_ABI, "0");     // Catch: JSONException -> L5
        r100.put(KEY_PROCESS_MODE, "0");     // Catch: JSONException -> L5
        r100.put(KEY_SUPPORTED_ABI0, "0");     // Catch: JSONException -> L5
        r100.put(KEY_MATCH_CPU_ABI, "0");     // Catch: JSONException -> L5
        r100.put(KEY_DEFAULT_ABI0, "0");     // Catch: JSONException -> L5
        r100.put(KEY_DEFAULT_ABI, "0");     // Catch: JSONException -> L5
        r100.put(KEY_AUTO_ERROR, "0");     // Catch: JSONException -> L5
        r100.put(KEY_MANUAL_ERROR, "0");     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static JSONObject createSafeLoadLibCategory() {
        JSONObject r100 = new JSONObject();
        r100.put(LOAD_FIRST_KEY, "0");     // Catch: JSONException -> L5
        r100.put(LOAD_SECOND_KEY, "0");     // Catch: JSONException -> L5
        r100.put(UNPACK_LIBRARY_KEY, "0");     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void reportInitTime() {
        JSONObject r100 = new JSONObject();
        r100.put("init", sTimeInit);     // Catch: JSONException -> L5
        r100.put("loadPlugins", sTimeLoadPlugins);     // Catch: JSONException -> L5
        r100.put("start", sTimeStart);     // Catch: JSONException -> L5
    L12:
        ApmAgent.monitorEvent(TAG_INIT, null, r100, null);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public void com_bytedance_mira_log_MiraMonitor__run$___twin___() {
        reportInitTime();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_mira_log_MiraMonitor_com_larus_apm_impl_protector_RunnableLancet_run(MiraMonitor r100) {
        r100.com_bytedance_mira_log_MiraMonitor__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void reportHostAbi(JSONObject r100) {
        ApmAgent.monitorEvent(TAG_INFER_HOST_ABI, r100, null, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static void reportSafeLoadLib(JSONObject r100) {
        ApmAgent.monitorEvent(TAG_SAFE_LOAD_LIB, r100, null, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static void reportSignEvent(String r100) {
        ApmAgent.monitorEvent(TAG_SIGN_ANALYZE, createCategory(r100, "0"), null, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private static JSONObject createCategory(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(r100, r101);     // Catch: JSONException -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void addCategory(JSONObject r100, String r101, String r102) {
        if (r100 == null) goto L10;
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void reportSafeLoadLib(JSONObject r100, String r101, String r102) {
        addCategory(r100, r101, r102);
        ApmAgent.monitorEvent(TAG_SAFE_LOAD_LIB, r100, null, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void reportSignEvent(String r100, Exception r101, String r102) {
        if (r101 != null) goto L7;
        if (r102 != null) goto L7;
        JSONObject r103 = null;
    L26:
        ApmAgent.monitorEvent(TAG_SIGN_ANALYZE, createCategory(r100, "0"), null, r103);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        r103 = new JSONObject();
        if (r101 == null) goto L14;
        StringWriter r104 = new StringWriter();
        r101.printStackTrace(new PrintWriter(r104));
        r103.put("ext_exception", r104.toString());     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (r102 == null) goto L26;
        r103.put("ext_info", r102);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }
}
