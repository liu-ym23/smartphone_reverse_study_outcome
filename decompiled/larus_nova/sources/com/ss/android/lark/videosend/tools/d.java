package com.ss.android.lark.videosend.tools;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.vesdk.VEListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements VEListener.VEMonitorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f445005a = null;

    static {
        f445005a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.vesdk.VEListener.VEMonitorListener
    public final void monitorLog(String r100, JSONObject r101) {
        Log.d("VeSDKTools", "monitorLog, logType:" + r100 + ", logExtra:" + r101);     // Catch: Exception -> L5
        MonitorUtils.monitorEvent(r100, r101, null, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("VeSDKTools", e);
    }
}
