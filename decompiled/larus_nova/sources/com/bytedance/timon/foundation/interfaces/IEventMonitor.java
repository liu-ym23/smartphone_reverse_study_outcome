package com.bytedance.timon.foundation.interfaces;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J<\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "", "monitorDuration", "", "serviceName", "", "duration", "Lorg/json/JSONObject;", "logExtra", "monitorEvent", "category", "metric", "monitorStatusAndDuration", "status", "", "monitorStatusAndEvent", "monitorStatusRate", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
public interface IEventMonitor {
    void monitorDuration(String r100, JSONObject r101, JSONObject r102);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusAndEvent(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104);

    void monitorStatusRate(String r100, int r101, JSONObject r102);
}
