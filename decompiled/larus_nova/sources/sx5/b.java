package sx5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.BuildConfig;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import go2.g;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile b f543815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f543816o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f543817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f543818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f543819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f543820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f543821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f543822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f543823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f543824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f543825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f543826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f543827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f543828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public sx5.a f543829m;

    /* JADX INFO: loaded from: classes19.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f543830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f543831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f543832c;

        public a(String r100, String r101, String r102) {
            this.f543830a = r100;
            this.f543831b = r101;
            this.f543832c = r102;
        }
    }

    public static b g() {
        if (f543815n != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f543815n != null) goto L9;
        f543815n = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f543815n;
    }

    public final JSONObject f() {
        if (this.f543828l == true) goto L6;
        return null;
    L6:
        JSONObject r100 = new JSONObject();
        r100.put(EffectConfiguration.KEY_REGION, this.f543817a);     // Catch: JSONException -> L9
        r100.put("source", this.f543818b);     // Catch: JSONException -> L9
        r100.put("local_region", this.f543821e);     // Catch: JSONException -> L9
        r100.put("update_region", this.f543822f);     // Catch: JSONException -> L9
    L11:
        return r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final void h() {
        SharedPreferences r100 = this.f543827k.getSharedPreferences("ttnet_store_region", 0);
        this.f543817a = r100.getString(CronetDataStorageAccess.STORE_REGION, "");
        this.f543818b = r100.getString("store_region_src", "");
        this.f543819c = r100.getString(CronetDataStorageAccess.REGION_LEGACY_USER, "");
        this.f543820d = r100.getString("store_sec_uid", "");
        this.f543822f = r100.getString("update_region_info", "");
        this.f543824h = r100.getBoolean("received_region_config", false);
        if (TextUtils.isEmpty(this.f543817a) == true) goto L5;
    L7:
        this.f543829m.onStoreIdcChanged("", this.f543817a, this.f543818b, this.f543819c, this.f543820d, "");
        if (Logger.debug() == false) goto L11;
        Logger.d("StoreRegionManager", "Init region:" + this.f543817a + " sec_uid:" + this.f543820d + " source:" + this.f543818b + " local:" + this.f543821e + " init region:" + this.f543823g + " region config:" + this.f543824h);
        return;
    L11:
        return;
    L5:
        if (TextUtils.isEmpty(this.f543821e) == true) goto L7;
        this.f543817a = this.f543821e;
        this.f543818b = "local";
        goto L7
    }

    public final void i() {
        if (this.f543824h == true) goto L6;
        this.f543824h = true;
        SharedPreferences.Editor r100 = this.f543827k.getSharedPreferences("ttnet_store_region", 0).edit();
        r100.putBoolean("received_region_config", true);
        r100.apply();
        return;
    }

    public b() {
        this.f543817a = "";
        this.f543818b = "";
        this.f543819c = "";
        this.f543820d = "";
        this.f543821e = "";
        this.f543822f = "";
        this.f543823g = "";
        this.f543825i = new ArrayList();
        this.f543826j = new ArrayList();
    }

    static {
    }

    public static a c(List r100) {
        if (r100 != null) goto L5;
    L31:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L31;
        if (f543816o == false) goto L10;
        String r101 = "store-region=";
        String r102 = "store-region-src=";
    L11:
        Iterator r103 = r100.iterator();
        String r104 = "";
        String r105 = "";
        String r106 = r105;
    L13:
        if (r103.hasNext() == false) goto L24;
        String r107 = (String) r103.next();
        if (r107.toLowerCase().startsWith(r101) == true) goto L16;
        if (r107.toLowerCase().startsWith(r102) == true) goto L19;
        if (r107.toLowerCase().startsWith("region_legacy_user=") == false) goto L13;
        r106 = r107;
        goto L13
    L19:
        r105 = r107;
        goto L13
    L16:
        r104 = r107;
        goto L13
    L24:
        if (TextUtils.isEmpty(r104) == false) goto L26;
        return null;
    L26:
        String r108 = d(r104);
        if (r108.isEmpty() == false) goto L30;
        return null;
    L30:
        return new a(r108, d(r105), d(r106));
    L10:
        r101 = "store-country-code=";
        r102 = "store-country-code-src=";
        goto L11
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String[] r101 = r100.split(i.f25853b);
        if (r101 != null) goto L8;
    L15:
        return "";
    L8:
        if (r101.length <= 0) goto L15;
        String[] r102 = r101[0].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r102 == null) goto L15;
        if (r102.length != 2) goto L15;
        return r102[1];
    }

    public final Request a(Request r100) {
        if (this.f543828l == true) goto L5;
    L61:
        return null;
    L5:
        if (TextUtils.isEmpty(r100.getHost()) == true) goto L61;
        if (r100.isPureRequest() == false) goto L10;
        return null;
    L10:
        Iterator r101 = ((ArrayList) this.f543826j).iterator();
    L11:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L16;
        String r103 = (String) r101.next();
        if (UrlUtils.matchPattern(r100.getHost(), r103) == false) goto L11;
        boolean r104 = true;
    L17:
        ArrayList r105 = new ArrayList();
        if (this.f543824h == false) goto L20;
    L22:
        if (r104 == true) goto L25;
        return null;
    L25:
        if (r100.getHeaders() == null) goto L27;
        r105.addAll(r100.getHeaders());
    L27:
        Request.Builder r106 = r100.newBuilder();
        if (TextUtils.isEmpty(r100.getPath()) == false) goto L31;
    L43:
        if (r102 == false) goto L47;
        r106.headers(r105);
        return r106.build();
    L47:
        if (this.f543817a.isEmpty() == true) goto L50;
        String r107 = this.f543817a;
    L54:
        if (TextUtils.isEmpty(r107) == true) goto L57;
        r105.add(new Header("x-tt-store-region", r107));
    L57:
        if (TextUtils.isEmpty(this.f543818b) == true) goto L59;
        r105.add(new Header("x-tt-store-region-src", this.f543818b));
    L59:
        r106.headers(r105);
        return r106.build();
    L50:
        if (this.f543821e.isEmpty() == true) goto L52;
        r107 = this.f543821e;
        goto L54
    L52:
        r107 = "";
        goto L54
    L31:
        if ("/get_domains/v5/".equals(r100.getPath()) == false) goto L33;
    L32:
        r102 = true;
        goto L43
    L33:
        Iterator r108 = ((ArrayList) this.f543825i).iterator();
    L35:
        if (r108.hasNext() == false) goto L39;
        String r109 = (String) r108.next();
        if (UrlUtils.matchPattern(r100.getPath(), r109) == false) goto L35;
        boolean r110 = true;
    L40:
        if (r110 == false) goto L43;
        UrlBuilder r111 = new UrlBuilder(r100.getUrl());
        r111.addParam("okhttp_version", BuildConfig.VERSION_NAME);
        r111.addParam("use_store_region_cookie", "1");
        r106.url(r111.build());
        goto L32
    L39:
        r110 = false;
        goto L40
    L20:
        if (TextUtils.isEmpty(this.f543823g) == true) goto L22;
        r105.add(new Header("x-tt-app-init-region", this.f543823g));
        r104 = true;
        goto L22
    L16:
        r104 = false;
        goto L17
    }

    public final boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Iterator r101 = ((ArrayList) this.f543825i).iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (UrlUtils.matchPattern(r100, (String) r101.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static String e(Map<String, List<String>> r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L23;
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        if (r101.equalsIgnoreCase(r103) == false) goto L7;
        List<String> r104 = r100.get(r103);
    L12:
        if (r104 != null) goto L14;
        return "";
    L14:
        if (r104.size() > 0) goto L16;
        return "";
    L16:
        return (String) ListProtector.get(r104, r104.size() - 1);
    L11:
        r104 = null;
        goto L12
    L23:
        return "";
    }

    public final void j(HttpURLConnection r110, byte[] r210, g r211) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.f543828l == true) goto L8;
        return;
    L8:
        if (b(r110.getURL().getPath()) == true) goto L10;
        return;
    L10:
        Map<String, List<String>> r100 = r110.getHeaderFields();
        List<String> r101 = r100.get("Set-Cookie");
        if (r101 != null) goto L13;
    L14:
        r101 = r100.get("Set-Cookie".toLowerCase());
    L15:
        a r102 = c(r101);
        String r103 = e(r100, "x-tt-with-tnc");
        String r104 = "";
        if (TextUtils.isEmpty(r103) == false) goto L18;
    L23:
        String r111 = "";
    L24:
        if (r102 == null) goto L26;
    L28:
        if (r102 != null) goto L30;
        r102 = new a("", "", "");
    L30:
        String r112 = e(r100, "x-tt-store-sec-uid");
        String r105 = e(r100, NetResponse.HEADER_KEY_LOG_ID);
        String r113 = e(r100, "x-tt-tnc-attr");
        String r114 = e(r100, "x-ss-etag");
        String r115 = e(r100, "x-tt-tnc-config");
        JSONObject r106 = new JSONObject();
        r104 = r110.getURL().getPath();     // Catch: JSONException -> L33
        r106.put("url", r110.getURL().getHost() + r104);     // Catch: JSONException -> L33
        r106.put(CronetDataStorageAccess.STORE_REGION, r102.f543830a + "," + r102.f543831b);     // Catch: JSONException -> L33
        r106.put(CronetDataStorageAccess.REGION_LEGACY_USER, r102.f543832c);     // Catch: JSONException -> L33
        r106.put("logId", r105);     // Catch: JSONException -> L33
    L35:
        BaseCronetSsCall.a(r104, r102.f543830a, r102.f543831b, r102.f543832c, r113, r114, r115, r111, r106.toString(), r112, r105);
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L26:
        if (TextUtils.isEmpty(r111) == false) goto L28;
        return;
    L18:
        if (r103.equals("1") == false) goto L23;
        r111 = "{\"data\": " + JSONObjectProtectorUtils.getString(new JSONObject(new String(r210)), "tnc_data") + i.f25855d;     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L13:
        if (r101.isEmpty() == false) goto L15;
        goto L14
    }

    public final void k(Response r110, String r111, byte[] r210) {
        if (this.f543828l == true) goto L61;
        return;
    L61:
        URI r100 = UrlUtils.safeCreateUri(r111);     // Catch: Exception -> L60
        String r101 = r100.getHost() + r100.getPath();     // Catch: Exception -> L60
        if (TextUtils.isEmpty(r100.getPath()) == false) goto L10;
        return;
    L10:
        if (b(r100.getPath()) == true) goto L12;
        return;
    L12:
        a r102 = c(r110.headers("Set-Cookie"));
        String r103 = r110.header("x-ss-etag");
        String r104 = r110.header("x-tt-tnc-attr");
        String r105 = r110.header("x-tt-with-tnc");
        if (TextUtils.isEmpty(r105) == false) goto L15;
    L20:
        JSONObject r106 = null;
    L22:
        if (r102 != null) goto L26;
        if (r106 == null) goto L26;
        this.f543829m.updateTncConfig(r106, r103, r104, false);
        return;
    L26:
        if (r102 != null) goto L29;
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d("StoreRegionManager", "origin region:" + this.f543817a + " sec_uid:" + this.f543820d + " source:" + this.f543818b + " local:" + this.f543821e);
    L31:
        boolean r107 = !this.f543817a.equals(r102.f543830a);
        String r112 = r110.header("x-tt-store-sec-uid");
        if (r112 != null) goto L34;
        r112 = "";
    L34:
        SharedPreferences.Editor r113 = this.f543827k.getSharedPreferences("ttnet_store_region", 0).edit();
        if (this.f543817a.equals(r102.f543830a) == false) goto L42;
        String r114 = r101;
        if (this.f543818b.equals(r102.f543831b) == true) goto L39;
    L43:
        String r108 = r102.f543830a;
        this.f543817a = r108;
        this.f543818b = r102.f543831b;
        this.f543820d = r112;
        r113.putString(CronetDataStorageAccess.STORE_REGION, r108);
        r113.putString("store_region_src", this.f543818b);
        r113.putString("store_sec_uid", this.f543820d);
        boolean r109 = true;
    L45:
        if (this.f543819c.equals(r102.f543832c) == true) goto L48;
        String r115 = r102.f543832c;
        this.f543819c = r115;
        r113.putString(CronetDataStorageAccess.REGION_LEGACY_USER, r115);
        r109 = true;
    L48:
        if (Logger.debug() == false) goto L51;
        Logger.d("StoreRegionManager", "update region:" + this.f543817a + " sec_uid:" + this.f543820d + " source:" + this.f543818b + " regionLegacyUser:" + this.f543819c + GXImageView.LOCAL_PREFIX + this.f543821e);
        StringBuilder r116 = new StringBuilder("save config:");
        r116.append(r109);
        r116.append(" update tnc:");
        r116.append(r107);
        Logger.d("StoreRegionManager", r116.toString());
    L51:
        boolean r117 = this.f543829m.updateTncConfig(r106, r103, r104, r107);
        if (r109 == false) goto L67;
        String r118 = r110.header(NetResponse.HEADER_KEY_LOG_ID);
        String r119 = r100.getPath() + "," + r118 + "," + r102.f543830a + "," + r102.f543831b;
        this.f543822f = r119;
        r113.putString("update_region_info", r119);
        r113.apply();
        sx5.a r120 = this.f543829m;
        JSONObject r121 = new JSONObject();
        JSONObject r122 = new JSONObject();
        r122.put("url", r114);     // Catch: JSONException -> L56
        r122.put("logId", r118);     // Catch: JSONException -> L56
        r121.put("tnc", r117);     // Catch: JSONException -> L56
        r121.put("base", r122);     // Catch: JSONException -> L56
        r121.put("report_time", System.currentTimeMillis());     // Catch: JSONException -> L56
        r121.put(CronetDataStorageAccess.STORE_REGION, this.f543817a);     // Catch: JSONException -> L56
        r121.put("source", this.f543818b);     // Catch: JSONException -> L56
        r121.put(CronetDataStorageAccess.REGION_LEGACY_USER, this.f543819c);     // Catch: JSONException -> L56
        r121.put("local", this.f543821e);     // Catch: JSONException -> L56
    L58:
        r120.sendFeedbackLog(r121.toString(), CronetDataStorageAccess.STORE_IDC);
        this.f543829m.onStoreIdcChanged("", this.f543817a, this.f543818b, this.f543819c, this.f543820d, r118);
        return;
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L67:
        return;
    L39:
        if (r112.equals(this.f543820d) == false) goto L43;
        r109 = false;
        goto L45
    L42:
        r114 = r101;
        goto L43
    L15:
        if (r105.equals("1") == false) goto L20;
        r106 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(new String(r210)), "tnc_data");     // Catch: JSONException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    }
}
