package com.bytedance.android.window.shop.product.presenter.others;

import android.view.View;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import java.util.Map;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ECWindowProductCardTagInfoElementPresenter a;
    public final /* synthetic */ WindowV2ProductItemDTO.WindowCardHeaderLabelInfo b;

    public a(ECWindowProductCardTagInfoElementPresenter r1, WindowV2ProductItemDTO.WindowCardHeaderLabelInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        WindowV2ProductItemVO r6 = ((i) this.a).j;
        if (r6 != null) goto L5;
        return;
    L5:
        fo.b r0 = r6.C;
        fo.a r1 = wn.a.a;
        f r2 = (f) r0.a(wn.a.D);
        fo.b r3 = r6.C;
        fo.a r4 = wn.a.E;
        r3.d(r4, this.b.d());
        if (r2 == null) goto L12;
        Map<String, ? extends Map<String, String>> r7 = r2.d;
        if (r7 == null) goto L12;
        Map<String, String> r8 = r7.get(this.b.a());
        if (r8 == null) goto L12;
        r6.C.d(wn.a.F, r8);
    L12:
        ((i) this.a).g.b(r6);
        r6.C.c(wn.a.F);
        r6.C.c(r4);
    }
}
