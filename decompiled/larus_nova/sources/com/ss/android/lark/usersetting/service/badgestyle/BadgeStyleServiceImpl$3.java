package com.ss.android.lark.usersetting.service.badgestyle;

import aac.g;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;

/* JADX INFO: loaded from: classes38.dex */
class BadgeStyleServiceImpl$3 implements IGetDataCallback<Boolean> {
    final /* synthetic */ a this$0;
    final /* synthetic */ BadgeStyle val$badgeStyle;
    final /* synthetic */ IGetDataCallback val$callback;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        IGetDataCallback r101 = this.val$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(Boolean r100) {
        a r101 = this.this$0;
        r101.getClass();
        UserSetting r102 = g.d.f2395a.f2389a.a();
        if (r102 != null) goto L5;
        BadgeStyle r103 = BadgeStyle.STRONG_REMIND;
    L6:
        a.a(r101, r103, this.val$badgeStyle);
        IGetDataCallback r104 = this.val$callback;
        if (r104 == null) goto L10;
        r104.onSuccess(r100);
        return;
    L10:
        return;
    L5:
        r103 = r102.getBadgeStyle();
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Boolean) r100);
    }

    public BadgeStyleServiceImpl$3(a r100, BadgeStyle r101, IGetDataCallback r102) {
        this.this$0 = r100;
        this.val$badgeStyle = r101;
        this.val$callback = r102;
    }
}
