package com.bytedance.bdlocation.utils.json.serializer;

import android.os.Build;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class BDLocationSerializer implements JsonSerializer<BDLocation> {
    public BDLocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(BDLocation r100, Type r101, JsonSerializationContext r102) {
        JsonObject r103 = new JsonObject();
        r103.addProperty("mProvider", r100.getProvider());     // Catch: Exception -> L14
        r103.addProperty("mAccuracy", Float.valueOf(r100.getAccuracy()));     // Catch: Exception -> L14
        r103.addProperty("mAltitude", Double.valueOf(r100.getAltitude()));     // Catch: Exception -> L14
        r103.addProperty("mBearing", Float.valueOf(r100.getBearing()));     // Catch: Exception -> L14
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L14
        if (r104 < 26) goto L6;
        r103.addProperty("mBearingAccuracyDegrees", Float.valueOf(r100.getBearingAccuracyDegrees()));     // Catch: Exception -> L14
    L6:
        r103.addProperty("mElapsedRealtimeNanos", Long.valueOf(r100.getElapsedRealtimeNanos()));     // Catch: Exception -> L14
        r103.addProperty("mLatitude", Double.valueOf(r100.getLatitude()));     // Catch: Exception -> L14
        r103.addProperty("mLongitude", Double.valueOf(r100.getLongitude()));     // Catch: Exception -> L14
        r103.addProperty("mProvider", r100.getProvider());     // Catch: Exception -> L14
        r103.addProperty("mSpeed", Float.valueOf(r100.getSpeed()));     // Catch: Exception -> L14
        if (r104 < 26) goto L9;
        r103.addProperty("mSpeedAccuracyMetersPerSecond", Float.valueOf(r100.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L14
    L9:
        r103.addProperty("mTime", Long.valueOf(r100.getTime()));     // Catch: Exception -> L14
        if (r104 < 26) goto L12;
        r103.addProperty("mVerticalAccuracyMeters", Float.valueOf(r100.getVerticalAccuracyMeters()));     // Catch: Exception -> L14
    L12:
        r103.addProperty("mAddress", r100.getAddress());     // Catch: Exception -> L14
        r103.addProperty("mCountry", r100.getCountry());     // Catch: Exception -> L14
        r103.addProperty("mAdministrativeArea", r100.getAdministrativeArea());     // Catch: Exception -> L14
        r103.addProperty("mSubAdministrativeArea", r100.getSubAdministrativeArea());     // Catch: Exception -> L14
        r103.addProperty("mCity", r100.getCity());     // Catch: Exception -> L14
        r103.addProperty("mDistrict", r100.getDistrict());     // Catch: Exception -> L14
        r103.addProperty("mCityCode", r100.getCityCode());     // Catch: Exception -> L14
        r103.addProperty("mStreet", r100.getStreet());     // Catch: Exception -> L14
        r103.addProperty("mStreetNum", r100.getStreetNum());     // Catch: Exception -> L14
        r103.addProperty("mFloor", r100.getFloor());     // Catch: Exception -> L14
        r103.addProperty("mLocationMs", Long.valueOf(r100.getLocationMs()));     // Catch: Exception -> L14
        r103.addProperty("mLocationSDKName", r100.getLocationSDKName());     // Catch: Exception -> L14
        r103.addProperty("mCoordinateSystem", r100.getCoordinateSystem());     // Catch: Exception -> L14
        r103.addProperty("mPoi", r100.getPoi());     // Catch: Exception -> L14
        r103.addProperty("mLocationType", Integer.valueOf(r100.getLocationType()));     // Catch: Exception -> L14
        r103.addProperty("mCountryCode", r100.getCountryCode());     // Catch: Exception -> L14
        r103.addProperty("mCountryLocalID", r100.getCountryLocalID());     // Catch: Exception -> L14
        r103.addProperty("mLocalID", r100.getLocalID());     // Catch: Exception -> L14
        r103.addProperty("mDistrictLocalID", r100.getDistrictLocalID());     // Catch: Exception -> L14
        r103.addProperty("mGeoNameID", r100.getGeoNameID());     // Catch: Exception -> L14
        r103.addProperty("mGeocodeSDKName", r100.getGeocodeSDKName());     // Catch: Exception -> L14
        r103.addProperty("mAoi", r100.getAoi());     // Catch: Exception -> L14
        r103.addProperty("mMockDuration", Long.valueOf(r100.getMockDuration()));     // Catch: Exception -> L14
        r103.addProperty("mTown", r100.getTown());     // Catch: Exception -> L14
        r103.addProperty("mVillage", r100.getVillage());     // Catch: Exception -> L14
        r103.addProperty("mCountryId", Long.valueOf(r100.getCountryId()));     // Catch: Exception -> L14
        r103.addProperty("mSubdivisionId", Long.valueOf(r100.getSubdivisionId()));     // Catch: Exception -> L14
        r103.addProperty("mCityId", Long.valueOf(r100.getCityId()));     // Catch: Exception -> L14
        r103.addProperty("mDistrictId", Long.valueOf(r100.getDistrictId()));     // Catch: Exception -> L14
        r103.addProperty("mTownId", Long.valueOf(r100.getTownId()));     // Catch: Exception -> L14
        r103.addProperty("mVillageId", Long.valueOf(r100.getVillageId()));     // Catch: Exception -> L14
        r103.addProperty("mCountryAsciName", r100.getCountryAsciName());     // Catch: Exception -> L14
        r103.addProperty("mSubdivisionAsciName", r100.getSubdivisionAsciName());     // Catch: Exception -> L14
        r103.addProperty("mCityAsciName", r100.getCityAsciName());     // Catch: Exception -> L14
        r103.addProperty("mDistrictAsciName", r100.getDistrictAsciName());     // Catch: Exception -> L14
        r103.addProperty("mTownAsciName", r100.getTownAsciName());     // Catch: Exception -> L14
        r103.addProperty("mVillageAsciName", r100.getVillageAsciName());     // Catch: Exception -> L14
        r103.addProperty("mAdCode", r100.getAdCode());     // Catch: Exception -> L14
        r103.addProperty("mIsDisputed", Boolean.valueOf(r100.getIsDisputed()));     // Catch: Exception -> L14
        r103.addProperty("mIsCompliance", Boolean.valueOf(r100.getIsCompliance()));     // Catch: Exception -> L14
        r103.addProperty("mTrustedLevel", Integer.valueOf(r100.getTrustedLevel()));     // Catch: Exception -> L14
        r103.addProperty("mLocationDetail", r100.getLocationDetail());     // Catch: Exception -> L14
        r103.addProperty("mSatellites", Integer.valueOf(r100.getSatellites()));     // Catch: Exception -> L14
        r103.addProperty("mBuildingId", r100.getBuildingId());     // Catch: Exception -> L14
        r103.add("mBdLBSResult", JsonUtil.safeToJsonTree(r100.getBdLBSResult()));     // Catch: Exception -> L14
        r103.add("mLocationResult", JsonUtil.safeToJsonTree(r100.getLocationResult()));     // Catch: Exception -> L14
        r103.add("mGCJ02", JsonUtil.safeToJsonTree(r100.getGCJ02()));     // Catch: Exception -> L14
        r103.add("mPoiEntities", JsonUtil.safeToJsonTree(r100.getPoiEntities()));     // Catch: Exception -> L14
        r103.add("mAoiEntities", JsonUtil.safeToJsonTree(r100.getAoiEntities()));     // Catch: Exception -> L14
        r103.add("mConnectedWifiInfo", JsonUtil.safeToJsonTree(r100.getConnectedWifiInfo()));     // Catch: Exception -> L14
        r103.addProperty("mInOutDoorStatus", Integer.valueOf(r100.getInOutDoorStatus()));     // Catch: Exception -> L14
        r103.addProperty("mInputHasLatlng", Boolean.valueOf(r100.inputHasLatlng()));     // Catch: Exception -> L14
        r103.addProperty("mValidLatlng", Boolean.valueOf(r100.validLatlng()));     // Catch: Exception -> L14
        r103.add("mInputSystemGpsInfo", JsonUtil.safeToJsonTree(r100.getInputSystemGpsInfo()));     // Catch: Exception -> L14
    L16:
        return r103;
    L14:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L16
    }

    @Override // com.google.gson.JsonSerializer
    public /* bridge */ /* synthetic */ JsonElement serialize(BDLocation r100, Type r101, JsonSerializationContext r102) {
        return serialize2(r100, r101, r102);
    }
}
