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
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDSatelliteInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
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

        private GnssStatusCallbackImpl(GnssInfoManager r100) {
            this.this$0 = r100;
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = r100.getSatelliteCount();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            int r104 = 0;
        L5:
            if (r104 >= r101) goto L10;
            BDSatelliteInfo r105 = new BDSatelliteInfo();
            r105.sVid = r100.getSvid(r104);
            r105.snr = r100.getCn0DbHz(r104);
            r105.azimuthDegrees = r100.getAzimuthDegrees(r104);
            r105.elevationDegrees = r100.getElevationDegrees(r104);
            r105.constellationType = r100.getConstellationType(r104);
            if (Build.VERSION.SDK_INT < 26) goto L9;
            r105.hasCarrierFrequencyHz = r100.hasCarrierFrequencyHz(r104);
            r105.carrierFrequencyHz = r100.getCarrierFrequencyHz(r104);
        L9:
            r105.usedInFix = r100.usedInFix(r104);
            r102.add(r105);
            r103.add(Float.valueOf(r105.snr));
            r104 = r104 + 1;
            goto L5
        L10:
            BDGnssInfo r106 = new BDGnssInfo();
            r106.satelliteNum = r101;
            r106.satelliteInfos = r102;
            r106.snr = r103;
            r106.timestamp = System.currentTimeMillis();
            r106.callbackClock = SystemClock.elapsedRealtime();
            GnssInfoManager.access$200(this.this$0, r106);
            Logger.i("GnssInfoManager: onSatelliteStatusChanged, satellite count: " + r101 + " satelliteInfos: " + JsonUtil.safeToJsonTree(r102));
        }

        public /* synthetic */ GnssStatusCallbackImpl(GnssInfoManager r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class GpsStatusListenerImpl implements GpsStatus.Listener {
        final /* synthetic */ GnssInfoManager this$0;

        private GpsStatusListenerImpl(GnssInfoManager r100) {
            this.this$0 = r100;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r100) {
            if (r100 != 1) goto L5;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_STARTED");
            return;
        L5:
            if (r100 != 2) goto L7;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_STOPPED");
            return;
        L7:
            if (r100 != 3) goto L9;
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_FIRST_FIX");
            return;
        L9:
            if (r100 == 4) goto L12;
            return;
        L12:
            if (GnssInfoManager.access$300(this.this$0) != null) goto L14;
            return;
        L14:
            GpsStatus r101 = GnssInfoManager.access$300(this.this$0).getGpsStatus(null);
            if (r101 != null) goto L17;
            return;
        L17:
            int r102 = r101.getMaxSatellites();
            ArrayList r103 = new ArrayList();
            ArrayList r104 = new ArrayList();
            Iterator<GpsSatellite> r105 = r101.getSatellites().iterator();
            int r106 = 0;
        L19:
            if (r105.hasNext() == false) goto L22;
            if (r106 >= r102) goto L22;
            GpsSatellite r107 = r105.next();
            BDSatelliteInfo r108 = new BDSatelliteInfo();
            r108.snr = r107.getSnr();
            r108.azimuthDegrees = r107.getAzimuth();
            r108.elevationDegrees = r107.getElevation();
            r108.usedInFix = r107.usedInFix();
            r108.sVid = r107.getPrn();
            r103.add(r108);
            r104.add(Float.valueOf(r108.snr));
            r106 = r106 + 1;
        L22:
            BDGnssInfo r109 = new BDGnssInfo();
            r109.satelliteNum = r102;
            r109.satelliteInfos = r103;
            r109.snr = r104;
            r109.timestamp = System.currentTimeMillis();
            r109.callbackClock = SystemClock.elapsedRealtime();
            GnssInfoManager.access$200(this.this$0, r109);
            Logger.i("GnssInfoManager: GpsStatusListener GPS_EVENT_SATELLITE_STATUS, count: " + r106);
        }

        public /* synthetic */ GpsStatusListenerImpl(GnssInfoManager r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public synchronized BDGnssInfo getCurrentGnssInfo() {
        monitor-enter(this);
        BDGnssInfo r100 = this.mCurrentGnssInfo;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterGnssCallback() {
        monitor-enter(this);
        LocationManager r100 = this.mLocationManager;     // Catch: Throwable -> L15 Exception -> L17
        if (r100 != null) goto L6;
    L19:
        monitor-exit(this);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        GnssStatus.Callback r101 = this.mGnssStatusCallback;     // Catch: Throwable -> L15 Exception -> L17
        if (r101 == null) goto L13;
        r100.unregisterGnssStatusCallback(r101);     // Catch: Throwable -> L15 Exception -> L17
        this.mGnssStatusCallback = null;     // Catch: Throwable -> L15 Exception -> L17
    L13:
        Logger.i("GnssInfoManager: unregisterGnssCallback success");     // Catch: Throwable -> L15 Exception -> L17
    L10:
        GpsStatus.Listener r102 = this.mGpsStatusListener;     // Catch: Throwable -> L15 Exception -> L17
        if (r102 == null) goto L13;
        r100.removeGpsStatusListener(r102);     // Catch: Throwable -> L15 Exception -> L17
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

    private GnssInfoManager(Context r100) {
        this.mLock = new Object();
        this.mContext = r100;
        if (r100 != null) goto L6;
        Logger.i("GnssInfoManager: Context is null!");
        return;
    L6:
        this.mLocationManager = (LocationManager) r100.getSystemService("location");
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ LocationManager access$300(GnssInfoManager r100) {
        return r100.mLocationManager;
    }

    private void updateGnssInfo(BDGnssInfo r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCurrentGnssInfo = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void registerGnssCallback(Object r100) {
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
        AnonymousClass1 r101 = null;
        if (Build.VERSION.SDK_INT < 24) goto L20;
        if (this.mGnssStatusCallback != null) goto L18;
        this.mGnssStatusCallback = new GnssStatusCallbackImpl(this, r101);     // Catch: Throwable -> L25 Exception -> L27
    L18:
        this.mBPEAManager.registerGnssStatusCallback(this.mLocationManager, this.mGnssStatusCallback, r100);     // Catch: Throwable -> L25 Exception -> L27
    L23:
        Logger.i("GnssInfoManager: registerGnssCallback success");     // Catch: Throwable -> L25 Exception -> L27
        goto L29
    L20:
        if (this.mGpsStatusListener != null) goto L22;
        this.mGpsStatusListener = new GpsStatusListenerImpl(this, r101);     // Catch: Throwable -> L25 Exception -> L27
    L22:
        this.mBPEAManager.addGpsStatusListener(this.mLocationManager, this.mGpsStatusListener, r100);     // Catch: Throwable -> L25 Exception -> L27
        goto L23
    }

    public static /* synthetic */ void access$200(GnssInfoManager r100, BDGnssInfo r101) {
        r100.updateGnssInfo(r101);
    }
}
