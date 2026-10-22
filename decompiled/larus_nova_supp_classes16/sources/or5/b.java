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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Interceptor {
    public final i a;
    public final OkHttpClient b;
    public Request c;
    public LarkRequest d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;

    public final Response intercept(Interceptor.Chain r17) throws IOException {
        Request r1 = r17.request();
        this.c = r1;
        mr5.a r2 = (mr5.a) r1.tag(mr5.a.class);
        if (this.f == true) goto L138;
        this.f = true;
        if (this.d != null) goto L87;
        Request r3 = this.c;
        OkHttpClient r6 = this.b;
        LarkRequest.a r7 = new LarkRequest.a();
        String r8 = r3.url().toString();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.a = r8;
        if ("GET".equals(r3.method().toUpperCase()) == false) goto L10;
        r7.b = LarkRequest.Method.GET;
        r7.g = null;
    L24:
        Iterator r9 = r3.headers().names().iterator();
    L26:
        if (r9.hasNext() == false) goto L28;
        String r10 = (String) r9.next();
        String r13 = r3.headers().get(r10);
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r13, "value");
        ((ArrayList) r7.f).add(new com.bytedance.lark.sdk.a(r10, r13));
        goto L26
    L28:
        String r11 = HttpChannel.RustChannel.toString();
        Intrinsics.checkNotNullParameter("EENet-Request-Http-Channel", "name");
        Intrinsics.checkNotNullParameter(r11, "value");
        ((ArrayList) r7.f).add(new com.bytedance.lark.sdk.a("EENet-Request-Http-Channel", r11));
        String r12 = r3.headers().get("EENet-Request-Priority");
        if (TextUtils.isEmpty(r12) == true) goto L39;
        int r14 = CastIntegerProtector.valueOf(r12).intValue();
        if (r14 != RequestPriority.HIGH.getLevel()) goto L34;
        LarkRequest.Priority r16 = LarkRequest.Priority.HIGH;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r7.e = r16;
        goto L39
    L34:
        if (r14 != RequestPriority.MEDIUM.getLevel()) goto L37;
        LarkRequest.Priority r18 = LarkRequest.Priority.MEDIUM;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r7.e = r18;
        goto L39
    L37:
        if (r14 != RequestPriority.LOW.getLevel()) goto L39;
        LarkRequest.Priority r19 = LarkRequest.Priority.LOW;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r7.e = r19;
    L39:
        String r20 = r3.headers().get("EENet-Request-alias");
        if (TextUtils.isEmpty(r20) == true) goto L71;
        int r21 = CastIntegerProtector.valueOf(r20).intValue();
        if (r21 != RequestAlias.API.getValue()) goto L45;
        r7.a(LarkRequest.Alias.API);
        goto L71
    L45:
        if (r21 != RequestAlias.DOCS.getValue()) goto L48;
        r7.a(LarkRequest.Alias.DOCS);
        goto L71
    L48:
        if (r21 != RequestAlias.DOCS_API.getValue()) goto L51;
        r7.a(LarkRequest.Alias.DOCS_API);
        goto L71
    L51:
        if (r21 != RequestAlias.DRIVE.getValue()) goto L54;
        r7.a(LarkRequest.Alias.DRIVE);
        goto L71
    L54:
        if (r21 != RequestAlias.FILE.getValue()) goto L57;
        r7.a(LarkRequest.Alias.FILE);
        goto L71
    L57:
        if (r21 != RequestAlias.MINA.getValue()) goto L60;
        r7.a(LarkRequest.Alias.MINA);
        goto L71
    L60:
        if (r21 != RequestAlias.OAPI.getValue()) goto L63;
        r7.a(LarkRequest.Alias.OAPI);
        goto L71
    L63:
        if (r21 != RequestAlias.OPEN.getValue()) goto L66;
        r7.a(LarkRequest.Alias.OPEN);
        goto L71
    L66:
        if (r21 != RequestAlias.PASSPORT.getValue()) goto L69;
        r7.a(LarkRequest.Alias.PASSPORT);
        goto L71
    L69:
        if (r21 != RequestAlias.UNKNOWN.getValue()) goto L71;
        r7.a(LarkRequest.Alias.UNKNOWN);
    L71:
        String r22 = r3.headers().get("EENet-Request-Retry-Num");
        if (TextUtils.isEmpty(r22) == true) goto L74;
        r7.i = CastIntegerProtector.valueOf(r22).intValue();
    L75:
        String r23 = r3.headers().get("EENet-Rust-Request-Timeout");
        if (TextUtils.isEmpty(r23) == false) goto L78;
    L80:
        r7.c = (r6.connectTimeoutMillis() + r6.writeTimeoutMillis()) + r6.readTimeoutMillis();
    L81:
        r7.h = qr5.a.a(r3);
        r7.d = r6.followRedirects();
        if (r2 == null) goto L86;
        boolean r4 = r2.a;
        if (r4 == false) goto L86;
        r7.k = r4;
        r7.j = r2.b;
    L86:
        LarkRequest r5 = new LarkRequest(r7);
        this.d = r5;
        ((ArrayList) this.d.f).add(new com.bytedance.lark.sdk.a("EENet-XRequest-Id", String.valueOf(r5.g)));
        goto L87
    L78:
        if (TextUtils.isDigitsOnly(r23) == false) goto L80;
        r7.c = CastIntegerProtector.parseInt(r23);
        goto L81
    L74:
        r7.i = 3;
        goto L75
    L10:
        if ("POST".equals(r3.method().toUpperCase()) == false) goto L13;
        com.bytedance.lark.sdk.c r24 = pr5.b.a(r3.body());
        Intrinsics.checkNotNullParameter(r24, "larkRequestBody");
        r7.b = LarkRequest.Method.POST;
        r7.g = r24;
        goto L24
    L13:
        if ("HEAD".equals(r3.method().toUpperCase()) == false) goto L16;
        r7.b = LarkRequest.Method.HEAD;
        r7.g = null;
        goto L24
    L16:
        if ("PUT".equals(r3.method().toUpperCase()) == false) goto L19;
        com.bytedance.lark.sdk.c r26 = pr5.b.a(r3.body());
        Intrinsics.checkNotNullParameter(r26, "larkRequestBody");
        r7.b = LarkRequest.Method.PUT;
        r7.g = r26;
        goto L24
    L19:
        if ("DELETE".equals(r3.method().toUpperCase()) == false) goto L22;
        r7.delete(pr5.b.a(r3.body()));
        goto L24
    L22:
        if ("PATCH".equals(r3.method().toUpperCase()) == false) goto L24;
        com.bytedance.lark.sdk.c r27 = pr5.b.a(r3.body());
        Intrinsics.checkNotNullParameter(r27, "larkRequestBody");
        r7.b = LarkRequest.Method.PATCH;
        r7.g = r27;
    L87:
        tt5.a.h("eenet_CallServerInterceptor", "rust net request task id: " + this.d.g);
        if (this.e == true) goto L136;
        LarkResponse r28 = this.a.c(this.d);
        LarkResponse.d r29 = r28.e;
        LarkResponse.b r30 = r28.d;
        LarkResponse.InnerErrorCode r31 = LarkResponse.InnerErrorCode.UNKNOWN;
        int r110 = r31.toInt();
        Response.Builder r111 = new Response.Builder();
        LarkResponse.e r112 = r28.c;
        LarkResponse.c r113 = r28.f;
        if (r112 == null) goto L106;
        r111.code(r112.a);
        LarkNetProtocol r32 = r112.b;
        if (LarkNetProtocol.HTTP_1_1 != r32) goto L95;
        Protocol r33 = Protocol.HTTP_1_1;
    L101:
        r111.protocol(r33);
        Headers.Builder r34 = new Headers.Builder();
        Iterator r114 = r112.c.iterator();
    L103:
        if (r114.hasNext() == false) goto L105;
        com.bytedance.lark.sdk.a r115 = (com.bytedance.lark.sdk.a) r114.next();
        OkHttpClient.a r116 = cvc.a.a;
        String r36 = r115.a;
        String r117 = r115.b;
        r116.getClass();
        r34.addLenient(r36, r117);
        goto L103
    L105:
        r111.headers(r34.build());
    L107:
        r111.addHeader("EENet-Request-Http-Channel", HttpChannel.RustChannel.toString());
        r111.addHeader("EENet-Request-Server-Ip", r28.g);
        LarkResponse.f r37 = r28.a;
        if (r37 == null) goto L110;
        r111.addHeader("EENet-Request-Dns-Cost", String.valueOf(r37.a));
        r111.addHeader("EENet-Request-Tls-Cost", String.valueOf(r37.c));
        r111.addHeader("EENet-Request-Tcp-Cost", String.valueOf(r37.b));
    L110:
        if (r113 == null) goto L112;
        r111.body(ResponseBody.create(MediaType.parse(r113.a), r113.b.toByteArray()));
    L112:
        String r38 = "";
        if (r29 == null) goto L115;
        String r39 = r29.b;
        r110 = r29.a.toInt();
    L118:
        r111.message(r39);
        r111.request(this.c);
        r111.addHeader("EENet-XRequest-Id", String.valueOf(this.d.g));
        String r40 = this.c.header("request-id");
        if (r40 == null) goto L121;
        r38 = r40;
    L121:
        r111.addHeader("request-id", r38);
        Response r41 = r111.build();
        LarkResponse.ResponseStatus r42 = LarkResponse.ResponseStatus.CANCEL;
        LarkResponse.ResponseStatus r43 = r28.b;
        if (r42 != r43) goto L124;
        RustIOException r44 = new RustIOException("request cancel", RustIOException.REQUEST_EENET_CANCEL);
        r44.setRequestCallInfo(pr5.a.b(r41));
        throw r44;
    L124:
        if (LarkResponse.ResponseStatus.ERROR == r43) goto L126;
        this.g = true;
        return r41;
    L126:
        if (r28.e == null) goto L128;
        LarkResponse.d r46 = r28.e;
        RustIOException r47 = new RustIOException(r39, r110, r46.d, r46.c);
    L129:
        r47.setRequestCallInfo(pr5.a.b(r41));
        throw r47;
    L128:
        r47 = new RustIOException(r39, r110);
        goto L129
    L115:
        if (r30 == null) goto L117;
        r39 = r30.b;
        r110 = r30.a.toInt();
        goto L118
    L117:
        r39 = "";
        goto L118
    L95:
        if (LarkNetProtocol.HTTP_2 != r32) goto L98;
        r33 = Protocol.HTTP_2;
        goto L101
    L98:
        if (LarkNetProtocol.QUIC != r32) goto L100;
        r33 = Protocol.QUIC;
        goto L101
    L100:
        r33 = Protocol.HTTP_1_0;
        goto L101
    L106:
        r111.code(r31.toInt());
        r111.protocol(Protocol.HTTP_1_0);
        goto L107
    L136:
        throw new RustIOException("request cancel", RustIOException.REQUEST_EENET_CANCEL);
    L138:
        throw new RustIOException(new IllegalStateException("Already mExecuted."), RustIOException.REQUEST_EENET_INNER_ERROR);
    }

    public b(OkHttpClient r1, i r2) {
        this.a = r2;
        this.b = r1;
    }
}
