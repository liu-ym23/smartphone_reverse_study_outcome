package h64;

import android.text.TextUtils;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.http.RequestContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q64.e;
import q64.g;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f483911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f483912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SsCall f483913c;

    @Override // q64.g
    public final AoNetworkMetric a() {
        SsCall r100 = this.f483913c;
        if ((r100 instanceof IMetricsCollect) == false) goto L5;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.retrofit2.IMetricsCollect");
        ((IMetricsCollect) r100).doCollect();
    L5:
        SsCall r101 = this.f483913c;
        if ((r101 instanceof IRequestInfo) == false) goto L18;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.retrofit2.IRequestInfo");
        Object r102 = ((IRequestInfo) r101).getRequestInfo();
        if ((r102 instanceof BaseHttpRequestInfo) == false) goto L18;
        BaseHttpRequestInfo r103 = (BaseHttpRequestInfo) r102;
        SsCall r104 = this.f483913c;
        if (r104 == null) goto L14;
        Request r105 = r104.getRequest();
        if (r105 == null) goto L14;
        RetrofitMetrics r106 = r105.getMetrics();
    L16:
        return a.c(r103, r106);
    L14:
        r106 = null;
    L18:
        return new AoNetworkMetric();
    }

    @Override // q64.g
    public final void cancel() {
        SsCall r100 = this.f483913c;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // q64.g
    public final q64.b execute() {
        SsCall r100 = this.f483913c;
        e r101 = null;
        String r102 = null;
        if (r100 != null) goto L24;
        StringBuilder r103 = new StringBuilder();
        Throwable r104 = this.f483912b;
        if (r104 == null) goto L18;
        Class<?> r105 = r104.getClass();
    L19:
        r103.append(r105);
        r103.append(": ");
        Throwable r106 = this.f483912b;
        if (r106 == null) goto L22;
        r102 = r106.getMessage();
    L22:
        r103.append(r102);
        r103.append(", -1");
        String r107 = r103.toString();
        String r108 = this.f483911a.getUrl();
        q64.c r109 = q64.c.f531789b;
        return new q64.b(-1, r107, r108, q64.c.f531789b, null, this.f483912b);
    L18:
        r105 = null;
        goto L19
    L24:
        Response r110 = r100.execute();     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        q64.c r111 = a.b(r110.getHeaders());     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        TypedInput r112 = r110.getBody();     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
        if (r112 == null) goto L7;
        r101 = new e(r112.mimeType(), r112.length(), r112.in());     // Catch: Exception -> L9 CronetIOException -> L11 HttpResponseException -> L13
    L7:
    L29:
        return new q64.b(r110.getStatus(), r110.getReason(), r110.getUrl(), r111, r101, null);
    L11:
        e = move-exception;
        String r113 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r114 = e.getStatusCode();
        String r115 = this.f483911a.getUrl();
        q64.c r116 = q64.c.f531789b;
        return new q64.b(r114, r113, r115, q64.c.f531789b, null, e);
    L13:
        e = move-exception;
        String r117 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r118 = e.getStatusCode();
        String r119 = this.f483911a.getUrl();
        q64.c r120 = q64.c.f531789b;
        return new q64.b(r118, r117, r119, q64.c.f531789b, null, e);
    L9:
        e = move-exception;
        String r121 = e.getClass() + ": " + e.getMessage() + ", -1";
        String r122 = this.f483911a.getUrl();
        q64.c r123 = q64.c.f531789b;
        return new q64.b(-1, r121, r122, q64.c.f531789b, null, e);
    }

    public b(q64.a r110) {
        Intrinsics.checkNotNullParameter(r110, "mAoRequest");
        lx5.b r100 = HttpClient.getHttpClient(r110.f531773a);
        String r101 = r110.f531774b;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "GET";
    L5:
        String r102 = r101;
        List<Header> r103 = a.a(r110.f531778f);
        RequestContext r111 = new RequestContext();
        r111.timeout_connect = r110.f531780h;
        r111.timeout_read = r110.f531781i;
        r111.timeout_write = r110.f531782j;
        r111.force_handle_response = true;
        q64.d r104 = r110.f531779g;
        if (r104 == null) goto L8;
        d r105 = new d(r104);
    L9:
        RetrofitMetrics r106 = new RetrofitMetrics();
        Request r112 = new Request(r102, r110.f531773a, r103, r105, 3, r110.f531775c, Integer.MAX_VALUE, r110.f531776d, r111);
        this.f483911a = r112;
        r106.createSsHttpCallTime = System.currentTimeMillis();     // Catch: Exception -> L12
        this.f483913c = r100.newSsCall(r112);     // Catch: Exception -> L12
    L14:
        this.f483911a.setMetrics(r106);
        return;
    L12:
        e = move-exception;
        this.f483912b = e;
        goto L14
    L8:
        r105 = null;
        goto L9
    }
}
