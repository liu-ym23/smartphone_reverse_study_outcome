package com.bytedance.lynx.webview.glue.sdk113;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebViewFactoryProvider;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.lynx.webview.IntegrityChecker;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.a;
import com.bytedance.lynx.webview.cloudservice.TTSccCloudService;
import com.bytedance.lynx.webview.cloudservice.c;
import com.bytedance.lynx.webview.cloudservice.d;
import com.bytedance.lynx.webview.cloudservice.h;
import com.bytedance.lynx.webview.glue.sdk112.IGlueToSdk112;
import com.bytedance.lynx.webview.internal.AppInfo;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.LibraryLoader;
import com.bytedance.lynx.webview.internal.TTAdblockContext;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.e;
import com.bytedance.lynx.webview.internal.i0;
import com.bytedance.lynx.webview.internal.o0;
import com.bytedance.lynx.webview.internal.q0;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import l17.k;
import l17.l;
import m17.b;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public abstract class IGlueToSdk113 extends IGlueToSdk112 {
    public static boolean acceptSysCookie() {
        return e.f265297d.acceptCookie();
    }

    public static boolean doesSccEnable() {
        return d.f265093b.get();
    }

    public static void flushSysCookie() {
        e.f265297d.flush();
    }

    public static String getBoeBlockHostList() {
        String r100 = TTWebContext.G;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public static String getBoeBlockPathList() {
        String r100 = TTWebContext.H;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public static int getSccVersion() {
        AtomicInteger r100 = TTWebContext.f265202n;
        return 25;
    }

    public static void removeExpiredSysCookie() {
        e.f265297d.removeExpiredCookie();
    }

    public static boolean sysHasCookies() {
        return e.f265297d.hasCookies();
    }

    public static void cm_flush() {
        TTWebContext.h().f265216b.f265146i.getSystemProvider().getCookieManager().flush();
    }

    public static boolean getHostAdblockEnable() {
        TTWebContext.h().f265221g.getClass();
        return TTWebContext.h().p().f265273b.getBoolean("host_adblock_enable", true);
    }

    public static ClassLoader getSysProviderClassLoader() {
        WebViewFactoryProvider r100 = TTWebContext.h().f265216b.f265146i.getSystemProvider();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getClass().getClassLoader();
    }

    public static boolean resetToSystemWebView() {
        LibraryLoader r100 = TTWebContext.h().f265216b;
        r100.z();
        a.d(EventType.LOAD_RESET_FALLBACK);
        f17.a r101 = LibraryLoader.f265129p;
        r101.i();
        r101.h();
        r100.f265149l = null;
        r.b("[Load] resetToSystemWebView invoked from core error.");
        EventStatistics.e(EventType.LOAD_FALLBACK_TO_SYSTEM, null);
        TTWebContext.j().f265229b = -106;
        return true;
    }

    public IGlueToSdk113() {
    }

    public static int getCodeCacheSize() {
        return TTWebContext.F;
    }

    public static int getHttpCacheSize() {
        return TTWebContext.E;
    }

    public static Bundle getSdkStartupTime() {
        return i0.f265324b;
    }

    public static Boolean checkIntegrityForLib(String r100) {
        return Boolean.valueOf(IntegrityChecker.b(r100));
    }

    public static String cm_getCookie(String r100) {
        return TTWebContext.h().f265216b.f265146i.getSystemProvider().getCookieManager().getCookie(r100);
    }

    public static String getSysCookie(String r100) {
        return e.f265297d.getCookie(r100);
    }

    public static boolean matchHighRiskBlocklist(String r110) {
        c r100 = c.a.f265091a;
        if (r100.f265086a == true) goto L6;
        return false;
    L6:
        if (r100.f265087b == null) goto L49;
        int r101 = r110.indexOf("://");
        if (r101 <= 0) goto L16;
        String r102 = r110.substring(r101 + 3);
        int r103 = r102.indexOf("?");
        if (r103 <= 0) goto L13;
        r102 = r102.substring(0, r103);
    L13:
        int r104 = r102.indexOf("#");
        if (r104 <= 0) goto L17;
        r102 = r102.substring(0, r104);
    L17:
        long r105 = System.currentTimeMillis();
        m17.a r106 = r100.f265087b;
        r106.getClass();
        long r107 = b.a(r102, -1756908916);
        long r111 = BodyPartID.bodyIdMax;
        long r108 = r107 & BodyPartID.bodyIdMax;
        long r112 = ((long) b.a(r102, (int) r108)) & BodyPartID.bodyIdMax;
        int r113 = 0;
        int r114 = 0;
    L18:
        int r109 = r106.f511608b;
        if (r113 >= r109) goto L24;
        long r115 = r105;
        long r116 = (((long) ((int) ((((long) r113) * r112) + r108))) & r111) % ((long) r106.f511607a);
        if ((((byte) (1 << ((int) (r116 % 8)))) & r106.f511609c[(int) (r116 >> 3)]) == 0) goto L23;
        r114 = r114 + 1;
    L23:
        r113 = r113 + 1;
        r105 = r115;
        r111 = BodyPartID.bodyIdMax;
        goto L18
    L24:
        long r117 = r105;
        if (r114 != r109) goto L27;
        boolean r118 = true;
    L28:
        EventStatistics.e(EventType.SCC_HIGH_RISK_BLOCKLIST_MATCH_COST, Long.valueOf(System.currentTimeMillis() - r117));
        if (r118 == false) goto L40;
        JSONObject r119 = new JSONObject();
        r119.put("iframe_url", r110);     // Catch: JSONException -> L33
        r119.put("bloom_key", r102);     // Catch: JSONException -> L33
        r119.put("scc_high_risk_bloom_version", r100.f265089d);     // Catch: JSONException -> L33
    L35:
        if (r100.f265090e != 0) goto L38;
        EventStatistics.f(EventType.SCC_HIGH_RISK_BLOCKLIST_MATCH.getEventCode(), r119);
        return true;
    L38:
        if (r100.f265090e != 1) goto L40;
        EventStatistics.f(EventType.SCC_HIGH_RISK_BLOCKLIST_MONITOR.getEventCode(), r119);
    L40:
        return false;
    L27:
        r118 = false;
        goto L28
    L16:
        r102 = "";
        goto L17
    L49:
        return false;
    }

    public static void onAdblockEvent(String r100) {
        TTAdblockContext r101 = TTWebContext.h().f265221g;
        r101.getClass();
        TTWebContext.B(new o0(r101, r100));
    }

    public static void onSccEvent(JSONObject r100) {
        d.onEvent(r100);
    }

    public static void removeAllSysCookies(ValueCallback<Boolean> r100) {
        e.f265297d.removeAllCookies(r100);
    }

    public static void removeSessionSysCookies(ValueCallback<Boolean> r100) {
        e.f265297d.removeSessionCookies(r100);
    }

    public static void setAcceptFileSchemeSysCookies(boolean r100) {
        CookieManager r101 = e.f265297d;     // Catch: Exception -> L4
        r101.getClass().getMethod("setAcceptFileSchemeCookiesImpl", new Class[]{Boolean.TYPE}).invoke(r101, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L4
        return;
    }

    public static void setAcceptSysCookie(boolean r100) {
        e.f265297d.setAcceptCookie(r100);
    }

    public static void cm_setCookie(String r100, String r101) {
        TTWebContext.h().f265216b.f265146i.getSystemProvider().getCookieManager().setCookie(r100, r101);
    }

    public static void onSafeBrowsingFeedback(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == true) goto L19;
        o17.e r102 = new o17.e(r100);
        r102.f521716c = r101.optString(com.alipay.sdk.m.p.e.f25671s, "POST");
        r102.f521718e = r101.optInt("timeout", 5000);
        r102.f521714a = new HashMap();
        JSONObject r103 = r101.optJSONObject("header");
        String r104 = "";
        if (r103 != null) goto L8;
        r102.f521714a.put("Content-Type", "application/json");
    L12:
        JSONObject r105 = r101.optJSONObject(ContainerPosition.BODY);
        if (r105 == null) goto L16;
        r104 = r105.toString();
    L16:
        r102.f521717d = r104;
        ((o17.b) l.a()).d(r102, null);
        return;
    L8:
        Iterator<String> r106 = r103.keys();
    L10:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();
        r102.f521714a.put(r107, r103.optString(r107, ""));
        goto L10
    }

    public static void onSpecificEventReport(String r100, JSONObject r101) {
        TTWebContext r102 = TTWebContext.h();
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (((HashMap) r102.f265227m).containsKey(r100) == false) goto L11;
        Iterator r103 = ((List) ((HashMap) r102.f265227m).get(r100)).iterator();     // Catch: Throwable -> L13
    L8:
        if (r103.hasNext() == false) goto L11;
        ((TTWebSdk.j) r103.next()).onEvent(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);
    }

    public static void startUriLookup(long r100, String r110) {
        com.bytedance.lynx.webview.internal.a r101 = TTWebContext.e();
        if (r101 != null) goto L5;
        TTSccCloudService.b(false, -1, "error", r100, -1, "");
        return;
    L5:
        AppInfo r102 = r101.a();
        if (r102 != null) goto L8;
        TTSccCloudService.b(false, -1, "error", r100, -1, "");
        return;
    L8:
        com.bytedance.lynx.webview.cloudservice.a r103 = d.f265092a;
        o17.e r104 = new o17.e("https://scc.bytedance.com/scc_sdk/url_scan_v2");
        r104.f521716c = "POST";
        HashMap r105 = new HashMap();
        r104.f521714a = r105;
        r105.put("Content-Type", "application/json");
        r104.f521718e = 2000;
        JSONObject r106 = new JSONObject();
        long r107 = TTWebContext.K;     // Catch: Exception -> L19
        if (r107 >= 0) goto L17;
        r107 = CastLongProtector.parseLong(r102.getAppId());     // Catch: Exception -> L19
        if (r107 != 13) goto L15;
        r107 = 58;
        goto L17
    L15:
        if (r107 != 35) goto L17;
        r107 = 59;
    L17:
        r106.put("aid", r107);     // Catch: Exception -> L19
        r106.put("device_platform", "android");     // Catch: Exception -> L19
        r106.put(com.bytedance.android.ec.core.event.a.KEY_DID, r102.getDeviceId());     // Catch: Exception -> L19
        r106.put("ts", System.currentTimeMillis());     // Catch: Exception -> L19
        r106.put("url", r110);     // Catch: Exception -> L19
        TTSccCloudService.a(r106, "sdk");     // Catch: Exception -> L19
        r106.put("sign", "");     // Catch: Exception -> L19
    L20:
        r104.f521717d = r106.toString();
        o17.c r111 = new o17.c();
        r111.f521712a = new TTSccCloudService.a(r100);
        ((o17.b) l.a()).d(r104, r111);
        return;
    L19:
        k.b(new String[]{"cloudservice", "generate params error"});
        goto L20
    }

    public static void requestRealtimeAdblockRules(String r100, String r101, String r102) {
        TTWebContext r103 = TTWebContext.h();
        r103.getClass();
        q0 r104 = new q0(r103, r100);
        long r105 = System.currentTimeMillis();     // Catch: JSONException -> L21
        o17.e r106 = new o17.e("https://scc.bytedance.com/scc_sdk/adblock_rules/get");     // Catch: JSONException -> L21
        r106.f521716c = "POST";     // Catch: JSONException -> L21
        HashMap r107 = new HashMap();     // Catch: JSONException -> L21
        r106.f521714a = r107;     // Catch: JSONException -> L21
        r107.put("Content-Type", "application/json");     // Catch: JSONException -> L21
        r106.f521718e = 5000;     // Catch: JSONException -> L21
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L21
        r108.put("domain", r100);     // Catch: JSONException -> L21
        if (TTWebContext.e() == null) goto L14;
        String r109 = TTWebContext.e().a().getAppId();     // Catch: JSONException -> L21
        if (r109 == null) goto L14;
        int r110 = CastIntegerProtector.parseInt(r109);     // Catch: JSONException -> L21
        if (r110 != 13) goto L12;
        r110 = 58;
    L15:
        r108.put("aid", r110);     // Catch: JSONException -> L21
        if (TTWebContext.e() == null) goto L18;
        String r111 = TTWebContext.e().a().getDeviceId();     // Catch: JSONException -> L21
    L19:
        r108.put(com.bytedance.android.ec.core.event.a.KEY_DID, r111);     // Catch: JSONException -> L21
        r108.put("device_platform", "android");     // Catch: JSONException -> L21
        r106.f521717d = r108.toString();     // Catch: JSONException -> L21
        o17.c r112 = new o17.c();     // Catch: JSONException -> L21
        r112.f521712a = new h(r104, r105);     // Catch: JSONException -> L21
        ((o17.b) l.a()).d(r106, r112);     // Catch: JSONException -> L21
        return;
    L18:
        r111 = null;
        goto L19
    L12:
        if (r110 != 35) goto L15;
        r110 = 59;
    L14:
        r110 = -1;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setSysCookie(String r100, String r101, ValueCallback<Boolean> r102) {
        e.f265297d.setCookie(r100, r101, r102);
    }

    public static void sendSccRequest(String r100, long r101, JSONObject r102, JSONObject r103) {
        if (TextUtils.isEmpty(r100) == true) goto L24;
        JSONObject r104 = r102.optJSONObject(ContainerPosition.BODY);
        String r105 = "";
        if (r104 == null) goto L10;
        r104.optString("url", "");
        if (r100.contains("scan") == false) goto L10;
        com.bytedance.lynx.webview.cloudservice.a r106 = d.f265092a;
    L10:
        o17.e r107 = new o17.e(r100);
        r107.f521716c = r102.optString(com.alipay.sdk.m.p.e.f25671s, "POST");
        r107.f521718e = r102.optInt("timeout", 2000);
        r107.f521714a = new HashMap();
        JSONObject r108 = r102.optJSONObject("header");
        if (r108 != null) goto L13;
        r107.f521714a.put("Content-Type", "application/json");
    L17:
        TTSccCloudService.a(r104, "native");
        if (r104 == null) goto L21;
        r105 = r104.toString();
    L21:
        r107.f521717d = r105;
        o17.c r109 = new o17.c();
        r109.f521712a = new TTSccCloudService.a(r101);
        ((o17.b) l.a()).d(r107, r109);
        return;
    L13:
        Iterator<String> r110 = r108.keys();
    L15:
        if (r110.hasNext() == false) goto L17;
        String r111 = r110.next();
        r107.f521714a.put(r111, r108.optString(r111, ""));
        goto L15
    }
}
