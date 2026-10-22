package com.bytedance.locallife.live.goodsshelves.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/adapter/HeaderAndFooterRecyclerViewAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedListAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class HeaderAndFooterRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f259511b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f259512a;

    public static final class a {
    }

    static {
    }

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract VH onCreateBasicViewHolder(ViewGroup r100, int r101);

    public VH onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    public abstract void y2(VH r100, int r101, List<Object> r102);

    public abstract void z2();

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = super.getItemCount();
        if (this.f259512a == true) goto L5;
        return r100;
    L5:
        return r100 + 1;
    }

    public HeaderAndFooterRecyclerViewAdapter(LiveLocalLifePagedGoodsAdapter$Companion$DIFF_CALLBACK$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f259512a == false) goto L8;
        if (r100 < (getItemCount() - 1)) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return getBasicItemViewType(r100 + 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        final RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        ((GridLayoutManager) r101).setSpanSizeLookup(new AnonymousClass1(this, r101));
        return;
    }

    @Override // androidx.paging.PagedListAdapter
    public final void onCurrentListChanged(PagedList<T> r100) {
        super.onCurrentListChanged(r100);
        if (LiveLifeSaaSUtil.C() == false) goto L6;
        z2();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        int r101 = getItemViewType(r100.getLayoutPosition());
        boolean r102 = false;
        if (r101 != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r100.getLayoutPosition();
    L12:
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L15;
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
    L16:
        if (r105 == null) goto L20;
        r105.setFullSpan(r102);
        return;
    L20:
        return;
    L15:
        r105 = null;
        goto L16
    L11:
        r102 = true;
        goto L12
    L5:
        if (r101 == Integer.MAX_VALUE) goto L8;
        r103 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItemViewType(r101);
        if (r102 == Integer.MIN_VALUE) goto L12;
        int r103 = 0;
        if (r102 == Integer.MAX_VALUE) goto L7;
        y2(r100, r101 - 0, null);
        return;
    L7:
        View r104 = r100.itemView;
        if (super.getItemCount() > 0) goto L11;
        r103 = 8;
    L11:
        r104.setVisibility(r103);
        Intrinsics.checkNotNullParameter(r100, "holder");
        return;
    L12:
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != Integer.MIN_VALUE) goto L5;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNull(null);
        return null;
    L5:
        if (r101 != Integer.MAX_VALUE) goto L10;
        VH r102 = (VH) onCreateFooterViewHolder(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    L10:
        return (VH) onCreateBasicViewHolder(r100, r101);
    }

    @Override // androidx.paging.PagedListAdapter
    public final void onCurrentListChanged(PagedList<T> r100, PagedList<T> r101) {
        super.onCurrentListChanged(r100, r101);
        if (LiveLifeSaaSUtil.C() == true) goto L6;
        z2();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        int r103 = getItemViewType(r101);
        if (r103 == Integer.MIN_VALUE) goto L12;
        int r104 = 0;
        if (r103 == Integer.MAX_VALUE) goto L7;
        y2(r100, r101 - 0, r102);
        return;
    L7:
        View r105 = r100.itemView;
        if (super.getItemCount() > 0) goto L11;
        r104 = 8;
    L11:
        r105.setVisibility(r104);
        Intrinsics.checkNotNullParameter(r100, "holder");
        return;
    L12:
        Intrinsics.checkNotNullParameter(r100, "holder");
    }
}
