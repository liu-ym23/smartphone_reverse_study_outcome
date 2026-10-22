package h64;

import android.util.Pair;
import com.bytedance.awemeopen.infra.plugs.ttnet.AoTTNetRetrofitApi;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q64.e;
import q64.g;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q64.a f483914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call<?> f483915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f483916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SsResponse<?> f483917d;

    @Override // q64.g
    public final AoNetworkMetric a() {
        Call<?> r100 = this.f483915b;
        if ((r100 instanceof IMetricsCollect) == false) goto L5;
        ((IMetricsCollect) r100).doCollect();
    L5:
        SsResponse<?> r101 = this.f483917d;
        RetrofitMetrics r102 = null;
        if (r101 == null) goto L10;
        Response r103 = r101.raw();
        if (r103 == null) goto L10;
        Object r104 = r103.getExtraInfo();
    L12:
        if ((r104 instanceof BaseHttpRequestInfo) == false) goto L21;
        BaseHttpRequestInfo r105 = (BaseHttpRequestInfo) r104;
        if (r100 == null) goto L19;
        Request r106 = r100.request();
        if (r106 == null) goto L19;
        r102 = r106.getMetrics();
    L19:
        return a.c(r105, r102);
    L21:
        return new AoNetworkMetric();
    L10:
        r104 = null;
        goto L12
    }

    @Override // q64.g
    public final void cancel() {
        Call<?> r100 = this.f483915b;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // q64.g
    public final q64.b execute() {
        Call<?> r100 = this.f483915b;
        e r101 = null;
        String r102 = null;
        if (r100 != null) goto L28;
        StringBuilder r103 = new StringBuilder();
        Throwable r104 = this.f483916c;
        if (r104 == null) goto L22;
        Class<?> r105 = r104.getClass();
    L23:
        r103.append(r105);
        r103.append(": ");
        Throwable r106 = this.f483916c;
        if (r106 == null) goto L26;
        r102 = r106.getMessage();
    L26:
        r103.append(r102);
        r103.append(", -1");
        String r107 = r103.toString();
        String r108 = this.f483914a.f531773a;
        q64.c r109 = q64.c.f531789b;
        return new q64.b(-1, r107, r108, q64.c.f531789b, null, this.f483916c);
    L22:
        r105 = null;
        goto L23
    L28:
        SsResponse<?> r110 = r100.execute();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        this.f483917d = r110;     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        q64.c r111 = a.b(r110.headers());     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
        if (r110.isSuccessful() == false) goto L7;
        Object r112 = r110.body();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L9:
        if ((r112 instanceof TypedInput) == false) goto L11;
        r101 = new e(((TypedInput) r112).mimeType(), ((TypedInput) r112).length(), ((TypedInput) r112).in());     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L11:
    L33:
        return new q64.b(r110.code(), r110.raw().getReason(), r110.raw().getUrl(), r111, r101, null);
    L7:
        r112 = r110.errorBody();     // Catch: Exception -> L13 CronetIOException -> L15 HttpResponseException -> L17
    L15:
        e = move-exception;
        String r113 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r114 = e.getStatusCode();
        String r115 = this.f483914a.f531773a;
        q64.c r116 = q64.c.f531789b;
        return new q64.b(r114, r113, r115, q64.c.f531789b, null, e);
    L17:
        e = move-exception;
        String r117 = e.getClass() + ": " + e.getMessage() + ", " + e.getStatusCode();
        int r118 = e.getStatusCode();
        String r119 = this.f483914a.f531773a;
        q64.c r120 = q64.c.f531789b;
        return new q64.b(r118, r117, r119, q64.c.f531789b, null, e);
    L13:
        e = move-exception;
        String r121 = e.getClass() + ": " + e.getMessage() + ", -1";
        String r122 = this.f483914a.f531773a;
        q64.c r123 = q64.c.f531789b;
        return new q64.b(-1, r121, r122, q64.c.f531789b, null, e);
    }

    public c(q64.a r110) {
        Intrinsics.checkNotNullParameter(r110, "mAoRequest");
        this.f483914a = r110;
    L59:
        th = move-exception;
        this.f483916c = th;
        return;
    L5:
        if (r110.f531774b.length() <= 0) goto L7;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        String r101 = r110.f531774b;     // Catch: Throwable -> L59
    L12:
        List<Header> r102 = a.a(r110.f531778f);     // Catch: Throwable -> L59
        boolean r111 = r110.f531776d;     // Catch: Throwable -> L59
        HashMap r103 = new HashMap();     // Catch: Throwable -> L59
        Pair<String, String> r104 = UrlUtils.parseUrl(r110.f531773a, r103);     // Catch: Throwable -> L59
        String r105 = (String) r104.first;     // Catch: Throwable -> L59
        String r106 = (String) r104.second;     // Catch: Throwable -> L59
        RequestContext r112 = new RequestContext();     // Catch: Throwable -> L59
        r112.timeout_connect = r110.f531780h;     // Catch: Throwable -> L59
        r112.timeout_read = r110.f531781i;     // Catch: Throwable -> L59
        r112.timeout_write = r110.f531782j;     // Catch: Throwable -> L59
        r112.force_handle_response = true;     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r105, "baseUrl");     // Catch: Throwable -> L59
        AoTTNetRetrofitApi r107 = (AoTTNetRetrofitApi) RetrofitUtils.createSsService(r105, AoTTNetRetrofitApi.class);     // Catch: Throwable -> L59
        if (r107 == null) goto L58;
        boolean r108 = r110.f531775c;     // Catch: Throwable -> L59
        q64.d r113 = r110.f531779g;     // Catch: Throwable -> L59
        if (r113 == null) goto L17;
        TypedOutput r109 = new d(r113);     // Catch: Throwable -> L59
    L19:
        switch(r101.hashCode()) {
            case -531492226: goto L52;
            case 70454: goto L47;
            case 79599: goto L42;
            case 2213344: goto L39;
            case 2461856: goto L34;
            case 75900968: goto L31;
            case 80083237: goto L28;
            case 1669334218: goto L25;
            case 2012838315: goto L22;
            default: goto L56;
        };     // Catch: Throwable -> L59
    L56:
        throw new RuntimeException("call need method");     // Catch: Throwable -> L59
    L22:
        if (r101.equals("DELETE") == false) goto L56;
        Call<?> r114 = r107.delete(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
    L54:
        this.f483915b = r114;     // Catch: Throwable -> L59
        return;
    L25:
        if (r101.equals(OpenNetMethod.CONNECT) == false) goto L56;
        r114 = r107.connect(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L28:
        if (r101.equals("TRACE") == false) goto L56;
        r114 = r107.trace(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L31:
        if (r101.equals("PATCH") == false) goto L56;
        r114 = r107.patch(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L34:
        if (r101.equals("POST") == false) goto L56;
        if (r108 == false) goto L37;
        r114 = r107.postStream(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L37:
        r114 = r107.post(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L39:
        if (r101.equals("HEAD") == false) goto L56;
        r114 = r107.head(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L42:
        if (r101.equals("PUT") == false) goto L56;
        if (r108 == false) goto L45;
        r114 = r107.putStream(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L45:
        r114 = r107.put(Integer.MAX_VALUE, r106, r103, r109, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L47:
        if (r101.equals("GET") == false) goto L56;
        if (r108 == false) goto L50;
        r114 = r107.getStream(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L50:
        r114 = r107.get(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L52:
        if (r101.equals("OPTIONS") == false) goto L56;
        r114 = r107.options(Integer.MAX_VALUE, r106, r103, r102, r112, r111);     // Catch: Throwable -> L59
        goto L54
    L17:
        r109 = new TypedByteArray(null, new byte[0], new String[0]);     // Catch: Throwable -> L59
        goto L19
    L58:
        throw new RuntimeException("generateTTNetApi Failed");     // Catch: Throwable -> L59
    L11:
        r101 = "GET";
        goto L12
    L7:
        r100 = false;
        goto L9
    }
}
