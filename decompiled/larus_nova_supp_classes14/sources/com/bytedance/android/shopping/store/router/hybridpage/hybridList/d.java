package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements n0 {
    public final /* synthetic */ Class a;
    public final /* synthetic */ Function2 b;

    public final Object a(String r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r4.getClass(), this.a) == true) goto L8;
        Object r1 = u0.b(r4, this.a);
        if (r1 != null) goto L13;
        return null;
    L13:
        return this.b.invoke(r1, r4);
    L8:
        return this.b.invoke(r4, r4);
    }

    public d(Class r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }
}
