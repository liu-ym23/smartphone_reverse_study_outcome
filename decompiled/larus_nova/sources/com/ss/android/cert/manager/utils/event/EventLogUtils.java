package com.ss.android.cert.manager.utils.event;

import android.text.TextUtils;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertMonitorConfig;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IExceptionCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class EventLogUtils {
    public static String lastModule = "";
    public static String module = "";

    public EventLogUtils() {
    }

    public static void eventSdkSessionLaunch() {
        JSONObject r100 = new JSONObject();
        r100.put(EventConstants.ExtraJson.KEY_SDK_AID, 7374);     // Catch: Exception -> L5
        r100.put("sdk_version", "4.7.7-rc.13");     // Catch: Exception -> L5
    L7:
        onEvent(EventConstants.Label.SDK_SESSION_LAUNCH, r100);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void onEvent(String r100) {
        onEvent(r100, null);
    }

    private static void removeSensitiveKey(JSONObject r100) {
        Iterator<String> r101 = r100.keys();
    L4:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        String[] r103 = BytedCertConstant.SENSITIVE_KEY_SETS;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L4;
        if (r103[r105].equalsIgnoreCase(r102) == false) goto L10;
        r101.remove();
    L10:
        r105 = r105 + 1;
        goto L6
    }

    private static JSONObject appendParams(String r100, JSONObject r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        Collection<IEventParamsInterceptor> r102 = CertManager.getInstance().getEventParamsInterceptors();
        if (r102 != null) goto L8;
    L15:
        return r101;
    L8:
        if (r102.size() <= 0) goto L15;
        Iterator<IEventParamsInterceptor> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        IEventParamsInterceptor r104 = r103.next();
        if (r104 == null) goto L11;
        r101 = r104.intercept(r100, r101);
        goto L11
    }

    public static void onEvent(String r100, JSONObject r101) {
        if (r101 != null) goto L13;
        r101 = new JSONObject();
    L13:
        removeSensitiveKey(r101);     // Catch: Exception -> L10
        r101.put("params_for_special", "uc_login");     // Catch: Exception -> L10
        r101.put(EventConstant.Key.UC_VERIFY_ACTION_TIME, System.currentTimeMillis());     // Catch: Exception -> L10
        r101.put("sdk_version", "4.7.7-rc.13");     // Catch: Exception -> L10
        ICertMonitorConfig r102 = CertManager.getInstance().getMonitor();     // Catch: Exception -> L10
        if (r102 == null) goto L9;
        r101.put("app_id", r102.getAppId() + "");     // Catch: Exception -> L10
        r101.put(EventConstant.Key.LAST_MODULE, lastModule);     // Catch: Exception -> L10
        r101.put(EventConstant.Key.MODULE, module);     // Catch: Exception -> L10
        JSONObject r103 = appendParams(r100, r101);     // Catch: Exception -> L10
        r102.onEvent(r100, r103);     // Catch: Exception -> L10
        CertLog.w("bytecert", "event = " + r100 + " obj = " + r103);     // Catch: Exception -> L10
        return;
    L9:
        throw new NullPointerException("cert monitor is null");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public static void onExceptionEvent(Throwable r100, int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        if (r100 == null) goto L5;
        r102.put(EventConstant.Key.EXCEPTION_STACK_TRACE, CertLog.getStackTraceString(r100));     // Catch: Exception -> L9
        r102.put("exception_msg", r100.getMessage());     // Catch: Exception -> L9
    L5:
        r102.put("error_code", r101);     // Catch: Exception -> L9
        onEvent(EventConstant.Event.SDK_EXCEPTION, r102);     // Catch: Exception -> L9
        IExceptionCallback r103 = CertManager.getInstance().getExceptionCallback();     // Catch: Exception -> L9
        if (r103 == null) goto L14;
        r103.onException(r100, r101);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void onEvent(String r100, Map<String, String> r101) {
        JSONObject r102 = new JSONObject();
        if (r101 != null) goto L16;
    L13:
        onEvent(r100, r102);
        return;
    L16:
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();     // Catch: Exception -> L15
    L6:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L6;
        if (TextUtils.isEmpty(r104.getValue()) == true) goto L6;
        r102.put(r104.getKey(), r104.getValue());     // Catch: Exception -> L15
        goto L6
    }

    public static void onEvent(String r100, String r101) {
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L4
    L5:
        onEvent(r100, r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static void performanceEvent(String r100, CertResponse r101, Integer r102, JSONObject r103, String r104) {
        if (r103 != null) goto L4;
        r103 = new JSONObject();
    L4:
        if (r101 != null) goto L31;
    L25:
        if (r102 == null) goto L29;
        r103.put("duration", r102);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L29:
        onEvent(r100, r103);
        return;
    L31:
        if (r101.success == false) goto L8;
        String r105 = "1";
    L9:
        r103.put("result", r105);     // Catch: Exception -> L23
        r103.put("error_code", String.valueOf(r101.errorCode));     // Catch: Exception -> L23
        String r106 = "";
        if (TextUtils.isEmpty(r101.errorMsg) == false) goto L13;
        String r107 = "";
    L14:
        r103.put("fail_reason", r107);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r103.put("error_stack", r104);     // Catch: Exception -> L23
        goto L25
    L18:
        if (TextUtils.isEmpty(r101.detailErrorMsg) == true) goto L21;
        r106 = r101.detailErrorMsg;     // Catch: Exception -> L23
    L21:
        r103.put("error_stack", r106);     // Catch: Exception -> L23
        goto L25
    L13:
        r107 = r101.errorMsg;     // Catch: Exception -> L23
        goto L14
    L8:
        r105 = "0";
        goto L9
    }
}
