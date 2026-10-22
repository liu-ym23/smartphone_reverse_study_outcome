package com.bytedance.ies.android.base.runtime.depend;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.monitor.IAdHostMonitorDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/AbsMonitorDepend;", "Lcom/bytedance/ies/android/base/runtime/depend/IMonitorDepend;", "()V", "monitorEvent", "", "serviceName", "", "metric", "Lorg/json/JSONObject;", "category", "extra", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public abstract class AbsMonitorDepend implements IMonitorDepend {
    public AbsMonitorDepend() {
    }

    public void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }
}
