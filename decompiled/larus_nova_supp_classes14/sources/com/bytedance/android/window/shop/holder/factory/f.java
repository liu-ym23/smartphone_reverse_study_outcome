package com.bytedance.android.window.shop.holder.factory;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements n0 {
    public final /* synthetic */ Class a;
    public final /* synthetic */ Function1 b;

    public final Object a(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r4 = u0.b(r3, this.a);
        if (r4 != null) goto L9;
        return null;
    L9:
        return this.b.invoke(r4);
    }

    public f(Class r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
