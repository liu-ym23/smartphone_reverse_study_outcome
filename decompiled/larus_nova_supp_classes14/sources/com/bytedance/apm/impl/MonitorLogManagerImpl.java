package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.IMonitorLogManager;
import ff7.f;
import java.util.List;
import ks3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    public MonitorLogManagerImpl() {
    }

    public void deleteLegacyLogByIds(String r1, String r2) {
    }

    public void getLegacyLog(long r1, long r3, String r5, f r6) {
    }

    public List<JSONObject> getRecentUiActionRecords() {
        return a.a().a.a;
    }
}
