package com.larus.business.multitask_management.impl.sheet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MtmConcatSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "concatAdapter", "Lcom/larus/common_ui/widget/concat_adapter/ConcatAdapter;", "spanCount", "", "<init>", "(Lcom/larus/common_ui/widget/concat_adapter/ConcatAdapter;I)V", "getSpanSize", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmConcatSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f320927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320928b;

    public MtmConcatSpanSizeLookup(ConcatAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "concatAdapter");
        this.f320927a = r100;
        this.f320928b = 2;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int r100) {
        Iterator<T> r101 = this.f320927a.getAdapters().iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        RecyclerView.Adapter r102 = (RecyclerView.Adapter) r101.next();
        int r103 = r102.getItemCount();
        if (r100 < r103) goto L8;
        r100 = r100 - r103;
        goto L4
    L8:
        if ((r102 instanceof MtmServiceSectionAdapter) == false) goto L13;
        int r104 = this.f320928b;
        if (((MtmServiceSectionAdapter) r102).f320936c.f320817c < 2) goto L19;
        return 1;
    L19:
        return r104;
    L13:
        return this.f320928b;
    L16:
        return this.f320928b;
    }
}
