package com.larus.business.debug.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.adapter.viewHolder.EntranceGroupViewHolder;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import zv8.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntrancePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceGroupViewHolder;", "entranceGroupList", "", "Lcom/larus/business/debug/base/register/EntranceGroup;", "page", "Lcom/larus/business/debug/base/register/EntrancePage;", "<init>", "(Ljava/util/List;Lcom/larus/business/debug/base/register/EntrancePage;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "payloads", "", "onViewRecycled", "refreshData", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntrancePageAdapter extends RecyclerView.Adapter<EntranceGroupViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<EntranceGroup> f319952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EntrancePage f319953b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f319952a.size();
    }

    public final void y2() {
        k r100 = k.f573760a;
        EntrancePage r101 = this.f319953b;
        r100.getClass();
        List r102 = k.c(r101);
        DiffUtil.calculateDiff(new EntrancePageDiffCallback(this.f319952a, r102)).dispatchUpdatesTo(this);
        List<EntranceGroup> r103 = this.f319952a;
        if (TypeIntrinsics.isMutableList(r103) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L9;
        r103.clear();
        r103.addAll(r102);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        EntranceGroupViewHolder r101 = (EntranceGroupViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        TextView r102 = r101.f319961c;
        if (r102 == null) goto L5;
        r102.setText("");
    L5:
        r101.f319961c = null;
        r101.f319960b = null;
        r101.f319962d = null;
    }

    public EntrancePageAdapter(List<EntranceGroup> r100, EntrancePage r101) {
        Intrinsics.checkNotNullParameter(r100, "entranceGroupList");
        Intrinsics.checkNotNullParameter(r101, "page");
        this.f319952a = r100;
        this.f319953b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        EntranceGroupViewHolder r102 = (EntranceGroupViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((EntranceGroup) ListProtector.get(this.f319952a, r101), this.f319953b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new EntranceGroupViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_debug_entrance_group_item, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        EntranceGroupViewHolder r103 = (EntranceGroupViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        r103.T3((EntranceGroup) ListProtector.get(this.f319952a, r101), this.f319953b);
    }
}
