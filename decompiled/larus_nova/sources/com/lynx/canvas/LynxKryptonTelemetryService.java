package com.lynx.canvas;

import com.lynx.canvas.telemetry.KryptonTelemetryService;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonTelemetryService extends KryptonTelemetryService {
    private static final String TAG = "LynxKryptonTelemetryService";
    private final int mInstanceId;

    public LynxKryptonTelemetryService(WeakReference<LynxContext> r100) {
        LynxContext r101 = r100.get();
        if (r101 == null) goto L5;
        this.mInstanceId = r101.getInstanceId();
        return;
    L5:
        this.mInstanceId = -1;
        LLog.e(TAG, "LynxKryptonTelemetryService created with invalid context");
    }

    @Override // com.lynx.canvas.telemetry.KryptonTelemetryService
    public void reportEvent(String r100, Map<String, String> r101) {
        if (this.mInstanceId <= (-1)) goto L6;
        LLog.e(TAG, "report " + r100 + " " + r101);
        StringBuilder r102 = new StringBuilder("lynxsdk_krypton_");
        r102.append(r100);
        LynxEventReporter.onEvent(r102.toString(), new HashMap(r101), this.mInstanceId);
        return;
    }
}
