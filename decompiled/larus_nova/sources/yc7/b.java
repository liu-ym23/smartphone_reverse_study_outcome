package yc7;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.bridge.BridgeConfig;
import com.bytedance.sdk.bridge.BridgeManager;
import com.bytedance.sdk.bridge.Logger;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.bytedance.sdk.bridge.js.JsBridgeManager;
import com.bytedance.sdk.bridge.js.spec.IFlutterInterceptorListener;
import com.bytedance.sdk.bridge.js.spec.JsBridgeContext;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.services.apm.api.IApmAgent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f567209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f567210b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f567211c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f567212d = "event";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WeakHashMap<WebView, cd7.c> f567213e = null;

    public static final class a<T> implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f567214a;

        public a(ad7.b r100, String r101) {
            this.f567214a = r101;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r100) {
            String r101 = r100;
            Logger.f269563c.getClass();
            Logger.a();
            if (TextUtils.isEmpty(r101) == false) goto L5;
            return;
        L5:
            if (TextUtils.equals("null", r101) == true) goto L9;
            JSONObject r102 = new JSONObject();
            r102.put("error_msg", r101);
            r102.put("error_url", this.f567214a);
            r102.put("error_code", 2);
            r102.put("event_type", "loadUrl");
            JSONObject r103 = new JSONObject();
            int r104 = fd7.a.f476541a;
            fd7.a.b(2, "loadUrl", r103, r102);
            return;
        }
    }

    /* JADX INFO: renamed from: yc7.b$b, reason: collision with other inner class name */
    public static final class RunnableC8327b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f567215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cd7.a f567216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f567217c;

        public RunnableC8327b(Ref.ObjectRef r100, cd7.a r101, Object r102) {
            this.f567215a = r100;
            this.f567216b = r101;
            this.f567217c = r102;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
        @Override // java.lang.Runnable
        public final void run() {
            Ref.ObjectRef r100 = this.f567215a;     // Catch: Throwable -> L10
            r100.element = this.f567216b.getUrl();     // Catch: Throwable -> L10
            Object r101 = this.f567217c;     // Catch: Throwable -> L10
            monitor-enter(r101);     // Catch: Throwable -> L10
            this.f567217c.notify();     // Catch: Throwable -> L7
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cd7.a f567218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f567219b;

        public c(cd7.a r100, String r101, ad7.b r102) {
            this.f567218a = r100;
            this.f567219b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = b.f567209a;     // Catch: Throwable -> L4
            b.c(this.f567218a, this.f567219b, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b() {
    }

    static {
        BridgeConfig r100 = BridgeManager.INSTANCE.getBridgeConfig();
        if (r100 == null) goto L7;
        String r101 = r100.getSchema();
        if (r101 == null) goto L7;
    L8:
        String r102 = r101.concat("://");
        f567209a = r102 + "dispatch_message/";
        f567210b = r102 + "private/setresult/";
        f567211c = new Handler(Looper.getMainLooper());
        f567212d = "event";
        f567213e = new WeakHashMap();
        return;
    L7:
        r101 = "nativeapp";
        goto L8
    }

    public static cd7.c a(WebView r100) {
        cd7.c r101 = f567213e.get(r100);     // Catch: Exception -> L5
    L13:
        if ((r101 instanceof cd7.c) == false) goto L15;
        Logger.f269563c.getClass();
        Logger.a();
        return r101;
    L15:
        Logger.f269563c.getClass();
        Logger.a();
        cd7.c r102 = new cd7.c(r100);
        f567213e.put(r100, r102);
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r104.put("error_msg", "getWebViewWrapper exception " + Log.getStackTraceString(e));     // Catch: JSONException -> L9
        r104.put("error_code", 1);     // Catch: JSONException -> L9
        r104.put("event_type", "getWebViewWrapper");     // Catch: JSONException -> L9
    L11:
        int r105 = fd7.a.f476541a;
        fd7.a.b(1, "getWebViewWrapper", r103, r104);
        r101 = null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static List h(cd7.a r110, String r111) {
        int r100 = 0;
        if (StringsKt.startsWith$default(r111, f567209a, false, 2, null) == false) goto L6;
        c(r110, "javascript:if(window.JSBridge && window.JSBridge._fetchQueue){ JSBridge._fetchQueue()} else if (window.Native2JSBridge && window.Native2JSBridge._fetchQueue){Native2JSBridge._fetchQueue()}", null);
        return null;
    L6:
        String r112 = f567210b;
        if (StringsKt.startsWith$default(r111, r112, false, 2, null) == false) goto L32;
        int r113 = r112.length();
        int r101 = StringsKt.indexOf$default(r111, Typography.amp, r113, false, 4, null);
        if (r101 <= 0) goto L43;
        if (r111 == null) goto L31;
        String r114 = r111.substring(r113, r101);
        String r115 = r111.substring(r101 + 1);
        if (Intrinsics.areEqual(r114, "SCENE_FETCHQUEUE") == true) goto L15;
        return null;
    L15:
        if (r115.length() <= 0) goto L41;
        JSONArray r116 = new JSONArray(new String(Base64.decode(r115, 2), Charsets.UTF_8));     // Catch: Exception -> L28
        int r117 = r116.length();     // Catch: Exception -> L28
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L28
    L17:
        if (r100 >= r117) goto L42;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r116, r100);     // Catch: Exception -> L28
        String r104 = r103.optString("func");     // Catch: Exception -> L28
        String r105 = r103.optString("__msg_type");     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r105) == true) goto L26;
        if (Intrinsics.areEqual(f567212d, r105) == true) goto L26;
        if (TextUtils.isEmpty(r104) == true) goto L26;
        r102.add(new yc7.c(r103, r104));     // Catch: Exception -> L28
    L26:
        r100 = r100 + 1;
        goto L17
    L42:
        return r102;
    L29:
        return null;
    L41:
        return null;
    L31:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L43:
        return null;
    L32:
        return null;
    }

    public static boolean b(cd7.a r110, String r111, Lifecycle r112) {
        Logger.f269563c.getClass();
        Logger.a();
    L28:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (StringsKt.startsWith$default(r111, f567209a, false, 2, null) == false) goto L6;
    L9:
        boolean r100 = true;
    L10:
        if (r100 == true) goto L12;
        return false;
    L12:
        List r113 = h(r110, r111);     // Catch: Exception -> L28
        if (r113 == null) goto L27;
        Iterator r114 = r113.iterator();     // Catch: Exception -> L28
    L15:
        if (r114.hasNext() == false) goto L27;
        yc7.c r101 = (yc7.c) r114.next();     // Catch: Exception -> L28
        if (r101.f567222c == null) goto L15;
        Logger.f269563c.getClass();     // Catch: Exception -> L28
        Logger.a();     // Catch: Exception -> L28
        LinkedBlockingDeque<e> r102 = f.f567230a;     // Catch: Exception -> L28
        if (f.a(r101.f567222c, r101.f567223d, new JsBridgeContext(r110, r101.f567221b, null, 4, null)) == true) goto L15;
        wc7.a r103 = wc7.a.f559179h;     // Catch: Exception -> L28
        String r104 = r101.f567222c;     // Catch: Exception -> L28
        if (r104 != null) goto L25;
        Intrinsics.throwNpe();     // Catch: Exception -> L28
    L25:
        r103.call(r104, r101.f567223d, new JsBridgeContext(r110, r101.f567221b, null, 4, null), r112);     // Catch: Exception -> L28
    L27:
        return true;
    L6:
        if (StringsKt.startsWith$default(r111, f567210b, false, 2, null) == true) goto L9;
        r100 = false;
        goto L10
    }

    public static void c(cd7.a r100, String r101, ad7.b r102) {
    L8:
        th = move-exception;
        if ((th instanceof IllegalStateException) == true) goto L13;
        th.printStackTrace();
    L13:
        th.printStackTrace();
        String r103 = Unit.INSTANCE.toString();
        boolean r104 = false;
    L14:
        if (r104 == false) goto L26;
    L19:
        if (r104 == true) goto L23;
        if (r102 == null) goto L22;
        r102.a();
    L22:
        JSONObject r105 = new JSONObject();
        r105.put("error_msg", "js loadUrl error, url =  " + r101 + " , errMsg = " + r103);
        r105.put("error_url", r101);
        r105.put("error_code", 1);
        r105.put("event_type", "loadUrl");
        JSONObject r106 = new JSONObject();
        int r107 = fd7.a.f476541a;
        fd7.a.b(1, "loadUrl", r106, r105);
        return;
    L23:
        if (r102 == null) goto L30;
        r102.a();
        return;
    L30:
        return;
    L26:
        r100.loadUrl(r101);     // Catch: Throwable -> L17
        r104 = true;
    L17:
        th = move-exception;
        th.printStackTrace();
        th.printStackTrace();
        r103 = Unit.INSTANCE.toString();
        goto L19
    L4:
        if ((r100 instanceof cd7.c) == false) goto L6;
        r100.b(r101, new a(r102, r101));     // Catch: Throwable -> L8
    L7:
        r103 = "";
        r104 = true;
        goto L14
    L6:
        r100.b(r101, null);     // Catch: Throwable -> L8
        goto L7
    }

    public static boolean d(yc7.c r100, JsBridgeContext r101, Lifecycle r102) {
        com.bytedance.sdk.bridge.e.d();
        if (r100.f567222c == null) goto L17;
        Logger.f269563c.getClass();
        Logger.a();
        LinkedBlockingDeque<e> r103 = f.f567230a;
        if (f.a(r100.f567222c, r100.f567223d, r101) == false) goto L7;
        return true;
    L7:
        wc7.a r104 = wc7.a.f559179h;
        String r105 = r100.f567222c;
        Object r106 = r101.getWebView();
        if (r106 != null) goto L12;
        r106 = r101.getIWebView();
    L12:
        if (wc7.a.d(r105, r106, r102) != null) goto L15;
        JSONObject r107 = new JSONObject();
        r107.put("error_msg", "old js call bridgeInfo == null is true");
        r107.put("error_code", 1);
        r107.put("event_type", "oldJsCall");
        int r108 = fd7.a.f476541a;
        r107.put("extra_params", fd7.a.a(r100.f567222c, r100.f567223d));
        fd7.a.b(1, "oldJsCall", new JSONObject(), r107);
        r101.callback(BridgeResult.Companion.createMethodNotFoundResult$default(BridgeResult.Companion, null, null, 3, null));
        return false;
    L15:
        r104.call(r100.f567222c, r100.f567223d, r101, r102);
        return true;
    L17:
        r101.callback(BridgeResult.Companion.createErrorResult$default(BridgeResult.Companion, "request.function == null", null, 2, null));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.lang.Object, java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.lang.Object, java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v28 */
    public static BridgeResult e(cd7.a r210, yc7.c r211, Lifecycle r212) {
        Object r100 = new Object();
        if (r211.f567222c == null) goto L96;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = r211.f567224e;
        wc7.a.f559178g.postAtFrontOfQueue(new RunnableC8327b(r101, r210, r100));
        monitor-enter(r100);
        r100.wait(3000);     // Catch: Throwable -> L92
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L92
        monitor-exit(r100);
        if (TextUtils.isEmpty((String) r101.element) == true) goto L12;
        ConcurrentHashMap<String, List<ed7.a>> r103 = wc7.a.f559172a;
        String r104 = r211.f567222c;
        if (r104 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        JSONObject r105 = r211.f567223d;
        String r106 = r211.f567221b;
        String r107 = (String) r101.element;
        if (r107 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        JsBridgeContext r108 = new JsBridgeContext(r210, r106, r107);
        long r109 = System.currentTimeMillis();
        Object r110 = r108.getWebView();
        if (r110 != null) goto L23;
        r110 = r108.getIWebView();
    L23:
        ed7.a r111 = wc7.a.d(r104, r110, r212);
        WebView r112 = r108.getWebView();
        if (r112 == null) goto L28;
        String r113 = r112.getUrl();
        if (r113 == null) goto L28;
    L29:
        Activity r114 = r108.getActivity();
        if (r111 != null) goto L53;
        JsBridgeManager r115 = JsBridgeManager.INSTANCE;
        r115.getJsBridgeMessageHandler();
        JSONObject r116 = new JSONObject();
        if (r113 == null) goto L34;
        r116.put("error_url", "webPageUrl =  ".concat(r113));
    L34:
        r116.put("error_msg", "js call error with method not found, bridgeName =  " + r104);
        r116.put("bridge_name", r104);
        r116.put("is_sync", 1);
        int r117 = 5;
        r116.put("error_code", 5);
        r116.put("event_type", "jsCallSync");
        int r118 = fd7.a.f476541a;
        r116.put("extra_params", fd7.a.a(r104, r105));
        JSONObject r119 = new JSONObject();
        r119.put("js_callSync_not_found_time_cost", System.currentTimeMillis() - r109);
        fd7.a.b(5, "jsCallSync", r119, r116);
        IFlutterInterceptorListener r120 = r115.getFlutterInterceptorListener();
        if (r120 == null) goto L50;
        WebView r121 = r108.getWebView();
        if (r121 != null) goto L39;
        int r122 = 3;
        ?? r123 = 0;
    L47:
        BridgeResult r124 = BridgeResult.Companion.createMethodNotFoundResult$default(BridgeResult.Companion, r123, r123, r122, r123);
    L48:
        if (r124 != null) goto L52;
    L51:
        r124 = BridgeResult.Companion.createMethodNotFoundResult$default(BridgeResult.Companion, r123, r123, r122, r123);
    L52:
        long r125 = r109;
    L87:
        if (BridgeManager.INSTANCE.getBridgeConfig().jsCallSuccessCostEnable().booleanValue() == false) goto L91;
        JSONObject r126 = new JSONObject();
        r126.put(r104 + "_js_callSync_success_time_cost", System.currentTimeMillis() - r125);
        JSONObject r127 = new JSONObject();
        r127.put("jsCallSync", r117);
        r127.put("bridge_name", r104);
        int r128 = fd7.a.f476541a;
        JSONObject r129 = new JSONObject();
        IApmAgent r130 = (IApmAgent) ServiceManager.getService(IApmAgent.class);
        if (r130 == null) goto L91;
        r130.monitorEvent("component_bridge_sdk_monitor_success", r127, r126, r129);
    L91:
        return r124;
    L39:
        if (r120.isInterceptor() == true) goto L41;
    L43:
        r122 = 3;
        r123 = 0;
        r124 = BridgeResult.Companion.createMethodNotFoundResult$default(BridgeResult.Companion, null, null, 3, null);
    L44:
        if (r124 == null) goto L47;
    L41:
        if (r120.isFlutterWebView(r121) == false) goto L43;
        r124 = r120.callSync(r104, r105, r108);
        r122 = 3;
        r123 = 0;
        goto L44
    L50:
        r122 = 3;
        r123 = 0;
        goto L51
    L53:
        ConcurrentHashMap<String, CopyOnWriteArrayList<ed7.a>> r131 = com.bytedance.sdk.bridge.e.f269587a;
        BridgeResult r132 = com.bytedance.sdk.bridge.e.a(r105, r111.f472224b.getParamInfos());
        r125 = r109;
        if (r132 == null) goto L62;
        JSONObject r133 = new JSONObject();
        if (r113 == null) goto L58;
        r133.put("error_url", "webPageUrl =  ".concat(r113));
    L58:
        if (r114 == null) goto L60;
        r133.put("error_activity", "activity = " + r114.getPackageName());
    L60:
        r133.put("error_msg", "js call error with no params, bridgeName =  " + r104);
        r133.put("bridge_name", r104);
        r133.put("is_sync", 1);
        r117 = 6;
        r133.put("error_code", 6);
        r133.put("event_type", "jsCallSync");
        int r134 = fd7.a.f476541a;
        r133.put("extra_params", fd7.a.a(r104, r105));
        JSONObject r135 = new JSONObject();
        r135.put("js_callSync_no_params_time_cost", System.currentTimeMillis() - r125);
        fd7.a.b(6, "jsCallSync", r135, r133);
        r124 = r132;
        goto L87
    L62:
        if (BridgeSyncType.SYNC.equals(r111.f472224b.getSyncType()) == true) goto L70;
        JSONObject r136 = new JSONObject();
        if (r113 == null) goto L66;
        r136.put("error_url", "webPageUrl =  ".concat(r113));
    L66:
        if (r114 == null) goto L68;
        r136.put("error_activity", "activity = " + r114.getPackageName());
    L68:
        r136.put("error_msg", "js callSync the method does not support synchronous calls, bridgeName =  " + r104);
        r136.put("bridge_name", r104);
        r136.put("is_sync", 1);
        r136.put("error_code", 2);
        r136.put("event_type", "jsCallSync");
        int r137 = fd7.a.f476541a;
        r136.put("extra_params", fd7.a.a(r104, r105));
        JSONObject r138 = new JSONObject();
        r138.put("js_callSync_not_support_sync_time_cost", System.currentTimeMillis() - r125);
        fd7.a.b(2, "jsCallSync", r138, r136);
        r124 = BridgeResult.Companion.createMethodNotFoundResult$default(BridgeResult.Companion, "The method does not support synchronous calls", null, 2, null);
        r117 = 2;
        goto L87
    L70:
        if (wc7.a.a(r108, r111.f472224b) == true) goto L77;
        JSONObject r139 = new JSONObject();
        if (r113 == null) goto L74;
        r139.put("error_url", "webPageUrl =  ".concat(r113));
    L74:
        if (r114 == null) goto L76;
        r139.put("error_activity", "activity = " + r114.getPackageName());
    L76:
        r139.put("error_msg", "js callSync error with no privilege, bridgeName =  " + r104);
        r139.put("bridge_name", r104);
        r139.put("is_sync", 1);
        r139.put("error_code", 3);
        r139.put("event_type", "jsCallSync");
        int r140 = fd7.a.f476541a;
        r139.put("extra_params", fd7.a.a(r104, r105));
        JSONObject r141 = new JSONObject();
        r141.put("js_callSync_no_privilege_time_cost", System.currentTimeMillis() - r125);
        r117 = 3;
        fd7.a.b(3, "jsCallSync", r141, r139);
        r124 = BridgeResult.Companion.createNoPrivilegeResult$default(BridgeResult.Companion, null, null, 3, null);
        goto L87
    L77:
        BridgeResult r142 = com.bytedance.sdk.bridge.e.f(r111, r105, r108);
        if (r142 != null) goto L85;
        JSONObject r143 = new JSONObject();
        if (r113 == null) goto L82;
        r143.put("error_url", "webPageUrl =  ".concat(r113));
    L82:
        if (r114 == null) goto L84;
        r143.put("error_activity", "activity = " + r114.getPackageName());
    L84:
        r143.put("error_msg", "js callSync error with null, bridgeName =  " + r104);
        r143.put("bridge_name", r104);
        r143.put("is_sync", 1);
        r143.put("error_code", 4);
        r143.put("event_type", "jsCallSync");
        int r144 = fd7.a.f476541a;
        r143.put("extra_params", fd7.a.a(r104, r105));
        JSONObject r145 = new JSONObject();
        r145.put("js_callSync_null_time_cost", System.currentTimeMillis() - r125);
        fd7.a.b(4, "jsCallSync", r145, r143);
        r124 = BridgeResult.Companion.createErrorResult$default(BridgeResult.Companion, "js callSync error with result null", null, 2, null);
        r117 = 4;
        goto L87
    L85:
        r117 = 0;
        r124 = r142;
    L28:
        r113 = r108.getUri();
        goto L29
    L12:
        return BridgeResult.Companion.createErrorResult$default(BridgeResult.Companion, "param currentUrl must not be null in sync-call.", null, 2, null);
    L92:
        th = move-exception;
        throw th;
    L96:
        return BridgeResult.Companion.createErrorResult$default(BridgeResult.Companion, "param functionName is null.", null, 2, null);
    }

    public static void g(cd7.a r100, JSONObject r101, ad7.b r102) {
        String r103 = "javascript:if(window.JSBridge && window.JSBridge._handleMessageFromApp){ window.JSBridge && window.JSBridge._handleMessageFromApp(" + r101 + ")} else if(window.Native2JSBridge && window.Native2JSBridge._handleMessageFromApp){ window.Native2JSBridge && window.Native2JSBridge._handleMessageFromApp(" + r101 + ")}";
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        c(r100, r103, r102);
        return;
    L10:
        f567211c.post(new c(r100, r103, r102));
        return;
    L5:
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L7;
        r104 = true;
        goto L8
    }

    public static void f(String r100, JSONObject r101, cd7.a r102, boolean r103, ad7.b r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L12
        if (r103 == false) goto L6;
        r105.put("__msg_type", "event");     // Catch: Exception -> L12
        r105.put("__event_id", r100);     // Catch: Exception -> L12
    L7:
        r105.put("__callback_id", r100);     // Catch: Exception -> L12
        if (r101 == null) goto L10;
        r105.put("__params", r101);     // Catch: Exception -> L12
    L10:
        g(r102, r105, r104);     // Catch: Exception -> L12
        return;
    L6:
        r105.put("__msg_type", "callback");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        if (r104 == null) goto L19;
        e.toString();
        r104.a();
        return;
    }
}
