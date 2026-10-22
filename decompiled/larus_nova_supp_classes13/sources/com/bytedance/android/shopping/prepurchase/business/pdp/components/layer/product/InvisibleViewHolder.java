package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/InvisibleViewHolder;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InvisibleViewHolder extends JediSimpleViewHolder<Object> {
    public final Function1<Object, Unit> l;

    public final void a4(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.l.invoke(r2);
    }

    public InvisibleViewHolder(ViewGroup r2, Function1<Object, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(new View(r2.getContext()));
        this.l = r3;
    }
}
