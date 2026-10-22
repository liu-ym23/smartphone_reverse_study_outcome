package com.bytedance.locallife.pdp.headimage.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.pdp.headimage.view.viewholder.BaseItemViewHolder;
import com.bytedance.locallife.pdp.headimage.view.viewholder.PicItemViewHolder;
import com.bytedance.locallife.pdp.headimage.view.viewholder.RateItemViewHolder;
import com.bytedance.locallife.pdp.headimage.view.viewholder.VideoItemViewHolder;
import com.bytedance.locallife.pdp.headimage.vo.ItemInfoType;
import com.bytedance.locallife.pdp.settings.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import hx6.a;
import hx6.b;
import java.util.List;
import jx6.i;
import jx6.p;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/HeadImageItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/pdp/headimage/view/viewholder/BaseItemViewHolder;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class HeadImageItemAdapter extends RecyclerView.Adapter<BaseItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<p> f261469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f261470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f261471c;

    public HeadImageItemAdapter() {
        this(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f261469a.size();
    }

    public HeadImageItemAdapter(Object r100) {
        List<p> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "itemInfoList");
        this.f261469a = r101;
        this.f261470b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((p) ListProtector.get(this.f261469a, r100)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        BaseItemViewHolder r101 = (BaseItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.onViewAttachedToWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        BaseItemViewHolder r101 = (BaseItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.U3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseItemViewHolder r102 = (BaseItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        p r103 = (p) ListProtector.get(this.f261469a, r101);
        i r104 = this.f261470b;
        if (r104 != null) goto L5;
        r104 = new i();
    L5:
        r102.T3(r103, r104);
        r102.itemView.setOnClickListener(new a(this, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        boolean r102 = false;
        if (r101 != ItemInfoType.RATE.getType()) goto L6;
        return new RateItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.life_pdp_head_image_rate_item, r100, false), this.f261470b);
    L6:
        if (r101 == ItemInfoType.VIDEO.getType()) goto L19;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.life_pdp_head_image_pic_item, r100, false);
        int r104 = r.f261748a;
        Integer r105 = (Integer) HostServiceUtilsKt.y().a("goodsdetail_head_image_fmp_invalid", Integer.TYPE, 0);
        if (r105 != null) goto L12;
    L14:
        if (r102 == false) goto L17;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.setTag(com.bytedance.locallife.biz.fmp.a.f256694b, Boolean.TRUE);
    L17:
        return new PicItemViewHolder(r103);
    L12:
        if (r105.intValue() != 2) goto L14;
        r102 = true;
        goto L14
    L19:
        return new VideoItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.life_pdp_head_image_video_item, r100, false));
    }
}
