package com.ss.android.ugc.effectmanager.common.listener;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface IMonitorService {
    void monitorCommonLog(String r100, String r101, JSONObject r102);

    void monitorCommonLog(String r100, JSONObject r101);

    void monitorDirectOnTimer(String r100, String r101, float r102);

    void monitorOnTimer(String r100, String r101, float r102);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);
}
