package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.entity.ECStoreHeaderConfigInfoVO;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeInfoResponse;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ ECShopFollowBasePresenter a;

    public i(ECShopFollowBasePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r15) {
        ECStoreHomeInfoResponse r16 = (ECStoreHomeInfoResponse) r15;
        boolean r1 = true;
        if (r16.getStatusCode() == 0) goto L13;
        String r0 = r16.getStatusMsg();
        if (r0 != null) goto L7;
    L10:
        if (r1 == false) goto L12;
        ECToast r2 = ECToast.INSTANCE;
        ECShopFollowBasePresenter r17 = this.a;
        int r3 = ECShopFollowBasePresenter.J;
        ECToast.showToast$default(r2, r17.u().c(), ag4.a.d(2131896864), null, 4, null);
        return;
    L12:
        ECToast r8 = ECToast.INSTANCE;
        ECShopFollowBasePresenter r4 = this.a;
        int r5 = ECShopFollowBasePresenter.J;
        ECToast.showToast$default(r8, r4.u().c(), r16.getStatusMsg(), null, 4, null);
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L10
    L13:
        ECShopFollowBasePresenter r6 = this.a;
        ECStoreHeaderConfigInfoVO r7 = r16.getConfigInfo();
        StoreFollowGiftConfig r9 = null;
        if (r7 == null) goto L16;
        Integer r10 = r7.getFollowStatus();
    L17:
        if (r10 != null) goto L20;
    L22:
        r1 = false;
    L23:
        ECStoreHeaderConfigInfoVO r18 = r16.getConfigInfo();
        if (r18 == null) goto L26;
        r9 = r18.getFollowGiftConfig();
    L26:
        int r19 = ECShopFollowBasePresenter.J;
        r6.t0(r1, r9);
        return;
    L20:
        if (r10.intValue() != 1) goto L22;
    L16:
        r10 = null;
        goto L17
    }
}
