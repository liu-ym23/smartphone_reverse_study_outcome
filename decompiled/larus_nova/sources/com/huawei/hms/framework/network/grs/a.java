package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f277138e = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f277139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f277140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f277141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f277142d;

    /* JADX INFO: renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    public static class C3873a implements com.huawei.hms.framework.network.grs.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f277143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<String, String> f277144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        IQueryUrlsCallBack f277145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Context f277146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        GrsBaseInfo f277147e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f277148f;

        public C3873a(String r100, Map<String, String> r101, IQueryUrlsCallBack r102, Context r103, GrsBaseInfo r104, com.huawei.hms.framework.network.grs.e.a r105) {
            this.f277143a = r100;
            this.f277144b = r101;
            this.f277145c = r102;
            this.f277146d = r103;
            this.f277147e = r104;
            this.f277148f = r105;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> r100 = this.f277144b;
            if (r100 == null) goto L8;
            if (r100.isEmpty() == true) goto L8;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", new Object[]{this.f277143a, StringUtils.anonymizeMessage(new JSONObject(this.f277144b).toString())});
            this.f277145c.onCallBackSuccess(this.f277144b);
            return;
        L8:
            if (this.f277144b != null) goto L18;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> r101 = com.huawei.hms.framework.network.grs.f.b.a(this.f277146d.getPackageName()).a(this.f277146d, this.f277148f, this.f277147e, this.f277143a, true);
            if (r101 != null) goto L12;
        L13:
            Logger.e(a.a(), "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{this.f277143a});
        L14:
            if (r101 != null) goto L17;
            r101 = new ConcurrentHashMap();
        L17:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", new Object[]{this.f277143a, StringUtils.anonymizeMessage(new JSONObject(r101).toString())});
            this.f277145c.onCallBackSuccess(r101);
            return;
        L12:
            if (r101.isEmpty() == false) goto L14;
        L18:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", new Object[]{this.f277143a});
            this.f277145c.onCallBackFail(-3);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d r110) {
            String r111 = r110.j();
            Map<String, String> r100 = a.a(r111, this.f277143a);
            if (r100.isEmpty() == true) goto L6;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", new Object[]{this.f277143a, StringUtils.anonymizeMessage(new JSONObject(r100).toString())});
            IQueryUrlsCallBack r112 = this.f277145c;
        L5:
            r112.onCallBackSuccess(r100);
            return;
        L6:
            Map<String, String> r101 = this.f277144b;
            if (r101 == null) goto L12;
            if (r101.isEmpty() == true) goto L12;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", new Object[]{this.f277143a, StringUtils.anonymizeMessage(new JSONObject(this.f277144b).toString())});
            r112 = this.f277145c;
            r100 = this.f277144b;
        L12:
            if (this.f277144b == null) goto L14;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", new Object[]{this.f277143a});
            this.f277145c.onCallBackFail(-5);
            return;
        L14:
            if (TextUtils.isEmpty(r111) == true) goto L16;
            Logger.e(a.a(), "The serviceName[%s] is not configured on the GRS server.", new Object[]{this.f277143a});
        L16:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> r113 = com.huawei.hms.framework.network.grs.f.b.a(this.f277146d.getPackageName()).a(this.f277146d, this.f277148f, this.f277147e, this.f277143a, true);
            if (r113 != null) goto L19;
        L20:
            Logger.e(a.a(), "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{this.f277143a});
        L21:
            if (r113 != null) goto L24;
            r113 = new ConcurrentHashMap();
        L24:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", new Object[]{this.f277143a, StringUtils.anonymizeMessage(new JSONObject(r113).toString())});
            this.f277145c.onCallBackSuccess(r113);
            return;
        L19:
            if (r113.isEmpty() == false) goto L21;
            goto L20
        }
    }

    public static class b implements com.huawei.hms.framework.network.grs.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f277149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f277150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        IQueryUrlCallBack f277151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f277152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Context f277153e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        GrsBaseInfo f277154f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f277155g;

        public b(String r100, String r101, IQueryUrlCallBack r102, String r103, Context r104, GrsBaseInfo r105, com.huawei.hms.framework.network.grs.e.a r106) {
            this.f277149a = r100;
            this.f277150b = r101;
            this.f277151c = r102;
            this.f277152d = r103;
            this.f277153e = r104;
            this.f277154f = r105;
            this.f277155g = r106;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (TextUtils.isEmpty(this.f277152d) == true) goto L6;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{this.f277149a, this.f277150b, StringUtils.anonymizeMessage(this.f277152d)});
            this.f277151c.onCallBackSuccess(this.f277152d);
            return;
        L6:
            if (TextUtils.isEmpty(this.f277152d) == false) goto L13;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String r100 = com.huawei.hms.framework.network.grs.f.b.a(this.f277153e.getPackageName()).a(this.f277153e, this.f277155g, this.f277154f, this.f277149a, this.f277150b, true);
            if (r100 != null) goto L10;
        L11:
            Logger.e(a.a(), "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{this.f277149a, this.f277150b});
        L12:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{this.f277149a, this.f277150b, StringUtils.anonymizeMessage(r100)});
            this.f277151c.onCallBackSuccess(r100);
            return;
        L10:
            if (r100.isEmpty() == false) goto L12;
        L13:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", new Object[]{this.f277149a, this.f277150b});
            this.f277151c.onCallBackFail(-3);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d r110) {
            String r111 = r110.j();
            Map<String, String> r100 = a.a(r111, this.f277149a);
            if (r100.containsKey(this.f277150b) == false) goto L7;
            String r112 = a.a();
            String r101 = this.f277150b;
            Logger.i(r112, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", new Object[]{this.f277149a, r101, StringUtils.anonymizeMessage(r100.get(r101))});
            IQueryUrlCallBack r113 = this.f277151c;
            String r102 = r100.get(this.f277150b);
        L5:
            r113.onCallBackSuccess(r102);
            return;
        L7:
            if (TextUtils.isEmpty(this.f277152d) == true) goto L10;
            String r114 = a.a();
            String r103 = this.f277150b;
            Logger.i(r114, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{this.f277149a, r103, StringUtils.anonymizeMessage(r100.get(r103))});
            r113 = this.f277151c;
            r102 = this.f277152d;
            goto L5
        L10:
            if (TextUtils.isEmpty(this.f277152d) == true) goto L12;
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", new Object[]{this.f277149a, this.f277150b});
            this.f277151c.onCallBackFail(-5);
            return;
        L12:
            if (TextUtils.isEmpty(r111) == true) goto L14;
            Logger.e(a.a(), "The serviceName[%s][%s] is not configured on the GRS server.", new Object[]{this.f277149a, this.f277150b});
        L14:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String r115 = com.huawei.hms.framework.network.grs.f.b.a(this.f277153e.getPackageName()).a(this.f277153e, this.f277155g, this.f277154f, this.f277149a, this.f277150b, true);
            if (r115 != null) goto L17;
        L18:
            Logger.e(a.a(), "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{this.f277149a, this.f277150b});
        L19:
            Logger.i(a.a(), "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{this.f277149a, this.f277150b, StringUtils.anonymizeMessage(r115)});
            this.f277151c.onCallBackSuccess(r115);
            return;
        L17:
            if (r115.isEmpty() == false) goto L19;
            goto L18
        }
    }

    public a(GrsBaseInfo r100, com.huawei.hms.framework.network.grs.e.a r101, g r102, com.huawei.hms.framework.network.grs.e.c r103) {
        this.f277139a = r100;
        this.f277140b = r101;
        this.f277141c = r102;
        this.f277142d = r103;
    }

    public static CountryCodeBean a(Context r100, boolean r101) {
        return new CountryCodeBean(r100, r101);
    }

    public static /* synthetic */ String a() {
        return f277138e;
    }

    public static Map<String, Map<String, String>> a(String r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(r100) == false) goto L17;
        Logger.v(f277138e, "isSpExpire jsonValue is null.");
        return r101;
    L17:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L14
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L14
    L8:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();     // Catch: JSONException -> L14
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r102, r104);     // Catch: JSONException -> L14
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r101.put(r104, a(r105));     // Catch: JSONException -> L14
        goto L8
    L13:
        return r101;
    L14:
        e = move-exception;
        Logger.w(f277138e, "getServicesUrlsMap occur a JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return r101;
    }

    private Map<String, String> a(String r100, com.huawei.hms.framework.network.grs.e.b r101, Context r102) {
        Map<String, String> r103 = this.f277140b.a(this.f277139a, r100, r101, r102);
        if (r103 != null) goto L5;
    L8:
        Map<String, String> r104 = com.huawei.hms.framework.network.grs.f.b.a(r102.getPackageName()).a(r102, this.f277140b, this.f277139a, r100, false);
        Logger.i(f277138e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        if (r104 == null) goto L12;
        return r104;
    L12:
        return new HashMap();
    L5:
        if (r103.isEmpty() == true) goto L8;
        Logger.i(f277138e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
        return r103;
    }

    public static Map<String, String> a(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L25;
        Logger.w(f277138e, "isSpExpire jsonValue from server is null.");
        return r102;
    L25:
        JSONObject r103 = new JSONObject(r100);     // Catch: JSONException -> L22
        if (r103.has(r101) == false) goto L10;
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r103, r101);     // Catch: JSONException -> L22
    L11:
        if (r104 == null) goto L14;
        Iterator<String> r105 = r104.keys();     // Catch: JSONException -> L22
    L18:
        if (r105.hasNext() == false) goto L21;
        String r106 = r105.next();     // Catch: JSONException -> L22
        r102.put(r106, r104.get(r106).toString());     // Catch: JSONException -> L22
        goto L18
    L21:
        return r102;
    L14:
        Logger.w(f277138e, "getServiceNameUrls: paser null from server json data by {%s}.", new Object[]{r101});     // Catch: JSONException -> L22
        return r102;
    L10:
        r104 = null;
    L22:
        e = move-exception;
        Logger.w(f277138e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return r102;
    }

    public static Map<String, String> a(JSONObject r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap(16);
        Iterator<String> r102 = r100.keys();     // Catch: JSONException -> L13
    L5:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L13
        String r104 = r100.get(r103).toString();     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r103) == true) goto L5;
        if (TextUtils.isEmpty(r104) == true) goto L5;
        r101.put(r103, r104);     // Catch: JSONException -> L13
        goto L5
    L12:
        return r101;
    L13:
        e = move-exception;
        Logger.w(f277138e, "getServiceUrls occur a JSONException: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        return r101;
    }

    public String a(Context r100, String r101, int r102) {
        com.huawei.hms.framework.network.grs.g.d r103 = this.f277141c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f277139a, r100), r101, this.f277142d, r102);
        if (r103 != null) goto L6;
        return "";
    L6:
        if (r103.m() == false) goto L10;
        return this.f277140b.a().a(this.f277139a.getGrsParasKey(true, true, r100), "");
    L10:
        return r103.j();
    }

    public String a(String r110, String r111, Context r112, int r210) {
        com.huawei.hms.framework.network.grs.e.b r100 = new com.huawei.hms.framework.network.grs.e.b();
        String r101 = a(r110, r100, r112).get(r111);
        if (r100.a() == true) goto L5;
    L8:
        String r102 = a(r112, r110, r210);
        String r103 = a(r102, r110).get(r111);
        if (TextUtils.isEmpty(r103) == true) goto L13;
        Logger.i(f277138e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", new Object[]{r110, r111, StringUtils.anonymizeMessage(r103)});
        return r103;
    L13:
        if (TextUtils.isEmpty(r101) == true) goto L15;
    L22:
        Logger.i(f277138e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{r110, r111, StringUtils.anonymizeMessage(r101)});
        return r101;
    L15:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        Logger.e(f277138e, "The serviceName[%s][%s] is not configured on the GRS server.", new Object[]{r110, r111});
    L17:
        String r113 = f277138e;
        Logger.i(r113, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
        r101 = com.huawei.hms.framework.network.grs.f.b.a(r112.getPackageName()).a(r112, this.f277140b, this.f277139a, r110, r111, true);
        if (r101 != null) goto L20;
    L21:
        Logger.e(r113, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{r110, r111});
        goto L22
    L20:
        if (r101.isEmpty() == false) goto L22;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        Logger.i(f277138e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", new Object[]{r110, r111, StringUtils.anonymizeMessage(r101)});
        return r101;
    }

    public Map<String, String> a(String r110, Context r111, int r112) {
        com.huawei.hms.framework.network.grs.e.b r100 = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> r101 = a(r110, r100, r111);
        if (r100.a() == true) goto L5;
    L8:
        String r113 = a(r111, r110, r112);
        Map<String, String> r102 = a(r113, r110);
        if (r102.isEmpty() == true) goto L13;
        Logger.i(f277138e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", new Object[]{r110, StringUtils.anonymizeMessage(new JSONObject(r102).toString())});
        return r102;
    L13:
        if (r101.isEmpty() == true) goto L15;
    L22:
        String r114 = f277138e;
        Object[] r115 = new Object[2];
        r115[0] = r110;
        if (r101 == null) goto L25;
        String r116 = new JSONObject(r101).toString();
    L26:
        r115[1] = StringUtils.anonymizeMessage(r116);
        Logger.i(r114, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", r115);
        return r101;
    L25:
        r116 = "";
        goto L26
    L15:
        if (TextUtils.isEmpty(r113) == true) goto L17;
        Logger.e(f277138e, "The serviceName[%s] is not configured on the GRS server.", new Object[]{r110});
    L17:
        String r117 = f277138e;
        Logger.i(r117, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
        r101 = com.huawei.hms.framework.network.grs.f.b.a(r111.getPackageName()).a(r111, this.f277140b, this.f277139a, r110, true);
        if (r101 != null) goto L20;
    L21:
        Logger.e(r117, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", new Object[]{r110});
        goto L22
    L20:
        if (r101.isEmpty() == false) goto L22;
    L5:
        if (r101.isEmpty() == true) goto L8;
        Logger.i(f277138e, "Return [%s] Urls: %s", new Object[]{r110, StringUtils.anonymizeMessage(new JSONObject(r101).toString())});
        return r101;
    }

    public void a(String r110, IQueryUrlsCallBack r111, Context r112, int r113) {
        com.huawei.hms.framework.network.grs.e.b r100 = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> r101 = a(r110, r100, r112);
        if (r100.a() == true) goto L5;
        this.f277141c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f277139a, r112), new C3873a(r110, r101, r111, r112, this.f277139a, this.f277140b), r110, this.f277142d, r113);
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        Logger.i(f277138e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", new Object[]{r110});
        r111.onCallBackFail(-5);
        return;
    L7:
        String r114 = f277138e;
        Logger.i(r114, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", new Object[]{r110, StringUtils.anonymizeMessage(new JSONObject(r101).toString())});
        Logger.i(r114, "ayncGetGrsUrls: %s", new Object[]{StringUtils.anonymizeMessage(new JSONObject(r101).toString())});
        r111.onCallBackSuccess(r101);
    }

    public void a(String r110, String r111, IQueryUrlCallBack r112, Context r113, int r114) {
        com.huawei.hms.framework.network.grs.e.b r100 = new com.huawei.hms.framework.network.grs.e.b();
        String r101 = a(r110, r100, r113).get(r111);
        if (r100.a() == true) goto L5;
        this.f277141c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f277139a, r113), new b(r110, r111, r112, r101, r113, this.f277139a, this.f277140b), r110, this.f277142d, r114);
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        Logger.i(f277138e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", new Object[]{r110, r111});
        r112.onCallBackFail(-5);
        return;
    L7:
        Logger.i(f277138e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", new Object[]{r110, r111, StringUtils.anonymizeMessage(r101)});
        r112.onCallBackSuccess(r101);
    }
}
