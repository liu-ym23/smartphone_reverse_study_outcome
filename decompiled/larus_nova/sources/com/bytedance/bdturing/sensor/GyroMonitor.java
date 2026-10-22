package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class GyroMonitor extends AbstractSensorMonitor {
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = "GyroMonitor";
    private long mTimestamp;

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 4;
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent r100) {
        long r101 = this.mTimestamp;
        if (r101 != 0) goto L6;
        this.mTimestamp = r100.timestamp;
        return null;
    L6:
        float r102 = (r100.timestamp - r101) * NS2S;
        float r103 = (float) Math.toDegrees(r100.values[0] * r102);
        float r104 = (float) Math.toDegrees(r100.values[1] * r102);
        float r105 = (float) Math.toDegrees(r100.values[2] * r102);
        this.mTimestamp = r100.timestamp;
        JSONObject r106 = new JSONObject();
        r106.put("x", r103);     // Catch: Exception -> L9
        r106.put("y", r104);     // Catch: Exception -> L9
        r106.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, r105);     // Catch: Exception -> L9
        r106.put("m", System.currentTimeMillis());     // Catch: Exception -> L9
    L11:
        return r106;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public GyroMonitor(Activity r100, Handler r101, long r102, long r103) {
        super(r100, r101, r102, r103);
    }
}
