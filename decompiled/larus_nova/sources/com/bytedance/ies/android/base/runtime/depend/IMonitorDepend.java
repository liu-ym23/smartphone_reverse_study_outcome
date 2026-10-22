package com.bytedance.ies.android.base.runtime.depend;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.monitor.IAdHostMonitorDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J,\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IMonitorDepend;", "", "ensureNotReachHere", "", "e", "", "message", "", "data", "", "monitorCommonLog", "logType", "logExtra", "Lorg/json/JSONObject;", "monitorStatusAndDuration", "serviceName", "status", "", "duration", "monitorStatusRate", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IMonitorDepend {
    void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);

    void monitorCommonLog(String r100, JSONObject r101);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);
}
