package com.ss.cast.source.api;

import com.byted.cast.common.source.ISendResultListener;
import com.byted.cast.common.source.ServiceInfo;
import com.bytedance.android.livesdk.castscreen.pad.controller.LivePadPlayController;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements ISendResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.byted.cast.common.api.ISendResultListener f456560a;

    @Override // com.byted.cast.common.api.ISendResultListener
    public final /* synthetic */ void onFailure(int r100, String r101) {
        com.byted.cast.common.api.ISendResultListener.CC.$default$onFailure(this, r100, r101);
    }

    @Override // com.byted.cast.common.source.ISendResultListener, com.byted.cast.common.api.ISendResultListener
    public final void onSuccess() {
        com.byted.cast.common.api.ISendResultListener r100 = this.f456560a;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    public g(LivePadPlayController.a r100) {
        this.f456560a = r100;
    }

    @Override // com.byted.cast.common.source.ISendResultListener, com.byted.cast.common.api.ISendResultListener
    public final void onReceive(String r100) {
        com.byted.cast.common.api.ISendResultListener r101 = this.f456560a;
        if (r101 == null) goto L6;
        r101.onReceive(r100);
        return;
    }

    @Override // com.byted.cast.common.source.ISendResultListener
    public final void onError(ServiceInfo r100, int r101, String r102) {
        com.byted.cast.common.api.ISendResultListener r103 = this.f456560a;
        if (r103 != null) goto L6;
        return;
    L6:
        if ((r103 instanceof ISendResultListener) == false) goto L8;
        ((ISendResultListener) r103).onError(r100, r101, r102);
        return;
    L8:
        r103.onFailure(r101, r102);
    }
}
