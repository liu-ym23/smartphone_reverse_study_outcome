package com.bytedance.android.window.shop.holder.presenter;

import com.bytedance.android.window.shop.repository.dto.WindowFollowDeleteDTO;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ WindowHeaderFollowAboutPresenter a;

    public m(WindowHeaderFollowAboutPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        WindowFollowDeleteDTO r4 = (WindowFollowDeleteDTO) r3;
        boolean r1 = false;
        if (r4.getStatusCode() == 0) goto L12;
        String r0 = r4.getStatusMsg();
        if (r0 != null) goto L7;
    L8:
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        WindowHeaderFollowAboutPresenter r5 = this.a;
        int r2 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r5.Y().c(), 2131896788);
        return;
    L11:
        WindowHeaderFollowAboutPresenter r6 = this.a;
        int r7 = WindowHeaderFollowAboutPresenter.A;
        UIUtils.displayToast(r6.Y().c(), r4.getStatusMsg());
        return;
    L7:
        if (r0.length() != 0) goto L9;
    L12:
        this.a.d0().getShopParam().setFollowStatus(0);
        this.a.l0(false);
        WindowHeaderFollowAboutPresenter.i0(this.a);
        UIUtils.displayToast(this.a.Y().c(), 2131896744);
    }
}
