package com.ss.android.lark.picker.base.view;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.databinding.ItemSpotlightLoadingBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SpotlightLoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/picker/base/databinding/ItemSpotlightLoadingBinding;", "<init>", "(Lcom/ss/android/lark/picker/base/databinding/ItemSpotlightLoadingBinding;)V", "getBinding", "()Lcom/ss/android/lark/picker/base/databinding/ItemSpotlightLoadingBinding;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpotlightLoadingViewHolder extends RecyclerView.ViewHolder {
    private final ItemSpotlightLoadingBinding binding;

    public final ItemSpotlightLoadingBinding getBinding() {
        return this.binding;
    }

    public SpotlightLoadingViewHolder(ItemSpotlightLoadingBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.searchLoadingContainer);
        this.binding = r100;
    }
}
