package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements CellEditDragView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity> f207604a;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
    public final void Q5() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
    public final void W6() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.b
    public final void X6() {
        if (this.f207604a.s() == false) goto L6;
        this.f207604a.dismiss();
        return;
    }

    public h(f<IChatterEntity> r100) {
        this.f207604a = r100;
    }
}
