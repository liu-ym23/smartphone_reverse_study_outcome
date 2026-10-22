package com.bytedance.services.apm.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import ff7.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IApmAgent extends IService {
    void monitorCommonLog(String r1, JSONObject r2);

    void monitorDuration(String r1, JSONObject r2, JSONObject r3);

    void monitorEvent(a r1);

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    void monitorExceptionLog(String r1, JSONObject r2);

    void monitorLog(String r1, JSONObject r2);

    void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4);

    void monitorStatusRate(String r1, int r2, JSONObject r3);

    void reportLegacyMonitorLog(Context r1, long r2, long r4, boolean r6);
}
