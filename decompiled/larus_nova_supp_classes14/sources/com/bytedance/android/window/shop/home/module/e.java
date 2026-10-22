package com.bytedance.android.window.shop.home.module;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.home.presenter.ECWindowBaseInfoPresenterBase;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import zq3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends a {
    public final QIPresenter h() {
        return new ECWindowBaseInfoPresenterBase();
    }

    public e() {
        super(2131370879);
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        if (l.b() == false) goto L7;
        return k.a.a(this, 2131560869);
    L7:
        return k.a.a(this, 2131560868);
    }
}
