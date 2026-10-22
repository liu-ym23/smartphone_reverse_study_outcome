package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;
import java.util.regex.Pattern;
import tt5.a;
import yu5.c;

/* JADX INFO: loaded from: classes15.dex */
@JSONType(ignores = {"longitude", "latitude"})
public class PoiInfo implements NonProguard {
    private static final double DEFAULT_LATITUDE = 39.908823d;
    private static final double DEFAULT_LONGITUDE = 116.39747d;
    private static final String TAG = "Bitable_PoiInfo";
    private String address;
    private String adname;
    private String cityname;
    private String fullAddress;
    private double latitude;
    private String location;
    private double longitude;
    private String name;
    private String pname;

    public void parseLocation() {
        String r100 = this.location;
        if (r100 != null) goto L5;
        return;
    L5:
        Pattern r101 = c.f569228a;
        String[] r102 = r100.split(",");
        if (r102.length != 2) goto L12;
        String r103 = r102[0];
        String r104 = r102[1];
        this.longitude = CastDoubleProtector.parseDouble(r103);     // Catch: Exception -> L10
        this.latitude = CastDoubleProtector.parseDouble(r104);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        this.longitude = DEFAULT_LONGITUDE;
        this.latitude = DEFAULT_LATITUDE;
        a.e(TAG, "parseLocation", e, false);
        return;
    L12:
        this.longitude = DEFAULT_LONGITUDE;
        this.latitude = DEFAULT_LATITUDE;
        a.h(TAG, "location is illegal");
    }

    public String toString() {
        return "PoiInfo{location='" + this.location + ", name=" + this.name + ", address=" + this.address + ", fullAddress=" + this.fullAddress + ", longitude=" + this.longitude + ", latitude=" + this.latitude + '}';
    }

    public PoiInfo() {
    }

    public String getAddress() {
        return this.address;
    }

    public String getAdname() {
        return this.adname;
    }

    public String getCityname() {
        return this.cityname;
    }

    public String getFullAddress() {
        return this.fullAddress;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocation() {
        return this.location;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getPname() {
        return this.pname;
    }

    private static void buildFullAddress(PoiInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        StringBuilder r101 = new StringBuilder();
        if (TextUtils.isEmpty(r100.name) == false) goto L7;
    L11:
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r100.pname) == true) goto L19;
        String r103 = r100.pname;
        if (TextUtils.isEmpty(r100.address) == true) goto L16;
        String r104 = r100.address;
    L17:
        addBitInNeed(r102, r103, r104);
        goto L19
    L16:
        r104 = r100.name;
    L19:
        if (TextUtils.isEmpty(r100.cityname) == true) goto L28;
        if (r100.cityname.equals(r100.pname) == true) goto L28;
        String r105 = r100.cityname;
        if (TextUtils.isEmpty(r100.address) == true) goto L25;
        String r106 = r100.address;
    L26:
        addBitInNeed(r102, r105, r106);
        goto L28
    L25:
        r106 = r100.name;
    L28:
        if (TextUtils.isEmpty(r100.adname) == true) goto L35;
        String r107 = r100.adname;
        if (TextUtils.isEmpty(r100.address) == true) goto L32;
        String r108 = r100.address;
    L33:
        addBitInNeed(r102, r107, r108);
        goto L35
    L32:
        r108 = r100.name;
    L35:
        if (TextUtils.isEmpty(r100.address) == true) goto L38;
        r102.append(r100.address);
    L38:
        if (r101.length() == 0) goto L43;
        if (r102.length() == 0) goto L43;
        r100.fullAddress = r101 + "，" + r102;
        return;
    L43:
        if (r101.length() == 0) goto L46;
        r100.fullAddress = r101.toString();
        return;
    L46:
        if (r102.length() == 0) goto L51;
        r100.fullAddress = r102.toString();
        return;
    L51:
        return;
    L7:
        if (r100.name.equals(r100.adname) == true) goto L11;
        if (r100.name.equals(r100.address) == true) goto L11;
        r101.append(r100.name);
        goto L11
    }

    public void setAddress(String r100) {
        this.address = r100;
    }

    public void setAdname(String r100) {
        this.adname = r100;
    }

    public void setCityname(String r100) {
        this.cityname = r100;
    }

    public void setFullAddress(String r100) {
        this.fullAddress = r100;
    }

