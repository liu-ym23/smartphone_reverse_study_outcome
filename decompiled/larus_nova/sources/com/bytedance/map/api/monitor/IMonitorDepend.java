package com.bytedance.map.api.monitor;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface IMonitorDepend {
    String getAppId();

    String getAppVersion();

    String getChannel();

    Map<String, String> getCommonParams();

    List<String> getConfigUrls();

    String getDeviceId();

    String getPackageName();

    List<String> getReportUrls();

    String getSessionId();

    String getUpdateVersion();
}
