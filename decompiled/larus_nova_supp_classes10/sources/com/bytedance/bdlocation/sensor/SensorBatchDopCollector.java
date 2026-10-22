package com.bytedance.bdlocation.sensor;

import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchDopCollector;", "", "locationManager", "Landroid/location/LocationManager;", "hasFineLocationPermission", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchDopCallback;", "(Landroid/location/LocationManager;Lkotlin/jvm/functions/Function0;Lcom/bytedance/bdlocation/sensor/SensorBatchDopCallback;)V", "dopIntervalMs", "", "lastEmitElapsedMs", "nmeaListener", "Landroid/location/OnNmeaMessageListener;", "collectNmea", "", "nmea", "", "nmeaTimestamp", "normalizeIntervalMs", "intervalMs", "parseDopValue", "", "value", "parseGsaDop", "", "start", "handler", "Landroid/os/Handler;", "bpeaCert", "stop", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchDopCollector {
    public static final Companion Companion = null;
    public static final long DEFAULT_DOP_INTERVAL_MS = 1000;
    public static final String TAG = "SSS-DopCollector";
    private final SensorBatchDopCallback callback;
    private long dopIntervalMs;
    private final Function0<Boolean> hasFineLocationPermission;
    private long lastEmitElapsedMs;
    private final LocationManager locationManager;
    private final OnNmeaMessageListener nmeaListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchDopCollector$Companion;", "", "()V", "DEFAULT_DOP_INTERVAL_MS", "", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
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

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    private final long normalizeIntervalMs(long r4) {
        if (r4 > 0) goto L6;
        return 1000;
    L6:
        return r4;
    }

    public final void stop() {
        Logger.i(TAG, "stop");
        LocationManager r0 = this.locationManager;
        if (r0 != null) goto L22;
        Logger.w(TAG, "stop: locationManager is null");
        this.lastEmitElapsedMs = 0;
        return;
    L22:
    L12:
        e = move-exception;
        Logger.e(TAG, "stop: unregister nmea failed", e);     // Catch: Throwable -> L10
    L9:
        this.lastEmitElapsedMs = 0;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (this.nmeaListener == null) goto L9;
        BDLocationExtrasService.getBPEAManager().removeNmeaListener(r0, this.nmeaListener);     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        this.lastEmitElapsedMs = 0;
        throw th;
    }

    private final float parseDopValue(String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L18;
        return 0.0f;
    L18:
        SensorBatchValueUtils r1 = SensorBatchValueUtils.INSTANCE;     // Catch: NumberFormatException -> L17
        if (r5 == null) goto L15;
        return SensorBatchValueUtils.finiteFloat$default(r1, CastFloatProtector.parseFloat(StringsKt.trim(r5).toString()), 0.0f, 2, null);
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: NumberFormatException -> L17
    L19:
        return 0.0f;
    L4:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r0 = false;
        goto L9
    }

    private final float[] parseGsaDop(String r10) {
        List r11 = StringsKt.split$default((String) ListProtector.get(StringsKt.split$default(r10, new String[]{"*"}, false, 0, 6, null), 0), new String[]{","}, false, 0, 6, null);
        if (r11.size() >= 4) goto L5;
        return null;
    L5:
        float r1 = parseDopValue((String) ListProtector.get(r11, r11.size() - 3));
        float r4 = parseDopValue((String) ListProtector.get(r11, r11.size() - 2));
        float r12 = parseDopValue((String) ListProtector.get(r11, r11.size() - 1));
        if (r1 > 0.0f) goto L12;
        if (r4 > 0.0f) goto L12;
        if (r12 > 0.0f) goto L12;
        return null;
    L12:
        return new float[]{r1, r4, r12};
    }

    private final void collectNmea(String r19, long r20) {
        if (r19 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        int r2 = StringsKt.indexOf$default(r19, ",", 0, false, 6, null);
        if (r2 < 0) goto L17;
        if (r19 == null) goto L16;
        String r3 = r19.substring(0, r2);
    L19:
        if (StringsKt.endsWith$default(r3, "GSA", false, 2, null) == true) goto L21;
        return;
    L21:
        long r4 = SystemClock.elapsedRealtime();
        long r5 = this.lastEmitElapsedMs;
        if (r5 > 0) goto L24;
    L26:
        float[] r6 = parseGsaDop(r19);
        if (r6 == null) goto L34;
        this.lastEmitElapsedMs = r4;
        if (r20 <= 0) goto L31;
        long r13 = r20;
    L32:
        DopSample r7 = new DopSample(r13, r6[0], r6[1], r6[2]);
        Logger.d(TAG, "collectNmea: pdop=" + r7.getPdop() + ", hdop=" + r7.getHdop() + ", vdop=" + r7.getVdop());
        this.callback.onDopSample(r7);
        return;
    L31:
        r13 = System.currentTimeMillis();
        goto L32
    L34:
        Logger.d(TAG, "collectNmea: skip invalid GSA nmea=" + r19);
        return;
    L24:
        if ((r4 - r5) >= this.dopIntervalMs) goto L26;
        return;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L17:
        r3 = r19;
        goto L19
    L5:
        if (r19.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public SensorBatchDopCollector(LocationManager r1, Function0<Boolean> r2, SensorBatchDopCallback r3) {
        this.locationManager = r1;
        this.hasFineLocationPermission = r2;
        this.callback = r3;
        this.dopIntervalMs = 1000;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        OnNmeaMessageListener r4 = new SensorBatchDopCollector$nmeaListener$1(this);
    L6:
        this.nmeaListener = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ void access$collectNmea(SensorBatchDopCollector r0, String r1, long r2) {
        r0.collectNmea(r1, r2);
    }

    public final void start(long r5, Handler r7, Object r8) {
        boolean r1 = ((Boolean) this.hasFineLocationPermission.invoke()).booleanValue();
        this.dopIntervalMs = normalizeIntervalMs(r5);
        this.lastEmitElapsedMs = 0;
        StringBuilder r6 = new StringBuilder("start: sdk=");
        int r9 = Build.VERSION.SDK_INT;
        r6.append(r9);
        r6.append(", hasFineLocationPermission=");
        r6.append(r1);
        r6.append(", dopIntervalMs=");
        r6.append(this.dopIntervalMs);
        Logger.i(TAG, r6.toString());
        if (r9 >= 24) goto L5;
    L19:
        Logger.w(TAG, "start: NMEA listener requires Android N or above");
        return;
    L5:
        if (this.nmeaListener == null) goto L19;
        if (r1 == true) goto L10;
        Logger.w(TAG, "start: missing ACCESS_FINE_LOCATION");
        return;
    L10:
        LocationManager r10 = this.locationManager;
        if (r10 != null) goto L21;
        Logger.w(TAG, "start: locationManager is null");
        return;
    L21:
        Logger.i(TAG, "start: gpsProviderEnabled=" + r10.isProviderEnabled("gps"));     // Catch: Exception -> L14
        BDLocationExtrasService.getBPEAManager().addNmeaListener(r10, this.nmeaListener, r7, r8);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e(TAG, "start: register nmea failed", e);
    }
}
