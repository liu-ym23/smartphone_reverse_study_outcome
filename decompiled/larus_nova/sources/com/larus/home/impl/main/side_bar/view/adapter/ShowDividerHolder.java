package com.larus.home.impl.main.side_bar.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.home.impl.databinding.LarusItemSideBarDividerBinding;
import com.larus.home.impl.main.side_bar.data.DividerTypeEnum;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/ShowDividerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/home/impl/databinding/LarusItemSideBarDividerBinding;", "<init>", "(Lcom/larus/home/impl/databinding/LarusItemSideBarDividerBinding;)V", "bind", "", ItemStyle.ITEM_STYLE_DIVIDER, "Lcom/larus/home/impl/main/side_bar/data/Divider;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowDividerHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSideBarDividerBinding f344877a;

    public ShowDividerHolder(LarusItemSideBarDividerBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.f344309a);
        this.f344877a = r100;
    }

    public final void T3(com.larus.home.impl.main.side_bar.data.f r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getType());
    L5:
        int r102 = DividerTypeEnum.BLANK_SPACE.getType();
        if (r101 != null) goto L9;
    L11:
        e1.x(this.f344877a.f344311c);
        e1.o(this.f344877a.f344310b);
        return;
    L9:
        if (r101.intValue() != r102) goto L11;
        e1.o(this.f344877a.f344311c);
        e1.x(this.f344877a.f344310b);
        ViewGroup.LayoutParams r103 = this.f344877a.f344310b.getLayoutParams();
        r103.height = c7.b(Integer.valueOf(r100.a()));
        this.f344877a.f344310b.setLayoutParams(r103);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
