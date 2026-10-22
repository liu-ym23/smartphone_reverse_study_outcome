package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class AccMonitor extends AbstractSensorMonitor {
    private static final String TAG = "AccMonitor";

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 1;
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent r100) {
        float[] r101 = r100.values;
        float r102 = r101[0];
        float r103 = r101[1];
        float r104 = r101[2];
        JSONObject r105 = new JSONObject();
        r105.put("x", r102);     // Catch: Exception -> L5
        r105.put("y", r103);     // Catch: Exception -> L5
        r105.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, r104);     // Catch: Exception -> L5
        r105.put("m", System.currentTimeMillis());     // Catch: Exception -> L5
    L7:
        return r105;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public AccMonitor(Activity r100, Handler r101, long r102, long r103) {
        super(r100, r101, r102, r103);
    }
}
