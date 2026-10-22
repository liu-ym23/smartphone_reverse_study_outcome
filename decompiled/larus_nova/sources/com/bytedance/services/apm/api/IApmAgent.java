package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import ff7.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r100, JSONObject r101);

    void monitorDuration(String r100, JSONObject r101, JSONObject r102);

    void monitorEvent(a r100);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorExceptionLog(String r100, JSONObject r101);

    void monitorLog(String r100, JSONObject r101);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);

    void reportLegacyMonitorLog(Context r100, long r101, long r102, boolean r103);
}
