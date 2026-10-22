package com.bytedance.ies.sve_list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ies.sve_list.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/sve_list/SVEListDiff;", "Lcom/bytedance/ies/sve_list/a;", "Item", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "()V", "sve-view_release"}, k = 1, mv = {1, 4, 0})
public final class SVEListDiff<Item extends a> extends DiffUtil.ItemCallback<Item> {
    public SVEListDiff() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object r100, Object r101) {
        return ((a) r100).b((a) r101);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object r100, Object r101) {
        return Intrinsics.areEqual(((a) r100).getId(), ((a) r101).getId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final Object getChangePayload(Object r100, Object r101) {
        a r102 = (a) r100;
        return (a) r101;
    }
}
