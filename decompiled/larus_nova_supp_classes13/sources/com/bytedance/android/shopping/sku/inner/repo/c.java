package com.bytedance.android.shopping.sku.inner.repo;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final Observable<Pair<com.bytedance.android.shopping.sku.inner.repo.a, SsResponse<String>>> query(boolean r4, ph3.b r5, Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "mapStart");
        Intrinsics.checkNotNullParameter(r7, "mapEnd");
        int r8 = !r4 ? 1 : 0;
        SkuYataApi.a.getClass();
        return ((SkuYataApi) n.a.create("https://ecom.snssdk.com/", SkuYataApi.class)).getQuery(Integer.valueOf(r8), r5).map(new d(r6, r7));
    }
}
