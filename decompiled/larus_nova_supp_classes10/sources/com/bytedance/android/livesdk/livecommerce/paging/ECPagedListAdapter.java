package com.bytedance.android.livesdk.livecommerce.paging;

import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/paging/ECPagedListAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedListAdapter;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECPagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {
    public Function1<? super PagedList<T>, Unit> a;

    public ECPagedListAdapter(DiffUtil.ItemCallback<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "diffCallback");
        super(r2);
    }

    public final void onCurrentListChanged(PagedList<T> r2) {
        super.onCurrentListChanged(r2);
        Function1<? super PagedList<T>, Unit> r0 = this.a;
        if (r0 == null) goto L5;
        Unit r3 = (Unit) r0.invoke(r2);
    L5:
        this.a = null;
    }

    public final void submitList(PagedList<T> r2) {
        this.a = null;
        super.submitList(r2);
    }

    public final void y2(PagedList<T> r1, Function1<? super PagedList<T>, Unit> r2) {
        this.a = r2;
        super.submitList(r1);
    }
}
