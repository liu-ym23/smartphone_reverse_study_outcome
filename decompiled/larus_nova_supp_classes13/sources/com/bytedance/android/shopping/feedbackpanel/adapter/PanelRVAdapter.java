package com.bytedance.android.shopping.feedbackpanel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feedbackpanel.viewholder.PanelRVVH;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import de3.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/adapter/PanelRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<c> a;
    public ce3.c b;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public PanelRVAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (r3 >= ((ArrayList) this.a).size()) goto L10;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if ((r2 instanceof PanelRVVH) == false) goto L11;
        ((PanelRVVH) r2).T3((c) ListProtector.get(this.a, r3), this.b);
        return;
    L11:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PanelRVVH(LayoutInflater.from(r4.getContext()).inflate(2131560572, r4, false));
    }
}
