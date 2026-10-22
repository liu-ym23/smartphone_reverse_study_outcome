package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

    public v(ECWindowCroppedStyleRootPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        uq3.a r3 = (uq3.a) r2;
        ECWindowCroppedStyleRootPresenter r4 = this.a;
        int r0 = ECWindowCroppedStyleRootPresenter.s;
        ((View) r4.r.getValue()).setVisibility(0);
    }
}
