package com.bytedance.locallife.poi.view.mall.filter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.poi.view.mall.model.MallFilterStruct;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/filter/PoiMallFilterItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMallFilterItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f264239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f264240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f264241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f264242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f264243e;

    public interface a {
        void j2(View r100, MallFilterStruct r101, int r102);
    }

    public PoiMallFilterItemViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_view_poi_collect_filter_panel_item, r100, false));
        this.f264239a = r100;
        this.f264241c = (TextView) this.itemView.findViewById(R.id.poi_collect_filter_panel_item_title);
        this.f264242d = ContextCompat.getColor(r100.getContext(), R.color.POITextPrimary);
        this.f264243e = ContextCompat.getColor(r100.getContext(), R.color.POITextHighlight);
    }
}
