package com.ss.android.lark.utils.statistics;

import android.os.Trace;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.log.Log;
import java.util.UUID;

/* JADX INFO: loaded from: classes38.dex */
public class PerfLog {
    public static final String EVENT_PRE = "android_";
    public static final String PARAM_KEY_CONTEXT_ID = "context";
    public static final String TAG = "PerfLog";
    public static final String TAG_END = "end";
    public static final String TAG_PERF = "perf";
    public static final String TAG_START = "start";

    public PerfLog() {
    }

    public static String getContextId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    public static void end(String r100, String r101) {
        log(r100, "end", r101);
        Trace.endSection();
    }

    public static String generateMsg(String r100, String r101) {
        return r100 + ContainerUtils.KEY_VALUE_DELIMITER + r101 + ",";
    }

    public static void start(String r100, String r101) {
        log(r100, "start", r101);
        Trace.beginSection(r100);
    }

    public static void end(String r100, String r101, String r102) {
        end(r100, generateMsg(PARAM_KEY_CONTEXT_ID, r101) + r102);
    }

    public static void log(String r100, String r101, String r102) {
        Log.i(TAG, "[perf][android_" + r100 + "][" + r101 + "]" + r102);
    }

    public static void start(String r100, String r101, String r102) {
        start(r100, generateMsg(PARAM_KEY_CONTEXT_ID, r101) + r102);
    }

    public static void log(String r100, String r101, String r102, String r103) {
        log(r100, r101, generateMsg(PARAM_KEY_CONTEXT_ID, r102) + r103);
    }
}
