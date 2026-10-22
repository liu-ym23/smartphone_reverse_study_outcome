package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ ECShopVideoPreviewPresenter a;

    public n(ECShopVideoPreviewPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L13;
        r4.booleanValue();
        View r0 = this.a.p;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L8:
        if (r4.booleanValue() == false) goto L10;
        int r5 = 2131248097;
    L11:
        r0.setBackgroundResource(r5);
        return;
    L10:
        r5 = 2131248096;
        goto L11
    }
}
