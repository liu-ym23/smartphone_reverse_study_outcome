package dv6;

import com.bytedance.locallife.live.util.m;
import com.bytedance.locallife.live.util.n;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f470159a = null;

    public static final class a {
    }

    public c() {
    }

    static {
        f470159a = CollectionsKt.listOf(new String[]{"/data/life/live/agg/card/detail/", "/data/life/live/pack_life_component/", "/data/life/live/preview/pack_life_component/"});
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r101 = r110.request();
        String r102 = r101.getPath();
        String r103 = r101.getUrl();
    L38:
        th = move-exception;
        m r104 = n.f260724a;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("url", r103);
        String r106 = th.getMessage();
        if (r106 == null) goto L43;
        r100 = r106;
    L43:
        r105.put("error_msg", r100);
        Unit r107 = Unit.INSTANCE;
        n.a("request_error", r105);
        throw th;
    L4:
        if (f470159a.contains(r102) == true) goto L6;
    L14:
        SsResponse<?> r111 = r110.proceed(r101);     // Catch: Throwable -> L38
        if (f470159a.contains(r102) == true) goto L17;
        return r111;
    L17:
        String r108 = null;
        if (r111 == null) goto L31;
        List<Header> r109 = r111.headers();     // Catch: Throwable -> L38
        if (r109 == null) goto L31;
        Iterator<T> r112 = r109.iterator();     // Catch: Throwable -> L38
    L23:
        if (r112.hasNext() == false) goto L27;
        Object r113 = r112.next();     // Catch: Throwable -> L38
        if (StringsKt.equals(NetResponse.HEADER_KEY_LOG_ID, ((Header) r113).getName(), true) == false) goto L23;
    L28:
        Header r114 = (Header) r113;     // Catch: Throwable -> L38
        if (r114 == null) goto L31;
        r108 = r114.getValue();     // Catch: Throwable -> L38
        goto L31
    L27:
        r113 = null;
    L31:
        if (r108 != null) goto L33;
        r108 = "";
    L33:
        int r115 = r111.code();     // Catch: Throwable -> L38
        String r116 = r111.message();     // Catch: Throwable -> L38
        m r117 = n.f260724a;     // Catch: Throwable -> L38
        LinkedHashMap r118 = new LinkedHashMap();     // Catch: Throwable -> L38
        r118.put("url", r103);     // Catch: Throwable -> L38
        r118.put("log_id", r108);     // Catch: Throwable -> L38
        r118.put("status_code", String.valueOf(r115));     // Catch: Throwable -> L38
        if (r116 != null) goto L36;
        r116 = "";
    L36:
        r118.put("status_msg", r116);     // Catch: Throwable -> L38
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L38
        n.a("request_end", r118);     // Catch: Throwable -> L38
        return r111;
    L6:
        if (Intrinsics.areEqual(r101.getMethod(), "POST") == false) goto L12;
        TypedOutput r120 = r101.getBody();     // Catch: Throwable -> L38
        ByteArrayOutputStream r121 = new ByteArrayOutputStream();     // Catch: IOException -> L45 Throwable -> L38
        if (r120 == null) goto L12;
        r120.writeTo(r121);     // Catch: IOException -> L45 Throwable -> L38
        String r122 = new String(r121.toByteArray(), StandardCharsets.UTF_8);     // Catch: IOException -> L45 Throwable -> L38
    L13:
        m r123 = n.f260724a;     // Catch: Throwable -> L38
        LinkedHashMap r124 = new LinkedHashMap();     // Catch: Throwable -> L38
        r124.put("url", r103);     // Catch: Throwable -> L38
        r124.put("params", r122);     // Catch: Throwable -> L38
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L38
        n.a("request_start", r124);     // Catch: Throwable -> L38
    L12:
        r122 = "";
        goto L13
    }
}
