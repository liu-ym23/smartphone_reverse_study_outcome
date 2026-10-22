package com.larus.home.impl.main.side_bar.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.home.impl.databinding.LarusItemSideBarDividerBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/SideBarDividerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ItemStyle.ITEM_STYLE_DIVIDER, "Lcom/larus/home/impl/main/side_bar/data/Divider;", "<init>", "(Lcom/larus/home/impl/main/side_bar/data/Divider;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "Lcom/larus/home/impl/main/side_bar/view/adapter/ShowDividerHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarDividerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.data.f f344936a;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 2147483547;
    }

    public SideBarDividerAdapter(com.larus.home.impl.main.side_bar.data.f r100) {
        Intrinsics.checkNotNullParameter(r100, ItemStyle.ITEM_STYLE_DIVIDER);
        this.f344936a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof ShowDividerHolder) == false) goto L5;
        ShowDividerHolder r102 = (ShowDividerHolder) r100;
    L6:
        if (r102 != null) goto L9;
        FLogger.f375446a.e("SideBarDividerAdapter", "unexpected holder=" + r100.getClass().getName() + " position=" + r101);
        return;
    L9:
        r102.T3(this.f344936a);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ShowDividerHolder(LarusItemSideBarDividerBinding.a(LayoutInflater.from(r100.getContext()), r100));
    }
}
