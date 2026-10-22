package com.bytedance.ee.bear.document.associateddocs.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001c\u001a\u00020\u00132\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$ViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;", "getClickListener", "()Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;", "setClickListener", "(Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;)V", "itemCallback", "com/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$itemCallback$1", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$itemCallback$1;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AppUrlItem;", "kotlin.jvm.PlatformType", "submitList", "", "items", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "ViewHolder", "OnItemClickListener", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f219024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncListDiffer<com.bytedance.ee.bear.document.associateddocs.view.a> f219025b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "icon", "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f219026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f219027b;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f219027b = (AppCompatImageView) r100.findViewById(R.id.icon_association_url);
            this.f219026a = (TextView) r100.findViewById(R.id.tv_association_url_name);
        }
    }

    public interface a {
        void a(String r100, String r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f219025b.getCurrentList().size();
    }

    public AssociatedAppUrlListAdapter() {
        this.f219025b = new AsyncListDiffer(this, new AssociatedAppUrlListAdapter$itemCallback$1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.f219026a.setText(((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.f219025b.getCurrentList(), r101)).f219039b);
        Drawable r103 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.f219025b.getCurrentList(), r101)).f219041d;
        String r104 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.f219025b.getCurrentList(), r101)).f219040c;
        String r105 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.f219025b.getCurrentList(), r101)).f219042e;
        r102.f219027b.setImageDrawable(r103);
        r102.itemView.setOnClickListener(new j(this, r104, r105));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.docx_associated_appurl_item, r100, false));
    }
}
