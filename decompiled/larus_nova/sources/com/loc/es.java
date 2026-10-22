package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.SocialConstants;
import n4a.b4;
import n4a.c4;
import n4a.f5;
import n4a.j4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class es extends AMapLocation {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f380050J;
    public String K;
    public String L;
    public int M;
    public String N;
    public int O;
    public String P;
    public JSONObject Q;
    public String R;
    public boolean S;
    public String T;
    public String U;
    public String V;

    public es() {
        super("");
        this.f380050J = "";
        this.K = null;
        this.L = "";
        this.N = "";
        this.O = 0;
        this.P = "new";
        this.Q = null;
        this.R = "";
        this.S = true;
        this.T = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.U = "";
        this.V = null;
    }

    public final void r(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        int r101 = -1;
    L11:
        this.M = r101;
        if (this.M != 0) goto L16;
        String r102 = AMapLocation.COORD_TYPE_WGS84;
    L14:
        super.setCoordType(r102);
        return;
    L16:
        r102 = AMapLocation.COORD_TYPE_GCJ02;
        goto L14
    L5:
        if (r100.equals("0") == false) goto L8;
        r101 = 0;
        goto L11
    L8:
        if (r100.equals("1") == false) goto L10;
        r101 = 1;
        goto L11
    }

    @Override // com.amap.api.location.AMapLocation
    public final void setLocationType(int r100) {
        if (r100 != 2) goto L5;
    L8:
        b4.a(this);
    L9:
        super.setLocationType(r100);
        return;
    L5:
        if (r100 == 4) goto L8;
        if (r100 != 9) goto L9;
        goto L8
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int r100) {
        JSONObject r101 = toJson(r100);     // Catch: Throwable -> L5
        r101.put("nb", this.V);     // Catch: Throwable -> L5
    L7:
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.toString();
    L5:
        th = move-exception;
        c4.g(th, "AMapLocation", "toStr part2");
        r101 = null;
        goto L7
    }

    public final es s() {
        String r100 = this.R;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        String[] r101 = r100.split(",");
        if (r101.length == 3) goto L8;
        return null;
    L8:
        es r102 = new es();
        r102.setProvider(getProvider());
        r102.setLongitude(CastDoubleProtector.parseDouble(r101[0]));
        r102.setLatitude(CastDoubleProtector.parseDouble(r101[1]));
        r102.setAccuracy(CastFloatProtector.parseFloat(r101[2]));
        r102.setCityCode(getCityCode());
        r102.setAdCode(getAdCode());
        r102.setCountry(getCountry());
        r102.setProvince(getProvince());
        r102.setCity(getCity());
        r102.setTime(getTime());
        r102.P = this.P;
        r102.r(String.valueOf(this.M));
        if (j4.m(r102) == true) goto L11;
        return null;
    L11:
        return r102;
    }

    public final void q(JSONObject r100) {
        c4.e(this, r100);     // Catch: Throwable -> L16
        this.P = r100.optString("type", this.P);     // Catch: Throwable -> L16
        this.N = r100.optString("retype", this.N);     // Catch: Throwable -> L16
        t(r100.optString("cens", this.U));     // Catch: Throwable -> L16
        this.f380050J = r100.optString(SocialConstants.PARAM_APP_DESC, this.f380050J);     // Catch: Throwable -> L16
        r(r100.optString("coord", String.valueOf(this.M)));     // Catch: Throwable -> L16
        this.R = r100.optString("mcell", this.R);     // Catch: Throwable -> L16
        this.S = r100.optBoolean("isReversegeo", this.S);     // Catch: Throwable -> L16
        this.T = r100.optString("geoLanguage", this.T);     // Catch: Throwable -> L16
        if (f5.h(r100, "poiid") == false) goto L7;
        setBuildingId(r100.optString("poiid"));     // Catch: Throwable -> L16
    L7:
        if (f5.h(r100, "pid") == false) goto L10;
        setBuildingId(r100.optString("pid"));     // Catch: Throwable -> L16
    L10:
        if (f5.h(r100, "floor") == false) goto L13;
        setFloor(r100.optString("floor"));     // Catch: Throwable -> L16
    L13:
        if (f5.h(r100, "flr") == false) goto L21;
        setFloor(r100.optString("flr"));     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        c4.g(th, "AmapLoc", "AmapLoc");
    }

    public final void t(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String[] r101 = r100.split("\\*");
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        String r104 = r101[r103];
        if (TextUtils.isEmpty(r104) == false) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        String[] r105 = r104.split(",");
        setLongitude(CastDoubleProtector.parseDouble(r105[0]));
        setLatitude(CastDoubleProtector.parseDouble(r105[1]));
        setAccuracy(CastIntegerProtector.parseInt(r105[2]));
    L11:
        this.U = r100;
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int r100) {
        JSONObject r101 = super.toJson(r100);     // Catch: Throwable -> L17
        if (r100 != 1) goto L6;
        r101.put("retype", this.N);     // Catch: Throwable -> L17
        r101.put("cens", this.U);     // Catch: Throwable -> L17
        r101.put("coord", this.M);     // Catch: Throwable -> L17
        r101.put("mcell", this.R);     // Catch: Throwable -> L17
        r101.put(SocialConstants.PARAM_APP_DESC, this.f380050J);     // Catch: Throwable -> L17
        r101.put("address", getAddress());     // Catch: Throwable -> L17
        if (this.Q != null) goto L13;
    L15:
        r101.put("type", this.P);     // Catch: Throwable -> L17
        r101.put("isReversegeo", this.S);     // Catch: Throwable -> L17
        r101.put("geoLanguage", this.T);     // Catch: Throwable -> L17
        return r101;
    L13:
        if (f5.h(r101, "offpct") == false) goto L15;
        r101.put("offpct", JSONObjectProtectorUtils.getString(this.Q, "offpct"));     // Catch: Throwable -> L17
        goto L15
    L6:
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L15;
        return r101;
    L17:
        th = move-exception;
        c4.g(th, "AmapLoc", "toStr");
        return null;
    }
}
