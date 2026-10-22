package k84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static void d(LocInfoRspData r3) {
        if (r3 != null) goto L5;
        BDLocationConfig.setGpsScanInterval(BDLocationConfig.getDefaultGpsScanInterval());
        return;
    L5:
        Logger.i("ResponseExecutor: setNextGpsScanInterval and interval:" + r3.nextGPSScanInterval);
        BDLocationConfig.setGpsScanInterval(r3.nextGPSScanInterval);
    }

    public static void a(LocInfoRspData r5, LocationOption r6) {
        if (r5 == null) goto L10;
        long r2 = r5.nextBleScanInterval;
        BDLocationConfig.setUploadBleImmediately(r5.submitBleNow);
        BDLocationConfig.setDisableUuidList(r5.disableUuidList);
        if (r2 <= 0) goto L8;
        BDLocationConfig.setScanBleInterval(r2);
        goto L10
    L8:
        if (LocationSettingUtil.getLocationConfig() == null) goto L10;
        BDLocationConfig.setScanBleInterval(LocationSettingUtil.getLocationConfig().scanBleInterval);
    L10:
        Logger.i("collectBleExtraData BLE_SCAN_INTERVAL：" + BDLocationConfig.getScanBleInterval() + "SUBMIT_BLE_NOW:" + BDLocationConfig.isUploadBleImmediately());
        if (r6 == null) goto L20;
        LocationExtraDataTraceLogger r7 = r6.getLocationExtraDataTraceLogger();
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L15;
        boolean r0 = true;
    L16:
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.HAS_BLE_SCAN_INTERVAL, Boolean.valueOf(r0));
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.BLE_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getScanBleInterval()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r7, LocationExtraDataTraceLogger.SUBMIT_BLE_NOW, Boolean.valueOf(BDLocationConfig.isUploadBleImmediately()));
        BDLocationExtraDataServer r8 = r6.getLocationExtraDataServer();
        if (r8 == null) goto L21;
        r8.startCollectBluetoothData(r6);
        return;
    L21:
        return;
    L15:
        r0 = false;
        goto L16
    }

    public static void e(LocInfoRspData r1, BDLocation r2) {
        if (r1 != null) goto L19;
        return;
    L19:
    L16:
        e = move-exception;
        Logger.i("submitCallback error:" + e.toString());
        return;
    L5:
        if (BDLocationConfig.getSubmitNotification() != null) goto L7;
        return;
    L7:
        if (BDLocationConfig.getSubmitNotification().size() <= 0) goto L27;
        if (r2 == null) goto L28;
        BDLocation r0 = new BDLocation(r2);     // Catch: Exception -> L16
        r0.setSubmitLogId(r1.submitLogId);     // Catch: Exception -> L16
        Iterator r3 = BDLocationConfig.getSubmitNotification().iterator();     // Catch: Exception -> L16
    L11:
        if (r3.hasNext() == false) goto L29;
        LocationSubmitNotification r4 = (LocationSubmitNotification) r3.next();     // Catch: Exception -> L16
        if (r4 == null) goto L11;
        r4.onSubmitListener(r0);     // Catch: Exception -> L16
        goto L11
    L29:
        return;
    L28:
        return;
    }

    public static void b(LocInfoRspData r8, BDLocation r9, LocationOption r10) {
        if (r8 != null) goto L18;
    L13:
        e(r8, r9);     // Catch: Exception -> L15
        a(r8, r10);     // Catch: Exception -> L15
        BDLocationConfig.setFirstRequestLocation(false);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return;
    L18:
        j84.a.f = System.currentTimeMillis();     // Catch: Exception -> L15
        long r0 = r8.nextPollingUploadInterval * 1000;     // Catch: Exception -> L15
        if (r0 != 0) goto L6;
        r0 = BDLocationConfig.getUploadInterval();     // Catch: Exception -> L15
    L6:
        j84.a r4 = j84.a.a();     // Catch: Exception -> L15
        if (r4.a == false) goto L13;
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadSchedule:" + r4.b());     // Catch: Exception -> L15
        r4.e(r0, LocationInfoConst.POLL_CERT);     // Catch: Exception -> L15
        if (r0 < 0) goto L13;
        r4.d = r0;     // Catch: Exception -> L15
        goto L13
    }

    public static void c(LocInfoRspData r4, BDLocation r5, LocationOption r6) {
        if (r6 == null) goto L4;
        LocationTraceLogger r0 = r6.getLocationTraceLogger();
    L5:
        int r3 = 0;
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L9;
        LocationMonitor.locationTracePutCategoryData(r0, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_AFTER_LOCATION, 0);
        return;
    L9:
        if (r6 == null) goto L14;
        if (r4 == null) goto L14;
        StationarySceneCacheInfo r7 = r6.getStationarySceneCacheInfo();
        if (r7 == null) goto L14;
        r7.setLocationResult(r4.location);
        LocationCache.getInstance().setStationarySceneCacheInfo(r7);
    L14:
        if (r4 == null) goto L16;
        r3 = r4.movingSceneWithAoiStatus;
    L16:
        LocationMonitor.locationTracePutCategoryData(r0, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_AFTER_LOCATION, Integer.valueOf(LocationUtil.checkStationaryScenePolicyAfterLocation(r5, LocationCache.getInstance().fastGetLocationCacheUnsafe().getLatestLocation(), r3, r0)));
        return;
    L4:
        r0 = null;
        goto L5
    }
}
