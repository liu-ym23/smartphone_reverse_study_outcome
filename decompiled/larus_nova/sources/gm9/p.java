package gm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class p implements Interceptor {
    public p() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        if (r100 == null) goto L18;
        Request r101 = r100.request();
        if (r101 == null) goto L20;
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 != null) goto L11;
        return r100.proceed(r101);
    L11:
        if (r102.f(r100.request().getUrl()) == false) goto L17;
        r102.E();
        if (o0.d("x-tt-audit-mock") == false) goto L17;
        Request.Builder r103 = r101.newBuilder();
        List<Header> r104 = CollectionsKt.toMutableList(r101.getHeaders());
        r102.E();
        r104.add(new Header("x-tt-audit-mock", "1"));
        Unit r105 = Unit.INSTANCE;
        return r100.proceed(r103.headers(r104).build());
    L17:
        return r100.proceed(r100.request());
    L20:
        return null;
    L18:
        return null;
    }
}
