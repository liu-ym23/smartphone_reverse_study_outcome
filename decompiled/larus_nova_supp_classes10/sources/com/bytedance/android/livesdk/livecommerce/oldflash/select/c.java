package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends RecyclerView.Adapter<d> {
    public final List<b> a;
    public final View.OnClickListener b;

    public final int getItemCount() {
        return this.a.size();
    }

    public c(List r2, LiveFlashSelectDialogFragment.c r3) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        Intrinsics.checkNotNullParameter(r3, "onItemClickListener");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        d r6 = (d) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        b r7 = (b) ListProtector.get(this.a, r5);
        TextView r0 = r6.a;
        r0.setText(r7.a);
        Context r1 = r0.getContext();
        if (r7.b == false) goto L5;
        int r2 = 2131101581;
    L6:
        r0.setTextColor(th.a.a(r1, r2));
        ImageView r3 = r6.b;
        if (r7.b == false) goto L9;
        int r8 = 0;
    L10:
        r3.setVisibility(r8);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(this.b);
        return;
    L9:
        r8 = 8;
        goto L10
    L5:
        r2 = 2131101610;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new d(th.a.c(r4.getContext(), 2131560709, r4, false));
    }
}
