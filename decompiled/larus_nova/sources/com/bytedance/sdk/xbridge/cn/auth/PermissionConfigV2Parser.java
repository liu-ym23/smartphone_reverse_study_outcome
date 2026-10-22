package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.utils.VerifyUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class PermissionConfigV2Parser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ld7.f> f269801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ld7.g> f269802b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f269803c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f269804d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f269805e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f269806f;

    public PermissionConfigV2Parser() {
    }

    static {
        f269801a = new ConcurrentHashMap();
        f269802b = new ConcurrentHashMap();
        f269803c = new ConcurrentHashMap();
        f269804d = new ConcurrentHashMap();
        f269805e = new ConcurrentHashMap();
    }

    public static ld7.l d() {
        Intrinsics.checkNotNullParameter("", "namespace");
        ConcurrentHashMap<String, Boolean> r100 = f269805e;
        if (r100.get("") == null) goto L26;
        Boolean r101 = r100.get("");
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == true) goto L26;
        ConcurrentHashMap<String, ld7.g> r102 = f269802b;
        ld7.g r103 = r102.get("");
        JSONObject r104 = null;
        if (r103 == null) goto L9;
        JSONObject r105 = r103.f508741c;
    L10:
        if (r105 == null) goto L26;
        monitor-enter(r100);
        ld7.f r106 = f269801a.get("");     // Catch: Throwable -> L23
        if (r106 == null) goto L20;
        ld7.g r107 = r102.get("");     // Catch: Throwable -> L23
        if (r107 == null) goto L19;
        r104 = r107.f508741c;     // Catch: Throwable -> L23
    L19:
        ld7.l r108 = k(r104);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r108, "<set-?>");     // Catch: Throwable -> L23
        r106.f508737c = r108;     // Catch: Throwable -> L23
    L20:
        r100.put("", Boolean.TRUE);     // Catch: Throwable -> L23
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r100);
    L23:
        th = move-exception;
        throw th;
    L9:
        r105 = null;
    L26:
        ld7.f r110 = f269801a.get("");
        if (r110 == null) goto L31;
        ld7.l r111 = r110.f508737c;
        if (r111 == null) goto L31;
        return r111;
    L31:
        return new ld7.l(0, false, false);
    }

    public static Map f() {
        ConcurrentHashMap<String, Boolean> r100 = f269804d;
        if (r100.get("") == null) goto L38;
        Boolean r101 = r100.get("");
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == true) goto L38;
        ConcurrentHashMap<String, ld7.g> r102 = f269802b;
        ld7.g r103 = r102.get("");
        if (r103 == null) goto L9;
        Map<String, JSONObject> r104 = r103.f508740b;
    L10:
        if (r104 == null) goto L38;
        monitor-enter(r100);
        ld7.g r105 = r102.get("");     // Catch: Throwable -> L35
        if (r105 == null) goto L32;
        Map<String, JSONObject> r106 = r105.f508740b;     // Catch: Throwable -> L35
        if (r106 == null) goto L32;
        Iterator<Map.Entry<String, JSONObject>> r107 = r106.entrySet().iterator();     // Catch: Throwable -> L35
    L19:
        if (r107.hasNext() == false) goto L32;
        Map.Entry<String, JSONObject> r108 = r107.next();     // Catch: Throwable -> L35
        ld7.f r109 = f269801a.get("");     // Catch: Throwable -> L35
        if (r109 == null) goto L19;
        Map<String, ld7.a> r110 = r109.f508736b;     // Catch: Throwable -> L35
        if (r110 == null) goto L19;
        if (r110.get(r108.getKey()) != null) goto L19;
        if (TypeIntrinsics.isMutableMap(r110) == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L19;
        ld7.a r111 = r110.put(r108.getKey(), i(r108.getValue()));     // Catch: Throwable -> L35
    L32:
        f269804d.put("", Boolean.TRUE);     // Catch: Throwable -> L35
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r100);
    L35:
        th = move-exception;
        throw th;
    L9:
        r104 = null;
    L38:
        ld7.f r113 = f269801a.get("");
        if (r113 == null) goto L43;
        Map<String, ld7.a> r114 = r113.f508736b;
        if (r114 == null) goto L43;
        return r114;
    L43:
        return MapsKt.emptyMap();
    }

    public static ld7.a a(String r100) {
        Intrinsics.checkNotNullParameter("", "namespace");
        if (r100 == null) goto L42;
        ConcurrentHashMap<String, ld7.f> r101 = f269801a;
        ld7.f r102 = r101.get("");
        if (r102 == null) goto L10;
        Map<String, ld7.a> r103 = r102.f508736b;
        if (r103 == null) goto L10;
        ld7.a r104 = r103.get(r100);
    L11:
        if (r104 != null) goto L42;
        ld7.g r105 = f269802b.get("");
        if (r105 == null) goto L42;
        Map<String, JSONObject> r106 = r105.f508740b;
        if (r106 == null) goto L42;
        JSONObject r107 = r106.get(r100);
        if (r107 == null) goto L42;
        monitor-enter(r101);
        ld7.f r108 = r101.get("");     // Catch: Throwable -> L39
        if (r108 == null) goto L24;
        Map<String, ld7.a> r109 = r108.f508736b;     // Catch: Throwable -> L39
        if (r109 == null) goto L24;
        ld7.a r110 = r109.get(r100);     // Catch: Throwable -> L39
    L25:
        if (r110 != null) goto L36;
        ld7.f r111 = r101.get("");     // Catch: Throwable -> L39
        if (r111 == null) goto L36;
        Map<String, ld7.a> r112 = r111.f508736b;     // Catch: Throwable -> L39
        if (r112 == null) goto L36;
        if (TypeIntrinsics.isMutableMap(r112) == true) goto L34;
        r112 = null;
    L34:
        if (r112 == null) goto L36;
        ld7.a r113 = r112.put(r100, i(r107));     // Catch: Throwable -> L39
    L36:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r101);
    L24:
        r110 = null;
    L39:
        th = move-exception;
        throw th;
    L10:
        r104 = null;
    L42:
        ld7.f r115 = f269801a.get("");
        if (r115 == null) goto L50;
        Map<String, ld7.a> r116 = r115.f508736b;
        if (r116 != null) goto L47;
        return null;
    L47:
        return r116.get(r100);
    L50:
        return null;
    }

    public static Map b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        ConcurrentHashMap<String, Boolean> r101 = f269803c;
        if (r101.get(r100) == null) goto L38;
        Boolean r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102);
        if (r102.booleanValue() == true) goto L38;
        ConcurrentHashMap<String, ld7.g> r103 = f269802b;
        ld7.g r104 = r103.get(r100);
        if (r104 == null) goto L9;
        Map<String, JSONArray> r105 = r104.f508739a;
    L10:
        if (r105 == null) goto L38;
        monitor-enter(r101);
        ld7.g r106 = r103.get(r100);     // Catch: Throwable -> L35
        if (r106 == null) goto L32;
        Map<String, JSONArray> r107 = r106.f508739a;     // Catch: Throwable -> L35
        if (r107 == null) goto L32;
        Iterator<Map.Entry<String, JSONArray>> r108 = r107.entrySet().iterator();     // Catch: Throwable -> L35
    L19:
        if (r108.hasNext() == false) goto L32;
        Map.Entry<String, JSONArray> r109 = r108.next();     // Catch: Throwable -> L35
        ld7.f r110 = f269801a.get(r100);     // Catch: Throwable -> L35
        if (r110 == null) goto L19;
        Map<String, List<ld7.b>> r111 = r110.f508735a;     // Catch: Throwable -> L35
        if (r111 == null) goto L19;
        if (r111.get(r109.getKey()) != null) goto L19;
        if (TypeIntrinsics.isMutableMap(r111) == true) goto L30;
        r111 = null;
    L30:
        if (r111 == null) goto L19;
        List<ld7.b> r112 = r111.put(r109.getKey(), j(r109.getValue()));     // Catch: Throwable -> L35
    L32:
        f269803c.put(r100, Boolean.TRUE);     // Catch: Throwable -> L35
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r101);
    L35:
        th = move-exception;
        throw th;
    L9:
        r105 = null;
    L38:
        ld7.f r114 = f269801a.get(r100);
        if (r114 != null) goto L41;
        return null;
    L41:
        return r114.f508735a;
    }

    public static int e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        ConcurrentHashMap<String, ld7.f> r101 = f269801a;
        ld7.f r102 = r101.get(r100);
        if (r102 != null) goto L10;
        r102 = r101.get("");
        if (r102 != null) goto L10;
        return -1;
    L10:
        return r102.f508738d;
    }

    public static ld7.a i(JSONObject r110) {
        JSONObject r100 = r110.optJSONObject("method_call_limits");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L3:
        String r103 = null;
        List r104 = null;
        r104 = null;
        if (r102.hasNext() == false) goto L11;
        String r105 = r102.next();
        Integer r106 = Integer.valueOf(r100.optJSONObject(r105).optInt("runtime_call_count"));
        String r107 = r100.optJSONObject(r105).optString("runtime_call_frequency");
        JSONObject r108 = r100.optJSONObject(r105);
        if (r108 == null) goto L10;
        JSONArray r109 = r108.optJSONArray("url");
        if (r109 == null) goto L10;
        r104 = g(r109, PermissionConfigV2Parser$parseMethodCallLimits$1$1.INSTANCE);
    L10:
        r101.put(r105, new ld7.m(r106, r107, r104));
        goto L3
    L11:
        AuthConfigType r111 = AuthConfigType.Companion.getType(r110.optString("type"));
        JSONArray r112 = r110.optJSONArray("safe_urls");
        if (r112 == null) goto L14;
        List r113 = g(r112, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$1.INSTANCE);
    L15:
        List r114 = r113;
        JSONObject r115 = r110.optJSONObject("public_key");
        if (r115 == null) goto L18;
        r103 = r115.optString(com.alipay.sdk.m.n.d.f25615a);
    L18:
        if (r103 != null) goto L20;
        r103 = "";
    L20:
        ld7.n r116 = new ld7.n(r103);
        AuthBridgeAccess.a r117 = AuthBridgeAccess.Companion;
        String r118 = r110.optString("group");
        r117.getClass();
        AuthBridgeAccess r119 = AuthBridgeAccess.a.a(r118);
        JSONArray r120 = r110.optJSONArray("included_methods");
        if (r120 == null) goto L23;
        List r121 = g(r120, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$2.INSTANCE);
    L24:
        List r122 = r121;
        JSONArray r123 = r110.optJSONArray("excluded_methods");
        if (r123 == null) goto L27;
        List r124 = g(r123, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$3.INSTANCE);
    L29:
        return new ld7.a(r111, r114, r116, r119, r122, r124, r101, r110.optInt(BaseSwitches.V, 1));
    L27:
        r124 = CollectionsKt.emptyList();
        goto L29
    L23:
        r121 = CollectionsKt.emptyList();
        goto L24
    L14:
        r113 = CollectionsKt.emptyList();
        goto L15
    }

    public static List j(JSONArray r110) {
        ArrayList r100 = new ArrayList();
        if (r110 == null) goto L19;
        int r101 = r110.length();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L19;
        JSONObject r103 = r110.optJSONObject(r102);
        String r104 = r103.optString("pattern");
        AuthBridgeAccess.a r105 = AuthBridgeAccess.Companion;
        String r106 = r103.optString("group");
        r105.getClass();
        AuthBridgeAccess r107 = AuthBridgeAccess.a.a(r106);
        JSONArray r108 = r103.optJSONArray("included_methods");
        if (r108 == null) goto L9;
        List r109 = g(r108, PermissionConfigV2Parser$parseContentPerHost$1$authConfig$1.INSTANCE);
    L10:
        List r111 = r109;
        JSONArray r112 = r103.optJSONArray("excluded_methods");
        if (r112 == null) goto L13;
        List r113 = g(r112, PermissionConfigV2Parser$parseContentPerHost$1$authConfig$2.INSTANCE);
    L14:
        List r114 = r113;
        if (r103.has("appid") == false) goto L17;
        Long r115 = Long.valueOf(r103.optLong("appid"));
    L18:
        r100.add(new ld7.b(r104, r107, r111, r114, r115));
        r102 = r102 + 1;
        goto L5
    L17:
        r115 = null;
        goto L18
    L13:
        r113 = CollectionsKt.emptyList();
        goto L14
    L9:
        r109 = CollectionsKt.emptyList();
    L19:
        return r100;
    }

    public static ld7.l k(JSONObject r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.optInt("sign_verify_mode");
    L7:
        if (r100 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r100 == null) goto L17;
        if (r100.optInt("enable_jsb_call_limit") != 1) goto L17;
        r101 = true;
    L17:
        return new ld7.l(r102, r103, r101);
    L9:
        if (r100.optInt("enable_jsb_auth") != 1) goto L11;
        r103 = true;
        goto L12
    L5:
        r102 = 0;
        goto L7
    }

    public static List c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "namespace");
        ConcurrentHashMap<String, ld7.f> r102 = f269801a;
        ld7.f r103 = r102.get(r101);
        Map<String, List<ld7.b>> r104 = null;
        if (r103 == null) goto L7;
        Map<String, List<ld7.b>> r105 = r103.f508735a;
        if (r105 == null) goto L7;
        List<ld7.b> r106 = r105.get(r100);
    L8:
        if (r106 != null) goto L38;
        ld7.g r107 = f269802b.get(r101);
        if (r107 == null) goto L38;
        Map<String, JSONArray> r108 = r107.f508739a;
        if (r108 == null) goto L38;
        JSONArray r109 = r108.get(r100);
        if (r109 == null) goto L38;
        monitor-enter(r102);
        ld7.f r110 = r102.get(r101);     // Catch: Throwable -> L35
        if (r110 == null) goto L21;
        Map<String, List<ld7.b>> r111 = r110.f508735a;     // Catch: Throwable -> L35
        if (r111 == null) goto L21;
        List<ld7.b> r112 = r111.get(r100);     // Catch: Throwable -> L35
    L22:
        if (r112 != null) goto L32;
        ld7.f r113 = r102.get(r101);     // Catch: Throwable -> L35
        if (r113 == null) goto L32;
        Map<String, List<ld7.b>> r114 = r113.f508735a;     // Catch: Throwable -> L35
        if (r114 == null) goto L32;
        if (TypeIntrinsics.isMutableMap(r114) == false) goto L30;
        r104 = r114;
    L30:
        if (r104 == null) goto L32;
        List<ld7.b> r115 = r104.put(r100, j(r109));     // Catch: Throwable -> L35
    L32:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r102);
    L21:
        r112 = null;
    L35:
        th = move-exception;
        throw th;
    L38:
        ld7.f r117 = r102.get(r101);
        if (r117 == null) goto L45;
        Map<String, List<ld7.b>> r118 = r117.f508735a;
        if (r118 == null) goto L45;
        List<ld7.b> r119 = r118.get(r100);
        if (r119 == null) goto L45;
        return r119;
    L45:
        return CollectionsKt.emptyList();
    L7:
        r106 = null;
        goto L8
    }

    public static List g(JSONArray r100, Function1 r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(r101.invoke(r100.opt(r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.ies.bullet.base.utils.logger.a, java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public static void h(JSONObject r110, String r210, boolean r211, String r212) {
        boolean r100 = r211;
        if (r210 == null) goto L84;
        JSONObject r101 = r110.optJSONObject("data");
        ?? r102 = 0;
        if (r101 == null) goto L10;
        JSONObject r103 = r101.optJSONObject("packages");
        if (r103 == null) goto L10;
        JSONArray r104 = r103.optJSONArray(r210);
    L11:
        if (r104 != null) goto L13;
        return;
    L13:
        f269806f = r212;
        String r105 = "parse config from loader " + r212 + ", accessKey: " + r210 + ", config size: " + r104.length() + ", isLazyParse: " + r100;
        Intrinsics.checkNotNullParameter(r105, "msg");
        int r106 = 12;
        HybridLogger.m("PermissionConfigV2Parser", r105, null, null, 12);
        int r107 = r104.length();
        boolean r108 = false;
        int r109 = 0;
    L14:
        if (r109 >= r107) goto L110;
        JSONObject r111 = r104.optJSONObject(r109);
        String r112 = r111.optString("channel");
        if (r112 != null) goto L19;
    L24:
        String r113 = r102;
    L25:
        if (r113 == 0) goto L81;
        int r114 = r111.optInt("package_version", -1);
        String r115 = "parse namespace: " + r113 + ", package version: " + r114;
        Intrinsics.checkNotNullParameter(r115, "msg");
        HybridLogger.m("PermissionConfigV2Parser", r115, r102, r102, r106);
        if (r100 == true) goto L62;
        ld7.l r116 = k(r111.optJSONObject("lynx_global_settings"));
        ConcurrentHashMap<String, ld7.f> r117 = f269801a;
        LinkedHashMap r118 = new LinkedHashMap();
        JSONObject r119 = r111.optJSONObject("content");
        if (r119 == null) goto L38;
        Iterator<String> r120 = r119.keys();
        if (r120 == null) goto L38;
    L33:
        if (r120.hasNext() == false) goto L38;
        String r121 = r120.next();
        JSONArray r122 = r119.optJSONArray(r121);
        int r123 = r107;
        if (r122 == null) goto L37;
        r118.put(r121, j(r122));
    L37:
        r107 = r123;
    L38:
        int r124 = r107;
        LinkedHashMap r125 = new LinkedHashMap();
        JSONObject r126 = r111.optJSONObject("content_v2");
        if (r126 == null) goto L47;
        Iterator<String> r127 = r126.keys();
        if (r127 == null) goto L47;
    L43:
        if (r127.hasNext() == false) goto L47;
        String r128 = r127.next();
        JSONObject r129 = r126.optJSONObject(r128);
        if (r129 == null) goto L43;
        r125.put(r128, i(r129));
    L47:
        Collection r130 = r125.values();
        ArrayList r131 = new ArrayList();
        Iterator r132 = r130.iterator();
    L49:
        if (r132.hasNext() == false) goto L57;
        Object r133 = r132.next();
        if (((ld7.a) r133).getType() != AuthConfigType.WEB) goto L53;
        boolean r134 = true;
    L54:
        if (r134 == false) goto L49;
        r131.add(r133);
        goto L49
    L53:
        r134 = false;
        goto L54
    L57:
        ArrayList r135 = new ArrayList();
        Iterator r136 = r131.iterator();
    L59:
        if (r136.hasNext() == false) goto L61;
        CollectionsKt.addAll(r135, ((ld7.a) r136.next()).f508699b);
        goto L59
    L61:
        VerifyUtils.f269854a.getClass();
        VerifyUtils.b(r135);
        ld7.f r137 = new ld7.f(r118, r125, r116);
        r137.f508738d = r114;
        r117.put(r113, r137);
        ConcurrentHashMap<String, Boolean> r138 = f269803c;
        Boolean r139 = Boolean.TRUE;
        r138.put(r113, r139);
        f269804d.put(r113, r139);
        f269805e.put(r113, r139);
    L83:
        r109 = r109 + 1;
        r100 = r211;
        r107 = r124;
        r102 = 0;
        r106 = 12;
        r108 = false;
        goto L14
    L62:
        r124 = r107;
        ConcurrentHashMap<String, ld7.f> r140 = f269801a;
        ld7.f r141 = new ld7.f(new LinkedHashMap(), new LinkedHashMap(), new ld7.l(0, false, false));
        r141.f508738d = r114;
        r140.put(r113, r141);
        ConcurrentHashMap<String, ld7.g> r142 = f269802b;
        LinkedHashMap r143 = new LinkedHashMap();
        JSONObject r144 = r111.optJSONObject("content");
        if (r144 == null) goto L71;
        Iterator<String> r145 = r144.keys();
        if (r145 == null) goto L71;
    L67:
        if (r145.hasNext() == false) goto L71;
        String r146 = r145.next();
        JSONArray r147 = r144.optJSONArray(r146);
        if (r147 == null) goto L67;
        r143.put(r146, r147);
    L71:
        LinkedHashMap r148 = new LinkedHashMap();
        JSONObject r149 = r111.optJSONObject("content_v2");
        if (r149 == null) goto L80;
        Iterator<String> r150 = r149.keys();
        if (r150 == null) goto L80;
    L76:
        if (r150.hasNext() == false) goto L80;
        String r151 = r150.next();
        JSONObject r152 = r149.optJSONObject(r151);
        if (r152 == null) goto L76;
        r148.put(r151, r152);
    L80:
        r142.put(r113, new ld7.g(r143, r148, r111.optJSONObject("lynx_global_settings")));
        ConcurrentHashMap<String, Boolean> r153 = f269803c;
        Boolean r154 = Boolean.FALSE;
        r153.put(r113, r154);
        f269804d.put(r113, r154);
        f269805e.put(r113, r154);
        goto L83
    L81:
        r124 = r107;
        goto L83
    L19:
        if (Intrinsics.areEqual(r112, "_jsb_auth") == false) goto L22;
        r113 = "";
        goto L25
    L22:
        if (StringsKt.startsWith$default(r112, "_jsb_auth.", r108, 2, r102) == false) goto L24;
        r113 = StringsKt.replace$default(r112, "_jsb_auth.", "", false, 4, null);
        goto L25
    L110:
        return;
    L10:
        r104 = null;
        goto L11
    }
}
