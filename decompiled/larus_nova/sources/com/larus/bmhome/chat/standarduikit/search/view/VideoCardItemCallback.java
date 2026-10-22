package com.larus.bmhome.chat.standarduikit.search.view;

import androidx.recyclerview.widget.DiffUtil;
import hn8.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewData;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCardItemCallback extends DiffUtil.ItemCallback<l> {
    public VideoCardItemCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(l r100, l r101) {
        l r102 = r100;
        l r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.hashCode() != r103.hashCode()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(l r100, l r101) {
        l r102 = r100;
        l r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (Intrinsics.areEqual(r102.f486154a.f486141a, r103.f486154a.f486141a) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r102.f486154a.f486142b, r103.f486154a.f486142b) == false) goto L7;
        return true;
    }
}
