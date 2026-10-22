package com.bytedance.locallife.poi.view.mall.filter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.locallife.poi.poidetail.container.mob.h;
import com.bytedance.locallife.poi.view.mall.model.FilterLevel;
import com.bytedance.locallife.poi.view.mall.model.MallFilterStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/filter/PoiMallFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/view/mall/filter/PoiMallFilterItemViewHolder;", "Lcom/bytedance/locallife/poi/view/mall/filter/PoiMallFilterItemViewHolder$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMallFilterAdapter extends RecyclerView.Adapter<PoiMallFilterItemViewHolder> implements PoiMallFilterItemViewHolder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MallFilterStruct> f264234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<MallFilterStruct> f264235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f264236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MallFilterStruct f264237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FilterLevel f264238e;

    public interface a {
        void a(View r100, MallFilterStruct r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<MallFilterStruct> r100 = this.f264234a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public PoiMallFilterAdapter() {
        this.f264238e = FilterLevel.FIRST_LEVEL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PoiMallFilterItemViewHolder r102 = (PoiMallFilterItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<MallFilterStruct> r103 = this.f264234a;
        if (r103 == null) goto L22;
        MallFilterStruct r104 = (MallFilterStruct) ListProtector.get(r103, r101);
        if (r104 == null) goto L23;
        Intrinsics.areEqual(r104, this.f264237d);
        FilterLevel r105 = this.f264238e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "level");
        r102.f264241c.setText(r104.getOptionText());
        TextView r106 = r102.f264241c;
        if (r106 == null) goto L9;
        h.a(r106, 14.0f);
    L9:
        r102.itemView.setOnClickListener(new com.bytedance.locallife.poi.view.mall.filter.a(r102, r104, r101));
        TextView r107 = r102.f264241c;
        if (r104.isSelected() == false) goto L12;
        int r108 = r102.f264243e;
    L13:
        r107.setTextColor(r108);
        if (r105 != FilterLevel.FIRST_LEVEL) goto L20;
        View r109 = r102.itemView;
        Context r110 = r102.f264239a.getContext();
        if (r104.isSelected() == false) goto L18;
        int r111 = R.color.POIBgPlaceholder2;
    L19:
        r109.setBackgroundColor(ContextCompat.getColor(r110, r111));
        goto L20
    L18:
        r111 = R.color.POIBgPrimary;
    L20:
        Intrinsics.checkNotNullParameter(this, "listener");
        r102.f264240b = this;
        return;
    L12:
        r108 = r102.f264242d;
        goto L13
    L23:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PoiMallFilterItemViewHolder(r100);
    }

    @Override // com.bytedance.locallife.poi.view.mall.filter.PoiMallFilterItemViewHolder.a
    public final void j2(View r100, MallFilterStruct r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f264237d = r101;
        List<MallFilterStruct> r103 = this.f264235b;
        if (r103 == null) goto L13;
        Iterator<MallFilterStruct> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        List<MallFilterStruct> r105 = r104.next().getChildOptions();
        if (r105 == null) goto L6;
        Iterator<MallFilterStruct> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L6;
        r106.next().setSelected(false);
    L13:
        List<MallFilterStruct> r107 = this.f264234a;
        if (r107 == null) goto L22;
        int r108 = r107.size();
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L22;
        MallFilterStruct r110 = (MallFilterStruct) ListProtector.get(r107, r109);
        if (r109 != r102) goto L20;
        boolean r111 = true;
    L21:
        r110.setSelected(r111);
        r109 = r109 + 1;
        goto L16
    L20:
        r111 = false;
    L22:
        a r112 = this.f264236c;
        if (r112 == null) goto L34;
        r112.a(r100, r101);
        return;
    }

    public final void y2(List<MallFilterStruct> r100, List<MallFilterStruct> r101, FilterLevel r102) {
        Intrinsics.checkNotNullParameter(r102, "level");
        this.f264234a = r100;
        this.f264238e = r102;
        this.f264235b = r101;
        if (r100 == null) goto L14;
        Iterator<MallFilterStruct> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        MallFilterStruct r104 = r103.next();
        if (r104.isSelected() == false) goto L6;
        this.f264237d = r104;
        return;
    L15:
        return;
    }
}
