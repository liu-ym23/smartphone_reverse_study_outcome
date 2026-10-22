package com.bytedance.mira;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MiraPluginReporter {
    public static final String ACTION_REPORTER = "com.bytedance.frameworks.plugin.ACTION_REPORTER";
    public static final String INSTALL_DURATION_KEY = "INSTALL_DURATION";
    public static final String LOAD_DURATION_KEY = "LOAD_DURATION";
    public static final String RESOLVE_DURATION_KEY = "RESOLVE_DURATION";
    public static final String WAIT_INSTALL_DURATION_KEY = "WAIT_INSTALL_DURATION";
    private static BroadcastSender sBroadcastSender;

    public interface BroadcastSender {
        void sendBroadcast(Intent r100);
    }

    public static final class InstallStatusCode {
        public static final int INSTALL_COPY_APK_FAILED = 12003;
        public static final int INSTALL_COPY_SO_FAILED = 12004;
        public static final int INSTALL_DEX_OPT_FAILED = 12006;
        public static final int INSTALL_MULTIDEX_FAILED = 12005;
        public static final int INSTALL_PERMISSION_NOT_MATCH = 12002;
        public static final int INSTALL_SIGNATURES_NOT_MATCH = 12001;
        public static final int INSTALL_START = 10000;
        public static final int INSTALL_SUCCESS = 11000;
        public static final int INSTALL_UNKNOWN_ERROR = 12000;

        public InstallStatusCode() {
        }
    }

    public static final class LoadStatusCode {
        public static final int LOAD_ACTIVITY_THREAD_NULL = 32002;
        public static final int LOAD_ALREADY_CONTAINS_PACKAGE = 32004;
        public static final int LOAD_APPLICATION_NULL = 32001;
        public static final int LOAD_CALL_APPLICATION_ON_CREATE_FAIL = 32008;
        public static final int LOAD_INSTALL_CONTENT_PROVIDER_FAIL = 32007;
        public static final int LOAD_LOADEDAPK_APPLICATION_NOT_NULL = 32006;
        public static final int LOAD_LOADEDAPK_NULL = 32005;
        public static final int LOAD_PACKAGES_NULL = 32003;
        public static final int LOAD_SOURCE_DIR_NULL = 32009;
        public static final int LOAD_START = 30000;
        public static final int LOAD_SUCCESS = 31000;
        public static final int LOAD_UNKNOWN_ERROR = 32000;

        public LoadStatusCode() {
        }
    }

    public static final class ResolveStatusCode {
        public static final int RESOLVE_START = 20000;
        public static final int RESOLVE_SUCCESS = 21000;
        public static final int RESOLVE_UNKNOWN_ERROR = 22000;

        public ResolveStatusCode() {
        }
    }

    public MiraPluginReporter() {
    }

    public static void setBroadcastSender(BroadcastSender r100) {
        sBroadcastSender = r100;
    }

    public static void report(String r100, int r101, int r102) {
        report(r100, r101, r102, null, null);
    }

    public static void report(String r100, int r101, int r102, Map<String, Long> r103) {
        report(r100, r101, r102, r103, null);
    }

    public static void report(String r100, int r101, int r102, Map<String, Long> r103, String r104) {
        Intent r105 = new Intent();
        r105.setAction(ACTION_REPORTER);
        Bundle r106 = new Bundle();
        r106.putInt("status", r102);
        r106.putString("packageName", r100);
        r106.putInt(RuleConditionBean.VERSION_CODE_KEY, r101);
        r106.putString("message", r104);
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L11
        if (r103 == null) goto L9;
        Iterator<String> r108 = r103.keySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r108.hasNext() == false) goto L9;
        String r109 = r108.next();     // Catch: Exception -> L11
        r107.put(r109, r103.get(r109));     // Catch: Exception -> L11
    L9:
        r106.putString("duration", r107.toString());     // Catch: Exception -> L11
    L13:
        r105.putExtras(r106);
        r105.setPackage(Mira.getAppContext().getPackageName());
        BroadcastSender r110 = sBroadcastSender;
        if (r110 == null) goto L16;
        r110.sendBroadcast(r105);
        return;
    L16:
        Mira.getAppContext().sendBroadcast(r105);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
