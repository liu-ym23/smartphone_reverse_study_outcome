package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.view.View;
import com.bytedance.android.ec.core.opt.ab.j;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.iron.ui.top.ECPromotionListHeaderLayout;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends QPresenter {
    public ECPromotionListHeaderLayout e;

    public d() {
    }

    public final void A(QModel r3) {
        this.e = (ECPromotionListHeaderLayout) w().b(2131378118).f();
        if ((r3 instanceof i) == true) goto L5;
        r3 = null;
    L5:
        i r4 = (i) r3;
        cl.d r0 = k.a();
        if (r0 == null) goto L11;
        View r1 = w().f();
        if (r4 == null) goto L10;
        r4.d();
    L10:
        r0.c(r1);
    L11:
        int r2 = ph.b.a;
        View r5 = w().f();
        Intrinsics.checkNotNullParameter(r5, "view");
        if (j.a().h() == false) goto L14;
        ph.b.b(r5);
    L14:
        if (r4 == null) goto L21;
        b r6 = r4.d();
        if (r6 == null) goto L22;
        ECPromotionListHeaderLayout r7 = this.e;
        if (r7 == null) goto L23;
        r7.R5(r6, r4);
        return;
    L23:
        return;
    L22:
        return;
    }
}
