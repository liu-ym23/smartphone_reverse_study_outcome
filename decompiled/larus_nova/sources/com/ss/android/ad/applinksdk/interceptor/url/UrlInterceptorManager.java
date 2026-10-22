package com.ss.android.ad.applinksdk.interceptor.url;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ad.applinksdk.interceptor.InterceptorModel;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes34.dex */
public final class UrlInterceptorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f406374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f406375b = null;

    static {
        f406374a = LazyKt.lazy(UrlInterceptorManager$commonInterceptors$2.INSTANCE);
        f406375b = LazyKt.lazy(UrlInterceptorManager$allInterceptors$2.INSTANCE);
    }

    public static AppLinkResult a(ira.e r100, Context r101, List r102) {
        Lazy r103 = f406375b;     // Catch: Exception -> L7
        ((List) r103.getValue()).clear();     // Catch: Exception -> L7
        ((List) r103.getValue()).addAll((List) f406374a.getValue());     // Catch: Exception -> L7
        if (r102 == null) goto L5;
        ((List) r103.getValue()).addAll(((List) r103.getValue()).size() - 1, r102);     // Catch: Exception -> L7
    L5:
        List r104 = (List) f406375b.getValue();
        return ((com.ss.android.ad.applinksdk.interceptor.a) ListProtector.get(r104, 0)).intercept(new com.ss.android.ad.applinksdk.interceptor.b(r104, new InterceptorModel(r100, r101), 1));
    }
}
