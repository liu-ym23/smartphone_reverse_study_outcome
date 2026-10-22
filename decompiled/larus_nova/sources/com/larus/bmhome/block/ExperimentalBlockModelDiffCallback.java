package com.larus.bmhome.block;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import jc8.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/block/ExperimentalBlockModelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "newItems", "forceRefreshAll", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "oldItemPosition", "newItemPosition", "areContentsTheSame", "block-kit-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExperimentalBlockModelDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f296160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f296161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f296162c;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f296161b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f296160a.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        if (this.f296162c == false) goto L5;
        return false;
    L5:
        a r102 = (a) CollectionsKt.getOrNull(this.f296160a, r100);
        a r103 = (a) CollectionsKt.getOrNull(this.f296161b, r101);
        if (r102 == null) goto L16;
        if (r103 == null) goto L16;
        if (r102.m() != r103.m()) goto L16;
        if (r102.n() != r103.n()) goto L16;
        return r102.e(r103);
    L16:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        a r102 = (a) CollectionsKt.getOrNull(this.f296160a, r100);
        a r103 = (a) CollectionsKt.getOrNull(this.f296161b, r101);
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.f(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExperimentalBlockModelDiffCallback(List<? extends a> r100, List<? extends a> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "oldItems");
        Intrinsics.checkNotNullParameter(r101, "newItems");
        this.f296160a = r100;
        this.f296161b = r101;
        this.f296162c = r102;
    }
}
