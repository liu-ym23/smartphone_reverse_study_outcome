package com.larus.canvas.feature.component.instruction.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/ui/DropDownBoxSelectHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "checkedIcon", "Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "titleTv", "Landroid/widget/TextView;", "itemIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "descTv", "bindData", "", "data", "Lcom/larus/canvas/feature/component/instruction/ui/DropDownBoxSelectItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropDownBoxSelectHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f323184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f323185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f323186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f323187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f323188e;

    public DropDownBoxSelectHolder(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f323184a = (ImageView) r100.findViewById(R.id.ic_item_checked);
        this.f323185b = r100.findViewById(R.id.item_divider);
        this.f323186c = (TextView) r100.findViewById(R.id.tv_item_name);
        this.f323187d = (SimpleDraweeView) r100.findViewById(R.id.ic_item);
        this.f323188e = (TextView) r100.findViewById(R.id.tv_item_desc);
    }
}
