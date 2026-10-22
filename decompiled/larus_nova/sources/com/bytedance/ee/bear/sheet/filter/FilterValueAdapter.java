package com.bytedance.ee.bear.sheet.filter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$ViewHolder;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "<init>", "(Ljava/util/List;)V", "selectedChangeListener", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$OnSelectedChangeListener;", "getSelectedChangeListener", "()Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$OnSelectedChangeListener;", "setSelectedChangeListener", "(Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$OnSelectedChangeListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getSearchResult", "setData", "newList", "ViewHolder", "OnSelectedChangeListener", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterValueAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<FilterData.FilterOptionItem> f237713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f237714b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter;Landroid/view/View;)V", "valueTV", "Landroid/widget/TextView;", "getValueTV", "()Landroid/widget/TextView;", "countTV", "getCountTV", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f237715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f237716b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UDCheckBox f237717c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f237715a = (TextView) r100.findViewById(R.id.filter_value_text);
            this.f237716b = (TextView) r100.findViewById(R.id.filter_value_count);
            this.f237717c = (UDCheckBox) r100.findViewById(R.id.filter_value_check_box);
        }
    }

    public interface a {
        void c20();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f237713a.size();
    }

    public FilterValueAdapter(List<FilterData.FilterOptionItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "valueList");
        this.f237713a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.itemView.setOnClickListener(new q(r102));
        r102.f237717c.setOnClickListener(new r(r101, this, r102));
        FilterData.FilterOptionItem r103 = (FilterData.FilterOptionItem) ListProtector.get(this.f237713a, r101);
        r102.f237715a.setText(r103.getValue());
        r102.f237716b.setText(String.valueOf(r103.getCount()));
        r102.f237717c.setChecked(r103.isSelect());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_filter_value_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
