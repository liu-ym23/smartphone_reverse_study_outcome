package pr5;

import android.text.TextUtils;
import com.bytedance.ee.eenet.util.HttpChannel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static kr5.a a(Request r3) {
        String r0 = r3.url().toString();
        r3.url().host();
        r3.url().topPrivateDomain();
        kr5.a r1 = new kr5.a();
        r1.f = HttpChannel.RustChannel.toString();
        r1.e = r0;
        String r2 = r3.header("request-id");
        String r4 = "";
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r1.g = r2;
        String r5 = r3.header("EENet-Request-Tag");
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r1.j = r4;
        r1.i = r3.method();
        r1.k = qr5.a.a(r3);
        return r1;
    }

    public static kr5.a b(Response r7) {
        String r0 = r7.header("EENet-Request-Dns-Cost");
        String r1 = r7.header("EENet-Request-Tcp-Cost");
        String r2 = r7.header("EENet-Request-Tls-Cost");
        int r4 = 0;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        int r3 = CastIntegerProtector.valueOf(r0).intValue();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        int r5 = CastIntegerProtector.valueOf(r1).intValue();
    L11:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        int r6 = CastIntegerProtector.valueOf(r2).intValue();
    L14:
        r7.header("EENet-Request-Server-Ip");
        String r8 = r7.request().url().toString();
        r7.request().url().host();
        String r9 = r7.protocol().toString();
        r7.request().url().topPrivateDomain();
        kr5.a r10 = new kr5.a();
        r10.a = r3;
        r10.b = r5;
        r10.c = r6;
        r10.d = r9;
        r10.f = HttpChannel.RustChannel.toString();
        r10.e = r8;
        List r11 = r7.headers("server-timing");
        StringBuffer r12 = new StringBuffer();
        if (r11 == null) goto L22;
        int r13 = r11.size();
        if (r13 <= 0) goto L22;
    L18:
        int r14 = r13 - 1;
        if (r4 >= r14) goto L21;
        r12.append((String) ListProtector.get(r11, r4));
        r12.append(",");
        r4 = r4 + 1;
        goto L18
    L21:
        r12.append((String) ListProtector.get(r11, r14));
    L22:
        r10.m = r12.toString();
        ResponseBody r16 = r7.body();
        if (r16 == null) goto L25;
        r10.l = r16.contentLength();
    L25:
        Request r17 = r7.request();
        String r18 = "";
        if (r17 == null) goto L32;
        String r19 = r17.header("EENet-Request-Tag");
        if (r19 != null) goto L31;
        r19 = "";
    L31:
        r10.j = r19;
        r10.i = r17.method();
        r10.k = qr5.a.a(r17);
    L32:
        String r20 = r7.header("request-id");
        if (r20 != null) goto L36;
        r20 = "";
    L36:
        r10.g = r20;
        String r21 = r7.header("EENet-XRequest-Id");
        if (r21 == null) goto L39;
        r18 = r21;
    L39:
        r10.h = r18;
        return r10;
    L13:
        r6 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L11
    L5:
        r3 = 0;
        goto L7
    }
}
