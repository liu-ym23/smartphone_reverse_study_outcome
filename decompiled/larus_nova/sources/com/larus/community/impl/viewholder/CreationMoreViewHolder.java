package com.larus.community.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.community.impl.widget.MoreItemView;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "moreItemView", "Lcom/larus/community/impl/widget/MoreItemView;", "kotlin.jvm.PlatformType", "setOnErrorClickListener", "", "onErrorClickListener", "Lkotlin/Function0;", "updateStatus", "moreState", "Lcom/larus/profile/api/model/MoreState;", "disableEndView", "", "bottomPadding", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f329997b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MoreItemView f329998a;

    public CreationMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f329998a = (MoreItemView) r100.findViewById(R.id.more_item_view);
    }

    public final void T3(final gs9.i r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "moreState");
        this.f329998a.setDisableEndView(r101);
        UIUtils.updateLayoutMargin(this.f329998a, 0, 0, 0, r102);
        m29.a.a("CreationDiscoverMoreViewHolder", new w(r100));
        MoreItemView r103 = this.f329998a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "moreState");
        if (Intrinsics.areEqual(r100, gs9.i.c.f482480a) == false) goto L6;
        e1.x(r103.f330144a.f329016d);
        e1.o(r103.f330144a.f329015c);
        e1.o(r103.f330144a.f329014b);
    L12:
        if (r103.f330146c == false) goto L17;
        e1.o(r103.f330144a.f329014b);
        return;
    L17:
        return;
    L6:
        if (Intrinsics.areEqual(r100, gs9.i.b.f482479a) == false) goto L9;
        e1.o(r103.f330144a.f329016d);
        e1.x(r103.f330144a.f329015c);
        e1.o(r103.f330144a.f329014b);
        goto L12
    L9:
        if (Intrinsics.areEqual(r100, gs9.i.a.f482478a) == false) goto L16;
        e1.o(r103.f330144a.f329016d);
        e1.o(r103.f330144a.f329015c);
        e1.x(r103.f330144a.f329014b);
        goto L12
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
