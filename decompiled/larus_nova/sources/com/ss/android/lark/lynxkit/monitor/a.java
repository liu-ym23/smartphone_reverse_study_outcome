package com.ss.android.lark.lynxkit.monitor;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ILynxKitMonitorReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f431518a = null;

    static {
        f431518a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.lynxkit.monitor.ILynxKitMonitorReporter
    public final void report(String r100, int r101, JSONObject r102, JSONObject r103) {
        if (r100 != null) goto L4;
    L7:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L17;
        Log.w("LynxKitMonitorReporter", "report skipped because serviceName is empty");
        return;
    L17:
        MonitorUtils.monitorStatusAndDuration(r100, r101, r102, r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.e("LynxKitMonitorReporter", "report failed", th);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r104 = false;
        goto L9
    }
}
