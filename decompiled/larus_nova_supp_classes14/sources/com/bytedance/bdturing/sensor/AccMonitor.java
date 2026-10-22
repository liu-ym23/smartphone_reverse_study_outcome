package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AccMonitor extends AbstractSensorMonitor {
    private static final String TAG = "AccMonitor";

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 1;
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent r7) {
        float[] r8 = r7.values;
        float r0 = r8[0];
        float r1 = r8[1];
        float r9 = r8[2];
        JSONObject r2 = new JSONObject();
        r2.put("x", r0);     // Catch: Exception -> L5
        r2.put("y", r1);     // Catch: Exception -> L5
        r2.put("z", r9);     // Catch: Exception -> L5
        r2.put("m", System.currentTimeMillis());     // Catch: Exception -> L5
    L7:
        return r2;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public AccMonitor(Activity r1, Handler r2, long r3, long r5) {
        super(r1, r2, r3, r5);
    }
}
