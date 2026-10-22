package com.larus.bmhome.view.actionbar.edit.component;

import android.view.View;
import android.view.ViewGroup;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "dropdownBoxId", "", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "<init>", "(Landroid/view/View;Ljava/lang/Integer;Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;)V", "Ljava/lang/Integer;", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "checkedIcon", "Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "titleTv", "Landroid/widget/TextView;", "itemIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "tagContainer", "Landroid/view/ViewGroup;", "descTv", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "disabledVisual", "", "bindOptionTag", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f316101i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f316102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f316103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f316104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f316105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f316106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f316107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f316108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f316109h;

    public DropdownItemHolder(ConstraintLayout r100, Integer r101, b1 r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100);
        this.f316102a = r101;
        this.f316103b = r102;
        this.f316104c = (ImageView) r100.findViewById(R.id.ic_item_checked);
        this.f316105d = r100.findViewById(R.id.item_divider);
        this.f316106e = (TextView) r100.findViewById(R.id.tv_item_name);
        this.f316107f = (SimpleDraweeView) r100.findViewById(R.id.ic_item);
        this.f316108g = (ViewGroup) r100.findViewById(R.id.ic_item_tag);
        this.f316109h = (TextView) r100.findViewById(R.id.tv_item_desc);
    }
}
