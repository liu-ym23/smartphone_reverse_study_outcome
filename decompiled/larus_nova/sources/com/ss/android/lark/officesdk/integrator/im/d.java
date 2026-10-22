package com.ss.android.lark.officesdk.integrator.im;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: classes37.dex */
public final class d {
    public d() {
    }

    public final String a() {
        User r100 = ((IUserListService) k.a(LarkContext.getApplication(), IUserListService.class)).getForegroundUser();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.userId;
    }
}
