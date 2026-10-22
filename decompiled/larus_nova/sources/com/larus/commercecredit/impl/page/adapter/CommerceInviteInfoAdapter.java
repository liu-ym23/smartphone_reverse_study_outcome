package com.larus.commercecredit.impl.page.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qz8.o;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/commercecredit/impl/entity/Step;", "Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$ViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "ViewHolder", "StepDiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceInviteInfoAdapter extends ListAdapter<o, ViewHolder> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$StepDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/commercecredit/impl/entity/Step;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StepDiffCallback extends DiffUtil.ItemCallback<o> {
        public StepDiffCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(o r100, o r101) {
            o r102 = r100;
            o r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            if (Intrinsics.areEqual(r102.b(), r103.b()) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r102.a(), r103.a()) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(o r100, o r101) {
            o r102 = r100;
            o r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            if (Intrinsics.areEqual(r102.b(), r103.b()) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(r102.a(), r103.a()) == false) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/commercecredit/impl/page/adapter/CommerceInviteInfoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "description", "inviteInfoIndex", "bind", "", "step", "Lcom/larus/commercecredit/impl/entity/Step;", "index", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f325749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f325750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f325751c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f325749a = (TextView) r100.findViewById(R.id.tv_invite_info_title);
            this.f325750b = (TextView) r100.findViewById(R.id.tv_invite_info_description);
            this.f325751c = (TextView) r100.findViewById(R.id.tv_invite_info_index);
        }
    }

    public CommerceInviteInfoAdapter() {
        super(new StepDiffCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        o r103 = getItem(r101);
        Intrinsics.checkNotNull(r103);
        int r104 = r101 + 1;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "step");
        TextView r105 = r102.f325749a;
        String r106 = r103.b();
        String r107 = "";
        if (r106 != null) goto L6;
        r106 = "";
    L6:
        r105.setText(r106);
        TextView r108 = r102.f325750b;
        String r109 = r103.a();
        if (r109 == null) goto L9;
        r107 = r109;
    L9:
        r108.setText(r107);
        r102.f325751c.setText(String.valueOf(r104));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_commerce_invite_info, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
