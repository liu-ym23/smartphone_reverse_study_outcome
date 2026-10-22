package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import androidx.collection.LruCache;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o<T, R> implements Function {
    public final /* synthetic */ List a;

    public o(List r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        Object[] r8 = (Object[]) r7;
        Intrinsics.checkNotNullParameter(r8, "rets");
        Iterator<T> r9 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r8, w.b.class), new n()).iterator();
        int r0 = 0;
    L4:
        if (r9.hasNext() == false) goto L13;
        T r1 = r9.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        w.b r3 = (w.b) r1;
        h r4 = new h(r3.b, r3.e, r3.f);
        this.a.add(r4);
        LruCache<String, h> r5 = InlineLongTitleComponentView.d;
        String r6 = r3.d;
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r5.put(r6, r4);
        r0 = r2;
        goto L4
    L13:
        return Unit.INSTANCE;
    }
}
