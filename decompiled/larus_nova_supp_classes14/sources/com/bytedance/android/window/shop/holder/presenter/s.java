package com.bytedance.android.window.shop.holder.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

    public s(WindowHeaderFollowAboutPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L7;
        WindowHeaderFollowAboutPresenter r3 = this.a;
        int r0 = WindowHeaderFollowAboutPresenter.A;
        LottieAnimationView r4 = r3.k0();
        if (r4 == null) goto L11;
        r4.playAnimation();
        return;
    L11:
        return;
    L7:
        WindowHeaderFollowAboutPresenter r5 = this.a;
        int r1 = WindowHeaderFollowAboutPresenter.A;
        LottieAnimationView r6 = r5.k0();
        if (r6 == null) goto L13;
        r6.setProgress(0.0f);
        return;
    }
}
