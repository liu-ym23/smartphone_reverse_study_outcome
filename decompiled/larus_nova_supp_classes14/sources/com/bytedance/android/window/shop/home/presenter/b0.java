package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 a;

    public b0(ECWindowCroppedStyleRootPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        uq3.a r3 = (uq3.a) r2;
        ECWindowCroppedStyleRootPresenterV2 r4 = this.a;
        int r0 = ECWindowCroppedStyleRootPresenterV2.r;
        ((View) r4.q.getValue()).setVisibility(0);
    }
}
