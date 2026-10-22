package com.bytedance.bdlocation.continuous;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
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
import com.bytedance.bdlocation.sensor.SensorBatchAtomicCollector;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 J2\u00020\u0001:\u0003JKLB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018H\u0002J,\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\rH\u0002J,\u0010\u001e\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010%\u001a\u00020#J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002J\"\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0002J\"\u00100\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020-H\u0002J \u00101\u001a\u00020#2\u0006\u0010!\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-H\u0002J$\u00105\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109J\u0006\u0010:\u001a\u00020\u0012J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ \u0010<\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0018\u0010A\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020#H\u0002J*\u0010C\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020-H\u0002J2\u0010C\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0002J2\u0010G\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010H\u001a\u00020+H\u0002J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation;", "", "config", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;", "(Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "loggerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformLoggerDelegate;", "observer", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationObserver;", "runtimeContexts", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$RuntimeContext;", "trackerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformTrackerDelegate;", "dispatchCallback", "", "callbackHandler", "Landroid/os/Handler;", "navInstanceId", "sourceFunction", "block", "Lkotlin/Function0;", "dispatchError", "callback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "error", "Lcom/bytedance/bdlocation/exception/BDLocationException;", "dispatchLocationChanged", "location", "Lcom/bytedance/bdlocation/BDLocation;", "runtimeContext", "isLocationRunningForBusiness", "", "isReliableLatLng", "isStarted", "markRuntimeStopped", "releaseCollectorSafely", "collector", "Lcom/bytedance/bdlocation/sensor/SensorBatchAtomicCollector;", "resolveFailureCallbackState", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$LocationCallbackState;", "callbackElapsedRealtime", "", "resolveLocationCallbackState", "inputHasLatlng", "resolveValidLatlng", "shouldLogSensorBatchPush", OPTrace.BATCH_DATA_KEY, "Lcom/bytedance/bdlocation/bridge/SensorBatch;", "elapsedRealtime", "startLocation", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "looper", "Landroid/os/Looper;", "stopLocation", "stopLocationForBusiness", "updateNavigationHint", "navigationCode", "", "projectionBearing", "", "updateUploadNetSignalThrottle", "validLatlng", "uploadContinueLocationFailure", "errorCode", "errMessage", "durationMs", "uploadContinueLocationMonitor", "callbackState", "uploadLastLocationIfNeeded", "Companion", "LocationCallbackState", "RuntimeContext", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
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

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation$LocationCallbackState;", "", "isFirstLocation", "", "durationMs", "", "validLatlng", "(ZJZ)V", "getDurationMs", "()J", "()Z", "getValidLatlng", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
    public static final class LocationCallbackState {
        private final long durationMs;
        private final boolean isFirstLocation;
        private final boolean validLatlng;

        public static /* synthetic */ LocationCallbackState copy$default(LocationCallbackState r100, boolean r101, long r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.isFirstLocation;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.durationMs;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.validLatlng;
        L12:
            return r100.copy(r101, r102, r103);
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

        public final LocationCallbackState copy(boolean r100, long r101, boolean r102) {
            return new LocationCallbackState(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LocationCallbackState) == false) goto L12;
            LocationCallbackState r101 = (LocationCallbackState) r100;
            if (this.isFirstLocation == r101.isFirstLocation) goto L8;
            return false;
        L8:
            if (this.durationMs == r101.durationMs) goto L10;
            return false;
        L10:
            if (this.validLatlng == r101.validLatlng) goto L19;
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
            boolean r100 = this.isFirstLocation;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            long r103 = this.durationMs;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            boolean r105 = this.validLatlng;
            if (r105 == true) goto L10;
            r101 = r105;
        L10:
            return r104 + r101;
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

        public LocationCallbackState(boolean r100, long r101, boolean r102) {
            this.isFirstLocation = r100;
            this.durationMs = r101;
            this.validLatlng = r102;
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

        public static /* synthetic */ RuntimeContext copy$default(RuntimeContext r110, String r111, long r112, SensorBatchAtomicCollector r210, LocationOption r211, BDLocationCallback r212, Handler r213, long r214, long r215, long r216, BDLocation r310, long r311, boolean r312, boolean r313, int r314, Object r315) {
            if ((r314 & 1) == 0) goto L5;
            String r100 = r110.navInstanceId;
        L7:
            if ((r314 & 2) == 0) goto L9;
            long r101 = r110.listenerToken;
        L11:
            if ((r314 & 4) == 0) goto L13;
            SensorBatchAtomicCollector r102 = r110.collector;
        L15:
            if ((r314 & 8) == 0) goto L17;
            LocationOption r103 = r110.option;
        L19:
            if ((r314 & 16) == 0) goto L21;
            BDLocationCallback r104 = r110.callback;
        L23:
            if ((r314 & 32) == 0) goto L25;
            Handler r105 = r110.callbackHandler;
        L27:
            if ((r314 & 64) == 0) goto L29;
            long r106 = r110.lastCallbackElapsedRealtime;
        L31:
            if ((r314 & 128) == 0) goto L33;
            long r113 = r110.lastValidLatlngElapsedRealtime;
        L35:
            if ((r314 & 256) == 0) goto L37;
            long r114 = r110.lastSensorBatchLogElapsedRealtime;
        L39:
            if ((r314 & 512) == 0) goto L41;
            BDLocation r115 = r110.lastLocation;
        L42:
            BDLocation r316 = r115;
            long r217 = r114;
            if ((r314 & 1024) == 0) goto L45;
            long r116 = r110.lastSetUploadNetSignalTime;
        L47:
            if ((r314 & 2048) == 0) goto L49;
            boolean r117 = r110.isFirstLocation;
        L51:
            if ((r314 & 4096) == 0) goto L53;
            boolean r107 = r110.stopped;
        L55:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r217, r316, r116, r117, r107);
        L53:
            r107 = r313;
            goto L55
        L49:
            r117 = r312;
            goto L51
        L45:
            r116 = r311;
            goto L47
        L41:
            r115 = r310;
            goto L42
        L37:
            r114 = r216;
            goto L39
        L33:
            r113 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
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

        public final RuntimeContext copy(String r210, long r211, SensorBatchAtomicCollector r212, LocationOption r213, BDLocationCallback r214, Handler r215, long r216, long r310, long r311, BDLocation r312, long r313, boolean r314, boolean r315) {
            return new RuntimeContext(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof RuntimeContext) == false) goto L32;
            RuntimeContext r101 = (RuntimeContext) r100;
            if (Intrinsics.areEqual(this.navInstanceId, r101.navInstanceId) == true) goto L8;
            return false;
        L8:
            if (this.listenerToken == r101.listenerToken) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.collector, r101.collector) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.option, r101.option) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.callback, r101.callback) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.callbackHandler, r101.callbackHandler) == true) goto L18;
            return false;
        L18:
            if (this.lastCallbackElapsedRealtime == r101.lastCallbackElapsedRealtime) goto L20;
            return false;
        L20:
            if (this.lastValidLatlngElapsedRealtime == r101.lastValidLatlngElapsedRealtime) goto L22;
            return false;
        L22:
            if (this.lastSensorBatchLogElapsedRealtime == r101.lastSensorBatchLogElapsedRealtime) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.lastLocation, r101.lastLocation) == true) goto L26;
            return false;
        L26:
            if (this.lastSetUploadNetSignalTime == r101.lastSetUploadNetSignalTime) goto L28;
            return false;
        L28:
            if (this.isFirstLocation == r101.isFirstLocation) goto L30;
            return false;
        L30:
            if (this.stopped == r101.stopped) goto L49;
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
            String r100 = this.navInstanceId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            long r103 = this.listenerToken;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            SensorBatchAtomicCollector r105 = this.collector;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            LocationOption r108 = this.option;
            if (r108 == null) goto L13;
            int r109 = r108.hashCode();
        L14:
            int r110 = (r107 + r109) * 31;
            BDLocationCallback r111 = this.callback;
            if (r111 == null) goto L17;
            int r112 = r111.hashCode();
        L18:
            int r113 = (r110 + r112) * 31;
            Handler r114 = this.callbackHandler;
            if (r114 == null) goto L21;
            int r115 = r114.hashCode();
        L22:
            int r116 = (r113 + r115) * 31;
            long r117 = this.lastCallbackElapsedRealtime;
            int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
            long r119 = this.lastValidLatlngElapsedRealtime;
            int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
            long r121 = this.lastSensorBatchLogElapsedRealtime;
            int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
            BDLocation r123 = this.lastLocation;
            if (r123 == null) goto L25;
            r101 = r123.hashCode();
        L25:
            int r124 = (r122 + r101) * 31;
            long r125 = this.lastSetUploadNetSignalTime;
            int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
            boolean r127 = this.isFirstLocation;
            ?? r128 = 1;
            ?? r129 = r127;
            if (r127 == false) goto L28;
            r129 = 1;
        L28:
            int r130 = (r126 + r129) * 31;
            boolean r131 = this.stopped;
            if (r131 == true) goto L33;
            r128 = r131;
        L33:
            return r130 + r128;
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r102 = 0;
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

        public final void setFirstLocation(boolean r100) {
            this.isFirstLocation = r100;
        }

        public final void setLastCallbackElapsedRealtime(long r100) {
            this.lastCallbackElapsedRealtime = r100;
        }

        public final void setLastLocation(BDLocation r100) {
            this.lastLocation = r100;
        }

        public final void setLastSensorBatchLogElapsedRealtime(long r100) {
            this.lastSensorBatchLogElapsedRealtime = r100;
        }

        public final void setLastSetUploadNetSignalTime(long r100) {
            this.lastSetUploadNetSignalTime = r100;
        }

        public final void setLastValidLatlngElapsedRealtime(long r100) {
            this.lastValidLatlngElapsedRealtime = r100;
        }

        public final void setStopped(boolean r100) {
            this.stopped = r100;
        }

        public RuntimeContext(String r100, long r101, SensorBatchAtomicCollector r102, LocationOption r103, BDLocationCallback r104, Handler r110, long r111, long r112, long r113, BDLocation r114, long r115, boolean r210, boolean r211) {
            this.navInstanceId = r100;
            this.listenerToken = r101;
            this.collector = r102;
            this.option = r103;
            this.callback = r104;
            this.callbackHandler = r110;
            this.lastCallbackElapsedRealtime = r111;
            this.lastValidLatlngElapsedRealtime = r112;
            this.lastSensorBatchLogElapsedRealtime = r113;
            this.lastLocation = r114;
            this.lastSetUploadNetSignalTime = r115;
            this.isFirstLocation = r210;
            this.stopped = r211;
        }

        public /* synthetic */ RuntimeContext(String r210, long r211, SensorBatchAtomicCollector r212, LocationOption r213, BDLocationCallback r214, Handler r310, long r311, long r312, long r313, BDLocation r314, long r315, boolean r410, boolean r411, int r412, DefaultConstructorMarker r413) {
            if ((r412 & 256) == 0) goto L5;
            long r110 = 0;
        L7:
            if ((r412 & 512) == 0) goto L9;
            BDLocation r111 = null;
        L11:
            if ((r412 & 1024) == 0) goto L13;
            long r112 = 0;
        L15:
            if ((r412 & 2048) == 0) goto L17;
            boolean r215 = true;
        L19:
            if ((r412 & 4096) == 0) goto L21;
            boolean r216 = false;
        L22:
            this(r210, r211, r212, r213, r214, r310, r311, r312, r110, r111, r112, r215, r216);
            return;
        L21:
            r216 = r411;
            goto L22
        L17:
            r215 = r410;
            goto L19
        L13:
            r112 = r315;
            goto L15
        L9:
            r111 = r314;
            goto L11
        L5:
            r110 = r313;
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

    public ByteFusionContinuousLocation(ByteFusionContinuousLocationConfig r100) {
        this.config = r100;
        Context r101 = r100.getPlatformContext();
        if ((r101 instanceof Context) == true) goto L5;
        r101 = null;
    L5:
        this.context = r101;
        this.runtimeContexts = new ConcurrentHashMap();
        ByteFusionPlatformDelegates r102 = ByteFusionPlatformDelegates.INSTANCE;
        this.trackerDelegate = r102.createTrackerDelegate();
        this.loggerDelegate = r102.createLoggerDelegate();
        this.observer = new ByteFusionContinuousLocationObserver();
    }

    public static final /* synthetic */ ByteFusionContinuousLocationObserver access$getObserver$p(ByteFusionContinuousLocation r100) {
        return r100.observer;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getRuntimeContexts$p(ByteFusionContinuousLocation r100) {
        return r100.runtimeContexts;
    }

    private final boolean isReliableLatLng(BDLocation r100) {
        double r101 = r100.getLatitude();
        double r102 = r100.getLongitude();
        if (Double.isInfinite(r101) == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L29:
        return false;
    L10:
        if (Double.isInfinite(r102) == false) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L29;
        if (r101 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        if (r102 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        if (r101 < (-90.0d)) goto L29;
        if (r101 > 90.0d) goto L29;
        if (r102 < (-180.0d)) goto L29;
        if (r102 > 180.0d) goto L29;
        return true;
    L12:
        if (Double.isNaN(r102) == true) goto L14;
        r104 = true;
        goto L15
    L5:
        if (Double.isNaN(r101) == true) goto L7;
        r103 = true;
        goto L8
    }

    private final void markRuntimeStopped(RuntimeContext r100) {
        monitor-enter(r100);
        r100.setStopped(true);     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void stopLocation(String r110) {
        RuntimeContext r100 = this.runtimeContexts.remove(r110);
        if (r100 != null) goto L6;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_ignored", r110, "runtime context not found", null, 8, null);
        return;
    L6:
        markRuntimeStopped(r100);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_enter", r100.getNavInstanceId(), "stop runtime", null, 8, null);
        r100.getCollector().release();     // Catch: Throwable -> L9
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "collector_stop_success", r100.getNavInstanceId(), "collector released", null, 8, null);     // Catch: Throwable -> L9
    L21:
        BDLocationBridge.removeLocationListener(r100.getNavInstanceId(), r100.getListenerToken());     // Catch: Throwable -> L13
    L23:
        BDLocationBridge.stopLocation(r100.getNavInstanceId(), r100.getNavInstanceId());     // Catch: Throwable -> L17
    L19:
        uploadLastLocationIfNeeded(r100);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "stop_success", r100.getNavInstanceId(), "runtimeCount=" + this.runtimeContexts.size(), null, 8, null);
        return;
    L17:
        th = move-exception;
        this.observer.logKeyNode("native_stop_failed", r100.getNavInstanceId(), "navInstanceId=" + r110, th);
    L13:
        th = move-exception;
        this.observer.logKeyNode("remove_listener_failed", r100.getNavInstanceId(), "token=" + r100.getListenerToken(), th);
    L9:
        th = move-exception;
        this.observer.logKeyNode("collector_stop_failed", r100.getNavInstanceId(), "navInstanceId=" + r110, th);
        goto L21
    }

    private final void uploadLastLocationIfNeeded(RuntimeContext r110) {
        if (BDLocationConfig.needUploadLastContinuousLocation() == true) goto L5;
        return;
    L5:
        BDLocation r100 = r110.getLastLocation();
        if (r100 == null) goto L19;
        BDLocationCallback r101 = r110.getCallback();
        if (r101 == null) goto L20;
        LocationOption r102 = r110.getOption();     // Catch: Throwable -> L14
        if (r102 == null) goto L12;
        r102.setEnableUploadNetSignal(true);     // Catch: Throwable -> L14
    L12:
        r100.setValidLatlng(true);     // Catch: Throwable -> L14
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "upload_last_location", r110.getNavInstanceId(), "locationType=" + r100.getLocationType(), null, 8, null);     // Catch: Throwable -> L14
        dispatchLocationChanged(r110.getCallbackHandler(), r101, r100, r110.getNavInstanceId());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        this.observer.logKeyNode("upload_last_location_failed", r110.getNavInstanceId(), "message=" + th.getMessage(), th);
        return;
    L20:
        return;
    }

    public final boolean isLocationRunningForBusiness(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return !this.runtimeContexts.isEmpty();
    L12:
        return this.runtimeContexts.containsKey(r100);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final synchronized void stopLocationForBusiness(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L19;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        stopLocation(r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L19:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public static final /* synthetic */ boolean access$isReliableLatLng(ByteFusionContinuousLocation r100, BDLocation r101) {
        return r100.isReliableLatLng(r101);
    }

    private final void dispatchLocationChanged(final RuntimeContext r100, final BDLocation r101) {
        dispatchCallback(r100.getCallbackHandler(), r100.getNavInstanceId(), "dispatch_location_changed", new C104641(this, r100, r101));
    }

    private final void releaseCollectorSafely(SensorBatchAtomicCollector r100, String r101) {
        r100.release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.observer.logKeyNode("collector_release_failed", r101, "collector release failed", th);
    }

    private final LocationCallbackState resolveFailureCallbackState(RuntimeContext r100, long r101) {
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (r100.getStopped() == false) goto L6;
    L10:
        LocationCallbackState r102 = null;
    L11:
        monitor-exit(r100);
        return r102;
    L6:
        if (this.runtimeContexts.get(r100.getNavInstanceId()) != r100) goto L10;
        boolean r103 = r100.isFirstLocation();     // Catch: Throwable -> L13
        long r104 = r101 - r100.getLastCallbackElapsedRealtime();     // Catch: Throwable -> L13
        r100.setLastCallbackElapsedRealtime(r101);     // Catch: Throwable -> L13
        r102 = new LocationCallbackState(r103, r104, false);     // Catch: Throwable -> L13
        goto L11
    }

    private final void updateUploadNetSignalThrottle(RuntimeContext r100, boolean r101) {
        monitor-enter(r100);
        LocationOption r102 = r100.getOption();     // Catch: Throwable -> L17
        if (r102 == null) goto L6;
        r102.setEnableUploadNetSignal(false);     // Catch: Throwable -> L17
    L6:
        if (r101 == false) goto L14;
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L17
        if ((r103 - r100.getLastSetUploadNetSignalTime()) < BDLocationConfig.getUploadNetSignalInterval()) goto L14;
        LocationOption r104 = r100.getOption();     // Catch: Throwable -> L17
        if (r104 == null) goto L13;
        r104.setEnableUploadNetSignal(true);     // Catch: Throwable -> L17
    L13:
        r100.setLastSetUploadNetSignalTime(r103);     // Catch: Throwable -> L17
    L14:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r100);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$dispatchLocationChanged(ByteFusionContinuousLocation r100, RuntimeContext r101, BDLocation r102) {
        r100.dispatchLocationChanged(r101, r102);
    }

    public static final /* synthetic */ LocationCallbackState access$resolveFailureCallbackState(ByteFusionContinuousLocation r100, RuntimeContext r101, long r102) {
        return r100.resolveFailureCallbackState(r101, r102);
    }

    public static final /* synthetic */ void access$updateUploadNetSignalThrottle(ByteFusionContinuousLocation r100, RuntimeContext r101, boolean r102) {
        r100.updateUploadNetSignalThrottle(r101, r102);
    }

    private final LocationCallbackState resolveLocationCallbackState(RuntimeContext r100, boolean r101, long r102) {
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (r100.getStopped() == false) goto L6;
    L13:
        LocationCallbackState r103 = null;
    L14:
        monitor-exit(r100);
        return r103;
    L6:
        if (this.runtimeContexts.get(r100.getNavInstanceId()) != r100) goto L13;
        boolean r104 = r100.isFirstLocation();     // Catch: Throwable -> L16
        boolean r105 = resolveValidLatlng(r101, r100, r102);     // Catch: Throwable -> L16
        long r106 = r102 - r100.getLastCallbackElapsedRealtime();     // Catch: Throwable -> L16
        r100.setLastCallbackElapsedRealtime(r102);     // Catch: Throwable -> L16
        if (r105 == false) goto L11;
        r100.setFirstLocation(false);     // Catch: Throwable -> L16
    L11:
        r103 = new LocationCallbackState(r104, r106, r105);     // Catch: Throwable -> L16
        goto L14
    }

    private final boolean resolveValidLatlng(boolean r100, RuntimeContext r101, long r102) {
        if (r100 == false) goto L8;
        if (r101 == null) goto L6;
        r101.setLastValidLatlngElapsedRealtime(r102);
    L6:
        return true;
    L8:
        if (r101 != null) goto L11;
        return false;
    L11:
        if ((r102 - r101.getLastValidLatlngElapsedRealtime()) >= 2000) goto L13;
        return false;
    L13:
        r101.setLastValidLatlngElapsedRealtime(r102);
        return true;
    }

    private final boolean shouldLogSensorBatchPush(RuntimeContext r100, SensorBatch r101, long r102) {
        monitor-enter(r100);
        boolean r103 = true;
        if (r101.gps == null) goto L7;
        r100.setLastSensorBatchLogElapsedRealtime(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);
        return r103;
    L7:
        if ((r102 - r100.getLastSensorBatchLogElapsedRealtime()) >= 1000) goto L9;
        r103 = false;
        goto L10
    L9:
        r100.setLastSensorBatchLogElapsedRealtime(r102);     // Catch: Throwable -> L12
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
    public final synchronized void startLocation(BDLocationCallback r410, LocationOption r411, Looper r412) {
        BDLocationCallback r100 = r410;
        String r110 = "token=";
        monitor-enter(this);
        long r310 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L123
        Context r101 = this.context;     // Catch: Throwable -> L123
        if (r101 == null) goto L7;
        Context r111 = r101.getApplicationContext();     // Catch: Throwable -> L123
    L8:
        ?? r102 = ByteFusionLocationUtils.INSTANCE;     // Catch: Throwable -> L123
        final ?? r112 = r102.resolveNavInstanceId(r411, this.config);     // Catch: Throwable -> L123
        if (r412 == null) goto L11;
        ?? r113 = new Handler(r412);     // Catch: Throwable -> L123
    L12:
        if (r111 != null) goto L16;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "start_context_null", r112, "context is null", null, 8, null);     // Catch: Throwable -> L123
        uploadContinueLocationFailure(r411, BDLocationException.ERROR_CONTEXT_NULL, "context is null", SystemClock.elapsedRealtime() - r310);     // Catch: Throwable -> L123
        dispatchError(r113, r100, r102.newException("context is null", BDLocationException.ERROR_CONTEXT_NULL), r112);     // Catch: Throwable -> L123
        monitor-exit(this);
        return;
    L16:
        ByteFusionContinuousLocationObserver r103 = this.observer;     // Catch: Throwable -> L123
        String r311 = "message=";
        StringBuilder r114 = new StringBuilder("locateType=");     // Catch: Throwable -> L123
        if (r411 == null) goto L19;
        Integer r104 = Integer.valueOf(r411.getLocateType());     // Catch: Throwable -> L123
    L20:
        r114.append(r104);     // Catch: Throwable -> L123
        r114.append(", uploadSource=");     // Catch: Throwable -> L123
        if (r411 == null) goto L23;
        String r105 = r411.getUploadSource();     // Catch: Throwable -> L123
    L24:
        r114.append(r105);     // Catch: Throwable -> L123
        ByteFusionContinuousLocationObserver.logKeyNode$default(r103, "start_enter", r112, r114.toString(), null, 8, null);     // Catch: Throwable -> L123
        stopLocation(r112);     // Catch: Throwable -> L123
        String r312 = "startLocation exception: ";
        String r313 = "startLocation exception: ";
        boolean r314 = false;
        long r115 = BDLocationBridge.getBDLocationInstance(r112, this.trackerDelegate, this.loggerDelegate);     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "get_instance_result", r112, "nativeInstance=" + r115, null, 8, null);     // Catch: Throwable -> L105
        if (r115 != 0) goto L35;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "get_instance_failed", r112, "getBDLocationInstance failed", null, 8, null);     // Catch: Throwable -> L32
        uploadContinueLocationFailure(r411, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "getBDLocationInstance failed", SystemClock.elapsedRealtime() - r310);     // Catch: Throwable -> L32
        dispatchError(r113, r100, r102.newException("getBDLocationInstance failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r112);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L35:
        LocationConfig r106 = r102.buildLocationConfig(r411, r112);     // Catch: Throwable -> L105
        boolean r107 = BDLocationBridge.setLocationConfig(r112, r106);     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "set_config_result", r112, "workMode=" + r106.workMode + " userMoitionMode=" + r106.userMotionMode + " result=" + r107, null, 8, null);     // Catch: Throwable -> L105
        if (r107 == true) goto L40;
        uploadContinueLocationFailure(r411, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "setLocationConfig failed", SystemClock.elapsedRealtime() - r310);     // Catch: Throwable -> L32
        dispatchError(r113, r100, r102.newException("setLocationConfig failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r112);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L40:
        final Ref.LongRef r108 = new Ref.LongRef();     // Catch: Throwable -> L105
        r108.element = 0;     // Catch: Throwable -> L103
        long r116 = BDLocationBridge.addLocationListener(r112, new C104651(this, r112, r108));     // Catch: Throwable -> L105
        r108.element = r116;     // Catch: Throwable -> L105
        ByteFusionContinuousLocationObserver r109 = this.observer;     // Catch: Throwable -> L99
        StringBuilder r117 = new StringBuilder("token=");     // Catch: Throwable -> L99
        long r315 = r116;
        r117.append(r108.element);     // Catch: Throwable -> L97
        ByteFusionContinuousLocationObserver.logKeyNode$default(r109, "add_listener_result", r112, r117.toString(), null, 8, null);     // Catch: Throwable -> L97
        if (r108.element != 0) goto L136;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "add_listener_failed", r112, "addLocationListener failed", null, 8, null);     // Catch: Throwable -> L52
        uploadContinueLocationFailure(r411, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "addLocationListener failed", SystemClock.elapsedRealtime() - r310);     // Catch: Throwable -> L52
        dispatchError(r113, r100, r102.newException("addLocationListener failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r112);     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L136:
    L95:
        th = th;
        long r316 = r315;
        long r317 = 0;
    L102:
        Throwable r118 = th;
        long r119 = r316;
    L108:
        ?? r120 = 0;
        ?? r121 = r100;
        ?? r122 = r113;
        ?? r123 = r112;
    L109:
        stopLocation(r123);     // Catch: Throwable -> L123
        if (r314 == true) goto L120;
        if (r120 == 0) goto L114;
        releaseCollectorSafely(r120, r123);     // Catch: Throwable -> L123
    L114:
        if (r119 == r317) goto L120;
        BDLocationBridge.removeLocationListener(r123, r119);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        this.observer.logKeyNode("start_exception_remove_listener_failed", r123, r110 + r119, th);     // Catch: Throwable -> L123
    L120:
        this.observer.logKeyNode("start_exception", r123, r311 + r118.getMessage(), r118);     // Catch: Throwable -> L123
        uploadContinueLocationFailure(r411, "24", r312 + r118.getMessage(), SystemClock.elapsedRealtime() - r310);     // Catch: Throwable -> L123
        dispatchError(r122, r121, ByteFusionLocationUtils.INSTANCE.newException(r313 + r118.getMessage(), "24"), r123);     // Catch: Throwable -> L123
    L121:
        monitor-exit(this);
        return;
    L55:
        if (r411 == null) goto L59;
        Object r124 = r411.getBpeaCert();     // Catch: Throwable -> L52
        if (r124 == null) goto L59;
    L60:
        final ?? r125 = new SensorBatchAtomicCollector(r111, r124, null, 4, null);     // Catch: Throwable -> L95
        r125.updateCallback(new C104662(this, r112, r125));     // Catch: Throwable -> L91
        AbstractMap r126 = this.runtimeContexts;     // Catch: Throwable -> L91
        ?? r413 = r113;
        r110 = r110;
        r311 = r311;
        r113 = r108.element;     // Catch: Throwable -> L89
        r315 = r315;
        r317 = 0;
        r312 = r312;
        r313 = r313;
        r112 = r411;
        r125 = r410;
        r126.put(r112, new RuntimeContext(r112, r113, r125, r112, r125, r413, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime(), 0, null, 0, false, false, 7936, null));     // Catch: Throwable -> L87
        r314 = true;
        boolean r127 = BDLocationBridge.startLocation(r112, r112);     // Catch: Throwable -> L87
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "native_start_result", r112, "result=" + r127, null, 8, null);     // Catch: Throwable -> L87
        if (r127 == true) goto L83;
        RuntimeContext r128 = this.runtimeContexts.remove(r112);     // Catch: Throwable -> L87
        if (r128 != null) goto L138;
        r112 = r410;
        r125 = r125;
        r112 = r112;
    L75:
        releaseCollectorSafely(r125, r112);     // Catch: Throwable -> L80
        BDLocationBridge.removeLocationListener(r112, r108.element);     // Catch: Throwable -> L80
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "native_start_failed", r112, "startLocation failed, listener removed", null, 8, null);     // Catch: Throwable -> L80
        dispatchError(r413, r112, r102.newException("startLocation failed", BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT), r112);     // Catch: Throwable -> L85
        monitor-exit(this);
        return;
    L80:
        th = th;
    L81:
        r113 = r413;
    L94:
        r118 = th;
        r119 = r315;
        r121 = r112;
        r122 = r113;
        r123 = r112;
        r120 = r125;
        goto L109
    L138:
        r112 = r410;
        r125 = r125;
        r112 = r112;
        uploadContinueLocationFailure(r128, null, BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT, "startLocation failed", SystemClock.elapsedRealtime());     // Catch: Throwable -> L80
        markRuntimeStopped(r128);     // Catch: Throwable -> L80
        r112 = r112;
        r112 = r112;
        r125 = r125;
    L72:
        th = th;
        r112 = r410;
        r125 = r125;
        r112 = r112;
        goto L81
    L83:
        r125.start();     // Catch: Throwable -> L85
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "start_success", r112, "runtimeCount=" + this.runtimeContexts.size(), null, 8, null);     // Catch: Throwable -> L85
    L85:
        th = th;
    L87:
        th = th;
        r112 = r410;
        r113 = r413;
        r125 = r125;
        r112 = r112;
    L89:
        th = th;
        r317 = 0;
    L93:
        r112 = r100;
    L91:
        th = th;
        r317 = 0;
    L59:
        r124 = this.config.getBpeaCert();     // Catch: Throwable -> L95
    L52:
        th = th;
        r119 = r315;
        boolean r129 = false;
        r317 = 0;
    L34:
        r121 = r100;
        r118 = th;
        r122 = r113;
        r123 = r112;
        r120 = r129;
    L97:
        th = th;
        r110 = r110;
        r311 = r311;
        r313 = r313;
        r312 = r312;
        r316 = r315;
        r317 = 0;
    L99:
        th = th;
        r316 = r116;
        r317 = 0;
    L103:
        th = th;
        r317 = 0;
    L107:
        r118 = th;
        r119 = r317;
    L32:
        th = th;
        r119 = 0;
        r129 = false;
        r317 = 0;
    L105:
        th = th;
        r317 = 0;
        goto L107
    L23:
        r105 = null;
        goto L24
    L19:
        r104 = null;
        goto L20
    L11:
        r113 = 0;
        goto L12
    L7:
        r111 = null;
    L123:
        th = move-exception;
        throw th;
    }

    public final void updateNavigationHint(String r110, int r111, float r112) {
        if (r110 != null) goto L4;
    L7:
        boolean r100 = true;
    L8:
        if (r100 == false) goto L11;
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_ignored", "", "navInstanceId is null or empty", null, 8, null);
        return;
    L11:
        RuntimeContext r101 = this.runtimeContexts.get(r110);
        if (r101 != null) goto L14;
    L18:
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_ignored", r110, "runtime context not found", null, 8, null);
        return;
    L14:
        if (r101.getStopped() == true) goto L18;
        r101.getCollector().updateNavigationHint(r111, r112);
        ByteFusionContinuousLocationObserver.logKeyNode$default(this.observer, "navigation_hint_update_cached", r110, "navigationCode=" + r111 + ", projectionBearing=" + r112, null, 8, null);
        return;
    L4:
        if (r110.length() == 0) goto L7;
        r100 = false;
        goto L8
    }

    public static final /* synthetic */ LocationCallbackState access$resolveLocationCallbackState(ByteFusionContinuousLocation r100, RuntimeContext r101, boolean r102, long r103) {
        return r100.resolveLocationCallbackState(r101, r102, r103);
    }

    public static final /* synthetic */ boolean access$shouldLogSensorBatchPush(ByteFusionContinuousLocation r100, RuntimeContext r101, SensorBatch r102, long r103) {
        return r100.shouldLogSensorBatchPush(r101, r102, r103);
    }

    private final void dispatchCallback(Handler r100, final String r101, final String r102, final Function0<Unit> r103) {
        Runnable r104 = new ByteFusionContinuousLocation$dispatchCallback$runnable$1(this, r103, r101, r102);
        if (r100 == null) goto L5;
        r100.post(r104);
        return;
    L5:
        r104.run();
    }

    private final void dispatchError(Handler r100, final BDLocationCallback r101, final BDLocationException r102, String r103) {
        dispatchCallback(r100, r103, "dispatch_error", new AnonymousClass1(r101, r102));
    }

    private final void dispatchLocationChanged(Handler r100, final BDLocationCallback r101, final BDLocation r102, String r103) {
        dispatchCallback(r100, r103, "dispatch_location_changed", new AnonymousClass2(r101, r102));
    }

    private final void uploadContinueLocationFailure(LocationOption r110, String r111, String r112, long r113) {
        if (r110 == null) goto L5;
        boolean r100 = r110.isChineseRegion();
    L7:
        if (r110 == null) goto L11;
        String r101 = r110.getUploadSource();
        if (r101 == null) goto L11;
    L12:
        LocationMonitor.doContinueLocation(LocationInfoConst.BYTE_FUSION_CONTINUOUS, r111, r112, r100, 0, com.bytedance.bdlocation.BuildConfig.BDLOCATION_VERSION, r113, true, r101, null);
        return;
    L11:
        r101 = "unknown";
        goto L12
    L5:
        r100 = true;
        goto L7
    }

    private final void uploadContinueLocationFailure(RuntimeContext r100, BDLocation r101, String r102, String r110, long r111) {
        LocationCallbackState r103 = resolveFailureCallbackState(r100, r111);
        if (r103 == null) goto L6;
        uploadContinueLocationMonitor(r100, r101, r102, r110, r103);
        return;
    }

    private final void uploadContinueLocationMonitor(RuntimeContext r110, BDLocation r111, String r112, String r113, LocationCallbackState r114) {
        if (Intrinsics.areEqual("200", r112) == true) goto L5;
    L7:
        LocationOption r100 = r110.getOption();
        if (r100 == null) goto L10;
        boolean r101 = r100.isChineseRegion();
    L11:
        if (r111 == null) goto L13;
        int r102 = r111.getLocationType();
    L14:
        long r103 = r114.getDurationMs();
        boolean r104 = r114.isFirstLocation();
        LocationOption r105 = r110.getOption();
        if (r105 == null) goto L19;
        String r106 = r105.getUploadSource();
        if (r106 == null) goto L19;
    L20:
        LocationMonitor.doContinueLocation(LocationInfoConst.BYTE_FUSION_CONTINUOUS, r112, r113, r101, r102, com.bytedance.bdlocation.BuildConfig.BDLOCATION_VERSION, r103, r104, r106, null);
        return;
    L19:
        r106 = "unknown";
        goto L20
    L13:
        r102 = 0;
        goto L14
    L10:
        r101 = true;
        goto L11
    L5:
        if (r114.getValidLatlng() == true) goto L7;
    }

    public static final /* synthetic */ void access$uploadContinueLocationFailure(ByteFusionContinuousLocation r100, RuntimeContext r101, BDLocation r102, String r103, String r104, long r105) {
        r100.uploadContinueLocationFailure(r101, r102, r103, r104, r105);
    }

    public static final /* synthetic */ void access$uploadContinueLocationMonitor(ByteFusionContinuousLocation r100, RuntimeContext r101, BDLocation r102, String r103, String r104, LocationCallbackState r105) {
        r100.uploadContinueLocationMonitor(r101, r102, r103, r104, r105);
    }
}
