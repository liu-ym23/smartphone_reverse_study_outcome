package com.ss.android.lark.thirdshare.panel.content;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter$ShareItemViewHolder;", "<init>", "()V", "items", "", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemContent;", "getItems", "()Ljava/util/List;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ShareItemViewHolder", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareItemAdapter extends RecyclerView.Adapter<ShareItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f441272a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter$ShareItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shareItemView", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemView;", "<init>", "(Lcom/ss/android/lark/thirdshare/panel/content/ShareItemView;)V", "getShareItemView", "()Lcom/ss/android/lark/thirdshare/panel/content/ShareItemView;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShareItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShareItemView f441273a;

        public ShareItemViewHolder(ShareItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "shareItemView");
            super(r100);
            this.f441273a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f441272a).size();
    }

    public ShareItemAdapter() {
        this.f441272a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ShareItemViewHolder r102 = (ShareItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f441272a, r101);
        r102.f441273a.setItemContent(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ShareItemView r102 = new ShareItemView(r100.getContext());
        r102.setLayoutParams(new RecyclerView.LayoutParams((int) ShareItemView.f441274c.toPixels(r102.getContext()), -2));
        return new ShareItemViewHolder(r102);
    }
}
