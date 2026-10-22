package com.bytedance.bdlocation.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import f06.b;
import f06.d;
import fna.g;
import g06.a;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class SystemBaseLocationImpl extends BaseLocate {
    public static final String LBS_GEOCODE_NAME = "LBS";
    private final Handler mHandler;
    private LocationManager mManager;

    public class SystemLocationListener implements LocationListener {
        private BDLocationCallback mCallback;
        private boolean mGpsDisabled;
        private long mLocationStartTime;
        private boolean mNetworkDisabled;
        private LocationOption mOption;
        private TimeOutRunnable mTimeOutRunnable;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r23) {
            ArrayList r11 = new ArrayList();
            Object[] r13 = {r23};
            b r15 = new b();
            a r1 = (a) ApiHookConfig.b.get(100038);
            if (r1 == null) goto L5;
            f06.a[] r2 = r1.i;
        L6:
            f06.a[] r8 = r2;
            int r7 = r8.length;
            int r6 = 0;
        L8:
            if (r6 >= r7) goto L15;
            f06.a r4 = r8[r6];
            int r19 = r6;
            int r20 = r7;
            f06.a[] r21 = r8;
            d r3 = r4.preInvoke(100038, "com/bytedance/bdlocation/service/SystemBaseLocationImpl$SystemLocationListener", "onLocationChanged", this, r13, "void", r15);     // Catch: Exception -> L38
            if (r3.a == true) goto L12;
            r11.add(r4);     // Catch: Exception -> L38
            goto L14
        L12:
            BDLocation r5 = null;
        L17:
            if (r3.a == false) goto L41;
            return;
        L41:
            this.this$0.removeListener(this);     // Catch: Exception -> L35
            if (this.mTimeOutRunnable == null) goto L23;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);     // Catch: Exception -> L35
        L23:
            if (this.mOption.isLocationChanged() == false) goto L26;
            Logger.i("Network Location Changed!");     // Catch: Exception -> L35
            return;
        L26:
            this.mOption.setLocationChanged(true);     // Catch: Exception -> L35
            String r9 = r23.getProvider();     // Catch: Exception -> L35
            Logger.i("SystemBaseLocationImpl onLocationChanged provider:" + r9);     // Catch: Exception -> L35
            if (r9.equals("gps") == false) goto L30;
            BDLocation r10 = SystemBaseLocationImpl.access$100(this.this$0, r23, 1);     // Catch: Exception -> L35
        L33:
            LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);     // Catch: Exception -> L35
            SystemBaseLocationImpl.access$200(this.this$0, r10, this.mOption, this.mCallback, this.mLocationStartTime);     // Catch: Exception -> L35
            LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.SUCCESS, "success", null, this.mOption.isChineseRegion(), SystemBaseLocationImpl.access$300(this.this$0, r10), this.mOption.isBackground());     // Catch: Exception -> L35
            return;
        L30:
            if (r9.equals("network") == false) goto L32;
            r10 = SystemBaseLocationImpl.access$100(this.this$0, r23, 4);     // Catch: Exception -> L35
            goto L33
        L32:
            r10 = r5;
        L35:
            e = move-exception;
            Logger.e("SystemBaseLocationImpl:network listener error", e);
            SystemBaseLocationImpl.access$400(this.this$0, this, e.getMessage(), BDLocationException.ERROR_UNKNOWN, this.mCallback, this.mLocationStartTime, this.mOption);
            return;
        L14:
            r6 = r19 + 1;
            r7 = r20;
            r8 = r21;
            goto L8
        L15:
            r5 = null;
            r3 = new d(false, null);
            goto L17
        L5:
            r2 = ApiHookConfig.d;
            goto L6
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r10) {
            Logger.i("SystemBaseLocationImpl:onProviderDisabled:" + r10);
            if ("gps".equals(r10) == false) goto L5;
            this.mGpsDisabled = true;
        L7:
            if (SystemBaseLocationImpl.access$500(this.this$0, this.mOption.getMode(), this.mGpsDisabled, this.mNetworkDisabled) == true) goto L9;
            return;
        L9:
            if (this.mTimeOutRunnable == null) goto L11;
            SystemBaseLocationImpl.access$000(this.this$0).removeCallbacks(this.mTimeOutRunnable);
        L11:
            SystemBaseLocationImpl.access$400(this.this$0, this, "provider disabled", BDLocationException.ERROR_PROVIDER_DISABLED, this.mCallback, this.mLocationStartTime, this.mOption);
            return;
        L5:
            this.mNetworkDisabled = true;
            goto L7
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r3) {
            Logger.i("SystemBaseLocationImpl:onProviderEnabled:" + r3);
            this.mNetworkDisabled = false;
        }

        public SystemLocationListener(SystemBaseLocationImpl r3, LocationOption r4, BDLocationCallback r5) {
            this.this$0 = r3;
            this.mOption = r4;
            this.mCallback = r5;
            this.mTimeOutRunnable = new TimeOutRunnable(r3, this, r4, r5);
            SystemBaseLocationImpl.access$000(r3).postDelayed(this.mTimeOutRunnable, r4.getLocationTimeOutMs());
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r4.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }
    }

    public class TimeOutRunnable implements Runnable {
        private BDLocationCallback mCallback;
        private LocationListener mListener;
        private LocationOption mOption;
        private long mTimeoutStartTime;
        final /* synthetic */ SystemBaseLocationImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_bdlocation_service_SystemBaseLocationImpl$TimeOutRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_bdlocation_service_SystemBaseLocationImpl$TimeOutRunnable__run$___twin___() {
            SystemBaseLocationImpl.access$400(this.this$0, this.mListener, LocationMonitorConst.TIMEOUT, BDLocationException.ERROR_TIMEOUT, this.mCallback, this.mTimeoutStartTime, this.mOption);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bdlocation_service_SystemBaseLocationImpl$TimeOutRunnable_com_larus_apm_impl_protector_RunnableLancet_run(TimeOutRunnable r1) {
            r1.com_bytedance_bdlocation_service_SystemBaseLocationImpl$TimeOutRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public TimeOutRunnable(SystemBaseLocationImpl r1, LocationListener r2, LocationOption r3, BDLocationCallback r4) {
            this.this$0 = r1;
            this.mListener = r2;
            this.mCallback = r4;
            this.mOption = r3;
            this.mTimeoutStartTime = SystemClock.elapsedRealtime();
        }
    }

    private boolean checkProviderDisabled(int r2, boolean r3, boolean r4) {
        if (r2 != 2) goto L9;
        if (r3 == false) goto L7;
        if (r4 == false) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (r2 != 0) goto L11;
        return r4;
    L11:
        return r3;
    }

    public float calculateLineDistance(BDPoint r1, BDPoint r2) {
        return -1.0f;
    }

    public BDPoint convertGCJ02(BDPoint r1) {
        return null;
    }

    public String getLocateName() {
        return LocationInfoConst.SYSTEM;
    }

    public boolean isAMapDataAvailable(double r1, double r3) {
        return false;
    }

    public void stopLocation() {
    }

    public SystemBaseLocationImpl(Context r3) {
        super(r3);
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mManager = (LocationManager) r3.getSystemService(LocationMonitorConst.LOCATION);
    }

    public static /* synthetic */ Handler access$000(SystemBaseLocationImpl r0) {
        return r0.mHandler;
    }

    private int getLocationType(BDLocation r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.getLocationType();
    }

    public BDLocation geocode(BDPoint r4) {
        BDLocation r0 = new BDLocation(r4.getProvider(), getLocateName());
        r0.setLatitude(r4.getLatitude());
        r0.setLongitude(r4.getLongitude());
        return LocationUtil.geocode(((BaseLocate) this).mContext, r0);
    L5:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:geocode error", e);
        return null;
    }

    public void removeListener(LocationListener r2) {
        if (r2 != null) goto L9;
    L4:
        Logger.i("SystemBaseLocationImpl:Android stopLocation");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Logger.e("SystemBaseLocationImpl:android stop location error", e);
        return;
    L9:
        INVOKEVIRTUAL_com_bytedance_bdlocation_service_SystemBaseLocationImpl_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(this.mManager, r2);     // Catch: Exception -> L6
        goto L4
    }

    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_service_SystemBaseLocationImpl_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(LocationManager r1, LocationListener r2) {
        if (g.d() == true) goto L6;
        r1.removeUpdates(r2);
        return;
    L6:
        r1.removeUpdates(r2);
        nna.a.a(r2.hashCode());
    }

    public static /* synthetic */ int access$300(SystemBaseLocationImpl r0, BDLocation r1) {
        return r0.getLocationType(r1);
    }

    private BDLocation transform(Location r3, int r4) {
        if (r3 == null) goto L5;
        BDLocation r0 = new BDLocation(r3, getLocateName());
        r0.setLocationType(r4);
        r0.setLocationMs(System.currentTimeMillis());
        return r0;
    L5:
        return null;
    }

    public static /* synthetic */ BDLocation access$100(SystemBaseLocationImpl r0, Location r1, int r2) {
        return r0.transform(r1, r2);
    }

    public static Location getLastKnownLocation(LocationManager r3, String r4, LocationOption r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r3, r4, r5.getBpeaCert());
    }

    private void singleLocation(LocationOption r9, Looper r10, BDLocationCallback r11) throws BDLocationException {
        SystemLocationListener r6 = new SystemLocationListener(this, r9, r11);
        int r12 = r9.getMode();
        Logger.i("SystemBaseLocationImpl singleLocation mode:" + r12);
        if (r12 != 0) goto L8;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L22;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "network", r6, r10, r9.getBpeaCert());
        return;
    L22:
        return;
    L8:
        if (r12 != 1) goto L13;
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L24;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "gps", r6, r10, r9.getBpeaCert());
        return;
    L24:
        return;
    L13:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L16;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "network", r6, r10, r9.getBpeaCert());
    L16:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L18;
        return;
    L18:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L20;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(this.mManager, "gps", r6, r10, r9.getBpeaCert());
        return;
    L20:
        Logger.i("SystemBaseLocationImpl.singleLocation: skip gps location.");
    }

    public void startLocation(BDLocationCallback r9, LocationOption r10, Looper r11) {
        super.startLocation(r9, r10, r11);
        long r6 = SystemClock.elapsedRealtime();
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        r9.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L32;
        return;
    L32:
    L29:
        e = move-exception;
        Logger.i("start location error");
        onError(null, e.getMessage(), BDLocationException.ERROR_UNKNOWN, r9, r6, r10);
        return;
    L10:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L26;
        Location r0 = getLastKnownLocation(this.mManager, "gps", r10);     // Catch: Exception -> L29
        Location r1 = getLastKnownLocation(this.mManager, "network", r10);     // Catch: Exception -> L29
        if (r1 != null) goto L14;
    L19:
        if (r0 != null) goto L21;
    L27:
        singleLocation(r10, r11, r9);     // Catch: Exception -> L29
        onLocateStart(getLocateName());     // Catch: Exception -> L29
        Logger.i("SystemBaseLocationImpl:Android startLocation");     // Catch: Exception -> L29
        return;
    L21:
        if (LocationUtil.checkCacheTime(r0.getTime(), r10.getMaxCacheTime()) == false) goto L27;
        if (LocationUtil.isEmpty(r0) == true) goto L27;
        geocodeAndCallback(transform(r0, 1), r10, r9, r6);     // Catch: Exception -> L29
        return;
    L14:
        if (LocationUtil.checkCacheTime(r1.getTime(), r10.getMaxCacheTime()) == false) goto L19;
        if (LocationUtil.isEmpty(r1) == true) goto L19;
        geocodeAndCallback(transform(r1, 4), r10, r9, r6);     // Catch: Exception -> L29
        return;
    L26:
        Logger.i("SystemBaseLocationImpl.startLocation: skip getLastKnownLocation opt.");     // Catch: Exception -> L29
        goto L27
    }

    public static /* synthetic */ boolean access$500(SystemBaseLocationImpl r0, int r1, boolean r2, boolean r3) {
        return r0.checkProviderDisabled(r1, r2, r3);
    }

    private void geocodeAndCallback(BDLocation r9, LocationOption r10, BDLocationCallback r11, long r12) {
        if (r9 != null) goto L5;
        onError(null, "location is null", BDLocationException.ERROR_UNKNOWN, r11, r12, r10);
    L5:
        if (LocationUtil.isNeedAddress(r10) == false) goto L7;
        BDLocation r13 = geocode(new BDPoint(r9.getLatitude(), r9.getLongitude(), r9.getProvider()));
    L8:
        if (r13 == null) goto L10;
        r9 = LocationUtil.composeGeocodeLocation(r9, r13);
    L10:
        r11.onLocationChanged(r9);
        return;
    L7:
        r13 = null;
        goto L8
    }

    public static /* synthetic */ void access$200(SystemBaseLocationImpl r0, BDLocation r1, LocationOption r2, BDLocationCallback r3, long r4) {
        r0.geocodeAndCallback(r1, r2, r3, r4);
    }

    private void onError(LocationListener r14, String r15, String r16, BDLocationCallback r17, long r18, LocationOption r20) {
        Logger.e("SystemBaseLocationImpl location errorCode:" + r16 + "--message:" + r15 + "--isBackground:" + r20.isBackground() + "--backgroundLocationPermissionStatus:" + LocationUtil.getBackgroundLocationPermissionStatus());
        LocationMonitor.doDesiredLocationDuration(getLocateName(), SystemClock.elapsedRealtime() - r18, r16, r15, null, r20.isChineseRegion(), 0, "", r20.isBackground());
        removeListener(r14);
        if (r17 == null) goto L6;
        r17.onError(new BDLocationException(r15, LocationInfoConst.SYSTEM, r16));
        return;
    }

    public static /* synthetic */ void access$400(SystemBaseLocationImpl r0, LocationListener r1, String r2, String r3, BDLocationCallback r4, long r5, LocationOption r7) {
        r0.onError(r1, r2, r3, r4, r5, r7);
    }
}
