package com.bytedance.ee.bear.search.picker.filter.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BD\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/type/SearchSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/search/picker/filter/type/ViewHolder;", "typeItemList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/search/picker/filter/type/SelectTypeItem;", "Lkotlin/collections/ArrayList;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectTypeItem", "", "<init>", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "enableMultiSelect", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "getItemList", "onBindViewHolder", "holder", "position", "handleSelected", MapController.ITEM_LAYER_TAG, "isCheckBox", "enable", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchSelectAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<e> f236895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<e, Unit> f236896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f236897c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f236895a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSelectAdapter(ArrayList<e> r100, Function1<? super e, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "typeItemList");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f236895a = r100;
        this.f236896b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        e r103 = (e) ListProtector.get(this.f236895a, r101);
        CheckBox r104 = r102.f236914a;
        if (this.f236897c == false) goto L5;
        int r105 = 0;
    L6:
        r104.setVisibility(r105);
        r102.f236914a.setChecked(r103.f236927c);
        r102.f236915b.setText(r103.f236925a);
        r102.f236914a.setOnCheckedChangeListener(new a(this, r102, r103));
        r102.itemView.setOnClickListener(new b(this, r102, r103));
        return;
    L5:
        r105 = 8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.search_select_type_item, r100, false));
    }

    public static final void y2(SearchSelectAdapter r100, ViewHolder r101, e r102, boolean r103) {
        if (r100.f236897c == false) goto L7;
        if (r103 == true) goto L6;
        CheckBox r104 = r101.f236914a;
        r104.setChecked(!r104.isChecked());
    L6:
        r102.f236927c = r101.f236914a.isChecked();
        r100.f236896b.invoke(null);
        return;
    L7:
        r100.f236896b.invoke(r102);
    }
}
