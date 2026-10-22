package com.bytedance.bdlocation.sensor;

import android.hardware.GeomagneticField;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import fna.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import nna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\r\u0018\u0018\u0000 72\u00020\u0001:\u00017B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nH\u0002J:\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0003J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\nH\u0002J\"\u00103\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u00104\u001a\u00020\u001dH\u0007J\u0018\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCollector;", "", "locationManager", "Landroid/location/LocationManager;", "hasFineLocationPermission", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCallback;", "networkFallbackTimeoutMs", "", "(Landroid/location/LocationManager;Lkotlin/jvm/functions/Function0;Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCallback;J)V", "gpsLocationListener", "com/bytedance/bdlocation/sensor/SensorBatchGpsCollector$gpsLocationListener$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCollector$gpsLocationListener$1;", "handler", "Landroid/os/Handler;", "hasDeliveredFirstLocation", "lastGpsCallbackElapsedMs", "latestNetworkLocation", "Landroid/location/Location;", "networkFallbackRunnable", "Ljava/lang/Runnable;", "networkLocationListener", "com/bytedance/bdlocation/sensor/SensorBatchGpsCollector$networkLocationListener$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCollector$networkLocationListener$1;", "networkLocationReturnable", "started", "emitGpsSample", "", LocationMonitorConst.LOCATION, "sourceType", "", "emitNetworkLocationIfAllowed", "nowElapsedMs", "ensureGcj02Location", "getMagneticDeclination", "", "gpsSilentDurationMs", "handleGpsLocation", "handleNetworkLocation", "isNetworkFallbackAllowed", "registerProvider", "manager", "provider", "", "gpsIntervalMs", "listener", "Landroid/location/LocationListener;", "bpeaCert", "scheduleNetworkFallbackIfNeeded", "start", "stop", "toGpsStruct", "Lcom/bytedance/bdlocation/bridge/SensorBatch$GpsStruct;", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchGpsCollector {
    public static final Companion Companion = null;
    public static final long DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS = 2000;
    public static final String TAG = "SSS-GpsCollector";
    private final SensorBatchGpsCallback callback;
    private final SensorBatchGpsCollector$gpsLocationListener$1 gpsLocationListener;
    private Handler handler;
    private boolean hasDeliveredFirstLocation;
    private final Function0<Boolean> hasFineLocationPermission;
    private long lastGpsCallbackElapsedMs;
    private Location latestNetworkLocation;
    private final LocationManager locationManager;
    private final Runnable networkFallbackRunnable;
    private final long networkFallbackTimeoutMs;
    private final SensorBatchGpsCollector$networkLocationListener$1 networkLocationListener;
    private boolean networkLocationReturnable;
    private boolean started;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGpsCollector$Companion;", "", "()V", "DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS", "", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final synchronized void stop() {
        monitor-enter(this);
        Logger.i(TAG, "stop");     // Catch: Throwable -> L18
        this.started = false;     // Catch: Throwable -> L18
        Handler r1 = this.handler;     // Catch: Throwable -> L18
        if (r1 == null) goto L6;
        r1.removeCallbacks(this.networkFallbackRunnable);     // Catch: Throwable -> L18
    L6:
        this.handler = null;     // Catch: Throwable -> L18
        this.hasDeliveredFirstLocation = false;     // Catch: Throwable -> L18
        this.lastGpsCallbackElapsedMs = 0;     // Catch: Throwable -> L18
        this.latestNetworkLocation = null;     // Catch: Throwable -> L18
        this.networkLocationReturnable = false;     // Catch: Throwable -> L18
        LocationManager r0 = this.locationManager;     // Catch: Exception -> L14 Throwable -> L18
        if (r0 == null) goto L10;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchGpsCollector_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(r0, this.gpsLocationListener);     // Catch: Exception -> L14 Throwable -> L18
    L10:
        LocationManager r2 = this.locationManager;     // Catch: Exception -> L14 Throwable -> L18
        if (r2 == null) goto L16;
        INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchGpsCollector_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(r2, this.networkLocationListener);     // Catch: Exception -> L14 Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L14:
        e = move-exception;
        Logger.e(TAG, "stop: removeUpdates failed", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private final synchronized boolean emitNetworkLocationIfAllowed(long r5) {
        monitor-enter(this);
        Location r1 = this.latestNetworkLocation;     // Catch: Throwable -> L22
        if (r1 != null) goto L7;
        monitor-exit(this);
        return false;
    L7:
        if (this.networkLocationReturnable == true) goto L9;
    L18:
        monitor-exit(this);
        return false;
    L9:
        if (isNetworkFallbackAllowed(r5) == false) goto L18;
        this.latestNetworkLocation = null;     // Catch: Throwable -> L22
        this.networkLocationReturnable = false;     // Catch: Throwable -> L22
        Handler r2 = this.handler;     // Catch: Throwable -> L22
        if (r2 == null) goto L14;
        r2.removeCallbacks(this.networkFallbackRunnable);     // Catch: Throwable -> L22
    L14:
        Logger.d(TAG, "emitNetworkLocationIfAllowed: callback NETWORK after gps silent " + gpsSilentDurationMs(r5) + "ms");     // Catch: Throwable -> L22
        emitGpsSample(r1, 4);     // Catch: Throwable -> L22
        monitor-exit(this);
        return true;
    L22:
        th = move-exception;
        throw th;
    }

    private final Location ensureGcj02Location(Location r8) {
        Bundle r0 = r8.getExtras();
        if (r0 == null) goto L7;
        String r1 = r0.getString("coordinateSystem");
        if (r1 == null) goto L7;
    L11:
        Location r2 = new Location(r8);
        if (StringsKt.equals(LocationInfoConst.GCJ_O2, r1, true) == false) goto L15;
        return r2;
    L15:
        if (r1 == null) goto L17;
        String r4 = r1;
    L26:
        boolean r5 = LocationUtil.convertLocationToGCJ_O2(r2, r4);     // Catch: Throwable -> L20
    L22:
        if (r5 == false) goto L24;
        Logger.d(TAG, "ensureGcj02Location: converted provider=" + r8.getProvider() + ", coordinateSystem=" + r1);
    L25:
        return r2;
    L24:
        Logger.w(TAG, "ensureGcj02Location: convert GCJ02 failed or skipped, provider=" + r8.getProvider() + ", coordinateSystem=" + r1);
    L20:
        th = move-exception;
        Logger.e(TAG, "ensureGcj02Location: convert GCJ02 exception, provider=" + r8.getProvider() + ", coordinateSystem=" + r1, th);
        r5 = false;
        goto L22
    L17:
        r4 = LocationInfoConst.WGS_84;
    L7:
        Bundle r3 = r8.getExtras();
        if (r3 == null) goto L10;
        r1 = r3.getString("coordType");
        goto L11
    L10:
        r1 = null;
        goto L11
    }

    private final float getMagneticDeclination(Location r9) {
    L12:
        th = move-exception;
        Logger.w(TAG, "getMagneticDeclination failed, provider=" + r9.getProvider(), th);
        return -6.0f;
    L3:
        if (r9.getTime() <= 0) goto L5;
        long r0 = r9.getTime();     // Catch: Throwable -> L12
    L6:
        long r6 = r0;
        float r3 = (float) r9.getLatitude();     // Catch: Throwable -> L12
        float r4 = (float) r9.getLongitude();     // Catch: Throwable -> L12
        if (r9.hasAltitude() == false) goto L9;
        float r5 = (float) r9.getAltitude();     // Catch: Throwable -> L12
    L10:
        return new GeomagneticField(r3, r4, r5, r6).getDeclination();
    L9:
        r5 = 0.0f;
        goto L10
    L5:
        r0 = System.currentTimeMillis();     // Catch: Throwable -> L12
        goto L6
    }

    private final long gpsSilentDurationMs(long r3) {
        return r3 - this.lastGpsCallbackElapsedMs;
    }

    private final synchronized void handleGpsLocation(Location r4) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.started == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.lastGpsCallbackElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        this.latestNetworkLocation = null;     // Catch: Throwable -> L13
        this.networkLocationReturnable = false;     // Catch: Throwable -> L13
        Handler r0 = this.handler;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        r0.removeCallbacks(this.networkFallbackRunnable);     // Catch: Throwable -> L13
    L10:
        this.hasDeliveredFirstLocation = true;     // Catch: Throwable -> L13
        Logger.d(TAG, "handleGpsLocation: callback GPS");     // Catch: Throwable -> L13
        emitGpsSample(r4, 1);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private final synchronized void handleNetworkLocation(Location r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.started == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.hasDeliveredFirstLocation == true) goto L12;
        this.hasDeliveredFirstLocation = true;     // Catch: Throwable -> L17
        this.latestNetworkLocation = null;     // Catch: Throwable -> L17
        this.networkLocationReturnable = false;     // Catch: Throwable -> L17
        Logger.d(TAG, "handleNetworkLocation: first callback NETWORK");     // Catch: Throwable -> L17
        emitGpsSample(r3, 4);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L12:
        this.latestNetworkLocation = new Location(r3);     // Catch: Throwable -> L17
        this.networkLocationReturnable = true;     // Catch: Throwable -> L17
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        if (emitNetworkLocationIfAllowed(r0) == true) goto L15;
        scheduleNetworkFallbackIfNeeded(r0);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    private final boolean isNetworkFallbackAllowed(long r4) {
        if (gpsSilentDurationMs(r4) < this.networkFallbackTimeoutMs) goto L5;
        return true;
    L5:
        return false;
    }

    private final synchronized void scheduleNetworkFallbackIfNeeded(long r5) {
        monitor-enter(this);
        Handler r1 = this.handler;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.removeCallbacks(this.networkFallbackRunnable);     // Catch: Throwable -> L11
        long r6 = RangesKt.coerceAtLeast(this.networkFallbackTimeoutMs - gpsSilentDurationMs(r5), 0);     // Catch: Throwable -> L11
        r1.postDelayed(this.networkFallbackRunnable, r6);     // Catch: Throwable -> L11
        Logger.d(TAG, "scheduleNetworkFallbackIfNeeded: delayMs=" + r6);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_sensor_SensorBatchGpsCollector_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(LocationManager r1, LocationListener r2) {
        if (g.d() == true) goto L6;
        r1.removeUpdates(r2);
        return;
    L6:
        r1.removeUpdates(r2);
        a.a(r2.hashCode());
    }

    public static final /* synthetic */ boolean access$emitNetworkLocationIfAllowed(SensorBatchGpsCollector r0, long r1) {
        return r0.emitNetworkLocationIfAllowed(r1);
    }

    public static final /* synthetic */ void access$handleGpsLocation(SensorBatchGpsCollector r0, Location r1) {
        r0.handleGpsLocation(r1);
    }

    public static final /* synthetic */ void access$handleNetworkLocation(SensorBatchGpsCollector r0, Location r1) {
        r0.handleNetworkLocation(r1);
    }

    private final void emitGpsSample(Location r4, int r5) {
        this.callback.onGpsSample(toGpsStruct(r4, r5), getMagneticDeclination(r4));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.e(TAG, "emitGpsSample failed, provider=" + r4.getProvider() + ", sourceType=" + r5, th);
    }

    private final SensorBatch.GpsStruct toGpsStruct(Location r21, int r22) {
        Location r0 = ensureGcj02Location(r21);
        long r2 = r21.getTime();
        long r4 = System.currentTimeMillis();
        SensorBatchValueUtils r1 = SensorBatchValueUtils.INSTANCE;
        double r13 = SensorBatchValueUtils.finiteDouble$default(r1, r0.getLatitude(), 0.0d, 2, null);
        double r8 = SensorBatchValueUtils.finiteDouble$default(r1, r0.getLongitude(), 0.0d, 2, null);
        if (r0.hasAccuracy() == false) goto L5;
        float r12 = SensorBatchValueUtils.finiteFloat$default(r1, r0.getAccuracy(), 0.0f, 2, null);
    L7:
        if (r0.hasSpeed() == false) goto L9;
        float r15 = SensorBatchValueUtils.finiteFloat$default(r1, r0.getSpeed(), 0.0f, 2, null);
    L10:
        int r6 = Build.VERSION.SDK_INT;
        if (r6 >= 26) goto L13;
    L15:
        Object r16 = null;
        float r19 = 0.0f;
    L17:
        if (r0.hasBearing() == false) goto L19;
        float r17 = SensorBatchValueUtils.finiteFloat$default(r1, r0.getBearing(), 0.0f, 2, r16);
        int r7 = 26;
    L20:
        if (r6 >= r7) goto L22;
    L24:
        float r3 = 0.0f;
    L26:
        return new SensorBatch.GpsStruct(r2, r4, r13, r8, r12, r15, r19, r17, r3, r22);
    L22:
        if (r0.hasBearingAccuracy() == false) goto L24;
        r3 = SensorBatchValueUtils.finiteFloat$default(r1, r0.getBearingAccuracyDegrees(), 0.0f, 2, r16);
        goto L26
    L19:
        r7 = 26;
        r17 = 0.0f;
        goto L20
    L13:
        if (r0.hasSpeedAccuracy() == false) goto L15;
        r16 = null;
        r19 = SensorBatchValueUtils.finiteFloat$default(r1, r0.getSpeedAccuracyMetersPerSecond(), 0.0f, 2, null);
        goto L17
    L9:
        r15 = 0.0f;
        goto L10
    L5:
        r12 = 0.0f;
        goto L7
    }

    public final synchronized void start(long r10, Handler r12, Object r13) {
        monitor-enter(this);
        boolean r1 = ((Boolean) this.hasFineLocationPermission.invoke()).booleanValue();     // Catch: Throwable -> L21
        Logger.i(TAG, "start: hasFineLocationPermission=" + r1 + ", gpsIntervalMs=" + r10 + ", networkFallbackTimeoutMs=" + this.networkFallbackTimeoutMs);     // Catch: Throwable -> L21
        if (r1 == true) goto L9;
        Logger.w(TAG, "start: missing ACCESS_FINE_LOCATION");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L9:
        LocationManager r8 = this.locationManager;     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        this.handler = r12;     // Catch: Throwable -> L21
        this.started = true;     // Catch: Throwable -> L21
        this.hasDeliveredFirstLocation = false;     // Catch: Throwable -> L21
        this.lastGpsCallbackElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L21
        this.latestNetworkLocation = null;     // Catch: Throwable -> L21
        this.networkLocationReturnable = false;     // Catch: Throwable -> L21
        registerProvider(r8, "gps", r10, r12, this.gpsLocationListener, r13);     // Catch: Exception -> L14 Throwable -> L21
        registerProvider(r8, "network", r10, r12, this.networkLocationListener, r13);     // Catch: Exception -> L14 Throwable -> L21
    L16:
        monitor-exit(this);
        return;
    L14:
        e = move-exception;
        Logger.e(TAG, "start: requestLocationUpdates failed", e);     // Catch: Throwable -> L21
        goto L16
    L18:
        Logger.w(TAG, "start: locationManager is null");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.bdlocation.sensor.SensorBatchGpsCollector$gpsLocationListener$1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.bdlocation.sensor.SensorBatchGpsCollector$networkLocationListener$1] */
    public SensorBatchGpsCollector(LocationManager r1, Function0<Boolean> r2, SensorBatchGpsCallback r3, long r4) {
        this.locationManager = r1;
        this.hasFineLocationPermission = r2;
        this.callback = r3;
        if (r4 >= 0) goto L5;
        r4 = DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
    L5:
        this.networkFallbackTimeoutMs = r4;
        this.gpsLocationListener = new SensorBatchGpsCollector$gpsLocationListener$1(this);
        this.networkLocationListener = new SensorBatchGpsCollector$networkLocationListener$1(this);
        this.networkFallbackRunnable = new SensorBatchGpsCollector$networkFallbackRunnable$1(this);
    }

    public /* synthetic */ SensorBatchGpsCollector(LocationManager r7, Function0 r8, SensorBatchGpsCallback r9, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS;
    L5:
        this(r7, r8, r9, r10);
    }

    private final void registerProvider(LocationManager r13, String r14, long r15, Handler r17, LocationListener r18, Object r19) {
        boolean r2 = r13.isProviderEnabled(r14);     // Catch: Exception -> L8
        Logger.i(TAG, "start: provider=" + r14 + ", enabled=" + r2);     // Catch: Exception -> L8
        if (r2 == true) goto L6;
        return;
    L6:
        BDLocationExtrasService.getBPEAManager().requestLocationUpdates(r13, r14, r15, 0.0f, r18, r17.getLooper(), r19);     // Catch: Exception -> L8
        Logger.i(TAG, "start: requestLocationUpdates called, provider=" + r14);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Logger.e(TAG, "start: requestLocationUpdates failed, provider=" + r14, e);
    }
}
