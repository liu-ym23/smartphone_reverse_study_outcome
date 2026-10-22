package o38;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: o38.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class C7007a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        if (r110 == null) goto L16;
        Request r100 = r110.request();
        if (r100 == null) goto L20;
        Request.Builder r101 = r100.newBuilder();
        List<Header> r102 = CollectionsKt.toMutableList(r100.getHeaders());
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = ServiceManager.get().getServices(IThirdPartyPlatformAuthorizationProvider.class).iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.putAll(IThirdPartyPlatformAuthorizationProvider.a.a((IThirdPartyPlatformAuthorizationProvider) r104.next(), r100.getMethod(), r100.getUrl(), 12));
        goto L8
    L10:
        FLogger.f375446a.d("AuthorizationInterceptor", "intercept auth headers, method=" + r100.getMethod() + ", keys=" + r103.keySet());
        Iterator r105 = r103.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.add(new Header((String) r106.getKey(), (String) r106.getValue()));
        goto L12
    L14:
        r101.headers(r102);
        return r110.proceed(r101.build());
    L20:
        return null;
    L16:
        return null;
    }
}
