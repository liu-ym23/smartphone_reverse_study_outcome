package im2;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.c3;
import com.bytedance.android.live.base.model.message.h6;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livesdk.chatroom.bl.LiveMessage;
import com.bytedance.android.livesdk.config.q60;
import com.bytedance.android.livesdk.config.q80;
import com.bytedance.android.livesdk.utils.h0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message.lazy.LazyText;
import com.bytedance.common.utility.Logger;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements com.ss.ugc.live.sdk.msg.dispatch.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f490458d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f490459e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f490460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f490461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f490462c;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static Class a(String r100) {
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            Class<? extends t> r101 = (Class) h6.f58887a.get(r100);
            if (r101 != null) goto L5;
            r101 = LiveMessage.getMessageClass(r100);
        L5:
            if (r101 != null) goto L7;
            r101 = ExternalMessageInject.getInstance().getMessageClass(r100);
        L7:
            if (r101 == null) goto L9;
            return r101;
        L9:
            if (TextUtils.equals(r100, "WebcastGameCPBaseMessage") == false) goto L11;
        L16:
            boolean r102 = true;
        L17:
            if (r102 == true) goto L19;
            return r101;
        L19:
            return ExternalMessageInject.getInstance().getMessageClass(r100);
        L11:
            if (TextUtils.equals(r100, "WebcastGameCPAnchorPromoteInfoMessage") == true) goto L16;
            if (TextUtils.equals(r100, "WebcastGameCPUserRoomMetaMessage") == true) goto L16;
            r102 = false;
            goto L17
        }

        @JvmStatic
        public static am3.c b(Class r100) {
            am3.c r101 = ((IMiddlewareNetworkService) jc1.k.n(IMiddlewareNetworkService.class)).getProtoDecoder(r100);
            if (r101 != null) goto L9;
            am3.c r102 = ExternalMessageInject.getInstance().getDecoder(r100);
            if ((r102 instanceof am3.c) == true) goto L8;
            r102 = null;
        L8:
            return r102;
        L9:
            return r101;
        }

        @JvmStatic
        public static void d(String r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (StringsKt.startsWith$default(r100, MessageType.WEBCAST, false, 2, null) == false) goto L7;
            ((HashSet) d.f490458d).add(r100);
            return;
        L7:
            Set<String> r101 = d.f490458d;
            HashSet r102 = (HashSet) r101;
            r102.add(MessageType.WEBCAST.concat(r100));
        }

        @JvmStatic
        public static boolean c(String r100, tlc.d r101) {
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L9:
            if (((HashSet) d.f490458d).contains(r100) == true) goto L11;
            if (r102 == true) goto L11;
            return false;
        L11:
            return true;
        L5:
            if (r101.getIntType() != ExternalMessageType.LYNX_DYNAMIC_MESSAGE.getMin()) goto L7;
            r102 = true;
            goto L9
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f490463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f490464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f490465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f490466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f490467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f490468f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f490469g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f490470h;

        public b() {
        }
    }

    static {
        f490459e = new a();
        f490458d = new HashSet();
    }

    public d(boolean r100) {
        this.f490462c = r100;
        this.f490460a = v.a();
        this.f490461b = new b();
        LazyText.Companion r101 = LazyText.Companion;
        int r102 = vs1.f.f556978a;
        r101.setLazySupport(q80.f121034a.getValue().b());
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.f
    public final tlc.d a(SdkMessage r110) {
        Intrinsics.checkNotNullParameter(r110, "sdkMessage");
        if (TextUtils.isEmpty(r110.method) == false) goto L5;
    L71:
        this.f490461b.f490464b++;
        return null;
    L5:
        if (r110.payload == null) goto L71;
        int r100 = 0;
        if (StringsKt.startsWith$default(r110.method, MessageType.WEBCAST, false, 2, null) == true) goto L11;
        this.f490461b.f490469g++;
        c(r110.msg_id.longValue(), r110.method, "method前缀缺少Webcast", null);
        return null;
    L11:
        int r101 = h0.f158967a;
        ByteString r102 = r110.payload;
        Intrinsics.checkNotNullParameter(r102, "$this$toByteArrayOpt");
        byte[] r103 = r102.toByteArray();
        if (r103.length != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L73;
        this.f490461b.f490465c++;
        bc2.c.d(r110.msg_id.longValue(), r110.method);
        return null;
    L73:
        a r105 = f490459e;     // Catch: Throwable -> L68
        String r106 = r110.method;     // Catch: Throwable -> L68
        r105.getClass();     // Catch: Throwable -> L68
        Class<lm2.b> r107 = a.a(r106);     // Catch: Throwable -> L68
        if (r107 == null) goto L21;
    L24:
        am3.c r108 = a.b(r107);     // Catch: Throwable -> L68
        if (r108 == null) goto L66;
        am3.g r109 = new am3.g();     // Catch: Throwable -> L68
        r109.l(new am3.b(r103), r103.length);     // Catch: Throwable -> L68
        tlc.d r111 = (tlc.d) r108.decode(r109);     // Catch: Throwable -> L68
        String r112 = "";
        if ((r111 instanceof c3) == false) goto L45;
        ((c3) r111).setGeneralMessageType(r110.msg_type.intValue());     // Catch: Throwable -> L68
        ((c3) r111).setTimestamp(r110.timestamp);     // Catch: Throwable -> L68
        c3 r113 = (c3) r111;     // Catch: Throwable -> L68
        if (r110.fromHttp == true) goto L33;
        r100 = 1;
    L33:
        r113.setMessageFrom(r100);     // Catch: Throwable -> L68
        String r114 = r110.method;     // Catch: Throwable -> L68
        if (r114 == null) goto L38;
        r112 = r114;
    L38:
        if (a.c(r112, r111) == false) goto L40;
        ((c3) r111).setRawPayload(r103);     // Catch: Throwable -> L68
    L40:
        ((c3) r111).setMessageExtra(r110.message_extra);     // Catch: Throwable -> L68
        ((c3) r111).setCommonMessageData(((c3) r111).getCommon());     // Catch: Throwable -> L68
        if (((c3) r111).getCommon() != null) goto L64;
        this.f490461b.f490468f++;     // Catch: Throwable -> L68
        bc2.c.c(r110.msg_id.longValue(), r110.method);     // Catch: Throwable -> L68
        c(r110.msg_id.longValue(), r110.method, "base message null", null);     // Catch: Throwable -> L68
        return null;
    L64:
        this.f490461b.f490463a++;
        return r111;
    L45:
        if ((r111 instanceof BaseMessage) == false) goto L64;
        ((BaseMessage) r111).setGeneralMessageType(r110.msg_type.intValue());     // Catch: Throwable -> L68
        ((BaseMessage) r111).timestamp = r110.timestamp;     // Catch: Throwable -> L68
        BaseMessage r115 = (BaseMessage) r111;     // Catch: Throwable -> L68
        if (r110.fromHttp == true) goto L50;
        r100 = 1;
    L50:
        r115.setMessageFrom(r100);     // Catch: Throwable -> L68
        String r116 = r110.method;     // Catch: Throwable -> L68
        if (r116 == null) goto L55;
        r112 = r116;
    L55:
        if (a.c(r112, r111) == false) goto L57;
        ((BaseMessage) r111).rawPayload = r103;     // Catch: Throwable -> L68
    L57:
        ((BaseMessage) r111).messageExtra = r110.message_extra;     // Catch: Throwable -> L68
        ((BaseMessage) r111).setCurrUserIsAnchor(this.f490462c);     // Catch: Throwable -> L68
        if (((IMiddlewareHostConfig) jc1.k.n(IMiddlewareHostConfig.class)).appConfig().isMessageJsonPrintEnable() == false) goto L60;
        Logger.d("PB2JSON " + r110.method, GsonHelper.get().toJson(r111));     // Catch: Throwable -> L68
    L60:
        ((BaseMessage) r111).checkValid();     // Catch: Throwable -> L68
        if (((BaseMessage) r111).baseMessage != null) goto L64;
        this.f490461b.f490468f++;     // Catch: Throwable -> L68
        bc2.c.c(r110.msg_id.longValue(), r110.method);     // Catch: Throwable -> L68
        c(r110.msg_id.longValue(), r110.method, "base message null", null);     // Catch: Throwable -> L68
        return null;
    L66:
        this.f490461b.f490467e++;     // Catch: Throwable -> L68
        c(r110.msg_id.longValue(), r110.method, "find decoder failed", null);     // Catch: Throwable -> L68
        return null;
    L21:
        if (a.c(r110.method, null) == false) goto L23;
        r107 = lm2.b.class;
        goto L24
    L23:
        this.f490461b.f490466d++;     // Catch: Throwable -> L68
        c(r110.msg_id.longValue(), r110.method, "method not register", null);     // Catch: Throwable -> L68
        r107 = null;
    L68:
        th = move-exception;
        c(r110.msg_id.longValue(), r110.method, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, th);
        this.f490461b.f490470h++;
        return null;
    L14:
        r104 = false;
        goto L15
    }

    public final tlc.d b(com.bytedance.android.livesdk.chatroom.model.n r110) {
        Intrinsics.checkNotNullParameter(r110, "sdkMessage");
        byte[] r100 = r110.e();
        if (TextUtils.isEmpty(r110.b()) == true) goto L50;
        if (r100 == null) goto L50;
        if (r100.length != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L52;
        this.f490461b.f490465c++;
        bc2.c.d(r110.c(), r110.b());
        return null;
    L52:
        a r102 = f490459e;     // Catch: Throwable -> L47
        String r103 = r110.b();     // Catch: Throwable -> L47
        r102.getClass();     // Catch: Throwable -> L47
        Class r104 = a.a(r103);     // Catch: Throwable -> L47
        if (r104 != null) goto L17;
        this.f490461b.f490466d++;     // Catch: Throwable -> L47
        c(r110.c(), r110.b(), "method not register", null);     // Catch: Throwable -> L47
        return null;
    L17:
        am3.c r105 = a.b(r104);     // Catch: Throwable -> L47
        if (r105 == null) goto L45;
        am3.g r106 = new am3.g();     // Catch: Throwable -> L47
        r106.k(new am3.b(r100));     // Catch: Throwable -> L47
        tlc.d r107 = (tlc.d) r105.decode(r106);     // Catch: Throwable -> L47
        if ((r107 instanceof c3) == false) goto L33;
        ((c3) r107).setGeneralMessageType(r110.d());     // Catch: Throwable -> L47
        if (a.c(r110.b(), r107) == false) goto L24;
        ((c3) r107).setRawPayload(r100);     // Catch: Throwable -> L47
    L24:
        c3 r108 = (c3) r107;     // Catch: Throwable -> L47
        Map<String, String> r109 = r110.a();     // Catch: Throwable -> L47
        if (r109 == null) goto L27;
        Map<String, String> r111 = MapsKt.toMutableMap(r109);     // Catch: Throwable -> L47
    L28:
        r108.setMessageExtra(r111);     // Catch: Throwable -> L47
        ((c3) r107).setCommonMessageData(((c3) r107).getCommon());     // Catch: Throwable -> L47
        if (((c3) r107).getCommon() != null) goto L44;
        this.f490461b.f490468f++;     // Catch: Throwable -> L47
        bc2.c.c(r110.c(), r110.b());     // Catch: Throwable -> L47
        c(r110.c(), r110.b(), "base message null", null);     // Catch: Throwable -> L47
        return null;
    L44:
        return r107;
    L27:
        r111 = null;
        goto L28
    L33:
        if ((r107 instanceof BaseMessage) == false) goto L44;
        ((BaseMessage) r107).setGeneralMessageType(r110.d());     // Catch: Throwable -> L47
        if (a.c(r110.b(), r107) == false) goto L37;
        ((BaseMessage) r107).rawPayload = r100;     // Catch: Throwable -> L47
    L37:
        ((BaseMessage) r107).messageExtra = r110.a();     // Catch: Throwable -> L47
        ((BaseMessage) r107).setCurrUserIsAnchor(this.f490462c);     // Catch: Throwable -> L47
        if (((IMiddlewareHostConfig) jc1.k.n(IMiddlewareHostConfig.class)).appConfig().isMessageJsonPrintEnable() == false) goto L40;
        Logger.d("PB2JSON ".concat(r110.b()), GsonHelper.get().toJson(r107));     // Catch: Throwable -> L47
    L40:
        ((BaseMessage) r107).checkValid();     // Catch: Throwable -> L47
        if (((BaseMessage) r107).baseMessage != null) goto L44;
        this.f490461b.f490468f++;     // Catch: Throwable -> L47
        bc2.c.c(r110.c(), r110.b());     // Catch: Throwable -> L47
        c(r110.c(), r110.b(), "base message null", null);     // Catch: Throwable -> L47
        return null;
    L45:
        this.f490461b.f490467e++;     // Catch: Throwable -> L47
        c(r110.c(), r110.b(), "find decoder failed", null);     // Catch: Throwable -> L47
        return null;
    L47:
        th = move-exception;
        c(r110.c(), r110.b(), com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, th);
        return null;
    L9:
        r101 = false;
    L50:
        this.f490461b.f490464b++;
        return null;
    }

    public final void d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        b r100 = this.f490461b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "scene");
        if (r100.f490463a == 0) goto L5;
    L7:
        JSONObject r101 = new JSONObject();
        r101.put("scene", r110);
        JSONObject r111 = new JSONObject();
        long r102 = r100.f490463a;
        r111.put("success_rate", Float.valueOf(r102 / (r102 + ((((((r100.f490464b + r100.f490465c) + r100.f490466d) + r100.f490467e) + r100.f490468f) + r100.f490469g) + r100.f490470h))));
        r111.put("decode_success_count", r100.f490463a);
        r111.put("decode_failed_count_due_to_method_empty", r100.f490464b);
        r111.put("decode_failed_count_due_to_payload_empty", r100.f490465c);
        r111.put("decode_failed_count_due_to_method_not_register", r100.f490466d);
        r111.put("decode_failed_count_due_to_decoder_not_found", r100.f490467e);
        r111.put("decode_failed_count_due_to_base_message_null", r100.f490468f);
        r111.put("decode_failed_count_due_to_method_not_valid", r100.f490469g);
        r111.put("decode_failed_count_due_to_exception", r100.f490470h);
        LiveTracingMonitor.f("ttlive_message_decode_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r101, r111, new JSONObject());
    L8:
        this.f490461b = new b();
        return;
    L5:
        if (((((((r100.f490464b + r100.f490465c) + r100.f490466d) + r100.f490467e) + r100.f490468f) + r100.f490469g) + r100.f490470h) != 0) goto L7;
        goto L7
    }

    public final void c(long r110, String r111, String r112, Throwable r113) {
        JSONObject r100 = new JSONObject();
        r100.put(com.alipay.sdk.m.p.e.f25671s, r111);
        r100.put("reason", r112);
        JSONObject r101 = new JSONObject();
        if (r113 == null) goto L9;
        r101.put("msg_id", r110);
        String r102 = r113.getMessage();
        if (r102 != null) goto L7;
        r102 = "unknown exception";
    L7:
        r101.put("cause", r102);
    L9:
        if (Intrinsics.areEqual(r111, "WebcastLinkMessage") == true) goto L11;
    L27:
        LiveTracingMonitor.f("ttlive_message_decode_status_error", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r100, new JSONObject(), r101);
        if (this.f490460a == false) goto L31;
        Logger.e("MessageDecoder", "message: " + r111 + " decode failed due to " + r112, r113);
        return;
    L31:
        return;
    L11:
        if (this.f490462c == false) goto L27;
        if (q60.f121032a.getValue().booleanValue() == false) goto L27;
        IMiddlewareUserService r103 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r103 == null) goto L22;
        com.bytedance.android.livesdk.user.e r104 = r103.user();
        if (r104 == null) goto L22;
        IBaseUser r105 = r104.b();
        if (r105 == null) goto L22;
        String r106 = r105.getUserId();
        if (r106 == null) goto L22;
    L23:
        int r107 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r108 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_interact_sdk_api_call", PbRequest.SwitchType.PK);
        r108.f65010a = String.valueOf(r110);
        r108.f65012c = "webcast_client_revenue_interact";
        r108.f65016g = r106;
        Map<String, Object> r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_id", 1128), TuplesKt.to("android_event_key", "linkmessage_decode_error")});
        Intrinsics.checkNotNullParameter(r109, "index");
        r108.f65019j = r109;
        r108.f65017h = 1;
        r108.f65018i = r112;
        r108.f65015f = r106;
        r108.f65014e = "0";
        r108.f65011b = String.valueOf(r110);
        com.bytedance.android.live.core.monitor.trace.e r114 = r108.a();
        if (r113 == null) goto L26;
        r101.put("stack", ExceptionsKt.stackTraceToString(r113));
        r101.put("android_event_key", "linkmessage_decode_error");
    L26:
        TraceMonitor.h(r114, r101);
    L22:
        r106 = "";
        goto L23
    }
}
