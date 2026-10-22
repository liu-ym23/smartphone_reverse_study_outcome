package com.ss.android.lark.todo.impl.features.common.dialog;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/ss/android/lark/todo/impl/features/common/dialog/ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$1", "Landroidx/recyclerview/widget/ItemTouchHelper;", "startDrag", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$1 extends ItemTouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f442416a;

    @Override // androidx.recyclerview.widget.ItemTouchHelper
    public final void startDrag(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        b r101 = this.f442416a;
        r101.f442429f = true;
        a.InterfaceC5342a r102 = r101.f442425b;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        super.startDrag(r100);
    }

    public ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$1(b r100, ListSectionSortManagerDialogController$initRecyclerView$itemTouchHelper$2 r101) {
        this.f442416a = r100;
        super(r101);
    }
}
