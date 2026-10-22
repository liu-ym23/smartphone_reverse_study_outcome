package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f208185a;

    public v(t r100) {
        this.f208185a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        t r101 = this.f208185a;
        t.a r102 = r101.f208177o;
        if (r102 == null) goto L9;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r103 = r101.f208178p;
        if (r103 == null) goto L7;
        String r104 = r103.f207141a;
    L8:
        r102.a(r104);
        goto L9
    L7:
        r104 = null;
    L9:
        q r105 = this.f208185a.f208179q;
        if (r105 == null) goto L12;
        r105.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_CLICK, BitableAnalytic.SelectSceneClickType.SIMILAR_OPTION);
    L12:
        this.f208185a.dismiss();
    }
}
