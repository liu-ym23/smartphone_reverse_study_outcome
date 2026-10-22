package com.bytedance.bdlocation.satellite;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDSatelliteInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class GnssInfoManager {
    private static volatile GnssInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private Context mContext;
    private volatile BDGnssInfo mCurrentGnssInfo;
    private GnssStatus.Callback mGnssStatusCallback;
    private GpsStatus.Listener mGpsStatusListener;
    private Handler mHandler;
    private LocationManager mLocationManager;
    private final Object mLock;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.satellite.GnssInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class GnssStatusCallbackImpl extends GnssStatus.Callback {
        final /* synthetic */ GnssInfoManager this$0;

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            super.onStarted();
            Logger.i("GnssInfoManager: GnssStatusCallback onStarted");
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            super.onStopped();
            Logger.i("GnssInfoManager: GnssStatusCallback onStopped");
        }

        private GnssStatusCallbackImpl(GnssInfoManager r1) {
            this.this$0 = r1;
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            int r0 = r8.getSatelliteCount();
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            int r3 = 0;
        L5:
            if (r3 >= r0) goto L10;
            BDSatelliteInfo r4 = new BDSatelliteInfo();
            r4.sVid = r8.getSvid(r3);
            r4.snr = r8.getCn0DbHz(r3);
            r4.azimuthDegrees = r8.getAzimuthDegrees(r3);
            r4.elevationDegrees = r8.getElevationDegrees(r3);
            r4.constellationType = r8.getConstellationType(r3);
            if (Build.VERSION.SDK_INT < 26) goto L9;
            r4.hasCarrierFrequencyHz = r8.hasCarrierFrequencyHz(r3);
            r4.carrierFrequencyHz = r8.getCarrierFrequencyHz(r3);
        L9:
            r4.usedInFix = r8.usedInFix(r3);
            r1.add(r4);
            r2.add(Float.valueOf(r4.snr));
            r3 = r3 + 1;
            goto L5
        L10:
            BDGnssInfo r9 = new BDGnssInfo();
            r9.satelliteNum = r0;
            r9.satelliteInfos = r1;
            r9.snr = r2;
            r9.timestamp = System.currentTimeMillis();
            r9.callbackClock = SystemClock.elapsedRealtime();
            GnssInfoManager.access$200(this.this$0, r9);
            Logger.i("GnssInfoManager: onSatelliteStatusChanged, satellite count: " + r0 + " satelliteInfos: " + JsonUtil.safeToJsonTree(r1));
        }

        public /* synthetic */ GnssStatusCallbackImpl(GnssInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public class GpsStatusListenerImpl implements GpsStatus.Listener {
        final /* synthetic */ GnssInfoManager this$0;

        private GpsStatusListenerImpl(GnssInfoManager r1) {
            this.this$0 = r1;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r8) {
            if (r8 != 1) goto L5;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_STARTED");
            return;
        L5:
            if (r8 != 2) goto L7;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_STOPPED");
            return;
        L7:
            if (r8 != 3) goto L9;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_FIRST_FIX");
            return;
        L9:
            if (r8 == 4) goto L12;
            return;
        L12:
            if (GnssInfoManager.access$300(this.this$0) != null) goto L14;
            return;
        L14:
            GpsStatus r9 = GnssInfoManager.access$300(this.this$0).getGpsStatus(null);
            if (r9 != null) goto L17;
            return;
        L17:
            int r0 = r9.getMaxSatellites();
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            Iterator<GpsSatellite> r10 = r9.getSatellites().iterator();
            int r3 = 0;
        L19:
            if (r10.hasNext() == false) goto L22;
            if (r3 >= r0) goto L22;
            GpsSatellite r4 = r10.next();
            BDSatelliteInfo r5 = new BDSatelliteInfo();
            r5.snr = r4.getSnr();
            r5.azimuthDegrees = r4.getAzimuth();
            r5.elevationDegrees = r4.getElevation();
            r5.usedInFix = r4.usedInFix();
            r5.sVid = r4.getPrn();
            r1.add(r5);
            r2.add(Float.valueOf(r5.snr));
            r3 = r3 + 1;
        L22:
            BDGnssInfo r11 = new BDGnssInfo();
            r11.satelliteNum = r0;
            r11.satelliteInfos = r1;
            r11.snr = r2;
            r11.timestamp = System.currentTimeMillis();
            r11.callbackClock = SystemClock.elapsedRealtime();
            GnssInfoManager.access$200(this.this$0, r11);
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_SATELLITE_STATUS, count: " + r3);
        }

        public /* synthetic */ GpsStatusListenerImpl(GnssInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public synchronized BDGnssInfo getCurrentGnssInfo() {
        monitor-enter(this);
        BDGnssInfo r0 = this.mCurrentGnssInfo;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterGnssCallback() {
        monitor-enter(this);
        LocationManager r0 = this.mLocationManager;     // Catch: Throwable -> L15 Exception -> L17
        if (r0 != null) goto L6;
    L19:
        monitor-exit(this);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        GnssStatus.Callback r1 = this.mGnssStatusCallback;     // Catch: Throwable -> L15 Exception -> L17
        if (r1 == null) goto L13;
        r0.unregisterGnssStatusCallback(r1);     // Catch: Throwable -> L15 Exception -> L17
        this.mGnssStatusCallback = null;     // Catch: Throwable -> L15 Exception -> L17
    L13:
        Logger.i("GnssInfoManager: unregisterGnssCallback success");     // Catch: Throwable -> L15 Exception -> L17
    L10:
        GpsStatus.Listener r2 = this.mGpsStatusListener;     // Catch: Throwable -> L15 Exception -> L17
        if (r2 == null) goto L13;
        r0.removeGpsStatusListener(r2);     // Catch: Throwable -> L15 Exception -> L17
        this.mGpsStatusListener = null;     // Catch: Throwable -> L15 Exception -> L17
    L15:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        Logger.e("GnssInfoManager: unregisterGnssCallback error", e);     // Catch: Throwable -> L15
        goto L19
    }

    public static GnssInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(GnssInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GnssInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(GnssInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private GnssInfoManager(Context r2) {
        this.mLock = new Object();
        this.mContext = r2;
        if (r2 != null) goto L6;
        Logger.i("GnssInfoManager: Context is null!");
        return;
    L6:
        this.mLocationManager = (LocationManager) r2.getSystemService(LocationMonitorConst.LOCATION);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ LocationManager access$300(GnssInfoManager r0) {
        return r0.mLocationManager;
    }

    private void updateGnssInfo(BDGnssInfo r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentGnssInfo = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void registerGnssCallback(Object r4) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L27:
        e = move-exception;
        Logger.e("GnssInfoManager: registerGnssCallback error", e);     // Catch: Throwable -> L25
    L29:
        monitor-exit(this);
        return;
    L4:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        Logger.i("GnssInfoManager: registerGnssCallback skipped (no ACCESS_FINE_LOCATION permission)");     // Catch: Throwable -> L25 Exception -> L27
        monitor-exit(this);
        return;
    L9:
        if (this.mLocationManager != null) goto L13;
        Logger.i("GnssInfoManager: registerGnssCallback skipped (LocationManager is null)");     // Catch: Throwable -> L25 Exception -> L27
        monitor-exit(this);
        return;
    L13:
        AnonymousClass1 r2 = null;
        if (Build.VERSION.SDK_INT < 24) goto L20;
        if (this.mGnssStatusCallback != null) goto L18;
        this.mGnssStatusCallback = new GnssStatusCallbackImpl(this, r2);     // Catch: Throwable -> L25 Exception -> L27
    L18:
        this.mBPEAManager.registerGnssStatusCallback(this.mLocationManager, this.mGnssStatusCallback, r4);     // Catch: Throwable -> L25 Exception -> L27
    L23:
        Logger.i("GnssInfoManager: registerGnssCallback success");     // Catch: Throwable -> L25 Exception -> L27
        goto L29
    L20:
        if (this.mGpsStatusListener != null) goto L22;
        this.mGpsStatusListener = new GpsStatusListenerImpl(this, r2);     // Catch: Throwable -> L25 Exception -> L27
    L22:
        this.mBPEAManager.addGpsStatusListener(this.mLocationManager, this.mGpsStatusListener, r4);     // Catch: Throwable -> L25 Exception -> L27
        goto L23
    }

    public static /* synthetic */ void access$200(GnssInfoManager r0, BDGnssInfo r1) {
        r0.updateGnssInfo(r1);
    }
}
