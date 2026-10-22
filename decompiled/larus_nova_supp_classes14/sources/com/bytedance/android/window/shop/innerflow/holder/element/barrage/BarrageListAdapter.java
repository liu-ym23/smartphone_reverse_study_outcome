package com.bytedance.android.window.shop.innerflow.holder.element.barrage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wp3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageListItemHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageListAdapter extends RecyclerView.Adapter<BarrageListItemHolder> {
    public final List<a.C0181a> a;

    public final int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public BarrageListAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BarrageListItemHolder r5 = (BarrageListItemHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        if (((ArrayList) this.a).size() == 0) goto L10;
        List<a.C0181a> r0 = this.a;
        a.C0181a r6 = (a.C0181a) ListProtector.get(r0, r4 % ((ArrayList) r0).size());
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "vo");
        String r1 = r6.a;
        if (r1 == null) goto L11;
        r5.a.setText(r1);
        r5.b.setText(Intrinsics.stringPlus(r6.b, " "));
        return;
    L11:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new BarrageListItemHolder(LayoutInflater.from(r2.getContext()).inflate(2131560883, null));
    }
}
