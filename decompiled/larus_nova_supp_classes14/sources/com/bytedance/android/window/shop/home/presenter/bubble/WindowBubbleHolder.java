package com.bytedance.android.window.shop.home.presenter.bubble;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/bubble/WindowBubbleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowBubbleHolder extends RecyclerView.ViewHolder {
    public final WindowHeadBubbleBaseCard a;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowBubbleHolder(WindowHeadBubbleBaseCard r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r2;
    }
}
