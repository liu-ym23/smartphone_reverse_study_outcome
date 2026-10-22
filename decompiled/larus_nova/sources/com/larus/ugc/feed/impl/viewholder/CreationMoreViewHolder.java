package com.larus.ugc.feed.impl.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.larus.ugc.feed.impl.widget.MoreItemView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fJ \u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "moreItemView", "Lcom/larus/ugc/feed/impl/widget/MoreItemView;", "kotlin.jvm.PlatformType", "setOnErrorClickListener", "", "onErrorClickListener", "Lkotlin/Function0;", "updateStatus", "state", "Lcom/larus/ugc/feed/api/state/LoadMoreState;", "disableEndView", "", "bottomPadding", "", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f374981b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MoreItemView f374982a;

    public CreationMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f374982a = (MoreItemView) r100.findViewById(R.id.more_item_view);
    }

    public final void T3(final n0a.b r100, boolean r101, int r102) {
        this.f374982a.setDisableEndView(r101);
        UIUtils.updateLayoutMargin(this.f374982a, 0, 0, 0, r102);
        w0a.a.a("CreationDiscoverMoreViewHolder", new s(r100));
        MoreItemView r103 = this.f374982a;
        if (r100 == null) goto L20;
        r103.getClass();
        if (Intrinsics.areEqual(r100, n0a.b.c.f516621a) == true) goto L20;
        if (Intrinsics.areEqual(r100, n0a.b.d.f516622a) == true) goto L20;
        if (Intrinsics.areEqual(r100, n0a.b.C6879b.f516620a) == false) goto L13;
        e1.o(r103.f375094a.f374724d);
        e1.x(r103.f375094a.f374723c);
        e1.o(r103.f375094a.f374722b);
    L22:
        if (r103.f375096c == false) goto L25;
        e1.o(r103.f375094a.f374722b);
        return;
    L25:
        return;
    L13:
        if (Intrinsics.areEqual(r100, n0a.b.e.f516623a) == false) goto L15;
    L19:
        e1.o(r103.f375094a.f374724d);
        e1.o(r103.f375094a.f374723c);
        e1.x(r103.f375094a.f374722b);
        goto L22
    L15:
        if (Intrinsics.areEqual(r100, n0a.b.a.f516619a) == true) goto L19;
        throw new NoWhenBranchMatchedException();
    L20:
        e1.x(r103.f375094a.f374724d);
        e1.o(r103.f375094a.f374723c);
        e1.o(r103.f375094a.f374722b);
        goto L22
    }
}
