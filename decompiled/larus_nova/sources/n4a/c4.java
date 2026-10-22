package n4a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f517206a = "5.3";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f517207b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f517208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f517209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f517210e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f517211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f517212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f517213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HashMap<String, String> f517214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static e5 f517215j;

    static {
        f517207b = new String[]{"5.1"};
        f517208c = "http://apilocate.amap.com/mobile/binary";
        f517209d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
        f517210e = new String[]{"com.amap.api.location", "com.loc", "com.amap.api.fence"};
        f517211f = null;
        f517212g = null;
        f517213h = null;
        f517215j = null;
    }

    public static Bundle a(AMapLocationClientOption r100) {
        Bundle r101 = new Bundle();
        if (r100 != null) goto L10;
        r100 = new AMapLocationClientOption();
    L10:
        r101.putParcelable("opt", r100);     // Catch: Throwable -> L7
    L9:
        return r101;
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getOptionBundle");
        goto L9
    }

    public static AMapLocationClientOption b(Bundle r100) {
        AMapLocationClientOption r101 = new AMapLocationClientOption();
        if (r100 != null) goto L10;
        return r101;
    L10:
        r100.setClassLoader(AMapLocationClientOption.class.getClassLoader());     // Catch: Throwable -> L7
        return (AMapLocationClientOption) r100.getParcelable("opt");
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getOptionFromBundle");
        return r101;
    }

    public static void d(AMapLocation r100, AMapLocation r101) {
        r100.setCountry(r101.getCountry());     // Catch: Throwable -> L8
        r100.setRoad(r101.getRoad());     // Catch: Throwable -> L8
        r100.setPoiName(r101.getPoiName());     // Catch: Throwable -> L8
        r100.setStreet(r101.getStreet());     // Catch: Throwable -> L8
        r100.setNumber(r101.getStreetNum());     // Catch: Throwable -> L8
        String r102 = r101.getCityCode();     // Catch: Throwable -> L8
        String r103 = r101.getAdCode();     // Catch: Throwable -> L8
        r100.setCityCode(r102);     // Catch: Throwable -> L8
        r100.setAdCode(r103);     // Catch: Throwable -> L8
        r100.setCity(r101.getCity());     // Catch: Throwable -> L8
        r100.setDistrict(r101.getDistrict());     // Catch: Throwable -> L8
        r100.setProvince(r101.getProvince());     // Catch: Throwable -> L8
        r100.setAoiName(r101.getAoiName());     // Catch: Throwable -> L8
        r100.setAddress(r101.getAddress());     // Catch: Throwable -> L8
        r100.setDescription(r101.getDescription());     // Catch: Throwable -> L8
        if (r100.getExtras() == null) goto L6;
        r100.getExtras().putString("citycode", r101.getCityCode());     // Catch: Throwable -> L8
        r100.getExtras().putString(SocialConstants.PARAM_APP_DESC, r101.getExtras().getString(SocialConstants.PARAM_APP_DESC));     // Catch: Throwable -> L8
        r100.getExtras().putString("adcode", r101.getAdCode());     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        Bundle r104 = new Bundle();     // Catch: Throwable -> L8
        r104.putString("citycode", r101.getCityCode());     // Catch: Throwable -> L8
        r104.putString(SocialConstants.PARAM_APP_DESC, r101.getExtras().getString(SocialConstants.PARAM_APP_DESC));     // Catch: Throwable -> L8
        r104.putString("adcode", r101.getAdCode());     // Catch: Throwable -> L8
        r100.setExtras(r104);     // Catch: Throwable -> L8
    }

    public static void e(AMapLocation r110, JSONObject r111) {
        double r100 = r111.optDouble("lat", r110.getLatitude());     // Catch: Throwable -> L25
        double r101 = r111.optDouble("lon", r110.getLongitude());     // Catch: Throwable -> L25
        r110.setProvider(r111.optString(ShortVideoSegments.KEY_PROP_PROVIDER, r110.getProvider()));     // Catch: Throwable -> L25
        r110.setLatitude(r100);     // Catch: Throwable -> L25
        r110.setLongitude(r101);     // Catch: Throwable -> L25
        r110.setAltitude(r111.optDouble("altitude", r110.getAltitude()));     // Catch: Throwable -> L25
        String r102 = r111.optString(LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r102) == true) goto L31;
        r110.setAccuracy(CastFloatProtector.parseFloat(r102));     // Catch: Throwable -> L28
    L31:
        String r103 = r111.optString("speed");     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r103) == true) goto L33;
        r110.setSpeed(CastFloatProtector.parseFloat(r103));     // Catch: Throwable -> L29
    L33:
        String r104 = r111.optString("bearing");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r104) == true) goto L13;
        r110.setBearing(CastFloatProtector.parseFloat(r104));     // Catch: Throwable -> L30
    L13:
        r110.setAdCode(r111.optString("adcode", r110.getAdCode()));     // Catch: Throwable -> L25
        r110.setCityCode(r111.optString("citycode", r110.getCityCode()));     // Catch: Throwable -> L25
        r110.setAddress(r111.optString("address", r110.getAddress()));     // Catch: Throwable -> L25
        String r105 = r111.optString(SocialConstants.PARAM_APP_DESC, "");     // Catch: Throwable -> L25
        r110.setCountry(r111.optString(DistrictSearchQuery.KEYWORDS_COUNTRY, r110.getCountry()));     // Catch: Throwable -> L25
        r110.setProvince(r111.optString("province", r110.getProvince()));     // Catch: Throwable -> L25
        r110.setCity(r111.optString("city", r110.getCity()));     // Catch: Throwable -> L25
        r110.setDistrict(r111.optString(DistrictSearchQuery.KEYWORDS_DISTRICT, r110.getDistrict()));     // Catch: Throwable -> L25
        r110.setRoad(r111.optString("road", r110.getRoad()));     // Catch: Throwable -> L25
        r110.setStreet(r111.optString("street", r110.getStreet()));     // Catch: Throwable -> L25
        r110.setNumber(r111.optString("number", r110.getStreetNum()));     // Catch: Throwable -> L25
        r110.setPoiName(r111.optString(MapBundleKey.MapObjKey.OBJ_SS_POINAME, r110.getPoiName()));     // Catch: Throwable -> L25
        r110.setAoiName(r111.optString("aoiname", r110.getAoiName()));     // Catch: Throwable -> L25
        r110.setErrorCode(r111.optInt("errorCode", r110.getErrorCode()));     // Catch: Throwable -> L25
        r110.setErrorInfo(r111.optString("errorInfo", r110.getErrorInfo()));     // Catch: Throwable -> L25
        r110.setLocationType(r111.optInt("locationType", r110.getLocationType()));     // Catch: Throwable -> L25
        r110.setLocationDetail(r111.optString("locationDetail", r110.getLocationDetail()));     // Catch: Throwable -> L25
        r110.setTime(r111.optLong("time", r110.getTime()));     // Catch: Throwable -> L25
        boolean r106 = r111.optBoolean("isOffset", r110.isOffset());     // Catch: Throwable -> L25
        r110.setOffset(r106);     // Catch: Throwable -> L25
        r110.setBuildingId(r111.optString("poiid", r110.getBuildingId()));     // Catch: Throwable -> L25
        r110.setFloor(r111.optString("floor", r110.getFloor()));     // Catch: Throwable -> L25
        r110.setDescription(r111.optString("description", r110.getDescription()));     // Catch: Throwable -> L25
        if (r111.has("coordType") == false) goto L18;
        String r112 = r111.optString("coordType", AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L25
    L22:
        r110.setCoordType(r112);     // Catch: Throwable -> L25
    L23:
        Bundle r113 = new Bundle();     // Catch: Throwable -> L25
        r113.putString("citycode", r110.getCityCode());     // Catch: Throwable -> L25
        r113.putString(SocialConstants.PARAM_APP_DESC, r105.toString());     // Catch: Throwable -> L25
        r113.putString("adcode", r110.getAdCode());     // Catch: Throwable -> L25
        r110.setExtras(r113);     // Catch: Throwable -> L25
        return;
    L18:
        if (h(r100, r101) == false) goto L21;
        if (r106 == false) goto L21;
        r110.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L25
    L21:
        r112 = AMapLocation.COORD_TYPE_WGS84;
    L25:
        th = move-exception;
        g(th, "CoreUtil", "transformLocation");
    }

    public static void g(Throwable r100, String r101, String r102) {
        if ("reportError".equals(r102) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof com.loc.l) == false) goto L11;
        return;
    L11:
        r.f(r100, r101, r102);     // Catch: Throwable -> L10
        return;
    }

    public static boolean h(double r100, double r101) {
        int r102 = (int) ((r101 - 73.0d) / 0.5d);
        int r103 = (int) ((r100 - 3.5d) / 0.5d);
        if (r103 >= 0) goto L5;
    L19:
        return false;
    L5:
        if (r103 >= 101) goto L19;
        if (r102 < 0) goto L19;
        if (r102 >= 124) goto L19;
        if ("00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((r103 * 124) + r102) != '1') goto L15;
        return true;
    L15:
        return false;
    L16:
        th = move-exception;
        g(th, "CoreUtil", "isChina");
        return true;
    }

    public static boolean i(double r100, double r101, double r110, double r111, double r112, double r113) {
        if (Math.abs(((r110 - r100) * (r113 - r101)) - ((r112 - r100) * (r111 - r101))) < 1.0E-9d) goto L5;
    L9:
        return false;
    L5:
        if (((r100 - r110) * (r100 - r112)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        if (((r101 - r111) * (r101 - r113)) > AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(DPoint r310, List<DPoint> r311) {
        double r110 = r310.getLongitude();
        double r111 = r310.getLatitude();
        double r112 = r310.getLatitude();
        if (((DPoint) ListProtector.get(r311, 0)).equals(ListProtector.get(r311, r311.size() - 1)) == true) goto L5;
        r311.add(ListProtector.get(r311, 0));
    L5:
        int r100 = 0;
        int r113 = 0;
    L7:
        if (r100 >= (r311.size() - 1)) goto L39;
        double r210 = ((DPoint) ListProtector.get(r311, r100)).getLongitude();
        double r211 = ((DPoint) ListProtector.get(r311, r100)).getLatitude();
        int r114 = r100 + 1;
        double r212 = ((DPoint) ListProtector.get(r311, r114)).getLongitude();
        double r213 = ((DPoint) ListProtector.get(r311, r114)).getLatitude();
        if (i(r110, r111, r210, r211, r212, r213) == true) goto L10;
        double r312 = r213 - r211;
        if (Math.abs(r312) < 1.0E-9d) goto L37;
        if (i(r210, r211, r110, r111, 180.0d, r112) == false) goto L19;
        if (r211 <= r213) goto L37;
    L36:
        r113 = r113 + 1;
        goto L37
    L19:
        if (i(r212, r213, r110, r111, 180.0d, r112) == true) goto L21;
        double r214 = r212 - r210;
        double r101 = r112 - r111;
        double r102 = 180.0d - r110;
        double r103 = (r214 * r101) - (r312 * r102);
        if (r103 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L34;
        double r215 = r211 - r111;
        double r216 = r210 - r110;
        double r104 = ((r102 * r215) - (r101 * r216)) / r103;
        double r217 = ((r215 * r214) - (r216 * r312)) / r103;
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L34;
        if (r104 > 1.0d) goto L34;
        if (r217 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L34;
        if (r217 > 1.0d) goto L34;
        boolean r115 = true;
    L35:
        if (r115 == false) goto L37;
    L34:
        r115 = false;
        goto L35
    L21:
        if (r213 > r211) goto L36;
    L37:
        r100 = r114;
        goto L7
    L10:
        return true;
    L39:
        if ((r113 % 2) == 0) goto L41;
        return true;
    L41:
        return false;
    }

    public static void l() {
    L7:
        th = move-exception;
        g(th, "CoreUtil", "initUrlHash");
        return;
    L3:
        if (f517214i != null) goto L5;
        f517214i = new HashMap(16);     // Catch: Throwable -> L7
    L5:
        f517214i.clear();     // Catch: Throwable -> L7
        f517214i.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");     // Catch: Throwable -> L7
        f517214i.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");     // Catch: Throwable -> L7
        f517214i.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");     // Catch: Throwable -> L7
    }

    public static e5 k() {
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getSDKInfo");
    L10:
        return f517215j;
    L4:
        if (f517215j != null) goto L10;
        e5.a r100 = new e5.a("loc", "6.4.8", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L7
        r100.f517273e = (String[]) ((String[]) f517210e.clone()).clone();     // Catch: Throwable -> L7
        r100.f517270b = "6.4.8";     // Catch: Throwable -> L7
        f517215j = r100.a();     // Catch: Throwable -> L7
        goto L10
    }

    public static void c(Context r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            boolean r0 = n4a.f5.m(r3)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto Lb
            java.lang.String r3 = "http://abroad.apilocate.amap.com/mobile/binary"
            n4a.c4.f517208c = r3     // Catch: java.lang.Throwable -> L46
            return
        Lb:
            l()     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = n4a.v4.g(r3)     // Catch: java.lang.Throwable -> L46
            char[] r0 = n4a.t3.f517754a     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L41
            int r0 = r3.length()     // Catch: java.lang.Throwable -> L39
            if (r0 != 0) goto L1d
            goto L41
        L1d:
            java.lang.String r0 = "SHA1"
            java.lang.String r0 = n4a.t3.a(r0, r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "MD5"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r2.<init>()     // Catch: java.lang.Throwable -> L39
            r2.append(r0)     // Catch: java.lang.Throwable -> L39
            r2.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = n4a.t3.a(r1, r3)     // Catch: java.lang.Throwable -> L39
            goto L42
        L39:
            r3 = move-exception
            java.lang.String r0 = "Encrypt"
            java.lang.String r1 = "generatorKey"
            g(r3, r0, r1)     // Catch: java.lang.Throwable -> L46
        L41:
            r3 = 0
        L42:
            f(r3)     // Catch: java.lang.Throwable -> L46
            return
        L46:
            r3 = move-exception
            java.lang.String r0 = "CoreUtil"
            java.lang.String r1 = "checkUrl"
            g(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n4a.c4.c(android.content.Context):void");
    }

    public static void f(String r100) {
        if (r100 == null) goto L41;
    L32:
        th = move-exception;
        g(th, "CoreUtil", "checkUrl");
        return;
    L4:
        if (r100.length() == 0) goto L42;
        HashMap<String, String> r101 = f517214i;     // Catch: Throwable -> L32
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.containsKey(r100) == true) goto L12;
        return;
    L12:
        String r102 = f517214i.get(r100);     // Catch: Throwable -> L32
        if (r102 != null) goto L15;
    L24:
        String r103 = null;
    L25:
        if (r103 != null) goto L27;
        return;
    L27:
        if (r103.length() > 0) goto L29;
        return;
    L29:
        if (r103.contains(GXImageView.NET_HTTP_PREFIX) == false) goto L40;
        f517208c = r103;     // Catch: Throwable -> L32
        return;
    L40:
        return;
    L15:
        if (r102.length() <= 0) goto L24;
        int r104 = 0;
        if (r102.length() >= 2) goto L19;
        byte[] r105 = new byte[0];     // Catch: Throwable -> L32
    L23:
        r103 = new String(t3.e(r105, r100), XML.CHARSET_UTF8);     // Catch: Throwable -> L32
        goto L25
    L19:
        String r106 = r102.toLowerCase(Locale.US);     // Catch: Throwable -> L32
        int r107 = r106.length() / 2;     // Catch: Throwable -> L32
        byte[] r108 = new byte[r107];     // Catch: Throwable -> L32
    L20:
        if (r104 >= r107) goto L22;
        int r109 = r104 * 2;     // Catch: Throwable -> L32
        r108[r104] = (byte) (CastIntegerProtector.parseInt(r106.substring(r109, r109 + 2), 16) & 255);     // Catch: Throwable -> L32
        r104 = r104 + 1;     // Catch: Throwable -> L32
        goto L20
    L22:
        r105 = r108;
        goto L23
    L42:
        return;
    }
}
