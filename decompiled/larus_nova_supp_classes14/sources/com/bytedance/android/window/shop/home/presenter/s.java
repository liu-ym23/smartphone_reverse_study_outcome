package com.bytedance.android.window.shop.home.presenter;

import com.gyf.barlibrary.ImmersionBar;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenter a;

    public s(ECWindowCroppedStyleRootPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        ECWindowCroppedStyleRootPresenter r4 = this.a;
        int r0 = ECWindowCroppedStyleRootPresenter.s;
        if (r4.O().getShopParam().getStatusBarDarkFont() == false) goto L9;
        ImmersionBar r5 = r4.q;
        if (r5 == null) goto L15;
        ImmersionBar r6 = r5.statusBarDarkFont(true);
        if (r6 == null) goto L16;
        r6.init();
        return;
    L16:
        return;
    L15:
        return;
    L9:
        ImmersionBar r1 = r4.q;
        if (r1 == null) goto L18;
        ImmersionBar r7 = r1.statusBarDarkFont(r4.T());
        if (r7 == null) goto L19;
        r7.init();
        return;
    L19:
        return;
    }
}
