package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;

/* JADX INFO: loaded from: classes14.dex */
public final class d1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f197956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PinchBtmBarPresenter f197957b;

    public d1(View r100, PinchBtmBarPresenter r101) {
        this.f197956a = r100;
        this.f197957b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(this.f197956a) == false) goto L5;
        return;
    L5:
        ((FlowPagePinchVM) this.f197957b.f197933e.getValue()).onStableCloseClick("button");
    }
}
