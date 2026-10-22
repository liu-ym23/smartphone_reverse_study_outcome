package qx5;

import android.os.Looper;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class a implements TTInternalInterceptor {
    public a() {
    }

    public void processAfterReceiveResponse(Request r100, SsResponse r101) throws Exception {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = processBeforeSendRequest(r100.request());
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L5;
        SsResponse r102 = r100.proceedWithoutHook(r101);
    L6:
        processAfterReceiveResponse(r101, r102);
        return r102;
    L5:
        r102 = r100.proceed(r101);
        goto L6
    }

    public Request processBeforeSendRequest(Request r100) throws IOException {
        if (NetworkParams.getEnableMainThreadCheck() == true) goto L5;
    L9:
        if (r100 != null) goto L35;
        return null;
    L35:
        URL r101 = new URL(r100.getUrl());     // Catch: MalformedURLException -> L16
        if ("http".equals(r101.getProtocol()) == false) goto L17;
        NetworkParams.monitorApiHttp(r101.getHost(), r101.getPath(), false, r100.getMetrics());     // Catch: MalformedURLException -> L16
    L17:
        String r102 = r100.getUrl();
        if ((r100.getExtraInfo() instanceof BaseRequestContext) == false) goto L20;
        String r103 = NetworkParams.filterUrl(r102, (BaseRequestContext) r100.getExtraInfo(), r100.getMetrics());
    L22:
        if (r100.getUrl().startsWith(GXImageView.NET_HTTPS_PREFIX) == false) goto L29;
        if (r103.startsWith(GXImageView.NET_HTTP_PREFIX) == false) goto L29;
        URL r104 = new URL(r103);     // Catch: Throwable -> L27
        NetworkParams.monitorApiHttp(r104.getHost(), r104.getPath(), true, r100.getMetrics());     // Catch: Throwable -> L27
    L29:
        if (r100.isAddCommonParam() == false) goto L31;
        mx5.a.a().getClass();
        r103 = tryAddCommonParams(r103, r100.getMetrics());
    L31:
        Request.Builder r105 = r100.newBuilder();
        r105.url(r103);
        return r105.build();
    L20:
        r103 = NetworkParams.filterUrl(r102, r100.getMetrics());
        goto L22
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    private String tryAddCommonParams(String r100, RetrofitMetrics r101) {
        return NetworkParams.addCommonParams(r100, true, r101);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r100;
    }
}
