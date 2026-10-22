package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;

/* JADX INFO: loaded from: classes15.dex */
public final class c0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f208124a;

    public c0(a0 r100) {
        this.f208124a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a0.a r101 = this.f208124a.f208119m;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        q r102 = this.f208124a.f208120n;
        if (r102 == null) goto L8;
        r102.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_MORE_CLICK, "edit");
    L8:
        this.f208124a.dismiss();
    }
}
