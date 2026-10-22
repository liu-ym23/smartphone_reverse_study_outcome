package com.bytedance.android.livesdk.ktvimpl.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.r;
import com.bytedance.android.livesdk.ktvimpl.base.viewholder.KtvGroupUserViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/adapter/KtvGroupUserListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewholder/KtvGroupUserViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupUserListAdapter extends RecyclerView.Adapter<KtvGroupUserViewHolder> {
    public final ArrayList<r> a;
    public final LayoutInflater b;

    public final int getItemCount() {
        return this.a.size();
    }

    public KtvGroupUserListAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new ArrayList();
        this.b = LayoutInflater.from(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        KtvGroupUserViewHolder r4 = (KtvGroupUserViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "vh");
        r4.T3((r) ListProtector.get(this.a, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        return new KtvGroupUserViewHolder(this.b.inflate(2131566498, r4, false));
    }
}
