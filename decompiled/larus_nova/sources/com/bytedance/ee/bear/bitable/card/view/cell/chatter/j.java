package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<IChatterEntity> f207606a;

    public j(f<IChatterEntity> r100) {
        this.f207606a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L8;
        f.a r102 = this.f207606a.f207573r;
        if (r102 == null) goto L6;
        r102.a("search_group", null, null);
    L6:
        this.f207606a.v("search");
        return;
    }
}
