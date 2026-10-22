package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu5.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "<init>", "()V", "mItemTouchCallbackListener", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemTouchHelperCallback$OnItemTouchCallbackListener;", "getMItemTouchCallbackListener", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemTouchHelperCallback$OnItemTouchCallbackListener;", "setMItemTouchCallbackListener", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemTouchHelperCallback$OnItemTouchCallbackListener;)V", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", PickerReporterConstants.KEY.TARGET, "onSwiped", "", "direction", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "onSelectedChanged", "actionState", "clearView", "setOnItemTouchCallbackListener", "listener", "vibrator", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "OnItemTouchCallbackListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionItemTouchHelperCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f211732a;

    public interface a {
        void V(RecyclerView.ViewHolder r100, boolean r101);

        void onMove(int r100, int r101);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    public OptionItemTouchHelperCallback() {
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        super.clearView(r100, r101);
        a r102 = this.f211732a;
        if (r102 == null) goto L6;
        r102.V(r101, false);
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        super.onSelectedChanged(r100, r101);
        a r102 = this.f211732a;
        if (r102 == null) goto L5;
        r102.V(r100, true);
    L5:
        if (r100 == null) goto L12;
        View r103 = r100.itemView;
        if (r103 == null) goto L13;
        Context r104 = r103.getContext();
        if (r104 == null) goto L14;
        h.a(r104, 10, 50);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        int r103 = r101.getAbsoluteAdapterPosition();
        int r104 = r102.getAbsoluteAdapterPosition();
        a r105 = this.f211732a;
        if (r105 == null) goto L5;
        r105.onMove(r103, r104);
    L5:
        View r106 = r101.itemView;
        if (r106 == null) goto L12;
        Context r107 = r106.getContext();
        if (r107 == null) goto L13;
        h.a(r107, 10, 50);
        return true;
    L13:
        return true;
    L12:
        return true;
    }
}
