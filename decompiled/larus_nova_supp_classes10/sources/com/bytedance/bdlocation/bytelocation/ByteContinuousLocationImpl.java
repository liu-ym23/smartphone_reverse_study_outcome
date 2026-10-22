package com.bytedance.bdlocation.bytelocation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rr3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 S2\u00020\u0001:\u0002STB\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010P¢\u0006\u0004\bQ\u0010RJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0003J,\u0010\u001d\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J4\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J,\u0010\u001f\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020\nH\u0016J&\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010(\u001a\u00020\bH\u0016J\u0012\u0010*\u001a\u00020)2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010+\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010,\u001a\u00020\bJ\u0014\u0010/\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0018\u00103\u001a\u00020)2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0016J\u001c\u00107\u001a\u0002062\b\u00104\u001a\u0004\u0018\u00010-2\b\u00105\u001a\u0004\u0018\u00010-H\u0016R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010L\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010<R \u0010N\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl;", "Lcom/bytedance/bdlocation/BaseLocate;", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "callback", "Lcom/bytedance/bdlocation/client/LocationOption;", "option", "Landroid/os/Looper;", "looper", "", "startLocationLegacy", "", "businessId", "startLocationMulti", "Lrr3/a$a$b;", "result", "onSuccessLegacy", "onSuccessMulti", "reason", "errorCode", "onErrorLegacy", "onErrorMulti", "onError", "Landroid/location/Location;", LocationMonitorConst.LOCATION, "", "locationType", "Lcom/bytedance/bdlocation/BDLocation;", "transform", "errMessage", "uploadMonitorLegacy", "uploadMonitorMulti", "uploadMonitor", "stopAllBusinessLocations", "Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$ContinuousLocationContext;", "context", "stopContextSafely", "uploadLastLocation", "uploadLastLocationForBusiness", "getLocateName", "startLocation", "stopLocation", "", "isLocationRunningForBusiness", "stopLocationForBusiness", "stopAllLocations", "Lcom/bytedance/bdlocation/client/BDPoint;", LocationInfoConst.WGS_84, "convertGCJ02", "", "latitude", "longitude", "isAMapDataAvailable", "startLatlng", "endLatlng", "", "calculateLineDistance", "Lrr3/a;", "mLocationManager", "Lrr3/a;", "mLocationRunning", "Z", "", "mLock", "Ljava/lang/Object;", "", "mLastSetUploadNetSignalTime", "J", "mLocationLooper", "Landroid/os/Looper;", "mOption", "Lcom/bytedance/bdlocation/client/LocationOption;", "mLastLocation", "Lcom/bytedance/bdlocation/BDLocation;", "mCallback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "mLastLocationStartTime", "mIsFirstLocation", "Ljava/util/concurrent/ConcurrentHashMap;", "mContinuousClients", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion", "ContinuousLocationContext", "bytelocation_release"}, k = 1, mv = {1, 4, 0})
public final class ByteContinuousLocationImpl extends BaseLocate {
    public static final Companion Companion = null;
    private static final String DEFAULT_BUSINESS_ID = "default_continuous_location";
    private BDLocationCallback mCallback;
    private final ConcurrentHashMap<String, ContinuousLocationContext> mContinuousClients;
    private volatile boolean mIsFirstLocation;
    private volatile BDLocation mLastLocation;
    private volatile long mLastLocationStartTime;
    private volatile long mLastSetUploadNetSignalTime;
    private Looper mLocationLooper;
    private a mLocationManager;
    private volatile boolean mLocationRunning;
    private final Object mLock;
    private LocationOption mOption;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$Companion;", "", "()V", "DEFAULT_BUSINESS_ID", "", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b,\b\u0082\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\bH\u0010IJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\fHÆ\u0003J\t\u0010\u0011\u001a\u00020\u000eHÆ\u0003Jm\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000eHÆ\u0001J\t\u0010\u001d\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001f\u001a\u00020\u001eHÖ\u0001J\u0013\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010@\u001a\u0004\b\u0018\u0010A\"\u0004\bB\u0010CR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010;\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010@\u001a\u0004\bF\u0010A\"\u0004\bG\u0010C¨\u0006J"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$ContinuousLocationContext;", "", "Lrr3/a;", "component1", "Landroid/os/Looper;", "component2", "Lcom/bytedance/bdlocation/client/LocationOption;", "component3", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "component4", "Lcom/bytedance/bdlocation/BDLocation;", "component5", "", "component6", "", "component7", "component8", "component9", "manager", "looper", "option", "callback", "lastLocation", "startTime", "isFirstLocation", "lastSetUploadNetSignalTime", "running", "copy", "", "toString", "", "hashCode", "other", "equals", "Lrr3/a;", "getManager", "()Lrr3/a;", "setManager", "(Lrr3/a;)V", "Landroid/os/Looper;", "getLooper", "()Landroid/os/Looper;", "setLooper", "(Landroid/os/Looper;)V", "Lcom/bytedance/bdlocation/client/LocationOption;", "getOption", "()Lcom/bytedance/bdlocation/client/LocationOption;", "setOption", "(Lcom/bytedance/bdlocation/client/LocationOption;)V", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "getCallback", "()Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "setCallback", "(Lcom/bytedance/bdlocation/callback/BDLocationCallback;)V", "Lcom/bytedance/bdlocation/BDLocation;", "getLastLocation", "()Lcom/bytedance/bdlocation/BDLocation;", "setLastLocation", "(Lcom/bytedance/bdlocation/BDLocation;)V", "J", "getStartTime", "()J", "setStartTime", "(J)V", "Z", "()Z", "setFirstLocation", "(Z)V", "getLastSetUploadNetSignalTime", "setLastSetUploadNetSignalTime", "getRunning", "setRunning", "<init>", "(Lrr3/a;Landroid/os/Looper;Lcom/bytedance/bdlocation/client/LocationOption;Lcom/bytedance/bdlocation/callback/BDLocationCallback;Lcom/bytedance/bdlocation/BDLocation;JZJZ)V", "bytelocation_release"}, k = 1, mv = {1, 4, 0})
    public static final class ContinuousLocationContext {
        private BDLocationCallback callback;
        private boolean isFirstLocation;
        private BDLocation lastLocation;
        private long lastSetUploadNetSignalTime;
        private Looper looper;
        private a manager;
        private LocationOption option;
        private boolean running;
        private long startTime;

        public ContinuousLocationContext() {
            this(null, null, null, null, null, 0, false, 0, false, 511, null);
        }

        public static /* synthetic */ ContinuousLocationContext copy$default(ContinuousLocationContext r12, a r13, Looper r14, LocationOption r15, BDLocationCallback r16, BDLocation r17, long r18, boolean r20, long r21, boolean r23, int r24, Object r25) {
            if ((r24 & 1) == 0) goto L5;
            a r2 = r12.manager;
        L7:
            if ((r24 & 2) == 0) goto L9;
            Looper r3 = r12.looper;
        L11:
            if ((r24 & 4) == 0) goto L13;
            LocationOption r4 = r12.option;
        L15:
            if ((r24 & 8) == 0) goto L17;
            BDLocationCallback r5 = r12.callback;
        L19:
            if ((r24 & 16) == 0) goto L21;
            BDLocation r6 = r12.lastLocation;
        L23:
            if ((r24 & 32) == 0) goto L25;
            long r7 = r12.startTime;
        L27:
            if ((r24 & 64) == 0) goto L29;
            boolean r9 = r12.isFirstLocation;
        L31:
            if ((r24 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
            long r10 = r12.lastSetUploadNetSignalTime;
        L35:
            if ((r24 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
            boolean r1 = r12.running;
        L39:
            return r12.copy(r2, r3, r4, r5, r6, r7, r9, r10, r1);
        L37:
            r1 = r23;
            goto L39
        L33:
            r10 = r21;
            goto L35
        L29:
            r9 = r20;
            goto L31
        L25:
            r7 = r18;
            goto L27
        L21:
            r6 = r17;
            goto L23
        L17:
            r5 = r16;
            goto L19
        L13:
            r4 = r15;
            goto L15
        L9:
            r3 = r14;
            goto L11
        L5:
            r2 = r13;
            goto L7
        }

        public final a component1() {
            return this.manager;
        }

        public final Looper component2() {
            return this.looper;
        }

        public final LocationOption component3() {
            return this.option;
        }

        public final BDLocationCallback component4() {
            return this.callback;
        }

        public final BDLocation component5() {
            return this.lastLocation;
        }

        public final long component6() {
            return this.startTime;
        }

        public final boolean component7() {
            return this.isFirstLocation;
        }

        public final long component8() {
            return this.lastSetUploadNetSignalTime;
        }

        public final boolean component9() {
            return this.running;
        }

        public final ContinuousLocationContext copy(a r14, Looper r15, LocationOption r16, BDLocationCallback r17, BDLocation r18, long r19, boolean r21, long r22, boolean r24) {
            return new ContinuousLocationContext(r14, r15, r16, r17, r18, r19, r21, r22, r24);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof ContinuousLocationContext) == false) goto L24;
            ContinuousLocationContext r7 = (ContinuousLocationContext) r6;
            if (Intrinsics.areEqual(this.manager, r7.manager) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.looper, r7.looper) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.option, r7.option) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.callback, r7.callback) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.lastLocation, r7.lastLocation) == true) goto L16;
            return false;
        L16:
            if (this.startTime == r7.startTime) goto L18;
            return false;
        L18:
            if (this.isFirstLocation == r7.isFirstLocation) goto L20;
            return false;
        L20:
            if (this.lastSetUploadNetSignalTime == r7.lastSetUploadNetSignalTime) goto L22;
            return false;
        L22:
            if (this.running == r7.running) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        public int hashCode() {
            a r0 = this.manager;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Looper r4 = this.looper;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            LocationOption r7 = this.option;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            BDLocationCallback r10 = this.callback;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            BDLocation r13 = this.lastLocation;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            int r14 = (r12 + r1) * 31;
            long r15 = this.startTime;
            int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
            boolean r17 = this.isFirstLocation;
            ?? r18 = 1;
            ?? r19 = r17;
            if (r17 == false) goto L24;
            r19 = 1;
        L24:
            long r20 = this.lastSetUploadNetSignalTime;
            int r21 = (((r16 + r19) * 31) + ((int) (r20 ^ (r20 >>> 32)))) * 31;
            boolean r22 = this.running;
            if (r22 == true) goto L29;
            r18 = r22;
        L29:
            return r21 + r18;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ContinuousLocationContext(manager=" + this.manager + ", looper=" + this.looper + ", option=" + this.option + ", callback=" + this.callback + ", lastLocation=" + this.lastLocation + ", startTime=" + this.startTime + ", isFirstLocation=" + this.isFirstLocation + ", lastSetUploadNetSignalTime=" + this.lastSetUploadNetSignalTime + ", running=" + this.running + ")";
        }

        public final BDLocationCallback getCallback() {
            return this.callback;
        }

        public final BDLocation getLastLocation() {
            return this.lastLocation;
        }

        public final long getLastSetUploadNetSignalTime() {
            return this.lastSetUploadNetSignalTime;
        }

        public final Looper getLooper() {
            return this.looper;
        }

        public final a getManager() {
            return this.manager;
        }

        public final LocationOption getOption() {
            return this.option;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final boolean isFirstLocation() {
            return this.isFirstLocation;
        }

        public final void setCallback(BDLocationCallback r1) {
            this.callback = r1;
        }

        public final void setFirstLocation(boolean r1) {
            this.isFirstLocation = r1;
        }

        public final void setLastLocation(BDLocation r1) {
            this.lastLocation = r1;
        }

        public final void setLastSetUploadNetSignalTime(long r1) {
            this.lastSetUploadNetSignalTime = r1;
        }

        public final void setLooper(Looper r1) {
            this.looper = r1;
        }

        public final void setManager(a r1) {
            this.manager = r1;
        }

        public final void setOption(LocationOption r1) {
            this.option = r1;
        }

        public final void setRunning(boolean r1) {
            this.running = r1;
        }

        public final void setStartTime(long r1) {
            this.startTime = r1;
        }

        public ContinuousLocationContext(a r1, Looper r2, LocationOption r3, BDLocationCallback r4, BDLocation r5, long r6, boolean r8, long r9, boolean r11) {
            this.manager = r1;
            this.looper = r2;
            this.option = r3;
            this.callback = r4;
            this.lastLocation = r5;
            this.startTime = r6;
            this.isFirstLocation = r8;
            this.lastSetUploadNetSignalTime = r9;
            this.running = r11;
        }

        public /* synthetic */ ContinuousLocationContext(a r13, Looper r14, LocationOption r15, BDLocationCallback r16, BDLocation r17, long r18, boolean r20, long r21, boolean r23, int r24, DefaultConstructorMarker r25) {
            BDLocation r2 = null;
            if ((r24 & 1) == 0) goto L5;
            a r1 = null;
        L7:
            if ((r24 & 2) == 0) goto L9;
            Looper r3 = null;
        L11:
            if ((r24 & 4) == 0) goto L13;
            LocationOption r4 = null;
        L15:
            if ((r24 & 8) == 0) goto L17;
            BDLocationCallback r5 = null;
        L19:
            if ((r24 & 16) != 0) goto L22;
            r2 = r17;
        L22:
            long r7 = 0;
            if ((r24 & 32) == 0) goto L25;
            long r9 = 0;
        L27:
            if ((r24 & 64) == 0) goto L29;
            boolean r6 = true;
        L31:
            if ((r24 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
            r7 = r21;
        L35:
            if ((r24 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
            boolean r0 = false;
        L38:
            this(r1, r3, r4, r5, r2, r9, r6, r7, r0);
            return;
        L37:
            r0 = r23;
            goto L38
        L29:
            r6 = r20;
            goto L31
        L25:
            r9 = r18;
            goto L27
        L17:
            r5 = r16;
            goto L19
        L13:
            r4 = r15;
            goto L15
        L9:
            r3 = r14;
            goto L11
        L5:
            r1 = r13;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public float calculateLineDistance(BDPoint r1, BDPoint r2) {
        return -1.0f;
    }

    public BDPoint convertGCJ02(BDPoint r1) {
        return null;
    }

    public String getLocateName() {
        return LocationInfoConst.BYTE_CONTINUOUS;
    }

    public boolean isAMapDataAvailable(double r1, double r3) {
        return false;
    }

    private final void stopAllBusinessLocations() {
        Iterator<Map.Entry<String, ContinuousLocationContext>> r0 = this.mContinuousClients.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, ContinuousLocationContext> r1 = r0.next();
        String r2 = r1.getKey();
        stopContextSafely(r1.getValue(), r2);
        goto L4
    L6:
        this.mContinuousClients.clear();
        Logger.i("ByteContinuousLocationImpl stopAllBusinessLocations completed");
    }

    private final void uploadLastLocation() {
        if (this.mLastLocation == null) goto L12;
        BDLocationCallback r0 = this.mCallback;
        if (r0 == null) goto L10;
        LocationOption r1 = this.mOption;
        if (r1 == null) goto L9;
        r1.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocation");
        r0.onLocationChanged(this.mLastLocation);
    L10:
        this.mCallback = null;
        return;
    }

    public final void stopAllLocations() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == false) goto L16;
        a r2 = this.mLocationManager;     // Catch: Throwable -> L19
        if (r2 != null) goto L24;
    L12:
        this.mLocationRunning = false;     // Catch: Throwable -> L19
        this.mLocationManager = null;     // Catch: Throwable -> L19
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L19
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L15;
        uploadLastLocation();     // Catch: Throwable -> L19
    L15:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L19
        goto L16
    L24:
        r2.c();     // Catch: Exception -> L10 Throwable -> L19
    L10:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L19
    L16:
        stopAllBusinessLocations();     // Catch: Throwable -> L19
        Logger.i("ByteContinuousLocationImpl stopAllLocations (legacy + all multi business)");     // Catch: Throwable -> L19
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r1);
    }

    public void stopLocation() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == true) goto L7;
        Logger.i("location is not running, stopLocation is ignored (legacy mode only)");     // Catch: Throwable -> L20
    L17:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        return;
    L7:
        a r2 = this.mLocationManager;     // Catch: Throwable -> L20
        if (r2 != null) goto L23;
    L13:
        this.mLocationRunning = false;     // Catch: Throwable -> L20
        this.mLocationManager = null;     // Catch: Throwable -> L20
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L20
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L16;
        uploadLastLocation();     // Catch: Throwable -> L20
    L16:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L20
        Logger.i("ByteContinuousLocationImpl stopLocation (legacy mode only)");     // Catch: Throwable -> L20
        goto L17
    L23:
        r2.c();     // Catch: Exception -> L11 Throwable -> L20
    L11:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L20
        goto L13
    }

    public ByteContinuousLocationImpl(Context r1) {
        super(r1);
        this.mLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMContinuousClients$p(ByteContinuousLocationImpl r0) {
        return r0.mContinuousClients;
    }

    public static final /* synthetic */ long access$getMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r2) {
        return r2.mLastSetUploadNetSignalTime;
    }

    private final void uploadLastLocationForBusiness(ContinuousLocationContext r4) {
        if (r4.getLastLocation() == null) goto L11;
        BDLocationCallback r0 = r4.getCallback();
        if (r0 == null) goto L12;
        LocationOption r1 = r4.getOption();
        if (r1 == null) goto L9;
        r1.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocationForBusiness");
        r0.onLocationChanged(r4.getLastLocation());
        return;
    L12:
        return;
    }

    public boolean isLocationRunningForBusiness(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = false;
        if (r5 != null) goto L24;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        r1 = this.mLocationRunning;     // Catch: Throwable -> L10
    L20:
        monitor-exit(r0);
        return r1;
    L15:
        ContinuousLocationContext r6 = this.mContinuousClients.get(r5);     // Catch: Throwable -> L10
        if (r6 == null) goto L20;
        if (r6.getRunning() != true) goto L20;
        r1 = true;
        goto L20
    L24:
    L10:
        th = move-exception;
        throw th;
    L7:
        if (r5.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    public void stopLocationForBusiness(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        Logger.w("ByteContinuousLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L12:
        Object r3 = this.mLock;
        monitor-enter(r3);
        ContinuousLocationContext r4 = this.mContinuousClients.remove(r5);     // Catch: Throwable -> L21
        if (r4 == null) goto L17;
        stopContextSafely(r4, r5);     // Catch: Throwable -> L21
        Logger.i("ByteContinuousLocationImpl stopLocationForBusiness: " + r5 + ", remaining clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L21
    L18:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r3);
        return;
    L17:
        Logger.i("ByteContinuousLocationImpl stopLocationForBusiness: businessId not found: " + r5);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final /* synthetic */ void access$setMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r0, long r1) {
        r0.mLastSetUploadNetSignalTime = r1;
    }

    private final void stopContextSafely(ContinuousLocationContext r4, String r5) {
        a r1 = r4.getManager();     // Catch: Exception -> L13
        if (r1 != null) goto L18;
    L9:
        r4.setRunning(false);     // Catch: Exception -> L13
        r4.setManager(null);     // Catch: Exception -> L13
        r4.setLastSetUploadNetSignalTime(0);     // Catch: Exception -> L13
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L20;
        uploadLastLocationForBusiness(r4);     // Catch: Exception -> L13
        return;
    L20:
        return;
    L18:
        r1.c();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Logger.e("stopContextSafely error: " + e.getMessage() + ", businessId: " + r5);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Logger.e("ByteContinuousLocationImpl stopContextSafely error", e);
    }

    private final BDLocation transform(Location r4, int r5) {
        if (r4 == null) goto L8;
        BDLocation r0 = new BDLocation(r4, getLocateName());
        r0.setLocationType(r5);
        r0.setLocationMs(System.currentTimeMillis());
        r0.setTrustedLevel(1);
        Bundle r6 = r4.getExtras();
        int r7 = 0;
        if (r6 == null) goto L6;
        r7 = r6.getInt("satellites", 0);
    L6:
        r0.setSatellites(r7);
        return r0;
    L8:
        return null;
    }

    private final void onSuccessLegacy(a.a.b r6, LocationOption r7, BDLocationCallback r8) {
        Location r2 = r6.a;     // Catch: Exception -> L6
        int r9 = r6.b;     // Catch: Exception -> L6
        if (r2 == null) goto L8;
        String r3 = r2.getProvider();     // Catch: Exception -> L6
    L9:
        Logger.i("location locationType: " + r9 + " - provider: " + r3);     // Catch: Exception -> L6
        BDLocation r10 = transform(r2, r9);     // Catch: Exception -> L6
        if (r10 != null) goto L13;
        onError("location is null", r7, BDLocationException.ERROR_UNKNOWN, r8);     // Catch: Exception -> L6
        return;
    L13:
        this.mLastLocation = r10;     // Catch: Exception -> L6
        uploadMonitorLegacy(r10, r7, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L6
        if (r8 == null) goto L20;
        r8.onLocationChanged(r10);     // Catch: Exception -> L6
        return;
    L20:
        return;
    L8:
        r3 = null;
    L6:
        e = move-exception;
        Logger.e("onSuccessLegacy error:", e);
        onError("onSuccessLegacy error", r7, BDLocationException.ERROR_UNKNOWN, r8);
    }

    private final void startLocationLegacy(final BDLocationCallback r8, final LocationOption r9, final Looper r10) {
        Object r2 = this.mLock;     // Catch: Exception -> L36
        monitor-enter(r2);     // Catch: Exception -> L36
        this.mLocationLooper = r10;     // Catch: Throwable -> L33
        this.mOption = r9;     // Catch: Throwable -> L33
        this.mCallback = r8;     // Catch: Throwable -> L33
        boolean r3 = true;
        this.mIsFirstLocation = true;     // Catch: Throwable -> L33
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L33
        super.startLocation(r8, r9, r10);     // Catch: Throwable -> L33
        if (LocationUtil.isLocationEnabled() == true) goto L11;
        BDLocationException r11 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L33
        if (r8 == null) goto L30;
        r8.onError(r11);     // Catch: Throwable -> L33
    L30:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r2);     // Catch: Exception -> L36
        return;
    L11:
        if (LocationUtil.checkBackground() == false) goto L15;
        if (r8 == null) goto L30;
        r8.onError(new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE));     // Catch: Throwable -> L33
        goto L30
    L15:
        if (((BaseLocate) this).mContext != null) goto L19;
        BDLocationException r13 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L33
        if (r8 == null) goto L30;
        r8.onError(r13);     // Catch: Throwable -> L33
        goto L30
    L19:
        a r4 = this.mLocationManager;     // Catch: Throwable -> L33
        if (r4 == null) goto L22;
        r4.c();     // Catch: Throwable -> L33
    L22:
        this.mLocationRunning = false;     // Catch: Throwable -> L33
        this.mLocationManager = null;     // Catch: Throwable -> L33
        a r5 = new a(((BaseLocate) this).mContext, r9, r10, new ByteContinuousLocationImpl$startLocationLegacy$$inlined$synchronized$lambda$1(this, r10, r9, r8));     // Catch: Throwable -> L33
        this.mLocationManager = r5;     // Catch: Throwable -> L33
        if (r5.b() == true) goto L26;
        r3 = false;
    L26:
        this.mLocationRunning = r3;     // Catch: Throwable -> L33
        if (this.mLocationRunning == true) goto L29;
        this.mLocationManager = null;     // Catch: Throwable -> L33
        Logger.e("ByteContinuousLocationImpl startLocationLegacy failed");     // Catch: Throwable -> L33
        goto L30
    L29:
        Logger.i("ByteContinuousLocationImpl startLocationLegacy completed");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        this.mLocationRunning = false;
        this.mLocationManager = null;
        Logger.e("startLocation error:", e);
        onError("startLocation error", r9, BDLocationException.ERROR_UNKNOWN, r8);
    }

    public void startLocation(BDLocationCallback r3, LocationOption r4, Looper r5) {
        if (r4 == null) goto L4;
        String r0 = r4.getBusinessId();
    L5:
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
        startLocationLegacy(r3, r4, r5);
        return;
    L14:
        startLocationMulti(r0, r3, r4, r5);
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L4:
        r0 = null;
        goto L5
    }

    public static final /* synthetic */ void access$onSuccessLegacy(ByteContinuousLocationImpl r0, a.a.b r1, LocationOption r2, BDLocationCallback r3) {
        r0.onSuccessLegacy(r1, r2, r3);
    }

    private final void onError(String r3, LocationOption r4, String r5, BDLocationCallback r6) {
        BDLocationException r0 = new BDLocationException(r3, getLocateName(), r5);
        uploadMonitorLegacy(null, r4, r5, r3);
        if (r6 == null) goto L6;
        r6.onError(r0);
        return;
    }

    private final void onErrorLegacy(String r3, LocationOption r4, String r5, BDLocationCallback r6) {
        BDLocationException r0 = new BDLocationException(r3, getLocateName(), r5);
        uploadMonitorLegacy(null, r4, r5, r3);
        if (r6 == null) goto L6;
        r6.onError(r0);
        return;
    }

    private final void onSuccessMulti(String r10, a.a.b r11, LocationOption r12, BDLocationCallback r13) {
        Location r2 = r11.a;     // Catch: Exception -> L6
        int r14 = r11.b;     // Catch: Exception -> L6
        if (r2 == null) goto L8;
        String r3 = r2.getProvider();     // Catch: Exception -> L6
    L9:
        Logger.i("location locationType: " + r14 + " - provider: " + r3 + ", businessId: " + r10);     // Catch: Exception -> L6
        BDLocation r15 = transform(r2, r14);     // Catch: Exception -> L6
        if (r15 != null) goto L13;
        onError("location is null", r12, BDLocationException.ERROR_UNKNOWN, r13);     // Catch: Exception -> L6
        return;
    L13:
        ContinuousLocationContext r1 = this.mContinuousClients.get(r10);     // Catch: Exception -> L6
        if (r1 == null) goto L16;
        r1.setLastLocation(r15);     // Catch: Exception -> L6
        uploadMonitorMulti(r10, r15, r12, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L6
    L16:
        if (r13 == null) goto L22;
        r13.onLocationChanged(r15);     // Catch: Exception -> L6
        return;
    L22:
        return;
    L8:
        r3 = null;
    L6:
        e = move-exception;
        Logger.e("onSuccessMulti error:", e);
        onError("onSuccessMulti error", r12, BDLocationException.ERROR_UNKNOWN, r13);
    }

    private final void startLocationMulti(final String r25, final BDLocationCallback r26, final LocationOption r27, final Looper r28) {
        Object r1 = this.mLock;     // Catch: Exception -> L43
        monitor-enter(r1);     // Catch: Exception -> L43
        stopLocationForBusiness(r25);     // Catch: Throwable -> L37
        super.startLocation(r26, r27, r28);     // Catch: Throwable -> L37
        if (LocationUtil.isLocationEnabled() == true) goto L11;
        BDLocationException r0 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L37
        if (r26 == null) goto L14;
        r26.onError(r0);     // Catch: Throwable -> L37
    L14:
        Object r11 = r1;
    L32:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r11);     // Catch: Exception -> L41
        return;
    L35:
        th = th;
    L39:
        monitor-exit(r11);     // Catch: Exception -> L41
        throw th;     // Catch: Exception -> L41
    L11:
        if (LocationUtil.checkBackground() == false) goto L16;
        if (r26 == null) goto L14;
        r26.onError(new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE));     // Catch: Throwable -> L37
        goto L14
    L16:
        if (((BaseLocate) this).mContext != null) goto L20;
        BDLocationException r3 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L37
        if (r26 == null) goto L14;
        r26.onError(r3);     // Catch: Throwable -> L37
        goto L14
    L20:
        ContinuousLocationContext r14 = new ContinuousLocationContext(null, r28, r27, r26, null, SystemClock.elapsedRealtime(), true, 0, false, 17, null);     // Catch: Throwable -> L37
        r11 = r1;
        r14.setManager(new a(((BaseLocate) this).mContext, r27, r28, new ByteContinuousLocationImpl$startLocationMulti$$inlined$synchronized$lambda$1(this, r25, r26, r27, r28)));     // Catch: Throwable -> L35
        a r4 = r14.getManager();     // Catch: Throwable -> L35
        if (r4 == null) goto L27;
        boolean r5 = true;
        if (r4.b() != true) goto L27;
    L28:
        r14.setRunning(r5);     // Catch: Throwable -> L35
        if (r14.getRunning() == true) goto L31;
        r14.setManager(null);     // Catch: Throwable -> L35
        Logger.e("ByteContinuousLocationImpl startLocationMulti failed, businessId: " + r25);     // Catch: Throwable -> L35
        goto L32
    L31:
        this.mContinuousClients.put(r25, r14);     // Catch: Throwable -> L35
        Logger.i("ByteContinuousLocationImpl startLocationMulti completed, businessId: " + r25 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L35
    L27:
        r5 = false;
    L37:
        th = th;
        r11 = r1;
    L41:
        e = e;
    L45:
        Logger.e("startLocationMulti error:", e);
        onError("startLocationMulti error", r27, BDLocationException.ERROR_UNKNOWN, r26);
        return;
    L43:
        e = e;
        goto L45
    }

    private final void uploadMonitor(BDLocation r1, LocationOption r2, String r3, String r4) {
        uploadMonitorLegacy(r1, r2, r3, r4);
    }

    private final void uploadMonitorLegacy(BDLocation r17, LocationOption r18, String r19, String r20) {
        long r11 = SystemClock.elapsedRealtime() - this.mLastLocationStartTime;
        StringBuilder r1 = new StringBuilder("uploadMonitorLegacy: ");
        r1.append(r11);
        r1.append("ms, provider: ");
        Integer r2 = null;
        if (r17 == null) goto L5;
        String r3 = r17.getProvider();
    L6:
        r1.append(r3);
        r1.append(", locationType: ");
        if (r17 == null) goto L9;
        r2 = Integer.valueOf(r17.getLocationType());
    L9:
        r1.append(r2);
        r1.append(", mIsFirstLocation: ");
        r1.append(this.mIsFirstLocation);
        Logger.i(r1.toString());
        String r5 = getLocateName();
        if (r18 == null) goto L12;
        boolean r8 = r18.isChineseRegion();
    L14:
        if (r17 == null) goto L16;
        int r9 = r17.getLocationType();
    L17:
        boolean r13 = this.mIsFirstLocation;
        if (r18 == null) goto L22;
        String r4 = r18.getUploadSource();
        if (r4 == null) goto L22;
    L23:
        LocationMonitor.doContinueLocation(r5, r19, r20, r8, r9, "2.17.6-rc.81", r11, r13, r4, null);
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();
        this.mIsFirstLocation = false;
        return;
    L22:
        r4 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
        goto L23
    L16:
        r9 = 0;
        goto L17
    L12:
        r8 = true;
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ void access$onErrorLegacy(ByteContinuousLocationImpl r0, String r1, LocationOption r2, String r3, BDLocationCallback r4) {
        r0.onErrorLegacy(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$onSuccessMulti(ByteContinuousLocationImpl r0, String r1, a.a.b r2, LocationOption r3, BDLocationCallback r4) {
        r0.onSuccessMulti(r1, r2, r3, r4);
    }

    private final void onErrorMulti(String r9, String r10, LocationOption r11, String r12, BDLocationCallback r13) {
        BDLocationException r0 = new BDLocationException(r10, getLocateName(), r12);
        uploadMonitorMulti(r9, null, r11, r12, r10);
        if (r13 == null) goto L6;
        r13.onError(r0);
        return;
    }

    private final void uploadMonitorMulti(String r21, BDLocation r22, LocationOption r23, String r24, String r25) {
        Object r3 = this.mLock;
        monitor-enter(r3);
        ContinuousLocationContext r4 = this.mContinuousClients.get(r21);     // Catch: Throwable -> L31
        if (r4 == null) goto L28;
        long r5 = SystemClock.elapsedRealtime() - r4.getStartTime();     // Catch: Throwable -> L31
        StringBuilder r7 = new StringBuilder("uploadMonitorMulti: ");     // Catch: Throwable -> L31
        r7.append(r5);     // Catch: Throwable -> L31
        r7.append("ms, provider: ");     // Catch: Throwable -> L31
        Integer r2 = null;
        if (r22 == null) goto L9;
        String r8 = r22.getProvider();     // Catch: Throwable -> L31
    L10:
        r7.append(r8);     // Catch: Throwable -> L31
        r7.append(", locationType: ");     // Catch: Throwable -> L31
        if (r22 == null) goto L13;
        r2 = Integer.valueOf(r22.getLocationType());     // Catch: Throwable -> L31
    L13:
        r7.append(r2);     // Catch: Throwable -> L31
        r7.append(", isFirstLocation: ");     // Catch: Throwable -> L31
        r7.append(r4.isFirstLocation());     // Catch: Throwable -> L31
        r7.append(", businessId: ");     // Catch: Throwable -> L31
        r7.append(r21);     // Catch: Throwable -> L31
        Logger.i(r7.toString());     // Catch: Throwable -> L31
        String r9 = getLocateName();     // Catch: Throwable -> L31
        if (r23 == null) goto L16;
        boolean r12 = r23.isChineseRegion();     // Catch: Throwable -> L31
    L18:
        if (r22 == null) goto L20;
        int r13 = r22.getLocationType();     // Catch: Throwable -> L31
    L21:
        boolean r17 = r4.isFirstLocation();     // Catch: Throwable -> L31
        if (r23 == null) goto L26;
        String r6 = r23.getUploadSource();     // Catch: Throwable -> L31
        if (r6 == null) goto L26;
    L27:
        LocationMonitor.doContinueLocation(r9, r24, r25, r12, r13, "2.17.6-rc.81", r5, r17, r6, null);     // Catch: Throwable -> L31
        r4.setStartTime(SystemClock.elapsedRealtime());     // Catch: Throwable -> L31
        r4.setFirstLocation(false);     // Catch: Throwable -> L31
    L26:
        r6 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
        goto L27
    L20:
        r13 = 0;
        goto L21
    L16:
        r12 = true;
        goto L18
    L9:
        r8 = null;
    L28:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r3);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$onErrorMulti(ByteContinuousLocationImpl r0, String r1, String r2, LocationOption r3, String r4, BDLocationCallback r5) {
        r0.onErrorMulti(r1, r2, r3, r4, r5);
    }
}
