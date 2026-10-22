package com.bytedance.ies.sve_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sve_list.a;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005:\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/sve_list/SVEAdapter;", "Lcom/bytedance/ies/sve_list/a;", "Item", "Landroidx/recyclerview/widget/RecyclerView;", "RV", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/ies/sve_list/SVEViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sve-view_release"}, k = 1, mv = {1, 4, 0})
public final class SVEAdapter<Item extends com.bytedance.ies.sve_list.a, RV extends RecyclerView> extends ListAdapter<Item, SVEViewHolder<Item>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Item> f248721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, SVEAdapter<Item, RV>, RecyclerViewItemWidget<? extends Item>> f248722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerList<?, Item, RV> f248723c;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getItem(r100).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        SVEViewHolder r101 = (SVEViewHolder) r100;
        super.onViewAttachedToWindow(r101);
        RecyclerViewItemWidget<Item> r102 = r101.f248724a;
        r102.getClass();
        Objects.toString(r102.f248718f);
        r102.Aq(RecyclerViewItemWidget$onAttach$1.INSTANCE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        SVEViewHolder r101 = (SVEViewHolder) r100;
        super.onViewDetachedFromWindow(r101);
        RecyclerViewItemWidget<Item> r102 = r101.f248724a;
        r102.getClass();
        Objects.toString(r102.f248718f);
        r102.Aq(RecyclerViewItemWidget$onDetach$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ListAdapter
    public final void submitList(List<? extends Item> r100) {
        ArrayList r101 = (ArrayList) this.f248721a;
        r101.clear();
        if (r100 == 0) goto L5;
        r101.addAll(r100);
    L5:
        super.submitList(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SVEAdapter(Function2<? super Integer, ? super SVEAdapter<Item, RV>, ? extends RecyclerViewItemWidget<? extends Item>> r100, RecyclerList<?, Item, RV> r101) {
        super(new SVEListDiff());
        this.f248722b = r100;
        this.f248723c = r101;
        this.f248721a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SVEViewHolder r102 = (SVEViewHolder) r100;
        Item r103 = getItem(r101);
        r102.f248724a.wj(r103);
        r102.f248724a.Pq(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        RecyclerViewItemWidget<? extends Item> r102 = this.f248722b.invoke(Integer.valueOf(r101), this);
        if (r102.Qq() == false) goto L5;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sve_recycler_list_item_fix_size, r100, false);
    L6:
        RecyclerList<?, Item, RV> r104 = this.f248723c;
        Integer r105 = Integer.valueOf(R.id.sve_list_item);
        if (r103 == null) goto L11;
        r102.Cq(r104, r105, (ViewGroup) r103);
        return new SVEViewHolder(r102);
    L11:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.sve_recycler_list_item, r100, false);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        super.onBindViewHolder((SVEViewHolder) r100, r101, r102);
    }
}
