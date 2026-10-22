package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ECShopHorizonSortBarPresenter a;
    public final /* synthetic */ View b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ ImageView d;

    public f(ECShopHorizonSortBarPresenter r1, View r2, TextView r3, ImageView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (this.b.getVisibility() == 0) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L12;
        if (this.a.q.isBrandShopUpgrade() == false) goto L10;
        this.c.setTextColor(this.a.Y().c().getResources().getColor(2131101805));
        this.d.setBackgroundResource(2131234806);
        return;
    L10:
        this.c.setTextColor(this.a.Y().c().getResources().getColor(2131101817));
        this.d.setBackgroundResource(2131234805);
        return;
    L12:
        if (this.a.q.isBrandShopUpgrade() == false) goto L14;
        this.c.setTextColor(this.a.Y().c().getResources().getColor(2131101801));
        this.d.setBackgroundResource(2131234808);
        return;
    L14:
        this.c.setTextColor(this.a.Y().c().getResources().getColor(2131101818));
        this.d.setBackgroundResource(2131234807);
    }
}
