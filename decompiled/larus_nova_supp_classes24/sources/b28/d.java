package b28;

import android.util.Base64;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements Interceptor {
    public final boolean a;
    public final evc.b b;
    public boolean c;

    public d(boolean r2) {
        this.a = r2;
        this.b = new evc.b(r2);
    }

    public final Response intercept(Interceptor.Chain r5) throws IOException {
        if (this.a == false) goto L7;
        return this.b.intercept(r5);
    L7:
        if (this.c == true) goto L19;
        Request r6 = r5.request();
        SendHttpRequest.Builder r0 = com.larksuite.framework.http.v2.internal.rust.b.b(r6);
        Command r1 = Command.SEND_HTTP;
        final ProtoAdapter r2 = SendHttpResponse.ADAPTER;
        Objects.requireNonNull(r2);
        SdkSender.d r3 = SdkSender.syncSendMayError(r1, r0, new c(r2));
        if (r3.b != null) goto L17;
        Response r4 = com.larksuite.framework.http.v2.internal.rust.c.a((SendHttpResponse) r3.a, r6).build();
        String r7 = new String(Base64.encode(r6.url().redact().getBytes(StandardCharsets.UTF_8), 0));
        if (r4.body() != null) goto L13;
        Log.w("RustInterceptor", "response body is null, origin request: ".concat(r7));
    L14:
        Log.d("RustInterceptor", r4.toString());
        return r4;
    L13:
        Log.i("RustInterceptor", "response body is not null, origin request: ".concat(r7));
        goto L14
    L17:
        throw new ProtocolException(r3.b.getDisplayMsg());
    L19:
        throw new IllegalStateException("Already Canceled");
    }
}
