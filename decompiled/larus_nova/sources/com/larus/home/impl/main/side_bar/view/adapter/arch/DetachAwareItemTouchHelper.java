package com.larus.home.impl.main.side_bar.view.adapter.arch;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yb9.c;
import yb9.d;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/arch/DetachAwareItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "callback", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "shouldKeepDragging", "Lkotlin/Function1;", "Landroid/view/View;", "", "onDraggedViewDetached", "", "<init>", "(Landroidx/recyclerview/widget/ItemTouchHelper$Callback;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onChildViewDetachedFromWindow", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetachAwareItemTouchHelper extends ItemTouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<View, Boolean> f344942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f344943b;

    @Override // androidx.recyclerview.widget.ItemTouchHelper, androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f344942a.invoke(r100).booleanValue() == false) goto L6;
        this.f344943b.invoke(r100);
        return;
    L6:
        super.onChildViewDetachedFromWindow(r100);
    }

    public DetachAwareItemTouchHelper(ReorderableConcatAdapterHost.b r100, c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "shouldKeepDragging");
        Intrinsics.checkNotNullParameter(r102, "onDraggedViewDetached");
        super(r100);
        this.f344942a = r101;
        this.f344943b = r102;
    }
}