    public void setLocation(String r100) {
        this.location = r100;
        parseLocation();
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPname(String r100) {
        this.pname = r100;
    }

    private static String buildAddress(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "";
    L5:
        r102.append(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r101 = "";
    L8:
        r102.append(r101);
        return r102.toString();
    }

    public static PoiInfo parseByAddress(LarkLocation r100, POIInfo r101) {
        if (AppInfoUtils.f().booleanValue() == false) goto L7;
        return parseByAddressForOffice(r100, r101);
    L7:
        if (r100 != null) goto L10;
        a.h(TAG, "parseByAddress larkLocation isNull");
        return null;
    L10:
        if (r101 != null) goto L12;
        a.h(TAG, "parseByAddress poiInfo isNull");
    L13:
        if (r101 != null) goto L15;
    L17:
        boolean r102 = false;
    L18:
        PoiInfo r103 = new PoiInfo();
        String r104 = r100.f431176b;
        if (TextUtils.isEmpty(r104) == false) goto L22;
        if (r102 == false) goto L22;
        r104 = r101.getAddressComponent().getProvince();
    L22:
        r103.pname = r104;
        String r105 = r100.f431177c;
        if (TextUtils.isEmpty(r105) == false) goto L26;
        if (r102 == false) goto L26;
        r105 = r101.getAddressComponent().getCity();
    L26:
        r103.cityname = r105;
        String r106 = r100.f431178d;
        if (TextUtils.isEmpty(r106) == false) goto L30;
        if (r102 == false) goto L30;
        r106 = r101.getAddressComponent().getDistrict();
    L30:
        r103.adname = r106;
        String r107 = buildAddress(r100.f431179e, r100.f431180f);
        if (TextUtils.isEmpty(r107) == false) goto L34;
        if (r102 == false) goto L34;
        AddressComponent r108 = r101.getAddressComponent();
        r107 = buildAddress(r108.getNeighborhood(), r108.getTownship(), r108.getBuilding());
    L34:
        r103.address = r107;
        String r109 = r100.f431175a;
        if (TextUtils.isEmpty(r109) == false) goto L42;
        if (r101 == null) goto L42;
        if (TextUtils.isEmpty(r101.getLocationName()) == false) goto L40;
        String r110 = r101.getLocationAddress();
    L41:
        r109 = r110;
        goto L42
    L40:
        r110 = r101.getLocationName();
    L42:
        r103.name = splitName(r109, r103);
        r103.longitude = r100.getLongitude();
        r103.latitude = r100.getLatitude();
        r103.location = r103.longitude + "," + r103.latitude;
        buildFullAddress(r103);
        return r103;
    L15:
        if (r101.getAddressComponent() == null) goto L17;
        r102 = true;
        goto L18
    L12:
        a.h(TAG, "parseByAddress poiInfo errCode=" + r101.getErrorCode() + " errMsg=" + r101.getErrorMsg());
        goto L13
    }

    public static PoiInfo parseByAddressForOffice(LarkLocation r100, POIInfo r101) {
        PoiInfo r102 = new PoiInfo();
        if (r101 != null) goto L5;
    L7:
        if (r100 == null) goto L9;
        r102.longitude = r100.getLongitude();
        r102.latitude = r100.getLatitude();
        r102.location = r102.longitude + "," + r102.latitude;
    L9:
        buildFullAddress(r102);
        return r102;
    L5:
        if (r101.getAddressComponent() == null) goto L7;
        r102.pname = r101.getAddressComponent().getProvince();
        r102.cityname = r101.getAddressComponent().getCity();
        r102.adname = r101.getAddressComponent().getDistrict();
        String r103 = splitName(r101.getAddressComponent().getAddress(), r102);
        r102.address = r103;
        r102.name = r103.replaceFirst(r101.getAddressComponent().getTownship(), "");
        goto L7
    }

    private static String splitName(String r100, PoiInfo r101) {
        if (r101 == null) goto L19;
        if (r100 == null) goto L19;
        if (TextUtils.isEmpty(r101.pname) == true) goto L10;
        r100 = r100.replaceFirst(r101.pname, "");
    L10:
        if (TextUtils.isEmpty(r101.cityname) == true) goto L13;
        r100 = r100.replaceFirst(r101.cityname, "");
    L13:
        if (TextUtils.isEmpty(r101.adname) == true) goto L16;
        r100 = r100.replaceFirst(r101.adname, "");
    L16:
        if (TextUtils.isEmpty(r101.address) == false) goto L18;
        return r100;
    L18:
        return r100.replaceFirst(r101.address, "");
    L19:
        return "";
    }

    public static PoiInfo parseByAddress(POIInfo r100, POIInfo r101) {
        PoiInfo r102 = new PoiInfo();
        if (r101 != null) goto L5;
    L7:
        if (r100 == null) goto L12;
        r102.longitude = r100.getLongitude();
        r102.latitude = r100.getLatitude();
        r102.location = r102.longitude + "," + r102.latitude;
        if (r100.getLocationAddress() != null) goto L11;
        r102.name = splitName(r100.getLocationName(), r102);
        goto L12
    L11:
        r102.address = r100.getLocationAddress();
        r102.name = r100.getLocationName();
    L12:
        buildFullAddress(r102);
        return r102;
    L5:
        if (r101.getAddressComponent() == null) goto L7;
        r102.pname = r101.getAddressComponent().getProvince();
        r102.cityname = r101.getAddressComponent().getCity();
        r102.adname = r101.getAddressComponent().getDistrict();
        r102.address = r101.getAddressComponent().getTownship();
        goto L7
    }

    private static void addBitInNeed(StringBuilder r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r100.append(r101);
        return;
    L6:
        if (r102.contains(r101) == true) goto L10;
        r100.append(r101);
        return;
    }

    private static String buildAddress(String r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "";
    L5:
        r103.append(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r101 = "";
    L8:
        r103.append(r101);
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = "";
    L11:
        r103.append(r102);
        return r103.toString();
    }

    public PoiInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.location = r100;
        this.pname = r101;
        this.cityname = r102;
        this.adname = r103;
        this.address = r104;
        this.name = r105;
        this.fullAddress = r106;
        parseLocation();
    }
}
