package com.larus.dora.impl.rebind;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraGRebindOpItemBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter$DoraRebindOpAdapterViewHolder;", "descriptions", "", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "DoraRebindOpAdapterViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraRebindOpAdapter extends RecyclerView.Adapter<DoraRebindOpAdapterViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f337810a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter$DoraRebindOpAdapterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;", "<init>", "(Lcom/larus/dora/impl/rebind/DoraRebindOpAdapter;Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;)V", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraGRebindOpItemBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DoraRebindOpAdapterViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraGRebindOpItemBinding f337811a;

        public DoraRebindOpAdapterViewHolder(LarusDoraGRebindOpItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f332664a);
            this.f337811a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f337810a.size();
    }

    public DoraRebindOpAdapter(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptions");
        this.f337810a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        DoraRebindOpAdapterViewHolder r102 = (DoraRebindOpAdapterViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        DoraTextView r103 = r102.f337811a.f332665b;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        r104.append('.');
        int r105 = j0.f375426a;
        r104.append(j0.d(((Number) ListProtector.get(this.f337810a, r101)).intValue()));
        r103.setText(r104.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_dora_g_rebind_op_item, r100, false);
        DoraTextView r103 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_rebind_op_desc_text);
        if (r103 == null) goto L7;
        return new DoraRebindOpAdapterViewHolder(new LarusDoraGRebindOpItemBinding((LinearLayout) r102, r103));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.dora_rebind_op_desc_text)));
    }
}
