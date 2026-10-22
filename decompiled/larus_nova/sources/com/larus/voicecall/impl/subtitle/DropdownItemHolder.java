package com.larus.voicecall.impl.subtitle;

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

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/DropdownItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "dropdownBoxId", "", "callback", "Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;", "<init>", "(Landroid/view/View;Ljava/lang/Integer;Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;)V", "getItemView", "()Landroid/view/View;", "Ljava/lang/Integer;", "getCallback", "()Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;", "checkedIcon", "Landroid/widget/ImageView;", ItemStyle.ITEM_STYLE_DIVIDER, "titleTv", "Landroid/widget/TextView;", "itemIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "descTv", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "getDisplayText", "", "selectedSpinnerItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f378749i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f378750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f378751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f378752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f378753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f378754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f378755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f378756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f378757h;

    public DropdownItemHolder(ConstraintLayout r100, Integer r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100);
        this.f378750a = r100;
        this.f378751b = r101;
        this.f378752c = r102;
        this.f378753d = (ImageView) r100.findViewById(R.id.ic_item_checked);
        this.f378754e = r100.findViewById(R.id.item_divider);
        this.f378755f = (TextView) r100.findViewById(R.id.tv_item_name);
        this.f378756g = (SimpleDraweeView) r100.findViewById(R.id.ic_item);
        this.f378757h = (TextView) r100.findViewById(R.id.tv_item_desc);
    }
}
