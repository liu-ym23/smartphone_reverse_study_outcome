package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonService;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonTelemetryService extends KryptonService {
    public abstract void reportEvent(String r100, Map<String, String> r101);

    public KryptonTelemetryService() {
    }
}
