package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f277203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f277204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f277205c;

    public b(Context r100, com.huawei.hms.framework.network.grs.e.a r101, GrsBaseInfo r102) {
        this.f277203a = r100;
        this.f277204b = r102;
        this.f277205c = r101;
    }

    public String a(boolean r110) {
        String r100 = com.huawei.hms.framework.network.grs.a.a(this.f277205c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + r100);
        String r101 = this.f277205c.a().a("geoipCountryCodetime", "0");
        long r102 = 0;
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.matches("\\d+") == false) goto L11;
        r102 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L8
    L8:
        e = move-exception;
        Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
    L11:
        if (TextUtils.isEmpty(r100) == false) goto L13;
    L14:
        com.huawei.hms.framework.network.grs.g.j.c r103 = new com.huawei.hms.framework.network.grs.g.j.c(this.f277204b, this.f277203a);
        r103.a("geoip.countrycode");
        com.huawei.hms.framework.network.grs.e.c r111 = this.f277205c.c();
        if (r111 != null) goto L33;
    L24:
        if (r110 == false) goto L29;
        d r112 = this.f277205c.b().a(r103, "geoip.countrycode", r111, -1);
        if (r112 == null) goto L28;
        r100 = com.huawei.hms.framework.network.grs.a.a(r112.j(), "geoip.countrycode").get("ROOT");
    L28:
        Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + r100);
    L30:
        return r100;
    L29:
        Logger.i("GeoipCountry", "async request to query geoip.countrycode");
        this.f277205c.b().a(r103, null, "geoip.countrycode", r111, -1);
        goto L30
    L33:
        String r104 = h.a(r111.a(PromotionProductPrivilegesStruct.SERVICES, ""), r103.c());     // Catch: JSONException -> L19
    L22:
        if (TextUtils.isEmpty(r104) == true) goto L24;
        r111.b(PromotionProductPrivilegesStruct.SERVICES, r104);
    L19:
        e = move-exception;
        Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        r104 = null;
        goto L22
    L13:
        if (com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(r102)) == false) goto L30;
        goto L14
    }
}
