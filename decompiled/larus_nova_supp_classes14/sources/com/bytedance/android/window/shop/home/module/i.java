package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowHybridSubTabsPresenter;
import com.bytedance.android.window.shop.home.presenter.ECWindowSubTabsPresenter;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends a {
    public final QIPresenter h() {
        if (WindowConstDef.b(null, 3) == false) goto L7;
        return new ECWindowHybridSubTabsPresenter();
    L7:
        return new ECWindowSubTabsPresenter();
    }

    public i(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(null);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return l();
    }
}
