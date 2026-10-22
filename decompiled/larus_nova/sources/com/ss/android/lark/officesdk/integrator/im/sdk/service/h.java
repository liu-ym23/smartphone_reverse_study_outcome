package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements okb.h {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // okb.h
    public final boolean a() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isGuest;
    }

    @Override // okb.h
    public final String getCurrentTenantId() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.getTenantId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // ikb.j
    public final String getCurrentUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    @Override // ikb.j
    public final void registerUserSwitchListener(qzb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Log.w("ImSdkUserProxy", "unsupported in office sdk");
    }
}
