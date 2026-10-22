package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ ECShopLivePreviewPresenter a;

    public f(ECShopLivePreviewPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L19;
        r6.booleanValue();
        View r0 = this.a.r;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("soundBtn");
    L8:
        if (r6.booleanValue() == false) goto L10;
        int r1 = 2131248097;
    L11:
        r0.setBackgroundResource(r1);
        ECShopLivePreviewPresenter r2 = this.a;
        boolean r7 = r6.booleanValue();
        o r3 = r2.n0();
        if (r3 == null) goto L20;
        Pair<String, String>[] r4 = new Pair[3];
        r4[0] = TuplesKt.to("enter_from_merge", "store_page");
        r4[1] = TuplesKt.to("enter_method", "live_cell");
        if (r7 == false) goto L16;
        String r8 = "off";
    L17:
        r4[2] = TuplesKt.to("status_to", r8);
        r3.doEventAction("livesdk_open_audio", r4);
        return;
    L16:
        r8 = "on";
        goto L17
    L20:
        return;
    L10:
        r1 = 2131248096;
        goto L11
    }
}
