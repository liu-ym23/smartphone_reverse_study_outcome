package qx5;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements TTInternalInterceptor {
    public b() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        if (r101 == null) goto L12;
        if (r101.isResponseStreaming() == true) goto L12;
        String r102 = NetworkParams.tryAddRequestVertifyParams(r101.getUrl(), r101.isAddCommonParam(), r101.getMetrics(), new Object[]{r101.getBody()});     // Catch: Throwable -> L9
        Request.Builder r103 = r101.newBuilder();     // Catch: Throwable -> L9
        r103.url(r102);     // Catch: Throwable -> L9
        r101 = r103.build();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L15;
        return r100.proceedWithoutHook(r101);
    L15:
        return r100.proceed(r101);
    }
}
