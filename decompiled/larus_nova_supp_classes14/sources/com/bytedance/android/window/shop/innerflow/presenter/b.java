package com.bytedance.android.window.shop.innerflow.presenter;

import android.view.View;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ECWindowInnerFlowListPresenter a;

    public b(ECWindowInnerFlowListPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ECWindowInnerFlowListPresenter r4 = this.a;
        WindowStatusView r0 = r4.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        r0.setVisibility(0);
        r0.setECStatus(0);
        r4.D().z2(FooterStatus.LOADING);
        r4.F();
    }
}
