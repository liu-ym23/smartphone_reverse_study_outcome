package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import g66.c;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J8\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostFrameworkDepend;", "", "Lg66/c;", "contextProviderFactory", "", "getContainerID", ReportConstant.COMMON_ACTION_TYPE, "", "eventName", "Lorg/json/JSONObject;", "params", "", "addObserverEvent", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostFrameworkDepend {
    void addObserverEvent(c r100, String r101, List<String> r102, List<? extends JSONObject> r103);

    String getContainerID(c r100);
}
