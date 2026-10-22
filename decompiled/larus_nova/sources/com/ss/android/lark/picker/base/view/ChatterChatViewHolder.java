package com.ss.android.lark.picker.base.view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "avatarItemView", "Lcom/ss/android/lark/picker/base/view/AvatarItemViewWithMask;", "itemType", "", "<init>", "(Lcom/ss/android/lark/picker/base/view/AvatarItemViewWithMask;I)V", "getAvatarItemView", "()Lcom/ss/android/lark/picker/base/view/AvatarItemViewWithMask;", "getItemType", "()I", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterChatViewHolder extends RecyclerView.ViewHolder {
    private final AvatarItemViewWithMask avatarItemView;
    private final int itemType;

    public final AvatarItemViewWithMask getAvatarItemView() {
        return this.avatarItemView;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public ChatterChatViewHolder(AvatarItemViewWithMask r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarItemView");
        super(r100);
        this.avatarItemView = r100;
        this.itemType = r101;
        this.itemView.setClickable(true);
    }
}
