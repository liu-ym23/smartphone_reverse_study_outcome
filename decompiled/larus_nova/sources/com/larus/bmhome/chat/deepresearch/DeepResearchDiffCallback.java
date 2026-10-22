package com.larus.bmhome.chat.deepresearch;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.im.bean.message.block.Block;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ne8.m;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepResearchDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/bmhome/chat/deepresearch/DeepResearchData;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchDiffCallback extends DiffUtil.ItemCallback<m> {
    public DeepResearchDiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(m r100, m r101) {
        m r102 = r100;
        m r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(m r100, m r101) {
        m r102 = r100;
        m r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        Block r104 = r102.f518902c;
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.getBlockId();
    L6:
        Block r107 = r103.f518902c;
        if (r107 == null) goto L10;
        r105 = r107.getBlockId();
    L10:
        return Intrinsics.areEqual(r106, r105);
    L5:
        r106 = null;
        goto L6
    }
}
