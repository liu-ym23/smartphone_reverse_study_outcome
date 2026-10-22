package gm9;

import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.n0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements Interceptor {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        String r100 = null;
        if (r110 == null) goto L51;
        Request r101 = r110.request();
        if (r101 == null) goto L51;
        Request.Builder r102 = r101.newBuilder();
        UrlBuilder r103 = new UrlBuilder(r101.getUrl());
        List<Header> r104 = CollectionsKt.toMutableList(r101.getHeaders());
        boolean r105 = n0.f365775a.b();
        String r106 = r101.getUrl();
        boolean r107 = false;
        if (StringsKt.contains$default(r106, "/service/settings", false, 2, null) == false) goto L20;
        String r108 = UriProtector.parse(r106).getPath();
        if (r108 == null) goto L20;
        String r109 = StringsKt.trimEnd(r108, new char[]{'/'});
        if (r109 == null) goto L20;
        if (Intrinsics.areEqual(r109, "/service/settings") == false) goto L18;
    L19:
        boolean r111 = true;
    L21:
        String r112 = AccountService.f365697a.getTenantId();
        String r113 = "0";
        if (r111 == false) goto L34;
        if (r105 == false) goto L25;
        r113 = "1";
    L25:
        r103.addParam("enterprise_mode", r113);
        r104.add(new Header("enterprise-mode", r113));
        if (r112 != null) goto L28;
    L49:
        r102.url(r103.build());
        r102.headers(r104);
        return r110.proceed(r102.build());
    L28:
        if (r112.length() <= 0) goto L30;
        r107 = true;
    L30:
        if (r107 == false) goto L32;
        r100 = r112;
    L32:
        if (r100 == null) goto L49;
        r103.addParam("lark_tenant_id", r100);
        goto L49
    L34:
        if (r105 == false) goto L36;
        r103.addParam("enterprise_mode", "1");
        r104.add(new Header("enterprise-mode", "1"));
    L36:
        if (r112 == null) goto L49;
        if (r112.length() <= 0) goto L40;
        boolean r114 = true;
    L41:
        if (r114 == true) goto L43;
    L45:
        if (r107 == false) goto L47;
        r100 = r112;
    L47:
        if (r100 == null) goto L49;
        r103.addParam("lark_tenant_id", r100);
        goto L49
    L43:
        if (Intrinsics.areEqual(r112, "0") == true) goto L45;
        r107 = true;
        goto L45
    L40:
        r114 = false;
        goto L41
    L18:
        if (StringsKt.startsWith$default(r109, "/service/settings/", false, 2, null) == true) goto L19;
    L20:
        r111 = false;
    L51:
        return null;
    }
}
