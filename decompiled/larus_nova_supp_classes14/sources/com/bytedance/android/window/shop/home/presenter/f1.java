package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.window.shop.repository.dto.WindowFollowDeleteDTO;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f1<T> implements Consumer {
    public final /* synthetic */ ECWindowInfoPresenterBase a;

    public f1(ECWindowInfoPresenterBase r1) {
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
        ECWindowInfoPresenterBase r5 = this.a;
        int r2 = ECWindowInfoPresenterBase.E;
        UIUtils.displayToast(r5.u().c(), 2131896788);
        return;
    L11:
        ECWindowInfoPresenterBase r6 = this.a;
        int r7 = ECWindowInfoPresenterBase.E;
        UIUtils.displayToast(r6.u().c(), r4.getStatusMsg());
        return;
    L7:
        if (r0.length() != 0) goto L9;
    L12:
        this.a.O().getShopParam().setFollowStatus(0);
        this.a.e0(false);
        ECWindowInfoPresenterBase.a0(this.a);
        UIUtils.displayToast(this.a.u().c(), 2131896744);
    }
}
