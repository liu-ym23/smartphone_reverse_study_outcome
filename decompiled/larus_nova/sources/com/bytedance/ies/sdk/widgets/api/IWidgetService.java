package com.bytedance.ies.sdk.widgets.api;

import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface IWidgetService {
    void aLogI(String r100, String r101);

    boolean enableFrameLoad();

    float getFrameRatio();

    Map<String, String> getLogCommonParams(Map<String, WidgetCostModule> r100);

    String getRoomScene(Widget r100);

    String getRoomScene(Map<String, Object> r100);

    String getUserType(boolean r100);

    boolean isNewPriority();

    void sendLog(String r100, Map<String, String> r101, Object... r102);
}
