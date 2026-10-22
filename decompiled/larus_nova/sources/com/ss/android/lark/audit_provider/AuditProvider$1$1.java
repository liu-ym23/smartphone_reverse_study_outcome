package com.ss.android.lark.audit_provider;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.authorization.PullPermissionResponse;
import gwa.g;

/* JADX INFO: loaded from: classes34.dex */
class AuditProvider$1$1 implements IGetDataCallback<PullPermissionResponse> {
    final /* synthetic */ b.a this$0;
    final /* synthetic */ g.c val$onPullPermissionListener;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
    }

    public void onSuccess(PullPermissionResponse r100) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PullPermissionResponse) r100);
    }

    public AuditProvider$1$1(b.a r100, g.c r101) {
        this.this$0 = r100;
    }
}
