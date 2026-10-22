package com.bytedance.android.shopping.feed.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.feed.view.InflowSkuThumbnail;
import com.bytedance.android.shopping.feed.viewholder.InflowSkuThumbnailVH;
import com.bytedance.android.shopping.feed.widget.InflowSkuWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/InflowSkuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/feed/viewholder/InflowSkuThumbnailVH;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowSkuAdapter extends RecyclerView.Adapter<InflowSkuThumbnailVH> {
    public List<SpecDetail> a;
    public rd3.a b;
    public InflowSkuWidget c;
    public String d;

    public final int getItemCount() {
        List<SpecDetail> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public InflowSkuAdapter() {
        this.d = "MAIN_PIC";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        InflowSkuThumbnailVH r10 = (InflowSkuThumbnailVH) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        List<SpecDetail> r0 = this.a;
        View r1 = null;
        if (r0 == null) goto L5;
        SpecDetail r11 = (SpecDetail) CollectionsKt.getOrNull(r0, r9);
    L6:
        rd3.a r2 = this.b;
        InflowSkuWidget r3 = this.c;
        String r4 = this.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r4, "selectedSpecId");
        View r5 = ((RecyclerView.ViewHolder) r10).itemView;
        if ((r5 instanceof InflowSkuThumbnail) == true) goto L9;
        r5 = null;
    L9:
        InflowSkuThumbnail r6 = (InflowSkuThumbnail) r5;
        if (r6 == null) goto L18;
        if (r11 == null) goto L18;
        r6.a();
        r6.a = r11;
        List r7 = r11.getImgList();
        if (r7 == null) goto L18;
        ECUrlModel r12 = (ECUrlModel) CollectionsKt.firstOrNull(r7);
        if (r12 == null) goto L18;
        ImageExtensionsKt.v(r6.b, r12, null, 8190);
    L18:
        View r13 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r11 == null) goto L21;
        Long r14 = Long.valueOf(r11.getSpecDetailId());
    L22:
        r13.setTag(String.valueOf(r14));
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new com.bytedance.android.shopping.feed.viewholder.b(r10, r2, r3));
        if (Intrinsics.areEqual(r4, ((RecyclerView.ViewHolder) r10).itemView.getTag()) == false) goto L32;
        View r15 = ((RecyclerView.ViewHolder) r10).itemView;
        if ((r15 instanceof InflowSkuThumbnail) == false) goto L28;
        r1 = r15;
    L28:
        InflowSkuThumbnail r16 = (InflowSkuThumbnail) r1;
        if (r16 == null) goto L33;
        r16.c(true);
        return;
    L33:
        return;
    L32:
        return;
    L21:
        r14 = null;
        goto L22
    L5:
        r11 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new InflowSkuThumbnailVH(new InflowSkuThumbnail(r4.getContext(), null, 6, 0));
    }
}
