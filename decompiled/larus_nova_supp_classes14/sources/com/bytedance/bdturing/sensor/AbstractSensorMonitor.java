package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import fna.g;
import hc4.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ona.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class AbstractSensorMonitor implements SensorEventListener {
    private static final int DEFAULT_SENSOR_TYPE = -1213;
    private static final int INITIAL_SIZE = 20;
    private static final int SAMPLE_RATE_GAME = 25;
    private static final int SAMPLE_RATE_NORMAL = 300;
    private JSONArray mAccuracyData;
    private JSONArray mData;
    private final LinkedList<JSONObject> mEventInfoList;
    private long mEventNum;
    private final JSONArray mInitData;
    private long mLastTimeStamp;
    private final SensorManager mManager;
    private final Handler mSensorHandler;
    private List<String> mSensorTypeList;
    private JSONObject mStateRecord;
    private long mTimeInterval;

    public abstract JSONObject handleSensorEvent(SensorEvent r1);

    public boolean sensorEnable() {
    L9:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "sensor_enable_error", String.valueOf(e));
        return false;
    L4:
        if (this.mManager.getDefaultSensor(sensorType()) == null) goto L6;
        boolean r1 = true;
    L7:
        d.b(this.mStateRecord, "sensor_enable", Boolean.valueOf(r1));     // Catch: Exception -> L9
        return r1;
    L6:
        r1 = false;
        goto L7
    }

    public abstract int sensorType();

    public JSONArray getData() {
        JSONArray r0 = this.mData;
        if (r0 == null) goto L5;
        return r0;
    L5:
        LinkedList<JSONObject> r1 = this.mEventInfoList;
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.size() <= 0) goto L17;
        JSONArray r2 = new JSONArray();
        Iterator<JSONObject> r3 = this.mEventInfoList.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r2.put(r3.next());
        goto L11
    L13:
        return r2;
    L17:
        return null;
    }

    public void onPause() {
        d.b(this.mStateRecord, "handle_onPause", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L4
        INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(this.mManager, this);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "handle_onPause_error", String.valueOf(e));
    }

    public void onResume() {
        long r1 = this.mTimeInterval;     // Catch: Exception -> L16
        if (r1 < 300) goto L6;
        int r3 = 3;
    L8:
        if (r1 >= 25) goto L10;
        r3 = 0;
    L10:
        Sensor r2 = this.mManager.getDefaultSensor(sensorType());     // Catch: Exception -> L16
        if (r2 == null) goto L13;
        String r4 = r2.getName();     // Catch: Exception -> L16
    L14:
        d.b(this.mStateRecord, "register_listener", "sensorName=" + r4 + ":sampleRate=" + r3 + ":sensorDetail=" + r2);     // Catch: Exception -> L16
        INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mManager, this, r2, r3, this.mSensorHandler);     // Catch: Exception -> L16
        return;
    L13:
        r4 = "";
        goto L14
    L6:
        r3 = 1;
    L16:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "register_listener_error", "errorMessage:" + e);
    }

    public JSONArray getAccuracyData() {
        return this.mAccuracyData;
    }

    public JSONArray getInitialData() {
        return this.mInitData;
    }

    public JSONObject getStateRecord() {
        return this.mStateRecord;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r8) {
        if (r8 != null) goto L36;
    L9:
        int r3 = DEFAULT_SENSOR_TYPE;
    L10:
        if (r3 == DEFAULT_SENSOR_TYPE) goto L15;
        if (this.mSensorTypeList.contains(String.valueOf(r3)) == true) goto L15;
        this.mSensorTypeList.add(String.valueOf(r3));     // Catch: Exception -> L7
        d.b(this.mStateRecord, "onSensorChanged_" + r3, "sensor_type=" + r3 + ":values=" + Arrays.toString(r8.values) + ":accept_sensor=" + sensorType());     // Catch: Exception -> L7
    L15:
        if (sensorType() != r3) goto L38;
        long r0 = System.currentTimeMillis();     // Catch: Exception -> L7
        if ((r0 - this.mLastTimeStamp) < this.mTimeInterval) goto L39;
        this.mLastTimeStamp = r0;     // Catch: Exception -> L7
        JSONObject r9 = handleSensorEvent(r8);     // Catch: Exception -> L7
        if (r9 != null) goto L21;
        return;
    L21:
        if (r9.length() != 0) goto L24;
        return;
    L24:
        if (this.mInitData.length() >= 20) goto L26;
        this.mInitData.put(r9);     // Catch: Exception -> L7
    L26:
        JSONArray r1 = this.mData;     // Catch: Exception -> L7
        if (r1 != null) goto L29;
    L31:
        this.mData = null;     // Catch: Exception -> L7
        this.mEventInfoList.remove(0);     // Catch: Exception -> L7
        this.mEventInfoList.add(r9);     // Catch: Exception -> L7
        return;
    L29:
        if (r1.length() >= this.mEventNum) goto L31;
        this.mEventInfoList.add(r9);     // Catch: Exception -> L7
        this.mData.put(r9);     // Catch: Exception -> L7
        return;
    L39:
        return;
    L38:
        return;
    L36:
        Sensor r4 = r8.sensor;     // Catch: Exception -> L7
        if (r4 == null) goto L9;
        r3 = r4.getType();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "onSensorChanged_error", String.valueOf(e));
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2);
        return;
    L6:
        r1.unregisterListener(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        b.c(new ona.a(r3, null));
        return;
    L9:
        r3 = 0;
        goto L10
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r5, int r6) {
        if (r5 == null) goto L5;
        int r7 = r5.getType();
    L6:
        if (r7 != DEFAULT_SENSOR_TYPE) goto L9;
        return;
    L9:
        if (this.mSensorTypeList.contains(String.valueOf(r7)) == true) goto L12;
        this.mSensorTypeList.add(String.valueOf(r7));
        d.b(this.mStateRecord, "onAccuracyChanged_" + r7, "accuracy=" + r6);
    L12:
        if (sensorType() != r7) goto L19;
        JSONArray r8 = this.mAccuracyData;
        if (r8 != null) goto L16;
        return;
    L16:
        if (r8.length() >= 100) goto L21;
        this.mAccuracyData.put(r6);
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r7 = DEFAULT_SENSOR_TYPE;
        goto L6
    }

    public AbstractSensorMonitor(Activity r2, Handler r3, long r4, long r6) {
        this.mStateRecord = new JSONObject();
        this.mSensorTypeList = new ArrayList();
        this.mTimeInterval = r4;
        this.mManager = (SensorManager) r2.getSystemService("sensor");
        this.mInitData = new JSONArray();
        this.mEventInfoList = new LinkedList();
        this.mData = new JSONArray();
        this.mEventNum = r6;
        this.mAccuracyData = new JSONArray();
        this.mSensorHandler = r3;
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r2, SensorEventListener r3, Sensor r4, int r5, Handler r6) {
        if (g.d() == true) goto L6;
        Boolean r7 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        return r7.booleanValue();
    L6:
        Boolean r8 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r9 = r8.booleanValue();
        int r10 = 0;
        if (r3 == null) goto L9;
        int r11 = r3.hashCode();
    L10:
        if (r4 == null) goto L12;
        r10 = r4.hashCode();
    L12:
        b.a(new ona.a(r11, Integer.valueOf(r10)));
        return r9;
    L9:
        r11 = 0;
        goto L10
    }
}
