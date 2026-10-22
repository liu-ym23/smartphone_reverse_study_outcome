package gm9;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.network.interceptor.config.TimeoutConfig;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a f481771a;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f481772d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f481773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, TimeoutConfig> f481774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Map<String, TimeoutConfig>> f481775c;

        /* JADX INFO: renamed from: gm9.o$a$a, reason: collision with other inner class name */
        public static final class C6039a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f481773a == r101.f481773a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f481774b, r101.f481774b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f481775c, r101.f481775c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f481773a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f481774b.hashCode()) * 31) + this.f481775c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "CompiledConfig(enabled=" + this.f481773a + ", domainTimeout=" + this.f481774b + ", overrides=" + this.f481775c + ')';
        }

        static {
            f481772d = new a(false, MapsKt.emptyMap(), MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean r100, Map<String, TimeoutConfig> r101, Map<String, ? extends Map<String, TimeoutConfig>> r102) {
            Intrinsics.checkNotNullParameter(r101, "domainTimeout");
            Intrinsics.checkNotNullParameter(r102, "overrides");
            this.f481773a = r100;
            this.f481774b = r101;
            this.f481775c = r102;
        }
    }

    public o() {
        a r100 = a.f481772d;
        this.f481771a = a.f481772d;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        Object r102 = r101.getExtraInfo();
        RequestContext r103 = null;
        if ((r102 instanceof BaseRequestContext) == false) goto L5;
        BaseRequestContext r104 = (BaseRequestContext) r102;
    L6:
        if (r104 != null) goto L8;
    L21:
        a r105 = this.f481771a;
        if (r105.f481773a == false) goto L24;
        String r106 = r101.getHost();
        if (r106 == null) goto L28;
        String r107 = r101.getPath();
        if (r107 != null) goto L34;
        return r100.proceed(r101);
    L34:
        if (Intrinsics.areEqual(r107, "") == true) goto L36;
        String r108 = HTTP.URL_DEFAULT;
        if (Intrinsics.areEqual(r107, HTTP.URL_DEFAULT) == true) goto L41;
        r108 = StringsKt.removeSuffix(r107, HTTP.URL_DEFAULT);
    L41:
        Intrinsics.checkNotNullParameter(r106, "host");
        Intrinsics.checkNotNullParameter(r108, "path");
        Map<String, TimeoutConfig> r109 = r105.f481775c.get(r106);
        if (r109 == null) goto L45;
        TimeoutConfig r110 = r109.get(r108);
        if (r110 == null) goto L45;
    L46:
        if (r110 == null) goto L48;
        Request.Builder r111 = r101.newBuilder();
        Intrinsics.checkNotNull(r101);
        Object r112 = r101.getExtraInfo();
        if ((r112 instanceof RequestContext) == false) goto L52;
        r103 = (RequestContext) r112;
    L52:
        if (r103 != null) goto L54;
        r103 = new RequestContext();
    L54:
        Long r113 = r110.getConnectTimeoutMs();
        if (r113 == null) goto L57;
        r103.timeout_connect = r113.longValue();
    L57:
        Long r114 = r110.getReadTimeoutMs();
        if (r114 == null) goto L60;
        r103.timeout_read = r114.longValue();
    L60:
        Long r115 = r110.getWriteTimeoutMs();
        if (r115 == null) goto L63;
        r103.timeout_write = r115.longValue();
    L63:
        Long r116 = r110.getProtectTimeoutMs();
        if (r116 == null) goto L66;
        r103.protect_timeout = r116.longValue();
    L66:
        Long r117 = r110.getSocketConnectTimeoutMs();
        if (r117 == null) goto L69;
        r103.socket_connect_timeout = r117.longValue();
    L69:
        Long r118 = r110.getSocketReadTimeoutMs();
        if (r118 == null) goto L72;
        r103.socket_read_timeout = r118.longValue();
    L72:
        Long r119 = r110.getSocketWriteTimeoutMs();
        if (r119 == null) goto L75;
        r103.socket_write_timeout = r119.longValue();
    L75:
        r111.setExtraInfo(r103);
        return r100.proceed(r111.build());
    L48:
        return r100.proceed(r101);
    L45:
        r110 = r105.f481774b.get(r106);
        goto L46
    L36:
        return r100.proceed(r101);
    L28:
        return r100.proceed(r101);
    L24:
        return r100.proceed(r101);
    L8:
        if (r104.protect_timeout <= 0) goto L10;
    L17:
        boolean r120 = true;
    L18:
        if (r120 == false) goto L21;
        return r100.proceed(r101);
    L10:
        if (r104.timeout_connect > 0) goto L17;
        if (r104.timeout_read > 0) goto L17;
        if (r104.timeout_write > 0) goto L17;
        r120 = false;
        goto L18
    L5:
        r104 = null;
        goto L6
    }
}
