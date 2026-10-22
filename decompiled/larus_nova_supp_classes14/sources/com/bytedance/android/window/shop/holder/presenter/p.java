package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public p(WindowHeaderFollowAboutPresenter r1, View r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        WindowHeaderFollowAboutPresenter r4 = this.a;
        int r0 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r4.Y().c(), 2131896788);
        View r5 = this.b;
        if (r5 == null) goto L5;
        r5.setVisibility(0);
    L5:
        View r6 = this.c;
        if (r6 == null) goto L9;
        r6.setVisibility(0);
        return;
    }
}
