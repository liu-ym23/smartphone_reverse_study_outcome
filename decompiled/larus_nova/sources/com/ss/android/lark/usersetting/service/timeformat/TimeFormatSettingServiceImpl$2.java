package com.ss.android.lark.usersetting.service.timeformat;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.usersetting.base.UserSetting;

/* JADX INFO: loaded from: classes38.dex */
class TimeFormatSettingServiceImpl$2 implements IGetDataCallback<UserSetting> {
    final /* synthetic */ b this$0;
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
        TimeFormatSetting r101 = r100.getTimeFormatSetting();
        b r102 = this.this$0;
        Object r103 = b.f444648b;
        r102.getClass();
        TimeFormatSetting r104 = b.a(r101);
        IGetDataCallback r105 = this.val$callback;
        if (r105 == null) goto L6;
        r105.onSuccess(r104);
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

    public TimeFormatSettingServiceImpl$2(b r100, IGetDataCallback r101) {
        this.this$0 = r100;
        this.val$callback = r101;
    }
}
