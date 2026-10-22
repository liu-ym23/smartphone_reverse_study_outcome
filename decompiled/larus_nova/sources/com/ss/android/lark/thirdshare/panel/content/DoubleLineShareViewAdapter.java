package com.ss.android.lark.thirdshare.panel.content;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareViewAdapter$ShareViewHolder;", "<init>", "()V", "items", "", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemContent;", "getItems", "()Ljava/util/List;", "value", "", "spanCount", "getSpanCount", "()I", "setSpanCount", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "ShareViewHolder", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubleLineShareViewAdapter extends RecyclerView.Adapter<ShareViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f441257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f441258b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareViewAdapter$ShareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter;", "getAdapter$third_share_panel_release", "()Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager$third_share_panel_release", "()Landroidx/recyclerview/widget/GridLayoutManager;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShareViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f441259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ShareItemAdapter f441260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final GridLayoutManager f441261c;

        public ShareViewHolder(RecyclerView r100) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            super(r100);
            this.f441259a = r100;
            ShareItemAdapter r101 = new ShareItemAdapter();
            this.f441260b = r101;
            GridLayoutManager r102 = new GridLayoutManager(r100.getContext(), 5);
            this.f441261c = r102;
            r100.setAdapter(r101);
            int r103 = (int) ShareItemView.f441274c.toPixels(r100.getContext());
            r100.setLayoutManager(r102);
            r100.addItemDecoration(new ShareViewGridDecoration(r103));
            r100.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            r100.setOverScrollMode(2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return (int) Math.ceil(((ArrayList) this.f441257a).size() / (this.f441258b * 2.0f));
    }

    public DoubleLineShareViewAdapter() {
        this.f441257a = new ArrayList();
        this.f441258b = 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ShareViewHolder r102 = (ShareViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ((ArrayList) r102.f441260b.f441272a).clear();
        List<a> r103 = r102.f441260b.f441272a;
        List<a> r104 = this.f441257a;
        ArrayList r105 = (ArrayList) r104;
        ArrayList r106 = (ArrayList) r103;
        r106.addAll(r105.subList((this.f441258b * r101) * 2, Math.min(r105.size(), ((r101 + 1) * this.f441258b) * 2)));
        r102.f441261c.setSpanCount(this.f441258b);
        r102.f441260b.notifyDataSetChanged();
        r102.f441259a.invalidateItemDecorations();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ShareViewHolder(new RecyclerView(r100.getContext()));
    }
}
