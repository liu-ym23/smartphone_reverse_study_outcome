package com.bytedance.android.window.shop.product.presenter.playable;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e;
import com.bytedance.android.window.shop.repository.tab.entity.p;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECWindowPlayableProductCardGroupPresenter {
    @Override // com.bytedance.android.window.shop.product.presenter.playable.ECWindowPlayableProductCardGroupPresenter
    public final String l0(WindowV2ProductItemVO r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Object r0 = r7.C.a(wn.a.D);
        ECUrlModel r2 = null;
        if ((r0 instanceof p) == true) goto L5;
        r0 = null;
    L5:
        p r1 = (p) r0;
        boolean r3 = false;
        if (r1 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r1 == null) goto L15;
        e r5 = r1.j;
        if (r5 == null) goto L15;
        r2 = r5.a;
    L15:
        if (r2 == null) goto L17;
        r3 = true;
    L17:
        if (r4 == false) goto L21;
        if (r3 == true) goto L21;
        return k0(r7, "d73007");
    L21:
        return k0(r7, "d066686");
    L8:
        if (r1.i != 210) goto L10;
        r4 = true;
        goto L11
    }

    public a(Fragment r2, WindowLayoutType r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "schemaProcessor");
        super(r2, r3, r4, null);
    }
}
