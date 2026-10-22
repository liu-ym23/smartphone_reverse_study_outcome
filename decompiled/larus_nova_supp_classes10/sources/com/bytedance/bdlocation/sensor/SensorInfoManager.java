package com.bytedance.bdlocation.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.larus.apm.impl.protector.RunnableProtector;
import fna.g;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import ona.a;
import ona.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class SensorInfoManager {
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int TYPE_CONTINUE_ACCELEROMETER = 1;
    public static final int TYPE_CONTINUE_GYROSCOPE = 2;
    public static final int TYPE_CONTINUE_LIGHT = 99;
    public static final int TYPE_CONTINUE_MAGNETOMETER = 3;
    public static final int TYPE_CONTINUE_PRESSURE = 4;
    public static final int TYPE_LIGHT = 5;
    private static volatile SensorInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private Context mContext;
    private final Queue<AccelerometerInfo> mContinueAccelerometerInfoQueue;
    private Sensor mContinueAccelerometerSensor;
    private final Queue<BarometerSampleInfo> mContinueBarometerSampleInfoQueue;
    private final Queue<GyroscopeInfo> mContinueGyroscopeInfoQueue;
    private Sensor mContinueGyroscopeSensor;
    private final Queue<LightSampleInfo> mContinueLightInfoQueue;
    private Sensor mContinueLightSensor;
    private final Queue<MagnetometerInfo> mContinueMagnetometerInfoQueue;
    private Sensor mContinueMagnetometerSensor;
    private Sensor mContinuePressureSensor;
    private Handler mHandler;
    private final Queue<LightInfo> mLightInfoQueue;
    private Sensor mLightSensor;
    private final Set<Integer> mRegisteredSensorTypes;
    private SensorCollectListener mSensorCollectListener;
    private SensorManager mSensorManager;
    private SingleLightCollectListener mSingleLightCollectListener;
    private TimeOutTask mTimeOutTask;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.sensor.SensorInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class SensorCollectListener implements SensorEventListener {
        final /* synthetic */ SensorInfoManager this$0;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        private SensorCollectListener(SensorInfoManager r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r9) {
            int r0 = r9.sensor.getType();
            if (r0 == 1) goto L18;
            if (r0 != 2) goto L6;
            long r4 = System.currentTimeMillis();
            MagnetometerInfo r1 = new MagnetometerInfo();
            float[] r10 = r9.values;
            r1.x = r10[0];
            r1.y = r10[1];
            r1.z = r10[2];
            r1.timestampMs = r4;
            trimByTimeWindow(SensorInfoManager.access$700(this.this$0), r4);
            SensorInfoManager.access$700(this.this$0).offer(r1);
            return;
        L6:
            if (r0 != 4) goto L8;
            long r5 = System.currentTimeMillis();
            GyroscopeInfo r2 = new GyroscopeInfo();
            float[] r11 = r9.values;
            r2.x = r11[0];
            r2.y = r11[1];
            r2.z = r11[2];
            r2.timestampMs = r5;
            trimByTimeWindow(SensorInfoManager.access$600(this.this$0), r5);
            SensorInfoManager.access$600(this.this$0).offer(r2);
            return;
        L8:
            if (r0 != 5) goto L10;
            long r3 = System.currentTimeMillis();
            if (SensorInfoManager.access$300(this.this$0).contains(99) == false) goto L21;
            LightSampleInfo r6 = new LightSampleInfo();
            r6.lux = r9.values[0];
            r6.timestampMs = r3;
            trimByTimeWindow(SensorInfoManager.access$400(this.this$0), r3);
            SensorInfoManager.access$400(this.this$0).offer(r6);
            return;
        L21:
            return;
        L10:
            if (r0 != 6) goto L25;
            long r7 = System.currentTimeMillis();
            BarometerSampleInfo r8 = new BarometerSampleInfo();
            r8.pressureHpa = r9.values[0];
            r8.timestampMs = r7;
            trimByTimeWindow(SensorInfoManager.access$800(this.this$0), r7);
            SensorInfoManager.access$800(this.this$0).offer(r8);
            return;
        L25:
            return;
        L18:
            long r12 = System.currentTimeMillis();
            AccelerometerInfo r13 = new AccelerometerInfo();
            float[] r14 = r9.values;
            r13.x = r14[0];
            r13.y = r14[1];
            r13.z = r14[2];
            r13.timestampMs = r12;
            trimByTimeWindow(SensorInfoManager.access$500(this.this$0), r12);
            SensorInfoManager.access$500(this.this$0).offer(r13);
        }

        public /* synthetic */ SensorCollectListener(SensorInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        private <T> void trimByTimeWindow(Queue<T> r6, long r7) {
            long r0 = r7 - (BDLocationConfig.getSensorMaxCacheSeconds() * 1000);
        L4:
            if (r6.isEmpty() == true) goto L24;
            T r2 = r6.peek();
            if ((r2 instanceof AccelerometerInfo) == false) goto L9;
            long r3 = ((AccelerometerInfo) r2).timestampMs;
        L22:
            if (r3 >= r0) goto L27;
            r6.poll();
            goto L4
        L27:
            return;
        L9:
            if ((r2 instanceof GyroscopeInfo) == false) goto L12;
            r3 = ((GyroscopeInfo) r2).timestampMs;
            goto L22
        L12:
            if ((r2 instanceof MagnetometerInfo) == false) goto L15;
            r3 = ((MagnetometerInfo) r2).timestampMs;
            goto L22
        L15:
            if ((r2 instanceof BarometerSampleInfo) == false) goto L18;
            r3 = ((BarometerSampleInfo) r2).timestampMs;
            goto L22
        L18:
            if ((r2 instanceof LightSampleInfo) == false) goto L20;
            r3 = ((LightSampleInfo) r2).timestampMs;
            goto L22
        L20:
            r3 = r7;
            goto L22
        }
    }

    public class SingleLightCollectListener implements SensorEventListener {
        final /* synthetic */ SensorInfoManager this$0;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        private SingleLightCollectListener(SensorInfoManager r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r4) {
            if (r4.sensor.getType() == 5) goto L5;
            return;
        L5:
            Logger.i("SensorInfoManager: onSensorChanged single light");
            LightInfo r0 = new LightInfo();
            r0.lightValue = r4.values[0];
            r0.timestamp = System.currentTimeMillis();
            if (SensorInfoManager.access$200(this.this$0).size() < BDLocationConfig.getMaxLightCount()) goto L8;
            Logger.i("SensorInfoManager: light info count is more than " + BDLocationConfig.getMaxLightCount());
            SensorInfoManager.access$200(this.this$0).poll();
        L8:
            SensorInfoManager.access$200(this.this$0).offer(r0);
        }

        public /* synthetic */ SingleLightCollectListener(SensorInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public class TimeOutTask implements Runnable {
        private int mSensorType;
        final /* synthetic */ SensorInfoManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_bdlocation_sensor_SensorInfoManager$TimeOutTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_bdlocation_sensor_SensorInfoManager$TimeOutTask__run$___twin___() {
            Logger.i("SensorInfoManager: collect sensor info timeout and sensor type is: " + this.mSensorType);
            this.this$0.unregisterListener(this.mSensorType);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bdlocation_sensor_SensorInfoManager$TimeOutTask_com_larus_apm_impl_protector_RunnableLancet_run(TimeOutTask r1) {
            r1.com_bytedance_bdlocation_sensor_SensorInfoManager$TimeOutTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public TimeOutTask(SensorInfoManager r1, int r2) {
            this.this$0 = r1;
            this.mSensorType = r2;
        }
    }

    public static SensorInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SensorInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<AccelerometerInfo> getContinueAccelerometerInfoList() {
        return new LinkedList(this.mContinueAccelerometerInfoQueue);
    }

    public List<GyroscopeInfo> getContinueGyroscopeInfoList() {
        return new LinkedList(this.mContinueGyroscopeInfoQueue);
    }

    public List<LightSampleInfo> getContinueLightInfoList() {
        return new LinkedList(this.mContinueLightInfoQueue);
    }

    public List<MagnetometerInfo> getContinueMagnetometerInfoList() {
        return new LinkedList(this.mContinueMagnetometerInfoQueue);
    }

    public List<BarometerSampleInfo> getContinuePressureInfoList() {
        return new LinkedList(this.mContinueBarometerSampleInfoQueue);
    }

    public List<LightInfo> getLightInfoList() {
        return new LinkedList(this.mLightInfoQueue);
    }

    private SensorInfoManager(Context r2) {
        this.mLightInfoQueue = new ConcurrentLinkedQueue();
        this.mContinueLightInfoQueue = new ConcurrentLinkedQueue();
        this.mContinueAccelerometerInfoQueue = new ConcurrentLinkedQueue();
        this.mContinueGyroscopeInfoQueue = new ConcurrentLinkedQueue();
        this.mContinueMagnetometerInfoQueue = new ConcurrentLinkedQueue();
        this.mContinueBarometerSampleInfoQueue = new ConcurrentLinkedQueue();
        this.mRegisteredSensorTypes = new HashSet();
        this.mContext = r2;
        if (r2 != null) goto L6;
        Logger.i("Context is null!");
        return;
    L6:
        this.mSensorManager = (SensorManager) r2.getSystemService("sensor");
        AnonymousClass1 r0 = null;
        this.mSingleLightCollectListener = new SingleLightCollectListener(this, r0);
        this.mSensorCollectListener = new SensorCollectListener(this, r0);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ Queue access$200(SensorInfoManager r0) {
        return r0.mLightInfoQueue;
    }

    public static /* synthetic */ Set access$300(SensorInfoManager r0) {
        return r0.mRegisteredSensorTypes;
    }

    public static /* synthetic */ Queue access$400(SensorInfoManager r0) {
        return r0.mContinueLightInfoQueue;
    }

    public static /* synthetic */ Queue access$500(SensorInfoManager r0) {
        return r0.mContinueAccelerometerInfoQueue;
    }

    public static /* synthetic */ Queue access$600(SensorInfoManager r0) {
        return r0.mContinueGyroscopeInfoQueue;
    }

    public static /* synthetic */ Queue access$700(SensorInfoManager r0) {
        return r0.mContinueMagnetometerInfoQueue;
    }

    public static /* synthetic */ Queue access$800(SensorInfoManager r0) {
        return r0.mContinueBarometerSampleInfoQueue;
    }

    public synchronized void registerListener(int r11) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: registerListener and sensor type is: " + r11);     // Catch: Throwable -> L98 Exception -> L100
        this.mRegisteredSensorTypes.add(Integer.valueOf(r11));     // Catch: Throwable -> L98 Exception -> L100
        boolean r6 = false;
        if (r11 != 1) goto L7;
        this.mContinueAccelerometerInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isSensorAccelerometerEnabled() == false) goto L95;
        SensorManager r12 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r12 == null) goto L95;
        this.mContinueAccelerometerSensor = this.mBPEAManager.getDefaultSensor(r12, 1, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r13 = new StringBuilder("SensorInfoManager: registerListener and continue accelerometer sensor: ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mContinueAccelerometerSensor == null) goto L91;
        r6 = true;
    L91:
        r13.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r13.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r14 = this.mContinueAccelerometerSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r14 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSensorCollectListener, r14, BDLocationConfig.getContinueAccelerometerInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
    L102:
        monitor-exit(this);
        return;
    L95:
        if (BDLocationConfig.isSensorAccelerometerEnabled() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register continue accelerometer.");     // Catch: Throwable -> L98 Exception -> L100
        goto L102
    L7:
        if (r11 != 2) goto L9;
        this.mContinueGyroscopeInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isSensorGyroscopeEnabled() == false) goto L82;
        SensorManager r15 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r15 == null) goto L82;
        this.mContinueGyroscopeSensor = this.mBPEAManager.getDefaultSensor(r15, 4, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r16 = new StringBuilder("SensorInfoManager: registerListener and continue gyroscope sensor: ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mContinueGyroscopeSensor == null) goto L78;
        r6 = true;
    L78:
        r16.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r16.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r17 = this.mContinueGyroscopeSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r17 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSensorCollectListener, r17, BDLocationConfig.getContinueGyroscopeInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
    L82:
        if (BDLocationConfig.isSensorGyroscopeEnabled() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register continue gyroscope.");     // Catch: Throwable -> L98 Exception -> L100
        goto L102
    L9:
        if (r11 == 3) goto L58;
        if (r11 != 4) goto L12;
        this.mContinueBarometerSampleInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isSensorBarometerEnabled() == false) goto L56;
        SensorManager r18 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r18 == null) goto L56;
        this.mContinuePressureSensor = this.mBPEAManager.getDefaultSensor(r18, 6, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r19 = new StringBuilder("SensorInfoManager: registerListener and continue pressure sensor: ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mContinuePressureSensor == null) goto L52;
        r6 = true;
    L52:
        r19.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r19.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r110 = this.mContinuePressureSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r110 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSensorCollectListener, r110, BDLocationConfig.getContinuePressureInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
    L56:
        if (BDLocationConfig.isSensorBarometerEnabled() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register continue pressure.");     // Catch: Throwable -> L98 Exception -> L100
        goto L102
    L12:
        if (r11 != 5) goto L14;
        this.mLightInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isCollectLightInfo() == false) goto L43;
        SensorManager r111 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r111 == null) goto L43;
        this.mLightSensor = this.mBPEAManager.getDefaultSensor(r111, 5, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r112 = new StringBuilder("SensorInfoManager: registerListener and light sensor: ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mLightSensor == null) goto L36;
        r6 = true;
    L36:
        r112.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r112.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r113 = this.mLightSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r113 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSingleLightCollectListener, r113, BDLocationConfig.getLightInfoInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
        if (this.mTimeOutTask != null) goto L41;
        this.mTimeOutTask = new TimeOutTask(this, 5);     // Catch: Throwable -> L98 Exception -> L100
    L41:
        this.mHandler.removeCallbacks(this.mTimeOutTask);     // Catch: Throwable -> L98 Exception -> L100
        this.mHandler.postDelayed(this.mTimeOutTask, BDLocationConfig.getMaxLightDuration());     // Catch: Throwable -> L98 Exception -> L100
    L43:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register.");     // Catch: Throwable -> L98 Exception -> L100
        goto L102
    L14:
        if (r11 != 99) goto L102;
        this.mContinueLightInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isSensorLightEnabled() == false) goto L27;
        SensorManager r114 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r114 == null) goto L27;
        this.mContinueLightSensor = this.mBPEAManager.getDefaultSensor(r114, 5, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r115 = new StringBuilder("SensorInfoManager: registerListener and continue light sensor(10Hz): ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mContinueLightSensor == null) goto L23;
        r6 = true;
    L23:
        r115.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r115.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r116 = this.mContinueLightSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r116 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSensorCollectListener, r116, BDLocationConfig.getContinueLightInfoInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
    L27:
        if (BDLocationConfig.isSensorLightEnabled() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register continue light.");     // Catch: Throwable -> L98 Exception -> L100
        goto L102
    L58:
        this.mContinueMagnetometerInfoQueue.clear();     // Catch: Throwable -> L98 Exception -> L100
        if (BDLocationConfig.isSensorMagnetometerEnabled() == false) goto L69;
        SensorManager r117 = this.mSensorManager;     // Catch: Throwable -> L98 Exception -> L100
        if (r117 == null) goto L69;
        this.mContinueMagnetometerSensor = this.mBPEAManager.getDefaultSensor(r117, 2, null);     // Catch: Throwable -> L98 Exception -> L100
        StringBuilder r118 = new StringBuilder("SensorInfoManager: registerListener and continue magnetometer sensor: ");     // Catch: Throwable -> L98 Exception -> L100
        if (this.mContinueMagnetometerSensor == null) goto L65;
        r6 = true;
    L65:
        r118.append(r6);     // Catch: Throwable -> L98 Exception -> L100
        Logger.i(r118.toString());     // Catch: Throwable -> L98 Exception -> L100
        Sensor r119 = this.mContinueMagnetometerSensor;     // Catch: Throwable -> L98 Exception -> L100
        if (r119 == null) goto L102;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(this.mSensorManager, this.mSensorCollectListener, r119, BDLocationConfig.getContinueMagnetometerInterval(), this.mHandler);     // Catch: Throwable -> L98 Exception -> L100
    L69:
        if (BDLocationConfig.isSensorMagnetometerEnabled() == true) goto L102;
        Logger.i("SensorInfoManager.registerListener: skip register continue magnetometer.");     // Catch: Throwable -> L98 Exception -> L100
    L100:
        e = move-exception;
        Logger.e("SensorInfoManager: registerListener error", e);     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterListener(int r4) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: unregisterListener and sensor type is: " + r4);     // Catch: Throwable -> L77 Exception -> L79
        this.mRegisteredSensorTypes.remove(Integer.valueOf(r4));     // Catch: Throwable -> L77 Exception -> L79
        if (r4 == 1) goto L68;
        if (r4 == 2) goto L59;
        if (r4 == 3) goto L50;
        if (r4 == 4) goto L41;
        if (r4 != 5) goto L15;
        TimeOutTask r5 = this.mTimeOutTask;     // Catch: Throwable -> L77 Exception -> L79
        if (r5 == null) goto L32;
        Handler r0 = this.mHandler;     // Catch: Throwable -> L77 Exception -> L79
        if (r0 == null) goto L32;
        r0.removeCallbacks(r5);     // Catch: Throwable -> L77 Exception -> L79
        this.mTimeOutTask = null;     // Catch: Throwable -> L77 Exception -> L79
    L32:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L37;
        SensorManager r6 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r6 == null) goto L37;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r6, this.mSingleLightCollectListener, this.mLightSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and light sensor");     // Catch: Throwable -> L77 Exception -> L79
    L39:
        this.mLightSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L81:
        monitor-exit(this);
        return;
    L37:
        if (BDLocationConfig.isCollectLightInfo() == true) goto L39;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister.");     // Catch: Throwable -> L77 Exception -> L79
        goto L39
    L15:
        if (r4 != 99) goto L81;
        if (BDLocationConfig.isSensorLightEnabled() == false) goto L23;
        SensorManager r7 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r7 == null) goto L23;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r7, this.mSensorCollectListener, this.mContinueLightSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and continue light sensor");     // Catch: Throwable -> L77 Exception -> L79
    L25:
        this.mContinueLightInfoQueue.clear();     // Catch: Throwable -> L77 Exception -> L79
        this.mContinueLightSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L23:
        if (BDLocationConfig.isSensorLightEnabled() == true) goto L25;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister continue light.");     // Catch: Throwable -> L77 Exception -> L79
        goto L25
    L41:
        if (BDLocationConfig.isSensorBarometerEnabled() == false) goto L46;
        SensorManager r8 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r8 == null) goto L46;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r8, this.mSensorCollectListener, this.mContinuePressureSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and continue pressure sensor");     // Catch: Throwable -> L77 Exception -> L79
    L48:
        this.mContinueBarometerSampleInfoQueue.clear();     // Catch: Throwable -> L77 Exception -> L79
        this.mContinuePressureSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L46:
        if (BDLocationConfig.isSensorBarometerEnabled() == true) goto L48;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister continue pressure.");     // Catch: Throwable -> L77 Exception -> L79
        goto L48
    L50:
        if (BDLocationConfig.isSensorMagnetometerEnabled() == false) goto L55;
        SensorManager r9 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r9 == null) goto L55;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r9, this.mSensorCollectListener, this.mContinueMagnetometerSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and continue magnetometer sensor");     // Catch: Throwable -> L77 Exception -> L79
    L57:
        this.mContinueMagnetometerInfoQueue.clear();     // Catch: Throwable -> L77 Exception -> L79
        this.mContinueMagnetometerSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L55:
        if (BDLocationConfig.isSensorMagnetometerEnabled() == true) goto L57;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister continue magnetometer.");     // Catch: Throwable -> L77 Exception -> L79
        goto L57
    L59:
        if (BDLocationConfig.isSensorGyroscopeEnabled() == false) goto L64;
        SensorManager r10 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r10 == null) goto L64;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r10, this.mSensorCollectListener, this.mContinueGyroscopeSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and continue gyroscope sensor");     // Catch: Throwable -> L77 Exception -> L79
    L66:
        this.mContinueGyroscopeInfoQueue.clear();     // Catch: Throwable -> L77 Exception -> L79
        this.mContinueGyroscopeSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L64:
        if (BDLocationConfig.isSensorGyroscopeEnabled() == true) goto L66;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister continue gyroscope.");     // Catch: Throwable -> L77 Exception -> L79
        goto L66
    L68:
        if (BDLocationConfig.isSensorAccelerometerEnabled() == false) goto L73;
        SensorManager r11 = this.mSensorManager;     // Catch: Throwable -> L77 Exception -> L79
        if (r11 == null) goto L73;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(r11, this.mSensorCollectListener, this.mContinueAccelerometerSensor);     // Catch: Throwable -> L77 Exception -> L79
        Logger.i("SensorInfoManager: unregisterListener and continue accelerometer sensor");     // Catch: Throwable -> L77 Exception -> L79
    L75:
        this.mContinueAccelerometerInfoQueue.clear();     // Catch: Throwable -> L77 Exception -> L79
        this.mContinueAccelerometerSensor = null;     // Catch: Throwable -> L77 Exception -> L79
    L73:
        if (BDLocationConfig.isSensorAccelerometerEnabled() == true) goto L75;
        Logger.i("SensorInfoManager.unregisterListener: skip unregister continue accelerometer.");     // Catch: Throwable -> L77 Exception -> L79
    L79:
        e = move-exception;
        Logger.e("SensorInfoManager: unregisterListener error", e);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_unregisterListener(SensorManager r1, SensorEventListener r2, Sensor r3) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2, r3);
        return;
    L6:
        r1.unregisterListener(r2, r3);
        int r0 = 0;
        if (r2 == null) goto L9;
        int r4 = r2.hashCode();
    L10:
        if (r3 == null) goto L12;
        r0 = r3.hashCode();
    L12:
        b.c(new a(r4, Integer.valueOf(r0)));
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorInfoManager_com_obric_performance_power_monitor_sensor_SensorLancet_registerListener(SensorManager r2, SensorEventListener r3, Sensor r4, int r5, Handler r6) {
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
        b.a(new a(r11, Integer.valueOf(r10)));
        return r9;
    L9:
        r11 = 0;
        goto L10
    }
}
