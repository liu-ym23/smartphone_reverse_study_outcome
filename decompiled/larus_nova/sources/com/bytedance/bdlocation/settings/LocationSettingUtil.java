package com.bytedance.bdlocation.settings;

import android.content.Context;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.store.LocationCache;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class LocationSettingUtil {
    public static final String LOCATION_SDK_SETTINGS_KEY = "sdk_key_BDUGLocationKit";
    private static LocationSettingModel sLocationSettingModel;

    public LocationSettingUtil() {
    }

    public static void setLocationConfig() {
        if (sLocationSettingModel != null) goto L5;
        String r100 = LocationCache.getInstance().getLocationSettings();
        Logger.i("LocationSettings:::" + r100);
        sLocationSettingModel = LocationSettingModel.toModel(r100);
    L5:
        LocationSettingModel r101 = sLocationSettingModel;
        if (r101 == null) goto L9;
        BDLocationConfig.setUpload(r101.collectConfig);
        BDLocationConfig.setLiveStallReportEnabled(sLocationSettingModel.enableLiveStallReport);
        BDLocationConfig.setLiveStallReportWindowMs(sLocationSettingModel.liveStallReportWindowMs);
        BDLocationConfig.setPollingUpload(sLocationSettingModel.pollingUpload);
        BDLocationConfig.setIndependentThreadGetScanResults(sLocationSettingModel.independentThreadGetScanResults);
        BDLocationConfig.setAMapGPSCollectAlwaysUseNewAMapClient(sLocationSettingModel.amapGPSCollectAlwaysUseNewAMapClient);
        BDLocationConfig.setEnableLocationOptBpeaList(sLocationSettingModel.enableLocationOptBpeaList);
        BDLocationConfig.setEnableLocationOptEncrypt(sLocationSettingModel.enableLocationOptEncrypt);
        BDLocationConfig.setUploadInterval(((long) sLocationSettingModel.reportIntervalSeconds) * 1000);
        BDLocationConfig.setReportAtStart(sLocationSettingModel.reportAtStart);
        BDLocationConfig.setReportLocationAtStart(sLocationSettingModel.reportLocationAtStart);
        BDLocationConfig.setIsUploadGPS(sLocationSettingModel.reportGps);
        BDLocationConfig.setBssNum(sLocationSettingModel.reportBssMax);
        BDLocationConfig.setWifiNum(sLocationSettingModel.reportWifiMax);
        BDLocationConfig.setEnableHARCollect(sLocationSettingModel.reportHar);
        BDLocationConfig.setHARStatusRange(sLocationSettingModel.reportHarRange);
        BDLocationConfig.setShakeConfig(sLocationSettingModel.shakeConfig);
        BDLocationConfig.setEnableTraceroute(sLocationSettingModel.enableTraceroute);
        BDLocationConfig.setLocateType(sLocationSettingModel.locateType);
        BDLocationConfig.setColdBootABTest(sLocationSettingModel.coldBootABTest);
        BDLocationConfig.setUploadBleNum(sLocationSettingModel.uploadBleNum);
        BDLocationConfig.setScanBleInterval(sLocationSettingModel.scanBleInterval);
        BDLocationConfig.setEnableScanBle(sLocationSettingModel.scanBle);
        BDLocationConfig.setEnableBlePassiveName(sLocationSettingModel.enableBlePassiveName);
        BDLocationConfig.setEnableBleTruncateOnTimeout(sLocationSettingModel.enableBleTruncateOnTimeout);
        BDLocationConfig.setCheckLocationBpea(sLocationSettingModel.checkLocationBpea);
        BDLocationConfig.setLocationMode(sLocationSettingModel.locationMode);
        BDLocationConfig.setOpenWifiListMonitor(sLocationSettingModel.openWifiListMonitor);
        BDLocationConfig.setUseGpsCheckRegion(sLocationSettingModel.useGpsCheckRegion);
        BDLocationConfig.setNeedDownGradeLocationInOverseas(sLocationSettingModel.needDowngradeLocationInOverseas);
        BDLocationConfig.setRedGeoNameIds(sLocationSettingModel.redGeoNameIds);
        BDLocationConfig.setOverseasGetLocationFailedUseCacheValidity(sLocationSettingModel.overseasGetLocationFailedCacheValidityTime);
        BDLocationConfig.setUseNewCacheStrategy(sLocationSettingModel.useNewCacheStrategy);
        BDLocationConfig.setEnableLightLocation(sLocationSettingModel.enableLightLocation);
        BDLocationConfig.setCollectLightInfo(sLocationSettingModel.collectLightInfo);
        BDLocationConfig.setRevertToSystemLocation(sLocationSettingModel.revertToSystemLocation);
        BDLocationConfig.setLightInfoInterval(sLocationSettingModel.lightInfoInterval);
        BDLocationConfig.setMaxLightCount(sLocationSettingModel.maxLightCount);
        BDLocationConfig.setMaxLightDuration(sLocationSettingModel.maxLightDuration);
        BDLocationConfig.setSensorContinuousCollectEnabled(sLocationSettingModel.sensorCollectionEnabled);
        BDLocationConfig.setSensorLightEnabled(sLocationSettingModel.sensorLightEnabled);
        BDLocationConfig.setContinueLightInfoInterval(sLocationSettingModel.sensorLightHz);
        BDLocationConfig.setSensorMaxCacheSeconds(sLocationSettingModel.sensorMaxCacheSeconds);
        BDLocationConfig.setSensorAccelerometerEnabled(sLocationSettingModel.sensorAccelerometerEnabled);
        BDLocationConfig.setContinueAccelerometerInterval(sLocationSettingModel.sensorAccelerometerHz);
        BDLocationConfig.setSensorGyroscopeEnabled(sLocationSettingModel.sensorGyroscopeEnabled);
        BDLocationConfig.setContinueGyroscopeInterval(sLocationSettingModel.sensorGyroscopeHz);
        BDLocationConfig.setSensorMagnetometerEnabled(sLocationSettingModel.sensorMagnetometerEnabled);
        BDLocationConfig.setContinueMagnetometerInterval(sLocationSettingModel.sensorMagnetometerHz);
        BDLocationConfig.setSensorBarometerEnabled(sLocationSettingModel.sensorBarometerEnabled);
        BDLocationConfig.setContinuePressureInterval(sLocationSettingModel.sensorBarometerHz);
        BDLocationConfig.setSensorDopEnabled(sLocationSettingModel.sensorDopEnabled);
        BDLocationConfig.setSensorGnssEnabled(sLocationSettingModel.sensorGnssEnabled);
        BDLocationConfig.setEnableGpsScan(sLocationSettingModel.enableGpsScan);
        BDLocationConfig.setAsyncScanWifi(sLocationSettingModel.asyncScanWifi);
        BDLocationConfig.setEnableCheckConnectWifi(sLocationSettingModel.enableCheckConnectWifi);
        BDLocationConfig.setCheckConnectWifiRssi(sLocationSettingModel.checkConnectWifiRssi);
        BDLocationConfig.setEnableCheckRefreshWifiTime(sLocationSettingModel.enableCheckWifiCache);
        BDLocationConfig.setCheckRefreshWifiTimeInterval(sLocationSettingModel.checkWifiCacheDuration);
        BDLocationConfig.setEnableScanWifi(sLocationSettingModel.enableScanWifi);
        BDLocationConfig.setUseNewReverseGeoLocationApi(sLocationSettingModel.useNewReverseGeoLocationApi);
        BDLocationConfig.setNoLocReqCgiEnable(sLocationSettingModel.enableNoLocReqCgi);
        BDLocationConfig.setSysNetworkLocEnable(sLocationSettingModel.enableSysNetworkLoc);
        BDLocationConfig.setEnableLightLocationNewPolicy(sLocationSettingModel.enableLightLocationNewPolicy);
        BDLocationConfig.setEnableBackgroundLocation(sLocationSettingModel.enableBackgroundLocation);
        BDLocationConfig.setInfoRequestKeyParamsMaxCacheTime(sLocationSettingModel.infoRequestKeyParamsMaxCacheTime);
        BDLocationConfig.setEnableInfoRequestOpt(sLocationSettingModel.enableInfoRequestOpt);
        BDLocationConfig.setMaxWaitGpsTimeMillis(sLocationSettingModel.maxWaitGPSTimeMillis);
        BDLocationConfig.setPreLocationCallback(sLocationSettingModel.preLocationCallback);
        BDLocationConfig.setEnableAcceptLightLocationParam(sLocationSettingModel.enableAcceptLightLocationParam);
        BDLocationConfig.setByteLocationLibraParam(sLocationSettingModel.byteLocationLibraParam);
        BDLocationConfig.setSearchLocationCacheTime(sLocationSettingModel.searchLocationCacheTime);
        BDLocationConfig.setByteLocationWhiteList(sLocationSettingModel.byteLocationWhiteList);
        BDLocationConfig.setCollectGpsType(sLocationSettingModel.collectGpsType);
        BDLocationConfig.setWifiScanInterval(sLocationSettingModel.wifiScanInterval);
        BDLocationConfig.setBeaconConfig(sLocationSettingModel.beaconConfig);
        BDLocationConfig.setEnableMonitor(sLocationSettingModel.enableMonitor);
        BDLocationConfig.setMonitorStrategy(sLocationSettingModel.monitorStrategy);
        BDLocationConfig.setMonitorStrategyInterval(sLocationSettingModel.monitorStrategyInterval);
        BDLocationConfig.setMonitorStrategyClassMemberList(sLocationSettingModel.monitorStrategyClassMember);
        BDLocationConfig.setMonitorBusinessStartLocationClassMemberList(sLocationSettingModel.monitorBusinessStartLocationClassMember);
        BDLocationConfig.setMonitorBusinessStopLocationClassMemberList(sLocationSettingModel.monitorBusinessStopLocationClassMember);
        BDLocationConfig.setEnableRescanWifi(sLocationSettingModel.sEnableRescanWifi);
        BDLocationConfig.setRescanWifiCount(sLocationSettingModel.sRescanWifiCount);
        BDLocationConfig.setUseCacheCondition(sLocationSettingModel.useCacheCondition);
        BDLocationConfig.setDisableCollectAMapLocationSource(sLocationSettingModel.disableCollectAMapLocationSource);
        BDLocationConfig.setLocationCacheTokenWhiteList(sLocationSettingModel.locationCacheTokenWhiteList);
        BDLocationConfig.setEnableLocationCacheTokenWhiteList(sLocationSettingModel.enableLocationCacheTokenWhiteList);
        BDLocationConfig.setHotBootLocToken(sLocationSettingModel.hotBootLocToken);
        BDLocationConfig.setHotBootCacheTime(sLocationSettingModel.hotBootCacheTime);
        BDLocationConfig.setColdBootCollectGpsStrategy(sLocationSettingModel.coldBootCollectGpsStrategy);
        BDLocationConfig.setColdBootCollectGps(sLocationSettingModel.coldBootCollectGps);
        BDLocationConfig.setEnableCollectGPSLocationInBatterySavingMode(sLocationSettingModel.enableCollectGPSLocationInBatterySavingMode);
        BDLocationConfig.setEnableCollectNetworkLocationInBatterySavingMode(sLocationSettingModel.enableCollectNetworkLocationInBatterySavingMode);
        BDLocationConfig.setEnableCollectAMapLocationInBatterySavingMode(sLocationSettingModel.enableCollectAMapLocationInBatterySavingMode);
        BDLocationConfig.setEnableCollectBleInBatterySavingMode(sLocationSettingModel.enableCollectBleInBatterySavingMode);
        BDLocationConfig.setEnableUploadLastLogId(sLocationSettingModel.enableUploadLastLogId);
        BDLocationConfig.setEnableDestroyAMapSingleClient(sLocationSettingModel.enableDestroyAMapSingleClient);
        BDLocationConfig.setEnableDestroyAMapContinuousClient(sLocationSettingModel.enableDestroyAMapContinuousClient);
        BDLocationConfig.setNetworkSignatureMode(sLocationSettingModel.networkSignatureMode);
        BDLocationConfig.setDefaultGpsScanInterval(sLocationSettingModel.defaultGpsScanInterval);
        BDLocationConfig.setEnableCheckUploadCompliance(sLocationSettingModel.enableCheckUploadCompliance);
        BDLocationConfig.setEnableBackgroundUploadLocationn(sLocationSettingModel.enableBackgroundUploadLocation);
        BDLocationConfig.setEnableCheckLastLogId(sLocationSettingModel.enableCheckLastLogId);
        BDLocationConfig.setEnableCollectContinuousGPSLocation(sLocationSettingModel.enableCollectContinuousGps);
        BDLocationConfig.setCollectContinuousGPSInterval(sLocationSettingModel.collectContinuousGpsInterval);
        BDLocationConfig.setCollectContinuousGPSDuration(sLocationSettingModel.collectContinuousGpsDuration);
        BDLocationConfig.setCollectContinuousTokenBlacklist(sLocationSettingModel.collectContinuousGpsLocTokenBlacklist);
        BDLocationConfig.setCollectContinuousGpsDisableGnssUpload(sLocationSettingModel.collectContinuousGpsDisableGnssUpload);
        BDLocationConfig.setCollectContinuousGpsOnlyLast(sLocationSettingModel.collectContinuousGpsOnlyLast);
        BDLocationConfig.setEnableUseCoarseLocation(sLocationSettingModel.enableUseCoarseLocation);
        BDLocationConfig.setEnableDimLocationCheck(sLocationSettingModel.enableDimLocationCheck);
        BDLocationConfig.setEnableTailLocateOptimize(sLocationSettingModel.enableTailLocateOptimize);
        BDLocationConfig.setTailAccuracyThreshold(sLocationSettingModel.tailAccuracyThreshold);
        BDLocationConfig.setTailWifiTimeThreshold(sLocationSettingModel.tailWifiTimeThreshold);
        BDLocationConfig.setDisableTailLocateOptimizeSource(sLocationSettingModel.disableTailLocateOptimizeSource);
        BDLocationConfig.setUploadFreshBaseStation(sLocationSettingModel.isUploadFreshBaseStation);
        BDLocationConfig.setFreshBaseStationTimeout(sLocationSettingModel.freshBaseStationTimeout);
        BDLocationConfig.setBaseStationInfoType(sLocationSettingModel.baseStationInfoType);
        BDLocationConfig.setEnableUploadLastLocationInfo(sLocationSettingModel.enableUploadLastLocationInfo);
        BDLocationConfig.setInOutDoorStatusCacheTime(sLocationSettingModel.inOutDoorStatusCacheTime);
        BDLocationConfig.setEnableScanGnss(sLocationSettingModel.enableScanGnss);
        BDLocationConfig.setStationarySceneMaxDistance(sLocationSettingModel.stationarySceneMaxDistance);
        BDLocationConfig.setStationarySceneMaxInterval(sLocationSettingModel.stationarySceneMaxInterval);
        BDLocationConfig.setStationarySceneMaxGpsAccuracy(sLocationSettingModel.stationarySceneMaxGpsAccuracy);
        BDLocationConfig.setStationarySceneWifiWhiteList(sLocationSettingModel.stationarySceneWifiWhiteList);
        BDLocationConfig.setStationarySceneTokenWhiteList(sLocationSettingModel.stationarySceneTokenWhiteList);
        BDLocationConfig.setEnableStationaryScenePolicy(sLocationSettingModel.enableStationaryScenePolicy);
        BDLocationConfig.setEnableCollectContinuousGpsForTest(sLocationSettingModel.enableCollectContinuousGpsForTest);
        BDLocationConfig.setEnableContinueLocateUploadWifi(sLocationSettingModel.enableContinueLocateUploadWifi);
        BDLocationConfig.setEnableContinueLocateUploadCell(sLocationSettingModel.enableContinueLocateUploadCell);
        BDLocationConfig.setEnableByteContinuousLocation(sLocationSettingModel.enableByteContinuousLocation);
        BDLocationConfig.setLocationExpiredInterval(sLocationSettingModel.locationExpiredInterval);
        BDLocationConfig.setUploadNetSignalInterval(sLocationSettingModel.uploadNetSignalInterval);
        BDLocationConfig.setFirstLocationTimeoutMs(sLocationSettingModel.firstLocationTimeoutMs);
        BDLocationConfig.setNeedUploadLastContinuousLocation(sLocationSettingModel.needUploadLastContinuousLocation);
        BDLocationConfig.setIsUseQuickGPS(sLocationSettingModel.isUseQuickGPS);
        BDLocationConfig.setEnableFusionLocation(sLocationSettingModel.enableFusionLocation);
        BDLocationConfig.setFusionLocationSensorBatchPushInterval(sLocationSettingModel.sensorBatchPushInterval);
        BDLocationConfig.setFusionLocationGpsInterval(sLocationSettingModel.sensorBatchGpsInterval);
        BDLocationConfig.setFusionLocationAccelerometerInterval(sLocationSettingModel.sensorBatchAccelerometerInterval);
        BDLocationConfig.setFusionLocationGyroscopeInterval(sLocationSettingModel.sensorBatchGyroscopeInterval);
        BDLocationConfig.setFusionLocationMagnetometerInterval(sLocationSettingModel.sensorBatchMagnetometerInterval);
        BDLocationConfig.setFusionLocationHeadingInterval(sLocationSettingModel.sensorBatchHeadingInterval);
        BDLocationConfig.setFusionLocationBarometerInterval(sLocationSettingModel.sensorBatchBarometerInterval);
        BDLocationConfig.setFusionLocationLightInterval(sLocationSettingModel.sensorBatchLightInterval);
        BDLocationConfig.setFusionLocationDopInterval(sLocationSettingModel.sensorBatchDopInterval);
        BDLocationConfig.setFusionLocationTempInterval(sLocationSettingModel.sensorBatchTempInterval);
        BDLocationConfig.setFusionLocationSatelliteInfoInterval(sLocationSettingModel.sensorBatchSatelliteInfoInterval);
        BDLocationConfig.setFusionLocationEnableTrackUpload(sLocationSettingModel.enableTrackUpload);
        BDLocationConfig.setFusionLocationTrackIntervalSec(sLocationSettingModel.trackIntervalSec);
        return;
    }

    public static LocationSettingModel getLocationConfig() {
        return sLocationSettingModel;
    }

    public static void updateSettings(Context r100, JSONObject r101) {
        if (r100 == null) goto L11;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.has(LOCATION_SDK_SETTINGS_KEY) == false) goto L8;
        r101 = r101.optJSONObject(LOCATION_SDK_SETTINGS_KEY);
    L8:
        if (r101 == null) goto L12;
        Logger.i("updateSettings:::" + r101.toString());
        sLocationSettingModel = LocationSettingModel.toModel(r101.toString());
        LocationCache.getInstance().setLocationSettings(r100, r101.toString());
        return;
    L12:
        return;
    }
}
