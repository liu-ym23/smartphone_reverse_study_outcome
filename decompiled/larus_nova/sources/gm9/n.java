package gm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements Interceptor {
    public n() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        if (r100 == null) goto L11;
        Request r101 = r100.request();
        if (r101 == null) goto L13;
        Request.Builder r102 = r101.newBuilder();
        List<Header> r103 = CollectionsKt.toMutableList(r101.getHeaders());
        if (AccountService.f365697a.a() == false) goto L9;
        r103.add(new Header("minor-mode", "1"));
    L9:
        r102.headers(r103);
        return r100.proceed(r102.build());
    L13:
        return null;
    L11:
        return null;
    }
}
