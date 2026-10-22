package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import ff7.f;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String r100, String r101);

    void getLegacyLog(long r100, long r101, String r102, f r103);

    List<JSONObject> getRecentUiActionRecords();
}
