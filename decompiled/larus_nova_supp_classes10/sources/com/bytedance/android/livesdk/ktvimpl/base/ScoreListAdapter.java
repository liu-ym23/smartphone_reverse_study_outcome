package com.bytedance.android.livesdk.ktvimpl.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter$ScoreViewHolder;", "ScoreViewHolder", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScoreListAdapter extends RecyclerView.Adapter<ScoreViewHolder> {
    public List<q> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/ScoreListAdapter$ScoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class ScoreViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public ScoreViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390041);
            this.b = (TextView) r2.findViewById(2131390089);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public ScoreListAdapter(List<q> r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreItems");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ScoreViewHolder r8 = (ScoreViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        q r9 = (q) ListProtector.get(this.a, r7);
        r8.a.setText(r9.a);
        TextView r0 = r8.b;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0.setText(String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(r9.b)}, 1)));
        if (r9.c == false) goto L6;
        r8.b.setTextColor(ColorProtector.parseColor("#FF4081"));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ScoreViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131561666, r3, false));
    }
}
