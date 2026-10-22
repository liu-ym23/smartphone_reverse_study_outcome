package com.bytedance.framwork.core.monitor;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.d;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;
import xu3.a;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorUtils {
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    public static final String TAG_DEPRECATED = "Deprecated";

    public MonitorUtils() {
    }

    public static void monitorDebugReal(String r100) {
    }

    public static void monitorDebugReal(String r100, String r101) {
    }

    public static void monitorDirectOnCount(String r100, String r101, float r102) {
    }

    public static void monitorOnCount(String r100, String r101) {
    }

    public static void monitorOnCount(String r100, String r101, float r102) {
    }

    public static void monitorOnStore(String r100, String r101, float r102) {
    }

    public static void monitorOnTimer(String r100, String r101, float r102) {
    }

    public static void setDebugMode() {
        d.f190514b = true;
        a.f565088a = d.j();
    }

    public static void setIsBackGround(boolean r100) {
    }

    public static boolean getLogTypeSwitch(String r100) {
        return ApmDelegate.g.f190592a.b(r100);
    }

    public static boolean getMetricsTypeSwitch(String r100) {
        ApmDelegate r101 = ApmDelegate.g.f190592a;
        if (r101.f190575f == false) goto L8;
        SlardarConfigManagerImpl r102 = r101.f190574e;
        if (r102 == null) goto L8;
        return r102.getMetricTypeSwitch(r100);
    L8:
        return false;
    }

    public static boolean getServiceNameSwitch(String r100) {
        ApmDelegate r101 = ApmDelegate.g.f190592a;
        if (r101.f190575f == false) goto L8;
        SlardarConfigManagerImpl r102 = r101.f190574e;
        if (r102 == null) goto L8;
        return r102.getServiceSwitch(r100);
    L8:
        return false;
    }

    public static void monitorCommonLog(String r100, JSONObject r101) {
        ApmAgent.monitorCommonLog(r100, r101);
    }

    public static void monitorStartTime(String r100, float r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put(r100, r101);     // Catch: Exception -> L4
        monitorPerformance("start", r100, r102, null, null);     // Catch: Exception -> L4
        return;
    }

    public static void monitorCommonLog(String r100, JSONObject r101, boolean r102) {
        ApmAgent.monitorCommonLog(r100, r101, r102);
    }

    public static void monitorDirectOnTimer(String r100, String r101, float r102) {
        ApmAgent.monitorDirectOnTimer(r100, r101, r102);
    }

    public static void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        ApmAgent.monitorDuration(r100, r101, r102);
    }

    public static void monitorStatusRate(String r100, int r101, JSONObject r102) {
        ApmAgent.monitorStatusRate(r100, r101, r102);
    }

    public static void monitorUIAction(String r100, String r101, JSONObject r102) {
        ApmAgent.monitorUIAction(r100, r101, r102);
    }

    public static void monitorDuration(String r100, JSONObject r101, JSONObject r102, long r103) {
        ApmAgent.monitorDuration(r100, r101, r102, r103);
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorEvent(r100, r101, r102, r103);
    }

    public static void monitorPerformance(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorPerformance(r100, r101, r102, r103);
    }

    public static void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorStatusAndDuration(r100, r101, r102, r103);
    }

    public static void monitorPerformance(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        ApmAgent.monitorPerformance(r100, r101, r102, r103, r104);
    }

    public static void monitorApiError(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
        ApmAgent.monitorApiError(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void monitorSLA(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
        ApmAgent.monitorSLA(r100, r101, r102, r103, r104, r105, r106);
    }
}
