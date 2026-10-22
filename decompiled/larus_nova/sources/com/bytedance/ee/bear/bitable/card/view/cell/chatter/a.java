package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatterCellContainer<IChatterEntity> f207561a;

    public a(ChatterCellContainer<IChatterEntity> r100) {
        this.f207561a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f207561a.requestFocus();
    }
}
