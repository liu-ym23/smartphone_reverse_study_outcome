package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s3<T> implements Observer {
    public final /* synthetic */ ECShopTopTabPresenter a;

    public s3(ECShopTopTabPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Float r7 = (Float) r6;
        ECShopTopTabPresenter r8 = this.a;
        int r0 = ECShopTopTabPresenter.C;
        float r1 = r8.Z();
        boolean r2 = r8.w;
        boolean r3 = false;
        if (r1 >= 1.0f) goto L5;
        boolean r4 = true;
    L6:
        if (r2 == r4) goto L11;
        if (r1 >= 1.0f) goto L9;
        r3 = true;
    L9:
        r8.w = r3;
        r8.r0();
        return;
    L11:
        return;
    L5:
        r4 = false;
        goto L6
    }
}
