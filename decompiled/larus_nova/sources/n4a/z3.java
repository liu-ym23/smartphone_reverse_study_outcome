package n4a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.em;
import com.loc.es;
import com.tencent.open.SocialConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f517977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AMapLocationClientOption f517978b;

    public z3() {
        this.f517977a = new StringBuilder();
        this.f517978b = new AMapLocationClientOption();
    }

    public static String d(String r100) {
        if ("[]".equals(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    public final es a(String r110) {
        es r111 = new es();     // Catch: Throwable -> L30
        JSONObject r112 = new JSONObject(r110).optJSONObject("regeocode");     // Catch: Throwable -> L30
        JSONObject r100 = r112.optJSONObject("addressComponent");     // Catch: Throwable -> L30
        r111.setCountry(d(r100.optString(DistrictSearchQuery.KEYWORDS_COUNTRY)));     // Catch: Throwable -> L30
        String r101 = d(r100.optString("province"));     // Catch: Throwable -> L30
        r111.setProvince(r101);     // Catch: Throwable -> L30
        String r102 = d(r100.optString("citycode"));     // Catch: Throwable -> L30
        r111.setCityCode(r102);     // Catch: Throwable -> L30
        String r103 = r100.optString("city");     // Catch: Throwable -> L30
        if (r102.endsWith("010") == false) goto L6;
    L13:
        if (r101 != null) goto L15;
    L18:
        if (TextUtils.isEmpty(r103) == false) goto L20;
        r111.setCity(r101);     // Catch: Throwable -> L30
        r103 = r101;
    L20:
        String r104 = d(r100.optString(DistrictSearchQuery.KEYWORDS_DISTRICT));     // Catch: Throwable -> L30
        r111.setDistrict(r104);     // Catch: Throwable -> L30
        String r105 = d(r100.optString("adcode"));     // Catch: Throwable -> L30
        r111.setAdCode(r105);     // Catch: Throwable -> L30
        JSONObject r106 = r100.optJSONObject("streetNumber");     // Catch: Throwable -> L30
        String r107 = d(r106.optString("street"));     // Catch: Throwable -> L30
        r111.setStreet(r107);     // Catch: Throwable -> L30
        r111.setRoad(r107);     // Catch: Throwable -> L30
        String r108 = d(r106.optString("number"));     // Catch: Throwable -> L30
        r111.setNumber(r108);     // Catch: Throwable -> L30
        JSONArray r109 = r112.optJSONArray("pois");     // Catch: Throwable -> L30
        if (r109.length() <= 0) goto L24;
        String r113 = d(JSONArrayProtectorUtils.getJSONObject(r109, 0).optString("name"));     // Catch: Throwable -> L30
        r111.setPoiName(r113);     // Catch: Throwable -> L30
        String r114 = r113;
    L25:
        JSONArray r115 = r112.optJSONArray("aois");     // Catch: Throwable -> L30
        if (r115.length() <= 0) goto L28;
        r111.setAoiName(d(JSONArrayProtectorUtils.getJSONObject(r115, 0).optString("name")));     // Catch: Throwable -> L30
    L28:
        c(r111, r101, r103, r104, r107, r108, r114, r105);     // Catch: Throwable -> L30
        return r111;
    L24:
        r114 = null;
        goto L25
    L15:
        if (r101.length() <= 0) goto L18;
        r111.setCity(r101);     // Catch: Throwable -> L30
        r103 = r101;
        goto L18
    L6:
        if (r102.endsWith("021") == true) goto L13;
        if (r102.endsWith("022") == true) goto L13;
        if (r102.endsWith("023") == true) goto L13;
        r103 = d(r103);     // Catch: Throwable -> L30
        r111.setCity(r103);     // Catch: Throwable -> L30
    L30:
        return null;
    }

    public final es b(String r210, Context r211, l0 r212, em r213) {
        es r100 = new es();
        r100.setErrorCode(7);
        StringBuffer r101 = new StringBuffer();
        r101.append("#SHA1AndPackage#");     // Catch: Throwable -> L27
        r101.append(v4.f(r211));     // Catch: Throwable -> L27
        String r110 = (String) ListProtector.get(r212.f517454b.get("gsid"), 0);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r110) == true) goto L6;
        r101.append("#gsid#");     // Catch: Throwable -> L27
        r101.append(r110);     // Catch: Throwable -> L27
    L6:
        String r111 = r212.f517455c;     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r111) == true) goto L32;
        r101.append("#csid#".concat(String.valueOf(r111)));     // Catch: Throwable -> L27
    L32:
        JSONObject r112 = new JSONObject(r210);     // Catch: Throwable -> L21
        if (r112.has("status") == true) goto L13;
    L14:
        r213.f380047h = "#0702";     // Catch: Throwable -> L21
        StringBuilder r113 = this.f517977a;     // Catch: Throwable -> L21
        r113.append("json is error:");     // Catch: Throwable -> L21
        r113.append(r210);     // Catch: Throwable -> L21
        r113.append(r101);     // Catch: Throwable -> L21
        r113.append("#0702");     // Catch: Throwable -> L21
    L15:
        String r102 = JSONObjectProtectorUtils.getString(r112, "status");     // Catch: Throwable -> L21
        String r114 = JSONObjectProtectorUtils.getString(r112, "info");     // Catch: Throwable -> L21
        String r115 = JSONObjectProtectorUtils.getString(r112, "infocode");     // Catch: Throwable -> L21
        if ("0".equals(r102) == false) goto L23;
        r213.f380047h = "#0701";     // Catch: Throwable -> L21
        StringBuilder r103 = this.f517977a;     // Catch: Throwable -> L21
        r103.append("auth fail:");     // Catch: Throwable -> L21
        r103.append(r114);     // Catch: Throwable -> L21
        r103.append(r101);     // Catch: Throwable -> L21
        r103.append("#0701");     // Catch: Throwable -> L21
        String r104 = r212.f517456d;     // Catch: Throwable -> L21
        List<r0> r105 = h4.f517352g;     // Catch: Throwable -> L21
        r.d(c4.k(), "/mobile/binary", r114, r104, "", r115);     // Catch: Throwable -> L20
    L23:
        r100.setLocationDetail(this.f517977a.toString());
        if (this.f517977a.length() <= 0) goto L26;
        StringBuilder r106 = this.f517977a;
        r106.delete(0, r106.length());
    L26:
        return r100;
    L13:
        if (r112.has("info") == true) goto L15;
    L21:
        th = move-exception;
        r213.f380047h = "#0703";
        StringBuilder r107 = this.f517977a;
        r107.append("json exception error:");
        r107.append(th.getMessage());
        r107.append(r101);
        r107.append("#0703");
        c4.g(th, "parser", "paseAuthFailurJson");
        goto L23
    }

    public final void c(es r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112) {
        StringBuilder r105 = new StringBuilder();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r105.append(r101);
        r105.append(" ");
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        if (this.f517978b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) goto L13;
        if (r102.equals(r101) == true) goto L18;
    L16:
        r105.append(r102);
        r105.append(" ");
        goto L18
    L13:
        if (r101.contains("市") == false) goto L16;
        if (r101.equals(r102) == false) goto L16;
    L18:
        if (TextUtils.isEmpty(r103) == true) goto L21;
        r105.append(r103);
        r105.append(" ");
    L21:
        if (TextUtils.isEmpty(r104) == true) goto L24;
        r105.append(r104);
        r105.append(" ");
    L24:
        if (TextUtils.isEmpty(r110) == true) goto L27;
        r105.append(r110);
        r105.append(" ");
    L27:
        if (TextUtils.isEmpty(r111) == false) goto L29;
    L35:
        Bundle r106 = new Bundle();
        r106.putString("citycode", r100.getCityCode());
        r106.putString(SocialConstants.PARAM_APP_DESC, r105.toString());
        r106.putString("adcode", r100.getAdCode());
        r100.setExtras(r106);
        r100.f380050J = r105.toString();
        String r107 = r100.getAdCode();
        if (r107 != null) goto L38;
    L42:
        String r108 = r105.toString();
    L43:
        r100.setAddress(r108);
        return;
    L38:
        if (r107.trim().length() <= 0) goto L42;
        if (this.f517978b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) goto L42;
        r108 = r105.toString().replace(" ", "");
        goto L43
    L29:
        if (TextUtils.isEmpty(r112) == false) goto L31;
    L33:
        r105.append("Near ".concat(String.valueOf(r111)));
        String r109 = "Near ".concat(String.valueOf(r111));
    L34:
        r100.setDescription(r109);
        goto L35
    L31:
        if (this.f517978b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) goto L33;
        r105.append("靠近");
        r105.append(r111);
        r105.append(" ");
        r109 = "在" + r111 + "附近";
        goto L34
    }
}
