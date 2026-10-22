package com.larus.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0011\u0010\u001b\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/ui/CommonTaskItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "descView", "getDescView", "dividerView", "getDividerView", "()Landroid/view/View;", "statusBadgeView", "getStatusBadgeView", "statusBadgeIcon", "Landroid/widget/ImageView;", "getStatusBadgeIcon", "()Landroid/widget/ImageView;", "statusBadgeTextView", "getStatusBadgeTextView", "endLabel", "getEndLabel", "endIcon", "getEndIcon", "endLoadingView", "getEndLoadingView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonTaskItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f375125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f375126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f375127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f375128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f375129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f375130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f375131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f375132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f375133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f375134j;

    public CommonTaskItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f375125a = (AppCompatImageView) r100.findViewById(R.id.item_left_icon);
        this.f375126b = (TextView) r100.findViewById(R.id.item_main_name);
        this.f375127c = (TextView) r100.findViewById(R.id.item_description);
        this.f375128d = r100.findViewById(R.id.item_divider);
        this.f375129e = r100.findViewById(R.id.item_status_badge);
        this.f375130f = (ImageView) r100.findViewById(R.id.item_status_badge_icon);
        this.f375131g = (TextView) r100.findViewById(R.id.item_status_badge_text);
        this.f375132h = (TextView) r100.findViewById(R.id.item_end_label);
        this.f375133i = (ImageView) r100.findViewById(R.id.item_end_icon);
        this.f375134j = r100.findViewById(R.id.item_end_loading);
    }
}
