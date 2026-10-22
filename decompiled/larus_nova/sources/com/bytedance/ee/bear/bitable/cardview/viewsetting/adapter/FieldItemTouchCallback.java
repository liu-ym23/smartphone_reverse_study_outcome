package com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.m;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu5.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/FieldItemTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onItemOptListener", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/FieldItemTouchCallback$OnItemOptListener;", "getOnItemOptListener", "()Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/FieldItemTouchCallback$OnItemOptListener;", "setOnItemOptListener", "(Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/FieldItemTouchCallback$OnItemOptListener;)V", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", PickerReporterConstants.KEY.TARGET, "onSwiped", "", "direction", "onSelectedChanged", "actionState", "clearView", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "vibrator", "OnItemOptListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldItemTouchCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f209233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f209234b;

    public interface a {
        void a();

        void onMoved(int r100, int r101);
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

    public final Context getContext() {
        return this.f209233a;
    }

    public FieldItemTouchCallback(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f209233a = r100;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        super.clearView(r100, r101);
        m.x(r101.itemView, false);
        View r102 = r101.itemView;
        if (r102 == null) goto L5;
        r102.setBackgroundColor(this.f209233a.getResources().getColor(R.color.transparent));
    L5:
        a r103 = this.f209234b;
        if (r103 == null) goto L9;
        r103.a();
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
        h.a(this.f209233a, 10, 50);
        if (r100 == null) goto L7;
        View r102 = r100.itemView;
        if (r102 == null) goto L7;
        m.x(r102, true);
    L7:
        if (r100 == null) goto L12;
        View r103 = r100.itemView;
        if (r103 == null) goto L13;
        r103.setBackgroundColor(this.f209233a.getResources().getColor(R.color.bg_body_overlay));
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        h.a(this.f209233a, 10, 50);
        int r103 = r101.getAbsoluteAdapterPosition();
        int r104 = r102.getAbsoluteAdapterPosition();
        a r105 = this.f209234b;
        if (r105 == null) goto L7;
        r105.onMoved(r103, r104);
        return true;
    L7:
        return true;
    }
}
