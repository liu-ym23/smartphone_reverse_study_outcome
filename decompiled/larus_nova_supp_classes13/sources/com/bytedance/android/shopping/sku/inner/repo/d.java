package com.bytedance.android.shopping.sku.inner.repo;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v96.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function0 b;

    public d(Function0 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r7) {
        SsResponse r8 = (SsResponse) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        Function0 r1 = this.a;
        if (r1 == null) goto L5;
        Unit r2 = (Unit) r1.invoke();
    L5:
        int r3 = c.a;
        Intrinsics.checkNotNullParameter(r8, "it");
        a r0 = (a) GsonProtectorUtils.fromJson(u0.c(), (String) r8.body(), a.class);
        List r4 = r8.headers();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Header r9 = (Header) r6.next();
        r5.add(new k(r9.getName(), r9.getValue()));
        goto L7
    L9:
        ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r0).a = r5;
        Function0 r10 = this.b;
        if (r10 == null) goto L13;
        Unit r11 = (Unit) r10.invoke();
    L13:
        return TuplesKt.to(r0, r8);
    }
}
