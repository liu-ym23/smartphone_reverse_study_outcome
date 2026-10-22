package com.larus.e_commerce.impl;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common.apphost.AppHost;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f342412a;

    public g() {
        this.f342412a = LazyKt.lazy(new f());
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        String r102 = r101.getHost();
        String r103 = r101.getUrl();
        if (AppHost.f326268a.isOversea() == true) goto L30;
        Set r104 = (Set) this.f342412a.getValue();
        if ((r104 instanceof Collection) == true) goto L7;
    L9:
        Iterator r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        boolean r106 = false;
        if (StringsKt.endsWith$default(r102, (String) r105.next(), false, 2, null) == false) goto L11;
    L16:
        if (r106 == true) goto L30;
        HttpUrl r107 = HttpUrl.parse(r103);
        if (r107 == null) goto L30;
        if (r107.queryParameterNames().contains("need_personal_recommend") == true) goto L30;
        if (SettingRepoDelegate.f307752b.R0() == false) goto L27;
        String r108 = "1";
    L28:
        HttpUrl.a r109 = r107.newBuilder();
        r109.a("need_personal_recommend", r108);
        r103 = r109.b().url().toString();
        goto L30
    L27:
        r108 = "0";
    L15:
        r106 = true;
        goto L16
    L7:
        if (r104.isEmpty() == false) goto L9;
    L30:
        return r100.proceed(r101.newBuilder().url(r103).build());
    }
}
