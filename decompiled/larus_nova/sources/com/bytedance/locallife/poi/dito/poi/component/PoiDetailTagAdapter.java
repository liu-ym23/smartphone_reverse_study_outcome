package com.bytedance.locallife.poi.dito.poi.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.poi.dito.poi.entity.PoiTag;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/PoiDetailTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/dito/poi/component/PoiDetailTagViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailTagAdapter extends RecyclerView.Adapter<PoiDetailTagViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PoiTag> f262437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f262438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f262439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Integer, PoiTag, Boolean> f262440d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f262437a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        PoiDetailTagViewHolder r112 = (PoiDetailTagViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        PoiTag r100 = (PoiTag) ListProtector.get(this.f262437a, r111);
        int r101 = this.f262438b;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "poiTag");
        if (r100.getCount() < 0) goto L5;
        String r102 = r100.getDisplayText() + '(' + r100.getCount() + ')';
    L6:
        r112.f262453a.setText(r102);
        DuxTextView r103 = r112.f262453a;
        String r104 = "";
        if (r111 != r101) goto L13;
        Context r105 = r112.itemView.getContext();
        Object[] r106 = new Object[1];
        String r107 = r100.getDisplayText();
        if (r107 == null) goto L12;
        r104 = r107;
    L12:
        r106[0] = r104;
        r104 = r105.getString(R.string.poi_ugc_tag_selected_talkback, r106);
    L17:
        r103.setContentDescription(r104);
        if (r111 != r101) goto L23;
        r112.f262453a.setTextColor(r112.f262455c);
        r112.f262453a.getPaint().setFakeBoldText(true);
        if (TextUtils.isEmpty(r100.getSelectedImage()) == true) goto L22;
        String r113 = r100.getSelectedImage();
        Intrinsics.checkNotNull(r113);
        r112.T3(r113);
        return;
    L22:
        r112.f262454b.setVisibility(8);
        return;
    L23:
        r112.f262453a.setTextColor(r112.f262456d);
        r112.f262453a.getPaint().setFakeBoldText(false);
        if (TextUtils.isEmpty(r100.getUnSelectedImage()) == true) goto L26;
        String r114 = r100.getUnSelectedImage();
        Intrinsics.checkNotNull(r114);
        r112.T3(r114);
        return;
    L26:
        r112.f262454b.setVisibility(8);
        return;
    L13:
        String r108 = r100.getDisplayText();
        if (r108 == null) goto L17;
        r104 = r108;
        goto L17
    L5:
        r102 = r100.getDisplayText();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_detail_tag_layout, r100, false);
        PoiDetailTagViewHolder r103 = new PoiDetailTagViewHolder(r102);
        r102.setOnClickListener(new g(r102, r103, this, r102));
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PoiDetailTagAdapter(List<PoiTag> r100, int r101, RecyclerView r102, Function2<? super Integer, ? super PoiTag, Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "poiTagDataList");
        Intrinsics.checkNotNullParameter(r103, "selectAction");
        this.f262437a = r100;
        this.f262438b = r101;
        this.f262439c = r102;
        this.f262440d = r103;
    }
}
