package com.bytedance.android.window.shop.home.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAutoScrollViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final TextView b;
    public final View c;

    public WindowAutoScrollViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = r2;
        this.a = (TextView) r2.findViewById(2131371304);
        this.b = (TextView) r2.findViewById(2131371301);
    }
}
