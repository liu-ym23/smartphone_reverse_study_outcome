package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/StageIndexCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ICellPresenter;", "", "fieldPresenter", "Lcom/bytedance/ee/bear/bitable/card/view/stage/IStageFieldPresenter;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/stage/StageIndexCellViewHolderDelegate;", "rootView", "Landroid/view/ViewGroup;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/stage/IStageFieldPresenter;Lcom/bytedance/ee/bear/bitable/card/view/stage/StageIndexCellViewHolderDelegate;Landroid/view/ViewGroup;)V", "lastFieldType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "lastCellPresenter", "setData", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "setIsForm", "isForm", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "isInEditMode", "setOnEditModeChangedListener", "listener", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ICellPresenter$OnEditModeChangedListener;", "notifyExitEditMode", "shouldExitEditModeWhenTouch", "downEvent", "Landroid/view/MotionEvent;", "onConfigurationChanged", "isLandscape", "setEditCallback", "callback", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ICellPresenter$EditCallback;", "onFragmentDestroy", "limitMaxVisibleLine", "ensureCellPresenter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageIndexCellViewHolder extends RecyclerView.ViewHolder implements com.bytedance.ee.bear.bitable.card.view.cell.b<Object, Object> {
    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final boolean O2(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void onViewRecycled() {
    }

    public final void T3() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void b0() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void m2() {
        T3();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void onViewAttachedToWindow() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void onViewDetachedFromWindow() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void u() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final boolean v2() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void K2(boolean r100) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void M2(boolean r100) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void Z(com.bytedance.ee.bear.bitable.card.view.cell.b.a r100) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void l2(dp4.a<Object> r100) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void q1(com.bytedance.ee.bear.bitable.card.view.cell.b.InterfaceC2994b r100) {
        throw null;
    }
}
