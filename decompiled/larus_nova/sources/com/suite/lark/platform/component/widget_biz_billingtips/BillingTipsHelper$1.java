package com.suite.lark.platform.component.widget_biz_billingtips;

import com.byted.cast.common.source.ISendResultListener;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.role.GetAdminPermissionInfoResponse;

/* JADX INFO: loaded from: classes36.dex */
class BillingTipsHelper$1 implements IGetDataCallback<GetAdminPermissionInfoResponse> {
    final /* synthetic */ IGetDataCallback val$callback;

    public BillingTipsHelper$1(IGetDataCallback r100) {
        this.val$callback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        this.val$callback.onError(r100);
    }

    public void onSuccess(GetAdminPermissionInfoResponse r100) {
        if (r100 != null) goto L5;
        onError(new ErrorResult(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL));
        return;
    L5:
        this.val$callback.onSuccess(r100.misSuperAdministrator);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((GetAdminPermissionInfoResponse) r100);
    }
}
