package ovc;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static CronetEngine f526990o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile String f526991p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f526992q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile AtomicInteger f526993r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile int f526994s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsChannelClient f526995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f526996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f526997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f526998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f526999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f527000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Boolean> f527001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CronetFrontierClient f527002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f527003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f527004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f527005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TTWebsocketConnection f527006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f527007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ovc.b f527008n;

    /* JADX INFO: renamed from: ovc.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes42.dex */
    public final class C7120a extends com.bytedance.frameworks.baselib.network.http.util.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f527009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f527010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f527011d;

        public final void a() {
            if (a.c(this.f527011d) == false) goto L6;
            this.f527011d.f526998d.set(0);
            this.f527011d.f527003i.set(false);
            return;
        L6:
            int r100 = this.f527011d.f526998d.incrementAndGet();
            if (Logger.debug() == false) goto L9;
            Logger.d("CronetFrontierConnection", "Fallback to websocket connection, retry attempts:" + r100);
        L9:
            this.f527011d.d();
            this.f527011d.g(this.f527009b, this.f527010c);
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L12
            r101.put("retry_attempts", r100);     // Catch: JSONException -> L12
            r101.put("reason", "connect timeout fallback");     // Catch: JSONException -> L12
            a.b(this.f527011d, r101);     // Catch: JSONException -> L12
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C7120a(a r100, long r101, Map<String, Object> r102, List<String> r103) {
            this.f527011d = r100;
            super(r101, a.f526992q);
            this.f527009b = r102;
            this.f527010c = r103;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class b implements CronetFrontierClient.IServiceMessageReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527012a;

        public b(a r100) {
            this.f527012a = r100;
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public final void onServiceReady(int r100, String r101) {
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetFrontierConnection", "onServiceReady ServiceId:" + r100 + " log info:" + r101);
        L6:
            if (this.f527012a.f527005k == true) goto L16;
            this.f527012a.f527005k = true;
            a r102 = this.f527012a;
            if (r102.f527002h == null) goto L16;
            if (r102.f527004j == (-1)) goto L16;
            a r103 = this.f527012a;
            CronetFrontierClient r104 = r103.f527002h;
            if (r103.f527004j != 1) goto L14;
            boolean r105 = true;
        L15:
            r104.reportAppStateChange(r105);
            goto L16
        L14:
            r105 = false;
        L16:
            ((ConcurrentHashMap) this.f527012a.f527001g).put(Integer.valueOf(r100), Boolean.TRUE);
            if (this.f527012a.f527003i.get() == true) goto L19;
        L24:
            this.f527012a.f526995a.onServiceConnectEvent(r100, true, "");
            return;
        L19:
            if (a.c(this.f527012a) == false) goto L24;
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L26
            r106.put("type", 1);     // Catch: Throwable -> L26
            r106.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L26
            r106.put("state", 4);     // Catch: Throwable -> L26
            r106.put("url", a.f526991p);     // Catch: Throwable -> L26
            if (Logger.debug() == false) goto L23;
            Logger.d("CronetFrontierConnection", "PP onConnectionStateChanged state: 4 url:" + a.f526991p);     // Catch: Throwable -> L26
        L23:
            this.f527012a.f526995a.onConnection(r106);     // Catch: Throwable -> L26
            goto L24
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public final void onError(int r100, int r101, String r102) {
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetFrontierConnection", "onError ServiceId:" + r100 + " error code:" + r101 + " info:" + r102);
        L5:
            this.f527012a.f526995a.onServiceConnectEvent(r100, false, "");
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public final void onReceivedMessage(int r100, Map<String, String> r101, byte[] r102) {
            if (this.f527012a.f526997c.get() == false) goto L10;
            if (Logger.debug() == false) goto L7;
            Logger.d("CronetFrontierConnection", "proxy onReceivedMessage service id:" + r100 + " data length:" + r102.length);
        L7:
            this.f527012a.f526995a.onMessage(r102);
            return;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.d("CronetFrontierConnection", "onReceivedMessage service id:" + r100 + " data length:" + r102.length);
        L12:
            WsChannelMsg r103 = new WsChannelMsg();
            r103.setService(r100);
            ArrayList r104 = new ArrayList();
            Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
        L14:
            if (r105.hasNext() == false) goto L39;
            Map.Entry<String, String> r106 = r105.next();
            if (TextUtils.isEmpty(r106.getKey()) == true) goto L14;
            if (TextUtils.isEmpty(r106.getValue()) == true) goto L14;
            if (r106.getKey().equals("method_id") == false) goto L27;
            r103.setMethod(CastIntegerProtector.valueOf(r106.getValue()).intValue());     // Catch: NumberFormatException -> L24
        L24:
            e = move-exception;
            Logger.e("CronetFrontierConnection", "method_id is not valid: " + r106.getValue());
            e.printStackTrace();
            goto L14
        L27:
            if (r106.getKey().equalsIgnoreCase("payload_encoding") == true) goto L28;
            if (r106.getKey().equalsIgnoreCase("payload_type") == true) goto L31;
            if (r106.getKey().equalsIgnoreCase("msg_id") == true) goto L34;
            if (r106.getKey().equalsIgnoreCase("server_timing") == true) goto L37;
            WsChannelMsg.MsgHeader r107 = new WsChannelMsg.MsgHeader();
            r107.setKey(r106.getKey());
            r107.setValue(r106.getValue());
            r104.add(r107);
            goto L14
        L37:
            r103.setServerTiming(r106.getValue());
            goto L14
        L34:
            r103.setMsgId(r106.getValue());
            goto L14
        L31:
            r103.setPayloadType(r106.getValue());
            goto L14
        L28:
            r103.setPayloadEncoding(r106.getValue());
            goto L14
        L39:
            r103.setMsgHeaders(r104);
            r103.setPayload(r102);
            if (r103.getPayloadEncoding() != null) goto L43;
            r103.setPayloadEncoding("");
        L43:
            if (r103.getPayloadType() != null) goto L46;
            r103.setPayloadType("");
        L46:
            if (Logger.debug() == false) goto L48;
            Logger.d("CronetFrontierConnection", "onReceivedMessage:" + r103);
        L48:
            this.f527012a.f526995a.onMessage(r103);
        }

        @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.IServiceMessageReceiver
        public final void onReceivedAck(int r100, long r101, String r102, Boolean r103) {
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetFrontierConnection", "onReceivedAck serviceId:" + r100 + " messageId:" + r101 + " logInfo:" + r102);
            return;
        }
    }

    public static Map e() {
        return (Map) a("com.bytedance.ttnet.clientkey.ClientKeyManager").getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void d() {
        TTWebsocketConnection r100 = this.f527006l;
        if (r100 == null) goto L5;
        r100.stopConnection();
        this.f527006l.destroyConnection();
    L5:
        CronetFrontierClient r101 = this.f527002h;
        if (r101 == null) goto L56;
        r101.destroy();
        if (com.bytedance.frameworks.baselib.network.http.util.a.f244764d == null) goto L10;
    L19:
        com.bytedance.frameworks.baselib.network.http.util.a r102 = com.bytedance.frameworks.baselib.network.http.util.a.f244764d;
        String r103 = f526992q;
        r102.getClass();
        if (TextUtils.isEmpty(r103) == false) goto L44;
    L40:
        this.f527003i.set(false);
        return;
    L44:
        Iterator<Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, Runnable>> r104 = r102.f244768c.entrySet().iterator();     // Catch: Throwable -> L38
    L24:
        if (r104.hasNext() == false) goto L28;
        com.bytedance.frameworks.baselib.network.http.util.b r105 = r104.next().getKey();     // Catch: Throwable -> L38
        if (r103.equals(r105.f244771a) == false) goto L24;
        r104.remove();     // Catch: Throwable -> L38
        r102.f244766a.remove(r105);     // Catch: Throwable -> L38
        goto L24
    L28:
        Iterator<Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, ScheduledFuture>> r106 = r102.f244767b.entrySet().iterator();     // Catch: Throwable -> L38
    L29:
        if (r106.hasNext() == false) goto L40;
        Map.Entry<com.bytedance.frameworks.baselib.network.http.util.b, ScheduledFuture> r107 = r106.next();     // Catch: Throwable -> L38
        if (r103.equals(r107.getKey().f244771a) == false) goto L29;
        ScheduledFuture r108 = r107.getValue();     // Catch: Throwable -> L38
        if (r108 == null) goto L36;
        r108.cancel(true);     // Catch: Throwable -> L38
    L36:
        r106.remove();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Logger.e(com.bytedance.frameworks.baselib.network.http.util.a.f244765e, "removeTask failed", th);
        goto L40
    L10:
        monitor-enter(com.bytedance.frameworks.baselib.network.http.util.a.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (com.bytedance.frameworks.baselib.network.http.util.a.f244764d != null) goto L14;
        com.bytedance.frameworks.baselib.network.http.util.a.f244764d = new com.bytedance.frameworks.baselib.network.http.util.a();     // Catch: Throwable -> L16
    L14:
        monitor-exit(com.bytedance.frameworks.baselib.network.http.util.a.class);     // Catch: Throwable -> L16
        goto L19
    }

    static {
        f526992q = UUID.randomUUID().toString();
        CronetFrontierClient.TransportMode r100 = CronetFrontierClient.TransportMode.UNKNOWN;
        f526993r = new AtomicInteger(0);
        f526994s = -1;
    }

    public a(IWsChannelClient r100) {
        this.f526996b = new AtomicBoolean(false);
        this.f526997c = new AtomicBoolean(false);
        this.f526998d = new AtomicInteger(0);
        this.f526999e = 10000;
        this.f527000f = 10000;
        this.f527001g = new ConcurrentHashMap();
        this.f527003i = new AtomicBoolean(false);
        this.f527004j = -1;
        this.f527005k = false;
        this.f526995a = r100;
        this.f527007m = new e(r100);
        Object r101 = a("com.bytedance.ttnet.TTNetInit").newInstance();     // Catch: Throwable -> L5
        Reflect.on(r101).call("getInitCompletedLatch");     // Catch: Throwable -> L5
        Reflect.on(r101).call("preInitCronetKernel");     // Catch: Throwable -> L5
    L9:
        f526990o = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d("CronetFrontierConnection", "TTNet init failed, cronet engine is null.");
        goto L9
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static boolean c(a r100) {
        if (((ConcurrentHashMap) r100.f527001g).isEmpty() == true) goto L16;
        Iterator r101 = ((ConcurrentHashMap) r100.f527001g).entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        if (((Boolean) ((Map.Entry) r101.next()).getValue()).booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    L16:
        return false;
    }

    public static String f(URI r100) {
        HashMap r101 = new HashMap();
        StringBuilder r102 = new StringBuilder();
        Map<String, List<String>> r103 = null;
        CookieHandler r104 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r104 == null) goto L6;
        r103 = r104.get(r100, r101);     // Catch: Exception -> L25
    L6:
        if (r103 == null) goto L24;
        if (r103.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r105 = r103.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r106 = r105.next();
        if (BaseHttpRequestInfo.KEY_COOKIE.equalsIgnoreCase(r106.getKey()) == false) goto L11;
        if (r106.getValue().isEmpty() == true) goto L11;
        Iterator<String> r107 = r106.getValue().iterator();
        int r108 = 0;
    L18:
        if (r107.hasNext() == false) goto L11;
        String r109 = r107.next();
        if (r108 <= 0) goto L22;
        r102.append("; ");
    L22:
        r102.append(r109);
        r108 = r108 + 1;
    L24:
        return r102.toString();
    L25:
        return null;
    }

    public static void b(a r100, JSONObject r101) throws JSONException {
        r100.getClass();
        r101.put("report_type", 1);
        r101.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetFrontierConnection", "report log:" + r101.toString());
    L5:
        org.chromium.c.h().k(r101.toString(), "private_protocol");
    }

    public final void g(Map<String, Object> r110, List<String> r111) {
        this.f526996b.set(false);
        this.f526997c.set(false);
        f526993r.incrementAndGet();
        Object r100 = r110.get("channel_id");
        if (r100 != null) goto L5;
        int r101 = -1;
    L7:
        if (f526994s != (-1)) goto L12;
        if (r101 <= 0) goto L12;
        if (f526993r.get() != 1) goto L12;
        f526994s = r101;
    L12:
        TTWebsocketConnection.Builder r102 = f526990o.newWebsocketConnectionBuilder(this.f527007m, PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CronetFrontierConnection")));
        r102.setUrlList(r111);     // Catch: Throwable -> L63
        r102.setAppKey(String.valueOf(r110.get("app_key")));     // Catch: Throwable -> L63
        r102.setFpid(((Integer) r110.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L63
        r102.setAppVersion(((Integer) r110.get("app_version")).intValue());     // Catch: Throwable -> L63
        r102.setAppId(((Integer) r110.get("aid")).intValue());     // Catch: Throwable -> L63
        r102.setDeviceId(CastLongProtector.parseLong((String) r110.get("device_id")));     // Catch: Throwable -> L63
        r102.setInstallId(CastLongProtector.parseLong((String) r110.get(WsConstants.KEY_INSTALL_ID)));     // Catch: Throwable -> L63
        r102.setSharedConnection(false);     // Catch: Throwable -> L63
        if (r110.containsKey(WsConstants.KEY_SESSION_ID) == false) goto L16;
        r102.setSessionId((String) r110.get(WsConstants.KEY_SESSION_ID));     // Catch: Throwable -> L63
    L16:
        String r112 = (String) r110.get("extra");     // Catch: Throwable -> L63
        HashMap r103 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r112) == true) goto L66;
        String[] r113 = r112.split("&");     // Catch: Throwable -> L63
        int r104 = r113.length;     // Catch: Throwable -> L63
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L66;
        String r106 = r113[r105];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r106) == true) goto L25;
        String[] r107 = r106.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L63
        if (r107.length != 2) goto L25;
        r103.put(r107[0], r107[1]);     // Catch: Throwable -> L63
    L25:
        r105 = r105 + 1;
    L66:
        HashMap r114 = new HashMap();     // Catch: Throwable -> L42
        Map r108 = e();     // Catch: Throwable -> L42
        if (Logger.debug() == false) goto L29;
        Logger.d("CronetFrontierConnection", "Client key: " + r108);     // Catch: Throwable -> L42
    L29:
        if (r108 != null) goto L31;
    L33:
        Map r115 = (Map) r110.get(WsConstants.KEY_HEADERS);     // Catch: Throwable -> L42
        if (r115 == null) goto L39;
        if (r115.isEmpty() == true) goto L39;
        r114.putAll(r115);     // Catch: Throwable -> L42
    L39:
        if (r114.isEmpty() == true) goto L44;
        r102.setCustomizedHeaders(r114);     // Catch: Throwable -> L42
    L44:
        ovc.b r116 = this.f527008n;     // Catch: Throwable -> L63
        if (r116 == null) goto L60;
        long r109 = 0;
        if (ovc.b.f527014e == true) goto L49;
        long r117 = 0;
    L51:
        if (r117 <= 0) goto L60;
        ovc.b r118 = this.f527008n;     // Catch: Throwable -> L63
        if (ovc.b.f527014e == true) goto L55;
        r118.getClass();     // Catch: Throwable -> L63
    L57:
        if (Logger.debug() == false) goto L59;
        Logger.d("CronetFrontierConnection", "WS destroy timeout:" + r109);     // Catch: Throwable -> L63
    L59:
        r103.put("ttnet_timeout_millis", String.valueOf(r109));     // Catch: Throwable -> L63
        goto L60
    L55:
        r109 = r118.f527015a;     // Catch: Throwable -> L63
        goto L57
    L49:
        r117 = r116.f527015a;     // Catch: Throwable -> L63
    L60:
        r102.setCustomizedParams(r103);     // Catch: Throwable -> L63
        TTWebsocketConnection r119 = r102.build();
        this.f527006l = r119;
        r119.startConnection();
        return;
    L31:
        if (r108.isEmpty() == true) goto L33;
        r114.putAll(r108);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L5:
        r101 = ((Integer) r100).intValue();
        goto L7
    }
}
