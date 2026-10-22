package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

    public u(ECWindowCroppedStyleRootPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        uq3.a r4 = (uq3.a) r3;
        ECWindowCroppedStyleRootPresenter r5 = this.a;
        int r0 = ECWindowCroppedStyleRootPresenter.s;
        r5.w().b(2131370890).g(0);
        this.a.w().b(2131370890).f().setOnClickListener(null);
    }
}
