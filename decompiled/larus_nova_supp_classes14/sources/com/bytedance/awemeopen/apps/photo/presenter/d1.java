package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d1 implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ PinchBtmBarPresenter b;

    public d1(View r1, PinchBtmBarPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.a) == false) goto L5;
        return;
    L5:
        ((FlowPagePinchVM) this.b.e.getValue()).onStableCloseClick("button");
    }
}
