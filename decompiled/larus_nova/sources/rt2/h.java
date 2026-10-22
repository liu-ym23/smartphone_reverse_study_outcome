package rt2;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdk.config.hz0;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.ss.ugc.live.sdk.msg.unify.network.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveWsBridge f539176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.unify.network.d f539177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f539178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f539179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h80.d<Map<String, String>> f539180e;

    public static final class a implements com.ss.ugc.live.sdk.msg.unify.network.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f539181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWsBridge f539182b;

        @Override // com.ss.ugc.live.sdk.msg.unify.network.b
        public final boolean a() {
            LiveWsBridge r100 = this.f539182b;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isConnected();
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.b
        public final void disconnect() {
            LiveWsBridge r100 = this.f539182b;
            if (r100 == null) goto L5;
            r100.unregisterChannel();
        L5:
            this.f539181a.f539177b = null;
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.b
        public final void b(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
            LiveWsBridge r101 = this.f539182b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isConnected() == false) goto L16;
            LiveWsMessage.Builder r102 = LiveWsMessage.Builder.create(this.f539181a.f539178c).setLogId(r100.f546766g).setSeqId(r100.f546767h).setService(r100.f546760a).setMethod(r100.f546761b).setPayload(r100.f546764e).setPayloadType(r100.f546762c).setPayloadEncoding(r100.f546763d).setFrom(2);
            List<com.ss.ugc.live.sdk.msg.network.d> r103 = r100.f546765f;
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.iterator();
        L10:
            if (r104.hasNext() == false) goto L12;
            com.ss.ugc.live.sdk.msg.network.d r105 = (com.ss.ugc.live.sdk.msg.network.d) r104.next();
            r102.addMsgHeader(r105.f458296a, r105.f458297b);
        L12:
            this.f539182b.sendMessage(r102.build(), null);
            return;
        }

        public a(h r100, LiveWsBridge r101) {
            this.f539181a = r100;
            this.f539182b = r101;
        }
    }

    public static final class b implements OnLiveWsMessageReceiveListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f539183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f539184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.unify.network.d f539185c;

        @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
        public final void onReceiveMsg(LiveWsMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "liveWsMessage");
            tlc.f r101 = bc2.d.b(r100);     // Catch: Exception -> L7
            if (r101 == null) goto L10;
            this.f539185c.d(r101);     // Catch: Exception -> L7
            return;
        L10:
            return;
        }

        public b(h r100, com.ss.ugc.live.sdk.msg.unify.network.d r101) {
            this.f539184b = r100;
            this.f539185c = r101;
        }

        @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
        public final void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101) {
            if (r100 == null) goto L52;
            int r102 = g.f539175a[r100.ordinal()];
            boolean r103 = true;
            if (r102 == 1) goto L47;
            String r104 = "";
            if (r102 != 2) goto L9;
            if (r101 == null) goto L42;
            r101.optInt("error_code", -3);
            String r105 = r101.toString();
            String r106 = r101.optString("error", "");
            int r107 = r101.optInt(WsConstants.KEY_CHANNEL_TYPE);
            int r108 = r101.optInt("type", 1);
            if (r107 != 1) goto L40;
            if (r108 != 1) goto L40;
            if (TextUtils.isEmpty(r106) == false) goto L40;
            return;
        L40:
            if (TextUtils.isEmpty(r106) == true) goto L43;
            r105 = r106;
        L43:
            f.a("ws connect failed due to " + r105);
            LiveWsBridge r109 = this.f539184b.f539176a;
            if (r109 == null) goto L46;
            r109.unregisterChannel();
        L46:
            this.f539185c.b(r105);
            this.f539184b.f539177b = null;
            this.f539183a = false;
            return;
        L42:
            r105 = "unknow";
            goto L43
        L9:
            if (r102 != 3) goto L11;
            if (r101 == null) goto L16;
            r104 = r101.optString("error", "");
        L16:
            f.a("ws connect closed, previous connect state: " + this.f539183a);
            if (this.f539183a == false) goto L31;
            LiveWsBridge r110 = this.f539184b.f539176a;
            if (r110 == null) goto L21;
            r110.unregisterChannel();
        L21:
            com.ss.ugc.live.sdk.msg.unify.network.d r111 = this.f539185c;
            if (r104 != null) goto L24;
        L27:
            if (r103 == false) goto L29;
            String r112 = "close";
        L30:
            r111.b(r112);
            this.f539184b.f539177b = null;
            goto L31
        L29:
            r112 = "close_due_to_" + r104;
            goto L30
        L24:
            if (r104.length() == 0) goto L27;
            r103 = false;
        L31:
            this.f539183a = false;
            return;
        L11:
            if (r102 != 4) goto L53;
            this.f539183a = true;
            f.a("ws connect success");
            this.f539185c.a();
            return;
        L53:
            return;
        L47:
            this.f539183a = false;
            return;
        }
    }

    public h(Context r100, rt2.a.C7532a r101) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        Intrinsics.checkNotNullParameter(r101, "tokenParams");
        this.f539178c = 10000;
        this.f539179d = r100;
        this.f539180e = r101;
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.c
    public final com.ss.ugc.live.sdk.msg.unify.network.b a(String r110, Map<String, String> r111, com.ss.ugc.live.sdk.msg.unify.network.d r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r210, "onWSListener");
        HashMap r100 = new HashMap(r111);
        HashMap r101 = new HashMap();
        Map<String, String> r102 = this.f539180e.get();
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L3:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L19;
        Map.Entry<String, String> r106 = r104.next();
        if (r106.getKey().length() <= 0) goto L8;
        boolean r112 = true;
    L9:
        if (r112 == true) goto L11;
    L16:
        r105 = false;
    L17:
        if (r105 == false) goto L3;
        r103.put(r106.getKey(), r106.getValue());
        goto L3
    L11:
        if (r106.getValue().length() <= 0) goto L13;
        boolean r113 = true;
    L14:
        if (r113 == false) goto L16;
    L13:
        r113 = false;
        goto L14
    L8:
        r112 = false;
        goto L9
    L19:
        Iterator r107 = r103.keySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        Object r108 = r107.next();
        if (StringsKt.equals((String) r108, LoginVerifyService.X_TT_TOKEN, true) == false) goto L21;
    L26:
        String r109 = (String) r108;
        String r114 = "";
        if (r109 == null) goto L32;
        String r115 = (String) r103.get(r109);
        if (r115 != null) goto L31;
        r115 = "";
    L31:
        String r116 = (String) r101.put(r109, r115);
    L32:
        Iterator r117 = r103.keySet().iterator();
    L34:
        if (r117.hasNext() == false) goto L38;
        Object r118 = r117.next();
        if (StringsKt.equals((String) r118, "sdk-version", true) == false) goto L34;
    L39:
        String r119 = (String) r118;
        if (r119 == null) goto L46;
        String r120 = (String) r103.get(r119);
        if (r120 == null) goto L45;
        r114 = r120;
    L45:
        String r121 = (String) r101.put(r119, r114);
    L46:
        String r122 = (String) ((HashMap) r111).get(VideoTools.ERROR_TYPE_COMPRESS);
        this.f539177b = r210;
        int r123 = d4.f158930a;     // Catch: Throwable -> L70
        if (hz0.f120415a.getValue().booleanValue() == false) goto L71;
        Uri r124 = UriProtector.parse(r110);     // Catch: Throwable -> L70
        String r125 = r124.getHost();     // Catch: Throwable -> L70
        if (r125 == null) goto L58;
        List r126 = StringsKt.split$default(r125, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L70
        if (r126 == null) goto L58;
        String r127 = (String) CollectionsKt.firstOrNull(r126);     // Catch: Throwable -> L70
        if (r127 == null) goto L58;
        List r128 = StringsKt.split$default(r127, new String[]{"-"}, false, 0, 6, null);     // Catch: Throwable -> L70
        if (r128 == null) goto L58;
        String r129 = (String) CollectionsKt.lastOrNull(r128);     // Catch: Throwable -> L70
    L60:
        if (Intrinsics.areEqual(r129, "lf") == false) goto L62;
    L67:
        String r130 = "webcast100-ws-frontier-" + r129 + ".amemv.com";     // Catch: Throwable -> L70
    L68:
        String r131 = r124.buildUpon().authority(r130).build().toString();     // Catch: Throwable -> L70
    L73:
        if (d4.e() == false) goto L75;
        String r132 = r211;
    L76:
        f.a("try register ws channel, private protocol enable " + d4.e() + ", actual url: " + r131 + "actual url for private protocol: " + r132);
        LiveWsBridge r133 = ((IMiddlewareHostNetwork) k.n(IMiddlewareHostNetwork.class)).registerWsChannel(this.f539179d, r131, r100, r101, new b(this, r210), this.f539178c, r132);
        this.f539176a = r133;
        return new a(this, r133);
    L75:
        r132 = null;
        goto L76
    L62:
        if (Intrinsics.areEqual(r129, "hl") == true) goto L67;
        if (Intrinsics.areEqual(r129, "lq") == true) goto L67;
        r130 = "webcast100-ws-frontier.amemv.com";
    L58:
        r129 = null;
    L71:
        r131 = r110;
        goto L73
    L38:
        r118 = null;
        goto L39
    L25:
        r108 = null;
        goto L26
    }
}
