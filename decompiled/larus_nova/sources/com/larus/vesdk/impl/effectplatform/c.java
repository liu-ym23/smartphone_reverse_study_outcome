package com.larus.vesdk.impl.effectplatform;

import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.effectplatform.EffectPlatformMonitor;
import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements IMonitorService {
    public c() {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorCommonLog(String r100, String r101, JSONObject r102) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorCommonLog(String r100, JSONObject r101) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorDirectOnTimer(String r100, String r101, float r102) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorOnTimer(String r100, String r101, float r102) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.ss.android.ugc.effectmanager.common.listener.IMonitorService
    public final void monitorStatusRate(String r100, int r101, JSONObject r102) {
        IApplog.Companion r103 = IApplog.f287053a;
        if (r100 != null) goto L5;
        String r104 = "";
    L6:
        r103.reportEvent(r104, r102);
        FLogger.f375446a.i(EffectPlatformMonitor.TAG, "monitorStatusRate " + r100 + ", " + r102);
        return;
    L5:
        r104 = r100;
        goto L6
    }
}
