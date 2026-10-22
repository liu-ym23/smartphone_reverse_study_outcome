package com.bytedance.bdlocation.sensor;

import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.bridge.WalkingCyclingNavigationHint;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\f\u0018\u0000 P2\u00020\u0001:\u0002PQB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010*\u001a\u00020+\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\t2\u0006\u0010.\u001a\u0002H,H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u000201H\u0002J2\u00102\u001a\u0002032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n04H\u0002J\"\u00105\u001a\b\u0012\u0004\u0012\u0002H,04\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0\tH\u0002J\b\u00106\u001a\u00020+H\u0002J\u001c\u00107\u001a\u0004\u0018\u00010\u00182\b\u00108\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020&H\u0002J\u0006\u0010:\u001a\u00020\u001aJ\b\u0010;\u001a\u00020$H\u0002J\u0006\u0010<\u001a\u00020$J\u0010\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020+H\u0002J\u0006\u0010@\u001a\u00020+J\u0006\u0010A\u001a\u00020+J\b\u0010B\u001a\u00020+H\u0002J\u0006\u0010C\u001a\u00020+J\u0006\u0010D\u001a\u00020+J\u0016\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n04H\u0002J\u0010\u0010H\u001a\u00020+2\b\u0010I\u001a\u0004\u0018\u00010\u0006J\u0018\u0010J\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u001aH\u0002J\u0016\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u001aR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;", "", "context", "Landroid/content/Context;", "bpeaCert", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$SensorBatchAtomicCallback;", "(Landroid/content/Context;Ljava/lang/Object;Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$SensorBatchAtomicCallback;)V", "accelerometerSamples", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/bytedance/bdlocation/sensor/AxisSample;", "batchCallbackRunnable", "com/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$batchCallbackRunnable$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$batchCallbackRunnable$1;", "gpsCollector", "Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCollector;", "gyroscopeSamples", "handler", "Landroid/os/Handler;", "headingCollector", "Lcom/bytedance/bdlocation/sensor/SensorBatchHeadingCollector;", "imuCollector", "Lcom/bytedance/bdlocation/sensor/SensorBatchImuCollector;", "latestGps", "Lcom/bytedance/bdlocation/bridge/SensorBatch$GpsStruct;", "latestMagneticDeclination", "", "latestNavigationHint", "Lcom/bytedance/bdlocation/bridge/WalkingCyclingNavigationHint;", "latestSensorHeading", "locationManager", "Landroid/location/LocationManager;", "magnetometerSamples", "sensorManager", "Landroid/hardware/SensorManager;", "started", "", "tBeginMs", "", "tEndMs", "workerThread", "Landroid/os/HandlerThread;", "appendSample", "", "T", "queue", "sample", "(Ljava/util/concurrent/ConcurrentLinkedQueue;Ljava/lang/Object;)V", "buildAndResetBatch", "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "buildImuStruct", "Lcom/bytedance/bdlocation/bridge/SensorBatch$ImuStruct;", "", "drainQueue", "emitCurrentBatch", "ensureGpsTimestampAfterBatchBegin", "gps", "batchBeginMs", "getLatestMagneticDeclination", "hasFineLocationPermission", "isStarted", "postBatchCallback", "delayMs", "postNextBatchCallback", "release", "resetBatch", "resetSamples", "start", "stop", "toAxisSamples", "Lcom/bytedance/bdlocation/bridge/SensorBatch$AxisSamples;", "samples", "updateCallback", "newCallback", "updateLatestGps", "magneticDeclination", "updateNavigationHint", "navigationCode", "", "projectionBearing", "Companion", "SensorBatchAtomicCallback", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchAtomicCollector {
    public static final Companion Companion = null;
    public static final String TAG = "SSS-AtomicCollector";
    private final ConcurrentLinkedQueue<AxisSample> accelerometerSamples;
    private final SensorBatchAtomicCollector$batchCallbackRunnable$1 batchCallbackRunnable;
    private final Object bpeaCert;
    private volatile SensorBatchAtomicCallback callback;
    private final Context context;
    private final SensorBatchGpsCollector gpsCollector;
    private final ConcurrentLinkedQueue<AxisSample> gyroscopeSamples;
    private Handler handler;
    private final SensorBatchHeadingCollector headingCollector;
    private final SensorBatchImuCollector imuCollector;
    private SensorBatch.GpsStruct latestGps;
    private volatile float latestMagneticDeclination;
    private WalkingCyclingNavigationHint latestNavigationHint;
    private float latestSensorHeading;
    private final LocationManager locationManager;
    private final ConcurrentLinkedQueue<AxisSample> magnetometerSamples;
    private final SensorManager sensorManager;
    private volatile boolean started;
    private volatile long tBeginMs;
    private volatile long tEndMs;
    private final HandlerThread workerThread;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$Companion;", "", "()V", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector$SensorBatchAtomicCallback;", "", "onSensorBatch", "", "batch", "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public interface SensorBatchAtomicCallback {
        void onSensorBatch(SensorBatch r1);
    }

    static {
        Companion = new Companion(null);
    }

    public final synchronized void release() {
        monitor-enter(this);
        stop();     // Catch: Throwable -> L9
        this.callback = null;     // Catch: Throwable -> L9
        Handler r1 = this.handler;     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L9
    L6:
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        this.workerThread.quitSafely();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void resetBatch() {
        monitor-enter(this);
        resetSamples();     // Catch: Throwable -> L6
        this.tBeginMs = System.currentTimeMillis();     // Catch: Throwable -> L6
        this.tEndMs = this.tBeginMs;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void start() {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.started == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.started = true;     // Catch: Throwable -> L29
        this.tBeginMs = System.currentTimeMillis();     // Catch: Throwable -> L29
        this.tEndMs = this.tBeginMs;     // Catch: Throwable -> L29
        resetSamples();     // Catch: Throwable -> L29
        SensorBatchImuCollector r0 = this.imuCollector;     // Catch: Throwable -> L29
        int r1 = BDLocationConfig.getFusionLocationAccelerometerIntervalUs();     // Catch: Throwable -> L29
        Handler r2 = this.handler;     // Catch: Throwable -> L29
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L11:
        r0.startAccelerometer(r1, r2, this.bpeaCert);     // Catch: Throwable -> L29
        SensorBatchImuCollector r3 = this.imuCollector;     // Catch: Throwable -> L29
        int r4 = BDLocationConfig.getFusionLocationGyroscopeIntervalUs();     // Catch: Throwable -> L29
        Handler r5 = this.handler;     // Catch: Throwable -> L29
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L14:
        r3.startGyroscope(r4, r5, this.bpeaCert);     // Catch: Throwable -> L29
        SensorBatchImuCollector r6 = this.imuCollector;     // Catch: Throwable -> L29
        int r7 = BDLocationConfig.getFusionLocationMagnetometerIntervalUs();     // Catch: Throwable -> L29
        Handler r8 = this.handler;     // Catch: Throwable -> L29
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L17:
        r6.startMagnetometer(r7, r8, this.bpeaCert);     // Catch: Throwable -> L29
        SensorBatchHeadingCollector r9 = this.headingCollector;     // Catch: Throwable -> L29
        int r10 = BDLocationConfig.getFusionLocationHeadingIntervalUs();     // Catch: Throwable -> L29
        Handler r11 = this.handler;     // Catch: Throwable -> L29
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L20:
        r9.start(r10, r11, this.bpeaCert);     // Catch: Throwable -> L29
        SensorBatchGpsCollector r12 = this.gpsCollector;     // Catch: Throwable -> L29
        long r13 = BDLocationConfig.getFusionLocationGpsIntervalMs();     // Catch: Throwable -> L29
        Handler r14 = this.handler;     // Catch: Throwable -> L29
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L23:
        r12.start(r13, r14, this.bpeaCert);     // Catch: Throwable -> L29
        Handler r15 = this.handler;     // Catch: Throwable -> L29
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L29
    L26:
        r15.removeCallbacks(this.batchCallbackRunnable);     // Catch: Throwable -> L29
        postBatchCallback(BDLocationConfig.getFusionLocationSensorBatchPushIntervalMs());     // Catch: Throwable -> L29
        monitor-exit(this);
    }

    public final synchronized void stop() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.started == true) goto L12;
        Handler r0 = this.handler;     // Catch: Throwable -> L21
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L21
    L8:
        r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L21
        resetSamples();     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L12:
        this.started = false;     // Catch: Throwable -> L21
        this.tEndMs = System.currentTimeMillis();     // Catch: Throwable -> L21
        Handler r1 = this.handler;     // Catch: Throwable -> L21
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L21
    L15:
        r1.removeCallbacks(this.batchCallbackRunnable);     // Catch: Throwable -> L21
        this.gpsCollector.stop();     // Catch: Throwable -> L21
        this.headingCollector.stop();     // Catch: Throwable -> L21
        this.imuCollector.stop();     // Catch: Throwable -> L21
        Handler r2 = this.handler;     // Catch: Throwable -> L21
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("handler");     // Catch: Throwable -> L21
    L18:
        r2.removeCallbacksAndMessages(null);     // Catch: Throwable -> L21
        resetSamples();     // Catch: Throwable -> L21
        monitor-exit(this);
    }

    private final synchronized SensorBatch buildAndResetBatch() {
        monitor-enter(this);
        long r3 = this.tBeginMs;     // Catch: Throwable -> L7
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L7
        WalkingCyclingNavigationHint r0 = this.latestNavigationHint;     // Catch: Throwable -> L7
        SensorBatch r19 = new SensorBatch(r3, r9, buildImuStruct(drainQueue(this.accelerometerSamples), drainQueue(this.gyroscopeSamples), drainQueue(this.magnetometerSamples)), ensureGpsTimestampAfterBatchBegin(this.latestGps, r3), this.latestSensorHeading, this.latestMagneticDeclination, null, null, null, null, null, null, -1, r0);     // Catch: Throwable -> L7
        this.latestGps = null;     // Catch: Throwable -> L7
        this.latestNavigationHint = null;     // Catch: Throwable -> L7
        this.tBeginMs = r9;     // Catch: Throwable -> L7
        this.tEndMs = r9;     // Catch: Throwable -> L7
        monitor-exit(this);
        return r19;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean hasFineLocationPermission() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L8:
        return true;
    L5:
        if (com_bytedance_bdlocation_sensor_SensorBatchAtomicCollector_android_content_Context_checkSelfPermission(this.context.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) goto L8;
        return false;
    }

    private final void resetSamples() {
        this.accelerometerSamples.clear();
        this.gyroscopeSamples.clear();
        this.magnetometerSamples.clear();
        this.latestGps = null;
        this.latestSensorHeading = 0.0f;
        this.latestMagneticDeclination = -6.0f;
        this.latestNavigationHint = null;
    }

    private final void emitCurrentBatch() {
        SensorBatch r0 = buildAndResetBatch();     // Catch: Throwable -> L6
        SensorBatchAtomicCallback r1 = this.callback;     // Catch: Throwable -> L6
        if (r1 == null) goto L11;
        r1.onSensorBatch(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        Logger.e(TAG, "emitCurrentBatch failed", th);
    }

    private final void postNextBatchCallback() {
        postBatchCallback(BDLocationConfig.getFusionLocationSensorBatchPushIntervalMs());
    }

    public final float getLatestMagneticDeclination() {
        return this.latestMagneticDeclination;
    }

    public final boolean isStarted() {
        return this.started;
    }

    public static final /* synthetic */ void access$emitCurrentBatch(SensorBatchAtomicCollector r0) {
        r0.emitCurrentBatch();
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getAccelerometerSamples$p(SensorBatchAtomicCollector r0) {
        return r0.accelerometerSamples;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getGyroscopeSamples$p(SensorBatchAtomicCollector r0) {
        return r0.gyroscopeSamples;
    }

    public static final /* synthetic */ float access$getLatestSensorHeading$p(SensorBatchAtomicCollector r0) {
        return r0.latestSensorHeading;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getMagnetometerSamples$p(SensorBatchAtomicCollector r0) {
        return r0.magnetometerSamples;
    }

    public static final /* synthetic */ boolean access$getStarted$p(SensorBatchAtomicCollector r0) {
        return r0.started;
    }

    public static final /* synthetic */ boolean access$hasFineLocationPermission(SensorBatchAtomicCollector r0) {
        return r0.hasFineLocationPermission();
    }

    public static final /* synthetic */ void access$postNextBatchCallback(SensorBatchAtomicCollector r0) {
        r0.postNextBatchCallback();
    }

    private final <T> List<T> drainQueue(ConcurrentLinkedQueue<T> r3) {
        ArrayList r0 = new ArrayList();
    L3:
        T r1 = r3.poll();
        if (r1 == null) goto L6;
        r0.add(r1);
        goto L3
    L6:
        return r0;
    }

    private final void postBatchCallback(long r3) {
        Handler r0 = this.handler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        r0.postDelayed(this.batchCallbackRunnable, r3);
    }

    private final SensorBatch.AxisSamples toAxisSamples(List<AxisSample> r7) {
        List<AxisSample> r8 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(Long.valueOf(((AxisSample) r2.next()).getTimestampMs()));
        goto L4
    L6:
        long[] r1 = CollectionsKt.toLongArray(r0);
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r4 = r8.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(Float.valueOf(((AxisSample) r4.next()).getX()));
        goto L8
    L10:
        float[] r5 = CollectionsKt.toFloatArray(r3);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        r6.add(Float.valueOf(((AxisSample) r9.next()).getY()));
        goto L12
    L14:
        float[] r10 = CollectionsKt.toFloatArray(r6);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r12 = r8.iterator();
    L16:
        if (r12.hasNext() == false) goto L19;
        r11.add(Float.valueOf(((AxisSample) r12.next()).getZ()));
        goto L16
    L19:
        return new SensorBatch.AxisSamples(r1, r5, r10, CollectionsKt.toFloatArray(r11));
    }

    public final synchronized void updateCallback(SensorBatchAtomicCallback r1) {
        monitor-enter(this);
        this.callback = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$setLatestSensorHeading$p(SensorBatchAtomicCollector r0, float r1) {
        r0.latestSensorHeading = r1;
    }

    public static final /* synthetic */ void access$setStarted$p(SensorBatchAtomicCollector r0, boolean r1) {
        r0.started = r1;
    }

    private final synchronized <T> void appendSample(ConcurrentLinkedQueue<T> r1, T r2) {
        monitor-enter(this);
        r1.offer(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static int com_bytedance_bdlocation_sensor_SensorBatchAtomicCollector_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_bytedance_bdlocation_sensor_SensorBatchAtomicCollector_android_content_Context_checkSelfPermission");
        a r2 = (a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private final SensorBatch.GpsStruct ensureGpsTimestampAfterBatchBegin(SensorBatch.GpsStruct r20, long r21) {
        if (r20 != null) goto L6;
        return null;
    L6:
        long r1 = r20.timestampMs;
        if (r1 > 0) goto L9;
    L13:
        return r20;
    L9:
        if (r1 > r21) goto L13;
        return new SensorBatch.GpsStruct(r20.locationTimestampMs, r21 + 1, r20.lat, r20.lon, r20.locationAccuracy, r20.speed, r20.speedAccuracy, r20.bearing, r20.bearingAccuracy, r20.sourceType);
    }

    private final synchronized void updateLatestGps(SensorBatch.GpsStruct r4, float r5) {
        monitor-enter(this);
        this.latestGps = r4;     // Catch: Throwable -> L6
        this.latestMagneticDeclination = SensorBatchValueUtils.finiteFloat$default(SensorBatchValueUtils.INSTANCE, r5, 0.0f, 2, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void updateNavigationHint(int r6, float r7) {
        monitor-enter(this);
        this.latestNavigationHint = new WalkingCyclingNavigationHint(true, r6, SensorBatchValueUtils.finiteFloat$default(SensorBatchValueUtils.INSTANCE, r7, 0.0f, 2, null));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r11v6, types: [com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector$batchCallbackRunnable$1] */
    public SensorBatchAtomicCollector(Context r10, Object r11, SensorBatchAtomicCallback r12) {
        this.context = r10;
        this.bpeaCert = r11;
        this.callback = r12;
        Object r13 = r10.getApplicationContext().getSystemService("sensor");
        Object r0 = null;
        if ((r13 instanceof SensorManager) == true) goto L5;
        r13 = null;
    L5:
        SensorManager r14 = (SensorManager) r13;
        this.sensorManager = r14;
        Object r15 = r10.getApplicationContext().getSystemService(LocationMonitorConst.LOCATION);
        if ((r15 instanceof LocationManager) == false) goto L9;
        r0 = r15;
    L9:
        LocationManager r2 = (LocationManager) r0;
        this.locationManager = r2;
        PthreadHandlerThreadV2 r16 = new PthreadHandlerThreadV2("bdlocation-continuous-sensor-batch");
        this.workerThread = r16;
        this.accelerometerSamples = new ConcurrentLinkedQueue();
        this.gyroscopeSamples = new ConcurrentLinkedQueue();
        this.magnetometerSamples = new ConcurrentLinkedQueue();
        this.latestMagneticDeclination = -6.0f;
        this.imuCollector = new SensorBatchImuCollector(r14, new SensorBatchAtomicCollector$imuCollector$1(this));
        this.headingCollector = new SensorBatchHeadingCollector(r14, new SensorBatchAtomicCollector$headingCollector$1(this), new SensorBatchAtomicCollector$headingCollector$2(this));
        this.gpsCollector = new SensorBatchGpsCollector(r2, new SensorBatchAtomicCollector$gpsCollector$1(this), new SensorBatchAtomicCollector$gpsCollector$2(this), 0, 8, null);
        this.batchCallbackRunnable = new SensorBatchAtomicCollector$batchCallbackRunnable$1(this);
        ThreadMethodProxy.start(r16);
        this.handler = new Handler(r16.getLooper());
    }

    public static final /* synthetic */ void access$appendSample(SensorBatchAtomicCollector r0, ConcurrentLinkedQueue r1, Object r2) {
        r0.appendSample(r1, r2);
    }

    public static final /* synthetic */ void access$updateLatestGps(SensorBatchAtomicCollector r0, SensorBatch.GpsStruct r1, float r2) {
        r0.updateLatestGps(r1, r2);
    }

    private final SensorBatch.ImuStruct buildImuStruct(List<AxisSample> r4, List<AxisSample> r5, List<AxisSample> r6) {
        SensorBatchAxisSampleLimiter r1 = SensorBatchAxisSampleLimiter.INSTANCE;
        return new SensorBatch.ImuStruct(toAxisSamples(r1.limitByConfig(r4, BDLocationConfig.getFusionLocationAccelerometerIntervalUs())), toAxisSamples(r1.limitByConfig(r5, BDLocationConfig.getFusionLocationGyroscopeIntervalUs())), toAxisSamples(r6));
    }

    public /* synthetic */ SensorBatchAtomicCollector(Context r2, Object r3, SensorBatchAtomicCallback r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
