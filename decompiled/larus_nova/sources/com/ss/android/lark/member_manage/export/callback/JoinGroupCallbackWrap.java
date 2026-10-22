package com.ss.android.lark.member_manage.export.callback;

import com.larksuite.framework.callback.CancelableCallback;
import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes36.dex */
public class JoinGroupCallbackWrap extends CancelableCallback<IJoinGroupCallback> implements IJoinGroupCallback {
    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onCancelSendApply() {
        T r100 = this.callback;
        if (r100 == 0) goto L6;
        ((IJoinGroupCallback) r100).onCancelSendApply();
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onShowSendApplyDialog() {
        T r100 = this.callback;
        if (r100 == 0) goto L6;
        ((IJoinGroupCallback) r100).onShowSendApplyDialog();
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void sendApplySuccess() {
        T r100 = this.callback;
        if (r100 == 0) goto L6;
        ((IJoinGroupCallback) r100).sendApplySuccess();
        return;
    }

    public JoinGroupCallbackWrap(IJoinGroupCallback r100) {
        super(r100);
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void joinGroupChatSuccess(String r100) {
        T r101 = this.callback;
        if (r101 == 0) goto L6;
        ((IJoinGroupCallback) r101).joinGroupChatSuccess(r100);
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onError(ErrorResult r100) {
        T r101 = this.callback;
        if (r101 == 0) goto L6;
        ((IJoinGroupCallback) r101).onError(r100);
        return;
    }

    @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
    public void onSendApplyError(ErrorResult r100) {
        T r101 = this.callback;
        if (r101 == 0) goto L6;
        ((IJoinGroupCallback) r101).onSendApplyError(r100);
        return;
    }
}
