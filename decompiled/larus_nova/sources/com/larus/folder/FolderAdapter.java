package com.larus.folder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0016\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/folder/FolderAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/folder/FolderItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onItemClick", "Lkotlin/Function1;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "FolderViewHolder", "LoadingViewHolder", "FolderDiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderAdapter extends ListAdapter<j, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super j, Unit> f343592a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/folder/FolderAdapter$FolderDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/folder/FolderItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FolderDiffCallback extends DiffUtil.ItemCallback<j> {
        public FolderDiffCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(j r100, j r101) {
            j r102 = r100;
            j r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102, r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(j r100, j r101) {
            j r102 = r100;
            j r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            boolean r104 = r102.f343633d;
            if (r104 == true) goto L13;
            if (r103.f343633d == true) goto L13;
            if (Intrinsics.areEqual(r102.f343631b, r103.f343631b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(r102.f343630a, r103.f343630a) == false) goto L18;
        L11:
            return true;
        L18:
            return false;
        L13:
            if (r104 == r103.f343633d) goto L15;
            return false;
        L15:
            if (r102.f343634e == r103.f343634e) goto L11;
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/folder/FolderAdapter$FolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "tvPath", "getTvPath", "vDivider", "getVDivider", "()Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FolderViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f343593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f343594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f343595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f343596d;

        public FolderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f343593a = (ImageView) r100.findViewById(R.id.item_left_icon);
            this.f343594b = (TextView) r100.findViewById(R.id.item_main_name);
            this.f343595c = (TextView) r100.findViewById(R.id.item_description);
            this.f343596d = r100.findViewById(R.id.item_divider);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/folder/FolderAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    public FolderAdapter() {
        super(new FolderDiffCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getItem(r100).f343633d ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        final j r102 = getItem(r101);
        if ((r100 instanceof LoadingViewHolder) == false) goto L6;
        r100.itemView.setOnClickListener(null);
        return;
    L6:
        r100.itemView.setBackgroundResource(R.drawable.larus_bg_task_skill_item_middle);
        FolderViewHolder r103 = (FolderViewHolder) r100;
        r103.f343594b.setText(r102.f343630a);
        TextView r104 = r103.f343595c;
        r104.setText(r102.f343631b);
        r104.setMaxLines(1);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        if (r102.f343632c == false) goto L9;
        r103.f343593a.setImageResource(R.drawable.larus_ic_drive_page_menu_not_use_folder);
    L10:
        View r105 = r103.f343596d;
        if (r101 != (getItemCount() - 1)) goto L13;
        int r106 = 8;
    L14:
        r105.setVisibility(r106);
        r100.itemView.setOnClickListener(new d(this, r102));
        return;
    L13:
        r106 = 0;
        goto L14
    L9:
        r103.f343593a.setImageResource(R.drawable.larus_ic_drive_page_menu_folder);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 1) goto L6;
        return new LoadingViewHolder(r102.inflate(R.layout.larus_item_folder_loading, r100, false));
    L6:
        return new FolderViewHolder(r102.inflate(R.layout.larus_item_task_common_ui, r100, false));
    }
}
