package com.bytedance.android.window.shop.holder.presenter;

import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

    public n(WindowHeaderFollowAboutPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        WindowHeaderFollowAboutPresenter r4 = this.a;
        int r0 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r4.Y().c(), 2131896788);
    }
}
