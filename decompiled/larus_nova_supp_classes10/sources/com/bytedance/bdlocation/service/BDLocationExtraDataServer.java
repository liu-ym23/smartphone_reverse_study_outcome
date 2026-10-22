package com.bytedance.bdlocation.service;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager;
import com.bytedance.bdlocation.scan.bluetooth.BluetoothUtil;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDLocationExtraDataServer {
    public static final String TAG = "BDLocationExtraDataServer:";
    private volatile List<BDBleInfo> mBleInfoList;
    private volatile int mBleInfoListStatus;
    private BluetoothInfoManager mBluetoothInfoManager;
    private volatile GpsInfoManager mGpsInfoManager;
    private volatile int mGpsInfoStatus;
    private volatile ArrayList<BDLocationExtraDataServer> mLocationExtraDataServerList;
    private volatile Handler mLocationHandler;
    private final AtomicInteger uploadGpsAndBleNum;

    public class BluetoothScanCallback implements BluetoothInfoManager.BluetoothScanCallback {
        private LocationExtraDataTraceLogger extraDataTraceLogger;
        private LocationOption mOption;
        final /* synthetic */ BDLocationExtraDataServer this$0;

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onScan(BDBleInfo r1) {
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onError() {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData error");
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, Boolean.FALSE);
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
        }

        @Override // com.bytedance.bdlocation.scan.bluetooth.BluetoothInfoManager.BluetoothScanCallback
        public void onSuccess(List<BDBleInfo> r4) {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData success");
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, Boolean.TRUE);
            LocationExtraDataTraceLogger r0 = this.extraDataTraceLogger;
            if (r4 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            LocationMonitor.locationExtraDataTracePutCategoryData(r0, LocationExtraDataTraceLogger.COLLECT_HAS_BLE_INFO, Boolean.valueOf(r1));
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            List r5 = BDLocationExtraDataServer.access$200(this.this$0, r4);
            if (BDLocationConfig.isUploadBleImmediately() == false) goto L12;
            BDLocationExtraDataServer.access$300(this.this$0, r5, this.mOption);
            return;
        L12:
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
            BDLocationExtraDataServer.access$500(this.this$0, r5, this.mOption.getStartLocationTime());
            return;
        L5:
            if (r4.isEmpty() == true) goto L7;
            r1 = true;
            goto L8
        }

        public BluetoothScanCallback(BDLocationExtraDataServer r1, LocationOption r2) {
            this.this$0 = r1;
            this.mOption = r2;
            if (r2 == null) goto L6;
            this.extraDataTraceLogger = r2.getLocationExtraDataTraceLogger();
            return;
        }
    }

    public void clearExtraData() {
        Logger.i("BDLocationExtraDataServer:clearExtraData");
        BDLocationConfig.setBleCacheEntity(null);
        BDLocationConfig.setLogIdCacheEntity(null);
    }

    public void stopCollectExtraData() {
        BluetoothInfoManager r0 = this.mBluetoothInfoManager;
        if (r0 == null) goto L6;
        r0.stopScan();
    L6:
        if (this.mGpsInfoManager == null) goto L9;
        this.mGpsInfoManager.stopGpsCollect();
        return;
    }

    public BDLocationExtraDataServer() {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.uploadGpsAndBleNum = new AtomicInteger(0);
        this.mBluetoothInfoManager = new BluetoothInfoManager(BDLocationConfig.getContext());
    }

    public List<BDBleInfo> getBleEntryList() {
        LogIdCacheEntity r0 = BDLocationConfig.getLogIdCacheEntity();
        if (r0 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:getLogIdCache cache is null");
        return null;
    L6:
        BLECacheEntity r2 = BDLocationConfig.getBleCacheEntity();
        if (r2 != null) goto L9;
    L14:
        Logger.i("BDLocationExtraDataServer:getBleEntryList error");
        return null;
    L9:
        if (r2.getTimeStamp() != r0.timestamp) goto L14;
        if (TextUtils.isEmpty(r0.logId) == true) goto L14;
        Logger.i("BDLocationExtraDataServer:getBleEntryList success");
        return r2.getBleInfoList();
    }

    public GpsInfoManager getGpsInfoManager() {
        return this.mGpsInfoManager;
    }

    public static /* synthetic */ ArrayList access$600(BDLocationExtraDataServer r0) {
        return r0.mLocationExtraDataServerList;
    }

    private void collectGpsInfo(final LocationOption r9) {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r9 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:collectGpsInfo option is null");
        this.mGpsInfoStatus = 1;
        uploadGpsAndBleInfos(r9);
        return;
    L6:
        final LocationExtraDataTraceLogger r3 = r9.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, "upload_source", r9.getUploadSource());
        this.mGpsInfoManager = new GpsInfoManager();
        final long r4 = System.currentTimeMillis();
        this.mGpsInfoManager.startGpsCollect(new AnonymousClass1(this, r3, r4, r9), r9);
    }

    private List<BDBleInfo> getNewBleInfos(List<BDBleInfo> r7) {
        if (r7 != null) goto L4;
    L22:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos bleInfos is null");
        return null;
    L4:
        if (r7.size() < 1) goto L22;
        List r0 = BDLocationConfig.getDisableUuidList();
        if (r0 != null) goto L9;
    L20:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is null");
        return new ArrayList(r7);
    L9:
        if (r0.size() <= 0) goto L20;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is not null");
        ArrayList r1 = new ArrayList();
        long r2 = System.currentTimeMillis();
        Iterator<BDBleInfo> r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        BDBleInfo r4 = r8.next();
        if (r4.isBeacon == false) goto L18;
        if (CollectionUtil.containsIgnoreCase(r0, r4.beaconUuid) == false) goto L18;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos and ignore the beacon");
    L18:
        r1.add(r4);
        goto L12
    L19:
        Logger.i(TAG, "getNewBleInfos and filter beacon duration(ms) is " + (System.currentTimeMillis() - r2));
        return r1;
    }

    private void setExtraData(LocationOption r4) {
        Logger.i("BDLocationExtraDataServer:setExtraData startLocationTime:" + r4.getStartLocationTime());
        LocationExtraBean r0 = new LocationExtraBean();
        r0.setBleInfoList(getBleEntryList());
        if (BDLocationConfig.getLogIdCacheEntity() == null) goto L5;
        LogIdCacheEntity r1 = BDLocationConfig.getLogIdCacheEntity();
    L6:
        r0.setLogIdCacheEntity(r1);
        r4.setLocationExtraBean(r0);
        return;
    L5:
        r1 = new LogIdCacheEntity();
        goto L6
    }

    private void uploadGpsAndBleInfos(LocationOption r2) {
        uploadGpsAndBleInfosAndRemove(r2);
        if (this.mLocationHandler == null) goto L6;
        this.mLocationHandler.post(new AnonymousClass2(this));
        return;
    }

    private void uploadGpsAndBleInfosAndRemove(LocationOption r14) {
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and mGpsInfoStatus:" + this.mGpsInfoStatus + ", mBleInfoListStatus:" + this.mBleInfoListStatus);
        if (BDLocationConfig.isEnableGpsScan() == false) goto L7;
        if (this.mGpsInfoStatus != 0) goto L7;
        return;
    L7:
        if (this.mBleInfoListStatus == 0) goto L106;
        StringBuilder r0 = new StringBuilder("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsinfo:");
        if (this.mGpsInfoStatus == 3) goto L11;
        boolean r1 = true;
    L12:
        r0.append(r1);
        r0.append(", bleinfos:");
        if (this.mBleInfoList == null) goto L15;
        boolean r2 = true;
    L16:
        r0.append(r2);
        Logger.i(r0.toString());
        LocationExtraDataTraceLogger r3 = r14.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.UPLOAD_GPS_AND_BLE_NUM, Integer.valueOf(this.uploadGpsAndBleNum.incrementAndGet()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.GPS_INFO_STATUS, Integer.valueOf(this.mGpsInfoStatus));
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.BLE_INFO_LIST_STATUS, Integer.valueOf(this.mBleInfoListStatus));
        if (this.mGpsInfoStatus != 3) goto L19;
    L22:
        LocationUploadExtra r4 = new LocationUploadExtra();
        r4.locationOption = r14;
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L26;
        LogIdCacheEntity r6 = BDLocationConfig.getLogIdCacheEntity();
    L34:
        Logger.i("BDLocationExtraDataServer: enableCheckLastLogId:" + BDLocationConfig.enableCheckLastLogId());
        if (r6 != null) goto L37;
        boolean r7 = true;
    L38:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_IS_NULL, Boolean.valueOf(r7));
        if (r6 != null) goto L41;
    L43:
        boolean r8 = false;
    L44:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_TIME_CHECK, Boolean.valueOf(r8));
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, Boolean.valueOf(BDLocationConfig.enableCheckLastLogId()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, Boolean.valueOf(BDLocationConfig.enableCheckUploadCompliance()));
        if (r6 != null) goto L47;
        long r9 = 0;
    L48:
        LocationMonitor.locationExtraDataTracePutExtraData(r3, LocationExtraDataTraceLogger.LOCATION_LOG_ID_CACHE_TIME, Long.valueOf(r9));
        LocationMonitor.locationExtraDataTracePutExtraData(r3, LocationExtraDataTraceLogger.START_LOCATION_TIME, Long.valueOf(r14.getStartLocationTime()));
        if (r6 != null) goto L51;
        String r10 = "";
    L52:
        LocationMonitor.locationExtraDataTracePutExtraData(r3, LocationExtraDataTraceLogger.LOCATION_LOG_ID, r10);
        StringBuilder r11 = new StringBuilder("BDLocationExtraDataServer: gpsCacheEntity:");
        if (r6 != null) goto L56;
        Object r12 = "null";
    L60:
        r11.append(r12);
        Logger.i(r11.toString());
        if (BDLocationConfig.enableUploadLastLogId() == true) goto L63;
    L71:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity != null");
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L74;
        r4.setLogIdCache(r6);
    L74:
        r4.setLocationExtraDataServer(this);
        if (r4.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult) == null) goto L77;
        boolean r5 = true;
    L78:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.UPLOAD_HAS_GPS_INFO, Boolean.valueOf(r5));
        if (r4.getSysLocation() == null) goto L81;
        boolean r13 = true;
    L82:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.UPLOAD_HAS_SYS_LOCATION_INFO, Boolean.valueOf(r13));
        if (r4.getAMapLocation() == null) goto L85;
        boolean r15 = true;
    L86:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.UPLOAD_HAS_AMAP_LOCATION_INFO, Boolean.valueOf(r15));
        r4.setLocateId(r14.getLocateId());
        if (this.mBleInfoList != null) goto L89;
    L91:
        boolean r16 = false;
    L92:
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.UPLOAD_HAS_BLE_INFO_LIST, Boolean.valueOf(r16));
        r4.setBleList(this.mBleInfoList);
        if (this.mGpsInfoStatus != 0) goto L95;
    L101:
        r4.setGpsAndBleMark("ble");
    L102:
        r4.setTriggerType(r14.getTriggerType());
        r4.setUploadSource(r14.getUploadSource());
        LocationMonitor.locationExtraDataTracePutCategoryData(r3, LocationExtraDataTraceLogger.EXTRA_DATA_MARK, r4.getGpsAndBleMark());
        uploadGpsAndBleInfos(r4, r14, r3);
    L103:
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        return;
    L95:
        if (this.mGpsInfoStatus == 1) goto L101;
        if (this.mBleInfoListStatus == 3) goto L100;
        r4.setGpsAndBleMark("gps");
        goto L102
    L100:
        r4.setGpsAndBleMark("ble_gps");
        goto L102
    L89:
        if (this.mBleInfoList.isEmpty() == true) goto L91;
        r16 = true;
        goto L92
    L85:
        r15 = false;
        goto L86
    L81:
        r13 = false;
        goto L82
    L77:
        r5 = false;
        goto L78
    L63:
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L71;
        if (r6 != null) goto L66;
    L70:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity is null");
        LocationMonitor.locationExtraDataTraceLogEnd(r3, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        LocationMonitor.locationExtraDataTraceLogErrorReport(r14, new BDLocationException("logId Cache Entity Error", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_LOG_ID_CACHE_ENTITY));
        goto L103
    L66:
        if (r6.timestamp != r14.getStartLocationTime()) goto L70;
        if (TextUtils.isEmpty(r6.logId) == true) goto L70;
    L56:
        if (r6.timestamp != r14.getStartLocationTime()) goto L58;
        boolean r17 = true;
    L59:
        r12 = Boolean.valueOf(r17);
        goto L60
    L58:
        r17 = false;
        goto L59
    L51:
        r10 = r6.logId;
        goto L52
    L47:
        r9 = r6.timestamp;
        goto L48
    L41:
        if (r6.timestamp != r14.getStartLocationTime()) goto L43;
        r8 = true;
        goto L44
    L37:
        r7 = false;
        goto L38
    L26:
        if (r14.getLocationExtraBean() == null) goto L28;
        r6 = r14.getLocationExtraBean().getLogIdCacheEntity();
    L29:
        StringBuilder r18 = new StringBuilder("uploadGpsAndBleInfosAndRemove ");
        if (r6 != null) goto L32;
        String r19 = "logIdCacheEntity = null";
    L33:
        r18.append(r19);
        Logger.i(r18.toString());
        goto L34
    L32:
        r19 = "logIdCacheEntity.logId: " + r6.logId + ", logIdCacheEntity.timestamp: " + r6.timestamp;
        goto L33
    L28:
        r6 = null;
        goto L29
    L19:
        if (this.mBleInfoList != null) goto L22;
        Logger.i("BDLocationExtraDataServer: extra data scan failed");
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        LocationMonitor.locationExtraDataTraceLogErrorReport(r14, new BDLocationException("extra data scan failed", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_EXTRA_DATA_SCAN_FAILED));
        return;
    L15:
        r2 = false;
        goto L16
    L11:
        r1 = false;
        goto L12
    }

    public void startCollectBluetoothData(LocationOption r13) {
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r13 != null) goto L5;
    L30:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData option is null");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r13);
        return;
    L5:
        if (r13.isOnceLocation() == false) goto L30;
        if (r13.scanBle() == false) goto L30;
        LocationExtraDataTraceLogger r1 = r13.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, LocationExtraDataTraceLogger.ENABLE_SCAN_BLE, Boolean.valueOf(BDLocationConfig.enableScanBle()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, LocationExtraDataTraceLogger.FIRST_REQUEST_LOCATION, Boolean.valueOf(BDLocationConfig.firstRequestLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, "enable_collect_ble_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectBleInBatterySavingMode()));
        if (BDLocationConfig.enableCollectBleInBatterySavingMode() == true) goto L16;
        if (r13.getMode() != 0) goto L16;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData Battery_Saving mode");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r13);
        return;
    L16:
        if (BDLocationConfig.isUploadBleImmediately() == true) goto L22;
        if (BDLocationConfig.firstRequestLocation() == false) goto L22;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData firstRequestLocation");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r13);
        return;
    L22:
        if (BDLocationConfig.enableScanBle() == true) goto L24;
    L28:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData not enable scan ble");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r13);
        return;
    L24:
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L28;
        scanBlueToothData(0, BDLocationConfig.getScanBleInterval(), r13);
    }

    public static /* synthetic */ int access$002(BDLocationExtraDataServer r0, int r1) {
        r0.mGpsInfoStatus = r1;
        return r1;
    }

    public static /* synthetic */ void access$100(BDLocationExtraDataServer r0, LocationOption r1) {
        r0.uploadGpsAndBleInfos(r1);
    }

    public static /* synthetic */ List access$200(BDLocationExtraDataServer r0, List r1) {
        return r0.getNewBleInfos(r1);
    }

    public static /* synthetic */ int access$402(BDLocationExtraDataServer r0, int r1) {
        r0.mBleInfoListStatus = r1;
        return r1;
    }

    private void setBleCacheEntity(List<BDBleInfo> r4, long r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() < 1) goto L12;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r4.size());
        Collections.sort(r4);
        if (r4.size() <= BDLocationConfig.getUploadBleNum()) goto L9;
        r4 = r4.subList(0, BDLocationConfig.getUploadBleNum());
    L9:
        BLECacheEntity r0 = new BLECacheEntity();
        r0.setBleInfoList(r4);
        r0.setTimeStamp(r5);
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r4.size() + "--startLocationTime：" + r5);
        BDLocationConfig.setBleCacheEntity(r0);
        return;
    }

    private void uploadBleCacheEntity(List<BDBleInfo> r4, LocationOption r5) {
        if (r5 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:uploadBleCacheEntity option is null");
        this.mBleInfoListStatus = 2;
        uploadGpsAndBleInfos(r5);
        return;
    L6:
        if (r4 != null) goto L8;
    L15:
        Logger.i("BDLocationExtraDataServer:uploadBleCacheEntity bleInfos is null");
        this.mBleInfoListStatus = 2;
        uploadGpsAndBleInfos(r5);
        return;
    L8:
        if (r4.size() < 1) goto L15;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r4.size());
        Collections.sort(r4);
        if (r4.size() <= BDLocationConfig.getUploadBleNum()) goto L13;
        r4 = r4.subList(0, BDLocationConfig.getUploadBleNum());
    L13:
        this.mBleInfoListStatus = 3;
        this.mBleInfoList = r4;
        uploadGpsAndBleInfos(r5);
    }

    public static /* synthetic */ void access$300(BDLocationExtraDataServer r0, List r1, LocationOption r2) {
        r0.uploadBleCacheEntity(r1, r2);
    }

    public static /* synthetic */ void access$500(BDLocationExtraDataServer r0, List r1, long r2) {
        r0.setBleCacheEntity(r1, r2);
    }

    private void extraDataTraceLoggerAddLastLocationInfo(LocationExtraDataTraceLogger r27, LocationUploadExtra r28, LocationOption r29) {
        if (r27 == null) goto L35;
        if (r28 == null) goto L35;
        if (r29 == null) goto L35;
        BDGpsInfo r1 = r28.getGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        if (r1 != null) goto L10;
    L33:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extra.getGpsInfo() == null || option.getLightLocation() == null || option.getLastLocationEntity() == null || option.getLightLocationWifiGap() < 0");
        return;
    L10:
        if (r29.getLightLocation() == null) goto L33;
        if (r29.getLastLocationEntity() == null) goto L33;
        if (r29.getLightLocationWifiGap() < 0) goto L33;
        if ("gps".equals(r1.provider) == true) goto L20;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo !LocationManager.GPS_PROVIDER.equals(extra.getGpsInfo().provider)");
        return;
    L20:
        LastLocationEntity r2 = r29.getLastLocationEntity();
        if (r2.coordinateSystemSuccess == true) goto L24;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo!lastLocationEntity.coordinateSystemSuccess");
        return;
    L24:
        BDLocation r3 = r29.getLightLocation();
        long r4 = r2.gpsLocationDuration;
        long r6 = r2.networkLocationDuration;
        long r8 = r2.totalLocationDuration;
        long r10 = r29.getLightLocationWifiGap();
        long r12 = r2.gpsLocationGap;
        long r14 = r2.networkLocationGap;
        long r9 = r12 - r10;
        long r11 = r14 - r10;
        Location r13 = r2.gpsLocation;
        Location r5 = r2.networkLocation;
        float r7 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r3.getLatitude(), r3.getLongitude()));
        if (r13 == null) goto L27;
        float r15 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r13.getLatitude(), r13.getLongitude()));
        boolean r16 = true;
    L28:
        if (r5 == null) goto L30;
        float r17 = LocationUtil.calculateLineDistance(new BDPoint(r1.latitude, r1.longitude), new BDPoint(r5.getLatitude(), r5.getLongitude()));
        boolean r18 = true;
    L31:
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_DURATION, r4);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_DURATION, r6);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_TOTAL_LOCATION_DURATION, r8);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_WIFI_GAP, r10);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_GAP, r12);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_GAP, r14);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_GAP, r9);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_GAP, r11);
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r15 - r7) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r17 - r7) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LIGHT_LOCATION_DISTANCE, (long) (r7 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_GPS_DISTANCE, (long) (r15 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r27, LocationExtraDataTraceLogger.LAST_NETWORK_DISTANCE, (long) (r17 * 100.0f));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_GPS_LOCATION, Boolean.valueOf(r16));
        LocationMonitor.locationExtraDataTracePutCategoryData(r27, LocationExtraDataTraceLogger.HAS_LAST_NETWORK_LOCATION, Boolean.valueOf(r18));
        Logger.i("LOCATION_INFO", "lastGpsLocationDuration:" + r4 + ", lastNetworkLocationDuration:" + r6 + ", lastTotalLocationDuration:" + r8 + ", lightLocationWifiGap:" + r10 + ", lastGpsLocationGap:" + r12 + ", lastNetworkLocationGap:" + r14 + ", lastGpsAndLightLocationGap:" + r9 + ", lastNetworkAndLightLocationGap:" + r11 + ", lightLocationDistance:" + r7 + ", lastGpsDistance:" + r15 + ", lastNetworkDistance:" + r17 + ", hasLastGpsLocation:" + r16 + ", hasLastNetworkLocation:" + r18);
        return;
    L30:
        r17 = -1.0f;
        r18 = false;
        goto L31
    L27:
        r15 = -1.0f;
        r16 = false;
    L35:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extraDataTraceLogger == null || extra == null || option == null");
    }

    private void scanBlueToothData(long r10, long r12, LocationOption r14) {
        Logger.i("BDLocationExtraDataServer:scanBlueToothData");
        LocationExtraDataTraceLogger r0 = r14.getLocationExtraDataTraceLogger();
        int r1 = LocationUtil.getTargetSdkVersion();
        LocationMonitor.locationExtraDataTracePutCategoryData(r0, "target_sdk_version", Integer.valueOf(r1));
        int r2 = Build.VERSION.SDK_INT;
        LocationMonitor.locationExtraDataTracePutCategoryData(r0, LocationExtraDataTraceLogger.SDK_INT, Integer.valueOf(r2));
        if (r1 < 31) goto L9;
        if (r2 < 31) goto L9;
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L9;
        Logger.i("BDLocationExtraDataServer: scanBlueToothData and has no permission");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r14);
        return;
    L9:
        Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "scanBlueToothData run:");
        LocationMonitor.locationExtraDataTraceLogBegin(r0, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
        this.mBluetoothInfoManager.startScan(new BluetoothScanCallback(this, r14), r10, r12, r14.getBpeaCert());
    }

    private void upLoadServerApi(LocationUploadExtra r4, LocationOption r5, LocationExtraDataTraceLogger r6) {
        LocationResp r0 = ServerApi.uploadGpsAndBleInfos(r4);
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L5;
        extraDataTraceLoggerAddLastLocationInfo(r6, r4, r5);
    L5:
        LocationMonitor.locationExtraDataTraceLogEnd(r6, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        if (r0 != null) goto L8;
    L10:
        StringBuilder r7 = new StringBuilder("server error:");
        String r1 = "";
        if (r0 != null) goto L13;
        String r2 = "";
    L14:
        r7.append(r2);
        String r8 = r7.toString();
        if (r0 == null) goto L18;
        r1 = r0.resultCode + "";
    L18:
        LocationMonitor.locationExtraDataTraceLogErrorReport(r5, new BDLocationException(r8, LocationInfoConst.BDLOCATION, r1));
        return;
    L13:
        r2 = r0.resultMsg;
        goto L14
    L8:
        if (r0.resultCode != 0) goto L10;
        LocationMonitor.locationExtraDataTraceLogSuccessReport(r5);
    }

    private void uploadGpsAndBleInfos(final LocationUploadExtra r3, final LocationOption r4, final LocationExtraDataTraceLogger r5) {
        if (LocationUtil.isMainThread() == false) goto L5;
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass3(this, r3, r4, r5));
        return;
    L5:
        upLoadServerApi(r3, r4, r5);
    }

    public void startCollectGpsData(LocationOption r3, Handler r4, ArrayList<BDLocationExtraDataServer> r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isOnceLocation() == false) goto L9;
        this.mLocationHandler = r4;
        this.mLocationExtraDataServerList = r5;
        long r6 = System.currentTimeMillis();
        r3.setStartLocationTime(r6);
        Logger.i("BDLocationExtraDataServer:startCollectGpsData");
        setExtraData(r3);
        clearExtraData();
        collectGpsInfo(r3);
        Logger.i("location-trace-core startCollectGpsData duration:" + (System.currentTimeMillis() - r6));
        return;
    }

    public static /* synthetic */ void access$700(BDLocationExtraDataServer r0, LocationUploadExtra r1, LocationOption r2, LocationExtraDataTraceLogger r3) {
        r0.upLoadServerApi(r1, r2, r3);
    }
}
