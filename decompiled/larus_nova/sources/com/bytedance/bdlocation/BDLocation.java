package com.bytedance.bdlocation;

import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.entity.GeoPoiEntity;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.InputSystemGpsInfo;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.map.api.data.MapInfoConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BDLocation extends Location {
    private BDLocationException exception;
    private transient boolean isCache;
    transient double latitudeWgs84;
    transient double longitudeWgs84;
    private int mAccuracyLevel;
    private String mAdCode;
    private String mAddress;
    private String mAdministrativeArea;
    private String mAoi;
    private List<PoiInfoEntity> mAoiEntities;
    private BdLBSResult mBdLBSResult;
    private float mBearing;
    private String mBuildingId;
    private String mCity;
    private String mCityAsciName;
    private String mCityCode;
    private long mCityId;
    private WifiInfo mConnectedWifiInfo;
    private String mCoordinateSystem;
    private String mCountry;
    private String mCountryAsciName;
    private String mCountryCode;
    private long mCountryId;
    private String mCountryLocalID;
    private String mDistrict;
    private String mDistrictAsciName;
    private long mDistrictId;
    private String mDistrictLocalID;
    private String mExtra;
    private String mFloor;
    private BDPoint mGCJ02;
    private List<GeoPoiEntity> mGeoAoiList;
    private String mGeoFormattedAddress;
    private String mGeoNameID;
    private List<GeoPoiEntity> mGeoPoiList;
    private String mGeocodeSDKName;
    private boolean mHasServerLatLng;
    private float mInOutDoorConfidence;
    private int mInOutDoorStatus;

    @SerializedName("inputHasLatlng")
    private boolean mInputHasLatlng;
    private InputSystemGpsInfo mInputSystemGpsInfo;
    private boolean mIsCompliance;
    private boolean mIsDisputed;
    private boolean mIsMock;
    private boolean mIsRecommendWifiResults;
    private boolean mIsServerLocateSuccess;
    private double mLatitude;
    private LocInfoRspData mLocInfoRsp;
    private String mLocalID;
    private String mLocationDetail;
    private BDLocationException mLocationException;
    private long mLocationMs;
    private LocationResult mLocationResult;
    private String mLocationSDKName;
    private int mLocationType;
    private double mLongitude;
    private long mMockDuration;
    private String mPoi;
    private List<PoiInfoEntity> mPoiEntities;
    private int mSatellites;
    private String mServerLocateMethod;
    private float mSpeed;
    private String mStreet;
    private String mStreetNum;
    private String mSubAdministrativeArea;
    private String mSubdivisionAsciName;
    private long mSubdivisionId;
    private String mSubmitLogId;
    private transient Location mThirdPartLocation;
    private String mTown;
    private String mTownAsciName;
    private long mTownId;
    private int mTrustedLevel;

    @SerializedName("validLatlng")
    private boolean mValidLatlng;
    private String mVillage;
    private String mVillageAsciName;
    private long mVillageId;

    public boolean hasAddress() {
        if (TextUtils.isEmpty(this.mAddress) == true) goto L5;
    L16:
        return true;
    L5:
        if (TextUtils.isEmpty(this.mCountry) == false) goto L16;
        if (TextUtils.isEmpty(this.mAdministrativeArea) == false) goto L16;
        if (TextUtils.isEmpty(this.mSubAdministrativeArea) == false) goto L16;
        if (TextUtils.isEmpty(this.mCity) == false) goto L16;
        if (TextUtils.isEmpty(this.mDistrict) == false) goto L16;
        return false;
    }

    public boolean hasLBSResult() {
        if (this.mBdLBSResult == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEmpty() {
        if (Double.compare(this.mLatitude, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) goto L5;
    L19:
        return false;
    L5:
        if (Double.compare(this.mLongitude, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L19;
        if (TextUtils.isEmpty(this.mAddress) == false) goto L19;
        if (TextUtils.isEmpty(this.mCountry) == false) goto L19;
        if (TextUtils.isEmpty(this.mAdministrativeArea) == false) goto L19;
        if (TextUtils.isEmpty(this.mSubAdministrativeArea) == false) goto L19;
        if (TextUtils.isEmpty(this.mCity) == false) goto L19;
        if (TextUtils.isEmpty(this.mDistrict) == false) goto L19;
        return true;
    }

    @Override // android.location.Location
    public String toString() {
        String r100 = this.mThirdPartLocation.toString();     // Catch: Exception -> L4
    L6:
        return "BDLocation{mAddress='" + this.mAddress + "', mCountry='" + this.mCountry + "', mAdministrativeArea='" + this.mAdministrativeArea + "', mSubAdministrativeArea='" + this.mSubAdministrativeArea + "', mCity='" + this.mCity + "', mDistrict='" + this.mDistrict + "', mTown='" + this.mTown + "', mVillage='" + this.mVillage + "', mCityCode='" + this.mCityCode + "', mAdCode='" + this.mAdCode + "', mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mStreet='" + this.mStreet + "', mStreetNum='" + this.mStreetNum + "', mFloor='" + this.mFloor + "', mLocationMs=" + this.mLocationMs + ", mThirdPartLocation=" + r100 + ", mLocationSDKName='" + this.mLocationSDKName + "', mPoi='" + this.mPoi + "', mGCJ02=" + this.mGCJ02 + ", mLocationType=" + this.mLocationType + ", isCache=" + this.isCache + ", mCountryCode=" + this.mCountryCode + ", mCountryLocalID='" + this.mCountryLocalID + "', mLocalID='" + this.mLocalID + "', mDistrictLocalID='" + this.mDistrictLocalID + "', mGeoNameID='" + this.mGeoNameID + "', mSubdivisionId='" + this.mSubdivisionId + "', mBdLBSResult=" + this.mBdLBSResult + ", mLocationResult=" + this.mLocationResult + ", mGeocodeSDKName='" + this.mGeocodeSDKName + "', mAoi='" + this.mAoi + "', mIsDisputed='" + this.mIsDisputed + "', mIsCompliance='" + this.mIsCompliance + "', mCoordinateSystem='" + this.mCoordinateSystem + "', mBearing='" + this.mBearing + "', mSpeed='" + this.mSpeed + "', mTrustedLevel='" + this.mTrustedLevel + "', mLocationDetail='" + this.mLocationDetail + "', mSatellites='" + this.mSatellites + "', mPoiEntities='" + this.mPoiEntities + "', mAoiEntities='" + this.mAoiEntities + "', mBuildingId='" + this.mBuildingId + "', mInOutDoorStatus='" + this.mInOutDoorStatus + "', mInOutDoorConfidence='" + this.mInOutDoorConfidence + "'}";
    L4:
        r100 = "error toString()";
        goto L6
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public String getAdCode() {
        return this.mAdCode;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getAdministrativeArea() {
        return this.mAdministrativeArea;
    }

    public String getAoi() {
        return this.mAoi;
    }

    public List<PoiInfoEntity> getAoiEntities() {
        return this.mAoiEntities;
    }

    public BdLBSResult getBdLBSResult() {
        return this.mBdLBSResult;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.mBearing;
    }

    public String getBuildingId() {
        return this.mBuildingId;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getCityAsciName() {
        return this.mCityAsciName;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public long getCityId() {
        return this.mCityId;
    }

    public WifiInfo getConnectedWifiInfo() {
        return this.mConnectedWifiInfo;
    }

    public String getCoordinateSystem() {
        return this.mCoordinateSystem;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getCountryAsciName() {
        return this.mCountryAsciName;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public long getCountryId() {
        return this.mCountryId;
    }

    public String getCountryLocalID() {
        return this.mCountryLocalID;
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public String getDistrictAsciName() {
        return this.mDistrictAsciName;
    }

    public long getDistrictId() {
        return this.mDistrictId;
    }

    public String getDistrictLocalID() {
        return this.mDistrictLocalID;
    }

    public BDLocationException getException() {
        return this.exception;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public BDPoint getGCJ02() {
        return this.mGCJ02;
    }

    public List<GeoPoiEntity> getGeoAoiList() {
        return this.mGeoAoiList;
    }

    public String getGeoFormattedAddress() {
        return this.mGeoFormattedAddress;
    }

    public String getGeoNameID() {
        return this.mGeoNameID;
    }

    public List<GeoPoiEntity> getGeoPoiList() {
        return this.mGeoPoiList;
    }

    public String getGeocodeSDKName() {
        return this.mGeocodeSDKName;
    }

    public float getInOutDoorConfidence() {
        return this.mInOutDoorConfidence;
    }

    public int getInOutDoorStatus() {
        return this.mInOutDoorStatus;
    }

    public InputSystemGpsInfo getInputSystemGpsInfo() {
        return this.mInputSystemGpsInfo;
    }

    public boolean getIsCompliance() {
        return this.mIsCompliance;
    }

    public boolean getIsDisputed() {
        return this.mIsDisputed;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.mLatitude;
    }

    public LocInfoRspData getLocInfoRsp() {
        return this.mLocInfoRsp;
    }

    public String getLocalID() {
        return this.mLocalID;
    }

    public String getLocationDetail() {
        return this.mLocationDetail;
    }

    public BDLocationException getLocationException() {
        return this.mLocationException;
    }

    public long getLocationMs() {
        return this.mLocationMs;
    }

    public LocationResult getLocationResult() {
        return this.mLocationResult;
    }

    public String getLocationSDKName() {
        return this.mLocationSDKName;
    }

    public int getLocationType() {
        return this.mLocationType;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.mLongitude;
    }

    public long getMockDuration() {
        return this.mMockDuration;
    }

    public String getPoi() {
        return this.mPoi;
    }

    public List<PoiInfoEntity> getPoiEntities() {
        return this.mPoiEntities;
    }

    public int getSatellites() {
        return this.mSatellites;
    }

    public String getServerLocateMethod() {
        return this.mServerLocateMethod;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.mSpeed;
    }

    public String getStreet() {
        return this.mStreet;
    }

    public String getStreetNum() {
        return this.mStreetNum;
    }

    public String getSubAdministrativeArea() {
        return this.mSubAdministrativeArea;
    }

    public String getSubdivisionAsciName() {
        return this.mSubdivisionAsciName;
    }

    public long getSubdivisionId() {
        return this.mSubdivisionId;
    }

    public String getSubmitLogId() {
        return this.mSubmitLogId;
    }

    public Location getThirdPartLocation() {
        return this.mThirdPartLocation;
    }

    public String getTown() {
        return this.mTown;
    }

    public String getTownAsciName() {
        return this.mTownAsciName;
    }

    public long getTownId() {
        return this.mTownId;
    }

    public int getTrustedLevel() {
        return this.mTrustedLevel;
    }

    public String getVillage() {
        return this.mVillage;
    }

    public String getVillageAsciName() {
        return this.mVillageAsciName;
    }

    public long getVillageId() {
        return this.mVillageId;
    }

    public boolean hasServerLatLng() {
        return this.mHasServerLatLng;
    }

    public boolean inputHasLatlng() {
        return this.mInputHasLatlng;
    }

    public boolean isCache() {
        return this.isCache;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.mIsMock;
    }

    public boolean isRecommendWifiResults() {
        return this.mIsRecommendWifiResults;
    }

    public boolean isServerLocateSuccess() {
        return this.mIsServerLocateSuccess;
    }

    public boolean validLatlng() {
        return this.mValidLatlng;
    }

    public BDLocation(BDLocation r100) {
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        super(r101);
        this.exception = null;
        this.mCoordinateSystem = "wgs84";
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r100 != null) goto L9;
        return;
    L9:
        superLocation(r100);
        this.mThirdPartLocation = r100.mThirdPartLocation;
        this.mAddress = r100.mAddress;
        this.mCountry = r100.mCountry;
        this.mCountryId = r100.mCountryId;
        this.mAdministrativeArea = r100.mAdministrativeArea;
        this.mSubdivisionId = r100.mSubdivisionId;
        this.mSubAdministrativeArea = r100.mSubAdministrativeArea;
        this.mCity = r100.mCity;
        this.mCityId = r100.mCityId;
        this.mDistrict = r100.mDistrict;
        this.mDistrictId = r100.mDistrictId;
        this.mTown = r100.mTown;
        this.mTownId = r100.mTownId;
        this.mVillage = r100.mVillage;
        this.mVillageId = r100.mVillageId;
        this.mCountryAsciName = r100.mCountryAsciName;
        this.mSubdivisionAsciName = r100.mSubdivisionAsciName;
        this.mCityAsciName = r100.mCityAsciName;
        this.mDistrictAsciName = r100.mDistrictAsciName;
        this.mTownAsciName = r100.mTownAsciName;
        this.mVillageAsciName = r100.mVillageAsciName;
        this.mCityCode = r100.mCityCode;
        this.mAdCode = r100.mAdCode;
        setLatitude(r100.getLatitude());
        setLongitude(r100.getLongitude());
        this.mLocationMs = r100.mLocationMs;
        this.mStreet = r100.mStreet;
        this.mStreetNum = r100.mStreetNum;
        this.mFloor = r100.mFloor;
        this.mLocationSDKName = r100.mLocationSDKName;
        this.mGCJ02 = r100.mGCJ02;
        this.mPoi = r100.mPoi;
        this.mLocationType = r100.mLocationType;
        this.isCache = r100.isCache;
        this.mCountryCode = r100.mCountryCode;
        this.mCountryLocalID = r100.mCountryLocalID;
        this.mLocalID = r100.mLocalID;
        this.mDistrictLocalID = r100.mDistrictLocalID;
        this.mGeoNameID = r100.mGeoNameID;
        this.mBdLBSResult = r100.mBdLBSResult;
        this.mLocationResult = r100.mLocationResult;
        this.mGeocodeSDKName = r100.mGeocodeSDKName;
        this.mAoi = r100.mAoi;
        this.mIsDisputed = r100.mIsDisputed;
        this.mIsCompliance = r100.mIsCompliance;
        this.mCoordinateSystem = r100.mCoordinateSystem;
        this.mLocationException = r100.mLocationException;
        this.mPoiEntities = r100.mPoiEntities;
        this.mAoiEntities = r100.mAoiEntities;
        this.mBearing = r100.mBearing;
        this.mSpeed = r100.mSpeed;
        this.mTrustedLevel = r100.mTrustedLevel;
        this.mLocationDetail = r100.mLocationDetail;
        this.mSatellites = r100.mSatellites;
        this.mBuildingId = r100.mBuildingId;
        this.mMockDuration = r100.mMockDuration;
        this.mSubmitLogId = r100.mSubmitLogId;
        this.mExtra = r100.mExtra;
        this.mIsMock = r100.mIsMock;
        this.mServerLocateMethod = r100.mServerLocateMethod;
        this.mHasServerLatLng = r100.mHasServerLatLng;
        this.mIsServerLocateSuccess = r100.mIsServerLocateSuccess;
        this.mIsRecommendWifiResults = r100.mIsRecommendWifiResults;
        this.mInputHasLatlng = r100.mInputHasLatlng;
        this.mValidLatlng = r100.mValidLatlng;
        this.mInputSystemGpsInfo = r100.mInputSystemGpsInfo;
        this.mGeoAoiList = r100.mGeoAoiList;
        this.mGeoPoiList = r100.mGeoPoiList;
        this.mGeoFormattedAddress = r100.mGeoFormattedAddress;
        this.mInOutDoorStatus = r100.mInOutDoorStatus;
        this.mInOutDoorConfidence = r100.mInOutDoorConfidence;
        this.mConnectedWifiInfo = r100.mConnectedWifiInfo;
        return;
    L5:
        r101 = r100.getProvider();
        goto L6
    }

    private void superLocation(Location r100) {
        setProvider(r100.getProvider());     // Catch: Exception -> L14
        setTime(r100.getTime());     // Catch: Exception -> L14
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L14
        setElapsedRealtimeNanos(r100.getElapsedRealtimeNanos());     // Catch: Exception -> L14
        setLatitude(r100.getLatitude());     // Catch: Exception -> L14
        setLongitude(r100.getLongitude());     // Catch: Exception -> L14
        setAltitude(r100.getAltitude());     // Catch: Exception -> L14
        setSpeed(r100.getSpeed());     // Catch: Exception -> L14
        setBearing(r100.getBearing());     // Catch: Exception -> L14
        setAccuracy(r100.getAccuracy());     // Catch: Exception -> L14
        if (r101 < 26) goto L5;
        setVerticalAccuracyMeters(r100.getVerticalAccuracyMeters());     // Catch: Exception -> L14
    L5:
        if (r101 < 26) goto L7;
        setSpeedAccuracyMetersPerSecond(r100.getSpeedAccuracyMetersPerSecond());     // Catch: Exception -> L14
    L7:
        if (r101 < 26) goto L10;
        setBearingAccuracyDegrees(r100.getBearingAccuracyDegrees());     // Catch: Exception -> L14
    L10:
        if (r101 < 29) goto L12;
        setElapsedRealtimeUncertaintyNanos(r100.getElapsedRealtimeUncertaintyNanos());     // Catch: Exception -> L14
    L12:
        setExtras(r100.getExtras());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.i(e.getMessage());
    }

    private int transProvider(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        if (GeocodeSearch.GPS.equalsIgnoreCase(r100) == false) goto L10;
        return 1;
    L10:
        if ("network".equalsIgnoreCase(r100) == false) goto L13;
        return 4;
    L13:
        if ("bd_lbs".equalsIgnoreCase(r100) == false) goto L16;
        return 4;
    L16:
        if (MapInfoConst.MAP_SHOT_DIR.equalsIgnoreCase(r100) == false) goto L18;
        return 4;
    L18:
        return 0;
    }

    public void setAccuracyLevel(int r100) {
        this.mAccuracyLevel = r100;
        transformLocationForLevel(r100);
    }

    public void setAdCode(String r100) {
        this.mAdCode = r100;
    }

    public void setAddress(String r100) {
        this.mAddress = r100;
    }

    public void setAdministrativeArea(String r100) {
        this.mAdministrativeArea = r100;
    }

    public void setAoi(String r100) {
        this.mAoi = r100;
    }

    public void setAoiEntities(List<PoiInfoEntity> r100) {
        this.mAoiEntities = r100;
    }

    public void setBdLBSResult(BdLBSResult r100) {
        this.mBdLBSResult = r100;
    }

    @Override // android.location.Location
    public void setBearing(float r100) {
        this.mBearing = r100;
    }

    public void setBuildingId(String r100) {
        this.mBuildingId = r100;
    }

    public void setCache(boolean r100) {
        this.isCache = r100;
    }

    public void setCity(String r100) {
        this.mCity = r100;
    }

    public void setCityAsciName(String r100) {
        this.mCityAsciName = r100;
    }

    public void setCityCode(String r100) {
        this.mCityCode = r100;
    }

    public void setCityId(long r100) {
        this.mCityId = r100;
    }

    public void setConnectedWifiInfo(WifiInfo r100) {
        this.mConnectedWifiInfo = r100;
    }

    public void setCoordinateSystem(String r100) {
        this.mCoordinateSystem = r100;
    }

    public void setCountry(String r100) {
        this.mCountry = r100;
    }

    public void setCountryAsciName(String r100) {
        this.mCountryAsciName = r100;
    }

    public void setCountryCode(String r100) {
        this.mCountryCode = r100;
    }

    public void setCountryId(long r100) {
        this.mCountryId = r100;
    }

    public void setCountryLocalID(String r100) {
        this.mCountryLocalID = r100;
    }

    public void setDistrict(String r100) {
        this.mDistrict = r100;
    }

    public void setDistrictAsciName(String r100) {
        this.mDistrictAsciName = r100;
    }

    public void setDistrictId(long r100) {
        this.mDistrictId = r100;
    }

    public void setDistrictLocalID(String r100) {
        this.mDistrictLocalID = r100;
    }

    public void setException(BDLocationException r100) {
        this.exception = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setFloor(String r100) {
        this.mFloor = r100;
    }

    public void setGCJ02(BDPoint r100) {
        this.mGCJ02 = r100;
    }

    public void setGeoAoiList(List<GeoPoiEntity> r100) {
        this.mGeoAoiList = r100;
    }

    public void setGeoFormattedAddress(String r100) {
        this.mGeoFormattedAddress = r100;
    }

    public void setGeoNameID(String r100) {
        this.mGeoNameID = r100;
    }

    public void setGeoPoiList(List<GeoPoiEntity> r100) {
        this.mGeoPoiList = r100;
    }

    public void setGeocodeSDKName(String r100) {
        this.mGeocodeSDKName = r100;
    }

    public void setHasServerLatLng(boolean r100) {
        this.mHasServerLatLng = r100;
    }

    public void setInOutDoorConfidence(float r100) {
        this.mInOutDoorConfidence = r100;
    }

    public void setInOutDoorStatus(int r100) {
        this.mInOutDoorStatus = r100;
    }

    public void setInputHasLatlng(boolean r100) {
        this.mInputHasLatlng = r100;
    }

    public void setInputSystemGpsInfo(InputSystemGpsInfo r100) {
        this.mInputSystemGpsInfo = r100;
    }

    public void setIsCompliance(boolean r100) {
        this.mIsCompliance = r100;
    }

    public void setIsDisputed(boolean r100) {
        this.mIsDisputed = r100;
    }

    @Override // android.location.Location
    public void setLatitude(double r100) {
        super.setLatitude(r100);
        this.mLatitude = r100;
    }

    public void setLocInfoRsp(LocInfoRspData r100) {
        this.mLocInfoRsp = r100;
    }

    public void setLocalID(String r100) {
        this.mLocalID = r100;
    }

    public void setLocationDetail(String r100) {
        this.mLocationDetail = r100;
    }

    public void setLocationException(BDLocationException r100) {
        this.mLocationException = r100;
    }

    public void setLocationMs(long r100) {
        this.mLocationMs = r100;
    }

    public void setLocationResult(LocationResult r100) {
        this.mLocationResult = r100;
    }

    public void setLocationSDKName(String r100) {
        this.mLocationSDKName = r100;
    }

    public void setLocationType(int r100) {
        this.mLocationType = r100;
    }

    @Override // android.location.Location
    public void setLongitude(double r100) {
        super.setLongitude(r100);
        this.mLongitude = r100;
    }

    @Override // android.location.Location
    public void setMock(boolean r100) {
        this.mIsMock = r100;
    }

    public void setMockDuration(long r100) {
        this.mMockDuration = r100;
    }

    public void setPoi(String r100) {
        this.mPoi = r100;
    }

    public void setPoiEntities(List<PoiInfoEntity> r100) {
        this.mPoiEntities = r100;
    }

    public void setRecommendWifiResults(boolean r100) {
        this.mIsRecommendWifiResults = r100;
    }

    public void setSatellites(int r100) {
        this.mSatellites = r100;
    }

    public void setServerLocateMethod(String r100) {
        this.mServerLocateMethod = r100;
    }

    public void setServerLocateSuccess(boolean r100) {
        this.mIsServerLocateSuccess = r100;
    }

    @Override // android.location.Location
    public void setSpeed(float r100) {
        this.mSpeed = r100;
    }

    public void setStreet(String r100) {
        this.mStreet = r100;
    }

    public void setStreetNum(String r100) {
        this.mStreetNum = r100;
    }

    public void setSubAdministrativeArea(String r100) {
        this.mSubAdministrativeArea = r100;
    }

    public void setSubdivisionAsciName(String r100) {
        this.mSubdivisionAsciName = r100;
    }

    public void setSubdivisionId(long r100) {
        this.mSubdivisionId = r100;
    }

    public void setSubmitLogId(String r100) {
        this.mSubmitLogId = r100;
    }

    public void setThirdPartLocation(Location r100) {
        this.mThirdPartLocation = r100;
    }

    public void setTown(String r100) {
        this.mTown = r100;
    }

    public void setTownAsciName(String r100) {
        this.mTownAsciName = r100;
    }

    public void setTownId(long r100) {
        this.mTownId = r100;
    }

    public void setTrustedLevel(int r100) {
        this.mTrustedLevel = r100;
    }

    public void setValidLatlng(boolean r100) {
        this.mValidLatlng = r100;
    }

    public void setVillage(String r100) {
        this.mVillage = r100;
    }

    public void setVillageAsciName(String r100) {
        this.mVillageAsciName = r100;
    }

    public void setVillageId(long r100) {
        this.mVillageId = r100;
    }

    public void transformLocationForLevel(int r100) {
        if (r100 != 4) goto L5;
        return;
    L5:
        setLatitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        setLongitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        setTown("");
        setTownId(0);
        setTownAsciName("");
        setAddress("");
        if (r100 != 0) goto L9;
        setAdministrativeArea("");
        setSubdivisionId(0);
        setSubdivisionAsciName("");
        setCity("");
        setCityId(0);
        setCityAsciName("");
        setCityCode("");
        setDistrict("");
        setDistrictId(0);
        setDistrictLocalID("");
        setDistrictAsciName("");
        return;
    L9:
        if (r100 != 1) goto L12;
        setCity("");
        setCityId(0);
        setCityAsciName("");
        setCityCode("");
        setDistrict("");
        setDistrictId(0);
        setDistrictLocalID("");
        setDistrictAsciName("");
        return;
    L12:
        if (r100 != 2) goto L17;
        setDistrict("");
        setDistrictId(0);
        setDistrictLocalID("");
        setDistrictAsciName("");
        return;
    }

    public BDLocation(Location r100, String r101) {
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        super(r102);
        this.exception = null;
        this.mCoordinateSystem = "wgs84";
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        if (r100 != null) goto L9;
        return;
    L9:
        superLocation(r100);
        this.mLatitude = r100.getLatitude();
        this.mLongitude = r100.getLongitude();
        this.mLocationMs = System.currentTimeMillis();
        this.mThirdPartLocation = r100;
        this.mLocationSDKName = r101;
        this.mLocationType = transProvider(r100.getProvider());
        this.mBearing = r100.getBearing();
        this.mSpeed = r100.getSpeed();
        return;
    L5:
        r102 = r100.getProvider();
        goto L6
    }

    public BDLocation(String r100, String r101) {
        super(r100);
        this.exception = null;
        this.mCoordinateSystem = "wgs84";
        this.mAccuracyLevel = 4;
        this.mExtra = "";
        this.mServerLocateMethod = "unknown";
        this.mIsRecommendWifiResults = true;
        this.mInOutDoorStatus = 0;
        this.mInOutDoorConfidence = -1.0f;
        this.mLocationSDKName = r101;
        this.mLocationType = transProvider(r100);
    }
}
