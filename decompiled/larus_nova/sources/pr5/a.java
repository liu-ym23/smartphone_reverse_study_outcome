package pr5;

import android.text.TextUtils;
import com.bytedance.ee.eenet.util.HttpChannel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static kr5.a a(Request r100) {
        String r101 = r100.url().toString();
        r100.url().host();
        r100.url().topPrivateDomain();
        kr5.a r102 = new kr5.a();
        r102.f505714f = HttpChannel.RustChannel.toString();
        r102.f505713e = r101;
        String r103 = r100.header("request-id");
        String r104 = "";
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        r102.f505715g = r103;
        String r105 = r100.header("EENet-Request-Tag");
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r102.f505718j = r104;
        r102.f505717i = r100.method();
        r102.f505719k = qr5.a.a(r100);
        return r102;
    }

    public static kr5.a b(Response r100) {
        String r101 = r100.header("EENet-Request-Dns-Cost");
        String r102 = r100.header("EENet-Request-Tcp-Cost");
        String r103 = r100.header("EENet-Request-Tls-Cost");
        int r104 = 0;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        int r105 = CastIntegerProtector.valueOf(r101).intValue();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        int r106 = CastIntegerProtector.valueOf(r102).intValue();
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L13;
        int r107 = CastIntegerProtector.valueOf(r103).intValue();
    L14:
        r100.header("EENet-Request-Server-Ip");
        String r108 = r100.request().url().toString();
        r100.request().url().host();
        String r109 = r100.protocol().toString();
        r100.request().url().topPrivateDomain();
        kr5.a r110 = new kr5.a();
        r110.f505709a = r105;
        r110.f505710b = r106;
        r110.f505711c = r107;
        r110.f505712d = r109;
        r110.f505714f = HttpChannel.RustChannel.toString();
        r110.f505713e = r108;
        List<String> r111 = r100.headers("server-timing");
        StringBuffer r112 = new StringBuffer();
        if (r111 == null) goto L22;
        int r113 = r111.size();
        if (r113 <= 0) goto L22;
    L18:
        int r114 = r113 - 1;
        if (r104 >= r114) goto L21;
        r112.append((String) ListProtector.get(r111, r104));
        r112.append(",");
        r104 = r104 + 1;
        goto L18
    L21:
        r112.append((String) ListProtector.get(r111, r114));
    L22:
        r110.f505721m = r112.toString();
        ResponseBody r115 = r100.body();
        if (r115 == null) goto L25;
        r110.f505720l = r115.contentLength();
    L25:
        Request r116 = r100.request();
        String r117 = "";
        if (r116 == null) goto L32;
        String r118 = r116.header("EENet-Request-Tag");
        if (r118 != null) goto L31;
        r118 = "";
    L31:
        r110.f505718j = r118;
        r110.f505717i = r116.method();
        r110.f505719k = qr5.a.a(r116);
    L32:
        String r119 = r100.header("request-id");
        if (r119 != null) goto L36;
        r119 = "";
    L36:
        r110.f505715g = r119;
        String r120 = r100.header("EENet-XRequest-Id");
        if (r120 == null) goto L39;
        r117 = r120;
    L39:
        r110.f505716h = r117;
        return r110;
    L13:
        r107 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L11
    L5:
        r105 = 0;
        goto L7
    }
}
