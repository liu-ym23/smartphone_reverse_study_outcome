package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ec.window.base.shop.ECWindowFansClubResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j1<T> implements Consumer {
    public final /* synthetic */ ECWindowInfoPresenterBase a;

    public j1(ECWindowInfoPresenterBase r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        ECWindowFansClubResponse r6 = (ECWindowFansClubResponse) r5;
        ECWindowInfoPresenterBase r0 = this.a;
        Boolean r1 = (Boolean) r0.O().isFollowed().getValue();
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.booleanValue();
    L6:
        com.bytedance.android.ec.window.base.shop.q r4 = r6.getUserData();
        if (r4 == null) goto L9;
        r2 = r4.a();
    L9:
        com.bytedance.android.ec.window.base.shop.q r7 = r6.getUserData();
        if (r7 == null) goto L12;
        Integer r8 = r7.b();
    L13:
        r0.j0(r3, r2, String.valueOf(r8));
        return;
    L12:
        r8 = null;
        goto L13
    L5:
        r3 = false;
        goto L6
    }
}
