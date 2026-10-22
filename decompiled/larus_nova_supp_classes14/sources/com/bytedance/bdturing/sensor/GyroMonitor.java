package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class GyroMonitor extends AbstractSensorMonitor {
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = "GyroMonitor";
    private long mTimestamp;

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 4;
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent r7) {
        long r0 = this.mTimestamp;
        if (r0 != 0) goto L6;
        this.mTimestamp = r7.timestamp;
        return null;
    L6:
        float r1 = (r7.timestamp - r0) * NS2S;
        float r2 = (float) Math.toDegrees(r7.values[0] * r1);
        float r3 = (float) Math.toDegrees(r7.values[1] * r1);
        float r4 = (float) Math.toDegrees(r7.values[2] * r1);
        this.mTimestamp = r7.timestamp;
        JSONObject r8 = new JSONObject();
        r8.put("x", r2);     // Catch: Exception -> L9
        r8.put("y", r3);     // Catch: Exception -> L9
        r8.put("z", r4);     // Catch: Exception -> L9
        r8.put("m", System.currentTimeMillis());     // Catch: Exception -> L9
    L11:
        return r8;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public GyroMonitor(Activity r1, Handler r2, long r3, long r5) {
        super(r1, r2, r3, r5);
    }
}
