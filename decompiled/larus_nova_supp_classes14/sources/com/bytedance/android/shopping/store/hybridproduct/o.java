package com.bytedance.android.shopping.store.hybridproduct;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ LazyStatusView b;

    public o(ECShopHybridProductListPresenter r1, LazyStatusView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        LoadStatus r5 = (LoadStatus) r4;
        ViewGroup r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusViewContainer");
    L5:
        r0.setVisibility(0);
        if (r5 == null) goto L16;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L11;
        Float r7 = this.a.t;
        if (r7 == null) goto L29;
        float r8 = r7.floatValue();
        this.b.setY(r8);
    L29:
        this.b.b(com.bytedance.android.ec.store.status.b.c.a);
        return;
    L11:
        if (r6 != 2) goto L13;
        ViewGroup r9 = this.a.o;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("statusViewContainer");
    L25:
        r9.setVisibility(8);
        return;
    L13:
        if (r6 != 3) goto L15;
        this.b.b(com.bytedance.android.ec.store.status.b.b.a);
        return;
    L15:
        if (r6 != 4) goto L16;
        this.b.b(com.bytedance.android.ec.store.status.b.a.a);
        return;
    L16:
        ViewGroup r10 = this.a.o;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("statusViewContainer");
    L19:
        r10.setVisibility(8);
    }
}
