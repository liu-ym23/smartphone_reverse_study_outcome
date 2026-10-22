package com.ss.android.lark.location.dto;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public class POIInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f431187a;
    private AddressComponent addressComponent;
    private final LarkLocation.CoordinateSystem coordinateSystem;
    private int errorCode;
    private String errorMsg;
    private boolean isInternal;
    private boolean isSelfDefine;
    private double latitude;
    private String locationAddress;
    private LocationImageData locationImageData;
    private String locationName;
    private double longitude;
    private int mZoomLevel;
    private String placeId;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    private String f431188vendor;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Vendor {
        public static final String BAIDU = "baidu";
        public static final String GAODE = "gaode";
        public static final String GOOGLE = "google";
        public static final String TENCENT = "tencent";
    }

    public Object clone() {
        POIInfo r100 = (POIInfo) super.clone();     // Catch: CloneNotSupportedException -> L10
        LocationImageData r101 = this.locationImageData;     // Catch: CloneNotSupportedException -> L8
        if (r101 == null) goto L13;
        r100.setLocationImageData((LocationImageData) r101.clone());     // Catch: CloneNotSupportedException -> L8
    L13:
        return r100;
    L8:
        CloneNotSupportedException e100 = e;
    L12:
        Log.e("POIInfo", "failed to clone POIInfo.", e100);
    L10:
        e = move-exception;
        r100 = null;
        e100 = e;
        goto L12
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.locationName, this.locationAddress});
    }

    public boolean isPlaceIdEmpty() {
        return TextUtils.isEmpty(this.placeId);
    }

    public POIInfo() {
        this(360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT);
    }

    public AddressComponent getAddressComponent() {
        return this.addressComponent;
    }

    public LarkLocation.CoordinateSystem getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean getIsCurrent() {
        return this.f431187a;
    }

    public boolean getIsSelfDefine() {
        return this.isSelfDefine;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationAddress() {
        return this.locationAddress;
    }

    public LocationImageData getLocationImageData() {
        return this.locationImageData;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public String getVendor() {
        return this.f431188vendor;
    }

    public int getZoomLevel() {
        return this.mZoomLevel;
    }

    public boolean isInternal() {
        return this.isInternal;
    }

    public POIInfo(JSONObject r100) {
        this.errorCode = 0;
        this.errorMsg = "";
        this.locationName = r100.optString("locationName");
        this.locationAddress = r100.optString("locationAddress");
        this.latitude = r100.optDouble("latitude", 360.0d);
        this.longitude = r100.optDouble("longitude", 360.0d);
        this.coordinateSystem = LarkLocation.CoordinateSystem.DEFAULT;
        this.isSelfDefine = r100.optBoolean("isSelfDefine", false);
        this.placeId = r100.optString("placeId");
        this.f431187a = false;
    }

    public static POIInfo parse(JSONObject r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new POIInfo(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof POIInfo) == false) goto L19;
        POIInfo r101 = (POIInfo) r100;
        String r102 = r101.locationName;
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r104 = r101.locationAddress;
        if (r104 == null) goto L12;
        r103 = r104;
    L12:
        if (r102.equals(this.locationName) == true) goto L14;
    L16:
        return false;
    L14:
        if (r103.equals(this.locationAddress) == false) goto L16;
        return true;
    L19:
        return super.equals(r100);
    }

    public void setAddressComponent(AddressComponent r100) {
        this.addressComponent = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public void setInternal(boolean r100) {
        this.isInternal = r100;
    }

    public void setIsCurrent(boolean r100) {
        this.f431187a = r100;
    }

    public void setIsSelfDefine(boolean r100) {
        this.isSelfDefine = r100;
    }

    public void setLatitude(double r100) {
        this.latitude = r100;
    }

    public void setLocationAddress(String r100) {
        this.locationAddress = r100;
    }

    public void setLocationImageData(LocationImageData r100) {
        this.locationImageData = r100;
    }

    public void setLocationName(String r100) {
        this.locationName = r100;
    }

    public void setLongitude(double r100) {
        this.longitude = r100;
    }

    public void setVendor(String r100) {
        this.f431188vendor = r100;
    }

    public void setZoomLevel(int r100) {
        this.mZoomLevel = r100;
    }

    public POIInfo(double r100, double r101, LarkLocation.CoordinateSystem r102) {
        this.errorCode = 0;
        this.errorMsg = "";
        this.latitude = r100;
        this.longitude = r101;
        this.coordinateSystem = r102;
    }

    public POIInfo(String r100, String r101, double r102, double r110, LarkLocation.CoordinateSystem r111) {
        this(r102, r110, r111);
        this.locationName = r100;
        this.locationAddress = r101;
    }

    public POIInfo(String r100, String r110, String r111, double r112, double r113, LarkLocation.CoordinateSystem r114) {
        this(r110, r111, r112, r113, r114);
        this.placeId = r100;
    }

    public POIInfo(String r100, String r101, double r102, double r103, LarkLocation.CoordinateSystem r104, boolean r105, boolean r106) {
        this(r100, r101, r102, r103, r104);
        this.f431187a = r105;
        this.isSelfDefine = r106;
    }

    public POIInfo(String r110, String r111, String r112, double r113, double r114, LarkLocation.CoordinateSystem r115, boolean r116, boolean r210) {
        this(r111, r112, r113, r114, r115, r116, r210);
        this.placeId = r110;
    }
}
