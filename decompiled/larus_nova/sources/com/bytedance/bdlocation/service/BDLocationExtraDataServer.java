package com.bytedance.bdlocation.service;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
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

/* JADX INFO: loaded from: classes10.dex */
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
        public void onScan(BDBleInfo r100) {
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
        public void onSuccess(List<BDBleInfo> r100) {
            Logger.i("BDLocationExtraDataServer:scanBlueToothData success");
            LocationMonitor.locationExtraDataTracePutCategoryData(this.extraDataTraceLogger, LocationExtraDataTraceLogger.SCAN_BLE_SUCCESS, Boolean.TRUE);
            LocationExtraDataTraceLogger r101 = this.extraDataTraceLogger;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            LocationMonitor.locationExtraDataTracePutCategoryData(r101, LocationExtraDataTraceLogger.COLLECT_HAS_BLE_INFO, Boolean.valueOf(r102));
            LocationMonitor.locationExtraDataTraceLogEnd(this.extraDataTraceLogger, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
            List r103 = BDLocationExtraDataServer.access$200(this.this$0, r100);
            if (BDLocationConfig.isUploadBleImmediately() == false) goto L12;
            BDLocationExtraDataServer.access$300(this.this$0, r103, this.mOption);
            return;
        L12:
            BDLocationExtraDataServer.access$402(this.this$0, 2);
            BDLocationExtraDataServer.access$100(this.this$0, this.mOption);
            BDLocationExtraDataServer.access$500(this.this$0, r103, this.mOption.getStartLocationTime());
            return;
        L5:
            if (r100.isEmpty() == true) goto L7;
            r102 = true;
            goto L8
        }

        public BluetoothScanCallback(BDLocationExtraDataServer r100, LocationOption r101) {
            this.this$0 = r100;
            this.mOption = r101;
            if (r101 == null) goto L6;
            this.extraDataTraceLogger = r101.getLocationExtraDataTraceLogger();
            return;
        }
    }

    public void clearExtraData() {
        Logger.i("BDLocationExtraDataServer:clearExtraData");
        BDLocationConfig.setBleCacheEntity(null);
        BDLocationConfig.setLogIdCacheEntity(null);
    }

    public void stopCollectExtraData() {
        BluetoothInfoManager r100 = this.mBluetoothInfoManager;
        if (r100 == null) goto L6;
        r100.stopScan();
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
        LogIdCacheEntity r100 = BDLocationConfig.getLogIdCacheEntity();
        if (r100 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:getLogIdCache cache is null");
        return null;
    L6:
        BLECacheEntity r101 = BDLocationConfig.getBleCacheEntity();
        if (r101 != null) goto L9;
    L14:
        Logger.i("BDLocationExtraDataServer:getBleEntryList error");
        return null;
    L9:
        if (r101.getTimeStamp() != r100.timestamp) goto L14;
        if (TextUtils.isEmpty(r100.logId) == true) goto L14;
        Logger.i("BDLocationExtraDataServer:getBleEntryList success");
        return r101.getBleInfoList();
    }

    public GpsInfoManager getGpsInfoManager() {
        return this.mGpsInfoManager;
    }

    public static /* synthetic */ ArrayList access$600(BDLocationExtraDataServer r100) {
        return r100.mLocationExtraDataServerList;
    }

    private void collectGpsInfo(final LocationOption r100) {
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r100 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:collectGpsInfo option is null");
        this.mGpsInfoStatus = 1;
        uploadGpsAndBleInfos(r100);
        return;
    L6:
        final LocationExtraDataTraceLogger r101 = r100.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r101, "upload_source", r100.getUploadSource());
        this.mGpsInfoManager = new GpsInfoManager();
        final long r102 = System.currentTimeMillis();
        this.mGpsInfoManager.startGpsCollect(new AnonymousClass1(this, r101, r102, r100), r100);
    }

    private List<BDBleInfo> getNewBleInfos(List<BDBleInfo> r100) {
        if (r100 != null) goto L4;
    L22:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos bleInfos is null");
        return null;
    L4:
        if (r100.size() < 1) goto L22;
        List<String> r101 = BDLocationConfig.getDisableUuidList();
        if (r101 != null) goto L9;
    L20:
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is null");
        return new ArrayList(r100);
    L9:
        if (r101.size() <= 0) goto L20;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos disableUuidList is not null");
        ArrayList r102 = new ArrayList();
        long r103 = System.currentTimeMillis();
        Iterator<BDBleInfo> r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        BDBleInfo r105 = r104.next();
        if (r105.isBeacon == false) goto L18;
        if (CollectionUtil.containsIgnoreCase(r101, r105.beaconUuid) == false) goto L18;
        Logger.i("BDLocationExtraDataServer:getNewBleInfos and ignore the beacon");
    L18:
        r102.add(r105);
        goto L12
    L19:
        Logger.i(TAG, "getNewBleInfos and filter beacon duration(ms) is " + (System.currentTimeMillis() - r103));
        return r102;
    }

    private void setExtraData(LocationOption r100) {
        Logger.i("BDLocationExtraDataServer:setExtraData startLocationTime:" + r100.getStartLocationTime());
        LocationExtraBean r101 = new LocationExtraBean();
        r101.setBleInfoList(getBleEntryList());
        if (BDLocationConfig.getLogIdCacheEntity() == null) goto L5;
        LogIdCacheEntity r102 = BDLocationConfig.getLogIdCacheEntity();
    L6:
        r101.setLogIdCacheEntity(r102);
        r100.setLocationExtraBean(r101);
        return;
    L5:
        r102 = new LogIdCacheEntity();
        goto L6
    }

    private void uploadGpsAndBleInfos(LocationOption r100) {
        uploadGpsAndBleInfosAndRemove(r100);
        if (this.mLocationHandler == null) goto L6;
        this.mLocationHandler.post(new AnonymousClass2(this));
        return;
    }

    private void uploadGpsAndBleInfosAndRemove(LocationOption r110) {
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and mGpsInfoStatus:" + this.mGpsInfoStatus + ", mBleInfoListStatus:" + this.mBleInfoListStatus);
        if (BDLocationConfig.isEnableGpsScan() == false) goto L7;
        if (this.mGpsInfoStatus != 0) goto L7;
        return;
    L7:
        if (this.mBleInfoListStatus == 0) goto L106;
        StringBuilder r100 = new StringBuilder("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsinfo:");
        if (this.mGpsInfoStatus == 3) goto L11;
        boolean r101 = true;
    L12:
        r100.append(r101);
        r100.append(", bleinfos:");
        if (this.mBleInfoList == null) goto L15;
        boolean r102 = true;
    L16:
        r100.append(r102);
        Logger.i(r100.toString());
        LocationExtraDataTraceLogger r103 = r110.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.UPLOAD_GPS_AND_BLE_NUM, Integer.valueOf(this.uploadGpsAndBleNum.incrementAndGet()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.GPS_INFO_STATUS, Integer.valueOf(this.mGpsInfoStatus));
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.BLE_INFO_LIST_STATUS, Integer.valueOf(this.mBleInfoListStatus));
        if (this.mGpsInfoStatus != 3) goto L19;
    L22:
        LocationUploadExtra r104 = new LocationUploadExtra();
        r104.locationOption = r110;
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L26;
        LogIdCacheEntity r105 = BDLocationConfig.getLogIdCacheEntity();
    L34:
        Logger.i("BDLocationExtraDataServer: enableCheckLastLogId:" + BDLocationConfig.enableCheckLastLogId());
        if (r105 != null) goto L37;
        boolean r106 = true;
    L38:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_IS_NULL, Boolean.valueOf(r106));
        if (r105 != null) goto L41;
    L43:
        boolean r107 = false;
    L44:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.LOG_ID_CACHE_ENTITY_TIME_CHECK, Boolean.valueOf(r107));
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, Boolean.valueOf(BDLocationConfig.enableCheckLastLogId()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, Boolean.valueOf(BDLocationConfig.enableCheckUploadCompliance()));
        if (r105 != null) goto L47;
        long r108 = 0;
    L48:
        LocationMonitor.locationExtraDataTracePutExtraData(r103, LocationExtraDataTraceLogger.LOCATION_LOG_ID_CACHE_TIME, Long.valueOf(r108));
        LocationMonitor.locationExtraDataTracePutExtraData(r103, LocationExtraDataTraceLogger.START_LOCATION_TIME, Long.valueOf(r110.getStartLocationTime()));
        if (r105 != null) goto L51;
        String r109 = "";
    L52:
        LocationMonitor.locationExtraDataTracePutExtraData(r103, LocationExtraDataTraceLogger.LOCATION_LOG_ID, r109);
        StringBuilder r111 = new StringBuilder("BDLocationExtraDataServer: gpsCacheEntity:");
        if (r105 != null) goto L56;
        Object r112 = "null";
    L60:
        r111.append(r112);
        Logger.i(r111.toString());
        if (BDLocationConfig.enableUploadLastLogId() == true) goto L63;
    L71:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity != null");
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L74;
        r104.setLogIdCache(r105);
    L74:
        r104.setLocationExtraDataServer(this);
        if (r104.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult) == null) goto L77;
        boolean r113 = true;
    L78:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.UPLOAD_HAS_GPS_INFO, Boolean.valueOf(r113));
        if (r104.getSysLocation() == null) goto L81;
        boolean r114 = true;
    L82:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.UPLOAD_HAS_SYS_LOCATION_INFO, Boolean.valueOf(r114));
        if (r104.getAMapLocation() == null) goto L85;
        boolean r115 = true;
    L86:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.UPLOAD_HAS_AMAP_LOCATION_INFO, Boolean.valueOf(r115));
        r104.setLocateId(r110.getLocateId());
        if (this.mBleInfoList != null) goto L89;
    L91:
        boolean r116 = false;
    L92:
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.UPLOAD_HAS_BLE_INFO_LIST, Boolean.valueOf(r116));
        r104.setBleList(this.mBleInfoList);
        if (this.mGpsInfoStatus != 0) goto L95;
    L101:
        r104.setGpsAndBleMark("ble");
    L102:
        r104.setTriggerType(r110.getTriggerType());
        r104.setUploadSource(r110.getUploadSource());
        LocationMonitor.locationExtraDataTracePutCategoryData(r103, LocationExtraDataTraceLogger.EXTRA_DATA_MARK, r104.getGpsAndBleMark());
        uploadGpsAndBleInfos(r104, r110, r103);
    L103:
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        return;
    L95:
        if (this.mGpsInfoStatus == 1) goto L101;
        if (this.mBleInfoListStatus == 3) goto L100;
        r104.setGpsAndBleMark(GeocodeSearch.GPS);
        goto L102
    L100:
        r104.setGpsAndBleMark("ble_gps");
        goto L102
    L89:
        if (this.mBleInfoList.isEmpty() == true) goto L91;
        r116 = true;
        goto L92
    L85:
        r115 = false;
        goto L86
    L81:
        r114 = false;
        goto L82
    L77:
        r113 = false;
        goto L78
    L63:
        if (BDLocationConfig.enableCheckLastLogId() == false) goto L71;
        if (r105 != null) goto L66;
    L70:
        Logger.i("BDLocationExtraDataServer: uploadGpsAndBleInfos and gpsCacheEntity is null");
        LocationMonitor.locationExtraDataTraceLogEnd(r103, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        LocationMonitor.locationExtraDataTraceLogErrorReport(r110, new BDLocationException("logId Cache Entity Error", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_LOG_ID_CACHE_ENTITY));
        goto L103
    L66:
        if (r105.timestamp != r110.getStartLocationTime()) goto L70;
        if (TextUtils.isEmpty(r105.logId) == true) goto L70;
    L56:
        if (r105.timestamp != r110.getStartLocationTime()) goto L58;
        boolean r117 = true;
    L59:
        r112 = Boolean.valueOf(r117);
        goto L60
    L58:
        r117 = false;
        goto L59
    L51:
        r109 = r105.logId;
        goto L52
    L47:
        r108 = r105.timestamp;
        goto L48
    L41:
        if (r105.timestamp != r110.getStartLocationTime()) goto L43;
        r107 = true;
        goto L44
    L37:
        r106 = false;
        goto L38
    L26:
        if (r110.getLocationExtraBean() == null) goto L28;
        r105 = r110.getLocationExtraBean().getLogIdCacheEntity();
    L29:
        StringBuilder r118 = new StringBuilder("uploadGpsAndBleInfosAndRemove ");
        if (r105 != null) goto L32;
        String r119 = "logIdCacheEntity = null";
    L33:
        r118.append(r119);
        Logger.i(r118.toString());
        goto L34
    L32:
        r119 = "logIdCacheEntity.logId: " + r105.logId + ", logIdCacheEntity.timestamp: " + r105.timestamp;
        goto L33
    L28:
        r105 = null;
        goto L29
    L19:
        if (this.mBleInfoList != null) goto L22;
        Logger.i("BDLocationExtraDataServer: extra data scan failed");
        this.mGpsInfoStatus = 0;
        this.mBleInfoListStatus = 0;
        LocationMonitor.locationExtraDataTraceLogErrorReport(r110, new BDLocationException("extra data scan failed", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_EXTRA_DATA_SCAN_FAILED));
        return;
    L15:
        r102 = false;
        goto L16
    L11:
        r101 = false;
        goto L12
    }

    public void startCollectBluetoothData(LocationOption r110) {
        this.mBleInfoListStatus = 0;
        this.mBleInfoList = null;
        if (r110 != null) goto L5;
    L30:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData option is null");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r110);
        return;
    L5:
        if (r110.isOnceLocation() == false) goto L30;
        if (r110.scanBle() == false) goto L30;
        LocationExtraDataTraceLogger r100 = r110.getLocationExtraDataTraceLogger();
        LocationMonitor.locationExtraDataTracePutCategoryData(r100, LocationExtraDataTraceLogger.ENABLE_SCAN_BLE, Boolean.valueOf(BDLocationConfig.enableScanBle()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r100, LocationExtraDataTraceLogger.FIRST_REQUEST_LOCATION, Boolean.valueOf(BDLocationConfig.firstRequestLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(r100, "enable_collect_ble_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectBleInBatterySavingMode()));
        if (BDLocationConfig.enableCollectBleInBatterySavingMode() == true) goto L16;
        if (r110.getMode() != 0) goto L16;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData Battery_Saving mode");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r110);
        return;
    L16:
        if (BDLocationConfig.isUploadBleImmediately() == true) goto L22;
        if (BDLocationConfig.firstRequestLocation() == false) goto L22;
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData firstRequestLocation");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r110);
        return;
    L22:
        if (BDLocationConfig.enableScanBle() == true) goto L24;
    L28:
        Logger.i("BDLocationExtraDataServer:startCollectBluetoothData not enable scan ble");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r110);
        return;
    L24:
        if (BDLocationConfig.getScanBleInterval() <= 0) goto L28;
        scanBlueToothData(0, BDLocationConfig.getScanBleInterval(), r110);
    }

    public static /* synthetic */ int access$002(BDLocationExtraDataServer r100, int r101) {
        r100.mGpsInfoStatus = r101;
        return r101;
    }

    public static /* synthetic */ void access$100(BDLocationExtraDataServer r100, LocationOption r101) {
        r100.uploadGpsAndBleInfos(r101);
    }

    public static /* synthetic */ List access$200(BDLocationExtraDataServer r100, List r101) {
        return r100.getNewBleInfos(r101);
    }

    public static /* synthetic */ int access$402(BDLocationExtraDataServer r100, int r101) {
        r100.mBleInfoListStatus = r101;
        return r101;
    }

    private void setBleCacheEntity(List<BDBleInfo> r100, long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() < 1) goto L12;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r100.size());
        Collections.sort(r100);
        if (r100.size() <= BDLocationConfig.getUploadBleNum()) goto L9;
        r100 = r100.subList(0, BDLocationConfig.getUploadBleNum());
    L9:
        BLECacheEntity r102 = new BLECacheEntity();
        r102.setBleInfoList(r100);
        r102.setTimeStamp(r101);
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r100.size() + "--startLocationTime：" + r101);
        BDLocationConfig.setBleCacheEntity(r102);
        return;
    }

    private void uploadBleCacheEntity(List<BDBleInfo> r100, LocationOption r101) {
        if (r101 != null) goto L6;
        Logger.i("BDLocationExtraDataServer:uploadBleCacheEntity option is null");
        this.mBleInfoListStatus = 2;
        uploadGpsAndBleInfos(r101);
        return;
    L6:
        if (r100 != null) goto L8;
    L15:
        Logger.i("BDLocationExtraDataServer:uploadBleCacheEntity bleInfos is null");
        this.mBleInfoListStatus = 2;
        uploadGpsAndBleInfos(r101);
        return;
    L8:
        if (r100.size() < 1) goto L15;
        Logger.i("BDLocationExtraDataServer:setBleCacheEntity size:" + r100.size());
        Collections.sort(r100);
        if (r100.size() <= BDLocationConfig.getUploadBleNum()) goto L13;
        r100 = r100.subList(0, BDLocationConfig.getUploadBleNum());
    L13:
        this.mBleInfoListStatus = 3;
        this.mBleInfoList = r100;
        uploadGpsAndBleInfos(r101);
    }

    public static /* synthetic */ void access$300(BDLocationExtraDataServer r100, List r101, LocationOption r102) {
        r100.uploadBleCacheEntity(r101, r102);
    }

    public static /* synthetic */ void access$500(BDLocationExtraDataServer r100, List r101, long r102) {
        r100.setBleCacheEntity(r101, r102);
    }

    private void extraDataTraceLoggerAddLastLocationInfo(LocationExtraDataTraceLogger r210, LocationUploadExtra r211, LocationOption r212) {
        if (r210 == null) goto L35;
        if (r211 == null) goto L35;
        if (r212 == null) goto L35;
        BDGpsInfo r100 = r211.getGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        if (r100 != null) goto L10;
    L33:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extra.getGpsInfo() == null || option.getLightLocation() == null || option.getLastLocationEntity() == null || option.getLightLocationWifiGap() < 0");
        return;
    L10:
        if (r212.getLightLocation() == null) goto L33;
        if (r212.getLastLocationEntity() == null) goto L33;
        if (r212.getLightLocationWifiGap() < 0) goto L33;
        if (GeocodeSearch.GPS.equals(r100.provider) == true) goto L20;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo !LocationManager.GPS_PROVIDER.equals(extra.getGpsInfo().provider)");
        return;
    L20:
        LastLocationEntity r101 = r212.getLastLocationEntity();
        if (r101.coordinateSystemSuccess == true) goto L24;
        Logger.i("extraDataTraceLoggerAddLastLocationInfo!lastLocationEntity.coordinateSystemSuccess");
        return;
    L24:
        BDLocation r102 = r212.getLightLocation();
        long r103 = r101.gpsLocationDuration;
        long r104 = r101.networkLocationDuration;
        long r105 = r101.totalLocationDuration;
        long r110 = r212.getLightLocationWifiGap();
        long r111 = r101.gpsLocationGap;
        long r112 = r101.networkLocationGap;
        long r106 = r111 - r110;
        long r107 = r112 - r110;
        Location r108 = r101.gpsLocation;
        Location r109 = r101.networkLocation;
        float r113 = LocationUtil.calculateLineDistance(new BDPoint(r100.latitude, r100.longitude), new BDPoint(r102.getLatitude(), r102.getLongitude()));
        if (r108 == null) goto L27;
        float r114 = LocationUtil.calculateLineDistance(new BDPoint(r100.latitude, r100.longitude), new BDPoint(r108.getLatitude(), r108.getLongitude()));
        boolean r115 = true;
    L28:
        if (r109 == null) goto L30;
        float r116 = LocationUtil.calculateLineDistance(new BDPoint(r100.latitude, r100.longitude), new BDPoint(r109.getLatitude(), r109.getLongitude()));
        boolean r117 = true;
    L31:
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_DURATION, r103);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_DURATION, r104);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_TOTAL_LOCATION_DURATION, r105);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LIGHT_LOCATION_WIFI_GAP, r110);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_GPS_LOCATION_GAP, r111);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_NETWORK_LOCATION_GAP, r112);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_GAP, r106);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_GAP, r107);
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_GPS_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r114 - r113) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_NETWORK_AND_LIGHT_LOCATION_DISTANCE_GAP, (long) ((r116 - r113) * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LIGHT_LOCATION_DISTANCE, (long) (r113 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_GPS_DISTANCE, (long) (r114 * 100.0f));
        LocationMonitor.locationExtraDataTracePutMetricData(r210, LocationExtraDataTraceLogger.LAST_NETWORK_DISTANCE, (long) (r116 * 100.0f));
        LocationMonitor.locationExtraDataTracePutCategoryData(r210, LocationExtraDataTraceLogger.HAS_LAST_GPS_LOCATION, Boolean.valueOf(r115));
        LocationMonitor.locationExtraDataTracePutCategoryData(r210, LocationExtraDataTraceLogger.HAS_LAST_NETWORK_LOCATION, Boolean.valueOf(r117));
        Logger.i("LOCATION_INFO", "lastGpsLocationDuration:" + r103 + ", lastNetworkLocationDuration:" + r104 + ", lastTotalLocationDuration:" + r105 + ", lightLocationWifiGap:" + r110 + ", lastGpsLocationGap:" + r111 + ", lastNetworkLocationGap:" + r112 + ", lastGpsAndLightLocationGap:" + r106 + ", lastNetworkAndLightLocationGap:" + r107 + ", lightLocationDistance:" + r113 + ", lastGpsDistance:" + r114 + ", lastNetworkDistance:" + r116 + ", hasLastGpsLocation:" + r115 + ", hasLastNetworkLocation:" + r117);
        return;
    L30:
        r116 = -1.0f;
        r117 = false;
        goto L31
    L27:
        r114 = -1.0f;
        r115 = false;
    L35:
        Logger.i("extraDataTraceLoggerAddLastLocationInfo extraDataTraceLogger == null || extra == null || option == null");
    }

    private void scanBlueToothData(long r110, long r111, LocationOption r112) {
        Logger.i("BDLocationExtraDataServer:scanBlueToothData");
        LocationExtraDataTraceLogger r100 = r112.getLocationExtraDataTraceLogger();
        int r101 = LocationUtil.getTargetSdkVersion();
        LocationMonitor.locationExtraDataTracePutCategoryData(r100, "target_sdk_version", Integer.valueOf(r101));
        int r102 = Build.VERSION.SDK_INT;
        LocationMonitor.locationExtraDataTracePutCategoryData(r100, LocationExtraDataTraceLogger.SDK_INT, Integer.valueOf(r102));
        if (r101 < 31) goto L9;
        if (r102 < 31) goto L9;
        if (PermissionManager.hasBluetoothPermissions(BDLocationConfig.getContext()) == true) goto L9;
        Logger.i("BDLocationExtraDataServer: scanBlueToothData and has no permission");
        this.mBleInfoListStatus = 1;
        uploadGpsAndBleInfos(r112);
        return;
    L9:
        Logger.i(BluetoothUtil.BLE_SCAN_TRACE, "scanBlueToothData run:");
        LocationMonitor.locationExtraDataTraceLogBegin(r100, LocationExtraDataTraceLogger.BLE_SCAN_DURATION);
        this.mBluetoothInfoManager.startScan(new BluetoothScanCallback(this, r112), r110, r111, r112.getBpeaCert());
    }

    private void upLoadServerApi(LocationUploadExtra r100, LocationOption r101, LocationExtraDataTraceLogger r102) {
        LocationResp r103 = ServerApi.uploadGpsAndBleInfos(r100);
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L5;
        extraDataTraceLoggerAddLastLocationInfo(r102, r100, r101);
    L5:
        LocationMonitor.locationExtraDataTraceLogEnd(r102, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);
        if (r103 != null) goto L8;
    L10:
        StringBuilder r104 = new StringBuilder("server error:");
        String r105 = "";
        if (r103 != null) goto L13;
        String r106 = "";
    L14:
        r104.append(r106);
        String r107 = r104.toString();
        if (r103 == null) goto L18;
        r105 = r103.resultCode + "";
    L18:
        LocationMonitor.locationExtraDataTraceLogErrorReport(r101, new BDLocationException(r107, LocationInfoConst.BDLOCATION, r105));
        return;
    L13:
        r106 = r103.resultMsg;
        goto L14
    L8:
        if (r103.resultCode != 0) goto L10;
        LocationMonitor.locationExtraDataTraceLogSuccessReport(r101);
    }

    private void uploadGpsAndBleInfos(final LocationUploadExtra r100, final LocationOption r101, final LocationExtraDataTraceLogger r102) {
        if (LocationUtil.isMainThread() == false) goto L5;
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass3(this, r100, r101, r102));
        return;
    L5:
        upLoadServerApi(r100, r101, r102);
    }

    public void startCollectGpsData(LocationOption r100, Handler r101, ArrayList<BDLocationExtraDataServer> r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isOnceLocation() == false) goto L9;
        this.mLocationHandler = r101;
        this.mLocationExtraDataServerList = r102;
        long r103 = System.currentTimeMillis();
        r100.setStartLocationTime(r103);
        Logger.i("BDLocationExtraDataServer:startCollectGpsData");
        setExtraData(r100);
        clearExtraData();
        collectGpsInfo(r100);
        Logger.i("location-trace-core startCollectGpsData duration:" + (System.currentTimeMillis() - r103));
        return;
    }

    public static /* synthetic */ void access$700(BDLocationExtraDataServer r100, LocationUploadExtra r101, LocationOption r102, LocationExtraDataTraceLogger r103) {
        r100.upLoadServerApi(r101, r102, r103);
    }
}
