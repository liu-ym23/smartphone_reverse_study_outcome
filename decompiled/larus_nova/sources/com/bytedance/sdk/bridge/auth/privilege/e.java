package com.bytedance.sdk.bridge.auth.privilege;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.JsonUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.BridgeConfig;
import com.bytedance.sdk.bridge.BridgeManager;
import com.bytedance.sdk.bridge.BridgeMethodInfo;
import com.bytedance.sdk.bridge.Logger;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.bytedance.sdk.bridge.api.BridgeService;
import com.bytedance.sdk.bridge.auth.AbsBridgeAuthFilter;
import com.bytedance.sdk.bridge.js.auth.NewAuthRequestApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;
import xc7.g;
import xc7.h;

/* JADX INFO: loaded from: classes22.dex */
public class e<T, B> extends AbsBridgeAuthFilter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T, B> f269572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, List<vc7.a>> f269573b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f269574a = null;

        static {
            int[] r100 = new int[NewPrivilegeAuthResult.values().length];
            f269574a = r100;
            r100[NewPrivilegeAuthResult.FALSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f269574a[NewPrivilegeAuthResult.TRUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public e(xc7.d r100) {
        this.f269572a = r100;
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r101 != null) goto L8;
        return r100;
    L8:
        if (r101.length > 1) goto L10;
        return r100;
    L10:
        return r101[r101.length - 1];
    }

    public static int d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        String r101 = r100.toLowerCase();
        r101.getClass();
        switch(r101.hashCode()) {
            case -977423767: goto L17;
            case -608539730: goto L13;
            case -314497661: goto L9;
            default: goto L7;
        };
    L7:
        byte r102 = -1;
    L20:
        switch(r102) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            default: goto L28;
        };
    L22:
        return 3;
    L23:
        return 2;
    L24:
        return 1;
    L28:
        return -1;
    L9:
        if (r101.equals(BridgePrivilege.PRIVATE) == false) goto L7;
        r102 = 2;
        goto L20
    L13:
        if (r101.equals("protected") == false) goto L7;
        r102 = 1;
        goto L20
    L17:
        if (r101.equals("public") == false) goto L7;
        r102 = 0;
        goto L20
    }

    public static void f(BridgeMethodInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getBridgeMethodName();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        d r102 = d.a.f269571a;
        r102.getClass();
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        Map<String, List<String>> r103 = r102.f269570b.f554127b;
        if (r103 == null) goto L49;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.isEmpty() == true) goto L50;
        boolean r105 = BridgeManager.INSTANCE.getBridgeConfig().isIgnoreNameSpace().booleanValue();
        String r106 = c(r101);
        Iterator r107 = r104.entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L51;
        Map.Entry r108 = (Map.Entry) r107.next();
        List r109 = (List) r108.getValue();
        if (r109 == null) goto L22;
        if (r109.isEmpty() == true) goto L22;
        if (r109.contains(r101) == true) goto L34;
        if (r105 == false) goto L22;
        if (b(r109, r106) == false) goto L22;
    L34:
        r100.setMethodPrivilege((String) r108.getKey());
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L9:
        if (((ConcurrentHashMap) r102.f269570b.f554126a).isEmpty() == false) goto L16;
        if (((ConcurrentHashMap) r102.f269570b.f554127b).isEmpty() == false) goto L16;
        r102.b();     // Catch: Exception -> L14
        goto L16
    }

    public static boolean b(List r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (TextUtils.equals(c((String) r102.next()), r101) == false) goto L7;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(T r100, BridgeMethodInfo r101) {
        if (this.f269572a != null) goto L5;
        return false;
    L5:
        if ("protected".equals(r101.getMethodPrivilege()) == false) goto L46;
        b<T, B> r102 = this.f269572a;
        String r103 = r101.getBridgeMethodName();
        ((xc7.d) r102).getClass();
        ConcurrentHashMap r104 = (ConcurrentHashMap) xc7.c.f563221a;
        xc7.e r105 = (xc7.e) r104.get((String) r100);
        if (r105 != null) goto L9;
        return false;
    L9:
        if (((ArrayList) r105.f563223a).contains(r103) == false) goto L11;
    L14:
        boolean r106 = true;
    L15:
        BridgeConfig r107 = BridgeManager.INSTANCE.getBridgeConfig();
        if (r107 == null) goto L37;
        if (r107.isIgnoreNameSpace().booleanValue() == false) goto L37;
        if (r106 == true) goto L35;
        List<String> r108 = r105.f563223a;
        int r109 = 0;
    L38:
        ArrayList r110 = (ArrayList) r108;     // Catch: RuntimeException -> L31
        if (r109 >= r110.size()) goto L33;
        String[] r111 = ((String) ListProtector.get(r110, r109)).split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: RuntimeException -> L31
        if (r111 == null) goto L30;
        if (r111.length <= 1) goto L30;
        if (TextUtils.equals(r111[r111.length - 1], r103) == false) goto L30;
        boolean r112 = true;
    L34:
        if (r112 == true) goto L35;
        return false;
    L30:
        r109 = r109 + 1;
    L33:
        r112 = false;
    L31:
        e = move-exception;
        Logger r113 = Logger.f269563c;
        int r114 = xc7.d.f563222a;
        e.getMessage();
        r113.getClass();
        Logger.a();
    L35:
        return true;
    L37:
        return r106;
    L11:
        if (((ArrayList) r105.f563224b).contains(r103) == true) goto L14;
        r106 = false;
        goto L15
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [com.bytedance.sdk.bridge.js.auth.NewAuthRequestApi] */
    /* JADX WARN: Type inference failed for: r0v111 */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v4, types: [com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r20v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.sdk.bridge.auth.AbsBridgeAuthFilter
    public final boolean auth(T r210, BridgeMethodInfo r211) {
        int[] r100 = a.f269574a;
        f(r211);
        String r110 = "public";
        ?? r111 = "event_type";
        if (r110.equals(r211.getMethodPrivilege()) == false) goto L5;
        NewPrivilegeAuthResult r101 = NewPrivilegeAuthResult.TRUE;
    L101:
        int r102 = r100[r101.ordinal()];
        if (r102 == 1) goto L151;
        if (r102 == 2) goto L149;
        d r103 = d.a.f269571a;
        boolean r104 = r103.f269569a;
        f(r211);
        if (r104 == true) goto L108;
    L138:
        r110 = r110;
    L141:
        if (r110.equals(r211.getMethodPrivilege()) == false) goto L144;
        return true;
    L144:
        if (this.f269572a == null) goto L146;
        String r105 = (String) r210;
        return a(r210, r211);
    L146:
        return false;
    L108:
        if (this.f269572a == null) goto L138;
        int r106 = h.f563228c;
        h r107 = h.a.f563231a;
        if (r107.f563229a == true) goto L138;
        if (r107.f563230b == true) goto L138;
        r107.f563230b = true;
        long r112 = System.currentTimeMillis();
        BridgeService r108 = (BridgeService) ServiceManager.getService(BridgeService.class);     // Catch: Throwable -> L130
        if (r108 == null) goto L134;
        com.bytedance.sdk.bridge.c r109 = r108.initBridgeLazyConfig();     // Catch: Throwable -> L130
        if (r109 != null) goto L121;
        r107.f563230b = false;     // Catch: Throwable -> L136
        Logger.f269563c.getClass();     // Catch: Throwable -> L136
        Logger.b();     // Catch: Throwable -> L136
    L164:
        goto L141
    L121:
        if (r103.f269569a == true) goto L123;
        r107.f563230b = false;     // Catch: Throwable -> L130
        goto L138
    L123:
        ?? r113 = (NewAuthRequestApi) RetrofitUtils.createOkService("https://jsb.snssdk.com/", NewAuthRequestApi.class);     // Catch: Throwable -> L130
        String r114 = r109.f269576a.f269580d;     // Catch: Throwable -> L130
        ?? r115 = new JsonObject();     // Catch: Throwable -> L130
        JsonObject r116 = new JsonObject();     // Catch: Throwable -> L130
        JsonObject r117 = new JsonObject();     // Catch: Throwable -> L130
        JsonArray r118 = new JsonArray();     // Catch: Throwable -> L130
        JsonObject r119 = new JsonObject();     // Catch: Throwable -> L130
        r119.addProperty("aid", Integer.valueOf(r109.f269576a.f269577a));     // Catch: Throwable -> L136
        r119.addProperty("app_version", r109.f269576a.f269578b);     // Catch: Throwable -> L136
        r119.addProperty("device_id", r109.f269576a.f269579c);     // Catch: Throwable -> L136
        r119.addProperty("os", 0);     // Catch: Throwable -> L136
        r115.add("common", r119);     // Catch: Throwable -> L136
        r116.addProperty("local_version", 0);     // Catch: Throwable -> L136
        r116.addProperty("channel", "_jsb_auth");     // Catch: Throwable -> L136
        r118.add(r116);     // Catch: Throwable -> L136
        r117.add(r114, r118);     // Catch: Throwable -> L136
        r115.add("deployment", r117);     // Catch: Throwable -> L136
        r113.requesAuthInfo(r115).enqueue(new g(r107, r114));     // Catch: Throwable -> L136
        goto L164
    L134:
        r107.f563230b = false;     // Catch: Throwable -> L136
        Logger.f269563c.getClass();     // Catch: Throwable -> L136
        Logger.b();     // Catch: Throwable -> L136
    L136:
        th = th;
    L137:
        r107.f563230b = false;
        Logger r120 = Logger.f269563c;
        th.getMessage();
        r120.getClass();
        Logger.b();
        JSONObject r121 = new JSONObject();
        JsonUtils.optPut(r121, "auth_error_time_cost", Long.valueOf(System.currentTimeMillis() - r112));
        JSONObject r122 = new JSONObject();
        JsonUtils.optPut(r122, "error_msg", "auth 请求异常: " + th.getMessage());
        JsonUtils.optPut(r122, "error_code", 1);
        JsonUtils.optPut(r122, r111, "requestAuth");
        int r123 = fd7.a.f476541a;
        fd7.a.b(1, "requestAuth", r121, r122);
    L130:
        th = th;
        r110 = r110;
        r111 = "event_type";
        goto L137
    L149:
        return true;
    L151:
        return a(r210, r211);
    L5:
        d r124 = d.a.f269571a;
        r124.getClass();
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        Map<String, List<vc7.a>> r125 = r124.f269570b.f554126a;
        this.f269573b = r125;
        if (r124.f269569a == true) goto L15;
    L100:
        r101 = NewPrivilegeAuthResult.EXCEPTION_AUTH_RULE_EMPTY;
        r111 = r18;
        goto L101
    L15:
        if (((ConcurrentHashMap) r125).isEmpty() == true) goto L100;
        if ((r210 instanceof String) == false) goto L100;
        String r126 = (String) r210;
        if (TextUtils.isEmpty(r126) == false) goto L22;
        r101 = NewPrivilegeAuthResult.EXCEPTION_EMPTY_URL;
        goto L101
    L22:
        if (TextUtils.isEmpty(null) == true) goto L27;
        if (r126.startsWith(null) == false) goto L27;
        r101 = NewPrivilegeAuthResult.TRUE;
    L27:
        if (TextUtils.isEmpty(r126) == false) goto L30;
    L34:
        boolean r127 = false;
    L36:
        if (r127 == true) goto L156;
        r101 = NewPrivilegeAuthResult.EXCEPTION_NOT_HTTP;
        goto L101
    L156:
    L93:
        e = move-exception;
        e.printStackTrace();
        JSONObject r128 = new JSONObject();
        JSONObject r129 = new JSONObject();
        r128.put("error_msg", "exception : " + e.getMessage());     // Catch: JSONException -> L97
        r128.put("error_code", 3);     // Catch: JSONException -> L97
        r128.put("event_type", "newAuth");     // Catch: JSONException -> L97
    L99:
        int r130 = fd7.a.f476541a;
        fd7.a.b(3, "newAuth", r129, r128);
        r101 = NewPrivilegeAuthResult.EXCEPTION_RUNTIME;
    L97:
        e = move-exception;
        e.printStackTrace();
        goto L99
    L39:
        if (Build.VERSION.SDK_INT >= 27) goto L44;
        int r131 = r126.indexOf(92);     // Catch: RuntimeException -> L93
        if (r131 != (-1)) goto L43;
        String r132 = UriProtector.parse(r126).getHost();     // Catch: RuntimeException -> L93
    L45:
        String r133 = r132;
        Logger.f269563c.getClass();     // Catch: RuntimeException -> L93
        Logger.a();     // Catch: RuntimeException -> L93
        if (TextUtils.isEmpty(r133) == false) goto L48;
        r101 = NewPrivilegeAuthResult.EXCEPTION_PARSE_HOST_ERROR;     // Catch: RuntimeException -> L93
        goto L101
    L48:
        String r134 = r211.getBridgeMethodName();     // Catch: RuntimeException -> L93
        String r135 = r211.getMethodPrivilege();     // Catch: RuntimeException -> L93
        if (TextUtils.isEmpty(r134) == false) goto L58;
        JSONObject r136 = new JSONObject();     // Catch: RuntimeException -> L93
        r136.put("error_msg", "newJsAuth error, bridgeName is empty");     // Catch: JSONException -> L54 RuntimeException -> L93
        r136.put("bridge_name", "bridgeName is empty");     // Catch: JSONException -> L54 RuntimeException -> L93
        r136.put("error_code", 1);     // Catch: JSONException -> L54 RuntimeException -> L93
        r136.put("event_type", "newAuth");     // Catch: JSONException -> L54 RuntimeException -> L93
    L56:
        int r137 = fd7.a.f476541a;     // Catch: RuntimeException -> L93
        fd7.a.b(1, "newAuth", null, r136);     // Catch: RuntimeException -> L93
        r101 = NewPrivilegeAuthResult.EXCEPTION_BRIDGE_NAME_EMPTY;     // Catch: RuntimeException -> L93
        goto L101
    L54:
        e = move-exception;
        e.printStackTrace();     // Catch: RuntimeException -> L93
        goto L56
    L58:
        if (TextUtils.isEmpty(r135) == false) goto L162;
        JSONObject r138 = new JSONObject();     // Catch: RuntimeException -> L93
        r138.put("error_msg", "bridgePrivilege is empty");     // Catch: JSONException -> L62 RuntimeException -> L93
        r138.put("bridge_name", r134);     // Catch: JSONException -> L62 RuntimeException -> L93
        r138.put("error_code", 2);     // Catch: JSONException -> L62 RuntimeException -> L93
        r138.put("event_type", "newAuth");     // Catch: JSONException -> L62 RuntimeException -> L93
    L64:
        int r139 = fd7.a.f476541a;     // Catch: RuntimeException -> L93
        fd7.a.b(2, "newAuth", null, r138);     // Catch: RuntimeException -> L93
        r101 = NewPrivilegeAuthResult.EXCEPTION_BRIDGE_PRIVILEGE_EMPTY;     // Catch: RuntimeException -> L93
        goto L101
    L62:
        e = move-exception;
        e.printStackTrace();     // Catch: RuntimeException -> L93
        goto L64
    L162:
    L70:
        e = move-exception;
        e.printStackTrace();     // Catch: RuntimeException -> L93
    L72:
        this.f269573b = r124.f269570b.f554126a;     // Catch: RuntimeException -> L93
        String[] r140 = r133.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: RuntimeException -> L93
        if (r140 != null) goto L76;
    L78:
        String r141 = r133;
    L79:
        List r142 = (List) ((ConcurrentHashMap) this.f269573b).get(r141);     // Catch: RuntimeException -> L93
        if (r142 == null) goto L82;
        r101 = e(r126, r134, r135, r142);     // Catch: RuntimeException -> L93
        goto L101
    L82:
        ?? r143 = ((ConcurrentHashMap) this.f269573b).entrySet().iterator();     // Catch: RuntimeException -> L93
    L84:
        if (r143.hasNext() == false) goto L100;
        Map.Entry r144 = (Map.Entry) r143.next();     // Catch: RuntimeException -> L93
        String r145 = (String) r144.getKey();     // Catch: RuntimeException -> L93
        ?? r146 = TextUtils.equals(r133, r145);     // Catch: RuntimeException -> L93
        if (r146 != 0) goto L91;
        r146 = r143;
        if (r133.endsWith("." + r145) == true) goto L91;
        r143 = r146;
        ?? r147 = r146;
    L91:
        r101 = e(r126, r134, r135, (List) r144.getValue());     // Catch: RuntimeException -> L93
        r111 = r146;
        goto L101
    L76:
        if (r140.length <= 1) goto L78;
        StringBuilder r148 = new StringBuilder();     // Catch: RuntimeException -> L93
        r148.append(r140[r140.length - 2]);     // Catch: RuntimeException -> L93
        r148.append(".");     // Catch: RuntimeException -> L93
        r147 = -1;
        r111 = -1;
        r148.append(r140[r140.length - 1]);     // Catch: RuntimeException -> L93
        r141 = r148.toString();     // Catch: RuntimeException -> L93
        goto L79
    L67:
        if (((ConcurrentHashMap) r124.f269570b.f554126a).isEmpty() == false) goto L72;
        r124.b();     // Catch: Exception -> L70
    L43:
        r132 = UriProtector.parse(r126.substring(0, r131)).getHost();     // Catch: RuntimeException -> L93
        goto L45
    L44:
        r132 = UriProtector.parse(r126).getHost();     // Catch: RuntimeException -> L93
        goto L45
    L30:
        if (r126.startsWith("http://") == false) goto L32;
    L35:
        r127 = true;
        goto L36
    L32:
        if (r126.startsWith("https://") == false) goto L34;
    L7:
        if (((ConcurrentHashMap) r124.f269570b.f554126a).isEmpty() == false) goto L12;
        r124.b();     // Catch: Exception -> L10
        goto L12
    }

    public static NewPrivilegeAuthResult e(String r100, String r101, String r110, List r111) {
        List r102 = new ArrayList();
        List r103 = new ArrayList();
        boolean r104 = false;
        if (r111 != null) goto L5;
    L20:
        String r105 = "";
    L22:
        if (TextUtils.isEmpty(r105) == false) goto L24;
    L50:
        if (r104 == false) goto L54;
        return NewPrivilegeAuthResult.TRUE;
    L54:
        return NewPrivilegeAuthResult.FALSE;
    L24:
        if (TextUtils.isEmpty(r110) == false) goto L26;
    L31:
        boolean r106 = false;
    L32:
        if (r106 == false) goto L40;
        if (r103.contains(r101) == true) goto L50;
        if (BridgeManager.INSTANCE.getBridgeConfig().isIgnoreNameSpace().booleanValue() == false) goto L49;
        boolean r107 = b(r103, c(r101));
    L42:
        r104 = true ^ r107;
    L49:
        r104 = true;
        goto L50
    L40:
        if (r102.contains(r101) == false) goto L44;
        r107 = r103.contains(r101);
        goto L42
    L44:
        if (BridgeManager.INSTANCE.getBridgeConfig().isIgnoreNameSpace().booleanValue() == false) goto L50;
        String r108 = c(r101);
        if (b(r102, r108) == false) goto L50;
        if (b(r103, r108) == true) goto L50;
    L26:
        if (TextUtils.isEmpty(r105) == true) goto L31;
        int r112 = d(r110);
        if (d(r105) < r112) goto L31;
        r106 = true;
        goto L32
    L5:
        if (r111.size() <= 0) goto L20;
        Iterator r113 = r111.iterator();
    L8:
        if (r113.hasNext() == false) goto L20;
        vc7.a r109 = (vc7.a) r113.next();
        if (r109 == null) goto L8;
        Matcher r114 = PatternProtector.compile(r109.f554122a).matcher(r100);
    L13:
        if (r114.find() == false) goto L17;
        Logger r115 = Logger.f269563c;
        r114.group();
        r114.start();
        r115.getClass();
        Logger.a();
        if (r114.start() != 0) goto L13;
        boolean r116 = true;
    L18:
        if (r116 == false) goto L8;
        r105 = r109.f554123b;
        r102 = r109.f554124c;
        r103 = r109.f554125d;
        goto L22
    L17:
        r116 = false;
        goto L18
    }
}
