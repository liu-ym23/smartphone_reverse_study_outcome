package com.bytedance.iesgurd.strategy;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Interceptor {
    public c() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) throws Exception {
        Request r100 = r110.request();
        SsResponse<?> r111 = r110.proceed(r100);
        List<Header> r101 = r111.headers();
        if (r101 == null) goto L18;
        Iterator<Header> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Header r103 = r102.next();
        if (r103 == null) goto L12;
        String r104 = r103.getName();
        if (r104 == null) goto L12;
        String r105 = r104.toLowerCase(Locale.ROOT);
    L14:
        if (Intrinsics.areEqual(r105, "x-tlb-probe") == false) goto L6;
        String r106 = e.f250861a;
        String r107 = r100.getHost() + r100.getPath();
        String r108 = r103.getValue();
        dz5.c r109 = dz5.c.a.f470586a;
        r109.f470585a.b(new d(r108, r107), 0, 0);
    L12:
        r105 = null;
    L16:
        return r111;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.bytedance.retrofit2.client.Header?>");
    }
}
