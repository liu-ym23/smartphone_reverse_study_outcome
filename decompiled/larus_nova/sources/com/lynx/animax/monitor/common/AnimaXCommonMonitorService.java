package com.lynx.animax.monitor.common;

import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.service.IAutoRegisterAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import v4a.a;
import v4a.c;
import w4a.e;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXCommonMonitorService implements IAnimaXMonitorService, IAutoRegisterAnimaXService {
    private static final String INTEGRATION_TYPE_DEFAULT = "default";
    private static final String TAG = "AnimaXCommonMonitorService";
    private String mCurrentUrl;

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public final /* synthetic */ e getAutoRegisterServiceScope() {
        return IAutoRegisterAnimaXService.CC.$default$getAutoRegisterServiceScope(this);
    }

    public AnimaXCommonMonitorService() {
        this.mCurrentUrl = "unknown";
    }

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public Class<? extends IAnimaXMonitorService> getServiceClass() {
        return IAnimaXMonitorService.class;
    }

    private void appendNativeCommonParams(Map<String, Object> r100) {
        r100.put("src_url", a.a(this.mCurrentUrl));
        r100.put("integration_type", "default");
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportError(t4a.a r100) {
        if (r100 != null) goto L6;
        AnimaXLog.a(TAG, "report failed, errorInfo is null.");
        return;
    L6:
        HashMap r101 = new HashMap();
        Map<String, Object> r102 = r100.f544609a;
        if (r102 == null) goto L9;
        r101.putAll(r102);
    L9:
        appendNativeCommonParams(r101);
        JSONObject r103 = a.b(r101);
        AnimaXLog.b(TAG, "reportError: " + r103);
        AppLogNewUtils.onEventV3("animax_error", r103);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportPerformanceMetrics(c r100) {
        if (r100 != null) goto L7;
        AnimaXLog.a(TAG, "report failed, metrics is null.");
        return;
    L7:
        if ((!"unknown".equals(this.mCurrentUrl)) == true) goto L9;
        return;
    L9:
        HashMap r101 = new HashMap();
        r101.putAll(new HashMap(r100.f553153b.asHashMap()));
        r101.putAll(new HashMap(r100.f553152a.asHashMap()));
        appendNativeCommonParams(r101);
        JSONObject r102 = a.b(r101);
        AnimaXLog.b(TAG, "reportPerformance: " + r102);
        AppLogNewUtils.onEventV3("animax_performance", r102);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void setCurrentUrl(String r100) {
        this.mCurrentUrl = r100;
    }
}
