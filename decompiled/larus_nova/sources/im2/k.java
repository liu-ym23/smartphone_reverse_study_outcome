package im2;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdk.config.hz0;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.a4;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdk.utils.l4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements com.ss.ugc.live.sdk.msg.network.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveWsBridge f490484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l4 f490485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.network.m f490486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f490487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h80.d<Map<String, String>> f490488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f490489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f490490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h80.d<Map<String, String>> f490491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h80.d<Long> f490492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h80.d<String> f490493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h80.d<Boolean> f490494k;

    public static final class a<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f490495a = null;

        static {
            f490495a = new a();
        }

        public a() {
        }

        @Override // h80.d
        public final Object get() {
            return MapsKt.emptyMap();
        }
    }

    public static final class b implements com.ss.ugc.live.sdk.msg.network.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f490496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWsBridge f490497b;

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final boolean a() {
            LiveWsBridge r100 = this.f490497b;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isConnected();
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void disconnect() {
            LiveWsBridge r100 = this.f490497b;
            if (r100 == null) goto L5;
            r100.unregisterChannel();
        L5:
            this.f490496a.f490486c = null;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.j
        public final void b(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
            LiveWsBridge r101 = this.f490497b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isConnected() == false) goto L16;
            LiveWsMessage.Builder r102 = LiveWsMessage.Builder.create(this.f490496a.f490489f).setLogId(r100.f546766g).setSeqId(r100.f546767h).setService(r100.f546760a).setMethod(r100.f546761b).setPayload(r100.f546764e).setPayloadType(r100.f546762c).setPayloadEncoding(r100.f546763d).setFrom(2);
            List<com.ss.ugc.live.sdk.msg.network.d> r103 = r100.f546765f;
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.iterator();
        L10:
            if (r104.hasNext() == false) goto L12;
            com.ss.ugc.live.sdk.msg.network.d r105 = (com.ss.ugc.live.sdk.msg.network.d) r104.next();
            r102.addMsgHeader(r105.f458296a, r105.f458297b);
        L12:
            this.f490497b.sendMessage(r102.build(), null);
            return;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void e(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
            LiveWsBridge r101 = this.f490497b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isConnected() == true) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual(r100.f546762c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L12;
            LiveWsMessage r102 = LiveWsMessage.Builder.create(this.f490496a.f490489f).setLogId(r100.f546766g).setSeqId(r100.f546767h).setService(20146).setMethod(1).setPayload(r100.f546764e).setPayloadType(r100.f546762c).setPayloadEncoding(r100.f546763d).setFrom(2).build();
            this.f490497b.sendMessage(r102, null);
            return;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void f(tlc.f r110) {
            Intrinsics.checkNotNullParameter(r110, "payloadItem");
            LiveWsBridge r100 = this.f490497b;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isConnected() == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r110.f546762c, "msg") == false) goto L9;
            int r101 = d4.f158930a;
            LiveTracingMonitor.EventModule r102 = LiveTracingMonitor.EventModule.LIVE_MESSAGE;
            JSONObject r103 = new JSONObject();
            SettingKey<Boolean> r104 = LiveTracingMonitor.f64909a;
            LiveTracingMonitor.e("ttlive_illegal_ws_packet_send", r102, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, null, null, r103);
            int r105 = bc2.c.f18575a;
            Intrinsics.checkNotNullParameter("illegal ws packet send", "info");
            LocalTestManager.a(new Class[]{wy.a.class});
            b0 r106 = b0.o();
            Exception r107 = new Exception("stack");
            r106.getClass();
            com.bytedance.android.live.core.log.g.d("LiveMessageTracer", "illegal ws packet send", r107);
        L9:
            k r108 = this.f490496a;
            if (r108.f490489f != 10001) goto L12;
            boolean r109 = true;
        L13:
            if (r109 == false) goto L49;
            boolean r111 = !r108.f490494k.get().booleanValue();
            int r112 = d4.f158930a;
            if ((!Intrinsics.areEqual(r110.f546762c, PayloadItemType.PAYLOAD_TYPE_ACK.getType())) == true) goto L49;
            HashMap r113 = new HashMap();
            List<com.ss.ugc.live.sdk.msg.network.d> r114 = r110.f546765f;
            if (r114 == null) goto L39;
            Iterator<T> r115 = r114.iterator();
        L21:
            if (r115.hasNext() == false) goto L39;
            com.ss.ugc.live.sdk.msg.network.d r116 = (com.ss.ugc.live.sdk.msg.network.d) r115.next();
            String r117 = r116.f458296a;
            String r118 = r116.f458297b;
            if (r117 != null) goto L25;
        L28:
            boolean r119 = true;
        L29:
            if (r119 == true) goto L21;
            if (r118 != null) goto L32;
        L35:
            boolean r120 = true;
        L36:
            if (r120 == true) goto L21;
            r113.put(r117, r118);
            goto L21
        L32:
            if (r118.length() == 0) goto L35;
            r120 = false;
            goto L36
        L25:
            if (r117.length() == 0) goto L28;
            r119 = false;
        L39:
            if (r113.isEmpty() == true) goto L49;
            if (r111 == false) goto L43;
            String r121 = "0";
        L44:
            r113.put("client_status", r121);
            ArrayList r122 = new ArrayList(r113.size());
            Iterator r123 = r113.entrySet().iterator();
        L46:
            if (r123.hasNext() == false) goto L48;
            Map.Entry r124 = (Map.Entry) r123.next();
            r122.add(new com.ss.ugc.live.sdk.msg.network.d((String) r124.getKey(), (String) r124.getValue()));
            goto L46
        L48:
            r110.f546765f = r122;
            goto L49
        L43:
            r121 = "1";
        L49:
            LiveWsMessage.Builder r125 = LiveWsMessage.Builder.create(this.f490496a.f490489f).setLogId(r110.f546766g).setSeqId(r110.f546767h).setService(1).setMethod(1).setPayload(r110.f546764e).setPayloadType(r110.f546762c).setPayloadEncoding(r110.f546763d).setFrom(2);
            List<com.ss.ugc.live.sdk.msg.network.d> r126 = r110.f546765f;
            if (r126 == null) goto L56;
            Iterator<T> r127 = r126.iterator();
        L53:
            if (r127.hasNext() == false) goto L56;
            com.ss.ugc.live.sdk.msg.network.d r128 = (com.ss.ugc.live.sdk.msg.network.d) r127.next();
            r125.addMsgHeader(r128.f458296a, r128.f458297b);
        L56:
            if (TextUtils.equals(r110.f546762c, "ack") == false) goto L63;
            Map<String, String> r129 = this.f490496a.f490488e.get();
            if (r129 == null) goto L63;
            Iterator<Map.Entry<String, String>> r130 = r129.entrySet().iterator();
        L61:
            if (r130.hasNext() == false) goto L63;
            Map.Entry<String, String> r131 = r130.next();
            r125.addMsgHeader(r131.getKey(), r131.getValue());
        L63:
            this.f490497b.sendMessage(r125.build(), null);
            return;
        L12:
            r109 = false;
            goto L13
        }

        public b(k r100, LiveWsBridge r101) {
            this.f490496a = r100;
            this.f490497b = r101;
        }
    }

    public static final class c implements OnLiveWsMessageReceiveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f490498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f490499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f490500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.m f490501d;

        @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
        public final void onReceiveMsg(LiveWsMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "liveWsMessage");
            tlc.f r101 = bc2.d.b(r100);     // Catch: Exception -> L10
            if (r101 != null) goto L6;
        L11:
            return;
        L6:
            if (Intrinsics.areEqual(r101.f546762c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L8;
            bc2.c.b("ws uplink packet received");     // Catch: Exception -> L10
            this.f490501d.i(r101);     // Catch: Exception -> L10
            goto L11
        L8:
            this.f490501d.d(r101);     // Catch: Exception -> L10
        }

        @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
        public final void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r110) {
            if (r100 == null) goto L78;
            int r101 = j.f490483a[r100.ordinal()];
            if (r101 != 1) goto L7;
            this.f490498a = false;
            return;
        L7:
            if (r101 != 2) goto L9;
            if (r110 == null) goto L38;
            int r102 = r110.optInt("error_code", -3);
            String r103 = r110.toString();
            String r104 = r110.optString("error", "");
            int r105 = r110.optInt(WsConstants.KEY_CHANNEL_TYPE);
            int r111 = r110.optInt("type", 1);
            if (r105 != 1) goto L36;
            if (r111 != 1) goto L36;
            if (TextUtils.isEmpty(r104) == false) goto L36;
            return;
        L36:
            if (TextUtils.isEmpty(r104) == true) goto L39;
            r103 = r104;
        L39:
            int r112 = r103.length() - 1;
            int r106 = 0;
            boolean r107 = false;
        L40:
            if (r106 > r112) goto L56;
            if (r107 == true) goto L43;
            int r108 = r106;
        L45:
            if (Intrinsics.compare(r103.charAt(r108), 32) > 0) goto L47;
            boolean r109 = true;
        L48:
            if (r107 == false) goto L49;
            if (r109 == false) goto L56;
            r112 = r112 - 1;
            goto L40
        L49:
            if (r109 == false) goto L50;
            r106 = r106 + 1;
            goto L40
        L50:
            r107 = true;
            goto L40
        L47:
            r109 = false;
            goto L48
        L43:
            r108 = r112;
        L56:
            if (TextUtils.equals(r103.subSequence(r106, r112 + 1).toString(), "internet is down, skip...") == false) goto L58;
            k r113 = this.f490499b;
            l4 r114 = r113.f490485b;
            r113.f490492i.get().longValue();
            r114.l();
        L59:
            int r115 = bc2.c.f18575a;
            Intrinsics.checkNotNullParameter(r103, "reason");
            bc2.c.b("ws connect failed, reason: ".concat(r103));
            LiveWsBridge r116 = this.f490499b.f490484a;
            if (r116 == null) goto L62;
            r116.unregisterChannel();
        L62:
            this.f490501d.b(r103);
            this.f490499b.f490486c = null;
            this.f490498a = false;
            return;
        L58:
            k r117 = this.f490499b;
            l4 r118 = r117.f490485b;
            r117.f490492i.get().longValue();
            r118.m(r102, r103, this.f490500c);
            goto L59
        L38:
            r103 = "unknow";
            r102 = 0;
            goto L39
        L9:
            if (r101 != 3) goto L11;
            if (r110 == null) goto L21;
            String r119 = r110.optString("error", "");
            if (TextUtils.isEmpty(r119) == true) goto L21;
            k r120 = this.f490499b;
            l4 r121 = r120.f490485b;
            r120.f490492i.get().longValue();
            r121.m(-4, r119, this.f490500c);
        L21:
            boolean r122 = this.f490498a;
            int r123 = bc2.c.f18575a;
            bc2.c.b("ws connect closed, before ws connected: " + r122);
            if (this.f490498a == false) goto L27;
            LiveWsBridge r124 = this.f490499b.f490484a;
            if (r124 == null) goto L26;
            r124.unregisterChannel();
        L26:
            this.f490501d.b("close");
            this.f490499b.f490486c = null;
        L27:
            this.f490498a = false;
            return;
        L11:
            if (r101 != 4) goto L79;
            this.f490498a = true;
            k r125 = this.f490499b;
            l4 r126 = r125.f490485b;
            r125.f490492i.get().longValue();
            String r127 = this.f490500c;
            long r128 = r126.l();
            int r129 = r126.f159054d;
            String r130 = r126.f159053c;
            boolean r131 = r126.f159055e;
            int r132 = a4.f158819a;
            JSONObject r133 = new JSONObject();
            if (r130 == null) goto L16;
            r133.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, r130);
        L16:
            r133.put("channel_id", r129);
            r133.put(VideoTools.ERROR_TYPE_COMPRESS, r127);
            r133.put("use_private_protocol", r131);
            LiveMonitor.a r134 = new LiveMonitor.a("ttlive_msg_ws_connect_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE);
            r134.l(0);
            r134.j(r128);
            r134.b(r133);
            r134.f64903f = false;
            r134.a().report();
            bc2.c.b("ws connect success");
            this.f490501d.a();
            return;
        L79:
            return;
        }

        public c(k r100, String r101, com.ss.ugc.live.sdk.msg.network.m r102) {
            this.f490499b = r100;
            this.f490500c = r101;
            this.f490501d = r102;
        }
    }

    public static final class d<T> implements h80.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f490502a;

        public d(k r100) {
            this.f490502a = r100;
        }

        @Override // h80.d
        public final Object get() {
            return this.f490502a.f490484a;
        }
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        int r101 = bc2.c.f18575a;
        Intrinsics.checkNotNullParameter(r100, "reason");
        bc2.c.b("ws disconnected, reason: ".concat(r100));
        LiveWsBridge r102 = this.f490484a;
        if (r102 == null) goto L5;
        r102.unregisterChannel();
    L5:
        com.ss.ugc.live.sdk.msg.network.m r103 = this.f490486c;
        if (r103 == null) goto L8;
        r103.b(r100);
    L8:
        this.f490486c = null;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.l
    public final com.ss.ugc.live.sdk.msg.network.k a(String r210, Map<String, String> r211, com.ss.ugc.live.sdk.msg.network.m r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "params");
        Intrinsics.checkNotNullParameter(r212, "onWSListener");
        l4 r100 = this.f490485b;
        r100.f159054d = this.f490489f;
        r100.f159053c = this.f490493j.get();
        l4 r101 = this.f490485b;
        if (r101.f159052b == true) goto L6;
        r101.f159052b = true;
        r101.f159051a = SystemClock.uptimeMillis();
    L6:
        HashMap r110 = new HashMap(r211);
        HashMap r111 = new HashMap();
        Map<String, String> r102 = this.f490491h.get();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L22;
        Map.Entry<String, String> r105 = r104.next();
        boolean r106 = false;
        if (r105.getKey().length() <= 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L15;
    L20:
        if (r106 == false) goto L8;
        r103.put(r105.getKey(), r105.getValue());
        goto L8
    L15:
        if (r105.getValue().length() <= 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L20;
        r106 = true;
        goto L20
    L17:
        r108 = false;
        goto L18
    L12:
        r107 = false;
        goto L13
    L22:
        Iterator r109 = r103.keySet().iterator();
    L23:
        String r112 = null;
        if (r109.hasNext() == false) goto L28;
        Object r113 = r109.next();
        if (StringsKt.equals((String) r113, LoginVerifyService.X_TT_TOKEN, true) == false) goto L23;
    L29:
        String r114 = (String) r113;
        String r115 = "";
        if (r114 == null) goto L35;
        String r116 = (String) r103.get(r114);
        if (r116 != null) goto L34;
        r116 = "";
    L34:
        String r117 = (String) r111.put(r114, r116);
    L35:
        Iterator r118 = r103.keySet().iterator();
    L37:
        if (r118.hasNext() == false) goto L41;
        Object r119 = r118.next();
        if (StringsKt.equals((String) r119, "sdk-version", true) == false) goto L37;
    L42:
        String r120 = (String) r119;
        if (r120 == null) goto L49;
        String r121 = (String) r103.get(r120);
        if (r121 == null) goto L48;
        r115 = r121;
    L48:
        String r122 = (String) r111.put(r120, r115);
    L49:
        String r123 = (String) ((HashMap) r211).get(VideoTools.ERROR_TYPE_COMPRESS);
        this.f490486c = r212;
        int r124 = d4.f158930a;     // Catch: Throwable -> L73
        if (hz0.f120415a.getValue().booleanValue() == false) goto L74;
        Uri r125 = UriProtector.parse(r210);     // Catch: Throwable -> L73
        String r126 = r125.getHost();     // Catch: Throwable -> L73
        if (r126 == null) goto L61;
        List r127 = StringsKt.split$default(r126, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L73
        if (r127 == null) goto L61;
        String r128 = (String) CollectionsKt.firstOrNull(r127);     // Catch: Throwable -> L73
        if (r128 == null) goto L61;
        List r129 = StringsKt.split$default(r128, new String[]{"-"}, false, 0, 6, null);     // Catch: Throwable -> L73
        if (r129 == null) goto L61;
        String r130 = (String) CollectionsKt.lastOrNull(r129);     // Catch: Throwable -> L73
    L63:
        if (Intrinsics.areEqual(r130, "lf") == false) goto L65;
    L70:
        String r131 = "webcast100-ws-frontier-" + r130 + ".amemv.com";     // Catch: Throwable -> L73
    L71:
        String r132 = r125.buildUpon().authority(r131).build().toString();     // Catch: Throwable -> L73
    L76:
        if (d4.e() == false) goto L78;
        r112 = r213;
    L78:
        bc2.c.b("try register ws channel, private protocol enable " + d4.e() + ", actual url: " + r132 + "actual url for private protocol: " + r112);
        this.f490485b.f159055e = TextUtils.isEmpty(r112) ^ true;
        LiveWsBridge r133 = ((IMiddlewareHostNetwork) jc1.k.n(IMiddlewareHostNetwork.class)).registerWsChannel(this.f490490g, r132, r110, r111, new c(this, r123, r212), this.f490489f, r112);
        this.f490484a = r133;
        return new b(this, r133);
    L65:
        if (Intrinsics.areEqual(r130, "hl") == true) goto L70;
        if (Intrinsics.areEqual(r130, "lq") == true) goto L70;
        r131 = "webcast100-ws-frontier.amemv.com";
    L61:
        r130 = null;
    L74:
        r132 = r210;
        goto L76
    L41:
        r119 = null;
        goto L42
    L28:
        r113 = null;
        goto L29
    }

    public k(int r100, Context r101, h80.d<Map<String, String>> r102, h80.d<Long> r103, h80.d<String> r104, h80.d<Boolean> r105) {
        Intrinsics.checkNotNullParameter(r101, "applicationContext");
        Intrinsics.checkNotNullParameter(r102, "tokenParams");
        Intrinsics.checkNotNullParameter(r103, "roomIdSupplier");
        Intrinsics.checkNotNullParameter(r104, "roomTagSupplier");
        Intrinsics.checkNotNullParameter(r105, "appBackgroundSupplier");
        this.f490489f = r100;
        this.f490490g = r101;
        this.f490491h = r102;
        this.f490492i = r103;
        this.f490493j = r104;
        this.f490494k = r105;
        this.f490485b = new l4();
        this.f490487d = new d(this);
        this.f490488e = a.f490495a;
    }
}
