package o5;

import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements Interceptor {
    public l() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        if (r100 == null) goto L13;
        Request r101 = r100.request();
        if (r101 == null) goto L15;
        ArrayList r102 = new ArrayList();
        AtomicBoolean r103 = f2.b.f475097a;
        h2.a r104 = f2.b.f475099c;
        if (r104 != null) goto L9;
    L11:
        Request.Builder r105 = r101.newBuilder();
        List<Header> r106 = CollectionsKt.toMutableList(r101.getHeaders());
        r106.addAll(r102);
        Unit r107 = Unit.INSTANCE;
        return r100.proceed(r105.headers(r106).build());
    L9:
        if (r104.f483577p == false) goto L11;
        r102.add(new Header(ByteNetEnvHeaderName.PPE, "1"));
        r102.add(new Header("x-tt-env", r104.f483578q));
        goto L11
    L15:
        return null;
    L13:
        return null;
    }
}
