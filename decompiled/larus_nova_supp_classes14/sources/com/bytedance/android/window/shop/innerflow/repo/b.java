package com.bytedance.android.window.shop.innerflow.repo;

import com.google.gson.JsonElement;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import up3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<E, T> {
    public final Map<Integer, Pair<Class<?>, Function1<Object, T>>> a;

    public b(Map<Integer, ? extends Pair<? extends Class<?>, ? extends Function1<Object, ? extends T>>> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a = r2;
    }

    public final Object a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if (r4.a() == null) goto L5;
    L7:
        Pair<Class<?>, Function1<Object, T>> r0 = this.a.get(r4.b());
        if (r0 != null) goto L10;
        return null;
    L10:
        Class r2 = (Class) r0.component1();
        Function1 r1 = (Function1) r0.component2();
        JsonElement r5 = r4.a();
        if (r2 == null) goto L14;
        if (r5 == null) goto L14;
        Object r6 = com.bytedance.android.window.shop.repository.dto.d.a(r5, r2);
    L16:
        if (r6 != null) goto L19;
        return null;
    L19:
        return r1.invoke(r6);
    L14:
        r6 = null;
        goto L16
    L5:
        if (r4.b() != null) goto L7;
        return null;
    }
}
