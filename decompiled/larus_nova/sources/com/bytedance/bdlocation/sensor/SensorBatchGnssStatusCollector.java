package com.bytedance.bdlocation.sensor;

import android.location.GnssStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0007J\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGnssStatusCollector;", "", "locationManager", "Landroid/location/LocationManager;", "hasFineLocationPermission", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchGnssStatusCallback;", "(Landroid/location/LocationManager;Lkotlin/jvm/functions/Function0;Lcom/bytedance/bdlocation/sensor/SensorBatchGnssStatusCallback;)V", "gnssStatusCallback", "com/bytedance/bdlocation/sensor/SensorBatchGnssStatusCollector$gnssStatusCallback$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchGnssStatusCollector$gnssStatusCallback$1;", "lastSatelliteInfoEmitElapsedMs", "", "satelliteInfoIntervalMs", "collectGnssStatus", "", "status", "Landroid/location/GnssStatus;", "normalizeIntervalMs", "intervalMs", "readSatelliteCount", "", "start", "bpeaCert", "stop", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchGnssStatusCollector {
    public static final Companion Companion = null;
    public static final int DEFAULT_SATELLITE_COUNT = -1;
    public static final long DEFAULT_SATELLITE_INFO_INTERVAL_MS = 1000;
    public static final String TAG = "SSS-GnssStatusCollector";
    private final SensorBatchGnssStatusCallback callback;
    private final SensorBatchGnssStatusCollector$gnssStatusCallback$1 gnssStatusCallback;
    private final Function0<Boolean> hasFineLocationPermission;
    private long lastSatelliteInfoEmitElapsedMs;
    private final LocationManager locationManager;
    private long satelliteInfoIntervalMs;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGnssStatusCollector$Companion;", "", "()V", "DEFAULT_SATELLITE_COUNT", "", "DEFAULT_SATELLITE_INFO_INTERVAL_MS", "", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    private final long normalizeIntervalMs(long r100) {
        if (r100 > 0) goto L6;
        return 1000;
    L6:
        return r100;
    }

    public final void stop() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "stop"
            java.lang.String r1 = "SSS-GnssStatusCollector"
            com.bytedance.bdlocation.log.Logger.i(r1, r0)
            android.location.LocationManager r0 = r6.locationManager
            r2 = 0
            if (r0 == 0) goto L2a
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r5 = 24
            if (r4 < r5) goto L1a
            com.bytedance.bdlocation.sensor.SensorBatchGnssStatusCollector$gnssStatusCallback$1 r4 = r6.gnssStatusCallback     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            if (r4 == 0) goto L1a
            r0.unregisterGnssStatusCallback(r4)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
        L1a:
            r6.lastSatelliteInfoEmitElapsedMs = r2
            goto L26
        L1d:
            r0 = move-exception
            goto L27
        L1f:
            r0 = move-exception
            java.lang.String r4 = "stop: unregister gnss status failed"
            com.bytedance.bdlocation.log.Logger.e(r1, r4, r0)     // Catch: java.lang.Throwable -> L1d
            goto L1a
        L26:
            return
        L27:
            r6.lastSatelliteInfoEmitElapsedMs = r2
            throw r0
        L2a:
            java.lang.String r0 = "stop: locationManager is null"
            com.bytedance.bdlocation.log.Logger.w(r1, r0)
            r6.lastSatelliteInfoEmitElapsedMs = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdlocation.sensor.SensorBatchGnssStatusCollector.stop():void");
    }

    private final void collectGnssStatus(GnssStatus r100) {
        long r101 = SystemClock.elapsedRealtime();
        long r102 = this.lastSatelliteInfoEmitElapsedMs;
        if (r102 > 0) goto L5;
    L7:
        this.lastSatelliteInfoEmitElapsedMs = r101;
        this.callback.onGnssVisibleSatelliteCount(readSatelliteCount(r100));
        return;
    L5:
        if ((r101 - r102) >= this.satelliteInfoIntervalMs) goto L7;
    }

    private final int readSatelliteCount(GnssStatus r100) {
        if (r100 != null) goto L12;
        int r101 = -1;
    L9:
        if (r101 >= 0) goto L11;
        return -1;
    L11:
        return r101;
    L12:
        r101 = r100.getSatelliteCount();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Logger.e(TAG, "readSatelliteCount failed", th);
        return -1;
    }

    public static final /* synthetic */ void access$collectGnssStatus(SensorBatchGnssStatusCollector r100, GnssStatus r101) {
        r100.collectGnssStatus(r101);
    }

    public final void start(long r100, Object r101) {
        boolean r102 = this.hasFineLocationPermission.invoke().booleanValue();
        this.satelliteInfoIntervalMs = normalizeIntervalMs(r100);
        this.lastSatelliteInfoEmitElapsedMs = 0;
        StringBuilder r103 = new StringBuilder("start: sdk=");
        int r104 = Build.VERSION.SDK_INT;
        r103.append(r104);
        r103.append(", hasFineLocationPermission=");
        r103.append(r102);
        r103.append(", satelliteInfoIntervalMs=");
        r103.append(this.satelliteInfoIntervalMs);
        Logger.i(TAG, r103.toString());
        if (r104 >= 24) goto L5;
    L19:
        Logger.w(TAG, "start: GnssStatus requires Android N or above");
        return;
    L5:
        if (this.gnssStatusCallback == null) goto L19;
        if (r102 == true) goto L10;
        Logger.w(TAG, "start: missing ACCESS_FINE_LOCATION");
        return;
    L10:
        LocationManager r105 = this.locationManager;
        if (r105 != null) goto L21;
        Logger.w(TAG, "start: locationManager is null");
        return;
    L21:
        Logger.i(TAG, "start: gpsProviderEnabled=" + r105.isProviderEnabled(GeocodeSearch.GPS));     // Catch: Exception -> L14
        BDLocationExtrasService.getBPEAManager().registerGnssStatusCallback(r105, this.gnssStatusCallback, r101);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e(TAG, "start: register gnss status failed", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SensorBatchGnssStatusCollector(LocationManager r100, Function0<Boolean> r101, SensorBatchGnssStatusCallback r102) {
        this.locationManager = r100;
        this.hasFineLocationPermission = r101;
        this.callback = r102;
        this.satelliteInfoIntervalMs = 1000;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        SensorBatchGnssStatusCollector$gnssStatusCallback$1 r103 = new SensorBatchGnssStatusCollector$gnssStatusCallback$1(this);
    L6:
        this.gnssStatusCallback = r103;
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
