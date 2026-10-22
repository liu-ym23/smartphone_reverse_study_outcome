package com.bytedance.android.shopping.collect.repo;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final Observable<Pair<e, SsResponse<String>>> query(qb3.b r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "mapStart");
        Intrinsics.checkNotNullParameter(r6, "mapEnd");
        CollectYataApi.a.getClass();
        return ((CollectYataApi) n.a.create("https://ecom.snssdk.com/", CollectYataApi.class)).getQuery(r4).map(new c(r5, r6));
    }
}
