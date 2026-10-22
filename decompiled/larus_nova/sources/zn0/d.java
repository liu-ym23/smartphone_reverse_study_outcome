package zn0;

import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Interceptor {
    public d() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        Request r100 = r110.request();
        List<Header> r101 = r100.headers("x-nx-chunk");
        if (r101 == null) goto L13;
        Iterator<Header> r102 = r101.iterator();
        if (r102 == null) goto L13;
    L7:
        if (r102.hasNext() == false) goto L13;
        Header r103 = r102.next();
        String r104 = r103.getValue();
        if (jc1.a.c() == false) goto L7;
        if ((!Intrinsics.areEqual(r104, "1.0")) == false) goto L7;
        r100.getUrl();
        r100.getHeaders().remove(r103);
    L13:
        SsResponse<?> r111 = r110.proceed(r100);
        Object r105 = r111.body();
        if ((r105 instanceof f) == false) goto L40;
        f r106 = (f) r105;
        Map<String, Object> r107 = r106.f244817b;
        Header r108 = r111.raw().getFirstHeader(NetResponse.HEADER_KEY_LOG_ID);
        String r109 = "";
        if (r108 == null) goto L19;
        String r112 = r108.getValue();
        if (r112 == null) goto L19;
    L20:
        r107.put("logId", r112);
        Map<String, Object> r113 = r106.f244817b;
        Header r114 = r111.raw().getFirstHeader(OkHttpEventListener.X_TT_TRACE_ID);
        if (r114 == null) goto L26;
        String r115 = r114.getValue();
        if (r115 == null) goto L26;
        r109 = r115;
    L26:
        r113.put("traceId", r109);
        List<Header> r116 = r111.raw().headers("x-nx-chunk");
        if (r116 != null) goto L29;
    L39:
        Intrinsics.checkNotNullParameter("server not support", "reason");
        r106.f244816a = true;
        goto L40
    L29:
        if (r116.size() == 0) goto L39;
        r116.size();
        String r117 = ((Header) ListProtector.get(r116, 0)).getValue();
        int r118 = StringsKt.indexOf$default(r117, ".", 0, false, 6, null);
        if (r118 < 0) goto L38;
        if ((!Intrinsics.areEqual("1", r117.substring(0, r118))) == false) goto L36;
        Intrinsics.checkNotNullParameter("version conflict", "reason");
        r106.f244816a = true;
    L36:
        r106.f244816a = false;
        goto L40
    L38:
        throw new IllegalAccessException("IllegalArgument NETX_CHUNK_VERSION_HEADER for live request");
    L19:
        r112 = "";
    L40:
        return r111;
    }
}
