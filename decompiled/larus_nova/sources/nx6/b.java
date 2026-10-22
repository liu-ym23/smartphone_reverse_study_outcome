package nx6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements pn6.b {

    public static final class a {
    }

    static {
    }

    @Override // pn6.b
    public final boolean a(Request r100, SsResponse<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "ssResponse");
        return true;
    }

    public b() {
    }

    @Override // pn6.b
    public final void b(nn6.a r110, Request r111, SsResponse<Object> r112) {
        Intrinsics.checkNotNullParameter(r110, "poiDurationMonitor");
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r112, "ssResponse");
        Response r113 = r112.raw();     // Catch: Exception -> L42
        long r114 = 0;
        if (r113 == null) goto L40;
        Header r115 = r113.getFirstHeader("server-timing");     // Catch: Exception -> L42
        if (r115 == null) goto L40;
        String r100 = r115.getValue();     // Catch: Exception -> L42
        if (r100 == null) goto L40;
        List r116 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L42
        if (r116 == null) goto L40;
        Iterator r117 = r116.iterator();     // Catch: Exception -> L42
    L13:
        Object r101 = null;
        if (r117.hasNext() == false) goto L22;
        Object r102 = r117.next();     // Catch: Exception -> L42
        String r103 = (String) r102;     // Catch: Exception -> L42
        if (r103 == null) goto L21;
        if (StringsKt.startsWith$default(StringsKt.trim(r103).toString(), "inner;", false, 2, null) == false) goto L13;
        r101 = r102;
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L42
    L22:
        String r104 = (String) r101;     // Catch: Exception -> L42
        if (r104 == null) goto L40;
        List r118 = StringsKt.split$default(r104, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);     // Catch: Exception -> L42
        if (r118 == null) goto L40;
        if (r118.size() <= 1) goto L40;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L34
        String r119 = (String) ListProtector.get(r118, 1);     // Catch: Throwable -> L34
        if (r119 == null) goto L33;
        Object r120 = Result.m9449constructorimpl(Long.valueOf(CastLongProtector.parseLong(StringsKt.trim(r119).toString())));     // Catch: Throwable -> L34
    L37:
        if (Result.m9455isFailureimpl(r120) == false) goto L39;
        r120 = 0L;
    L39:
        r114 = ((Number) r120).longValue();     // Catch: Exception -> L42
        goto L40
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Exception -> L42
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L42
    L40:
        Long r121 = com.bytedance.locallife.pdp.net.dynamic.a.f261601a;     // Catch: Exception -> L42
        com.bytedance.locallife.pdp.net.dynamic.a.f261601a = Long.valueOf(r114);     // Catch: Exception -> L42
        return;
    }
}
