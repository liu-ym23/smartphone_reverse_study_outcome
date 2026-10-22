package com.bytedance.android.window.shop.product.presenter.others;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowProductCardLiveHotPlayBackElementPresenter extends i<WindowV2ProductItemVO> {
    public h l;
    public final Lazy m;

    public ECWindowProductCardLiveHotPlayBackElementPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.m = LazyKt.lazy(new ECWindowProductCardLiveHotPlayBackElementPresenter$playBackNoticeView$2(this));
    }

    public final void d0(WindowV2ProductItemVO r5) {
        if ((r5 instanceof h) == true) goto L5;
        r5 = null;
    L5:
        h r6 = (h) r5;
        if (r6 == null) goto L13;
        this.l = r6;
        if (r6.U != null) goto L10;
        ((View) this.m.getValue()).setVisibility(8);
    L11:
        f.c((View) this.m.getValue(), null, "bind_store_product_card", new ECWindowProductCardLiveHotPlayBackElementPresenter$onElementBind$$inlined$let$lambda$1(this), 1);
        return;
    L10:
        ((View) this.m.getValue()).setVisibility(0);
        goto L11
    }
}
