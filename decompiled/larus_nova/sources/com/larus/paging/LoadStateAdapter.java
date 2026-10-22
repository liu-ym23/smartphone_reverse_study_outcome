package com.larus.paging;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.larus.search.impl.global.LoadMoreViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/paging/LoadStateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "paging-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class LoadStateAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f363664a;

    public abstract LoadMoreViewHolder A2(ViewGroup r100, u r101);

    public abstract void z2(VH r100, u r101);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return y2(this.f363664a) ? 1 : 0;
    }

    public LoadStateAdapter() {
        this.f363664a = new u.c(false);
    }

    public static boolean y2(u r100) {
        Intrinsics.checkNotNullParameter(r100, "loadState");
        if ((r100 instanceof u.b) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r100 instanceof u.a) == true) goto L8;
        return false;
    }

    public final void B2(u r100) {
        Intrinsics.checkNotNullParameter(r100, "loadState");
        if (Intrinsics.areEqual(this.f363664a, r100) == true) goto L16;
        boolean r101 = y2(this.f363664a);
        boolean r102 = y2(r100);
        if (r101 == false) goto L8;
        if (r102 == true) goto L8;
        notifyItemRemoved(0);
    L14:
        this.f363664a = r100;
        return;
    L8:
        if (r102 == false) goto L11;
        if (r101 == true) goto L11;
        notifyItemInserted(0);
    L11:
        if (r101 == false) goto L14;
        if (r102 == false) goto L14;
        notifyItemChanged(0);
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Intrinsics.checkNotNullParameter(this.f363664a, "loadState");
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        z2(r100, this.f363664a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return A2(r100, this.f363664a);
    }
}
