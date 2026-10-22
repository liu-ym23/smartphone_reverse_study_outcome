package com.larus.canvas.feature.component.title.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/canvas/feature/component/title/widget/DropdownItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", ItemStyle.ITEM_STYLE_DIVIDER, "iconView", "Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f323723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f323724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f323725c;

    public DropdownItemHolder(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f323723a = r100.findViewById(R.id.item_divider);
        this.f323724b = (ImageView) r100.findViewById(R.id.icon);
        this.f323725c = (TextView) r100.findViewById(R.id.desc);
    }
}
