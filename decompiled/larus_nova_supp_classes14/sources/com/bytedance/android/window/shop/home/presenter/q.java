package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleBackGroundPresenter a;

    public q(ECWindowCroppedStyleBackGroundPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        uq3.a r6 = (uq3.a) r5;
        uq3.a r0 = (uq3.a) this.a.O().getHeaderResponse().getValue();
        Integer r1 = null;
        if (r0 == null) goto L7;
        uq3.o r2 = r0.c;
        if (r2 == null) goto L7;
        ECUrlModel r3 = r2.g;
    L8:
        uq3.a r4 = (uq3.a) this.a.O().getHeaderResponse().getValue();
        if (r4 == null) goto L14;
        uq3.o r7 = r4.c;
        if (r7 == null) goto L14;
        r1 = r7.h;
    L14:
        if (r3 == null) goto L17;
        if (r1 == null) goto L17;
        this.a.b0().addView(ECWindowCroppedStyleBackGroundPresenter.Z(this.a, r3, r1.intValue()), 0);
        return;
    L17:
        this.a.b0().addView(ECWindowCroppedStyleBackGroundPresenter.a0(this.a, r6), 0);
        return;
    L7:
        r3 = null;
        goto L8
    }
}
