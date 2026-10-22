package com.bytedance.locallife.pdp.biz.common.cache;

import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import yw6.n;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f261015a = null;

    static {
        f261015a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SsResponse r101 = (SsResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "originResponse");
        n r102 = (n) r101.body();
        String r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.a());
    L6:
        String r105 = String.valueOf(r104);
        if (r102 == null) goto L9;
        String r106 = r102.b();
    L10:
        if (r102 == null) goto L12;
        DitoPage r107 = r102.d();
    L13:
        List<Header> r108 = r101.headers();
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r108, 10)), 16));
        Iterator<T> r110 = r108.iterator();
    L15:
        if (r110.hasNext() == false) goto L17;
        Header r111 = (Header) r110.next();
        Pair r112 = TuplesKt.to(r111.getName(), r111.getValue());
        r109.put(r112.getFirst(), r112.getSecond());
        goto L15
    L17:
        lp6.a r113 = new lp6.a(r107, r109, 4);
        if (r102 == null) goto L21;
        r103 = r102.c();
    L21:
        return new xw6.a(r105, r106, r103, r113);
    L12:
        r107 = null;
        goto L13
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
