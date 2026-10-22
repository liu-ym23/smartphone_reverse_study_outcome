package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class c extends a {
    public c(Context r100, boolean r101) {
        this.f277188d = r101;
        if (a("grs_sdk_global_route_config.json", r100) != 0) goto L6;
        this.f277187c = true;
        return;
    }

    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject r110) {
        ArrayList r100 = new ArrayList(16);     // Catch: JSONException -> L26
        Iterator<String> r101 = r110.keys();     // Catch: JSONException -> L26
    L5:
        if (r101.hasNext() == false) goto L25;
        String r102 = r101.next();     // Catch: JSONException -> L26
        com.huawei.hms.framework.network.grs.local.model.b r103 = new com.huawei.hms.framework.network.grs.local.model.b();     // Catch: JSONException -> L26
        r103.b(r102);     // Catch: JSONException -> L26
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r110, r102);     // Catch: JSONException -> L26
        r103.c(JSONObjectProtectorUtils.getString(r104, "name"));     // Catch: JSONException -> L26
        r103.a(JSONObjectProtectorUtils.getString(r104, "description"));     // Catch: JSONException -> L26
        if (r104.has("countriesOrAreas") == false) goto L10;
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r104, "countriesOrAreas");     // Catch: JSONException -> L26
    L13:
        HashSet r106 = new HashSet(16);     // Catch: JSONException -> L26
        if (r105 == null) goto L23;
        if (r105.length() == 0) goto L23;
        int r111 = 0;
    L20:
        if (r111 >= r105.length()) goto L22;
        r106.add((String) r105.get(r111));     // Catch: JSONException -> L26
        r111 = r111 + 1;     // Catch: JSONException -> L26
        goto L20
    L22:
        r103.a(r106);     // Catch: JSONException -> L26
        r100.add(r103);     // Catch: JSONException -> L26
    L23:
        return new ArrayList();
    L10:
        if (r104.has("countries") == false) goto L12;
        r105 = JSONObjectProtectorUtils.getJSONArray(r104, "countries");     // Catch: JSONException -> L26
        goto L13
    L12:
        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");     // Catch: JSONException -> L26
        r105 = null;
        goto L13
    L25:
        return r100;
    L26:
        e = move-exception;
        Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return new ArrayList();
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray r100, JSONObject r101) {
        if (r101 == null) goto L9;
        if (r101.length() == 0) goto L9;
        return a(r101);
    L9:
        return new ArrayList();
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String r100) {
        this.f277185a = new com.huawei.hms.framework.network.grs.local.model.a();
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "application");     // Catch: JSONException -> L10
        String r102 = JSONObjectProtectorUtils.getString(r101, "name");     // Catch: JSONException -> L10
        long r103 = JSONObjectProtectorUtils.getLong(r101, "cacheControl");     // Catch: JSONException -> L10
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r101, PromotionProductPrivilegesStruct.SERVICES);     // Catch: JSONException -> L10
        this.f277185a.b(r102);     // Catch: JSONException -> L10
        this.f277185a.a(r103);     // Catch: JSONException -> L10
        if (r104 == null) goto L9;
        if (r104.length() == 0) goto L9;
        return 0;
    L9:
        return -1;
    L10:
        e = move-exception;
        Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int c(String r100) {
        this.f277186b = new ArrayList(16);
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L16
        if (r101.has("countryOrAreaGroups") == false) goto L7;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "countryOrAreaGroups");     // Catch: JSONException -> L16
    L10:
        if (r102 != null) goto L13;
        return -1;
    L13:
        if (r102.length() == 0) goto L15;
        this.f277186b.addAll(a(r102));     // Catch: JSONException -> L16
    L15:
        return 0;
    L7:
        if (r101.has("countryGroups") == false) goto L9;
        r102 = JSONObjectProtectorUtils.getJSONObject(r101, "countryGroups");     // Catch: JSONException -> L16
        goto L10
    L9:
        Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");     // Catch: JSONException -> L16
        r102 = null;
    L16:
        e = move-exception;
        Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.huawei.hms.framework.network.grs.f.a
    public int g(String r210) {
        String r100 = "countryGroup";
        String r101 = "countryOrAreaGroup";
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r210), PromotionProductPrivilegesStruct.SERVICES);     // Catch: JSONException -> L47
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L47
    L4:
        if (r103.hasNext() == false) goto L45;
        String r104 = r103.next();     // Catch: JSONException -> L47
        com.huawei.hms.framework.network.grs.local.model.c r110 = new com.huawei.hms.framework.network.grs.local.model.c();     // Catch: JSONException -> L47
        r110.b(r104);     // Catch: JSONException -> L47
        if (this.f277189e.contains(r104) == true) goto L4;
        this.f277189e.add(r104);     // Catch: JSONException -> L47
        if (this.f277188d == false) goto L4;
        JSONObject r111 = JSONObjectProtectorUtils.getJSONObject(r102, r104);     // Catch: JSONException -> L47
        r110.c(JSONObjectProtectorUtils.getString(r111, "routeBy"));     // Catch: JSONException -> L47
        JSONArray r112 = JSONObjectProtectorUtils.getJSONArray(r111, "servings");     // Catch: JSONException -> L47
        int r113 = 0;
    L12:
        if (r113 >= r112.length()) goto L32;
        JSONObject r114 = (JSONObject) r112.get(r113);     // Catch: JSONException -> L47
        com.huawei.hms.framework.network.grs.local.model.d r115 = new com.huawei.hms.framework.network.grs.local.model.d();     // Catch: JSONException -> L47
        if (r114.has(r101) == false) goto L17;
        String r116 = JSONObjectProtectorUtils.getString(r114, r101);     // Catch: JSONException -> L47
    L19:
        String r105 = r116;
    L22:
        r115.a(r105);     // Catch: JSONException -> L47
        JSONObject r106 = JSONObjectProtectorUtils.getJSONObject(r114, "addresses");     // Catch: JSONException -> L47
        String r117 = r100;
        ConcurrentHashMap r118 = new ConcurrentHashMap(16);     // Catch: JSONException -> L47
        Iterator<String> r107 = r106.keys();     // Catch: JSONException -> L47
    L24:
        if (r107.hasNext() == false) goto L31;
        r107 = r107;
        String r108 = r107.next();     // Catch: JSONException -> L47
        String r119 = JSONObjectProtectorUtils.getString(r106, r108);     // Catch: JSONException -> L47
        if (TextUtils.isEmpty(r108) == true) goto L24;
        if (TextUtils.isEmpty(r119) == true) goto L24;
        r118.put(r108, JSONObjectProtectorUtils.getString(r106, r108));     // Catch: JSONException -> L47
        r101 = r101;
        goto L24
    L31:
        r115.a(r118);     // Catch: JSONException -> L47
        r110.a(r115.b(), r115);     // Catch: JSONException -> L47
        r113 = r113 + 1;     // Catch: JSONException -> L47
        r100 = r117;
        r101 = r101;
        goto L12
    L17:
        if (r114.has(r100) == false) goto L20;
        r116 = JSONObjectProtectorUtils.getString(r114, r100);     // Catch: JSONException -> L47
        goto L19
    L20:
        Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");     // Catch: JSONException -> L47
        r105 = "no-country";
        goto L22
    L32:
        String r120 = r100;
        String r121 = r101;
        List<com.huawei.hms.framework.network.grs.local.model.b> r109 = null;
        if (r111.has("countryOrAreaGroups") == false) goto L36;
        JSONObject r122 = JSONObjectProtectorUtils.getJSONObject(r111, "countryOrAreaGroups");     // Catch: JSONException -> L47
    L38:
        r109 = a(null, r122);     // Catch: JSONException -> L47
    L40:
        r110.a(r109);     // Catch: JSONException -> L47
        if (this.f277185a != null) goto L43;
        this.f277185a = new com.huawei.hms.framework.network.grs.local.model.a();     // Catch: JSONException -> L47
    L43:
        this.f277185a.a(r104, r110);     // Catch: JSONException -> L47
        r100 = r120;
        r101 = r121;
        goto L4
    L36:
        if (r111.has("countryGroups") == false) goto L39;
        r122 = JSONObjectProtectorUtils.getJSONObject(r111, "countryGroups");     // Catch: JSONException -> L47
        goto L38
    L39:
        Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");     // Catch: JSONException -> L47
        goto L40
    L45:
        return 0;
    L47:
        e = move-exception;
        Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }
}
