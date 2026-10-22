package com.bytedance.android.window.shop.holder.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

    public r(WindowHeaderFollowAboutPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        WindowHeaderFollowAboutPresenter r0 = this.a;
        boolean r5 = ((Boolean) r4).booleanValue();
        WindowHeaderFollowAboutPresenter r1 = this.a;
        r0.n0(r5, r1.k, r1.l);
    }
}
