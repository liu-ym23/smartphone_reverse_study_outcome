package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowFloatGoTopPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a {
    public final Function0<Integer> m;

    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new ECWindowFloatGoTopPresenter(this.m);
    }

    public c(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "getViewHeight");
        super(2131370876);
        this.m = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r4) {
        View r5 = new View(a().getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(40), com.bytedance.android.shopping.extensions.b.b(40)));
        r5.setBackgroundResource(2131234810);
        r5.setVisibility(4);
        r5.setTag("anchor_window_bottom_go_top");
        return r5;
    }
}
