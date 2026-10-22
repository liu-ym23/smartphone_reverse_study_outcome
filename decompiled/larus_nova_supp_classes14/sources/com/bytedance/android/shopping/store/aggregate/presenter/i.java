package com.bytedance.android.shopping.store.aggregate.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.status.ECShopAggregatePageLoadingStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ ShopAggregatePageProductGroupPresenter a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ LazyStatusView c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ Ref.ObjectRef e;

    public i(ShopAggregatePageProductGroupPresenter r1, ViewGroup r2, LazyStatusView r3, Context r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void onChanged(Object r8) {
        LoadStatus r9 = (LoadStatus) r8;
        this.b.setVisibility(0);
        if (this.a.g == false) goto L6;
        this.c.a(new ECShopAggregatePageLoadingStatusView(this.d).a());
    L6:
        if (r9 == null) goto L15;
        int r10 = e.a[r9.ordinal()];
        if (r10 != 1) goto L11;
        ((View) this.e.element).setVisibility(4);
        ((TextView) this.a.Z().b(2131391852).f()).setVisibility(8);
        this.c.b(com.bytedance.android.ec.store.status.b.c.a);
    L20:
        this.a.g = true;
        return;
    L11:
        if (r10 != 2) goto L13;
        this.b.setVisibility(8);
        ((View) this.e.element).setVisibility(0);
        Ref.ObjectRef r11 = this.e;
        r11.element = this.a.Z().b(2131391853).f();
        ((TextView) this.a.Z().b(2131391852).f()).setVisibility(8);
        goto L20
    L13:
        if (r10 == 3) goto L17;
        if (r10 != 4) goto L15;
        ((TextView) this.a.Z().b(2131391852).f()).setVisibility(8);
        ((View) this.e.element).setVisibility(0);
        Ref.ObjectRef r12 = this.e;
        r12.element = this.a.Z().b(2131391853).f();
        ((View) this.e.element).setVisibility(4);
        this.c.b(com.bytedance.android.ec.store.status.b.a.a);
        goto L20
    L17:
        ((TextView) this.a.Z().b(2131391852).f()).setVisibility(8);
        ((View) this.e.element).setVisibility(4);
        this.c.b(com.bytedance.android.ec.store.status.b.b.a);
    L15:
        this.b.setVisibility(8);
        goto L20
    }
}
