package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SelectedChatterAdapter<IChatterEntity> f207621c;

    public t(SelectedChatterAdapter<IChatterEntity> r100) {
        this.f207621c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        IChatterEntity r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof IChatterEntity) == false) goto L9;
        r101 = (IChatterEntity) r102;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        this.f207621c.y2(r101);
        return;
    L5:
        r102 = null;
        goto L7
    }
}
