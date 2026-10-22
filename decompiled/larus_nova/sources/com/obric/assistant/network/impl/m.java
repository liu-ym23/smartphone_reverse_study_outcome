package com.obric.assistant.network.impl;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class m implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f390349a;

    public static final class a {
    }

    static {
    }

    public m() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        SsResponse<?> r101 = r100.proceed(r100.request());
        String r102 = null;
        if (r101 == null) goto L26;
        List<Header> r103 = r101.headers();
        if (r103 == null) goto L26;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if ((r106 instanceof Header) == false) goto L8;
        r104.add(r106);
        goto L8
    L12:
        Iterator r107 = r104.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        Object r108 = r107.next();
        if (StringsKt.equals(((Header) r108).getName(), NetResponse.HEADER_KEY_LOG_ID, true) == false) goto L14;
    L19:
        Header r109 = (Header) r108;
        if (r109 == null) goto L26;
        String r110 = r109.getValue();
        if (r110 == null) goto L26;
        if (Boolean.valueOf(!StringsKt.isBlank(r110)).booleanValue() == false) goto L26;
        r102 = r110;
        goto L26
    L18:
        r108 = null;
    L26:
        this.f390349a = r102;
        return r101;
    }
}
