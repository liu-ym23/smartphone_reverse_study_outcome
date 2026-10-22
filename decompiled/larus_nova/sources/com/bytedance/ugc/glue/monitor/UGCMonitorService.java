package com.bytedance.ugc.glue.monitor;

import ep7.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class UGCMonitorService {
    private static UGCMonitorService instance;

    public void eventImpl(String r100, Object r101) {
    }

    public void metricImpl(String r100, String r101, int r102, Object... r103) {
    }

    public void monitorImpl(String r100, String r101, int r102, Object... r103) {
    }

    public void sendImpl(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    static {
        instance = new UGCMonitorService();
    }

    private static UGCMonitorService getInstance() {
        int r100 = a.f473437a;
        return instance;
    }

    public UGCMonitorService() {
    }

    public final void register() {
        instance = this;
    }

    public static void event(String r100, Object r101) {
        getInstance().eventImpl(r100, r101);
    }

    public static void metric(String r100, String r101, int r102, Object... r103) {
        getInstance().metricImpl(r100, r101, r102, r103);
    }

    public static void monitor(String r100, String r101, int r102, Object... r103) {
        getInstance().monitorImpl(r100, r101, r102, r103);
    }

    public static void send(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        getInstance().sendImpl(r100, r101, r102, r103);
    }
}
