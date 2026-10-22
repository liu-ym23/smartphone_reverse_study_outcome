package com.bytedance.bdlocation.continuous;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.bridge.BDLocationBridge;
import com.bytedance.bdlocation.bridge.LocationConfig;
import com.bytedance.bdlocation.bridge.PlatformLoggerDelegate;
import com.bytedance.bdlocation.bridge.PlatformTrackerDelegate;
import com.bytedance.bdlocation.bridge.SensorBatch;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector;
import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 J2\u00020\u0001:\u0003JKLB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018H\u0002J,\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\rH\u0002J,\u0010\u001e\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010%\u001a\u00020#J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002J\"\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0002J\"\u00100\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020-H\u0002J \u00101\u001a\u00020#2\u0006\u0010!\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-H\u0002J$\u00105\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109J\u0006\u0010:\u001a\u00020\u0012J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ \u0010<\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0018\u0010A\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020#H\u0002J*\u0010C\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020-H\u0002J2\u0010C\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0002J2\u0010G\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010H\u001a\u00020+H\u0002J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation;", "", "config", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;", "(Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;)V", "context", "Landroid/content/Context;", "loggerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformLoggerDelegate;", "observer", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver;", "runtimeContexts", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$RuntimeContext;", "trackerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformTrackerDelegate;", "dispatchCallback", "", "callbackHandler", "Landroid/os/Handler;", "navInstanceId", "sourceFunction", "block", "Lkotlin/Function0;", "dispatchError", "callback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "error", "Lcom/bytedance/bdlocation/exception/BDLocationException;", "dispatchLocationChanged", LocationMonitorConst.LOCATION, "Lcom/bytedance/bdlocation/BDLocation;", "runtimeContext", "isLocationRunningForBusiness", "", "isReliableLatLng", "isStarted", "markRuntimeStopped", "releaseCollectorSafely", "collector", "Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;", "resolveFailureCallbackState", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$LocationCallbackState;", "callbackElapsedRealtime", "", "resolveLocationCallbackState", "inputHasLatlng", "resolveValidLatlng", "shouldLogSensorBatchPush", "batch", "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "elapsedRealtime", "startLocation", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "looper", "Landroid/os/Looper;", "stopLocation", "stopLocationForBusiness", "updateNavigationHint", "navigationCode", "", "projectionBearing", "", "updateUploadNetSignalThrottle", "validLatlng", "uploadContinueLocationFailure", "errorCode", "errMessage", "durationMs", "uploadContinueLocationMonitor", "callbackState", "uploadLastLocationIfNeeded", "Companion", "LocationCallbackState", "RuntimeContext", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionContinuousLocation {
    public static final Companion Companion = null;
    private static final long SENSOR_BATCH_LOG_INTERVAL_MS = 1000;
    private static final long VALID_LATLNG_INTERVAL_MS = 2000;
    private final ByteFusionContinuousLocationConfig config;
    private final Context context;
    private final PlatformLoggerDelegate loggerDelegate;
    private final ByteFusionContinuousLocationObserver observer;
    private final ConcurrentHashMap<String, RuntimeContext> runtimeContexts;
    private final PlatformTrackerDelegate trackerDelegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$Companion;", "", "()V", "SENSOR_BATCH_LOG_INTERVAL_MS", "", "VALID_LATLNG_INTERVAL_MS", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$LocationCallbackState;", "", "isFirstLocation", "", "durationMs", "", "validLatlng", "(ZJZ)V", "getDurationMs", "()J", "()Z", "getValidLatlng", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class LocationCallbackState {
        private final long durationMs;
        private final boolean isFirstLocation;
        private final boolean validLatlng;

        public static /* synthetic */ LocationCallbackState copy$default(LocationCallbackState r0, boolean r1, long r2, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.isFirstLocation;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.durationMs;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.validLatlng;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final boolean component1() {
            return this.isFirstLocation;
        }

        public final long component2() {
            return this.durationMs;
        }

        public final boolean component3() {
            return this.validLatlng;
        }

        public final LocationCallbackState copy(boolean r2, long r3, boolean r5) {
            return new LocationCallbackState(r2, r3, r5);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof LocationCallbackState) == false) goto L12;
            LocationCallbackState r7 = (LocationCallbackState) r6;
            if (this.isFirstLocation == r7.isFirstLocation) goto L8;
            return false;
        L8:
            if (this.durationMs == r7.durationMs) goto L10;
            return false;
        L10:
            if (this.validLatlng == r7.validLatlng) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r0 = this.isFirstLocation;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            long r3 = this.durationMs;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            boolean r5 = this.validLatlng;
            if (r5 == true) goto L10;
            r1 = r5;
        L10:
            return r4 + r1;
        }

        public String toString() {
            return "LocationCallbackState(isFirstLocation=" + this.isFirstLocation + ", durationMs=" + this.durationMs + ", validLatlng=" + this.validLatlng + ")";
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final boolean getValidLatlng() {
            return this.validLatlng;
        }

        public final boolean isFirstLocation() {
            return this.isFirstLocation;
        }

        public LocationCallbackState(boolean r1, long r2, boolean r4) {
            this.isFirstLocation = r1;
            this.durationMs = r2;
            this.validLatlng = r4;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0002\u0010\u0017J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0015HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u0093\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001J\u0013\u0010D\u001a\u00020\u00152\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 ¨\u0006I"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$RuntimeContext;", "", "navInstanceId", "", "listenerToken", "", "collector", "Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "callback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "callbackHandler", "Landroid/os/Handler;", "lastCallbackElapsedRealtime", "lastValidLatlngElapsedRealtime", "lastSensorBatchLogElapsedRealtime", "lastLocation", "Lcom/bytedance/bdlocation/BDLocation;", "lastSetUploadNetSignalTime", "isFirstLocation", "", "stopped", "(Ljava/lang/String;JLcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;Lcom/bytedance/bdlocation/client/LocationOption;Lcom/bytedance/bdlocation/callback/BDLocationCallback;Landroid/os/Handler;JJJLcom/bytedance/bdlocation/BDLocation;JZZ)V", "getCallback", "()Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "getCallbackHandler", "()Landroid/os/Handler;", "getCollector", "()Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;", "()Z", "setFirstLocation", "(Z)V", "getLastCallbackElapsedRealtime", "()J", "setLastCallbackElapsedRealtime", "(J)V", "getLastLocation", "()Lcom/bytedance/bdlocation/BDLocation;", "setLastLocation", "(Lcom/bytedance/bdlocation/BDLocation;)V", "getLastSensorBatchLogElapsedRealtime", "setLastSensorBatchLogElapsedRealtime", "getLastSetUploadNetSignalTime", "setLastSetUploadNetSignalTime", "getLastValidLatlngElapsedRealtime", "setLastValidLatlngElapsedRealtime", "getListenerToken", "getNavInstanceId", "()Ljava/lang/String;", "getOption", "()Lcom/bytedance/bdlocation/client/LocationOption;", "getStopped", "setStopped", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class RuntimeContext {
        private final BDLocationCallback callback;
        private final Handler callbackHandler;
        private final SensorBatchAtomicCollector collector;
        private boolean isFirstLocation;
        private long lastCallbackElapsedRealtime;
        private BDLocation lastLocation;
        private long lastSensorBatchLogElapsedRealtime;
        private long lastSetUploadNetSignalTime;
        private long lastValidLatlngElapsedRealtime;
        private final long listenerToken;
        private final String navInstanceId;
        private final LocationOption option;
        private volatile boolean stopped;

        public static /* synthetic */ RuntimeContext copy$default(RuntimeContext r16, String r17, long r18, SensorBatchAtomicCollector r20, LocationOption r21, BDLocationCallback r22, Handler r23, long r24, long r26, long r28, BDLocation r30, long r31, boolean r33, boolean r34, int r35, Object r36) {
            if ((r35 & 1) == 0) goto L5;
            String r2 = r16.navInstanceId;
        L7:
            if ((r35 & 2) == 0) goto L9;
            long r3 = r16.listenerToken;
        L11:
            if ((r35 & 4) == 0) goto L13;
            SensorBatchAtomicCollector r5 = r16.collector;
        L15:
            if ((r35 & 8) == 0) goto L17;
            LocationOption r6 = r16.option;
        L19:
            if ((r35 & 16) == 0) goto L21;
            BDLocationCallback r7 = r16.callback;
        L23:
            if ((r35 & 32) == 0) goto L25;
            Handler r8 = r16.callbackHandler;
        L27:
            if ((r35 & 64) == 0) goto L29;
            long r9 = r16.lastCallbackElapsedRealtime;
        L31:
            if ((r35 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
            long r11 = r16.lastValidLatlngElapsedRealtime;
        L35:
            if ((r35 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
            long r13 = r16.lastSensorBatchLogElapsedRealtime;
        L39:
            if ((r35 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
            BDLocation r15 = r16.lastLocation;
        L42:
            BDLocation r32 = r15;
            long r29 = r13;
            if ((r35 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
            long r14 = r16.lastSetUploadNetSignalTime;
        L47:
            if ((r35 & 2048) == 0) goto L49;
            boolean r19 = r16.isFirstLocation;
        L51:
            if ((r35 & 4096) == 0) goto L53;
            boolean r1 = r16.stopped;
        L55:
            return r16.copy(r2, r3, r5, r6, r7, r8, r9, r11, r29, r32, r14, r19, r1);
        L53:
            r1 = r34;
            goto L55
        L49:
            r19 = r33;
            goto L51
        L45:
            r14 = r31;
            goto L47
        L41:
            r15 = r30;
            goto L42
        L37:
            r13 = r28;
            goto L39
        L33:
            r11 = r26;
            goto L35
        L29:
            r9 = r24;
            goto L31
        L25:
            r8 = r23;
            goto L27
        L21:
            r7 = r22;
            goto L23
        L17:
            r6 = r21;
            goto L19
        L13:
            r5 = r20;
            goto L15
        L9:
            r3 = r18;
            goto L11
        L5:
            r2 = r17;
            goto L7
        }

        public final String component1() {
            return this.navInstanceId;
        }

        public final BDLocation component10() {
            return this.lastLocation;
        }

        public final long component11() {
            return this.lastSetUploadNetSignalTime;
        }

        public final boolean component12() {
            return this.isFirstLocation;
        }

        public final boolean component13() {
            return this.stopped;
        }

        public final long component2() {
            return this.listenerToken;
        }

        public final SensorBatchAtomicCollector component3() {
            return this.collector;
        }

        public final LocationOption component4() {
            return this.option;
        }

        public final BDLocationCallback component5() {
            return this.callback;
        }

        public final Handler component6() {
            return this.callbackHandler;
        }

        public final long component7() {
            return this.lastCallbackElapsedRealtime;
        }

        public final long component8() {
            return this.lastValidLatlngElapsedRealtime;
        }

        public final long component9() {
            return this.lastSensorBatchLogElapsedRealtime;
        }

        public final RuntimeContext copy(String r21, long r22, SensorBatchAtomicCollector r24, LocationOption r25, BDLocationCallback r26, Handler r27, long r28, long r30, long r32, BDLocation r34, long r35, boolean r37, boolean r38) {
            return new RuntimeContext(r21, r22, r24, r25, r26, r27, r28, r30, r32, r34, r35, r37, r38);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof RuntimeContext) == false) goto L32;
            RuntimeContext r7 = (RuntimeContext) r6;
            if (Intrinsics.areEqual(this.navInstanceId, r7.navInstanceId) == true) goto L8;
            return false;
        L8:
            if (this.listenerToken == r7.listenerToken) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.collector, r7.collector) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.option, r7.option) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.callback, r7.callback) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.callbackHandler, r7.callbackHandler) == true) goto L18;
            return false;
        L18:
            if (this.lastCallbackElapsedRealtime == r7.lastCallbackElapsedRealtime) goto L20;
            return false;
        L20:
            if (this.lastValidLatlngElapsedRealtime == r7.lastValidLatlngElapsedRealtime) goto L22;
            return false;
        L22:
            if (this.lastSensorBatchLogElapsedRealtime == r7.lastSensorBatchLogElapsedRealtime) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.lastLocation, r7.lastLocation) == true) goto L26;
            return false;
        L26:
            if (this.lastSetUploadNetSignalTime == r7.lastSetUploadNetSignalTime) goto L28;
            return false;
        L28:
            if (this.isFirstLocation == r7.isFirstLocation) goto L30;
            return false;
        L30:
            if (this.stopped == r7.stopped) goto L49;
            return false;
        L49:
            return true;
        L32:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v24, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23, types: [int] */
        /* JADX WARN: Type inference failed for: r2v24 */
        public int hashCode() {
            String r0 = this.navInstanceId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            long r3 = this.listenerToken;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            SensorBatchAtomicCollector r5 = this.collector;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            LocationOption r8 = this.option;
            if (r8 == null) goto L13;
            int r9 = r8.hashCode();
        L14:
            int r10 = (r7 + r9) * 31;
            BDLocationCallback r11 = this.callback;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r10 + r12) * 31;
            Handler r14 = this.callbackHandler;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            long r17 = this.lastCallbackElapsedRealtime;
            int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
            long r19 = this.lastValidLatlngElapsedRealtime;
            int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
            long r21 = this.lastSensorBatchLogElapsedRealtime;
            int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
            BDLocation r23 = this.lastLocation;
            if (r23 == null) goto L25;
            r1 = r23.hashCode();
        L25:
            int r24 = (r22 + r1) * 31;
            long r25 = this.lastSetUploadNetSignalTime;
            int r26 = (r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31;
            boolean r27 = this.isFirstLocation;
            ?? r28 = 1;
            ?? r29 = r27;
            if (r27 == false) goto L28;
            r29 = 1;
        L28:
            int r30 = (r26 + r29) * 31;
            boolean r31 = this.stopped;
            if (r31 == true) goto L33;
            r28 = r31;
        L33:
            return r30 + r28;
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "RuntimeContext(navInstanceId=" + this.navInstanceId + ", listenerToken=" + this.listenerToken + ", collector=" + this.collector + ", option=" + this.option + ", callback=" + this.callback + ", callbackHandler=" + this.callbackHandler + ", lastCallbackElapsedRealtime=" + this.lastCallbackElapsedRealtime + ", lastValidLatlngElapsedRealtime=" + this.lastValidLatlngElapsedRealtime + ", lastSensorBatchLogElapsedRealtime=" + this.lastSensorBatchLogElapsedRealtime + ", lastLocation=" + this.lastLocation + ", lastSetUploadNetSignalTime=" + this.lastSetUploadNetSignalTime + ", isFirstLocation=" + this.isFirstLocation + ", stopped=" + this.stopped + ")";
        }

        public final BDLocationCallback getCallback() {
            return this.callback;
        }

        public final Handler getCallbackHandler() {
            return this.callbackHandler;
        }

        public final SensorBatchAtomicCollector getCollector() {
            return this.collector;
        }

        public final long getLastCallbackElapsedRealtime() {
            return this.lastCallbackElapsedRealtime;
        }

        public final BDLocation getLastLocation() {
            return this.lastLocation;
        }

        public final long getLastSensorBatchLogElapsedRealtime() {
            return this.lastSensorBatchLogElapsedRealtime;
        }

        public final long getLastSetUploadNetSignalTime() {
            return this.lastSetUploadNetSignalTime;
        }

        public final long getLastValidLatlngElapsedRealtime() {
            return this.lastValidLatlngElapsedRealtime;
        }

        public final long getListenerToken() {
            return this.listenerToken;
        }

        public final String getNavInstanceId() {
            return this.navInstanceId;
        }

        public final LocationOption getOption() {
            return this.option;
        }

        public final boolean getStopped() {
            return this.stopped;
        }

        public final boolean isFirstLocation() {
            return this.isFirstLocation;
        }

        public final void setFirstLocation(boolean r1) {
            this.isFirstLocation = r1;
        }

        public final void setLastCallbackElapsedRealtime(long r1) {
            this.lastCallbackElapsedRealtime = r1;
        }

        public final void setLastLocation(BDLocation r1) {
            this.lastLocation = r1;
        }

        public final void setLastSensorBatchLogElapsedRealtime(long r1) {
            this.lastSensorBatchLogElapsedRealtime = r1;
        }

        public final void setLastSetUploadNetSignalTime(long r1) {
            this.lastSetUploadNetSignalTime = r1;
        }

        public final void setLastValidLatlngElapsedRealtime(long r1) {
            this.lastValidLatlngElapsedRealtime = r1;
        }

        public final void setStopped(boolean r1) {
            this.stopped = r1;
        }

        public RuntimeContext(String r4, long r5, SensorBatchAtomicCollector r7, LocationOption r8, BDLocationCallback r9, Handler r10, long r11, long r13, long r15, BDLocation r17, long r18, boolean r20, boolean r21) {
            this.navInstanceId = r4;
            this.listenerToken = r5;
            this.collector = r7;
            this.option = r8;
            this.callback = r9;
            this.callbackHandler = r10;
            this.lastCallbackElapsedRealtime = r11;
            this.lastValidLatlngElapsedRealtime = r13;
            this.lastSensorBatchLogElapsedRealtime = r15;
            this.lastLocation = r17;
            this.lastSetUploadNetSignalTime = r18;
            this.isFirstLocation = r20;
            this.stopped = r21;
        }

        public /* synthetic */ RuntimeContext(String r24, long r25, SensorBatchAtomicCollector r27, LocationOption r28, BDLocationCallback r29, Handler r30, long r31, long r33, long r35, BDLocation r37, long r38, boolean r40, boolean r41, int r42, DefaultConstructorMarker r43) {
            if ((r42 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L5;
            long r16 = 0;
        L7:
            if ((r42 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L9;
            BDLocation r18 = null;
        L11:
            if ((r42 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L13;
            long r19 = 0;
        L15:
            if ((r42 & 2048) == 0) goto L17;
            boolean r21 = true;
        L19:
            if ((r42 & 4096) == 0) goto L21;
            boolean r22 = false;
        L22:
            this(r24, r25, r27, r28, r29, r30, r31, r33, r16, r18, r19, r21, r22);
            return;
        L21:
            r22 = r41;
            goto L22
        L17:
            r21 = r40;
            goto L19
        L13:
            r19 = r38;
            goto L15
        L9:
            r18 = r37;
            goto L11
        L5:
            r16 = r35;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final synchronized void stopLocation() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final boolean isStarted() {
        return !this.runtimeContexts.isEmpty();
    }

    public ByteFusionContinuousLocation(ByteFusionContinuousLocationConfig r2) {
        this.config = r2;
        Context r3 = r2.getPlatformContext();
        if ((r3 instanceof Context) == true) goto L5;
        r3 = null;
    L5:
        this.context = r3;
        this.runtimeContexts = new ConcurrentHashMap();
        ByteFusionPlatformDelegates r4 = ByteFusionPlatformDelegates.INSTANCE;
        this.trackerDelegate = r4.createTrackerDelegate();
        this.loggerDelegate = r4.createLoggerDelegate();
        this.observer = new ByteFusionContinuousLocationObserver();
    }

    public static final /* synthetic */ ByteFusionContinuousLocationObserver access$getObserver$p(ByteFusionContinuousLocation r0) {
        return r0.observer;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getRuntimeContexts$p(ByteFusionContinuousLocation r0) {
        return r0.runtimeContexts;
    }

    private final boolean isReliableLatLng(BDLocation r9) {
        double r0 = r9.getLatitude();
        double r2 = r9.getLongitude();
        if (Double.isInfinite(r0) == false) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == true) goto L10;
    L29:
        return false;
    L10:
        if (Double.isInfinite(r2) == false) goto L12;
    L14:
        boolean r11 = false;
    L15:
        if (r11 == false) goto L29;
        if (r0 == 0.0d) goto L29;
        if (r2 == 0.0d) goto L29;
        if (r0 < (-90.0d)) goto L29;
        if (r0 > 90.0d) goto L29;
        if (r2 < (-180.0d)) goto L29;
        if (r2 > 180.0d) goto L29;
        return true;
    L12:
        if (Double.isNaN(r2) == true) goto L14;
        r11 = true;
        goto L15
    L5:
        if (Double.isNaN(r0) == true) goto L7;
        r10 = true;
        goto L8
    }

    private final void markRuntimeStopped(RuntimeContext r2) {
        monitor-enter(r2);
        r2.setStopped(true);     // Catch: Throwable -> L7
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void stopLocation(String r17) {
        RuntimeContext r3 = this.runtimeContexts.remove(r17);
        if (r3 != null) goto L6;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_ignored", r17, "runtime context not found", null, 8, null);
        return;
    L6:
        markRuntimeStopped(r3);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_enter", r3.getNavInstanceId(), "stop runtime", null, 8, null);
        r3.getCollector().release();     // Catch: Throwable -> L9
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "collector_stop_success", r3.getNavInstanceId(), "collector released", null, 8, null);     // Catch: Throwable -> L9
    L21:
        BDLocationBridge.removeLocationListener(r3.getNavInstanceId(), r3.getListenerToken());     // Catch: Throwable -> L13
    L23:
        BDLocationBridge.stopLocation(r3.getNavInstanceId(), r3.getNavInstanceId());     // Catch: Throwable -> L17
    L19:
        uploadLastLocationIfNeeded(r3);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_success", r3.getNavInstanceId(), "runtimeCount=" + this.runtimeContexts.size(), null, 8, null);
        return;
    L17:
        th = move-exception;
        this.observer.logKeyNode("native_stop_failed", r3.getNavInstanceId(), "navInstanceId=" + r17, th);
    L13:
        th = move-exception;
        this.observer.logKeyNode("remove_listener_failed", r3.getNavInstanceId(), "token=" + r3.getListenerToken(), th);
    L9:
        th = move-exception;
        this.observer.logKeyNode("collector_stop_failed", r3.getNavInstanceId(), "navInstanceId=" + r17, th);
        goto L21
    }

    private final void uploadLastLocationIfNeeded(RuntimeContext r11) {
        if (BDLocationConfig.needUploadLastContinuousLocation() == true) goto L5;
        return;
    L5:
        BDLocation r1 = r11.getLastLocation();
        if (r1 == null) goto L19;
        BDLocationCallback r2 = r11.getCallback();
        if (r2 == null) goto L20;
        LocationOption r3 = r11.getOption();     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        r3.setEnableUploadNetSignal(true);     // Catch: Throwable -> L14
    L12:
        r1.setValidLatlng(true);     // Catch: Throwable -> L14
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "upload_last_location", r11.getNavInstanceId(), "locationType=" + r1.getLocationType(), null, 8, null);     // Catch: Throwable -> L14
        dispatchLocationChanged(r11.getCallbackHandler(), r2, r1, r11.getNavInstanceId());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        this.observer.logKeyNode("upload_last_location_failed", r11.getNavInstanceId(), "message=" + th.getMessage(), th);
        return;
    L20:
        return;
    }

    public final boolean isLocationRunningForBusiness(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return !this.runtimeContexts.isEmpty();
    L12:
        return this.runtimeContexts.containsKey(r3);
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final synchronized void stopLocationForBusiness(String r2) {
        monitor-enter(this);
        if (r2 != null) goto L19;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        stopLocation(r2);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L19:
        if (r2.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public static final /* synthetic */ boolean access$isReliableLatLng(ByteFusionContinuousLocation r0, BDLocation r1) {
        return r0.isReliableLatLng(r1);
    }

    private final void dispatchLocationChanged(final RuntimeContext r4, final BDLocation r5) {
        dispatchCallback(r4.getCallbackHandler(), r4.getNavInstanceId(), "dispatch_location_changed", new C03441(this, r4, r5));
    }

    private final void releaseCollectorSafely(SensorBatchAtomicCollector r4, String r5) {
        r4.release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.observer.logKeyNode("collector_release_failed", r5, "collector release failed", th);
    }

    private final LocationCallbackState resolveFailureCallbackState(RuntimeContext r4, long r5) {
        monitor-enter(r4);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (r4.getStopped() == false) goto L6;
    L10:
        LocationCallbackState r6 = null;
    L11:
        monitor-exit(r4);
        return r6;
    L6:
        if (this.runtimeContexts.get(r4.getNavInstanceId()) != r4) goto L10;
        boolean r0 = r4.isFirstLocation();     // Catch: Throwable -> L13
        long r1 = r5 - r4.getLastCallbackElapsedRealtime();     // Catch: Throwable -> L13
        r4.setLastCallbackElapsedRealtime(r5);     // Catch: Throwable -> L13
        r6 = new LocationCallbackState(r0, r1, false);     // Catch: Throwable -> L13
        goto L11
    }

    private final void updateUploadNetSignalThrottle(RuntimeContext r7, boolean r8) {
        monitor-enter(r7);
        LocationOption r0 = r7.getOption();     // Catch: Throwable -> L17
        if (r0 == null) goto L6;
        r0.setEnableUploadNetSignal(false);     // Catch: Throwable -> L17
    L6:
        if (r8 == false) goto L14;
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if ((r1 - r7.getLastSetUploadNetSignalTime()) < BDLocationConfig.getUploadNetSignalInterval()) goto L14;
        LocationOption r9 = r7.getOption();     // Catch: Throwable -> L17
        if (r9 == null) goto L13;
        r9.setEnableUploadNetSignal(true);     // Catch: Throwable -> L17
    L13:
        r7.setLastSetUploadNetSignalTime(r1);     // Catch: Throwable -> L17
    L14:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$dispatchLocationChanged(ByteFusionContinuousLocation r0, RuntimeContext r1, BDLocation r2) {
        r0.dispatchLocationChanged(r1, r2);
    }

    public static final /* synthetic */ LocationCallbackState access$resolveFailureCallbackState(ByteFusionContinuousLocation r0, RuntimeContext r1, long r2) {
        return r0.resolveFailureCallbackState(r1, r2);
    }

    public static final /* synthetic */ void access$updateUploadNetSignalThrottle(ByteFusionContinuousLocation r0, RuntimeContext r1, boolean r2) {
        r0.updateUploadNetSignalThrottle(r1, r2);
    }

    private final LocationCallbackState resolveLocationCallbackState(RuntimeContext r4, boolean r5, long r6) {
        monitor-enter(r4);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (r4.getStopped() == false) goto L6;
    L13:
        LocationCallbackState r7 = null;
    L14:
        monitor-exit(r4);
        return r7;
    L6:
        if (this.runtimeContexts.get(r4.getNavInstanceId()) != r4) goto L13;
        boolean r0 = r4.isFirstLocation();     // Catch: Throwable -> L16
        boolean r8 = resolveValidLatlng(r5, r4, r6);     // Catch: Throwable -> L16
        long r1 = r6 - r4.getLastCallbackElapsedRealtime();     // Catch: Throwable -> L16
        r4.setLastCallbackElapsedRealtime(r6);     // Catch: Throwable -> L16
        if (r8 == false) goto L11;
        r4.setFirstLocation(false);     // Catch: Throwable -> L16
    L11:
        r7 = new LocationCallbackState(r0, r1, r8);     // Catch: Throwable -> L16
        goto L14
    }

    private final boolean resolveValidLatlng(boolean r7, RuntimeContext r8, long r9) {
        if (r7 == false) goto L8;
        if (r8 == null) goto L6;
        r8.setLastValidLatlngElapsedRealtime(r9);
    L6:
        return true;
    L8:
        if (r8 != null) goto L11;
        return false;
    L11:
        if ((r9 - r8.getLastValidLatlngElapsedRealtime()) >= 2000) goto L13;
        return false;
    L13:
        r8.setLastValidLatlngElapsedRealtime(r9);
        return true;
    }

    private final boolean shouldLogSensorBatchPush(RuntimeContext r6, SensorBatch r7, long r8) {
        monitor-enter(r6);
        boolean r0 = true;
        if (r7.gps == null) goto L7;
        r6.setLastSensorBatchLogElapsedRealtime(r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r6);
        return r0;
    L7:
        if ((r8 - r6.getLastSensorBatchLogElapsedRealtime()) >= 1000) goto L9;
        r0 = false;
        goto L10
    L9:
        r6.setLastSensorBatchLogElapsedRealtime(r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.bdlocation.continuous.ByteFusionContinuousLocationObserver] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.bdlocation.continuous.ByteFusionContinuousLocationObserver] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [com.bytedance.bdlocation.callback.BDLocationCallback] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.bytedance.bdlocation.callback.BDLocationCallback] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [long] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v17, types: [com.bytedance.bdlocation.client.LocationOption] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10, types: [com.bytedance.bdlocation.callback.BDLocationCallback] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16, types: [com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector] */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r25v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r45v0, types: [com.bytedance.bdlocation.continuous.ByteFusionContinuousLocation] */
    /* JADX WARN: Type inference failed for: r48v1, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r6v10, types: [com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.bytedance.bdlocation.continuous.ByteFusionLocationUtils] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final synchronized void startLocation(BDLocationCallback r46, LocationOption r47, Looper r48) {
        BDLocationCallback r7 = r46;
        String r11 = "token=";
        monitor-enter(this);
        long r30 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L123
        Context r9 = this.context;     // Catch: Throwable -> L123
        if (r9 == null) goto L7;
        Context r17 = r9.getApplicationContext();     // Catch: Throwable -> L123
    L8:
        ?? r10 = ByteFusionLocationUtils.INSTANCE;     // Catch: Throwable -> L123
        final ?? r12 = r10.resolveNavInstanceId(r47, this.config);     // Catch: Throwable -> L123
        if (r48 == null) goto L11;
        ?? r13 = new Handler(r48);     // Catch: Throwable -> L123
    L12:
        if (r17 != null) goto L16;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "start_context_null", r12, "context is null", null, 8, null);     // Catch: Throwable -> L123
        uploadContinueLocationFailure(r47, BDLocationException.ERROR_CONTEXT_NULL, "context is null", SystemClock.elapsedRealtime() - r30);     // Catch: Throwable -> L123
        dispatchError(r13, r7, r10.newException("context is null", BDLocationException.ERROR_CONTEXT_NULL), r12);     // Catch: Throwable -> L123
        monitor-exit(this);
        return;
    L16:
        ByteFusionContinuousLocationObserver r0 = this.observer;     // Catch: Throwable -> L123
        String r33 = "message=";
        StringBuilder r14 = new StringBuilder("locateType=");     // Catch: Throwable -> L123
        if (r47 == null) goto L19;
        Integer r6 = Integer.valueOf(r47.getLocateType());     // Catch: Throwable -> L123
    L20:
        r14.append(r6);     // Catch: Throwable -> L123
        r14.append(", uploadSource=");     // Catch: Throwable -> L123
        if (r47 == null) goto L23;
        String r8 = r47.getUploadSource();     // Catch: Throwable -> L123
    L24:
        r14.append(r8);     // Catch: Throwable -> L123
        ByteFusionContinuousLocationObserver.logKeyNode$default(r0, "start_enter", r12, r14.toString(), null, 8, null);     // Catch: Throwable -> L123
        stopLocation(r12);     // Catch: Throwable -> L123
        String r35 = "startLocation exception: ";
        String r34 = "startLocation exception: ";
        boolean r36 = false;
        long r15 = BDLocationBridge.getBDLocationInstance(r12, this.trackerDelegate, this.loggerDelegate);     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "get_instance_result", r12, "nativeInstance=" + r15, null, 8, null);     // Catch: Throwable -> L105
        if (r15 != 0) goto L35;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "get_instance_failed", r12, "getBDLocationInstance failed", null, 8, null);     // Catch: Throwable -> L32
        uploadContinueLocationFailure(r47, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "getBDLocationInstance failed", SystemClock.elapsedRealtime() - r30);     // Catch: Throwable -> L32
        dispatchError(r13, r7, r10.newException("getBDLocationInstance failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r12);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L35:
        LocationConfig r1 = r10.buildLocationConfig(r47, r12);     // Catch: Throwable -> L105
        boolean r5 = BDLocationBridge.setLocationConfig(r12, r1);     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "set_config_result", r12, "workMode=" + r1.workMode + " userMoitionMode=" + r1.userMotionMode + " result=" + r5, null, 8, null);     // Catch: Throwable -> L105
        if (r5 == true) goto L40;
        uploadContinueLocationFailure(r47, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "setLocationConfig failed", SystemClock.elapsedRealtime() - r30);     // Catch: Throwable -> L32
        dispatchError(r13, r7, r10.newException("setLocationConfig failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r12);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L40:
        final Ref.LongRef r2 = new Ref.LongRef();     // Catch: Throwable -> L105
        r2.element = 0;     // Catch: Throwable -> L103
        long r16 = BDLocationBridge.addLocationListener(r12, new C03451(this, r12, r2));     // Catch: Throwable -> L105
        r2.element = r16;     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver r4 = this.observer;     // Catch: Throwable -> L99
        StringBuilder r18 = new StringBuilder("token=");     // Catch: Throwable -> L99
        long r39 = r16;
        r18.append(r2.element);     // Catch: Throwable -> L97
        ByteFusionContinuousLocationObserver.logKeyNode$default(r4, "add_listener_result", r12, r18.toString(), null, 8, null);     // Catch: Throwable -> L97
        if (r2.element != 0) goto L136;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "add_listener_failed", r12, "addLocationListener failed", null, 8, null);     // Catch: Throwable -> L52
        uploadContinueLocationFailure(r47, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "addLocationListener failed", SystemClock.elapsedRealtime() - r30);     // Catch: Throwable -> L52
        dispatchError(r13, r7, r10.newException("addLocationListener failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r12);     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L136:
    L95:
        th = th;
        long r37 = r39;
        long r32 = 0;
    L102:
        Throwable r19 = th;
        long r3 = r37;
    L108:
        ?? r110 = 0;
        ?? r111 = r7;
        ?? r112 = r13;
        ?? r113 = r12;
    L109:
        stopLocation(r113);     // Catch: Throwable -> L123
        if (r36 == true) goto L120;
        if (r110 == 0) goto L114;
        releaseCollectorSafely(r110, r113);     // Catch: Throwable -> L123
    L114:
        if (r3 == r32) goto L120;
        BDLocationBridge.removeLocationListener(r113, r3);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        this.observer.logKeyNode("start_exception_remove_listener_failed", r113, r11 + r3, th);     // Catch: Throwable -> L123
    L120:
        this.observer.logKeyNode("start_exception", r113, r33 + r19.getMessage(), r19);     // Catch: Throwable -> L123
        uploadContinueLocationFailure(r47, BDLocationException.ERROR_UNKNOWN, r35 + r19.getMessage(), SystemClock.elapsedRealtime() - r30);     // Catch: Throwable -> L123
        dispatchError(r112, r111, ByteFusionLocationUtils.INSTANCE.newException(r34 + r19.getMessage(), BDLocationException.ERROR_UNKNOWN), r113);     // Catch: Throwable -> L123
    L121:
        monitor-exit(this);
        return;
    L55:
        if (r47 == null) goto L59;
        Object r20 = r47.getBpeaCert();     // Catch: Throwable -> L52
        if (r20 == null) goto L59;
    L60:
        final ?? r21 = new SensorBatchAtomicCollector(r17, r20, null, 4, null);     // Catch: Throwable -> L95
        r21.updateCallback(new C03462(this, r12, r21));     // Catch: Throwable -> L91
        AbstractMap r22 = this.runtimeContexts;     // Catch: Throwable -> L91
        ?? r49 = r13;
        r11 = r11;
        r33 = r33;
        r13 = r2.element;     // Catch: Throwable -> L89
        r39 = r39;
        r32 = 0;
        r35 = r35;
        r34 = r34;
        r12 = r47;
        r21 = r46;
        r22.put(r12, new RuntimeContext(r12, r13, r21, r12, r21, r49, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime(), 0, null, 0, false, false, 7936, null));     // Catch: Throwable -> L87
        r36 = true;
        boolean r23 = BDLocationBridge.startLocation(r12, r12);     // Catch: Throwable -> L87
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "native_start_result", r12, "result=" + r23, null, 8, null);     // Catch: Throwable -> L87
        if (r23 == true) goto L83;
        RuntimeContext r24 = this.runtimeContexts.remove(r12);     // Catch: Throwable -> L87
        if (r24 != null) goto L138;
        r12 = r46;
        r21 = r21;
        r12 = r12;
    L75:
        releaseCollectorSafely(r21, r12);     // Catch: Throwable -> L80
        BDLocationBridge.removeLocationListener(r12, r2.element);     // Catch: Throwable -> L80
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "native_start_failed", r12, "startLocation failed, listener removed", null, 8, null);     // Catch: Throwable -> L80
        dispatchError(r49, r12, r10.newException("startLocation failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r12);     // Catch: Throwable -> L85
        monitor-exit(this);
        return;
    L80:
        th = th;
    L81:
        r13 = r49;
    L94:
        r19 = th;
        r3 = r39;
        r111 = r12;
        r112 = r13;
        r113 = r12;
        r110 = r21;
        goto L109
    L138:
        r12 = r46;
        r21 = r21;
        r12 = r12;
        uploadContinueLocationFailure(r24, null, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "startLocation failed", SystemClock.elapsedRealtime());     // Catch: Throwable -> L80
        markRuntimeStopped(r24);     // Catch: Throwable -> L80
        r12 = r12;
        r12 = r12;
        r21 = r21;
    L72:
        th = th;
        r12 = r46;
        r21 = r21;
        r12 = r12;
        goto L81
    L83:
        r21.start();     // Catch: Throwable -> L85
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "start_success", r12, "runtimeCount=" + this.runtimeContexts.size(), null, 8, null);     // Catch: Throwable -> L85
    L85:
        th = th;
    L87:
        th = th;
        r12 = r46;
        r13 = r49;
        r21 = r21;
        r12 = r12;
    L89:
        th = th;
        r32 = 0;
    L93:
        r12 = r7;
    L91:
        th = th;
        r32 = 0;
    L59:
        r20 = this.config.getBpeaCert();     // Catch: Throwable -> L95
    L52:
        th = th;
        r3 = r39;
        boolean r114 = false;
        r32 = 0;
    L34:
        r111 = r7;
        r19 = th;
        r112 = r13;
        r113 = r12;
        r110 = r114;
    L97:
        th = th;
        r11 = r11;
        r33 = r33;
        r34 = r34;
        r35 = r35;
        r37 = r39;
        r32 = 0;
    L99:
        th = th;
        r37 = r16;
        r32 = 0;
    L103:
        th = th;
        r32 = 0;
    L107:
        r19 = th;
        r3 = r32;
    L32:
        th = th;
        r3 = 0;
        r114 = false;
        r32 = 0;
    L105:
        th = th;
        r32 = 0;
        goto L107
    L23:
        r8 = null;
        goto L24
    L19:
        r6 = null;
        goto L20
    L11:
        r13 = 0;
        goto L12
    L7:
        r17 = null;
    L123:
        th = move-exception;
        throw th;
    }

    public final void updateNavigationHint(String r12, int r13, float r14) {
        if (r12 != null) goto L4;
    L7:
        boolean r3 = true;
    L8:
        if (r3 == false) goto L11;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_ignored", "", "navInstanceId is null or empty", null, 8, null);
        return;
    L11:
        RuntimeContext r4 = this.runtimeContexts.get(r12);
        if (r4 != null) goto L14;
    L18:
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_ignored", r12, "runtime context not found", null, 8, null);
        return;
    L14:
        if (r4.getStopped() == true) goto L18;
        r4.getCollector().updateNavigationHint(r13, r14);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_cached", r12, "navigationCode=" + r13 + ", projectionBearing=" + r14, null, 8, null);
        return;
    L4:
        if (r12.length() == 0) goto L7;
        r3 = false;
        goto L8
    }

    public static final /* synthetic */ LocationCallbackState access$resolveLocationCallbackState(ByteFusionContinuousLocation r0, RuntimeContext r1, boolean r2, long r3) {
        return r0.resolveLocationCallbackState(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$shouldLogSensorBatchPush(ByteFusionContinuousLocation r0, RuntimeContext r1, SensorBatch r2, long r3) {
        return r0.shouldLogSensorBatchPush(r1, r2, r3);
    }

    private final void dispatchCallback(Handler r2, final String r3, final String r4, final Function0<Unit> r5) {
        Runnable r0 = new ByteFusionContinuousLocation$dispatchCallback$runnable$1(this, r5, r3, r4);
        if (r2 == null) goto L5;
        r2.post(r0);
        return;
    L5:
        r0.run();
    }

    private final void dispatchError(Handler r2, final BDLocationCallback r3, final BDLocationException r4, String r5) {
        dispatchCallback(r2, r5, "dispatch_error", new AnonymousClass1(r3, r4));
    }

    private final void dispatchLocationChanged(Handler r2, final BDLocationCallback r3, final BDLocation r4, String r5) {
        dispatchCallback(r2, r5, "dispatch_location_changed", new AnonymousClass2(r3, r4));
    }

    private final void uploadContinueLocationFailure(LocationOption r12, String r13, String r14, long r15) {
        if (r12 == null) goto L5;
        boolean r3 = r12.isChineseRegion();
    L7:
        if (r12 == null) goto L11;
        String r1 = r12.getUploadSource();
        if (r1 == null) goto L11;
    L12:
        LocationMonitor.doContinueLocation(LocationInfoConst.BYTE_FUSION_CONTINUOUS, r13, r14, r3, 0, "2.17.6-rc.81", r15, true, r1, null);
        return;
    L11:
        r1 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
        goto L12
    L5:
        r3 = true;
        goto L7
    }

    private final void uploadContinueLocationFailure(RuntimeContext r7, BDLocation r8, String r9, String r10, long r11) {
        LocationCallbackState r5 = resolveFailureCallbackState(r7, r11);
        if (r5 == null) goto L6;
        uploadContinueLocationMonitor(r7, r8, r9, r10, r5);
        return;
    }

    private final void uploadContinueLocationMonitor(RuntimeContext r13, BDLocation r14, String r15, String r16, LocationCallbackState r17) {
        if (Intrinsics.areEqual(BDLocationException.SUCCESS, r15) == true) goto L5;
    L7:
        LocationOption r0 = r13.getOption();
        if (r0 == null) goto L10;
        boolean r4 = r0.isChineseRegion();
    L11:
        if (r14 == null) goto L13;
        int r5 = r14.getLocationType();
    L14:
        long r7 = r17.getDurationMs();
        boolean r9 = r17.isFirstLocation();
        LocationOption r1 = r13.getOption();
        if (r1 == null) goto L19;
        String r2 = r1.getUploadSource();
        if (r2 == null) goto L19;
    L20:
        LocationMonitor.doContinueLocation(LocationInfoConst.BYTE_FUSION_CONTINUOUS, r15, r16, r4, r5, "2.17.6-rc.81", r7, r9, r2, null);
        return;
    L19:
        r2 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
        goto L20
    L13:
        r5 = 0;
        goto L14
    L10:
        r4 = true;
        goto L11
    L5:
        if (r17.getValidLatlng() == true) goto L7;
    }

    public static final /* synthetic */ void access$uploadContinueLocationFailure(ByteFusionContinuousLocation r0, RuntimeContext r1, BDLocation r2, String r3, String r4, long r5) {
        r0.uploadContinueLocationFailure(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$uploadContinueLocationMonitor(ByteFusionContinuousLocation r0, RuntimeContext r1, BDLocation r2, String r3, String r4, LocationCallbackState r5) {
        r0.uploadContinueLocationMonitor(r1, r2, r3, r4, r5);
    }
}
