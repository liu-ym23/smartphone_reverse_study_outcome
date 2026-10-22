package or5;

import android.text.TextUtils;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.bytedance.ee.eenet.util.HttpChannel;
import com.bytedance.ee.eenet.util.RequestAlias;
import com.bytedance.ee.eenet.util.RequestPriority;
import com.bytedance.lark.sdk.LarkNetProtocol;
import com.bytedance.lark.sdk.LarkRequest;
import com.bytedance.lark.sdk.LarkResponse;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import se6.i;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f524934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OkHttpClient f524935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Request f524936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarkRequest f524937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f524938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f524939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f524940g;

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r110) throws IOException {
        Request r100 = r110.request();
        this.f524936c = r100;
        mr5.a r101 = (mr5.a) r100.tag(mr5.a.class);
        if (this.f524939f == true) goto L138;
        this.f524939f = true;
        if (this.f524937d != null) goto L87;
        Request r102 = this.f524936c;
        OkHttpClient r103 = this.f524935b;
        LarkRequest.a r104 = new LarkRequest.a();
        String r105 = r102.url().toString();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f254070a = r105;
        if ("GET".equals(r102.method().toUpperCase()) == false) goto L10;
        r104.f254071b = LarkRequest.Method.GET;
        r104.f254076g = null;
    L24:
        Iterator<String> r106 = r102.headers().names().iterator();
    L26:
        if (r106.hasNext() == false) goto L28;
        String r111 = r106.next();
        String r112 = r102.headers().get(r111);
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "value");
        ((ArrayList) r104.f254075f).add(new com.bytedance.lark.sdk.a(r111, r112));
        goto L26
    L28:
        String r107 = HttpChannel.RustChannel.toString();
        Intrinsics.checkNotNullParameter("EENet-Request-Http-Channel", "name");
        Intrinsics.checkNotNullParameter(r107, "value");
        ((ArrayList) r104.f254075f).add(new com.bytedance.lark.sdk.a("EENet-Request-Http-Channel", r107));
        String r108 = r102.headers().get("EENet-Request-Priority");
        if (TextUtils.isEmpty(r108) == true) goto L39;
        int r109 = CastIntegerProtector.valueOf(r108).intValue();
        if (r109 != RequestPriority.HIGH.getLevel()) goto L34;
        LarkRequest.Priority r113 = LarkRequest.Priority.HIGH;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r104.f254074e = r113;
        goto L39
    L34:
        if (r109 != RequestPriority.MEDIUM.getLevel()) goto L37;
        LarkRequest.Priority r114 = LarkRequest.Priority.MEDIUM;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r104.f254074e = r114;
        goto L39
    L37:
        if (r109 != RequestPriority.LOW.getLevel()) goto L39;
        LarkRequest.Priority r115 = LarkRequest.Priority.LOW;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r104.f254074e = r115;
    L39:
        String r116 = r102.headers().get("EENet-Request-alias");
        if (TextUtils.isEmpty(r116) == true) goto L71;
        int r117 = CastIntegerProtector.valueOf(r116).intValue();
        if (r117 != RequestAlias.API.getValue()) goto L45;
        r104.a(LarkRequest.Alias.API);
        goto L71
    L45:
        if (r117 != RequestAlias.DOCS.getValue()) goto L48;
        r104.a(LarkRequest.Alias.DOCS);
        goto L71
    L48:
        if (r117 != RequestAlias.DOCS_API.getValue()) goto L51;
        r104.a(LarkRequest.Alias.DOCS_API);
        goto L71
    L51:
        if (r117 != RequestAlias.DRIVE.getValue()) goto L54;
        r104.a(LarkRequest.Alias.DRIVE);
        goto L71
    L54:
        if (r117 != RequestAlias.FILE.getValue()) goto L57;
        r104.a(LarkRequest.Alias.FILE);
        goto L71
    L57:
        if (r117 != RequestAlias.MINA.getValue()) goto L60;
        r104.a(LarkRequest.Alias.MINA);
        goto L71
    L60:
        if (r117 != RequestAlias.OAPI.getValue()) goto L63;
        r104.a(LarkRequest.Alias.OAPI);
        goto L71
    L63:
        if (r117 != RequestAlias.OPEN.getValue()) goto L66;
        r104.a(LarkRequest.Alias.OPEN);
        goto L71
    L66:
        if (r117 != RequestAlias.PASSPORT.getValue()) goto L69;
        r104.a(LarkRequest.Alias.PASSPORT);
        goto L71
    L69:
        if (r117 != RequestAlias.UNKNOWN.getValue()) goto L71;
        r104.a(LarkRequest.Alias.UNKNOWN);
    L71:
        String r118 = r102.headers().get("EENet-Request-Retry-Num");
        if (TextUtils.isEmpty(r118) == true) goto L74;
        r104.f254078i = CastIntegerProtector.valueOf(r118).intValue();
    L75:
        String r119 = r102.headers().get("EENet-Rust-Request-Timeout");
        if (TextUtils.isEmpty(r119) == false) goto L78;
    L80:
        r104.f254072c = (r103.connectTimeoutMillis() + r103.writeTimeoutMillis()) + r103.readTimeoutMillis();
    L81:
        r104.f254077h = qr5.a.a(r102);
        r104.f254073d = r103.followRedirects();
        if (r101 == null) goto L86;
        boolean r120 = r101.f514982a;
        if (r120 == false) goto L86;
        r104.f254080k = r120;
        r104.f254079j = r101.f514983b;
    L86:
        LarkRequest r121 = new LarkRequest(r104);
        this.f524937d = r121;
        ((ArrayList) this.f524937d.f254057f).add(new com.bytedance.lark.sdk.a("EENet-XRequest-Id", String.valueOf(r121.f254058g)));
        goto L87
    L78:
        if (TextUtils.isDigitsOnly(r119) == false) goto L80;
        r104.f254072c = CastIntegerProtector.parseInt(r119);
        goto L81
    L74:
        r104.f254078i = 3;
        goto L75
    L10:
        if ("POST".equals(r102.method().toUpperCase()) == false) goto L13;
        com.bytedance.lark.sdk.c r122 = pr5.b.a(r102.body());
        Intrinsics.checkNotNullParameter(r122, "larkRequestBody");
        r104.f254071b = LarkRequest.Method.POST;
        r104.f254076g = r122;
        goto L24
    L13:
        if ("HEAD".equals(r102.method().toUpperCase()) == false) goto L16;
        r104.f254071b = LarkRequest.Method.HEAD;
        r104.f254076g = null;
        goto L24
    L16:
        if ("PUT".equals(r102.method().toUpperCase()) == false) goto L19;
        com.bytedance.lark.sdk.c r123 = pr5.b.a(r102.body());
        Intrinsics.checkNotNullParameter(r123, "larkRequestBody");
        r104.f254071b = LarkRequest.Method.PUT;
        r104.f254076g = r123;
        goto L24
    L19:
        if ("DELETE".equals(r102.method().toUpperCase()) == false) goto L22;
        r104.delete(pr5.b.a(r102.body()));
        goto L24
    L22:
        if ("PATCH".equals(r102.method().toUpperCase()) == false) goto L24;
        com.bytedance.lark.sdk.c r124 = pr5.b.a(r102.body());
        Intrinsics.checkNotNullParameter(r124, "larkRequestBody");
        r104.f254071b = LarkRequest.Method.PATCH;
        r104.f254076g = r124;
    L87:
        tt5.a.h("eenet_CallServerInterceptor", "rust net request task id: " + this.f524937d.f254058g);
        if (this.f524938e == true) goto L136;
        LarkResponse r125 = this.f524934a.c(this.f524937d);
        LarkResponse.d r126 = r125.f254085e;
        LarkResponse.b r127 = r125.f254084d;
        LarkResponse.InnerErrorCode r128 = LarkResponse.InnerErrorCode.UNKNOWN;
        int r129 = r128.toInt();
        Response.Builder r130 = new Response.Builder();
        LarkResponse.e r131 = r125.f254083c;
        LarkResponse.c r132 = r125.f254086f;
        if (r131 == null) goto L106;
        r130.code(r131.f254109a);
        LarkNetProtocol r133 = r131.f254110b;
        if (LarkNetProtocol.HTTP_1_1 != r133) goto L95;
        Protocol r134 = Protocol.HTTP_1_1;
    L101:
        r130.protocol(r134);
        Headers.Builder r135 = new Headers.Builder();
        Iterator<com.bytedance.lark.sdk.a> r136 = r131.f254111c.iterator();
    L103:
        if (r136.hasNext() == false) goto L105;
        com.bytedance.lark.sdk.a r137 = r136.next();
        OkHttpClient.a r138 = cvc.a.f465511a;
        String r139 = r137.f254119a;
        String r140 = r137.f254120b;
        r138.getClass();
        r135.addLenient(r139, r140);
        goto L103
    L105:
        r130.headers(r135.build());
    L107:
        r130.addHeader("EENet-Request-Http-Channel", HttpChannel.RustChannel.toString());
        r130.addHeader("EENet-Request-Server-Ip", r125.f254087g);
        LarkResponse.f r141 = r125.f254081a;
        if (r141 == null) goto L110;
        r130.addHeader("EENet-Request-Dns-Cost", String.valueOf(r141.f254112a));
        r130.addHeader("EENet-Request-Tls-Cost", String.valueOf(r141.f254114c));
        r130.addHeader("EENet-Request-Tcp-Cost", String.valueOf(r141.f254113b));
    L110:
        if (r132 == null) goto L112;
        r130.body(ResponseBody.create(MediaType.parse(r132.f254103a), r132.f254104b.toByteArray()));
    L112:
        String r142 = "";
        if (r126 == null) goto L115;
        String r143 = r126.f254106b;
        r129 = r126.f254105a.toInt();
    L118:
        r130.message(r143);
        r130.request(this.f524936c);
        r130.addHeader("EENet-XRequest-Id", String.valueOf(this.f524937d.f254058g));
        String r144 = this.f524936c.header("request-id");
        if (r144 == null) goto L121;
        r142 = r144;
    L121:
        r130.addHeader("request-id", r142);
        Response r145 = r130.build();
        LarkResponse.ResponseStatus r146 = LarkResponse.ResponseStatus.CANCEL;
        LarkResponse.ResponseStatus r147 = r125.f254082b;
        if (r146 != r147) goto L124;
        RustIOException r148 = new RustIOException("request cancel", RustIOException.REQUEST_EENET_CANCEL);
        r148.setRequestCallInfo(pr5.a.b(r145));
        throw r148;
    L124:
        if (LarkResponse.ResponseStatus.ERROR == r147) goto L126;
        this.f524940g = true;
        return r145;
    L126:
        if (r125.f254085e == null) goto L128;
        LarkResponse.d r149 = r125.f254085e;
        RustIOException r150 = new RustIOException(r143, r129, r149.f254108d, r149.f254107c);
    L129:
        r150.setRequestCallInfo(pr5.a.b(r145));
        throw r150;
    L128:
        r150 = new RustIOException(r143, r129);
        goto L129
    L115:
        if (r127 == null) goto L117;
        r143 = r127.f254102b;
        r129 = r127.f254101a.toInt();
        goto L118
    L117:
        r143 = "";
        goto L118
    L95:
        if (LarkNetProtocol.HTTP_2 != r133) goto L98;
        r134 = Protocol.HTTP_2;
        goto L101
    L98:
        if (LarkNetProtocol.QUIC != r133) goto L100;
        r134 = Protocol.QUIC;
        goto L101
    L100:
        r134 = Protocol.HTTP_1_0;
        goto L101
    L106:
        r130.code(r128.toInt());
        r130.protocol(Protocol.HTTP_1_0);
        goto L107
    L136:
        throw new RustIOException("request cancel", RustIOException.REQUEST_EENET_CANCEL);
    L138:
        throw new RustIOException(new IllegalStateException("Already mExecuted."), RustIOException.REQUEST_EENET_INNER_ERROR);
    }

    public b(OkHttpClient r100, i r101) {
        this.f524934a = r101;
        this.f524935b = r100;
    }
}
