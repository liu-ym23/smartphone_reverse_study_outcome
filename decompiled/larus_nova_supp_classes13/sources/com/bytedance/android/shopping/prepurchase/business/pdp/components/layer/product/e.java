package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ProductDetailInfoAdapter r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "list");
        DiffableAdapter.DefaultImpls.submitList(r0, r4);
        Function1<? super List<? extends com.bytedance.android.ecom.arch.slice.adapter.b>, Unit> r1 = this.a.d;
        if (r1 == null) goto L9;
        Unit r5 = (Unit) r1.invoke(r4);
        return;
    }
}
