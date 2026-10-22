package com.bytedance.android.shopping.store.moments.module.presenter;

import android.widget.ImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ ECStoreShortVideoPresenterNew a;

    public l(ECStoreShortVideoPresenterNew r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4.booleanValue() == false) goto L7;
        ImageView r0 = this.a.l;
        if (r0 == null) goto L10;
        r0.setBackgroundResource(2131248097);
    L10:
        ECStoreShortVideoPresenterNew r1 = this.a;
        s83.f r2 = r1.g;
        if (r2 == null) goto L14;
        String r5 = r1.y;
        r4.booleanValue();
        r2.h(r5);
        return;
    L14:
        return;
    L7:
        ImageView r6 = this.a.l;
        if (r6 == null) goto L10;
        r6.setBackgroundResource(2131248096);
        goto L10
    }
}
