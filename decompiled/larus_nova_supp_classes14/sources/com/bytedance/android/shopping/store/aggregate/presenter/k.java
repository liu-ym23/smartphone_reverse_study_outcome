package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ShopAggregatePageProductListPresenter a;

    public k(ShopAggregatePageProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        p r4 = (p) r3;
        if (r4 == null) goto L21;
        String r0 = r4.a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L22;
        View r2 = this.a.i;
        if (r2 == null) goto L16;
        r2.setVisibility(0);
    L16:
        View r5 = this.a.i;
        if (r5 == null) goto L19;
        r5.setOnClickListener(new j(this, r4));
    L19:
        this.a.Z().b(2131391853).f().addOnScrollListener(new ShopAggregatePageProductListPresenter$setupFloatCartEntry$1$2(this));
        return;
    L22:
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    }
}
