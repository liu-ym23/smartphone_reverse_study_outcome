package com.bytedance.android.shopping.store.hybridproduct;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public p(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        if (((Boolean) r8).booleanValue() == false) goto L34;
        this.a.m0().resetUniqueKey();
        this.a.m0().getIdRecords().clear();
        this.a.m0().resetDisposable();
        ECShopHybridProductListPresenter r9 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$refreshFilterY");
        ECHybridListEngine r0 = r9.n;
        if (r0 == null) goto L13;
        BaseViewHolder r1 = r0.e("__FILTER_SECTION__", "666");
        if (r1 == null) goto L13;
        if (((RecyclerView.ViewHolder) r1).itemView.getY() >= 0) goto L13;
        ((RecyclerView.ViewHolder) r1).itemView.setY(0.0f);
    L13:
        r9.v.clear();
        ((ArrayList) r9.w).clear();
        CompositeDisposable r2 = r9.J;
        if (r2 == null) goto L16;
        r2.dispose();
    L16:
        ECHybridListEngine r3 = r9.n;
        if (r3 == null) goto L22;
        ECHybridRecyclerView r4 = r3.b;
        if (r4 == null) goto L22;
        r4.stopScroll();
    L22:
        if (r9.m0().getRefreshAll() == false) goto L24;
        r9.t = Float.valueOf(0.0f);
        r9.m0().setRefreshAll(false);
    L32:
        r9.I = new s(r9);
        this.a.s = true;
        return;
    L24:
        ECHybridListEngine r5 = r9.n;
        if (r5 == null) goto L31;
        BaseViewHolder r6 = r5.e("__FILTER_SECTION__", "666");
        if (r6 == null) goto L31;
        View r7 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r7 == null) goto L31;
        r9.t = Float.valueOf(r7.getY() + r7.getHeight());
    L31:
        r9.t = Float.valueOf(0.0f);
        Unit r10 = Unit.INSTANCE;
        goto L32
    }
}
