package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class e extends d {
    public final String b;
    public final Function0<LayoutTypes> c;

    public final LayoutTypes c() {
        return (LayoutTypes) this.c.invoke();
    }

    public final r j(Integer r1) {
        int r2 = r.h;
        return r.a.c(this.b);
    }

    public e(ShopAggregatePageProductViewModel r2, String r3, Function0<? extends LayoutTypes> r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "imageScene");
        Intrinsics.checkNotNullParameter(r4, "layoutTypeProvider");
        super(r2);
        this.b = r3;
        this.c = r4;
    }
}
