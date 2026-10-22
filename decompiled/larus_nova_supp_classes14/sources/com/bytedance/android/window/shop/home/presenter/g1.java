package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g1<T> implements Consumer {
    public final /* synthetic */ ECWindowInfoPresenterBase a;

    public g1(ECWindowInfoPresenterBase r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ECWindowInfoPresenterBase r4 = this.a;
        int r0 = ECWindowInfoPresenterBase.E;
        UIUtils.displayToast(r4.u().c(), 2131896788);
    }
}
