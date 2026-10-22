package com.bytedance.bdlocation.sensor;

import android.location.GnssClock;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007J\u0006\u0010\u001e\u001a\u00020\u0017J \u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGnssCollector;", "", "locationManager", "Landroid/location/LocationManager;", "hasFineLocationPermission", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/bdlocation/sensor/SensorBatchGnssCallback;", "(Landroid/location/LocationManager;Lkotlin/jvm/functions/Function0;Lcom/bytedance/bdlocation/sensor/SensorBatchGnssCallback;)V", "gnssMeasurementsCallback", "com/bytedance/bdlocation/sensor/SensorBatchGnssCollector$gnssMeasurementsCallback$1", "Lcom/bytedance/bdlocation/sensor/SensorBatchGnssCollector$gnssMeasurementsCallback$1;", "registeredBpeaCert", "calculateCarrierPhaseCycles", "", "measurement", "Landroid/location/GnssMeasurement;", "calculateDopplerHz", "calculatePseudorangeM", "clock", "Landroid/location/GnssClock;", "collectGnssMeasurements", "", "event", "Landroid/location/GnssMeasurementsEvent;", "start", "handler", "Landroid/os/Handler;", "bpeaCert", "stop", "toSample", "Lcom/bytedance/bdlocation/sensor/GnssMeasurementSample;", "systemTimeNs", "", "Companion", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class SensorBatchGnssCollector {
    public static final Companion Companion = null;
    public static final double SPEED_OF_LIGHT_M_PER_SEC = 2.99792458E8d;
    public static final String TAG = "SSS-GnssCollector";
    private final SensorBatchGnssCallback callback;
    private final SensorBatchGnssCollector$gnssMeasurementsCallback$1 gnssMeasurementsCallback;
    private final Function0<Boolean> hasFineLocationPermission;
    private final LocationManager locationManager;
    private Object registeredBpeaCert;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdlocation/sensor/SensorBatchGnssCollector$Companion;", "", "()V", "SPEED_OF_LIGHT_M_PER_SEC", "", "TAG", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
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
            java.lang.String r1 = "SSS-GnssCollector"
            com.bytedance.bdlocation.log.Logger.i(r1, r0)
            android.location.LocationManager r0 = r6.locationManager
            r2 = 0
            if (r0 == 0) goto L36
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r4 = 24
            if (r3 < r4) goto L26
            com.bytedance.bdlocation.sensor.SensorBatchGnssCollector$gnssMeasurementsCallback$1 r3 = r6.gnssMeasurementsCallback     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            if (r3 == 0) goto L26
            java.lang.String r3 = "stop: unregisterGnssMeasurementsCallback"
            com.bytedance.bdlocation.log.Logger.i(r1, r3)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            com.bytedance.bdlocation.api.IBPEALocal r3 = com.bytedance.bdlocation.service.BDLocationExtrasService.getBPEAManager()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            com.bytedance.bdlocation.sensor.SensorBatchGnssCollector$gnssMeasurementsCallback$1 r4 = r6.gnssMeasurementsCallback     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.Object r5 = r6.registeredBpeaCert     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r3.unregisterGnssMeasurementsCallback(r0, r4, r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
        L26:
            r6.registeredBpeaCert = r2
            goto L32
        L29:
            r0 = move-exception
            goto L33
        L2b:
            r0 = move-exception
            java.lang.String r3 = "stop: unregister gnss measurement failed"
            com.bytedance.bdlocation.log.Logger.e(r1, r3, r0)     // Catch: java.lang.Throwable -> L29
            goto L26
        L32:
            return
        L33:
            r6.registeredBpeaCert = r2
            throw r0
        L36:
            java.lang.String r0 = "stop: locationManager is null"
            com.bytedance.bdlocation.log.Logger.w(r1, r0)
            r6.registeredBpeaCert = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdlocation.sensor.SensorBatchGnssCollector.stop():void");
    }

    private final double calculateCarrierPhaseCycles(GnssMeasurement r12) {
        if (r12.hasCarrierCycles() == false) goto L7;
        return r12.getCarrierCycles();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0.0d;
    L9:
        if (r12.hasCarrierFrequencyHz() == true) goto L11;
        return 0.0d;
    L11:
        if (r12.getCarrierFrequencyHz() > 0.0f) goto L13;
        return 0.0d;
    L13:
        return SensorBatchValueUtils.finiteDouble$default(SensorBatchValueUtils.INSTANCE, r12.getAccumulatedDeltaRangeMeters() / (2.99792458E8d / ((double) r12.getCarrierFrequencyHz())), 0.0d, 2, null);
    }

    private final double calculateDopplerHz(GnssMeasurement r12) {
        if (Build.VERSION.SDK_INT < 26) goto L11;
        if (r12.hasCarrierFrequencyHz() == false) goto L11;
        if (r12.getCarrierFrequencyHz() <= 0.0f) goto L11;
        double r2 = 2.99792458E8d / ((double) r12.getCarrierFrequencyHz());
        return SensorBatchValueUtils.finiteDouble$default(SensorBatchValueUtils.INSTANCE, (-r12.getPseudorangeRateMetersPerSecond()) / r2, 0.0d, 2, null);
    L11:
        return SensorBatchValueUtils.finiteDouble$default(SensorBatchValueUtils.INSTANCE, r12.getPseudorangeRateMetersPerSecond(), 0.0d, 2, null);
    }

    private final void collectGnssMeasurements(GnssMeasurementsEvent r7) {
        GnssClock r0 = r7.getClock();
        long r1 = System.nanoTime();
        Iterator<GnssMeasurement> r8 = r7.getMeasurements().iterator();
        int r3 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        this.callback.onGnssMeasurementSample(toSample(r0, r8.next(), r1));
        r3 = r3 + 1;
        goto L4
    L6:
        Logger.d(TAG, "collectGnssMeasurements: measurementCount=" + r3);
    }

    public static final /* synthetic */ void access$collectGnssMeasurements(SensorBatchGnssCollector r0, GnssMeasurementsEvent r1) {
        r0.collectGnssMeasurements(r1);
    }

    private final double calculatePseudorangeM(GnssClock r15, GnssMeasurement r16) {
        if (r15.hasFullBiasNanos() == true) goto L6;
        return 0.0d;
    L6:
        if (r15.hasBiasNanos() == false) goto L8;
        double r3 = r15.getBiasNanos();
    L9:
        double r5 = (r15.getTimeNanos() - (r15.getFullBiasNanos() + r3)) - (r16.getReceivedSvTimeNanos() + r16.getTimeOffsetNanos());
        if (r5 > 0.0d) goto L12;
        return 0.0d;
    L12:
        return SensorBatchValueUtils.finiteDouble$default(SensorBatchValueUtils.INSTANCE, (r5 * 1.0E-9d) * 2.99792458E8d, 0.0d, 2, null);
    L8:
        r3 = 0.0d;
        goto L9
    }

    public final void start(Handler r6, Object r7) {
        boolean r1 = ((Boolean) this.hasFineLocationPermission.invoke()).booleanValue();
        StringBuilder r2 = new StringBuilder("start: sdk=");
        int r3 = Build.VERSION.SDK_INT;
        r2.append(r3);
        r2.append(", hasFineLocationPermission=");
        r2.append(r1);
        Logger.i(TAG, r2.toString());
        if (r3 >= 24) goto L5;
    L19:
        Logger.w(TAG, "start: GnssMeasurementsEvent requires Android N or above");
        return;
    L5:
        if (this.gnssMeasurementsCallback == null) goto L19;
        if (r1 == true) goto L10;
        Logger.w(TAG, "start: missing ACCESS_FINE_LOCATION");
        return;
    L10:
        LocationManager r4 = this.locationManager;
        if (r4 != null) goto L21;
        Logger.w(TAG, "start: locationManager is null");
        return;
    L21:
        Logger.i(TAG, "start: gpsProviderEnabled=" + r4.isProviderEnabled("gps"));     // Catch: Exception -> L14
        Logger.i(TAG, "start: registerGnssMeasurementsCallback");     // Catch: Exception -> L14
        BDLocationExtrasService.getBPEAManager().registerGnssMeasurementsCallback(r4, this.gnssMeasurementsCallback, r6, r7);     // Catch: Exception -> L14
        this.registeredBpeaCert = r7;     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e(TAG, "start: register gnss measurement failed", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SensorBatchGnssCollector(LocationManager r1, Function0<Boolean> r2, SensorBatchGnssCallback r3) {
        this.locationManager = r1;
        this.hasFineLocationPermission = r2;
        this.callback = r3;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        SensorBatchGnssCollector$gnssMeasurementsCallback$1 r4 = new SensorBatchGnssCollector$gnssMeasurementsCallback$1(this);
    L6:
        this.gnssMeasurementsCallback = r4;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private final GnssMeasurementSample toSample(GnssClock r27, GnssMeasurement r28, long r29) {
        long r11 = r28.getReceivedSvTimeNanos();
        double r3 = calculatePseudorangeM(r27, r28);
        double r14 = calculateCarrierPhaseCycles(r28);
        double r9 = calculateDopplerHz(r28);
        int r24 = r28.getSvid();
        int r25 = r28.getConstellationType();
        SensorBatchValueUtils r13 = SensorBatchValueUtils.INSTANCE;
        return new GnssMeasurementSample(r24, r25, SensorBatchValueUtils.finiteDouble$default(r13, r3, 0.0d, 2, null), SensorBatchValueUtils.finiteDouble$default(r13, r14, 0.0d, 2, null), SensorBatchValueUtils.finiteDouble$default(r13, r9, 0.0d, 2, null), SensorBatchValueUtils.finiteFloat$default(r13, (float) r28.getCn0DbHz(), 0.0f, 2, null), r11, r29, r28.getState(), r28.getAccumulatedDeltaRangeState());
    }
}
