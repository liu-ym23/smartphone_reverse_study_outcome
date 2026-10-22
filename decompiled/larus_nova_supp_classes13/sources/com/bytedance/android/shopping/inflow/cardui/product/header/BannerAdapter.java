package com.bytedance.android.shopping.inflow.cardui.product.header;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.inflow.cardui.product.header.vh.BannerFooterVH;
import com.bytedance.android.shopping.inflow.cardui.product.header.vh.BannerImageVH;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int c = 0;
    public final List<ECUrlModel> a;
    public final b b;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BannerAdapter a;

        public b(BannerAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            BannerAdapter r3 = this.a;
            int r0 = BannerAdapter.c;
            r3.getClass();
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size() + 1;
    }

    public BannerAdapter() {
        this.a = new ArrayList();
        this.b = new b(this);
    }

    public final int getItemViewType(int r2) {
        if (r2 >= ((ArrayList) this.a).size()) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        if ((r10 instanceof BannerImageVH) == false) goto L6;
        BannerImageVH r0 = (BannerImageVH) r10;
        ECUrlModel r2 = (ECUrlModel) ListProtector.get(this.a, r11);
        h0.d(r0.a, r2, r0.c, null, null, null, null, 120);
        r0.b.setVisibility(8);
        r10.itemView.setOnClickListener(this.b);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 1) goto L5;
        int r5 = BannerFooterVH.b;
        return BannerFooterVH.a.a(r3);
    L5:
        int r6 = BannerImageVH.d;
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new BannerImageVH(LayoutInflater.from(r3.getContext()).inflate(2131564829, r3, false));
    }
}
