package w38;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.account.saas.core.internal.f;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Interceptor {

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        if (r110 == null) goto L5;
        Request r100 = r110.request();
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        Uri r101 = UriProtector.parse(r100.getUrl());
        String r102 = r101.getPath();
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        if (StringsKt.startsWith$default(r102, "/passport", false, 2, null) == false) goto L20;
        Uri.Builder r103 = r101.buildUpon();
        Map<String, String> r104 = f.f286240a;
        Iterator<Map.Entry<String, String>> r105 = f.f286240a.entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L18;
        Map.Entry<String, String> r106 = r105.next();
        String r107 = r106.getKey();
        String r108 = r106.getValue();
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("PassportCommonQueryInterceptor", "append query parameter for " + r102 + ": " + r107 + ", " + r108);
        r103.appendQueryParameter(r107, r108);
        goto L15
    L18:
        return r110.proceed(r100.newBuilder().url(r103.build().toString()).build());
    L20:
        return r110.proceed(r100);
    L5:
        r100 = null;
        goto L6
    }
}
