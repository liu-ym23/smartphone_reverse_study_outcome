package com.bytedance.ee.bear.document.associateddocs.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001c\u001a\u00020\u00132\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001aH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$ViewHolder;", "<init>", "()V", "clickListener", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;", "getClickListener", "()Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;", "setClickListener", "(Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$OnItemClickListener;)V", "itemCallback", "com/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$itemCallback$1", "Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$itemCallback$1;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/bytedance/ee/bear/document/associateddocs/view/AppUrlItem;", "kotlin.jvm.PlatformType", "submitList", "", "items", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "ViewHolder", "OnItemClickListener", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public a a;
    public final AsyncListDiffer<com.bytedance.ee.bear.document.associateddocs.view.a> b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/document/associateddocs/view/AssociatedAppUrlListAdapter;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final AppCompatImageView b;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.b = r2.findViewById(2131374729);
            this.a = (TextView) r2.findViewById(2131390169);
        }
    }

    public interface a {
        void a(String r1, String r2);
    }

    public final int getItemCount() {
        return this.b.getCurrentList().size();
    }

    public AssociatedAppUrlListAdapter() {
        this.b = new AsyncListDiffer(this, new AssociatedAppUrlListAdapter$itemCallback$1());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ViewHolder r6 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        r6.a.setText(((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.b.getCurrentList(), r5)).b);
        Drawable r0 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.b.getCurrentList(), r5)).d;
        String r1 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.b.getCurrentList(), r5)).c;
        String r7 = ((com.bytedance.ee.bear.document.associateddocs.view.a) ListProtector.get(this.b.getCurrentList(), r5)).e;
        r6.b.setImageDrawable(r0);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new j(this, r1, r7));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560129, r3, false));
    }
}
