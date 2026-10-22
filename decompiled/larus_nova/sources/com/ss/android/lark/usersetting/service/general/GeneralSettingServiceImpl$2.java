package com.ss.android.lark.usersetting.service.general;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.usersetting.base.UserSetting;

/* JADX INFO: loaded from: classes38.dex */
class GeneralSettingServiceImpl$2 implements IGetDataCallback<UserSetting> {
    final /* synthetic */ a this$0;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(UserSetting r100) {
        r100.isAutoAudioToText();
        bac.a r101 = new bac.a(r100.isAutoUpdateWorkStatus());
        IGetDataCallback r102 = this.val$callback;
        if (r102 == null) goto L6;
        r102.onSuccess(r101);
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((UserSetting) r100);
    }

    public GeneralSettingServiceImpl$2(a r100, IGetDataCallback r101) {
        this.val$callback = r101;
    }
}
