package com.ss.android.lark.member_manage.export.callback;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.ICallback;

/* JADX INFO: loaded from: classes36.dex */
public interface IJoinGroupCallback extends ICallback {
    void joinGroupChatSuccess(String r100);

    void onCancelSendApply();

    void onError(ErrorResult r100);

    void onSendApplyError(ErrorResult r100);

    void onShowSendApplyDialog();

    void sendApplySuccess();
}
