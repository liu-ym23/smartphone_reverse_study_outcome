package com.larus.bmhome.chat.search.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.SkeletonInfo;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.SearchImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/im/bean/message/ItemData;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchItemCallback extends DiffUtil.ItemCallback<ItemData> {
    public SearchItemCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(ItemData r100, ItemData r101) {
        ItemData r102 = r100;
        ItemData r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if ((r102 instanceof ArticleInfo) == false) goto L8;
        if ((r103 instanceof ArticleInfo) == false) goto L8;
        return Intrinsics.areEqual(r102, r103);
    L8:
        if ((r102 instanceof VideoInfo) == false) goto L13;
        if ((r103 instanceof VideoInfo) == false) goto L13;
        return Intrinsics.areEqual(r102, r103);
    L13:
        if ((r102 instanceof SearchImageInfo) == false) goto L18;
        if ((r103 instanceof SearchImageInfo) == false) goto L18;
        return Intrinsics.areEqual(r102, r103);
    L18:
        if ((r102 instanceof MoreInfo) == false) goto L23;
        if ((r103 instanceof MoreInfo) == false) goto L23;
        return Intrinsics.areEqual(r102, r103);
    L23:
        if ((r102 instanceof SkeletonInfo) == true) goto L25;
    L27:
        return false;
    L25:
        if ((r103 instanceof SkeletonInfo) == false) goto L27;
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(ItemData r100, ItemData r101) {
        ItemData r102 = r100;
        ItemData r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102.getId(), r103.getId());
    }
}
