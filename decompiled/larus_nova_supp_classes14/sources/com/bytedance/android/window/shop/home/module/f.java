package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends a {
    public final Function0<Integer> m;

    public final QIPresenter h() {
        return new ECWindowLinkageHeaderLivePresenter(this.m);
    }

    public f(Function0 r2) {
        super(2131370922);
        this.m = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return k.a.a(this, 2131561014);
    }
}
