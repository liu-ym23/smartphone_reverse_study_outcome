package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.huawei.hms.framework.network.grs.local.model.a f277185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<com.huawei.hms.framework.network.grs.local.model.b> f277186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f277187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f277188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Set<String> f277189e;

    public a() {
        this.f277187c = false;
        this.f277188d = false;
        this.f277189e = new HashSet(16);
    }

    private Map<String, String> a(List<com.huawei.hms.framework.network.grs.local.model.b> r100, GrsBaseInfo r101, String r102) {
        ConcurrentHashMap r103 = new ConcurrentHashMap(16);
        r103.put("no_route_country", "no-country");
        Iterator<com.huawei.hms.framework.network.grs.local.model.b> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L17;
        com.huawei.hms.framework.network.grs.local.model.b r105 = r104.next();
        if (r105.a().contains(r101.getIssueCountry()) == false) goto L9;
        r103.put(r101.getIssueCountry(), r105.b());
    L9:
        if (r105.a().contains(r101.getRegCountry()) == false) goto L12;
        r103.put(r101.getRegCountry(), r105.b());
    L12:
        if (r105.a().contains(r101.getSerCountry()) == false) goto L15;
        r103.put(r101.getSerCountry(), r105.b());
    L15:
        if (r105.a().contains(r102) == false) goto L4;
        Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
        r103.put(r102, r105.b());
        goto L4
    L17:
        return r103;
    }

    private int b(String r100, Context r101) {
        if (h(com.huawei.hms.framework.network.grs.h.c.a(r100, r101)) != 0) goto L5;
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", new Object[]{r100});
        return 0;
    L5:
        return -1;
    }

    private int h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return -1;
    L7:
        if (this.f277188d == false) goto L11;
        int r101 = c(r100);
        if (r101 == 0) goto L11;
        return r101;
    L11:
        int r102 = b(r100);
        if (r102 == 0) goto L15;
        return r102;
    L15:
        return g(r100);
    }

    private int i(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return -1;
    L7:
        if (this.f277188d == false) goto L16;
        List<com.huawei.hms.framework.network.grs.local.model.b> r101 = this.f277186b;
        if (r101 != null) goto L11;
    L12:
        int r102 = e(r100);
        if (r102 == 0) goto L16;
        return r102;
    L11:
        if (r101.isEmpty() == true) goto L12;
    L16:
        return f(r100);
    }

    public int a(String r100, Context r101) {
        if (b(GrsApp.getInstance().getBrand(HTTP.URL_DEFAULT) + r100, r101) == 0) goto L6;
        return -1;
    L6:
        return 0;
    }

    public String a(Context r100, com.huawei.hms.framework.network.grs.e.a r101, GrsBaseInfo r102, String r110, String r111, boolean r112) {
        Map<String, String> r103 = a(r100, r101, r102, r110, r112);
        if (r103 != null) goto L7;
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", new Object[]{r110});
        return null;
    L7:
        return r103.get(r111);
    }

    public String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if ("no_route_country".equals(r100) == false) goto L9;
        return "no-country";
    L9:
        List<com.huawei.hms.framework.network.grs.local.model.b> r101 = this.f277186b;
        if (r101 != null) goto L12;
    L21:
        return null;
    L12:
        if (r101.isEmpty() == true) goto L21;
        Iterator<com.huawei.hms.framework.network.grs.local.model.b> r102 = this.f277186b.iterator();
    L16:
        if (r102.hasNext() == false) goto L21;
        com.huawei.hms.framework.network.grs.local.model.b r103 = r102.next();
        if (r103.a().contains(r100) == false) goto L16;
        return r103.b();
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray r110) {
        if (r110 == null) goto L30;
        if (r110.length() == 0) goto L30;
        ArrayList r100 = new ArrayList(16);
        int r101 = 0;
    L8:
        if (r101 >= r110.length()) goto L28;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r110, r101);
        com.huawei.hms.framework.network.grs.local.model.b r103 = new com.huawei.hms.framework.network.grs.local.model.b();
        r103.b(JSONObjectProtectorUtils.getString(r102, "id"));
        r103.c(JSONObjectProtectorUtils.getString(r102, "name"));
        r103.a(JSONObjectProtectorUtils.getString(r102, "description"));
        String r104 = "countriesOrAreas";
        if (r102.has("countriesOrAreas") == false) goto L12;
    L11:
        JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r102, r104);
    L16:
        HashSet r106 = new HashSet(16);
        if (r105 == null) goto L27;
        if (r105.length() == 0) goto L27;
        int r107 = 0;
    L23:
        if (r107 >= r105.length()) goto L25;
        r106.add((String) r105.get(r107));
        r107 = r107 + 1;
        goto L23
    L25:
        r103.a(r106);
        r100.add(r103);
        r101 = r101 + 1;
    L27:
        return new ArrayList();
    L12:
        r104 = "countries";
        if (r102.has("countries") == true) goto L11;
        Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
        r105 = null;
        goto L16
    L28:
        return r100;
    L30:
        return new ArrayList();
    }

    public Map<String, String> a(Context r100, com.huawei.hms.framework.network.grs.e.a r101, GrsBaseInfo r102, String r103, boolean r110) {
        com.huawei.hms.framework.network.grs.local.model.a r104 = this.f277185a;
        if (r104 != null) goto L6;
        Logger.w("AbstractLocalManager", "application data is null.");
        return null;
    L6:
        com.huawei.hms.framework.network.grs.local.model.c r105 = r104.a(r103);
        if (r105 != null) goto L10;
        Logger.w("AbstractLocalManager", "service not found in local config{%s}", new Object[]{r103});
        return null;
    L10:
        String r106 = e.b(r100, r101, r105.b(), r102, r110);
        if (r106 != null) goto L14;
        Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", new Object[]{r105.b()});
        return null;
    L14:
        List<com.huawei.hms.framework.network.grs.local.model.b> r107 = r105.a();
        if (r107 != null) goto L17;
    L19:
        String r108 = a(r106);
    L20:
        com.huawei.hms.framework.network.grs.local.model.d r109 = r105.a(r108);
        if (r109 != null) goto L24;
        return null;
    L24:
        return r109.a();
    L17:
        if (r107.size() == 0) goto L19;
        r108 = a(r107, r102, r106).get(r106);
        goto L20
    }

    public JSONObject a() {
        JSONObject r100 = this.f277185a.b();
        if (this.f277186b == null) goto L9;
        JSONArray r101 = new JSONArray();
        Iterator<com.huawei.hms.framework.network.grs.local.model.b> r102 = this.f277186b.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.put(r102.next().c());
        goto L6
    L8:
        r100.put("countryGroups", r101);
    L9:
        return r100;
    }

    public void a(Context r100, List<String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() <= 0) goto L28;
        Iterator<String> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L29;
        String r103 = r102.next();
        Logger.d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + r103);
        if (TextUtils.isEmpty(r103) == true) goto L16;
        if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", r103) == false) goto L16;
        if (i(com.huawei.hms.framework.network.grs.h.c.a(GrsApp.getInstance().getBrand(HTTP.URL_DEFAULT) + r103, r100)) == 0) goto L14;
        Logger.w("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", new Object[]{r103});
        goto L7
    L14:
        Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", new Object[]{r103});
    L16:
        Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", new Object[]{r103});
        goto L7
    L29:
        return;
    }

    public abstract int b(String r100);

    public com.huawei.hms.framework.network.grs.local.model.a b() {
        return this.f277185a;
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
    public void b(JSONArray r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.length() == 0) goto L57;
        int r100 = 0;
    L8:
        if (r100 >= r110.length()) goto L58;
        JSONObject r101 = JSONArrayProtectorUtils.getJSONObject(r110, r100);
        com.huawei.hms.framework.network.grs.local.model.c r102 = new com.huawei.hms.framework.network.grs.local.model.c();
        String r103 = JSONObjectProtectorUtils.getString(r101, "name");
        r102.b(r103);
        if (this.f277189e.contains(r103) == true) goto L43;
        this.f277189e.add(r103);
        if (this.f277188d == false) goto L43;
        r102.c(JSONObjectProtectorUtils.getString(r101, "routeBy"));
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r101, "servings");
        int r105 = 0;
    L15:
        if (r105 >= r104.length()) goto L32;
        JSONObject r106 = (JSONObject) r104.get(r105);
        com.huawei.hms.framework.network.grs.local.model.d r107 = new com.huawei.hms.framework.network.grs.local.model.d();
        String r111 = "countryOrAreaGroup";
        if (r106.has("countryOrAreaGroup") == false) goto L19;
    L18:
        String r108 = JSONObjectProtectorUtils.getString(r106, r111);
    L23:
        r107.a(r108);
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r106, "addresses");
        ConcurrentHashMap r112 = new ConcurrentHashMap(16);
        Iterator<String> r113 = r109.keys();
    L25:
        if (r113.hasNext() == false) goto L31;
        String r114 = r113.next();
        String r115 = JSONObjectProtectorUtils.getString(r109, r114);
        if (TextUtils.isEmpty(r114) == true) goto L25;
        if (TextUtils.isEmpty(r115) == true) goto L25;
        r112.put(r114, JSONObjectProtectorUtils.getString(r109, r114));
        goto L25
    L31:
        r107.a(r112);
        r102.a(r107.b(), r107);
        r105 = r105 + 1;
        goto L15
    L19:
        r111 = "countryGroup";
        if (r106.has("countryGroup") == true) goto L18;
        Logger.v("AbstractLocalManager", "maybe this service{%s} routeBy is unconditional.", new Object[]{r103});
        r108 = "no-country";
        goto L23
    L32:
        String r116 = "countryOrAreaGroups";
        if (r101.has("countryOrAreaGroups") == false) goto L35;
    L34:
        List<com.huawei.hms.framework.network.grs.local.model.b> r117 = a(JSONObjectProtectorUtils.getJSONArray(r101, r116));
    L39:
        r102.a(r117);
        if (this.f277185a != null) goto L42;
        this.f277185a = new com.huawei.hms.framework.network.grs.local.model.a();
    L42:
        this.f277185a.a(r103, r102);
        goto L43
    L35:
        r116 = "countryGroups";
        if (r101.has("countryGroups") == true) goto L34;
        Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
        r117 = null;
    L43:
        r100 = r100 + 1;
        goto L8
    L58:
        return;
    }

    public abstract int c(String r100);

    public Set<String> c() {
        return this.f277189e;
    }

    public boolean d() {
        return this.f277187c;
    }

    public boolean d(String r100) {
        this.f277185a = new com.huawei.hms.framework.network.grs.local.model.a();     // Catch: Throwable -> L18 JSONException -> L20
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L18 JSONException -> L20
        if (r101.has("name") == false) goto L7;
        this.f277185a.b(r101.getString("name"));     // Catch: Throwable -> L18 JSONException -> L20
    L7:
        if (r101.has("cacheControl") == false) goto L10;
        this.f277185a.a(r101.getLong("cacheControl"));     // Catch: Throwable -> L18 JSONException -> L20
    L10:
        if (r101.has(PromotionProductPrivilegesStruct.SERVICES) == false) goto L13;
        b(r101.getJSONArray(PromotionProductPrivilegesStruct.SERVICES));     // Catch: Throwable -> L18 JSONException -> L20
    L13:
        if (r101.has("countryGroups") == false) goto L16;
        JSONArray r102 = r101.getJSONArray("countryGroups");     // Catch: Throwable -> L18 JSONException -> L20
        ArrayList r103 = new ArrayList(16);     // Catch: Throwable -> L18 JSONException -> L20
        this.f277186b = r103;     // Catch: Throwable -> L18 JSONException -> L20
        r103.addAll(a(r102));     // Catch: Throwable -> L18 JSONException -> L20
    L16:
        Logger.i("AbstractLocalManager", "parse from sp services size : %d, countryGroups size: %d:", new Object[]{Integer.valueOf(this.f277189e.size()), Integer.valueOf(this.f277186b.size())});     // Catch: Throwable -> L18 JSONException -> L20
        return true;
    L20:
        String r104 = "Parse local config from sp failed, JSONException";
    L21:
        Logger.w("AbstractLocalManager", r104);
        return false;
    L18:
        th = move-exception;
        r104 = "Parse local config from sp failed, Throwable:" + StringUtils.anonymizeMessage(th.getMessage());
        goto L21
    }

    public int e(String r100) {
        this.f277186b = new ArrayList(16);
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L14
        if (r101.has("countryOrAreaGroups") == false) goto L7;
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r101, "countryOrAreaGroups");     // Catch: JSONException -> L14
    L10:
        if (r102 != null) goto L12;
        return -1;
    L12:
        this.f277186b.addAll(a(r102));     // Catch: JSONException -> L14
        return 0;
    L7:
        if (r101.has("countryGroups") == false) goto L9;
        r102 = JSONObjectProtectorUtils.getJSONArray(r101, "countryGroups");     // Catch: JSONException -> L14
        goto L10
    L9:
        Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");     // Catch: JSONException -> L14
        r102 = null;
    L14:
        e = move-exception;
        Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    public int f(String r100) {
        b(JSONObjectProtectorUtils.getJSONArray(new JSONObject(r100), PromotionProductPrivilegesStruct.SERVICES));     // Catch: JSONException -> L5
        return 0;
    L5:
        e = move-exception;
        Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return -1;
    }

    public abstract int g(String r100);
}
