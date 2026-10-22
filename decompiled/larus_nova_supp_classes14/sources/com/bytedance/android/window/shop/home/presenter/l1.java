package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l1<T> implements Observer {
    public final /* synthetic */ ECWindowInfoPresenterBase a;

    public l1(ECWindowInfoPresenterBase r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ECWindowInfoPresenterBase r0 = this.a;
        int r1 = ECWindowInfoPresenterBase.E;
        ((a1) r0.y.getValue()).a(((Boolean) r3).booleanValue(), true);
    }
}
