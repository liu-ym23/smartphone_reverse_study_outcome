package uw2;

import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements Interceptor {
    public b() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        SsResponse<?> r102 = r100.proceed(r101);     // Catch: Exception -> L5
        a(r101, r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r103 = Spm.a.a("a100.b4000").result(100);
        String r104 = e.getMessage();
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        vw2.a.a(r103.reason(r104).addArg("path", r101.getPath()), "network");
        throw e;
    }

    public final void a(Request r100, SsResponse<?> r101) {
        List<Header> r102 = r101.headers();
        String r103 = null;
        if (r102 == null) goto L10;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Header r105 = (Header) r104.next();
        if (Intrinsics.areEqual(r105.getName(), NetResponse.HEADER_KEY_LOG_ID) == false) goto L6;
        r103 = r105.getValue();
    L10:
        if (r103 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L24;
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.b4000").result(r101.code()).addArg(CronetDataStorageAccess.LOGID, r103).addArg("param", "-").addArg("path", r100.getPath()), "network");
        return;
    L24:
        return;
    L12:
        if (r103.length() == 0) goto L15;
        r106 = false;
        goto L16
    }
}
