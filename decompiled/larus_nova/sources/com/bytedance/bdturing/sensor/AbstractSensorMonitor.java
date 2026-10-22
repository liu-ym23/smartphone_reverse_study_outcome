package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import faceverify.w;
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

/* JADX INFO: loaded from: classes14.dex */
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

    public abstract JSONObject handleSensorEvent(SensorEvent r100);

    public boolean sensorEnable() {
    L9:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "sensor_enable_error", String.valueOf(e));
        return false;
    L4:
        if (this.mManager.getDefaultSensor(sensorType()) == null) goto L6;
        boolean r100 = true;
    L7:
        d.b(this.mStateRecord, "sensor_enable", Boolean.valueOf(r100));     // Catch: Exception -> L9
        return r100;
    L6:
        r100 = false;
        goto L7
    }

    public abstract int sensorType();

    public JSONArray getData() {
        JSONArray r100 = this.mData;
        if (r100 == null) goto L5;
        return r100;
    L5:
        LinkedList<JSONObject> r101 = this.mEventInfoList;
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.size() <= 0) goto L17;
        JSONArray r102 = new JSONArray();
        Iterator<JSONObject> r103 = this.mEventInfoList.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r102.put(r103.next());
        goto L11
    L13:
        return r102;
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
        long r100 = this.mTimeInterval;     // Catch: Exception -> L16
        if (r100 < 300) goto L6;
        int r101 = 3;
    L8:
        if (r100 >= 25) goto L10;
        r101 = 0;
    L10:
        Sensor r102 = this.mManager.getDefaultSensor(sensorType());     // Catch: Exception -> L16
        if (r102 == null) goto L13;
        String r103 = r102.getName();     // Catch: Exception -> L16
    L14:
        d.b(this.mStateRecord, "register_listener", "sensorName=" + r103 + ":sampleRate=" + r101 + ":sensorDetail=" + r102);     // Catch: Exception -> L16
        INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mManager, this, r102, r101, this.mSensorHandler);     // Catch: Exception -> L16
        return;
    L13:
        r103 = "";
        goto L14
    L6:
        r101 = 1;
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
    public void onSensorChanged(SensorEvent r100) {
        if (r100 != null) goto L36;
    L9:
        int r101 = DEFAULT_SENSOR_TYPE;
    L10:
        if (r101 == DEFAULT_SENSOR_TYPE) goto L15;
        if (this.mSensorTypeList.contains(String.valueOf(r101)) == true) goto L15;
        this.mSensorTypeList.add(String.valueOf(r101));     // Catch: Exception -> L7
        d.b(this.mStateRecord, "onSensorChanged_" + r101, "sensor_type=" + r101 + ":values=" + Arrays.toString(r100.values) + ":accept_sensor=" + sensorType());     // Catch: Exception -> L7
    L15:
        if (sensorType() != r101) goto L38;
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L7
        if ((r102 - this.mLastTimeStamp) < this.mTimeInterval) goto L39;
        this.mLastTimeStamp = r102;     // Catch: Exception -> L7
        JSONObject r103 = handleSensorEvent(r100);     // Catch: Exception -> L7
        if (r103 != null) goto L21;
        return;
    L21:
        if (r103.length() != 0) goto L24;
        return;
    L24:
        if (this.mInitData.length() >= 20) goto L26;
        this.mInitData.put(r103);     // Catch: Exception -> L7
    L26:
        JSONArray r104 = this.mData;     // Catch: Exception -> L7
        if (r104 != null) goto L29;
    L31:
        this.mData = null;     // Catch: Exception -> L7
        this.mEventInfoList.remove(0);     // Catch: Exception -> L7
        this.mEventInfoList.add(r103);     // Catch: Exception -> L7
        return;
    L29:
        if (r104.length() >= this.mEventNum) goto L31;
        this.mEventInfoList.add(r103);     // Catch: Exception -> L7
        this.mData.put(r103);     // Catch: Exception -> L7
        return;
    L39:
        return;
    L38:
        return;
    L36:
        Sensor r105 = r100.sensor;     // Catch: Exception -> L7
        if (r105 == null) goto L9;
        r101 = r105.getType();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        d.b(this.mStateRecord, "onSensorChanged_error", String.valueOf(e));
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r100, SensorEventListener r101) {
        if (g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        b.c(new ona.a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r100, int r101) {
        if (r100 == null) goto L5;
        int r102 = r100.getType();
    L6:
        if (r102 != DEFAULT_SENSOR_TYPE) goto L9;
        return;
    L9:
        if (this.mSensorTypeList.contains(String.valueOf(r102)) == true) goto L12;
        this.mSensorTypeList.add(String.valueOf(r102));
        d.b(this.mStateRecord, "onAccuracyChanged_" + r102, "accuracy=" + r101);
    L12:
        if (sensorType() != r102) goto L19;
        JSONArray r103 = this.mAccuracyData;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.length() >= 100) goto L21;
        this.mAccuracyData.put(r101);
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r102 = DEFAULT_SENSOR_TYPE;
        goto L6
    }

    public AbstractSensorMonitor(Activity r100, Handler r101, long r102, long r103) {
        this.mStateRecord = new JSONObject();
        this.mSensorTypeList = new ArrayList();
        this.mTimeInterval = r102;
        this.mManager = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.mInitData = new JSONArray();
        this.mEventInfoList = new LinkedList();
        this.mData = new JSONArray();
        this.mEventNum = r103;
        this.mAccuracyData = new JSONArray();
        this.mSensorHandler = r101;
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdturing_sensor_AbstractSensorMonitor_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r100, SensorEventListener r101, Sensor r102, int r103, Handler r104) {
        if (g.d() == true) goto L6;
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        return r105.booleanValue();
    L6:
        Boolean r106 = Boolean.valueOf(r100.registerListener(r101, r102, r103, r104));
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r107 = r106.booleanValue();
        int r108 = 0;
        if (r101 == null) goto L9;
        int r109 = r101.hashCode();
    L10:
        if (r102 == null) goto L12;
        r108 = r102.hashCode();
    L12:
        b.a(new ona.a(r109, Integer.valueOf(r108)));
        return r107;
    L9:
        r109 = 0;
        goto L10
    }
}
