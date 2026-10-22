package com.ss.android.ugc.aweme.search.filter.view.component;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchSimpleAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchSimpleAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends T> f452996a;

    public abstract void y2(RecyclerView.ViewHolder r100, int r101, T r102);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<? extends T> r100 = this.f452996a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public ECSearchSimpleAdapter() {
    }

    public final void setData(List<? extends T> r100) {
        this.f452996a = r100;
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<? extends T> r102 = this.f452996a;
        if (r102 == null) goto L5;
        Object r103 = CollectionsKt.getOrNull(r102, r101);
    L6:
        y2(r100, r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
