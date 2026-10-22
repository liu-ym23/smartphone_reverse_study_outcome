package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class d extends a {
    public d(Context r100, String r101, boolean r102) {
        this.f277188d = r102;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = "grs_app_global_route_config.json";
    L6:
        if (a(r101, r100) != 0) goto L9;
        this.f277187c = true;
        return;
    }

    public d(boolean r100, boolean r101) {
        this.f277188d = r101;
        this.f277187c = r100;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String r100) {
        this.f277185a = new com.huawei.hms.framework.network.grs.local.model.a();
        JSONObject r101 = JSONArrayProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONArray(new JSONObject(r100), "applications"), 0);     // Catch: JSONException -> L13
        this.f277185a.b(JSONObjectProtectorUtils.getString(r101, "name"));     // Catch: JSONException -> L13
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r101, PromotionProductPrivilegesStruct.SERVICES);     // Catch: JSONException -> L13
        if (r102 != null) goto L6;
    L12:
        return -1;
    L6:
        if (r102.length() == 0) goto L12;
        if (r101.has("customservices") == false) goto L11;
        b(JSONObjectProtectorUtils.getJSONArray(r101, "customservices"));     // Catch: JSONException -> L13
    L11:
        return 0;
    L13:
        e = move-exception;
        Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int c(String r110) {
        this.f277186b = new ArrayList(16);
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L37
        if (r100.has("countryOrAreaGroups") == false) goto L7;
        JSONArray r111 = JSONObjectProtectorUtils.getJSONArray(r100, "countryOrAreaGroups");     // Catch: JSONException -> L37
    L10:
        if (r111 != null) goto L13;
        return -1;
    L13:
        if (r111.length() == 0) goto L36;
        int r101 = 0;
    L15:
        if (r101 >= r111.length()) goto L36;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r111, r101);     // Catch: JSONException -> L37
        com.huawei.hms.framework.network.grs.local.model.b r103 = new com.huawei.hms.framework.network.grs.local.model.b();     // Catch: JSONException -> L37
        r103.b(JSONObjectProtectorUtils.getString(r102, "id"));     // Catch: JSONException -> L37
        r103.c(JSONObjectProtectorUtils.getString(r102, "name"));     // Catch: JSONException -> L37
        r103.a(JSONObjectProtectorUtils.getString(r102, "description"));     // Catch: JSONException -> L37
        if (r102.has("countriesOrAreas") == false) goto L21;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r102, "countriesOrAreas");     // Catch: JSONException -> L37
    L24:
        HashSet r112 = new HashSet(16);     // Catch: JSONException -> L37
        if (r104 == null) goto L35;
        if (r104.length() == 0) goto L35;
        int r113 = 0;
    L31:
        if (r113 >= r104.length()) goto L33;
        r112.add((String) r104.get(r113));     // Catch: JSONException -> L37
        r113 = r113 + 1;     // Catch: JSONException -> L37
        goto L31
    L33:
        r103.a(r112);     // Catch: JSONException -> L37
        this.f277186b.add(r103);     // Catch: JSONException -> L37
        r101 = r101 + 1;
    L35:
        return -1;
    L21:
        if (r102.has("countries") == false) goto L23;
        r104 = JSONObjectProtectorUtils.getJSONArray(r102, "countries");     // Catch: JSONException -> L37
        goto L24
    L23:
        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");     // Catch: JSONException -> L37
        r104 = null;
    L36:
        return 0;
    L7:
        if (r100.has("countryGroups") == false) goto L9;
        r111 = JSONObjectProtectorUtils.getJSONArray(r100, "countryGroups");     // Catch: JSONException -> L37
        goto L10
    L9:
        Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");     // Catch: JSONException -> L37
        r111 = null;
    L37:
        e = move-exception;
        Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int g(String r100) {
        return f(r100);
    }
}
